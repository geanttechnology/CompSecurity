.class Lcom/amazon/mShop/details/ProductImagesView$3;
.super Ljava/lang/Object;
.source "ProductImagesView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/ProductImagesView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/ProductImagesView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;)V
    .locals 0

    .prologue
    .line 543
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 549
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/ProductImagesView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$bool;->config_isSupportPinchZoom:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 550
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$600(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v0

    invoke-interface {v0, p2}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 551
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$600(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;->isInProgress()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$400(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 557
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->getVisibility()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    .line 558
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    if-le v0, v2, :cond_3

    .line 564
    :cond_1
    :goto_1
    return v2

    .line 555
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$3;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$400(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_0

    .line 561
    :cond_3
    invoke-virtual {p1, p2}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    goto :goto_1
.end method
