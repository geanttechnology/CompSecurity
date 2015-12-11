.class Lcom/aio/downloader/activity/MyDownloaderList$4;
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
.field private down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 247
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MyDownloaderList$4;)Lcom/aio/downloader/activity/MyDownloaderList;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/16 v7, 0x6e

    const/4 v6, 0x0

    .line 254
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyDownloaderList;->access$16(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v3

    if-nez v3, :cond_0

    .line 255
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    new-instance v4, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v4, p1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    invoke-static {v3, v4}, Lcom/aio/downloader/activity/MyDownloaderList;->access$17(Lcom/aio/downloader/activity/MyDownloaderList;Lcom/aio/downloader/db/TypeDbUtils;)V

    .line 257
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyDownloaderList;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/MyApplcation;->getDownloadSuccess()Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 258
    new-instance v3, Ljava/lang/Thread;

    new-instance v4, Lcom/aio/downloader/activity/MyDownloaderList$4$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/MyDownloaderList$4$1;-><init>(Lcom/aio/downloader/activity/MyDownloaderList$4;)V

    invoke-direct {v3, v4}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 276
    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 277
    const-string v3, "qwa"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "down.getSerial()="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    new-instance v0, Landroid/content/Intent;

    const-string v3, "downloadsuccess"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 279
    .local v0, "intent_down":Landroid/content/Intent;
    const-string v3, "headimage"

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 280
    const-string v3, "appname"

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 281
    const-string v3, "baoming"

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 282
    const-string v3, "serial"

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 283
    const-string v3, "filepathdown"

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 284
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v3

    if-ne v3, v7, :cond_1

    .line 285
    const-string v3, "iddown"

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 287
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "mp3"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->down:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "video"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 290
    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$4;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    const-string v4, "downloadcomplete"

    invoke-virtual {v3, v4, v6}, Lcom/aio/downloader/activity/MyDownloaderList;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 292
    .local v2, "userInfo2":Landroid/content/SharedPreferences;
    const-string v3, "wycdc"

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 293
    .local v1, "show":I
    if-nez v1, :cond_2

    .line 294
    invoke-virtual {p1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 297
    .end local v1    # "show":I
    .end local v2    # "userInfo2":Landroid/content/SharedPreferences;
    :cond_2
    const-string v3, "downloadsuccess"

    invoke-static {p1, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 298
    sget-object v3, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    invoke-virtual {v3, v7}, Landroid/app/NotificationManager;->cancel(I)V

    .line 299
    return-void
.end method
