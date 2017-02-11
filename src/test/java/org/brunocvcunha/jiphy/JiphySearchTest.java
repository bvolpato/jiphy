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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
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

    @Test
    public void testSearch() throws ClientProtocolException, IOException {

        Jiphy jiphy = Jiphy.builder().build();
        JiphySearchResponse cats = jiphy.sendRequest(new JiphySearchRequest("cats"));
        assertNotNull(cats);
        System.out.println(cats);

        assertTrue(cats.getData().size() > 0);

    }

}