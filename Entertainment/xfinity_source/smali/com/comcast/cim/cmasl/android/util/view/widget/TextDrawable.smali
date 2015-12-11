.class public Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "TextDrawable.java"


# instance fields
.field private final ellipsizeWhere:Landroid/text/TextUtils$TruncateAt;

.field private final hPad:I

.field private final isCenteredH:Z

.field private final isCenteredV:Z

.field private final paint:Landroid/text/TextPaint;

.field private final pixelFormat:I

.field private final text:Ljava/lang/String;

.field private final vPad:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;IFIIZIZLandroid/text/TextUtils$TruncateAt;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "textColor"    # I
    .param p4, "textSize"    # F
    .param p5, "pixelFormat"    # I
    .param p6, "hPad"    # I
    .param p7, "isCenteredH"    # Z
    .param p8, "vPad"    # I
    .param p9, "isCenteredV"    # Z
    .param p10, "ellipsizeWhere"    # Landroid/text/TextUtils$TruncateAt;

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 36
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    .line 37
    iput-object p2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->text:Ljava/lang/String;

    .line 38
    iput p5, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->pixelFormat:I

    .line 39
    iput p6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->hPad:I

    .line 40
    iput-boolean p7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->isCenteredH:Z

    .line 41
    iput p8, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->vPad:I

    .line 42
    iput-boolean p9, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->isCenteredV:Z

    .line 43
    iput-object p10, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->ellipsizeWhere:Landroid/text/TextUtils$TruncateAt;

    .line 45
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p3}, Landroid/text/TextPaint;->setColor(I)V

    .line 46
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p4}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 48
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    if-eqz p7, :cond_0

    sget-object v0, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    :goto_0
    invoke-virtual {v1, v0}, Landroid/text/TextPaint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 49
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setAntiAlias(Z)V

    .line 51
    return-void

    .line 48
    :cond_0
    sget-object v0, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    goto :goto_0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 10
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v4, 0x0

    .line 61
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getClipBounds()Landroid/graphics/Rect;

    move-result-object v0

    .line 62
    .local v0, "cBounds":Landroid/graphics/Rect;
    iget v6, v0, Landroid/graphics/Rect;->left:I

    iget v7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->hPad:I

    add-int/2addr v6, v7

    iput v6, v0, Landroid/graphics/Rect;->left:I

    .line 63
    iget v6, v0, Landroid/graphics/Rect;->right:I

    iget v7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->hPad:I

    sub-int/2addr v6, v7

    iput v6, v0, Landroid/graphics/Rect;->right:I

    .line 64
    iget v6, v0, Landroid/graphics/Rect;->top:I

    iget v7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->vPad:I

    add-int/2addr v6, v7

    iput v6, v0, Landroid/graphics/Rect;->top:I

    .line 65
    iget v6, v0, Landroid/graphics/Rect;->bottom:I

    iget v7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->vPad:I

    sub-int/2addr v6, v7

    iput v6, v0, Landroid/graphics/Rect;->bottom:I

    .line 66
    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 69
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    .line 70
    .local v2, "tBounds":Landroid/graphics/Rect;
    iget-object v6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    iget-object v7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->text:Ljava/lang/String;

    iget-object v8, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->text:Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    invoke-virtual {v6, v7, v4, v8, v2}, Landroid/text/TextPaint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 72
    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->text:Ljava/lang/String;

    .line 75
    .local v3, "textToUse":Ljava/lang/String;
    invoke-virtual {v2}, Landroid/graphics/Rect;->width()I

    move-result v6

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v7

    if-le v6, v7, :cond_0

    .line 76
    iget-object v6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->text:Ljava/lang/String;

    iget-object v7, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v8

    int-to-float v8, v8

    iget-object v9, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->ellipsizeWhere:Landroid/text/TextUtils$TruncateAt;

    invoke-static {v6, v7, v8, v9}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-interface {v6}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    .line 79
    :cond_0
    iget-boolean v6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->isCenteredH:Z

    if-eqz v6, :cond_1

    invoke-virtual {v0}, Landroid/graphics/Rect;->centerX()I

    move-result v4

    .line 81
    .local v4, "x":I
    :cond_1
    iget-object v6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {v6}, Landroid/text/TextPaint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v1

    .line 85
    .local v1, "fm":Landroid/graphics/Paint$FontMetricsInt;
    iget-boolean v6, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->isCenteredV:Z

    if-eqz v6, :cond_2

    invoke-virtual {v0}, Landroid/graphics/Rect;->centerY()I

    move-result v6

    iget v7, v1, Landroid/graphics/Paint$FontMetricsInt;->top:I

    iget v8, v1, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v7, v8

    div-int/lit8 v7, v7, 0x2

    sub-int v5, v6, v7

    .line 90
    .local v5, "y":I
    :goto_0
    int-to-float v6, v4

    int-to-float v7, v5

    iget-object v8, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {p1, v3, v6, v7, v8}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 91
    return-void

    .line 85
    .end local v5    # "y":I
    :cond_2
    iget v6, v1, Landroid/graphics/Paint$FontMetricsInt;->top:I

    neg-int v5, v6

    goto :goto_0
.end method

.method public getOpacity()I
    .locals 1

    .prologue
    .line 105
    iget v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->pixelFormat:I

    return v0
.end method

.method public setAlpha(I)V
    .locals 1
    .param p1, "alpha"    # I

    .prologue
    .line 95
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1}, Landroid/text/TextPaint;->setAlpha(I)V

    .line 96
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 100
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;->paint:Landroid/text/TextPaint;

    invoke-virtual {v0, p1}, Landroid/text/TextPaint;->setColorFilter(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;

    .line 101
    return-void
.end method
