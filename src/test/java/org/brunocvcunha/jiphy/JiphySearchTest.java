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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.brunocvcunha.jiphy.model.JiphyGif;
import org.brunocvcunha.jiphy.model.JiphySearchResponse;
import org.brunocvcunha.jiphy.requests.JiphySearchRequest;
import org.junit.Test;

/**
 * Jiphy Search Tests
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class JiphySearchTest {

    private static final String API_KEY = "test-key";
    private static final String SEARCH_RESPONSE = "{"
            + "\"data\":[{\"type\":\"gif\",\"id\":\"cat-id\",\"url\":\"https://giphy.example/cat.gif\","
            + "\"images\":{\"fixed_height\":{\"url\":\"https://giphy.example/cat-height.gif\",\"width\":\"200\",\"height\":\"200\"}}}],"
            + "\"pagination\":{\"total_count\":1,\"count\":1,\"offset\":0},"
            + "\"meta\":{\"status\":200,\"msg\":\"OK\"}"
            + "}";

    @Test
    public void testSearch() {

        JiphySearchRequest request = new JiphySearchRequest("cats");
        request.setApi(Jiphy.builder().apiKey(API_KEY).build());

        assertEquals("/gifs/search?q=cats&api_key=" + API_KEY, request.getUrl());

        JiphySearchResponse cats = request.parseResult(200, SEARCH_RESPONSE);
        assertNotNull(cats);
        assertEquals(200, cats.getMeta().getStatus());
        assertEquals(1, cats.getData().size());

        JiphyGif gif = cats.getData().get(0);
        assertEquals("cat-id", gif.getId());
        assertEquals("https://giphy.example/cat.gif", gif.getUrl());
        assertEquals("https://giphy.example/cat-height.gif", gif.getImages().get("fixed_height").getUrl());

    }

}
