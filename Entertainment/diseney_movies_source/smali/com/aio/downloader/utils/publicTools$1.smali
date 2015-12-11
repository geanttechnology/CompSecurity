.class Lcom/aio/downloader/utils/publicTools$1;
.super Landroid/os/AsyncTask;
.source "publicTools.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/utils/publicTools;->resetServerTime()V
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
        "Ljava/lang/Long;",
        ">;"
    }
.end annotation


# instance fields
.field private offset:J

.field private server_time:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 449
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 450
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    .line 451
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/aio/downloader/utils/publicTools$1;->offset:J

    .line 1
    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Long;
    .locals 8
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 464
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 465
    .local v0, "local_time":J
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "http://android.downloadatoz.com/_201409/market/time.php?"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 466
    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 465
    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    .line 467
    iget-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    if-eqz v4, :cond_1

    .line 468
    iget-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    long-to-double v4, v4

    .line 469
    const-wide/16 v6, 0x3e8

    div-long v6, v0, v6

    long-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    sub-double/2addr v4, v6

    double-to-long v4, v4

    .line 468
    iput-wide v4, p0, Lcom/aio/downloader/utils/publicTools$1;->offset:J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 496
    .end local v0    # "local_time":J
    :cond_0
    :goto_0
    iget-wide v4, p0, Lcom/aio/downloader/utils/publicTools$1;->offset:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    return-object v4

    .line 472
    .restart local v0    # "local_time":J
    :cond_1
    :try_start_1
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "http://93app.com/time.php?"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 473
    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 472
    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    .line 474
    iget-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    if-eqz v4, :cond_2

    .line 475
    iget-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    long-to-double v4, v4

    .line 476
    const-wide/16 v6, 0x3e8

    div-long v6, v0, v6

    long-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    sub-double/2addr v4, v6

    double-to-long v4, v4

    .line 475
    iput-wide v4, p0, Lcom/aio/downloader/utils/publicTools$1;->offset:J

    goto :goto_0

    .line 492
    .end local v0    # "local_time":J
    :catch_0
    move-exception v4

    goto :goto_0

    .line 479
    .restart local v0    # "local_time":J
    :cond_2
    const-string v4, "http://www.convert-unix-time.com/api?timestamp=now"

    invoke-static {v4}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    .line 480
    iget-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 481
    new-instance v2, Lorg/json/JSONObject;

    iget-object v4, p0, Lcom/aio/downloader/utils/publicTools$1;->server_time:Ljava/lang/String;

    invoke-direct {v2, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 483
    .local v2, "object":Lorg/json/JSONObject;
    const-string v4, "timestamp"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 485
    .local v3, "timestamp":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 484
    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    long-to-double v4, v4

    .line 486
    const-wide/16 v6, 0x3e8

    div-long v6, v0, v6

    long-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    sub-double/2addr v4, v6

    double-to-long v4, v4

    .line 484
    iput-wide v4, p0, Lcom/aio/downloader/utils/publicTools$1;->offset:J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/utils/publicTools$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Ljava/lang/Long;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/Long;

    .prologue
    .line 501
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 502
    if-eqz p1, :cond_0

    .line 505
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 506
    sget-object v4, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v5, "system_time"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 505
    sub-long/2addr v2, v4

    .line 506
    const-wide/32 v4, 0x36ee80

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 507
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "time_offset"

    invoke-virtual {v2, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 508
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "system_time"

    .line 509
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 508
    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 510
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V

    .line 511
    const-string v2, "erer"

    const-string v3, "aaaaaaaaaa"

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 530
    :cond_0
    :goto_0
    return-void

    .line 517
    :catch_0
    move-exception v0

    .line 519
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    const-string v2, "erer"

    const-string v3, "bbbbbbbbb"

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 520
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "time_offset"

    invoke-virtual {v2, v3, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 521
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v3, "system_time"

    .line 522
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 521
    invoke-virtual {v2, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 523
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->saveSetting()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 524
    :catch_1
    move-exception v1

    .line 525
    .local v1, "e1":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/utils/publicTools$1;->onPostExecute(Ljava/lang/Long;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 4

    .prologue
    .line 455
    sget-object v0, Lcom/aio/downloader/utils/publicTools;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "time_offset"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 458
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 459
    return-void
.end method
