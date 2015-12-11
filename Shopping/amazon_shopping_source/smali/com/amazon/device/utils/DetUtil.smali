.class public Lcom/amazon/device/utils/DetUtil;
.super Ljava/lang/Object;
.source "DetUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/utils/DetUtil$HeaderWriter;,
        Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;,
        Lcom/amazon/device/utils/DetUtil$HeaderProcessor;,
        Lcom/amazon/device/utils/DetUtil$PlainBodyWriter;,
        Lcom/amazon/device/utils/DetUtil$BodyWriter;,
        Lcom/amazon/device/utils/DetUtil$DetResponse;
    }
.end annotation


# static fields
.field private static final HEADER_VALUE_REGEX:Ljava/util/regex/Pattern;

.field private static final sDetDateFormat:Ljava/text/SimpleDateFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 52
    const-string/jumbo v0, "^(.+?): (.+)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/utils/DetUtil;->HEADER_VALUE_REGEX:Ljava/util/regex/Pattern;

    .line 55
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string/jumbo v1, "yyMMdd:HHmmss"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lcom/amazon/device/utils/DetUtil;->sDetDateFormat:Ljava/text/SimpleDateFormat;

    .line 58
    sget-object v0, Lcom/amazon/device/utils/DetUtil;->sDetDateFormat:Ljava/text/SimpleDateFormat;

    const-string/jumbo v1, "UTC"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 59
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    return-void
.end method


# virtual methods
.method public addEventsSectionHeader(Ljava/io/Writer;)V
    .locals 1
    .param p1, "body"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 325
    const-string/jumbo v0, "\n[Events]\n"

    invoke-virtual {p1, v0}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 326
    return-void
.end method

