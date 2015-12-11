.class Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;
.super Landroid/os/AsyncTask;
.source "VideoActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/VideoActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/util/ArrayList",
        "<",
        "Lcom/aio/downloader/model/VideoModel;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/VideoActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/VideoActivity;)V
    .locals 0

    .prologue
    .line 344
    iput-object p1, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;)Lcom/aio/downloader/activity/VideoActivity;
    .locals 1

    .prologue
    .line 344
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/util/ArrayList;
    .locals 18
    .param p1, "params"    # [Ljava/lang/Void;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Void;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/VideoModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 355
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->video_info_url:Ljava/lang/String;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$8(Lcom/aio/downloader/activity/VideoActivity;)Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 357
    .local v2, "content":Ljava/lang/String;
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 360
    .local v8, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/VideoModel;>;"
    if-nez v2, :cond_1

    .line 362
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # invokes: Lcom/aio/downloader/activity/VideoActivity;->Error_dialog()V
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$9(Lcom/aio/downloader/activity/VideoActivity;)V

    .line 410
    :cond_0
    :goto_0
    return-object v8

    .line 365
    :cond_1
    new-instance v9, Ljava/util/HashMap;

    invoke-direct {v9}, Ljava/util/HashMap;-><init>()V

    .line 366
    .local v9, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v16, "content"

    move-object/from16 v0, v16

    invoke-virtual {v9, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 367
    const-string v12, "http://android.downloadatoz.com/_201409/market/youtube_parse.php"

    .line 368
    .local v12, "posturl":Ljava/lang/String;
    invoke-static {v12, v9}, Lcom/aio/downloader/utils/publicTools;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v7

    .line 372
    .local v7, "jsondata":Ljava/lang/String;
    :try_start_0
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10, v7}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 373
    .local v10, "object":Lorg/json/JSONObject;
    const-string v16, "status"

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    .line 374
    .local v13, "status":I
    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v13, v0, :cond_0

    .line 375
    const-string v16, "img"

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 376
    .local v6, "img":Ljava/lang/String;
    const-string v16, "id"

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 377
    .local v5, "id":Ljava/lang/String;
    const-string v16, "title"

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 379
    .local v14, "title":Ljava/lang/String;
    if-nez v5, :cond_2

    .line 382
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # invokes: Lcom/aio/downloader/activity/VideoActivity;->Error_dialog()V
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$9(Lcom/aio/downloader/activity/VideoActivity;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 404
    .end local v5    # "id":Ljava/lang/String;
    .end local v6    # "img":Ljava/lang/String;
    .end local v10    # "object":Lorg/json/JSONObject;
    .end local v13    # "status":I
    .end local v14    # "title":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 406
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 386
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v5    # "id":Ljava/lang/String;
    .restart local v6    # "img":Ljava/lang/String;
    .restart local v10    # "object":Lorg/json/JSONObject;
    .restart local v13    # "status":I
    .restart local v14    # "title":Ljava/lang/String;
    :cond_2
    :try_start_1
    const-string v16, "downloads"

    move-object/from16 v0, v16

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 387
    .local v1, "array":Lorg/json/JSONArray;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v16

    move/from16 v0, v16

    if-ge v4, v0, :cond_0

    .line 388
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    new-instance v17, Lcom/aio/downloader/model/VideoModel;

    invoke-direct/range {v17 .. v17}, Lcom/aio/downloader/model/VideoModel;-><init>()V

    invoke-static/range {v16 .. v17}, Lcom/aio/downloader/activity/VideoActivity;->access$10(Lcom/aio/downloader/activity/VideoActivity;Lcom/aio/downloader/model/VideoModel;)V

    .line 389
    invoke-virtual {v1, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v11

    .line 390
    .local v11, "object2":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    .line 391
    const-string v17, "format"

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 390
    invoke-virtual/range {v16 .. v17}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_format(Ljava/lang/String;)V

    .line 392
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    .line 393
    const-string v17, "type"

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 392
    invoke-virtual/range {v16 .. v17}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_type(Ljava/lang/String;)V

    .line 394
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_title(Ljava/lang/String;)V

    .line 395
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_id(Ljava/lang/String;)V

    .line 396
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v6}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_img(Ljava/lang/String;)V

    .line 397
    const-string v16, "url"

    move-object/from16 v0, v16

    invoke-virtual {v11, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 398
    .local v15, "url":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v15}, Lcom/aio/downloader/model/VideoModel;->setVideo_item_url(Ljava/lang/String;)V

    .line 399
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    move-object/from16 v16, v0

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->model:Lcom/aio/downloader/model/VideoModel;
    invoke-static/range {v16 .. v16}, Lcom/aio/downloader/activity/VideoActivity;->access$11(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/model/VideoModel;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 387
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/util/ArrayList;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->onPostExecute(Ljava/util/ArrayList;)V

    return-void
.end method

.method protected onPostExecute(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/VideoModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/VideoModel;>;"
    const/16 v4, 0x8

    .line 416
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 417
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->tvloading:Landroid/widget/TextView;
    invoke-static {v3}, Lcom/aio/downloader/activity/VideoActivity;->access$2(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 418
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v3}, Lcom/aio/downloader/activity/VideoActivity;->access$3(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v3

    invoke-virtual {v3, v4}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 420
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_0

    .line 421
    new-instance v2, Lcom/aio/downloader/dialog/RestaryDownloadDialog;

    .line 422
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    const v4, 0x7f0c000e

    .line 421
    invoke-direct {v2, v3, v4}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;-><init>(Landroid/content/Context;I)V

    .line 423
    .local v2, "restarydialog":Lcom/aio/downloader/dialog/RestaryDownloadDialog;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;->setCanceledOnTouchOutside(Z)V

    .line 424
    invoke-virtual {v2}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;->show()V

    .line 426
    const v3, 0x7f07038b

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 425
    check-cast v0, Landroid/widget/Button;

    .line 428
    .local v0, "downloadcancel":Landroid/widget/Button;
    const v3, 0x7f07038c

    invoke-virtual {v2, v3}, Lcom/aio/downloader/dialog/RestaryDownloadDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 427
    check-cast v1, Landroid/widget/Button;

    .line 429
    .local v1, "downloadok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$1;

    invoke-direct {v3, p0, v2}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$1;-><init>(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;Lcom/aio/downloader/dialog/RestaryDownloadDialog;)V

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 437
    new-instance v3, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;

    invoke-direct {v3, p0, v2, p1}, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask$2;-><init>(Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;Lcom/aio/downloader/dialog/RestaryDownloadDialog;Ljava/util/ArrayList;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 451
    .end local v0    # "downloadcancel":Landroid/widget/Button;
    .end local v1    # "downloadok":Landroid/widget/Button;
    .end local v2    # "restarydialog":Lcom/aio/downloader/dialog/RestaryDownloadDialog;
    :goto_0
    return-void

    .line 448
    :cond_0
    iget-object v3, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # invokes: Lcom/aio/downloader/activity/VideoActivity;->dowload_video(Ljava/util/ArrayList;)V
    invoke-static {v3, p1}, Lcom/aio/downloader/activity/VideoActivity;->access$12(Lcom/aio/downloader/activity/VideoActivity;Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 347
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 348
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$3(Lcom/aio/downloader/activity/VideoActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 349
    iget-object v0, p0, Lcom/aio/downloader/activity/VideoActivity$MyAsyncTask;->this$0:Lcom/aio/downloader/activity/VideoActivity;

    # getter for: Lcom/aio/downloader/activity/VideoActivity;->tvloading:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/VideoActivity;->access$2(Lcom/aio/downloader/activity/VideoActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 350
    return-void
.end method
