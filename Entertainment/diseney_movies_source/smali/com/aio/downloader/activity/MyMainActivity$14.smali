.class Lcom/aio/downloader/activity/MyMainActivity$14;
.super Ljava/lang/Thread;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$14;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 1283
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 11

    .prologue
    .line 1288
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 1290
    :try_start_0
    new-instance v9, Ljava/net/URL;

    .line 1291
    const-string v10, "http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1"

    .line 1290
    invoke-direct {v9, v10}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 1293
    .local v9, "url":Ljava/net/URL;
    invoke-virtual {v9}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    .line 1292
    check-cast v2, Ljava/net/HttpURLConnection;

    .line 1294
    .local v2, "conn":Ljava/net/HttpURLConnection;
    const-string v10, "GET"

    invoke-virtual {v2, v10}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 1295
    const/16 v10, 0x1388

    invoke-virtual {v2, v10}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 1296
    const/16 v10, 0x1388

    invoke-virtual {v2, v10}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 1298
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    .line 1300
    .local v1, "code":I
    const/16 v10, 0xc8

    if-ne v1, v10, :cond_0

    .line 1301
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    .line 1302
    .local v4, "is":Ljava/io/InputStream;
    new-instance v5, Ljava/io/InputStreamReader;

    invoke-direct {v5, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 1304
    .local v5, "isr":Ljava/io/InputStreamReader;
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 1306
    .local v0, "br":Ljava/io/BufferedReader;
    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    .line 1307
    .local v8, "sBuffer":Ljava/lang/StringBuffer;
    const/4 v6, 0x0

    .line 1308
    .local v6, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_1

    .line 1311
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 1312
    invoke-virtual {v5}, Ljava/io/InputStreamReader;->close()V

    .line 1313
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 1314
    invoke-virtual {v2}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 1316
    iget-object v10, p0, Lcom/aio/downloader/activity/MyMainActivity$14;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v10, v10, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v10}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v7

    .line 1317
    .local v7, "msg":Landroid/os/Message;
    const/16 v10, 0xfa

    iput v10, v7, Landroid/os/Message;->what:I

    .line 1318
    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v7, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 1319
    iget-object v10, p0, Lcom/aio/downloader/activity/MyMainActivity$14;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v10, v10, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v10, v7}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 1329
    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v1    # "code":I
    .end local v2    # "conn":Ljava/net/HttpURLConnection;
    .end local v4    # "is":Ljava/io/InputStream;
    .end local v5    # "isr":Ljava/io/InputStreamReader;
    .end local v6    # "line":Ljava/lang/String;
    .end local v7    # "msg":Landroid/os/Message;
    .end local v8    # "sBuffer":Ljava/lang/StringBuffer;
    .end local v9    # "url":Ljava/net/URL;
    :cond_0
    :goto_1
    return-void

    .line 1309
    .restart local v0    # "br":Ljava/io/BufferedReader;
    .restart local v1    # "code":I
    .restart local v2    # "conn":Ljava/net/HttpURLConnection;
    .restart local v4    # "is":Ljava/io/InputStream;
    .restart local v5    # "isr":Ljava/io/InputStreamReader;
    .restart local v6    # "line":Ljava/lang/String;
    .restart local v8    # "sBuffer":Ljava/lang/StringBuffer;
    .restart local v9    # "url":Ljava/net/URL;
    :cond_1
    invoke-virtual {v8, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 1322
    .end local v0    # "br":Ljava/io/BufferedReader;
    .end local v1    # "code":I
    .end local v2    # "conn":Ljava/net/HttpURLConnection;
    .end local v4    # "is":Ljava/io/InputStream;
    .end local v5    # "isr":Ljava/io/InputStreamReader;
    .end local v6    # "line":Ljava/lang/String;
    .end local v8    # "sBuffer":Ljava/lang/StringBuffer;
    .end local v9    # "url":Ljava/net/URL;
    :catch_0
    move-exception v3

    .line 1324
    .local v3, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v3}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_1

    .line 1325
    .end local v3    # "e":Ljava/net/MalformedURLException;
    :catch_1
    move-exception v3

    .line 1327
    .local v3, "e":Ljava/io/IOException;
    invoke-virtual {v3}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method
