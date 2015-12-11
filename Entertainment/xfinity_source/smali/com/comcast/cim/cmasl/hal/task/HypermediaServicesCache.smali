.class public abstract Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "HypermediaServicesCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/comcast/cim/cmasl/hal/task/HypermediaService;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<TT;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

.field private hypermediaUrl:Ljava/lang/String;


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
    .line 15
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;, "Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache<TT;>;"
    .local p1, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 16
    iput-object p2, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .line 17
    iput-object p3, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;->hypermediaUrl:Ljava/lang/String;

    .line 18
    return-void
.end method


# virtual methods
.method protected fetchMicrodataItem()Lcom/comcast/cim/microdata/model/MicrodataItem;
    .locals 2

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;, "Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;->hypermediaUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->fetchMicroData(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    return-object v0
.end method

.method protected abstract fetchResourceWithNoCache()Lcom/comcast/cim/cmasl/hal/task/HypermediaService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 8
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;, "Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hal/task/HypermediaServicesCache;->fetchResourceWithNoCache()Lcom/comcast/cim/cmasl/hal/task/HypermediaService;

    move-result-object v0

    return-object v0
.end method
