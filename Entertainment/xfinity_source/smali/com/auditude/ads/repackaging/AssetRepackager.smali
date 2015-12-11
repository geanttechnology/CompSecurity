.class public Lcom/auditude/ads/repackaging/AssetRepackager;
.super Ljava/lang/Object;
.source "AssetRepackager.java"

# interfaces
.implements Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;
    }
.end annotation


# instance fields
.field private asset:Lcom/auditude/ads/model/Asset;

.field private domain:Ljava/lang/String;

.field private listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

.field private requiredFormat:Ljava/lang/String;

.field private zoneId:I


# direct methods
.method public constructor <init>(Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;Lcom/auditude/ads/model/Asset;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;
    .param p2, "asset"    # Lcom/auditude/ads/model/Asset;
    .param p3, "requiredFormat"    # Ljava/lang/String;
    .param p4, "domain"    # Ljava/lang/String;
    .param p5, "zoneId"    # I

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    .line 28
    iput-object p3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->requiredFormat:Ljava/lang/String;

    .line 29
    iput-object p4, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->domain:Ljava/lang/String;

    .line 30
    iput p5, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->zoneId:I

    .line 31
    iput-object p1, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    .line 32
    return-void
.end method

.method private creativeUrlForSource(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "source"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    .line 77
    const/4 v4, 0x0

    .line 80
    .local v4, "sourceUrl":Ljava/net/URL;
    :try_start_0
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
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

    .line 85
    invoke-virtual {v5}, Ljava/net/URL;->getQuery()Ljava/lang/String;

    move-result-object v6

    const-string v7, "&"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 86
    .local v2, "params":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v6, v2

    if-lt v0, v6, :cond_0

    move-object v4, v5

    .line 116
    .end local v0    # "i":I
    .end local v2    # "params":[Ljava/lang/String;
    .end local v5    # "sourceUrl":Ljava/net/URL;
    .end local p1    # "source":Ljava/lang/String;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    :goto_1
    return-object p1

    .line 88
    .end local v4    # "sourceUrl":Ljava/net/URL;
    .restart local v0    # "i":I
    .restart local v2    # "params":[Ljava/lang/String;
    .restart local v5    # "sourceUrl":Ljava/net/URL;
    .restart local p1    # "source":Ljava/lang/String;
    :cond_0
    aget-object v1, v2, v0

    .line 89
    .local v1, "param":Ljava/lang/String;
    const-string v6, "="

    invoke-virtual {v1, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 91
    .local v3, "parts":[Ljava/lang/String;
    array-length v6, v3

    if-ge v6, v8, :cond_2

    .line 86
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 97
    :cond_2
    const/4 v6, 0x0

    aget-object v6, v3, v6

    const-string v7, "creativeurl"

    invoke-virtual {v6, v7}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v6

    if-nez v6, :cond_1

    .line 99
    array-length v6, v3
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    const/4 v7, 0x2

    if-ge v6, v7, :cond_3

    .line 101
    const-string p1, ""

    .end local p1    # "source":Ljava/lang/String;
    move-object v4, v5

    .end local v5    # "sourceUrl":Ljava/net/URL;
    .restart local v4    # "sourceUrl":Ljava/net/URL;
    goto :goto_1

    .line 104
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

    .line 114
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
    .line 144
    iget-object v0, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    iget-object v1, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/model/Asset;Z)V

    .line 148
    :cond_0
    return-void
.end method

.method public onURLAvaliable(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "impressionURL"    # Ljava/lang/String;

    .prologue
    .line 121
    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v2}, Lcom/auditude/ads/model/Asset;->getBestMediaFile()Lcom/auditude/ads/model/media/MediaFile;

    move-result-object v0

    .line 122
    .local v0, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    if-nez v0, :cond_0

    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v2}, Lcom/auditude/ads/model/Asset;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 124
    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v2}, Lcom/auditude/ads/model/Asset;->getMediaFile()Lcom/auditude/ads/model/media/MediaFile;

    move-result-object v0

    .line 127
    :cond_0
    if-eqz v0, :cond_1

    .line 129
    iput-object p1, v0, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    .line 130
    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->requiredFormat:Ljava/lang/String;

    iput-object v2, v0, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    .line 133
    :cond_1
    new-instance v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v2, "creativeview"

    invoke-direct {v1, p2, v2}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    .local v1, "tracking":Lcom/auditude/ads/model/tracking/TrackingUrl;
    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    const-string v3, "creativeview"

    invoke-virtual {v2, v1, v3}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 136
    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    if-eqz v2, :cond_2

    .line 138
    iget-object v2, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    const/4 v4, 0x1

    invoke-interface {v2, v3, v4}, Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/model/Asset;Z)V

    .line 140
    :cond_2
    return-void
