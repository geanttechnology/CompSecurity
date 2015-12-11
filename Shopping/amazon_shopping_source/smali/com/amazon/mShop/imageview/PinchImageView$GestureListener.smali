.class Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "PinchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/imageview/PinchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "GestureListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/imageview/PinchImageView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/imageview/PinchImageView;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 81
    iget-object v2, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-virtual {v2}, Lcom/amazon/mShop/imageview/PinchImageView;->getScale()F

    move-result v0

    .line 82
    .local v0, "scale":F
    iget-object v2, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {v2, v0, v3}, Lcom/amazon/mShop/imageview/PinchImageView;->onDoubleTapPost(FF)F

    move-result v1

    .line 84
    .local v1, "targetScale":F
    iget-object v2, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {v2, v1, v3, v4}, Lcom/amazon/mShop/imageview/PinchImageView;->zoomTo(FFF)V

    .line 85
    iget-object v2, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-virtual {v2}, Lcom/amazon/mShop/imageview/PinchImageView;->invalidate()V

    .line 86
    invoke-super {p0, p1}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onDoubleTap(Landroid/view/MotionEvent;)Z

    move-result v2

    return v2
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 3
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "distanceX"    # F
    .param p4, "distanceY"    # F

    .prologue
    const/4 v2, 0x1

    const/4 v0, 0x0

    .line 91
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 102
    :cond_0
    :goto_0
    return v0

    .line 93
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    if-gt v1, v2, :cond_0

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    if-gt v1, v2, :cond_0

    .line 95
    iget-object v1, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    # getter for: Lcom/amazon/mShop/imageview/PinchImageView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    invoke-static {v1}, Lcom/amazon/mShop/imageview/PinchImageView;->access$000(Lcom/amazon/mShop/imageview/PinchImageView;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;->isInProgress()Z

    move-result v1

    if-nez v1, :cond_0

    .line 97
    iget-object v1, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-virtual {v1}, Lcom/amazon/mShop/imageview/PinchImageView;->getScale()F

    move-result v1

    const/high16 v2, 0x3f800000    # 1.0f

    cmpg-float v1, v1, v2

    if-lez v1, :cond_0

    .line 100
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    neg-float v1, p3

    neg-float v2, p4

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/imageview/PinchImageView;->scrollBy(FF)V

    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView$GestureListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-virtual {v0}, Lcom/amazon/mShop/imageview/PinchImageView;->invalidate()V

    .line 102
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/GestureDetector$SimpleOnGestureListener;->onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z

    move-result v0

    goto :goto_0
.end method
