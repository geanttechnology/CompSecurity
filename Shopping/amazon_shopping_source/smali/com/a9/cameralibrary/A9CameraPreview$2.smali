.class Lcom/a9/cameralibrary/A9CameraPreview$2;
.super Ljava/lang/Object;
.source "A9CameraPreview.java"

# interfaces
.implements Landroid/hardware/Camera$AutoFocusCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/a9/cameralibrary/A9CameraPreview;->focus()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/a9/cameralibrary/A9CameraPreview;


# direct methods
.method constructor <init>(Lcom/a9/cameralibrary/A9CameraPreview;)V
    .locals 0

    .prologue
    .line 556
    iput-object p1, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAutoFocus(ZLandroid/hardware/Camera;)V
    .locals 5
    .param p1, "success"    # Z
    .param p2, "camera"    # Landroid/hardware/Camera;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "InlinedApi"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 561
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # getter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_isCameraReleased:Z
    invoke-static {v2}, Lcom/a9/cameralibrary/A9CameraPreview;->access$000(Lcom/a9/cameralibrary/A9CameraPreview;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 579
    :cond_0
    :goto_0
    return-void

    .line 565
    :cond_1
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # setter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z
    invoke-static {v2, v4}, Lcom/a9/cameralibrary/A9CameraPreview;->access$102(Lcom/a9/cameralibrary/A9CameraPreview;Z)Z

    .line 566
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    const/4 v3, 0x3

    # setter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_framesTilNextFocus:I
    invoke-static {v2, v3}, Lcom/a9/cameralibrary/A9CameraPreview;->access$202(Lcom/a9/cameralibrary/A9CameraPreview;I)I

    .line 567
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    # setter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_lastFocus:Ljava/util/Date;
    invoke-static {v2, v3}, Lcom/a9/cameralibrary/A9CameraPreview;->access$302(Lcom/a9/cameralibrary/A9CameraPreview;Ljava/util/Date;)Ljava/util/Date;

    .line 570
    :try_start_0
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # getter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_supportsContinuousFocus:Z
    invoke-static {v2}, Lcom/a9/cameralibrary/A9CameraPreview;->access$400(Lcom/a9/cameralibrary/A9CameraPreview;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 571
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # getter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;
    invoke-static {v2}, Lcom/a9/cameralibrary/A9CameraPreview;->access$500(Lcom/a9/cameralibrary/A9CameraPreview;)Landroid/hardware/Camera;

    move-result-object v2

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 572
    .local v1, "parameters":Landroid/hardware/Camera$Parameters;
    const-string/jumbo v2, "continuous-picture"

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 573
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # getter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_camera:Landroid/hardware/Camera;
    invoke-static {v2}, Lcom/a9/cameralibrary/A9CameraPreview;->access$500(Lcom/a9/cameralibrary/A9CameraPreview;)Landroid/hardware/Camera;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 574
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # invokes: Lcom/a9/cameralibrary/A9CameraPreview;->setFocusArea()V
    invoke-static {v2}, Lcom/a9/cameralibrary/A9CameraPreview;->access$600(Lcom/a9/cameralibrary/A9CameraPreview;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 576
    .end local v1    # "parameters":Landroid/hardware/Camera$Parameters;
    :catch_0
    move-exception v0

    .line 577
    .local v0, "e":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/a9/cameralibrary/A9CameraPreview$2;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    # setter for: Lcom/a9/cameralibrary/A9CameraPreview;->m_focusing:Z
    invoke-static {v2, v4}, Lcom/a9/cameralibrary/A9CameraPreview;->access$102(Lcom/a9/cameralibrary/A9CameraPreview;Z)Z

    goto :goto_0
.end method
