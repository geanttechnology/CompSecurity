.class public Lcom/aio/downloader/views/DragLayout;
.super Landroid/widget/FrameLayout;
.source "DragLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/DragLayout$DragListener;,
        Lcom/aio/downloader/views/DragLayout$Status;,
        Lcom/aio/downloader/views/DragLayout$YScrollDetector;
    }
.end annotation


# static fields
.field private static final RANGE:F = 0.7f


# instance fields
.field private dragHelper:Landroid/support/v4/widget/ViewDragHelper;

.field private dragHelperCallback:Landroid/support/v4/widget/ViewDragHelper$Callback;

.field private dragListener:Lcom/aio/downloader/views/DragLayout$DragListener;

.field private gestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

.field private height:I

.field private mainLeft:I

.field private range:I

.field private status:Lcom/aio/downloader/views/DragLayout$Status;

.field private vg_left:Landroid/widget/RelativeLayout;

.field private vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

.field private width:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/views/DragLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/aio/downloader/views/DragLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 42
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 31
    sget-object v0, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    iput-object v0, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    .line 56
    new-instance v0, Lcom/aio/downloader/views/DragLayout$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/views/DragLayout$1;-><init>(Lcom/aio/downloader/views/DragLayout;)V

    iput-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelperCallback:Landroid/support/v4/widget/ViewDragHelper$Callback;

    .line 43
    new-instance v0, Landroid/support/v4/view/GestureDetectorCompat;

    .line 44
    new-instance v1, Lcom/aio/downloader/views/DragLayout$YScrollDetector;

    invoke-direct {v1, p0}, Lcom/aio/downloader/views/DragLayout$YScrollDetector;-><init>(Lcom/aio/downloader/views/DragLayout;)V

    invoke-direct {v0, p1, v1}, Landroid/support/v4/view/GestureDetectorCompat;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    .line 43
    iput-object v0, p0, Lcom/aio/downloader/views/DragLayout;->gestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

    .line 45
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelperCallback:Landroid/support/v4/widget/ViewDragHelper$Callback;

    invoke-static {p0, v0}, Landroid/support/v4/widget/ViewDragHelper;->create(Landroid/view/ViewGroup;Landroid/support/v4/widget/ViewDragHelper$Callback;)Landroid/support/v4/widget/ViewDragHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelper:Landroid/support/v4/widget/ViewDragHelper;

    .line 46
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/DragLayout;)I
    .locals 1

    .prologue
    .line 26
    iget v0, p0, Lcom/aio/downloader/views/DragLayout;->mainLeft:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/DragLayout;)I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/views/DragLayout;)I
    .locals 1

    .prologue
    .line 23
    iget v0, p0, Lcom/aio/downloader/views/DragLayout;->width:I

    return v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/views/DragLayout;)Lcom/aio/downloader/views/MyRelativeLayout;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/views/DragLayout;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/views/DragLayout;I)V
    .locals 0

    .prologue
    .line 26
    iput p1, p0, Lcom/aio/downloader/views/DragLayout;->mainLeft:I

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/views/DragLayout;I)V
    .locals 0

    .prologue
    .line 177
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/DragLayout;->dispatchDragEvent(I)V

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/views/DragLayout;)I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/aio/downloader/views/DragLayout;->height:I

    return v0
.end method

