.class Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdapterDataSetObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Lcom/amazon/retailsearch/android/ui/HorizontalListView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/HorizontalListView$1;

    .prologue
    .line 200
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;-><init>(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 3

    .prologue
    .line 206
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    monitor-enter v1

    .line 208
    :try_start_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    const/4 v2, 0x1

    # setter for: Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mDataChanged:Z
    invoke-static {v0, v2}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->access$002(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Z)Z

    .line 209
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 210
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->invalidate()V

    .line 211
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    .line 212
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->access$102(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Z)Z

    .line 213
    return-void

    .line 209
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public onInvalidated()V
    .locals 2

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    # invokes: Lcom/amazon/retailsearch/android/ui/HorizontalListView;->reset()V
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->access$200(Lcom/amazon/retailsearch/android/ui/HorizontalListView;)V

    .line 219
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->invalidate()V

    .line 220
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->requestLayout()V

    .line 221
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/HorizontalListView$AdapterDataSetObserver;->this$0:Lcom/amazon/retailsearch/android/ui/HorizontalListView;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/HorizontalListView;->mCanReceiveKeyEvent:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/HorizontalListView;->access$102(Lcom/amazon/retailsearch/android/ui/HorizontalListView;Z)Z

    .line 222
    return-void
.end method
