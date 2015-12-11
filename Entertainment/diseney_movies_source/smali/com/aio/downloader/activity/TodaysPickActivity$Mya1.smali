.class Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;
.super Landroid/os/AsyncTask;
.source "TodaysPickActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/TodaysPickActivity;
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
.field final synthetic this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

.field private url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/TodaysPickActivity;)V
    .locals 0

    .prologue
    .line 523
    iput-object p1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 534
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->todayid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$2(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 536
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=rs&id="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 537
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->todayid:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$2(Lcom/aio/downloader/activity/TodaysPickActivity;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&page="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->page:I
    invoke-static {v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$3(Lcom/aio/downloader/activity/TodaysPickActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 536
    iput-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->url:Ljava/lang/String;

    .line 544
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->url:Ljava/lang/String;

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 545
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0

    .line 541
    .end local v0    # "jsonData":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 542
    iget-object v2, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->page:I
    invoke-static {v2}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$3(Lcom/aio/downloader/activity/TodaysPickActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 541
    iput-object v1, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->url:Ljava/lang/String;

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 550
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 551
    if-nez p1, :cond_0

    .line 556
    :goto_0
    return-void

    .line 555
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # invokes: Lcom/aio/downloader/activity/TodaysPickActivity;->ShowResult(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$4(Lcom/aio/downloader/activity/TodaysPickActivity;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 528
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 529
    iget-object v0, p0, Lcom/aio/downloader/activity/TodaysPickActivity$Mya1;->this$0:Lcom/aio/downloader/activity/TodaysPickActivity;

    # getter for: Lcom/aio/downloader/activity/TodaysPickActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/TodaysPickActivity;->access$1(Lcom/aio/downloader/activity/TodaysPickActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 530
    return-void
.end method
