.class public Lcom/aio/downloader/views/LDialogLayout;
.super Landroid/widget/LinearLayout;
.source "LDialogLayout.java"


# instance fields
.field private mMaxWidthWeight:F

.field private mMinWidthWeight:F

.field private metrics:Landroid/util/DisplayMetrics;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 10
    const v0, 0x3f666666    # 0.9f

    iput v0, p0, Lcom/aio/downloader/views/LDialogLayout;->mMaxWidthWeight:F

    .line 11
    const v0, 0x3f0ccccd    # 0.55f

    iput v0, p0, Lcom/aio/downloader/views/LDialogLayout;->mMinWidthWeight:F

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 10
    const v0, 0x3f666666    # 0.9f

    iput v0, p0, Lcom/aio/downloader/views/LDialogLayout;->mMaxWidthWeight:F

    .line 11
    const v0, 0x3f0ccccd    # 0.55f

    iput v0, p0, Lcom/aio/downloader/views/LDialogLayout;->mMinWidthWeight:F

    .line 21
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDialogLayout;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/views/LDialogLayout;->metrics:Landroid/util/DisplayMetrics;

    .line 22
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 27
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogLayout;->metrics:Landroid/util/DisplayMetrics;

    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v2, p0, Lcom/aio/downloader/views/LDialogLayout;->metrics:Landroid/util/DisplayMetrics;

    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    if-ge v1, v2, :cond_0

    iget v0, p0, Lcom/aio/downloader/views/LDialogLayout;->mMaxWidthWeight:F

    .line 30
    .local v0, "widthWeight":F
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogLayout;->metrics:Landroid/util/DisplayMetrics;

    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v1, v1

    mul-float/2addr v1, v0

    float-to-int v1, v1

    const/high16 v2, 0x40000000    # 2.0f

    .line 29
    invoke-static {v1, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    .line 32
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    .line 37
    return-void

    .line 28
    .end local v0    # "widthWeight":F
    :cond_0
    iget v0, p0, Lcom/aio/downloader/views/LDialogLayout;->mMinWidthWeight:F

    goto :goto_0
.end method
