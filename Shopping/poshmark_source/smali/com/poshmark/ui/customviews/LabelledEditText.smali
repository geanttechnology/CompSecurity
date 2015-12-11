.class public Lcom/poshmark/ui/customviews/LabelledEditText;
.super Lcom/poshmark/ui/customviews/PMEditText;
.source "LabelledEditText.java"


# instance fields
.field private labelText:Ljava/lang/String;

.field private labelTextWidth:F

.field private paddingLeft:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    .line 20
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->LabelledEditText:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 23
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    .line 24
    const/4 v1, 0x1

    invoke-virtual {v0, v1, v3}, Landroid/content/res/TypedArray;->getDimension(IF)F

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelTextWidth:F

    .line 25
    iget-object v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 26
    const-string v1, ""

    iput-object v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    .line 27
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getPaddingLeft()I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->paddingLeft:I

    .line 29
    iget v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelTextWidth:F

    cmpl-float v1, v1, v3

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 30
    const/high16 v1, 0x42c80000    # 100.0f

    invoke-static {p1, v1}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelTextWidth:F

    .line 32
    :cond_1
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 33
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 36
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getPaint()Landroid/text/TextPaint;

    move-result-object v1

    .line 38
    .local v1, "textPaint":Landroid/text/TextPaint;
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 39
    .local v0, "size":Landroid/graphics/Rect;
    iget-object v2, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/text/TextPaint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    .line 40
    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-float v2, v2

    iget v3, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelTextWidth:F

    cmpl-float v2, v2, v3

    if-lez v2, :cond_0

    .line 41
    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelTextWidth:F

    .line 43
    :cond_0
    iget v2, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->paddingLeft:I

    iget v3, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelTextWidth:F

    float-to-int v3, v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getPaddingTop()I

    move-result v3

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getPaddingRight()I

    move-result v4

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getPaddingBottom()I

    move-result v5

    invoke-virtual {p0, v2, v3, v4, v5}, Lcom/poshmark/ui/customviews/LabelledEditText;->setPadding(IIII)V

    .line 45
    invoke-super {p0, p1}, Lcom/poshmark/ui/customviews/PMEditText;->onDraw(Landroid/graphics/Canvas;)V

    .line 47
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    const/high16 v3, 0x41600000    # 14.0f

    invoke-static {v2, v3}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v2

    invoke-virtual {v1, v2}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 48
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090039

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/text/TextPaint;->setColor(I)V

    .line 49
    iget-object v2, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->labelText:Ljava/lang/String;

    iget v3, p0, Lcom/poshmark/ui/customviews/LabelledEditText;->paddingLeft:I

    int-to-float v3, v3

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v4

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/LabelledEditText;->getPaddingTop()I

    move-result v5

    add-int/2addr v4, v5

    int-to-float v4, v4

    invoke-virtual {p1, v2, v3, v4, v1}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 50
    return-void
.end method

.method protected onMeasure(II)V
    .locals 0
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 53
    invoke-super {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMEditText;->onMeasure(II)V

    .line 54
    return-void
.end method
