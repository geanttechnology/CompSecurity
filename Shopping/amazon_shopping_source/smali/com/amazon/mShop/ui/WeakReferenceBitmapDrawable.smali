.class public Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "WeakReferenceBitmapDrawable.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/graphics/drawable/Drawable;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

.field private mBitmapHeight:I

.field private mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

.field private mBitmapWidth:I

.field private mDefaultImage:Landroid/graphics/Bitmap;

.field private mTargetDensity:I


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 6
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "defaultImage"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/res/Resources;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p4, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 58
    iput-object p3, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mDefaultImage:Landroid/graphics/Bitmap;

    .line 59
    new-instance v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p1

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;-><init>(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/content/res/Resources;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->densityDpi:I

    iput v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mTargetDensity:I

    iput v1, v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mTargetDensity:I

    .line 61
    invoke-direct {p0, p2}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->computeBitmapSize(Landroid/graphics/Bitmap;)V

    .line 62
    return-void
.end method

.method private computeBitmapSize(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v0, -0x1

    .line 108
    if-eqz p1, :cond_0

    .line 109
    iget v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mTargetDensity:I

    invoke-virtual {p1, v0}, Landroid/graphics/Bitmap;->getScaledWidth(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapWidth:I

    .line 110
    iget v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mTargetDensity:I

    invoke-virtual {p1, v0}, Landroid/graphics/Bitmap;->getScaledHeight(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapHeight:I

    .line 115
    :goto_0
    return-void

    .line 112
    :cond_0
    iput v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapWidth:I

    .line 113
    iput v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapHeight:I

    goto :goto_0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 131
    .local v0, "bmp":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 132
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/Rect;->centerX()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    sub-int v1, v3, v4

    .line 133
    .local v1, "left":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/Rect;->centerY()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    sub-int v2, v3, v4

    .line 135
    .local v2, "top":I
    const/4 v3, 0x0

    new-instance v4, Landroid/graphics/Rect;

    iget v5, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapWidth:I

    iget v6, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapHeight:I

    invoke-direct {v4, v1, v2, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    iget-object v5, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;
    invoke-static {v5}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;

    move-result-object v5

    invoke-virtual {p1, v0, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 137
    .end local v1    # "left":I
    .end local v2    # "top":I
    :cond_0
    return-void
.end method

.method public getBitmap()Landroid/graphics/Bitmap;
    .locals 3

    .prologue
    .line 227
    const/4 v0, 0x0

    .line 229
    .local v0, "bmp":Landroid/graphics/Bitmap;
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {v1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$100(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 230
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {v1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$100(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getUrl()Ljava/lang/String;

    move-result-object v1

    const-class v2, Landroid/graphics/Bitmap;

    invoke-static {v1, v2}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    check-cast v0, Landroid/graphics/Bitmap;

    .line 231
    .restart local v0    # "bmp":Landroid/graphics/Bitmap;
    if-nez v0, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-nez v1, :cond_0

    .line 232
    new-instance v1, Lcom/amazon/mShop/net/BitmapFetcher;

    iget-object v2, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mParams:Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {v2}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$100(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;)V

    iput-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 233
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    .line 237
    :cond_0
    if-nez v0, :cond_1

    .line 238
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mDefaultImage:Landroid/graphics/Bitmap;

    .line 241
    :cond_1
    return-object v0
.end method

.method public final getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    .locals 2

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getChangingConfigurations()I

    move-result v1

    iput v1, v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mChangingConfigurations:I

    .line 176
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    return-object v0
.end method

.method public getIntrinsicHeight()I
    .locals 1

    .prologue
    .line 124
    iget v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapHeight:I

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .prologue
    .line 119
    iget v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapWidth:I

    return v0
.end method

.method public getOpacity()I
    .locals 2

    .prologue
    .line 156
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 157
    .local v0, "bmp":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, -0x3

    :goto_0
    return v1

    :cond_1
    const/4 v1, -0x1

    goto :goto_0
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
    .line 256
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 257
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 1
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
    .line 246
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 248
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 249
    invoke-direct {p0, p1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->computeBitmapSize(Landroid/graphics/Bitmap;)V

    .line 250
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->invalidateSelf()V

    .line 252
    :cond_0
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 33
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method

.method public setAlpha(I)V
    .locals 2
    .param p1, "alpha"    # I

    .prologue
    .line 141
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;
    invoke-static {v1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;

    move-result-object v1

    invoke-virtual {v1}, Landroid/graphics/Paint;->getAlpha()I

    move-result v0

    .line 142
    .local v0, "oldAlpha":I
    if-eq p1, v0, :cond_0

    .line 143
    iget-object v1, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;
    invoke-static {v1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 144
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->invalidateSelf()V

    .line 146
    :cond_0
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 150
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;
    invoke-static {v0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 151
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->invalidateSelf()V

    .line 152
    return-void
.end method

.method public setDither(Z)V
    .locals 1
    .param p1, "dither"    # Z

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;
    invoke-static {v0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setDither(Z)V

    .line 170
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->invalidateSelf()V

    .line 171
    return-void
.end method

.method public setFilterBitmap(Z)V
    .locals 1
    .param p1, "filter"    # Z

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->mBitmapState:Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;

    # getter for: Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->mPaint:Landroid/graphics/Paint;
    invoke-static {v0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;->access$000(Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable$WeakReferenceBitmapState;)Landroid/graphics/Paint;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 164
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->invalidateSelf()V

    .line 165
    return-void
.end method
