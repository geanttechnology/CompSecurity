.class public Lcom/aio/downloader/views/MyRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "MyRelativeLayout.java"


# instance fields
.field private dl:Lcom/aio/downloader/views/DragLayout;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 15
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 23
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/aio/downloader/views/MyRelativeLayout;->dl:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/views/DragLayout;->getStatus()Lcom/aio/downloader/views/DragLayout$Status;

    move-result-object v0

    sget-object v1, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    if-eq v0, v1, :cond_0

    .line 32
    const/4 v0, 0x1

    .line 34
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    .line 39
    iget-object v1, p0, Lcom/aio/downloader/views/MyRelativeLayout;->dl:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DragLayout;->getStatus()Lcom/aio/downloader/views/DragLayout$Status;

    move-result-object v1

    sget-object v2, Lcom/aio/downloader/views/DragLayout$Status;->Close:Lcom/aio/downloader/views/DragLayout$Status;

    if-eq v1, v2, :cond_1

    .line 40
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-ne v1, v0, :cond_0

    .line 41
    iget-object v1, p0, Lcom/aio/downloader/views/MyRelativeLayout;->dl:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DragLayout;->close()V

    .line 45
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public setDragLayout(Lcom/aio/downloader/views/DragLayout;)V
    .locals 0
    .param p1, "dl"    # Lcom/aio/downloader/views/DragLayout;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/aio/downloader/views/MyRelativeLayout;->dl:Lcom/aio/downloader/views/DragLayout;

    .line 27
    return-void
.end method
