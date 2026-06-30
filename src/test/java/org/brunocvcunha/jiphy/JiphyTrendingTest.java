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
import org.brunocvcunha.jiphy.requests.JiphyTrendingRequest;
import org.junit.Test;

/**
 * Jiphy Trend Tests
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class JiphyTrendingTest {

    private static final String API_KEY = "test-key";
    private static final String TRENDING_RESPONSE = "{"
            + "\"data\":[{\"type\":\"gif\",\"id\":\"trend-id\",\"url\":\"https://giphy.example/trend.gif\"}],"
            + "\"pagination\":{\"total_count\":1,\"count\":1,\"offset\":0},"
            + "\"meta\":{\"status\":200,\"msg\":\"OK\"}"
            + "}";

    @Test
    public void testTrending() {
        JiphyTrendingRequest request = new JiphyTrendingRequest();
        request.setApi(Jiphy.builder().apiKey(API_KEY).build());

        assertEquals("/gifs/trending?api_key=" + API_KEY, request.getUrl());

        JiphySearchResponse trend = request.parseResult(200, TRENDING_RESPONSE);
        assertNotNull(trend);
        assertEquals(200, trend.getMeta().getStatus());
        assertEquals(1, trend.getData().size());
        assertEquals("trend-id", trend.getData().get(0).getId());
    }

}
