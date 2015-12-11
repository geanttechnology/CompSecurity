.class Lcom/aio/downloader/activity/MyMainActivity$Mya5;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Mya5"
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

.field private url1:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4316
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 4327
    const-string v1, "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1"

    iput-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->url1:Ljava/lang/String;

    .line 4329
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->url1:Ljava/lang/String;

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 4330
    .local v0, "jsonData":Ljava/lang/String;
    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 4335
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 4336
    if-nez p1, :cond_0

    .line 4341
    :goto_0
    return-void

    .line 4339
    :cond_0
    const-string v0, "asd"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "result="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4340
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya5;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->ShowResult6(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/aio/downloader/activity/MyMainActivity;->access$37(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 0

    .prologue
    .line 4321
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 4322
    return-void
.end method
