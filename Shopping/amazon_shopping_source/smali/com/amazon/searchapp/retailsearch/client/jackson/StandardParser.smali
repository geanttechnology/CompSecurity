.class public Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;
.super Ljava/lang/Object;
.source "StandardParser.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/ObjectParser;


# static fields
.field private static mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addTypes(Lcom/fasterxml/jackson/databind/module/SimpleModule;)V
    .locals 0
    .param p0, "module"    # Lcom/fasterxml/jackson/databind/module/SimpleModule;

    .prologue
    .line 68
    invoke-static {p0}, Lcom/amazon/searchapp/retailsearch/client/jackson/EntityMap;->mapTypes(Lcom/fasterxml/jackson/databind/module/SimpleModule;)V

    .line 69
    return-void
.end method

.method public static configureMapper(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 1
    .param p0, "mapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;

    .prologue
    .line 58
    sget-object v0, Lcom/fasterxml/jackson/databind/SerializationFeature;->FAIL_ON_EMPTY_BEANS:Lcom/fasterxml/jackson/databind/SerializationFeature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->disable(Lcom/fasterxml/jackson/databind/SerializationFeature;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 59
    sget-object v0, Lcom/fasterxml/jackson/databind/DeserializationFeature;->FAIL_ON_UNKNOWN_PROPERTIES:Lcom/fasterxml/jackson/databind/DeserializationFeature;

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->disable(Lcom/fasterxml/jackson/databind/DeserializationFeature;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 60
    return-void
.end method

.method public static declared-synchronized getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 4

    .prologue
    .line 38
    const-class v2, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    if-nez v1, :cond_0

    .line 39
    new-instance v1, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v1}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    sput-object v1, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 40
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-static {v1}, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->configureMapper(Lcom/fasterxml/jackson/databind/ObjectMapper;)V

    .line 42
    new-instance v0, Lcom/fasterxml/jackson/databind/module/SimpleModule;

    const-class v1, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcom/fasterxml/jackson/core/Version;->unknownVersion()Lcom/fasterxml/jackson/core/Version;

    move-result-object v3

    invoke-direct {v0, v1, v3}, Lcom/fasterxml/jackson/databind/module/SimpleModule;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/Version;)V

    .line 45
    .local v0, "module":Lcom/fasterxml/jackson/databind/module/SimpleModule;
    invoke-static {v0}, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->addTypes(Lcom/fasterxml/jackson/databind/module/SimpleModule;)V

    .line 46
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-virtual {v1, v0}, Lcom/fasterxml/jackson/databind/ObjectMapper;->registerModule(Lcom/fasterxml/jackson/databind/Module;)Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 49
    :cond_0
    sget-object v1, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->mapper:Lcom/fasterxml/jackson/databind/ObjectMapper;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v2

    return-object v1

    .line 38
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method


# virtual methods
.method public parse(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .param p1, "content"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<TResult:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/io/InputStream;",
            "Ljava/lang/Class",
            "<TTResult;>;)TTResult;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 29
    .local p2, "resultClass":Ljava/lang/Class;, "Ljava/lang/Class<TTResult;>;"
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/jackson/StandardParser;->getMapper()Lcom/fasterxml/jackson/databind/ObjectMapper;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->readValue(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
