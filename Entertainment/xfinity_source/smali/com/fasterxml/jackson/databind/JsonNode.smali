.class public abstract Lcom/fasterxml/jackson/databind/JsonNode;
.super Ljava/lang/Object;
.source "JsonNode.java"

# interfaces
.implements Lcom/fasterxml/jackson/core/TreeNode;
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/fasterxml/jackson/core/TreeNode;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/fasterxml/jackson/databind/JsonNode;",
        ">;"
    }
.end annotation


# static fields
.field protected static final NO_NODES:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation
.end field

.field protected static final NO_STRINGS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/databind/JsonNode;->NO_NODES:Ljava/util/List;

    .line 35
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/fasterxml/jackson/databind/JsonNode;->NO_STRINGS:Ljava/util/List;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public asBoolean()Z
    .locals 1

    .prologue
    .line 458
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asBoolean(Z)Z

    move-result v0

    return v0
.end method

.method public asBoolean(Z)Z
    .locals 0
    .param p1, "defaultValue"    # Z

    .prologue
    .line 472
    return p1
.end method

.method public asDouble()D
    .locals 2

    .prologue
    .line 430
    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->asDouble(D)D

    move-result-wide v0

    return-wide v0
.end method

.method public asDouble(D)D
    .locals 1
    .param p1, "defaultValue"    # D

    .prologue
    .line 444
    return-wide p1
.end method

.method public asInt()I
    .locals 1

    .prologue
    .line 374
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/JsonNode;->asInt(I)I

    move-result v0

    return v0
.end method

.method public asInt(I)I
    .locals 0
    .param p1, "defaultValue"    # I

    .prologue
    .line 388
    return p1
.end method

.method public asLong()J
    .locals 2

    .prologue
    .line 402
    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->asLong(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public asLong(J)J
    .locals 1
    .param p1, "defaultValue"    # J

    .prologue
    .line 416
    return-wide p1
.end method

.method public abstract asText()Ljava/lang/String;
.end method

.method public abstract asToken()Lcom/fasterxml/jackson/core/JsonToken;
.end method

.method public bigIntegerValue()Ljava/math/BigInteger;
    .locals 1

    .prologue
    .line 307
    sget-object v0, Ljava/math/BigInteger;->ZERO:Ljava/math/BigInteger;

    return-object v0
.end method

.method public binaryValue()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 269
    const/4 v0, 0x0

    return-object v0
.end method

.method public booleanValue()Z
    .locals 1

    .prologue
    .line 280
    const/4 v0, 0x0

    return v0
.end method

.method public canConvertToInt()Z
    .locals 1

    .prologue
    .line 226
    const/4 v0, 0x0

    return v0
.end method

.method public canConvertToLong()Z
    .locals 1

    .prologue
    .line 237
    const/4 v0, 0x0

    return v0
.end method

.method public decimalValue()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 306
    sget-object v0, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public abstract deepCopy()Lcom/fasterxml/jackson/databind/JsonNode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">()TT;"
        }
    .end annotation
.end method

.method public doubleValue()D
    .locals 2

    .prologue
    .line 305
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public elements()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 682
    sget-object v0, Lcom/fasterxml/jackson/databind/JsonNode;->NO_NODES:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public abstract equals(Ljava/lang/Object;)Z
.end method

.method public fieldNames()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 688
    sget-object v0, Lcom/fasterxml/jackson/databind/JsonNode;->NO_STRINGS:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public fields()Ljava/util/Iterator;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/util/Map$Entry",
            "<",
            "Ljava/lang/String;",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 695
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 696
    .local v0, "coll":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/util/Map$Entry<Ljava/lang/String;Lcom/fasterxml/jackson/databind/JsonNode;>;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    return-object v1
.end method

