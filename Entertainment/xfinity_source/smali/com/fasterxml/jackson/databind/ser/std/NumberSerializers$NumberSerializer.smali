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
    .line 219
    new-instance v0, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;-><init>()V

    sput-object v0, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;->instance:Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 221
    const-class v0, Ljava/lang/Number;

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/ser/std/StdScalarSerializer;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public acceptJsonFormatVisitor(Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;Lcom/fasterxml/jackson/databind/JavaType;)V
    .locals 0
    .param p1, "visitor"    # Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;
    .param p2, "typeHint"    # Lcom/fasterxml/jackson/databind/JavaType;

    .prologue
    .line 261
    invoke-interface {p1, p2}, Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonFormatVisitorWrapper;->expectNumberFormat(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/jsonFormatVisitors/JsonNumberFormatVisitor;

    .line 262
    return-void
.end method

.method public getSchema(Lcom/fasterxml/jackson/databind/SerializerProvider;Ljava/lang/reflect/Type;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 2
    .param p1, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .param p2, "typeHint"    # Ljava/lang/reflect/Type;

    .prologue
    .line 255
    const-string v0, "number"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;->createSchemaNode(Ljava/lang/String;Z)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v0

    return-object v0
.end method

.method public serialize(Ljava/lang/Number;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 2
    .param p1, "value"    # Ljava/lang/Number;
    .param p2, "jgen"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 228
    instance-of v0, p1, Ljava/math/BigDecimal;

    if-eqz v0, :cond_0

    .line 229
    check-cast p1, Ljava/math/BigDecimal;

    .end local p1    # "value":Ljava/lang/Number;
    invoke-virtual {p2, p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(Ljava/math/BigDecimal;)V

    .line 250
    :goto_0
    return-void

    .line 230
    .restart local p1    # "value":Ljava/lang/Number;
    :cond_0
    instance-of v0, p1, Ljava/math/BigInteger;

    if-eqz v0, :cond_1

    .line 231
    check-cast p1, Ljava/math/BigInteger;

    .end local p1    # "value":Ljava/lang/Number;
    invoke-virtual {p2, p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(Ljava/math/BigInteger;)V

    goto :goto_0

    .line 236
    .restart local p1    # "value":Ljava/lang/Number;
    :cond_1
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_2

    .line 237
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(I)V

    goto :goto_0

    .line 238
    :cond_2
    instance-of v0, p1, Ljava/lang/Long;

    if-eqz v0, :cond_3

    .line 239
    invoke-virtual {p1}, Ljava/lang/Number;->longValue()J

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(J)V

    goto :goto_0

    .line 240
    :cond_3
    instance-of v0, p1, Ljava/lang/Double;

    if-eqz v0, :cond_4

    .line 241
    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(D)V

    goto :goto_0

    .line 242
    :cond_4
    instance-of v0, p1, Ljava/lang/Float;

    if-eqz v0, :cond_5

    .line 243
    invoke-virtual {p1}, Ljava/lang/Number;->floatValue()F

    move-result v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(F)V

    goto :goto_0

    .line 244
    :cond_5
    instance-of v0, p1, Ljava/lang/Byte;

    if-nez v0, :cond_6

    instance-of v0, p1, Ljava/lang/Short;

    if-eqz v0, :cond_7

    .line 245
    :cond_6
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(I)V

    goto :goto_0

    .line 248
    :cond_7
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNumber(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic serialize(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p3, "x2"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonGenerationException;
        }
    .end annotation

    .prologue
    .line 215
    check-cast p1, Ljava/lang/Number;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/fasterxml/jackson/databind/ser/std/NumberSerializers$NumberSerializer;->serialize(Ljava/lang/Number;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V

    return-void
.end method
