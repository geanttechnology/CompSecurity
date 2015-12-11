.class final Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/VideoEngineTimeline;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "InsertedAd"
.end annotation


# instance fields
.field private _ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

.field private _handle:Lcom/adobe/mediacore/AdHandle;

.field private _index:I

.field private _replaceDuration:J

.field private _timeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

.field final synthetic this$0:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineTimeline;ILcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Lcom/adobe/mediacore/AdHandle;Lcom/adobe/mediacore/timeline/advertising/Ad;J)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_index:I

    iput-object p3, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_timeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iput-object p4, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_handle:Lcom/adobe/mediacore/AdHandle;

    iput-object p5, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    iput-wide p6, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_replaceDuration:J

    return-void
.end method


# virtual methods
.method public getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getAdHandle()Lcom/adobe/mediacore/AdHandle;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_handle:Lcom/adobe/mediacore/AdHandle;

    return-object v0
.end method

.method public getIndex()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_index:I

    return v0
.end method

.method public getReplaceDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_replaceDuration:J

    return-wide v0
.end method

.method public getTimeMapping()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->_timeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    return-object v0
.end method
