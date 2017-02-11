/**
 * Copyright (C) 2017 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.jiphy;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.brunocvcunha.jiphy.requests.base.JiphyRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * 
 * Jiphy API
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Builder
@Log4j
public class Jiphy {

    @Getter
    @Setter
    private String apiKey;

    @Getter
    @Setter
    protected HttpResponse lastResponse;

    @Getter
    protected CloseableHttpClient client;

    /**
     * Send request to endpoint
     * 
     * @param request
     *            Request object
     * @return success flag
     * @throws IOException
     * @throws ClientProtocolException
     */
    public <T> T sendRequest(JiphyRequest<T> request) throws ClientProtocolException, IOException {

        log.info("Sending request: " + request.getClass().getName());

        request.setApi(this);
        T response = request.execute();

        log.info("Result for " + request.getClass().getName() + ": " + response);

        return response;
    }
    
    
    /**
     * Builder
     */
    public static class JiphyBuilder {
        private String apiKey = JiphyConstants.API_KEY_BETA;
        private CloseableHttpClient client = HttpClients.createDefault();
      }

}