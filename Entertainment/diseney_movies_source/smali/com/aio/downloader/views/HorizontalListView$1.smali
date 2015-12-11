.class Lcom/aio/downloader/views/HorizontalListView$1;
.super Landroid/database/DataSetObserver;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/HorizontalListView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/HorizontalListView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    .line 68
    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 3

    .prologue
    .line 72
    iget-object v1, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    monitor-enter v1

    .line 73
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lcom/aio/downloader/views/HorizontalListView;->access$2(Lcom/aio/downloader/views/HorizontalListView;Z)V

    .line 72
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 75
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/HorizontalListView;->invalidate()V

    .line 76
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/HorizontalListView;->requestLayout()V

    .line 77
    return-void

    .line 72
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public onInvalidated()V
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    # invokes: Lcom/aio/downloader/views/HorizontalListView;->reset()V
    invoke-static {v0}, Lcom/aio/downloader/views/HorizontalListView;->access$3(Lcom/aio/downloader/views/HorizontalListView;)V

    .line 82
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/HorizontalListView;->invalidate()V

    .line 83
    iget-object v0, p0, Lcom/aio/downloader/views/HorizontalListView$1;->this$0:Lcom/aio/downloader/views/HorizontalListView;

    invoke-virtual {v0}, Lcom/aio/downloader/views/HorizontalListView;->requestLayout()V

    .line 84
    return-void
.end method
