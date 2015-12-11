.class public Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
.super Ljava/lang/Object;
.source "SearchConfigurationManager.java"


# static fields
.field private static volatile instance:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;


# instance fields
.field private volatile config:Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

.field private final configs:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;)V
    .locals 0
    .param p1, "configs"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->configs:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;

    .line 46
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
    .locals 3

    .prologue
    .line 52
    const-class v1, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->instance:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    if-nez v0, :cond_0

    .line 53
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/StaticSearchConfiguration;->build()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;-><init>(Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;)V

    sput-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->instance:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    .line 56
    :cond_0
    sget-object v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->instance:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 52
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public declared-synchronized getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    .locals 1

    .prologue
    .line 72
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->config:Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    if-nez v0, :cond_0

    .line 73
    const-string/jumbo v0, "amazon"

    invoke-virtual {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getConfigurationById(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->config:Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    .line 76
    :cond_0
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->config:Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 72
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getConfigurationById(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    .locals 1
    .param p1, "configId"    # Ljava/lang/String;

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->configs:Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationSet;->getConfigurations()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    return-object v0
.end method

.method public declared-synchronized setConfiguration(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;)V
    .locals 1
    .param p1, "config"    # Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    .prologue
    .line 85
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->config:Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    monitor-exit p0

    return-void

    .line 85
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setConfigurationId(Ljava/lang/String;)V
    .locals 1
    .param p1, "configId"    # Ljava/lang/String;

    .prologue
    .line 94
    invoke-virtual {p0, p1}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getConfigurationById(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->setConfiguration(Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;)V

    .line 95
    return-void
.end method
