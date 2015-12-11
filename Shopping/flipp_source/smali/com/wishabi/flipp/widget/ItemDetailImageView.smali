.class public Lcom/wishabi/flipp/widget/ItemDetailImageView;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field private final a:Landroid/widget/ImageView;

.field private final b:Landroid/widget/ProgressBar;

.field private c:Ljava/lang/String;

.field private d:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 29
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4

    .prologue
    const/4 v2, -0x1

    const/4 v3, -0x2

    .line 34
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 22
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->d:F

    .line 36
    new-instance v0, Landroid/widget/ImageView;

    invoke-direct {v0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a:Landroid/widget/ImageView;

    .line 37
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a:Landroid/widget/ImageView;

    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a:Landroid/widget/ImageView;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->addView(Landroid/view/View;)V

    .line 42
    new-instance v0, Landroid/widget/ProgressBar;

    invoke-direct {v0, p1}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->b:Landroid/widget/ProgressBar;

    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->b:Landroid/widget/ProgressBar;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    .line 44
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->b:Landroid/widget/ProgressBar;

    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v2, 0x11

    invoke-direct {v1, v3, v3, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 47
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->b:Landroid/widget/ProgressBar;

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->addView(Landroid/view/View;)V

    .line 48
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/widget/ItemDetailImageView;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->b:Landroid/widget/ProgressBar;

    return-object v0
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 5

    .prologue
    const/high16 v4, 0x40000000    # 2.0f

    .line 81
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 82
    iget-object v1, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a:Landroid/widget/ImageView;

    invoke-virtual {v1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 83
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 84
    :cond_0
    iget v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->d:F

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v0, v1

    float-to-int v0, v0

    invoke-static {v0, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 87
    invoke-super {p0, p1, v0}, Landroid/widget/FrameLayout;->onMeasure(II)V

    .line 100
    :goto_0
    return-void

    .line 91
    :cond_1
    const/4 v2, 0x1

    const/high16 v3, 0x43a00000    # 320.0f

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v2, v3, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    .line 93
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 94
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    .line 95
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    .line 96
    mul-int/2addr v1, v3

    div-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 97
    invoke-static {v0, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 99
    invoke-super {p0, p1, v0}, Landroid/widget/FrameLayout;->onMeasure(II)V

    goto :goto_0
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 56
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->c:Ljava/lang/String;

    if-nez v0, :cond_0

    if-eqz p1, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->c:Ljava/lang/String;

    if-eqz v0, :cond_2

    if-eqz p1, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->c:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 77
    :cond_1
    :goto_0
    return-void

    .line 60
    :cond_2
    iput-object p1, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->c:Ljava/lang/String;

    .line 61
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 62
    if-eqz p1, :cond_1

    .line 63
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/a/b/ad;->a(Landroid/content/Context;)Lcom/a/b/ad;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/a/b/ad;->a(Ljava/lang/String;)Lcom/a/b/aq;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->a:Landroid/widget/ImageView;

    new-instance v2, Lcom/wishabi/flipp/widget/cg;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/widget/cg;-><init>(Lcom/wishabi/flipp/widget/ItemDetailImageView;)V

    invoke-virtual {v0, v1, v2}, Lcom/a/b/aq;->a(Landroid/widget/ImageView;Lcom/a/b/j;)V

    goto :goto_0
.end method

.method public setRatio(F)V
    .locals 0

    .prologue
    .line 51
    iput p1, p0, Lcom/wishabi/flipp/widget/ItemDetailImageView;->d:F

    .line 52
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ItemDetailImageView;->requestLayout()V

    .line 53
    return-void
.end method
