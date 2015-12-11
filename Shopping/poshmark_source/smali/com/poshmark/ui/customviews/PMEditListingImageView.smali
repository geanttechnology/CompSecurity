.class public Lcom/poshmark/ui/customviews/PMEditListingImageView;
.super Landroid/widget/ImageView;
.source "PMEditListingImageView.java"


# instance fields
.field private imageId:Ljava/lang/String;

.field private imageUri:Landroid/net/Uri;

.field private isCovershot:Z

.field private isNextSelector:Z

.field private isSet:Z

.field private originalImageUri:Landroid/net/Uri;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 30
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isCovershot:Z

    .line 22
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isSet:Z

    .line 23
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector:Z

    .line 31
    return-void
.end method

.method private setImageUrl(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->url:Ljava/lang/String;

    .line 76
    if-eqz p1, :cond_0

    .line 77
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    .line 78
    .local v0, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v0, p1, p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 82
    .end local v0    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :goto_0
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isSet:Z

    .line 83
    return-void

    .line 80
    :cond_0
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method


# virtual methods
.method public getFileUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageUri:Landroid/net/Uri;

    return-object v0
.end method

.method public getImageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageId:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalFileUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->originalImageUri:Landroid/net/Uri;

    return-object v0
.end method

.method public imageAssignedState(Z)V
    .locals 1
    .param p1, "bIsSet"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isSet:Z

    .line 46
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector:Z

    .line 47
    return-void
.end method

.method public isCovershot()Z
    .locals 1

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isCovershot:Z

    return v0
.end method

.method public isImageSet()Z
    .locals 1

    .prologue
    .line 87
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isSet:Z

    return v0
.end method

.method public isNextSelector()Z
    .locals 1

    .prologue
    .line 95
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector:Z

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 10
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v9, 0x41200000    # 10.0f

    const/4 v8, 0x0

    .line 115
    invoke-super {p0, p1}, Landroid/widget/ImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 116
    iget-boolean v5, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isSet:Z

    if-eqz v5, :cond_0

    .line 148
    :goto_0
    return-void

    .line 119
    :cond_0
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    .line 121
    .local v1, "paint":Landroid/graphics/Paint;
    iget-boolean v5, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector:Z

    if-eqz v5, :cond_1

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f090039

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setColor(I)V

    .line 123
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f060036

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 124
    .local v3, "text":Ljava/lang/String;
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    .line 125
    .local v2, "size":Landroid/graphics/Rect;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getContext()Landroid/content/Context;

    move-result-object v5

    const/high16 v6, 0x41100000    # 9.0f

    invoke-static {v5, v6}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 126
    const/4 v5, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v1, v3, v5, v6, v2}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 128
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f02006e

    invoke-static {v5, v6}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 130
    .local v0, "icon":Landroid/graphics/Bitmap;
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getHeight()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    sub-int/2addr v5, v6

    invoke-virtual {v2}, Landroid/graphics/Rect;->height()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    sub-int v4, v5, v6

    .line 133
    .local v4, "yPos":I
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getWidth()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    sub-int/2addr v5, v6

    int-to-float v5, v5

    int-to-float v6, v4

    invoke-virtual {p1, v0, v5, v6, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 135
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v5

    add-int/lit8 v5, v5, 0x19

    add-int/2addr v4, v5

    .line 136
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getWidth()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v6

    div-int/lit8 v6, v6, 0x2

    sub-int/2addr v5, v6

    int-to-float v5, v5

    int-to-float v6, v4

    invoke-virtual {p1, v3, v5, v6, v1}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 138
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f090016

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setColor(I)V

    .line 144
    .end local v0    # "icon":Landroid/graphics/Bitmap;
    .end local v2    # "size":Landroid/graphics/Rect;
    .end local v3    # "text":Ljava/lang/String;
    .end local v4    # "yPos":I
    :goto_1
    sget-object v5, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 145
    const/high16 v5, 0x40800000    # 4.0f

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 146
    new-instance v5, Landroid/graphics/DashPathEffect;

    const/4 v6, 0x4

    new-array v6, v6, [F

    fill-array-data v6, :array_0

    const/high16 v7, 0x3f800000    # 1.0f

    invoke-direct {v5, v6, v7}, Landroid/graphics/DashPathEffect;-><init>([FF)V

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setPathEffect(Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;

    .line 147
    new-instance v5, Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getWidth()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    int-to-float v6, v6

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getHeight()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    int-to-float v7, v7

    invoke-direct {v5, v8, v8, v6, v7}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {p1, v5, v9, v9, v1}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 141
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f090018

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v1, v5}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_1

    .line 146
    nop

    :array_0
    .array-data 4
        0x41200000    # 10.0f
        0x40a00000    # 5.0f
        0x41200000    # 10.0f
        0x40a00000    # 5.0f
    .end array-data
.end method

.method public resetImageView()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 35
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setImageResource(I)V

    .line 36
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isSet:Z

    .line 37
    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->url:Ljava/lang/String;

    .line 38
    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageUri:Landroid/net/Uri;

    .line 39
    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->originalImageUri:Landroid/net/Uri;

    .line 40
    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector:Z

    .line 41
    return-void
.end method

.method public setAsNextEmptyImageView(Z)V
    .locals 0
    .param p1, "s"    # Z

    .prologue
    .line 71
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isNextSelector:Z

    .line 72
    return-void
.end method

.method public setCovershotStatus(Z)V
    .locals 0
    .param p1, "bIsCovershot"    # Z

    .prologue
    .line 50
    iput-boolean p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->isCovershot:Z

    .line 51
    return-void
.end method

.method public setFileUri(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageUri:Landroid/net/Uri;

    .line 55
    return-void
.end method

.method public setOriginalFileUri(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->originalImageUri:Landroid/net/Uri;

    .line 59
    return-void
.end method

.method public setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/PMEditListingImageView;->setImageUrl(Ljava/lang/String;)V

    .line 67
    iput-object p2, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->imageId:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditListingImageView;->url:Ljava/lang/String;

    .line 63
    return-void
.end method
