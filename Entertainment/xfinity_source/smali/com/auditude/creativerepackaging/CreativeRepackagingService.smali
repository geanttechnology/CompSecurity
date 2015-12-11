.class public Lcom/auditude/creativerepackaging/CreativeRepackagingService;
.super Ljava/lang/Object;
.source "CreativeRepackagingService.java"

# interfaces
.implements Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;
.implements Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;
    }
.end annotation


# instance fields
.field private audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

.field private cdnURL:Ljava/lang/String;

.field private creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

.field private urlNormalizingRules:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

.field private vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;


# direct methods
.method public constructor <init>(Lcom/auditude/creativerepackaging/AuditudeParameters;Lcom/auditude/creativerepackaging/RepackagingParameters;Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;)V
    .locals 1
    .param p1, "auditudeParams"    # Lcom/auditude/creativerepackaging/AuditudeParameters;
    .param p2, "videoParams"    # Lcom/auditude/creativerepackaging/RepackagingParameters;
    .param p3, "listener"    # Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    .line 51
    iput-object p2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    .line 52
    iput-object p3, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    .line 53
    invoke-static {}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->getInstance()Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->urlNormalizingRules:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    .line 55
    invoke-direct {p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->init()V

    .line 56
    return-void
.end method

.method private getErrorURL(I)Ljava/lang/String;
    .locals 3
    .param p1, "errorId"    # I

    .prologue
    .line 179
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->getPlayerErrorURL()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "&errorId="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 180
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&z="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getZoneId()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&a="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getAdId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 181
    const-string v2, "&f="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getRequiredFormat()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&tp="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getExternalAdId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 182
    const-string v2, "&tv="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&url="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getCreativeURL()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 183
    const-string v2, "&vw="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getVideoWidth()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&vh="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getVideoHeight()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 179
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 184
    .local v0, "url":Ljava/lang/String;
    return-object v0
.end method

.method private getPlayerErrorURL()Ljava/lang/String;
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v0}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getDomain()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://ad."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v1}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getDomain()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/adserver/e?type=playererror"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 163
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "http://ad.auditude.com/adserver/e?type=playererror"

    goto :goto_0
.end method

