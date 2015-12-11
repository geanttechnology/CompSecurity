.class public Lcom/amazon/mShop/details/GalleryPinchImageView;
.super Lcom/amazon/mShop/imageview/PinchImageView;
.source "GalleryPinchImageView.java"


# instance fields
.field private mCanSwitchImageView:Z

.field private mGallery:Landroid/widget/Gallery;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/imageview/PinchImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    return-void
.end method

.method private static equalFloat(FF)Z
    .locals 3
    .param p0, "float1"    # F
    .param p1, "float2"    # F

    .prologue
    .line 164
    const v0, 0x3dcccccd    # 0.1f

    .line 165
    .local v0, "threshold":F
    sub-float v1, p0, p1

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    const v2, 0x3dcccccd    # 0.1f

    cmpg-float v1, v1, v2

    if-gez v1, :cond_0

    .line 166
    const/4 v1, 0x1

    .line 168
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private switchGalleryImage(I)V
    .locals 3
    .param p1, "switchDirection"    # I

    .prologue
    const/4 v2, 0x0

    .line 178
    iget-object v0, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v0, v2}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 179
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setVisibility(I)V

    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/widget/Gallery;->onKeyDown(ILandroid/view/KeyEvent;)Z

    .line 181
    iput-boolean v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mCanSwitchImageView:Z

    .line 182
    return-void
.end method


# virtual methods
.method public getGallery()Landroid/widget/Gallery;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    return-object v0
.end method

