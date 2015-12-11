.class Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;
.super Ljava/lang/Object;
.source "MboxFactory.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/adms/testandtarget/MboxFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TargetBackgroundTask"
.end annotation


# instance fields
.field public callback:Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/adobe/adms/testandtarget/MboxFactory;Lcom/adobe/adms/testandtarget/Mbox;Ljava/lang/String;Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;)V
    .locals 0
    .param p2, "mbox"    # Lcom/adobe/adms/testandtarget/Mbox;
    .param p3, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/adms/testandtarget/Mbox;",
            "Ljava/lang/String;",
            "Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 322
    .local p4, "callback":Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;, "Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    .line 323
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 325
    iput-object p3, p0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->url:Ljava/lang/String;

    .line 326
    iput-object p4, p0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->callback:Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;

    .line 327
    return-void
.end method


# virtual methods
.method public run()V
    .locals 17

    .prologue
    .line 331
    new-instance v7, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v7}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 332
    .local v7, "httpClient":Lorg/apache/http/impl/client/DefaultHttpClient;
    new-instance v6, Lorg/apache/http/client/methods/HttpGet;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->url:Ljava/lang/String;

    invoke-direct {v6, v13}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 333
    .local v6, "getRequest":Lorg/apache/http/client/methods/HttpGet;
    const-string v13, "User-Agent"

    const-string v14, "Apache-HttpClient (Test&Target Android SDK)"

    invoke-virtual {v6, v13, v14}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    # getter for: Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;
    invoke-static {v13}, Lcom/adobe/adms/testandtarget/MboxFactory;->access$000(Lcom/adobe/adms/testandtarget/MboxFactory;)Ljava/lang/String;

    move-result-object v13

    if-eqz v13, :cond_0

    .line 335
    const-string v13, "Cookie"

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    # getter for: Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;
    invoke-static {v14}, Lcom/adobe/adms/testandtarget/MboxFactory;->access$000(Lcom/adobe/adms/testandtarget/MboxFactory;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v6, v13, v14}, Lorg/apache/http/client/methods/HttpGet;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    :cond_0
    const/4 v8, 0x0

    .line 339
    .local v8, "inputStream":Ljava/io/InputStream;
    const/4 v1, 0x0

    .line 342
    .local v1, "content":Ljava/io/ByteArrayOutputStream;
    :try_start_0
    invoke-virtual {v7, v6}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v10

    .line 343
    .local v10, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v13

    invoke-interface {v13}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v11

    .line 344
    .local v11, "statusCode":I
    const-string v13, "Content-Type"

    invoke-interface {v10, v13}, Lorg/apache/http/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v13

    invoke-interface {v13}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 345
    .local v3, "contentType":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    invoke-virtual {v7}, Lorg/apache/http/impl/client/DefaultHttpClient;->getCookieStore()Lorg/apache/http/client/CookieStore;

    move-result-object v14

    # invokes: Lcom/adobe/adms/testandtarget/MboxFactory;->saveCookies(Lorg/apache/http/client/CookieStore;)V
    invoke-static {v13, v14}, Lcom/adobe/adms/testandtarget/MboxFactory;->access$100(Lcom/adobe/adms/testandtarget/MboxFactory;Lorg/apache/http/client/CookieStore;)V

    .line 346
    const/16 v13, 0xc8

    if-ne v11, v13, :cond_1

    const-string v13, "image/gif"

    invoke-virtual {v3, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 347
    :cond_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->callback:Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;

    const-string v14, "/images/log.gif"

    invoke-interface {v13, v14}, Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;->call(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 367
    :goto_0
    :try_start_1
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V

    .line 368
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4

    .line 371
    .end local v3    # "contentType":Ljava/lang/String;
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "statusCode":I
    :goto_1
    return-void

    .line 350
    .restart local v3    # "contentType":Ljava/lang/String;
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v11    # "statusCode":I
    :cond_2
    :try_start_2
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v5

    .line 351
    .local v5, "entity":Lorg/apache/http/HttpEntity;
    invoke-interface {v5}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v8

    .line 352
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 353
    .end local v1    # "content":Ljava/io/ByteArrayOutputStream;
    .local v2, "content":Ljava/io/ByteArrayOutputStream;
    const/16 v13, 0x200

    :try_start_3
    new-array v12, v13, [B

    .line 354
    .local v12, "streamBuffer":[B
    const/4 v9, 0x0

    .line 355
    .local v9, "readBytes":I
    :goto_2
    invoke-virtual {v8, v12}, Ljava/io/InputStream;->read([B)I

    move-result v9

    const/4 v13, -0x1

    if-eq v9, v13, :cond_3

    .line 356
    const/4 v13, 0x0

    invoke-virtual {v2, v12, v13, v9}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_2

    .line 361
    .end local v9    # "readBytes":I
    .end local v12    # "streamBuffer":[B
    :catch_0
    move-exception v4

    move-object v1, v2

    .line 362
    .end local v2    # "content":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "contentType":Ljava/lang/String;
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "statusCode":I
    .restart local v1    # "content":Ljava/io/ByteArrayOutputStream;
    .local v4, "e":Ljava/io/IOException;
    :goto_3
    :try_start_4
    const-string v13, "MboxFactory"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "ERROR: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v4}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 363
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->callback:Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;

    const-string v14, "/images/log.gif"

    invoke-interface {v13, v14}, Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;->call(Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 367
    :try_start_5
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V

    .line 368
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_1

    .line 369
    :catch_1
    move-exception v13

    goto :goto_1

    .line 358
    .end local v1    # "content":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v2    # "content":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "contentType":Ljava/lang/String;
    .restart local v5    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v9    # "readBytes":I
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v11    # "statusCode":I
    .restart local v12    # "streamBuffer":[B
    :cond_3
    :try_start_6
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;->callback:Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;

    new-instance v14, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v15

    const-string v16, "UTF-8"

    invoke-direct/range {v14 .. v16}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    invoke-interface {v13, v14}, Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;->call(Ljava/lang/Object;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    move-object v1, v2

    .end local v2    # "content":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "content":Ljava/io/ByteArrayOutputStream;
    goto :goto_0

    .line 366
    .end local v3    # "contentType":Ljava/lang/String;
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v9    # "readBytes":I
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "statusCode":I
    .end local v12    # "streamBuffer":[B
    :catchall_0
    move-exception v13

    .line 367
    :goto_4
    :try_start_7
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V

    .line 368
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2

    .line 369
    :goto_5
    throw v13

    :catch_2
    move-exception v14

    goto :goto_5

    .line 366
    .end local v1    # "content":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "content":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "contentType":Ljava/lang/String;
    .restart local v5    # "entity":Lorg/apache/http/HttpEntity;
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v11    # "statusCode":I
    :catchall_1
    move-exception v13

    move-object v1, v2

    .end local v2    # "content":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "content":Ljava/io/ByteArrayOutputStream;
    goto :goto_4

    .line 361
    .end local v3    # "contentType":Ljava/lang/String;
    .end local v5    # "entity":Lorg/apache/http/HttpEntity;
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    .end local v11    # "statusCode":I
    :catch_3
    move-exception v4

    goto :goto_3

    .line 369
    .restart local v3    # "contentType":Ljava/lang/String;
    .restart local v10    # "response":Lorg/apache/http/HttpResponse;
    .restart local v11    # "statusCode":I
    :catch_4
    move-exception v13

    goto :goto_1
.end method
