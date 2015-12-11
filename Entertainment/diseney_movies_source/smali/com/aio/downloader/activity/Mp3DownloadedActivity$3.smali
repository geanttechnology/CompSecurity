.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;
.super Landroid/content/BroadcastReceiver;
.source "Mp3DownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    .line 118
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 122
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 123
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3_lv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$4(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$2(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 124
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$2(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->notifyDataSetChanged()V

    .line 125
    return-void
.end method
