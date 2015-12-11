.class public Lcom/poshmark/ui/customviews/PMClickableImageView;
.super Lcom/poshmark/ui/customviews/PMListingImageView;
.source "PMClickableImageView.java"


# static fields
.field static final THRESHOLD_DIP:F = 16.0f


# instance fields
.field bundleForDestinationFragment:Landroid/os/Bundle;

.field destination:Ljava/lang/Class;

.field displayString:Ljava/lang/String;

.field isImageSet:Z

.field isTextOverlay:Z

.field paint:Landroid/graphics/Paint;

.field rect:Landroid/graphics/Rect;

.field textLayout:Landroid/text/StaticLayout;

.field textPaint:Landroid/text/TextPaint;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 44
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMListingImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bundleForDestinationFragment:Landroid/os/Bundle;

    .line 35
    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isTextOverlay:Z

    .line 36
    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isImageSet:Z

    .line 38
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    .line 39
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    .line 46
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setFlags(I)V

    .line 47
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    invoke-virtual {v0, v2}, Landroid/text/TextPaint;->setFlags(I)V

    .line 48
    return-void
.end method


# virtual methods
.method public launchFragmentOnClick()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 61
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    if-eqz v3, :cond_1

    .line 62
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->customOnCLickListener:Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;

    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bundleForDestinationFragment:Landroid/os/Bundle;

    invoke-interface {v3, p0, v4}, Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;->onClick(Lcom/poshmark/ui/customviews/PMImageView;Landroid/os/Bundle;)V

    .line 79
    :cond_0
    :goto_0
    return-void

    .line 64
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->destination:Ljava/lang/Class;

    if-eqz v3, :cond_2

    .line 65
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 66
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bundleForDestinationFragment:Landroid/os/Bundle;

    iget-object v4, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->destination:Ljava/lang/Class;

    invoke-virtual {v1, v3, v4, v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0

    .line 68
    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_2
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bundleForDestinationFragment:Landroid/os/Bundle;

    const-string v4, "DEEP_LINK"

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, "deepLink":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 71
    .restart local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    instance-of v3, v1, Lcom/poshmark/ui/MainActivity;

    if-eqz v3, :cond_0

    .line 72
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 73
    .local v2, "uri":Landroid/net/Uri;
    check-cast v1, Lcom/poshmark/ui/MainActivity;

    .end local v1    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/MainActivity;->handleDeepLinkLaunch(Landroid/net/Uri;Z)V

    goto :goto_0
.end method

.method public loadImage(Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 82
    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->displayString:Ljava/lang/String;

    .line 83
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->releaseInternalBitmap()V

    .line 84
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 85
    if-eqz p1, :cond_1

    .line 86
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    .line 87
    .local v2, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v2, p1, p0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 88
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isImageSet:Z

    .line 89
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->imgURL:Ljava/lang/String;

    .line 90
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bUsingResourceBitmap:Z

    .line 100
    .end local v2    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    const-string v3, ""

    iput-object v3, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->imgURL:Ljava/lang/String;

    .line 93
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bUsingResourceBitmap:Z

    .line 94
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0200d4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 95
    .local v1, "d":Landroid/graphics/drawable/Drawable;
    instance-of v3, v1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v3, :cond_0

    .line 96
    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 97
    .local v0, "b":Landroid/graphics/Bitmap;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public loadImageWithString(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "isOverlay"    # Z

    .prologue
    const/4 v0, 0x0

    .line 103
    if-nez p2, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->releaseInternalBitmap()V

    .line 105
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 107
    :cond_0
    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    .line 108
    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    .line 109
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->displayString:Ljava/lang/String;

    .line 110
    iput-boolean p2, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isTextOverlay:Z

    .line 111
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->invalidate()V

    .line 112
    return-void
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 14
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v2, 0x3f000000    # 0.5f

    const/high16 v13, 0x40000000    # 2.0f

    const/4 v7, 0x0

    .line 116
    invoke-super {p0, p1}, Lcom/poshmark/ui/customviews/PMListingImageView;->onDraw(Landroid/graphics/Canvas;)V

    .line 118
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->displayString:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 174
    :goto_0
    return-void

    .line 121
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    if-nez v0, :cond_1

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v9, v0, Landroid/util/DisplayMetrics;->density:F

    .line 124
    .local v9, "scale":F
    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    .line 125
    .local v4, "alignment":Landroid/text/Layout$Alignment;
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isTextOverlay:Z

    if-eqz v0, :cond_3

    .line 126
    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    const/high16 v1, 0x41500000    # 13.0f

    mul-float/2addr v1, v9

    add-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 133
    :goto_1
    new-instance v0, Landroid/text/StaticLayout;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->displayString:Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getWidth()I

    move-result v3

    add-int/lit8 v3, v3, -0x14

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v7}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    .line 136
    .end local v4    # "alignment":Landroid/text/Layout$Alignment;
    .end local v9    # "scale":F
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    if-nez v0, :cond_2

    .line 137
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isTextOverlay:Z

    if-eqz v0, :cond_4

    .line 138
    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getHeight()I

    move-result v1

    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v2}, Landroid/text/StaticLayout;->getHeight()I

    move-result v2

    sub-int/2addr v1, v2

    add-int/lit8 v1, v1, -0x1e

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getHeight()I

    move-result v3

    invoke-direct {v0, v7, v1, v2, v3}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    .line 145
    :cond_2
    :goto_2
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isTextOverlay:Z

    if-eqz v0, :cond_5

    .line 146
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090002

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 147
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 149
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 151
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090040

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    .line 167
    :goto_3
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0}, Landroid/text/StaticLayout;->getHeight()I

    move-result v0

    int-to-float v8, v0

    .line 168
    .local v8, "height":F
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0}, Landroid/text/StaticLayout;->getWidth()I

    move-result v0

    int-to-float v10, v0

    .line 169
    .local v10, "width":F
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->top:I

    int-to-float v0, v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    div-float v2, v8, v13

    sub-float/2addr v1, v2

    add-float v12, v0, v1

    .line 170
    .local v12, "yPos":F
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->left:I

    int-to-float v0, v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    div-float v2, v10, v13

    sub-float/2addr v1, v2

    add-float v11, v0, v1

    .line 171
    .local v11, "xPos":F
    invoke-virtual {p1, v11, v12}, Landroid/graphics/Canvas;->translate(FF)V

    .line 172
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v0, p1}, Landroid/text/StaticLayout;->draw(Landroid/graphics/Canvas;)V

    .line 173
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    goto/16 :goto_0

    .line 130
    .end local v8    # "height":F
    .end local v10    # "width":F
    .end local v11    # "xPos":F
    .end local v12    # "yPos":F
    .restart local v4    # "alignment":Landroid/text/Layout$Alignment;
    .restart local v9    # "scale":F
    :cond_3
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    const/high16 v1, 0x41800000    # 16.0f

    mul-float/2addr v1, v9

    add-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setTextSize(F)V

    goto/16 :goto_1

    .line 141
    .end local v4    # "alignment":Landroid/text/Layout$Alignment;
    .end local v9    # "scale":F
    :cond_4
    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getWidth()I

    move-result v1

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getHeight()I

    move-result v2

    invoke-direct {v0, v7, v7, v1, v2}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    goto/16 :goto_2

    .line 154
    :cond_5
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 155
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 157
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 159
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090016

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 160
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 161
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {v0, v13}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 162
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->rect:Landroid/graphics/Rect;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 164
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->textPaint:Landroid/text/TextPaint;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    goto/16 :goto_3
.end method

.method protected onSizeChanged(IIII)V
    .locals 0
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 182
    return-void
.end method

.method public requestLayout()V
    .locals 1

    .prologue
    .line 177
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->isImageSet:Z

    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/poshmark/ui/customviews/PMListingImageView;->requestLayout()V

    .line 178
    :cond_0
    return-void
.end method

.method public setBundle(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->bundleForDestinationFragment:Landroid/os/Bundle;

    .line 52
    return-void
.end method

.method public setDestinationFragment(Ljava/lang/Class;)V
    .locals 0
    .param p1, "destination"    # Ljava/lang/Class;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMClickableImageView;->destination:Ljava/lang/Class;

    .line 57
    return-void
.end method
