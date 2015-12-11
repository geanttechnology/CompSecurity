.class public Lcom/adobe/ave/Timeline;
.super Ljava/lang/Object;
.source "Timeline.java"


# instance fields
.field public complete:I

.field public firstPeriodIndex:I

.field public firstSubscribedTagIndex:I

.field public lastPeriodIndex:I

.field public lastSubscribedTagIndex:I

.field private mNativeContext:J

.field public type:Lcom/adobe/ave/ContainerType;

.field public virtualDuration:J

.field public virtualStartTime:J


# direct methods
.method private constructor <init>(J)V
    .locals 1
    .param p1, "nativeContext"    # J

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-wide p1, p0, Lcom/adobe/ave/Timeline;->mNativeContext:J

    .line 49
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Timeline;->nativeCreateTimeline(J)V

    .line 50
    return-void
.end method

.method private constructor <init>(JIIJJIIII)V
    .locals 7
    .param p1, "nativeContext"    # J
    .param p3, "aType"    # I
    .param p4, "aComplete"    # I
    .param p5, "aVirtualStartTime"    # J
    .param p7, "aVirtualDuration"    # J
    .param p9, "aFirstPeriodIndex"    # I
    .param p10, "aLastPeriodIndex"    # I
    .param p11, "aFirstSubscribedTagIndex"    # I
    .param p12, "aLastSubscribedTagIndex"    # I

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-wide p1, p0, Lcom/adobe/ave/Timeline;->mNativeContext:J

    .line 60
    sget-object v2, Lcom/adobe/ave/ContainerType;->UNDEFINED:Lcom/adobe/ave/ContainerType;

    .line 61
    .local v2, "typeToSet":Lcom/adobe/ave/ContainerType;
    invoke-static {}, Lcom/adobe/ave/ContainerType;->values()[Lcom/adobe/ave/ContainerType;

    move-result-object v4

    array-length v5, v4

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v1, v4, v3

    .line 63
    .local v1, "c":Lcom/adobe/ave/ContainerType;
    invoke-virtual {v1}, Lcom/adobe/ave/ContainerType;->getValue()I

    move-result v6

    if-ne v6, p3, :cond_1

    .line 65
    move-object v2, v1

    .line 69
    .end local v1    # "c":Lcom/adobe/ave/ContainerType;
    :cond_0
    iput-object v2, p0, Lcom/adobe/ave/Timeline;->type:Lcom/adobe/ave/ContainerType;

    .line 71
    iput p4, p0, Lcom/adobe/ave/Timeline;->complete:I

    .line 72
    iput-wide p5, p0, Lcom/adobe/ave/Timeline;->virtualStartTime:J

    .line 73
    iput-wide p7, p0, Lcom/adobe/ave/Timeline;->virtualDuration:J

    .line 74
    move/from16 v0, p9

    iput v0, p0, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    .line 75
    move/from16 v0, p10

    iput v0, p0, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    .line 76
    move/from16 v0, p11

    iput v0, p0, Lcom/adobe/ave/Timeline;->firstSubscribedTagIndex:I

    .line 77
    move/from16 v0, p12

    iput v0, p0, Lcom/adobe/ave/Timeline;->lastSubscribedTagIndex:I

    .line 79
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Timeline;->nativeCreateTimeline(J)V

    .line 80
    return-void

    .line 61
    .restart local v1    # "c":Lcom/adobe/ave/ContainerType;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method private native nativeCreateTimeline(J)V
.end method

.method private native nativeEraseByLocalTime(IJJZ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeEraseByVirtualTime(JJ)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetABRProfileCount(I)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetABRProfileInfoAtIndex(II)Lcom/adobe/ave/ABRProfileInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetCuePoint(II)Lcom/adobe/ave/CuePoint;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetMainManifestSubscribedTag(I)Lcom/adobe/ave/TagData;
.end method

.method private native nativeGetPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetSubscribedTag(II)Lcom/adobe/ave/TagData;
.end method

.method private native nativeGetTrackCount(II)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeGetTrackInfo(III)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeInsertByLocalTime(IJIIJ)Lcom/adobe/ave/InsertionResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeInsertByVirtualTime(JIIJ)Lcom/adobe/ave/InsertionResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeLoadManifest(Ljava/lang/String;II)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeReleaseManifest(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation
.end method

.method private native nativeSetHoldAt(J)V
.end method


# virtual methods
.method public eraseByLocalTime(IJJZ)V
    .locals 0
    .param p1, "periodIndex"    # I
    .param p2, "localTimeStart"    # J
    .param p4, "localTimeEnd"    # J
    .param p6, "replaceWithMainMedia"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 307
    invoke-direct/range {p0 .. p6}, Lcom/adobe/ave/Timeline;->nativeEraseByLocalTime(IJJZ)V

    .line 308
    return-void
.end method

.method public eraseByVirtualTime(JJ)V
    .locals 1
    .param p1, "virtualTimeStart"    # J
    .param p3, "virtualTimeEnd"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 289
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/adobe/ave/Timeline;->nativeEraseByVirtualTime(JJ)V

    .line 290
    return-void
.end method

.method public getABRProfileCount(I)I
    .locals 1
    .param p1, "periodIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 143
    invoke-direct {p0, p1}, Lcom/adobe/ave/Timeline;->nativeGetABRProfileCount(I)I

    move-result v0

    return v0
.end method

.method public getABRProfileInfoAtIndex(II)Lcom/adobe/ave/ABRProfileInfo;
    .locals 1
    .param p1, "periodIndex"    # I
    .param p2, "abrProfileIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 156
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Timeline;->nativeGetABRProfileInfoAtIndex(II)Lcom/adobe/ave/ABRProfileInfo;

    move-result-object v0

    return-object v0
.end method

.method public getCuePoint(II)Lcom/adobe/ave/CuePoint;
    .locals 1
    .param p1, "periodIndex"    # I
    .param p2, "cuePointIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 320
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Timeline;->nativeGetCuePoint(II)Lcom/adobe/ave/CuePoint;

    move-result-object v0

    return-object v0
.end method

.method public getMainManifestSubscribedTag(I)Lcom/adobe/ave/TagData;
    .locals 1
    .param p1, "subscribedTagIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 347
    invoke-direct {p0, p1}, Lcom/adobe/ave/Timeline;->nativeGetMainManifestSubscribedTag(I)Lcom/adobe/ave/TagData;

    move-result-object v0

    return-object v0
.end method

.method public getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;
    .locals 1
    .param p1, "periodIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 132
    invoke-direct {p0, p1}, Lcom/adobe/ave/Timeline;->nativeGetPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v0

    return-object v0
.end method

.method public getSubscribedTag(II)Lcom/adobe/ave/TagData;
    .locals 1
    .param p1, "periodIndex"    # I
    .param p2, "subscribedTagIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 334
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Timeline;->nativeGetSubscribedTag(II)Lcom/adobe/ave/TagData;

    move-result-object v0

    return-object v0
.end method

.method public getTrackCount(ILcom/adobe/ave/PayloadType;)I
    .locals 1
    .param p1, "periodIndex"    # I
    .param p2, "type"    # Lcom/adobe/ave/PayloadType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 169
    invoke-virtual {p2}, Lcom/adobe/ave/PayloadType;->getValue()I

    move-result v0

    invoke-direct {p0, p1, v0}, Lcom/adobe/ave/Timeline;->nativeGetTrackCount(II)I

    move-result v0

    return v0
.end method

.method public getTrackInfo(IILcom/adobe/ave/PayloadType;)Ljava/lang/Object;
    .locals 1
    .param p1, "periodIndex"    # I
    .param p2, "trackIndex"    # I
    .param p3, "type"    # Lcom/adobe/ave/PayloadType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 187
    invoke-virtual {p3}, Lcom/adobe/ave/PayloadType;->getValue()I

    move-result v0

    invoke-direct {p0, p1, p2, v0}, Lcom/adobe/ave/Timeline;->nativeGetTrackInfo(III)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public insertByLocalTime(IJIIJ)Lcom/adobe/ave/InsertionResult;
    .locals 2
    .param p1, "periodIndex"    # I
    .param p2, "localInsertionTime"    # J
    .param p4, "handle"    # I
    .param p5, "userData"    # I
    .param p6, "replaceDuration"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 274
    invoke-direct/range {p0 .. p7}, Lcom/adobe/ave/Timeline;->nativeInsertByLocalTime(IJIIJ)Lcom/adobe/ave/InsertionResult;

    move-result-object v0

    return-object v0
.end method

.method public insertByVirtualTime(JIIJ)Lcom/adobe/ave/InsertionResult;
    .locals 1
    .param p1, "insertionTime"    # J
    .param p3, "handle"    # I
    .param p4, "userData"    # I
    .param p5, "replaceDuration"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 251
    invoke-direct/range {p0 .. p6}, Lcom/adobe/ave/Timeline;->nativeInsertByVirtualTime(JIIJ)Lcom/adobe/ave/InsertionResult;

    move-result-object v0

    return-object v0
.end method

.method public loadManifest(Ljava/lang/String;ILcom/adobe/ave/ContainerType;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "userData"    # I
    .param p3, "containerType"    # Lcom/adobe/ave/ContainerType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 204
    invoke-virtual {p3}, Lcom/adobe/ave/ContainerType;->getValue()I

    move-result v0

    invoke-direct {p0, p1, p2, v0}, Lcom/adobe/ave/Timeline;->nativeLoadManifest(Ljava/lang/String;II)V

    .line 205
    return-void
.end method

.method public releaseManifest(I)V
    .locals 0
    .param p1, "handle"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 215
    invoke-direct {p0, p1}, Lcom/adobe/ave/Timeline;->nativeReleaseManifest(I)V

    .line 216
    return-void
.end method

.method public setHoldAt(J)V
    .locals 1
    .param p1, "holdTime"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    .prologue
    .line 228
    invoke-direct {p0, p1, p2}, Lcom/adobe/ave/Timeline;->nativeSetHoldAt(J)V

    .line 229
    return-void
.end method