.method public setBackendResource()V
    .locals 5

    .prologue
    .line 45
    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v3}, Landroid/widget/Gallery;->getSelectedItemPosition()I

    move-result v2

    .line 48
    .local v2, "position":I
    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v3}, Landroid/widget/Gallery;->getSelectedView()Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 49
    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v3}, Landroid/widget/Gallery;->getSelectedView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v4}, Landroid/widget/Gallery;->getSelectedView()Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v4

    invoke-virtual {p0, v3, v4}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setInitialImageDisplaySize(II)V

    .line 53
    :cond_0
    const/4 v0, 0x0

    .line 54
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v3}, Landroid/widget/Gallery;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 55
    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    check-cast v3, Lcom/amazon/mShop/details/CustomizedGallery;

    invoke-virtual {v3}, Lcom/amazon/mShop/details/CustomizedGallery;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v3

    invoke-interface {v3, v2}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    .line 56
    .local v1, "drawable":Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
    invoke-virtual {v1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 58
    .end local v1    # "drawable":Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;
    :cond_1
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 59
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mCanSwitchImageView:Z

    .line 61
    return-void
.end method

.method public setGallery(Landroid/widget/Gallery;)V
    .locals 0
    .param p1, "gallery"    # Landroid/widget/Gallery;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    .line 35
    return-void
.end method

.method protected updateRect(Landroid/graphics/RectF;Landroid/graphics/RectF;)V
    .locals 9
    .param p1, "bitmapRect"    # Landroid/graphics/RectF;
    .param p2, "scrolledRect"    # Landroid/graphics/RectF;

    .prologue
    const/16 v8, 0x16

    const/16 v7, 0x15

    const/high16 v6, 0x41f00000    # 30.0f

    const/high16 v5, -0x3e100000    # -30.0f

    const/4 v4, 0x0

    .line 98
    invoke-virtual {p0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->getWidth()I

    move-result v1

    .line 99
    .local v1, "width":I
    invoke-virtual {p0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->getHeight()I

    move-result v0

    .line 102
    .local v0, "height":I
    iget v2, p1, Landroid/graphics/RectF;->top:F

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_0

    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    int-to-float v3, v0

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_0

    .line 103
    iput v4, p2, Landroid/graphics/RectF;->top:F

    .line 109
    :cond_0
    iget v2, p1, Landroid/graphics/RectF;->left:F

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_2

    iget v2, p1, Landroid/graphics/RectF;->right:F

    int-to-float v3, v1

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_2

    .line 110
    iget v2, p2, Landroid/graphics/RectF;->left:F

    cmpl-float v2, v2, v6

    if-lez v2, :cond_9

    iget-boolean v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mCanSwitchImageView:Z

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v2}, Landroid/widget/Gallery;->getSelectedItemPosition()I

    move-result v2

    if-lez v2, :cond_9

    .line 112
    invoke-direct {p0, v7}, Lcom/amazon/mShop/details/GalleryPinchImageView;->switchGalleryImage(I)V

    .line 117
    :cond_1
    :goto_0
    iput v4, p2, Landroid/graphics/RectF;->left:F

    .line 123
    :cond_2
    iget v2, p1, Landroid/graphics/RectF;->top:F

    iget v3, p2, Landroid/graphics/RectF;->top:F

    add-float/2addr v2, v3

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_3

    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    int-to-float v3, v0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_3

    .line 124
    iget v2, p1, Landroid/graphics/RectF;->top:F

    sub-float v2, v4, v2

    iput v2, p2, Landroid/graphics/RectF;->top:F

    .line 129
    :cond_3
    iget v2, p1, Landroid/graphics/RectF;->bottom:F

    iget v3, p2, Landroid/graphics/RectF;->top:F

    add-float/2addr v2, v3

    int-to-float v3, v0

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_4

    iget v2, p1, Landroid/graphics/RectF;->top:F

    cmpg-float v2, v2, v4

    if-gez v2, :cond_4

    .line 130
    int-to-float v2, v0

    iget v3, p1, Landroid/graphics/RectF;->bottom:F

    sub-float/2addr v2, v3

    iput v2, p2, Landroid/graphics/RectF;->top:F

    .line 137
    :cond_4
    iget v2, p1, Landroid/graphics/RectF;->left:F

    iget v3, p2, Landroid/graphics/RectF;->left:F

    add-float/2addr v2, v3

    cmpl-float v2, v2, v4

    if-ltz v2, :cond_6

    .line 138
    iget v2, p1, Landroid/graphics/RectF;->left:F

    invoke-static {v2, v4}, Lcom/amazon/mShop/details/GalleryPinchImageView;->equalFloat(FF)Z

    move-result v2

    if-eqz v2, :cond_5

    iget-boolean v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mCanSwitchImageView:Z

    if-eqz v2, :cond_5

    iget v2, p2, Landroid/graphics/RectF;->left:F

    cmpl-float v2, v2, v6

    if-lez v2, :cond_5

    iget-object v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v2}, Landroid/widget/Gallery;->getSelectedItemPosition()I

    move-result v2

    if-lez v2, :cond_5

    .line 140
    invoke-direct {p0, v7}, Lcom/amazon/mShop/details/GalleryPinchImageView;->switchGalleryImage(I)V

    .line 142
    :cond_5
    iget v2, p1, Landroid/graphics/RectF;->left:F

    sub-float v2, v4, v2

    iput v2, p2, Landroid/graphics/RectF;->left:F

    .line 152
    :cond_6
    iget v2, p1, Landroid/graphics/RectF;->right:F

    iget v3, p2, Landroid/graphics/RectF;->left:F

    add-float/2addr v2, v3

    int-to-float v3, v1

    cmpg-float v2, v2, v3

    if-gtz v2, :cond_8

    .line 153
    iget v2, p1, Landroid/graphics/RectF;->right:F

    int-to-float v3, v1

    invoke-static {v2, v3}, Lcom/amazon/mShop/details/GalleryPinchImageView;->equalFloat(FF)Z

    move-result v2

    if-eqz v2, :cond_7

    iget-boolean v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mCanSwitchImageView:Z

    if-eqz v2, :cond_7

    iget v2, p2, Landroid/graphics/RectF;->left:F

    cmpg-float v2, v2, v5

    if-gtz v2, :cond_7

    iget-object v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v2}, Landroid/widget/Gallery;->getSelectedItemPosition()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v3}, Landroid/widget/Gallery;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v3

    invoke-interface {v3}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_7

    .line 155
    invoke-direct {p0, v8}, Lcom/amazon/mShop/details/GalleryPinchImageView;->switchGalleryImage(I)V

    .line 157
    :cond_7
    int-to-float v2, v1

    iget v3, p1, Landroid/graphics/RectF;->right:F

    sub-float/2addr v2, v3

    iput v2, p2, Landroid/graphics/RectF;->left:F

    .line 160
    :cond_8
    return-void

    .line 113
    :cond_9
    iget v2, p2, Landroid/graphics/RectF;->left:F

    cmpg-float v2, v2, v5

    if-gez v2, :cond_1

    iget-boolean v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mCanSwitchImageView:Z

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v2}, Landroid/widget/Gallery;->getSelectedItemPosition()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    invoke-virtual {v3}, Landroid/widget/Gallery;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v3

    invoke-interface {v3}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_1

    .line 115
    invoke-direct {p0, v8}, Lcom/amazon/mShop/details/GalleryPinchImageView;->switchGalleryImage(I)V

    goto/16 :goto_0
.end method

.method public updateScale(Landroid/view/ScaleGestureDetector;)V
    .locals 2
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 190
    invoke-super {p0, p1}, Lcom/amazon/mShop/imageview/PinchImageView;->updateScale(Landroid/view/ScaleGestureDetector;)V

    .line 192
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/amazon/mShop/details/GalleryPinchImageView;->mGallery:Landroid/widget/Gallery;

    check-cast v0, Lcom/amazon/mShop/details/CustomizedGallery;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/CustomizedGallery;->logImageZoomedRefMarker()V

    .line 195
    :cond_0
    return-void
.end method

.method public zoomTo(FFF)V
    .locals 2
    .param p1, "scale"    # F
    .param p2, "centerX"    # F
    .param p3, "centerY"    # F

    .prologue
    .line 67
    const/high16 v0, 0x3f800000    # 1.0f

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_0

    .line 68
    invoke-virtual {p0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->getGallery()Landroid/widget/Gallery;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Gallery;->setVisibility(I)V

    .line 69
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/GalleryPinchImageView;->setVisibility(I)V

    .line 74
    :goto_0
    return-void

    .line 72
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/imageview/PinchImageView;->zoomTo(FFF)V

    goto :goto_0
.end method
