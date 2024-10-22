# Protostream marshaller for Soteria OIDC mechanism

Workaround to use Soteria OIDC mechanism in a `<distributable/>` web app. See https://github.com/eclipse-ee4j/soteria/issues/379

## How to use with Wildfly

Tested with 33.0.2.Final.

Add this project to your WAR's dependencies and change the Infinispan marshaller to protostream:

```shell
/subsystem=distributable-web/infinispan-session-management=default:write-attribute(name=marshaller, value=PROTOSTREAM)
```

## Docs

- https://docs.redhat.com/en/documentation/red_hat_data_grid/8.2/html/cache_encoding_and_marshalling/marshalling_user_types#marshalling_user_types
- https://docs.wildfly.org/33/High_Availability_Guide.html
