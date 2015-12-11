.class Lcom/aio/downloader/activity/VideoDownloadedActivity$2;
.super Landroid/content/BroadcastReceiver;
.source "VideoDownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/VideoDownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoDownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoDownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;->this$0:Lcom/aio/downloader/activity/VideoDownloadedActivity;

    .line 89
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;->this$0:Lcom/aio/downloader/activity/VideoDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/VideoDownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->access$0(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 95
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;->this$0:Lcom/aio/downloader/activity/VideoDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/VideoDownloadedActivity;->video_lv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->access$3(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;->this$0:Lcom/aio/downloader/activity/VideoDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->access$2(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 96
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoDownloadedActivity$2;->this$0:Lcom/aio/downloader/activity/VideoDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/VideoDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoDownloadedActivity;->access$2(Lcom/aio/downloader/activity/VideoDownloadedActivity;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 97
    return-void
.end method
