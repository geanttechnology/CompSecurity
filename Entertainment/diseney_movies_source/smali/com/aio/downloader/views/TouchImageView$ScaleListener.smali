.class Lcom/aio/downloader/views/TouchImageView$ScaleListener;
.super Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;
.source "TouchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ScaleListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/TouchImageView;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/TouchImageView;)V
    .locals 0

    .prologue
    .line 886
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-direct {p0}, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$ScaleListener;)V
    .locals 0

    .prologue
    .line 886
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/TouchImageView$ScaleListener;-><init>(Lcom/aio/downloader/views/TouchImageView;)V

    return-void
.end method


# virtual methods
.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 6
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    const/4 v5, 0x1

    .line 895
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v1

    float-to-double v1, v1

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v4

    # invokes: Lcom/aio/downloader/views/TouchImageView;->scaleImage(DFFZ)V
    invoke-static/range {v0 .. v5}, Lcom/aio/downloader/views/TouchImageView;->access$20(Lcom/aio/downloader/views/TouchImageView;DFFZ)V

    .line 900
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 901
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;->onMove()V

    .line 903
    :cond_0
    return v5
.end method

.method public onScaleBegin(Landroid/view/ScaleGestureDetector;)Z
    .locals 2
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 889
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    sget-object v1, Lcom/aio/downloader/views/TouchImageView$State;->ZOOM:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {v0, v1}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    .line 890
    const/4 v0, 0x1

    return v0
.end method

.method public onScaleEnd(Landroid/view/ScaleGestureDetector;)V
    .locals 7
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 908
    invoke-super {p0, p1}, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;->onScaleEnd(Landroid/view/ScaleGestureDetector;)V

    .line 909
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    sget-object v3, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {v1, v3}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    .line 910
    const/4 v6, 0x0

    .line 911
    .local v6, "animateToZoomBoundary":Z
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$5(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v2

    .line 912
    .local v2, "targetZoom":F
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$5(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v1

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->maxScale:F
    invoke-static {v3}, Lcom/aio/downloader/views/TouchImageView;->access$7(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v3

    cmpl-float v1, v1, v3

    if-lez v1, :cond_2

    .line 913
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->maxScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$7(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v2

    .line 914
    const/4 v6, 0x1

    .line 921
    :cond_0
    :goto_0
    if-eqz v6, :cond_1

    .line 922
    new-instance v0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;

    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewWidth:I
    invoke-static {v3}, Lcom/aio/downloader/views/TouchImageView;->access$11(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewHeight:I
    invoke-static {v4}, Lcom/aio/downloader/views/TouchImageView;->access$14(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;-><init>(Lcom/aio/downloader/views/TouchImageView;FFFZ)V

    .line 923
    .local v0, "doubleTap":Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->compatPostOnAnimation(Ljava/lang/Runnable;)V
    invoke-static {v1, v0}, Lcom/aio/downloader/views/TouchImageView;->access$3(Lcom/aio/downloader/views/TouchImageView;Ljava/lang/Runnable;)V

    .line 925
    .end local v0    # "doubleTap":Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;
    :cond_1
    return-void

    .line 916
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$5(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v1

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->minScale:F
    invoke-static {v3}, Lcom/aio/downloader/views/TouchImageView;->access$6(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v3

    cmpg-float v1, v1, v3

    if-gez v1, :cond_0

    .line 917
    iget-object v1, p0, Lcom/aio/downloader/views/TouchImageView$ScaleListener;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->minScale:F
    invoke-static {v1}, Lcom/aio/downloader/views/TouchImageView;->access$6(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v2

    .line 918
    const/4 v6, 0x1

    goto :goto_0
.end method
