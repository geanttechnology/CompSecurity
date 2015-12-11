.class Lcom/aio/downloader/activity/MyMainActivity$16;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onCreate(Landroid/os/Bundle;)V
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
.field private model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 1569
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$16;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 9
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    const/4 v8, 0x0

    .line 1576
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1577
    iget-object v6, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->appid:Ljava/lang/String;
    invoke-static {v6}, Lcom/aio/downloader/activity/MyMainActivity;->access$78(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 1576
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1578
    .local v4, "url":Ljava/lang/String;
    const-string v5, "goo"

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "url="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1579
    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1580
    .local v1, "jsonData":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 1608
    :cond_0
    :goto_0
    return-object v8

    .line 1585
    :cond_1
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1586
    .local v2, "object":Lorg/json/JSONObject;
    const-string v5, "status"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 1587
    new-instance v5, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1589
    const-string v5, "pdt"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 1590
    .local v3, "object2":Lorg/json/JSONObject;
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1591
    const-string v6, "title"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1590
    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 1592
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1593
    const-string v6, "author_title"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1592
    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAuthor_title(Ljava/lang/String;)V

    .line 1594
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1595
    const-string v6, "icon"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 1596
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1597
    const-string v6, "version"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1596
    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setVersion(Ljava/lang/String;)V

    .line 1598
    iget-object v5, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1599
    const-string v6, "serial"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v6

    .line 1598
    invoke-virtual {v5, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1604
    .end local v2    # "object":Lorg/json/JSONObject;
    .end local v3    # "object2":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 1606
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$16;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 5
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 1614
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 1616
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->appid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$78(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v2

    .line 1617
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v3

    .line 1618
    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$16;->model_aio:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSerial()I

    move-result v4

    .line 1616
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk6(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1623
    :goto_0
    return-void

    .line 1619
    :catch_0
    move-exception v0

    goto :goto_0
.end method
