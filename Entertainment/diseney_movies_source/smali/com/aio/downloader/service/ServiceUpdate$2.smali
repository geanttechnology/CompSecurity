.class Lcom/aio/downloader/service/ServiceUpdate$2;
.super Landroid/os/Handler;
.source "ServiceUpdate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/service/ServiceUpdate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private icon0:Ljava/lang/String;

.field private icon1:Ljava/lang/String;

.field private icon2:Ljava/lang/String;

.field private icon3:Ljava/lang/String;

.field private icon4:Ljava/lang/String;

.field private icon5:Ljava/lang/String;

.field private icon6:Ljava/lang/String;

.field private icon7:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 230
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon0:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 233
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon2:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon3:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon4:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/service/ServiceUpdate$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon5:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/service/ServiceUpdate$2;)Lcom/aio/downloader/service/ServiceUpdate;
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 29
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 244
    invoke-super/range {p0 .. p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 245
    move-object/from16 v0, p1

    iget v4, v0, Landroid/os/Message;->what:I

    sparse-switch v4, :sswitch_data_0

    .line 409
    :cond_0
    :goto_0
    return-void

    .line 247
    :sswitch_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 248
    const-string v5, "first_insall_cleaner"

    .line 247
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 249
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->dialog:Lcom/aio/downloader/dialog/InstallfirstDialog;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$0(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/InstallfirstDialog;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/InstallfirstDialog;->show()V

    goto :goto_0

    .line 269
    :sswitch_1
    move-object/from16 v0, p1

    iget-object v4, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    .line 271
    .local v11, "jsonStr":Ljava/lang/String;
    :try_start_0
    new-instance v15, Lorg/json/JSONObject;

    invoke-direct {v15, v11}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 272
    .local v15, "object":Lorg/json/JSONObject;
    const-string v4, "has_next_page"

    invoke-virtual {v15, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v14

    .line 273
    .local v14, "next":I
    const-string v4, "status"

    invoke-virtual {v15, v4}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 274
    const-string v4, "list"

    invoke-virtual {v15, v4}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    .line 275
    .local v8, "array":Lorg/json/JSONArray;
    const/4 v4, 0x0

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v16

    .line 276
    .local v16, "object2":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon0:Ljava/lang/String;

    .line 278
    const/4 v4, 0x1

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v17

    .line 279
    .local v17, "object3":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon1:Ljava/lang/String;

    .line 281
    const/4 v4, 0x2

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v18

    .line 282
    .local v18, "object4":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v18

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon2:Ljava/lang/String;

    .line 284
    const/4 v4, 0x3

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v19

    .line 285
    .local v19, "object5":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon3:Ljava/lang/String;

    .line 287
    const/4 v4, 0x4

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v20

    .line 288
    .local v20, "object6":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v20

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon4:Ljava/lang/String;

    .line 290
    const/4 v4, 0x5

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v21

    .line 291
    .local v21, "object7":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v21

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon5:Ljava/lang/String;

    .line 293
    const/4 v4, 0x6

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v22

    .line 294
    .local v22, "object8":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon6:Ljava/lang/String;

    .line 296
    const/4 v4, 0x7

    invoke-virtual {v8, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v23

    .line 297
    .local v23, "object9":Lorg/json/JSONObject;
    const-string v4, "icon"

    move-object/from16 v0, v23

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    iput-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->icon7:Ljava/lang/String;

    .line 298
    new-instance v2, Ljava/util/Timer;

    invoke-direct {v2}, Ljava/util/Timer;-><init>()V

    .line 299
    .local v2, "timer":Ljava/util/Timer;
    new-instance v3, Lcom/aio/downloader/service/ServiceUpdate$2$1;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/aio/downloader/service/ServiceUpdate$2$1;-><init>(Lcom/aio/downloader/service/ServiceUpdate$2;)V

    .line 316
    .local v3, "task":Ljava/util/TimerTask;
    const-wide/16 v4, 0x2710

    const-wide/16 v6, 0x7530

    invoke-virtual/range {v2 .. v7}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 323
    .end local v2    # "timer":Ljava/util/Timer;
    .end local v3    # "task":Ljava/util/TimerTask;
    .end local v8    # "array":Lorg/json/JSONArray;
    .end local v14    # "next":I
    .end local v15    # "object":Lorg/json/JSONObject;
    .end local v16    # "object2":Lorg/json/JSONObject;
    .end local v17    # "object3":Lorg/json/JSONObject;
    .end local v18    # "object4":Lorg/json/JSONObject;
    .end local v19    # "object5":Lorg/json/JSONObject;
    .end local v20    # "object6":Lorg/json/JSONObject;
    .end local v21    # "object7":Lorg/json/JSONObject;
    .end local v22    # "object8":Lorg/json/JSONObject;
    .end local v23    # "object9":Lorg/json/JSONObject;
    :catch_0
    move-exception v9

    .line 325
    .local v9, "e":Lorg/json/JSONException;
    invoke-virtual {v9}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0

    .line 329
    .end local v9    # "e":Lorg/json/JSONException;
    .end local v11    # "jsonStr":Ljava/lang/String;
    :sswitch_2
    move-object/from16 v0, p1

    iget-object v4, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    .line 330
    .local v12, "jsonStrmeiri":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    invoke-static {v12}, Lcom/aio/downloader/utils/Myutils;->parsetodaypick(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 331
    const-string v4, "lpl"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "list_pick="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v6, v6, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 333
    :try_start_1
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$1(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 334
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$2(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 335
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getShort_desc()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$3(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 336
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieHeadImagePath()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$4(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 337
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$5(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 339
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getIcon()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$6(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 340
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$7(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 341
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getShort_desc()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$8(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 342
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    iget-object v4, v4, Lcom/aio/downloader/service/ServiceUpdate;->list_pick:Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v4}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$9(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 348
    :goto_1
    new-instance v2, Ljava/util/Timer;

    invoke-direct {v2}, Ljava/util/Timer;-><init>()V

    .line 349
    .restart local v2    # "timer":Ljava/util/Timer;
    new-instance v3, Lcom/aio/downloader/service/ServiceUpdate$2$2;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/aio/downloader/service/ServiceUpdate$2$2;-><init>(Lcom/aio/downloader/service/ServiceUpdate$2;)V

    .line 372
    .restart local v3    # "task":Ljava/util/TimerTask;
    const-wide/16 v4, 0x7530

    const-wide/32 v6, 0xea60

    invoke-virtual/range {v2 .. v7}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    goto/16 :goto_0

    .line 376
    .end local v2    # "timer":Ljava/util/Timer;
    .end local v3    # "task":Ljava/util/TimerTask;
    .end local v12    # "jsonStrmeiri":Ljava/lang/String;
    :sswitch_3
    const/16 v24, 0x0

    .line 378
    .local v24, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_2
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 379
    const-string v5, "com.allinone.callerid"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v24

    .line 383
    :goto_2
    new-instance v26, Landroid/text/format/Time;

    invoke-direct/range {v26 .. v26}, Landroid/text/format/Time;-><init>()V

    .line 385
    .local v26, "t":Landroid/text/format/Time;
    invoke-virtual/range {v26 .. v26}, Landroid/text/format/Time;->setToNow()V

    .line 386
    move-object/from16 v0, v26

    iget v10, v0, Landroid/text/format/Time;->hour:I

    .line 387
    .local v10, "hour":I
    move-object/from16 v0, v26

    iget v13, v0, Landroid/text/format/Time;->minute:I

    .line 388
    .local v13, "minute":I
    move-object/from16 v0, v26

    iget v0, v0, Landroid/text/format/Time;->second:I

    move/from16 v25, v0

    .line 389
    .local v25, "second":I
    const/16 v4, 0xa

    if-ne v10, v4, :cond_0

    const/16 v4, 0x1e

    if-ne v13, v4, :cond_0

    if-nez v25, :cond_0

    .line 390
    if-nez v24, :cond_0

    .line 391
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 392
    const-string v5, "simulate_call"

    .line 391
    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 393
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    new-instance v5, Lcom/aio/downloader/dialog/CallerOutDialog1;

    .line 394
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    invoke-virtual {v6}, Lcom/aio/downloader/service/ServiceUpdate;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    const v7, 0x7f0c0010

    .line 395
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    move-object/from16 v27, v0

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->itemsOnClick4:Landroid/view/View$OnClickListener;
    invoke-static/range {v27 .. v27}, Lcom/aio/downloader/service/ServiceUpdate;->access$19(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/view/View$OnClickListener;

    move-result-object v27

    const-string v28, "+1 813-449-2756"

    move-object/from16 v0, v27

    move-object/from16 v1, v28

    invoke-direct {v5, v6, v7, v0, v1}, Lcom/aio/downloader/dialog/CallerOutDialog1;-><init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;)V

    .line 393
    invoke-static {v4, v5}, Lcom/aio/downloader/service/ServiceUpdate;->access$20(Lcom/aio/downloader/service/ServiceUpdate;Lcom/aio/downloader/dialog/CallerOutDialog1;)V

    .line 396
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$21(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/CallerOutDialog1;

    move-result-object v4

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/CallerOutDialog1;->setCanceledOnTouchOutside(Z)V

    .line 397
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$21(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/CallerOutDialog1;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/CallerOutDialog1;->getWindow()Landroid/view/Window;

    move-result-object v4

    .line 398
    const/16 v5, 0x7d3

    .line 397
    invoke-virtual {v4, v5}, Landroid/view/Window;->setType(I)V

    .line 399
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/service/ServiceUpdate$2;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->callerOutDialog1:Lcom/aio/downloader/dialog/CallerOutDialog1;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$21(Lcom/aio/downloader/service/ServiceUpdate;)Lcom/aio/downloader/dialog/CallerOutDialog1;

    move-result-object v4

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/CallerOutDialog1;->show()V

    goto/16 :goto_0

    .line 380
    .end local v10    # "hour":I
    .end local v13    # "minute":I
    .end local v25    # "second":I
    .end local v26    # "t":Landroid/text/format/Time;
    :catch_1
    move-exception v9

    .line 381
    .local v9, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v9}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 344
    .end local v9    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v24    # "packageInfo":Landroid/content/pm/PackageInfo;
    .restart local v12    # "jsonStrmeiri":Ljava/lang/String;
    :catch_2
    move-exception v4

    goto/16 :goto_1

    .line 245
    :sswitch_data_0
    .sparse-switch
        0xa -> :sswitch_2
        0x1e -> :sswitch_0
        0x64 -> :sswitch_3
        0xfa -> :sswitch_1
    .end sparse-switch
.end method
