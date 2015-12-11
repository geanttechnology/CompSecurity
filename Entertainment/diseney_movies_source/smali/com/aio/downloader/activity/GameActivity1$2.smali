.class Lcom/aio/downloader/activity/GameActivity1$2;
.super Landroid/content/BroadcastReceiver;
.source "GameActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/GameActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/GameActivity1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/GameActivity1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    .line 147
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/GameActivity1$2;)Lcom/aio/downloader/activity/GameActivity1;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 153
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    new-instance v1, Lnet/tsz/afinal/FinalDBChen;

    iget-object v2, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    .line 154
    iget-object v3, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    const-string v4, "download2.db"

    invoke-virtual {v3, v4}, Lcom/aio/downloader/activity/GameActivity1;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 153
    invoke-static {v0, v1}, Lcom/aio/downloader/activity/GameActivity1;->access$1(Lcom/aio/downloader/activity/GameActivity1;Lnet/tsz/afinal/FinalDBChen;)V

    .line 155
    iget-object v6, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$2;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    # getter for: Lcom/aio/downloader/activity/GameActivity1;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/GameActivity1;->access$2(Lcom/aio/downloader/activity/GameActivity1;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 156
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 155
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v6, v0}, Lcom/aio/downloader/activity/GameActivity1;->access$3(Lcom/aio/downloader/activity/GameActivity1;Ljava/util/List;)V

    .line 157
    new-instance v0, Lcom/aio/downloader/activity/GameActivity1$2$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/GameActivity1$2$1;-><init>(Lcom/aio/downloader/activity/GameActivity1$2;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 177
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/GameActivity1$2$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 183
    :goto_0
    return-void

    .line 179
    :catch_0
    move-exception v0

    goto :goto_0
.end method
