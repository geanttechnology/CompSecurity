.class public Lcom/aio/downloader/views/LFrameLayout;
.super Landroid/widget/FrameLayout;
.source "LFrameLayout.java"

# interfaces
.implements Lcom/aio/downloader/views/IMaterial;


# instance fields
.field private mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/views/LFrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    new-instance v0, Lcom/aio/downloader/views/MaterialStyle;

    invoke-direct {v0, p0, p2}, Lcom/aio/downloader/views/MaterialStyle;-><init>(Landroid/view/View;Landroid/util/AttributeSet;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    .line 23
    return-void
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 131
    invoke-virtual {p0}, Lcom/aio/downloader/views/LFrameLayout;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 132
    const/4 v0, 0x0

    .line 133
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/aio/downloader/views/LFrameLayout;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 40
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 45
    :goto_0
    return-void

    .line 43
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->doDraw(Landroid/graphics/Canvas;)V

    .line 44
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onDraw(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 115
    iget-object v1, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v1, :cond_1

    .line 116
    iget-object v1, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v1}, Lcom/aio/downloader/views/MaterialStyle;->needBackgroundMeasure()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 117
    iget-object v1, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v1, p1, p2}, Lcom/aio/downloader/views/MaterialStyle;->getMeasureSize(II)[I

    move-result-object v0

    .line 119
    .local v0, "size":[I
    const/4 v1, 0x0

    aget v1, v0, v1

    const/4 v2, 0x1

    aget v2, v0, v2

    invoke-virtual {p0, v1, v2}, Lcom/aio/downloader/views/LFrameLayout;->setMeasuredDimension(II)V

    .line 127
    .end local v0    # "size":[I
    :goto_0
    return-void

    .line 121
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    goto :goto_0

    .line 124
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ClickableViewAccessibility"
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->onTouchEvent(Landroid/view/MotionEvent;)V

    .line 63
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method protected onVisibilityChanged(Landroid/view/View;I)V
    .locals 1
    .param p1, "changedView"    # Landroid/view/View;
    .param p2, "visibility"    # I

    .prologue
    .line 75
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onVisibilityChanged(Landroid/view/View;I)V

    .line 76
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 77
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1, p2}, Lcom/aio/downloader/views/MaterialStyle;->onVisibilityChanged(Landroid/view/View;I)V

    .line 78
    :cond_0
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 68
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onWindowFocusChanged(Z)V

    .line 69
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->onWindowFocusChanged(Z)V

    .line 71
    :cond_0
    return-void
.end method

.method public perfirmSuperClick()V
    .locals 0

    .prologue
    .line 26
    invoke-super {p0}, Landroid/widget/FrameLayout;->performClick()Z

    .line 27
    return-void
.end method

.method public performClick()Z
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ClickableViewAccessibility"
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0}, Lcom/aio/downloader/views/MaterialStyle;->performClick()V

    .line 55
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 53
    :cond_0
    invoke-super {p0}, Landroid/widget/FrameLayout;->performClick()Z

    move-result v0

    goto :goto_0
.end method

.method public setBackground(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 98
    :cond_0
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setBackgroundColor(I)V

    .line 104
    :cond_0
    return-void
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0, p1}, Lcom/aio/downloader/views/LFrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 111
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/aio/downloader/views/LFrameLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/LFrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 92
    return-void
.end method

.method public setColor(I)V
    .locals 1
    .param p1, "fullColor"    # I

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setColor(I)V

    .line 31
    return-void
.end method

.method public setDelayClick(Z)V
    .locals 1
    .param p1, "delayClick"    # Z

    .prologue
    .line 86
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setDelayClick(Z)V

    .line 87
    return-void
.end method

.method public setType(I)V
    .locals 1
    .param p1, "widgetType"    # I

    .prologue
    .line 34
    iget-object v0, p0, Lcom/aio/downloader/views/LFrameLayout;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setType(I)V

    .line 35
    return-void
.end method
