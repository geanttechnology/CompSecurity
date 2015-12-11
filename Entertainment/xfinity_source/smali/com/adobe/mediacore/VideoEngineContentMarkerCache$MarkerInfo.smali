.class Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/VideoEngineContentMarkerCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MarkerInfo"
.end annotation


# instance fields
.field private final _contentId:I

.field private final _duration:J

.field private _eventDispatched:Z

.field private final _timestamp:J


# direct methods
.method public constructor <init>(IJJ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide p2, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_timestamp:J

    iput p1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_contentId:I

    iput-wide p4, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_duration:J

    return-void
.end method


# virtual methods
.method public getContentId()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_contentId:I

    return v0
.end method

.method getDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_duration:J

    return-wide v0
.end method

.method public getTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_timestamp:J

    return-wide v0
.end method

.method public isEventDispatched()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_eventDispatched:Z

    return v0
.end method

.method public setEventDispatched(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->_eventDispatched:Z

    return-void
.end method
