.class Lcom/poshmark/ui/fragments/CropImageFragment$1;
.super Ljava/lang/Object;
.source "CropImageFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CropImageFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CropImageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CropImageFragment;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CropImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 64
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CropImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    iget-boolean v2, v2, Lcom/poshmark/ui/fragments/CropImageFragment;->isNextClicked:Z

    if-nez v2, :cond_0

    .line 65
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CropImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/poshmark/ui/fragments/CropImageFragment;->isNextClicked:Z

    .line 66
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CropImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    # getter for: Lcom/poshmark/ui/fragments/CropImageFragment;->cropImageSurfaceView:Lcom/poshmark/ui/customviews/CropImageSurfaceView;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/CropImageFragment;->access$100(Lcom/poshmark/ui/fragments/CropImageFragment;)Lcom/poshmark/ui/customviews/CropImageSurfaceView;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/CropImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    # getter for: Lcom/poshmark/ui/fragments/CropImageFragment;->viewportOverlay:Lcom/poshmark/ui/customviews/CameraViewportRectView;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/CropImageFragment;->access$000(Lcom/poshmark/ui/fragments/CropImageFragment;)Lcom/poshmark/ui/customviews/CameraViewportRectView;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->getBitmap(Landroid/graphics/Rect;)Landroid/net/Uri;

    move-result-object v0

    .line 67
    .local v0, "croppedImageFile":Landroid/net/Uri;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 68
    .local v1, "i":Landroid/content/Intent;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 69
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CropImageFragment$1;->this$0:Lcom/poshmark/ui/fragments/CropImageFragment;

    const/4 v3, -0x1

    invoke-virtual {v2, v3, v1}, Lcom/poshmark/ui/fragments/CropImageFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 71
    .end local v0    # "croppedImageFile":Landroid/net/Uri;
    .end local v1    # "i":Landroid/content/Intent;
    :cond_0
    return-void
.end method
