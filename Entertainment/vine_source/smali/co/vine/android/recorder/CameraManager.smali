.class public Lco/vine/android/recorder/CameraManager;
.super Ljava/lang/Object;
.source "CameraManager.java"

# interfaces
.implements Landroid/hardware/Camera$OnZoomChangeListener;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xe
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/CameraManager$DummySurfaceHolder;,
        Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;,
        Lco/vine/android/recorder/CameraManager$StartPreviewThread;,
        Lco/vine/android/recorder/CameraManager$AddBufferThread;
    }
.end annotation


# static fields
.field private static INSTANCE:Lco/vine/android/recorder/CameraManager;

.field private static hasPreallocateBuffers:Z

.field private static final mBackFacing:[Ljava/lang/Integer;

.field private static final mFrontFacing:[Ljava/lang/Integer;

.field public static sCameraBufferCount:I

.field private static final sCameraInfoTable:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/hardware/Camera$CameraInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static final sCameraSettingTable:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lco/vine/android/recorder/CameraSetting;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private volatile isPreviewing:Z

.field private final mAddArray:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<[B>;"
        }
    .end annotation
.end field

.field private final mAddedBufferArray:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<[B>;"
        }
    .end annotation
.end field

.field private mAutoStopZoomCalled:Z

.field private final mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentLinkedQueue",
            "<[B>;"
        }
    .end annotation
.end field

.field private mCamera:Landroid/hardware/Camera;

.field private mCameraSetting:Lco/vine/android/recorder/CameraSetting;

.field private mController:Lco/vine/android/recorder/RecordController;

.field private mControllerId:Ljava/lang/String;

.field private mCurrentCamera:I

.field private mCurrentZoomTarget:I

.field private mFocusArea:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/hardware/Camera$Area;",
            ">;"
        }
    .end annotation
.end field

.field private mFrameSize:I

.field private mFramesReceived:J

.field private final mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

.field private mIsCurrentFront:Z

.field private mIsSmoothZoomSupported:Z

.field private mIsSmoothZooming:Z

.field private mIsSmoothZoomingStopCalled:Z

