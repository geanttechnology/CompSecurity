.class public Lco/vine/android/recorder/RecordSession;
.super Ljava/lang/Object;
.source "RecordSession.java"

# interfaces
.implements Ljava/io/Externalizable;


# static fields
.field private static final sInstanceCounter:Lco/vine/android/util/InstanceCounter;

.field private static final sLock:[I

.field private static final serialVersionUID:J = 0x773660a9759c8145L


# instance fields
.field private mAudioData:Lco/vine/android/recorder/AudioArray;

.field private mAudioDataCount:I

.field private mConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

.field private final mSegments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation
.end field

.field private mVersion:Lco/vine/android/recorder/RecordSessionVersion;

.field private mVideoData:[B

.field private mVideoDataCount:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lco/vine/android/util/InstanceCounter;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Lco/vine/android/util/InstanceCounter;-><init>(I)V

    sput-object v0, Lco/vine/android/recorder/RecordSession;->sInstanceCounter:Lco/vine/android/util/InstanceCounter;

    .line 32
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/recorder/RecordSession;->sLock:[I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    .line 27
    iput v1, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    .line 28
    iput v1, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    .line 36
    return-void
.end method

.method public constructor <init>(Lco/vine/android/recorder/RecordSessionVersion;)V
    .locals 2
    .param p1, "version"    # Lco/vine/android/recorder/RecordSessionVersion;

    .prologue
    const/4 v1, -0x1

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    .line 27
    iput v1, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    .line 28
    iput v1, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    .line 39
    sget-object v1, Lco/vine/android/recorder/RecordSession;->sLock:[I

    monitor-enter v1

    .line 40
    :try_start_0
    iput-object p1, p0, Lco/vine/android/recorder/RecordSession;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 41
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 42
    sget-object v0, Lco/vine/android/recorder/RecordSession;->sInstanceCounter:Lco/vine/android/util/InstanceCounter;

    invoke-virtual {v0, p0}, Lco/vine/android/util/InstanceCounter;->onCreate(Ljava/lang/Object;)I

    .line 44
    :cond_0
    monitor-exit v1

    .line 45
    return-void

    .line 44
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static newSession(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Lco/vine/android/recorder/RecordSessionVersion;)Lco/vine/android/recorder/RecordSession;
    .locals 4
    .param p0, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p1, "version"    # Lco/vine/android/recorder/RecordSessionVersion;

    .prologue
    .line 48
    new-instance v0, Lco/vine/android/recorder/RecordSession;

    invoke-direct {v0, p1}, Lco/vine/android/recorder/RecordSession;-><init>(Lco/vine/android/recorder/RecordSessionVersion;)V

    .line 49
    .local v0, "session":Lco/vine/android/recorder/RecordSession;
    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->getVideoBufferMax(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)I

    move-result v1

    new-array v1, v1, [B

    iput-object v1, v0, Lco/vine/android/recorder/RecordSession;->mVideoData:[B

    .line 50
    new-instance v1, Lco/vine/android/recorder/AudioArray;

    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->getMaxAudioBufferSize(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)I

    move-result v2

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordSessionVersion;->getAudioArrayType()Lco/vine/android/recorder/AudioArray$AudioArrayType;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lco/vine/android/recorder/AudioArray;-><init>(ILco/vine/android/recorder/AudioArray$AudioArrayType;)V

    iput-object v1, v0, Lco/vine/android/recorder/RecordSession;->mAudioData:Lco/vine/android/recorder/AudioArray;

    .line 51
    iput-object p0, v0, Lco/vine/android/recorder/RecordSession;->mConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .line 52
    return-object v0
.end method


# virtual methods
.method public add(Lco/vine/android/recorder/RecordSegment;)V
    .locals 1
    .param p1, "currentSegment"    # Lco/vine/android/recorder/RecordSegment;

    .prologue
    .line 142
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 143
    return-void
.end method

.method public calculateAudioCount()I
    .locals 4

    .prologue
    .line 99
    const/4 v2, 0x0

    .line 100
    .local v2, "total":I
    iget-object v3, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/recorder/RecordSegment;

    .line 101
    .local v1, "segment":Lco/vine/android/recorder/RecordSegment;
    iget-boolean v3, v1, Lco/vine/android/recorder/RecordSegment;->removed:Z

    if-nez v3, :cond_0

    .line 102
    invoke-virtual {v1}, Lco/vine/android/recorder/RecordSegment;->getCombinedAudioData()Lco/vine/android/recorder/AudioData;

    move-result-object v3

    iget v3, v3, Lco/vine/android/recorder/AudioData;->size:I

    add-int/2addr v2, v3

    goto :goto_0

    .line 105
    .end local v1    # "segment":Lco/vine/android/recorder/RecordSegment;
    :cond_1
    return v2
.end method

.method public calculateVideoCount()I
    .locals 7

    .prologue
    .line 84
    const/4 v4, 0x0

    .line 85
    .local v4, "total":I
    iget-object v6, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/recorder/RecordSegment;

    .line 86
    .local v3, "segment":Lco/vine/android/recorder/RecordSegment;
    iget-boolean v6, v3, Lco/vine/android/recorder/RecordSegment;->removed:Z

    if-nez v6, :cond_0

    .line 87
    invoke-virtual {v3}, Lco/vine/android/recorder/RecordSegment;->getVideoData()Ljava/util/ArrayList;

    move-result-object v5

    .line 88
    .local v5, "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/VideoData;

    .line 89
    .local v0, "data":Lco/vine/android/recorder/VideoData;
    iget v6, v0, Lco/vine/android/recorder/VideoData;->size:I

    if-lez v6, :cond_1

    .line 90
    iget v6, v0, Lco/vine/android/recorder/VideoData;->size:I

    add-int/2addr v4, v6

    goto :goto_0

    .line 95
    .end local v0    # "data":Lco/vine/android/recorder/VideoData;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "segment":Lco/vine/android/recorder/RecordSegment;
    .end local v5    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    :cond_2
    return v4
.end method

.method public getAudioData()Lco/vine/android/recorder/AudioArray;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mAudioData:Lco/vine/android/recorder/AudioArray;

    return-object v0
.end method

.method public getAudioDataCount()I
    .locals 2

    .prologue
    .line 63
    iget v0, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 64
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSession;->calculateAudioCount()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    .line 66
    :cond_0
    iget v0, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    return v0
.end method

.method public getConfig()Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    return-object v0
.end method

.method public getSegments()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getVersion()Lco/vine/android/recorder/RecordSessionVersion;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    if-nez v0, :cond_0

    .line 161
    sget-object v0, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    iput-object v0, p0, Lco/vine/android/recorder/RecordSession;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 163
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    return-object v0
.end method

.method public getVideoData()[B
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mVideoData:[B

    return-object v0
.end method

.method public getVideoDataCount()I
    .locals 2

    .prologue
    .line 56
    iget v0, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 57
    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSession;->calculateVideoCount()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    .line 59
    :cond_0
    iget v0, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    return v0
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 4
    .param p1, "stream"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 117
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v1

    .line 118
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, [B

    if-eqz v2, :cond_0

    .line 119
    check-cast v1, [B

    .end local v1    # "obj":Ljava/lang/Object;
    check-cast v1, [B

    iput-object v1, p0, Lco/vine/android/recorder/RecordSession;->mVideoData:[B

    .line 124
    :goto_0
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    .line 125
    .local v0, "audioData":Ljava/lang/Object;
    new-instance v2, Lco/vine/android/recorder/AudioArray;

    invoke-direct {v2, v0}, Lco/vine/android/recorder/AudioArray;-><init>(Ljava/lang/Object;)V

    iput-object v2, p0, Lco/vine/android/recorder/RecordSession;->mAudioData:Lco/vine/android/recorder/AudioArray;

    .line 126
    iget-object v3, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 127
    return-void

    .line 121
    .end local v0    # "audioData":Ljava/lang/Object;
    .restart local v1    # "obj":Ljava/lang/Object;
    :cond_0
    check-cast v1, Lco/vine/android/recorder/RecordSessionVersion;

    .end local v1    # "obj":Ljava/lang/Object;
    iput-object v1, p0, Lco/vine/android/recorder/RecordSession;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    .line 122
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    check-cast v2, [B

    iput-object v2, p0, Lco/vine/android/recorder/RecordSession;->mVideoData:[B

    goto :goto_0
.end method

.method public setAudioDataCount(I)V
    .locals 3
    .param p1, "audioDataCount"    # I

    .prologue
    .line 77
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSession;->calculateAudioCount()I

    move-result v0

    if-eq p1, v0, :cond_0

    .line 78
    const-string v0, "Audio Counts does not match: {} {}."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSession;->calculateAudioCount()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 80
    :cond_0
    iput p1, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    .line 81
    return-void
.end method

.method public setConfig(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)V
    .locals 0
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .prologue
    .line 150
    iput-object p1, p0, Lco/vine/android/recorder/RecordSession;->mConfig:Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    .line 151
    return-void
.end method

.method public setVideoDataCount(I)V
    .locals 3
    .param p1, "videoDataCount"    # I

    .prologue
    .line 70
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSession;->calculateVideoCount()I

    move-result v0

    if-eq p1, v0, :cond_0

    .line 71
    const-string v0, "Video Counts does not match: {} {}."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0}, Lco/vine/android/recorder/RecordSession;->calculateVideoCount()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 73
    :cond_0
    iput p1, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    .line 74
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 155
    const-string v0, "\nVideoData Count: {}, AudioData Count: {}, Segments: {}"

    iget v1, p0, Lco/vine/android/recorder/RecordSession;->mVideoDataCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget v2, p0, Lco/vine/android/recorder/RecordSession;->mAudioDataCount:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 1
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mVersion:Lco/vine/android/recorder/RecordSessionVersion;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 110
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mVideoData:[B

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 111
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mAudioData:Lco/vine/android/recorder/AudioArray;

    invoke-virtual {v0}, Lco/vine/android/recorder/AudioArray;->getData()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 112
    iget-object v0, p0, Lco/vine/android/recorder/RecordSession;->mSegments:Ljava/util/ArrayList;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 113
    return-void
.end method
