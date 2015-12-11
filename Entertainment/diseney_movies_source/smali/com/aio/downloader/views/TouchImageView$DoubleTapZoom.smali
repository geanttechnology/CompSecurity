.class Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;
.super Ljava/lang/Object;
.source "TouchImageView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DoubleTapZoom"
.end annotation


# static fields
.field private static final ZOOM_TIME:F = 500.0f


# instance fields
.field private bitmapX:F

.field private bitmapY:F

.field private endTouch:Landroid/graphics/PointF;

.field private interpolator:Landroid/view/animation/AccelerateDecelerateInterpolator;

.field private startTime:J

.field private startTouch:Landroid/graphics/PointF;

.field private startZoom:F

.field private stretchImageToSuper:Z

.field private targetZoom:F

.field final synthetic this$0:Lcom/aio/downloader/views/TouchImageView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/TouchImageView;FFFZ)V
    .locals 4
    .param p2, "targetZoom"    # F
    .param p3, "focusX"    # F
    .param p4, "focusY"    # F
    .param p5, "stretchImageToSuper"    # Z

    .prologue
    .line 971
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 967
    new-instance v1, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    iput-object v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->interpolator:Landroid/view/animation/AccelerateDecelerateInterpolator;

    .line 972
    sget-object v1, Lcom/aio/downloader/views/TouchImageView$State;->ANIMATE_ZOOM:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {p1, v1}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    .line 973
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTime:J

    .line 974
    # getter for: Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$5(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v1

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startZoom:F

    .line 975
    iput p2, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->targetZoom:F

    .line 976
    iput-boolean p5, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->stretchImageToSuper:Z

    .line 977
    const/4 v1, 0x0

    # invokes: Lcom/aio/downloader/views/TouchImageView;->transformCoordTouchToBitmap(FFZ)Landroid/graphics/PointF;
    invoke-static {p1, p3, p4, v1}, Lcom/aio/downloader/views/TouchImageView;->access$21(Lcom/aio/downloader/views/TouchImageView;FFZ)Landroid/graphics/PointF;

    move-result-object v0

    .line 978
    .local v0, "bitmapPoint":Landroid/graphics/PointF;
    iget v1, v0, Landroid/graphics/PointF;->x:F

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapX:F

    .line 979
    iget v1, v0, Landroid/graphics/PointF;->y:F

    iput v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapY:F

    .line 984
    iget v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapX:F

    iget v2, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapY:F

    # invokes: Lcom/aio/downloader/views/TouchImageView;->transformCoordBitmapToTouch(FF)Landroid/graphics/PointF;
    invoke-static {p1, v1, v2}, Lcom/aio/downloader/views/TouchImageView;->access$22(Lcom/aio/downloader/views/TouchImageView;FF)Landroid/graphics/PointF;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTouch:Landroid/graphics/PointF;

    .line 985
    new-instance v1, Landroid/graphics/PointF;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewWidth:I
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$11(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewHeight:I
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$14(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    invoke-direct {v1, v2, v3}, Landroid/graphics/PointF;-><init>(FF)V

    iput-object v1, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->endTouch:Landroid/graphics/PointF;

    .line 986
    return-void
.end method

.method private calculateDeltaScale(F)D
    .locals 5
    .param p1, "t"    # F

    .prologue
    .line 1050
    iget v2, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startZoom:F

    iget v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->targetZoom:F

    iget v4, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startZoom:F

    sub-float/2addr v3, v4

    mul-float/2addr v3, p1

    add-float/2addr v2, v3

    float-to-double v0, v2

    .line 1051
    .local v0, "zoom":D
    iget-object v2, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->normalizedScale:F
    invoke-static {v2}, Lcom/aio/downloader/views/TouchImageView;->access$5(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v2

    float-to-double v2, v2

    div-double v2, v0, v2

    return-wide v2
.end method

.method private interpolate()F
    .locals 5

    .prologue
    .line 1037
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 1038
    .local v0, "currTime":J
    iget-wide v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTime:J

    sub-long v3, v0, v3

    long-to-float v3, v3

    const/high16 v4, 0x43fa0000    # 500.0f

    div-float v2, v3, v4

    .line 1039
    .local v2, "elapsed":F
    const/high16 v3, 0x3f800000    # 1.0f

    invoke-static {v3, v2}, Ljava/lang/Math;->min(FF)F

    move-result v2

    .line 1040
    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->interpolator:Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-virtual {v3, v2}, Landroid/view/animation/AccelerateDecelerateInterpolator;->getInterpolation(F)F

    move-result v3

    return v3
.end method

.method private translateImageToCenterTouchPosition(F)V
    .locals 6
    .param p1, "t"    # F

    .prologue
    .line 1026
    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTouch:Landroid/graphics/PointF;

    iget v3, v3, Landroid/graphics/PointF;->x:F

    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->endTouch:Landroid/graphics/PointF;

    iget v4, v4, Landroid/graphics/PointF;->x:F

    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTouch:Landroid/graphics/PointF;

    iget v5, v5, Landroid/graphics/PointF;->x:F

    sub-float/2addr v4, v5

    mul-float/2addr v4, p1

    add-float v1, v3, v4

    .line 1027
    .local v1, "targetX":F
    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTouch:Landroid/graphics/PointF;

    iget v3, v3, Landroid/graphics/PointF;->y:F

    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->endTouch:Landroid/graphics/PointF;

    iget v4, v4, Landroid/graphics/PointF;->y:F

    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->startTouch:Landroid/graphics/PointF;

    iget v5, v5, Landroid/graphics/PointF;->y:F

    sub-float/2addr v4, v5

    mul-float/2addr v4, p1

    add-float v2, v3, v4

    .line 1028
    .local v2, "targetY":F
    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget v4, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapX:F

    iget v5, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapY:F

    # invokes: Lcom/aio/downloader/views/TouchImageView;->transformCoordBitmapToTouch(FF)Landroid/graphics/PointF;
    invoke-static {v3, v4, v5}, Lcom/aio/downloader/views/TouchImageView;->access$22(Lcom/aio/downloader/views/TouchImageView;FF)Landroid/graphics/PointF;

    move-result-object v0

    .line 1029
    .local v0, "curr":Landroid/graphics/PointF;
    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {v3}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v3

    iget v4, v0, Landroid/graphics/PointF;->x:F

    sub-float v4, v1, v4

    iget v5, v0, Landroid/graphics/PointF;->y:F

    sub-float v5, v2, v5

    invoke-virtual {v3, v4, v5}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 1030
    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 990
    invoke-direct {p0}, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->interpolate()F

    move-result v6

    .line 991
    .local v6, "t":F
    invoke-direct {p0, v6}, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->calculateDeltaScale(F)D

    move-result-wide v1

    .line 992
    .local v1, "deltaScale":D
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapX:F

    iget v4, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->bitmapY:F

    iget-boolean v5, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->stretchImageToSuper:Z

    # invokes: Lcom/aio/downloader/views/TouchImageView;->scaleImage(DFFZ)V
    invoke-static/range {v0 .. v5}, Lcom/aio/downloader/views/TouchImageView;->access$20(Lcom/aio/downloader/views/TouchImageView;DFFZ)V

    .line 993
    invoke-direct {p0, v6}, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->translateImageToCenterTouchPosition(F)V

    .line 994
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->fixScaleTrans()V
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$23(Lcom/aio/downloader/views/TouchImageView;)V

    .line 995
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v3, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {v3}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/aio/downloader/views/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 1001
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1002
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v0}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;->onMove()V

    .line 1005
    :cond_0
    const/high16 v0, 0x3f800000    # 1.0f

    cmpg-float v0, v6, v0

    if-gez v0, :cond_1

    .line 1009
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->compatPostOnAnimation(Ljava/lang/Runnable;)V
    invoke-static {v0, p0}, Lcom/aio/downloader/views/TouchImageView;->access$3(Lcom/aio/downloader/views/TouchImageView;Ljava/lang/Runnable;)V

    .line 1017
    :goto_0
    return-void

    .line 1015
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$DoubleTapZoom;->this$0:Lcom/aio/downloader/views/TouchImageView;

    sget-object v3, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {v0, v3}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    goto :goto_0
.end method
