.class public Lcom/poshmark/ui/customviews/PMPriceLayout;
.super Landroid/widget/LinearLayout;
.source "PMPriceLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/PMPriceLayout$1;,
        Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;,
        Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;
    }
.end annotation


# instance fields
.field defaultListingPriceFontSizeAsDip:I

.field leftOffset:I

.field listingPrice:Ljava/lang/String;

.field minListingPriceFontSizeAsDip:I

.field minOriginalPriceFontSizeAsDip:I

.field originalPrice:Ljava/lang/String;

.field paint:Landroid/graphics/Paint;

.field savedBackground:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    const/16 v0, 0x16

    iput v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->defaultListingPriceFontSizeAsDip:I

    .line 29
    const/16 v0, 0xa

    iput v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->minListingPriceFontSizeAsDip:I

    .line 30
    const/4 v0, 0x6

    iput v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->minOriginalPriceFontSizeAsDip:I

    .line 31
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    const/high16 v1, 0x41200000    # 10.0f

    invoke-static {v0, v1}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->leftOffset:I

    .line 38
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->setWillNotDraw(Z)V

    .line 40
    new-instance v0, Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    .line 42
    return-void
.end method

.method private getDrawPoint(Landroid/graphics/Canvas;Landroid/graphics/Point;I)Landroid/graphics/Point;
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "textLimits"    # Landroid/graphics/Point;
    .param p3, "xOffset"    # I

    .prologue
    .line 136
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    .line 137
    .local v0, "p":Landroid/graphics/Point;
    iput p3, v0, Landroid/graphics/Point;->x:I

    .line 138
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    iget v2, p2, Landroid/graphics/Point;->y:I

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Point;->y:I

    .line 139
    return-object v0
.end method

.method private getMinFontSize(Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)I
    .locals 2
    .param p1, "stringType"    # Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    .prologue
    .line 125
    sget-object v0, Lcom/poshmark/ui/customviews/PMPriceLayout$1;->$SwitchMap$com$poshmark$ui$customviews$PMPriceLayout$STRING_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 131
    iget v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->minListingPriceFontSizeAsDip:I

    :goto_0
    return v0

    .line 127
    :pswitch_0
    iget v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->minListingPriceFontSizeAsDip:I

    goto :goto_0

    .line 129
    :pswitch_1
    iget v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->minOriginalPriceFontSizeAsDip:I

    goto :goto_0

    .line 125
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private getTextBounds(Ljava/lang/String;)Landroid/graphics/Point;
    .locals 6
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 143
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 144
    .local v0, "horizontalBounds":Landroid/graphics/Rect;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v2, p1, v5, v3, v0}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 146
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 147
    .local v1, "verticalBounds":Landroid/graphics/Rect;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    const-string v3, "a"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v5, v4, v1}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 149
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v3

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    return-object v2
.end method

