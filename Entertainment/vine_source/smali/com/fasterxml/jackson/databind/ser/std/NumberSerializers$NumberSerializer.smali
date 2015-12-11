.class public final Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;
.super Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer;
.source "NumberSerializers.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JacksonStdImpl;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "NumberSerializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer",
        "<",
        "Ljava/lang/Number;",
        ">;"
    }
.end annotation


# static fields
.field public static final instance:Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 265
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;->instance:Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 267
    const-class v0, Ljava/lang/Number;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/databind/JsonMappingException;
        }
    .end annotation

    .prologue
    .line 321
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectNumberFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonNumberFormatVisitor;

    move-result-object v0

    .line 322
    if-eqz v0, :cond_0

    .line 323
    sget-object v1, Lcom/fasterxml/jackson/core/JsonParser$NumberType;->BIG_DECIMAL:Lcom/fasterxml/jackson/core/JsonParser$NumberType;

    invoke-interface {v0, v1}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonNumberFormatVisitor;->numberType(Lcom/fasterxml/jackson/core/JsonParser$NumberType;)V

    .line 325
    :cond_0
    return-void
.end method

.method public getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 2

    .prologue
    .line 312
    const-string v0, "number"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;->createSchemaNode(Ljava/lang/String;Z)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v0

    return-object v0
.end method

.method public serialize(Ljava/lang/Number;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 274
    instance-of v0, p1, Ljava/math/BigDecimal;

    if-eqz v0, :cond_0

    .line 286
    check-cast p1, Ljava/math/BigDecimal;

    invoke-virtual {p2, p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(Ljava/math/BigDecimal;)V

    .line 307
    :goto_0
    return-void

    .line 287
    :cond_0
    instance-of v0, p1, Ljava/math/BigInteger;

    if-eqz v0, :cond_1

    .line 288
    check-cast p1, Ljava/math/BigInteger;

    invoke-virtual {p2, p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(Ljava/math/BigInteger;)V

    goto :goto_0

    .line 293
    :cond_1
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_2

    .line 294
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(I)V

    goto :goto_0

    .line 295
    :cond_2
    instance-of v0, p1, Ljava/lang/Long;

    if-eqz v0, :cond_3

    .line 296
    invoke-virtual {p1}, Ljava/lang/Number;->longValue()J

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(J)V

    goto :goto_0

    .line 297
    :cond_3
    instance-of v0, p1, Ljava/lang/Double;

    if-eqz v0, :cond_4

    .line 298
    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(D)V

    goto :goto_0

    .line 299
    :cond_4
    instance-of v0, p1, Ljava/lang/Float;

    if-eqz v0, :cond_5

    .line 300
    invoke-virtual {p1}, Ljava/lang/Number;->floatValue()F

    move-result v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(F)V

    goto :goto_0

    .line 301
    :cond_5
    instance-of v0, p1, Ljava/lang/Byte;

    if-nez v0, :cond_6

    instance-of v0, p1, Ljava/lang/Short;

    if-eqz v0, :cond_7

    .line 302
    :cond_6
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(I)V

    goto :goto_0

    .line 305
    :cond_7
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 261
    check-cast p1, Ljava/lang/Number;

    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;->serialize(Ljava/lang/Number;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    return-void
.end method
