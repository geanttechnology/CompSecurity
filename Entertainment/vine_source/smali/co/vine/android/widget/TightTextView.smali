.class public Lco/vine/android/widget/TightTextView;
.super Lco/vine/android/widget/TypefacesTextView;
.source "TightTextView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lco/vine/android/widget/TightTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/TightTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 29
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/widget/TypefacesTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 7
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 34
    invoke-super {p0, p1, p2}, Lco/vine/android/widget/TypefacesTextView;->onMeasure(II)V

    .line 35
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v3

    .line 36
    .local v3, "specModeW":I
    const/high16 v6, 0x40000000    # 2.0f

    if-eq v3, v6, :cond_1

    .line 37
    invoke-virtual {p0}, Lco/vine/android/widget/TightTextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 38
    .local v0, "layout":Landroid/text/Layout;
    invoke-virtual {v0}, Landroid/text/Layout;->getLineCount()I

    move-result v1

    .line 39
    .local v1, "linesCount":I
    const/4 v6, 0x1

    if-le v1, v6, :cond_1

    .line 40
    const/4 v4, 0x0

    .line 41
    .local v4, "textRealMaxWidth":F
    const/4 v2, 0x0

    .local v2, "n":I
    :goto_0
    if-ge v2, v1, :cond_0

    .line 42
    invoke-virtual {v0, v2}, Landroid/text/Layout;->getLineWidth(I)F

    move-result v6

    invoke-static {v4, v6}, Ljava/lang/Math;->max(FF)F

    move-result v4

    .line 41
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 44
    :cond_0
    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v5

    .line 45
    .local v5, "w":I
    invoke-virtual {p0}, Lco/vine/android/widget/TightTextView;->getMeasuredWidth()I

    move-result v6

    if-ge v5, v6, :cond_1

    .line 46
    const/high16 v6, -0x80000000

    invoke-static {v5, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-super {p0, v6, p2}, Lco/vine/android/widget/TypefacesTextView;->onMeasure(II)V

    .line 51
    .end local v0    # "layout":Landroid/text/Layout;
    .end local v1    # "linesCount":I
    .end local v2    # "n":I
    .end local v4    # "textRealMaxWidth":F
    .end local v5    # "w":I
    :cond_1
    return-void
.end method
