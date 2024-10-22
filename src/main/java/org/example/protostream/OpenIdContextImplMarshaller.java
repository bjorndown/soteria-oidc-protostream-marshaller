package org.example.protostream;

import org.glassfish.soteria.mechanisms.openid.domain.AccessTokenImpl;
import org.glassfish.soteria.mechanisms.openid.domain.IdentityTokenImpl;
import org.glassfish.soteria.mechanisms.openid.domain.RefreshTokenImpl;
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
			Long expiresIn
	) {
		OpenIdContextImpl openIdContext = new OpenIdContextImpl();
		openIdContext.setTokenType(tokenType);
		openIdContext.setAccessToken(accessToken);
		openIdContext.setIdentityToken(identityToken);
		openIdContext.setRefreshToken(refreshToken);
		openIdContext.setExpiresIn(expiresIn);
		return openIdContext;
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
}
