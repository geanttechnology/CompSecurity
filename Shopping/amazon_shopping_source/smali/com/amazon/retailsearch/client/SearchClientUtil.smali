.class public Lcom/amazon/retailsearch/client/SearchClientUtil;
.super Ljava/lang/Object;
.source "SearchClientUtil.java"


# static fields
.field private static final ALIAS_REFINEMENT:Ljava/lang/String; = "i"

.field private static final KEYWORDS_REFINEMENT:Ljava/lang/String; = "k"

.field private static final NODE_REFINEMENT:Ljava/lang/String; = "n"

.field private static final REFINEMENT_SEPERATOR:Ljava/lang/String; = ","

.field private static final REFINEMENT_VALUE_SEPARATOR:Ljava/lang/String; = ":"

.field private static executorService:Ljava/util/concurrent/ExecutorService;

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/amazon/retailsearch/client/SearchClientUtil;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/client/SearchClientUtil;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static createExecutorService()Ljava/util/concurrent/ExecutorService;
    .locals 7

    .prologue
    const/16 v1, 0xa

    .line 83
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/16 v3, 0x3a98

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    move v2, v1

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    .line 86
    .local v0, "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 88
    return-object v0
.end method

.method public static createListenerProxy(Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .locals 6
    .param p0, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    .prologue
    .line 160
    new-instance v0, Lcom/amazon/retailsearch/client/UiInvocationHandler;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/client/UiInvocationHandler;-><init>(Ljava/lang/Object;)V

    .line 162
    .local v0, "handler":Lcom/amazon/retailsearch/client/UiInvocationHandler;, "Lcom/amazon/retailsearch/client/UiInvocationHandler<Lcom/amazon/searchapp/retailsearch/client/SearchListener;>;"
    const-class v2, Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    aput-object v5, v3, v4

    invoke-static {v2, v3, v0}, Ljava/lang/reflect/Proxy;->newProxyInstance(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;

    move-result-object v1

    .line 164
    .local v1, "proxy":Ljava/lang/Object;
    check-cast v1, Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    .end local v1    # "proxy":Ljava/lang/Object;
    return-object v1
.end method

.method private static execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p0, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 68
    invoke-static {}, Lcom/amazon/retailsearch/client/SearchClientUtil;->getExecutorService()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-interface {v0, p0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 69
    return-void
.end method

.method public static executeRequest(Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;)Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall",
            "<*>;)",
            "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "searchCall":Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;, "Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall<*>;"
    :try_start_0
    new-instance v1, Lcom/amazon/retailsearch/client/SearchClientUtil$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/client/SearchClientUtil$1;-><init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchServiceCall;)V

    .line 56
    .local v1, "task":Ljava/lang/Runnable;
    invoke-static {v1}, Lcom/amazon/retailsearch/client/SearchClientUtil;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 63
    .end local v1    # "task":Ljava/lang/Runnable;
    :goto_0
    return-object p0

    .line 58
    :catch_0
    move-exception v0

    .line 60
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/retailsearch/client/SearchClientUtil;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v3, "Failed to execute service call"

    invoke-interface {v2, v3, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static filterToRefinement(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "filter"    # Ljava/lang/String;
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 107
    if-nez p0, :cond_0

    .line 109
    const/4 v5, 0x0

    .line 149
    :goto_0
    return-object v5

    .line 112
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v6

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    :goto_1
    add-int/2addr v5, v6

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 114
    .local v3, "refinement":Ljava/lang/StringBuilder;
    invoke-static {p0}, Lcom/amazon/retailsearch/web/WebSearchFilter;->splitFilters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 116
    .local v2, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/web/WebSearchFilter;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/web/WebSearchFilter;

    .line 118
    .local v1, "item":Lcom/amazon/retailsearch/web/WebSearchFilter;
    invoke-virtual {v1}, Lcom/amazon/retailsearch/web/WebSearchFilter;->getFilterValue()Ljava/lang/String;

    move-result-object v4

    .line 120
    .local v4, "val":Ljava/lang/String;
    if-eqz v4, :cond_1

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-eqz v5, :cond_1

    .line 125
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_2

    .line 127
    const-string/jumbo v5, ","

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 130
    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-nez v5, :cond_4

    invoke-virtual {v1}, Lcom/amazon/retailsearch/web/WebSearchFilter;->isAlias()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 132
    const-string/jumbo v5, "i"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 112
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "item":Lcom/amazon/retailsearch/web/WebSearchFilter;
    .end local v2    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/web/WebSearchFilter;>;"
    .end local v3    # "refinement":Ljava/lang/StringBuilder;
    .end local v4    # "val":Ljava/lang/String;
    :cond_3
    const/4 v5, 0x0

    goto :goto_1

    .line 135
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v1    # "item":Lcom/amazon/retailsearch/web/WebSearchFilter;
    .restart local v2    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/web/WebSearchFilter;>;"
    .restart local v3    # "refinement":Ljava/lang/StringBuilder;
    .restart local v4    # "val":Ljava/lang/String;
    :cond_4
    const-string/jumbo v5, "n"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 139
    .end local v1    # "item":Lcom/amazon/retailsearch/web/WebSearchFilter;
    .end local v4    # "val":Ljava/lang/String;
    :cond_5
    if-eqz p1, :cond_7

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_7

    .line 141
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    if-lez v5, :cond_6

    .line 143
    const-string/jumbo v5, ","

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 146
    :cond_6
    const-string/jumbo v5, "k"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 149
    :cond_7
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_0
.end method

.method private static declared-synchronized getExecutorService()Ljava/util/concurrent/ExecutorService;
    .locals 2

    .prologue
    .line 73
    const-class v1, Lcom/amazon/retailsearch/client/SearchClientUtil;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/retailsearch/client/SearchClientUtil;->executorService:Ljava/util/concurrent/ExecutorService;

    if-nez v0, :cond_0

    .line 75
    invoke-static {}, Lcom/amazon/retailsearch/client/SearchClientUtil;->createExecutorService()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/client/SearchClientUtil;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 78
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/client/SearchClientUtil;->executorService:Ljava/util/concurrent/ExecutorService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 73
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
