.class Lcom/amazon/mShop/search/viewit/CameraThread$2;
.super Ljava/lang/Object;
.source "CameraThread.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/CameraThread;->releaseCamera()V
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
    .line 85
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 89
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$000(Lcom/amazon/mShop/search/viewit/CameraThread;)Landroid/hardware/Camera;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->setPreviewCallback(Landroid/hardware/Camera$PreviewCallback;)V

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$000(Lcom/amazon/mShop/search/viewit/CameraThread;)Landroid/hardware/Camera;

    move-result-object v0

    invoke-virtual {v0}, Landroid/hardware/Camera;->stopPreview()V

    .line 91
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$000(Lcom/amazon/mShop/search/viewit/CameraThread;)Landroid/hardware/Camera;

    move-result-object v0

    invoke-virtual {v0}, Landroid/hardware/Camera;->release()V

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCamera:Landroid/hardware/Camera;
    invoke-static {v0, v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$002(Lcom/amazon/mShop/search/viewit/CameraThread;Landroid/hardware/Camera;)Landroid/hardware/Camera;

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraThread;->shutdownCameraThread()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$200(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 99
    :goto_0
    return-void

    .line 94
    :catch_0
    move-exception v0

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$200(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/CameraThread$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraThread;

    # getter for: Lcom/amazon/mShop/search/viewit/CameraThread;->mCameraReleaseLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/CameraThread;->access$200(Lcom/amazon/mShop/search/viewit/CameraThread;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0
.end method
