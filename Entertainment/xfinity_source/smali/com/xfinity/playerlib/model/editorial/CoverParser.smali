.class public Lcom/xfinity/playerlib/model/editorial/CoverParser;
.super Ljava/lang/Object;
.source "CoverParser.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/editorial/EditorialParser;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/xfinity/playerlib/model/editorial/CoverParser;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/editorial/CoverParser;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/editorial/CoverParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 39
    return-void
.end method


# virtual methods
.method public getCollectionTitle(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "json"    # Ljava/lang/String;

    .prologue
    .line 66
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/model/editorial/CoverParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v4, Lcom/fasterxml/jackson/databind/JsonNode;

    invoke-virtual {v3, p1, v4}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 67
    .local v2, "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v3, "name"

    invoke-virtual {v2, v3}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v1

    .line 68
    .local v1, "name":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-virtual {v1}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    return-object v3

    .line 69
    .end local v1    # "name":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v2    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_0
    move-exception v0

    .line 70
    .local v0, "e":Ljava/lang/Exception;
    new-instance v3, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method public getPrograms(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 11
    .param p1, "json"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/xfinity/playerlib/model/CoverVideo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 42
    new-instance v0, Ljava/util/ArrayList;

    const/4 v8, 0x5

    invoke-direct {v0, v8}, Ljava/util/ArrayList;-><init>(I)V

    .line 44
    .local v0, "covers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/xfinity/playerlib/model/CoverVideo;>;"
    :try_start_0
    iget-object v8, p0, Lcom/xfinity/playerlib/model/editorial/CoverParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v9, Lcom/fasterxml/jackson/databind/JsonNode;

    invoke-virtual {v8, p1, v9}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 45
    .local v7, "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v8, "lists"

    invoke-virtual {v7, v8}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    .line 46
    .local v5, "jsonCoverListNode":Lcom/fasterxml/jackson/databind/JsonNode;
    iget-object v8, p0, Lcom/xfinity/playerlib/model/editorial/CoverParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JsonNode;->traverse()Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v9

    const-class v10, Ljava/util/ArrayList;

    invoke-virtual {v8, v9, v10}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/ArrayList;

    .line 47
    .local v6, "lists":Ljava/util/ArrayList;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v8

    if-ge v4, v8, :cond_0

    .line 48
    new-instance v1, Lcom/xfinity/playerlib/model/CoverVideo;

    invoke-direct {v1}, Lcom/xfinity/playerlib/model/CoverVideo;-><init>()V

    .line 49
    .local v1, "cv":Lcom/xfinity/playerlib/model/CoverVideo;
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/LinkedHashMap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 51
    .local v3, "hm":Ljava/util/LinkedHashMap;
    :try_start_1
    invoke-virtual {v1, v3}, Lcom/xfinity/playerlib/model/CoverVideo;->parse(Ljava/util/LinkedHashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 56
    :try_start_2
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 47
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 52
    :catch_0
    move-exception v2

    .line 53
    .local v2, "e":Ljava/lang/Exception;
    sget-object v8, Lcom/xfinity/playerlib/model/editorial/CoverParser;->LOG:Lorg/slf4j/Logger;

    const-string v9, "Failed parsing cover item."

    invoke-interface {v8, v9, v2}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 58
    .end local v1    # "cv":Lcom/xfinity/playerlib/model/CoverVideo;
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "hm":Ljava/util/LinkedHashMap;
    .end local v4    # "i":I
    .end local v5    # "jsonCoverListNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v6    # "lists":Ljava/util/ArrayList;
    .end local v7    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_1
    move-exception v2

    .line 59
    .restart local v2    # "e":Ljava/lang/Exception;
    new-instance v8, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-virtual {v2}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 61
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v4    # "i":I
    .restart local v5    # "jsonCoverListNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v6    # "lists":Ljava/util/ArrayList;
    .restart local v7    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :cond_0
    return-object v0
.end method
