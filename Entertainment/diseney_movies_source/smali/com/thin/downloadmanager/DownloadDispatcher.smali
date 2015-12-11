.class public Lcom/thin/downloadmanager/DownloadDispatcher;
.super Ljava/lang/Thread;
.source "DownloadDispatcher.java"


# static fields
.field public static final TAG:Ljava/lang/String; = "ThinDownloadManager"


# instance fields
.field public final BUFFER_SIZE:I

.field private final DEFAULT_TIMEOUT:I

.field private final HTTP_REQUESTED_RANGE_NOT_SATISFIABLE:I

.field private final HTTP_TEMP_REDIRECT:I

.field public final MAX_REDIRECTS:I

.field private mContentLength:J

.field private mCurrentBytes:J

.field private mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

.field private final mQueue:Ljava/util/concurrent/BlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Lcom/thin/downloadmanager/DownloadRequest;",
            ">;"
        }
    .end annotation
.end field

.field private volatile mQuit:Z

.field private mRedirectionCount:I

.field private mRequest:Lcom/thin/downloadmanager/DownloadRequest;

.field shouldAllowRedirects:Z


# direct methods
.method public constructor <init>(Ljava/util/concurrent/BlockingQueue;Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;)V
    .locals 2
    .param p2, "delivery"    # Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Lcom/thin/downloadmanager/DownloadRequest;",
            ">;",
            "Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "queue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Lcom/thin/downloadmanager/DownloadRequest;>;"
    const/4 v1, 0x0

    .line 64
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 32
    iput-boolean v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mQuit:Z

    .line 41
    const/16 v0, 0x4e20

    iput v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->DEFAULT_TIMEOUT:I

    .line 44
    const/16 v0, 0x1000

    iput v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->BUFFER_SIZE:I

    .line 47
    iput v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRedirectionCount:I

    .line 50
    const/4 v0, 0x5

    iput v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->MAX_REDIRECTS:I

    .line 52
    const/16 v0, 0x1a0

    iput v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->HTTP_REQUESTED_RANGE_NOT_SATISFIABLE:I

    .line 53
    const/16 v0, 0x133

    iput v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->HTTP_TEMP_REDIRECT:I

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->shouldAllowRedirects:Z

    .line 65
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mQueue:Ljava/util/concurrent/BlockingQueue;

    .line 66
    iput-object p2, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    .line 67
    return-void
.end method

.method private cleanupDestination()V
    .locals 4

    .prologue
    .line 301
    const-string v1, "ThinDownloadManager"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "cleanupDestination() deleting "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v3}, Lcom/thin/downloadmanager/DownloadRequest;->getDestinationURI()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 302
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getDestinationURI()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 303
    .local v0, "destinationFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 304
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 306
    :cond_0
    return-void
.end method

