.class Lcom/poshmark/ui/fragments/GestureTester$1;
.super Ljava/lang/Object;
.source "GestureTester.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/CameraViewportRectView$CustomListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/GestureTester;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/GestureTester;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/GestureTester;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterDraw()V
    .locals 3

    .prologue
    .line 57
    const-string v0, "GestureTester"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Rect;->left:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Rect;->top:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/GestureView;->setVisibility(I)V

    .line 59
    iget-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/GestureTester;->croppable_view:Lcom/poshmark/ui/customviews/GestureView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/GestureTester$1;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/GestureTester;->croppable_space:Lcom/poshmark/ui/customviews/CameraViewportRectView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/CameraViewportRectView;->getViewportRect()Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/GestureView;->setupBitmap(Landroid/graphics/Rect;)V

    .line 60
    return-void
.end method
