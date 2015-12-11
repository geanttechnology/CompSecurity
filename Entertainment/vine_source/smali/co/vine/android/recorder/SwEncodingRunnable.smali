.class public Lco/vine/android/recorder/SwEncodingRunnable;
.super Lco/vine/android/recorder/AbstractEncodingRunnable;
.source "SwEncodingRunnable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;
    }
.end annotation


# static fields
.field private static final sInstanceCounter:Lco/vine/android/util/InstanceCounter;

.field private static sRunningInstances:I


# instance fields
.field private mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

.field private final mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

.field private final mCameraManager:Lco/vine/android/recorder/CameraManager;

.field private final mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;"
        }
    .end annotation
.end field

.field private mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

.field private final mEncodingImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

.field private final mEncodingTempPath:Ljava/lang/String;

.field private mLastSegment:Lco/vine/android/recorder/RecordSegment;

.field private mMatrixBitmap:Landroid/graphics/Bitmap;

.field private mMatrixCanvas:Landroid/graphics/Canvas;

.field private mMaxEncodedSize:I

.field private final mOutput:Ljava/lang/String;

.field private final mPictureConverter:Lco/vine/android/recorder/PictureConverter;

.field private final mProducer:Lco/vine/android/recorder/RecordController;

.field private final mRecorderFrameRate:I

.field private volatile mTerminateImmediately:Z

.field private final mThumbnailBitmap:Landroid/graphics/Bitmap;

.field private final mThumbnailCanvas:Landroid/graphics/Canvas;

.field private final mThumbnailMatrix:Landroid/graphics/Matrix;

.field private mTotalProcessed:I

.field private final mUseMp4:Z

