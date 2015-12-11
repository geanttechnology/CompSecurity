.class public Lcom/amazon/mShop/imageview/PinchImageView;
.super Lcom/amazon/mShop/imageview/BasePinchImageView;
.source "PinchImageView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/imageview/PinchImageView$ScaleListener;,
        Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;
    }
.end annotation


# instance fields
.field private mGestureDetector:Landroid/view/GestureDetector;

.field private mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/imageview/BasePinchImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/imageview/PinchImageView;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/imageview/PinchImageView;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    return-object v0
.end method


# virtual methods
.method protected init()V
    .locals 3

    .prologue
    .line 25
    invoke-super {p0}, Lcom/amazon/mShop/imageview/BasePinchImageView;->init()V

    .line 31
    sget-object v0, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    .line 32
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/PinchImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/imageview/PinchImageView$ScaleListener;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/imageview/PinchImageView$ScaleListener;-><init>(Lcom/amazon/mShop/imageview/PinchImageView;)V

    invoke-static {v0, v1}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector;->newInstance(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    .line 37
    :goto_0
    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/PinchImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;-><init>(Lcom/amazon/mShop/imageview/PinchImageView;)V

    invoke-direct {v0, v1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mGestureDetector:Landroid/view/GestureDetector;

    .line 38
    return-void

    .line 34
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/PinchImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector;->newInstance(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    goto :goto_0
.end method

.method public onDoubleTapPost(FF)F
    .locals 2
    .param p1, "scale"    # F
    .param p2, "maxZoom"    # F

    .prologue
    const/high16 v1, 0x40000000    # 2.0f

    .line 67
    div-float v0, p2, v1

    cmpg-float v0, p1, v0

    if-gez v0, :cond_0

    .line 68
    div-float v0, p2, v1

    iput v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mCurrentScaleFactor:F

    .line 74
    :goto_0
    iget v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mCurrentScaleFactor:F

    return v0

    .line 69
    :cond_0
    div-float v0, p2, v1

    cmpl-float v0, p1, v0

    if-ltz v0, :cond_1

    cmpg-float v0, p1, p2

    if-gez v0, :cond_1

    .line 70
    iput p2, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mCurrentScaleFactor:F

    goto :goto_0

    .line 72
    :cond_1
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mCurrentScaleFactor:F

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/PinchImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$bool;->config_isSupportPinchZoom:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    invoke-interface {v0, p1}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    invoke-interface {v0}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;->isInProgress()Z

    move-result v0

    if-nez v0, :cond_0

    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mGestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 55
    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 53
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mGestureDetector:Landroid/view/GestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_0
.end method

.method public updateScale(Landroid/view/ScaleGestureDetector;)V
    .locals 3
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 121
    iget v1, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mCurrentScaleFactor:F

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v2

    mul-float v0, v1, v2

    .line 122
    .local v0, "targetScale":F
    const/high16 v1, 0x40800000    # 4.0f

    invoke-static {v1, v0}, Ljava/lang/Math;->min(FF)F

    move-result v0

    .line 123
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v1

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/amazon/mShop/imageview/PinchImageView;->zoomTo(FFF)V

    .line 124
    iput v0, p0, Lcom/amazon/mShop/imageview/PinchImageView;->mCurrentScaleFactor:F

    .line 125
    invoke-virtual {p0}, Lcom/amazon/mShop/imageview/PinchImageView;->invalidate()V

    .line 126
    return-void
.end method
