.class public Lcom/comcast/cim/model/MinVersionTask;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "MinVersionTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private final appVersionName:Ljava/lang/String;

.field private final httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;)V
    .locals 0
    .param p3, "appVersionName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/model/MinVersionTask;, "Lcom/comcast/cim/model/MinVersionTask<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p2, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    .local p4, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 24
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    iput-object p1, p0, Lcom/comcast/cim/model/MinVersionTask;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 26
    iput-object p3, p0, Lcom/comcast/cim/model/MinVersionTask;->appVersionName:Ljava/lang/String;

    .line 27
    iput-object p4, p0, Lcom/comcast/cim/model/MinVersionTask;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 28
    return-void
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Ljava/lang/Integer;
    .locals 6

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/model/MinVersionTask;, "Lcom/comcast/cim/model/MinVersionTask<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/model/MinVersionTask;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v2, "checkcompat?appId=%s&deviceType=Android"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/comcast/cim/model/MinVersionTask;->appVersionName:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 33
    .local v0, "request":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/model/MinVersionTask;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v2, Lcom/comcast/cim/model/MinVersionTask$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/model/MinVersionTask$1;-><init>(Lcom/comcast/cim/model/MinVersionTask;)V

    invoke-interface {v1, v0, v2}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;

    .line 37
    invoke-virtual {v1}, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;->getMinVersion()Ljava/lang/Integer;

    move-result-object v1

    return-object v1
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/model/MinVersionTask;, "Lcom/comcast/cim/model/MinVersionTask<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/MinVersionTask;->fetchResourceWithNoCache()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method
