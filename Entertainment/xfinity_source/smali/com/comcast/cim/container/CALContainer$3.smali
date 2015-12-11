.class Lcom/comcast/cim/container/CALContainer$3;
.super Ljava/lang/Object;
.source "CALContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/CALContainer;->getAnalyticsTaskQueue()Lcom/comcast/cim/cmasl/analytics/AnalyticsTaskQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
        "<",
        "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/CALContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/CALContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/CALContainer;

    .prologue
    .line 427
    iput-object p1, p0, Lcom/comcast/cim/container/CALContainer$3;->this$0:Lcom/comcast/cim/container/CALContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 430
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;

    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer$3;->this$0:Lcom/comcast/cim/container/CALContainer;

    invoke-virtual {v1}, Lcom/comcast/cim/container/CALContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "httpMethod"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 435
    new-instance v0, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;

    iget-object v1, p0, Lcom/comcast/cim/container/CALContainer$3;->this$0:Lcom/comcast/cim/container/CALContainer;

    invoke-virtual {v1}, Lcom/comcast/cim/container/CALContainer;->getHttpRequestProviderFactory()Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/analytics/DefaultAnalyticsRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V

    return-object v0
.end method

.method public bridge synthetic create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 1

    .prologue
    .line 427
    invoke-virtual {p0, p1}, Lcom/comcast/cim/container/CALContainer$3;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 1

    .prologue
    .line 427
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/container/CALContainer$3;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;

    move-result-object v0

    return-object v0
.end method
