.class Lcom/poshmark/ui/customviews/GestureView$1;
.super Ljava/lang/Object;
.source "GestureView.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/GestureView;->setupBitmap(Landroid/graphics/Rect;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/GestureView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/GestureView;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/poshmark/ui/customviews/GestureView$1;->this$0:Lcom/poshmark/ui/customviews/GestureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;
    .param p2, "i"    # I
    .param p3, "i1"    # I
    .param p4, "i2"    # I

    .prologue
    .line 124
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 4
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView$1;->this$0:Lcom/poshmark/ui/customviews/GestureView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/GestureView;->updateImage()V

    .line 118
    iget-object v0, p0, Lcom/poshmark/ui/customviews/GestureView$1;->this$0:Lcom/poshmark/ui/customviews/GestureView;

    new-instance v1, Lcom/poshmark/utils/PMGestureDetector;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/GestureView$1;->this$0:Lcom/poshmark/ui/customviews/GestureView;

    iget-object v3, p0, Lcom/poshmark/ui/customviews/GestureView$1;->this$0:Lcom/poshmark/ui/customviews/GestureView;

    invoke-direct {v1, v2, v3}, Lcom/poshmark/utils/PMGestureDetector;-><init>(Landroid/view/View;Lcom/poshmark/utils/PMGestureDetectorListener;)V

    iput-object v1, v0, Lcom/poshmark/ui/customviews/GestureView;->gestureDetector:Lcom/poshmark/utils/PMGestureDetector;

    .line 119
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 129
    return-void
.end method