.field private final mVideoDataBufferMax:[B

.field private mVideoDataBufferPosition:I

.field private timeToMatrix:J

.field private timeToRGB:J

.field private timeToRecord:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 60
    new-instance v0, Lco/vine/android/util/InstanceCounter;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Lco/vine/android/util/InstanceCounter;-><init>(I)V

    sput-object v0, Lco/vine/android/recorder/SwEncodingRunnable;->sInstanceCounter:Lco/vine/android/util/InstanceCounter;

    return-void
.end method

.method public constructor <init>(Ljava/util/concurrent/ConcurrentLinkedQueue;[BLco/vine/android/recorder/RecordController;Ljava/lang/String;ILcom/googlecode/javacv/cpp/opencv_core$IplImage;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lco/vine/android/recorder/PictureConverter;ILco/vine/android/recorder/CameraManager;Lco/vine/android/recorder/ByteBufferQueue;Landroid/graphics/Matrix;Landroid/graphics/Canvas;Landroid/graphics/Canvas;Z)V
    .locals 3
    .param p2, "videoDataBufferMax"    # [B
    .param p3, "producer"    # Lco/vine/android/recorder/RecordController;
    .param p4, "output"    # Ljava/lang/String;
    .param p5, "frameRate"    # I
    .param p6, "image"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p7, "bitmap"    # Landroid/graphics/Bitmap;
    .param p8, "thumbnailBitmap"    # Landroid/graphics/Bitmap;
    .param p9, "pc"    # Lco/vine/android/recorder/PictureConverter;
    .param p10, "videoBufferPosition"    # I
    .param p11, "cameraManager"    # Lco/vine/android/recorder/CameraManager;
    .param p12, "byteBufferQueue"    # Lco/vine/android/recorder/ByteBufferQueue;
    .param p13, "thumbnailMatrix"    # Landroid/graphics/Matrix;
    .param p14, "thumbnailCanvas"    # Landroid/graphics/Canvas;
    .param p15, "matrixCanvas"    # Landroid/graphics/Canvas;
    .param p16, "useMp4"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;[B",
            "Lco/vine/android/recorder/RecordController;",
            "Ljava/lang/String;",
            "I",
            "Lcom/googlecode/javacv/cpp/opencv_core$IplImage;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            "Lco/vine/android/recorder/PictureConverter;",
            "I",
            "Lco/vine/android/recorder/CameraManager;",
            "Lco/vine/android/recorder/ByteBufferQueue;",
            "Landroid/graphics/Matrix;",
            "Landroid/graphics/Canvas;",
            "Landroid/graphics/Canvas;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 67
    .local p1, "queue":Ljava/util/concurrent/ConcurrentLinkedQueue;, "Ljava/util/concurrent/ConcurrentLinkedQueue<Lco/vine/android/recorder/VideoData;>;"
    invoke-direct {p0}, Lco/vine/android/recorder/AbstractEncodingRunnable;-><init>()V

    .line 49
    const/4 v1, 0x0

    iput-boolean v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    .line 68
    sget-object v1, Lco/vine/android/recorder/SwEncodingRunnable;->sInstanceCounter:Lco/vine/android/util/InstanceCounter;

    invoke-virtual {v1, p0}, Lco/vine/android/util/InstanceCounter;->onCreate(Ljava/lang/Object;)I

    .line 69
    iput-object p6, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncodingImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    .line 70
    move/from16 v0, p16

    iput-boolean v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mUseMp4:Z

    .line 71
    iput-object p1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 72
    iput-object p3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    .line 73
    iput-object p7, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;

    .line 74
    iput-object p8, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mThumbnailBitmap:Landroid/graphics/Bitmap;

    .line 75
    iput-object p11, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    .line 76
    move-object/from16 v0, p14

    iput-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mThumbnailCanvas:Landroid/graphics/Canvas;

    .line 77
    move-object/from16 v0, p15

    iput-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mMatrixCanvas:Landroid/graphics/Canvas;

    .line 78
    iput-object p2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferMax:[B

    .line 79
    iput p10, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferPosition:I

    .line 80
    iput-object p9, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    .line 81
    iput p5, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mRecorderFrameRate:I

    .line 82
    iput-object p4, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mOutput:Ljava/lang/String;

    .line 83
    move-object/from16 v0, p13

    iput-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mThumbnailMatrix:Landroid/graphics/Matrix;

    .line 84
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mOutput:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".encode"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncodingTempPath:Ljava/lang/String;

    .line 85
    iput-object p12, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    .line 86
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    invoke-virtual {v1}, Lco/vine/android/recorder/ByteBufferQueue;->isFresh()Z

    move-result v1

    if-nez v1, :cond_1

    .line 87
    :cond_0
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Invalid buffer queue."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 89
    :cond_1
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/recorder/SwEncodingRunnable;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/SwEncodingRunnable;

    .prologue
    .line 27
    invoke-direct {p0}, Lco/vine/android/recorder/SwEncodingRunnable;->makeNewEncoder()V

    return-void
.end method

.method static synthetic access$100(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/SwEncodingRunnable;

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/RecordController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/SwEncodingRunnable;

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/SwEncodingRunnable;

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/recorder/SwEncodingRunnable;Ljava/util/LinkedList;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/SwEncodingRunnable;
    .param p1, "x1"    # Ljava/util/LinkedList;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lco/vine/android/recorder/SwEncodingRunnable;->stopEncoder(Ljava/util/LinkedList;)V

    return-void
.end method

.method private doVideoFrame(Ljava/util/LinkedList;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Z)Z
    .locals 5
    .param p2, "image"    # Lcom/googlecode/javacv/cpp/opencv_core$IplImage;
    .param p3, "newSegment"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/LinkedList",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;",
            "Lcom/googlecode/javacv/cpp/opencv_core$IplImage;",
            "Z)Z"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
        }
    .end annotation

    .prologue
    .local p1, "bufferedVideoData":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/recorder/VideoData;>;"
    const/4 v1, 0x1

    .line 227
    iget-object v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    if-nez v2, :cond_1

    .line 228
    invoke-direct {p0}, Lco/vine/android/recorder/SwEncodingRunnable;->makeNewEncoder()V

    .line 235
    :cond_0
    :goto_0
    invoke-virtual {p1}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/VideoData;

    .line 236
    .local v0, "data":Lco/vine/android/recorder/VideoData;
    iget-object v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferMax:[B

    iget v4, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferPosition:I

    invoke-virtual {v2, p2, v3, v4}, Lco/vine/android/recorder/SwVineFrameRecorder;->encode(Lcom/googlecode/javacv/cpp/opencv_core$IplImage;[BI)I

    move-result v2

    iput v2, v0, Lco/vine/android/recorder/VideoData;->size:I

    .line 237
    const-string v2, "Encoded video frame size {}. Total processed {}."

    iget v3, v0, Lco/vine/android/recorder/VideoData;->size:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget v4, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTotalProcessed:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 238
    iget v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTotalProcessed:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTotalProcessed:I

    .line 239
    iget v2, v0, Lco/vine/android/recorder/VideoData;->size:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_2

    .line 240
    iget v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferPosition:I

    iput v2, v0, Lco/vine/android/recorder/VideoData;->start:I

    .line 241
    iput-boolean v1, v0, Lco/vine/android/recorder/VideoData;->keyFrame:Z

    .line 242
    iget v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mMaxEncodedSize:I

    iget v3, v0, Lco/vine/android/recorder/VideoData;->size:I

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mMaxEncodedSize:I

    .line 243
    iget v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferPosition:I

    iget v3, v0, Lco/vine/android/recorder/VideoData;->size:I

    add-int/2addr v2, v3

    iput v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mVideoDataBufferPosition:I

    .line 244
    invoke-virtual {p1}, Ljava/util/LinkedList;->pop()Ljava/lang/Object;

    .line 248
    :goto_1
    return v1

    .line 230
    .end local v0    # "data":Lco/vine/android/recorder/VideoData;
    :cond_1
    if-eqz p3, :cond_0

    .line 231
    invoke-direct {p0, p1}, Lco/vine/android/recorder/SwEncodingRunnable;->stopEncoder(Ljava/util/LinkedList;)V

    .line 232
    invoke-direct {p0}, Lco/vine/android/recorder/SwEncodingRunnable;->makeNewEncoder()V

    goto :goto_0

    .line 247
    .restart local v0    # "data":Lco/vine/android/recorder/VideoData;
    :cond_2
    const-string v1, "******Image was buffered to the next frame.********"

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 248
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private makeNewEncoder()V
    .locals 5

    .prologue
    .line 157
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncodingTempPath:Ljava/lang/String;

    iget v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mRecorderFrameRate:I

    const/16 v3, 0x1e0

    iget-boolean v4, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mUseMp4:Z

    invoke-static {v1, v2, v3, v4}, Lco/vine/android/recorder/RecordConfigUtils;->newVideoRecorder(Ljava/lang/String;IIZ)Lco/vine/android/recorder/SwVineFrameRecorder;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    .line 159
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->start()V
    :try_end_0
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 163
    :goto_0
    return-void

    .line 160
    :catch_0
    move-exception v0

    .line 161
    .local v0, "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    const-string v1, "Failed to start encoder"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private process(Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;Z)V
    .locals 5
    .param p1, "runnable"    # Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;
    .param p2, "waitForMore"    # Z

    .prologue
    .line 312
    :cond_0
    :goto_0
    iget-boolean v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    if-nez v3, :cond_2

    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v3}, Ljava/util/concurrent/ConcurrentLinkedQueue;->poll()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/recorder/VideoData;

    .local v2, "next":Lco/vine/android/recorder/VideoData;
    if-nez v2, :cond_1

    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 313
    :cond_1
    if-nez v2, :cond_3

    .line 314
    if-eqz p2, :cond_0

    .line 316
    const-wide/16 v3, 0x64

    :try_start_0
    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 317
    :catch_0
    move-exception v1

    .line 318
    .local v1, "e":Ljava/lang/InterruptedException;
    const-string v3, "Break signal reached."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 327
    .end local v1    # "e":Ljava/lang/InterruptedException;
    .end local v2    # "next":Lco/vine/android/recorder/VideoData;
    :cond_2
    return-void

    .line 323
    .restart local v2    # "next":Lco/vine/android/recorder/VideoData;
    :cond_3
    invoke-virtual {p1, v2}, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->add(Lco/vine/android/recorder/VideoData;)[B

    move-result-object v0

    .line 324
    .local v0, "data":[B
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    if-nez p2, :cond_4

    const/4 v3, 0x1

    :goto_1
    invoke-virtual {v4, v0, v3}, Lco/vine/android/recorder/CameraManager;->addBuffer([BZ)V

    goto :goto_0

    :cond_4
    const/4 v3, 0x0

    goto :goto_1
.end method

.method private stopEncoder(Ljava/util/LinkedList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/LinkedList",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 254
    .local p1, "bufferedVideoData":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/recorder/VideoData;>;"
    :cond_0
    :try_start_0
    invoke-virtual {p1}, Ljava/util/LinkedList;->size()I

    move-result v1

    if-lez v1, :cond_1

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-direct {p0, p1, v1, v2}, Lco/vine/android/recorder/SwEncodingRunnable;->doVideoFrame(Ljava/util/LinkedList;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Z)Z

    move-result v1

    if-nez v1, :cond_0

    .line 255
    :cond_1
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->stopEncoding()V
    :try_end_0
    .catch Lco/vine/android/recorder/SwVineFrameRecorder$Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 259
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    .line 261
    :goto_0
    return-void

    .line 256
    :catch_0
    move-exception v0

    .line 257
    .local v0, "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    :try_start_1
    const-string v1, "Error flushing..."

    invoke-static {v1, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 259
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v1}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    goto :goto_0

    .end local v0    # "e":Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/SwVineFrameRecorder;

    invoke-virtual {v2}, Lco/vine/android/recorder/SwVineFrameRecorder;->release()V

    throw v1
.end method


# virtual methods
.method public getOutput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mOutput:Ljava/lang/String;

    return-object v0
.end method

.method public processVideoData(Ljava/util/LinkedList;Lco/vine/android/recorder/VideoData;)[B
    .locals 23
    .param p2, "next"    # Lco/vine/android/recorder/VideoData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/LinkedList",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;",
            "Lco/vine/android/recorder/VideoData;",
            ")[B"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/SwVineFrameRecorder$Exception;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 166
    .local p1, "bufferedVideoData":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Lco/vine/android/recorder/VideoData;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mLastSegment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    move-object/from16 v0, p2

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-eq v0, v1, :cond_2

    const/4 v11, 0x1

    .line 167
    .local v11, "newSegment":Z
    :goto_0
    move-object/from16 v0, p2

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/recorder/SwEncodingRunnable;->mLastSegment:Lco/vine/android/recorder/RecordSegment;

    .line 168
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/recorder/PictureConverter;->LOCK:[I

    move-object/from16 v18, v0

    monitor-enter v18

    .line 169
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    .line 170
    .local v14, "startTime":J
    move-object/from16 v0, p2

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lco/vine/android/recorder/RecordSegment;->getCameraSetting()Lco/vine/android/recorder/CameraSetting;

    move-result-object v4

    .line 171
    .local v4, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Lco/vine/android/recorder/PictureConverter;->updateSettingsIfNeeded(Lco/vine/android/recorder/CameraSetting;)Z

    move-result v10

    .line 173
    .local v10, "hasChanged":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    move-object/from16 v17, v0

    iget v0, v4, Lco/vine/android/recorder/CameraSetting;->degrees:I

    move/from16 v19, v0

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lco/vine/android/recorder/PictureConverter;->giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(IZ)V

    .line 176
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v4, v1, v10}, Lco/vine/android/recorder/PictureConverter;->convert(Lco/vine/android/recorder/CameraSetting;Lco/vine/android/recorder/VideoData;Z)Z

    .line 178
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->timeToRGB:J

    move-wide/from16 v19, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v21

    sub-long v21, v21, v14

    add-long v19, v19, v21

    move-wide/from16 v0, v19

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwEncodingRunnable;->timeToRGB:J

    .line 179
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    .line 183
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mMatrixCanvas:Landroid/graphics/Canvas;

    move-object/from16 v19, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/PictureConverter;->draw(Landroid/graphics/Canvas;)V

    .line 185
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->timeToMatrix:J

    move-wide/from16 v19, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v21

    sub-long v21, v21, v14

    add-long v19, v19, v21

    move-wide/from16 v0, v19

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwEncodingRunnable;->timeToMatrix:J

    .line 186
    monitor-exit v18
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 189
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncodingImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/googlecode/javacv/cpp/opencv_core$IplImage;->getByteBuffer()Ljava/nio/ByteBuffer;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/graphics/Bitmap;->copyPixelsToBuffer(Ljava/nio/Buffer;)V

    .line 191
    if-eqz v11, :cond_0

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    move/from16 v17, v0

    if-nez v17, :cond_0

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mThumbnailCanvas:Landroid/graphics/Canvas;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mThumbnailMatrix:Landroid/graphics/Matrix;

    move-object/from16 v20, v0

    invoke-virtual/range {v17 .. v20}, Lco/vine/android/recorder/PictureConverter;->drawGeneric(Landroid/graphics/Canvas;Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V

    .line 193
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mOutput:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "."

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    invoke-virtual/range {v17 .. v19}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, ".jpg"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 194
    .local v13, "path":Ljava/lang/String;
    move-object/from16 v0, p2

    iget-object v0, v0, Lco/vine/android/recorder/VideoData;->segment:Lco/vine/android/recorder/RecordSegment;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Lco/vine/android/recorder/RecordSegment;->setThumbnailPath(Ljava/lang/String;)V

    .line 195
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 196
    .local v8, "f":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v12

    .line 198
    .local v12, "parentFile":Ljava/io/File;
    :try_start_1
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 199
    .local v3, "bos":Ljava/io/ByteArrayOutputStream;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mThumbnailBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v17, v0

    sget-object v18, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v19, 0x64

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v0, v1, v2, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 200
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

    .line 201
    .local v5, "compressed":[B
    new-instance v9, Ljava/io/FileOutputStream;

    invoke-direct {v9, v8}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 202
    .local v9, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {v9, v5}, Ljava/io/FileOutputStream;->write([B)V

    .line 203
    invoke-virtual {v9}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    .line 215
    .end local v3    # "bos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "compressed":[B
    .end local v8    # "f":Ljava/io/File;
    .end local v9    # "fos":Ljava/io/FileOutputStream;
    .end local v12    # "parentFile":Ljava/io/File;
    .end local v13    # "path":Ljava/lang/String;
    :cond_0
    :goto_1
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    move/from16 v17, v0

    if-nez v17, :cond_1

    .line 216
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    .line 217
    invoke-virtual/range {p1 .. p2}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 218
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncodingImage:Lcom/googlecode/javacv/cpp/opencv_core$IplImage;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v17

    invoke-direct {v0, v1, v2, v11}, Lco/vine/android/recorder/SwEncodingRunnable;->doVideoFrame(Ljava/util/LinkedList;Lcom/googlecode/javacv/cpp/opencv_core$IplImage;Z)Z

    .line 219
    move-object/from16 v0, p0

    iget-wide v0, v0, Lco/vine/android/recorder/SwEncodingRunnable;->timeToRecord:J

    move-wide/from16 v17, v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v19

    sub-long v19, v19, v14

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    move-object/from16 v2, p0

    iput-wide v0, v2, Lco/vine/android/recorder/SwEncodingRunnable;->timeToRecord:J

    .line 221
    :cond_1
    move-object/from16 v0, p2

    iget-object v6, v0, Lco/vine/android/recorder/VideoData;->data:[B

    .line 222
    .local v6, "data":[B
    const/16 v17, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    iput-object v0, v1, Lco/vine/android/recorder/VideoData;->data:[B

    .line 223
    return-object v6

    .line 166
    .end local v4    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .end local v6    # "data":[B
    .end local v10    # "hasChanged":Z
    .end local v11    # "newSegment":Z
    .end local v14    # "startTime":J
    :cond_2
    const/4 v11, 0x0

    goto/16 :goto_0

    .line 186
    .restart local v11    # "newSegment":Z
    :catchall_0
    move-exception v17

    :try_start_2
    monitor-exit v18
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v17

    .line 204
    .restart local v4    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .restart local v8    # "f":Ljava/io/File;
    .restart local v10    # "hasChanged":Z
    .restart local v12    # "parentFile":Ljava/io/File;
    .restart local v13    # "path":Ljava/lang/String;
    .restart local v14    # "startTime":J
    :catch_0
    move-exception v7

    .line 205
    .local v7, "e":Ljava/lang/Throwable;
    invoke-static {v12}, Lco/vine/android/recorder/RecordSessionManager;->wasSessionJustDeleted(Ljava/io/File;)Z

    move-result v16

    .line 206
    .local v16, "wasSessionJustDeleted":Z
    if-eqz v16, :cond_3

    .line 207
    const/16 v17, 0x1

    move/from16 v0, v17

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    .line 208
    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 210
    :cond_3
    throw v7
.end method

.method public run()V
    .locals 10

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 274
    sget v3, Lco/vine/android/recorder/SwEncodingRunnable;->sRunningInstances:I

    add-int/lit8 v3, v3, 0x1

    sput v3, Lco/vine/android/recorder/SwEncodingRunnable;->sRunningInstances:I

    .line 275
    const-string v3, "Encoder Count"

    sget v4, Lco/vine/android/recorder/SwEncodingRunnable;->sRunningInstances:I

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;I)V

    .line 276
    const/16 v3, 0x13

    invoke-static {v3}, Landroid/os/Process;->setThreadPriority(I)V

    .line 277
    const-string v3, "[ML] Processing started: {}, running: {}"

    new-array v4, v9, [Ljava/lang/Object;

    iget-object v5, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mOutput:Ljava/lang/String;

    aput-object v5, v4, v8

    sget v5, Lco/vine/android/recorder/SwEncodingRunnable;->sRunningInstances:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 278
    new-instance v1, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;

    invoke-direct {v1, p0}, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;-><init>(Lco/vine/android/recorder/SwEncodingRunnable;)V

    .line 279
    .local v1, "encodingRunnable":Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;
    iput-boolean v7, v1, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mRun:Z

    .line 280
    new-instance v2, Ljava/lang/Thread;

    invoke-direct {v2, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 281
    .local v2, "encodingThread":Ljava/lang/Thread;
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 282
    :goto_0
    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-boolean v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    if-nez v3, :cond_0

    .line 283
    invoke-direct {p0, v1, v7}, Lco/vine/android/recorder/SwEncodingRunnable;->process(Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;Z)V

    goto :goto_0

    .line 285
    :cond_0
    const-string v3, "[ML] Flushing..."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 286
    iget-boolean v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    if-nez v3, :cond_2

    .line 287
    invoke-direct {p0, v1, v8}, Lco/vine/android/recorder/SwEncodingRunnable;->process(Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;Z)V

    .line 291
    :goto_1
    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    invoke-virtual {v3}, Lco/vine/android/recorder/ByteBufferQueue;->endOfPut()V

    .line 292
    const-string v3, "[ML] Waiting for encoding prcess thread to end..."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 294
    :try_start_0
    invoke-virtual {v2}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 298
    :goto_2
    const-string v3, "[ML] Encoding process thread ended"

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 299
    new-instance v3, Ljava/io/File;

    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mEncodingTempPath:Ljava/lang/String;

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Lorg/apache/commons/io/FileUtils;->deleteQuietly(Ljava/io/File;)Z

    .line 300
    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    if-eqz v3, :cond_1

    .line 301
    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    const/16 v4, 0x5a

    invoke-virtual {v3, v4}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 303
    :cond_1
    const-string v3, "Time used: rgb: {}, matrix: {}, encode: {}, n: {}, max: {}."

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/Object;

    iget-wide v5, p0, Lco/vine/android/recorder/SwEncodingRunnable;->timeToRGB:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v4, v8

    iget-wide v5, p0, Lco/vine/android/recorder/SwEncodingRunnable;->timeToMatrix:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v4, v7

    iget-wide v5, p0, Lco/vine/android/recorder/SwEncodingRunnable;->timeToRecord:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v4, v9

    const/4 v5, 0x3

    iget v6, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTotalProcessed:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x4

    iget v6, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mMaxEncodedSize:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 305
    const/4 v3, 0x0

    iput-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mLastSegment:Lco/vine/android/recorder/RecordSegment;

    .line 306
    const-string v3, "[ML] Processing Ended: {}."

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mOutput:Ljava/lang/String;

    aput-object v5, v4, v8

    invoke-static {v3, v4}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 307
    sget v3, Lco/vine/android/recorder/SwEncodingRunnable;->sRunningInstances:I

    add-int/lit8 v3, v3, -0x1

    sput v3, Lco/vine/android/recorder/SwEncodingRunnable;->sRunningInstances:I

    .line 308
    return-void

    .line 289
    :cond_2
    const-string v3, "Terminate without saving...."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_1

    .line 295
    :catch_0
    move-exception v0

    .line 296
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v3, "Interrupted."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_2
.end method

.method public setAsyncTask(Lco/vine/android/recorder/BaseFinishProcessTask;)V
    .locals 0
    .param p1, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;

    .prologue
    .line 264
    iput-object p1, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    .line 265
    return-void
.end method

.method public terminate()V
    .locals 1

    .prologue
    .line 268
    const-string v0, "Terminate without saving turned on."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 269
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/SwEncodingRunnable;->mTerminateImmediately:Z

    .line 270
    return-void
.end method
