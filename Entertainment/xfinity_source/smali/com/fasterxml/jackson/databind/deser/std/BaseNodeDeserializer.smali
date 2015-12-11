.class abstract Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;
.source "JsonNodeDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<N:",
        "Lcom/fasterxml/jackson/databind/JsonNode;",
        ">",
        "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer",
        "<TN;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TN;>;)V"
        }
    .end annotation

    .prologue
    .line 130
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    .local p1, "nodeClass":Ljava/lang/Class;, "Ljava/lang/Class<TN;>;"
    invoke-direct {p0, p1}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;-><init>(Ljava/lang/Class;)V

    .line 131
    return-void
.end method


# virtual methods
.method protected _handleDuplicateField(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ObjectNode;Lcom/fasterxml/jackson/databind/JsonNode;Lcom/fasterxml/jackson/databind/JsonNode;)V
    .locals 0
    .param p1, "fieldName"    # Ljava/lang/String;
    .param p2, "objectNode"    # Lcom/fasterxml/jackson/databind/node/ObjectNode;
    .param p3, "oldValue"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .param p4, "newValue"    # Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 175
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    return-void
.end method

.method protected _reportProblem(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/String;)V
    .locals 2
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "msg"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 153
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    new-instance v0, Lcom/fasterxml/jackson/databind/JsonMappingException;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getTokenLocation()Lcom/fasterxml/jackson/core/JsonLocation;

    move-result-object v1

    invoke-direct {v0, p2, v1}, Lcom/fasterxml/jackson/databind/JsonMappingException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;)V

    throw v0
.end method

