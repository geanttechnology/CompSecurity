.class public Lcom/wishabi/flipp/widget/RatingView;
.super Landroid/view/View;
.source "SourceFile"


# instance fields
.field private a:Landroid/graphics/drawable/Drawable;

.field private b:Landroid/graphics/drawable/Drawable;

.field private c:Landroid/graphics/drawable/Drawable;

.field private d:I

.field private e:I

.field private f:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 24
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lcom/wishabi/flipp/widget/RatingView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 25
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/RatingView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 32
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 34
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/RatingView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 35
    if-nez v0, :cond_1

    .line 54
    :cond_0
    :goto_0
    return-void

    .line 38
    :cond_1
    const v1, 0x7f0200c1

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/widget/RatingView;->a:Landroid/graphics/drawable/Drawable;

    .line 39
    const v1, 0x7f0200c2

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Lcom/wishabi/flipp/widget/RatingView;->b:Landroid/graphics/drawable/Drawable;

    .line 40
    const v1, 0x7f0200c3

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/widget/RatingView;->c:Landroid/graphics/drawable/Drawable;

    .line 42
    const/high16 v0, 0x41400000    # 12.0f

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/RatingView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v3, v0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    .line 44
    const/high16 v0, 0x40000000    # 2.0f

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/RatingView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    invoke-static {v3, v0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Lcom/wishabi/flipp/widget/RatingView;->e:I

    .line 47
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/RatingView;->isInEditMode()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 48
    const/4 v0, 0x7

    iput v0, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    .line 50
    :cond_2
    sget-object v0, Lcom/wishabi/flipp/b;->RatingView:[I

    invoke-virtual {p1, p2, v0, p3, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 52
    if-eqz v0, :cond_0

    .line 53
    invoke-virtual {v0, v2, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    goto :goto_0
.end method


# virtual methods
.method public getRating()I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 9

    .prologue
    const/4 v1, 0x0

    .line 65
    .line 66
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/RatingView;->getHeight()I

    move-result v0

    iget v2, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    sub-int/2addr v0, v2

    div-int/lit8 v4, v0, 0x2

    .line 68
    iget v0, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    shr-int/lit8 v5, v0, 0x1

    move v2, v1

    move v0, v1

    :goto_0
    if-ge v2, v5, :cond_0

    .line 69
    iget-object v3, p0, Lcom/wishabi/flipp/widget/RatingView;->a:Landroid/graphics/drawable/Drawable;

    iget v6, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    add-int/2addr v6, v0

    iget v7, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    add-int/2addr v7, v4

    invoke-virtual {v3, v0, v4, v6, v7}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 70
    iget-object v3, p0, Lcom/wishabi/flipp/widget/RatingView;->a:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 71
    iget v3, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    iget v6, p0, Lcom/wishabi/flipp/widget/RatingView;->e:I

    add-int/2addr v3, v6

    add-int/2addr v3, v0

    .line 68
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    move v0, v3

    goto :goto_0

    .line 74
    :cond_0
    iget v2, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    and-int/lit8 v2, v2, 0x1

    if-eqz v2, :cond_1

    .line 75
    iget-object v2, p0, Lcom/wishabi/flipp/widget/RatingView;->b:Landroid/graphics/drawable/Drawable;

    iget v3, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    add-int/2addr v3, v0

    iget v5, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    add-int/2addr v5, v4

    invoke-virtual {v2, v0, v4, v3, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 76
    iget-object v2, p0, Lcom/wishabi/flipp/widget/RatingView;->b:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 77
    iget v2, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    iget v3, p0, Lcom/wishabi/flipp/widget/RatingView;->e:I

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 80
    :cond_1
    iget v2, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    rsub-int/lit8 v2, v2, 0xa

    shr-int/lit8 v2, v2, 0x1

    move v8, v1

    move v1, v0

    move v0, v8

    :goto_1
    if-ge v0, v2, :cond_2

    .line 81
    iget-object v3, p0, Lcom/wishabi/flipp/widget/RatingView;->c:Landroid/graphics/drawable/Drawable;

    iget v5, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    add-int/2addr v5, v1

    iget v6, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    add-int/2addr v6, v4

    invoke-virtual {v3, v1, v4, v5, v6}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 82
    iget-object v3, p0, Lcom/wishabi/flipp/widget/RatingView;->c:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 83
    iget v3, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    iget v5, p0, Lcom/wishabi/flipp/widget/RatingView;->e:I

    add-int/2addr v3, v5

    add-int/2addr v1, v3

    .line 80
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 85
    :cond_2
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2

    .prologue
    .line 58
    iget v0, p0, Lcom/wishabi/flipp/widget/RatingView;->d:I

    mul-int/lit8 v0, v0, 0x5

    iget v1, p0, Lcom/wishabi/flipp/widget/RatingView;->e:I

    mul-int/lit8 v1, v1, 0x4

    add-int/2addr v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    invoke-super {p0, v0, p2}, Landroid/view/View;->onMeasure(II)V

    .line 61
    return-void
.end method

.method public setRating(I)V
    .locals 0

    .prologue
    .line 92
    iput p1, p0, Lcom/wishabi/flipp/widget/RatingView;->f:I

    .line 93
    return-void
.end method
