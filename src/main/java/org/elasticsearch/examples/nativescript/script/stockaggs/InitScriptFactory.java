/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elasticsearch.examples.nativescript.script.stockaggs;

import org.elasticsearch.common.Nullable;
import org.elasticsearch.script.AbstractExecutableScript;
import org.elasticsearch.script.ExecutableScript;
import org.elasticsearch.script.NativeScriptFactory;

import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Init script from https://www.elastic.co/guide/en/elasticsearch/reference/current/search-aggregations-metrics-scripted-metric-aggregation.html
 *
 * _agg['transactions'] = []
 */
public class InitScriptFactory implements NativeScriptFactory {

    public static final String TRANSACTIONS_FIELD = "transactions";

    @Override
    public ExecutableScript newScript(final @Nullable Map<String, Object> params) {
        return new AbstractExecutableScript() {
            @Override
            public Object run() {
                ((Map<String, Object>)params.get("_agg")).put(TRANSACTIONS_FIELD, newArrayList());
                return null;
            }
        };
    }

    @Override
    public boolean needsScores() {
        return false;
    }
}
