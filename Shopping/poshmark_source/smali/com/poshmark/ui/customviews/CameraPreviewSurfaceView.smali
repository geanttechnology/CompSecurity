.class public Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;
.super Landroid/view/SurfaceView;
.source "CameraPreviewSurfaceView.java"


# instance fields
.field height:I

.field width:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 13
    invoke-direct {p0, p1, p2}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 14
    return-void
.end method


# virtual methods
.method public getSurfaceViewHeight()I
    .locals 1

    .prologue
    .line 28
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->height:I

    return v0
.end method

.method public getSurfaceViewWidth()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->width:I

    return v0
.end method

.method public setScaledDimensions(II)V
    .locals 1
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 17
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, p1, p2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 18
    .local v0, "params":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 19
    iput p1, p0, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->width:I

    .line 20
    iput p2, p0, Lcom/poshmark/ui/customviews/CameraPreviewSurfaceView;->height:I

    .line 21
    return-void
.end method
