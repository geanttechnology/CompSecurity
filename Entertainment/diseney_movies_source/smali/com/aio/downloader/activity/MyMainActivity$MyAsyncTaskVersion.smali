.class Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
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

.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 4133
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 12
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 4148
    const-wide/16 v9, 0x3e8

    :try_start_0
    invoke-static {v9, v10}, Ljava/lang/Thread;->sleep(J)V

    .line 4149
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "http://app.loveitsomuch.com/gonglue_xilie/ping.php?id="

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 4150
    sget-object v10, Lcom/aio/downloader/utils/Myutils;->packagename2:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "&version="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "3.3.9"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 4149
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 4151
    .local v5, "path":Ljava/lang/String;
    new-instance v9, Ljava/net/URL;

    invoke-direct {v9, v5}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 4152
    invoke-virtual {v9}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 4151
    check-cast v0, Ljava/net/HttpURLConnection;

    .line 4153
    .local v0, "conn":Ljava/net/HttpURLConnection;
    const/16 v9, 0x1388

    invoke-virtual {v0, v9}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 4154
    const-string v9, "GET"

    invoke-virtual {v0, v9}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 4155
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

    .line 4156
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v9

    const/16 v10, 0xc8

    if-ne v9, v10, :cond_0

    .line 4157
    new-instance v7, Ljava/lang/StringBuffer;

    invoke-direct {v7}, Ljava/lang/StringBuffer;-><init>()V

    .line 4158
    .local v7, "sb":Ljava/lang/StringBuffer;
    new-instance v6, Ljava/io/BufferedReader;

    .line 4159
    new-instance v9, Ljava/io/InputStreamReader;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 4158
    invoke-direct {v6, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 4160
    .local v6, "reader":Ljava/io/BufferedReader;
    const-string v3, ""

    .line 4161
    .local v3, "len":Ljava/lang/String;
    :goto_0
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1

    .line 4164
    new-instance v4, Lorg/json/JSONObject;

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v4, v9}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 4165
    .local v4, "object":Lorg/json/JSONObject;
    const-string v9, "status"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v8

    .line 4166
    .local v8, "status":I
    const/4 v9, 0x1

    if-ne v8, v9, :cond_0

    .line 4167
    new-instance v2, Lcom/aio/downloader/model/GameInfosVersionModel;

    invoke-direct {v2}, Lcom/aio/downloader/model/GameInfosVersionModel;-><init>()V

    .line 4168
    .local v2, "info":Lcom/aio/downloader/model/GameInfosVersionModel;
    const-string v9, "update_url"

    invoke-virtual {v4, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Lcom/aio/downloader/model/GameInfosVersionModel;->setUpdatePath(Ljava/lang/String;)V

    .line 4169
    iget-object v9, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v9, v9, Lcom/aio/downloader/activity/MyMainActivity;->handlerversion:Landroid/os/Handler;

    iget-object v10, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v10, v10, Lcom/aio/downloader/activity/MyMainActivity;->handlerversion:Landroid/os/Handler;

    .line 4170
    const/16 v11, 0x234

    invoke-virtual {v10, v11, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v10

    .line 4169
    invoke-virtual {v9, v10}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 4176
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

    .line 4162
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

    .line 4173
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v3    # "len":Ljava/lang/String;
    .end local v5    # "path":Ljava/lang/String;
    .end local v6    # "reader":Ljava/io/BufferedReader;
    .end local v7    # "sb":Ljava/lang/StringBuffer;
    :catch_0
    move-exception v1

    .line 4174
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 4183
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 4184
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4185
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 4186
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 4189
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 4140
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 4141
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    const/4 v1, 0x0

    .line 4142
    const-string v2, "Loading......"

    .line 4141
    invoke-static {v0, v1, v2}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/app/ProgressDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$MyAsyncTaskVersion;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 4143
    return-void
.end method
