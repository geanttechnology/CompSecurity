.class Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;
.super Ljava/lang/Object;
.source "MyMainActivity.java"

# interfaces
.implements Lcom/thin/downloadmanager/DownloadStatusListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyDownloadListner"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4844
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDownloadComplete(I)V
    .locals 7
    .param p1, "id"    # I

    .prologue
    const/16 v6, 0xe7

    .line 4847
    const-string v4, "jone"

    const-string v5, "download completed"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4848
    new-instance v1, Landroid/app/Notification;

    invoke-direct {v1}, Landroid/app/Notification;-><init>()V

    .line 4849
    .local v1, "notification2":Landroid/app/Notification;
    const/16 v4, 0x10

    iput v4, v1, Landroid/app/Notification;->flags:I

    .line 4850
    const v4, 0x7f0200eb

    iput v4, v1, Landroid/app/Notification;->icon:I

    .line 4851
    new-instance v0, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 4853
    .local v0, "aa":Landroid/content/Intent;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "file://"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOUPDATEFILE:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$55(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 4854
    const-string v5, "aioupdate.apk"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 4853
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    .line 4855
    const-string v5, "application/vnd.android.package-archive"

    .line 4852
    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 4857
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 4858
    const/high16 v5, 0x8000000

    .line 4856
    invoke-static {v4, v6, v0, v5}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 4859
    .local v2, "pendingIntent2":Landroid/app/PendingIntent;
    iput-object v2, v1, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 4860
    new-instance v3, Landroid/widget/RemoteViews;

    .line 4861
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v4}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const v5, 0x7f03008e

    .line 4860
    invoke-direct {v3, v4, v5}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 4863
    .local v3, "rv2":Landroid/widget/RemoteViews;
    iput-object v3, v1, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 4864
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mNotificationManager8:Landroid/app/NotificationManager;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$56(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/app/NotificationManager;

    move-result-object v4

    invoke-virtual {v4, v6, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 4865
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->updateaioApk()V
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$57(Lcom/aio/downloader/activity/MyMainActivity;)V

    .line 4866
    return-void
.end method

.method public onDownloadFailed(IILjava/lang/String;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 4870
    const-string v0, "jone"

    const-string v1, "DownloadFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 4871
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId1:I
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$58(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 4872
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4875
    :cond_0
    return-void
.end method

.method public onProgress(IJJI)V
    .locals 3
    .param p1, "id"    # I
    .param p2, "totalBytes"    # J
    .param p4, "downloadedBytes"    # J
    .param p6, "progress"    # I

    .prologue
    .line 4881
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 4882
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId1:I
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$58(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 4884
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, p6}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4888
    :cond_0
    return-void
.end method
