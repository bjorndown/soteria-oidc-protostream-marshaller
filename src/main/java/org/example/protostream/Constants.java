package org.example.protostream;

import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;

public interface Constants {
	/**
	 * should be set to same value as
	 * {@link OpenIdAuthenticationMechanismDefinition#tokenMinValidity()}
	 */
	long TOKEN_MIN_VALIDITY = 10_000;
}
