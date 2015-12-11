.class Lcom/amazon/mShop/details/ProductImagesView$2;
.super Ljava/lang/Object;
.source "ProductImagesView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/ProductImagesView;->addThumbnail(Landroid/graphics/drawable/Drawable;I)V
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
    .line 294
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 297
    invoke-virtual {p1}, Landroid/view/View;->isSelected()Z

    move-result v2

    if-nez v2, :cond_2

    .line 298
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-nez v2, :cond_0

    .line 299
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 303
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mPinchImage:Lcom/amazon/mShop/details/GalleryPinchImageView;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/GalleryPinchImageView;

    move-result-object v2

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setVisibility(I)V

    .line 304
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 306
    const/4 v1, 0x0

    .line 307
    .local v1, "position":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1300(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 308
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mThumbnails:Landroid/view/ViewGroup;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$1300(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    if-ne v2, p1, :cond_3

    .line 309
    move v1, v0

    .line 315
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    sget-object v3, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->CLICK:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    invoke-virtual {v2, p1, v3}, Lcom/amazon/mShop/details/ProductImagesView;->setSelectedState(Landroid/view/View;Lcom/amazon/mShop/details/ProductImagesView$MoveAction;)V

    .line 316
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$2;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v2}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v1, v3}, Landroid/widget/Gallery;->setSelection(IZ)V

    .line 318
    .end local v0    # "i":I
    .end local v1    # "position":I
    :cond_2
    return-void

    .line 307
    .restart local v0    # "i":I
    .restart local v1    # "position":I
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
