.class public Lco/vine/android/widget/tabs/ScrollAwayTabWidget;
.super Landroid/widget/TabWidget;
.source "ScrollAwayTabWidget.java"


# instance fields
.field private mCurrentDelta:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Landroid/widget/TabWidget;-><init>(Landroid/content/Context;)V

    .line 13
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Landroid/widget/TabWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 13
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 24
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/TabWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 13
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 25
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "c"    # Landroid/graphics/Canvas;

    .prologue
    .line 29
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 30
    const/4 v0, 0x0

    iget v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 31
    invoke-super {p0, p1}, Landroid/widget/TabWidget;->draw(Landroid/graphics/Canvas;)V

    .line 32
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 33
    return-void
.end method

.method public getNavBottom()I
    .locals 2

    .prologue
    .line 53
    iget v0, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getHeight()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 58
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getNavBottom()I

    move-result v1

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onScroll(I)V
    .locals 3
    .param p1, "delta"    # I

    .prologue
    .line 36
    iget v0, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 37
    .local v0, "oldDelta":I
    iget v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    add-int/2addr v1, p1

    iput v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 38
    iget v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getHeight()I

    move-result v2

    neg-int v2, v2

    if-ge v1, v2, :cond_2

    .line 39
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getHeight()I

    move-result v1

    neg-int v1, v1

    iput v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 43
    :cond_0
    :goto_0
    iget v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    if-eq v1, v0, :cond_1

    .line 44
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->invalidate()V

    .line 46
    :cond_1
    return-void

    .line 40
    :cond_2
    iget v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    if-lez v1, :cond_0

    .line 41
    const/4 v1, 0x0

    iput v1, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 63
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    invoke-virtual {p0}, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->getNavBottom()I

    move-result v1

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 64
    const/4 v0, 0x0

    .line 66
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/TabWidget;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public resetScroll()V
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/widget/tabs/ScrollAwayTabWidget;->mCurrentDelta:I

    .line 50
    return-void
.end method
