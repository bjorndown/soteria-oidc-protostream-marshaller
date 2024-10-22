package org.example.protostream;

import org.glassfish.soteria.mechanisms.openid.domain.IdentityTokenImpl;
import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

@ProtoAdapter(IdentityTokenImpl.class)
public class IdentityTokenImplMarshaller {
	@ProtoFactory
	public static IdentityTokenImpl create(String token) {
		return new IdentityTokenImpl(token, Constants.TOKEN_MIN_VALIDITY);
	}

	@ProtoField(1)
	public String getToken(IdentityTokenImpl token) {
		return token.getToken();
	}
}
