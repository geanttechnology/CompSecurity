.class public Lcom/amazon/mShop/AmazonImageView;
.super Landroid/widget/ImageView;
.source "AmazonImageView.java"

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

.field private mImageDimen:I

.field private mImageUrl:Ljava/lang/String;

.field private mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    return-void
.end method

.method private cancelImageFetcher()V
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->cancel()V

    .line 97
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 99
    :cond_0
    return-void
.end method


# virtual methods
.method public fetchImage(Ljava/lang/String;I)V
    .locals 1
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageDimen"    # I

    .prologue
    .line 51
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/mShop/AmazonImageView;->fetchImage(Ljava/lang/String;IZ)V

    .line 52
    return-void
.end method

.method public fetchImage(Ljava/lang/String;IZ)V
    .locals 2
    .param p1, "imageUrl"    # Ljava/lang/String;
    .param p2, "imageDimen"    # I
    .param p3, "hasDefaultLoadingImage"    # Z

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/mShop/AmazonImageView;->mImageUrl:Ljava/lang/String;

    .line 66
    iput p2, p0, Lcom/amazon/mShop/AmazonImageView;->mImageDimen:I

    .line 67
    if-eqz p3, :cond_0

    .line 68
    sget v0, Lcom/amazon/mShop/android/lib/R$drawable;->noimage:I

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/BitmapUtil;->setImageResource(Landroid/widget/ImageView;I)V

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_3

    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 82
    :cond_1
    :goto_0
    return-void

    .line 75
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonImageView;->cancelImageFetcher()V

    .line 78
    :cond_3
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 79
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher;

    iget v1, p0, Lcom/amazon/mShop/AmazonImageView;->mImageDimen:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, p1, v1, p0}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0
.end method

.method public getImageByteArray()[B
    .locals 4

    .prologue
    .line 120
    const/4 v1, 0x0

    .line 121
    .local v1, "data":[B
    iget-object v2, p0, Lcom/amazon/mShop/AmazonImageView;->mUrl:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 122
    iget-object v2, p0, Lcom/amazon/mShop/AmazonImageView;->mUrl:Ljava/lang/String;

    const-class v3, Landroid/graphics/Bitmap;

    invoke-static {v2, v3}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 123
    .local v0, "bmp":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 124
    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->convertBitmapToByteArray(Landroid/graphics/Bitmap;)[B

    move-result-object v1

    .line 127
    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    :cond_0
    return-object v1
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 86
    invoke-super {p0}, Landroid/widget/ImageView;->onDetachedFromWindow()V

    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 88
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonImageView;->cancelImageFetcher()V

    .line 90
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
    .line 116
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 117
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
    .line 103
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_1

    move-object v1, p2

    .line 104
    check-cast v1, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "baseUrl":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getUrl()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/AmazonImageView;->mUrl:Ljava/lang/String;

    .line 106
    iget-object v1, p0, Lcom/amazon/mShop/AmazonImageView;->mImageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 107
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-interface {v1, v2, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 108
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonImageView;->setVisibility(I)V

    .line 110
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/AmazonImageView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 112
    .end local v0    # "baseUrl":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 28
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/AmazonImageView;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method