.method private getRequiredVideoURL(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "format"    # Ljava/lang/String;

    .prologue
    .line 169
    iget-object v3, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->urlNormalizingRules:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    invoke-virtual {v3, p1}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->normalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 170
    .local v1, "normalizedURL":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 171
    .local v0, "buffer":Ljava/lang/StringBuffer;
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->reverse()Ljava/lang/StringBuffer;

    move-result-object v0

    .line 172
    invoke-static {v1}, Lcom/auditude/ads/util/MD5;->GetMd5String(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 173
    .local v2, "urlHash":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "http://cdn2.auditude.com/assets/3p/v1/"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x0

    const/16 v5, 0xa

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/auditude/ads/util/MD5;->GetMd5String(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method private init()V
    .locals 2

    .prologue
    .line 60
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    if-nez v0, :cond_0

    .line 62
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "RepackageCreativeListener must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->urlNormalizingRules:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    invoke-virtual {v0, p0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->addEventListener(Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;)V

    .line 66
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->urlNormalizingRules:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    invoke-virtual {v0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->loadRules()V

    .line 67
    return-void
.end method

.method private repackage()V
    .locals 6

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->validateParams()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 79
    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    invoke-direct {p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->validateParams()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;->onError(Ljava/lang/String;)V

    .line 97
    :goto_0
    return-void

    .line 83
    :cond_0
    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getCreativeURL()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v3}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getRequiredFormat()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v2, v3}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->getRequiredVideoURL(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->cdnURL:Ljava/lang/String;

    .line 85
    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v2}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getCreativeURL()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/auditude/creativerepackaging/Cache;->playlistFromCacheForId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 86
    .local v0, "cachedStream":Ljava/lang/String;
    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 88
    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    iget-object v3, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->cdnURL:Ljava/lang/String;

    const/16 v4, 0x57b

    invoke-direct {p0, v4}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->getErrorURL(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;->onURLAvaliable(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 92
    :cond_1
    new-instance v1, Lcom/auditude/ads/loader/DataLoader;

    invoke-direct {v1}, Lcom/auditude/ads/loader/DataLoader;-><init>()V

    .line 93
    .local v1, "dataLoader":Lcom/auditude/ads/loader/DataLoader;
    invoke-virtual {v1, p0}, Lcom/auditude/ads/loader/DataLoader;->setDataLoaderListener(Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;)V

    .line 95
    const-string v2, "CreativeRepackagingService"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Sending Request for repackaged url availability to: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->cdnURL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 96
    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->cdnURL:Ljava/lang/String;

    const/4 v3, 0x0

    const/16 v4, 0xa

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/auditude/ads/loader/DataLoader;->load(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)V

    goto :goto_0
.end method

.method private validateParams()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v0}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getAdId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 103
    const-string v0, "Required parameters missing: adId"

    .line 121
    :goto_0
    return-object v0

    .line 106
    :cond_0
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->audParams:Lcom/auditude/creativerepackaging/AuditudeParameters;

    invoke-virtual {v0}, Lcom/auditude/creativerepackaging/AuditudeParameters;->getExternalAdId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 108
    const-string v0, "Required parameters missing: externalAdId"

    goto :goto_0

    .line 111
    :cond_1
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v0}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getCreativeURL()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 113
    const-string v0, "Required parameters missing: creativeURL"

    goto :goto_0

    .line 116
    :cond_2
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v0}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getRequiredFormat()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 118
    const-string v0, "Required parameters missing: requiredFormat"

    goto :goto_0

    .line 121
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public onRequestComplete(Ljava/lang/String;)V
    .locals 5
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    const/16 v4, 0x579

    .line 131
    const-string v1, "true"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 133
    const-string v1, "CreativeRepackagingService"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Received repackaged url: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->cdnURL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 134
    const/16 v1, 0x57b

    invoke-direct {p0, v1}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->getErrorURL(I)Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "impressionURL":Ljava/lang/String;
    iget-object v1, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->vidParams:Lcom/auditude/creativerepackaging/RepackagingParameters;

    invoke-virtual {v1}, Lcom/auditude/creativerepackaging/RepackagingParameters;->getCreativeURL()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/auditude/creativerepackaging/Cache;->addPlaylistToCache(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    iget-object v1, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    iget-object v2, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->cdnURL:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;->onURLAvaliable(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    .end local v0    # "impressionURL":Ljava/lang/String;
    :goto_0
    return-void

    .line 140
    :cond_0
    const-string v1, "CreativeRepackagingService"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Sending Request for repackaging to: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v4}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->getErrorURL(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 141
    invoke-direct {p0, v4}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->getErrorURL(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/auditude/ads/util/PingUtil;->pingUrl(Ljava/lang/String;)V

    .line 142
    iget-object v1, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    const-string v2, "Begin to transcode video"

    invoke-interface {v1, v2}, Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;->onError(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onRequestFailed(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->creativeRepackagingServiceListener:Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;

    const-string v1, "Service unavailable"

    invoke-interface {v0, v1}, Lcom/auditude/creativerepackaging/CreativeRepackagingService$CreativeRepackagingServiceListener;->onError(Ljava/lang/String;)V

    .line 153
    return-void
.end method

.method public onRulesLoaded(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "success"    # Ljava/lang/Boolean;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->urlNormalizingRules:Lcom/auditude/creativerepackaging/UrlNormalizingRules;

    invoke-virtual {v0, p0}, Lcom/auditude/creativerepackaging/UrlNormalizingRules;->removeEventListener(Lcom/auditude/creativerepackaging/UrlNormalizingRules$UrlNormalizingRulesListener;)V

    .line 72
    invoke-direct {p0}, Lcom/auditude/creativerepackaging/CreativeRepackagingService;->repackage()V

    .line 73
    return-void
.end method
