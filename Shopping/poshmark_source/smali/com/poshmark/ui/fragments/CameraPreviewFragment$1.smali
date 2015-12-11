.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;
.super Ljava/lang/Object;
.source "CameraPreviewFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupButtonHandlers()V
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
    .line 261
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 264
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-boolean v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureTaken:Z

    if-nez v0, :cond_0

    .line 265
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->pictureTaken:Z

    .line 266
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 267
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mAutoFocusCallback:Landroid/hardware/Camera$AutoFocusCallback;

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)V

    .line 270
    :cond_0
    return-void
.end method
