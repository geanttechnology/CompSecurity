.class Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;
.super Landroid/os/AsyncTask;
.source "Mp3_Popular_Fragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;
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
.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 346
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "http://android.downloadatoz.com/_201409/market/mp3_list_more.php?tab=popular&page="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 347
    iget-object v3, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->page:I
    invoke-static {v3}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$5(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 346
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 348
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 349
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 354
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 355
    if-nez p1, :cond_0

    .line 367
    :goto_0
    return-void

    .line 359
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # invokes: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->ShowResult(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$6(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 339
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 340
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$Mya1;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$0(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 342
    return-void
.end method
