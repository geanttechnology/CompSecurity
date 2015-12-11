.class public Lcom/amazon/mShop/search/viewit/CameraThread;
.super Ljava/lang/Thread;
.source "CameraThread.java"


# instance fields
.field private mCamera:Landroid/hardware/Camera;

.field private final mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;

.field private final mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;

.field private mHandler:Landroid/os/Handler;

.field private final mThreadInitLatch:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 23
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 17
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mHandler:Landroid/os/Handler;

    .line 18
    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;

    .line 24
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mThreadInitLatch:Ljava/util/concurrent/CountDownLatch;

    .line 25
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;

    .line 26
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;

    .line 27
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/CameraThread;)Landroid/hardware/Camera;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/CameraThread;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/search/viewit/CameraThread;Landroid/hardware/Camera;)Landroid/hardware/Camera;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/CameraThread;
    .param p1, "x1"    # Landroid/hardware/Camera;

    .prologue
    .line 15
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/CameraThread;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/CameraThread;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method


# virtual methods
.method public getCamera()Landroid/hardware/Camera;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;

    return-object v0
.end method

.method public openAwait(JLjava/util/concurrent/TimeUnit;)V
    .locals 1
    .param p1, "timeout"    # J
    .param p3, "units"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    .line 57
    return-void
.end method

.method public openCamera()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/amazon/mShop/search/viewit/CameraThread$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/CameraThread$1;-><init>(Lcom/amazon/mShop/search/viewit/CameraThread;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 79
    return-void
.end method

.method public releaseAwait(JLjava/util/concurrent/TimeUnit;)V
    .locals 1
    .param p1, "timeout"    # J
    .param p3, "units"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    .line 61
    return-void
.end method

.method public releaseCamera()V
    .locals 2

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/amazon/mShop/search/viewit/CameraThread$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/CameraThread$2;-><init>(Lcom/amazon/mShop/search/viewit/CameraThread;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z

    .line 101
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 41
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 42
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mHandler:Landroid/os/Handler;

    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mThreadInitLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 44
    invoke-static {}, Landroid/os/Looper;->loop()V

    .line 45
    return-void
.end method

.method public shutdownCameraThread()V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 105
    return-void
.end method

.method public start()V
    .locals 3

    .prologue
    .line 31
    invoke-super {p0}, Ljava/lang/Thread;->start()V

    .line 33
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraThread;->mThreadInitLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 37
    return-void

    .line 34
    :catch_0
    move-exception v0

    .line 35
    .local v0, "e":Ljava/lang/InterruptedException;
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Could not start camera thread"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