.method private dispatchDragEvent(I)V
    .locals 4
    .param p1, "mainLeft"    # I

    .prologue
    .line 178
    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->dragListener:Lcom/aio/downloader/views/DragLayout$DragListener;

    if-nez v2, :cond_1

    .line 191
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    int-to-float v2, p1

    iget v3, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    int-to-float v3, v3

    div-float v1, v2, v3

    .line 182
    .local v1, "percent":F
    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->dragListener:Lcom/aio/downloader/views/DragLayout$DragListener;

    invoke-interface {v2, v1}, Lcom/aio/downloader/views/DragLayout$DragListener;->onDrag(F)V

    .line 183
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    .line 184
    .local v0, "lastStatus":Lcom/aio/downloader/views/DragLayout$Status;
    invoke-virtual {p0}, Lcom/aio/downloader/views/DragLayout;->getStatus()Lcom/aio/downloader/views/DragLayout$Status;

    move-result-object v2

    if-eq v0, v2, :cond_2

    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    sget-object v3, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    if-ne v2, v3, :cond_2

    .line 185
    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setEnabled(Z)V

    .line 186
    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->dragListener:Lcom/aio/downloader/views/DragLayout$DragListener;

    invoke-interface {v2}, Lcom/aio/downloader/views/DragLayout$DragListener;->onClose()V

    goto :goto_0

    .line 187
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/views/DragLayout;->getStatus()Lcom/aio/downloader/views/DragLayout$Status;

    move-result-object v2

    if-eq v0, v2, :cond_0

    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    sget-object v3, Lcom/aio/downloader/views/DragLayout$Status;->Open:Lcom/aio/downloader/views/DragLayout$Status;

    if-ne v2, v3, :cond_0

    .line 188
    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setEnabled(Z)V

    .line 189
    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout;->dragListener:Lcom/aio/downloader/views/DragLayout$DragListener;

    invoke-interface {v2}, Lcom/aio/downloader/views/DragLayout$DragListener;->onOpen()V

    goto :goto_0
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 232
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/DragLayout;->close(Z)V

    .line 233
    return-void
.end method

.method public close(Z)V
    .locals 4
    .param p1, "animate"    # Z

    .prologue
    const/4 v3, 0x0

    .line 236
    if-eqz p1, :cond_1

    .line 237
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    invoke-virtual {v0, v1, v3, v3}, Landroid/support/v4/widget/ViewDragHelper;->smoothSlideViewTo(Landroid/view/View;II)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    .line 244
    :cond_0
    :goto_0
    return-void

    .line 241
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    iget v1, p0, Lcom/aio/downloader/views/DragLayout;->width:I

    iget v2, p0, Lcom/aio/downloader/views/DragLayout;->height:I

    invoke-virtual {v0, v3, v3, v1, v2}, Lcom/aio/downloader/views/MyRelativeLayout;->layout(IIII)V

    .line 242
    invoke-direct {p0, v3}, Lcom/aio/downloader/views/DragLayout;->dispatchDragEvent(I)V

    goto :goto_0
.end method

