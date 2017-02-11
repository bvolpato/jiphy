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
package org.brunocvcunha.jiphy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

import lombok.Data;

/**
 * Search Result
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JiphyGif {
    private String type;
    private String id;
    private String slug;
    private String url;
    private String bitly_gif_url;
    private String bitly_url;
    private String embed_url;
    private String username;
    private String source;
    private String rating;
    private String caption;
    private String content_url;
    private String source_tld;
    private String source_post_url;
    private String import_datetime;
    private String trending_datetime;
    private Map<String, JiphyImageDetails> images;

}