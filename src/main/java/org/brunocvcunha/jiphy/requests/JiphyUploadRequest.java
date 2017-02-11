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
package org.brunocvcunha.jiphy.requests;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.brunocvcunha.jiphy.JiphyConstants;
import org.brunocvcunha.jiphy.model.JiphyUploadResult;
import org.brunocvcunha.jiphy.requests.base.JiphyRequest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Upload GIF request
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Log4j
@RequiredArgsConstructor
public class JiphyUploadRequest extends JiphyRequest<JiphyUploadResult> {

    @NonNull
    private File file;

    @Override
    public String getUrl() {
        return "/gifs?api_key=" + api.getApiKey();
    }

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public JiphyUploadResult execute() throws ClientProtocolException, IOException {

        HttpPost post = createHttpRequest();
        post.setEntity(createMultipartEntity());

        try (CloseableHttpResponse response = api.getClient().execute(post)) {
            api.setLastResponse(response);

            int resultCode = response.getStatusLine().getStatusCode();
            String content = EntityUtils.toString(response.getEntity());

            log.info("GIF Upload result: " + resultCode + ", " + content);

            post.releaseConnection();

            return parseResult(resultCode, content);
        }
    }

    /**
     * Creates required multipart entity with the image binary
     * 
     * @return HttpEntity to send on the post
     * @throws ClientProtocolException
     * @throws IOException
     */
    protected HttpEntity createMultipartEntity() throws ClientProtocolException, IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", file);

        HttpEntity entity = builder.build();
        return entity;
    }

    /**
     * Creates the Post Request
     * 
     * @return Request
     */
    protected HttpPost createHttpRequest() {
        String url = "http://upload.giphy.com/v1" + getUrl();
        log.info("URL Upload: " + url);

        HttpPost post = new HttpPost(url);
        return post;
    }

    @Override
    public JiphyUploadResult parseResult(int resultCode, String content) {
        return parseJson(content, JiphyUploadResult.class);
    }

}
