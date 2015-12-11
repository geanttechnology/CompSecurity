.class public Lcom/wishabi/flipp/widget/SlidingFrameLayout;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 13
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 21
    return-void
.end method


# virtual methods
.method public getXFraction()F
    .locals 2

    .prologue
    .line 28
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getWidth()I

    move-result v0

    if-nez v0, :cond_0

    .line 29
    const/4 v0, 0x0

    .line 31
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getTranslationX()F

    move-result v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getWidth()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    goto :goto_0
.end method

.method public getYFraction()F
    .locals 2

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getHeight()I

    move-result v0

    if-nez v0, :cond_0

    .line 40
    const/4 v0, 0x0

    .line 42
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getTranslationY()F

    move-result v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getHeight()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    goto :goto_0
.end method

.method public setXFraction(F)V
    .locals 1

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, p1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->setTranslationX(F)V

    .line 25
    return-void
.end method

.method public setYFraction(F)V
    .locals 1

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->getHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, p1

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/SlidingFrameLayout;->setTranslationY(F)V

    .line 36
    return-void
.end method
