.class public Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers$TokenBufferDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;
.source "JacksonDeserializers.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TokenBufferDeserializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer",
        "<",
        "Lcom/fasterxml/jackson/databind/util/TokenBuffer;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 129
    const-class v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/fasterxml/jackson/databind/util/TokenBuffer;
    .locals 2
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 135
    new-instance v0, Lcom/fasterxml/jackson/databind/util/TokenBuffer;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCodec()Lcom/fasterxml/jackson/core/ObjectCodec;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/util/TokenBuffer;-><init>(Lcom/fasterxml/jackson/core/ObjectCodec;)V

    .line 137
    .local v0, "tb":Lcom/fasterxml/jackson/databind/util/TokenBuffer;
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/util/TokenBuffer;->copyCurrentStructure(Lcom/fasterxml/jackson/core/JsonParser;)V

    .line 138
    return-object v0
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
    .line 125
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/JacksonDeserializers$TokenBufferDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lcom/fasterxml/jackson/databind/util/TokenBuffer;

    move-result-object v0

    return-object v0
.end method
