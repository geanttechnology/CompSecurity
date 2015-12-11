.class Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;
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
    name = "MyDownloadListner_Caller"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 5037
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDownloadComplete(I)V
    .locals 6
    .param p1, "id"    # I

    .prologue
    .line 5040
    const-string v2, "jone"

    const-string v3, "download caller completed"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5041
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyMainActivity;->access$72(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$73(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V

    .line 5042
    new-instance v1, Landroid/content/Intent;

    const-string v2, "diyicianzhuang"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 5043
    .local v1, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 5045
    :try_start_0
    const-string v2, "caller"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "caller="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$72(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 5050
    :goto_0
    return-void

    .line 5046
    :catch_0
    move-exception v0

    .line 5048
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onDownloadFailed(IILjava/lang/String;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 5054
    const-string v0, "jone"

    const-string v1, "DownloadFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5055
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$74(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 5056
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 5058
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
    .line 5064
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 5065
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId_caller:I
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$74(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 5067
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_Caller;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, p6}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 5071
    :cond_0
    return-void
.end method
