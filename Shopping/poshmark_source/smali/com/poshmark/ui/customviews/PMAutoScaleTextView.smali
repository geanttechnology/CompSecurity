.class public Lcom/poshmark/ui/customviews/PMAutoScaleTextView;
.super Landroid/widget/TextView;
.source "PMAutoScaleTextView.java"


# static fields
.field public static final MIN_TEXT_SIZE:F = 5.0f

.field private static final mEllipsis:Ljava/lang/String; = "..."


# instance fields
.field private fontColor:I

.field private fontName:Ljava/lang/String;

.field private mAddEllipsis:Z

.field private mMaxTextSize:F

.field private mMinTextSize:F

.field private mNeedsResize:Z

.field private mSpacingAdd:F

.field private mSpacingMult:F

.field private mTextSize:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 46
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 23
    iput-boolean v3, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mNeedsResize:Z

    .line 30
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mAddEllipsis:Z

    .line 33
    iput v2, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMaxTextSize:F

    .line 36
    const/high16 v1, 0x40a00000    # 5.0f

    iput v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMinTextSize:F

    .line 39
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingMult:F

    .line 42
    iput v2, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingAdd:F

    .line 47
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->PMTextView:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 49
    .local v0, "array":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v3}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->fontColor:I

    .line 51
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->PMCommon:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 52
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->fontName:Ljava/lang/String;

    .line 53
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->fontName:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 54
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->fontName:Ljava/lang/String;

    invoke-static {p1, v1, p0}, Lcom/poshmark/utils/ViewUtils;->setTypefaceForView(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)V

    .line 56
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getTextSize()F

    move-result v1

    iput v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    .line 57
    return-void
.end method

.method private getTextHeight(Ljava/lang/CharSequence;Landroid/text/TextPaint;IF)I
    .locals 8
    .param p1, "source"    # Ljava/lang/CharSequence;
    .param p2, "paint"    # Landroid/text/TextPaint;
    .param p3, "width"    # I
    .param p4, "textSize"    # F

    .prologue
    .line 156
    new-instance v2, Landroid/text/TextPaint;

    invoke-direct {v2, p2}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    .line 158
    .local v2, "paintCopy":Landroid/text/TextPaint;
    invoke-virtual {v2, p4}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 160
    new-instance v0, Landroid/text/StaticLayout;

    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    iget v5, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingMult:F

    iget v6, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingAdd:F

    const/4 v7, 0x1

    move-object v1, p1

    move v3, p3

    invoke-direct/range {v0 .. v7}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    .line 161
    .local v0, "layout":Landroid/text/StaticLayout;
    invoke-virtual {v0}, Landroid/text/StaticLayout;->getHeight()I

    move-result v1

    return v1
.end method


