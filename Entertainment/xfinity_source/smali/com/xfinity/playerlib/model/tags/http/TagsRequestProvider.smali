.class public Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider;
.super Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;
.source "TagsRequestProvider.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V
    .locals 2
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
    .line 9
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider;, "Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider<TT;>;"
    .local p1, "baseProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V

    .line 10
    const-string v0, "Accept"

    const-string v1, "application/json"

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 11
    return-void
.end method
