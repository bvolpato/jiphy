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

import org.brunocvcunha.jiphy.model.JiphySearchResponse;
import org.brunocvcunha.jiphy.requests.JiphyTranslateRequest;
import org.junit.Test;

/**
 * Jiphy Translate Tests
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class JiphyTranslateTest {

    private static final String API_KEY = "test-key";
    private static final String TRANSLATE_RESPONSE = "{"
            + "\"data\":{\"type\":\"gif\",\"id\":\"superman-id\",\"url\":\"https://giphy.example/superman.gif\"},"
            + "\"meta\":{\"status\":200,\"msg\":\"OK\"}"
            + "}";

    @Test
    public void testTranslate() {
        JiphyTranslateRequest request = new JiphyTranslateRequest("superman");
        request.setApi(Jiphy.builder().apiKey(API_KEY).build());

        assertEquals("/gifs/translate?s=superman&api_key=" + API_KEY, request.getUrl());

        JiphySearchResponse translate = request.parseResult(200, TRANSLATE_RESPONSE);
        assertNotNull(translate);
        assertEquals(200, translate.getMeta().getStatus());
        assertEquals(1, translate.getData().size());
        assertEquals("superman-id", translate.getData().get(0).getId());
    }

}
