.class Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;
.super Landroid/os/AsyncTask;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;
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
        "Ljava/util/ArrayList",
        "<",
        "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;)V
    .locals 0

    .prologue
    .line 1585
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;
    .locals 12
    .param p1, "params"    # [Ljava/lang/Void;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Void;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 1597
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id="

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1598
    iget-object v10, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->id:Ljava/lang/String;
    invoke-static {v10}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$21(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 1597
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1600
    .local v7, "url":Ljava/lang/String;
    invoke-static {v7}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1601
    .local v3, "jsonData":Ljava/lang/String;
    const-string v9, "gak"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "=====================jsonData="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1602
    if-nez v3, :cond_1

    .line 1645
    :cond_0
    :goto_0
    return-object v8

    .line 1606
    :cond_1
    iget-object v9, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v9, v10}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$22(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/ArrayList;)V

    .line 1608
    :try_start_0
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1609
    .local v5, "object":Lorg/json/JSONObject;
    const-string v9, "status"

    invoke-virtual {v5, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    const/4 v10, 0x1

    if-ne v9, v10, :cond_0

    .line 1610
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    new-instance v9, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    invoke-static {v8, v9}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$23(Lcom/aio/downloader/activity/AppDetailsActivity;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 1611
    const-string v8, "pdt"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 1612
    .local v6, "object2":Lorg/json/JSONObject;
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "id"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 1613
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "title"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 1614
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "author_title"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAuthor_title(Ljava/lang/String;)V

    .line 1615
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "icon"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 1616
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    .line 1617
    const-string v9, "rating"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 1616
    invoke-static {v9}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v9

    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 1618
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "version"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setVersion(Ljava/lang/String;)V

    .line 1619
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "release_date"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRelease_date(Ljava/lang/String;)V

    .line 1620
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "downloads"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloads(Ljava/lang/String;)V

    .line 1621
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "size"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 1622
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "price"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPrice(Ljava/lang/String;)V

    .line 1623
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "detail"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDetail(Ljava/lang/String;)V

    .line 1624
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "has_apk"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_apk(Ljava/lang/String;)V

    .line 1625
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "is_official"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIs_official(Ljava/lang/String;)V

    .line 1626
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "serial"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 1627
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "rating_count"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSetCount(Ljava/lang/String;)V

    .line 1628
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "short_desc"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPpshort_desc(Ljava/lang/String;)V

    .line 1629
    const-string v8, "screenshots"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1630
    .local v0, "array":Lorg/json/JSONArray;
    const/4 v4, 0x0

    .line 1631
    .local v4, "modelscreenshots":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v8

    if-lt v2, v8, :cond_2

    .line 1645
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v4    # "modelscreenshots":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v5    # "object":Lorg/json/JSONObject;
    .end local v6    # "object2":Lorg/json/JSONObject;
    :goto_2
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->list:Ljava/util/ArrayList;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$24(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;

    move-result-object v8

    goto/16 :goto_0

    .line 1632
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v4    # "modelscreenshots":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .restart local v5    # "object":Lorg/json/JSONObject;
    .restart local v6    # "object2":Lorg/json/JSONObject;
    :cond_2
    :try_start_1
    new-instance v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .end local v4    # "modelscreenshots":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-direct {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 1633
    .restart local v4    # "modelscreenshots":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setScreenshots(Ljava/lang/String;)V

    .line 1634
    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->list:Ljava/util/ArrayList;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$24(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 1631
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 1641
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v4    # "modelscreenshots":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v5    # "object":Lorg/json/JSONObject;
    .end local v6    # "object2":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 1643
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/util/ArrayList;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->onPostExecute(Ljava/util/ArrayList;)V

    return-void
.end method

.method protected onPostExecute(Ljava/util/ArrayList;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 1650
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 1651
    if-nez p1, :cond_2

    .line 1652
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wocao:I
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$17(Lcom/aio/downloader/activity/AppDetailsActivity;)I

    move-result v0

    if-nez v0, :cond_0

    .line 1653
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 1654
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->rl_sad:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$25(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1655
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 1656
    const-string v1, "acquire_fail"

    .line 1655
    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 1770
    :goto_0
    return-void

    .line 1658
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$26(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    .line 1659
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$10(Lcom/aio/downloader/activity/AppDetailsActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "file_id"

    .line 1660
    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 1661
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 1659
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1661
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 1659
    if-nez v0, :cond_1

    .line 1662
    new-instance v6, Lcom/aio/downloader/utils/MyAppInfo;

    .line 1663
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 1662
    invoke-direct {v6, v0}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 1665
    .local v6, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Lcom/aio/downloader/utils/MyAppInfo;->getAppName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$28(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;)V

    .line 1666
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Lcom/aio/downloader/utils/MyAppInfo;->getAppIcon(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$29(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/graphics/drawable/Drawable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1672
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->wycmyid:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$27(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appName:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$19(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->myUpver:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$30(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x6e

    .line 1673
    iget-object v5, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appIcon2:Landroid/graphics/drawable/Drawable;
    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$31(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-static {v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->drawableToBitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 1672
    invoke-virtual/range {v0 .. v5}, Lcom/aio/downloader/activity/AppDetailsActivity;->MydownloadApk_Update(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V

    .line 1674
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->bt_dea_download:Landroid/widget/Button;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$32(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/Button;

    move-result-object v0

    .line 1675
    const v1, 0x7f02006e

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundResource(I)V

    .line 1676
    new-instance v9, Landroid/content/Intent;

    const-string v0, "setbroadUpdate"

    invoke-direct {v9, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1678
    .local v9, "mIntent":Landroid/content/Intent;
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0, v9}, Lcom/aio/downloader/activity/AppDetailsActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 1668
    .end local v9    # "mIntent":Landroid/content/Intent;
    :catch_0
    move-exception v7

    .line 1670
    .local v7, "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 1681
    .end local v6    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v7    # "e":Ljava/lang/Exception;
    :cond_1
    new-instance v10, Landroid/os/Message;

    invoke-direct {v10}, Landroid/os/Message;-><init>()V

    .line 1682
    .local v10, "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v10, Landroid/os/Message;->what:I

    .line 1683
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/AppDetailsActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v10}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_0

    .line 1689
    .end local v10    # "msg":Landroid/os/Message;
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtoprel:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$6(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1690
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->ll_dea_sh:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$33(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1691
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->mygallery:Lcom/aio/downloader/views/HorizontalListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$34(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/HorizontalListView;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/views/HorizontalListView;->setVisibility(I)V

    .line 1692
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->ll_gall:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$35(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1694
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->view1:Landroid/view/View;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$36(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1695
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->view2:Landroid/view/View;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$37(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 1698
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->tv_readmore:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$38(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1700
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->rl_yuancheng:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$39(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1702
    const/4 v11, 0x0

    .line 1704
    .local v11, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_1
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 1705
    const-string v1, "com.freepezzle.hexcrush"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v11

    .line 1709
    :goto_2
    if-eqz v11, :cond_4

    .line 1710
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->ll_free:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$40(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1714
    :goto_3
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailscroll:Landroid/widget/ScrollView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$41(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ScrollView;

    move-result-object v0

    const/16 v1, 0x21

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->fullScroll(I)Z

    .line 1717
    :try_start_2
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$42(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailicon:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$43(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 1718
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$42(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailicon1:Landroid/widget/ImageView;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$44(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 1719
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$45(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1720
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle1:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$46(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1721
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailauthortitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$47(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getAuthor_title()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1722
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailratingbar:Landroid/widget/RatingBar;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$48(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RatingBar;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRating()Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setRating(F)V

    .line 1723
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->version:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$49(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Version:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1724
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->date:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$50(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getRelease_date()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1725
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->device:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$51(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSize()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1726
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloads:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$52(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Downloads:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDownloads()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1727
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detail:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$53(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getDetail()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1728
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->tv_rating_count:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$54(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v2}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getSetCount()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1729
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->tv_short_desc:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$55(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPpshort_desc()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1730
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$45(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$56(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 1731
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailtitle1:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$46(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace:Landroid/graphics/Typeface;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$56(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 1732
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->appdetailauthortitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$47(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->typeFace2:Landroid/graphics/Typeface;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$57(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 1734
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPrice()Ljava/lang/String;

    move-result-object v0

    const-string v1, "FREE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1735
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->tv_price:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$58(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 1741
    :goto_4
    :try_start_3
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIs_official()Ljava/lang/String;

    move-result-object v8

    .line 1742
    .local v8, "is_official":Ljava/lang/String;
    const-string v0, "1"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1743
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailplaytop:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$59(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 1752
    .end local v8    # "is_official":Ljava/lang/String;
    :cond_3
    :goto_5
    :try_start_4
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->mygallery:Lcom/aio/downloader/views/HorizontalListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$34(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/HorizontalListView;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;

    iget-object v2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 1753
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-direct {v1, v2, v3}, Lcom/aio/downloader/activity/AppDetailsActivity$ImageGalleryAdapter;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity;Landroid/content/Context;)V

    .line 1752
    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/HorizontalListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1754
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->mygallery:Lcom/aio/downloader/views/HorizontalListView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$34(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/views/HorizontalListView;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/HorizontalListView;->setSelection(I)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 1759
    :goto_6
    :try_start_5
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 1761
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    const-string v1, "1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 1762
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->downloadapk:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$60(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto/16 :goto_0

    .line 1766
    :catch_1
    move-exception v0

    goto/16 :goto_0

    .line 1706
    :catch_2
    move-exception v7

    .line 1707
    .local v7, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v7}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 1712
    .end local v7    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->ll_free:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$40(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto/16 :goto_3

    .line 1737
    :cond_5
    :try_start_6
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->tv_price:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$58(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getPrice()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1738
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->tv_price:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$58(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setFlags(I)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1

    goto/16 :goto_4

    .line 1744
    .restart local v8    # "is_official":Ljava/lang/String;
    :cond_6
    :try_start_7
    const-string v0, "0"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1745
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailplaytop:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$59(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    goto/16 :goto_5

    .line 1747
    .end local v8    # "is_official":Ljava/lang/String;
    :catch_3
    move-exception v0

    goto/16 :goto_5

    .line 1763
    :cond_7
    :try_start_8
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$18(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v0

    const-string v1, "0"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_1

    goto/16 :goto_0

    .line 1755
    :catch_4
    move-exception v0

    goto/16 :goto_6
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 1588
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 1589
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$Mya1;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 1592
    return-void
.end method
