.class Lco/vine/android/recorder/VineRecorder$25;
.super Ljava/lang/Object;
.source "VineRecorder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/recorder/VineRecorder;->onUiResumed(Landroid/app/Activity;Ljava/lang/Runnable;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/recorder/VineRecorder;


# direct methods
.method constructor <init>(Lco/vine/android/recorder/VineRecorder;)V
    .locals 0

    .prologue
    .line 1585
    iput-object p1, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1588
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    move-result-object v0

    const/4 v1, 0x0

    iput-object v1, v0, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->toPlay:Lco/vine/android/recorder/RecordSegment;

    .line 1589
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mPlayButtonOnClickListener:Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2900(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;

    move-result-object v0

    iput-boolean v3, v0, Lco/vine/android/recorder/VineRecorder$PlayButtonOnClickListener;->forceRefresh:Z

    .line 1590
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    invoke-virtual {v0, v3}, Lco/vine/android/recorder/VineRecorder;->pausePreview(Z)V

    .line 1591
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1592
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/recorder/SegmentEditorAdapter;->undoDelete()V

    .line 1593
    iget-object v1, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mEditorAdapter:Lco/vine/android/recorder/SegmentEditorAdapter;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2300(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/recorder/SegmentEditorAdapter;

    move-result-object v0

    invoke-virtual {v0, v2}, Lco/vine/android/recorder/SegmentEditorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/RecordSegment;

    invoke-virtual {v1, v0}, Lco/vine/android/recorder/VineRecorder;->showThumbnailOverlay(Lco/vine/android/recorder/RecordSegment;)V

    .line 1595
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    const/4 v1, 0x2

    # invokes: Lco/vine/android/recorder/VineRecorder;->animateTopButtons(I)V
    invoke-static {v0, v1}, Lco/vine/android/recorder/VineRecorder;->access$4100(Lco/vine/android/recorder/VineRecorder;I)V

    .line 1596
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$4200(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1597
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mUndoButton:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$4200(Lco/vine/android/recorder/VineRecorder;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 1599
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 1600
    iget-object v0, p0, Lco/vine/android/recorder/VineRecorder$25;->this$0:Lco/vine/android/recorder/VineRecorder;

    # getter for: Lco/vine/android/recorder/VineRecorder;->mDragSortWidget:Lco/vine/android/dragsort/DragSortWidget;
    invoke-static {v0}, Lco/vine/android/recorder/VineRecorder;->access$2600(Lco/vine/android/recorder/VineRecorder;)Lco/vine/android/dragsort/DragSortWidget;

    move-result-object v0

    invoke-virtual {v0, v2}, Lco/vine/android/dragsort/DragSortWidget;->setFocused(I)V

    .line 1602
    :cond_2
    return-void
.end method
