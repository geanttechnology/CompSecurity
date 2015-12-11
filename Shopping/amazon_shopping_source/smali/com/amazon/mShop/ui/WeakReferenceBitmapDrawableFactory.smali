.class public Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;
.super Ljava/lang/Object;
.source "WeakReferenceBitmapDrawableFactory.java"

# interfaces
.implements Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;


# static fields
.field public static sDefaultBitmap:Landroid/graphics/Bitmap;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->sDefaultBitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method


# virtual methods
.method public createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "defaultBitmap"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/res/Resources;",
            "Landroid/graphics/Bitmap;",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Landroid/graphics/drawable/Drawable;"
        }
    .end annotation

    .prologue
    .line 44
    .local p4, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    if-nez p3, :cond_0

    .line 45
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->getDefaultBitmap(Landroid/content/res/Resources;)Landroid/graphics/Bitmap;

    move-result-object p3

    .line 46
    :cond_0
    new-instance v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-object v0
.end method

.method public createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/res/Resources;",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Landroid/graphics/drawable/Drawable;"
        }
    .end annotation

    .prologue
    .line 40
    .local p3, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->getDefaultBitmap(Landroid/content/res/Resources;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getDefaultBitmap(Landroid/content/res/Resources;)Landroid/graphics/Bitmap;
    .locals 4
    .param p1, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 21
    const/4 v1, 0x0

    .line 22
    .local v1, "defaultBitmap":Landroid/graphics/Bitmap;
    sget-object v3, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->sDefaultBitmap:Landroid/graphics/Bitmap;

    if-eqz v3, :cond_0

    .line 23
    sget-object v1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->sDefaultBitmap:Landroid/graphics/Bitmap;

    .line 26
    :cond_0
    if-nez v1, :cond_1

    if-eqz p1, :cond_1

    .line 27
    sget v3, Lcom/amazon/mShop/android/lib/R$drawable;->noimage:I

    invoke-virtual {p1, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 28
    .local v2, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v2, :cond_1

    instance-of v3, v2, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v3, :cond_1

    move-object v0, v2

    .line 29
    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .line 30
    .local v0, "bitmapDrawable":Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 31
    sput-object v1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->sDefaultBitmap:Landroid/graphics/Bitmap;

    .line 35
    .end local v0    # "bitmapDrawable":Landroid/graphics/drawable/BitmapDrawable;
    .end local v2    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-object v1
.end method

.method public getDefaultDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    .locals 3
    .param p1, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 52
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->getDefaultBitmap(Landroid/content/res/Resources;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 53
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v0, v0, v2}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-object v1
.end method

.method public resetDefaultImage()V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawableFactory;->sDefaultBitmap:Landroid/graphics/Bitmap;

    .line 60
    return-void
.end method
