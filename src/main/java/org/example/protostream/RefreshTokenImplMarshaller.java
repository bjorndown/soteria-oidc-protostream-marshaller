package org.example.protostream;

import org.glassfish.soteria.mechanisms.openid.domain.RefreshTokenImpl;
import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

@ProtoAdapter(RefreshTokenImpl.class)
public class RefreshTokenImplMarshaller {
	@ProtoFactory
	public static RefreshTokenImpl create(String token) {
		return new RefreshTokenImpl(token);
	}

	@ProtoField(1)
	public String getToken(RefreshTokenImpl token) {
		return token.getToken();
	}
}
