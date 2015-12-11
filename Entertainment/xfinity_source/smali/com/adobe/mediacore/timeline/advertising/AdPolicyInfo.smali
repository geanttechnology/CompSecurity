.class public final Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;
.super Ljava/lang/Object;


# instance fields
.field private _ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

.field private _adBreakPlacements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation
.end field

.field private _currentTime:J

.field private _mode:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

.field private _rate:F

.field private _seekToTime:J


# direct methods
.method public constructor <init>(Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/Ad;JJFLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            "JJF",
            "Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;",
            ")V"
        }
    .end annotation

    const-wide/16 v2, 0x0

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_adBreakPlacements:Ljava/util/List;

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    iput-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_currentTime:J

    iput-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_seekToTime:J

    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_rate:F

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_mode:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_adBreakPlacements:Ljava/util/List;

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    iput-wide p3, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_currentTime:J

    iput-wide p5, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_seekToTime:J

    iput p7, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_rate:F

    iput-object p8, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_mode:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    return-void
.end method


# virtual methods
.method public getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getAdBreakPlacements()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_adBreakPlacements:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_currentTime:J

    return-wide v0
.end method

.method public getMode()Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_mode:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    return-object v0
.end method

.method public getRate()F
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_rate:F

    return v0
.end method

.method public getSeekToTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_seekToTime:J

    return-wide v0
.end method

.method public setAd(Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-void
.end method

.method public setAdBreakPlacements(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_adBreakPlacements:Ljava/util/List;

    return-void
.end method

.method public setCurrentTime(J)V
    .locals 1

    iput-wide p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_currentTime:J

    return-void
.end method

.method public setMode(Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_mode:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    return-void
.end method

.method public setRate(F)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_rate:F

    return-void
.end method

.method public setSeekToTime(J)V
    .locals 1

    iput-wide p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;->_seekToTime:J

    return-void
.end method
