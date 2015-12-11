.class Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;
.super Landroid/content/BroadcastReceiver;
.source "RingtoneDownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    .line 123
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/List;

    move-result-object v0

    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v1, Lcom/aio/downloader/utils/Myutils;->successItem:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 129
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtone_lv:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$4(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$2(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 130
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$2(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->notifyDataSetChanged()V

    .line 131
    return-void
.end method
