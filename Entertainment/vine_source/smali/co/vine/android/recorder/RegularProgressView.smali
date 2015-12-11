.class public Lco/vine/android/recorder/RegularProgressView;
.super Lco/vine/android/recorder/ProgressView;
.source "RegularProgressView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Lco/vine/android/recorder/ProgressView;-><init>(Landroid/content/Context;)V

    .line 14
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lco/vine/android/recorder/ProgressView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/recorder/ProgressView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 22
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    .line 26
    invoke-super {p0, p1}, Lco/vine/android/recorder/ProgressView;->onDraw(Landroid/graphics/Canvas;)V

    .line 27
    iget v0, p0, Lco/vine/android/recorder/RegularProgressView;->mProgressRatio:F

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 28
    iget v0, p0, Lco/vine/android/recorder/RegularProgressView;->mProgressRatio:F

    invoke-virtual {p0}, Lco/vine/android/recorder/RegularProgressView;->getMeasuredWidth()I

    move-result v2

    int-to-float v2, v2

    mul-float v3, v0, v2

    invoke-virtual {p0}, Lco/vine/android/recorder/RegularProgressView;->getMeasuredHeight()I

    move-result v0

    int-to-float v4, v0

    iget-object v5, p0, Lco/vine/android/recorder/RegularProgressView;->mPaint:Landroid/graphics/Paint;

    move-object v0, p1

    move v2, v1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 30
    :cond_0
    return-void
.end method
