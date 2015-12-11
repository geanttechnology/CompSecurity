.class public Lcom/aio/downloader/utils/OverScrollWarpLayout;
.super Landroid/widget/LinearLayout;
.source "OverScrollWarpLayout.java"


# static fields
.field private static final OVERSHOOT_TENSION:F = 0.75f


# instance fields
.field private mScroller:Landroid/widget/Scroller;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 30
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->setOrientation(I)V

    .line 32
    new-instance v0, Landroid/widget/Scroller;

    invoke-virtual {p0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Landroid/view/animation/OvershootInterpolator;

    const/high16 v3, 0x3f400000    # 0.75f

    invoke-direct {v2, v3}, Landroid/view/animation/OvershootInterpolator;-><init>(F)V

    invoke-direct {v0, v1, v2}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    iput-object v0, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    .line 33
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attr"    # Landroid/util/AttributeSet;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 23
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->setOrientation(I)V

    .line 25
    new-instance v0, Landroid/widget/Scroller;

    invoke-virtual {p0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Landroid/view/animation/OvershootInterpolator;

    const/high16 v3, 0x3f400000    # 0.75f

    invoke-direct {v2, v3}, Landroid/view/animation/OvershootInterpolator;-><init>(F)V

    invoke-direct {v0, v1, v2}, Landroid/widget/Scroller;-><init>(Landroid/content/Context;Landroid/view/animation/Interpolator;)V

    iput-object v0, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    .line 26
    return-void
.end method


# virtual methods
.method public computeScroll()V
    .locals 2

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->computeScrollOffset()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->getCurrX()I

    move-result v0

    iget-object v1, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v1}, Landroid/widget/Scroller;->getCurrY()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->scrollTo(II)V

    .line 61
    invoke-virtual {p0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->postInvalidate()V

    .line 63
    :cond_0
    invoke-super {p0}, Landroid/widget/LinearLayout;->computeScroll()V

    .line 64
    return-void
.end method

.method public final getScrollerCurrY()I
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v0}, Landroid/widget/Scroller;->getCurrY()I

    move-result v0

    return v0
.end method

.method public smoothScrollBy(II)V
    .locals 3
    .param p1, "dx"    # I
    .param p2, "dy"    # I

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    iget-object v1, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v1}, Landroid/widget/Scroller;->getFinalX()I

    move-result v1

    iget-object v2, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v2}, Landroid/widget/Scroller;->getFinalY()I

    move-result v2

    invoke-virtual {v0, v1, v2, p1, p2}, Landroid/widget/Scroller;->startScroll(IIII)V

    .line 48
    invoke-virtual {p0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->invalidate()V

    .line 49
    return-void
.end method

.method public smoothScrollTo(II)V
    .locals 3
    .param p1, "fx"    # I
    .param p2, "fy"    # I

    .prologue
    .line 37
    iget-object v2, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v2}, Landroid/widget/Scroller;->getFinalX()I

    move-result v2

    sub-int v0, p1, v2

    .line 38
    .local v0, "dx":I
    iget-object v2, p0, Lcom/aio/downloader/utils/OverScrollWarpLayout;->mScroller:Landroid/widget/Scroller;

    invoke-virtual {v2}, Landroid/widget/Scroller;->getFinalY()I

    move-result v2

    sub-int v1, p2, v2

    .line 39
    .local v1, "dy":I
    invoke-virtual {p0, v0, v1}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->smoothScrollBy(II)V

    .line 40
    return-void
.end method

.method public final smoothScrollToNormal()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 67
    invoke-virtual {p0, v0, v0}, Lcom/aio/downloader/utils/OverScrollWarpLayout;->smoothScrollTo(II)V

    .line 68
    return-void
.end method
