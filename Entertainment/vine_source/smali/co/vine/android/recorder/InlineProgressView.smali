.class public Lco/vine/android/recorder/InlineProgressView;
.super Lco/vine/android/recorder/ProgressView;
.source "InlineProgressView.java"


# instance fields
.field final mRect:Landroid/graphics/RectF;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 16
    invoke-direct {p0, p1}, Lco/vine/android/recorder/ProgressView;-><init>(Landroid/content/Context;)V

    .line 13
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lco/vine/android/recorder/InlineProgressView;->mRect:Landroid/graphics/RectF;

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 20
    invoke-direct {p0, p1, p2}, Lco/vine/android/recorder/ProgressView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 13
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lco/vine/android/recorder/InlineProgressView;->mRect:Landroid/graphics/RectF;

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x0

    .line 24
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/recorder/ProgressView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 13
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/RectF;-><init>(FFFF)V

    iput-object v0, p0, Lco/vine/android/recorder/InlineProgressView;->mRect:Landroid/graphics/RectF;

    .line 25
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 29
    iget v3, p0, Lco/vine/android/recorder/InlineProgressView;->mProgressRatio:F

    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-lez v3, :cond_0

    .line 30
    invoke-virtual {p0}, Lco/vine/android/recorder/InlineProgressView;->getMeasuredHeight()I

    move-result v0

    .line 31
    .local v0, "height":I
    invoke-virtual {p0}, Lco/vine/android/recorder/InlineProgressView;->getMeasuredWidth()I

    move-result v2

    .line 32
    .local v2, "width":I
    div-int/lit8 v1, v0, 0x2

    .line 33
    .local v1, "radius":I
    iget-object v3, p0, Lco/vine/android/recorder/InlineProgressView;->mRect:Landroid/graphics/RectF;

    iget v4, p0, Lco/vine/android/recorder/InlineProgressView;->mProgressRatio:F

    int-to-float v5, v2

    mul-float/2addr v4, v5

    iput v4, v3, Landroid/graphics/RectF;->right:F

    .line 34
    iget-object v3, p0, Lco/vine/android/recorder/InlineProgressView;->mRect:Landroid/graphics/RectF;

    int-to-float v4, v0

    iput v4, v3, Landroid/graphics/RectF;->bottom:F

    .line 35
    iget-object v3, p0, Lco/vine/android/recorder/InlineProgressView;->mRect:Landroid/graphics/RectF;

    int-to-float v4, v1

    int-to-float v5, v1

    iget-object v6, p0, Lco/vine/android/recorder/InlineProgressView;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v4, v5, v6}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 37
    .end local v0    # "height":I
    .end local v1    # "radius":I
    .end local v2    # "width":I
    :cond_0
    return-void
.end method
