.class public Lco/vine/android/widget/ColorPicker;
.super Landroid/view/ViewGroup;
.source "ColorPicker.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/ColorPicker$ColorClickListener;
    }
.end annotation


# instance fields
.field private mCircleWidth:I

.field private mColorClickListener:Lco/vine/android/widget/ColorPicker$ColorClickListener;

.field private mLineCount:I

.field private mMinPadding:I

.field private mSelected:Lco/vine/android/widget/ColorPickerCircle;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/ColorPicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/ColorPicker;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 40
    .local v0, "res":Landroid/content/res/Resources;
    const v1, 0x7f0b001f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    iput v1, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    .line 41
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 104
    move-object v0, p1

    check-cast v0, Lco/vine/android/widget/ColorPickerCircle;

    .line 105
    .local v0, "c":Lco/vine/android/widget/ColorPickerCircle;
    iget-object v1, p0, Lco/vine/android/widget/ColorPicker;->mSelected:Lco/vine/android/widget/ColorPickerCircle;

    if-eqz v1, :cond_0

    .line 106
    iget-object v1, p0, Lco/vine/android/widget/ColorPicker;->mSelected:Lco/vine/android/widget/ColorPickerCircle;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lco/vine/android/widget/ColorPickerCircle;->setSelected(Z)V

    .line 108
    :cond_0
    iput-object v0, p0, Lco/vine/android/widget/ColorPicker;->mSelected:Lco/vine/android/widget/ColorPickerCircle;

    .line 109
    iget-object v1, p0, Lco/vine/android/widget/ColorPicker;->mSelected:Lco/vine/android/widget/ColorPickerCircle;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lco/vine/android/widget/ColorPickerCircle;->setSelected(Z)V

    .line 111
    iget-object v1, p0, Lco/vine/android/widget/ColorPicker;->mColorClickListener:Lco/vine/android/widget/ColorPicker$ColorClickListener;

    if-nez v1, :cond_1

    .line 115
    :goto_0
    return-void

    .line 114
    :cond_1
    iget-object v1, p0, Lco/vine/android/widget/ColorPicker;->mColorClickListener:Lco/vine/android/widget/ColorPicker$ColorClickListener;

    invoke-virtual {v0}, Lco/vine/android/widget/ColorPickerCircle;->getIndex()I

    move-result v2

    invoke-interface {v1, v2}, Lco/vine/android/widget/ColorPicker$ColorClickListener;->onColorClick(I)V

    goto :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 11
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 69
    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    mul-int/lit8 v6, v8, 0x2

    .line 70
    .local v6, "top":I
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPicker;->getMeasuredWidth()I

    move-result v7

    .line 73
    .local v7, "width":I
    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mLineCount:I

    iget v9, p0, Lco/vine/android/widget/ColorPicker;->mCircleWidth:I

    iget v10, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    add-int/2addr v9, v10

    mul-int/2addr v8, v9

    sub-int v8, v7, v8

    div-int/lit8 v4, v8, 0x2

    .line 74
    .local v4, "leftPadding":I
    move v3, v4

    .line 76
    .local v3, "left":I
    const/4 v5, 0x0

    .line 77
    .local v5, "newline":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPicker;->getChildCount()I

    move-result v8

    if-ge v1, v8, :cond_1

    .line 78
    move v2, v1

    .line 79
    .local v2, "index":I
    invoke-virtual {p0, v1}, Lco/vine/android/widget/ColorPicker;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/widget/ColorPickerCircle;

    .line 80
    .local v0, "circle":Lco/vine/android/widget/ColorPickerCircle;
    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mCircleWidth:I

    add-int/2addr v8, v3

    iget v9, p0, Lco/vine/android/widget/ColorPicker;->mCircleWidth:I

    add-int/2addr v9, v6

    invoke-virtual {v0, v3, v6, v8, v9}, Lco/vine/android/widget/ColorPickerCircle;->layout(IIII)V

    .line 81
    new-instance v8, Lco/vine/android/widget/ColorPicker$1;

    invoke-direct {v8, p0, v0, v2}, Lco/vine/android/widget/ColorPicker$1;-><init>(Lco/vine/android/widget/ColorPicker;Lco/vine/android/widget/ColorPickerCircle;I)V

    invoke-virtual {v0, v8}, Lco/vine/android/widget/ColorPickerCircle;->post(Ljava/lang/Runnable;)Z

    .line 87
    invoke-virtual {v0, p0}, Lco/vine/android/widget/ColorPickerCircle;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 88
    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mCircleWidth:I

    iget v9, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    add-int/2addr v8, v9

    add-int/2addr v3, v8

    .line 90
    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mLineCount:I

    add-int/lit8 v8, v8, -0x1

    if-lt v1, v8, :cond_0

    if-nez v5, :cond_0

    .line 91
    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mCircleWidth:I

    iget v9, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    add-int/2addr v8, v9

    add-int/2addr v6, v8

    .line 92
    move v3, v4

    .line 93
    const/4 v5, 0x1

    .line 77
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 96
    .end local v0    # "circle":Lco/vine/android/widget/ColorPickerCircle;
    .end local v2    # "index":I
    :cond_1
    return-void