.end method

.method public repackage()V
    .locals 6

    .prologue
    .line 36
    new-instance v0, Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-direct {v0}, Lcom/auditude/creativerepackaging/AuditudeParameters;-><init>()V

    .line 37
    .local v0, "audParams":Lcom/auditude/creativerepackaging/AuditudeParameters;
    iget v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->zoneId:I

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setZoneId(I)V

    .line 39
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v3}, Lcom/auditude/ads/model/Asset;->getParent()Lcom/auditude/ads/model/BaseElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/auditude/ads/model/BaseElement;->getID()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setAdId(Ljava/lang/String;)V

    .line 40
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v3}, Lcom/auditude/ads/model/Asset;->isNetworkAd()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 42
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v3}, Lcom/auditude/ads/model/Asset;->getNetworkAdId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setExternalAdId(Ljava/lang/String;)V

    .line 49
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->domain:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setDomain(Ljava/lang/String;)V

    .line 51
    new-instance v2, Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-direct {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;-><init>()V

    .line 52
    .local v2, "vidParams":Lcom/auditude/creativerepackaging/RepackagingParameters;
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->requiredFormat:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setRequiredFormat(Ljava/lang/String;)V

    .line 54
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    invoke-virtual {v3}, Lcom/auditude/ads/model/Asset;->getBestMediaFile()Lcom/auditude/ads/model/media/MediaFile;

    move-result-object v1

    .line 56
    .local v1, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    if-eqz v1, :cond_2

    iget-object v3, v1, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    if-eqz v3, :cond_2

    .line 58
    iget-object v3, v1, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/auditude/ads/repackaging/AssetRepackager;->creativeUrlForSource(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setCreativeURL(Ljava/lang/String;)V

    .line 59
    iget v3, v1, Lcom/auditude/ads/model/media/MediaFile;->height:I

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setVideoHeight(I)V

    .line 60
    iget v3, v1, Lcom/auditude/ads/model/media/MediaFile;->width:I

    invoke-virtual {v2, v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->setVideoWidth(I)V

    .line 72
    :cond_0
    new-instance v3, Lcom/auditude/creativerepackaging/CreativeRepackagingService;

    invoke-direct {v3, v0, v2, p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;-><init>(Lcom/auditude/creativerepackaging/AuditudeParameters;Lcom/auditude/creativerepackaging/RepackagingParameters;Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;)V

    .line 73
    :goto_1
    return-void

    .line 46
    .end local v1    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    .end local v2    # "vidParams":Lcom/auditude/creativerepackaging/RepackagingParameters;
    :cond_1
    const-string v3, "0"

    invoke-virtual {v0, v3}, Lcom/auditude/creativerepackaging/AuditudeParameters;->setExternalAdId(Ljava/lang/String;)V

    goto :goto_0

    .line 64
    .restart local v1    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    .restart local v2    # "vidParams":Lcom/auditude/creativerepackaging/RepackagingParameters;
    :cond_2
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    if-eqz v3, :cond_0

    .line 66
    iget-object v3, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->listener:Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;

    iget-object v4, p0, Lcom/auditude/ads/repackaging/AssetRepackager;->asset:Lcom/auditude/ads/model/Asset;

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;->onRepackagingComplete(Lcom/auditude/ads/model/Asset;Z)V

    goto :goto_1
.end method
