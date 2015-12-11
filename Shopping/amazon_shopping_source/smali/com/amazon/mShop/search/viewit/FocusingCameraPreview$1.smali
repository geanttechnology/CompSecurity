.class Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;
.super Ljava/lang/Object;
.source "FocusingCameraPreview.java"

# interfaces
.implements Landroid/hardware/Camera$AutoFocusCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->focus()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAutoFocus(ZLandroid/hardware/Camera;)V
    .locals 5
    .param p1, "success"    # Z
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 63
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    iget-object v2, v2, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    if-nez v2, :cond_1

    .line 83
    :cond_0
    :goto_0
    return-void

    .line 66
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->access$002(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;Z)Z

    .line 67
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    const/4 v3, 0x3

    # setter for: Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFramesTilNextFocus:I
    invoke-static {v2, v3}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->access$102(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;I)I

    .line 68
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    # setter for: Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mLastFocus:Ljava/util/Date;
    invoke-static {v2, v3}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->access$202(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;Ljava/util/Date;)Ljava/util/Date;

    .line 70
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    # getter for: Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->access$300(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 74
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    iget-object v2, v2, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->cancelAutoFocus()V

    .line 75
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    iget-object v2, v2, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 76
    .local v1, "parameters":Landroid/hardware/Camera$Parameters;
    const-string/jumbo v2, "continuous-picture"

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 77
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    iget-object v2, v2, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 78
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;->this$0:Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    # invokes: Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->setFocusArea()V
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->access$400(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 79
    .end local v1    # "parameters":Landroid/hardware/Camera$Parameters;
    :catch_0
    move-exception v0

    .line 80
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v2, "FocusingCameraPreview"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Error to set continuse-picture after autoFocus:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
