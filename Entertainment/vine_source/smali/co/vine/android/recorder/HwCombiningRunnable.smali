.class public Lco/vine/android/recorder/HwCombiningRunnable;
.super Lco/vine/android/recorder/AbstractCombiningRunnable;
.source "HwCombiningRunnable.java"


# instance fields
.field private hasLoggedException:Z

.field private final mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

.field private final mAudioArray:[B

.field private final mIsPreview:Z

.field private mLastFrameOnlyModePath:Ljava/lang/String;

.field private mSegments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;"
        }
    .end annotation
.end field

.field private mSingleSegment:Z

.field private mThumbnailPath:Ljava/lang/String;

.field private mTimeOffset:J

.field private final mVideoArray:[B

.field private mVideoPath:Ljava/lang/String;

.field private final mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/RecordingFile;Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Z)V
    .locals 6
    .param p1, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "segment"    # Lco/vine/android/recorder/RecordSegment;
    .param p3, "videoRecorder"    # Lco/vine/android/recorder/HwVineFrameRecorder;
    .param p4, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .param p5, "onlyGrabLastSegmentMode"    # Z

    .prologue
    const/4 v1, 0x1

    .line 48
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/AudioArray;->getDataByte()[B

    move-result-object v2

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v3

    move-object v0, p0

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/HwCombiningRunnable;-><init>(Z[B[BLco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;)V

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    .line 50
    iget-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 51
    iput-boolean v1, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mSingleSegment:Z

    .line 52
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSegmentVideoPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    .line 53
    iget-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    iput-object v0, p2, Lco/vine/android/recorder/RecordSegment;->videoPath:Ljava/lang/String;

    .line 54
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSegmentThumbnailPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    .line 55
    if-eqz p5, :cond_0

    .line 56
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getPreviewThumbnailPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    .line 58
    :cond_0
    return-void
.end method

.method public constructor <init>(Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;)V
    .locals 6
    .param p1, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "isPreview"    # Z
    .param p3, "audioArray"    # Lco/vine/android/recorder/AudioArray;
    .param p4, "videoArray"    # [B
    .param p6, "videoRecorder"    # Lco/vine/android/recorder/HwVineFrameRecorder;
    .param p7, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/recorder/RecordingFile;",
            "Z",
            "Lco/vine/android/recorder/AudioArray;",
            "[B",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;",
            "Lco/vine/android/recorder/HwVineFrameRecorder;",
            "Lco/vine/android/recorder/BaseFinishProcessTask;",
            ")V"
        }
    .end annotation

    .prologue
    .line 39
    .local p5, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    invoke-virtual {p3}, Lco/vine/android/recorder/AudioArray;->getDataByte()[B

    move-result-object v2

    move-object v0, p0

    move v1, p2

    move-object v3, p4

    move-object v4, p6

    move-object v5, p7

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/HwCombiningRunnable;-><init>(Z[B[BLco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;)V

    .line 40
    iput-object p5, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    .line 41
    if-eqz p2, :cond_0

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getPreviewVideoPath()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    .line 42
    if-eqz p2, :cond_1

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getPreviewThumbnailPath()Ljava/lang/String;

    move-result-object v0

    :goto_1
    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    .line 43
    return-void

    .line 41
    :cond_0
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 42
    :cond_1
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getThumbnailPath()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private constructor <init>(Z[B[BLco/vine/android/recorder/HwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;)V
    .locals 2
    .param p1, "isPreview"    # Z
    .param p2, "audioArray"    # [B
    .param p3, "videoArray"    # [B
    .param p4, "videoRecorder"    # Lco/vine/android/recorder/HwVineFrameRecorder;
    .param p5, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;

    .prologue
    .line 62
    invoke-direct {p0}, Lco/vine/android/recorder/AbstractCombiningRunnable;-><init>()V

    .line 33
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    .line 63
    iput-object p2, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mAudioArray:[B

    .line 64
    iput-object p3, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoArray:[B

    .line 65
    iput-boolean p1, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mIsPreview:Z

    .line 66
    iput-object p4, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    .line 67
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mTimeOffset:J

    .line 68
    iput-object p5, p0, Lco/vine/android/recorder/HwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    .line 69
    return-void
.end method


# virtual methods
.method public combineVideos()Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .locals 43

    .prologue
    .line 72
    const/4 v3, -0x8

    invoke-static {v3}, Landroid/os/Process;->setThreadPriority(I)V

    .line 73
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    move-object/from16 v29, v0

    .line 74
    .local v29, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    invoke-virtual/range {v29 .. v29}, Ljava/util/ArrayList;->size()I

    move-result v30

    .line 75
    .local v30, "size":I
    const-wide/16 v39, 0x0

    .line 76
    .local v39, "videoTotal":J
    const-wide/16 v13, 0x0

    .line 77
    .local v13, "audioTotal":J
    const-string v3, "Processing started: {}."

    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 78
    const-wide/16 v34, 0x0

    .line 79
    .local v34, "videoDuration":J
    const-wide/16 v9, 0x0

    .line 81
    .local v9, "audioDuration":J
    const/16 v27, 0x0

    .line 82
    .local v27, "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    if-lez v30, :cond_f

    .line 83
    move-object/from16 v0, p0

    iget-object v8, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mAudioArray:[B

    .line 86
    .local v8, "audioArray":[B
    const/16 v20, 0x0

    .local v20, "i":I
    :goto_0
    move/from16 v0, v20

    move/from16 v1, v30

    if-ge v0, v1, :cond_a

    .line 87
    move-object/from16 v0, v29

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v28

    check-cast v28, Lco/vine/android/recorder/RecordSegment;

    .line 88
    .local v28, "segment":Lco/vine/android/recorder/RecordSegment;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    .line 89
    .local v11, "audioTime":J
    invoke-virtual/range {v28 .. v28}, Lco/vine/android/recorder/RecordSegment;->getCombinedAudioData()Lco/vine/android/recorder/AudioData;

    move-result-object v15

    .line 91
    .local v15, "combined":Lco/vine/android/recorder/AudioData;
    :try_start_0
    iget v3, v15, Lco/vine/android/recorder/AudioData;->size:I

    if-lez v3, :cond_0

    .line 92
    const-string v3, "Recording segment audio: {}, {}."

    iget v4, v15, Lco/vine/android/recorder/AudioData;->start:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iget v5, v15, Lco/vine/android/recorder/AudioData;->size:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 93
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    iget v4, v15, Lco/vine/android/recorder/AudioData;->start:I

    iget v5, v15, Lco/vine/android/recorder/AudioData;->size:I

    invoke-virtual {v3, v8, v4, v5}, Lco/vine/android/recorder/HwVineFrameRecorder;->recordAudio([BII)V
    :try_end_0
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 101
    :cond_0
    :goto_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long/2addr v3, v11

    add-long/2addr v13, v3

    .line 102
    invoke-virtual/range {v28 .. v28}, Lco/vine/android/recorder/RecordSegment;->getVideoData()Ljava/util/ArrayList;

    move-result-object v31

    .line 103
    .local v31, "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoArray:[B

    move-object/from16 v32, v0

    .line 104
    .local v32, "videoDataArray":[B
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v37

    .line 105
    .local v37, "videoTime":J
    invoke-virtual/range {v28 .. v28}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v3

    iget v0, v3, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move/from16 v19, v0

    .line 106
    .local v19, "frameRate":I
    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v33

    .line 108
    .local v33, "videoDataSize":I
    const-wide/16 v25, 0x0

    .line 110
    .local v25, "offset":J
    const/16 v21, 0x0

    .local v21, "k":I
    :goto_2
    move/from16 v0, v21

    move/from16 v1, v33

    if-ge v0, v1, :cond_7

    .line 112
    move-object/from16 v0, v31

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v36

    check-cast v36, Lco/vine/android/recorder/VideoData;

    .line 114
    .local v36, "videoPiece":Lco/vine/android/recorder/VideoData;
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mSingleSegment:Z

    if-eqz v3, :cond_2

    .line 115
    if-nez v21, :cond_1

    .line 116
    move-object/from16 v0, v36

    iget-wide v0, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    move-wide/from16 v25, v0

    .line 118
    :cond_1
    move-object/from16 v0, v36

    iget-wide v3, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    sub-long v3, v3, v25

    move-object/from16 v0, v36

    iput-wide v3, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    .line 121
    :cond_2
    move-object/from16 v0, v36

    iget v3, v0, Lco/vine/android/recorder/VideoData;->size:I

    if-gez v3, :cond_4

    .line 110
    :goto_3
    add-int/lit8 v21, v21, 0x1

    goto :goto_2

    .line 95
    .end local v19    # "frameRate":I
    .end local v21    # "k":I
    .end local v25    # "offset":J
    .end local v31    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    .end local v32    # "videoDataArray":[B
    .end local v33    # "videoDataSize":I
    .end local v36    # "videoPiece":Lco/vine/android/recorder/VideoData;
    .end local v37    # "videoTime":J
    :catch_0
    move-exception v18

    .line 96
    .local v18, "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->hasLoggedException:Z

    if-eqz v3, :cond_3

    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v3, :cond_0

    .line 97
    :cond_3
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->hasLoggedException:Z

    .line 98
    invoke-static/range {v18 .. v18}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 125
    .end local v18    # "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    .restart local v19    # "frameRate":I
    .restart local v21    # "k":I
    .restart local v25    # "offset":J
    .restart local v31    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    .restart local v32    # "videoDataArray":[B
    .restart local v33    # "videoDataSize":I
    .restart local v36    # "videoPiece":Lco/vine/android/recorder/VideoData;
    .restart local v37    # "videoTime":J
    :cond_4
    move-object/from16 v0, v36

    iget-wide v3, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-nez v3, :cond_5

    .line 126
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->getTimestamp()J

    move-result-wide v3

    move-object/from16 v0, p0

    iput-wide v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mTimeOffset:J

    .line 130
    :cond_5
    move-object/from16 v0, v36

    iget-wide v3, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    move-object/from16 v0, p0

    iget-wide v5, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mTimeOffset:J

    add-long v16, v3, v5

    .line 132
    .local v16, "determinedTimestamp":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->getFrameNumber()I

    move-result v22

    .line 133
    .local v22, "nextFrameNumber":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->getTimestamp()J

    move-result-wide v23

    .line 138
    .local v23, "nextTimestamp":J
    sub-long v3, v16, v23

    const v5, 0xf4240

    div-int v5, v5, v19

    int-to-long v5, v5

    cmp-long v3, v3, v5

    if-lez v3, :cond_6

    .line 139
    const-string v3, "*******Skipped frame*******"

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 140
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    move-wide/from16 v0, v16

    invoke-virtual {v3, v0, v1}, Lco/vine/android/recorder/HwVineFrameRecorder;->setTimestamp(J)V

    .line 141
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->getFrameNumber()I

    move-result v22

    .line 147
    :goto_4
    :try_start_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    move-object/from16 v0, v36

    iget v4, v0, Lco/vine/android/recorder/VideoData;->start:I

    move-object/from16 v0, v36

    iget v5, v0, Lco/vine/android/recorder/VideoData;->size:I

    move-object/from16 v0, v32

    invoke-virtual {v3, v0, v4, v5}, Lco/vine/android/recorder/HwVineFrameRecorder;->writeEncodedImage([BII)V

    .line 148
    const-string v3, "Successfully did video frame at {}, #{}."

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_1
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_3

    .line 149
    :catch_1
    move-exception v18

    .line 150
    .restart local v18    # "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    const-string v3, "Failed to record video frame at {}. #{}."

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_3

    .line 143
    .end local v18    # "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    :cond_6
    move-wide/from16 v16, v23

    goto :goto_4

    .line 153
    .end local v16    # "determinedTimestamp":J
    .end local v22    # "nextFrameNumber":I
    .end local v23    # "nextTimestamp":J
    .end local v36    # "videoPiece":Lco/vine/android/recorder/VideoData;
    :cond_7
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long v3, v3, v37

    add-long v39, v39, v3

    .line 154
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    if-eqz v3, :cond_8

    .line 155
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    mul-int/lit8 v4, v20, 0xa

    div-int v4, v4, v30

    add-int/lit8 v4, v4, 0x5a

    invoke-virtual {v3, v4}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 157
    :cond_8
    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v3, :cond_9

    .line 158
    invoke-virtual {v15}, Lco/vine/android/recorder/AudioData;->getDurationNs()J

    move-result-wide v3

    const-wide/16 v5, 0x3e8

    div-long/2addr v3, v5

    add-long/2addr v9, v3

    .line 159
    const/16 v3, 0x3e8

    div-int v3, v3, v19

    mul-int v3, v3, v33

    int-to-long v3, v3

    add-long v34, v34, v3

    .line 160
    const-string v3, "Recorded segment with time: audio: {}, video: {}."

    invoke-virtual {v15}, Lco/vine/android/recorder/AudioData;->getDurationNs()J

    move-result-wide v4

    const-wide/16 v41, 0x3e8

    div-long v4, v4, v41

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    const/16 v5, 0x3e8

    div-int v5, v5, v19

    mul-int v5, v5, v33

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 86
    :cond_9
    add-int/lit8 v20, v20, 0x1

    goto/16 :goto_0

    .line 163
    .end local v11    # "audioTime":J
    .end local v15    # "combined":Lco/vine/android/recorder/AudioData;
    .end local v19    # "frameRate":I
    .end local v21    # "k":I
    .end local v25    # "offset":J
    .end local v28    # "segment":Lco/vine/android/recorder/RecordSegment;
    .end local v31    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    .end local v32    # "videoDataArray":[B
    .end local v33    # "videoDataSize":I
    .end local v37    # "videoTime":J
    :cond_a
    const-string v3, "Done with all segments. total time: audio: {}, video: {}."

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static/range {v34 .. v35}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 165
    :try_start_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->stopCombining()V

    .line 167
    const-string v3, "Video file renamed: {}, {}."

    new-instance v4, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v5}, Lco/vine/android/recorder/HwVineFrameRecorder;->getOutput()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    new-instance v5, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    invoke-static {v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 168
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    if-eqz v3, :cond_f

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->hasData()Z

    move-result v3

    if-eqz v3, :cond_f

    .line 170
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mSingleSegment:Z

    if-eqz v3, :cond_b

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    if-eqz v3, :cond_e

    .line 171
    :cond_b
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    if-nez v3, :cond_d

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    :goto_5
    move-object/from16 v0, p0

    iget-boolean v4, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mIsPreview:Z

    invoke-static {v3, v4}, Lco/vine/android/recorder/RecordingFile;->getLastFramePathThumbnailFromThumbnailPath(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v7

    .line 177
    .local v7, "lastFramePath":Ljava/lang/String;
    :goto_6
    new-instance v2, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;

    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/HwVineFrameRecorder;

    invoke-virtual {v3}, Lco/vine/android/recorder/HwVineFrameRecorder;->getLastTimestamp()J

    move-result-wide v3

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    invoke-direct/range {v2 .. v7}, Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    .line 185
    .end local v7    # "lastFramePath":Ljava/lang/String;
    .end local v8    # "audioArray":[B
    .end local v20    # "i":I
    .end local v27    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .local v2, "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    :goto_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    if-eqz v3, :cond_c

    .line 186
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    const/16 v4, 0x63

    invoke-virtual {v3, v4}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 188
    :cond_c
    const-string v3, "Time used: video: {}, audio: {}, n: {}."

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static/range {v39 .. v40}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {v13, v14}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-static/range {v30 .. v30}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 189
    return-object v2

    .line 171
    .end local v2    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .restart local v8    # "audioArray":[B
    .restart local v20    # "i":I
    .restart local v27    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    :cond_d
    :try_start_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/recorder/HwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;
    :try_end_3
    .catch Lco/vine/android/recorder/HwVineFrameRecorder$Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_5

    .line 175
    :cond_e
    const/4 v7, 0x0

    .restart local v7    # "lastFramePath":Ljava/lang/String;
    goto :goto_6

    .line 179
    .end local v7    # "lastFramePath":Ljava/lang/String;
    :catch_2
    move-exception v18

    .line 180
    .restart local v18    # "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    const-string v3, "Error flushing..."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v18, v4, v5

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    move-object/from16 v2, v27

    .line 183
    .end local v27    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .restart local v2    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    goto :goto_7

    .line 181
    .end local v2    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .end local v18    # "e":Lco/vine/android/recorder/HwVineFrameRecorder$Exception;
    .restart local v27    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    :catch_3
    move-exception v18

    .line 182
    .local v18, "e":Ljava/lang/Exception;
    const-string v3, "Failed to generate thumbnail."

    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .end local v8    # "audioArray":[B
    .end local v18    # "e":Ljava/lang/Exception;
    .end local v20    # "i":I
    :cond_f
    move-object/from16 v2, v27

    .end local v27    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .restart local v2    # "runnableToReturn":Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    goto :goto_7
.end method
