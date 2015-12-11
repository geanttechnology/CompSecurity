.class public Lcom/auditude/ads/model/tracking/TrackingUrl;
.super Ljava/lang/Object;
.source "TrackingUrl.java"


# instance fields
.field private isLogged:Z

.field private offset:I

.field private offsetIsPercent:Ljava/lang/Boolean;

.field private type:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-boolean v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->isLogged:Z

    .line 12
    iput v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->offset:I

    .line 13
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->offsetIsPercent:Ljava/lang/Boolean;

    .line 17
    iput-object p1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->url:Ljava/lang/String;

    .line 18
    iput-object p2, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->type:Ljava/lang/String;

    .line 19
    return-void
.end method


# virtual methods
.method public duplicate()Lcom/auditude/ads/model/tracking/TrackingUrl;
    .locals 3

    .prologue
    .line 85
    new-instance v0, Lcom/auditude/ads/model/tracking/TrackingUrl;

    invoke-virtual {p0}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public final getOffset()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->offset:I

    return v0
.end method

.method public final getOffsetIsPercent()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->offsetIsPercent:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->url:Ljava/lang/String;

    return-object v0
.end method

.method public final isLogged()Z
    .locals 1

    .prologue
    .line 25
    iget-boolean v0, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->isLogged:Z

    return v0
.end method

.method public log(ZLjava/util/HashMap;)V
    .locals 1
    .param p1, "force"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p2, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, -0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;I)V

    .line 60
    return-void
.end method

.method public log(ZLjava/util/HashMap;I)V
    .locals 4
    .param p1, "force"    # Z
    .param p3, "errorCode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p2, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-boolean v1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->isLogged:Z

    if-eqz v1, :cond_0

    if-nez p1, :cond_0

    .line 81
    :goto_0
    return-void

    .line 66
    :cond_0
    iget-object v1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->url:Ljava/lang/String;

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 68
    if-ltz p3, :cond_2

    .line 70
    iget-object v1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->url:Ljava/lang/String;

    const-string v2, "\\[ERRORCODE\\]"

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "nUrl":Ljava/lang/String;
    const-string v1, "%5BERRORCODE%5D"

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 72
    invoke-static {v0}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;)V

    .line 80
    .end local v0    # "nUrl":Ljava/lang/String;
    :cond_1
    :goto_1
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->isLogged:Z

    goto :goto_0

    .line 76
    :cond_2
    iget-object v1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->url:Ljava/lang/String;

    invoke-static {v1}, Lcom/auditude/ads/util/AuditudeUtil;->substituteTags(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public final setLogged(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->isLogged:Z

    return-void
.end method

.method public final setOffset(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 33
    iput p1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->offset:I

    .line 34
    return-void
.end method

.method public final setOffsetIsPercent(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/auditude/ads/model/tracking/TrackingUrl;->offsetIsPercent:Ljava/lang/Boolean;

    .line 43
    return-void
.end method
