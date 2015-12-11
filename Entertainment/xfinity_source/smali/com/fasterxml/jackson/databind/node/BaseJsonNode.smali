.class public abstract Lcom/fasterxml/jackson/databind/node/BaseJsonNode;
.super Lcom/fasterxml/jackson/databind/JsonNode;
.source "BaseJsonNode.java"

# interfaces
.implements Lcom/fasterxml/jackson/databind/JsonSerializable;


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/JsonNode;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract asToken()Lcom/fasterxml/jackson/core/JsonToken;
.end method

.method public bridge synthetic findParent(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 1
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/node/BaseJsonNode;->findParent(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/ObjectNode;

    move-result-object v0

    return-object v0
.end method

.method public findParent(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/ObjectNode;
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 49
    const/4 v0, 0x0

    return-object v0
.end method

.method public findParents(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p1, "fieldName"    # Ljava/lang/String;
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

    .prologue
    .line 64
    .local p2, "foundSoFar":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/JsonNode;>;"
    return-object p2
.end method

.method public final findPath(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-virtual {p0, p1}, Lcom/fasterxml/jackson/databind/node/BaseJsonNode;->findValue(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 40
    .local v0, "value":Lcom/fasterxml/jackson/databind/JsonNode;
    if-nez v0, :cond_0

    .line 41
    invoke-static {}, Lcom/fasterxml/jackson/databind/node/MissingNode;->getInstance()Lcom/fasterxml/jackson/databind/node/MissingNode;

    move-result-object v0

    .line 43
    .end local v0    # "value":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    return-object v0
.end method

.method public findValue(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;
    .locals 1
    .param p1, "fieldName"    # Ljava/lang/String;

    .prologue
    .line 33
    const/4 v0, 0x0

    return-object v0
.end method

.method public findValues(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p1, "fieldName"    # Ljava/lang/String;
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

    .prologue
    .line 54
    .local p2, "foundSoFar":Ljava/util/List;, "Ljava/util/List<Lcom/fasterxml/jackson/databind/JsonNode;>;"
    return-object p2
.end method

.method public findValuesAsText(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p1, "fieldName"    # Ljava/lang/String;
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

    .prologue
    .line 59
    .local p2, "foundSoFar":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    return-object p2
.end method

.method public numberType()Lcom/fasterxml/jackson/core/JsonParser$NumberType;
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract serialize(Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation
.end method

.method public abstract serializeWithType(Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;Lcom/fasterxml/jackson/databind/jsontype/TypeSerializer;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation
.end method

.method public traverse()Lcom/fasterxml/jackson/core/JsonParser;
    .locals 1

    .prologue
    .line 75
    new-instance v0, Lcom/fasterxml/jackson/databind/node/TreeTraversingParser;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/node/TreeTraversingParser;-><init>(Lcom/fasterxml/jackson/databind/JsonNode;)V

    return-object v0
.end method
