.class Lcom/aio/downloader/activity/MyMainActivity$Mya4;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya4"
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
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4528
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$Mya4;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 4539
    const-string v1, "http://welaf.com/fun/list.php?tab=random&page=1"

    .line 4540
    .local v1, "url":Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 4541
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$Mya4;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 4546
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 4547
    if-nez p1, :cond_0

    .line 4556
    :goto_0
    return-void

    .line 4552
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->ShowResult2(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/activity/MyMainActivity;->access$54(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 4532
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 4533
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya4;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 4535
    return-void
.end method