.method protected final deserializeAny(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 6
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "nodeFactory"    # Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 249
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    sget-object v3, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer$1;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    invoke-virtual {v4}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 315
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->getValueClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v3

    throw v3

    .line 251
    :pswitch_1
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeObject(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v3

    .line 307
    :goto_0
    return-object v3

    .line 254
    :pswitch_2
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeArray(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    move-result-object v3

    goto :goto_0

    .line 257
    :pswitch_3
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeObject(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v3

    goto :goto_0

    .line 262
    :pswitch_4
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getEmbeddedObject()Ljava/lang/Object;

    move-result-object v1

    .line 263
    .local v1, "ob":Ljava/lang/Object;
    if-nez v1, :cond_0

    .line 264
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v3

    goto :goto_0

    .line 266
    :cond_0
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 267
    .local v2, "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v3, [B

    if-ne v2, v3, :cond_1

    .line 268
    check-cast v1, [B

    .end local v1    # "ob":Ljava/lang/Object;
    check-cast v1, [B

    invoke-virtual {p3, v1}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->binaryNode([B)Lcom/fasterxml/jackson/databind/node/BinaryNode;

    move-result-object v3

    goto :goto_0

    .line 271
    .restart local v1    # "ob":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p3, v1}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->POJONode(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/node/POJONode;

    move-result-object v3

    goto :goto_0

    .line 275
    .end local v1    # "ob":Ljava/lang/Object;
    .end local v2    # "type":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :pswitch_5
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p3, v3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->textNode(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/TextNode;

    move-result-object v3

    goto :goto_0

    .line 279
    :pswitch_6
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getNumberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    move-result-object v0

    .line 280
    .local v0, "nt":Lcom/fasterxml/jackson/core/JsonParser$NumberType;
    sget-object v3, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->BIG_INTEGER:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    if-eq v0, v3, :cond_2

    sget-object v3, Lcom/fasterxml/jackson/databind/DeserializationFeature;->USE_BIG_INTEGER_FOR_INTS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 282
    :cond_2
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getBigIntegerValue()Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {p3, v3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->numberNode(Ljava/math/BigInteger;)Lcom/fasterxml/jackson/databind/node/NumericNode;

    move-result-object v3

    goto :goto_0

    .line 284
    :cond_3
    sget-object v3, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->INT:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    if-ne v0, v3, :cond_4

    .line 285
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    invoke-virtual {p3, v3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->numberNode(I)Lcom/fasterxml/jackson/databind/node/NumericNode;

    move-result-object v3

    goto :goto_0

    .line 287
    :cond_4
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v4

    invoke-virtual {p3, v4, v5}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->numberNode(J)Lcom/fasterxml/jackson/databind/node/NumericNode;

    move-result-object v3

    goto :goto_0

    .line 292
    .end local v0    # "nt":Lcom/fasterxml/jackson/core/JsonParser$NumberType;
    :pswitch_7
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getNumberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    move-result-object v0

    .line 293
    .restart local v0    # "nt":Lcom/fasterxml/jackson/core/JsonParser$NumberType;
    sget-object v3, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->BIG_DECIMAL:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    if-eq v0, v3, :cond_5

    sget-object v3, Lcom/fasterxml/jackson/databind/DeserializationFeature;->USE_BIG_DECIMAL_FOR_FLOATS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 295
    :cond_5
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getDecimalValue()Ljava/math/BigDecimal;

    move-result-object v3

    invoke-virtual {p3, v3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->numberNode(Ljava/math/BigDecimal;)Lcom/fasterxml/jackson/databind/node/NumericNode;

    move-result-object v3

    goto :goto_0

    .line 297
    :cond_6
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getDoubleValue()D

    move-result-wide v4

    invoke-virtual {p3, v4, v5}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->numberNode(D)Lcom/fasterxml/jackson/databind/node/NumericNode;

    move-result-object v3

    goto/16 :goto_0

    .line 301
    .end local v0    # "nt":Lcom/fasterxml/jackson/core/JsonParser$NumberType;
    :pswitch_8
    const/4 v3, 0x1

    invoke-virtual {p3, v3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->booleanNode(Z)Lcom/fasterxml/jackson/databind/node/BooleanNode;

    move-result-object v3

    goto/16 :goto_0

    .line 304
    :pswitch_9
    const/4 v3, 0x0

    invoke-virtual {p3, v3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->booleanNode(Z)Lcom/fasterxml/jackson/databind/node/BooleanNode;

    move-result-object v3

    goto/16 :goto_0

    .line 307
    :pswitch_a
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v3

    goto/16 :goto_0

    .line 249
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_5
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch
.end method

.method protected final deserializeArray(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ArrayNode;
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "nodeFactory"    # Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 220
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->arrayNode()Lcom/fasterxml/jackson/databind/node/ArrayNode;

    move-result-object v0

    .line 222
    .local v0, "node":Lcom/fasterxml/jackson/databind/node/ArrayNode;
    :goto_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 223
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    if-nez v1, :cond_0

    .line 224
    const-string v2, "Unexpected end-of-input when binding data into ArrayNode"

    invoke-virtual {p2, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 226
    :cond_0
    sget-object v2, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer$1;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 239
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeAny(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->add(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    goto :goto_0

    .line 228
    :pswitch_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeObject(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->add(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    goto :goto_0

    .line 231
    :pswitch_1
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeArray(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->add(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    goto :goto_0

    .line 236
    :pswitch_2
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p3, v2}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->textNode(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/TextNode;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/fasterxml/jackson/databind/node/ArrayNode;->add(Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    goto :goto_0

    .line 234
    :pswitch_3
    return-object v0

    .line 226
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected final deserializeObject(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ObjectNode;
    .locals 7
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "nodeFactory"    # Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 187
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    invoke-virtual {p3}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->objectNode()Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v1

    .line 188
    .local v1, "node":Lcom/fasterxml/jackson/databind/node/ObjectNode;
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 189
    .local v3, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v3, v5, :cond_0

    .line 190
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 192
    :cond_0
    :goto_0
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->FIELD_NAME:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v3, v5, :cond_2

    .line 193
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 195
    .local v0, "fieldName":Ljava/lang/String;
    sget-object v5, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer$1;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v6

    invoke-virtual {v6}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 206
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeAny(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    .line 208
    .local v4, "value":Lcom/fasterxml/jackson/databind/JsonNode;
    :goto_1
    invoke-virtual {v1, v0, v4}, Lcom/fasterxml/jackson/databind/node/ObjectNode;->replace(Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    .line 209
    .local v2, "old":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v2, :cond_1

    .line 210
    invoke-virtual {p0, v0, v1, v2, v4}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->_handleDuplicateField(Ljava/lang/String;Lcom/fasterxml/jackson/databind/node/ObjectNode;Lcom/fasterxml/jackson/databind/JsonNode;Lcom/fasterxml/jackson/databind/JsonNode;)V

    .line 192
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    goto :goto_0

    .line 197
    .end local v2    # "old":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    :pswitch_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeObject(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v4

    .line 198
    .restart local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    goto :goto_1

    .line 200
    .end local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    :pswitch_1
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;->deserializeArray(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)Lcom/fasterxml/jackson/databind/node/ArrayNode;

    move-result-object v4

    .line 201
    .restart local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    goto :goto_1

    .line 203
    .end local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    :pswitch_2
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3, v5}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->textNode(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/TextNode;

    move-result-object v4

    .line 204
    .restart local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    goto :goto_1

    .line 213
    .end local v0    # "fieldName":Ljava/lang/String;
    .end local v4    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_2
    return-object v1

    .line 195
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public deserializeWithType(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)Ljava/lang/Object;
    .locals 1
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "typeDeserializer"    # Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 141
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer<TN;>;"
    invoke-virtual {p3, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;->deserializeTypedFromAny(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
