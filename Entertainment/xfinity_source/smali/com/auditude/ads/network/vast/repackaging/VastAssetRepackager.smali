.class public Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;
.super Ljava/lang/Object;
.source "VastAssetRepackager.java"

# interfaces
.implements Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;
    }
.end annotation


# instance fields
.field private domain:Ljava/lang/String;

.field private linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

.field private listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

.field private requiredFormat:Ljava/lang/String;

.field private rootAdId:Ljava/lang/String;

.field private zoneId:I


# direct methods
.method public constructor <init>(Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Ljava/lang/String;Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;)V
    .locals 1
    .param p1, "listener"    # Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;
    .param p2, "linearAd"    # Lcom/auditude/ads/network/vast/model/VASTLinearCreative;
    .param p3, "rootAdId"    # Ljava/lang/String;
    .param p4, "vastAssetRepackagerInfo"    # Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;

    .prologue
    const/4 v0, 0x0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    .line 18
    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->rootAdId:Ljava/lang/String;

    .line 19
    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->requiredFormat:Ljava/lang/String;

    .line 20
    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->domain:Ljava/lang/String;

    .line 21
    const/4 v0, 0x0

    iput v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->zoneId:I

    .line 29
    iput-object p1, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    .line 30
    iput-object p2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    .line 31
    iput-object p3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->rootAdId:Ljava/lang/String;

    .line 32
    if-eqz p4, :cond_0

    .line 34
    iget-object v0, p4, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->requiredFormat:Ljava/lang/String;

    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->requiredFormat:Ljava/lang/String;

    .line 35
    iget-object v0, p4, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->domain:Ljava/lang/String;

    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->domain:Ljava/lang/String;

    .line 36
    iget v0, p4, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->zoneId:I

    iput v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->zoneId:I

    .line 38
    :cond_0
    return-void
.end method

