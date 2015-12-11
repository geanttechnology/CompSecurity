.class public Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;
.super Ljava/lang/Object;
.source "JsonNodeFactory.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final decimalsAsIs:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

.field private static final decimalsNormalized:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

.field public static final instance:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

.field private static final serialVersionUID:J = 0x203d8a5db36799f7L


# instance fields
.field private final _cfgBigDecimalExact:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 21
    new-instance v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;-><init>(Z)V

    sput-object v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->decimalsNormalized:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    .line 23
    new-instance v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;-><init>(Z)V

    sput-object v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->decimalsAsIs:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    .line 31
    sget-object v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->decimalsNormalized:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    sput-object v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->instance:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;-><init>(Z)V

    .line 72
    return-void
.end method

.method protected constructor <init>(Z)V
    .locals 0
    .param p1, "bigDecimalExact"    # Z

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput-boolean p1, p0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->_cfgBigDecimalExact:Z

    .line 61
    return-void
.end method

.method public static withExactBigDecimals(Z)Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;
    .locals 1
    .param p0, "bigDecimalExact"    # Z

    .prologue
    .line 84
    if-eqz p0, :cond_0

    sget-object v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->decimalsAsIs:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->decimalsNormalized:Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;

    goto :goto_0
.end method


# virtual methods
.method public POJONode(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/node/POJONode;
    .locals 1
    .param p1, "pojo"    # Ljava/lang/Object;

    .prologue
    .line 279
    new-instance v0, Lcom/fasterxml/jackson/databind/node/POJONode;

    invoke-direct {v0, p1}, Lcom/fasterxml/jackson/databind/node/POJONode;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method

.method public arrayNode()Lcom/fasterxml/jackson/databind/node/ArrayNode;
    .locals 1

    .prologue
    .line 266
    new-instance v0, Lcom/fasterxml/jackson/databind/node/ArrayNode;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/node/ArrayNode;-><init>(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)V

    return-object v0
.end method

.method public binaryNode([B)Lcom/fasterxml/jackson/databind/node/BinaryNode;
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 246
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/BinaryNode;->valueOf([B)Lcom/fasterxml/jackson/databind/node/BinaryNode;

    move-result-object v0

    return-object v0
.end method

.method public binaryNode([BII)Lcom/fasterxml/jackson/databind/node/BinaryNode;
    .locals 1
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 254
    invoke-static {p1, p2, p3}, Lcom/fasterxml/jackson/databind/node/BinaryNode;->valueOf([BII)Lcom/fasterxml/jackson/databind/node/BinaryNode;

    move-result-object v0

    return-object v0
.end method

.method public booleanNode(Z)Lcom/fasterxml/jackson/databind/node/BooleanNode;
    .locals 1
    .param p1, "v"    # Z

    .prologue
    .line 98
    if-eqz p1, :cond_0

    invoke-static {}, Lcom/fasterxml/jackson/databind/node/BooleanNode;->getTrue()Lcom/fasterxml/jackson/databind/node/BooleanNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/fasterxml/jackson/databind/node/BooleanNode;->getFalse()Lcom/fasterxml/jackson/databind/node/BooleanNode;

    move-result-object v0

    goto :goto_0
.end method

.method public nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;
    .locals 1

    .prologue
    .line 105
    invoke-static {}, Lcom/fasterxml/jackson/databind/node/NullNode;->getInstance()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(B)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # B

    .prologue
    .line 117
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/IntNode;->valueOf(I)Lcom/fasterxml/jackson/databind/node/IntNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(D)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # D

    .prologue
    .line 202
    invoke-static {p1, p2}, Lcom/fasterxml/jackson/databind/node/DoubleNode;->valueOf(D)Lcom/fasterxml/jackson/databind/node/DoubleNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(F)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 2
    .param p1, "v"    # F

    .prologue
    .line 186
    float-to-double v0, p1

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/node/DoubleNode;->valueOf(D)Lcom/fasterxml/jackson/databind/node/DoubleNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(I)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # I

    .prologue
    .line 149
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/IntNode;->valueOf(I)Lcom/fasterxml/jackson/databind/node/IntNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(J)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # J

    .prologue
    .line 165
    invoke-static {p1, p2}, Lcom/fasterxml/jackson/databind/node/LongNode;->valueOf(J)Lcom/fasterxml/jackson/databind/node/LongNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(Ljava/math/BigDecimal;)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # Ljava/math/BigDecimal;

    .prologue
    .line 226
    iget-boolean v0, p0, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->_cfgBigDecimalExact:Z

    if-eqz v0, :cond_0

    .end local p1    # "v":Ljava/math/BigDecimal;
    :goto_0
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/DecimalNode;->valueOf(Ljava/math/BigDecimal;)Lcom/fasterxml/jackson/databind/node/DecimalNode;

    move-result-object v0

    return-object v0

    .restart local p1    # "v":Ljava/math/BigDecimal;
    :cond_0
    invoke-virtual {p1}, Ljava/math/BigDecimal;->stripTrailingZeros()Ljava/math/BigDecimal;

    move-result-object p1

    goto :goto_0
.end method

.method public numberNode(Ljava/math/BigInteger;)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # Ljava/math/BigInteger;

    .prologue
    .line 180
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/BigIntegerNode;->valueOf(Ljava/math/BigInteger;)Lcom/fasterxml/jackson/databind/node/BigIntegerNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(S)Lcom/fasterxml/jackson/databind/node/NumericNode;
    .locals 1
    .param p1, "v"    # S

    .prologue
    .line 133
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/IntNode;->valueOf(I)Lcom/fasterxml/jackson/databind/node/IntNode;

    move-result-object v0

    return-object v0
.end method

.method public numberNode(Ljava/lang/Byte;)Lcom/fasterxml/jackson/databind/node/ValueNode;
    .locals 1
    .param p1, "value"    # Ljava/lang/Byte;

    .prologue
    .line 126
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Byte;->intValue()I

    move-result v0

    invoke-static {v0}, Lcom/fasterxml/jackson/databind/node/IntNode;->valueOf(I)Lcom/fasterxml/jackson/databind/node/IntNode;

    move-result-object v0

    goto :goto_0
.end method

.method public numberNode(Ljava/lang/Double;)Lcom/fasterxml/jackson/databind/node/ValueNode;
    .locals 2
    .param p1, "value"    # Ljava/lang/Double;

    .prologue
    .line 211
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/node/DoubleNode;->valueOf(D)Lcom/fasterxml/jackson/databind/node/DoubleNode;

    move-result-object v0

    goto :goto_0
.end method

.method public numberNode(Ljava/lang/Float;)Lcom/fasterxml/jackson/databind/node/ValueNode;
    .locals 2
    .param p1, "value"    # Ljava/lang/Float;

    .prologue
    .line 195
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Float;->doubleValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/node/DoubleNode;->valueOf(D)Lcom/fasterxml/jackson/databind/node/DoubleNode;

    move-result-object v0

    goto :goto_0
.end method

.method public numberNode(Ljava/lang/Integer;)Lcom/fasterxml/jackson/databind/node/ValueNode;
    .locals 1
    .param p1, "value"    # Ljava/lang/Integer;

    .prologue
    .line 158
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Lcom/fasterxml/jackson/databind/node/IntNode;->valueOf(I)Lcom/fasterxml/jackson/databind/node/IntNode;

    move-result-object v0

    goto :goto_0
.end method

.method public numberNode(Ljava/lang/Long;)Lcom/fasterxml/jackson/databind/node/ValueNode;
    .locals 2
    .param p1, "value"    # Ljava/lang/Long;

    .prologue
    .line 173
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/fasterxml/jackson/databind/node/LongNode;->valueOf(J)Lcom/fasterxml/jackson/databind/node/LongNode;

    move-result-object v0

    goto :goto_0
.end method

.method public numberNode(Ljava/lang/Short;)Lcom/fasterxml/jackson/databind/node/ValueNode;
    .locals 1
    .param p1, "value"    # Ljava/lang/Short;

    .prologue
    .line 142
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;->nullNode()Lcom/fasterxml/jackson/databind/node/NullNode;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Short;->shortValue()S

    move-result v0

    invoke-static {v0}, Lcom/fasterxml/jackson/databind/node/IntNode;->valueOf(I)Lcom/fasterxml/jackson/databind/node/IntNode;

    move-result-object v0

    goto :goto_0
.end method

.method public objectNode()Lcom/fasterxml/jackson/databind/node/ObjectNode;
    .locals 1

    .prologue
    .line 271
    new-instance v0, Lcom/fasterxml/jackson/databind/node/ObjectNode;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/node/ObjectNode;-><init>(Lcom/fasterxml/jackson/databind/node/JsonNodeFactory;)V

    return-object v0
.end method

.method public textNode(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/TextNode;
    .locals 1
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 239
    invoke-static {p1}, Lcom/fasterxml/jackson/databind/node/TextNode;->valueOf(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/TextNode;

    move-result-object v0

    return-object v0
.end method
