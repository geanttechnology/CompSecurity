.class Lcom/aio/downloader/activity/AppDetailsActivity$9;
.super Landroid/content/BroadcastReceiver;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 235
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AppDetailsActivity$9;)Lcom/aio/downloader/activity/AppDetailsActivity;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 240
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    new-instance v1, Lnet/tsz/afinal/FinalDBChen;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 241
    const-string v4, "download2.db"

    invoke-virtual {v3, v4}, Lcom/aio/downloader/activity/AppDetailsActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 240
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$9(Lcom/aio/downloader/activity/AppDetailsActivity;Lnet/tsz/afinal/FinalDBChen;)V

    .line 242
    iget-object v6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$9;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$10(Lcom/aio/downloader/activity/AppDetailsActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 243
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 242
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v6, v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$11(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/List;)V

    .line 244
    new-instance v0, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$9;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 260
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity$9$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 265
    :goto_0
    return-void

    .line 262
    :catch_0
    move-exception v0

    goto :goto_0
.end method