.end method

.method protected onMeasure(II)V
    .locals 10
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/high16 v9, 0x40000000    # 2.0f

    .line 45
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onMeasure(II)V

    .line 46
    sget-object v7, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    array-length v1, v7

    .line 49
    .local v1, "count":I
    div-int/lit8 v5, v1, 0x2

    .line 50
    .local v5, "lineCount":I
    iput v5, p0, Lco/vine/android/widget/ColorPicker;->mLineCount:I

    .line 52
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPicker;->getMeasuredWidth()I

    move-result v6

    .line 53
    .local v6, "thisWidth":I
    div-int v7, v6, v5

    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    mul-int/lit8 v8, v8, 0x2

    sub-int v2, v7, v8

    .line 54
    .local v2, "eachWidth":I
    mul-int/lit8 v7, v2, 0x2

    iget v8, p0, Lco/vine/android/widget/ColorPicker;->mMinPadding:I

    mul-int/lit8 v8, v8, 0x4

    add-int v3, v7, v8

    .line 56
    .local v3, "height":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPicker;->getChildCount()I

    move-result v7

    if-ge v4, v7, :cond_0

    .line 57
    invoke-virtual {p0, v4}, Lco/vine/android/widget/ColorPicker;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 58
    .local v0, "child":Landroid/view/View;
    invoke-static {v2, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v7

    invoke-static {v2, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-virtual {p0, v0, v7, v8}, Lco/vine/android/widget/ColorPicker;->measureChild(Landroid/view/View;II)V

    .line 56
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 63
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    iput v2, p0, Lco/vine/android/widget/ColorPicker;->mCircleWidth:I

    .line 64
    invoke-virtual {p0, v6, v3}, Lco/vine/android/widget/ColorPicker;->setMeasuredDimension(II)V

    .line 65
    return-void
.end method

.method public setColorIndex(I)V
    .locals 4
    .param p1, "index"    # I

    .prologue
    .line 118
    if-ltz p1, :cond_1

    invoke-virtual {p0}, Lco/vine/android/widget/ColorPicker;->getChildCount()I

    move-result v2

    if-ge p1, v2, :cond_1

    .line 119
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/widget/ColorPicker;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 120
    if-ne p1, v1, :cond_0

    .line 121
    invoke-virtual {p0, p1}, Lco/vine/android/widget/ColorPicker;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 122
    .local v0, "child":Landroid/view/View;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/view/View;->setSelected(Z)V

    .line 123
    check-cast v0, Lco/vine/android/widget/ColorPickerCircle;

    .end local v0    # "child":Landroid/view/View;
    iput-object v0, p0, Lco/vine/android/widget/ColorPicker;->mSelected:Lco/vine/android/widget/ColorPickerCircle;

    .line 119
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 125
    :cond_0
    invoke-virtual {p0, v1}, Lco/vine/android/widget/ColorPicker;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setSelected(Z)V

    goto :goto_1

    .line 129
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method public setOnColorClickListener(Lco/vine/android/widget/ColorPicker$ColorClickListener;)V
    .locals 0
    .param p1, "ccl"    # Lco/vine/android/widget/ColorPicker$ColorClickListener;

    .prologue
    .line 99
    iput-object p1, p0, Lco/vine/android/widget/ColorPicker;->mColorClickListener:Lco/vine/android/widget/ColorPicker$ColorClickListener;

    .line 100
    return-void
.end method
