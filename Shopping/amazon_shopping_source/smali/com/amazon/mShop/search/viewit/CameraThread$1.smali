.class Lcom/amazon/mShop/search/viewit/CameraThread$1;
.super Ljava/lang/Object;
.source "CameraThread.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/CameraThread;->openCamera()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/CameraThread;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/CameraThread;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraThread$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 71
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraThread$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-static {}, Landroid/hardware/Camera;->open()Landroid/hardware/Camera;

    move-result-object v2

    # setter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;
    invoke-static {v1, v2}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$002(Lcom/amazon/mShop/search/viewit/CameraThread;Landroid/hardware/Camera;)Landroid/hardware/Camera;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 75
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraThread$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$100(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 77
    :goto_0
    return-void

    .line 72
    :catch_0
    move-exception v0

    .line 73
    .local v0, "t":Ljava/lang/Throwable;
    :try_start_1
    const-string/jumbo v1, "CameraThread"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Error camera open: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 75
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraThread$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$100(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .end local v0    # "t":Ljava/lang/Throwable;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/CameraThread$1;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraOpenLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$100(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v1
.end method
