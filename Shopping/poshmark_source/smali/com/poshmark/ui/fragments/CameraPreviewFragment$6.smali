.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$6;
.super Ljava/lang/Object;
.source "CameraPreviewFragment.java"

# interfaces
.implements Landroid/hardware/Camera$AutoFocusCallback;


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
    .line 434
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$6;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAutoFocus(ZLandroid/hardware/Camera;)V
    .locals 3
    .param p1, "success"    # Z
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    const/4 v2, 0x0

    .line 437
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$6;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$6;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # getter for: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureCallback:Landroid/hardware/Camera$PictureCallback;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$400(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)Landroid/hardware/Camera$PictureCallback;

    move-result-object v1

    invoke-virtual {v0, v2, v2, v1}, Landroid/hardware/Camera;->takePicture(Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V

    .line 438
    return-void
.end method
