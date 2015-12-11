.class Lco/vine/android/views/HorizontalListView$PerformClick;
.super Ljava/lang/Object;
.source "HorizontalListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/views/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PerformClick"
.end annotation


# instance fields
.field public clickMotionPosition:I

.field private mOriginalAttachCount:I

.field final synthetic this$0:Lco/vine/android/views/HorizontalListView;


# direct methods
.method public constructor <init>(Lco/vine/android/views/HorizontalListView;)V
    .locals 0

    .prologue
    .line 1370
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1371
    return-void
.end method


# virtual methods
.method public rememberWindowAttachCount()V
    .locals 1

    .prologue
    .line 1374
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    # invokes: Lco/vine/android/views/HorizontalListView;->getWindowAttachCount()I
    invoke-static {v0}, Lco/vine/android/views/HorizontalListView;->access$1600(Lco/vine/android/views/HorizontalListView;)I

    move-result v0

    iput v0, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->mOriginalAttachCount:I

    .line 1375
    return-void
.end method

.method public run()V
    .locals 6

    .prologue
    .line 1384
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mDataChanged:Z
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$100(Lco/vine/android/views/HorizontalListView;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1400
    :cond_0
    :goto_0
    return-void

    .line 1388
    :cond_1
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mAdapter:Landroid/widget/ListAdapter;
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$500(Lco/vine/android/views/HorizontalListView;)Landroid/widget/ListAdapter;

    move-result-object v0

    .line 1389
    .local v0, "adapter":Landroid/widget/ListAdapter;
    iget v1, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->clickMotionPosition:I

    .line 1390
    .local v1, "motionPosition":I
    if-eqz v0, :cond_0

    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mItemCount:I
    invoke-static {v3}, Lco/vine/android/views/HorizontalListView;->access$400(Lco/vine/android/views/HorizontalListView;)I

    move-result v3

    if-lez v3, :cond_0

    const/4 v3, -0x1

    if-eq v1, v3, :cond_0

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v3

    if-ge v1, v3, :cond_0

    invoke-virtual {p0}, Lco/vine/android/views/HorizontalListView$PerformClick;->sameWindow()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1393
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    iget-object v4, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    # getter for: Lco/vine/android/views/HorizontalListView;->mFirstVisiblePos:I
    invoke-static {v4}, Lco/vine/android/views/HorizontalListView;->access$800(Lco/vine/android/views/HorizontalListView;)I

    move-result v4

    sub-int v4, v1, v4

    invoke-virtual {v3, v4}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 1396
    .local v2, "view":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 1397
    iget-object v3, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-interface {v0, v1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v4

    invoke-virtual {v3, v2, v1, v4, v5}, Lco/vine/android/views/HorizontalListView;->performItemClick(Landroid/view/View;IJ)Z

    goto :goto_0
.end method

.method public sameWindow()Z
    .locals 2

    .prologue
    .line 1378
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v0}, Lco/vine/android/views/HorizontalListView;->hasWindowFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->this$0:Lco/vine/android/views/HorizontalListView;

    # invokes: Lco/vine/android/views/HorizontalListView;->getWindowAttachCount()I
    invoke-static {v0}, Lco/vine/android/views/HorizontalListView;->access$1700(Lco/vine/android/views/HorizontalListView;)I

    move-result v0

    iget v1, p0, Lco/vine/android/views/HorizontalListView$PerformClick;->mOriginalAttachCount:I

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
