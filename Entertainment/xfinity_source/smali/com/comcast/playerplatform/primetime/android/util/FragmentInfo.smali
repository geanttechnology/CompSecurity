.class public Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;
.super Ljava/lang/Object;
.source "FragmentInfo.java"


# instance fields
.field private downloadDuration:J

.field private downloadLatency:J

.field private fragmentDuration:J

.field private fragmentSize:J

.field private numberOfFragments:I


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->numberOfFragments:I

    .line 9
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentSize:J

    .line 10
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadLatency:J

    .line 11
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadDuration:J

    .line 12
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentDuration:J

    return-void
.end method


# virtual methods
.method public addFragment(JJJ)V
    .locals 3
    .param p1, "downloadDuration"    # J
    .param p3, "mediaDuration"    # J
    .param p5, "size"    # J

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadDuration:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadDuration:J

    .line 48
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentSize:J

    add-long/2addr v0, p5

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentSize:J

    .line 49
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentDuration:J

    add-long/2addr v0, p3

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentDuration:J

    .line 50
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->numberOfFragments:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->numberOfFragments:I

    .line 51
    return-void
.end method

.method public getDownloadDuration()J
    .locals 2

    .prologue
    .line 27
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadDuration:J

    return-wide v0
.end method

.method public getDownloadLatency()J
    .locals 2

    .prologue
    .line 23
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadLatency:J

    return-wide v0
.end method

.method public getFragmentDuration()J
    .locals 2

    .prologue
    .line 31
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentDuration:J

    return-wide v0
.end method

.method public getFragmentSize()J
    .locals 2

    .prologue
    .line 19
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentSize:J

    return-wide v0
.end method

.method public getNumberOfFragments()I
    .locals 1

    .prologue
    .line 15
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->numberOfFragments:I

    return v0
.end method

.method public reset()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 35
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->numberOfFragments:I

    if-nez v0, :cond_0

    .line 44
    :goto_0
    return-void

    .line 39
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->numberOfFragments:I

    .line 40
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentSize:J

    .line 41
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadLatency:J

    .line 42
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->downloadDuration:J

    .line 43
    iput-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;->fragmentDuration:J

    goto :goto_0
.end method
