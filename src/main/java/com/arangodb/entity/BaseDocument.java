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

package com.arangodb.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mark Vollmary
 *
 */
public class BaseDocument implements Serializable {

	private static final long serialVersionUID = -1824742667228719116L;

	@JsonProperty("_id")
	protected String id;
	@JsonProperty("_key")
	protected String key;
	@JsonProperty("_rev")
	protected String revision;
	protected Map<String, Object> properties;

	public BaseDocument() {
		super();
		properties = new HashMap<>();
	}

	public BaseDocument(final String key) {
		this();
		this.key = key;
	}

	public BaseDocument(final Map<String, Object> properties) {
		this();
		final Object tmpId = properties.remove("_id");
		if (tmpId != null) {
			id = tmpId.toString();
		}
		final Object tmpKey = properties.remove("_key");
		if (tmpKey != null) {
			key = tmpKey.toString();
		}
		final Object tmpRev = properties.remove("_rev");
		if (tmpRev != null) {
			revision = tmpRev.toString();
		}
		this.properties = properties;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(final String revision) {
		this.revision = revision;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(final Map<String, Object> properties) {
		this.properties = properties;
	}

	public void put(final String key, final Object value) {
		properties.put(key, value);
	}

	@Deprecated
	public void addAttribute(final String key, final Object value) {
		put(key, value);
	}

	@Deprecated
	public void updateAttribute(final String key, final Object value) {
		put(key, value);
	}

	public Object get(final String key) {
		return properties.get(key);
	}

	@Deprecated
	public Object getAttribute(final String key) {
		return get(key);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("BaseDocument [documentRevision=");
		sb.append(revision);
		sb.append(", documentHandle=");
		sb.append(id);
		sb.append(", documentKey=");
		sb.append(key);
		sb.append(", properties=");
		sb.append(properties);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((revision == null) ? 0 : revision.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BaseDocument other = (BaseDocument) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		if (properties == null) {
			if (other.properties != null) {
				return false;
			}
		} else if (!properties.equals(other.properties)) {
			return false;
		}
		if (revision == null) {
			if (other.revision != null) {
				return false;
			}
		} else if (!revision.equals(other.revision)) {
			return false;
		}
		return true;
	}

}
