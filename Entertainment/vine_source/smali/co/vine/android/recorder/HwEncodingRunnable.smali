.class public Lco/vine/android/recorder/HwEncodingRunnable;
.super Lco/vine/android/recorder/AbstractEncodingRunnable;
.source "HwEncodingRunnable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;
    }
.end annotation


# instance fields
.field private mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

.field private final mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

.field private final mCameraManager:Lco/vine/android/recorder/CameraManager;

.field private final mContext:Landroid/content/Context;

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

.field private mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;

.field private final mEncodingRunnable:Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

.field private final mEncodingThread:Ljava/lang/Thread;

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

.field private final mVideoDataBufferMax:[B

.field private mVideoDataBufferPosition:I

.field private timeToMatrix:J

.field private timeToRGB:J

.field private timeToRecord:J


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/concurrent/ConcurrentLinkedQueue;[BLco/vine/android/recorder/RecordController;Ljava/lang/String;ILjava/nio/ByteBuffer;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lco/vine/android/recorder/PictureConverter;ILco/vine/android/recorder/CameraManager;Lco/vine/android/recorder/ByteBufferQueue;Landroid/graphics/Matrix;Landroid/graphics/Canvas;Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "videoDataBufferMax"    # [B
    .param p4, "producer"    # Lco/vine/android/recorder/RecordController;
    .param p5, "output"    # Ljava/lang/String;
    .param p6, "frameRate"    # I
    .param p7, "buffer"    # Ljava/nio/ByteBuffer;
    .param p8, "bitmap"    # Landroid/graphics/Bitmap;
    .param p9, "thumbnailBitmap"    # Landroid/graphics/Bitmap;
    .param p10, "pc"    # Lco/vine/android/recorder/PictureConverter;
    .param p11, "videoBufferPosition"    # I
    .param p12, "cameraManager"    # Lco/vine/android/recorder/CameraManager;
    .param p13, "byteBufferQueue"    # Lco/vine/android/recorder/ByteBufferQueue;
    .param p14, "thumbnailMatrix"    # Landroid/graphics/Matrix;
    .param p15, "thumbnailCanvas"    # Landroid/graphics/Canvas;
    .param p16, "matrixCanvas"    # Landroid/graphics/Canvas;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;[B",
            "Lco/vine/android/recorder/RecordController;",
            "Ljava/lang/String;",
            "I",
            "Ljava/nio/ByteBuffer;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            "Lco/vine/android/recorder/PictureConverter;",
            "I",
            "Lco/vine/android/recorder/CameraManager;",
            "Lco/vine/android/recorder/ByteBufferQueue;",
            "Landroid/graphics/Matrix;",
            "Landroid/graphics/Canvas;",
            "Landroid/graphics/Canvas;",
            ")V"
        }
    .end annotation

    .prologue
    .line 61
    .local p2, "queue":Ljava/util/concurrent/ConcurrentLinkedQueue;, "Ljava/util/concurrent/ConcurrentLinkedQueue<Lco/vine/android/recorder/VideoData;>;"
    invoke-direct {p0}, Lco/vine/android/recorder/AbstractEncodingRunnable;-><init>()V

    .line 47
    const/4 v1, 0x0

    iput-boolean v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    .line 62
    iput-object p1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mContext:Landroid/content/Context;

    .line 63
    iput-object p2, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 64
    iput-object p4, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    .line 65
    iput-object p8, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;

    .line 66
    iput-object p9, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailBitmap:Landroid/graphics/Bitmap;

    .line 67
    iput-object p12, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    .line 68
    move-object/from16 v0, p15

    iput-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailCanvas:Landroid/graphics/Canvas;

    .line 69
    move-object/from16 v0, p16

    iput-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixCanvas:Landroid/graphics/Canvas;

    .line 70
    iput-object p3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferMax:[B

    .line 71
    iput p11, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I

    .line 72
    iput-object p10, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    .line 73
    iput p6, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mRecorderFrameRate:I

    .line 74
    iput-object p5, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mOutput:Ljava/lang/String;

    .line 75
    move-object/from16 v0, p14

    iput-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailMatrix:Landroid/graphics/Matrix;

    .line 76
    move-object/from16 v0, p13

    iput-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    .line 77
    new-instance v1, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

    invoke-direct {v1, p0, p7}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;-><init>(Lco/vine/android/recorder/HwEncodingRunnable;Ljava/nio/ByteBuffer;)V

    iput-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingRunnable:Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

    .line 78
    new-instance v1, Ljava/lang/Thread;

    iget-object v2, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingRunnable:Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingThread:Ljava/lang/Thread;

    .line 79
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    invoke-virtual {v1}, Lco/vine/android/recorder/ByteBufferQueue;->isFresh()Z

    move-result v1

    if-nez v1, :cond_0

    .line 80
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Invalid buffer queue."

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 82
    :cond_0
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/RecordController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/PictureConverter;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mPictureConverter:Lco/vine/android/recorder/PictureConverter;

    return-object v0
.end method

.method static synthetic access$1114(Lco/vine/android/recorder/HwEncodingRunnable;J)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # J

    .prologue
    .line 25
    iget-wide v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToRGB:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToRGB:J

    return-wide v0
.end method

.method static synthetic access$1200(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Canvas;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixCanvas:Landroid/graphics/Canvas;

    return-object v0
.end method

.method static synthetic access$1314(Lco/vine/android/recorder/HwEncodingRunnable;J)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # J

    .prologue
    .line 25
    iget-wide v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToMatrix:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToMatrix:J

    return-wide v0
.end method

.method static synthetic access$1400(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mMatrixBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$1500(Lco/vine/android/recorder/HwEncodingRunnable;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-boolean v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    return v0
.end method

.method static synthetic access$1502(Lco/vine/android/recorder/HwEncodingRunnable;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # Z

    .prologue
    .line 25
    iput-boolean p1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    return p1
.end method

.method static synthetic access$1600(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Canvas;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailCanvas:Landroid/graphics/Canvas;

    return-object v0
.end method

.method static synthetic access$1700(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Matrix;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailMatrix:Landroid/graphics/Matrix;

    return-object v0
.end method

.method static synthetic access$1800(Lco/vine/android/recorder/HwEncodingRunnable;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mOutput:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1900(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mThumbnailBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/BaseFinishProcessTask;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    return-object v0
.end method

.method static synthetic access$2014(Lco/vine/android/recorder/HwEncodingRunnable;J)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # J

    .prologue
    .line 25
    iget-wide v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToRecord:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToRecord:J

    return-wide v0
.end method

.method static synthetic access$300(Lco/vine/android/recorder/HwEncodingRunnable;)[B
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferMax:[B

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/recorder/HwEncodingRunnable;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I

    return v0
.end method

.method static synthetic access$412(Lco/vine/android/recorder/HwEncodingRunnable;I)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # I

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I

    add-int/2addr v0, p1

    iput v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mVideoDataBufferPosition:I

    return v0
.end method

.method static synthetic access$500(Lco/vine/android/recorder/HwEncodingRunnable;)Lco/vine/android/recorder/HwVineFrameRecorder;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;

    return-object v0
.end method

.method static synthetic access$502(Lco/vine/android/recorder/HwEncodingRunnable;Lco/vine/android/recorder/HwVineFrameRecorder;)Lco/vine/android/recorder/HwVineFrameRecorder;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # Lco/vine/android/recorder/HwVineFrameRecorder;

    .prologue
    .line 25
    iput-object p1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncoder:Lco/vine/android/recorder/HwVineFrameRecorder;

    return-object p1
.end method

.method static synthetic access$600(Lco/vine/android/recorder/HwEncodingRunnable;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I

    return v0
.end method

.method static synthetic access$602(Lco/vine/android/recorder/HwEncodingRunnable;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # I

    .prologue
    .line 25
    iput p1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I

    return p1
.end method

.method static synthetic access$608(Lco/vine/android/recorder/HwEncodingRunnable;)I
    .locals 2
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I

    return v0
.end method

.method static synthetic access$700(Lco/vine/android/recorder/HwEncodingRunnable;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mMaxEncodedSize:I

    return v0
.end method

.method static synthetic access$702(Lco/vine/android/recorder/HwEncodingRunnable;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;
    .param p1, "x1"    # I

    .prologue
    .line 25
    iput p1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mMaxEncodedSize:I

    return p1
.end method

.method static synthetic access$800(Lco/vine/android/recorder/HwEncodingRunnable;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$900(Lco/vine/android/recorder/HwEncodingRunnable;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/HwEncodingRunnable;

    .prologue
    .line 25
    iget v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mRecorderFrameRate:I

    return v0
.end method

.method private process(Z)V
    .locals 5
    .param p1, "waitForMore"    # Z

    .prologue
    .line 356
    :cond_0
    :goto_0
    iget-boolean v3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    if-nez v3, :cond_2

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mDataQueue:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v3}, Ljava/util/concurrent/ConcurrentLinkedQueue;->poll()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/recorder/VideoData;

    .local v2, "next":Lco/vine/android/recorder/VideoData;
    if-nez v2, :cond_1

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v3}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 357
    :cond_1
    if-nez v2, :cond_3

    .line 358
    if-eqz p1, :cond_0

    .line 360
    const-wide/16 v3, 0x64

    :try_start_0
    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 361
    :catch_0
    move-exception v1

    .line 362
    .local v1, "e":Ljava/lang/InterruptedException;
    const-string v3, "Break signal reached."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 371
    .end local v1    # "e":Ljava/lang/InterruptedException;
    .end local v2    # "next":Lco/vine/android/recorder/VideoData;
    :cond_2
    return-void

    .line 367
    .restart local v2    # "next":Lco/vine/android/recorder/VideoData;
    :cond_3
    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingRunnable:Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

    invoke-virtual {v3, v2}, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->add(Lco/vine/android/recorder/VideoData;)[B

    move-result-object v0

    .line 368
    .local v0, "data":[B
    iget-object v4, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mCameraManager:Lco/vine/android/recorder/CameraManager;

    if-nez p1, :cond_4

    const/4 v3, 0x1

    :goto_1
    invoke-virtual {v4, v0, v3}, Lco/vine/android/recorder/CameraManager;->addBuffer([BZ)V

    goto :goto_0

    :cond_4
    const/4 v3, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getOutput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mOutput:Ljava/lang/String;

    return-object v0
.end method

.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 325
    const/16 v1, 0x13

    invoke-static {v1}, Landroid/os/Process;->setThreadPriority(I)V

    .line 326
    const-string v1, "Processing started: {}."

    new-array v2, v4, [Ljava/lang/Object;

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mOutput:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 327
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingRunnable:Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;

    iput-boolean v4, v1, Lco/vine/android/recorder/HwEncodingRunnable$EncodingProcessRunnable;->mRun:Z

    .line 328
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 329
    :goto_0
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;

    invoke-virtual {v1}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    if-nez v1, :cond_0

    .line 330
    invoke-direct {p0, v4}, Lco/vine/android/recorder/HwEncodingRunnable;->process(Z)V

    goto :goto_0

    .line 332
    :cond_0
    const-string v1, "Flushing..."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 333
    iget-boolean v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    if-nez v1, :cond_2

    .line 334
    invoke-direct {p0, v5}, Lco/vine/android/recorder/HwEncodingRunnable;->process(Z)V

    .line 338
    :goto_1
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;

    invoke-virtual {v1}, Lco/vine/android/recorder/ByteBufferQueue;->endOfPut()V

    .line 340
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mEncodingThread:Ljava/lang/Thread;

    invoke-virtual {v1}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 344
    :goto_2
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    if-eqz v1, :cond_1

    .line 345
    iget-object v1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    const/16 v2, 0x5a

    invoke-virtual {v1, v2}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 347
    :cond_1
    const-string v1, "Time used: rgb: {}ms"

    iget-wide v2, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToRGB:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 348
    const-string v1, "Time used: matrix: {}ms."

    iget-wide v2, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToMatrix:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 349
    const-string v1, "Total Processed: {}."

    iget v2, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTotalProcessed:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 350
    const-string v1, "Total Encoding time: {}ms."

    iget-wide v2, p0, Lco/vine/android/recorder/HwEncodingRunnable;->timeToRecord:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 351
    const-string v1, "Processing Ended: {}."

    new-array v2, v4, [Ljava/lang/Object;

    iget-object v3, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mOutput:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 352
    return-void

    .line 336
    :cond_2
    const-string v1, "Terminate without saving...."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_1

    .line 341
    :catch_0
    move-exception v0

    .line 342
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v1, "Interrupted."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_2
.end method

.method public setAsyncTask(Lco/vine/android/recorder/BaseFinishProcessTask;)V
    .locals 0
    .param p1, "task"    # Lco/vine/android/recorder/BaseFinishProcessTask;

    .prologue
    .line 315
    iput-object p1, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;

    .line 316
    return-void
.end method

.method public terminate()V
    .locals 1

    .prologue
    .line 319
    const-string v0, "Terminate without saving turned on."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 320
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/HwEncodingRunnable;->mTerminateImmediately:Z

    .line 321
    return-void
.end method
