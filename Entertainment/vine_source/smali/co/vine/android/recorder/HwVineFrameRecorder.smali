.class public Lco/vine/android/recorder/HwVineFrameRecorder;
.super Ljava/lang/Object;
.source "HwVineFrameRecorder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    }
.end annotation


# static fields
.field private static final LOCK:[I

.field private static final LOGGING:Z = false

.field private static final TAG:Ljava/lang/String; = "Recorder"


# instance fields
.field private mAudioRecordTime:J

.field private final mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

.field private mEncodingCount:I

.field private mFrameNumber:I

.field private mHasData:Z

.field private mLastTimestamp:I

.field private mLoggingVideoFile:Ljava/io/ObjectOutputStream;

.field private final mOutput:Ljava/lang/String;

.field private final mTpfMs:D

.field private final mTpfUs:D

.field private mVideoEncodeTime:J

.field private mVideoRecordTime:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 37
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/recorder/HwVineFrameRecorder;->LOCK:[I

    .line 40
    const-string v0, "LV3GPWriterAndColorFilters"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 41
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-ge v0, v1, :cond_0

    .line 42
    const-string v0, "LifeVibesSFEncoder"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 44
    :cond_0
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "output"    # Ljava/lang/String;
    .param p3, "frameRate"    # I

    .prologue
    const-wide v3, 0x408f400000000000L    # 1000.0

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    const-string v1, "Recorder"

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Created frame recorder: encoding only? "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-nez p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    sget-object v1, Lco/vine/android/recorder/HwVineFrameRecorder;->LOCK:[I

    monitor-enter v1

    .line 52
    :try_start_0
    invoke-static {}, Ljava/lang/Thread;->dumpStack()V

    .line 53
    iput-object p2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mOutput:Ljava/lang/String;

    .line 58
    invoke-static {}, Lco/vine/android/recorder/RecordConfigUtils;->getEncoderConfiguration()Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->create(Landroid/content/Context;Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    .line 59
    iget-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mOutput:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 60
    iget-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->startEncoding()V

    .line 64
    :goto_1
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 65
    int-to-double v0, p3

    div-double v0, v3, v0

    iput-wide v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mTpfMs:D

    .line 66
    iget-wide v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mTpfMs:D

    mul-double/2addr v0, v3

    iput-wide v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mTpfUs:D

    .line 67
    return-void

    .line 50
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 62
    :cond_1
    :try_start_1
    iget-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    iget-object v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mOutput:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->startRecording(Ljava/lang/String;)V

    goto :goto_1

    .line 64
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method


# virtual methods
.method public encode(Ljava/nio/ByteBuffer;[BIZ)I
    .locals 9
    .param p1, "bytes"    # Ljava/nio/ByteBuffer;
    .param p2, "videoDataBufferMax"    # [B
    .param p3, "videoDataBufferPosition"    # I
    .param p4, "lastFrame"    # Z

    .prologue
    const/4 v2, -0x1

    const/4 v7, 0x1

    .line 144
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 152
    .local v3, "startTime":J
    iput-boolean v7, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mHasData:Z

    .line 155
    const/4 v1, 0x0

    .line 156
    .local v1, "encoded":Ljava/nio/ByteBuffer;
    if-eqz p1, :cond_1

    .line 170
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x10

    if-lt v5, v6, :cond_2

    .line 171
    iget-object v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v5, p1, v7}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeVideo(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;

    move-result-object v1

    .line 175
    :goto_0
    iget-object v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLoggingVideoFile:Ljava/io/ObjectOutputStream;

    if-eqz v5, :cond_0

    .line 176
    const/4 v5, 0x0

    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 178
    :try_start_0
    iget-object v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLoggingVideoFile:Ljava/io/ObjectOutputStream;

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 183
    :cond_0
    :goto_1
    if-nez v1, :cond_3

    .line 193
    :cond_1
    :goto_2
    return v2

    .line 173
    :cond_2
    iget-object v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v5, p1, v7, p4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeVideoAsync(Ljava/nio/ByteBuffer;IZ)V

    goto :goto_0

    .line 179
    :catch_0
    move-exception v0

    .line 180
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 190
    .end local v0    # "e":Ljava/io/IOException;
    :cond_3
    invoke-virtual {p0, v1, p2, p3}, Lco/vine/android/recorder/HwVineFrameRecorder;->putEncodedData(Ljava/nio/ByteBuffer;[BI)I

    move-result v2

    .line 191
    .local v2, "r":I
    iget v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mEncodingCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mEncodingCount:I

    .line 192
    iget-wide v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoEncodeTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    sub-long/2addr v7, v3

    add-long/2addr v5, v7

    iput-wide v5, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoEncodeTime:J

    goto :goto_2
.end method

.method public getFrameNumber()I
    .locals 1

    .prologue
    .line 112
    iget v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mFrameNumber:I

    return v0
.end method

.method public getLastTimestamp()J
    .locals 2

    .prologue
    .line 204
    iget v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLastTimestamp:I

    int-to-long v0, v0

    return-wide v0
.end method

.method public getOutput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mOutput:Ljava/lang/String;

    return-object v0
.end method

.method public getTimestamp()J
    .locals 4

    .prologue
    .line 104
    iget v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mFrameNumber:I

    int-to-double v0, v0

    iget-wide v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mTpfUs:D

    mul-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    return-wide v0
.end method

.method public hasData()Z
    .locals 1

    .prologue
    .line 140
    iget-boolean v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mHasData:Z

    return v0
.end method

.method public putEncodedData(Ljava/nio/ByteBuffer;[BI)I
    .locals 2
    .param p1, "encoded"    # Ljava/nio/ByteBuffer;
    .param p2, "videoDataBufferMax"    # [B
    .param p3, "videoDataBufferPosition"    # I

    .prologue
    .line 197
    invoke-static {p2}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 198
    .local v0, "current":Ljava/nio/ByteBuffer;
    invoke-virtual {v0, p3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 199
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 200
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    sub-int/2addr v1, p3

    return v1
.end method

.method public recordAudio([BII)V
    .locals 8
    .param p1, "data"    # [B
    .param p2, "start"    # I
    .param p3, "size"    # I

    .prologue
    .line 70
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mHasData:Z

    .line 72
    const/16 v1, 0x800

    .line 74
    .local v1, "encoderSizeLimit":I
    const-string v4, "Audio buffer size: {}."

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    .line 75
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 76
    .local v2, "startTime":J
    :goto_0
    if-lez p3, :cond_1

    .line 77
    if-ge p3, v1, :cond_0

    .line 78
    move v1, p3

    .line 80
    :cond_0
    iget-object v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v4, p1, p2, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->encodeAudio([BII)Ljava/nio/ShortBuffer;

    move-result-object v0

    .line 81
    .local v0, "encoded":Ljava/nio/ShortBuffer;
    sub-int/2addr p3, v1

    .line 82
    add-int/2addr p2, v1

    .line 83
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Ljava/nio/ShortBuffer;->position(I)Ljava/nio/Buffer;

    .line 84
    iget-object v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v4, v0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->recordAudio(Ljava/nio/ShortBuffer;)V

    goto :goto_0

    .line 86
    .end local v0    # "encoded":Ljava/nio/ShortBuffer;
    :cond_1
    iget-wide v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mAudioRecordTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v2

    add-long/2addr v4, v6

    iput-wide v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mAudioRecordTime:J

    .line 87
    return-void
.end method

.method public setDataListener(Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;)V
    .locals 2
    .param p1, "encodingProcessRunnable"    # Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

    .prologue
    .line 208
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-ge v0, v1, :cond_0

    .line 209
    iget-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v0, p1}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->setEncoderVideoAsyncListener(Lcom/lifevibes/mediacoder/LVMediaCoder$LVMediaCoderICSEncoderProgressListener;)V

    .line 211
    :cond_0
    return-void
.end method

.method public setTimestamp(J)V
    .locals 4
    .param p1, "determinedTimestamp"    # J

    .prologue
    .line 108
    long-to-double v0, p1

    iget-wide v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mTpfUs:D

    div-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-int v0, v0

    iput v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mFrameNumber:I

    .line 109
    return-void
.end method

.method public stopCombining()V
    .locals 4

    .prologue
    .line 125
    iget-object v1, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLoggingVideoFile:Ljava/io/ObjectOutputStream;

    if-eqz v1, :cond_0

    .line 127
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLoggingVideoFile:Ljava/io/ObjectOutputStream;

    invoke-virtual {v1}, Ljava/io/ObjectOutputStream;->flush()V

    .line 128
    iget-object v1, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLoggingVideoFile:Ljava/io/ObjectOutputStream;

    invoke-virtual {v1}, Ljava/io/ObjectOutputStream;->close()V

    .line 129
    const-string v1, "Recorder"

    const-string v2, "Video file binary saved."

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    :cond_0
    :goto_0
    const-string v1, "Recording audio took: {}ms"

    iget-wide v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mAudioRecordTime:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 135
    const-string v1, "Recording video took: {}ms."

    iget-wide v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoRecordTime:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 136
    iget-object v1, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v1}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->stop()V

    .line 137
    return-void

    .line 130
    :catch_0
    move-exception v0

    .line 131
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public stopEncoding()V
    .locals 5

    .prologue
    .line 90
    const-string v0, "Stop Encoding Start."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 91
    iget-object v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-virtual {v0}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->stop()V

    .line 92
    const-string v0, "Stop Encoding Done."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 93
    iget v0, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mEncodingCount:I

    if-lez v0, :cond_0

    .line 94
    const-string v0, "Encoding video took: {}ms."

    iget-wide v1, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoEncodeTime:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 95
    const-string v0, "Encoding fps: {}fps, "

    iget v1, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mEncodingCount:I

    mul-int/lit16 v1, v1, 0x3e8

    int-to-long v1, v1

    iget-wide v3, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoEncodeTime:J

    div-long/2addr v1, v3

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 97
    :cond_0
    return-void
.end method

.method public writeEncodedImage([BII)V
    .locals 6
    .param p1, "videoDataArray"    # [B
    .param p2, "start"    # I
    .param p3, "size"    # I

    .prologue
    .line 116
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 117
    .local v0, "startTime":J
    const/4 v2, 0x1

    iput-boolean v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mHasData:Z

    .line 118
    iget v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mFrameNumber:I

    int-to-double v2, v2

    iget-wide v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mTpfMs:D

    mul-double/2addr v2, v4

    double-to-int v2, v2

    iput v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLastTimestamp:I

    .line 119
    iget-object v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mCoder:Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-static {p1, p2, p3}, Ljava/nio/ByteBuffer;->wrap([BII)Ljava/nio/ByteBuffer;

    move-result-object v3

    iget v4, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mLastTimestamp:I

    add-int/lit8 v4, v4, 0x21

    invoke-virtual {v2, v3, v4}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->recordVideo(Ljava/nio/ByteBuffer;I)V

    .line 120
    iget v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mFrameNumber:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mFrameNumber:I

    .line 121
    iget-wide v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoRecordTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v0

    add-long/2addr v2, v4

    iput-wide v2, p0, Lco/vine/android/recorder/HwVineFrameRecorder;->mVideoRecordTime:J

    .line 122
    return-void
.end method
