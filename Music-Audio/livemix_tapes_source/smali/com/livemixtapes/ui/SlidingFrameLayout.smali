.class public Lcom/livemixtapes/ui/SlidingFrameLayout;
.super Landroid/widget/FrameLayout;
.source "SlidingFrameLayout.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 10
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 13
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 14
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 17
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 18
    return-void
.end method


# virtual methods
.method public getXFraction()F
    .locals 2

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getWidth()I

    move-result v0

    if-nez v0, :cond_0

    .line 39
    const/4 v0, 0x0

    .line 41
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getTranslationX()F

    move-result v0

    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getWidth()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    goto :goto_0
.end method

.method public getYFraction()F
    .locals 2

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getHeight()I

    move-result v0

    if-nez v0, :cond_0

    .line 27
    const/4 v0, 0x0

    .line 29
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getTranslationY()F

    move-result v0

    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getHeight()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    goto :goto_0
.end method

.method public setXFraction(F)V
    .locals 2
    .param p1, "fraction"    # F

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getWidth()I

    move-result v1

    int-to-float v1, v1

    mul-float v0, v1, p1

    .line 34
    .local v0, "translationX":F
    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->setTranslationX(F)V

    .line 35
    return-void
.end method

.method public setYFraction(F)V
    .locals 2
    .param p1, "fraction"    # F

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->getHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float v0, v1, p1

    .line 22
    .local v0, "translationY":F
    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/SlidingFrameLayout;->setTranslationY(F)V

    .line 23
    return-void
.end method
