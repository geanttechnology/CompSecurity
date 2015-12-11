.class final Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$CharDeser;
.super Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$Base;
.source "PrimitiveArrayDeserializers.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "CharDeser"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$Base",
        "<[C>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 168
    const-class v0, [C

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$Base;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
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
    .line 162
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$CharDeser;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)[C

    move-result-object v0

    return-object v0
.end method

.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)[C
    .locals 11
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    .line 178
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v7

    .line 179
    .local v7, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v8, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v7, v8, :cond_0

    .line 181
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getTextCharacters()[C

    move-result-object v0

    .line 182
    .local v0, "buffer":[C
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getTextOffset()I

    move-result v3

    .line 183
    .local v3, "offset":I
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getTextLength()I

    move-result v1

    .line 185
    .local v1, "len":I
    new-array v4, v1, [C

    .line 186
    .local v4, "result":[C
    invoke-static {v0, v3, v4, v10, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 216
    .end local v0    # "buffer":[C
    .end local v1    # "len":I
    .end local v3    # "offset":I
    .end local v4    # "result":[C
    :goto_0
    return-object v4

    .line 189
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->isExpectedStartArrayToken()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 191
    new-instance v5, Ljava/lang/StringBuilder;

    const/16 v8, 0x40

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 192
    .local v5, "sb":Ljava/lang/StringBuilder;
    :goto_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v7

    sget-object v8, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v7, v8, :cond_3

    .line 193
    sget-object v8, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v7, v8, :cond_1

    .line 194
    sget-object v8, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-virtual {p2, v8}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v8

    throw v8

    .line 196
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    .line 197
    .local v6, "str":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v8

    const/4 v9, 0x1

    if-eq v8, v9, :cond_2

    .line 198
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Can not convert a JSON String of length "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " into a char element of char array"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {p1, v8}, Lcom/fasterxml/jackson/databind/JsonMappingException;->from(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v8

    throw v8

    .line 200
    :cond_2
    invoke-virtual {v6, v10}, Ljava/lang/String;->charAt(I)C

    move-result v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 202
    .end local v6    # "str":Ljava/lang/String;
    :cond_3
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toCharArray()[C

    move-result-object v4

    goto :goto_0

    .line 205
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    :cond_4
    sget-object v8, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_EMBEDDED_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v7, v8, :cond_8

    .line 206
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getEmbeddedObject()Ljava/lang/Object;

    move-result-object v2

    .line 207
    .local v2, "ob":Ljava/lang/Object;
    if-nez v2, :cond_5

    const/4 v4, 0x0

    goto :goto_0

    .line 208
    :cond_5
    instance-of v8, v2, [C

    if-eqz v8, :cond_6

    .line 209
    check-cast v2, [C

    .end local v2    # "ob":Ljava/lang/Object;
    check-cast v2, [C

    move-object v4, v2

    goto :goto_0

    .line 211
    .restart local v2    # "ob":Ljava/lang/Object;
    :cond_6
    instance-of v8, v2, Ljava/lang/String;

    if-eqz v8, :cond_7

    .line 212
    check-cast v2, Ljava/lang/String;

    .end local v2    # "ob":Ljava/lang/Object;
    invoke-virtual {v2}, Ljava/lang/String;->toCharArray()[C

    move-result-object v4

    goto :goto_0

    .line 215
    .restart local v2    # "ob":Ljava/lang/Object;
    :cond_7
    instance-of v8, v2, [B

    if-eqz v8, :cond_8

    .line 216
    invoke-static {}, Lcom/fasterxml/jackson/core/Base64Variants;->getDefaultVariant()Lcom/fasterxml/jackson/core/Base64Variant;

    move-result-object v8

    check-cast v2, [B

    .end local v2    # "ob":Ljava/lang/Object;
    check-cast v2, [B

    invoke-virtual {v8, v2, v10}, Lcom/fasterxml/jackson/core/Base64Variant;->encode([BZ)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toCharArray()[C

    move-result-object v4

    goto/16 :goto_0

    .line 220
    :cond_8
    iget-object v8, p0, Lcom/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$CharDeser;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v8}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v8

    throw v8
.end method
