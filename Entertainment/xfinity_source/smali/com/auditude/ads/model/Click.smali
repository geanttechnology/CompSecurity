.class public Lcom/auditude/ads/model/Click;
.super Lcom/auditude/ads/model/BaseElement;
.source "Click.java"

# interfaces
.implements Lcom/auditude/ads/model/IClick;


# instance fields
.field private baseTrackingClick:Lcom/auditude/ads/model/Click;

.field private shouldAppendParState:Z

.field private title:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/BaseElement;)V
    .locals 1
    .param p1, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/auditude/ads/model/BaseElement;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 13
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/model/Click;->shouldAppendParState:Z

    .line 18
    return-void
.end method


# virtual methods
.method public final getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/auditude/ads/model/Click;->title:Ljava/lang/String;

    return-object v0
.end method

.method public final getUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 37
    iget-boolean v1, p0, Lcom/auditude/ads/model/Click;->shouldAppendParState:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/model/Click;->url:Ljava/lang/String;

    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/auditude/ads/core/AuditudeEnv;->getReportingHelper()Lcom/auditude/ads/reporting/ReportingHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/auditude/ads/reporting/ReportingHelper;->currentAdState()Ljava/util/HashMap;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/auditude/ads/util/AuditudeUtil;->getUrlWithState(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "resultUrl":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 37
    .end local v0    # "resultUrl":Ljava/lang/String;
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/model/Click;->url:Ljava/lang/String;

    goto :goto_0
.end method

.method public final setBaseTrackingClick(Lcom/auditude/ads/model/Click;)V
    .locals 0
    .param p1, "value"    # Lcom/auditude/ads/model/Click;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/auditude/ads/model/Click;->baseTrackingClick:Lcom/auditude/ads/model/Click;

    .line 66
    return-void
.end method

.method public final setShouldAppendParState(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/auditude/ads/model/Click;->shouldAppendParState:Z

    .line 28
    return-void
.end method

.method public final setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/auditude/ads/model/Click;->title:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public final setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/auditude/ads/model/Click;->url:Ljava/lang/String;

    .line 56
    return-void
.end method
