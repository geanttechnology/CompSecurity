.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;
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
    .line 304
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 307
    move-object v0, p1

    check-cast v0, Landroid/widget/Button;

    .line 308
    .local v0, "flashButton":Landroid/widget/Button;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 309
    .local v1, "p":Landroid/hardware/Camera$Parameters;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    const-string v3, "auto"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 310
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const-string v3, "off"

    iput-object v3, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    .line 311
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 312
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const v3, 0x7f0601db

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 324
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 325
    return-void

    .line 314
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    const-string v3, "off"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 315
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const-string v3, "on"

    iput-object v3, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    .line 316
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 317
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const v3, 0x7f0601e2

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 319
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    const-string v3, "on"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 320
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const-string v3, "auto"

    iput-object v3, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    .line 321
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->currentFlashMode:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFlashMode(Ljava/lang/String;)V

    .line 322
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$5;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    const v3, 0x7f06004d

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
