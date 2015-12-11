.class public Lcom/auditude/ads/response/VMAPAdBreak;
.super Ljava/lang/Object;
.source "VMAPAdBreak.java"


# instance fields
.field private allowMultipleAds:Ljava/lang/String;

.field private followRedirects:Ljava/lang/String;

.field private repeatAfter:I

.field private startTime:I

.field private trackingUrls:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/tracking/TrackingUrl;",
            ">;"
        }
    .end annotation
.end field

.field private vastDocuments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTDocument;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "startTime"    # I

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->startTime:I

    .line 14
    iput v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->repeatAfter:I

    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->trackingUrls:Ljava/util/ArrayList;

    .line 16
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->vastDocuments:Ljava/util/ArrayList;

    .line 20
    iput p1, p0, Lcom/auditude/ads/response/VMAPAdBreak;->startTime:I

    .line 21
    return-void
.end method


# virtual methods
.method public addTrackingUrl(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 73
    const/4 v0, 0x0

    .line 74
    .local v0, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    const-string v1, "breakStart"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "start"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 76
    :cond_0
    new-instance v0, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .end local v0    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    const-string v1, "start"

    invoke-direct {v0, p2, v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    .restart local v0    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_1
    :goto_0
    if-eqz v0, :cond_2

    .line 84
    iget-object v1, p0, Lcom/auditude/ads/response/VMAPAdBreak;->trackingUrls:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 87
    :cond_2
    return-void

    .line 78
    :cond_3
    const-string v1, "breakEnd"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    const-string v1, "complete"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 80
    :cond_4
    new-instance v0, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .end local v0    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    const-string v1, "complete"

    invoke-direct {v0, p2, v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v0    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    goto :goto_0
.end method

.method public addVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V
    .locals 1
    .param p1, "vastDocument"    # Lcom/auditude/ads/network/vast/model/VASTDocument;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->vastDocuments:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 56
    return-void
.end method

.method public getAllowMultipleAds()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->allowMultipleAds:Ljava/lang/String;

    return-object v0
.end method

.method public getCopy(I)Lcom/auditude/ads/response/VMAPAdBreak;
    .locals 6
    .param p1, "startTime"    # I

    .prologue
    .line 95
    new-instance v0, Lcom/auditude/ads/response/VMAPAdBreak;

    invoke-direct {v0, p1}, Lcom/auditude/ads/response/VMAPAdBreak;-><init>(I)V

    .line 96
    .local v0, "adBreak":Lcom/auditude/ads/response/VMAPAdBreak;
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPAdBreak;->allowMultipleAds:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/auditude/ads/response/VMAPAdBreak;->setAllowMultipleAds(Ljava/lang/String;)V

    .line 97
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPAdBreak;->followRedirects:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/auditude/ads/response/VMAPAdBreak;->setFollowRedirects(Ljava/lang/String;)V

    .line 98
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPAdBreak;->trackingUrls:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_0

    .line 103
    iget-object v3, p0, Lcom/auditude/ads/response/VMAPAdBreak;->vastDocuments:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 108
    return-object v0

    .line 98
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 100
    .local v1, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Lcom/auditude/ads/response/VMAPAdBreak;->addTrackingUrl(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 103
    .end local v1    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/network/vast/model/VASTDocument;

    .line 105
    .local v2, "vastDoc":Lcom/auditude/ads/network/vast/model/VASTDocument;
    invoke-virtual {v0, v2}, Lcom/auditude/ads/response/VMAPAdBreak;->addVastDocument(Lcom/auditude/ads/network/vast/model/VASTDocument;)V

    goto :goto_1
.end method

.method public getFollowRedirects()Ljava/lang/Boolean;
    .locals 2

    .prologue
    .line 43
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->followRedirects:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->followRedirects:Ljava/lang/String;

    const-string v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 49
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public getRepeatAfter()I
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->repeatAfter:I

    return v0
.end method

.method public getStartTime()I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->startTime:I

    return v0
.end method

.method public getTrackingUrls()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/tracking/TrackingUrl;",
            ">;"
        }
    .end annotation

    .prologue
    .line 90
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->trackingUrls:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getVastDocuments()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTDocument;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    iget-object v0, p0, Lcom/auditude/ads/response/VMAPAdBreak;->vastDocuments:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setAllowMultipleAds(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/auditude/ads/response/VMAPAdBreak;->allowMultipleAds:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setFollowRedirects(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/auditude/ads/response/VMAPAdBreak;->followRedirects:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setRepeatAfter(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 64
    iput p1, p0, Lcom/auditude/ads/response/VMAPAdBreak;->repeatAfter:I

    .line 65
    return-void
.end method
