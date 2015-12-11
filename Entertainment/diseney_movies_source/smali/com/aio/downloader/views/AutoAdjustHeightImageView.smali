.class public Lcom/aio/downloader/views/AutoAdjustHeightImageView;
.super Landroid/widget/ImageView;
.source "AutoAdjustHeightImageView.java"


# instance fields
.field private imageHeight:I

.field private imageWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 16
    invoke-direct {p0}, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->getImageSize()V

    .line 17
    return-void
.end method

.method private getImageSize()V
    .locals 3

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 21
    .local v0, "background":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_0

    .line 26
    .end local v0    # "background":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-void

    .line 23
    .restart local v0    # "background":Landroid/graphics/drawable/Drawable;
    :cond_0
    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    .end local v0    # "background":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 24
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->imageWidth:I

    .line 25
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->imageHeight:I

    goto :goto_0
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 30
    iget v2, p0, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->imageWidth:I

    if-eqz v2, :cond_0

    iget v2, p0, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->imageHeight:I

    if-eqz v2, :cond_0

    .line 33
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 34
    .local v1, "width":I
    iget v2, p0, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->imageHeight:I

    mul-int/2addr v2, v1

    iget v3, p0, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->imageWidth:I

    div-int v0, v2, v3

    .line 35
    .local v0, "height":I
    invoke-virtual {p0, v1, v0}, Lcom/aio/downloader/views/AutoAdjustHeightImageView;->setMeasuredDimension(II)V

    .line 38
    .end local v0    # "height":I
    .end local v1    # "width":I
    :cond_0
    return-void
.end method
