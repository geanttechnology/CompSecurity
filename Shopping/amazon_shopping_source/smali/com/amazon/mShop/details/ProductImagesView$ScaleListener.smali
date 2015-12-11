.class Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;
.super Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;
.source "ProductImagesView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/ProductImagesView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ScaleListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/ProductImagesView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;)V
    .locals 0

    .prologue
    .line 589
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {p0}, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/details/ProductImagesView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/details/ProductImagesView;
    .param p2, "x1"    # Lcom/amazon/mShop/details/ProductImagesView$1;

    .prologue
    .line 589
    invoke-direct {p0, p1}, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;-><init>(Lcom/amazon/mShop/details/ProductImagesView;)V

    return-void
.end method


# virtual methods
.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 3
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    const/4 v1, 0x0

    .line 593
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Gallery;->getVisibility()I

    move-result v2

    if-nez v2, :cond_1

    .line 594
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v0

    .line 595
    .local v0, "scaleFactor":F
    const/high16 v2, 0x3f800000    # 1.0f

    cmpg-float v2, v0, v2

    if-gtz v2, :cond_0

    .line 607
    .end local v0    # "scaleFactor":F
    :goto_0
    return v1

    .line 597
    .restart local v0    # "scaleFactor":F
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setBackendResource()V

    .line 598
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setVisibility(I)V

    .line 599
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v1

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 605
    .end local v0    # "scaleFactor":F
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/details/GalleryPinchImageView;->updateScale(Landroid/view/ScaleGestureDetector;)V

    .line 607
    const/4 v1, 0x1

    goto :goto_0
.end method
