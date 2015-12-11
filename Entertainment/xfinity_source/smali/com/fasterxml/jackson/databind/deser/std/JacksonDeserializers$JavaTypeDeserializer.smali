.class public Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers$JavaTypeDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;
.source "JacksonDeserializers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JavaTypeDeserializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer",
        "<",
        "Lcom/fasterxml/jackson/databind/JavaType;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/fasterxml/jackson/databind/JavaType;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/fasterxml/jackson/databind/JavaType;
    .locals 3
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 59
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 61
    .local v0, "curr":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_1

    .line 62
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 63
    .local v1, "str":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_0

    .line 64
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers$JavaTypeDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/JavaType;

    .line 70
    .end local v1    # "str":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 66
    .restart local v1    # "str":Ljava/lang/String;
    :cond_0
    invoke-virtual {p2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->getTypeFactory()Lcom/fasterxml/jackson/databind/type/TypeFactory;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/fasterxml/jackson/databind/type/TypeFactory;->constructFromCanonical(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v2

    goto :goto_0

    .line 69
    .end local v1    # "str":Ljava/lang/String;
    :cond_1
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_EMBEDDED_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_2

    .line 70
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getEmbeddedObject()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/JavaType;

    goto :goto_0

    .line 72
    :cond_2
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers$JavaTypeDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2
.end method

.method public bridge synthetic deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "x1"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers$JavaTypeDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/fasterxml/jackson/databind/JavaType;

    move-result-object v0

    return-object v0
.end method
