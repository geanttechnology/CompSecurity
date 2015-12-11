.class public Lcom/xfinity/playerlib/model/entitlement/EntitlementParser;
.super Ljava/lang/Object;
.source "EntitlementParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public parse(Lcom/fasterxml/jackson/databind/ObjectMapper;Ljava/io/InputStream;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 6
    .param p1, "jsonObjectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .param p2, "bodyStream"    # Ljava/io/InputStream;

    .prologue
    .line 14
    :try_start_0
    const-class v4, Lcom/fasterxml/jackson/databind/JsonNode;

    invoke-virtual {p1, p2, v4}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 15
    .local v3, "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v4, "data"

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v0

    .line 16
    .local v0, "dataNode":Lcom/fasterxml/jackson/databind/JsonNode;
    new-instance v2, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    const-string v4, "edata"

    invoke-virtual {v0, v4}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    invoke-virtual {v4}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v4

    const-string v5, "xedata"

    invoke-virtual {v0, v5}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v4, v5}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;-><init>(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 22
    .local v2, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    return-object v2

    .line 18
    .end local v0    # "dataNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v2    # "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .end local v3    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_0
    move-exception v1

    .line 19
    .local v1, "e":Ljava/io/IOException;
    new-instance v4, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-direct {v4, v1}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/io/IOException;)V

    throw v4
.end method
