.class Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;
.super Ljava/lang/Object;
.source "AnalyticsSenderFactory.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/task/Task;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->createTask(Ljava/lang/String;Ljava/util/Map;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

.field final synthetic val$analyticsHost:Ljava/lang/String;

.field final synthetic val$dataPairs:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->val$analyticsHost:Ljava/lang/String;

    iput-object p3, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->val$dataPairs:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public clearCachedResult()V
    .locals 0

    .prologue
    .line 62
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    return-void
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->execute()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/lang/Void;
    .locals 3

    .prologue
    .line 42
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    # getter for: Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    invoke-static {v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->access$000(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;)Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->val$analyticsHost:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;

    .line 43
    .local v0, "requestProvider":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    iget-object v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->val$dataPairs:Ljava/util/Map;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->addDataPairs(Ljava/util/Map;)V

    .line 44
    iget-object v1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->this$0:Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    # getter for: Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    invoke-static {v1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->access$100(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;)Lcom/comcast/cim/cmasl/http/service/HttpService;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;

    invoke-direct {v2, p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1$1;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;)V

    invoke-interface {v1, v0, v2}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    .line 51
    const/4 v1, 0x0

    return-object v1
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->getCachedResultIfAvailable()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Ljava/lang/Void;
    .locals 1

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getSecondLevelStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->getSecondLevelStaleResultIfAvailable()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public getSecondLevelStaleResultIfAvailable()Ljava/lang/Void;
    .locals 1

    .prologue
    .line 37
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getStaleResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;->getStaleResultIfAvailable()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public getStaleResultIfAvailable()Ljava/lang/Void;
    .locals 1

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory.1;"
    const/4 v0, 0x0

    return-object v0
.end method
