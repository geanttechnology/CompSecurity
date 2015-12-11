.class public Lco/vine/android/recorder/SwCombiningRunnable;
.super Lco/vine/android/recorder/AbstractCombiningRunnable;
.source "SwCombiningRunnable.java"


# instance fields
.field private errorCount:I

.field private hasLoggedException:Z

.field private final mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

.field private final mAudioArray:[S

.field private mBitmap:Landroid/graphics/Bitmap;

.field private mLastFrameOnlyModePath:Ljava/lang/String;

.field private mLastFramePath:Ljava/lang/String;

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

.field private mTempFrame:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

.field private mThumbnailPath:Ljava/lang/String;

.field private mTimeOffset:J

.field private final mVideoArray:[B

.field private mVideoPath:Ljava/lang/String;

.field private final mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

.field public mVideoSize:I


# direct methods
.method private constructor <init>(Lco/vine/android/recorder/AudioArray;[BLco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
    .locals 2
    .param p1, "audioArray"    # Lco/vine/android/recorder/AudioArray;
    .param p2, "videoArray"    # [B
    .param p3, "videoRecorder"    # Lco/vine/android/recorder/SwVineFrameRecorder;
    .param p4, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .param p5, "bitmap"    # Landroid/graphics/Bitmap;
    .param p6, "tempFrame"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    .prologue
    const/4 v0, 0x0

    .line 99
    invoke-direct {p0}, Lco/vine/android/recorder/AbstractCombiningRunnable;-><init>()V

    .line 34
    const/4 v1, 0x0

    iput v1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->errorCount:I

    .line 46
    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    .line 100
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lco/vine/android/recorder/AudioArray;->getDataShort()[S

    move-result-object v0

    :cond_0
    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mAudioArray:[S

    .line 101
    iput-object p2, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoArray:[B

    .line 102
    iput-object p5, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mBitmap:Landroid/graphics/Bitmap;

    .line 103
    iput-object p6, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mTempFrame:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    .line 104
    iput-object p3, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    .line 105
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mTimeOffset:J

    .line 106
    iput-object p4, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    .line 107
    return-void
.end method

.method public constructor <init>(Lco/vine/android/recorder/RecordingFile;Lco/vine/android/recorder/RecordSegment;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Z)V
    .locals 8
    .param p1, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "segment"    # Lco/vine/android/recorder/RecordSegment;
    .param p3, "videoRecorder"    # Lco/vine/android/recorder/SwVineFrameRecorder;
    .param p4, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .param p5, "bitmap"    # Landroid/graphics/Bitmap;
    .param p6, "tempFrame"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p7, "onlyGrabLastSegmentMode"    # Z

    .prologue
    const/4 v7, 0x1

    .line 72
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getAudioData()Lco/vine/android/recorder/AudioArray;

    move-result-object v1

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSession()Lco/vine/android/recorder/RecordSession;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/RecordSession;->getVideoData()[B

    move-result-object v2

    move-object v0, p0

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lco/vine/android/recorder/SwCombiningRunnable;-><init>(Lco/vine/android/recorder/AudioArray;[BLco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    .line 74
    iget-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 75
    iput-boolean v7, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mSingleSegment:Z

    .line 76
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSegmentVideoPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    .line 77
    iget-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    iput-object v0, p2, Lco/vine/android/recorder/RecordSegment;->videoPath:Ljava/lang/String;

    .line 78
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getSegmentThumbnailPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    .line 79
    if-eqz p7, :cond_0

    .line 80
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getPreviewThumbnailPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    .line 82
    :cond_0
    invoke-direct {p0, v7}, Lco/vine/android/recorder/SwCombiningRunnable;->initLastFramePath(Z)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFramePath:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public constructor <init>(Lco/vine/android/recorder/RecordingFile;ZLco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
    .locals 10
    .param p1, "file"    # Lco/vine/android/recorder/RecordingFile;
    .param p2, "isPreview"    # Z
    .param p3, "audioArray"    # Lco/vine/android/recorder/AudioArray;
    .param p4, "videoArray"    # [B
    .param p6, "videoRecorder"    # Lco/vine/android/recorder/SwVineFrameRecorder;
    .param p7, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .param p8, "bitmap"    # Landroid/graphics/Bitmap;
    .param p9, "tempFrame"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
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
            "Lco/vine/android/recorder/SwVineFrameRecorder;",
            "Lco/vine/android/recorder/BaseFinishProcessTask;",
            "Landroid/graphics/Bitmap;",
            "Lcom/googlecode/javacv/cpp/opencv_core$IplImage;",
            ")V"
        }
    .end annotation

    .prologue
    .line 63
    .local p5, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    if-eqz p2, :cond_0

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getPreviewVideoPath()Ljava/lang/String;

    move-result-object v1

    :goto_0
    if-eqz p2, :cond_1

    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getPreviewThumbnailPath()Ljava/lang/String;

    move-result-object v2

    :goto_1
    move-object v0, p0

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    move-object/from16 v9, p9

    invoke-direct/range {v0 .. v9}, Lco/vine/android/recorder/SwCombiningRunnable;-><init>(Ljava/lang/String;Ljava/lang/String;Lco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V

    .line 66
    invoke-direct {p0, p2}, Lco/vine/android/recorder/SwCombiningRunnable;->initLastFramePath(Z)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFramePath:Ljava/lang/String;

    .line 67
    return-void

    .line 63
    :cond_0
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getVideoPath()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lco/vine/android/recorder/RecordingFile;->getThumbnailPath()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lco/vine/android/recorder/AudioArray;[BLjava/util/ArrayList;Lco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V
    .locals 7
    .param p1, "videoPath"    # Ljava/lang/String;
    .param p2, "thumbnailPath"    # Ljava/lang/String;
    .param p3, "audioArray"    # Lco/vine/android/recorder/AudioArray;
    .param p4, "videoArray"    # [B
    .param p6, "videoRecorder"    # Lco/vine/android/recorder/SwVineFrameRecorder;
    .param p7, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;
    .param p8, "bitmap"    # Landroid/graphics/Bitmap;
    .param p9, "tempFrame"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lco/vine/android/recorder/AudioArray;",
            "[B",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/recorder/RecordSegment;",
            ">;",
            "Lco/vine/android/recorder/SwVineFrameRecorder;",
            "Lco/vine/android/recorder/BaseFinishProcessTask;",
            "Landroid/graphics/Bitmap;",
            "Lcom/googlecode/javacv/cpp/opencv_core$IplImage;",
            ")V"
        }
    .end annotation

    .prologue
    .line 53
    .local p5, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    move-object v0, p0

    move-object v1, p3

    move-object v2, p4

    move-object v3, p6

    move-object v4, p7

    move-object v5, p8

    move-object/from16 v6, p9

    invoke-direct/range {v0 .. v6}, Lco/vine/android/recorder/SwCombiningRunnable;-><init>(Lco/vine/android/recorder/AudioArray;[BLco/vine/android/recorder/SwVineFrameRecorder;Lco/vine/android/recorder/BaseFinishProcessTask;Landroid/graphics/Bitmap;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;)V

    .line 54
    iput-object p5, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    .line 55
    iput-object p1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    .line 56
    iput-object p2, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    .line 57
    return-void
.end method

.method private initLastFramePath(Z)Ljava/lang/String;
    .locals 2
    .param p1, "isPreview"    # Z

    .prologue
    .line 87
    iget-boolean v1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mSingleSegment:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 88
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    if-nez v1, :cond_1

    iget-object v1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    :goto_0
    invoke-static {v1, p1}, Lco/vine/android/recorder/RecordingFile;->getLastFramePathThumbnailFromThumbnailPath(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "lastFramePath":Ljava/lang/String;
    :goto_1
    return-object v0

    .line 88
    .end local v0    # "lastFramePath":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFrameOnlyModePath:Ljava/lang/String;

    goto :goto_0

    .line 92
    :cond_2
    const/4 v0, 0x0

    .restart local v0    # "lastFramePath":Ljava/lang/String;
    goto :goto_1
.end method

.method private saveThumbnail(III)V
    .locals 22
    .param p1, "videoCount"    # I
    .param p2, "nextFrameNumber"    # I
    .param p3, "frameRate"    # I

    .prologue
    .line 283
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lco/vine/android/recorder/SwVineFrameRecorder;->hasData()Z

    move-result v17

    if-eqz v17, :cond_8

    .line 284
    move-object/from16 v0, p0

    iget-object v10, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mLastFramePath:Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    .line 289
    .local v10, "lastFramePath":Ljava/lang/String;
    const/4 v14, 0x0

    .line 291
    .local v14, "testFolder":Ljava/io/File;
    const/16 v16, 0x0

    .line 294
    .local v16, "thumbnailCreated":Z
    :try_start_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 295
    .local v12, "start":J
    new-instance v7, Lco/vine/android/recorder/VineFrameGrabber;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-direct {v7, v0}, Lco/vine/android/recorder/VineFrameGrabber;-><init>(Ljava/lang/String;)V

    .line 296
    .local v7, "grabber":Lco/vine/android/recorder/VineFrameGrabber;
    invoke-virtual {v7}, Lco/vine/android/recorder/VineFrameGrabber;->start()V

    .line 299
    const/4 v8, 0x0

    .line 300
    .local v8, "index":I
    :cond_0
    :goto_0
    invoke-virtual {v7}, Lco/vine/android/recorder/VineFrameGrabber;->grab()Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-result-object v6

    .local v6, "frame":Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    if-eqz v6, :cond_3

    .line 301
    add-int/lit8 v8, v8, 0x1

    .line 302
    const/16 v17, 0x2

    move/from16 v0, v17

    if-eq v8, v0, :cond_1

    const/16 v17, 0x1

    move/from16 v0, p1

    move/from16 v1, v17

    if-ne v0, v1, :cond_2

    .line 303
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mTempFrame:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-object/from16 v17, v0

    const/16 v18, 0x2

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v6, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_imgproc;->cvCvtColor(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V

    .line 304
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mTempFrame:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->getByteBuffer()Ljava/nio/ByteBuffer;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/graphics/Bitmap;->copyPixelsFromBuffer(Ljava/nio/Buffer;)V

    .line 305
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x4b

    new-instance v20, Ljava/io/FileOutputStream;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-direct/range {v20 .. v21}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 306
    const-string v17, "First Thumbnail generated."

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 308
    :cond_2
    if-nez v10, :cond_9

    .line 320
    :cond_3
    invoke-virtual {v7}, Lco/vine/android/recorder/VineFrameGrabber;->stop()V

    .line 321
    invoke-virtual {v7}, Lco/vine/android/recorder/VineFrameGrabber;->release()V

    .line 323
    const/16 v16, 0x1

    .line 325
    const-string v17, "Grabbing using openCV took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    sub-long v18, v18, v12

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lco/vine/android/recorder/VineFrameGrabber$Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 327
    if-eqz v14, :cond_4

    .line 329
    :try_start_2
    new-instance v15, Ljava/io/File;

    const-string v17, "firstFrame.jpg"

    move-object/from16 v0, v17

    invoke-direct {v15, v14, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 330
    .local v15, "thumbnail":Ljava/io/File;
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-direct/range {v17 .. v18}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-static {v0, v15}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 331
    invoke-virtual {v15}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v17

    const-string v18, "/storage/emulated/0/"

    const-string v19, "/sdcard/"

    invoke-virtual/range {v17 .. v19}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 332
    .local v11, "path":Ljava/lang/String;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Thumbnail copied to "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 333
    if-eqz v10, :cond_4

    .line 334
    new-instance v9, Ljava/io/File;

    const-string v17, "lastFrame.jpg"

    move-object/from16 v0, v17

    invoke-direct {v9, v14, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 335
    .local v9, "lastFrame":Ljava/io/File;
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, v17

    invoke-direct {v0, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-static {v0, v9}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 336
    invoke-virtual {v9}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v17

    const-string v18, "/storage/emulated/0/"

    const-string v19, "/sdcard/"

    invoke-virtual/range {v17 .. v19}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 337
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Last Frame copied to "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lco/vine/android/recorder/VineFrameGrabber$Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_1

    .line 347
    .end local v6    # "frame":Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .end local v7    # "grabber":Lco/vine/android/recorder/VineFrameGrabber;
    .end local v8    # "index":I
    .end local v9    # "lastFrame":Ljava/io/File;
    .end local v11    # "path":Ljava/lang/String;
    .end local v12    # "start":J
    .end local v15    # "thumbnail":Ljava/io/File;
    :cond_4
    :goto_1
    if-nez v16, :cond_6

    .line 348
    :try_start_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 350
    .restart local v12    # "start":J
    move/from16 v0, p2

    int-to-double v0, v0

    move-wide/from16 v17, v0

    const-wide/high16 v19, 0x3ff0000000000000L    # 1.0

    mul-double v17, v17, v19

    move/from16 v0, p3

    int-to-double v0, v0

    move-wide/from16 v19, v0

    div-double v17, v17, v19

    const-wide v19, 0x408f400000000000L    # 1000.0

    mul-double v17, v17, v19

    const-wide v19, 0x408f400000000000L    # 1000.0

    mul-double v17, v17, v19

    move-wide/from16 v0, v17

    double-to-long v3, v0

    .line 352
    .local v3, "duration":J
    const-string v17, "Use duration: {}."

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 354
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v18, v0

    if-eqz v10, :cond_a

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [J

    move-object/from16 v17, v0

    const/16 v19, 0x0

    const-wide/16 v20, 0x0

    aput-wide v20, v17, v19

    const/16 v19, 0x1

    aput-wide v3, v17, v19

    :goto_2
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Lco/vine/android/util/MediaUtil;->getVideoFrames(Ljava/lang/String;[J)[Landroid/graphics/Bitmap;

    move-result-object v2

    .line 359
    .local v2, "bitmaps":[Landroid/graphics/Bitmap;
    const-string v17, "Grabbing using MediaUtil took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    sub-long v18, v18, v12

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 361
    if-eqz v2, :cond_6

    .line 362
    const/16 v17, 0x0

    aget-object v17, v2, v17

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x4b

    new-instance v20, Ljava/io/FileOutputStream;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-direct/range {v20 .. v21}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 363
    if-eqz v10, :cond_5

    .line 364
    const/16 v17, 0x1

    aget-object v17, v2, v17

    if-eqz v17, :cond_5

    .line 365
    const/16 v17, 0x1

    aget-object v17, v2, v17

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x4b

    new-instance v20, Ljava/io/FileOutputStream;

    move-object/from16 v0, v20

    invoke-direct {v0, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_1

    .line 368
    :cond_5
    if-eqz v14, :cond_6

    .line 370
    :try_start_4
    new-instance v15, Ljava/io/File;

    const-string v17, "firstFrame2.jpg"

    move-object/from16 v0, v17

    invoke-direct {v15, v14, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 371
    .restart local v15    # "thumbnail":Ljava/io/File;
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-direct/range {v17 .. v18}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-static {v0, v15}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 372
    invoke-virtual {v15}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v17

    const-string v18, "/storage/emulated/0/"

    const-string v19, "/sdcard/"

    invoke-virtual/range {v17 .. v19}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 373
    .restart local v11    # "path":Ljava/lang/String;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Thumbnail copied to "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 374
    if-eqz v10, :cond_6

    .line 375
    new-instance v9, Ljava/io/File;

    const-string v17, "lastFrame2.jpg"

    move-object/from16 v0, v17

    invoke-direct {v9, v14, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 376
    .restart local v9    # "lastFrame":Ljava/io/File;
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, v17

    invoke-direct {v0, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-static {v0, v9}, Lorg/apache/commons/io/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 377
    invoke-virtual {v9}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v17

    const-string v18, "/storage/emulated/0/"

    const-string v19, "/sdcard/"

    invoke-virtual/range {v17 .. v19}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 378
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "Last Frame copied to "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_1

    .line 387
    .end local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    .end local v3    # "duration":J
    .end local v9    # "lastFrame":Ljava/io/File;
    .end local v11    # "path":Ljava/lang/String;
    .end local v12    # "start":J
    .end local v15    # "thumbnail":Ljava/io/File;
    :cond_6
    :goto_3
    :try_start_5
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-direct/range {v17 .. v18}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v17}, Ljava/io/File;->exists()Z

    move-result v17

    if-nez v17, :cond_7

    .line 388
    const-string v17, "Retry generating thumbnail."

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 389
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [J

    move-object/from16 v18, v0

    const/16 v19, 0x0

    const-wide/16 v20, 0x0

    aput-wide v20, v18, v19

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/MediaUtil;->getVideoFrames(Ljava/lang/String;[J)[Landroid/graphics/Bitmap;

    move-result-object v2

    .line 390
    .restart local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    if-eqz v2, :cond_b

    array-length v0, v2

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_b

    .line 391
    const/16 v17, 0x0

    aget-object v17, v2, v17

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x4b

    new-instance v20, Ljava/io/FileOutputStream;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-direct/range {v20 .. v21}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 392
    const-string v17, "First Thumbnail generated."

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4
    .catch Ljava/io/FileNotFoundException; {:try_start_5 .. :try_end_5} :catch_1

    .line 401
    .end local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    :cond_7
    :goto_4
    :try_start_6
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-direct/range {v17 .. v18}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v17}, Ljava/io/File;->exists()Z

    move-result v17

    if-nez v17, :cond_8

    .line 402
    const-string v17, "Retry generating thumbnail."

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 403
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [J

    move-object/from16 v18, v0

    const/16 v19, 0x0

    const-wide/16 v20, 0x0

    aput-wide v20, v18, v19

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/MediaUtil;->getVideoFrames(Ljava/lang/String;[J)[Landroid/graphics/Bitmap;

    move-result-object v2

    .line 404
    .restart local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    if-eqz v2, :cond_c

    array-length v0, v2

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_c

    .line 405
    const/16 v17, 0x0

    aget-object v17, v2, v17

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x4b

    new-instance v20, Ljava/io/FileOutputStream;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-direct/range {v20 .. v21}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 406
    const-string v17, "First Thumbnail generated."

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5
    .catch Ljava/io/FileNotFoundException; {:try_start_6 .. :try_end_6} :catch_1

    .line 418
    .end local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    .end local v10    # "lastFramePath":Ljava/lang/String;
    .end local v14    # "testFolder":Ljava/io/File;
    .end local v16    # "thumbnailCreated":Z
    :cond_8
    :goto_5
    return-void

    .line 311
    .restart local v6    # "frame":Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .restart local v7    # "grabber":Lco/vine/android/recorder/VineFrameGrabber;
    .restart local v8    # "index":I
    .restart local v10    # "lastFramePath":Ljava/lang/String;
    .restart local v12    # "start":J
    .restart local v14    # "testFolder":Ljava/io/File;
    .restart local v16    # "thumbnailCreated":Z
    :cond_9
    move/from16 v0, p1

    if-gt v0, v8, :cond_0

    const/16 v17, 0x1

    move/from16 v0, v17

    if-eq v8, v0, :cond_0

    .line 312
    :try_start_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mTempFrame:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-object/from16 v17, v0

    const/16 v18, 0x2

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v6, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_imgproc;->cvCvtColor(Lcom/googlecode/javacv/cpp/opencv_core$CvArr;Lcom/googlecode/javacv/cpp/opencv_core$CvArr;I)V

    .line 313
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mTempFrame:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->getByteBuffer()Ljava/nio/ByteBuffer;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/graphics/Bitmap;->copyPixelsFromBuffer(Ljava/nio/Buffer;)V

    .line 314
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x4b

    new-instance v20, Ljava/io/FileOutputStream;

    move-object/from16 v0, v20

    invoke-direct {v0, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v20}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 316
    const-string v17, "Last Thumbnail generated."

    invoke-static/range {v17 .. v17}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_7 .. :try_end_7} :catch_0
    .catch Lco/vine/android/recorder/VineFrameGrabber$Exception; {:try_start_7 .. :try_end_7} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_7 .. :try_end_7} :catch_1

    goto/16 :goto_0

    .line 344
    .end local v6    # "frame":Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .end local v7    # "grabber":Lco/vine/android/recorder/VineFrameGrabber;
    .end local v8    # "index":I
    .end local v12    # "start":J
    :catch_0
    move-exception v5

    .line 345
    .local v5, "e":Ljava/lang/Throwable;
    :try_start_8
    const-string v17, "Error creating thumbnail using default method..."

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput-object v5, v18, v19

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_8
    .catch Ljava/io/FileNotFoundException; {:try_start_8 .. :try_end_8} :catch_1

    goto/16 :goto_1

    .line 415
    .end local v5    # "e":Ljava/lang/Throwable;
    .end local v10    # "lastFramePath":Ljava/lang/String;
    .end local v14    # "testFolder":Ljava/io/File;
    .end local v16    # "thumbnailCreated":Z
    :catch_1
    move-exception v5

    .line 416
    .local v5, "e":Ljava/io/FileNotFoundException;
    const-string v17, "Error saving thumbnail..."

    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput-object v5, v18, v19

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_5

    .line 339
    .end local v5    # "e":Ljava/io/FileNotFoundException;
    .restart local v6    # "frame":Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .restart local v7    # "grabber":Lco/vine/android/recorder/VineFrameGrabber;
    .restart local v8    # "index":I
    .restart local v10    # "lastFramePath":Ljava/lang/String;
    .restart local v12    # "start":J
    .restart local v14    # "testFolder":Ljava/io/File;
    .restart local v16    # "thumbnailCreated":Z
    :catch_2
    move-exception v5

    .line 340
    .local v5, "e":Ljava/io/IOException;
    :try_start_9
    const-string v17, "Failed to copy."

    move-object/from16 v0, v17

    invoke-static {v0, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_9
    .catch Ljava/lang/ExceptionInInitializerError; {:try_start_9 .. :try_end_9} :catch_0
    .catch Lco/vine/android/recorder/VineFrameGrabber$Exception; {:try_start_9 .. :try_end_9} :catch_0
    .catch Ljava/io/FileNotFoundException; {:try_start_9 .. :try_end_9} :catch_1

    goto/16 :goto_1

    .line 354
    .end local v5    # "e":Ljava/io/IOException;
    .end local v6    # "frame":Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .end local v7    # "grabber":Lco/vine/android/recorder/VineFrameGrabber;
    .end local v8    # "index":I
    .restart local v3    # "duration":J
    :cond_a
    const/16 v17, 0x1

    :try_start_a
    move/from16 v0, v17

    new-array v0, v0, [J

    move-object/from16 v17, v0

    const/16 v19, 0x0

    const-wide/16 v20, 0x0

    aput-wide v20, v17, v19

    goto/16 :goto_2

    .line 380
    .restart local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    :catch_3
    move-exception v5

    .line 381
    .restart local v5    # "e":Ljava/io/IOException;
    const-string v17, "Failed to copy."

    move-object/from16 v0, v17

    invoke-static {v0, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_a
    .catch Ljava/io/FileNotFoundException; {:try_start_a .. :try_end_a} :catch_1

    goto/16 :goto_3

    .line 394
    .end local v3    # "duration":J
    .end local v5    # "e":Ljava/io/IOException;
    .end local v12    # "start":J
    :cond_b
    :try_start_b
    new-instance v17, Ljava/lang/IllegalStateException;

    invoke-direct/range {v17 .. v17}, Ljava/lang/IllegalStateException;-><init>()V

    throw v17
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_4
    .catch Ljava/io/FileNotFoundException; {:try_start_b .. :try_end_b} :catch_1

    .line 397
    .end local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    :catch_4
    move-exception v5

    .line 398
    .local v5, "e":Ljava/lang/Exception;
    :try_start_c
    const-string v17, "Failed to generate thumbnail."

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_c
    .catch Ljava/io/FileNotFoundException; {:try_start_c .. :try_end_c} :catch_1

    goto/16 :goto_4

    .line 408
    .end local v5    # "e":Ljava/lang/Exception;
    .restart local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    :cond_c
    :try_start_d
    new-instance v17, Ljava/lang/IllegalStateException;

    invoke-direct/range {v17 .. v17}, Ljava/lang/IllegalStateException;-><init>()V

    throw v17
    :try_end_d
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_5
    .catch Ljava/io/FileNotFoundException; {:try_start_d .. :try_end_d} :catch_1

    .line 411
    .end local v2    # "bitmaps":[Landroid/graphics/Bitmap;
    :catch_5
    move-exception v5

    .line 412
    .restart local v5    # "e":Ljava/lang/Exception;
    :try_start_e
    const-string v17, "Failed to generate thumbnail."

    invoke-static/range {v17 .. v17}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_e
    .catch Ljava/io/FileNotFoundException; {:try_start_e .. :try_end_e} :catch_1

    goto/16 :goto_5
.end method


# virtual methods
.method public combineVideos()Lco/vine/android/util/MediaUtil$GenerateThumbnailsRunnable;
    .locals 50

    .prologue
    .line 114
    const/16 v45, -0x8

    invoke-static/range {v45 .. v45}, Landroid/os/Process;->setThreadPriority(I)V

    .line 115
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mSegments:Ljava/util/ArrayList;

    move-object/from16 v31, v0

    .line 116
    .local v31, "segments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/RecordSegment;>;"
    invoke-virtual/range {v31 .. v31}, Ljava/util/ArrayList;->size()I

    move-result v32

    .line 117
    .local v32, "size":I
    const-wide/16 v43, 0x0

    .line 118
    .local v43, "videoTotal":J
    const-wide/16 v9, 0x0

    .line 119
    .local v9, "audioTotal":J
    const/16 v34, 0x0

    .line 120
    .local v34, "videoCount":I
    const-string v45, "Processing started: {}."

    invoke-static/range {v32 .. v32}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 121
    const/high16 v45, 0x3f800000    # 1.0f

    move/from16 v0, v32

    int-to-float v0, v0

    move/from16 v46, v0

    div-float v45, v45, v46

    const/high16 v46, 0x40a00000    # 5.0f

    mul-float v22, v45, v46

    .line 122
    .local v22, "increment":F
    const-wide/16 v38, 0x0

    .line 123
    .local v38, "videoDuration":J
    const-wide/16 v5, 0x0

    .line 124
    .local v5, "audioDuration":J
    const/16 v24, 0x0

    .line 125
    .local v24, "nextFrameNumber":I
    const/16 v20, 0x1e

    .line 127
    .local v20, "frameRate":I
    if-lez v32, :cond_10

    .line 128
    const/16 v21, 0x0

    .local v21, "i":I
    :goto_0
    move/from16 v0, v21

    move/from16 v1, v32

    if-ge v0, v1, :cond_e

    .line 129
    move-object/from16 v0, v31

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v30

    check-cast v30, Lco/vine/android/recorder/RecordSegment;

    .line 130
    .local v30, "segment":Lco/vine/android/recorder/RecordSegment;
    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v45, v0

    move/from16 v0, v32

    int-to-float v0, v0

    move/from16 v46, v0

    div-float v45, v45, v46

    const/high16 v46, 0x41200000    # 10.0f

    mul-float v45, v45, v46

    move/from16 v0, v45

    float-to-int v0, v0

    move/from16 v45, v0

    add-int/lit8 v29, v45, 0x5a

    .line 131
    .local v29, "progress":I
    const/4 v14, 0x0

    .line 132
    .local v14, "combined":Lco/vine/android/recorder/AudioData;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAudioArray:[S

    move-object/from16 v45, v0

    if-eqz v45, :cond_1

    .line 133
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 134
    .local v7, "audioTime":J
    invoke-virtual/range {v30 .. v30}, Lco/vine/android/recorder/RecordSegment;->getCombinedAudioData()Lco/vine/android/recorder/AudioData;

    move-result-object v14

    .line 136
    :try_start_0
    iget v0, v14, Lco/vine/android/recorder/AudioData;->size:I

    move/from16 v45, v0

    if-lez v45, :cond_0

    .line 138
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAudioArray:[S

    move-object/from16 v45, v0

    iget v0, v14, Lco/vine/android/recorder/AudioData;->start:I

    move/from16 v46, v0

    iget v0, v14, Lco/vine/android/recorder/AudioData;->size:I

    move/from16 v47, v0

    invoke-static/range {v45 .. v47}, Ljava/nio/ShortBuffer;->wrap([SII)Ljava/nio/ShortBuffer;

    move-result-object v12

    .line 139
    .local v12, "bft":Ljava/nio/ShortBuffer;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mSingleSegment:Z

    move/from16 v45, v0

    if-eqz v45, :cond_6

    .line 140
    iget v0, v14, Lco/vine/android/recorder/AudioData;->size:I

    move/from16 v45, v0

    move/from16 v0, v45

    new-array v13, v0, [S

    .line 141
    .local v13, "buffer":[S
    invoke-virtual {v12, v13}, Ljava/nio/ShortBuffer;->get([S)Ljava/nio/ShortBuffer;

    .line 142
    invoke-static {v13}, Ljava/nio/ShortBuffer;->wrap([S)Ljava/nio/ShortBuffer;

    move-result-object v11

    .line 147
    .end local v13    # "buffer":[S
    .local v11, "bf":Ljava/nio/ShortBuffer;
    :goto_1
    const-string v45, "Recording segment audio: {}, {}."

    iget v0, v14, Lco/vine/android/recorder/AudioData;->start:I

    move/from16 v46, v0

    invoke-static/range {v46 .. v46}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    iget v0, v14, Lco/vine/android/recorder/AudioData;->size:I

    move/from16 v47, v0

    invoke-static/range {v47 .. v47}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v47

    invoke-static/range {v45 .. v47}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 148
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    const/16 v46, 0x1

    move/from16 v0, v46

    new-array v0, v0, [Ljava/nio/Buffer;

    move-object/from16 v46, v0

    const/16 v47, 0x0

    aput-object v11, v46, v47

    invoke-virtual/range {v45 .. v46}, Lco/vine/android/recorder/SwVineFrameRecorder;->record([Ljava/nio/Buffer;)Z
    :try_end_0
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 156
    .end local v11    # "bf":Ljava/nio/ShortBuffer;
    .end local v12    # "bft":Ljava/nio/ShortBuffer;
    :cond_0
    :goto_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v45

    sub-long v45, v45, v7

    add-long v9, v9, v45

    .line 158
    .end local v7    # "audioTime":J
    :cond_1
    invoke-virtual/range {v30 .. v30}, Lco/vine/android/recorder/RecordSegment;->getVideoData()Ljava/util/ArrayList;

    move-result-object v35

    .line 159
    .local v35, "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoArray:[B

    move-object/from16 v36, v0

    .line 160
    .local v36, "videoDataArray":[B
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v41

    .line 161
    .local v41, "videoTime":J
    invoke-virtual/range {v30 .. v30}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v45

    move-object/from16 v0, v45

    iget v0, v0, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move/from16 v20, v0

    .line 162
    invoke-virtual/range {v35 .. v35}, Ljava/util/ArrayList;->size()I

    move-result v37

    .line 164
    .local v37, "videoDataSize":I
    const-wide/16 v27, 0x0

    .line 166
    .local v27, "offset":J
    const/16 v45, 0x0

    move/from16 v0, v45

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoSize:I

    .line 168
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    if-eqz v45, :cond_2

    .line 169
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v46, v0

    add-float v46, v46, v22

    move/from16 v0, v46

    float-to-int v0, v0

    move/from16 v46, v0

    invoke-virtual/range {v45 .. v46}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 172
    :cond_2
    const/16 v23, 0x0

    .local v23, "k":I
    :goto_3
    move/from16 v0, v23

    move/from16 v1, v37

    if-ge v0, v1, :cond_b

    .line 174
    move-object/from16 v0, v35

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v40

    check-cast v40, Lco/vine/android/recorder/VideoData;

    .line 175
    .local v40, "videoPiece":Lco/vine/android/recorder/VideoData;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoSize:I

    move/from16 v45, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->size:I

    move/from16 v46, v0

    add-int v45, v45, v46

    move/from16 v0, v45

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoSize:I

    .line 177
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mSingleSegment:Z

    move/from16 v45, v0

    if-eqz v45, :cond_4

    .line 178
    if-nez v23, :cond_3

    .line 179
    move-object/from16 v0, v40

    iget-wide v0, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    move-wide/from16 v27, v0

    .line 181
    :cond_3
    move-object/from16 v0, v40

    iget-wide v0, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    move-wide/from16 v45, v0

    sub-long v45, v45, v27

    move-wide/from16 v0, v45

    move-object/from16 v2, v40

    iput-wide v0, v2, Lco/vine/android/recorder/VideoData;->timestamp:J

    .line 184
    :cond_4
    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->size:I

    move/from16 v45, v0

    if-gez v45, :cond_8

    .line 172
    :cond_5
    :goto_4
    add-int/lit8 v23, v23, 0x1

    goto :goto_3

    .line 144
    .end local v23    # "k":I
    .end local v27    # "offset":J
    .end local v35    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    .end local v36    # "videoDataArray":[B
    .end local v37    # "videoDataSize":I
    .end local v40    # "videoPiece":Lco/vine/android/recorder/VideoData;
    .end local v41    # "videoTime":J
    .restart local v7    # "audioTime":J
    .restart local v12    # "bft":Ljava/nio/ShortBuffer;
    :cond_6
    move-object v11, v12

    .restart local v11    # "bf":Ljava/nio/ShortBuffer;
    goto/16 :goto_1

    .line 150
    .end local v11    # "bf":Ljava/nio/ShortBuffer;
    .end local v12    # "bft":Ljava/nio/ShortBuffer;
    :catch_0
    move-exception v17

    .line 151
    .local v17, "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->hasLoggedException:Z

    move/from16 v45, v0

    if-eqz v45, :cond_7

    sget-boolean v45, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v45, :cond_0

    .line 152
    :cond_7
    const/16 v45, 0x1

    move/from16 v0, v45

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/SwCombiningRunnable;->hasLoggedException:Z

    .line 153
    invoke-static/range {v17 .. v17}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto/16 :goto_2

    .line 188
    .end local v7    # "audioTime":J
    .end local v17    # "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    .restart local v23    # "k":I
    .restart local v27    # "offset":J
    .restart local v35    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    .restart local v36    # "videoDataArray":[B
    .restart local v37    # "videoDataSize":I
    .restart local v40    # "videoPiece":Lco/vine/android/recorder/VideoData;
    .restart local v41    # "videoTime":J
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    move/from16 v0, v20

    int-to-double v0, v0

    move-wide/from16 v46, v0

    invoke-virtual/range {v45 .. v47}, Lco/vine/android/recorder/SwVineFrameRecorder;->setFrameRate(D)V

    .line 190
    move-object/from16 v0, v40

    iget-wide v0, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    move-wide/from16 v45, v0

    const-wide/16 v47, 0x0

    cmp-long v45, v45, v47

    if-nez v45, :cond_9

    .line 191
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    invoke-virtual/range {v45 .. v45}, Lco/vine/android/recorder/SwVineFrameRecorder;->getTimestamp()J

    move-result-wide v45

    move-wide/from16 v0, v45

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwCombiningRunnable;->mTimeOffset:J

    .line 195
    :cond_9
    move-object/from16 v0, v40

    iget-wide v0, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    move-wide/from16 v45, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mTimeOffset:J

    move-wide/from16 v47, v0

    add-long v15, v45, v47

    .line 197
    .local v15, "determinedTimestamp":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    invoke-virtual/range {v45 .. v45}, Lco/vine/android/recorder/SwVineFrameRecorder;->getFrameNumber()I

    move-result v24

    .line 198
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    invoke-virtual/range {v45 .. v45}, Lco/vine/android/recorder/SwVineFrameRecorder;->getTimestamp()J

    move-result-wide v25

    .line 203
    .local v25, "nextTimestamp":J
    sub-long v45, v15, v25

    const v47, 0xf4240

    div-int v47, v47, v20

    move/from16 v0, v47

    int-to-long v0, v0

    move-wide/from16 v47, v0

    cmp-long v45, v45, v47

    if-lez v45, :cond_a

    .line 204
    const-string v45, "*******Skipped frame*******"

    invoke-static/range {v45 .. v45}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 205
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    move-object/from16 v0, v45

    move-wide v1, v15

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->setTimestampAndGetFrameNumber(J)I

    move-result v24

    .line 211
    :goto_5
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->start:I

    move/from16 v46, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->size:I

    move/from16 v47, v0

    move-object/from16 v0, v40

    iget-boolean v0, v0, Lco/vine/android/recorder/VideoData;->keyFrame:Z

    move/from16 v48, v0

    move-object/from16 v0, v45

    move-object/from16 v1, v36

    move/from16 v2, v46

    move/from16 v3, v47

    move/from16 v4, v48

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/recorder/SwVineFrameRecorder;->writeEncodedImage([BIIZ)V

    .line 213
    add-int/lit8 v34, v34, 0x1

    .line 214
    const-string v45, "Successfully did video frame at {}, #{}."

    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v46

    invoke-static/range {v24 .. v24}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v47

    invoke-static/range {v45 .. v47}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_1
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 239
    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    if-eqz v45, :cond_5

    .line 240
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    move/from16 v0, v29

    int-to-float v0, v0

    move/from16 v46, v0

    add-int/lit8 v47, v23, 0x1

    move/from16 v0, v47

    int-to-float v0, v0

    move/from16 v47, v0

    mul-float v47, v47, v22

    move/from16 v0, v37

    int-to-float v0, v0

    move/from16 v48, v0

    div-float v47, v47, v48

    add-float v47, v47, v22

    add-float v46, v46, v47

    move/from16 v0, v46

    float-to-int v0, v0

    move/from16 v46, v0

    invoke-virtual/range {v45 .. v46}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    goto/16 :goto_4

    .line 207
    :cond_a
    move-wide/from16 v15, v25

    goto :goto_5

    .line 215
    :catch_1
    move-exception v17

    .line 216
    .restart local v17    # "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    const-string v45, "Failed to record video frame at {}. #{}."

    invoke-static/range {v15 .. v16}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v46

    invoke-static/range {v24 .. v24}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v47

    invoke-static/range {v45 .. v47}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 218
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->start:I

    move/from16 v46, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->size:I

    move/from16 v47, v0

    move-object/from16 v0, v40

    iget-boolean v0, v0, Lco/vine/android/recorder/VideoData;->keyFrame:Z

    move/from16 v48, v0

    move-object/from16 v0, v45

    move-object/from16 v1, v36

    move/from16 v2, v46

    move/from16 v3, v47

    move/from16 v4, v48

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/recorder/SwVineFrameRecorder;->writeEncodedImage([BIIZ)V

    .line 220
    add-int/lit8 v34, v34, 0x1

    .line 221
    const-string v45, "Retry successful #{}."

    invoke-static/range {v24 .. v24}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_2
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_6

    .line 222
    :catch_2
    move-exception v18

    .line 223
    .local v18, "e2":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    const-string v45, "Retry again: #{}."

    invoke-static/range {v24 .. v24}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    .line 224
    const-wide/16 v45, 0x3e8

    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v47, v0

    div-long v45, v45, v47

    add-long v15, v15, v45

    .line 225
    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v45, v0

    mul-long v45, v45, v15

    const-wide/16 v47, 0x3e8

    div-long v45, v45, v47

    move-wide/from16 v0, v45

    long-to-float v0, v0

    move/from16 v45, v0

    invoke-static/range {v45 .. v45}, Ljava/lang/Math;->round(F)I

    move-result v24

    .line 226
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    move-object/from16 v0, v45

    move-wide v1, v15

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->setTimestamp(J)V

    .line 227
    move-object/from16 v0, v40

    iput-wide v15, v0, Lco/vine/android/recorder/VideoData;->timestamp:J

    .line 229
    :try_start_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->start:I

    move/from16 v46, v0

    move-object/from16 v0, v40

    iget v0, v0, Lco/vine/android/recorder/VideoData;->size:I

    move/from16 v47, v0

    move-object/from16 v0, v40

    iget-boolean v0, v0, Lco/vine/android/recorder/VideoData;->keyFrame:Z

    move/from16 v48, v0

    move-object/from16 v0, v45

    move-object/from16 v1, v36

    move/from16 v2, v46

    move/from16 v3, v47

    move/from16 v4, v48

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/recorder/SwVineFrameRecorder;->writeEncodedImage([BIIZ)V

    .line 231
    add-int/lit8 v34, v34, 0x1

    .line 232
    const-string v45, "Retry Retry successful #{}."

    invoke-static/range {v24 .. v24}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_3
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto/16 :goto_6

    .line 233
    :catch_3
    move-exception v19

    .line 234
    .local v19, "e3":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->errorCount:I

    move/from16 v45, v0

    add-int/lit8 v45, v45, 0x1

    move/from16 v0, v45

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/recorder/SwCombiningRunnable;->errorCount:I

    .line 235
    const-string v45, "Retry failed: {}."

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->errorCount:I

    move/from16 v46, v0

    invoke-static/range {v46 .. v46}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V

    goto/16 :goto_6

    .line 243
    .end local v15    # "determinedTimestamp":J
    .end local v17    # "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    .end local v18    # "e2":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    .end local v19    # "e3":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    .end local v25    # "nextTimestamp":J
    .end local v40    # "videoPiece":Lco/vine/android/recorder/VideoData;
    :cond_b
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v45

    sub-long v45, v45, v41

    add-long v43, v43, v45

    .line 244
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    if-eqz v45, :cond_c

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    add-int/lit8 v46, v21, 0x1

    mul-int/lit8 v46, v46, 0xa

    div-int v46, v46, v32

    add-int/lit8 v46, v46, 0x5a

    invoke-virtual/range {v45 .. v46}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 247
    :cond_c
    if-eqz v14, :cond_d

    sget-boolean v45, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v45, :cond_d

    .line 248
    invoke-virtual {v14}, Lco/vine/android/recorder/AudioData;->getDurationNs()J

    move-result-wide v45

    const-wide/16 v47, 0x3e8

    div-long v45, v45, v47

    add-long v5, v5, v45

    .line 249
    const/16 v45, 0x3e8

    div-int v45, v45, v20

    mul-int v45, v45, v37

    move/from16 v0, v45

    int-to-long v0, v0

    move-wide/from16 v45, v0

    add-long v38, v38, v45

    .line 250
    const-string v45, "Recorded segment with time: audio: {}, video: {}."

    invoke-virtual {v14}, Lco/vine/android/recorder/AudioData;->getDurationNs()J

    move-result-wide v46

    const-wide/16 v48, 0x3e8

    div-long v46, v46, v48

    invoke-static/range {v46 .. v47}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v46

    const/16 v47, 0x3e8

    div-int v47, v47, v20

    mul-int v47, v47, v37

    invoke-static/range {v47 .. v47}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v47

    invoke-static/range {v45 .. v47}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 252
    :cond_d
    const-string v45, "Video Count: {}."

    invoke-static/range {v34 .. v34}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 128
    add-int/lit8 v21, v21, 0x1

    goto/16 :goto_0

    .line 254
    .end local v14    # "combined":Lco/vine/android/recorder/AudioData;
    .end local v23    # "k":I
    .end local v27    # "offset":J
    .end local v29    # "progress":I
    .end local v30    # "segment":Lco/vine/android/recorder/RecordSegment;
    .end local v35    # "videoData":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/recorder/VideoData;>;"
    .end local v36    # "videoDataArray":[B
    .end local v37    # "videoDataSize":I
    .end local v41    # "videoTime":J
    :cond_e
    const-string v45, "Done with all segments. total time: audio: {}, video: {}."

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v46

    invoke-static/range {v38 .. v39}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v47

    invoke-static/range {v45 .. v47}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 255
    const/16 v33, 0x0

    .line 257
    .local v33, "success":Z
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v45, v0

    invoke-virtual/range {v45 .. v45}, Lco/vine/android/recorder/SwVineFrameRecorder;->stop()V
    :try_end_4
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 258
    const/16 v33, 0x1

    .line 262
    :goto_7
    if-eqz v33, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v45, v0

    if-eqz v45, :cond_f

    .line 263
    new-instance v45, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoRecorder:Lco/vine/android/recorder/SwVineFrameRecorder;

    move-object/from16 v46, v0

    invoke-virtual/range {v46 .. v46}, Lco/vine/android/recorder/SwVineFrameRecorder;->getFilename()Ljava/lang/String;

    move-result-object v46

    invoke-direct/range {v45 .. v46}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    new-instance v46, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mVideoPath:Ljava/lang/String;

    move-object/from16 v47, v0

    invoke-direct/range {v46 .. v47}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v45 .. v46}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v33

    .line 264
    if-nez v33, :cond_f

    .line 265
    const-string v45, "Error renaming to final fn."

    invoke-static/range {v45 .. v45}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 268
    :cond_f
    const-string v45, "Combining finished: {}"

    invoke-static/range {v33 .. v33}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 269
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v45, v0

    if-eqz v45, :cond_10

    .line 270
    move-object/from16 v0, p0

    move/from16 v1, v34

    move/from16 v2, v24

    move/from16 v3, v20

    invoke-direct {v0, v1, v2, v3}, Lco/vine/android/recorder/SwCombiningRunnable;->saveThumbnail(III)V

    .line 273
    .end local v21    # "i":I
    .end local v33    # "success":Z
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    if-eqz v45, :cond_11

    .line 274
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    move-object/from16 v45, v0

    const/16 v46, 0x63

    invoke-virtual/range {v45 .. v46}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 276
    :cond_11
    const-string v45, "Processing thread finished: failed {} frames."

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/recorder/SwCombiningRunnable;->errorCount:I

    move/from16 v46, v0

    invoke-static/range {v46 .. v46}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v46

    invoke-static/range {v45 .. v46}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 277
    const-string v45, "Time used: video: {}, audio: {}, n: {}."

    invoke-static/range {v43 .. v44}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v46

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v47

    invoke-static/range {v32 .. v32}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v48

    invoke-static/range {v45 .. v48}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 278
    const/16 v45, 0x0

    return-object v45

    .line 259
    .restart local v21    # "i":I
    .restart local v33    # "success":Z
    :catch_4
    move-exception v17

    .line 260
    .restart local v17    # "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    const-string v45, "Error flushing..."

    const/16 v46, 0x1

    move/from16 v0, v46

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v46, v0

    const/16 v47, 0x0

    aput-object v17, v46, v47

    invoke-static/range {v45 .. v46}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_7
.end method
