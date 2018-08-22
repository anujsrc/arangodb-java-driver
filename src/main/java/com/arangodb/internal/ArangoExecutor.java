/*
 * DISCLAIMER
 *
 * Copyright 2016 ArangoDB GmbH, Cologne, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright holder is ArangoDB GmbH, Cologne, Germany
 */

package com.arangodb.internal;

import java.lang.reflect.Type;

import com.arangodb.util.ArangoSerialization;
import com.arangodb.velocypack.exception.VPackException;
import com.arangodb.velocystream.Response;

/**
 * @author Mark Vollmary
 *
 */
public abstract class ArangoExecutor {

	public static interface ResponseDeserializer<T> {
		T deserialize(Response response) throws VPackException;
	}

	private final DocumentCache documentCache;
	private final ArangoSerialization serializer;

	protected ArangoExecutor(final ArangoSerialization serializer, final DocumentCache documentCache) {
		super();
		this.documentCache = documentCache;
		this.serializer = serializer;
	}

	public DocumentCache documentCache() {
		return documentCache;
	}

	@SuppressWarnings("unchecked")
	protected <T> T createResult(final Type type, final Response response) {
		return (T) ((type != Void.class && response.getBody() != null) ? serializer.deserialize(response.getBody(), type)
				: null);
	}

}
