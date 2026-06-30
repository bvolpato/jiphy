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

import java.io.File;

import org.brunocvcunha.jiphy.model.JiphyUploadResult;
import org.brunocvcunha.jiphy.requests.JiphyUploadRequest;
import org.junit.Test;

/**
 * Jiphy Upload Tests
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
public class JiphyUploadTest {

    private static final String API_KEY = "test-key";
    private static final String UPLOAD_RESPONSE = "{"
            + "\"data\":{\"id\":\"uploaded-id\"},"
            + "\"meta\":{\"status\":200,\"msg\":\"OK\"}"
            + "}";

    @Test
    public void testUpload() {
        JiphyUploadRequest request = new JiphyUploadRequest(new File("test.gif"));
        request.setApi(Jiphy.builder().apiKey(API_KEY).build());

        assertEquals("POST", request.getMethod());
        assertEquals("/gifs?api_key=" + API_KEY, request.getUrl());

        JiphyUploadResult upload = request.parseResult(200, UPLOAD_RESPONSE);
        assertNotNull(upload);
        assertEquals(200, upload.getMeta().getStatus());
        assertEquals("uploaded-id", upload.getData().getId());

    }

}
