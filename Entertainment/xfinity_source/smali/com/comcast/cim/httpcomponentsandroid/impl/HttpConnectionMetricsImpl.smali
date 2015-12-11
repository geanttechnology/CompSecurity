.class public Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;
.super Ljava/lang/Object;
.source "HttpConnectionMetricsImpl.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpConnectionMetrics;


# instance fields
.field private final inTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

.field private final outTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

.field private requestCount:J

.field private responseCount:J


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;)V
    .locals 2
    .param p1, "inTransportMetric"    # Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;
    .param p2, "outTransportMetric"    # Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    .prologue
    const-wide/16 v0, 0x0

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->requestCount:J

    .line 49
    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->responseCount:J

    .line 60
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->inTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    .line 61
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->outTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    .line 62
    return-void
.end method


# virtual methods
.method public getReceivedBytesCount()J
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->inTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->inTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;->getBytesTransferred()J

    move-result-wide v0

    .line 70
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public getRequestCount()J
    .locals 2

    .prologue
    .line 83
    iget-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->requestCount:J

    return-wide v0
.end method

.method public getResponseCount()J
    .locals 2

    .prologue
    .line 91
    iget-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->responseCount:J

    return-wide v0
.end method

.method public getSentBytesCount()J
    .locals 2

    .prologue
    .line 75
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->outTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    if-eqz v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->outTransportMetric:Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;->getBytesTransferred()J

    move-result-wide v0

    .line 78
    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, -0x1

    goto :goto_0
.end method

.method public incrementRequestCount()V
    .locals 4

    .prologue
    .line 87
    iget-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->requestCount:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->requestCount:J

    .line 88
    return-void
.end method

.method public incrementResponseCount()V
    .locals 4

    .prologue
    .line 95
    iget-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->responseCount:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/HttpConnectionMetricsImpl;->responseCount:J

    .line 96
    return-void
.end method
