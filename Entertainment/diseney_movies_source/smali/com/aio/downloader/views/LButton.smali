.class public Lcom/aio/downloader/views/LButton;
.super Landroid/widget/Button;
.source "LButton.java"

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

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/views/LButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

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
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    new-instance v0, Lcom/aio/downloader/views/MaterialStyle;

    invoke-direct {v0, p0, p2}, Lcom/aio/downloader/views/MaterialStyle;-><init>(Landroid/view/View;Landroid/util/AttributeSet;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    .line 23
    return-void
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 132
    invoke-virtual {p0}, Lcom/aio/downloader/views/LButton;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 133
    const/4 v0, 0x0

    .line 134
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/Button;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/aio/downloader/views/LButton;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 40
    const v0, -0x303031

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 41
    invoke-super {p0, p1}, Landroid/widget/Button;->onDraw(Landroid/graphics/Canvas;)V

    .line 46
    :goto_0
    return-void

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->doDraw(Landroid/graphics/Canvas;)V

    .line 45
    invoke-super {p0, p1}, Landroid/widget/Button;->onDraw(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method protected onMeasure(II)V
    .locals 3
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 116
    iget-object v1, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v1, :cond_1

    .line 117
    iget-object v1, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v1}, Lcom/aio/downloader/views/MaterialStyle;->needBackgroundMeasure()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 118
    iget-object v1, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v1, p1, p2}, Lcom/aio/downloader/views/MaterialStyle;->getMeasureSize(II)[I

    move-result-object v0

    .line 120
    .local v0, "size":[I
    const/4 v1, 0x0

    aget v1, v0, v1

    const/4 v2, 0x1

    aget v2, v0, v2

    invoke-virtual {p0, v1, v2}, Lcom/aio/downloader/views/LButton;->setMeasuredDimension(II)V

    .line 128
    .end local v0    # "size":[I
    :goto_0
    return-void

    .line 122
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/Button;->onMeasure(II)V

    goto :goto_0

    .line 125
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/widget/Button;->onMeasure(II)V

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
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->onTouchEvent(Landroid/view/MotionEvent;)V

    .line 64
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/Button;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method protected onVisibilityChanged(Landroid/view/View;I)V
    .locals 1
    .param p1, "changedView"    # Landroid/view/View;
    .param p2, "visibility"    # I

    .prologue
    .line 76
    invoke-super {p0, p1, p2}, Landroid/widget/Button;->onVisibilityChanged(Landroid/view/View;I)V

    .line 77
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1, p2}, Lcom/aio/downloader/views/MaterialStyle;->onVisibilityChanged(Landroid/view/View;I)V

    .line 79
    :cond_0
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 69
    invoke-super {p0, p1}, Landroid/widget/Button;->onWindowFocusChanged(Z)V

    .line 70
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->onWindowFocusChanged(Z)V

    .line 72
    :cond_0
    return-void
.end method

.method public perfirmSuperClick()V
    .locals 0

    .prologue
    .line 26
    invoke-super {p0}, Landroid/widget/Button;->performClick()Z

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
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0}, Lcom/aio/downloader/views/MaterialStyle;->performClick()V

    .line 56
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 54
    :cond_0
    invoke-super {p0}, Landroid/widget/Button;->performClick()Z

    move-result v0

    goto :goto_0
.end method

.method public setBackground(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 99
    :cond_0
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 103
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setBackgroundColor(I)V

    .line 105
    :cond_0
    return-void
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 111
    invoke-virtual {p0, p1}, Lcom/aio/downloader/views/LButton;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 112
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .prologue
    .line 92
    invoke-virtual {p0}, Lcom/aio/downloader/views/LButton;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/LButton;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 93
    return-void
.end method

.method public setColor(I)V
    .locals 1
    .param p1, "fullColor"    # I

    .prologue
    .line 30
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setColor(I)V

    .line 31
    return-void
.end method

.method public setDelayClick(Z)V
    .locals 1
    .param p1, "delayClick"    # Z

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setDelayClick(Z)V

    .line 88
    return-void
.end method

.method public setType(I)V
    .locals 1
    .param p1, "widgetType"    # I

    .prologue
    .line 34
    iget-object v0, p0, Lcom/aio/downloader/views/LButton;->mMaterialStyle:Lcom/aio/downloader/views/MaterialStyle;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/MaterialStyle;->setType(I)V

    .line 35
    return-void
.end method
