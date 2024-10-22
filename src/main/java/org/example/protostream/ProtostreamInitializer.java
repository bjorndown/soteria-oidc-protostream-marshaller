package org.example.protostream;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = { AccessTokenImplMarshaller.class,
		OpenIdContextImplMarshaller.class, IdentityTokenImplMarshaller.class, RefreshTokenImplMarshaller.class },
		schemaPackageName = "org.example.protostream")
public interface ProtostreamInitializer extends SerializationContextInitializer {
}
