.class public Lcom/amazon/mShop/home/ShovelerItemView;
.super Landroid/widget/LinearLayout;
.source "ShovelerItemView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

.field private mDrawable:Landroid/graphics/drawable/Drawable;

.field private mImageUrl:Ljava/lang/String;

.field private mThumbnail:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    return-void
.end method

.method private cancelImageFetcher()V
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->cancel()V

    .line 89
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 91
    :cond_0
    return-void
.end method

.method private setImageUrl(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 69
    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_2

    .line 70
    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 84
    :cond_0
    :goto_0
    return-void

    .line 74
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->cancelImageFetcher()V

    .line 78
    :cond_2
    if-eqz p1, :cond_0

    .line 79
    invoke-virtual {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->home_view_shoveler_view_thumbnail_max_dimension:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 80
    .local v0, "dimension":I
    new-instance v1, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v1, p1, v2, p0}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    iput-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 81
    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0
.end method


# virtual methods
.method public getEncodedImage()[B
    .locals 5

    .prologue
    .line 112
    iget-object v3, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_0

    .line 113
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 114
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    iget-object v3, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    check-cast v3, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    invoke-virtual {v3}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 115
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    .line 116
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v4, 0x64

    invoke-virtual {v1, v3, v4, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    move-result v2

    .line 117
    .local v2, "isSuccessful":Z
    if-eqz v2, :cond_0

    .line 118
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    .line 122
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "isSuccessful":Z
    :goto_0
    return-object v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 60
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 62
    invoke-direct {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->cancelImageFetcher()V

    .line 64
    :cond_0
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 95
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 96
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->home_shoveler_item_thumbnail:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/home/ShovelerItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mThumbnail:Landroid/widget/ImageView;

    .line 97
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
    .line 127
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 128
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
    .line 101
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_1

    move-object v1, p2

    .line 102
    check-cast v1, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, "baseUrl":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mImageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 104
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-interface {v1, v2, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 105
    iget-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mThumbnail:Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 107
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 109
    .end local v0    # "baseUrl":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 23
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/home/ShovelerItemView;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method

.method public update(Ljava/lang/String;)V
    .locals 7
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mImageUrl:Ljava/lang/String;

    .line 39
    iget-object v4, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mImageUrl:Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 40
    invoke-virtual {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->home_view_shoveler_view_thumbnail_max_dimension:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 42
    .local v1, "dimension":I
    iget-object v4, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mImageUrl:Ljava/lang/String;

    invoke-static {v4, v1}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v3

    .line 43
    .local v3, "url":Ljava/lang/String;
    const-class v4, Landroid/graphics/Bitmap;

    invoke-static {v3, v4}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 44
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_1

    .line 45
    new-instance v2, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 46
    .local v2, "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-interface {v4, v5, v0, v2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 47
    iget-object v4, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mThumbnail:Landroid/widget/ImageView;

    iget-object v5, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 56
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "dimension":I
    .end local v2    # "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    .end local v3    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 50
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v1    # "dimension":I
    .restart local v3    # "url":Ljava/lang/String;
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/home/ShovelerItemView;->mThumbnail:Landroid/widget/ImageView;

    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v5

    invoke-virtual {p0}, Lcom/amazon/mShop/home/ShovelerItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-interface {v5, v6}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->getDefaultDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 54
    invoke-direct {p0, p1}, Lcom/amazon/mShop/home/ShovelerItemView;->setImageUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
