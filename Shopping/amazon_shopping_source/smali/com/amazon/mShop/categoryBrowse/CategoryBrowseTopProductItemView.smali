.class public Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;
.super Landroid/widget/ImageView;
.source "CategoryBrowseTopProductItemView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ImageView;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

.field private mDrawable:Landroid/graphics/drawable/Drawable;

.field private mEncodedImage:[B

.field private mImageUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    return-void
.end method

.method private cancelImageFetcher()V
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->cancel()V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 62
    :cond_0
    return-void
.end method

.method private setImageUrl(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 39
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_2

    .line 40
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 55
    :cond_0
    :goto_0
    return-void

    .line 44
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->cancelImageFetcher()V

    .line 48
    :cond_2
    if-eqz p1, :cond_0

    .line 49
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->category_browse_top_product_max_image_dimension:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 51
    .local v0, "dimension":I
    new-instance v1, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v1, p1, v2, p0}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    iput-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 52
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0
.end method


# virtual methods
.method public getEncodedImage()[B
    .locals 5

    .prologue
    .line 65
    iget-object v3, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mEncodedImage:[B

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 66
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 67
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    iget-object v3, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    check-cast v3, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    invoke-virtual {v3}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 68
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    .line 70
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v4, 0x64

    invoke-virtual {v1, v3, v4, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result v2

    .line 71
    .local v2, "isSuccessful":Z
    if-eqz v2, :cond_0

    .line 72
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mEncodedImage:[B

    .line 76
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "isSuccessful":Z
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mEncodedImage:[B

    return-object v3
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 81
    invoke-super {p0}, Landroid/widget/ImageView;->onDetachedFromWindow()V

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 83
    invoke-direct {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->cancelImageFetcher()V

    .line 85
    :cond_0
    return-void
.end method

.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 1
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
    .line 104
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 105
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
    .line 92
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_1

    move-object v1, p2

    .line 93
    check-cast v1, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "baseUrl":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mImageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 95
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-interface {v1, v2, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 96
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 98
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 100
    .end local v0    # "baseUrl":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 21
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseTopProductItemView;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method
