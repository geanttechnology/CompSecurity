.class Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;
.super Landroid/os/AsyncTask;
.source "MySettingsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MySettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyAsyncTaskVersion"
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
.field private mProgressDialog:Landroid/app/ProgressDialog;

.field final synthetic this$0:Lcom/aio/downloader/activity/MySettingsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 12
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 384
    const-wide/16 v9, 0x3e8

    :try_start_0
    invoke-static {v9, v10}, Ljava/lang/Thread;->sleep(J)V

    .line 385
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "http://app.loveitsomuch.com/gonglue_xilie/ping.php?id="

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v10, Lcom/aio/downloader/utils/Myutils;->packagename2:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "&version="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "3.3.9"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 386
    .local v5, "path":Ljava/lang/String;
    new-instance v9, Ljava/net/URL;

    invoke-direct {v9, v5}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 387
    invoke-virtual {v9}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 386
    check-cast v0, Ljava/net/HttpURLConnection;

    .line 388
    .local v0, "conn":Ljava/net/HttpURLConnection;
    const/16 v9, 0x1388

    invoke-virtual {v0, v9}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 389
    const-string v9, "GET"

    invoke-virtual {v0, v9}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 390
    const-string v9, "ggg"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v11

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 391
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v9

    const/16 v10, 0xc8

    if-ne v9, v10, :cond_0

    .line 392
    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    .line 393
    .local v7, "sb":Ljava/lang/StringBuffer;
    new-instance v6, Ljava/io/BufferedReader;

    .line 394
    new-instance v9, Ljava/io/InputStreamReader;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 393
    invoke-direct {v6, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 395
    .local v6, "reader":Ljava/io/BufferedReader;
    const-string v3, ""

    .line 396
    .local v3, "len":Ljava/lang/String;
    :goto_0
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1

    .line 399
    new-instance v4, Lorg/json/JSONObject;

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v4, v9}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 400
    .local v4, "object":Lorg/json/JSONObject;
    const-string v9, "status"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    .line 401
    .local v8, "status":I
    const/4 v9, 0x1

    if-ne v8, v9, :cond_0

    .line 403
    new-instance v2, Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-direct {v2}, Lcom/aio/downloader/model/GameInfosVersionModel;-><init>()V

    .line 404
    .local v2, "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    const-string v9, "update_url"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Lcom/aio/downloader/model/GameInfosVersionModel;->setUpdatePath(Ljava/lang/String;)V

    .line 406
    iget-object v9, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    iget-object v9, v9, Lcom/aio/downloader/activity/MySettingsActivity;->handler:Landroid/os/Handler;

    iget-object v10, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    iget-object v10, v10, Lcom/aio/downloader/activity/MySettingsActivity;->handler:Landroid/os/Handler;

    const/16 v11, 0x234

    invoke-virtual {v10, v11, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 413
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v2    # "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    .end local v3    # "len":Ljava/lang/String;
    .end local v4    # "object":Lorg/json/JSONObject;
    .end local v5    # "path":Ljava/lang/String;
    .end local v6    # "reader":Ljava/io/BufferedReader;
    .end local v7    # "sb":Ljava/lang/StringBuffer;
    .end local v8    # "status":I
    :cond_0
    :goto_1
    const/4 v9, 0x0

    return-object v9

    .line 397
    .restart local v0    # "conn":Ljava/net/HttpURLConnection;
    .restart local v3    # "len":Ljava/lang/String;
    .restart local v5    # "path":Ljava/lang/String;
    .restart local v6    # "reader":Ljava/io/BufferedReader;
    .restart local v7    # "sb":Ljava/lang/StringBuffer;
    :cond_1
    invoke-virtual {v7, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 410
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v3    # "len":Ljava/lang/String;
    .end local v5    # "path":Ljava/lang/String;
    .end local v6    # "reader":Ljava/io/BufferedReader;
    .end local v7    # "sb":Ljava/lang/StringBuffer;
    :catch_0
    move-exception v1

    .line 411
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 420
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 421
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 422
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 423
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 426
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 376
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 377
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    .line 378
    const/4 v1, 0x0

    const-string v2, "Loading......"

    .line 377
    invoke-static {v0, v1, v2}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/app/ProgressDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 379
    return-void
.end method
