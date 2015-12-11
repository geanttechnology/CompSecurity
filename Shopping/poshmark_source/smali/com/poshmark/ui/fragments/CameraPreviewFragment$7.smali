.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;
.super Ljava/lang/Object;
.source "CameraPreviewFragment.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CameraPreviewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V
    .locals 0

    .prologue
    .line 586
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 1
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 595
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 596
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraPreviewDisplay(Landroid/view/SurfaceHolder;)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$300(Lcom/poshmark/ui/fragments/CameraPreviewFragment;Landroid/view/SurfaceHolder;)V

    .line 597
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->startPreview()V

    .line 599
    :cond_0
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 589
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupButtonHandlers()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$500(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    .line 591
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 603
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$7;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->releaseCamera()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$000(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    return-void
.end method
