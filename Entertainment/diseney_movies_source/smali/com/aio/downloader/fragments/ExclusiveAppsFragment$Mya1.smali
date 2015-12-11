.class Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;
.super Landroid/os/AsyncTask;
.source "ExclusiveAppsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/ExclusiveAppsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya1"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/ExclusiveAppsFragment;)V
    .locals 0

    .prologue
    .line 339
    iput-object p1, p0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 5
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 350
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=exclusive&page="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 351
    iget-object v3, p0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    # getter for: Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->page:I
    invoke-static {v3}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->access$1(Lcom/aio/downloader/fragments/ExclusiveAppsFragment;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 350
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 352
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 353
    .local v0, "jsonData":Ljava/lang/String;
    const-string v2, "www"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "ex="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 354
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 359
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 360
    if-nez p1, :cond_0

    .line 361
    iget-object v0, p0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->access$2(Lcom/aio/downloader/fragments/ExclusiveAppsFragment;Z)V

    .line 369
    :goto_0
    return-void

    .line 365
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    # invokes: Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->ShowResult(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->access$3(Lcom/aio/downloader/fragments/ExclusiveAppsFragment;Ljava/lang/String;)V

    .line 366
    iget-object v0, p0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->access$2(Lcom/aio/downloader/fragments/ExclusiveAppsFragment;Z)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 343
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 344
    iget-object v0, p0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment$Mya1;->this$0:Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    # getter for: Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;->access$0(Lcom/aio/downloader/fragments/ExclusiveAppsFragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 346
    return-void
.end method
