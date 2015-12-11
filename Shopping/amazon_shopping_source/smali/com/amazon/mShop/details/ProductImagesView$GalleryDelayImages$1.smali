.class Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;
.super Ljava/lang/Object;
.source "ProductImagesView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->initWithPreviewMainImage(Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
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
.field final synthetic this$1:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)V
    .locals 0

    .prologue
    .line 430
    iput-object p1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;->this$1:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
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
    .line 443
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 3
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
    .line 433
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;->this$1:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mFirstImageReceived:Z
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->access$1400(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 434
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;->this$1:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    iget-object v2, v2, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->this$0:Lcom/amazon/mShop/details/ProductImagesView;

    invoke-virtual {v2}, Lcom/amazon/mShop/details/ProductImagesView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-interface {v1, v2, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 435
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;->this$1:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    # getter for: Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->mImages:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->access$000(Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 436
    iget-object v1, p0, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;->this$1:Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages;->onImageReceived(Landroid/graphics/drawable/Drawable;I)V

    .line 438
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 430
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/details/ProductImagesView$GalleryDelayImages$1;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method
