.class public Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;
.super Ljava/lang/Object;
.source "AnalyticsSenderFactory.java"


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
.field private httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider",
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
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p2, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 19
    iput-object p2, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 20
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;)Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    .prologue
    .line 11
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;)Lcom/comcast/cim/cmasl/http/service/HttpService;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;

    .prologue
    .line 11
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    return-object v0
.end method


# virtual methods
.method public createTask(Ljava/lang/String;Ljava/util/Map;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p1, "analyticsHost"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 23
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory<TT;>;"
    .local p2, "dataPairs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1;-><init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsSenderFactory;Ljava/lang/String;Ljava/util/Map;)V

    return-object v0
.end method
