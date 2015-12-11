.class Lcom/amazon/mShop/details/ProductImagesView$GestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "ProductImagesView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/ProductImagesView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GestureListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/ProductImagesView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;)V
    .locals 0

    .prologue
    .line 568
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/details/ProductImagesView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;
    .param p2, "x1"    # Lcom/amazon/mShop/details/ProductImagesView$1;

    .prologue
    .line 568
    invoke-direct {p0, p1}, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;-><init>(Lcom/amazon/mShop/details/ProductImagesView;)V

    return-void
.end method


# virtual methods
.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 572
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Gallery;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 573
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setBackendResource()V

    .line 574
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 575
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setVisibility(I)V

    .line 580
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/details/GalleryPinchImageView;->getScale()F

    move-result v2

    const/high16 v3, 0x40800000    # 4.0f

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/details/GalleryPinchImageView;->onDoubleTapPost(FF)F

    move-result v1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/mShop/details/GalleryPinchImageView;->zoomTo(FFF)V

    .line 583
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/details/CustomizedGallery;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/CustomizedGallery;->logImageZoomedRefMarker()V

    .line 585
    const/4 v0, 0x1

    return v0
.end method
