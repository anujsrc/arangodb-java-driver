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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mark Vollmary
 *
 */
public class BaseEdgeDocument extends BaseDocument {

	private static final long serialVersionUID = 6904923804449368783L;

	@JsonProperty("_from")
	private String from;
	@JsonProperty("_to")
	private String to;

	public BaseEdgeDocument() {
		super();
	}

	public BaseEdgeDocument(final String from, final String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public BaseEdgeDocument(final String key, final String from, final String to) {
		super(key);
		this.from = from;
		this.to = to;
	}

	public BaseEdgeDocument(final Map<String, Object> properties) {
		super(properties);
		final Object tmpFrom = properties.remove("_from");
		if (tmpFrom != null) {
			from = tmpFrom.toString();
		}
		final Object tmpTo = properties.remove("_to");
		if (tmpTo != null) {
			to = tmpTo.toString();
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(final String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(final String to) {
		this.to = to;
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
		sb.append(", from=");
		sb.append(from);
		sb.append(", to=");
		sb.append(to);
		sb.append(", properties=");
		sb.append(properties);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BaseEdgeDocument other = (BaseEdgeDocument) obj;
		if (from == null) {
			if (other.from != null) {
				return false;
			}
		} else if (!from.equals(other.from)) {
			return false;
		}
		if (to == null) {
			if (other.to != null) {
				return false;
			}
		} else if (!to.equals(other.to)) {
			return false;
		}
		return true;
	}

}