.method private creativeUrlForSource(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    .line 78
    const/4 v4, 0x0

    .line 81
    .local v4, "sourceUrl":Ljava/net/URL;
    :try_start_0
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 84
    .end local v4    # "sourceUrl":Ljava/net/URL;
    .local v5, "sourceUrl":Ljava/net/URL;
    :try_start_1
    invoke-virtual {v5}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_4

    invoke-virtual {v5}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v6

    const-string v7, "theplatform.com"

    invoke-virtual {v6, v7}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-virtual {v5}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 86
    invoke-virtual {v5}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v6

    const-string v7, "&"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 87
    .local v2, "params":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v6, v2

    if-lt v0, v6, :cond_0

    move-object v4, v5

    .line 117
    .end local v0    # "i":I
    .end local v2    # "params":[Ljava/lang/String;
    .end local v5    # "sourceUrl":Ljava/net/URL;
    .end local p1    # "source":Ljava/lang/String;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    :goto_1
    return-object p1

    .line 89
    .end local v4    # "sourceUrl":Ljava/net/URL;
    .restart local v0    # "i":I
    .restart local v2    # "params":[Ljava/lang/String;
    .restart local v5    # "sourceUrl":Ljava/net/URL;
    .restart local p1    # "source":Ljava/lang/String;
    :cond_0
    aget-object v1, v2, v0

    .line 90
    .local v1, "param":Ljava/lang/String;
    const-string v6, "="

    invoke-virtual {v1, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 92
    .local v3, "parts":[Ljava/lang/String;
    array-length v6, v3

    if-ge v6, v8, :cond_2

    .line 87
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 98
    :cond_2
    const/4 v6, 0x0

    aget-object v6, v3, v6

    const-string v7, "creativeurl"

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v6

    if-nez v6, :cond_1

    .line 100
    array-length v6, v3
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    const/4 v7, 0x2

    if-ge v6, v7, :cond_3

    .line 102
    const-string p1, ""

    .end local p1    # "source":Ljava/lang/String;
    move-object v4, v5

    .end local v5    # "sourceUrl":Ljava/net/URL;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    goto :goto_1

    .line 105
    .end local v4    # "sourceUrl":Ljava/net/URL;
    .restart local v5    # "sourceUrl":Ljava/net/URL;
    .restart local p1    # "source":Ljava/lang/String;
    :cond_3
    const/4 v6, 0x1

    :try_start_2
    aget-object p1, v3, v6
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .end local p1    # "source":Ljava/lang/String;
    move-object v4, v5

    .end local v5    # "sourceUrl":Ljava/net/URL;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    goto :goto_1

    .line 115
    .end local v0    # "i":I
    .end local v1    # "param":Ljava/lang/String;
    .end local v2    # "params":[Ljava/lang/String;
    .end local v3    # "parts":[Ljava/lang/String;
    .restart local p1    # "source":Ljava/lang/String;
    :catch_0
    move-exception v6

    goto :goto_1

    .end local v4    # "sourceUrl":Ljava/net/URL;
    .restart local v5    # "sourceUrl":Ljava/net/URL;
    :catch_1
    move-exception v6

    move-object v4, v5

    .end local v5    # "sourceUrl":Ljava/net/URL;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    goto :goto_1

    .end local v4    # "sourceUrl":Ljava/net/URL;
    .restart local v5    # "sourceUrl":Ljava/net/URL;
    :cond_4
    move-object v4, v5

    .end local v5    # "sourceUrl":Ljava/net/URL;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    goto :goto_1
.end method


# virtual methods
.method public onError(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 148
    iget-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    iget-object v1, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V

    .line 153
    :cond_0
    return-void
.end method

.method public onURLAvaliable(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "impressionURL"    # Ljava/lang/String;

    .prologue
    .line 122
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v2, :cond_0

    .line 124
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v2}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getBestMediaFile()Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    move-result-object v0

    .line 125
    .local v0, "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    if-eqz v0, :cond_0

    .line 127
    iput-object p1, v0, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->url:Ljava/lang/String;

    .line 128
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->requiredFormat:Ljava/lang/String;

    iput-object v2, v0, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->type:Ljava/lang/String;

    .line 132
    .end local v0    # "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    :cond_0
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    const-string v3, "creativeview"

    invoke-virtual {v2, v3}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    move-result-object v1

    .line 133
    .local v1, "vastTrackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    if-nez v1, :cond_1

    .line 135
    new-instance v1, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;

    .end local v1    # "vastTrackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    const-string v2, "creativeview"

    invoke-direct {v1, v2}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;-><init>(Ljava/lang/String;)V

    .line 136
    .restart local v1    # "vastTrackingEvent":Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v2, v1}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->addTrackingEvent(Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;)V

    .line 138
    :cond_1
    new-instance v2, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    const-string v3, "creativeview"

    invoke-direct {v2, p2, v3}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V

    .line 140
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    if-eqz v2, :cond_2

    .line 142
    iget-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    const/4 v4, 0x1

    invoke-interface {v2, v3, v4}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V

    .line 144
    :cond_2
    return-void
.end method

.method public repackage()V
    .locals 6

    .prologue
    .line 42
    new-instance v0, Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-direct {v0}, Lcom/auditude/creativerepackaging/AuditudeParameters;-><init>()V

    .line 43
    .local v0, "audParams":Lcom/auditude/creativerepackaging/AuditudeParameters;
    iget v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->zoneId:I

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setZoneId(I)V

    .line 44
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->domain:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setDomain(Ljava/lang/String;)V

    .line 45
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->rootAdId:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setAdId(Ljava/lang/String;)V

    .line 46
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    iget-object v3, v3, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->adId:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setExternalAdId(Ljava/lang/String;)V

    .line 48
    new-instance v2, Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-direct {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;-><init>()V

    .line 49
    .local v2, "vidParams":Lcom/auditude/creativerepackaging/RepackagingParameters;
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->requiredFormat:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setRequiredFormat(Ljava/lang/String;)V

    .line 51
    const/4 v1, 0x0

    .line 52
    .local v1, "mediaFile":Lcom/auditude/ads/network/vast/model/VASTMediaFile;
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    if-eqz v3, :cond_0

    .line 54
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    invoke-virtual {v3}, Lcom/auditude/ads/network/vast/model/VASTLinearCreative;->getBestMediaFile()Lcom/auditude/ads/network/vast/model/VASTMediaFile;

    move-result-object v1

    .line 57
    :cond_0
    if-eqz v1, :cond_2

    iget-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->url:Ljava/lang/String;

    if-eqz v3, :cond_2

    .line 59
    iget-object v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->url:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->creativeUrlForSource(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setCreativeURL(Ljava/lang/String;)V

    .line 60
    iget v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->height:I

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setVideoHeight(I)V

    .line 61
    iget v3, v1, Lcom/auditude/ads/network/vast/model/VASTMediaFile;->width:I

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setVideoWidth(I)V

    .line 73
    :cond_1
    new-instance v3, Lcom/auditude/creativerepackaging/CreativeRepackagingService;

    invoke-direct {v3, v0, v2, p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;-><init>(Lcom/auditude/creativerepackaging/AuditudeParameters;Lcom/auditude/creativerepackaging/RepackagingParameters;Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;)V

    .line 74
    :goto_0
    return-void

    .line 65
    :cond_2
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    if-eqz v3, :cond_1

    .line 67
    iget-object v3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->listener:Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;

    iget-object v4, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager;->linearAd:Lcom/auditude/ads/network/vast/model/VASTLinearCreative;

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackager$VastAssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/network/vast/model/VASTLinearCreative;Z)V

    goto :goto_0
.end method
