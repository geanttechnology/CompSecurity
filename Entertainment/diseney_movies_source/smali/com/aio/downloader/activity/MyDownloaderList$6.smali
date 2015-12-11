.class Lcom/aio/downloader/activity/MyDownloaderList$6;
.super Landroid/content/BroadcastReceiver;
.source "MyDownloaderList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyDownloaderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$6;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 561
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 565
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$6;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 566
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$6;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->mlistview:Lcom/aio/downloader/views/MyListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$19(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/views/MyListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$6;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$18(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/MyListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 567
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$6;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$18(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->notifyDataSetChanged()V

    .line 568
    return-void
.end method
