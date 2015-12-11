.class Lcom/aio/downloader/activity/MyMainActivity$4;
.super Landroid/content/BroadcastReceiver;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 342
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyMainActivity$4;)Lcom/aio/downloader/activity/MyMainActivity;
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 347
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    new-instance v1, Lnet/tsz/afinal/FinalDBChen;

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 348
    const-string v4, "download2.db"

    invoke-virtual {v3, v4}, Lcom/aio/downloader/activity/MyMainActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 347
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$7(Lcom/aio/downloader/activity/MyMainActivity;Lnet/tsz/afinal/FinalDBChen;)V

    .line 349
    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$8(Lcom/aio/downloader/activity/MyMainActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 350
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 349
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v6, v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$9(Lcom/aio/downloader/activity/MyMainActivity;Ljava/util/List;)V

    .line 351
    new-instance v0, Lcom/aio/downloader/activity/MyMainActivity$4$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MyMainActivity$4$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$4;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 369
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity$4$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 375
    :goto_0
    return-void

    .line 371
    :catch_0
    move-exception v0

    goto :goto_0
.end method