.method public computeScroll()V
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelper:Landroid/support/v4/widget/ViewDragHelper;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/ViewDragHelper;->continueSettling(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 196
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    .line 198
    :cond_0
    return-void
.end method

.method public getStatus()Lcom/aio/downloader/views/DragLayout$Status;
    .locals 2

    .prologue
    .line 205
    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    invoke-virtual {v1}, Lcom/aio/downloader/views/MyRelativeLayout;->getLeft()I

    move-result v0

    .line 206
    .local v0, "mainLeft":I
    if-nez v0, :cond_0

    .line 207
    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    iput-object v1, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    .line 213
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    return-object v1

    .line 208
    :cond_0
    iget v1, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    if-ne v0, v1, :cond_1

    .line 209
    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Open:Lcom/aio/downloader/views/DragLayout$Status;

    iput-object v1, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    goto :goto_0

    .line 211
    :cond_1
    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Drag:Lcom/aio/downloader/views/DragLayout$Status;

    iput-object v1, p0, Lcom/aio/downloader/views/DragLayout;->status:Lcom/aio/downloader/views/DragLayout$Status;

    goto :goto_0
.end method

.method public getVg_left()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method public getVg_main()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    return-object v0
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 130
    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    .line 131
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/DragLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    .line 132
    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/DragLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/MyRelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    .line 133
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/views/MyRelativeLayout;->setDragLayout(Lcom/aio/downloader/views/DragLayout;)V

    .line 134
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 135
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/MyRelativeLayout;->setClickable(Z)V

    .line 136
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 163
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/ViewDragHelper;->shouldInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->gestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

    invoke-virtual {v0, p1}, Landroid/support/v4/view/GestureDetectorCompat;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 5
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/4 v4, 0x0

    .line 157
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    iget v1, p0, Lcom/aio/downloader/views/DragLayout;->width:I

    iget v2, p0, Lcom/aio/downloader/views/DragLayout;->height:I

    invoke-virtual {v0, v4, v4, v1, v2}, Landroid/widget/RelativeLayout;->layout(IIII)V

    .line 158
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    iget v1, p0, Lcom/aio/downloader/views/DragLayout;->mainLeft:I

    iget v2, p0, Lcom/aio/downloader/views/DragLayout;->mainLeft:I

    iget v3, p0, Lcom/aio/downloader/views/DragLayout;->width:I

    add-int/2addr v2, v3

    iget v3, p0, Lcom/aio/downloader/views/DragLayout;->height:I

    invoke-virtual {v0, v1, v4, v2, v3}, Lcom/aio/downloader/views/MyRelativeLayout;->layout(IIII)V

    .line 159
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 2
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 148
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/FrameLayout;->onSizeChanged(IIII)V

    .line 149
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getMeasuredWidth()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/DragLayout;->width:I

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getMeasuredHeight()I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/views/DragLayout;->height:I

    .line 151
    iget v0, p0, Lcom/aio/downloader/views/DragLayout;->width:I

    int-to-float v0, v0

    const v1, 0x3f333333    # 0.7f

    mul-float/2addr v0, v1

    float-to-int v0, v0

    iput v0, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    .line 152
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 170
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout;->dragHelper:Landroid/support/v4/widget/ViewDragHelper;

    invoke-virtual {v1, p1}, Landroid/support/v4/widget/ViewDragHelper;->processTouchEvent(Landroid/view/MotionEvent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 174
    :goto_0
    const/4 v1, 0x0

    return v1

    .line 171
    :catch_0
    move-exception v0

    .line 172
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public open()V
    .locals 1

    .prologue
    .line 217
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/DragLayout;->open(Z)V

    .line 218
    return-void
.end method

.method public open(Z)V
    .locals 5
    .param p1, "animate"    # Z

    .prologue
    const/4 v4, 0x0

    .line 221
    if-eqz p1, :cond_1

    .line 222
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->dragHelper:Landroid/support/v4/widget/ViewDragHelper;

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    iget v2, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    invoke-virtual {v0, v1, v2, v4}, Landroid/support/v4/widget/ViewDragHelper;->smoothSlideViewTo(Landroid/view/View;II)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 223
    invoke-static {p0}, Landroid/support/v4/view/ViewCompat;->postInvalidateOnAnimation(Landroid/view/View;)V

    .line 229
    :cond_0
    :goto_0
    return-void

    .line 226
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;

    iget v1, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    iget v2, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    mul-int/lit8 v2, v2, 0x2

    iget v3, p0, Lcom/aio/downloader/views/DragLayout;->height:I

    invoke-virtual {v0, v1, v4, v2, v3}, Lcom/aio/downloader/views/MyRelativeLayout;->layout(IIII)V

    .line 227
    iget v0, p0, Lcom/aio/downloader/views/DragLayout;->range:I

    invoke-direct {p0, v0}, Lcom/aio/downloader/views/DragLayout;->dispatchDragEvent(I)V

    goto :goto_0
.end method

.method public setDragListener(Lcom/aio/downloader/views/DragLayout$DragListener;)V
    .locals 0
    .param p1, "dragListener"    # Lcom/aio/downloader/views/DragLayout$DragListener;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/aio/downloader/views/DragLayout;->dragListener:Lcom/aio/downloader/views/DragLayout$DragListener;

    .line 126
    return-void
.end method
