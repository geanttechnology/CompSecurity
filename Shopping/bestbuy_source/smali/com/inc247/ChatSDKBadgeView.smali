.class public Lcom/inc247/ChatSDKBadgeView;
.super Landroid/widget/TextView;
.source "SourceFile"


# instance fields
.field final topDown:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 20
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getGravity()I

    move-result v0

    .line 21
    invoke-static {v0}, Landroid/view/Gravity;->isVertical(I)Z

    move-result v1

    if-eqz v1, :cond_0

    and-int/lit8 v1, v0, 0x70

    const/16 v2, 0x50

    if-ne v1, v2, :cond_0

    .line 22
    and-int/lit8 v0, v0, 0x7

    or-int/lit8 v0, v0, 0x30

    invoke-virtual {p0, v0}, Lcom/inc247/ChatSDKBadgeView;->setGravity(I)V

    .line 23
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/inc247/ChatSDKBadgeView;->topDown:Z

    .line 26
    :goto_0
    return-void

    .line 25
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/inc247/ChatSDKBadgeView;->topDown:Z

    goto :goto_0
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 35
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    .line 36
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getCurrentTextColor()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    .line 37
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getDrawableState()[I

    move-result-object v1

    iput-object v1, v0, Landroid/text/TextPaint;->drawableState:[I

    .line 39
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 41
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->shouldRotate()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 42
    iget-boolean v0, p0, Lcom/inc247/ChatSDKBadgeView;->topDown:Z

    if-eqz v0, :cond_1

    .line 43
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p1, v0, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 44
    const/high16 v0, 0x42b40000    # 90.0f

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->rotate(F)V

    .line 51
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getCompoundPaddingLeft()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getExtendedPaddingTop()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 52
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;)V

    .line 53
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 54
    return-void

    .line 46
    :cond_1
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getHeight()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p1, v2, v0}, Landroid/graphics/Canvas;->translate(FF)V

    .line 47
    const/high16 v0, -0x3d4c0000    # -90.0f

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->rotate(F)V

    goto :goto_0
.end method

.method protected onMeasure(II)V
    .locals 2

    .prologue
    .line 28
    invoke-super {p0, p2, p1}, Landroid/widget/TextView;->onMeasure(II)V

    .line 29
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->shouldRotate()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 30
    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getMeasuredHeight()I

    move-result v0

    invoke-virtual {p0}, Lcom/inc247/ChatSDKBadgeView;->getMeasuredWidth()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/inc247/ChatSDKBadgeView;->setMeasuredDimension(II)V

    .line 32
    :cond_0
    return-void
.end method

.method public shouldRotate()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 57
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v1, v1, Landroid/content/res/Configuration;->orientation:I

    if-ne v1, v0, :cond_1

    .line 59
    sget-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    const-string v2, "top-center"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    sget-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    const-string v2, "bottom-center"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 72
    :cond_0
    :goto_0
    return v0

    .line 66
    :cond_1
    sget-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    const-string v2, "top-center"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    sget-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    const-string v2, "bottom-center"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