.method private initPaintForPriceString(ILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)V
    .locals 5
    .param p1, "dipFontSize"    # I
    .param p2, "stringType"    # Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    .prologue
    const/4 v4, 0x1

    .line 165
    sget-object v2, Lcom/poshmark/ui/customviews/PMPriceLayout$1;->$SwitchMap$com$poshmark$ui$customviews$PMPriceLayout$STRING_TYPE:[I

    invoke-virtual {p2}, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 183
    :goto_0
    return-void

    .line 167
    :pswitch_0
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090040

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 168
    .local v1, "myColor":I
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 169
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    int-to-float v3, p1

    invoke-static {v2, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v0

    .line 170
    .local v0, "fontSize":F
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 171
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 172
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setFlags(I)V

    goto :goto_0

    .line 175
    .end local v0    # "fontSize":F
    .end local v1    # "myColor":I
    :pswitch_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090039

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    .line 176
    .restart local v1    # "myColor":I
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 177
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getContext()Landroid/content/Context;

    move-result-object v2

    int-to-float v3, p1

    invoke-static {v2, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v0

    .line 178
    .restart local v0    # "fontSize":F
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v0}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 179
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 180
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    const/16 v3, 0x11

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setFlags(I)V

    goto :goto_0

    .line 165
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private renderScaledString(Ljava/lang/String;Landroid/graphics/Canvas;IIILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    .locals 5
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "canvas"    # Landroid/graphics/Canvas;
    .param p3, "xOffset"    # I
    .param p4, "maxWidth"    # I
    .param p5, "initialFontSize"    # I
    .param p6, "stringType"    # Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    .prologue
    const/4 v4, 0x1

    .line 92
    new-instance v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;-><init>(Lcom/poshmark/ui/customviews/PMPriceLayout;)V

    .line 93
    .local v1, "result":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    move v0, p5

    .line 95
    .local v0, "currentFontSize":I
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {v3}, Landroid/graphics/Paint;->reset()V

    .line 96
    invoke-direct {p0, v0, p6}, Lcom/poshmark/ui/customviews/PMPriceLayout;->initPaintForPriceString(ILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)V

    .line 97
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getTextBounds(Ljava/lang/String;)Landroid/graphics/Point;

    move-result-object v2

    .line 98
    .local v2, "textLimits":Landroid/graphics/Point;
    iget v3, v2, Landroid/graphics/Point;->x:I

    add-int/2addr v3, p3

    if-ge v3, p4, :cond_2

    .line 99
    iput-boolean v4, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    .line 100
    iput v0, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderedFontSize:I

    .line 115
    :cond_0
    :goto_0
    iget-boolean v3, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    if-eqz v3, :cond_1

    .line 116
    invoke-direct {p0, p2, v2, p3}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getDrawPoint(Landroid/graphics/Canvas;Landroid/graphics/Point;I)Landroid/graphics/Point;

    move-result-object v3

    iput-object v3, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    .line 117
    iget-object v3, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    iget v3, v3, Landroid/graphics/Point;->x:I

    iget v4, v2, Landroid/graphics/Point;->x:I

    add-int/2addr v3, v4

    iput v3, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->endPoint:I

    .line 121
    :cond_1
    return-object v1

    .line 102
    :cond_2
    add-int/lit8 v0, v0, -0x1

    .line 103
    :goto_1
    iget v3, v2, Landroid/graphics/Point;->x:I

    add-int/2addr v3, p3

    if-lt v3, p4, :cond_0

    invoke-direct {p0, p6}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getMinFontSize(Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)I

    move-result v3

    if-le v0, v3, :cond_0

    .line 104
    invoke-direct {p0, v0, p6}, Lcom/poshmark/ui/customviews/PMPriceLayout;->initPaintForPriceString(ILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)V

    .line 105
    invoke-direct {p0, p1}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getTextBounds(Ljava/lang/String;)Landroid/graphics/Point;

    move-result-object v2

    .line 106
    iget v3, v2, Landroid/graphics/Point;->x:I

    add-int/2addr v3, p3

    if-ge v3, p4, :cond_3

    .line 107
    iput-boolean v4, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    .line 108
    iput v0, v1, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderedFontSize:I

    goto :goto_0

    .line 111
    :cond_3
    add-int/lit8 v0, v0, -0x1

    goto :goto_1
.end method

.method private willFit(Ljava/lang/String;I)Z
    .locals 4
    .param p1, "listingPrice"    # Ljava/lang/String;
    .param p2, "max"    # I

    .prologue
    const/4 v1, 0x0

    .line 153
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 154
    .local v0, "bounds":Landroid/graphics/Rect;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v2, p1, v1, v3, v0}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 155
    iget v2, v0, Landroid/graphics/Rect;->right:I

    if-le v2, p2, :cond_0

    .line 158
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 14
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 53
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->originalPrice:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->listingPrice:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 54
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getWidth()I

    move-result v0

    div-int/lit8 v4, v0, 0x2

    .line 55
    .local v4, "maxWidth":I
    const/4 v12, 0x0

    .line 56
    .local v12, "listingPriceResult":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    const/4 v13, 0x0

    .line 57
    .local v13, "originalPriceResult":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->listingPrice:Ljava/lang/String;

    iget v3, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->leftOffset:I

    iget v5, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->defaultListingPriceFontSizeAsDip:I

    sget-object v6, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->LISTING_PRICE:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    move-object v0, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/ui/customviews/PMPriceLayout;->renderScaledString(Ljava/lang/String;Landroid/graphics/Canvas;IIILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;

    move-result-object v12

    .line 58
    iget-boolean v0, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    if-nez v0, :cond_3

    .line 61
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->listingPrice:Ljava/lang/String;

    iget v8, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->leftOffset:I

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getWidth()I

    move-result v9

    iget v10, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->defaultListingPriceFontSizeAsDip:I

    sget-object v11, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->LISTING_PRICE:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    move-object v5, p0

    move-object v7, p1

    invoke-direct/range {v5 .. v11}, Lcom/poshmark/ui/customviews/PMPriceLayout;->renderScaledString(Ljava/lang/String;Landroid/graphics/Canvas;IIILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;

    move-result-object v12

    .line 62
    iget-boolean v0, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    if-eqz v0, :cond_0

    .line 65
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->originalPrice:Ljava/lang/String;

    iget v0, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->endPoint:I

    iget v1, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->leftOffset:I

    add-int v8, v0, v1

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getWidth()I

    move-result v9

    iget v10, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderedFontSize:I

    sget-object v11, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->ORIGINAL_STRING:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    move-object v5, p0

    move-object v7, p1

    invoke-direct/range {v5 .. v11}, Lcom/poshmark/ui/customviews/PMPriceLayout;->renderScaledString(Ljava/lang/String;Landroid/graphics/Canvas;IIILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;

    move-result-object v13

    .line 76
    :cond_0
    :goto_0
    if-eqz v12, :cond_1

    iget-boolean v0, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    if-eqz v0, :cond_1

    .line 77
    iget v0, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderedFontSize:I

    sget-object v1, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->LISTING_PRICE:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/customviews/PMPriceLayout;->initPaintForPriceString(ILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)V

    .line 78
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->listingPrice:Ljava/lang/String;

    iget-object v1, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    int-to-float v1, v1

    iget-object v2, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 81
    :cond_1
    if-eqz v13, :cond_2

    iget-boolean v0, v13, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    if-eqz v0, :cond_2

    .line 82
    iget v0, v13, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderedFontSize:I

    sget-object v1, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->ORIGINAL_STRING:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/customviews/PMPriceLayout;->initPaintForPriceString(ILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)V

    .line 83
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->originalPrice:Ljava/lang/String;

    iget-object v1, v13, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    iget v1, v1, Landroid/graphics/Point;->x:I

    int-to-float v1, v1

    iget-object v2, v13, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderStartPoint:Landroid/graphics/Point;

    iget v2, v2, Landroid/graphics/Point;->y:I

    int-to-float v2, v2

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 88
    .end local v4    # "maxWidth":I
    .end local v12    # "listingPriceResult":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    .end local v13    # "originalPriceResult":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    :cond_2
    return-void

    .line 68
    .restart local v4    # "maxWidth":I
    .restart local v12    # "listingPriceResult":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    .restart local v13    # "originalPriceResult":Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;
    :cond_3
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->originalPrice:Ljava/lang/String;

    iget v0, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->endPoint:I

    iget v1, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->leftOffset:I

    add-int v8, v0, v1

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getWidth()I

    move-result v9

    iget v10, v12, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->renderedFontSize:I

    sget-object v11, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->ORIGINAL_STRING:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    move-object v5, p0

    move-object v7, p1

    invoke-direct/range {v5 .. v11}, Lcom/poshmark/ui/customviews/PMPriceLayout;->renderScaledString(Ljava/lang/String;Landroid/graphics/Canvas;IIILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;

    move-result-object v13

    .line 69
    iget-boolean v0, v13, Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;->success:Z

    if-nez v0, :cond_0

    .line 72
    iget-object v6, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->listingPrice:Ljava/lang/String;

    iget v8, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->leftOffset:I

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->getWidth()I

    move-result v9

    iget v10, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->defaultListingPriceFontSizeAsDip:I

    sget-object v11, Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;->LISTING_PRICE:Lcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;

    move-object v5, p0

    move-object v7, p1

    invoke-direct/range {v5 .. v11}, Lcom/poshmark/ui/customviews/PMPriceLayout;->renderScaledString(Ljava/lang/String;Landroid/graphics/Canvas;IIILcom/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE;)Lcom/poshmark/ui/customviews/PMPriceLayout$RenderResult;

    move-result-object v12

    goto :goto_0
.end method

.method public setListingPrices(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "listingPrice"    # Ljava/lang/String;
    .param p2, "originalPrice"    # Ljava/lang/String;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->listingPrice:Ljava/lang/String;

    .line 46
    iput-object p2, p0, Lcom/poshmark/ui/customviews/PMPriceLayout;->originalPrice:Ljava/lang/String;

    .line 47
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMPriceLayout;->invalidate()V

    .line 48
    return-void
.end method
