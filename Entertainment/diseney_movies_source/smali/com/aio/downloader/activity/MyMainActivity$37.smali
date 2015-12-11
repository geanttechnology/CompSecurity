.class Lcom/aio/downloader/activity/MyMainActivity$37;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk2(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$id:Ljava/lang/String;

    iput-object p3, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$title:Ljava/lang/String;

    iput-object p4, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$icon:Ljava/lang/String;

    iput p5, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$appserial:I

    .line 3461
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 3462
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$37;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 8
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    .line 3477
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$8(Lcom/aio/downloader/activity/MyMainActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 3478
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity;->access$93(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 3479
    const-string v4, "downloadtask2"

    .line 3477
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 3479
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 3481
    new-instance v6, Landroid/os/Message;

    invoke-direct {v6}, Landroid/os/Message;-><init>()V

    .line 3482
    .local v6, "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v6, Landroid/os/Message;->what:I

    .line 3483
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v6}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 3510
    :goto_0
    return-object v5

    .line 3486
    .end local v6    # "msg":Landroid/os/Message;
    :cond_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 3487
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3488
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 3489
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$id:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, ".apk"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 3486
    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 3490
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    .line 3492
    .local v7, "path":Ljava/lang/String;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$93(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 3493
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v7}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 3495
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 3496
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 3497
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 3498
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 3499
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 3500
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 3501
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 3502
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 3503
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 3504
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3505
    new-instance v6, Landroid/os/Message;

    invoke-direct {v6}, Landroid/os/Message;-><init>()V

    .line 3506
    .restart local v6    # "msg":Landroid/os/Message;
    const/4 v0, 0x3

    iput v0, v6, Landroid/os/Message;->what:I

    .line 3507
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v6}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$37;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 3516
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 3518
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 3520
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 3466
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 3468
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$37;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 3470
    return-void
.end method
