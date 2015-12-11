.class public Lcom/amazon/retailsearch/data/search/SearchLoader;
.super Ljava/lang/Object;
.source "SearchLoader.java"

# interfaces
.implements Lcom/amazon/retailsearch/data/SearchTask;


# instance fields
.field private final client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

.field private final executorService:Ljava/util/concurrent/ExecutorService;

.field private final initialRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

.field private lastRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

.field private listener:Lcom/amazon/retailsearch/data/search/RequestListener;

.field private loading:Z

.field private nextUrl:Ljava/lang/String;

.field private pageStartIndex:I

.field private final resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;Lcom/amazon/searchapp/retailsearch/client/SearchRequest;Ljava/util/concurrent/ExecutorService;)V
    .locals 1
    .param p1, "client"    # Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;
    .param p2, "request"    # Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
    .param p3, "executorService"    # Ljava/util/concurrent/ExecutorService;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-direct {v0}, Lcom/amazon/retailsearch/data/search/ResultStream;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    .line 30
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->pageStartIndex:I

    .line 31
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->lastRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    .line 35
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    .line 36
    iput-object p2, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->initialRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    .line 37
    iput-object p3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 38
    return-void
.end method

.method public static createListenerProxy(Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/client/SearchListener;
    .locals 6
    .param p0, "listener"    # Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    .prologue
    .line 146
    new-instance v0, Lcom/amazon/retailsearch/client/UiInvocationHandler;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/client/UiInvocationHandler;-><init>(Ljava/lang/Object;)V

    .line 148
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

    .line 150
    .local v1, "proxy":Ljava/lang/Object;
    check-cast v1, Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    .end local v1    # "proxy":Ljava/lang/Object;
    return-object v1
.end method


# virtual methods
.method public addListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/data/search/ResultStream;->read(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V

    .line 175
    return-void
.end method

.method public clearError()V
    .locals 3

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/data/search/ResultStream;->getContent()Ljava/util/List;

    move-result-object v0

    iget v1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->pageStartIndex:I

    iget-object v2, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/data/search/ResultStream;->getContent()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-interface {v0, v1, v2}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 128
    new-instance v0, Lcom/amazon/retailsearch/data/search/SearchLoader$1;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/data/search/SearchLoader$1;-><init>(Lcom/amazon/retailsearch/data/search/SearchLoader;)V

    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->getListeners()Ljava/lang/Iterable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/SearchLoader$1;->send(Ljava/lang/Iterable;)V

    .line 136
    return-void
.end method

.method public close()V
    .locals 2

    .prologue
    .line 193
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    new-instance v1, Lcom/amazon/retailsearch/data/search/SearchLoader$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/data/search/SearchLoader$2;-><init>(Lcom/amazon/retailsearch/data/search/SearchLoader;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/data/search/ResultStream;->addRecord(Lcom/amazon/retailsearch/data/search/ResultEvent;)V

    .line 204
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/data/search/ResultStream;->close()V

    .line 205
    return-void
.end method

.method protected getNextUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->nextUrl:Ljava/lang/String;

    return-object v0
.end method

.method protected getPageStartIndex()I
    .locals 1

    .prologue
    .line 116
    iget v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->pageStartIndex:I

    return v0
.end method

.method public getResultStream()Lcom/amazon/retailsearch/data/search/ResultStream;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    return-object v0
.end method

.method public getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/data/search/ResultStream;->getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    move-result-object v0

    return-object v0
.end method

.method public isLoading()Z
    .locals 1

    .prologue
    .line 96
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->loading:Z

    return v0
.end method

.method public load()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 42
    iget-boolean v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->loading:Z

    if-eqz v3, :cond_1

    .line 87
    :cond_0
    :goto_0
    return-void

    .line 47
    :cond_1
    sget-object v3, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Done:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    iget-object v4, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/data/search/ResultStream;->getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 53
    iput-boolean v5, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->loading:Z

    .line 55
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->initialRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    .line 57
    .local v1, "request":Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
    sget-object v3, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    iget-object v4, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/data/search/ResultStream;->getStatus()Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 60
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/SearchLoader;->clearError()V

    .line 62
    iget-object v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->lastRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    if-eqz v3, :cond_2

    .line 64
    iget-object v1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->lastRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    .line 78
    :cond_2
    :goto_1
    new-instance v3, Lcom/amazon/retailsearch/data/search/RequestListener;

    iget-object v4, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-direct {v3, p0, v4}, Lcom/amazon/retailsearch/data/search/RequestListener;-><init>(Lcom/amazon/retailsearch/data/search/SearchLoader;Lcom/amazon/retailsearch/data/search/ResultStream;)V

    iput-object v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->listener:Lcom/amazon/retailsearch/data/search/RequestListener;

    .line 79
    iget-object v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->client:Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;

    iget-object v4, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->listener:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-static {v4}, Lcom/amazon/retailsearch/data/search/SearchLoader;->createListenerProxy(Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/client/SearchListener;

    move-result-object v4

    invoke-virtual {v3, v1, v4}, Lcom/amazon/searchapp/retailsearch/client/RetailSearchClient;->search(Lcom/amazon/searchapp/retailsearch/client/SearchRequest;Lcom/amazon/searchapp/retailsearch/client/SearchListener;)Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;

    move-result-object v2

    .line 80
    .local v2, "serviceCall":Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;
    iget-object v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->listener:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-virtual {v3, v2}, Lcom/amazon/retailsearch/data/search/RequestListener;->setServiceCall(Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;)V

    .line 82
    iget-object v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->executorService:Ljava/util/concurrent/ExecutorService;

    if-eqz v3, :cond_4

    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->executorService:Ljava/util/concurrent/ExecutorService;

    .line 85
    .local v0, "executor":Ljava/util/concurrent/ExecutorService;
    :goto_2
    iput-object v1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->lastRequest:Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    .line 86
    invoke-interface {v0, v2}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    goto :goto_0

    .line 67
    .end local v0    # "executor":Ljava/util/concurrent/ExecutorService;
    .end local v2    # "serviceCall":Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;
    :cond_3
    iget-object v3, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->nextUrl:Ljava/lang/String;

    if-eqz v3, :cond_2

    .line 70
    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;-><init>()V

    iget-object v4, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->nextUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setDataUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    move-result-object v3

    invoke-virtual {v3, v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setImageCrop(Z)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setImageResolution(Ljava/lang/Integer;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    move-result-object v3

    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getInstance()Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getDeviceInfo()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setDeviceInformation(Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    move-result-object v1

    goto :goto_1

    .line 82
    .restart local v2    # "serviceCall":Lcom/amazon/searchapp/retailsearch/client/SearchServiceCall;
    :cond_4
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    goto :goto_2
.end method

.method public loadNext()V
    .locals 0

    .prologue
    .line 156
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/SearchLoader;->load()V

    .line 157
    return-void
.end method

.method public loadNext(I)V
    .locals 0
    .param p1, "count"    # I

    .prologue
    .line 163
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;)Z
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->resultStream:Lcom/amazon/retailsearch/data/search/ResultStream;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/data/search/ResultStream;->detach(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V

    .line 181
    const/4 v0, 0x1

    return v0
.end method

.method public retry()V
    .locals 0

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/SearchLoader;->load()V

    .line 169
    return-void
.end method

.method protected setLoading(Z)V
    .locals 0
    .param p1, "loading"    # Z

    .prologue
    .line 101
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->loading:Z

    .line 102
    return-void
.end method

.method protected setNextUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "nextUrl"    # Ljava/lang/String;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->nextUrl:Ljava/lang/String;

    .line 112
    return-void
.end method

.method protected setPageStartIndex(I)V
    .locals 0
    .param p1, "pageStartIndex"    # I

    .prologue
    .line 121
    iput p1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader;->pageStartIndex:I

    .line 122
    return-void
.end method
