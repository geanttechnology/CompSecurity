.class Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

.field private final connectionTimeout:I

.field private final directory:Ljava/lang/String;

.field private final readTimeout:I

.field private final url:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;IILjava/lang/String;)V
    .locals 0

    .prologue
    .line 329
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 331
    iput-object p1, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    .line 332
    iput-object p2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    .line 333
    iput p3, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->connectionTimeout:I

    .line 334
    iput p4, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->readTimeout:I

    .line 335
    iput-object p5, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->directory:Ljava/lang/String;

    .line 336
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;IILjava/lang/String;Lcom/adobe/mobile/RemoteDownload$1;)V
    .locals 0

    .prologue
    .line 320
    invoke-direct/range {p0 .. p5}, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;-><init>(Ljava/lang/String;Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;IILjava/lang/String;)V

    return-void
.end method

.method protected static requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    .locals 4

    .prologue
    .line 488
    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 489
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 494
    :goto_0
    return-object v0

    .line 490
    :catch_0
    move-exception v0

    .line 491
    const-string v1, "Cached Files - Exception opening URL(%s)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 494
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public run()V
    .locals 15

    .prologue
    const/4 v1, 0x0

    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 340
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 341
    const-string v0, "Cached Files - url is null and cannot be cached"

    new-array v2, v12, [Ljava/lang/Object;

    invoke-static {v0, v2}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 342
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_0

    .line 343
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    invoke-interface {v0, v12, v1}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V

    .line 483
    :cond_0
    :goto_0
    return-void

    .line 349
    :cond_1
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mobile/RemoteDownload;->stringIsUrl(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 350
    const-string v0, "Cached Files - given url is not valid and cannot be cached (\"%s\")"

    new-array v2, v13, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    aput-object v3, v2, v12

    invoke-static {v0, v2}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 351
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_0

    .line 352
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    invoke-interface {v0, v12, v1}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V

    goto :goto_0

    .line 357
    :cond_2
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->directory:Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/adobe/mobile/RemoteDownload;->getFileForCachedURL(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 359
    # invokes: Lcom/adobe/mobile/RemoteDownload;->createRFC2822Formatter()Ljava/text/SimpleDateFormat;
    invoke-static {}, Lcom/adobe/mobile/RemoteDownload;->access$100()Ljava/text/SimpleDateFormat;

    move-result-object v2

    .line 360
    iget-object v3, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    invoke-static {v3}, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->requestConnect(Ljava/lang/String;)Ljava/net/HttpURLConnection;

    move-result-object v3

    .line 362
    const/4 v4, 0x0

    .line 363
    const/4 v5, 0x0

    .line 365
    if-nez v3, :cond_3

    .line 366
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    invoke-interface {v0, v12, v1}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V

    goto :goto_0

    .line 372
    :cond_3
    iget v6, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->connectionTimeout:I

    invoke-virtual {v3, v6}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 373
    iget v6, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->readTimeout:I

    invoke-virtual {v3, v6}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 375
    if-eqz v0, :cond_5

    .line 376
    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    # invokes: Lcom/adobe/mobile/RemoteDownload;->getEtagOfFile(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v6}, Lcom/adobe/mobile/RemoteDownload;->access$200(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/adobe/mobile/StaticMethods;->hexToString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 377
    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v7

    # invokes: Lcom/adobe/mobile/RemoteDownload;->getLastModifiedOfFile(Ljava/lang/String;)J
    invoke-static {v7}, Lcom/adobe/mobile/RemoteDownload;->access$300(Ljava/lang/String;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    .line 379
    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-eqz v8, :cond_4

    .line 380
    const-string v8, "If-Modified-Since"

    invoke-virtual {v2, v7}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v8, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    :cond_4
    if-eqz v6, :cond_5

    .line 383
    const-string v2, "If-None-Match"

    invoke-virtual {v3, v2, v6}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 387
    :cond_5
    :try_start_0
    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_9
    .catch Ljava/lang/Error; {:try_start_0 .. :try_end_0} :catch_d
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->connect()V

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_9
    .catch Ljava/lang/Error; {:try_start_1 .. :try_end_1} :catch_d
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 389
    :try_start_2
    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V
    :try_end_2
    .catch Ljava/net/SocketTimeoutException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_5
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_9
    .catch Ljava/lang/Error; {:try_start_2 .. :try_end_2} :catch_d
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/net/SocketTimeoutException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_9
    .catch Ljava/lang/Error; {:try_start_3 .. :try_end_3} :catch_d
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    const/16 v6, 0x130

    if-ne v2, v6, :cond_f

    .line 390
    const-string v2, "Cached Files - File has not been modified since last download. (%s)"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v2, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 391
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v2, :cond_6

    .line 392
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v6, 0x0

    invoke-interface {v2, v6, v0}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_4
    .catch Ljava/net/SocketTimeoutException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_9
    .catch Ljava/lang/Error; {:try_start_4 .. :try_end_4} :catch_d
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 471
    :cond_6
    if-eqz v1, :cond_7

    .line 472
    :try_start_5
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_7
    if-eqz v1, :cond_8

    .line 475
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_8
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_0

    .line 479
    :catch_0
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 387
    :catch_1
    move-exception v0

    :try_start_6
    invoke-static {v3, v0}, Lp;->a(Ljava/net/URLConnection;Ljava/io/IOException;)V

    throw v0
    :try_end_6
    .catch Ljava/net/SocketTimeoutException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_5
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_9
    .catch Ljava/lang/Error; {:try_start_6 .. :try_end_6} :catch_d
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 447
    :catch_2
    move-exception v0

    move-object v0, v1

    .line 448
    :goto_1
    :try_start_7
    const-string v2, "Cached Files - Timed out making request (%s)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v4}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 449
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v2, :cond_9

    .line 450
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-interface {v2, v4, v5}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 471
    :cond_9
    if-eqz v0, :cond_a

    .line 472
    :try_start_8
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_a
    if-eqz v1, :cond_b

    .line 475
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_b
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_3

    goto/16 :goto_0

    .line 479
    :catch_3
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 389
    :catch_4
    move-exception v0

    :try_start_9
    invoke-static {v3, v0}, Lp;->a(Ljava/net/URLConnection;Ljava/io/IOException;)V

    throw v0
    :try_end_9
    .catch Ljava/net/SocketTimeoutException; {:try_start_9 .. :try_end_9} :catch_2
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_5
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_9
    .catch Ljava/lang/Error; {:try_start_9 .. :try_end_9} :catch_d
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 452
    :catch_5
    move-exception v0

    move-object v2, v1

    .line 453
    :goto_2
    :try_start_a
    const-string v4, "Cached Files - IOException while making request (%s)"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v6

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 454
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_c

    .line 455
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-interface {v0, v4, v5}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    .line 471
    :cond_c
    if-eqz v1, :cond_d

    .line 472
    :try_start_b
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_d
    if-eqz v2, :cond_e

    .line 475
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_e
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_6

    goto/16 :goto_0

    .line 479
    :catch_6
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 396
    :cond_f
    :try_start_c
    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V
    :try_end_c
    .catch Ljava/net/SocketTimeoutException; {:try_start_c .. :try_end_c} :catch_2
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_5
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_c} :catch_9
    .catch Ljava/lang/Error; {:try_start_c .. :try_end_c} :catch_d
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    :try_start_d
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_8
    .catch Ljava/net/SocketTimeoutException; {:try_start_d .. :try_end_d} :catch_2
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_d} :catch_9
    .catch Ljava/lang/Error; {:try_start_d .. :try_end_d} :catch_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    :try_start_e
    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    const/16 v6, 0x194

    if-ne v2, v6, :cond_16

    .line 397
    const-string v2, "Cached Files - File not found. (%s)"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v2, v6}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 398
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v2, :cond_10

    .line 399
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v6, 0x0

    invoke-interface {v2, v6, v0}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_e
    .catch Ljava/net/SocketTimeoutException; {:try_start_e .. :try_end_e} :catch_2
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_5
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_e} :catch_9
    .catch Ljava/lang/Error; {:try_start_e .. :try_end_e} :catch_d
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    .line 471
    :cond_10
    if-eqz v1, :cond_11

    .line 472
    :try_start_f
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_11
    if-eqz v1, :cond_12

    .line 475
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_12
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_7

    goto/16 :goto_0

    .line 479
    :catch_7
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 396
    :catch_8
    move-exception v0

    :try_start_10
    invoke-static {v3, v0}, Lp;->a(Ljava/net/URLConnection;Ljava/io/IOException;)V

    throw v0
    :try_end_10
    .catch Ljava/net/SocketTimeoutException; {:try_start_10 .. :try_end_10} :catch_2
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_10} :catch_5
    .catch Ljava/lang/Exception; {:try_start_10 .. :try_end_10} :catch_9
    .catch Ljava/lang/Error; {:try_start_10 .. :try_end_10} :catch_d
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    .line 457
    :catch_9
    move-exception v0

    move-object v2, v1

    .line 458
    :goto_3
    :try_start_11
    const-string v4, "Cached Files - Unexpected exception while attempting to get remote file (%s)"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v6

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 459
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_13

    .line 460
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-interface {v0, v4, v5}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_1

    .line 471
    :cond_13
    if-eqz v1, :cond_14

    .line 472
    :try_start_12
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_14
    if-eqz v2, :cond_15

    .line 475
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_15
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_12} :catch_a

    goto/16 :goto_0

    .line 479
    :catch_a
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 403
    :cond_16
    :try_start_13
    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V
    :try_end_13
    .catch Ljava/net/SocketTimeoutException; {:try_start_13 .. :try_end_13} :catch_2
    .catch Ljava/io/IOException; {:try_start_13 .. :try_end_13} :catch_5
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_13} :catch_9
    .catch Ljava/lang/Error; {:try_start_13 .. :try_end_13} :catch_d
    .catchall {:try_start_13 .. :try_end_13} :catchall_0

    :try_start_14
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_14} :catch_c
    .catch Ljava/net/SocketTimeoutException; {:try_start_14 .. :try_end_14} :catch_2
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_14} :catch_9
    .catch Ljava/lang/Error; {:try_start_14 .. :try_end_14} :catch_d
    .catchall {:try_start_14 .. :try_end_14} :catchall_0

    :try_start_15
    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    const/16 v6, 0xc8

    if-eq v2, v6, :cond_1f

    .line 404
    const-string v2, "Cached Files - File could not be downloaded from URL (%s) Response: (%d) Message: (%s)"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V
    :try_end_15
    .catch Ljava/net/SocketTimeoutException; {:try_start_15 .. :try_end_15} :catch_2
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_15} :catch_5
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_15} :catch_9
    .catch Ljava/lang/Error; {:try_start_15 .. :try_end_15} :catch_d
    .catchall {:try_start_15 .. :try_end_15} :catchall_0

    :try_start_16
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v8

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V
    :try_end_16
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_16} :catch_f
    .catch Ljava/net/SocketTimeoutException; {:try_start_16 .. :try_end_16} :catch_2
    .catch Ljava/lang/Exception; {:try_start_16 .. :try_end_16} :catch_9
    .catch Ljava/lang/Error; {:try_start_16 .. :try_end_16} :catch_d
    .catchall {:try_start_16 .. :try_end_16} :catchall_0

    :try_start_17
    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V
    :try_end_17
    .catch Ljava/net/SocketTimeoutException; {:try_start_17 .. :try_end_17} :catch_2
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_17} :catch_5
    .catch Ljava/lang/Exception; {:try_start_17 .. :try_end_17} :catch_9
    .catch Ljava/lang/Error; {:try_start_17 .. :try_end_17} :catch_d
    .catchall {:try_start_17 .. :try_end_17} :catchall_0

    :try_start_18
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v8

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V
    :try_end_18
    .catch Ljava/io/IOException; {:try_start_18 .. :try_end_18} :catch_10
    .catch Ljava/net/SocketTimeoutException; {:try_start_18 .. :try_end_18} :catch_2
    .catch Ljava/lang/Exception; {:try_start_18 .. :try_end_18} :catch_9
    .catch Ljava/lang/Error; {:try_start_18 .. :try_end_18} :catch_d
    .catchall {:try_start_18 .. :try_end_18} :catchall_0

    :try_start_19
    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    aput-object v8, v6, v7

    invoke-static {v2, v6}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 405
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v2, :cond_17

    .line 406
    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v6, 0x0

    invoke-interface {v2, v6, v0}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_19
    .catch Ljava/net/SocketTimeoutException; {:try_start_19 .. :try_end_19} :catch_2
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_19} :catch_5
    .catch Ljava/lang/Exception; {:try_start_19 .. :try_end_19} :catch_9
    .catch Ljava/lang/Error; {:try_start_19 .. :try_end_19} :catch_d
    .catchall {:try_start_19 .. :try_end_19} :catchall_0

    .line 471
    :cond_17
    if-eqz v1, :cond_18

    .line 472
    :try_start_1a
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_18
    if-eqz v1, :cond_19

    .line 475
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_19
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1a} :catch_b

    goto/16 :goto_0

    .line 479
    :catch_b
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 403
    :catch_c
    move-exception v0

    :try_start_1b
    invoke-static {v3, v0}, Lp;->a(Ljava/net/URLConnection;Ljava/io/IOException;)V

    throw v0
    :try_end_1b
    .catch Ljava/net/SocketTimeoutException; {:try_start_1b .. :try_end_1b} :catch_2
    .catch Ljava/io/IOException; {:try_start_1b .. :try_end_1b} :catch_5
    .catch Ljava/lang/Exception; {:try_start_1b .. :try_end_1b} :catch_9
    .catch Ljava/lang/Error; {:try_start_1b .. :try_end_1b} :catch_d
    .catchall {:try_start_1b .. :try_end_1b} :catchall_0

    .line 462
    :catch_d
    move-exception v0

    move-object v2, v1

    .line 463
    :goto_4
    :try_start_1c
    const-string v4, "Cached Files - Unexpected error while attempting to get remote file (%s)"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Ljava/lang/Error;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v6

    invoke-static {v4, v5}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 464
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_1a

    .line 465
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-interface {v0, v4, v5}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_1c
    .catchall {:try_start_1c .. :try_end_1c} :catchall_1

    .line 471
    :cond_1a
    if-eqz v1, :cond_1b

    .line 472
    :try_start_1d
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_1b
    if-eqz v2, :cond_1c

    .line 475
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_1c
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1d
    .catch Ljava/io/IOException; {:try_start_1d .. :try_end_1d} :catch_e

    goto/16 :goto_0

    .line 479
    :catch_e
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 404
    :catch_f
    move-exception v0

    :try_start_1e
    invoke-static {v3, v0}, Lp;->a(Ljava/net/URLConnection;Ljava/io/IOException;)V

    throw v0
    :try_end_1e
    .catch Ljava/net/SocketTimeoutException; {:try_start_1e .. :try_end_1e} :catch_2
    .catch Ljava/io/IOException; {:try_start_1e .. :try_end_1e} :catch_5
    .catch Ljava/lang/Exception; {:try_start_1e .. :try_end_1e} :catch_9
    .catch Ljava/lang/Error; {:try_start_1e .. :try_end_1e} :catch_d
    .catchall {:try_start_1e .. :try_end_1e} :catchall_0

    .line 470
    :catchall_0
    move-exception v0

    move-object v2, v1

    .line 471
    :goto_5
    if-eqz v1, :cond_1d

    .line 472
    :try_start_1f
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_1d
    if-eqz v2, :cond_1e

    .line 475
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_1e
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1f
    .catch Ljava/io/IOException; {:try_start_1f .. :try_end_1f} :catch_14

    .line 481
    :goto_6
    throw v0

    .line 404
    :catch_10
    move-exception v0

    :try_start_20
    invoke-static {v3, v0}, Lp;->a(Ljava/net/URLConnection;Ljava/io/IOException;)V

    throw v0

    .line 411
    :cond_1f
    if-eqz v0, :cond_20

    .line 412
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    iget-object v2, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->directory:Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/adobe/mobile/RemoteDownload;->deleteCachedDataForURL(Ljava/lang/String;Ljava/lang/String;)Z

    .line 415
    :cond_20
    new-instance v2, Ljava/util/Date;

    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V

    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getLastModified()J

    move-result-wide v6

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V

    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    invoke-direct {v2, v6, v7}, Ljava/util/Date;-><init>(J)V

    .line 416
    const-string v0, "ETag"

    invoke-static {v3}, Lp;->a(Ljava/net/URLConnection;)V

    invoke-virtual {v3, v0}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v3}, Lp;->b(Ljava/net/URLConnection;)V

    invoke-static {v3}, Lp;->c(Ljava/net/URLConnection;)V

    .line 418
    if-eqz v0, :cond_21

    .line 419
    invoke-static {v0}, Lcom/adobe/mobile/StaticMethods;->getHexString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 423
    :cond_21
    iget-object v6, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    iget-object v7, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->directory:Ljava/lang/String;

    # invokes: Lcom/adobe/mobile/RemoteDownload;->getNewCachedFile(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    invoke-static {v6, v2, v0, v7}, Lcom/adobe/mobile/RemoteDownload;->access$400(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v6

    .line 425
    if-nez v6, :cond_25

    .line 426
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v0, :cond_22

    .line 427
    iget-object v0, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v2, 0x0

    const/4 v6, 0x0

    invoke-interface {v0, v2, v6}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_20
    .catch Ljava/net/SocketTimeoutException; {:try_start_20 .. :try_end_20} :catch_2
    .catch Ljava/io/IOException; {:try_start_20 .. :try_end_20} :catch_5
    .catch Ljava/lang/Exception; {:try_start_20 .. :try_end_20} :catch_9
    .catch Ljava/lang/Error; {:try_start_20 .. :try_end_20} :catch_d
    .catchall {:try_start_20 .. :try_end_20} :catchall_0

    .line 471
    :cond_22
    if-eqz v1, :cond_23

    .line 472
    :try_start_21
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_23
    if-eqz v1, :cond_24

    .line 475
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_24
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_21
    .catch Ljava/io/IOException; {:try_start_21 .. :try_end_21} :catch_11

    goto/16 :goto_0

    .line 479
    :catch_11
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 432
    :cond_25
    :try_start_22
    invoke-static {v3}, Lp;->d(Ljava/net/URLConnection;)Ljava/io/InputStream;
    :try_end_22
    .catch Ljava/net/SocketTimeoutException; {:try_start_22 .. :try_end_22} :catch_2
    .catch Ljava/io/IOException; {:try_start_22 .. :try_end_22} :catch_5
    .catch Ljava/lang/Exception; {:try_start_22 .. :try_end_22} :catch_9
    .catch Ljava/lang/Error; {:try_start_22 .. :try_end_22} :catch_d
    .catchall {:try_start_22 .. :try_end_22} :catchall_0

    move-result-object v2

    .line 433
    :try_start_23
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_23
    .catch Ljava/net/SocketTimeoutException; {:try_start_23 .. :try_end_23} :catch_1b
    .catch Ljava/io/IOException; {:try_start_23 .. :try_end_23} :catch_19
    .catch Ljava/lang/Exception; {:try_start_23 .. :try_end_23} :catch_17
    .catch Ljava/lang/Error; {:try_start_23 .. :try_end_23} :catch_15
    .catchall {:try_start_23 .. :try_end_23} :catchall_1

    .line 435
    const/16 v1, 0x1000

    :try_start_24
    new-array v1, v1, [B

    .line 438
    :goto_7
    invoke-virtual {v2, v1}, Ljava/io/InputStream;->read([B)I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_26

    .line 439
    const/4 v5, 0x0

    invoke-virtual {v0, v1, v5, v4}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_7

    .line 447
    :catch_12
    move-exception v1

    move-object v1, v2

    goto/16 :goto_1

    .line 442
    :cond_26
    const-string v1, "Cached Files - Caching successful (%s)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v7, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->url:Ljava/lang/String;

    aput-object v7, v4, v5

    invoke-static {v1, v4}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 444
    iget-object v1, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    if-eqz v1, :cond_27

    .line 445
    iget-object v1, p0, Lcom/adobe/mobile/RemoteDownload$DownloadFileTask;->callback:Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;

    const/4 v4, 0x1

    invoke-interface {v1, v4, v6}, Lcom/adobe/mobile/RemoteDownload$RemoteDownloadBlock;->call(ZLjava/io/File;)V
    :try_end_24
    .catch Ljava/net/SocketTimeoutException; {:try_start_24 .. :try_end_24} :catch_12
    .catch Ljava/io/IOException; {:try_start_24 .. :try_end_24} :catch_1a
    .catch Ljava/lang/Exception; {:try_start_24 .. :try_end_24} :catch_18
    .catch Ljava/lang/Error; {:try_start_24 .. :try_end_24} :catch_16
    .catchall {:try_start_24 .. :try_end_24} :catchall_2

    .line 471
    :cond_27
    if-eqz v0, :cond_28

    .line 472
    :try_start_25
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 474
    :cond_28
    if-eqz v2, :cond_29

    .line 475
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 477
    :cond_29
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_25
    .catch Ljava/io/IOException; {:try_start_25 .. :try_end_25} :catch_13

    goto/16 :goto_0

    .line 479
    :catch_13
    move-exception v0

    .line 480
    const-string v1, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v2, v13, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v12

    invoke-static {v1, v2}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 479
    :catch_14
    move-exception v1

    .line 480
    const-string v2, "Cached Files - Exception while attempting to close streams (%s)"

    new-array v3, v13, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/io/IOException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v3, v12

    invoke-static {v2, v3}, Lcom/adobe/mobile/StaticMethods;->logWarningFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_6

    .line 470
    :catchall_1
    move-exception v0

    goto/16 :goto_5

    :catchall_2
    move-exception v1

    move-object v14, v1

    move-object v1, v0

    move-object v0, v14

    goto/16 :goto_5

    :catchall_3
    move-exception v2

    move-object v14, v2

    move-object v2, v1

    move-object v1, v0

    move-object v0, v14

    goto/16 :goto_5

    .line 462
    :catch_15
    move-exception v0

    goto/16 :goto_4

    :catch_16
    move-exception v1

    move-object v14, v1

    move-object v1, v0

    move-object v0, v14

    goto/16 :goto_4

    .line 457
    :catch_17
    move-exception v0

    goto/16 :goto_3

    :catch_18
    move-exception v1

    move-object v14, v1

    move-object v1, v0

    move-object v0, v14

    goto/16 :goto_3

    .line 452
    :catch_19
    move-exception v0

    goto/16 :goto_2

    :catch_1a
    move-exception v1

    move-object v14, v1

    move-object v1, v0

    move-object v0, v14

    goto/16 :goto_2

    .line 447
    :catch_1b
    move-exception v0

    move-object v0, v1

    move-object v1, v2

    goto/16 :goto_1
.end method
