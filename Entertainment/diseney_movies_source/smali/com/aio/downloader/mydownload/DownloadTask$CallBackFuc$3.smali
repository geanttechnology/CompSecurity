.class Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;
.super Landroid/os/AsyncTask;
.source "DownloadTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->onSuccess(Ljava/io/File;)V
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
.field final synthetic this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;


# direct methods
.method constructor <init>(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    .line 648
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 653
    const-wide/16 v1, 0x7d0

    :try_start_0
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 657
    :goto_0
    const/4 v1, 0x0

    return-object v1

    .line 654
    :catch_0
    move-exception v0

    .line 655
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 12
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    const/16 v11, 0x6e

    const/4 v1, 0x0

    .line 662
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 663
    new-instance v7, Landroid/app/Notification;

    invoke-direct {v7}, Landroid/app/Notification;-><init>()V

    .line 664
    .local v7, "notification2":Landroid/app/Notification;
    const/16 v0, 0x10

    iput v0, v7, Landroid/app/Notification;->flags:I

    .line 665
    const v0, 0x7f0200ec

    iput v0, v7, Landroid/app/Notification;->icon:I

    .line 666
    new-instance v6, Landroid/content/Intent;

    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v0

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v0

    .line 667
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 666
    invoke-direct {v6, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 668
    .local v6, "intent2":Landroid/content/Intent;
    const/high16 v0, 0x10000000

    invoke-virtual {v6, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 670
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v0

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v0

    .line 671
    const/high16 v2, 0x8000000

    .line 670
    invoke-static {v0, v11, v6, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v8

    .line 672
    .local v8, "pendingIntent2":Landroid/app/PendingIntent;
    iput-object v8, v7, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 673
    new-instance v9, Landroid/widget/RemoteViews;

    .line 674
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v0

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask;->access$3(Lcom/aio/downloader/mydownload/DownloadTask;)Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 675
    const v2, 0x7f030090

    .line 673
    invoke-direct {v9, v0, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 676
    .local v9, "rv2":Landroid/widget/RemoteViews;
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v10

    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v0

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask;->access$9(Lcom/aio/downloader/mydownload/DownloadTask;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    .line 677
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 678
    const-string v4, "downloadtask2"

    move-object v2, v1

    move-object v5, v1

    .line 676
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v10, v0}, Lcom/aio/downloader/mydownload/DownloadTask;->access$11(Lcom/aio/downloader/mydownload/DownloadTask;Ljava/util/List;)V

    .line 679
    const v0, 0x7f07031c

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Downloading("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 680
    iget-object v2, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v2

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->ds:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/mydownload/DownloadTask;->access$12(Lcom/aio/downloader/mydownload/DownloadTask;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") & Completed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 681
    sget v2, Lcom/aio/downloader/utils/publicTools;->noticomplete:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 679
    invoke-virtual {v9, v0, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 683
    const v0, 0x7f07031b

    .line 684
    const-string v1, "kk:mm"

    .line 685
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 684
    invoke-static {v1, v2, v3}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v1

    .line 682
    invoke-virtual {v9, v0, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 686
    iput-object v9, v7, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 687
    iget-object v0, p0, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc$3;->this$1:Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->this$0:Lcom/aio/downloader/mydownload/DownloadTask;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;->access$2(Lcom/aio/downloader/mydownload/DownloadTask$CallBackFuc;)Lcom/aio/downloader/mydownload/DownloadTask;

    move-result-object v0

    # getter for: Lcom/aio/downloader/mydownload/DownloadTask;->ds:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/mydownload/DownloadTask;->access$12(Lcom/aio/downloader/mydownload/DownloadTask;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 688
    sget-object v0, Lcom/aio/downloader/mydownload/DownloadTask;->mNotificationManager:Landroid/app/NotificationManager;

    invoke-virtual {v0, v11, v7}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 691
    :cond_0
    return-void
.end method
