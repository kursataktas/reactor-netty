/*
 * Copyright (c) 2022 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.netty5.tcp;

import io.micrometer.common.docs.KeyName;
import io.micrometer.tracing.docs.DocumentedSpan;

/**
 * TLS handshake spans.
 *
 * @author Violeta Georgieva
 * @since 1.1.0
 */
enum TlsHandshakeSpans implements DocumentedSpan {

	/**
	 * TLS Handshake Span.
	 */
	TLS_HANDSHAKE_SPAN {
		@Override
		public String getName() {
			return "%s";
		}

		@Override
		public KeyName[] getKeyNames() {
			return TlsHandshakeTimeHighCardinalityTags.values();
		}

		@Override
		public Enum<?> overridesDefaultSpanFrom() {
			return TlsHandshakeObservations.TLS_HANDSHAKE_TIME;
		}
	};

	enum TlsHandshakeTimeHighCardinalityTags implements KeyName {

		/**
		 * Reactor Netty protocol (tcp/http etc.).
		 */
		REACTOR_NETTY_PROTOCOL {
			@Override
			public String asString() {
				return "reactor.netty5.protocol";
			}
		},

		/**
		 * Reactor Netty status.
		 */
		REACTOR_NETTY_STATUS {
			@Override
			public String asString() {
				return "reactor.netty5.status";
			}
		},

		/**
		 * Reactor Netty type (client/server).
		 */
		REACTOR_NETTY_TYPE {
			@Override
			public String asString() {
				return "reactor.netty5.type";
			}
		},

		/**
		 * Remote address.
		 */
		REMOTE_ADDRESS {
			@Override
			public String asString() {
				return "remote.address";
			}
		}
	}
}
