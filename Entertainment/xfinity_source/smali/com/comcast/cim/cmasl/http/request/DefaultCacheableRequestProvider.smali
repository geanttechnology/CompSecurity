.class public Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;
.super Ljava/lang/Object;
.source "DefaultCacheableRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final cacheKey:Ljava/lang/String;

.field private final delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V
    .locals 0
    .param p2, "cacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 8
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    .local p1, "delegate":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object p1, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    .line 10
    iput-object p2, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->cacheKey:Ljava/lang/String;

    .line 11
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 35
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    return-void
.end method

.method public addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 30
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    return-void
.end method

.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method public createRequest()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->createRequest()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getCacheKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->cacheKey:Ljava/lang/String;

    return-object v0
.end method

.method public setSocketTimeout(J)V
    .locals 1
    .param p1, "timeoutInMillis"    # J

    .prologue
    .line 40
    .local p0, "this":Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;->delegate:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->setSocketTimeout(J)V

    .line 41
    return-void
.end method
