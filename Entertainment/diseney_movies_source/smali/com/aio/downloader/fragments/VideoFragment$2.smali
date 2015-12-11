.class Lcom/aio/downloader/fragments/VideoFragment$2;
.super Landroid/content/BroadcastReceiver;
.source "VideoFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/VideoFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/VideoFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/VideoFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/VideoFragment$2;->this$0:Lcom/aio/downloader/fragments/VideoFragment;

    .line 87
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment$2;->this$0:Lcom/aio/downloader/fragments/VideoFragment;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/VideoFragment;->access$0(Lcom/aio/downloader/fragments/VideoFragment;)Ljava/util/List;

    move-result-object v0

    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 93
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment$2;->this$0:Lcom/aio/downloader/fragments/VideoFragment;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/VideoFragment;->access$3(Lcom/aio/downloader/fragments/VideoFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment$2;->this$0:Lcom/aio/downloader/fragments/VideoFragment;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment;->access$2(Lcom/aio/downloader/fragments/VideoFragment;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 94
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment$2;->this$0:Lcom/aio/downloader/fragments/VideoFragment;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/fragments/VideoFragment;->access$2(Lcom/aio/downloader/fragments/VideoFragment;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 95
    return-void
.end method
