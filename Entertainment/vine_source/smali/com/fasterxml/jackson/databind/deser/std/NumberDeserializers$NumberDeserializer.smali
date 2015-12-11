.class public final Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;
.super Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;
.source "NumberDeserializers.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "NumberDeserializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer",
        "<",
        "Ljava/lang/Number;",
        ">;"
    }
.end annotation


# static fields
.field public static final instance:Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 426
    new-instance v0, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->instance:Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 428
    const-class v0, Ljava/lang/Number;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/deser/std/StdScalarDeserializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Number;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 434
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 435
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_INT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_1

    .line 436
    sget-object v0, Lcom/fasterxml/jackson/databind/DeserializationFeature;->USE_BIG_INTEGER_FOR_INTS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 437
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getBigIntegerValue()Ljava/math/BigInteger;

    move-result-object v0

    .line 484
    :goto_0
    return-object v0

    .line 439
    :cond_0
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getNumberValue()Ljava/lang/Number;

    move-result-object v0

    goto :goto_0

    .line 440
    :cond_1
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_NUMBER_FLOAT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_3

    .line 444
    sget-object v0, Lcom/fasterxml/jackson/databind/DeserializationFeature;->USE_BIG_DECIMAL_FOR_FLOATS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 445
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getDecimalValue()Ljava/math/BigDecimal;

    move-result-object v0

    goto :goto_0

    .line 447
    :cond_2
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getDoubleValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_0

    .line 453
    :cond_3
    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_d

    .line 454
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 455
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_4

    .line 456
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->getEmptyValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    goto :goto_0

    .line 458
    :cond_4
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->_hasTextualNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 459
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->getNullValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    goto :goto_0

    .line 461
    :cond_5
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->_isPosInf(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 462
    const-wide/high16 v0, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_0

    .line 464
    :cond_6
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->_isNegInf(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 465
    const-wide/high16 v0, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_0

    .line 467
    :cond_7
    invoke-virtual {p0, v1}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->_isNaN(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 468
    const-wide/high16 v0, 0x7ff8000000000000L    # NaN

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    goto :goto_0

    .line 471
    :cond_8
    const/16 v0, 0x2e

    :try_start_0
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-ltz v0, :cond_a

    .line 472
    sget-object v0, Lcom/fasterxml/jackson/databind/DeserializationFeature;->USE_BIG_DECIMAL_FOR_FLOATS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 473
    new-instance v0, Ljava/math/BigDecimal;

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 485
    :catch_0
    move-exception v0

    .line 486
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->_valueClass:Ljava/lang/Class;

    const-string v2, "not a valid number"

    invoke-virtual {p2, v1, v0, v2}, Lcom/fasterxml/jackson/databind/DeserializationContext;->weirdStringException(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v0

    throw v0

    .line 475
    :cond_9
    :try_start_1
    new-instance v0, Ljava/lang/Double;

    invoke-direct {v0, v1}, Ljava/lang/Double;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 477
    :cond_a
    sget-object v0, Lcom/fasterxml/jackson/databind/DeserializationFeature;->USE_BIG_INTEGER_FOR_INTS:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->isEnabled(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 478
    new-instance v0, Ljava/math/BigInteger;

    invoke-direct {v0, v1}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 480
    :cond_b
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 481
    const-wide/32 v4, 0x7fffffff

    cmp-long v0, v2, v4

    if-gtz v0, :cond_c

    const-wide/32 v4, -0x80000000

    cmp-long v0, v2, v4

    if-ltz v0, :cond_c

    .line 482
    long-to-int v0, v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto/16 :goto_0

    .line 484
    :cond_c
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    goto/16 :goto_0

    .line 490
    :cond_d
    iget-object v1, p0, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->_valueClass:Ljava/lang/Class;

    invoke-virtual {p2, v1, v0}, Lcom/fasterxml/jackson/databind/DeserializationContext;->mappingException(Ljava/lang/Class;Lcom/fasterxml/jackson/core/JsonToken;)Lcom/fasterxml/jackson/databind/JsonMappingException;

    move-result-object v0

    throw v0
.end method

.method public bridge synthetic deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 421
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Number;

    move-result-object v0

    return-object v0
.end method

.method public deserializeWithType(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 505
    sget-object v0, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$1;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 512
    invoke-virtual {p3, p1, p2}, Lcom/fasterxml/jackson/databind/jsontype/TypeDeserializer;->deserializeTypedFromScalar(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    .line 510
    :pswitch_0
    invoke-virtual {p0, p1, p2}, Lcom/fasterxml/jackson/databind/deser/std/NumberDeserializers$NumberDeserializer;->deserialize(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Number;

    move-result-object v0

    goto :goto_0

    .line 505
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