.method public abstract findParent(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
.end method

.method public final findParents(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 641
    const/4 v1, 0x0

    invoke-virtual {p0, p1, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->findParents(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 642
    .local v0, "result":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/JsonNode;>;"
    if-nez v0, :cond_0

    .line 643
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 645
    .end local v0    # "result":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/JsonNode;>;"
    :cond_0
    return-object v0
.end method

.method public abstract findParents(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation
.end method

.method public abstract findPath(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
.end method

.method public abstract findValue(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
.end method

.method public final findValues(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 585
    const/4 v1, 0x0

    invoke-virtual {p0, p1, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->findValues(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 586
    .local v0, "result":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/JsonNode;>;"
    if-nez v0, :cond_0

    .line 587
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 589
    .end local v0    # "result":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/JsonNode;>;"
    :cond_0
    return-object v0
.end method

.method public abstract findValues(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation
.end method

.method public final findValuesAsText(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 598
    const/4 v1, 0x0

    invoke-virtual {p0, p1, v1}, Lcom/fasterxml/jackson/databind/JsonNode;->findValuesAsText(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 599
    .local v0, "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 600
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 602
    .end local v0    # "result":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    return-object v0
.end method

.method public abstract findValuesAsText(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public get(I)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 330
    const/4 v0, 0x0

    return-object v0
.end method

.method public get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 347
    const/4 v0, 0x0

    return-object v0
.end method

.method public has(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 528
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/JsonNode;->get(I)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public has(Ljava/lang/String;)Z
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 502
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasNonNull(I)Z
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 559
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/JsonNode;->get(I)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 560
    .local v0, "n":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->isNull()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public hasNonNull(Ljava/lang/String;)Z
    .locals 2
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 543
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 544
    .local v0, "n":Lcom/fasterxml/jackson/databind/JsonNode;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/fasterxml/jackson/databind/JsonNode;->isNull()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public intValue()I
    .locals 1

    .prologue
    .line 302
    const/4 v0, 0x0

    return v0
.end method

.method public isArray()Z
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    return v0
.end method

.method public isBigDecimal()Z
    .locals 1

    .prologue
    .line 171
    const/4 v0, 0x0

    return v0
.end method

.method public isBigInteger()Z
    .locals 1

    .prologue
    .line 172
    const/4 v0, 0x0

    return v0
.end method

.method public isBinary()Z
    .locals 1

    .prologue
    .line 196
    const/4 v0, 0x0

    return v0
.end method

.method public isBoolean()Z
    .locals 1

    .prologue
    .line 180
    const/4 v0, 0x0

    return v0
.end method

.method public isContainerNode()Z
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    return v0
.end method

.method public isDouble()Z
    .locals 1

    .prologue
    .line 170
    const/4 v0, 0x0

    return v0
.end method

.method public isFloatingPointNumber()Z
    .locals 1

    .prologue
    .line 144
    const/4 v0, 0x0

    return v0
.end method

.method public isInt()Z
    .locals 1

    .prologue
    .line 156
    const/4 v0, 0x0

    return v0
.end method

.method public isIntegralNumber()Z
    .locals 1

    .prologue
    .line 138
    const/4 v0, 0x0

    return v0
.end method

.method public isLong()Z
    .locals 1

    .prologue
    .line 168
    const/4 v0, 0x0

    return v0
.end method

.method public isMissingNode()Z
    .locals 1

    .prologue
    .line 102
    const/4 v0, 0x0

    return v0
.end method

.method public isNull()Z
    .locals 1

    .prologue
    .line 186
    const/4 v0, 0x0

    return v0
.end method

.method public isNumber()Z
    .locals 1

    .prologue
    .line 131
    const/4 v0, 0x0

    return v0
.end method

.method public isObject()Z
    .locals 1

    .prologue
    .line 115
    const/4 v0, 0x0

    return v0
.end method

.method public isPojo()Z
    .locals 1

    .prologue
    .line 125
    const/4 v0, 0x0

    return v0
.end method

.method public isTextual()Z
    .locals 1

    .prologue
    .line 174
    const/4 v0, 0x0

    return v0
.end method

.method public isValueNode()Z
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x0

    return v0
.end method

.method public final iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/fasterxml/jackson/databind/JsonNode;",
            ">;"
        }
    .end annotation

    .prologue
    .line 674
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/JsonNode;->elements()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public longValue()J
    .locals 2

    .prologue
    .line 304
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public abstract numberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;
.end method

.method public numberValue()Ljava/lang/Number;
    .locals 1

    .prologue
    .line 290
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract path(I)Lcom/fasterxml/jackson/databind/JsonNode;
.end method

.method public abstract path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
.end method

.method public size()I
    .locals 1

    .prologue
    .line 666
    const/4 v0, 0x0

    return v0
.end method

.method public textValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 255
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract toString()Ljava/lang/String;
.end method

.method public abstract traverse()Lcom/fasterxml/jackson/core/JsonParser;
.end method

.method public with(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 3
    .param p1, "propertyName"    # Ljava/lang/String;

    .prologue
    .line 735
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "JsonNode not of type ObjectNode (but "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "), can not call with() on it"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public withArray(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 3
    .param p1, "propertyName"    # Ljava/lang/String;

    .prologue
    .line 748
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "JsonNode not of type ObjectNode (but "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "), can not call withArray() on it"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
