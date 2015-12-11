.class public Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;
.super Landroid/graphics/drawable/Drawable$ConstantState;
.source "WeakReferenceBitmapDrawable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WeakReferenceBitmapState"
.end annotation


# instance fields
.field public mChangingConfigurations:I

.field private mDefaultImage:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field private mPaint:Landroid/graphics/Paint;

.field private mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

.field private mResource:Landroid/content/res/Resources;

.field public mTargetDensity:I


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/content/res/Resources;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 8
    .param p1, "pThis"    # Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "defaultImage"    # Landroid/graphics/Bitmap;
    .param p4, "res"    # Landroid/content/res/Resources;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            "Landroid/content/res/Resources;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p5, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    const/4 v4, 0x0

    .line 188
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable$ConstantState;-><init>()V

    .line 185
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;

    .line 189
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p3}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mDefaultImage:Ljava/lang/ref/WeakReference;

    .line 190
    iput-object p4, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mResource:Landroid/content/res/Resources;

    .line 191
    if-nez p5, :cond_1

    .line 192
    iput-object v4, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    .line 202
    :cond_0
    :goto_0
    return-void

    .line 193
    :cond_1
    instance-of v0, p5, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    if-eqz v0, :cond_0

    move-object v7, p5

    .line 194
    check-cast v7, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    .line 195
    .local v7, "bfParams":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 196
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getMaxDimension()I

    move-result v3

    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->useDiskCache()Z

    move-result v5

    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getResidencePriority()Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    move-result-object v6

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ILjava/lang/Object;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    goto :goto_0

    .line 197
    :cond_2
    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 199
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    return-object v0
.end method


# virtual methods
.method public getChangingConfigurations()I
    .locals 1

    .prologue
    .line 221
    iget v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mChangingConfigurations:I

    return v0
.end method

.method public newDrawable()Landroid/graphics/drawable/Drawable;
    .locals 5

    .prologue
    .line 206
    const/4 v0, 0x0

    .line 208
    .local v0, "bmp":Landroid/graphics/Bitmap;
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    if-eqz v1, :cond_0

    .line 209
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getUrl()Ljava/lang/String;

    move-result-object v1

    const-class v2, Landroid/graphics/Bitmap;

    invoke-static {v1, v2}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    check-cast v0, Landroid/graphics/Bitmap;

    .line 212
    .restart local v0    # "bmp":Landroid/graphics/Bitmap;
    :cond_0
    if-nez v0, :cond_1

    .line 213
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mDefaultImage:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    check-cast v0, Landroid/graphics/Bitmap;

    .line 216
    .restart local v0    # "bmp":Landroid/graphics/Bitmap;
    :cond_1
    new-instance v2, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    iget-object v3, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mResource:Landroid/content/res/Resources;

    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mDefaultImage:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/Bitmap;

    iget-object v4, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-direct {v2, v3, v0, v1, v4}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-object v2
.end method
