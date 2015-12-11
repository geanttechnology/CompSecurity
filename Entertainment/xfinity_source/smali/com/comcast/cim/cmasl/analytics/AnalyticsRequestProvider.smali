.class public abstract Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;
.super Ljava/lang/Object;
.source "AnalyticsRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 11
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    .local p1, "delegateRequestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    .line 13
    return-void
.end method


# virtual methods
.method public abstract addDataPairs(Ljava/util/Map;)V
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
.end method

.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 32
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    return-void
.end method

.method public addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 27
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
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
    .line 17
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->createRequest()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public setSocketTimeout(J)V
    .locals 1
    .param p1, "timeoutInMillis"    # J

    .prologue
    .line 37
    .local p0, "this":Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;, "Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsRequestProvider;->delegateRequestProvider:Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProvider;->setSocketTimeout(J)V

    .line 38
    return-void
.end method
