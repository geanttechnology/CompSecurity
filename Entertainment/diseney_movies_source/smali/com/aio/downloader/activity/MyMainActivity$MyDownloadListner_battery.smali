.class Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;
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
    name = "MyDownloadListner_battery"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4892
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDownloadComplete(I)V
    .locals 4
    .param p1, "id"    # I

    .prologue
    .line 4895
    const-string v0, "battery"

    const-string v1, "download battery completed"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4897
    :try_start_0
    const-string v0, "battery"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "==="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$60(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/MyMainActivity;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4901
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERY:Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$60(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->AIOBATTERYAPK:Ljava/io/File;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$61(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/io/File;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/aio/downloader/utils/Myutils;->copyfile(Ljava/io/File;Ljava/io/File;Ljava/lang/Boolean;)V

    .line 4902
    return-void

    .line 4898
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onDownloadFailed(IILjava/lang/String;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 4906
    const-string v0, "jone"

    const-string v1, "DownloadFailed"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4907
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$62(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 4908
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4910
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
    .line 4916
    const-string v0, "jone"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4917
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->downloadId_battery:I
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$62(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 4919
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyDownloadListner_battery;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mProgress1:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$59(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, p6}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 4923
    :cond_0
    return-void
.end method
