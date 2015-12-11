.class Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;
.super Lcom/amazon/mShop/ObjectSubscriberAdapter;
.source "ProductImagesView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/ProductImagesView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ImageAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/details/ProductImagesView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p2, "c"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    .line 203
    invoke-direct {p0, p2}, Lcom/amazon/mShop/ObjectSubscriberAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 204
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->getCount()I

    move-result v0

    return v0
.end method

.method public getItem(I)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 213
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mGalleryDelayImages:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$200(Lcom/amazon/mShop/details/ProductImagesView;)Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->getImage(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 214
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 200
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->getItem(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 252
    instance-of v2, p2, Landroid/widget/ImageView;

    if-eqz v2, :cond_0

    move-object v0, p2

    .line 253
    check-cast v0, Landroid/widget/ImageView;

    .line 254
    .local v0, "img":Landroid/widget/ImageView;
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    move-object v1, v0

    .line 267
    .end local v0    # "img":Landroid/widget/ImageView;
    .local v1, "img":Landroid/widget/ImageView;
    :goto_0
    return-object v1

    .line 258
    .end local v1    # "img":Landroid/widget/ImageView;
    :cond_0
    new-instance v0, Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 259
    .restart local v0    # "img":Landroid/widget/ImageView;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setAdjustViewBounds(Z)V

    .line 260
    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setFocusable(Z)V

    .line 261
    new-instance v2, Landroid/widget/Gallery$LayoutParams;

    const/4 v3, -0x1

    const/4 v4, -0x2

    invoke-direct {v2, v3, v4}, Landroid/widget/Gallery$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 262
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 265
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->getItem(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    # invokes: Lcom/amazon/mShop/details/ProductImagesView;->setDrawableForImageView(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Z)V
    invoke-static {v2, v3, v0, v5}, Lcom/amazon/mShop/details/ProductImagesView;->access$1000(Lcom/amazon/mShop/details/ProductImagesView;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Z)V

    move-object v1, v0

    .line 267
    .end local v0    # "img":Landroid/widget/ImageView;
    .restart local v1    # "img":Landroid/widget/ImageView;
    goto :goto_0
.end method

.method public onImageReceived(Landroid/graphics/drawable/Drawable;I)V
    .locals 7
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "indexTag"    # I

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 218
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->notifyDataSetChanged()V

    .line 219
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # invokes: Lcom/amazon/mShop/details/ProductImagesView;->addThumbnail(Landroid/graphics/drawable/Drawable;I)V
    invoke-static {v0, p1, p2}, Lcom/amazon/mShop/details/ProductImagesView;->access$300(Lcom/amazon/mShop/details/ProductImagesView;Landroid/graphics/drawable/Drawable;I)V

    .line 221
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$400(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/GestureDetector;

    move-result-object v0

    if-nez v0, :cond_0

    .line 222
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    new-instance v1, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->getContext()Landroid/content/Context;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;

    iget-object v4, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {v3, v4, v5}, Lcom/amazon/mShop/details/ProductImagesView$GestureListener;-><init>(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/details/ProductImagesView$1;)V

    invoke-direct {v1, v2, v3}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    # setter for: Lcom/amazon/mShop/details/ProductImagesView;->mGestureDetector:Landroid/view/GestureDetector;
    invoke-static {v0, v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$402(Lcom/amazon/mShop/details/ProductImagesView;Landroid/view/GestureDetector;)Landroid/view/GestureDetector;

    .line 228
    sget-object v0, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/16 v1, 0x8

    if-lt v0, v1, :cond_2

    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;

    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {v2, v3, v5}, Lcom/amazon/mShop/details/ProductImagesView$ScaleListener;-><init>(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/details/ProductImagesView$1;)V

    invoke-static {v1, v2}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector;->newInstance(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/details/ProductImagesView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    invoke-static {v0, v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$602(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    .line 234
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->onTouchListener:Landroid/view/View$OnTouchListener;
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$800(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View$OnTouchListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Gallery;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 236
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$900(Lcom/amazon/mShop/details/ProductImagesView;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 238
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    sget-object v1, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->CLICK:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    invoke-virtual {v0, v6, v1}, Lcom/amazon/mShop/details/ProductImagesView;->setSelectedState(ILcom/amazon/mShop/details/ProductImagesView$MoveAction;)V

    .line 239
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/widget/Gallery;->setSelection(I)V

    .line 243
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$900(Lcom/amazon/mShop/details/ProductImagesView;)I

    move-result v0

    if-ne v0, p2, :cond_1

    .line 244
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$900(Lcom/amazon/mShop/details/ProductImagesView;)I

    move-result v1

    sget-object v2, Lcom/amazon/mShop/details/ProductImagesView$MoveAction;->CLICK:Lcom/amazon/mShop/details/ProductImagesView$MoveAction;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/details/ProductImagesView;->setSelectedState(ILcom/amazon/mShop/details/ProductImagesView$MoveAction;)V

    .line 245
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v0}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$900(Lcom/amazon/mShop/details/ProductImagesView;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Gallery;->setSelection(I)V

    .line 247
    :cond_1
    return-void

    .line 231
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v5}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector;->newInstance(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/details/ProductImagesView;->mScaleDetector:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    invoke-static {v0, v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$602(Lcom/amazon/mShop/details/ProductImagesView;Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;

    goto :goto_0
.end method
