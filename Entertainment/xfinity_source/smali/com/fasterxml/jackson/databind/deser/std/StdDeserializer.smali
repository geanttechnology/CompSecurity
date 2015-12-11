.class public abstract Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;
.super Lcom/fasterxml/jackson/databind/JsonDeserializer;
.source "StdDeserializer.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/fasterxml/jackson/databind/JsonDeserializer",
        "<TT;>;",
        "Ljava/io/Serializable;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field protected final _valueClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 1
    .param p1, "valueType"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 37
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/JsonDeserializer;-><init>()V

    .line 38
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    .line 39
    return-void

    .line 38
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/databind/JavaType;->getRawClass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_0
.end method

.method protected constructor <init>(Ljava/lang/Class;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    .local p1, "vc":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/JsonDeserializer;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    .line 35
    return-void
.end method

.method protected static final parseDouble(Ljava/lang/String;)D
    .locals 2
    .param p0, "numStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    .line 592
    const-string v0, "2.2250738585072012e-308"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 593
    const-wide/16 v0, 0x1

    .line 595
    :goto_0
    return-wide v0

    :cond_0
    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    goto :goto_0
.end method


# virtual methods
.method protected final _parseBoolean(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Boolean;
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 136
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 137
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_TRUE:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_0

    .line 138
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 164
    :goto_0
    return-object v2

    .line 140
    :cond_0
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_FALSE:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_1

    .line 141
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_0

    .line 144
    :cond_1
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_4

    .line 146
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getNumberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    move-result-object v2

    sget-object v3, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->INT:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    if-ne v2, v3, :cond_3

    .line 147
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v2

    if-nez v2, :cond_2

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_0

    :cond_2
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_0

    .line 149
    :cond_3
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_parseBooleanFromNumber(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    goto :goto_0

    .line 151
    :cond_4
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_5

    .line 152
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    goto :goto_0

    .line 155
    :cond_5
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_9

    .line 156
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 157
    .local v1, "text":Ljava/lang/String;
    const-string v2, "true"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 158
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_0

    .line 160
    :cond_6
    const-string v2, "false"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 161
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_0

    .line 163
    :cond_7
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_8

    .line 164
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    goto :goto_0

    .line 166
    :cond_8
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "only \"true\" or \"false\" recognized"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 169
    .end local v1    # "text":Ljava/lang/String;
    :cond_9
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2
.end method

.method protected final _parseBooleanFromNumber(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Z
    .locals 6
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 175
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getNumberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    move-result-object v1

    sget-object v2, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->LONG:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    if-ne v1, v2, :cond_1

    .line 176
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-nez v1, :cond_0

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_0
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 183
    :goto_1
    return v1

    .line 176
    :cond_0
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_0

    .line 179
    :cond_1
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    .line 180
    .local v0, "str":Ljava/lang/String;
    const-string v1, "0.0"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "0"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 181
    :cond_2
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    goto :goto_1

    .line 183
    :cond_3
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    goto :goto_1
.end method

.method protected final _parseBooleanPrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Z
    .locals 6
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 100
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 101
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_TRUE:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_1

    .line 125
    :cond_0
    :goto_0
    return v2

    .line 104
    :cond_1
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_FALSE:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_2

    move v2, v3

    .line 105
    goto :goto_0

    .line 107
    :cond_2
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_3

    move v2, v3

    .line 108
    goto :goto_0

    .line 111
    :cond_3
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_5

    .line 113
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getNumberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    move-result-object v4

    sget-object v5, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->INT:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    if-ne v4, v5, :cond_4

    .line 114
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 116
    :cond_4
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_parseBooleanFromNumber(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Z

    move-result v2

    goto :goto_0

    .line 119
    :cond_5
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v3, :cond_8

    .line 120
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 121
    .local v1, "text":Ljava/lang/String;
    const-string v3, "true"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 124
    const-string v2, "false"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_7

    .line 125
    :cond_6
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    goto :goto_0

    .line 127
    :cond_7
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "only \"true\" or \"false\" recognized"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 130
    .end local v1    # "text":Ljava/lang/String;
    :cond_8
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2
.end method

.method protected _parseByte(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Byte;
    .locals 7
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 189
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 190
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v5, :cond_0

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v5, :cond_1

    .line 191
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getByteValue()B

    move-result v5

    invoke-static {v5}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v5

    .line 213
    :goto_0
    return-object v5

    .line 193
    :cond_1
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v5, :cond_5

    .line 194
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 197
    .local v3, "text":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v1

    .line 198
    .local v1, "len":I
    if-nez v1, :cond_2

    .line 199
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Byte;

    goto :goto_0

    .line 201
    :cond_2
    invoke-static {v3}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 207
    .local v4, "value":I
    const/16 v5, -0x80

    if-lt v4, v5, :cond_3

    const/16 v5, 0xff

    if-le v4, v5, :cond_4

    .line 208
    :cond_3
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v6, "overflow, value can not be represented as 8-bit value"

    invoke-virtual {p2, v3, v5, v6}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    .line 202
    .end local v1    # "len":I
    .end local v4    # "value":I
    :catch_0
    move-exception v0

    .line 203
    .local v0, "iae":Ljava/lang/IllegalArgumentException;
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v6, "not a valid Byte value"

    invoke-virtual {p2, v3, v5, v6}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    .line 210
    .end local v0    # "iae":Ljava/lang/IllegalArgumentException;
    .restart local v1    # "len":I
    .restart local v4    # "value":I
    :cond_4
    int-to-byte v5, v4

    invoke-static {v5}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v5

    goto :goto_0

    .line 212
    .end local v1    # "len":I
    .end local v3    # "text":Ljava/lang/String;
    .end local v4    # "value":I
    :cond_5
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v5, :cond_6

    .line 213
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Byte;

    goto :goto_0

    .line 215
    :cond_6
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v5, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5
.end method

.method protected _parseDate(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/util/Date;
    .locals 6
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 560
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 561
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v3, :cond_0

    .line 562
    new-instance v3, Ljava/util/Date;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v4

    invoke-direct {v3, v4, v5}, Ljava/util/Date;-><init>(J)V

    .line 575
    :goto_0
    return-object v3

    .line 564
    :cond_0
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v3, :cond_1

    .line 565
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Date;

    goto :goto_0

    .line 567
    :cond_1
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v1, v3, :cond_3

    .line 568
    const/4 v2, 0x0

    .line 571
    .local v2, "value":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 572
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_2

    .line 573
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Date;

    goto :goto_0

    .line 575
    :cond_2
    invoke-virtual {p2, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->parseDate(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    goto :goto_0

    .line 576
    :catch_0
    move-exception v0

    .line 577
    .local v0, "iae":Ljava/lang/IllegalArgumentException;
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "not a valid representation (error: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2, v2, v3, v4}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v3

    throw v3

    .line 581
    .end local v0    # "iae":Ljava/lang/IllegalArgumentException;
    .end local v2    # "value":Ljava/lang/String;
    :cond_3
    iget-object v3, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v3, v1}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v3

    throw v3
.end method

.method protected final _parseDouble(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Double;
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 474
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 476
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v2, :cond_0

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_1

    .line 477
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getDoubleValue()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    .line 507
    :goto_0
    return-object v2

    .line 479
    :cond_1
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_6

    .line 480
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 481
    .local v1, "text":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_2

    .line 482
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Double;

    goto :goto_0

    .line 484
    :cond_2
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 502
    :cond_3
    :try_start_0
    invoke-static {v1}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 486
    :sswitch_0
    const-string v2, "Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string v2, "INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 487
    :cond_4
    const-wide/high16 v2, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    goto :goto_0

    .line 491
    :sswitch_1
    const-string v2, "NaN"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 492
    const-wide/high16 v2, 0x7ff8000000000000L    # NaN

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    goto :goto_0

    .line 496
    :sswitch_2
    const-string v2, "-Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "-INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 497
    :cond_5
    const-wide/high16 v2, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    goto :goto_0

    .line 503
    :catch_0
    move-exception v2

    .line 504
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "not a valid Double value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 506
    .end local v1    # "text":Ljava/lang/String;
    :cond_6
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_7

    .line 507
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Double;

    goto :goto_0

    .line 510
    :cond_7
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 484
    :sswitch_data_0
    .sparse-switch
        0x2d -> :sswitch_2
        0x49 -> :sswitch_0
        0x4e -> :sswitch_1
    .end sparse-switch
.end method

.method protected final _parseDoublePrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)D
    .locals 5
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    const-wide/16 v2, 0x0

    .line 517
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 519
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v4, :cond_0

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_2

    .line 520
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getDoubleValue()D

    move-result-wide v2

    .line 551
    :cond_1
    :goto_0
    return-wide v2

    .line 523
    :cond_2
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_6

    .line 524
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 525
    .local v1, "text":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_1

    .line 528
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 546
    :cond_3
    :try_start_0
    invoke-static {v1}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    goto :goto_0

    .line 530
    :sswitch_0
    const-string v2, "Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string v2, "INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 531
    :cond_4
    const-wide/high16 v2, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    goto :goto_0

    .line 535
    :sswitch_1
    const-string v2, "NaN"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 536
    const-wide/high16 v2, 0x7ff8000000000000L    # NaN

    goto :goto_0

    .line 540
    :sswitch_2
    const-string v2, "-Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "-INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 541
    :cond_5
    const-wide/high16 v2, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    goto :goto_0

    .line 547
    :catch_0
    move-exception v2

    .line 548
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "not a valid double value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 550
    .end local v1    # "text":Ljava/lang/String;
    :cond_6
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v4, :cond_1

    .line 554
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 528
    :sswitch_data_0
    .sparse-switch
        0x2d -> :sswitch_2
        0x49 -> :sswitch_0
        0x4e -> :sswitch_1
    .end sparse-switch
.end method

.method protected final _parseFloat(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Float;
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 389
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 391
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v2, :cond_0

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_1

    .line 392
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getFloatValue()F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 423
    :goto_0
    return-object v2

    .line 395
    :cond_1
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_6

    .line 396
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 397
    .local v1, "text":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_2

    .line 398
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    goto :goto_0

    .line 400
    :cond_2
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 418
    :cond_3
    :try_start_0
    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 402
    :sswitch_0
    const-string v2, "Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string v2, "INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 403
    :cond_4
    const/high16 v2, 0x7f800000    # Float.POSITIVE_INFINITY

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    goto :goto_0

    .line 407
    :sswitch_1
    const-string v2, "NaN"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 408
    const/high16 v2, 0x7fc00000    # NaNf

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    goto :goto_0

    .line 412
    :sswitch_2
    const-string v2, "-Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "-INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 413
    :cond_5
    const/high16 v2, -0x800000    # Float.NEGATIVE_INFINITY

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    goto :goto_0

    .line 419
    :catch_0
    move-exception v2

    .line 420
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "not a valid Float value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 422
    .end local v1    # "text":Ljava/lang/String;
    :cond_6
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_7

    .line 423
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    goto :goto_0

    .line 426
    :cond_7
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 400
    :sswitch_data_0
    .sparse-switch
        0x2d -> :sswitch_2
        0x49 -> :sswitch_0
        0x4e -> :sswitch_1
    .end sparse-switch
.end method

.method protected final _parseFloatPrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)F
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    const/4 v2, 0x0

    .line 432
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 434
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v3, :cond_0

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v3, :cond_2

    .line 435
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getFloatValue()F

    move-result v2

    .line 465
    :cond_1
    :goto_0
    return v2

    .line 437
    :cond_2
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v3, :cond_6

    .line 438
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 439
    .local v1, "text":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_1

    .line 442
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 460
    :cond_3
    :try_start_0
    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 444
    :sswitch_0
    const-string v2, "Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string v2, "INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 445
    :cond_4
    const/high16 v2, 0x7f800000    # Float.POSITIVE_INFINITY

    goto :goto_0

    .line 449
    :sswitch_1
    const-string v2, "NaN"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 450
    const/high16 v2, 0x7fc00000    # NaNf

    goto :goto_0

    .line 454
    :sswitch_2
    const-string v2, "-Infinity"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "-INF"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 455
    :cond_5
    const/high16 v2, -0x800000    # Float.NEGATIVE_INFINITY

    goto :goto_0

    .line 461
    :catch_0
    move-exception v2

    .line 462
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "not a valid float value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 464
    .end local v1    # "text":Ljava/lang/String;
    :cond_6
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v3, :cond_1

    .line 468
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 442
    nop

    :sswitch_data_0
    .sparse-switch
        0x2d -> :sswitch_2
        0x49 -> :sswitch_0
        0x4e -> :sswitch_1
    .end sparse-switch
.end method

.method protected final _parseIntPrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)I
    .locals 9
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    const/4 v6, 0x0

    .line 264
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 267
    .local v4, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v7, :cond_0

    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v4, v7, :cond_2

    .line 268
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v6

    .line 294
    :cond_1
    :goto_0
    return v6

    .line 270
    :cond_2
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v4, v7, :cond_6

    .line 274
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 276
    .local v5, "text":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v1

    .line 277
    .local v1, "len":I
    const/16 v7, 0x9

    if-le v1, v7, :cond_5

    .line 278
    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 279
    .local v2, "l":J
    const-wide/32 v6, -0x80000000

    cmp-long v6, v2, v6

    if-ltz v6, :cond_3

    const-wide/32 v6, 0x7fffffff

    cmp-long v6, v2, v6

    if-lez v6, :cond_4

    .line 280
    :cond_3
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Overflow: numeric value ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") out of range of int ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/high16 v8, -0x80000000

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " - "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const v8, 0x7fffffff

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2, v5, v6, v7}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v6

    throw v6
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 289
    .end local v1    # "len":I
    .end local v2    # "l":J
    :catch_0
    move-exception v0

    .line 290
    .local v0, "iae":Ljava/lang/IllegalArgumentException;
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v7, "not a valid int value"

    invoke-virtual {p2, v5, v6, v7}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v6

    throw v6

    .line 283
    .end local v0    # "iae":Ljava/lang/IllegalArgumentException;
    .restart local v1    # "len":I
    .restart local v2    # "l":J
    :cond_4
    long-to-int v6, v2

    goto :goto_0

    .line 285
    .end local v2    # "l":J
    :cond_5
    if-eqz v1, :cond_1

    .line 288
    :try_start_1
    invoke-static {v5}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v6

    goto :goto_0

    .line 293
    .end local v1    # "len":I
    .end local v5    # "text":Ljava/lang/String;
    :cond_6
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v7, :cond_1

    .line 297
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v6, v4}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v6

    throw v6
.end method

.method protected final _parseInteger(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Integer;
    .locals 9
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 303
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 304
    .local v4, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v6, :cond_0

    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v4, v6, :cond_1

    .line 305
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    .line 328
    :goto_0
    return-object v6

    .line 307
    :cond_1
    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v4, v6, :cond_6

    .line 308
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 310
    .local v5, "text":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v1

    .line 311
    .local v1, "len":I
    const/16 v6, 0x9

    if-le v1, v6, :cond_4

    .line 312
    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 313
    .local v2, "l":J
    const-wide/32 v6, -0x80000000

    cmp-long v6, v2, v6

    if-ltz v6, :cond_2

    const-wide/32 v6, 0x7fffffff

    cmp-long v6, v2, v6

    if-lez v6, :cond_3

    .line 314
    :cond_2
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Overflow: numeric value ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") out of range of Integer ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/high16 v8, -0x80000000

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " - "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const v8, 0x7fffffff

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ")"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2, v5, v6, v7}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v6

    throw v6
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 323
    .end local v1    # "len":I
    .end local v2    # "l":J
    :catch_0
    move-exception v0

    .line 324
    .local v0, "iae":Ljava/lang/IllegalArgumentException;
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v7, "not a valid Integer value"

    invoke-virtual {p2, v5, v6, v7}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v6

    throw v6

    .line 317
    .end local v0    # "iae":Ljava/lang/IllegalArgumentException;
    .restart local v1    # "len":I
    .restart local v2    # "l":J
    :cond_3
    long-to-int v6, v2

    :try_start_1
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    goto :goto_0

    .line 319
    .end local v2    # "l":J
    :cond_4
    if-nez v1, :cond_5

    .line 320
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    goto :goto_0

    .line 322
    :cond_5
    invoke-static {v5}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseInt(Ljava/lang/String;)I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v6

    goto/16 :goto_0

    .line 327
    .end local v1    # "len":I
    .end local v5    # "text":Ljava/lang/String;
    :cond_6
    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v4, v6, :cond_7

    .line 328
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    goto/16 :goto_0

    .line 331
    :cond_7
    iget-object v6, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v6, v4}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v6

    throw v6
.end method

.method protected final _parseLong(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Long;
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 337
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 340
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v2, :cond_0

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_1

    .line 341
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 356
    :goto_0
    return-object v2

    .line 344
    :cond_1
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_3

    .line 346
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 347
    .local v1, "text":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_2

    .line 348
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    goto :goto_0

    .line 351
    :cond_2
    :try_start_0
    invoke-static {v1}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 352
    :catch_0
    move-exception v2

    .line 353
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "not a valid Long value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 355
    .end local v1    # "text":Ljava/lang/String;
    :cond_3
    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v2, :cond_4

    .line 356
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    goto :goto_0

    .line 359
    :cond_4
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2
.end method

.method protected final _parseLongPrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)J
    .locals 5
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    const-wide/16 v2, 0x0

    .line 365
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 366
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v4, :cond_0

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_2

    .line 367
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v2

    .line 380
    :cond_1
    :goto_0
    return-wide v2

    .line 369
    :cond_2
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v4, :cond_3

    .line 370
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 371
    .local v1, "text":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-eqz v4, :cond_1

    .line 375
    :try_start_0
    invoke-static {v1}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    goto :goto_0

    .line 376
    :catch_0
    move-exception v2

    .line 377
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "not a valid long value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2

    .line 379
    .end local v1    # "text":Ljava/lang/String;
    :cond_3
    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v4, :cond_1

    .line 382
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v2

    throw v2
.end method

.method protected _parseShort(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Short;
    .locals 7
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 221
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 222
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v5, :cond_0

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v5, :cond_1

    .line 223
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getShortValue()S

    move-result v5

    invoke-static {v5}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v5

    .line 244
    :goto_0
    return-object v5

    .line 225
    :cond_1
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v5, :cond_5

    .line 226
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 229
    .local v3, "text":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v1

    .line 230
    .local v1, "len":I
    if-nez v1, :cond_2

    .line 231
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Short;

    goto :goto_0

    .line 233
    :cond_2
    invoke-static {v3}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 238
    .local v4, "value":I
    const/16 v5, -0x8000

    if-lt v4, v5, :cond_3

    const/16 v5, 0x7fff

    if-le v4, v5, :cond_4

    .line 239
    :cond_3
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v6, "overflow, value can not be represented as 16-bit value"

    invoke-virtual {p2, v3, v5, v6}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    .line 234
    .end local v1    # "len":I
    .end local v4    # "value":I
    :catch_0
    move-exception v0

    .line 235
    .local v0, "iae":Ljava/lang/IllegalArgumentException;
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v6, "not a valid Short value"

    invoke-virtual {p2, v3, v5, v6}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5

    .line 241
    .end local v0    # "iae":Ljava/lang/IllegalArgumentException;
    .restart local v1    # "len":I
    .restart local v4    # "value":I
    :cond_4
    int-to-short v5, v4

    invoke-static {v5}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v5

    goto :goto_0

    .line 243
    .end local v1    # "len":I
    .end local v3    # "text":Ljava/lang/String;
    .end local v4    # "value":I
    :cond_5
    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NULL:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v5, :cond_6

    .line 244
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Short;

    goto :goto_0

    .line 246
    :cond_6
    iget-object v5, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v5, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v5

    throw v5
.end method

.method protected final _parseShortPrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)S
    .locals 4
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 252
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_parseIntPrimitive(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)I

    move-result v0

    .line 254
    .local v0, "value":I
    const/16 v1, -0x8000

    if-lt v0, v1, :cond_0

    const/16 v1, 0x7fff

    if-le v0, v1, :cond_1

    .line 255
    :cond_0
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v3, "overflow, value can not be represented as 16-bit value"

    invoke-virtual {p2, v1, v2, v3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v1

    throw v1

    .line 258
    :cond_1
    int-to-short v1, v0

    return v1
.end method

.method protected final _parseString(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/String;
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
    .line 607
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsString()Ljava/lang/String;

    move-result-object v0

    .line 608
    .local v0, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 609
    return-object v0

    .line 611
    :cond_0
    const-class v1, Ljava/lang/String;

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    invoke-virtual {p2, v1, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v1

    throw v1
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
    .line 86
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p3, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;->deserializeTypedFromAny(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected findDeserializer(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    .locals 1
    .param p1, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p2, "type"    # Lcom/fasterxml/jackson/databind/JavaType;
    .param p3, "property"    # Lcom/fasterxml/jackson/databind/BeanProperty;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/DeserializationContext;",
            "Lcom/fasterxml/jackson/databind/JavaType;",
            "Lcom/fasterxml/jackson/databind/BeanProperty;",
            ")",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 633
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    invoke-virtual {p1, p2, p3}, Lcom/fasterxml/jackson/databind/DeserializationContext;->findContextualValueDeserializer(Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/BeanProperty;)Lcom/fasterxml/jackson/databind/JsonDeserializer;

    move-result-object v0

    return-object v0
.end method

.method public getValueClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 47
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->_valueClass:Ljava/lang/Class;

    return-object v0
.end method

.method public getValueType()Lcom/fasterxml/jackson/databind/JavaType;
    .locals 1

    .prologue
    .line 54
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected handleUnknownProperty(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;Ljava/lang/String;)V
    .locals 1
    .param p1, "jp"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "ctxt"    # Lcom/fasterxml/jackson/databind/DeserializationContext;
    .param p3, "instanceOrClass"    # Ljava/lang/Object;
    .param p4, "propName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 664
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    if-nez p3, :cond_0

    .line 665
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;->getValueClass()Ljava/lang/Class;

    move-result-object p3

    .line 668
    .end local p3    # "instanceOrClass":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p2, p1, p0, p3, p4}, Lcom/fasterxml/jackson/databind/DeserializationContext;->handleUnknownProperty(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/JsonDeserializer;Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 678
    :goto_0
    return-void

    .line 672
    :cond_1
    invoke-virtual {p2, p3, p4, p0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->reportUnknownProperty(Ljava/lang/Object;Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonDeserializer;)V

    .line 677
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_0
.end method

.method protected isDefaultDeserializer(Lcom/fasterxml/jackson/databind/JsonDeserializer;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/databind/JsonDeserializer",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 63
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    .local p1, "deserializer":Lcom/fasterxml/jackson/databind/JsonDeserializer;, "Lcom/fasterxml/jackson/databind/JsonDeserializer<*>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected isDefaultKeyDeserializer(Lcom/fasterxml/jackson/databind/KeyDeserializer;)Z
    .locals 2
    .param p1, "keyDeser"    # Lcom/fasterxml/jackson/databind/KeyDeserializer;

    .prologue
    .line 67
    .local p0, "this":Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;, "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer<TT;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
