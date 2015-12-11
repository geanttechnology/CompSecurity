.class public Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
.super Ljava/lang/Object;
.source "HlsDownloadClient.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field downloadHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field final requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient<TT;>;"
    .local p1, "downloadHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p2, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->downloadHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 18
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 20
    return-void
.end method


# virtual methods
.method public downloadHlsFile(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsParser;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .locals 1
    .param p1, "hlsUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<P:",
            "Lcom/comcast/cim/cmasl/hls/HlsPlaylist;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/hls/HlsParser",
            "<TP;>;)TP;"
        }
    .end annotation

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient<TT;>;"
    .local p2, "hlsParser":Lcom/comcast/cim/cmasl/hls/HlsParser;, "Lcom/comcast/cim/cmasl/hls/HlsParser<TP;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->downloadHlsFile(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsParser;Ljava/util/Map;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    move-result-object v0

    return-object v0
.end method

.method public downloadHlsFile(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsParser;Ljava/util/Map;)Lcom/comcast/cim/cmasl/hls/HlsPlaylist;
    .locals 6
    .param p1, "hlsUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<P:",
            "Lcom/comcast/cim/cmasl/hls/HlsPlaylist;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/hls/HlsParser",
            "<TP;>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)TP;"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient<TT;>;"
    .local p2, "hlsParser":Lcom/comcast/cim/cmasl/hls/HlsParser;, "Lcom/comcast/cim/cmasl/hls/HlsParser<TP;>;"
    .local p3, "additionalHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-interface {v4, p1}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v2

    .line 28
    .local v2, "provider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    if-eqz p3, :cond_0

    .line 29
    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 30
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v2, v4, v5}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 34
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v4, p0, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;->downloadHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v5, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;

    invoke-direct {v5, p0, p2}, Lcom/comcast/cim/cmasl/hls/HlsDownloadClient$1;-><init>(Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;Lcom/comcast/cim/cmasl/hls/HlsParser;)V

    invoke-interface {v4, v2, v5}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;

    .line 40
    .local v3, "response":Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;, "Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler<TP;>;"
    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/hls/HlsDownloadResponseHandler;->getFile()Lcom/comcast/cim/cmasl/hls/HlsPlaylist;

    move-result-object v4

    return-object v4
.end method
