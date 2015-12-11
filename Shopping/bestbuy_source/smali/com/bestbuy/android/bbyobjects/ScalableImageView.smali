.class public Lcom/bestbuy/android/bbyobjects/ScalableImageView;
.super Landroid/widget/ImageView;
.source "SourceFile"


# instance fields
.field public a:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 9
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->a:Z

    .line 13
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 9
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->a:Z

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 9
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->a:Z

    .line 21
    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 26
    :try_start_0
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 28
    if-nez v0, :cond_0

    .line 29
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->setMeasuredDimension(II)V

    .line 40
    :goto_0
    return-void

    .line 31
    :cond_0
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v1

    .line 32
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    mul-int/2addr v2, v1

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    div-int v0, v2, v0

    .line 34
    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->setMeasuredDimension(II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 36
    :catch_0
    move-exception v0

    .line 37
    iput-boolean v3, p0, Lcom/bestbuy/android/bbyobjects/ScalableImageView;->a:Z

    .line 38
    invoke-super {p0, p1, p2}, Landroid/widget/ImageView;->onMeasure(II)V

    goto :goto_0
.end method
