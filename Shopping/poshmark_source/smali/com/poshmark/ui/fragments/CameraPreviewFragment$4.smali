.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;
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
    .line 292
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 295
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->releaseCamera()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$000(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    .line 296
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->switchCamera()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$100(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    .line 297
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraPreviewAttributes()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$200(Lcom/poshmark/ui/fragments/CameraPreviewFragment;)V

    .line 298
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->surfaceHolder:Landroid/view/SurfaceHolder;

    # invokes: Lcom/poshmark/ui/fragments/CameraPreviewFragment;->setupCameraPreviewDisplay(Landroid/view/SurfaceHolder;)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->access$300(Lcom/poshmark/ui/fragments/CameraPreviewFragment;Landroid/view/SurfaceHolder;)V

    .line 299
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$4;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->startPreview()V

    .line 300
    return-void
.end method
