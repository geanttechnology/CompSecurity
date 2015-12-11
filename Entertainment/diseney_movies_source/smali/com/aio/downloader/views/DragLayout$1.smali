.class Lcom/aio/downloader/views/DragLayout$1;
.super Landroid/support/v4/widget/ViewDragHelper$Callback;
.source "DragLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/DragLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/DragLayout;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/DragLayout;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    .line 56
    invoke-direct {p0}, Landroid/support/v4/widget/ViewDragHelper$Callback;-><init>()V

    return-void
.end method


# virtual methods
.method public clampViewPositionHorizontal(Landroid/view/View;II)I
    .locals 2
    .param p1, "child"    # Landroid/view/View;
    .param p2, "left"    # I
    .param p3, "dx"    # I

    .prologue
    .line 60
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    add-int/2addr v0, p3

    if-gez v0, :cond_1

    .line 61
    const/4 p2, 0x0

    .line 65
    .end local p2    # "left":I
    :cond_0
    :goto_0
    return p2

    .line 62
    .restart local p2    # "left":I
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    add-int/2addr v0, p3

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->range:I
    invoke-static {v1}, Lcom/aio/downloader/views/DragLayout;->access$1(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    if-le v0, v1, :cond_0

    .line 63
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->range:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$1(Lcom/aio/downloader/views/DragLayout;)I

    move-result p2

    goto :goto_0
.end method

.method public getViewHorizontalDragRange(Landroid/view/View;)I
    .locals 1
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->width:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$2(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    return v0
.end method

.method public onViewPositionChanged(Landroid/view/View;IIII)V
    .locals 5
    .param p1, "changedView"    # Landroid/view/View;
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "dx"    # I
    .param p5, "dy"    # I

    .prologue
    const/4 v4, 0x0

    .line 98
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$3(Lcom/aio/downloader/views/DragLayout;)Lcom/aio/downloader/views/MyRelativeLayout;

    move-result-object v0

    if-ne p1, v0, :cond_2

    .line 99
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-static {v0, p2}, Lcom/aio/downloader/views/DragLayout;->access$5(Lcom/aio/downloader/views/DragLayout;I)V

    .line 103
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    if-gez v0, :cond_3

    .line 104
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-static {v0, v4}, Lcom/aio/downloader/views/DragLayout;->access$5(Lcom/aio/downloader/views/DragLayout;I)V

    .line 108
    :cond_0
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v1}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    # invokes: Lcom/aio/downloader/views/DragLayout;->dispatchDragEvent(I)V
    invoke-static {v0, v1}, Lcom/aio/downloader/views/DragLayout;->access$6(Lcom/aio/downloader/views/DragLayout;I)V

    .line 109
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$4(Lcom/aio/downloader/views/DragLayout;)Landroid/widget/RelativeLayout;

    move-result-object v0

    if-ne p1, v0, :cond_1

    .line 110
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$4(Lcom/aio/downloader/views/DragLayout;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->width:I
    invoke-static {v1}, Lcom/aio/downloader/views/DragLayout;->access$2(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->height:I
    invoke-static {v2}, Lcom/aio/downloader/views/DragLayout;->access$7(Lcom/aio/downloader/views/DragLayout;)I

    move-result v2

    invoke-virtual {v0, v4, v4, v1, v2}, Landroid/widget/RelativeLayout;->layout(IIII)V

    .line 111
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$3(Lcom/aio/downloader/views/DragLayout;)Lcom/aio/downloader/views/MyRelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v1}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v2}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v2

    iget-object v3, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->width:I
    invoke-static {v3}, Lcom/aio/downloader/views/DragLayout;->access$2(Lcom/aio/downloader/views/DragLayout;)I

    move-result v3

    add-int/2addr v2, v3

    iget-object v3, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->height:I
    invoke-static {v3}, Lcom/aio/downloader/views/DragLayout;->access$7(Lcom/aio/downloader/views/DragLayout;)I

    move-result v3

    invoke-virtual {v0, v1, v4, v2, v3}, Lcom/aio/downloader/views/MyRelativeLayout;->layout(IIII)V

    .line 113
    :cond_1
    return-void

    .line 101
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    add-int/2addr v1, p2

    invoke-static {v0, v1}, Lcom/aio/downloader/views/DragLayout;->access$5(Lcom/aio/downloader/views/DragLayout;I)V

    goto :goto_0

    .line 105
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->range:I
    invoke-static {v1}, Lcom/aio/downloader/views/DragLayout;->access$1(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    if-le v0, v1, :cond_0

    .line 106
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    iget-object v1, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->range:I
    invoke-static {v1}, Lcom/aio/downloader/views/DragLayout;->access$1(Lcom/aio/downloader/views/DragLayout;)I

    move-result v1

    invoke-static {v0, v1}, Lcom/aio/downloader/views/DragLayout;->access$5(Lcom/aio/downloader/views/DragLayout;I)V

    goto :goto_1
.end method

.method public onViewReleased(Landroid/view/View;FF)V
    .locals 6
    .param p1, "releasedChild"    # Landroid/view/View;
    .param p2, "xvel"    # F
    .param p3, "yvel"    # F

    .prologue
    const/4 v1, 0x0

    .line 81
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/widget/ViewDragHelper$Callback;->onViewReleased(Landroid/view/View;FF)V

    .line 82
    cmpl-float v0, p2, v1

    if-lez v0, :cond_0

    .line 83
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/views/DragLayout;->open()V

    .line 93
    :goto_0
    return-void

    .line 84
    :cond_0
    cmpg-float v0, p2, v1

    if-gez v0, :cond_1

    .line 85
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/views/DragLayout;->close()V

    goto :goto_0

    .line 86
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->vg_main:Lcom/aio/downloader/views/MyRelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$3(Lcom/aio/downloader/views/DragLayout;)Lcom/aio/downloader/views/MyRelativeLayout;

    move-result-object v0

    if-ne p1, v0, :cond_2

    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    int-to-double v0, v0

    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->range:I
    invoke-static {v2}, Lcom/aio/downloader/views/DragLayout;->access$1(Lcom/aio/downloader/views/DragLayout;)I

    move-result v2

    int-to-double v2, v2

    const-wide v4, 0x3fd3333333333333L    # 0.3

    mul-double/2addr v2, v4

    cmpl-double v0, v0, v2

    if-lez v0, :cond_2

    .line 87
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/views/DragLayout;->open()V

    goto :goto_0

    .line 88
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->vg_left:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$4(Lcom/aio/downloader/views/DragLayout;)Landroid/widget/RelativeLayout;

    move-result-object v0

    if-ne p1, v0, :cond_3

    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->mainLeft:I
    invoke-static {v0}, Lcom/aio/downloader/views/DragLayout;->access$0(Lcom/aio/downloader/views/DragLayout;)I

    move-result v0

    int-to-double v0, v0

    iget-object v2, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    # getter for: Lcom/aio/downloader/views/DragLayout;->range:I
    invoke-static {v2}, Lcom/aio/downloader/views/DragLayout;->access$1(Lcom/aio/downloader/views/DragLayout;)I

    move-result v2

    int-to-double v2, v2

    const-wide v4, 0x3fe6666666666666L    # 0.7

    mul-double/2addr v2, v4

    cmpl-double v0, v0, v2

    if-lez v0, :cond_3

    .line 89
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/views/DragLayout;->open()V

    goto :goto_0

    .line 91
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/views/DragLayout$1;->this$0:Lcom/aio/downloader/views/DragLayout;

    invoke-virtual {v0}, Lcom/aio/downloader/views/DragLayout;->close()V

    goto :goto_0
.end method

.method public tryCaptureView(Landroid/view/View;I)Z
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "pointerId"    # I

    .prologue
    .line 71
    const/4 v0, 0x1

    return v0
.end method
