.class public Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;
.super Ljava/lang/Object;
.source "ProductImagesView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/ProductImagesView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "GalleryDelayImages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mFirstImageReceived:Z

.field private mImageTotalCount:I

.field private mImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field private final mListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;",
            ">;"
        }
    .end annotation
.end field

.field private final mMaxImageDimension:I

.field final synthetic this$0:Lcom/amazon/mShop/details/ProductImagesView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/details/ProductImagesView;)V
    .locals 3

    .prologue
    .line 419
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 416
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mFirstImageReceived:Z

    .line 423
    invoke-virtual {p1}, Lcom/amazon/mShop/details/ProductImagesView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->getPortraitWidth(Landroid/content/Context;)I

    move-result v0

    invoke-virtual {p1}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->product_images_spacing:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mMaxImageDimension:I

    .line 424
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    .line 425
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mListeners:Ljava/util/List;

    .line 426
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    .prologue
    .line 412
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    .prologue
    .line 412
    iget-boolean v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mFirstImageReceived:Z

    return v0
.end method

.method private initWithPreviewMainImage(Ljava/lang/String;I)V
    .locals 4
    .param p1, "previewImageUrl"    # Ljava/lang/String;
    .param p2, "previewImageDimension"    # I

    .prologue
    .line 429
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 430
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;-><init>(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)V

    invoke-direct {v0, p1, v1, v2, v3}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    .line 446
    :cond_0
    return-void
.end method


# virtual methods
.method public addGalleryImageItemsListener(Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

    .prologue
    .line 476
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 477
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 485
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getImage(I)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 489
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    .line 490
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    return-object v0
.end method

.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 538
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/details/ProductImagesView;->access$1600()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "fetching image failed."

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 539
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 5
    .param p1, "response"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 502
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-boolean v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mFirstImageReceived:Z

    if-nez v3, :cond_0

    .line 504
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mFirstImageReceived:Z

    .line 506
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mKeepImageOrder:Z
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$1500(Lcom/amazon/mShop/details/ProductImagesView;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 508
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {v4}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->getDefaultDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 512
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    .local v1, "i":I
    :goto_0
    iget v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImageTotalCount:I

    if-ge v1, v3, :cond_0

    .line 513
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 514
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # invokes: Lcom/amazon/mShop/details/ProductImagesView;->addThumbnail(Landroid/graphics/drawable/Drawable;I)V
    invoke-static {v3, v0, v1}, Lcom/amazon/mShop/details/ProductImagesView;->access$300(Lcom/amazon/mShop/details/ProductImagesView;Landroid/graphics/drawable/Drawable;I)V

    .line 512
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 519
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {p2}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 520
    .local v2, "indexTag":I
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {v4}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-interface {v3, v4, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 521
    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mKeepImageOrder:Z
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$1500(Lcom/amazon/mShop/details/ProductImagesView;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 522
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    invoke-interface {v3, v2, v0}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 526
    :goto_1
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$900(Lcom/amazon/mShop/details/ProductImagesView;)I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_1

    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mStartIndex:I
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$900(Lcom/amazon/mShop/details/ProductImagesView;)I

    move-result v3

    if-ne v3, v2, :cond_2

    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$1100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v3

    if-nez v3, :cond_2

    .line 529
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mProgressBar:Landroid/view/View;
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$1100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/view/View;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 530
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView;->mMainGallery:Landroid/widget/Gallery;
    invoke-static {v3}, Lcom/amazon/mShop/details/ProductImagesView;->access$100(Lcom/amazon/mShop/details/ProductImagesView;)Landroid/widget/Gallery;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 533
    :cond_2
    invoke-virtual {p0, v0, v2}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->onImageReceived(Landroid/graphics/drawable/Drawable;I)V

    .line 534
    return-void

    .line 524
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 412
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method

.method public onImageReceived(Landroid/graphics/drawable/Drawable;I)V
    .locals 3
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "indexTag"    # I

    .prologue
    .line 469
    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mListeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;

    .line 470
    .local v1, "listener":Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;
    invoke-virtual {v1, p1, p2}, Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;->onImageReceived(Landroid/graphics/drawable/Drawable;I)V

    goto :goto_0

    .line 472
    .end local v1    # "listener":Lcom/amazon/mShop/details/ProductImagesView$ImageAdapter;
    :cond_0
    return-void
.end method

.method public requestImage(Ljava/lang/String;I)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "position"    # I

    .prologue
    .line 494
    if-eqz p1, :cond_0

    .line 495
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher;

    iget v1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mMaxImageDimension:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, p1, v1, v2, p0}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    .line 497
    :cond_0
    return-void
.end method

.method public setMultiImages(Ljava/util/List;Ljava/lang/String;I)V
    .locals 6
    .param p2, "previewImageUrl"    # Ljava/lang/String;
    .param p3, "previewImageDimension"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;",
            ">;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 450
    .local p1, "multiImages":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;>;"
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->initWithPreviewMainImage(Ljava/lang/String;I)V

    .line 452
    const/4 v0, 0x0

    .line 453
    .local v0, "i":I
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;

    .line 455
    .local v3, "multiImage":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->getHiresUrl()Ljava/lang/String;

    move-result-object v4

    .line 456
    .local v4, "url":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 458
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;->getStandardUrl()Ljava/lang/String;

    move-result-object v4

    .line 460
    :cond_0
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .local v1, "i":I
    invoke-virtual {p0, v4, v0}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->requestImage(Ljava/lang/String;I)V

    .line 461
    const/4 v5, 0x7

    if-ne v1, v5, :cond_2

    move v0, v1

    .line 465
    .end local v1    # "i":I
    .end local v3    # "multiImage":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    .end local v4    # "url":Ljava/lang/String;
    .restart local v0    # "i":I
    :cond_1
    iput v0, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImageTotalCount:I

    .line 466
    return-void

    .end local v0    # "i":I
    .restart local v1    # "i":I
    .restart local v3    # "multiImage":Lcom/amazon/rio/j2me/client/services/mShop/MultiImage;
    .restart local v4    # "url":Ljava/lang/String;
    :cond_2
    move v0, v1

    .line 464
    .end local v1    # "i":I
    .restart local v0    # "i":I
    goto :goto_0
.end method