.method public addMetadataSectionHeader(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/io/Writer;)V
    .locals 5
    .param p1, "headerProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "deviceSerialNumber"    # Ljava/lang/String;
    .param p5, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/utils/DetUtil$HeaderProcessor;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/io/Writer;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 301
    .local p4, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v2, "[Metadata]\n"

    invoke-virtual {p5, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 302
    const-string/jumbo v2, "DeviceType"

    invoke-interface {p1, v2, p2, p5}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 303
    const-string/jumbo v2, "DeviceSerialNumber"

    invoke-interface {p1, v2, p3, p5}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 304
    const-string/jumbo v2, "SystemVersion"

    sget-object v3, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    invoke-interface {p1, v2, v3, p5}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 305
    const-string/jumbo v2, "BuildType"

    sget-object v3, Landroid/os/Build;->TYPE:Ljava/lang/String;

    invoke-interface {p1, v2, v3, p5}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 306
    const-string/jumbo v2, "BuildTags"

    sget-object v3, Landroid/os/Build;->TAGS:Ljava/lang/String;

    invoke-interface {p1, v2, v3, p5}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 307
    if-eqz p4, :cond_2

    .line 308
    invoke-interface {p4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 309
    .local v1, "infoPair":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_1

    .line 310
    :cond_0
    const-string/jumbo v3, "addMetadataSectionHeader"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Extra info key or value set to null. Skipping. Key :"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v4, " Value :"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 316
    :cond_1
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {p1, v2, v3, p5}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    goto :goto_0

    .line 319
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "infoPair":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_2
    return-void
.end method

.method public compressMessage([B)[B
    .locals 5
    .param p1, "message"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 262
    const v1, 0x3f4ccccd    # 0.8f

    .line 263
    .local v1, "compression":F
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    array-length v3, p1

    int-to-float v3, v3

    const v4, 0x3e4ccccc    # 0.19999999f

    mul-float/2addr v3, v4

    float-to-int v3, v3

    invoke-direct {v0, v3}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    .line 265
    .local v0, "compressedByteArray":Ljava/io/ByteArrayOutputStream;
    new-instance v2, Ljava/util/zip/GZIPOutputStream;

    invoke-direct {v2, v0}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 267
    .local v2, "gzipOutputStream":Ljava/util/zip/GZIPOutputStream;
    :try_start_0
    invoke-virtual {v2, p1}, Ljava/util/zip/GZIPOutputStream;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 269
    invoke-virtual {v2}, Ljava/util/zip/GZIPOutputStream;->close()V

    .line 271
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    return-object v3

    .line 269
    :catchall_0
    move-exception v3

    invoke-virtual {v2}, Ljava/util/zip/GZIPOutputStream;->close()V

    throw v3
.end method

.method public createDefaultHttpPost(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/methods/HttpPost;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "deviceSerialNumber"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 238
    new-instance v0, Lorg/apache/http/client/methods/HttpPost;

    const-string/jumbo v1, "/DeviceEventProxy/DETLogServlet?key=%s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 241
    .local v0, "postRequest":Lorg/apache/http/client/methods/HttpPost;
    const-string/jumbo v1, "expect"

    const-string/jumbo v2, ""

    invoke-virtual {v0, v1, v2}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    const-string/jumbo v1, "X-Anonymous-Tag"

    invoke-virtual {v0, v1, p3}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    const-string/jumbo v1, "X-DeviceType"

    invoke-virtual {v0, v1, p2}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 250
    const-string/jumbo v1, "X-DeviceFirmwareVersion"

    sget-object v2, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    return-object v0
.end method

.method public createDetMfbsHeader(Ljava/lang/Long;)Ljava/lang/String;
    .locals 3
    .param p1, "contentLength"    # Ljava/lang/Long;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 279
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x96

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 281
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string/jumbo v1, "\nFiles: messages.0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 282
    const-string/jumbo v1, "\n------------------"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 283
    const-string/jumbo v1, "\nMFBS/1.0 1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 284
    const-string/jumbo v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 285
    const-string/jumbo v1, "\nContent-Type: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "text/plain"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 286
    const-string/jumbo v1, "\nContent-Encoding: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "GZIP"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 287
    const-string/jumbo v1, "\nContent-Length: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 288
    const-string/jumbo v1, "\nContent-Name: Content"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 289
    const-string/jumbo v1, "\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 291
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public formatDate(J)Ljava/lang/String;
    .locals 2
    .param p1, "millisUtc"    # J

    .prologue
    .line 399
    sget-object v0, Lcom/amazon/device/utils/DetUtil;->sDetDateFormat:Ljava/text/SimpleDateFormat;

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1, p1, p2}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public postFileToDet(Lorg/apache/http/client/methods/HttpPost;Lamazon/communication/srr/SrrManager;Lamazon/communication/identity/EndpointIdentity;Lamazon/communication/authentication/RequestContext;)Lcom/amazon/device/utils/DetUtil$DetResponse;
    .locals 13
    .param p1, "postRequest"    # Lorg/apache/http/client/methods/HttpPost;
    .param p2, "srrManager"    # Lamazon/communication/srr/SrrManager;
    .param p3, "endpointIdentity"    # Lamazon/communication/identity/EndpointIdentity;
    .param p4, "requestContext"    # Lamazon/communication/authentication/RequestContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalAccessException;,
            Lamazon/communication/TimeoutException;,
            Lamazon/communication/RequestFailedException;,
            Lamazon/communication/MissingCredentialsException;
        }
    .end annotation

    .prologue
    .line 336
    if-nez p1, :cond_0

    .line 337
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "Http Post must not be null."

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 340
    :cond_0
    if-nez p2, :cond_1

    .line 341
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "SRR Manager must not be null."

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 344
    :cond_1
    if-nez p3, :cond_2

    .line 345
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v8, "Endpoint identity must not be null."

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 348
    :cond_2
    const-string/jumbo v7, "postFileToDet"

    const-string/jumbo v8, "Posting file to DET of size %d."

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {p1}, Lorg/apache/http/client/methods/HttpPost;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v11

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 350
    new-instance v7, Lamazon/communication/srr/SrrRequest$Builder;

    invoke-direct {v7}, Lamazon/communication/srr/SrrRequest$Builder;-><init>()V

    invoke-virtual {v7, p1}, Lamazon/communication/srr/SrrRequest$Builder;->setRequest(Lorg/apache/http/client/methods/HttpRequestBase;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    move-object/from16 v0, p3

    invoke-virtual {v7, v0}, Lamazon/communication/srr/SrrRequest$Builder;->setEndpointIdentity(Lamazon/communication/identity/EndpointIdentity;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    const/16 v8, 0x7530

    invoke-virtual {v7, v8}, Lamazon/communication/srr/SrrRequest$Builder;->setTimeout(I)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    sget-object v8, Lamazon/communication/connection/CompressionOption;->REQUIRED:Lamazon/communication/connection/CompressionOption;

    invoke-virtual {v7, v8}, Lamazon/communication/srr/SrrRequest$Builder;->setCompressionOption(Lamazon/communication/connection/CompressionOption;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    move-object/from16 v0, p4

    invoke-virtual {v7, v0}, Lamazon/communication/srr/SrrRequest$Builder;->setRequestContext(Lamazon/communication/authentication/RequestContext;)Lamazon/communication/srr/SrrRequest$Builder;

    move-result-object v7

    invoke-virtual {v7}, Lamazon/communication/srr/SrrRequest$Builder;->build()Lamazon/communication/srr/SrrRequest;

    move-result-object v5

    .line 360
    .local v5, "srrRequest":Lamazon/communication/srr/SrrRequest;
    invoke-interface {p2, v5}, Lamazon/communication/srr/SrrManager;->makeRequestSync(Lamazon/communication/srr/SrrRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v4

    .line 361
    .local v4, "response":Lorg/apache/http/HttpResponse;
    if-eqz v4, :cond_7

    .line 364
    :try_start_0
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v1

    .line 365
    .local v1, "entity":Lorg/apache/http/HttpEntity;
    if-nez v1, :cond_4

    const/4 v2, 0x0

    .line 366
    .local v2, "entityInputStream":Ljava/io/InputStream;
    :goto_0
    if-eqz v2, :cond_3

    .line 367
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 373
    .end local v1    # "entity":Lorg/apache/http/HttpEntity;
    .end local v2    # "entityInputStream":Ljava/io/InputStream;
    :cond_3
    :goto_1
    invoke-interface {v4}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v6

    .line 374
    .local v6, "status":Lorg/apache/http/StatusLine;
    if-eqz v6, :cond_7

    .line 375
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0xc8

    if-lt v7, v8, :cond_5

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x12c

    if-ge v7, v8, :cond_5

    .line 376
    const-string/jumbo v7, "postFileToDet"

    const-string/jumbo v8, "Succesfully posted file to DET."

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 377
    sget-object v7, Lcom/amazon/device/utils/DetUtil$DetResponse;->SUCCESS:Lcom/amazon/device/utils/DetUtil$DetResponse;

    .line 390
    .end local v6    # "status":Lorg/apache/http/StatusLine;
    :goto_2
    return-object v7

    .line 365
    .restart local v1    # "entity":Lorg/apache/http/HttpEntity;
    :cond_4
    :try_start_1
    invoke-interface {v1}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v2

    goto :goto_0

    .line 369
    .end local v1    # "entity":Lorg/apache/http/HttpEntity;
    :catch_0
    move-exception v3

    .line 370
    .local v3, "ioe":Ljava/io/IOException;
    const-string/jumbo v7, "postFileToDet"

    const-string/jumbo v8, "IO exception while trying to close the DET response."

    invoke-static {v7, v8, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 379
    .end local v3    # "ioe":Ljava/io/IOException;
    .restart local v6    # "status":Lorg/apache/http/StatusLine;
    :cond_5
    const-string/jumbo v7, "postFileToDet"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Failed with error code: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 380
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x190

    if-lt v7, v8, :cond_6

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x1f4

    if-ge v7, v8, :cond_6

    .line 381
    sget-object v7, Lcom/amazon/device/utils/DetUtil$DetResponse;->CLIENT_ERROR:Lcom/amazon/device/utils/DetUtil$DetResponse;

    goto :goto_2

    .line 382
    :cond_6
    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x1f4

    if-lt v7, v8, :cond_7

    invoke-interface {v6}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v7

    const/16 v8, 0x258

    if-ge v7, v8, :cond_7

    .line 383
    sget-object v7, Lcom/amazon/device/utils/DetUtil$DetResponse;->SERVER_ERROR:Lcom/amazon/device/utils/DetUtil$DetResponse;

    goto :goto_2

    .line 390
    .end local v6    # "status":Lorg/apache/http/StatusLine;
    :cond_7
    sget-object v7, Lcom/amazon/device/utils/DetUtil$DetResponse;->CLIENT_ERROR:Lcom/amazon/device/utils/DetUtil$DetResponse;

    goto :goto_2
.end method

.method public processHeaders(Ljava/io/BufferedReader;Ljava/io/Writer;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V
    .locals 5
    .param p1, "reader"    # Ljava/io/BufferedReader;
    .param p2, "writer"    # Ljava/io/Writer;
    .param p3, "headerProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 210
    const/4 v1, 0x0

    .line 211
    .local v1, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 214
    const-string/jumbo v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 232
    :cond_0
    return-void

    .line 220
    :cond_1
    sget-object v4, Lcom/amazon/device/utils/DetUtil;->HEADER_VALUE_REGEX:Ljava/util/regex/Pattern;

    invoke-virtual {v4, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 221
    .local v2, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 223
    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    .line 224
    .local v0, "header":Ljava/lang/String;
    const/4 v4, 0x2

    invoke-virtual {v2, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    .line 226
    .local v3, "value":Ljava/lang/String;
    invoke-interface {p3, v0, v3, p2}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    goto :goto_0
.end method
