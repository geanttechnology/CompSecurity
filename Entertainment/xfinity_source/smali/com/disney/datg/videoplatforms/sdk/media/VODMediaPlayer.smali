.class public Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;
.super Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.source "VODMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;,
        Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;,
        Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;


# instance fields
.field protected adCues:Ljava/util/LinkedHashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashSet",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;",
            ">;"
        }
    .end annotation
.end field

.field protected currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

.field protected currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

.field protected currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

.field protected currentAdIndex:I

.field protected currentAdTotal:I

.field private inAd:Z

.field protected loop:Z

.field needsPing:Z

.field protected nextPingTime:I

.field private omnitureTagFiredForWatchedPercentage:I

.field pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

.field protected playManifest:Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

.field protected progressionTimer:Ljava/util/Timer;

.field protected timeToSeekToAfterUnlockingAdBreak:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 57
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 221
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;-><init>(Landroid/content/Context;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V

    .line 59
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    .line 65
    const/4 v0, -0x1

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->timeToSeekToAfterUnlockingAdBreak:I

    .line 68
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->needsPing:Z

    .line 69
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    .line 216
    iput-boolean v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->loop:Z

    .line 218
    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I

    .line 222
    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I

    .line 223
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)I
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;

    .prologue
    .line 55
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I

    return v0
.end method

.method static synthetic access$102(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;I)I
    .locals 0
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;
    .param p1, "x1"    # I

    .prologue
    .line 55
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I

    return p1
.end method

