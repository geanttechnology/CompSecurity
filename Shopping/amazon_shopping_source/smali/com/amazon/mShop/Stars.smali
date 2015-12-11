.class public Lcom/amazon/mShop/Stars;
.super Landroid/widget/LinearLayout;
.source "Stars.java"


# instance fields
.field private mStarHeight:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 38
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/Stars;I)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/Stars;
    .param p1, "x1"    # I

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/Stars;->getResourceBitmap(I)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/Stars;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/Stars;

    .prologue
    .line 27
    iget v0, p0, Lcom/amazon/mShop/Stars;->mStarHeight:I

    return v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/Stars;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/Stars;
    .param p1, "x1"    # Landroid/graphics/Bitmap;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/Stars;->scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method private getResourceBitmap(I)Landroid/graphics/Bitmap;
    .locals 4
    .param p1, "id"    # I

    .prologue
    .line 102
    invoke-virtual {p0}, Lcom/amazon/mShop/Stars;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 103
    .local v2, "res":Landroid/content/res/Resources;
    invoke-virtual {v2, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 104
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    const/4 v0, 0x0

    .line 105
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v1, :cond_0

    instance-of v3, v1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v3, :cond_0

    .line 106
    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 108
    :cond_0
    return-object v0
.end method

.method private scaleBitmap(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .locals 8
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v1, 0x0

    .line 128
    iget v0, p0, Lcom/amazon/mShop/Stars;->mStarHeight:I

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    iget v2, p0, Lcom/amazon/mShop/Stars;->mStarHeight:I

    if-ne v0, v2, :cond_1

    .line 136
    .end local p1    # "bitmap":Landroid/graphics/Bitmap;
    :cond_0
    :goto_0
    return-object p1

    .line 132
    .restart local p1    # "bitmap":Landroid/graphics/Bitmap;
    :cond_1
    iget v0, p0, Lcom/amazon/mShop/Stars;->mStarHeight:I

    int-to-float v0, v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    int-to-float v2, v2

    const/high16 v3, 0x3f800000    # 1.0f

    mul-float/2addr v2, v3

    div-float v7, v0, v2

    .line 133
    .local v7, "heightScalingFactor":F
    new-instance v5, Landroid/graphics/Matrix;

    invoke-direct {v5}, Landroid/graphics/Matrix;-><init>()V

    .line 134
    .local v5, "scaleMatrix":Landroid/graphics/Matrix;
    invoke-virtual {v5, v7, v7}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 136
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    const/4 v6, 0x1

    move-object v0, p1

    move v2, v1

    invoke-static/range {v0 .. v6}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object p1

    goto :goto_0
.end method


# virtual methods
.method public setRating(Ljava/lang/Integer;)V
    .locals 5
    .param p1, "rating"    # Ljava/lang/Integer;

    .prologue
    .line 49
    new-instance v0, Lcom/amazon/mShop/util/MShopUiOOMHandler;

    invoke-virtual {p0}, Lcom/amazon/mShop/Stars;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    new-instance v2, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    new-instance v3, Lcom/amazon/mShop/Stars$1;

    invoke-direct {v3, p0, p1}, Lcom/amazon/mShop/Stars$1;-><init>(Lcom/amazon/mShop/Stars;Ljava/lang/Integer;)V

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;-><init>(Ljava/lang/Runnable;Z)V

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/util/MShopUiOOMHandler;-><init>(Landroid/app/Activity;Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;)V

    .line 98
    .local v0, "oomHandler":Lcom/amazon/mShop/util/MShopUiOOMHandler;
    invoke-virtual {v0}, Lcom/amazon/mShop/util/MShopUiOOMHandler;->execute()V

    .line 99
    return-void
.end method

.method public setStarHeight(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 119
    iput p1, p0, Lcom/amazon/mShop/Stars;->mStarHeight:I

    .line 120
    return-void
.end method