# virtual methods
.method protected onLayout(ZIIII)V
    .locals 4
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 78
    if-nez p1, :cond_0

    iget-boolean v2, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mNeedsResize:Z

    if-eqz v2, :cond_1

    .line 79
    :cond_0
    sub-int v2, p4, p2

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getCompoundPaddingLeft()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getCompoundPaddingRight()I

    move-result v3

    sub-int v1, v2, v3

    .line 80
    .local v1, "widthLimit":I
    sub-int v2, p5, p3

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getCompoundPaddingBottom()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getCompoundPaddingTop()I

    move-result v3

    sub-int v0, v2, v3

    .line 81
    .local v0, "heightLimit":I
    invoke-virtual {p0, v1, v0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->resizeText(II)V

    .line 83
    .end local v0    # "heightLimit":I
    .end local v1    # "widthLimit":I
    :cond_1
    invoke-super/range {p0 .. p5}, Landroid/widget/TextView;->onLayout(ZIIII)V

    .line 84
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 71
    if-ne p1, p3, :cond_0

    if-eq p2, p4, :cond_1

    .line 72
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mNeedsResize:Z

    .line 74
    :cond_1
    return-void
.end method

.method protected onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "after"    # I

    .prologue
    .line 61
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mNeedsResize:Z

    .line 63
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->resetTextSize()V

    .line 64
    return-void
.end method

.method public resetTextSize()V
    .locals 2

    .prologue
    .line 165
    iget v0, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 166
    const/4 v0, 0x0

    iget v1, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    invoke-super {p0, v0, v1}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 167
    iget v0, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    iput v0, p0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMaxTextSize:F

    .line 169
    :cond_0
    return-void
.end method

.method public resizeText(II)V
    .locals 21
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 87
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    .line 89
    .local v5, "text":Ljava/lang/CharSequence;
    if-eqz v5, :cond_0

    invoke-interface {v5}, Ljava/lang/CharSequence;->length()I

    move-result v7

    if-eqz v7, :cond_0

    if-lez p2, :cond_0

    if-lez p1, :cond_0

    move-object/from16 v0, p0

    iget v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    const/4 v8, 0x0

    cmpl-float v7, v7, v8

    if-nez v7, :cond_1

    .line 149
    :cond_0
    :goto_0
    return-void

    .line 94
    :cond_1
    new-instance v20, Landroid/text/TextPaint;

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v7

    move-object/from16 v0, v20

    invoke-direct {v0, v7}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    .line 97
    .local v20, "textPaint":Landroid/text/TextPaint;
    invoke-virtual/range {v20 .. v20}, Landroid/text/TextPaint;->getTextSize()F

    move-result v16

    .line 99
    .local v16, "oldTextSize":F
    move-object/from16 v0, p0

    iget v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMaxTextSize:F

    const/4 v8, 0x0

    cmpl-float v7, v7, v8

    if-lez v7, :cond_2

    move-object/from16 v0, p0

    iget v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    move-object/from16 v0, p0

    iget v8, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMaxTextSize:F

    invoke-static {v7, v8}, Ljava/lang/Math;->min(FF)F

    move-result v18

    .line 102
    .local v18, "targetTextSize":F
    :goto_1
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move/from16 v2, p1

    move/from16 v3, v18

    invoke-direct {v0, v5, v1, v2, v3}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getTextHeight(Ljava/lang/CharSequence;Landroid/text/TextPaint;IF)I

    move-result v19

    .line 105
    .local v19, "textHeight":I
    :goto_2
    move/from16 v0, v19

    move/from16 v1, p2

    if-le v0, v1, :cond_3

    move-object/from16 v0, p0

    iget v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMinTextSize:F

    cmpl-float v7, v18, v7

    if-lez v7, :cond_3

    .line 106
    const/high16 v7, 0x40000000    # 2.0f

    sub-float v7, v18, v7

    move-object/from16 v0, p0

    iget v8, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMinTextSize:F

    invoke-static {v7, v8}, Ljava/lang/Math;->max(FF)F

    move-result v18

    .line 107
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move/from16 v2, p1

    move/from16 v3, v18

    invoke-direct {v0, v5, v1, v2, v3}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->getTextHeight(Ljava/lang/CharSequence;Landroid/text/TextPaint;IF)I

    move-result v19

    goto :goto_2

    .line 99
    .end local v18    # "targetTextSize":F
    .end local v19    # "textHeight":I
    :cond_2
    move-object/from16 v0, p0

    iget v0, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mTextSize:F

    move/from16 v18, v0

    goto :goto_1

    .line 111
    .restart local v18    # "targetTextSize":F
    .restart local v19    # "textHeight":I
    :cond_3
    move-object/from16 v0, p0

    iget-boolean v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mAddEllipsis:Z

    if-eqz v7, :cond_4

    move-object/from16 v0, p0

    iget v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mMinTextSize:F

    cmpl-float v7, v18, v7

    if-nez v7, :cond_4

    move/from16 v0, v19

    move/from16 v1, p2

    if-le v0, v1, :cond_4

    .line 114
    new-instance v6, Landroid/text/TextPaint;

    move-object/from16 v0, v20

    invoke-direct {v6, v0}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    .line 116
    .local v6, "paint":Landroid/text/TextPaint;
    new-instance v4, Landroid/text/StaticLayout;

    sget-object v8, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    move-object/from16 v0, p0

    iget v9, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingMult:F

    move-object/from16 v0, p0

    iget v10, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingAdd:F

    const/4 v11, 0x0

    move/from16 v7, p1

    invoke-direct/range {v4 .. v11}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    .line 118
    .local v4, "layout":Landroid/text/StaticLayout;
    invoke-virtual {v4}, Landroid/text/StaticLayout;->getLineCount()I

    move-result v7

    if-lez v7, :cond_4

    .line 121
    move/from16 v0, p2

    invoke-virtual {v4, v0}, Landroid/text/StaticLayout;->getLineForVertical(I)I

    move-result v7

    add-int/lit8 v14, v7, -0x1

    .line 123
    .local v14, "lastLine":I
    if-gez v14, :cond_5

    .line 124
    const-string v7, ""

    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->setText(Ljava/lang/CharSequence;)V

    .line 144
    .end local v4    # "layout":Landroid/text/StaticLayout;
    .end local v6    # "paint":Landroid/text/TextPaint;
    .end local v14    # "lastLine":I
    :cond_4
    :goto_3
    const/4 v7, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v7, v1}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->setTextSize(IF)V

    .line 145
    move-object/from16 v0, p0

    iget v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingAdd:F

    move-object/from16 v0, p0

    iget v8, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mSpacingMult:F

    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v8}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->setLineSpacing(FF)V

    .line 148
    const/4 v7, 0x0

    move-object/from16 v0, p0

    iput-boolean v7, v0, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->mNeedsResize:Z

    goto/16 :goto_0

    .line 128
    .restart local v4    # "layout":Landroid/text/StaticLayout;
    .restart local v6    # "paint":Landroid/text/TextPaint;
    .restart local v14    # "lastLine":I
    :cond_5
    invoke-virtual {v4, v14}, Landroid/text/StaticLayout;->getLineStart(I)I

    move-result v17

    .line 129
    .local v17, "start":I
    invoke-virtual {v4, v14}, Landroid/text/StaticLayout;->getLineEnd(I)I

    move-result v13

    .line 130
    .local v13, "end":I
    invoke-virtual {v4, v14}, Landroid/text/StaticLayout;->getLineWidth(I)F

    move-result v15

    .line 131
    .local v15, "lineWidth":F
    const-string v7, "..."

    move-object/from16 v0, v20

    invoke-virtual {v0, v7}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v12

    .line 134
    .local v12, "ellipseWidth":F
    :goto_4
    move/from16 v0, p1

    int-to-float v7, v0

    add-float v8, v15, v12

    cmpg-float v7, v7, v8

    if-gez v7, :cond_6

    .line 135
    add-int/lit8 v13, v13, -0x1

    add-int/lit8 v7, v13, 0x1

    move/from16 v0, v17

    invoke-interface {v5, v0, v7}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v20

    invoke-virtual {v0, v7}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v15

    goto :goto_4

    .line 137
    :cond_6
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v8, 0x0

    invoke-interface {v5, v8, v13}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "..."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method
