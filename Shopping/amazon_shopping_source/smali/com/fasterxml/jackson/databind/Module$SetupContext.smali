.class public interface abstract Lcom/fasterxml/jackson/databind/Module$SetupContext;
.super Ljava/lang/Object;
.source "Module.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/Module;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "SetupContext"
.end annotation


# virtual methods
.method public abstract addAbstractTypeResolver(Lcom/fasterxml/jackson/databind/AbstractTypeResolver;)V
.end method

.method public abstract addDeserializers(Lcom/fasterxml/jackson/databind/deser/Deserializers;)V
.end method

.method public abstract addKeyDeserializers(Lcom/fasterxml/jackson/databind/deser/KeyDeserializers;)V
.end method

.method public abstract addKeySerializers(Lcom/fasterxml/jackson/databind/ser/Serializers;)V
.end method

.method public abstract addSerializers(Lcom/fasterxml/jackson/databind/ser/Serializers;)V
.end method

.method public abstract addValueInstantiators(Lcom/fasterxml/jackson/databind/deser/ValueInstantiators;)V
.end method

.method public varargs abstract registerSubtypes([Lcom/fasterxml/jackson/databind/jsontype/NamedType;)V
.end method

.method public abstract setMixInAnnotations(Ljava/lang/Class;Ljava/lang/Class;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation
.end method
