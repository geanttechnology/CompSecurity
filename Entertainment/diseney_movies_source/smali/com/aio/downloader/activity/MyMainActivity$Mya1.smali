.class Lcom/aio/downloader/activity/MyMainActivity$Mya1;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
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
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 2686
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)Lcom/aio/downloader/activity/MyMainActivity;
    .locals 1

    .prologue
    .line 2686
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;
    .locals 11
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
    const/4 v10, 0x1

    .line 2696
    const/4 v3, 0x0

    .line 2699
    .local v3, "jsonData":Ljava/lang/String;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->recommendurl:Ljava/lang/String;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$29(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 2700
    if-nez v3, :cond_0

    .line 2701
    const/4 v8, 0x0

    .line 2769
    :goto_0
    return-object v8

    .line 2703
    :catch_0
    move-exception v8

    .line 2706
    :cond_0
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v8, v9}, Lcom/aio/downloader/activity/MyMainActivity;->access$30(Lcom/aio/downloader/activity/MyMainActivity;Ljava/util/ArrayList;)V

    .line 2708
    if-eqz v3, :cond_2

    .line 2709
    :try_start_1
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 2710
    .local v5, "object":Lorg/json/JSONObject;
    const-string v8, "status"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    if-ne v8, v10, :cond_2

    .line 2712
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    new-instance v9, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    invoke-static {v8, v9}, Lcom/aio/downloader/activity/MyMainActivity;->access$31(Lcom/aio/downloader/activity/MyMainActivity;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 2715
    :try_start_2
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->run_time:I
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$32(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v8

    if-ne v8, v10, :cond_1

    .line 2717
    const-string v8, "pdt"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 2719
    const-string v8, "pdt"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 2720
    .local v6, "object2":Lorg/json/JSONObject;
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "id"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 2721
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "icon"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 2722
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "title"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 2723
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    .line 2724
    const-string v9, "author_title"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 2723
    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAuthor_title(Ljava/lang/String;)V

    .line 2725
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    .line 2726
    const-string v9, "short_desc"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 2725
    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setShort_desc(Ljava/lang/String;)V

    .line 2727
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    .line 2728
    const-string v9, "rating"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 2727
    invoke-static {v9}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v9

    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 2729
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    const-string v9, "serial"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v9

    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 2730
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    .line 2731
    const-string v9, "has_apk"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 2730
    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_apk(Ljava/lang/String;)V

    .line 2732
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    .line 2733
    const-string v9, "is_official"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 2732
    invoke-virtual {v8, v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIs_official(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    .line 2741
    .end local v6    # "object2":Lorg/json/JSONObject;
    :cond_1
    :goto_1
    :try_start_3
    const-string v8, "list"

    invoke-virtual {v5, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 2742
    .local v0, "array":Lorg/json/JSONArray;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    move-result v8

    if-lt v2, v8, :cond_3

    .line 2769
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v5    # "object":Lorg/json/JSONObject;
    :cond_2
    :goto_3
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->list2:Ljava/util/ArrayList;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$33(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/ArrayList;

    move-result-object v8

    goto/16 :goto_0

    .line 2743
    .restart local v0    # "array":Lorg/json/JSONArray;
    .restart local v2    # "i":I
    .restart local v5    # "object":Lorg/json/JSONObject;
    :cond_3
    :try_start_4
    new-instance v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 2744
    .local v4, "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    .line 2745
    .local v7, "object3":Lorg/json/JSONObject;
    const-string v8, "id"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 2746
    const-string v8, "serial"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 2747
    const-string v8, "title"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 2749
    const-string v8, "author_title"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 2748
    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setAuthor_title(Ljava/lang/String;)V

    .line 2750
    const-string v8, "icon"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIcon(Ljava/lang/String;)V

    .line 2751
    const-string v8, "size"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSize(Ljava/lang/String;)V

    .line 2753
    const-string v8, "rating"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 2752
    invoke-static {v8}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v8

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setRating(Ljava/lang/Float;)V

    .line 2754
    const-string v8, "price"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setPrice(Ljava/lang/String;)V

    .line 2755
    const-string v8, "has_apk"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setHas_apk(Ljava/lang/String;)V

    .line 2757
    const-string v8, "is_official"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 2756
    invoke-virtual {v4, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setIs_official(Ljava/lang/String;)V

    .line 2758
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->list2:Ljava/util/ArrayList;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$33(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/ArrayList;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_1

    .line 2742
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_2

    .line 2764
    .end local v0    # "array":Lorg/json/JSONArray;
    .end local v2    # "i":I
    .end local v4    # "model":Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .end local v5    # "object":Lorg/json/JSONObject;
    .end local v7    # "object3":Lorg/json/JSONObject;
    :catch_1
    move-exception v1

    .line 2766
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_3

    .line 2736
    .end local v1    # "e":Lorg/json/JSONException;
    .restart local v5    # "object":Lorg/json/JSONObject;
    :catch_2
    move-exception v8

    goto/16 :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/util/ArrayList;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->onPostExecute(Ljava/util/ArrayList;)V

    return-void
.end method

.method protected onPostExecute(Ljava/util/ArrayList;)V
    .locals 10
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
    .local p1, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    const/4 v9, 0x1

    .line 2774
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 2775
    if-nez p1, :cond_1

    .line 2901
    :cond_0
    :goto_0
    return-void

    .line 2782
    :cond_1
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->run_time:I
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$32(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v8

    if-ne v8, v9, :cond_0

    .line 2784
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v8}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    const-string v9, "web_caller"

    invoke-static {v8, v9}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 2785
    new-instance v1, Lcom/aio/downloader/dialog/WebFirstDialog;

    .line 2786
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const v9, 0x7f0c000e

    .line 2785
    invoke-direct {v1, v8, v9}, Lcom/aio/downloader/dialog/WebFirstDialog;-><init>(Landroid/content/Context;I)V

    .line 2787
    .local v1, "dialog1":Lcom/aio/downloader/dialog/WebFirstDialog;
    const/4 v8, 0x1

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->setCanceledOnTouchOutside(Z)V

    .line 2789
    invoke-virtual {v1}, Lcom/aio/downloader/dialog/WebFirstDialog;->show()V

    .line 2792
    const v8, 0x7f070369

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 2791
    check-cast v6, Landroid/widget/ImageView;

    .line 2794
    .local v6, "popularicon":Landroid/widget/ImageView;
    const v8, 0x7f070371

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 2793
    check-cast v7, Landroid/widget/TextView;

    .line 2797
    .local v7, "populartitle":Landroid/widget/TextView;
    const v8, 0x7f070376

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 2796
    check-cast v2, Landroid/widget/Button;

    .line 2799
    .local v2, "downloadapk":Landroid/widget/Button;
    const v8, 0x7f070377

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 2798
    check-cast v3, Landroid/widget/Button;

    .line 2801
    .local v3, "googleplay":Landroid/widget/Button;
    const v8, 0x7f070378

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 2800
    check-cast v5, Landroid/widget/ImageView;

    .line 2802
    .local v5, "iv_firstcha":Landroid/widget/ImageView;
    new-instance v8, Lcom/aio/downloader/activity/MyMainActivity$Mya1$1;

    invoke-direct {v8, p0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;Lcom/aio/downloader/dialog/WebFirstDialog;)V

    invoke-virtual {v5, v8}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2811
    const v8, 0x7f070379

    invoke-virtual {v1, v8}, Lcom/aio/downloader/dialog/WebFirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 2810
    check-cast v0, Landroid/widget/CheckBox;

    .line 2814
    .local v0, "cb_caller":Landroid/widget/CheckBox;
    new-instance v8, Lcom/aio/downloader/activity/MyMainActivity$Mya1$2;

    invoke-direct {v8, p0}, Lcom/aio/downloader/activity/MyMainActivity$Mya1$2;-><init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;)V

    invoke-virtual {v0, v8}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 2827
    new-instance v8, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;

    invoke-direct {v8, p0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1$3;-><init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;Lcom/aio/downloader/dialog/WebFirstDialog;)V

    invoke-virtual {v2, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2875
    new-instance v8, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;

    invoke-direct {v8, p0, v1}, Lcom/aio/downloader/activity/MyMainActivity$Mya1$4;-><init>(Lcom/aio/downloader/activity/MyMainActivity$Mya1;Lcom/aio/downloader/dialog/WebFirstDialog;)V

    invoke-virtual {v3, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2887
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getHas_apk()Ljava/lang/String;

    move-result-object v4

    .line 2888
    .local v4, "has_apk":Ljava/lang/String;
    const-string v8, "1"

    invoke-virtual {v4, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 2889
    const/4 v8, 0x0

    invoke-virtual {v2, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 2893
    :cond_2
    :goto_1
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v8

    iget-object v9, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v9}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v9

    invoke-virtual {v9}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9, v6}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 2894
    iget-object v8, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v8}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v8

    invoke-virtual {v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 2897
    .end local v0    # "cb_caller":Landroid/widget/CheckBox;
    .end local v1    # "dialog1":Lcom/aio/downloader/dialog/WebFirstDialog;
    .end local v2    # "downloadapk":Landroid/widget/Button;
    .end local v3    # "googleplay":Landroid/widget/Button;
    .end local v4    # "has_apk":Ljava/lang/String;
    .end local v5    # "iv_firstcha":Landroid/widget/ImageView;
    .end local v6    # "popularicon":Landroid/widget/ImageView;
    .end local v7    # "populartitle":Landroid/widget/TextView;
    :catch_0
    move-exception v8

    goto/16 :goto_0

    .line 2890
    .restart local v0    # "cb_caller":Landroid/widget/CheckBox;
    .restart local v1    # "dialog1":Lcom/aio/downloader/dialog/WebFirstDialog;
    .restart local v2    # "downloadapk":Landroid/widget/Button;
    .restart local v3    # "googleplay":Landroid/widget/Button;
    .restart local v4    # "has_apk":Ljava/lang/String;
    .restart local v5    # "iv_firstcha":Landroid/widget/ImageView;
    .restart local v6    # "popularicon":Landroid/widget/ImageView;
    .restart local v7    # "populartitle":Landroid/widget/TextView;
    :cond_3
    const-string v8, "0"

    invoke-virtual {v4, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 2891
    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Landroid/widget/Button;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 2690
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 2691
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$Mya1;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 2692
    return-void
.end method
