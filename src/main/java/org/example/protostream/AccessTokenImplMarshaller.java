package org.example.protostream;

import org.glassfish.soteria.mechanisms.openid.domain.AccessTokenImpl;
import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

@ProtoAdapter(AccessTokenImpl.class)
public class AccessTokenImplMarshaller {
	@ProtoFactory
	public static AccessTokenImpl create(String tokenType, String token, Long expiresIn, String scopeValue) {
		return new AccessTokenImpl(tokenType, token, expiresIn, scopeValue, Constants.TOKEN_MIN_VALIDITY);
	}

	@ProtoField(1)
	public String getTokenType(AccessTokenImpl token) {
		return token.getType().toString();
	}

	@ProtoField(2)
	public String getToken(AccessTokenImpl token) {
		return token.getToken();
	}

	@ProtoField(3)
	public Long getExpiresIn(AccessTokenImpl token) {
		return token.getExpirationTime();
	}

	@ProtoField(4)
	public String getScopeValue(AccessTokenImpl token) {
		return token.getScope().toString();
	}
}
