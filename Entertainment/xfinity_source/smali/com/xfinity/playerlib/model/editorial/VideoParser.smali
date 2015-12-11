.class public Lcom/xfinity/playerlib/model/editorial/VideoParser;
.super Ljava/lang/Object;
.source "VideoParser.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/editorial/EditorialParser;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/xfinity/playerlib/model/editorial/VideoParser;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/editorial/VideoParser;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/image/CoverArtImageLoader;)V
    .locals 1
    .param p1, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    new-instance v0, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/editorial/VideoParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 43
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/VideoParser;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 44
    return-void
.end method

.method private getCollectionTitle(Ljava/lang/String;I)Ljava/lang/String;
    .locals 6
    .param p1, "json"    # Ljava/lang/String;
    .param p2, "index"    # I

    .prologue
    .line 94
    :try_start_0
    iget-object v4, p0, Lcom/xfinity/playerlib/model/editorial/VideoParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v5, Lcom/fasterxml/jackson/databind/JsonNode;

    invoke-virtual {v4, p1, v5}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 95
    .local v3, "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v4, "videoGalleries"

    invoke-virtual {v3, v4}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    invoke-virtual {v4, p2}, Lcom/fasterxml/jackson/databind/JsonNode;->path(I)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v4

    const-string v5, "header"

    invoke-virtual {v4, v5}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v1

    .line 96
    .local v1, "header":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v4, "name"

    invoke-virtual {v1, v4}, Lcom/fasterxml/jackson/databind/JsonNode;->get(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    .line 97
    .local v2, "name":Lcom/fasterxml/jackson/databind/JsonNode;
    invoke-virtual {v2}, Lcom/fasterxml/jackson/databind/JsonNode;->asText()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    return-object v4

    .line 98
    .end local v1    # "header":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v2    # "name":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v3    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_0
    move-exception v0

    .line 99
    .local v0, "e":Ljava/lang/Exception;
    new-instance v4, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/comcast/cim/cmasl/http/exceptions/CimIOException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method private getPrograms(Ljava/lang/String;Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;I)Ljava/util/List;
    .locals 12
    .param p1, "json"    # Ljava/lang/String;
    .param p3, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory",
            "<TT;>;I)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 65
    .local p2, "programFactory":Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;, "Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory<TT;>;"
    :try_start_0
    new-instance v7, Ljava/util/ArrayList;

    const/16 v9, 0x14

    invoke-direct {v7, v9}, Ljava/util/ArrayList;-><init>(I)V

    .line 66
    .local v7, "programs":Ljava/util/List;, "Ljava/util/List<TT;>;"
    iget-object v9, p0, Lcom/xfinity/playerlib/model/editorial/VideoParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    const-class v10, Lcom/fasterxml/jackson/databind/JsonNode;

    invoke-virtual {v9, p1, v10}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/fasterxml/jackson/databind/JsonNode;

    .line 67
    .local v8, "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    const-string v9, "videoGalleries"

    invoke-virtual {v8, v9}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v9

    invoke-virtual {v9, p3}, Lcom/fasterxml/jackson/databind/JsonNode;->path(I)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v9

    const-string v10, "items"

    invoke-virtual {v9, v10}, Lcom/fasterxml/jackson/databind/JsonNode;->path(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v5

    .line 68
    .local v5, "listNode":Lcom/fasterxml/jackson/databind/JsonNode;
    iget-object v9, p0, Lcom/xfinity/playerlib/model/editorial/VideoParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v5}, Lcom/fasterxml/jackson/databind/JsonNode;->traverse()Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v10

    const-class v11, Ljava/util/ArrayList;

    invoke-virtual {v9, v10, v11}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Lcom/fasterxml/jackson/core/JsonParser;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 69
    .local v4, "list":Ljava/util/List;
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_0

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 70
    .local v1, "aList":Ljava/lang/Object;
    move-object v0, v1

    check-cast v0, Ljava/util/LinkedHashMap;

    move-object v3, v0

    .line 71
    .local v3, "item":Ljava/util/LinkedHashMap;
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;->create()Lcom/xfinity/playerlib/model/EditorialProgram;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 74
    .local v6, "program":Lcom/xfinity/playerlib/model/EditorialProgram;, "TT;"
    :try_start_1
    invoke-virtual {v6, v3}, Lcom/xfinity/playerlib/model/EditorialProgram;->parse(Ljava/util/LinkedHashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 83
    :try_start_2
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 87
    .end local v1    # "aList":Ljava/lang/Object;
    .end local v3    # "item":Ljava/util/LinkedHashMap;
    .end local v4    # "list":Ljava/util/List;
    .end local v5    # "listNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v6    # "program":Lcom/xfinity/playerlib/model/EditorialProgram;, "TT;"
    .end local v7    # "programs":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local v8    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_0
    move-exception v2

    .line 88
    .local v2, "e":Ljava/lang/Exception;
    new-instance v9, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v9, v2}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 75
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v1    # "aList":Ljava/lang/Object;
    .restart local v3    # "item":Ljava/util/LinkedHashMap;
    .restart local v4    # "list":Ljava/util/List;
    .restart local v5    # "listNode":Lcom/fasterxml/jackson/databind/JsonNode;
    .restart local v6    # "program":Lcom/xfinity/playerlib/model/EditorialProgram;, "TT;"
    .restart local v7    # "programs":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .restart local v8    # "rootNode":Lcom/fasterxml/jackson/databind/JsonNode;
    :catch_1
    move-exception v2

    .line 76
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_3
    sget-object v10, Lcom/xfinity/playerlib/model/editorial/VideoParser;->LOG:Lorg/slf4j/Logger;

    const-string v11, "Failed parsing video."

    invoke-interface {v10, v11, v2}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0

    .line 86
    .end local v1    # "aList":Ljava/lang/Object;
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "item":Ljava/util/LinkedHashMap;
    .end local v6    # "program":Lcom/xfinity/playerlib/model/EditorialProgram;, "TT;"
    :cond_0
    return-object v7
.end method


# virtual methods
.method public getMovieCollectionTitle(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "json"    # Ljava/lang/String;

    .prologue
    .line 51
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getCollectionTitle(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMovies(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "json"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialMovie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    new-instance v0, Lcom/xfinity/playerlib/model/etc/EditorialMovieFactory;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/etc/EditorialMovieFactory;-><init>()V

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getPrograms(Ljava/lang/String;Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSeries(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "json"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialTVSeries;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    new-instance v0, Lcom/xfinity/playerlib/model/etc/EditorialTVSeriesFactory;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/etc/EditorialTVSeriesFactory;-><init>()V

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getPrograms(Ljava/lang/String;Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSeriesCollectionTitle(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "json"    # Ljava/lang/String;

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/model/editorial/VideoParser;->getCollectionTitle(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