.field private final mLOCK:[I

.field private mLastPreviewFrameTimestamp:J

.field private final mMatrix:Landroid/graphics/Matrix;

.field private mMaxZoom:I

.field private mMaxtimeElapsed:J

.field private mPreviewHeight:I

.field private mPreviewStartTime:J

.field private mPreviewWidth:I

.field private mRequestedZoom:I

.field private volatile mRunAddBufferThread:Z

.field private mSharedByteBuffer:Ljava/nio/ByteBuffer;

.field private mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;


# direct methods
.method static constructor <clinit>()V
    .locals 11

    .prologue
    const/4 v10, 0x1

    .line 47
    new-instance v1, Landroid/hardware/Camera$CameraInfo;

    invoke-direct {v1}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .line 49
    .local v1, "cameraInfo":Landroid/hardware/Camera$CameraInfo;
    invoke-static {}, Landroid/hardware/Camera;->getNumberOfCameras()I

    move-result v5

    .line 51
    .local v5, "numberOfCameras":I
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 52
    .local v3, "frontFacing":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 54
    .local v0, "backFacing":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v5, :cond_2

    .line 56
    :try_start_0
    invoke-static {v4, v1}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    .line 57
    iget v6, v1, Landroid/hardware/Camera$CameraInfo;->facing:I

    if-ne v6, v10, :cond_1

    .line 58
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 54
    :cond_0
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 59
    :cond_1
    iget v6, v1, Landroid/hardware/Camera$CameraInfo;->facing:I

    if-nez v6, :cond_0

    .line 60
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 62
    :catch_0
    move-exception v2

    .line 63
    .local v2, "e":Ljava/lang/Exception;
    const-string v6, "Cannot get camera info for camera #{}."

    new-array v7, v10, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v2, v6, v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 66
    .end local v2    # "e":Ljava/lang/Exception;
    :cond_2
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v6

    new-array v6, v6, [Ljava/lang/Integer;

    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Ljava/lang/Integer;

    sput-object v6, Lco/vine/android/recorder/CameraManager;->mFrontFacing:[Ljava/lang/Integer;

    .line 67
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v6

    new-array v6, v6, [Ljava/lang/Integer;

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Ljava/lang/Integer;

    sput-object v6, Lco/vine/android/recorder/CameraManager;->mBackFacing:[Ljava/lang/Integer;

    .line 71
    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6}, Landroid/util/SparseArray;-><init>()V

    sput-object v6, Lco/vine/android/recorder/CameraManager;->sCameraInfoTable:Landroid/util/SparseArray;

    .line 72
    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6}, Landroid/util/SparseArray;-><init>()V

    sput-object v6, Lco/vine/android/recorder/CameraManager;->sCameraSettingTable:Landroid/util/SparseArray;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Lco/vine/android/util/IntentionalObjectCounter;

    const-string v1, "recorder"

    invoke-direct {v0, v1, p0}, Lco/vine/android/util/IntentionalObjectCounter;-><init>(Ljava/lang/String;Ljava/lang/Object;)V

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    .line 74
    new-array v0, v2, [I

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    .line 79
    iput-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mIsCurrentFront:Z

    .line 80
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    .line 87
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    .line 88
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 89
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    .line 96
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/recorder/CameraManager;->mMaxtimeElapsed:J

    .line 120
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mMatrix:Landroid/graphics/Matrix;

    .line 121
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/recorder/CameraManager;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mRunAddBufferThread:Z

    return v0
.end method

.method static synthetic access$002(Lco/vine/android/recorder/CameraManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;
    .param p1, "x1"    # Z

    .prologue
    .line 39
    iput-boolean p1, p0, Lco/vine/android/recorder/CameraManager;->mRunAddBufferThread:Z

    return p1
.end method

.method static synthetic access$100(Lco/vine/android/recorder/CameraManager;)Landroid/hardware/Camera;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    return-object v0
.end method

.method static synthetic access$1000(Lco/vine/android/recorder/CameraManager;)Ljava/nio/ByteBuffer;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mSharedByteBuffer:Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method static synthetic access$1002(Lco/vine/android/recorder/CameraManager;Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;
    .param p1, "x1"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 39
    iput-object p1, p0, Lco/vine/android/recorder/CameraManager;->mSharedByteBuffer:Ljava/nio/ByteBuffer;

    return-object p1
.end method

.method static synthetic access$1102(Lco/vine/android/recorder/CameraManager;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;
    .param p1, "x1"    # J

    .prologue
    .line 39
    iput-wide p1, p0, Lco/vine/android/recorder/CameraManager;->mLastPreviewFrameTimestamp:J

    return-wide p1
.end method

.method static synthetic access$1202(Lco/vine/android/recorder/CameraManager;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;
    .param p1, "x1"    # J

    .prologue
    .line 39
    iput-wide p1, p0, Lco/vine/android/recorder/CameraManager;->mFramesReceived:J

    return-wide p1
.end method

.method static synthetic access$1302(Lco/vine/android/recorder/CameraManager;J)J
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;
    .param p1, "x1"    # J

    .prologue
    .line 39
    iput-wide p1, p0, Lco/vine/android/recorder/CameraManager;->mPreviewStartTime:J

    return-wide p1
.end method

.method static synthetic access$200(Lco/vine/android/recorder/CameraManager;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/recorder/CameraManager;)Ljava/util/concurrent/ConcurrentLinkedQueue;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/recorder/CameraManager;)Lco/vine/android/recorder/RecordController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/recorder/CameraManager;)[I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/recorder/CameraManager;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/recorder/CameraManager;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mControllerId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$702(Lco/vine/android/recorder/CameraManager;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lco/vine/android/recorder/CameraManager;->mControllerId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$800()Z
    .locals 1

    .prologue
    .line 39
    sget-boolean v0, Lco/vine/android/recorder/CameraManager;->hasPreallocateBuffers:Z

    return v0
.end method

.method static synthetic access$802(Z)Z
    .locals 0
    .param p0, "x0"    # Z

    .prologue
    .line 39
    sput-boolean p0, Lco/vine/android/recorder/CameraManager;->hasPreallocateBuffers:Z

    return p0
.end method

.method static synthetic access$900(Lco/vine/android/recorder/CameraManager;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/CameraManager;

    .prologue
    .line 39
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mFrameSize:I

    return v0
.end method

.method private calculateTapArea(IIFIIIILandroid/graphics/Rect;)V
    .locals 10
    .param p1, "focusWidth"    # I
    .param p2, "focusHeight"    # I
    .param p3, "areaMultiple"    # F
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "previewWidth"    # I
    .param p7, "previewHeight"    # I
    .param p8, "rect"    # Landroid/graphics/Rect;

    .prologue
    .line 222
    int-to-float v6, p1

    mul-float/2addr v6, p3

    float-to-int v2, v6

    .line 223
    .local v2, "areaWidth":I
    int-to-float v6, p2

    mul-float/2addr v6, p3

    float-to-int v1, v6

    .line 224
    .local v1, "areaHeight":I
    div-int/lit8 v6, v2, 0x2

    sub-int v6, p4, v6

    const/4 v7, 0x0

    sub-int v8, p6, v2

    invoke-static {v6, v7, v8}, Lco/vine/android/util/MathUtil;->clamp(III)I

    move-result v3

    .line 225
    .local v3, "left":I
    div-int/lit8 v6, v1, 0x2

    sub-int v6, p5, v6

    const/4 v7, 0x0

    sub-int v8, p7, v1

    invoke-static {v6, v7, v8}, Lco/vine/android/util/MathUtil;->clamp(III)I

    move-result v5

    .line 227
    .local v5, "top":I
    new-instance v4, Landroid/graphics/RectF;

    int-to-float v6, v3

    int-to-float v7, v5

    add-int v8, v3, v2

    int-to-float v8, v8

    add-int v9, v5, v1

    int-to-float v9, v9

    invoke-direct {v4, v6, v7, v8, v9}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 228
    .local v4, "rectF":Landroid/graphics/RectF;
    iget-object v6, p0, Lco/vine/android/recorder/CameraManager;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v6, v4}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 229
    move-object/from16 v0, p8

    invoke-static {v4, v0}, Lco/vine/android/util/MathUtil;->rectFToRect(Landroid/graphics/RectF;Landroid/graphics/Rect;)V

    .line 230
    return-void
.end method

.method private disableVideoStab(Landroid/hardware/Camera$Parameters;)V
    .locals 2
    .param p1, "parameters"    # Landroid/hardware/Camera$Parameters;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xf
    .end annotation

    .prologue
    .line 930
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xf

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->isVideoStabilizationSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 931
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/hardware/Camera$Parameters;->setVideoStabilization(Z)V

    .line 933
    :cond_0
    return-void
.end method

.method public static declared-synchronized getCameraDisplayOrientation(II)I
    .locals 5
    .param p0, "degrees"    # I
    .param p1, "cameraId"    # I

    .prologue
    .line 1084
    const-class v3, Lco/vine/android/recorder/CameraManager;

    monitor-enter v3

    :try_start_0
    sget-object v2, Lco/vine/android/recorder/CameraManager;->sCameraInfoTable:Landroid/util/SparseArray;

    invoke-virtual {v2, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/Camera$CameraInfo;

    .line 1085
    .local v0, "info":Landroid/hardware/Camera$CameraInfo;
    if-nez v0, :cond_0

    .line 1086
    new-instance v0, Landroid/hardware/Camera$CameraInfo;

    .end local v0    # "info":Landroid/hardware/Camera$CameraInfo;
    invoke-direct {v0}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .line 1087
    .restart local v0    # "info":Landroid/hardware/Camera$CameraInfo;
    invoke-static {p1, v0}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    .line 1088
    sget-object v2, Lco/vine/android/recorder/CameraManager;->sCameraInfoTable:Landroid/util/SparseArray;

    invoke-virtual {v2, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1093
    :goto_0
    const-string v2, "Set rotation to {} degrees"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1096
    iget v2, v0, Landroid/hardware/Camera$CameraInfo;->facing:I

    const/4 v4, 0x1

    if-ne v2, v4, :cond_1

    .line 1097
    iget v2, v0, Landroid/hardware/Camera$CameraInfo;->orientation:I

    add-int/2addr v2, p0

    rem-int/lit16 v1, v2, 0x168

    .line 1098
    .local v1, "result":I
    rsub-int v2, v1, 0x168

    rem-int/lit16 v1, v2, 0x168
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1102
    :goto_1
    monitor-exit v3

    return v1

    .line 1090
    .end local v1    # "result":I
    :cond_0
    :try_start_1
    const-string v2, "Using cached camera info."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1084
    .end local v0    # "info":Landroid/hardware/Camera$CameraInfo;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2

    .line 1100
    .restart local v0    # "info":Landroid/hardware/Camera$CameraInfo;
    :cond_1
    :try_start_2
    iget v2, v0, Landroid/hardware/Camera$CameraInfo;->orientation:I

    sub-int/2addr v2, p0

    add-int/lit16 v2, v2, 0x168

    rem-int/lit16 v1, v2, 0x168
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .restart local v1    # "result":I
    goto :goto_1
.end method

.method public static getCameraInfo(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ILandroid/hardware/Camera$Parameters;IZ)Lco/vine/android/recorder/CameraSetting;
    .locals 22
    .param p0, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p1, "cameraId"    # I
    .param p2, "params"    # Landroid/hardware/Camera$Parameters;
    .param p3, "rotation"    # I
    .param p4, "isFront"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 604
    move/from16 v0, p3

    move/from16 v1, p1

    invoke-static {v0, v1}, Lco/vine/android/recorder/CameraManager;->getCameraDisplayOrientation(II)I

    move-result v5

    .line 605
    .local v5, "degree":I
    if-eqz p4, :cond_0

    .line 606
    neg-int v5, v5

    .line 608
    :cond_0
    sget-object v8, Lco/vine/android/recorder/CameraManager;->sCameraSettingTable:Landroid/util/SparseArray;

    move/from16 v0, p1

    invoke-virtual {v8, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/recorder/CameraSetting;

    .line 609
    .local v2, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    if-eqz v2, :cond_1

    .line 610
    new-instance v11, Lco/vine/android/recorder/CameraSetting;

    invoke-direct {v11, v2}, Lco/vine/android/recorder/CameraSetting;-><init>(Lco/vine/android/recorder/CameraSetting;)V

    .line 611
    .end local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .local v11, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    iput v5, v11, Lco/vine/android/recorder/CameraSetting;->degrees:I

    .line 612
    const-string v8, "Using cached camera setting."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    move-object v2, v11

    .line 738
    .end local v11    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .restart local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    :goto_0
    return-object v11

    .line 615
    :cond_1
    const/16 v16, 0x0

    .line 617
    .local v16, "previewFormats":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :try_start_0
    invoke-virtual/range {p2 .. p2}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewFormats()Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v16

    .line 621
    :goto_1
    const/16 v7, 0x11

    .line 622
    .local v7, "selectedFormat":I
    if-eqz v16, :cond_5

    .line 623
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .local v15, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/Integer;

    .line 624
    .local v14, "format":Ljava/lang/Integer;
    const-string v8, "Supported format: {}"

    invoke-static {v8, v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 625
    invoke-virtual {v14}, Ljava/lang/Integer;->intValue()I

    move-result v8

    const/4 v9, 0x4

    if-ne v8, v9, :cond_2

    .line 626
    invoke-virtual {v14}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 630
    .end local v14    # "format":Ljava/lang/Integer;
    :cond_3
    const/16 v8, 0x11

    if-ne v7, v8, :cond_5

    .line 631
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    :cond_4
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/Integer;

    .line 632
    .restart local v14    # "format":Ljava/lang/Integer;
    invoke-virtual {v14}, Ljava/lang/Integer;->intValue()I

    move-result v8

    const/16 v9, 0x100

    if-ne v8, v9, :cond_4

    .line 633
    invoke-virtual {v14}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 639
    .end local v14    # "format":Ljava/lang/Integer;
    .end local v15    # "i$":Ljava/util/Iterator;
    :cond_5
    const-string v8, "Selected format: {}."

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 643
    const/4 v8, 0x4

    :try_start_1
    move/from16 v0, p1

    invoke-static {v0, v8}, Landroid/media/CamcorderProfile;->hasProfile(II)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 644
    const/4 v8, 0x4

    move/from16 v0, p1

    invoke-static {v0, v8}, Landroid/media/CamcorderProfile;->get(II)Landroid/media/CamcorderProfile;

    move-result-object v12

    .line 646
    .local v12, "cp":Landroid/media/CamcorderProfile;
    const-string v8, "Use default profile"

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 650
    :goto_2
    const-string v8, "Preferred FrameRate: {}."

    iget v9, v12, Landroid/media/CamcorderProfile;->videoFrameRate:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 651
    iget v8, v12, Landroid/media/CamcorderProfile;->videoFrameRate:I

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    if-lt v8, v9, :cond_6

    .line 652
    move-object/from16 v0, p0

    iget v8, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    iput v8, v12, Landroid/media/CamcorderProfile;->videoFrameRate:I

    .line 654
    :cond_6
    const-string v8, "Original Width * Height: {}/{}"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget v0, v12, Landroid/media/CamcorderProfile;->videoFrameWidth:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x1

    iget v0, v12, Landroid/media/CamcorderProfile;->videoFrameHeight:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    invoke-static {v8, v9}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 656
    move-object/from16 v0, p0

    iget v8, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    iput v8, v12, Landroid/media/CamcorderProfile;->videoFrameWidth:I

    .line 658
    iget v8, v12, Landroid/media/CamcorderProfile;->videoFrameHeight:I

    iget v9, v12, Landroid/media/CamcorderProfile;->videoFrameWidth:I

    if-le v8, v9, :cond_7

    .line 659
    move-object/from16 v0, p0

    iget-boolean v8, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->highQuality:Z

    if-eqz v8, :cond_b

    const/16 v8, 0x1e0

    :goto_3
    iput v8, v12, Landroid/media/CamcorderProfile;->videoFrameHeight:I

    .line 662
    :cond_7
    const-string v8, "Video: {}*{} codec: {} bitRate:{} frameRate:{}."

    const/4 v9, 0x5

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget v0, v12, Landroid/media/CamcorderProfile;->videoFrameWidth:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x1

    iget v0, v12, Landroid/media/CamcorderProfile;->videoFrameHeight:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x2

    iget v0, v12, Landroid/media/CamcorderProfile;->videoCodec:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x3

    iget v0, v12, Landroid/media/CamcorderProfile;->videoBitRate:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x4

    iget v0, v12, Landroid/media/CamcorderProfile;->videoFrameRate:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 663
    const-string v8, "Audio: bitRate:{} channels: {} codec: {} sampleRate: {} "

    const/4 v9, 0x4

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget v0, v12, Landroid/media/CamcorderProfile;->audioBitRate:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x1

    iget v0, v12, Landroid/media/CamcorderProfile;->audioChannels:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x2

    iget v0, v12, Landroid/media/CamcorderProfile;->audioCodec:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x3

    iget v0, v12, Landroid/media/CamcorderProfile;->audioSampleRate:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 664
    iget v3, v12, Landroid/media/CamcorderProfile;->videoFrameWidth:I

    .line 665
    .local v3, "videoFrameWidth":I
    iget v4, v12, Landroid/media/CamcorderProfile;->videoFrameHeight:I

    .line 666
    .local v4, "videoFrameHeight":I
    iget v6, v12, Landroid/media/CamcorderProfile;->videoFrameRate:I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_1 .. :try_end_1} :catch_2

    .line 699
    .end local v12    # "cp":Landroid/media/CamcorderProfile;
    .local v6, "videoFrameRate":I
    :goto_4
    const-string v8, "FFC OR: {}."

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingAspectRatioOverride:F

    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 700
    const-string v8, "BFC OR: {}."

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingAspectRatioOverride:F

    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 703
    const/16 v8, 0x280

    if-ne v3, v8, :cond_8

    const/16 v8, 0x1e0

    if-eq v4, v8, :cond_8

    .line 704
    const-string v8, "Force 480 with 480p."

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 705
    const/16 v4, 0x1e0

    .line 708
    :cond_8
    new-instance v2, Lco/vine/android/recorder/CameraSetting;

    .end local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingAspectRatioOverride:F

    move-object/from16 v0, p0

    iget v10, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingAspectRatioOverride:F

    move/from16 v8, p4

    invoke-direct/range {v2 .. v10}, Lco/vine/android/recorder/CameraSetting;-><init>(IIIIIZFF)V

    .line 712
    .restart local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    sget-object v8, Lco/vine/android/recorder/CameraManager;->sCameraSettingTable:Landroid/util/SparseArray;

    move/from16 v0, p1

    invoke-virtual {v8, v0, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 714
    new-instance v11, Lco/vine/android/recorder/CameraSetting;

    invoke-direct {v11, v2}, Lco/vine/android/recorder/CameraSetting;-><init>(Lco/vine/android/recorder/CameraSetting;)V

    .line 716
    .end local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .restart local v11    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    sget-boolean v8, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v8, :cond_13

    .line 717
    invoke-virtual/range {p2 .. p2}, Landroid/hardware/Camera$Parameters;->getPreferredPreviewSizeForVideo()Landroid/hardware/Camera$Size;

    move-result-object v18

    .line 718
    .local v18, "size":Landroid/hardware/Camera$Size;
    if-eqz v18, :cond_9

    .line 719
    const-string v8, "Preferred Width * Height: {}/{}."

    move-object/from16 v0, v18

    iget v9, v0, Landroid/hardware/Camera$Size;->width:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    move-object/from16 v0, v18

    iget v10, v0, Landroid/hardware/Camera$Size;->height:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v8, v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 721
    :cond_9
    invoke-virtual/range {p2 .. p2}, Landroid/hardware/Camera$Parameters;->getSupportedVideoSizes()Ljava/util/List;

    move-result-object v19

    .line 722
    .local v19, "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    if-eqz v19, :cond_11

    .line 723
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .restart local v15    # "i$":Ljava/util/Iterator;
    :goto_5
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_11

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Landroid/hardware/Camera$Size;

    .line 724
    .local v17, "s":Landroid/hardware/Camera$Size;
    const-string v8, "Supported Video Width * Height: {}/{}."

    move-object/from16 v0, v17

    iget v9, v0, Landroid/hardware/Camera$Size;->width:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    move-object/from16 v0, v17

    iget v10, v0, Landroid/hardware/Camera$Size;->height:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v8, v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_5

    .line 618
    .end local v3    # "videoFrameWidth":I
    .end local v4    # "videoFrameHeight":I
    .end local v6    # "videoFrameRate":I
    .end local v7    # "selectedFormat":I
    .end local v11    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .end local v15    # "i$":Ljava/util/Iterator;
    .end local v17    # "s":Landroid/hardware/Camera$Size;
    .end local v18    # "size":Landroid/hardware/Camera$Size;
    .end local v19    # "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    .restart local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    :catch_0
    move-exception v13

    .line 619
    .local v13, "e":Ljava/lang/NullPointerException;
    const-string v8, "This device sucks, it cannot return params properly."

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 648
    .end local v13    # "e":Ljava/lang/NullPointerException;
    .restart local v7    # "selectedFormat":I
    :cond_a
    const/4 v8, 0x1

    :try_start_2
    move/from16 v0, p1

    invoke-static {v0, v8}, Landroid/media/CamcorderProfile;->get(II)Landroid/media/CamcorderProfile;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v12

    .restart local v12    # "cp":Landroid/media/CamcorderProfile;
    goto/16 :goto_2

    .line 659
    :cond_b
    const/16 v8, 0xf0

    goto/16 :goto_3

    .line 667
    .end local v12    # "cp":Landroid/media/CamcorderProfile;
    :catch_1
    move-exception v13

    .line 668
    .local v13, "e":Ljava/lang/Exception;
    invoke-virtual/range {p2 .. p2}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v19

    .line 669
    .restart local v19    # "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    new-instance v20, Ljava/util/HashSet;

    invoke-direct/range {v20 .. v20}, Ljava/util/HashSet;-><init>()V

    .line 670
    .local v20, "supportedWidth":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    if-eqz v19, :cond_10

    .line 671
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .restart local v15    # "i$":Ljava/util/Iterator;
    :cond_c
    :goto_6
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_d

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Landroid/hardware/Camera$Size;

    .line 672
    .restart local v18    # "size":Landroid/hardware/Camera$Size;
    const-string v8, "Supported width and height: {}, {}."

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/hardware/Camera$Size;->width:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x1

    move-object/from16 v0, v18

    iget v0, v0, Landroid/hardware/Camera$Size;->height:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    invoke-static {v8, v9}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 673
    move-object/from16 v0, v18

    iget v8, v0, Landroid/hardware/Camera$Size;->height:I

    move-object/from16 v0, p0

    iget v9, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetSize:I

    if-ne v8, v9, :cond_c

    .line 674
    move-object/from16 v0, v18

    iget v8, v0, Landroid/hardware/Camera$Size;->width:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    move-object/from16 v0, v20

    invoke-interface {v0, v8}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 677
    .end local v18    # "size":Landroid/hardware/Camera$Size;
    :cond_d
    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_e

    .line 678
    const-string v8, "Edison: Target size is not supported."

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 679
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    .line 680
    .restart local v4    # "videoFrameHeight":I
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    .line 695
    .end local v15    # "i$":Ljava/util/Iterator;
    .restart local v3    # "videoFrameWidth":I
    :goto_7
    move-object/from16 v0, p0

    iget v6, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->targetFrameRate:I

    .line 698
    .restart local v6    # "videoFrameRate":I
    goto/16 :goto_4

    .line 682
    .end local v3    # "videoFrameWidth":I
    .end local v4    # "videoFrameHeight":I
    .end local v6    # "videoFrameRate":I
    .restart local v15    # "i$":Ljava/util/Iterator;
    :cond_e
    move-object/from16 v0, p0

    iget v8, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    move-object/from16 v0, v20

    invoke-interface {v0, v8}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_f

    .line 683
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    .line 684
    .restart local v4    # "videoFrameHeight":I
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    .restart local v3    # "videoFrameWidth":I
    goto :goto_7

    .line 686
    .end local v3    # "videoFrameWidth":I
    .end local v4    # "videoFrameHeight":I
    :cond_f
    const-string v8, "Edison: Target width is not supported."

    invoke-static {v8}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 687
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    .line 688
    .restart local v4    # "videoFrameHeight":I
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    .restart local v3    # "videoFrameWidth":I
    goto :goto_7

    .line 692
    .end local v3    # "videoFrameWidth":I
    .end local v4    # "videoFrameHeight":I
    .end local v15    # "i$":Ljava/util/Iterator;
    :cond_10
    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewHeight:I

    .line 693
    .restart local v4    # "videoFrameHeight":I
    move-object/from16 v0, p0

    iget v3, v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->previewWidth:I

    .restart local v3    # "videoFrameWidth":I
    goto :goto_7

    .line 696
    .end local v3    # "videoFrameWidth":I
    .end local v4    # "videoFrameHeight":I
    .end local v13    # "e":Ljava/lang/Exception;
    .end local v19    # "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    .end local v20    # "supportedWidth":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Integer;>;"
    :catch_2
    move-exception v13

    .line 697
    .local v13, "e":Ljava/lang/UnsatisfiedLinkError;
    new-instance v8, Lco/vine/android/VineNotSupportedException;

    invoke-direct {v8, v13}, Lco/vine/android/VineNotSupportedException;-><init>(Ljava/lang/Throwable;)V

    throw v8

    .line 727
    .end local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .end local v13    # "e":Ljava/lang/UnsatisfiedLinkError;
    .restart local v3    # "videoFrameWidth":I
    .restart local v4    # "videoFrameHeight":I
    .restart local v6    # "videoFrameRate":I
    .restart local v11    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .restart local v18    # "size":Landroid/hardware/Camera$Size;
    .restart local v19    # "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    :cond_11
    invoke-virtual/range {p2 .. p2}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v19

    .line 728
    if-eqz v19, :cond_12

    .line 729
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v15

    .restart local v15    # "i$":Ljava/util/Iterator;
    :goto_8
    invoke-interface {v15}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_12

    invoke-interface {v15}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Landroid/hardware/Camera$Size;

    .line 730
    .restart local v17    # "s":Landroid/hardware/Camera$Size;
    const-string v8, "Supported Preview Width * Height: {}/{}."

    move-object/from16 v0, v17

    iget v9, v0, Landroid/hardware/Camera$Size;->width:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    move-object/from16 v0, v17

    iget v10, v0, Landroid/hardware/Camera$Size;->height:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v8, v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_8

    .line 733
    .end local v15    # "i$":Ljava/util/Iterator;
    .end local v17    # "s":Landroid/hardware/Camera$Size;
    :cond_12
    const-string v8, "Camera w/h/f/p/d: {}/{}/{}/{}/{}"

    const/4 v9, 0x5

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget v0, v11, Lco/vine/android/recorder/CameraSetting;->originalW:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x1

    iget v0, v11, Lco/vine/android/recorder/CameraSetting;->originalH:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x2

    iget v0, v11, Lco/vine/android/recorder/CameraSetting;->frameRate:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x3

    invoke-virtual/range {p2 .. p2}, Landroid/hardware/Camera$Parameters;->getPreviewFormat()I

    move-result v21

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    const/4 v10, 0x4

    iget v0, v11, Lco/vine/android/recorder/CameraSetting;->degrees:I

    move/from16 v21, v0

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v21

    aput-object v21, v9, v10

    invoke-static {v8, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .end local v18    # "size":Landroid/hardware/Camera$Size;
    .end local v19    # "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    :cond_13
    move-object v2, v11

    .line 738
    .end local v11    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    .restart local v2    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    goto/16 :goto_0
.end method

.method public static getCameraRotation(Landroid/app/Activity;)I
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v1, 0x0

    .line 588
    invoke-virtual {p0}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v2

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Display;->getRotation()I

    move-result v0

    .line 590
    .local v0, "rotation":I
    packed-switch v0, :pswitch_data_0

    .line 600
    :goto_0
    :pswitch_0
    return v1

    .line 594
    :pswitch_1
    const/16 v1, 0x5a

    goto :goto_0

    .line 596
    :pswitch_2
    const/16 v1, 0xb4

    goto :goto_0

    .line 598
    :pswitch_3
    const/16 v1, 0x10e

    goto :goto_0

    .line 590
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static declared-synchronized getInstance()Lco/vine/android/recorder/CameraManager;
    .locals 2

    .prologue
    .line 126
    const-class v1, Lco/vine/android/recorder/CameraManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lco/vine/android/recorder/CameraManager;->INSTANCE:Lco/vine/android/recorder/CameraManager;

    if-nez v0, :cond_0

    .line 127
    new-instance v0, Lco/vine/android/recorder/CameraManager;

    invoke-direct {v0}, Lco/vine/android/recorder/CameraManager;-><init>()V

    sput-object v0, Lco/vine/android/recorder/CameraManager;->INSTANCE:Lco/vine/android/recorder/CameraManager;

    .line 129
    :cond_0
    sget-object v0, Lco/vine/android/recorder/CameraManager;->INSTANCE:Lco/vine/android/recorder/CameraManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 126
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getNextParamValue(ZLjava/util/List;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "up"    # Z
    .param p3, "current"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 1265
    .local p2, "supported":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz p2, :cond_5

    .line 1266
    const/4 v0, 0x0

    .line 1267
    .local v0, "i":I
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 1268
    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1272
    :cond_0
    if-eqz p1, :cond_3

    .line 1273
    add-int/lit8 v0, v0, 0x1

    .line 1274
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-lt v0, v1, :cond_1

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .line 1279
    :cond_1
    :goto_1
    const-string v1, "Modify to: {}"

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1280
    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1282
    .end local v0    # "i":I
    :goto_2
    return-object v1

    .line 1267
    .restart local v0    # "i":I
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1276
    :cond_3
    add-int/lit8 v0, v0, -0x1

    .line 1277
    if-gez v0, :cond_4

    const/4 v0, 0x0

    :cond_4
    goto :goto_1

    .line 1282
    .end local v0    # "i":I
    :cond_5
    const/4 v1, 0x0

    goto :goto_2
.end method

.method public static hasBackFacingCamera()Z
    .locals 1

    .prologue
    .line 116
    sget-object v0, Lco/vine/android/recorder/CameraManager;->mBackFacing:[Ljava/lang/Integer;

    array-length v0, v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasCamera()Z
    .locals 1

    .prologue
    .line 108
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasBackFacingCamera()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasFrontFacingCamera()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasFrontFacingCamera()Z
    .locals 1

    .prologue
    .line 112
    sget-object v0, Lco/vine/android/recorder/CameraManager;->mFrontFacing:[Ljava/lang/Integer;

    array-length v0, v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initializeFocusAreas(II)V
    .locals 9
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const/16 v1, 0x64

    .line 210
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mFocusArea:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 211
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/CameraManager;->mFocusArea:Ljava/util/ArrayList;

    .line 212
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mFocusArea:Ljava/util/ArrayList;

    new-instance v2, Landroid/hardware/Camera$Area;

    new-instance v3, Landroid/graphics/Rect;

    invoke-direct {v3}, Landroid/graphics/Rect;-><init>()V

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Landroid/hardware/Camera$Area;-><init>(Landroid/graphics/Rect;I)V

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 216
    :cond_0
    const/high16 v3, 0x3f800000    # 1.0f

    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    iget v6, v0, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    iget v7, v0, Lco/vine/android/recorder/CameraSetting;->originalH:I

    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mFocusArea:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/Camera$Area;

    iget-object v8, v0, Landroid/hardware/Camera$Area;->rect:Landroid/graphics/Rect;

    move-object v0, p0

    move v2, v1

    move v4, p1

    move v5, p2

    invoke-direct/range {v0 .. v8}, Lco/vine/android/recorder/CameraManager;->calculateTapArea(IIFIIIILandroid/graphics/Rect;)V

    .line 218
    return-void
.end method

.method public static preLoadCameras(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 281
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->getInstance()Lco/vine/android/recorder/CameraManager;

    move-result-object v0

    invoke-static {p0}, Lco/vine/android/recorder/RecordConfigUtils;->getGenericConfig(Landroid/content/Context;)Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/CameraManager;->preLoadCameras(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)V

    .line 282
    return-void
.end method

.method private safeCameraOpen(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ZIIZ)Lco/vine/android/recorder/CameraSetting;
    .locals 8
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p2, "frontFacing"    # Z
    .param p3, "id"    # I
    .param p4, "rotation"    # I
    .param p5, "reOpen"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 533
    const/4 v4, -0x1

    if-ne p3, v4, :cond_0

    .line 534
    const/4 v4, 0x0

    .line 580
    :goto_0
    return-object v4

    .line 537
    :cond_0
    iget-object v5, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v5

    .line 538
    if-nez p5, :cond_1

    :try_start_0
    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    if-eq v4, p3, :cond_2

    .line 539
    :cond_1
    const-string v4, "safeCameraOpen"

    invoke-virtual {p0, v4}, Lco/vine/android/recorder/CameraManager;->releaseCameraAndPreview(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 542
    :cond_2
    if-nez p5, :cond_3

    :try_start_1
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v4, :cond_3

    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    if-eq v4, p3, :cond_5

    .line 543
    :cond_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 544
    .local v2, "start":J
    invoke-static {p3}, Landroid/hardware/Camera;->open(I)Landroid/hardware/Camera;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    .line 545
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4, p0}, Landroid/hardware/Camera;->setZoomChangeListener(Landroid/hardware/Camera$OnZoomChangeListener;)V

    .line 546
    const-string v4, "Open camera took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v2

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v4, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 547
    const/4 v4, 0x0

    iput-boolean v4, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZooming:Z

    .line 548
    const/4 v4, 0x0

    iput-boolean v4, p0, Lco/vine/android/recorder/CameraManager;->mAutoStopZoomCalled:Z

    .line 549
    const/4 v4, 0x0

    iput-boolean v4, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomingStopCalled:Z

    .line 550
    const/4 v4, -0x1

    iput v4, p0, Lco/vine/android/recorder/CameraManager;->mCurrentZoomTarget:I

    .line 554
    .end local v2    # "start":J
    :goto_1
    const/4 v4, 0x0

    iput-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    .line 555
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 556
    .local v1, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getMaxZoom()I

    move-result v4

    iput v4, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    .line 557
    sget-boolean v4, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->IS_ZERO_INDEX_BASED_ZOOM:Z

    if-eqz v4, :cond_6

    .line 558
    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    .line 559
    const/4 v4, 0x0

    iput v4, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    .line 564
    :goto_2
    sget-boolean v4, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->SHOULD_FORCE_SMOOTH_ZOOM:Z

    if-nez v4, :cond_4

    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->isSmoothZoomSupported()Z

    move-result v4

    if-eqz v4, :cond_8

    :cond_4
    const/4 v4, 0x1

    :goto_3
    iput-boolean v4, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    .line 566
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v4, :cond_7

    .line 567
    const-string v4, "1. Open Camera."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 568
    iput p3, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    .line 569
    iput-boolean p2, p0, Lco/vine/android/recorder/CameraManager;->mIsCurrentFront:Z

    .line 570
    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    invoke-static {p1, v4, v1, p4, p2}, Lco/vine/android/recorder/CameraManager;->getCameraInfo(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ILandroid/hardware/Camera$Parameters;IZ)Lco/vine/android/recorder/CameraSetting;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    .line 571
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;
    :try_end_1
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    monitor-exit v5

    goto/16 :goto_0

    .line 578
    .end local v1    # "params":Landroid/hardware/Camera$Parameters;
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v4

    .line 552
    :cond_5
    :try_start_3
    const-string v4, "Camera was already opened."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_3
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 573
    :catch_0
    move-exception v0

    .line 574
    .local v0, "e":Lco/vine/android/VineNotSupportedException;
    :try_start_4
    throw v0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 561
    .end local v0    # "e":Lco/vine/android/VineNotSupportedException;
    .restart local v1    # "params":Landroid/hardware/Camera$Parameters;
    :cond_6
    const/4 v4, 0x1

    :try_start_5
    iput v4, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I
    :try_end_5
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 575
    .end local v1    # "params":Landroid/hardware/Camera$Parameters;
    :catch_1
    move-exception v0

    .line 576
    .local v0, "e":Ljava/lang/Exception;
    :try_start_6
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 578
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_7
    monitor-exit v5
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 580
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 564
    .restart local v1    # "params":Landroid/hardware/Camera$Parameters;
    :cond_8
    const/4 v4, 0x0

    goto :goto_3
.end method

.method private startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/view/Surface;Landroid/graphics/SurfaceTexture;ZZIII)V
    .locals 12
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p2, "surface"    # Landroid/view/Surface;
    .param p3, "texture"    # Landroid/graphics/SurfaceTexture;
    .param p4, "flash"    # Z
    .param p5, "autoFocus"    # Z
    .param p6, "frameRate"    # I
    .param p7, "rotation"    # I
    .param p8, "currentDuration"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;
        }
    .end annotation

    .prologue
    .line 851
    iget-object v8, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v8

    .line 853
    :try_start_0
    iget-boolean v7, p0, Lco/vine/android/recorder/CameraManager;->isPreviewing:Z

    if-eqz v7, :cond_0

    .line 854
    const-string v7, "Do not preview again."

    invoke-static {v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 855
    :try_start_1
    monitor-exit v8
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 913
    :goto_0
    return-void

    .line 857
    :cond_0
    :try_start_2
    iget-object v7, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v7, :cond_9

    .line 858
    const-string v7, "2,3: Set preview display and start preview."

    invoke-static {v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 859
    if-eqz p2, :cond_a

    .line 860
    iget-object v7, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    new-instance v9, Lco/vine/android/recorder/CameraManager$DummySurfaceHolder;

    invoke-direct {v9, p2}, Lco/vine/android/recorder/CameraManager$DummySurfaceHolder;-><init>(Landroid/view/Surface;)V

    invoke-virtual {v7, v9}, Landroid/hardware/Camera;->setPreviewDisplay(Landroid/view/SurfaceHolder;)V

    .line 869
    :goto_1
    const/4 v7, 0x1

    iput-boolean v7, p0, Lco/vine/android/recorder/CameraManager;->isPreviewing:Z

    .line 870
    iget-object v7, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v7}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v4

    .line 871
    .local v4, "parameters":Landroid/hardware/Camera$Parameters;
    move/from16 v0, p7

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/CameraManager;->fixOrientation(I)I

    move-result v1

    .line 872
    .local v1, "degree":I
    if-eqz p5, :cond_1

    .line 873
    invoke-virtual {p0, v4}, Lco/vine/android/recorder/CameraManager;->startContinuousAutoFocus(Landroid/hardware/Camera$Parameters;)Z

    .line 875
    :cond_1
    if-eqz p4, :cond_2

    .line 876
    const/4 v7, 0x1

    invoke-virtual {p0, v7}, Lco/vine/android/recorder/CameraManager;->changeFlashState(Z)V

    .line 878
    :cond_2
    const/16 v7, 0x5a

    if-eq v1, v7, :cond_3

    const/16 v7, 0x10e

    if-ne v1, v7, :cond_c

    :cond_3
    const/4 v3, 0x1

    .line 879
    .local v3, "flip":Z
    :goto_2
    iget v7, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    iget v9, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    invoke-virtual {v4, v7, v9}, Landroid/hardware/Camera$Parameters;->setPreviewSize(II)V

    .line 880
    iget v7, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    iget v9, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    invoke-virtual {v4, v7, v9}, Landroid/hardware/Camera$Parameters;->setPictureSize(II)V

    .line 881
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    iget v9, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, "x"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v9, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 882
    .local v6, "v":Ljava/lang/String;
    const-string v7, "video-size"

    invoke-virtual {v4, v7, v6}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 883
    sget-boolean v7, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->DISABLE_FACE_RECOGNITION:Z

    if-eqz v7, :cond_4

    .line 884
    const-string v7, "face-detection"

    const-string v9, "off"

    invoke-virtual {v4, v7, v9}, Landroid/hardware/Camera$Parameters;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 886
    :cond_4
    iget-boolean v7, p0, Lco/vine/android/recorder/CameraManager;->mIsCurrentFront:Z

    if-eqz v7, :cond_5

    iget-boolean v7, p1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->frontFacingRecordingHint:Z

    if-nez v7, :cond_6

    :cond_5
    iget-boolean v7, p0, Lco/vine/android/recorder/CameraManager;->mIsCurrentFront:Z

    if-nez v7, :cond_d

    iget-boolean v7, p1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->backFacingRecordingHint:Z

    if-eqz v7, :cond_d

    :cond_6
    const/4 v5, 0x1

    .line 887
    .local v5, "setRecordingHint":Z
    :goto_3
    if-eqz v5, :cond_7

    .line 888
    const/4 v7, 0x1

    invoke-virtual {v4, v7}, Landroid/hardware/Camera$Parameters;->setRecordingHint(Z)V

    .line 890
    :cond_7
    const-string v7, "Set preview size: {} * {}, {}, {}."

    const/4 v9, 0x4

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget v11, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    iget v11, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x3

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v7, v9}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 891
    const/16 v7, 0x11

    invoke-virtual {v4, v7}, Landroid/hardware/Camera$Parameters;->setPreviewFormat(I)V

    .line 892
    invoke-direct {p0, v4}, Lco/vine/android/recorder/CameraManager;->disableVideoStab(Landroid/hardware/Camera$Parameters;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 894
    :try_start_3
    iget-object v7, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v7, v4}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 898
    :try_start_4
    sget-boolean v7, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v7, :cond_8

    .line 899
    const-string v7, "Starting params: {}."

    iget-object v9, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v9}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v9

    invoke-virtual {v9}, Landroid/hardware/Camera$Parameters;->flatten()Ljava/lang/String;

    move-result-object v9

    invoke-static {v7, v9}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 902
    :cond_8
    new-instance v7, Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    move/from16 v0, p8

    int-to-long v9, v0

    move/from16 v0, p6

    invoke-direct {v7, p0, v0, v9, v10}, Lco/vine/android/recorder/CameraManager$StartPreviewThread;-><init>(Lco/vine/android/recorder/CameraManager;IJ)V

    iput-object v7, p0, Lco/vine/android/recorder/CameraManager;->mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    .line 903
    iget-object v7, p0, Lco/vine/android/recorder/CameraManager;->mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    invoke-virtual {v7}, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->start()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 912
    .end local v1    # "degree":I
    .end local v3    # "flip":Z
    .end local v4    # "parameters":Landroid/hardware/Camera$Parameters;
    .end local v5    # "setRecordingHint":Z
    .end local v6    # "v":Ljava/lang/String;
    :cond_9
    :try_start_5
    monitor-exit v8

    goto/16 :goto_0

    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    throw v7

    .line 862
    :cond_a
    if-eqz p3, :cond_b

    .line 863
    :try_start_6
    iget-object v7, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v7, p3}, Landroid/hardware/Camera;->setPreviewTexture(Landroid/graphics/SurfaceTexture;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_1

    .line 905
    :catch_0
    move-exception v2

    .line 906
    .local v2, "e":Ljava/lang/Exception;
    const/4 v7, 0x0

    :try_start_7
    iput-boolean v7, p0, Lco/vine/android/recorder/CameraManager;->isPreviewing:Z

    .line 907
    const-string v7, "Failed to startPreview: {}."

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v7, v9}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 908
    instance-of v7, v2, Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

    if-eqz v7, :cond_9

    .line 909
    check-cast v2, Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

    .end local v2    # "e":Ljava/lang/Exception;
    throw v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 865
    :cond_b
    :try_start_8
    const-string v7, "Surface is not ready, wait..."

    invoke-static {v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 866
    :try_start_9
    monitor-exit v8
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto/16 :goto_0

    .line 878
    .restart local v1    # "degree":I
    .restart local v4    # "parameters":Landroid/hardware/Camera$Parameters;
    :cond_c
    const/4 v3, 0x0

    goto/16 :goto_2

    .line 886
    .restart local v3    # "flip":Z
    .restart local v6    # "v":Ljava/lang/String;
    :cond_d
    const/4 v5, 0x0

    goto/16 :goto_3

    .line 895
    .restart local v5    # "setRecordingHint":Z
    :catch_1
    move-exception v2

    .line 896
    .restart local v2    # "e":Ljava/lang/Exception;
    :try_start_a
    new-instance v7, Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v9}, Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_0
    .catchall {:try_start_a .. :try_end_a} :catchall_0
.end method


# virtual methods
.method public addBuffer([BZ)V
    .locals 2
    .param p1, "bytes"    # [B
    .param p2, "isFlushing"    # Z

    .prologue
    .line 157
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v1

    .line 158
    if-eqz p1, :cond_0

    .line 159
    if-eqz p2, :cond_1

    .line 160
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z

    .line 173
    :cond_0
    :goto_0
    monitor-exit v1

    .line 174
    return-void

    .line 162
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_3

    .line 163
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mRunAddBufferThread:Z

    if-nez v0, :cond_2

    .line 164
    invoke-virtual {p0, p1}, Lco/vine/android/recorder/CameraManager;->addCallbackBuffer([B)V

    goto :goto_0

    .line 173
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 166
    :cond_2
    :try_start_1
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z

    goto :goto_0

    .line 169
    :cond_3
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;->offer(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public addCallbackBuffer([B)V
    .locals 2
    .param p1, "bytes"    # [B

    .prologue
    .line 177
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v1

    .line 178
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 179
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0, p1}, Landroid/hardware/Camera;->addCallbackBuffer([B)V

    .line 180
    sget v0, Lco/vine/android/recorder/CameraManager;->sCameraBufferCount:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lco/vine/android/recorder/CameraManager;->sCameraBufferCount:I

    .line 181
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 185
    :goto_0
    monitor-exit v1

    .line 186
    return-void

    .line 183
    :cond_0
    const-string v0, "Buffer couldn\'t be added."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_0

    .line 185
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)Z
    .locals 4
    .param p1, "cb"    # Landroid/hardware/Camera$AutoFocusCallback;

    .prologue
    const/4 v1, 0x0

    .line 267
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, p1}, Landroid/hardware/Camera;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 268
    const/4 v1, 0x1

    .line 271
    :goto_0
    return v1

    .line 269
    :catch_0
    move-exception v0

    .line 270
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Failed to autoFocus."

    new-array v3, v1, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public canChangeFocus()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 190
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getMaxNumFocusAreas()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-lez v2, :cond_0

    const/4 v1, 0x1

    .line 192
    :cond_0
    :goto_0
    return v1

    .line 191
    :catch_0
    move-exception v0

    .line 192
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public changeFlashState(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 1078
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    .line 1079
    .local v0, "parameters":Landroid/hardware/Camera$Parameters;
    if-eqz p1, :cond_0

    const-string v1, "torch"

    :goto_0
    invoke-virtual {v0, v1}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 1080
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1, v0}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1081
    return-void

    .line 1079
    :cond_0
    const-string v1, "off"

    goto :goto_0
.end method

.method public fixOrientation(I)I
    .locals 6
    .param p1, "rotation"    # I

    .prologue
    .line 1057
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v3

    .line 1058
    const/4 v0, 0x0

    .line 1059
    .local v0, "fixedDegrees":I
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v2, :cond_0

    .line 1060
    iget v2, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    invoke-static {p1, v2}, Lco/vine/android/recorder/CameraManager;->getCameraDisplayOrientation(II)I

    move-result v0

    .line 1061
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v0}, Landroid/hardware/Camera;->setDisplayOrientation(I)V

    .line 1062
    const-string v2, "Fixed orientation: {}"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1063
    iget v2, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    if-eqz v2, :cond_0

    iget v2, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    if-eqz v2, :cond_0

    .line 1064
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    .line 1065
    .local v1, "matrix":Landroid/graphics/Matrix;
    iget-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mIsCurrentFront:Z

    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    iget v5, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    invoke-static {v1, v2, v0, v4, v5}, Lco/vine/android/util/MathUtil;->prepareMatrix(Landroid/graphics/Matrix;ZIII)V

    .line 1070
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->invert(Landroid/graphics/Matrix;)Z

    .line 1073
    .end local v1    # "matrix":Landroid/graphics/Matrix;
    :cond_0
    monitor-exit v3

    return v0

    .line 1074
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public getAddedBufferArrayCount()I
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    return v0
.end method

.method public getCamera()Landroid/hardware/Camera;
    .locals 1

    .prologue
    .line 584
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    return-object v0
.end method

.method public getCameraSetting()Lco/vine/android/recorder/CameraSetting;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    return-object v0
.end method

.method public getControllerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mControllerId:Ljava/lang/String;

    return-object v0
.end method

.method public getDefaultCameraId(Z)I
    .locals 3
    .param p1, "frontFacing"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v0, -0x1

    .line 742
    if-eqz p1, :cond_1

    .line 743
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasFrontFacingCamera()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lco/vine/android/recorder/CameraManager;->mFrontFacing:[Ljava/lang/Integer;

    aget-object v0, v0, v2

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 745
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-static {}, Lco/vine/android/recorder/CameraManager;->hasBackFacingCamera()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lco/vine/android/recorder/CameraManager;->mBackFacing:[Ljava/lang/Integer;

    aget-object v0, v0, v2

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0
.end method

.method public getFrameSize()I
    .locals 1

    .prologue
    .line 1112
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mFrameSize:I

    return v0
.end method

.method public getMaxZoom()I
    .locals 1

    .prologue
    .line 1155
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    return v0
.end method

.method public getParameters()Landroid/hardware/Camera$Parameters;
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSharedByteBuffer()Ljava/nio/ByteBuffer;
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mSharedByteBuffer:Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method public isCameraReady()Z
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFlashSupported()Z
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 936
    iget-object v5, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v5}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v5

    invoke-virtual {v5}, Landroid/hardware/Camera$Parameters;->getSupportedFlashModes()Ljava/util/List;

    move-result-object v2

    .line 937
    .local v2, "modes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v5

    if-nez v5, :cond_2

    :cond_0
    move v3, v4

    .line 947
    :cond_1
    :goto_0
    return v3

    .line 940
    :cond_2
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 941
    .local v1, "mode":Ljava/lang/String;
    const-string v5, "on"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 943
    const-string v5, "torch"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    goto :goto_0

    .end local v1    # "mode":Ljava/lang/String;
    :cond_4
    move v3, v4

    .line 947
    goto :goto_0
.end method

.method public isFrameAdded([B)Z
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 348
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isPreviewing()Z
    .locals 1

    .prologue
    .line 826
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->isPreviewing:Z

    return v0
.end method

.method public isSmoothZoomingSupported()Z
    .locals 1

    .prologue
    .line 344
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    return v0
.end method

.method public isZoomSupported()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 323
    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    if-le v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected lock()V
    .locals 1

    .prologue
    .line 830
    const-string v0, "5d. Lock Camera"

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 831
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->lock()V

    .line 832
    return-void
.end method

.method public modifyAntiBanding(Z)V
    .locals 6
    .param p1, "up"    # Z

    .prologue
    .line 1338
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v4

    .line 1339
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_1

    .line 1341
    :try_start_1
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    .line 1342
    .local v2, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getSupportedAntibanding()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getAntibanding()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, p1, v3, v5}, Lco/vine/android/recorder/CameraManager;->getNextParamValue(ZLjava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1343
    .local v1, "next":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1344
    invoke-virtual {v2, v1}, Landroid/hardware/Camera$Parameters;->setAntibanding(Ljava/lang/String;)V

    .line 1345
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1347
    :cond_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1352
    .end local v1    # "next":Ljava/lang/String;
    .end local v2    # "params":Landroid/hardware/Camera$Parameters;
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit v4

    .line 1353
    return-void

    .line 1348
    :catch_0
    move-exception v0

    .line 1349
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "It just didn\'t work."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 1352
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method public modifyColorEffects(Z)V
    .locals 6
    .param p1, "up"    # Z

    .prologue
    .line 1320
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v4

    .line 1321
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_1

    .line 1323
    :try_start_1
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    .line 1324
    .local v2, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getSupportedColorEffects()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getColorEffect()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, p1, v3, v5}, Lco/vine/android/recorder/CameraManager;->getNextParamValue(ZLjava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1325
    .local v1, "next":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1326
    invoke-virtual {v2, v1}, Landroid/hardware/Camera$Parameters;->setColorEffect(Ljava/lang/String;)V

    .line 1327
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1329
    :cond_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1334
    .end local v1    # "next":Ljava/lang/String;
    .end local v2    # "params":Landroid/hardware/Camera$Parameters;
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit v4

    .line 1335
    return-void

    .line 1330
    :catch_0
    move-exception v0

    .line 1331
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "It just didn\'t work."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 1334
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method public modifyExposure(Z)V
    .locals 14
    .param p1, "up"    # Z

    .prologue
    .line 1240
    iget-object v9, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v9

    .line 1241
    :try_start_0
    iget-object v8, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v8, :cond_0

    .line 1243
    :try_start_1
    iget-object v8, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v8}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v4

    .line 1244
    .local v4, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v4}, Landroid/hardware/Camera$Parameters;->getExposureCompensation()I

    move-result v0

    .line 1245
    .local v0, "current":I
    invoke-virtual {v4}, Landroid/hardware/Camera$Parameters;->getMaxExposureCompensation()I

    move-result v2

    .line 1246
    .local v2, "max":I
    invoke-virtual {v4}, Landroid/hardware/Camera$Parameters;->getMinExposureCompensation()I

    move-result v3

    .line 1247
    .local v3, "min":I
    sub-int v8, v2, v3

    int-to-double v10, v8

    const-wide/high16 v12, 0x4024000000000000L    # 10.0

    div-double v5, v10, v12

    .line 1249
    .local v5, "step":D
    if-eqz p1, :cond_2

    .line 1250
    int-to-double v10, v0

    add-double/2addr v10, v5

    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v7, v10

    .line 1251
    .local v7, "val":I
    if-lt v7, v2, :cond_1

    .end local v2    # "max":I
    :goto_0
    invoke-virtual {v4, v2}, Landroid/hardware/Camera$Parameters;->setExposureCompensation(I)V

    .line 1256
    .end local v3    # "min":I
    :goto_1
    iget-object v8, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v8, v4}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1261
    .end local v0    # "current":I
    .end local v4    # "params":Landroid/hardware/Camera$Parameters;
    .end local v5    # "step":D
    .end local v7    # "val":I
    :cond_0
    :goto_2
    :try_start_2
    monitor-exit v9
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1262
    return-void

    .restart local v0    # "current":I
    .restart local v2    # "max":I
    .restart local v3    # "min":I
    .restart local v4    # "params":Landroid/hardware/Camera$Parameters;
    .restart local v5    # "step":D
    .restart local v7    # "val":I
    :cond_1
    move v2, v7

    .line 1251
    goto :goto_0

    .line 1253
    .end local v7    # "val":I
    :cond_2
    int-to-double v10, v0

    sub-double/2addr v10, v5

    :try_start_3
    invoke-static {v10, v11}, Ljava/lang/Math;->floor(D)D

    move-result-wide v10

    double-to-int v7, v10

    .line 1254
    .restart local v7    # "val":I
    if-gt v7, v3, :cond_3

    .end local v3    # "min":I
    :goto_3
    invoke-virtual {v4, v3}, Landroid/hardware/Camera$Parameters;->setExposureCompensation(I)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 1257
    .end local v0    # "current":I
    .end local v2    # "max":I
    .end local v4    # "params":Landroid/hardware/Camera$Parameters;
    .end local v5    # "step":D
    .end local v7    # "val":I
    :catch_0
    move-exception v1

    .line 1258
    .local v1, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v8, "It just didn\'t work."

    invoke-static {v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_2

    .line 1261
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v8

    monitor-exit v9
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v8

    .restart local v0    # "current":I
    .restart local v2    # "max":I
    .restart local v3    # "min":I
    .restart local v4    # "params":Landroid/hardware/Camera$Parameters;
    .restart local v5    # "step":D
    .restart local v7    # "val":I
    :cond_3
    move v3, v7

    .line 1254
    goto :goto_3
.end method

.method public modifySceneMode(Z)V
    .locals 6
    .param p1, "up"    # Z

    .prologue
    .line 1303
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v4

    .line 1304
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_0

    .line 1306
    :try_start_1
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    .line 1307
    .local v2, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getSupportedSceneModes()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getSceneMode()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, p1, v3, v5}, Lco/vine/android/recorder/CameraManager;->getNextParamValue(ZLjava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1308
    .local v1, "next":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1309
    invoke-virtual {v2, v1}, Landroid/hardware/Camera$Parameters;->setSceneMode(Ljava/lang/String;)V

    .line 1310
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1316
    .end local v1    # "next":Ljava/lang/String;
    .end local v2    # "params":Landroid/hardware/Camera$Parameters;
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v4

    .line 1317
    return-void

    .line 1312
    :catch_0
    move-exception v0

    .line 1313
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "It just didn\'t work."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 1316
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method public modifyWhiteBalance(Z)V
    .locals 6
    .param p1, "up"    # Z

    .prologue
    .line 1286
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v4

    .line 1287
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_0

    .line 1289
    :try_start_1
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    .line 1290
    .local v2, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getSupportedWhiteBalance()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getWhiteBalance()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, p1, v3, v5}, Lco/vine/android/recorder/CameraManager;->getNextParamValue(ZLjava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1291
    .local v1, "next":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 1292
    invoke-virtual {v2, v1}, Landroid/hardware/Camera$Parameters;->setWhiteBalance(Ljava/lang/String;)V

    .line 1293
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v3, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1299
    .end local v1    # "next":Ljava/lang/String;
    .end local v2    # "params":Landroid/hardware/Camera$Parameters;
    :cond_0
    :goto_0
    :try_start_2
    monitor-exit v4

    .line 1300
    return-void

    .line 1295
    :catch_0
    move-exception v0

    .line 1296
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "It just didn\'t work."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 1299
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method public modifyZoom(I)I
    .locals 7
    .param p1, "zoom"    # I

    .prologue
    const/4 v2, 0x0

    .line 1211
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v4

    .line 1212
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v3, :cond_2

    .line 1213
    const/4 v1, 0x0

    .line 1214
    .local v1, "min":I
    sget-boolean v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->IS_ZERO_INDEX_BASED_ZOOM:Z

    if-eqz v3, :cond_0

    .line 1215
    add-int/lit8 p1, p1, -0x1

    .line 1216
    const/4 v1, -0x1

    .line 1218
    :cond_0
    iget v3, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    if-eq p1, v3, :cond_2

    .line 1219
    iget v3, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    if-gt p1, v3, :cond_2

    if-le p1, v1, :cond_2

    .line 1220
    iget v3, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    if-le p1, v3, :cond_1

    const/4 v2, 0x1

    .line 1221
    .local v2, "zoomIn":Z
    :cond_1
    iput p1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1223
    :try_start_1
    const-string v3, "Modifying waiting to zoom to {} using smooth? {}."

    iget v5, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-boolean v6, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1224
    iget-boolean v3, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    if-eqz v3, :cond_3

    .line 1225
    invoke-virtual {p0, v2}, Lco/vine/android/recorder/CameraManager;->startSmoothZoom(Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1235
    .end local v1    # "min":I
    .end local v2    # "zoomIn":Z
    :cond_2
    :goto_0
    :try_start_2
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1236
    iget v3, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    return v3

    .line 1227
    .restart local v1    # "min":I
    .restart local v2    # "zoomIn":Z
    :cond_3
    :try_start_3
    invoke-virtual {p0}, Lco/vine/android/recorder/CameraManager;->startInstantZoom()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 1229
    :catch_0
    move-exception v0

    .line 1230
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    const-string v3, "It just didn\'t work."

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0, v3, v5}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 1235
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "min":I
    .end local v2    # "zoomIn":Z
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v3
.end method

.method public modifyZoom(Z)I
    .locals 2
    .param p1, "zoomIn"    # Z

    .prologue
    .line 1117
    iget-boolean v1, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    if-eqz v1, :cond_2

    .line 1118
    if-eqz p1, :cond_1

    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    .line 1122
    .local v0, "newZoom":I
    :goto_0
    sget-boolean v1, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->IS_ZERO_INDEX_BASED_ZOOM:Z

    if-eqz v1, :cond_0

    .line 1123
    add-int/lit8 v0, v0, 0x1

    .line 1125
    :cond_0
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/CameraManager;->modifyZoom(I)I

    move-result v1

    return v1

    .line 1118
    .end local v0    # "newZoom":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 1120
    :cond_2
    if-eqz p1, :cond_3

    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    add-int/lit8 v0, v1, 0x1

    .restart local v0    # "newZoom":I
    :goto_1
    goto :goto_0

    .end local v0    # "newZoom":I
    :cond_3
    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    add-int/lit8 v0, v1, -0x1

    goto :goto_1
.end method

.method public onPreviewFrameReceived()V
    .locals 6

    .prologue
    .line 314
    iget-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mFramesReceived:J

    const-wide/16 v4, 0x1

    add-long/2addr v2, v4

    iput-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mFramesReceived:J

    .line 315
    iget-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mLastPreviewFrameTimestamp:J

    const-wide/16 v4, -0x1

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 316
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lco/vine/android/recorder/CameraManager;->mLastPreviewFrameTimestamp:J

    sub-long v0, v2, v4

    .line 317
    .local v0, "timeElapsed":J
    iget-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mMaxtimeElapsed:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mMaxtimeElapsed:J

    .line 319
    .end local v0    # "timeElapsed":J
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mLastPreviewFrameTimestamp:J

    .line 320
    return-void
.end method

.method public onZoomChange(IZLandroid/hardware/Camera;)V
    .locals 6
    .param p1, "zoomValue"    # I
    .param p2, "stopped"    # Z
    .param p3, "camera"    # Landroid/hardware/Camera;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1160
    if-eqz p2, :cond_5

    .line 1161
    const-string v0, "Zoom stopped on value {} (target {}, queued value: {})."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mCurrentZoomTarget:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iget v5, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v0, v3, v4, v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1162
    iput-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZooming:Z

    .line 1163
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 1165
    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/CameraManager;->startContinuousAutoFocus(Landroid/hardware/Camera$Parameters;)Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1170
    :cond_0
    :goto_0
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomingStopCalled:Z

    if-eqz v0, :cond_1

    .line 1171
    iput-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomingStopCalled:Z

    .line 1172
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    iget v3, p0, Lco/vine/android/recorder/CameraManager;->mCurrentZoomTarget:I

    if-ne v0, v3, :cond_1

    .line 1173
    iput p1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    .line 1176
    :cond_1
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    if-eq p1, v0, :cond_2

    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_2

    .line 1177
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    if-lt v0, p1, :cond_4

    move v0, v1

    :goto_1
    invoke-virtual {p0, v0}, Lco/vine/android/recorder/CameraManager;->startSmoothZoom(Z)V

    .line 1186
    :cond_2
    :goto_2
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;

    if-eqz v0, :cond_3

    .line 1187
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;

    sget-boolean v0, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->IS_ZERO_INDEX_BASED_ZOOM:Z

    if-eqz v0, :cond_6

    add-int/lit8 v0, p1, 0x1

    :goto_3
    if-eqz p2, :cond_7

    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    if-ne p1, v4, :cond_7

    :goto_4
    invoke-virtual {v3, v0, v1}, Lco/vine/android/recorder/RecordController;->onZoomUpdated(IZ)V

    .line 1190
    if-eqz p2, :cond_3

    .line 1191
    iput-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mAutoStopZoomCalled:Z

    .line 1194
    :cond_3
    return-void

    :cond_4
    move v0, v2

    .line 1177
    goto :goto_1

    .line 1180
    :cond_5
    const-string v0, "Zoom updated on value {} (queued value: {})."

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget v4, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v0, v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1181
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mCurrentZoomTarget:I

    if-ne v0, p1, :cond_2

    .line 1182
    const-string v0, "Stop zoom on reaching target."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1183
    invoke-virtual {p0}, Lco/vine/android/recorder/CameraManager;->stopSmoothZoom()Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mAutoStopZoomCalled:Z

    goto :goto_2

    :cond_6
    move v0, p1

    .line 1187
    goto :goto_3

    :cond_7
    move v1, v2

    goto :goto_4

    .line 1166
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public openDefaultCamera(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ZIZ)Lco/vine/android/recorder/CameraSetting;
    .locals 6
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p2, "frontFacing"    # Z
    .param p3, "rotation"    # I
    .param p4, "reOpen"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 750
    invoke-virtual {p0, p2}, Lco/vine/android/recorder/CameraManager;->getDefaultCameraId(Z)I

    move-result v3

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lco/vine/android/recorder/CameraManager;->safeCameraOpen(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ZIIZ)Lco/vine/android/recorder/CameraSetting;

    move-result-object v0

    return-object v0
.end method

.method public preLoadCameras(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;)V
    .locals 5
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 285
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mIntentionalObjectCounter:Lco/vine/android/util/IntentionalObjectCounter;

    invoke-virtual {v1}, Lco/vine/android/util/IntentionalObjectCounter;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 286
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v2

    .line 288
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-nez v1, :cond_0

    .line 290
    sget-object v1, Lco/vine/android/recorder/CameraManager;->sCameraSettingTable:Landroid/util/SparseArray;

    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Lco/vine/android/recorder/CameraManager;->getDefaultCameraId(Z)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/CameraSetting;

    .line 292
    .local v0, "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    if-nez v0, :cond_2

    .line 293
    const/4 v1, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p0, p1, v1, v3, v4}, Lco/vine/android/recorder/CameraManager;->openDefaultCamera(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ZIZ)Lco/vine/android/recorder/CameraSetting;

    .line 294
    const-string v1, "preload"

    invoke-virtual {p0, v1}, Lco/vine/android/recorder/CameraManager;->releaseCameraAndPreview(Ljava/lang/String;)V

    .line 299
    :goto_0
    sget-object v1, Lco/vine/android/recorder/CameraManager;->sCameraSettingTable:Landroid/util/SparseArray;

    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lco/vine/android/recorder/CameraManager;->getDefaultCameraId(Z)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    check-cast v0, Lco/vine/android/recorder/CameraSetting;

    .line 301
    .restart local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    if-nez v0, :cond_3

    .line 302
    const/4 v1, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p0, p1, v1, v3, v4}, Lco/vine/android/recorder/CameraManager;->openDefaultCamera(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;ZIZ)Lco/vine/android/recorder/CameraSetting;

    .line 303
    const-string v1, "preload"

    invoke-virtual {p0, v1}, Lco/vine/android/recorder/CameraManager;->releaseCameraAndPreview(Ljava/lang/String;)V

    .line 309
    .end local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    :cond_0
    :goto_1
    monitor-exit v2

    .line 311
    :cond_1
    return-void

    .line 296
    .restart local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    :cond_2
    const-string v1, "Skip preload ffc."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 309
    .end local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 305
    .restart local v0    # "cameraSetting":Lco/vine/android/recorder/CameraSetting;
    :cond_3
    :try_start_1
    const-string v1, "Skip preload bfc."

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method public printSupportedPreviewSizes()V
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 327
    iget-object v5, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v5, :cond_1

    .line 328
    iget-object v5, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v5}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 329
    .local v1, "param":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getPreferredPreviewSizeForVideo()Landroid/hardware/Camera$Size;

    move-result-object v2

    .line 330
    .local v2, "preferred":Landroid/hardware/Camera$Size;
    if-eqz v2, :cond_0

    .line 331
    const-string v5, "Preferred size: {} * {}"

    new-array v6, v10, [Ljava/lang/Object;

    iget v7, v2, Landroid/hardware/Camera$Size;->width:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    iget v7, v2, Landroid/hardware/Camera$Size;->height:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 333
    :cond_0
    iget-object v5, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v5}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v5

    invoke-virtual {v5}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v4

    .line 334
    .local v4, "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    if-eqz v4, :cond_1

    .line 335
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/hardware/Camera$Size;

    .line 336
    .local v3, "size":Landroid/hardware/Camera$Size;
    const-string v5, "Supported Preview Size: {} * {}."

    new-array v6, v10, [Ljava/lang/Object;

    iget v7, v3, Landroid/hardware/Camera$Size;->width:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    iget v7, v3, Landroid/hardware/Camera$Size;->height:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v5, v6}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .line 341
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "param":Landroid/hardware/Camera$Parameters;
    .end local v2    # "preferred":Landroid/hardware/Camera$Size;
    .end local v3    # "size":Landroid/hardware/Camera$Size;
    .end local v4    # "sizes":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Size;>;"
    :cond_1
    return-void
.end method

.method public releaseCameraAndPreview(Ljava/lang/String;)V
    .locals 13
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    const-wide/16 v11, 0x0

    const/4 v2, 0x1

    const/4 v0, -0x1

    const/4 v3, 0x0

    .line 754
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    .line 755
    .local v1, "startPreviewThread":Lco/vine/android/recorder/CameraManager$StartPreviewThread;
    if-eqz v1, :cond_0

    .line 756
    invoke-virtual {v1}, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->notifyReleasedAlready()V

    .line 758
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/recorder/CameraManager;->waitForPreviewToStart()V

    .line 759
    iget-object v6, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v6

    .line 760
    :try_start_0
    iget-object v4, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    if-eqz v4, :cond_4

    .line 761
    const-string v4, "6,7 RELEASE Camera and STOP Preview."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 762
    invoke-virtual {p0}, Lco/vine/android/recorder/CameraManager;->isPreviewing()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 763
    invoke-virtual {p0}, Lco/vine/android/recorder/CameraManager;->stopPreview()V

    .line 765
    :cond_1
    const-string v4, "Camera was released from {}."

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v5, v7

    invoke-static {v4, v5}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 766
    iget-wide v4, p0, Lco/vine/android/recorder/CameraManager;->mFramesReceived:J

    cmp-long v4, v4, v11

    if-lez v4, :cond_2

    iget-wide v4, p0, Lco/vine/android/recorder/CameraManager;->mFramesReceived:J

    const-wide/16 v7, 0x3e8

    mul-long/2addr v4, v7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    iget-wide v9, p0, Lco/vine/android/recorder/CameraManager;->mPreviewStartTime:J

    sub-long/2addr v7, v9

    div-long/2addr v4, v7

    long-to-int v0, v4

    .line 767
    .local v0, "avgFrameRate":I
    :cond_2
    if-lez v0, :cond_3

    .line 768
    const-string v7, "Lowest frame rate: {}."

    iget-wide v4, p0, Lco/vine/android/recorder/CameraManager;->mMaxtimeElapsed:J

    cmp-long v4, v4, v11

    if-lez v4, :cond_5

    const-wide/16 v4, 0x3e8

    iget-wide v8, p0, Lco/vine/android/recorder/CameraManager;->mMaxtimeElapsed:J

    div-long/2addr v4, v8

    :goto_0
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v7, v4}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;)V

    .line 769
    const-string v4, "Average frame rate: {}."

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    if-lez v0, :cond_6

    const/16 v7, 0xf

    if-ge v0, v7, :cond_6

    :goto_1
    invoke-static {v4, v5, v2}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 771
    :cond_3
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 772
    const/4 v2, 0x0

    sput v2, Lco/vine/android/recorder/CameraManager;->sCameraBufferCount:I

    .line 773
    const-string v2, "null"

    iput-object v2, p0, Lco/vine/android/recorder/CameraManager;->mControllerId:Ljava/lang/String;

    .line 775
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->release()V

    .line 776
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    .line 777
    const/4 v2, 0x0

    iput-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCameraSetting:Lco/vine/android/recorder/CameraSetting;

    .line 778
    const/4 v2, -0x1

    iput v2, p0, Lco/vine/android/recorder/CameraManager;->mCurrentCamera:I

    .line 780
    .end local v0    # "avgFrameRate":I
    :cond_4
    monitor-exit v6

    .line 781
    return-void

    .line 768
    .restart local v0    # "avgFrameRate":I
    :cond_5
    iget-wide v4, p0, Lco/vine/android/recorder/CameraManager;->mMaxtimeElapsed:J

    goto :goto_0

    :cond_6
    move v2, v3

    .line 769
    goto :goto_1

    .line 780
    .end local v0    # "avgFrameRate":I
    :catchall_0
    move-exception v2

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public releaseCameraResources()V
    .locals 1

    .prologue
    .line 509
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mBufferArray:Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;->clear()V

    .line 510
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 511
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 512
    return-void
.end method

.method public removeBufferFromAvailableQueue([B)V
    .locals 1
    .param p1, "b"    # [B

    .prologue
    .line 149
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mAddedBufferArray:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 150
    return-void
.end method

.method public setController(Lco/vine/android/recorder/RecordController;)V
    .locals 0
    .param p1, "cb"    # Lco/vine/android/recorder/RecordController;

    .prologue
    .line 133
    iput-object p1, p0, Lco/vine/android/recorder/CameraManager;->mController:Lco/vine/android/recorder/RecordController;

    .line 134
    return-void
.end method

.method public setFocusAreas(II)Z
    .locals 7
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 198
    :try_start_0
    invoke-direct {p0, p1, p2}, Lco/vine/android/recorder/CameraManager;->initializeFocusAreas(II)V

    .line 199
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 200
    .local v1, "params":Landroid/hardware/Camera$Parameters;
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mFocusArea:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFocusAreas(Ljava/util/List;)V

    .line 201
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move v2, v3

    .line 205
    .end local v1    # "params":Landroid/hardware/Camera$Parameters;
    :goto_0
    return v2

    .line 203
    :catch_0
    move-exception v0

    .line 204
    .local v0, "e":Ljava/lang/Exception;
    const-string v5, "Failed to set focus areas {}, {}."

    const/4 v2, 0x2

    new-array v6, v2, [Ljava/lang/Object;

    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mMatrix:Landroid/graphics/Matrix;

    aput-object v2, v6, v4

    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mFocusArea:Ljava/util/ArrayList;

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/hardware/Camera$Area;

    iget-object v2, v2, Landroid/hardware/Camera$Area;->rect:Landroid/graphics/Rect;

    aput-object v2, v6, v3

    invoke-static {v0, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    move v2, v4

    .line 205
    goto :goto_0
.end method

.method public setFrameRate(I)I
    .locals 20
    .param p1, "frameRate"    # I

    .prologue
    .line 951
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    move-object/from16 v16, v0

    monitor-enter v16

    .line 952
    :try_start_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v15, :cond_9

    .line 956
    :try_start_1
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v10

    .line 957
    .local v10, "parameters":Landroid/hardware/Camera$Parameters;
    move/from16 v0, p1

    mul-int/lit16 v15, v0, 0x3e8

    move/from16 v0, p1

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-virtual {v10, v15, v0}, Landroid/hardware/Camera$Parameters;->setPreviewFpsRange(II)V

    .line 958
    const-string v15, "SET frameRate using fixed-range frameRate"

    invoke-static {v15}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 959
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15, v10}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 960
    :try_start_2
    monitor-exit v16
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move/from16 v15, p1

    .line 1053
    .end local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    :goto_0
    return v15

    .line 961
    :catch_0
    move-exception v3

    .line 962
    .local v3, "e":Ljava/lang/Exception;
    :try_start_3
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v10

    .line 963
    .restart local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    move/from16 v0, p1

    invoke-virtual {v10, v0}, Landroid/hardware/Camera$Parameters;->setPreviewFrameRate(I)V

    .line 964
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15, v10}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 965
    const-string v15, "SET frameRate using fixed frameRate"

    invoke-static {v15}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 966
    :try_start_4
    monitor-exit v16
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move/from16 v15, p1

    goto :goto_0

    .line 968
    .end local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    :catch_1
    move-exception v3

    .line 971
    :try_start_5
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v10

    .line 976
    .restart local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    :try_start_6
    invoke-virtual {v10}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewFpsRange()Ljava/util/List;

    move-result-object v14

    .line 977
    .local v14, "ss":Ljava/util/List;, "Ljava/util/List<[I>;"
    if-nez v14, :cond_0

    .line 978
    const-string v15, "Cannot set frame-rate"

    invoke-static {v15}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 979
    :try_start_7
    monitor-exit v16

    move/from16 v15, p1

    goto :goto_0

    .line 972
    .end local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    .end local v14    # "ss":Ljava/util/List;, "Ljava/util/List<[I>;"
    :catch_2
    move-exception v4

    .line 974
    .local v4, "e2":Ljava/lang/Exception;
    const/16 v15, 0x1e

    monitor-exit v16

    goto :goto_0

    .line 1052
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v4    # "e2":Ljava/lang/Exception;
    :catchall_0
    move-exception v15

    monitor-exit v16
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    throw v15

    .line 981
    .restart local v3    # "e":Ljava/lang/Exception;
    .restart local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    .restart local v14    # "ss":Ljava/util/List;, "Ljava/util/List<[I>;"
    :cond_0
    move/from16 v0, p1

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 p1, v0

    .line 982
    const/4 v13, 0x0

    .line 983
    .local v13, "selected":[I
    const/4 v8, 0x0

    .local v8, "lowest":I
    const/4 v6, 0x0

    .local v6, "highest":I
    const/4 v11, -0x1

    .local v11, "reachedIndex":I
    :try_start_8
    invoke-interface {v14}, Ljava/util/List;->size()I

    move-result v15

    add-int/lit8 v9, v15, -0x1

    .line 984
    .local v9, "otherIndex":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    invoke-interface {v14}, Ljava/util/List;->size()I

    move-result v15

    if-ge v7, v15, :cond_1

    .line 985
    invoke-interface {v14, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, [I

    .line 986
    .local v12, "s":[I
    const-string v15, "Supported FPS: {}"

    invoke-static {v15, v12}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 987
    const/4 v15, 0x0

    aget v15, v12, v15

    move/from16 v0, p1

    if-ne v15, v0, :cond_3

    .line 988
    move-object v13, v12

    .line 1010
    .end local v12    # "s":[I
    :cond_1
    if-nez v13, :cond_2

    .line 1011
    const/4 v15, -0x1

    if-eq v11, v15, :cond_7

    .line 1012
    invoke-interface {v14, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    .end local v13    # "selected":[I
    check-cast v13, [I

    .line 1018
    .restart local v13    # "selected":[I
    :cond_2
    :goto_2
    const/4 v15, 0x1

    aget v15, v13, v15
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    move/from16 v0, p1

    if-lt v15, v0, :cond_8

    .line 1020
    :try_start_9
    const-string v15, "Try Using variable FPS: {}, {}."

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-static {v15, v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1021
    move/from16 v0, p1

    invoke-virtual {v10, v8, v0}, Landroid/hardware/Camera$Parameters;->setPreviewFpsRange(II)V

    .line 1022
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15, v10}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1023
    move/from16 v0, p1

    div-int/lit16 v15, v0, 0x3e8
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_3
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    :try_start_a
    monitor-exit v16
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    goto/16 :goto_0

    .line 991
    .restart local v12    # "s":[I
    :cond_3
    const/4 v15, 0x1

    :try_start_b
    aget v15, v12, v15

    move/from16 v0, p1

    if-ne v15, v0, :cond_6

    .line 992
    const/4 v15, 0x0

    aget v15, v12, v15

    if-ge v8, v15, :cond_4

    .line 993
    const/4 v15, 0x0

    aget v8, v12, v15

    .line 994
    move v11, v7

    .line 996
    :cond_4
    const/4 v15, 0x1

    aget v15, v12, v15

    if-gt v6, v15, :cond_5

    .line 997
    const/4 v15, 0x1

    aget v6, v12, v15

    .line 984
    :cond_5
    :goto_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 1000
    :cond_6
    const/4 v15, 0x0

    aget v15, v12, v15

    if-gt v8, v15, :cond_5

    .line 1001
    const/4 v15, 0x0

    aget v8, v12, v15

    .line 1002
    const/4 v15, 0x1

    aget v15, v12, v15

    if-gt v6, v15, :cond_5

    .line 1003
    const/4 v15, 0x1

    aget v6, v12, v15

    .line 1004
    move v9, v7

    goto :goto_3

    .line 1014
    .end local v12    # "s":[I
    :cond_7
    invoke-interface {v14, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    .end local v13    # "selected":[I
    check-cast v13, [I
    :try_end_b
    .catch Ljava/lang/Exception; {:try_start_b .. :try_end_b} :catch_5
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .restart local v13    # "selected":[I
    goto :goto_2

    .line 1024
    :catch_3
    move-exception v4

    .line 1026
    .restart local v4    # "e2":Ljava/lang/Exception;
    :try_start_c
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v10

    .line 1027
    const-string v15, "Try Using fixed framerate FPS: {}"

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-static {v15, v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1028
    move/from16 v0, p1

    div-int/lit16 v15, v0, 0x3e8

    invoke-virtual {v10, v15}, Landroid/hardware/Camera$Parameters;->setPreviewFrameRate(I)V

    .line 1029
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15, v10}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1030
    move/from16 v0, p1

    div-int/lit16 v15, v0, 0x3e8
    :try_end_c
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_4
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    :try_start_d
    monitor-exit v16
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    goto/16 :goto_0

    .line 1031
    :catch_4
    move-exception v5

    .line 1032
    .local v5, "e3":Ljava/lang/Exception;
    :try_start_e
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v10

    .line 1033
    const-string v15, "Try Using selected framerate FPS: {}, {}, {}."

    const/16 v17, 0x0

    aget v17, v13, v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    const/16 v18, 0x1

    aget v18, v13, v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    invoke-static/range {p1 .. p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-static {v15, v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 1034
    const/4 v15, 0x0

    aget v15, v13, v15

    const/16 v17, 0x1

    aget v17, v13, v17

    move/from16 v0, v17

    invoke-virtual {v10, v15, v0}, Landroid/hardware/Camera$Parameters;->setPreviewFpsRange(II)V

    .line 1035
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15, v10}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1036
    const/4 v15, 0x1

    aget v15, v13, v15

    div-int/lit16 v15, v15, 0x3e8
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_5
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    :try_start_f
    monitor-exit v16
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    goto/16 :goto_0

    .line 1040
    .end local v4    # "e2":Ljava/lang/Exception;
    .end local v5    # "e3":Ljava/lang/Exception;
    :cond_8
    :try_start_10
    const-string v15, "Fall back, should never reach here."

    invoke-static {v15}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1041
    move/from16 v0, p1

    div-int/lit16 v0, v0, 0x3e8

    move/from16 p1, v0

    .line 1042
    move/from16 v0, p1

    invoke-virtual {v10, v0}, Landroid/hardware/Camera$Parameters;->setPreviewFrameRate(I)V

    .line 1043
    move-object/from16 v0, p0

    iget-object v15, v0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v15, v10}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_10
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_5
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    .line 1044
    :try_start_11
    monitor-exit v16

    move/from16 v15, p1

    goto/16 :goto_0

    .line 1048
    .end local v6    # "highest":I
    .end local v7    # "i":I
    .end local v8    # "lowest":I
    .end local v9    # "otherIndex":I
    .end local v11    # "reachedIndex":I
    .end local v13    # "selected":[I
    .end local v14    # "ss":Ljava/util/List;, "Ljava/util/List<[I>;"
    :catch_5
    move-exception v3

    .line 1049
    const/16 v15, 0x1e

    monitor-exit v16

    goto/16 :goto_0

    .line 1052
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v10    # "parameters":Landroid/hardware/Camera$Parameters;
    :cond_9
    monitor-exit v16
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_0

    .line 1053
    const/16 v15, 0x1e

    goto/16 :goto_0
.end method

.method public setPreviewSize(II)V
    .locals 2
    .param p1, "previewWidth"    # I
    .param p2, "previewHeight"    # I

    .prologue
    .line 1106
    iput p1, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    .line 1107
    iput p2, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    .line 1108
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mPreviewWidth:I

    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mPreviewHeight:I

    mul-int/2addr v0, v1

    const/16 v1, 0x11

    invoke-static {v1}, Landroid/graphics/ImageFormat;->getBitsPerPixel(I)I

    move-result v1

    mul-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x8

    iput v0, p0, Lco/vine/android/recorder/CameraManager;->mFrameSize:I

    .line 1109
    return-void
.end method

.method public startContinuousAutoFocus(Landroid/hardware/Camera$Parameters;)Z
    .locals 7
    .param p1, "params"    # Landroid/hardware/Camera$Parameters;

    .prologue
    const/4 v4, 0x0

    .line 784
    const-string v3, ""

    .line 786
    .local v3, "supportedMode":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->getSupportedFocusModes()Ljava/util/List;

    move-result-object v1

    .line 788
    .local v1, "focusModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v1, :cond_1

    .line 813
    :cond_0
    :goto_0
    return v4

    .line 792
    :cond_1
    sget-boolean v5, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->FORCE_AUTO_FOCUS:Z

    if-eqz v5, :cond_3

    .line 793
    const-string v3, "auto"

    .line 794
    const-string v5, "Focus Mode: AUTO"

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 802
    :cond_2
    :goto_1
    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->getFocusMode()Ljava/lang/String;

    move-result-object v2

    .line 804
    .local v2, "originalFocusMode":Ljava/lang/String;
    :try_start_0
    const-string v5, ""

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 805
    invoke-virtual {p1, v3}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 806
    iget-object v5, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v5, p1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 807
    const/4 v4, 0x1

    goto :goto_0

    .line 795
    .end local v2    # "originalFocusMode":Ljava/lang/String;
    :cond_3
    const-string v5, "continuous-video"

    invoke-interface {v1, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 796
    const-string v3, "continuous-video"

    .line 797
    const-string v5, "Focus Mode: CONTINUOUS VIDEO"

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_1

    .line 798
    :cond_4
    const-string v5, "infinity"

    invoke-interface {v1, v5}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 799
    const-string v3, "infinity"

    .line 800
    const-string v5, "Focus Mode: INFINITY"

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_1

    .line 809
    .restart local v2    # "originalFocusMode":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 810
    .local v0, "e":Ljava/lang/Exception;
    const-string v5, "Continuous Auto Focus is not supported on this device."

    new-array v6, v4, [Ljava/lang/Object;

    invoke-static {v0, v5, v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 811
    invoke-virtual {p1, v2}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public startInstantZoom()V
    .locals 4

    .prologue
    .line 1146
    const-string v1, "Instant zoom started on value {}"

    iget v2, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1147
    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    iput v1, p0, Lco/vine/android/recorder/CameraManager;->mCurrentZoomTarget:I

    .line 1148
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    .line 1149
    .local v0, "params":Landroid/hardware/Camera$Parameters;
    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    invoke-virtual {v0, v1}, Landroid/hardware/Camera$Parameters;->setZoom(I)V

    .line 1150
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1, v0}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 1151
    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    const/4 v2, 0x1

    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {p0, v1, v2, v3}, Lco/vine/android/recorder/CameraManager;->onZoomChange(IZLandroid/hardware/Camera;)V

    .line 1152
    return-void
.end method

.method public startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/graphics/SurfaceTexture;ZZIII)V
    .locals 9
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p2, "texture"    # Landroid/graphics/SurfaceTexture;
    .param p3, "flash"    # Z
    .param p4, "autoFocus"    # Z
    .param p5, "frameRate"    # I
    .param p6, "rotation"    # I
    .param p7, "currentDuration"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;
        }
    .end annotation

    .prologue
    .line 839
    const/4 v2, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lco/vine/android/recorder/CameraManager;->startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/view/Surface;Landroid/graphics/SurfaceTexture;ZZIII)V

    .line 840
    return-void
.end method

.method public startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/view/Surface;ZZIII)V
    .locals 9
    .param p1, "config"    # Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;
    .param p2, "surface"    # Landroid/view/Surface;
    .param p3, "flash"    # Z
    .param p4, "autoFocus"    # Z
    .param p5, "frameRate"    # I
    .param p6, "rotation"    # I
    .param p7, "currentDuration"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/recorder/CameraManager$InvalidPreviewSizeException;
        }
    .end annotation

    .prologue
    .line 835
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lco/vine/android/recorder/CameraManager;->startPreview(Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;Landroid/view/Surface;Landroid/graphics/SurfaceTexture;ZZIII)V

    .line 836
    return-void
.end method

.method public startSmoothZoom(Z)V
    .locals 2
    .param p1, "zoomIn"    # Z

    .prologue
    .line 1129
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomSupported:Z

    if-nez v0, :cond_0

    .line 1130
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Smooth zoom not supported."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1132
    :cond_0
    iget-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZooming:Z

    if-nez v0, :cond_1

    .line 1133
    const-string v0, "Smooth zoom started on value {}"

    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1134
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/recorder/CameraManager;->stopContinuousFocus(Landroid/hardware/Camera$Parameters;)Z

    .line 1135
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZooming:Z

    .line 1136
    iget v0, p0, Lco/vine/android/recorder/CameraManager;->mRequestedZoom:I

    iput v0, p0, Lco/vine/android/recorder/CameraManager;->mCurrentZoomTarget:I

    .line 1137
    if-eqz p1, :cond_2

    .line 1138
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    iget v1, p0, Lco/vine/android/recorder/CameraManager;->mMaxZoom:I

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->startSmoothZoom(I)V

    .line 1143
    :cond_1
    :goto_0
    return-void

    .line 1140
    :cond_2
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->startSmoothZoom(I)V

    goto :goto_0
.end method

.method public stopContinuousFocus(Landroid/hardware/Camera$Parameters;)Z
    .locals 4
    .param p1, "params"    # Landroid/hardware/Camera$Parameters;

    .prologue
    .line 237
    const-string v1, ""

    .line 239
    .local v1, "supportedMode":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/hardware/Camera$Parameters;->getSupportedFocusModes()Ljava/util/List;

    move-result-object v0

    .line 241
    .local v0, "focusModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v2, "Force auto focus: {}"

    sget-boolean v3, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->FORCE_AUTO_FOCUS:Z

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 243
    if-eqz v0, :cond_3

    .line 245
    const-string v2, "auto"

    invoke-interface {v0, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-boolean v2, Lco/vine/android/recorder/RecordConfigUtils$RecordConfig;->FORCE_AUTO_FOCUS:Z

    if-eqz v2, :cond_2

    .line 247
    :cond_0
    const-string v1, "auto"

    .line 248
    const-string v2, "Focus Mode: FOCUS_MODE_AUTO"

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 256
    :cond_1
    :goto_0
    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 257
    invoke-virtual {p1, v1}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 258
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, p1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 259
    const/4 v2, 0x1

    .line 262
    :goto_1
    return v2

    .line 250
    :cond_2
    const-string v2, "continuous-picture"

    invoke-interface {v0, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 251
    const-string v1, "continuous-picture"

    .line 252
    const-string v2, "Focus Mode: FOCUS_MODE_CONTINUOUS_PICTURE"

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0

    .line 262
    :cond_3
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public stopPreview()V
    .locals 4

    .prologue
    .line 817
    iget-object v1, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v1

    .line 818
    :try_start_0
    const-string v0, "6. Stop Preview."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 819
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->stopPreview()V

    .line 820
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lco/vine/android/recorder/CameraManager;->mLastPreviewFrameTimestamp:J

    .line 821
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/CameraManager;->isPreviewing:Z

    .line 822
    monitor-exit v1

    .line 823
    return-void

    .line 822
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public stopSmoothZoom()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 1197
    iget-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZooming:Z

    if-eqz v2, :cond_0

    iget-boolean v2, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomingStopCalled:Z

    if-nez v2, :cond_0

    .line 1198
    iput-boolean v1, p0, Lco/vine/android/recorder/CameraManager;->mIsSmoothZoomingStopCalled:Z

    .line 1199
    const-string v2, "Stop smooth zoom."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1201
    :try_start_0
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->stopSmoothZoom()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1207
    :goto_0
    return v1

    .line 1202
    :catch_0
    move-exception v0

    .line 1203
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "Failed to stop smooth zoom."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 1207
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public switchImageStabilization()V
    .locals 5
    .annotation build Landroid/annotation/TargetApi;
        value = 0xf
    .end annotation

    .prologue
    .line 1357
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mLOCK:[I

    monitor-enter v3

    .line 1358
    :try_start_0
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xf

    if-lt v2, v4, :cond_1

    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v2, :cond_1

    .line 1360
    :try_start_1
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 1361
    .local v1, "params":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->isVideoStabilizationSupported()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1362
    invoke-virtual {v1}, Landroid/hardware/Camera$Parameters;->getVideoStabilization()Z

    move-result v2

    if-nez v2, :cond_2

    const/4 v2, 0x1

    :goto_0
    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setVideoStabilization(Z)V

    .line 1364
    :cond_0
    iget-object v2, p0, Lco/vine/android/recorder/CameraManager;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1369
    .end local v1    # "params":Landroid/hardware/Camera$Parameters;
    :cond_1
    :goto_1
    :try_start_2
    monitor-exit v3

    .line 1370
    return-void

    .line 1362
    .restart local v1    # "params":Landroid/hardware/Camera$Parameters;
    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    .line 1365
    .end local v1    # "params":Landroid/hardware/Camera$Parameters;
    :catch_0
    move-exception v0

    .line 1366
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "It just didn\'t work."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_1

    .line 1369
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method

.method public waitForPreviewToStart()V
    .locals 6

    .prologue
    .line 917
    :try_start_0
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    if-eqz v3, :cond_0

    .line 918
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 919
    .local v1, "start":J
    iget-object v3, p0, Lco/vine/android/recorder/CameraManager;->mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    invoke-virtual {v3}, Lco/vine/android/recorder/CameraManager$StartPreviewThread;->join()V

    .line 920
    const-string v3, "Waiting for preview thread took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 925
    .end local v1    # "start":J
    :cond_0
    :goto_0
    const/4 v3, 0x0

    iput-object v3, p0, Lco/vine/android/recorder/CameraManager;->mStartPreviewThread:Lco/vine/android/recorder/CameraManager$StartPreviewThread;

    .line 926
    return-void

    .line 922
    :catch_0
    move-exception v0

    .line 923
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v3, "Couldn\'t wait for preview to join."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0
.end method
