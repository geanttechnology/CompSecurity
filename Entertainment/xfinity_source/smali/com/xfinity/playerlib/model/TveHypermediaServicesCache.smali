.class public Lcom/xfinity/playerlib/model/TveHypermediaServicesCache;
.super Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;
.source "TveHypermediaServicesCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache",
        "<",
        "Lcom/xfinity/playerlib/model/TveHypermediaService;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V
    .locals 0
    .param p2, "halHttpClient"    # Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
    .param p3, "hypermediaUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 11
    .local p1, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Ljava/lang/String;)V

    .line 12
    return-void
.end method


# virtual methods
.method protected bridge synthetic fetchResourceWithNoCache()Lcom/comcast/cim/cmasl/hal/task/HypermediaService;
    .locals 1

    .prologue
    .line 7
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/TveHypermediaServicesCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/TveHypermediaService;

    move-result-object v0

    return-object v0
.end method

.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/TveHypermediaService;
    .locals 2

    .prologue
    .line 16
    new-instance v0, Lcom/xfinity/playerlib/model/TveHypermediaService;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/TveHypermediaServicesCache;->fetchMicrodataItem()Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/TveHypermediaService;-><init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V

    return-object v0
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 7
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/TveHypermediaServicesCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/TveHypermediaService;

    move-result-object v0

    return-object v0
.end method