.method private executeDownload(Ljava/lang/String;)V
    .locals 11
    .param p1, "downloadUrl"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x5

    .line 102
    const/4 v5, 0x0

    .line 104
    .local v5, "url":Ljava/net/URL;
    :try_start_0
    new-instance v6, Ljava/net/URL;

    invoke-direct {v6, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 110
    .end local v5    # "url":Ljava/net/URL;
    .local v6, "url":Ljava/net/URL;
    const/4 v1, 0x0

    .line 113
    .local v1, "conn":Ljava/net/HttpURLConnection;
    :try_start_1
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v1, v0

    .line 114
    const/4 v7, 0x0

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 115
    const/16 v7, 0x4e20

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 116
    const/16 v7, 0x4e20

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 118
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    .line 119
    .local v4, "responseCode":I
    const-string v7, "ThinDownloadManager"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Response code obtained for downloaded Id "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v9}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " : httpResponse Code "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    sparse-switch v4, :sswitch_data_0

    .line 157
    const/16 v7, 0x3ea

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Unhandled HTTP response:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " message:"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 164
    :cond_0
    :goto_0
    if-eqz v1, :cond_1

    .line 165
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .end local v4    # "responseCode":I
    :cond_1
    :goto_1
    move-object v5, v6

    .line 168
    .end local v1    # "conn":Ljava/net/HttpURLConnection;
    .end local v6    # "url":Ljava/net/URL;
    .restart local v5    # "url":Ljava/net/URL;
    :goto_2
    return-void

    .line 105
    :catch_0
    move-exception v2

    .line 106
    .local v2, "e":Ljava/net/MalformedURLException;
    const/16 v7, 0x3ef

    const-string v8, "MalformedURLException: URI passed is malformed."

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    goto :goto_2

    .line 122
    .end local v2    # "e":Ljava/net/MalformedURLException;
    .end local v5    # "url":Ljava/net/URL;
    .restart local v1    # "conn":Ljava/net/HttpURLConnection;
    .restart local v4    # "responseCode":I
    .restart local v6    # "url":Ljava/net/URL;
    :sswitch_0
    const/4 v7, 0x0

    :try_start_2
    iput-boolean v7, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->shouldAllowRedirects:Z

    .line 123
    invoke-direct {p0, v1}, Lcom/thin/downloadmanager/DownloadDispatcher;->readResponseHeaders(Ljava/net/HttpURLConnection;)I

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_3

    .line 124
    invoke-direct {p0, v1}, Lcom/thin/downloadmanager/DownloadDispatcher;->transferData(Ljava/net/HttpURLConnection;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 164
    :goto_3
    if-eqz v1, :cond_2

    .line 165
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_2
    move-object v5, v6

    .end local v6    # "url":Ljava/net/URL;
    .restart local v5    # "url":Ljava/net/URL;
    goto :goto_2

    .line 126
    .end local v5    # "url":Ljava/net/URL;
    .restart local v6    # "url":Ljava/net/URL;
    :cond_3
    const/16 v7, 0x3ee

    :try_start_3
    const-string v8, "Can\'t know size of download, giving up"

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_3

    .line 160
    .end local v4    # "responseCode":I
    :catch_1
    move-exception v2

    .line 161
    .local v2, "e":Ljava/io/IOException;
    :try_start_4
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 162
    const/16 v7, 0x3ec

    const-string v8, "Trouble with low-level sockets"

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 164
    if-eqz v1, :cond_1

    .line 165
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_1

    .line 135
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v4    # "responseCode":I
    :goto_4
    :sswitch_1
    :try_start_5
    iget v7, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRedirectionCount:I

    add-int/lit8 v8, v7, 0x1

    iput v8, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRedirectionCount:I

    if-ge v7, v10, :cond_5

    iget-boolean v7, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->shouldAllowRedirects:Z

    if-eqz v7, :cond_5

    .line 136
    const-string v7, "ThinDownloadManager"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Redirect for downloaded Id "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v9}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 137
    const-string v7, "Location"

    invoke-virtual {v1, v7}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 138
    .local v3, "location":Ljava/lang/String;
    invoke-direct {p0, v3}, Lcom/thin/downloadmanager/DownloadDispatcher;->executeDownload(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_4

    .line 164
    .end local v3    # "location":Ljava/lang/String;
    .end local v4    # "responseCode":I
    :catchall_0
    move-exception v7

    if-eqz v1, :cond_4

    .line 165
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_4
    throw v7

    .line 142
    .restart local v4    # "responseCode":I
    :cond_5
    :try_start_6
    iget v7, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRedirectionCount:I

    if-le v7, v10, :cond_0

    .line 143
    const/16 v7, 0x3ed

    const-string v8, "Too many redirects, giving up"

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 164
    if-eqz v1, :cond_6

    .line 165
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_6
    move-object v5, v6

    .end local v6    # "url":Ljava/net/URL;
    .restart local v5    # "url":Ljava/net/URL;
    goto/16 :goto_2

    .line 148
    .end local v5    # "url":Ljava/net/URL;
    .restart local v6    # "url":Ljava/net/URL;
    :sswitch_2
    const/16 v7, 0x1a0

    :try_start_7
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 151
    :sswitch_3
    const/16 v7, 0x1f7

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 154
    :sswitch_4
    const/16 v7, 0x1f4

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_0

    .line 120
    nop

    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_0
        0x12d -> :sswitch_1
        0x12e -> :sswitch_1
        0x12f -> :sswitch_1
        0x133 -> :sswitch_1
        0x1a0 -> :sswitch_2
        0x1f4 -> :sswitch_4
        0x1f7 -> :sswitch_3
    .end sparse-switch
.end method

.method private readFromResponse([BLjava/io/InputStream;)I
    .locals 3
    .param p1, "data"    # [B
    .param p2, "entityStream"    # Ljava/io/InputStream;

    .prologue
    .line 249
    :try_start_0
    invoke-virtual {p2, p1}, Ljava/io/InputStream;->read([B)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 255
    :goto_0
    return v1

    .line 250
    :catch_0
    move-exception v0

    .line 251
    .local v0, "ex":Ljava/io/IOException;
    const-string v1, "unexpected end of stream"

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 252
    const/4 v1, -0x1

    goto :goto_0

    .line 254
    :cond_0
    const/16 v1, 0x3ec

    const-string v2, "IOException: Failed reading response"

    invoke-virtual {p0, v1, v2}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    .line 255
    const/high16 v1, -0x80000000

    goto :goto_0
.end method

.method private readResponseHeaders(Ljava/net/HttpURLConnection;)I
    .locals 6
    .param p1, "conn"    # Ljava/net/HttpURLConnection;

    .prologue
    const-wide/16 v4, -0x1

    .line 271
    const-string v1, "Transfer-Encoding"

    invoke-virtual {p1, v1}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 273
    .local v0, "transferEncoding":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 274
    const-string v1, "Content-Length"

    invoke-virtual {p0, p1, v1, v4, v5}, Lcom/thin/downloadmanager/DownloadDispatcher;->getHeaderFieldLong(Ljava/net/URLConnection;Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    .line 280
    :goto_0
    iget-wide v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    cmp-long v1, v1, v4

    if-nez v1, :cond_2

    if-eqz v0, :cond_0

    const-string v1, "chunked"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 282
    :cond_0
    const/4 v1, -0x1

    .line 284
    :goto_1
    return v1

    .line 276
    :cond_1
    const-string v1, "ThinDownloadManager"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Ignoring Content-Length since Transfer-Encoding is also defined for Downloaded Id "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v3}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 277
    iput-wide v4, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    goto :goto_0

    .line 284
    :cond_2
    const/4 v1, 0x1

    goto :goto_1
.end method

.method private transferData(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 7
    .param p1, "in"    # Ljava/io/InputStream;
    .param p2, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 217
    const/16 v3, 0x1000

    new-array v1, v3, [B

    .line 218
    .local v1, "data":[B
    const-wide/16 v3, 0x0

    iput-wide v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mCurrentBytes:J

    .line 219
    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadState(I)V

    .line 220
    const-string v3, "ThinDownloadManager"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Content Length: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v5, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " for Download Id "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v5}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 222
    :goto_0
    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v3}, Lcom/thin/downloadmanager/DownloadRequest;->isCanceled()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 223
    const-string v3, "ThinDownloadManager"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Stopping the download as Download Request is cancelled for Downloaded Id "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v5}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 224
    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v3}, Lcom/thin/downloadmanager/DownloadRequest;->finish()V

    .line 225
    const/16 v3, 0x3f0

    const-string v4, "Download cancelled"

    invoke-virtual {p0, v3, v4}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    .line 239
    :cond_0
    :goto_1
    return-void

    .line 228
    :cond_1
    invoke-direct {p0, v1, p1}, Lcom/thin/downloadmanager/DownloadDispatcher;->readFromResponse([BLjava/io/InputStream;)I

    move-result v0

    .line 230
    .local v0, "bytesRead":I
    iget-wide v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    const-wide/16 v5, -0x1

    cmp-long v3, v3, v5

    if-eqz v3, :cond_2

    .line 231
    iget-wide v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mCurrentBytes:J

    const-wide/16 v5, 0x64

    mul-long/2addr v3, v5

    iget-wide v5, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    div-long/2addr v3, v5

    long-to-int v2, v3

    .line 232
    .local v2, "progress":I
    iget-wide v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mCurrentBytes:J

    invoke-virtual {p0, v2, v3, v4}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadProgress(IJ)V

    .line 235
    .end local v2    # "progress":I
    :cond_2
    const/4 v3, -0x1

    if-ne v0, v3, :cond_3

    .line 236
    invoke-virtual {p0}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadComplete()V

    goto :goto_1

    .line 238
    :cond_3
    const/high16 v3, -0x80000000

    if-eq v0, v3, :cond_0

    .line 242
    invoke-direct {p0, v1, v0, p2}, Lcom/thin/downloadmanager/DownloadDispatcher;->writeDataToDestination([BILjava/io/OutputStream;)V

    .line 243
    iget-wide v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mCurrentBytes:J

    int-to-long v5, v0

    add-long/2addr v3, v5

    iput-wide v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mCurrentBytes:J

    goto :goto_0
.end method

.method private transferData(Ljava/net/HttpURLConnection;)V
    .locals 9
    .param p1, "conn"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 171
    const/4 v3, 0x0

    .line 172
    .local v3, "in":Ljava/io/InputStream;
    const/4 v4, 0x0

    .line 173
    .local v4, "out":Ljava/io/OutputStream;
    const/4 v6, 0x0

    .line 174
    .local v6, "outFd":Ljava/io/FileDescriptor;
    invoke-direct {p0}, Lcom/thin/downloadmanager/DownloadDispatcher;->cleanupDestination()V

    .line 177
    :try_start_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 182
    :goto_0
    :try_start_1
    new-instance v1, Ljava/io/File;

    iget-object v7, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v7}, Lcom/thin/downloadmanager/DownloadRequest;->getDestinationURI()Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v1, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 185
    .local v1, "destinationFile":Ljava/io/File;
    :try_start_2
    new-instance v5, Ljava/io/FileOutputStream;

    const/4 v7, 0x1

    invoke-direct {v5, v1, v7}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 186
    .end local v4    # "out":Ljava/io/OutputStream;
    .local v5, "out":Ljava/io/OutputStream;
    :try_start_3
    move-object v0, v5

    check-cast v0, Ljava/io/FileOutputStream;

    move-object v7, v0

    invoke-virtual {v7}, Ljava/io/FileOutputStream;->getFD()Ljava/io/FileDescriptor;
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_c
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    move-result-object v6

    move-object v4, v5

    .line 193
    .end local v5    # "out":Ljava/io/OutputStream;
    .restart local v4    # "out":Ljava/io/OutputStream;
    :goto_1
    :try_start_4
    invoke-direct {p0, v3, v4}, Lcom/thin/downloadmanager/DownloadDispatcher;->transferData(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 197
    :try_start_5
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    .line 203
    :goto_2
    if-eqz v4, :cond_0

    :try_start_6
    invoke-virtual {v4}, Ljava/io/OutputStream;->flush()V

    .line 204
    :cond_0
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ljava/io/FileDescriptor;->sync()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 208
    :cond_1
    :try_start_7
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3

    .line 214
    :goto_3
    return-void

    .line 178
    .end local v1    # "destinationFile":Ljava/io/File;
    :catch_0
    move-exception v2

    .line 179
    .local v2, "e":Ljava/io/IOException;
    :try_start_8
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    goto :goto_0

    .line 196
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    .line 197
    :goto_4
    :try_start_9
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_7

    .line 203
    :goto_5
    if-eqz v4, :cond_2

    :try_start_a
    invoke-virtual {v4}, Ljava/io/OutputStream;->flush()V

    .line 204
    :cond_2
    if-eqz v6, :cond_3

    invoke-virtual {v6}, Ljava/io/FileDescriptor;->sync()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_9
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    .line 208
    :cond_3
    :try_start_b
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_8

    .line 211
    :goto_6
    throw v7

    .line 187
    .restart local v1    # "destinationFile":Ljava/io/File;
    :catch_1
    move-exception v2

    .line 188
    .restart local v2    # "e":Ljava/io/IOException;
    :goto_7
    :try_start_c
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 189
    const/16 v7, 0x3e9

    const-string v8, "Error in writing download contents to the destination file"

    invoke-virtual {p0, v7, v8}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    goto :goto_1

    .line 198
    .end local v2    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v2

    .line 199
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2

    .line 209
    .end local v2    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v2

    .line 210
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 205
    .end local v2    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v7

    .line 208
    :try_start_d
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_5

    goto :goto_3

    .line 209
    :catch_5
    move-exception v2

    .line 210
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 207
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_1
    move-exception v7

    .line 208
    :try_start_e
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_6

    .line 211
    :goto_8
    throw v7

    .line 209
    :catch_6
    move-exception v2

    .line 210
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_8

    .line 198
    .end local v1    # "destinationFile":Ljava/io/File;
    .end local v2    # "e":Ljava/io/IOException;
    :catch_7
    move-exception v2

    .line 199
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5

    .line 209
    .end local v2    # "e":Ljava/io/IOException;
    :catch_8
    move-exception v2

    .line 210
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_6

    .line 205
    .end local v2    # "e":Ljava/io/IOException;
    :catch_9
    move-exception v8

    .line 208
    :try_start_f
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_a

    goto :goto_6

    .line 209
    :catch_a
    move-exception v2

    .line 210
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_6

    .line 207
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_2
    move-exception v7

    .line 208
    :try_start_10
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_10
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_10} :catch_b

    .line 211
    :goto_9
    throw v7

    .line 209
    :catch_b
    move-exception v2

    .line 210
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_9

    .line 196
    .end local v2    # "e":Ljava/io/IOException;
    .end local v4    # "out":Ljava/io/OutputStream;
    .restart local v1    # "destinationFile":Ljava/io/File;
    .restart local v5    # "out":Ljava/io/OutputStream;
    :catchall_3
    move-exception v7

    move-object v4, v5

    .end local v5    # "out":Ljava/io/OutputStream;
    .restart local v4    # "out":Ljava/io/OutputStream;
    goto :goto_4

    .line 187
    .end local v4    # "out":Ljava/io/OutputStream;
    .restart local v5    # "out":Ljava/io/OutputStream;
    :catch_c
    move-exception v2

    move-object v4, v5

    .end local v5    # "out":Ljava/io/OutputStream;
    .restart local v4    # "out":Ljava/io/OutputStream;
    goto :goto_7
.end method

.method private writeDataToDestination([BILjava/io/OutputStream;)V
    .locals 3
    .param p1, "data"    # [B
    .param p2, "bytesRead"    # I
    .param p3, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 262
    :goto_0
    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p3, p1, v1, p2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 263
    return-void

    .line 264
    :catch_0
    move-exception v0

    .line 265
    .local v0, "ex":Ljava/io/IOException;
    const/16 v1, 0x3e9

    const-string v2, "IOException when writing download contents to the destination file"

    invoke-virtual {p0, v1, v2}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public getHeaderFieldLong(Ljava/net/URLConnection;Ljava/lang/String;J)J
    .locals 2
    .param p1, "conn"    # Ljava/net/URLConnection;
    .param p2, "field"    # Ljava/lang/String;
    .param p3, "defaultValue"    # J

    .prologue
    .line 290
    :try_start_0
    invoke-virtual {p1, p2}, Ljava/net/URLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide p3

    .line 292
    .end local p3    # "defaultValue":J
    :goto_0
    return-wide p3

    .line 291
    .restart local p3    # "defaultValue":J
    :catch_0
    move-exception v0

    .line 292
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method public quit()V
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mQuit:Z

    .line 96
    invoke-virtual {p0}, Lcom/thin/downloadmanager/DownloadDispatcher;->interrupt()V

    .line 97
    return-void
.end method

.method public run()V
    .locals 4

    .prologue
    .line 71
    const/16 v1, 0xa

    invoke-static {v1}, Landroid/os/Process;->setThreadPriority(I)V

    .line 75
    :cond_0
    :goto_0
    :try_start_0
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v1}, Ljava/util/concurrent/BlockingQueue;->take()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/thin/downloadmanager/DownloadRequest;

    iput-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    .line 76
    const/4 v1, 0x0

    iput v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRedirectionCount:I

    .line 77
    const-string v1, "ThinDownloadManager"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Download initiated for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v3}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 78
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadState(I)V

    .line 79
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getUri()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/thin/downloadmanager/DownloadDispatcher;->executeDownload(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 80
    :catch_0
    move-exception v0

    .line 82
    .local v0, "e":Ljava/lang/InterruptedException;
    iget-boolean v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mQuit:Z

    if-eqz v1, :cond_0

    .line 83
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    if-eqz v1, :cond_1

    .line 84
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->finish()V

    .line 85
    const/16 v1, 0x3f0

    const-string v2, "Download cancelled"

    invoke-virtual {p0, v1, v2}, Lcom/thin/downloadmanager/DownloadDispatcher;->updateDownloadFailed(ILjava/lang/String;)V

    .line 87
    :cond_1
    return-void
.end method

.method public updateDownloadComplete()V
    .locals 2

    .prologue
    .line 313
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadState(I)V

    .line 314
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadListener()Lcom/thin/downloadmanager/DownloadStatusListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0, v1}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->postDownloadComplete(Lcom/thin/downloadmanager/DownloadRequest;)V

    .line 316
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->finish()V

    .line 318
    :cond_0
    return-void
.end method

.method public updateDownloadFailed(ILjava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # I
    .param p2, "errorMsg"    # Ljava/lang/String;

    .prologue
    .line 321
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->shouldAllowRedirects:Z

    .line 322
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadState(I)V

    .line 323
    invoke-direct {p0}, Lcom/thin/downloadmanager/DownloadDispatcher;->cleanupDestination()V

    .line 324
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadListener()Lcom/thin/downloadmanager/DownloadStatusListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 325
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0, v1, p1, p2}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->postDownloadFailed(Lcom/thin/downloadmanager/DownloadRequest;ILjava/lang/String;)V

    .line 326
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->finish()V

    .line 328
    :cond_0
    return-void
.end method

.method public updateDownloadProgress(IJ)V
    .locals 7
    .param p1, "progress"    # I
    .param p2, "downloadedBytes"    # J

    .prologue
    .line 331
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadListener()Lcom/thin/downloadmanager/DownloadStatusListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 332
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    iget-wide v2, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mContentLength:J

    move-wide v4, p2

    move v6, p1

    invoke-virtual/range {v0 .. v6}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->postProgressUpdate(Lcom/thin/downloadmanager/DownloadRequest;JJI)V

    .line 334
    :cond_0
    return-void
.end method

.method public updateDownloadState(I)V
    .locals 1
    .param p1, "state"    # I

    .prologue
    .line 309
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadDispatcher;->mRequest:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0, p1}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadState(I)V

    .line 310
    return-void
.end method
