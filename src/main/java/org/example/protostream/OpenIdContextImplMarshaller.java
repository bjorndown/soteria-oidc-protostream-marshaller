package org.example.protostream;

import java.io.StringReader;
import java.lang.reflect.Field;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.glassfish.soteria.mechanisms.openid.domain.AccessTokenImpl;
import org.glassfish.soteria.mechanisms.openid.domain.IdentityTokenImpl;
import org.glassfish.soteria.mechanisms.openid.domain.RefreshTokenImpl;
import org.infinispan.commons.util.ReflectionUtil;
import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;
import org.wildfly.security.soteria.original.OpenIdContextImpl;

@ProtoAdapter(OpenIdContextImpl.class)
public class OpenIdContextImplMarshaller {

	@ProtoFactory
	public static OpenIdContextImpl create(
		String tokenType,
		AccessTokenImpl accessToken,
		IdentityTokenImpl identityToken,
		RefreshTokenImpl refreshToken,
		Long expiresIn,
		String claims
	) {
		OpenIdContextImpl openIdContext = new OpenIdContextImpl();
		openIdContext.setTokenType(tokenType);
		openIdContext.setAccessToken(accessToken);
		openIdContext.setIdentityToken(identityToken);
		openIdContext.setRefreshToken(refreshToken);
		openIdContext.setExpiresIn(expiresIn);
		setClaims(openIdContext, claims);
		return openIdContext;
	}

	private static void setClaims(
		OpenIdContextImpl openIdContext,
		String claims
	) {
		Field field = ReflectionUtil.getField(
			"claims",
			OpenIdContextImpl.class
		);
		ReflectionUtil.setAccessibly(
			openIdContext,
			field,
			parseJsonString(claims)
		);
	}

	private static JsonObject parseJsonString(String claimsString) {
		try (JsonReader reader = Json.createReader(new StringReader(claimsString))) {
			return reader.readObject();
		}
	}

	@ProtoField(1)
	public String getTokenType(OpenIdContextImpl token) {
		return token.getTokenType();
	}

	@ProtoField(2)
	public AccessTokenImpl getAccessToken(OpenIdContextImpl token) {
		return (AccessTokenImpl) token.getAccessToken();
	}

	@ProtoField(3)
	public IdentityTokenImpl getIdentityToken(OpenIdContextImpl token) {
		return (IdentityTokenImpl) token.getIdentityToken();
	}

	@ProtoField(4)
	public RefreshTokenImpl getRefreshToken(OpenIdContextImpl token) {
		return (RefreshTokenImpl) token.getRefreshToken().orElse(null);
	}

	@ProtoField(5)
	public Long getExpiresIn(OpenIdContextImpl token) {
		return token.getExpiresIn().orElse(0L);
	}

	@ProtoField(6)
	public String getClaims(OpenIdContextImpl token) {
		return token.getClaimsJson().toString();
	}
}
