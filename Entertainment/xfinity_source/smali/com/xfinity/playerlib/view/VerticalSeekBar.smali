.class public Lcom/xfinity/playerlib/view/VerticalSeekBar;
.super Landroid/widget/SeekBar;
.source "VerticalSeekBar.java"


# static fields
.field private static final APPEAR_ENABLED_STATE_SET:[I


# instance fields
.field private appearEnabled:Z

.field private onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

.field private w:I

.field private x:I

.field private y:I

.field private z:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 14
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/xfinity/playerlib/R$attr;->state_appear_enabled:I

    aput v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->APPEAR_ENABLED_STATE_SET:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Landroid/widget/SeekBar;-><init>(Landroid/content/Context;)V

    .line 18
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->appearEnabled:Z

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Landroid/widget/SeekBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->appearEnabled:Z

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 25
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/SeekBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 18
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->appearEnabled:Z

    .line 26
    return-void
.end method

.method private trackTouchEvent(Landroid/view/MotionEvent;)V
    .locals 11
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 119
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getPaddingTop()I

    move-result v4

    .line 120
    .local v4, "paddingTop":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getPaddingBottom()I

    move-result v3

    .line 122
    .local v3, "paddingBottom":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getHeight()I

    move-result v1

    .line 123
    .local v1, "height":I
    sub-int v8, v1, v4

    sub-int v0, v8, v3

    .line 124
    .local v0, "available":I
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v8

    float-to-int v7, v8

    .line 125
    .local v7, "y":I
    if-ge v7, v4, :cond_2

    .line 126
    move v7, v4

    .line 132
    :cond_0
    :goto_0
    const/4 v5, 0x0

    .line 133
    .local v5, "progress":F
    const/high16 v8, 0x3f800000    # 1.0f

    sub-int v9, v7, v4

    int-to-float v9, v9

    int-to-float v10, v0

    div-float/2addr v9, v10

    sub-float v6, v8, v9

    .line 135
    .local v6, "scale":F
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getMax()I

    move-result v2

    .line 136
    .local v2, "max":I
    int-to-float v8, v2

    mul-float/2addr v8, v6

    add-float/2addr v5, v8

    .line 137
    const/4 v8, 0x0

    cmpg-float v8, v5, v8

    if-gez v8, :cond_3

    .line 138
    const/4 v5, 0x0

    .line 143
    :cond_1
    :goto_1
    float-to-int v8, v5

    invoke-virtual {p0, v8}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setProgress(I)V

    .line 144
    return-void

    .line 127
    .end local v2    # "max":I
    .end local v5    # "progress":F
    .end local v6    # "scale":F
    :cond_2
    if-le v7, v0, :cond_0

    .line 128
    move v7, v0

    goto :goto_0

    .line 139
    .restart local v2    # "max":I
    .restart local v5    # "progress":F
    .restart local v6    # "scale":F
    :cond_3
    int-to-float v8, v2

    cmpl-float v8, v5, v8

    if-lez v8, :cond_1

    .line 140
    int-to-float v5, v2

    goto :goto_1
.end method


# virtual methods
.method public appearEnabled()Z
    .locals 1

    .prologue
    .line 104
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->appearEnabled:Z

    return v0
.end method

.method protected onCreateDrawableState(I)[I
    .locals 2
    .param p1, "extraSpace"    # I

    .prologue
    .line 109
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/widget/SeekBar;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 111
    .local v0, "drawableState":[I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->appearEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 112
    sget-object v1, Lcom/xfinity/playerlib/view/VerticalSeekBar;->APPEAR_ENABLED_STATE_SET:[I

    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->mergeDrawableStates([I[I)[I

    .line 115
    :cond_0
    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "c"    # Landroid/graphics/Canvas;

    .prologue
    .line 48
    const/high16 v0, -0x3d4c0000    # -90.0f

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->rotate(F)V

    .line 49
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getHeight()I

    move-result v0

    neg-int v0, v0

    int-to-float v0, v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 50
    invoke-super {p0, p1}, Landroid/widget/SeekBar;->onDraw(Landroid/graphics/Canvas;)V

    .line 51
    return-void
.end method

.method protected declared-synchronized onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 43
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p2, p1}, Landroid/widget/SeekBar;->onMeasure(II)V

    .line 44
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getMeasuredHeight()I

    move-result v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getMeasuredWidth()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setMeasuredDimension(II)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 45
    monitor-exit p0

    return-void

    .line 43
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected onSizeChanged(IIII)V
    .locals 0
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 33
    invoke-super {p0, p2, p1, p4, p3}, Landroid/widget/SeekBar;->onSizeChanged(IIII)V

    .line 34
    iput p1, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->x:I

    .line 35
    iput p2, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->y:I

    .line 36
    iput p3, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->z:I

    .line 37
    iput p4, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->w:I

    .line 38
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 55
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->isEnabled()Z

    move-result v2

    if-nez v2, :cond_0

    .line 83
    :goto_0
    return v0

    .line 59
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_1
    :goto_1
    move v0, v1

    .line 83
    goto :goto_0

    .line 62
    :pswitch_0
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setSelected(Z)V

    .line 63
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setPressed(Z)V

    .line 64
    iget-object v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    invoke-interface {v0, p0}, Landroid/widget/SeekBar$OnSeekBarChangeListener;->onStartTrackingTouch(Landroid/widget/SeekBar;)V

    goto :goto_1

    .line 69
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->trackTouchEvent(Landroid/view/MotionEvent;)V

    .line 70
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->getHeight()I

    move-result v3

    invoke-virtual {p0, v2, v3, v0, v0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onSizeChanged(IIII)V

    goto :goto_1

    .line 73
    :pswitch_2
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setSelected(Z)V

    .line 74
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setPressed(Z)V

    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    if-eqz v0, :cond_1

    .line 76
    iget-object v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    invoke-interface {v0, p0}, Landroid/widget/SeekBar$OnSeekBarChangeListener;->onStopTrackingTouch(Landroid/widget/SeekBar;)V

    goto :goto_1

    .line 59
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public setAppearEnabled(Z)V
    .locals 0
    .param p1, "appearEnabled"    # Z

    .prologue
    .line 98
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->appearEnabled:Z

    .line 99
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->refreshDrawableState()V

    .line 100
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->invalidate()V

    .line 101
    return-void
.end method

.method public setOnVerticalSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V
    .locals 0
    .param p1, "onVerticalSeekBarChangeListener"    # Landroid/widget/SeekBar$OnSeekBarChangeListener;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    .line 148
    return-void
.end method

.method public declared-synchronized setProgress(I)V
    .locals 4
    .param p1, "progress"    # I

    .prologue
    .line 88
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    invoke-static {p1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    invoke-super {p0, v0}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 91
    iget v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->x:I

    iget v1, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->y:I

    iget v2, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->z:I

    iget v3, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->w:I

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onSizeChanged(IIII)V

    .line 92
    iget-object v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/view/VerticalSeekBar;->onVerticalSeekBarChangeListener:Landroid/widget/SeekBar$OnSeekBarChangeListener;

    const/4 v1, 0x1

    invoke-interface {v0, p0, p1, v1}, Landroid/widget/SeekBar$OnSeekBarChangeListener;->onProgressChanged(Landroid/widget/SeekBar;IZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 95
    :cond_0
    monitor-exit p0

    return-void

    .line 88
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
