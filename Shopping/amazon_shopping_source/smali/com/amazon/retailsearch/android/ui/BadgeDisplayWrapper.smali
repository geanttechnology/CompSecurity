.class public Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;
.super Landroid/text/style/DynamicDrawableSpan;
.source "BadgeDisplayWrapper.java"


# instance fields
.field private badgeID:Ljava/lang/String;

.field private baseStyleId:Ljava/lang/Integer;

.field private drawableImage:Landroid/graphics/drawable/Drawable;

.field private imageAlign:I


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;ILjava/lang/Integer;Ljava/lang/String;)V
    .locals 0
    .param p1, "drawableImage"    # Landroid/graphics/drawable/Drawable;
    .param p2, "imageAlign"    # I
    .param p3, "baseStyleId"    # Ljava/lang/Integer;
    .param p4, "badgeID"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/text/style/DynamicDrawableSpan;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->drawableImage:Landroid/graphics/drawable/Drawable;

    .line 35
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->imageAlign:I

    .line 36
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->baseStyleId:Ljava/lang/Integer;

    .line 37
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->badgeID:Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "text"    # Ljava/lang/CharSequence;
    .param p3, "start"    # I
    .param p4, "end"    # I
    .param p5, "x"    # F
    .param p6, "top"    # I
    .param p7, "y"    # I
    .param p8, "bottom"    # I
    .param p9, "paint"    # Landroid/graphics/Paint;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->drawableImage:Landroid/graphics/drawable/Drawable;

    .line 51
    .local v0, "b":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    if-nez p9, :cond_1

    .line 74
    :cond_0
    :goto_0
    return-void

    .line 52
    :cond_1
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 53
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Rect;->bottom:I

    sub-int v1, p8, v2

    .line 54
    .local v1, "transY":I
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->imageAlign:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_3

    .line 56
    invoke-virtual {p9}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    sub-int/2addr v1, v2

    .line 58
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->baseStyleId:Ljava/lang/Integer;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->baseStyleId:Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    sget v3, Lcom/amazon/retailsearch/R$style;->Results_PriceBadgeSpan:I

    if-ne v2, v3, :cond_3

    if-nez p6, :cond_3

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->badgeID:Ljava/lang/String;

    if-eqz v2, :cond_3

    .line 61
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->badgeID:Ljava/lang/String;

    const-string/jumbo v3, "primeBadge"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->badgeID:Ljava/lang/String;

    const-string/jumbo v3, "primeFreshBadge"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 63
    :cond_2
    invoke-virtual {p9}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    div-int/lit8 v2, v2, 0x5

    mul-int/lit8 v2, v2, 0x4

    sub-int/2addr v1, v2

    .line 71
    :cond_3
    :goto_1
    int-to-float v2, v1

    invoke-virtual {p1, p5, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 72
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 73
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    goto :goto_0

    .line 65
    :cond_4
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->badgeID:Ljava/lang/String;

    const-string/jumbo v3, "addOnBadge"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 67
    invoke-virtual {p9}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v2

    iget v2, v2, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    div-int/lit8 v2, v2, 0x5

    mul-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    goto :goto_1
.end method

.method public getDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/BadgeDisplayWrapper;->drawableImage:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method
