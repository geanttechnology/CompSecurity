.class public Lcom/amazon/mShop/ui/SelectableLayout;
.super Landroid/widget/LinearLayout;
.source "SelectableLayout.java"


# instance fields
.field private mDownPosY:F

.field private mMoveOccured:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 25
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    .line 14
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 25
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 25
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    .line 22
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 51
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 76
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0

    .line 53
    :pswitch_0
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/ui/SelectableLayout;->setEffectPressed(Z)V

    .line 54
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    .line 55
    iput-boolean v2, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    goto :goto_0

    .line 58
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v0

    iget v1, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const/high16 v1, 0x41200000    # 10.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 59
    iput-boolean v3, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 60
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/SelectableLayout;->setEffectPressed(Z)V

    goto :goto_0

    .line 64
    :pswitch_2
    iget-boolean v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    if-nez v0, :cond_1

    .line 65
    iput-boolean v2, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 66
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    .line 68
    :cond_1
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/SelectableLayout;->setEffectPressed(Z)V

    goto :goto_0

    .line 71
    :pswitch_3
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/SelectableLayout;->setEffectPressed(Z)V

    goto :goto_0

    .line 51
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x0

    .line 83
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 85
    .local v0, "handled":Z
    if-nez v0, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    .line 88
    const/4 v0, 0x1

    .line 91
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 106
    :cond_1
    :goto_0
    return v0

    .line 93
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    sub-float/2addr v1, v2

    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    const/high16 v2, 0x41200000    # 10.0f

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    .line 94
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 95
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/ui/SelectableLayout;->setEffectPressed(Z)V

    goto :goto_0

    .line 99
    :pswitch_1
    iget-boolean v1, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    if-nez v1, :cond_2

    .line 100
    iput-boolean v3, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mMoveOccured:Z

    .line 101
    const/4 v1, 0x0

    iput v1, p0, Lcom/amazon/mShop/ui/SelectableLayout;->mDownPosY:F

    .line 103
    :cond_2
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/ui/SelectableLayout;->setEffectPressed(Z)V

    goto :goto_0

    .line 91
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected setEffectPressed(Z)V
    .locals 6
    .param p1, "isPressed"    # Z

    .prologue
    .line 33
    if-eqz p1, :cond_0

    .line 34
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/SelectableLayout;->getPaddingLeft()I

    move-result v1

    .line 35
    .local v1, "paddingLeft":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/SelectableLayout;->getPaddingTop()I

    move-result v3

    .line 36
    .local v3, "paddingTop":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/SelectableLayout;->getPaddingRight()I

    move-result v2

    .line 37
    .local v2, "paddingRight":I
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/SelectableLayout;->getPaddingBottom()I

    move-result v0

    .line 39
    .local v0, "paddingBottom":I
    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->orange_outline_sharp_corner:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/ui/SelectableLayout;->setBackgroundResource(I)V

    .line 42
    invoke-virtual {p0, v1, v3, v2, v0}, Lcom/amazon/mShop/ui/SelectableLayout;->setPadding(IIII)V

    .line 47
    .end local v0    # "paddingBottom":I
    .end local v1    # "paddingLeft":I
    .end local v2    # "paddingRight":I
    .end local v3    # "paddingTop":I
    :goto_0
    return-void

    .line 45
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ui/SelectableLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x106000d

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/ui/SelectableLayout;->setBackgroundColor(I)V

    goto :goto_0
.end method