.method private configurePlayManifest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V
    .locals 7
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    .prologue
    .line 253
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    const-string v6, "configurePlayManifest"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v5}, Ljava/util/LinkedHashSet;->clear()V

    .line 257
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getPlayManifest()Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 258
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getPlayManifest()Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    move-result-object v2

    .line 259
    .local v2, "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getAdCollection()Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getAdCollection()Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->getAdbreak()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getAdCollection()Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->getAdbreak()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 264
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getEntitlmentResponse()Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getEntitlmentResponse()Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->getUplynkData()Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 267
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getEntitlmentResponse()Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->getUplynkData()Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;->getHost()Ljava/lang/String;

    move-result-object v4

    .line 268
    .local v4, "uplynkHost":Ljava/lang/String;
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getEntitlmentResponse()Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->getUplynkData()Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;->getSessionId()Ljava/lang/String;

    move-result-object v3

    .line 270
    .local v3, "sessionId":Ljava/lang/String;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 272
    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    invoke-direct {v5, p0, v4, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    .line 273
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->needsPing:Z

    .line 277
    .end local v3    # "sessionId":Ljava/lang/String;
    .end local v4    # "uplynkHost":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->setPlayManifest(Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V

    .line 278
    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;->getAdCollection()Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdCollection;->getAdbreak()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .line 280
    .local v0, "adbreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v5, v0}, Ljava/util/LinkedHashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 283
    .end local v0    # "adbreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    :cond_1
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    const-string v6, "manifest file returned and cues inserted"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    :goto_1
    return-void

    .line 285
    .restart local v2    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    :cond_2
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    const-string v6, "manifest file returned with no ad cues"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 288
    .end local v2    # "manifestResponse":Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;
    :cond_3
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    const-string v6, "manifest file returned null"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private startProgressionTimer()V
    .locals 6

    .prologue
    .line 547
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->stopProgressionTimer()V

    .line 548
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->progressionTimer:Ljava/util/Timer;

    .line 549
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->progressionTimer:Ljava/util/Timer;

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$ProgressionTask;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1f4

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 550
    return-void
.end method

.method private stopProgressionTimer()V
    .locals 1

    .prologue
    .line 553
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->progressionTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 554
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->progressionTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 555
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->progressionTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 557
    :cond_0
    return-void
.end method


# virtual methods
.method protected enteredAd(Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;)V
    .locals 7
    .param p1, "adAsset"    # Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    .prologue
    const/high16 v6, 0x447a0000    # 1000.0f

    .line 697
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    if-eqz v1, :cond_1

    if-eqz p1, :cond_1

    .line 698
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    .line 699
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 700
    .local v0, "bundle":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 701
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_TYPE:Ljava/lang/String;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 703
    :cond_0
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_DURATION:Ljava/lang/String;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getDuration()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 704
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_TOTAL_ADS:Ljava/lang/String;

    iget v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdTotal:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 705
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_INDEX:Ljava/lang/String;

    iget v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdIndex:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 706
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_START:Ljava/lang/String;

    invoke-virtual {p0, v1, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendMetadataEvent(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 707
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AD_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 708
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "VODMediaPlayer: enteredAd "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getStart()F

    move-result v3

    mul-float/2addr v3, v6

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getEnd()F

    move-result v3

    mul-float/2addr v3, v6

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 710
    .end local v0    # "bundle":Landroid/os/Bundle;
    :cond_1
    return-void
.end method

.method protected enteredAdBreak(Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;)V
    .locals 5
    .param p1, "adBreak"    # Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .prologue
    const/high16 v4, 0x447a0000    # 1000.0f

    .line 673
    if-eqz p1, :cond_0

    .line 674
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .line 675
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->resetCurrentAd()V

    .line 676
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->setAdEventStarted(Z)V

    .line 677
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_BREAK_START:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 678
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AD_BREAK_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 679
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "VODMediaPlayer: enteredAdBreak "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v2

    mul-float/2addr v2, v4

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v2

    mul-float/2addr v2, v4

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 681
    :cond_0
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->printAdBreakStatus()V

    .line 682
    return-void
.end method

.method protected getAdBreakBeforeTime(I)Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    .locals 11
    .param p1, "msec"    # I

    .prologue
    const/high16 v10, 0x447a0000    # 1000.0f

    .line 649
    const/4 v1, 0x0

    .line 650
    .local v1, "curAdBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    if-eqz v6, :cond_0

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v6}, Ljava/util/LinkedHashSet;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 651
    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v6}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .line 652
    .local v0, "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v6

    mul-float/2addr v6, v10

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-float v4, v6

    .line 653
    .local v4, "start":F
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v6

    mul-float/2addr v6, v10

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-float v2, v6

    .line 654
    .local v2, "end":F
    if-eqz v1, :cond_2

    int-to-float v6, p1

    cmpg-float v6, v6, v4

    if-gez v6, :cond_2

    int-to-float v6, p1

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v7

    mul-float/2addr v7, v10

    float-to-double v8, v7

    invoke-static {v8, v9}, Ljava/lang/Math;->floor(D)D

    move-result-wide v8

    double-to-float v7, v8

    cmpl-float v6, v6, v7

    if-lez v6, :cond_2

    .line 663
    .end local v0    # "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    .end local v2    # "end":F
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "start":F
    :cond_0
    if-eqz v1, :cond_1

    .line 664
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v6

    mul-float/2addr v6, v10

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-float v4, v6

    .line 665
    .restart local v4    # "start":F
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v6

    mul-float/2addr v6, v10

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-float v2, v6

    .line 666
    .restart local v2    # "end":F
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->isWatched()Z

    move-result v5

    .line 667
    .local v5, "watched":Z
    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "VODMediaPlayer: getAdBreakBeforeTime: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " curAdBreak.watched: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " curAdBreak.start: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " curAdBreak.end: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 669
    .end local v2    # "end":F
    .end local v4    # "start":F
    .end local v5    # "watched":Z
    :cond_1
    return-object v1

    .line 659
    .restart local v0    # "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    .restart local v2    # "end":F
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "start":F
    :cond_2
    move-object v1, v0

    .line 661
    goto/16 :goto_0
.end method

.method protected isCurrentTimeInAdBreak(I)Z
    .locals 11
    .param p1, "msec"    # I

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    const/high16 v8, 0x447a0000    # 1000.0f

    .line 611
    move v1, p1

    .line 612
    .local v1, "currentPosition":I
    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    if-eqz v6, :cond_3

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v6}, Ljava/util/LinkedHashSet;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_3

    .line 613
    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v6}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .line 614
    .local v0, "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v6

    mul-float/2addr v6, v8

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-float v5, v6

    .line 615
    .local v5, "start":F
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v6

    mul-float/2addr v6, v8

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-float v2, v6

    .line 616
    .local v2, "end":F
    int-to-float v6, v1

    cmpl-float v6, v6, v5

    if-ltz v6, :cond_0

    int-to-float v6, v1

    cmpg-float v6, v6, v2

    if-gez v6, :cond_0

    .line 617
    iget-boolean v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    if-nez v6, :cond_1

    .line 618
    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->enteredAdBreak(Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;)V

    .line 620
    :cond_1
    iput-boolean v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    .line 621
    iput-boolean v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->seekAllowed:Z

    .line 622
    iget-boolean v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    if-eqz v6, :cond_2

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-eqz v6, :cond_2

    .line 623
    invoke-virtual {p0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendAdInfoCurrentAdBreak(I)V

    .line 626
    :cond_2
    iget-boolean v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    .line 645
    .end local v0    # "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    .end local v2    # "end":F
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v5    # "start":F
    :goto_0
    return v6

    .line 630
    :cond_3
    iput-boolean v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->seekAllowed:Z

    .line 631
    iget-boolean v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    if-eqz v6, :cond_4

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-eqz v6, :cond_4

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->isAdEventStarted()Z

    move-result v6

    if-eqz v6, :cond_4

    int-to-float v6, v1

    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v7

    mul-float/2addr v7, v8

    float-to-double v8, v7

    invoke-static {v8, v9}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v8

    double-to-float v7, v8

    cmpl-float v6, v6, v7

    if-ltz v6, :cond_4

    .line 635
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->leftAd()V

    .line 636
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->leftAdBreak()V

    .line 637
    iget v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->timeToSeekToAfterUnlockingAdBreak:I

    if-ltz v6, :cond_4

    .line 638
    iget v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->timeToSeekToAfterUnlockingAdBreak:I

    .line 639
    .local v4, "seekTo":I
    invoke-virtual {p0, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->seekTo(I)V

    .line 640
    const/4 v6, -0x1

    iput v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->timeToSeekToAfterUnlockingAdBreak:I

    .line 643
    .end local v4    # "seekTo":I
    :cond_4
    iput-boolean v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    .line 645
    iget-boolean v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    goto :goto_0
.end method

.method protected leftAd()V
    .locals 7

    .prologue
    const/high16 v6, 0x447a0000    # 1000.0f

    .line 713
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    if-eqz v1, :cond_1

    .line 714
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "VODMediaPlayer: leftAd "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getStart()F

    move-result v3

    mul-float/2addr v3, v6

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getEnd()F

    move-result v3

    mul-float/2addr v3, v6

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 715
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 716
    .local v0, "bundle":Landroid/os/Bundle;
    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 717
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_TYPE:Ljava/lang/String;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 719
    :cond_0
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_DURATION:Ljava/lang/String;

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getDuration()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 720
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_TOTAL_ADS:Ljava/lang/String;

    iget v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdTotal:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 721
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->ADINFO_AD_INDEX:Ljava/lang/String;

    iget v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdIndex:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 722
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_END:Ljava/lang/String;

    invoke-virtual {p0, v1, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendMetadataEvent(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 723
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AD_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 725
    .end local v0    # "bundle":Landroid/os/Bundle;
    :cond_1
    return-void
.end method

.method protected leftAdBreak()V
    .locals 5

    .prologue
    const/high16 v4, 0x447a0000    # 1000.0f

    .line 685
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-eqz v0, :cond_0

    .line 686
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "VODMediaPlayer: leftAdBreak "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v2

    mul-float/2addr v2, v4

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v2}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v2

    mul-float/2addr v2, v4

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 687
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->setWatched(Z)V

    .line 688
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .line 689
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->resetCurrentAd()V

    .line 690
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_AD_BREAK_END:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 691
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->AD_BREAK_END:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;)V

    .line 693
    :cond_0
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->printAdBreakStatus()V

    .line 694
    return-void
.end method

.method public onCaptionEvent(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/CaptionEvent;)Z
    .locals 4
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "event"    # Lcom/uplynk/media/CaptionEvent;

    .prologue
    .line 533
    if-eqz p2, :cond_0

    iget-boolean v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->closeCaptionsOn:Z

    if-eqz v2, :cond_0

    .line 535
    iget-object v1, p2, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    .line 536
    .local v1, "captionEvent":Lcom/uplynk/media/CaptionEvent$CaptionEventType;
    if-eqz v1, :cond_0

    .line 538
    const-string v2, "00:00:00"

    const-string v3, "00:00:00"

    invoke-static {p2, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionUtils;->parseEvent(Lcom/uplynk/media/CaptionEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;

    move-result-object v0

    .line 539
    .local v0, "captionData":Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;->getWebVTT()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTimedText(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;)V

    .line 540
    const/4 v2, 0x1

    .line 543
    .end local v0    # "captionData":Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
    .end local v1    # "captionEvent":Lcom/uplynk/media/CaptionEvent$CaptionEventType;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public onCompletion(Lcom/uplynk/media/MediaPlayer;)V
    .locals 1
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;

    .prologue
    .line 425
    invoke-super {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onCompletion(Lcom/uplynk/media/MediaPlayer;)V

    .line 426
    iget-boolean v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->loop:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 427
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v0}, Lcom/uplynk/media/MediaPlayer;->start()V

    .line 429
    :cond_0
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->stopProgressionTimer()V

    .line 430
    return-void
.end method

.method public onError(Lcom/uplynk/media/MediaPlayer;II)Z
    .locals 8
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 435
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 436
    .local v0, "bundle":Landroid/os/Bundle;
    const/16 v3, 0x64

    if-ne p2, v3, :cond_0

    .line 437
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v3}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getReason()Ljava/lang/String;

    move-result-object v3

    const-string v4, "[video id]"

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 438
    .local v2, "message":Ljava/lang/String;
    const-string v3, "trackCode"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 440
    const-string v3, "lf:video playback:%s"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 441
    .local v1, "errorMessage":Ljava/lang/String;
    const-string v3, "error"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 451
    :goto_0
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->MEDIA_ERROR:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v3, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    .line 452
    invoke-super {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onError(Lcom/uplynk/media/MediaPlayer;II)Z

    .line 453
    return v6

    .line 444
    .end local v1    # "errorMessage":Ljava/lang/String;
    .end local v2    # "message":Ljava/lang/String;
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "unknown:vodplayer:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 445
    .restart local v2    # "message":Ljava/lang/String;
    const-string v3, "trackCode"

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 447
    const-string v3, "lf:video playback:%s"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 448
    .restart local v1    # "errorMessage":Ljava/lang/String;
    const-string v3, "error"

    invoke-virtual {v0, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onUplynkMetadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)Z
    .locals 8
    .param p1, "mp"    # Lcom/uplynk/media/MediaPlayer;
    .param p2, "uplynkMetadata"    # Lcom/uplynk/media/MediaPlayer$UplynkMetadata;

    .prologue
    const/4 v4, 0x0

    const/4 v7, -0x1

    .line 461
    invoke-super {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->onUplynkMetadata(Lcom/uplynk/media/MediaPlayer;Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)Z

    .line 462
    iget-boolean v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->processNextAsset:Z

    if-eqz v5, :cond_2

    .line 464
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetID()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAssetId:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAssetId:Ljava/lang/String;

    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetID()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 468
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 469
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v5

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getCurrentMetadata()Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;

    move-result-object v5

    invoke-virtual {v5, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->setUplynkMetadata(Lcom/uplynk/media/MediaPlayer$UplynkMetadata;)V

    .line 472
    :cond_0
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    const-string v6, "processing uplynk metadata"

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 474
    invoke-virtual {p2}, Lcom/uplynk/media/MediaPlayer$UplynkMetadata;->getAssetInfo()Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;

    move-result-object v2

    .line 475
    .local v2, "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    if-eqz v2, :cond_2

    .line 477
    invoke-virtual {v2}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->isAd()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 521
    :cond_1
    :goto_0
    iput-boolean v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->processNextAsset:Z

    .line 522
    const/4 v4, 0x1

    .line 527
    .end local v2    # "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_2
    return v4

    .line 498
    .restart local v2    # "tempAssetInfo":Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;
    :cond_3
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAssetId:Ljava/lang/String;

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentProgramId:Ljava/lang/String;

    invoke-static {v5, v6}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 500
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaMetadata;->BOUNDARY_EVENT_PROGRAM_START:Ljava/lang/String;

    invoke-virtual {p0, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendMetadataEvent(Ljava/lang/String;)V

    .line 501
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 502
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v5, "start_video"

    const-string v6, ""

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 503
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v5, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    .line 505
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAssetId:Ljava/lang/String;

    iput-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentProgramId:Ljava/lang/String;

    .line 506
    invoke-virtual {v2}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getTvRating()I

    move-result v3

    .line 507
    .local v3, "tvrating":I
    invoke-virtual {v2}, Lcom/uplynk/media/MediaPlayer$UplynkAssetInfo;->getMovieRating()I

    move-result v1

    .line 508
    .local v1, "movierating":I
    if-eq v3, v7, :cond_4

    iput v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentRating:I

    .line 509
    :cond_4
    if-eq v1, v7, :cond_1

    iput v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentRating:I

    goto :goto_0

    .line 514
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v1    # "movierating":I
    .end local v3    # "tvrating":I
    :cond_5
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 515
    .restart local v0    # "bundle":Landroid/os/Bundle;
    const-string v5, "start_video"

    const-string v6, ""

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 516
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;->PROGRAM_START:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;

    invoke-virtual {p0, v5, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->sendTrackable(Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public pause()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 332
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->pause()V

    .line 333
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 340
    :goto_0
    return-void

    .line 335
    :pswitch_0
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->stopProgressionTimer()V

    goto :goto_0

    .line 333
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected printAdBreakStatus()V
    .locals 6

    .prologue
    const/high16 v5, 0x447a0000    # 1000.0f

    .line 602
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "VODMediaPlayer: isCurrentTimeInAdBreak: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentPosition()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " inAd: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-boolean v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->inAd:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 603
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    if-eqz v2, :cond_0

    .line 604
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->adCues:Ljava/util/LinkedHashSet;

    invoke-virtual {v2}, Ljava/util/LinkedHashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    .line 605
    .local v0, "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "VODMediaPlayer: AdBreak"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getNum()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " watched:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->isWatched()Z

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " started:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->isAdEventStarted()Z

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " start:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v4

    mul-float/2addr v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " end:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v4

    mul-float/2addr v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 608
    .end local v0    # "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public reset()V
    .locals 2

    .prologue
    .line 401
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->reset()V

    .line 402
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 409
    :goto_0
    return-void

    .line 404
    :pswitch_0
    const/4 v0, 0x0

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->omnitureTagFiredForWatchedPercentage:I

    goto :goto_0

    .line 402
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected resetCurrentAd()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 568
    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdTotal:I

    .line 569
    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdIndex:I

    .line 570
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    .line 571
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    .line 572
    return-void
.end method

.method public seekTo(I)V
    .locals 9
    .param p1, "msec"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/high16 v8, 0x447a0000    # 1000.0f

    .line 344
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 396
    :cond_0
    :goto_0
    return-void

    .line 346
    :pswitch_0
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    if-eqz v5, :cond_4

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->canSeek()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 348
    move v3, p1

    .line 349
    .local v3, "seekTo":I
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "VODMediaPlayer: seekTo: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    invoke-virtual {p0, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getAdBreakBeforeTime(I)Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    move-result-object v0

    .line 352
    .local v0, "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->isWatched()Z

    move-result v5

    if-nez v5, :cond_3

    .line 354
    iget v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->timeToSeekToAfterUnlockingAdBreak:I

    if-gez v5, :cond_1

    .line 355
    iput v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->timeToSeekToAfterUnlockingAdBreak:I

    .line 357
    :cond_1
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getStart()F

    move-result v5

    mul-float/2addr v5, v8

    float-to-double v6, v5

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-float v4, v6

    .line 359
    .local v4, "start":F
    int-to-float v5, p1

    cmpg-float v5, v4, v5

    if-gez v5, :cond_2

    .line 360
    float-to-int v3, v4

    .line 361
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->seekAllowed:Z

    .line 370
    .end local v4    # "start":F
    :cond_2
    :goto_1
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "VODMediaPlayer: uplynkMediaPlayerSeekTo: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 371
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->uplynkMediaPlayer:Lcom/uplynk/media/MediaPlayer;

    invoke-virtual {v5, v3}, Lcom/uplynk/media/MediaPlayer;->seekTo(I)V

    .line 372
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    if-eqz v5, :cond_0

    .line 375
    :try_start_0
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->pingUplynk:Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;

    div-int/lit16 v6, v3, 0x3e8

    const-string v7, "seek"

    invoke-virtual {v5, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$PingUplynk;->ping(ILjava/lang/String;)Ljava/util/concurrent/Future;

    move-result-object v5

    const-wide/16 v6, 0x5

    sget-object v8, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v5, v6, v7, v8}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iput v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->nextPingTime:I
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2

    goto/16 :goto_0

    .line 376
    :catch_0
    move-exception v1

    .line 377
    .local v1, "e":Ljava/lang/InterruptedException;
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 363
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :cond_3
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->isWatched()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 364
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getEnd()F

    move-result v5

    mul-float/2addr v5, v8

    float-to-double v6, v5

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-float v2, v6

    .line 365
    .local v2, "end":F
    int-to-float v5, v3

    cmpg-float v5, v5, v2

    if-gez v5, :cond_2

    .line 366
    float-to-int v3, v2

    goto :goto_1

    .line 378
    .end local v2    # "end":F
    :catch_1
    move-exception v1

    .line 379
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 380
    .end local v1    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_2
    move-exception v1

    .line 381
    .local v1, "e":Ljava/util/concurrent/TimeoutException;
    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->TAG:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 386
    .end local v0    # "adBreak":Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;
    .end local v1    # "e":Ljava/util/concurrent/TimeoutException;
    .end local v3    # "seekTo":I
    :cond_4
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getOnInfoListener()Landroid/media/MediaPlayer$OnInfoListener;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 387
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getOnInfoListener()Landroid/media/MediaPlayer$OnInfoListener;

    move-result-object v5

    const/16 v6, 0x321

    sget-object v7, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SEEK_DISABLED:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->getErrorCode()I

    move-result v7

    invoke-interface {v5, p0, v6, v7}, Landroid/media/MediaPlayer$OnInfoListener;->onInfo(Landroid/media/MediaPlayer;II)Z

    goto/16 :goto_0

    .line 393
    :pswitch_1
    invoke-super {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->seekTo(I)V

    goto/16 :goto_0

    .line 344
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected sendAdInfoCurrentAdBreak(I)V
    .locals 11
    .param p1, "msec"    # I

    .prologue
    const/high16 v10, 0x447a0000    # 1000.0f

    .line 575
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    if-eqz v7, :cond_4

    .line 576
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getAdgroup()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    .line 577
    .local v1, "ads":Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getAdgroup()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v3

    .line 578
    .local v3, "i":I
    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;->getAd()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    .line 579
    .local v0, "adAsset":Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getStart()F

    move-result v7

    mul-float/2addr v7, v10

    float-to-double v8, v7

    invoke-static {v8, v9}, Ljava/lang/Math;->floor(D)D

    move-result-wide v8

    double-to-float v6, v8

    .line 580
    .local v6, "start":F
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;->getEnd()F

    move-result v7

    mul-float/2addr v7, v10

    float-to-double v8, v7

    invoke-static {v8, v9}, Ljava/lang/Math;->floor(D)D

    move-result-wide v8

    double-to-float v2, v8

    .line 581
    .local v2, "end":F
    int-to-float v7, p1

    cmpl-float v7, v7, v6

    if-ltz v7, :cond_1

    int-to-float v7, p1

    cmpg-float v7, v7, v2

    if-gtz v7, :cond_1

    .line 582
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdGroup:Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;

    .line 583
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getAdgroup()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    iget v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdTotal:I

    if-ne v7, v8, :cond_2

    add-int/lit8 v7, v3, 0x1

    iget v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdIndex:I

    if-eq v7, v8, :cond_4

    .line 585
    :cond_2
    iget v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdTotal:I

    if-eqz v7, :cond_3

    iget v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdIndex:I

    if-eqz v7, :cond_3

    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAd:Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;

    if-eqz v7, :cond_3

    .line 588
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->leftAd()V

    .line 590
    :cond_3
    iget-object v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdBreak:Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;

    invoke-virtual {v7}, Lcom/disney/datg/videoplatforms/sdk/models/api/AdBreak;->getAdgroup()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    iput v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdTotal:I

    .line 591
    add-int/lit8 v7, v3, 0x1

    iput v7, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentAdIndex:I

    .line 592
    invoke-virtual {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->enteredAd(Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;)V

    .line 599
    .end local v0    # "adAsset":Lcom/disney/datg/videoplatforms/sdk/models/api/AdAsset;
    .end local v1    # "ads":Lcom/disney/datg/videoplatforms/sdk/models/api/Ads;
    .end local v2    # "end":F
    .end local v3    # "i":I
    .end local v5    # "i$":Ljava/util/Iterator;
    .end local v6    # "start":F
    :cond_4
    return-void
.end method

.method public setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 5
    .param p1, "media"    # Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;",
            "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 227
    .local p2, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;, "Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 228
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_INVALID_MEDIA_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v4, "valid Media object must be set"

    invoke-direct {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 231
    :cond_0
    invoke-virtual {p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;->getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    move-result-object v1

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    if-eq v1, v2, :cond_1

    .line 232
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v4, "Media must be a VOD type"

    invoke-direct {v2, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 236
    :cond_1
    invoke-super {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDataSource(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;Lcom/disney/datg/videoplatforms/sdk/common/AsyncHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    .line 241
    .local v0, "returnVal":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Ljava/lang/Boolean;>;"
    return-object v0
.end method

.method public setDataSource(Ljava/lang/String;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 247
    invoke-super {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 248
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->getCurrentMedia()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->configurePlayManifest(Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;)V

    .line 249
    return-void
.end method

.method public setLooping(Z)V
    .locals 2
    .param p1, "looping"    # Z

    .prologue
    .line 413
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 421
    :goto_0
    return-void

    .line 415
    :pswitch_0
    iput-boolean p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->loop:Z

    goto :goto_0

    .line 418
    :pswitch_1
    invoke-super {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->setLooping(Z)V

    goto :goto_0

    .line 413
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setPlayManifest(Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;)V
    .locals 0
    .param p1, "playManifest"    # Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .prologue
    .line 564
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->playManifest:Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    .line 565
    return-void
.end method

.method public start()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 296
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->start()V

    .line 297
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 305
    :goto_0
    return-void

    .line 299
    :pswitch_0
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->startProgressionTimer()V

    goto :goto_0

    .line 297
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 319
    invoke-super {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;->stop()V

    .line 320
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType:[I

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->currentPlayerType:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$BasePlayerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 327
    :goto_0
    return-void

    .line 322
    :pswitch_0
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VODMediaPlayer;->stopProgressionTimer()V

    goto :goto_0

    .line 320
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
