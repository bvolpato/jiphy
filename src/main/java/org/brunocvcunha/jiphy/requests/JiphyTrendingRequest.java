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

import org.brunocvcunha.jiphy.model.JiphySearchResponse;
import org.brunocvcunha.jiphy.requests.base.JiphyGetRequest;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * Trending GIFs Request
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@RequiredArgsConstructor
public class JiphyTrendingRequest extends JiphyGetRequest<JiphySearchResponse> {

    @Override
    public String getUrl() {
        return "/gifs/trending?api_key=" + api.getApiKey();
    }

    @Override
    @SneakyThrows
    public JiphySearchResponse parseResult(int statusCode, String content) {
        return parseJson(content, JiphySearchResponse.class);
    }

}
