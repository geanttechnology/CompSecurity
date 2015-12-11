.class public Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;
.super Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;
.source "DefaultAnalyticsRequestProvider.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field LOG:Lorg/slf4j/Logger;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider<TT;>;"
    .local p1, "delegateRequestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V

    .line 12
    const-class v0, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;->LOG:Lorg/slf4j/Logger;

    .line 16
    return-void
.end method


# virtual methods
.method public addDataPairs(Ljava/util/Map;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider<TT;>;"
    .local p1, "dataPairs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 22
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v4, "UTF-8"

    invoke-static {v3, v4}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v3, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    :goto_1
    invoke-virtual {p0, v4, v3}, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 23
    :catch_0
    move-exception v0

    .line 24
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Failed to encode analytics data-pair"

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 22
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_0
    :try_start_1
    const-string v3, "null"
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 27
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void
.end method
