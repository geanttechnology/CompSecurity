.class public Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;
.super Ljava/lang/Object;
.source "AmazonWebserviceCall.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCall;


# static fields
.field static final AMZN_REQUEST_ID_HEADER:Ljava/lang/String; = "X-Amzn-RequestId"

.field static final CALL_COUNTER:Ljava/util/concurrent/atomic/AtomicInteger;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

.field private final mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

.field mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

.field mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->CALL_COUNTER:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 35
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p3, "callback"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;
    .param p4, "requestSigner"    # Lcom/amazon/identity/kcpsdk/auth/RequestSigner;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    const/4 v0, 0x0

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    .line 38
    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 39
    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 50
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .line 51
    iput-object p4, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .line 53
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    .line 54
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mContext:Landroid/content/Context;

    .line 55
    iput-object p5, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    .line 56
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static connectionRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/net/HttpURLConnection;)Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    .locals 10
    .param p0, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p1, "connection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 277
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getVerb()Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    move-result-object v5

    .line 278
    .local v5, "verb":Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    sget-object v6, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    if-ne v5, v6, :cond_0

    .line 280
    const-string/jumbo v6, "GET"

    invoke-virtual {p1, v6}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 297
    :goto_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getNumHeaders()I

    move-result v6

    if-ge v0, v6, :cond_3

    .line 299
    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getHeaderName(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getHeaderValue(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1, v6, v7}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 282
    .end local v0    # "i":I
    :cond_0
    sget-object v6, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    if-ne v5, v6, :cond_1

    .line 284
    const-string/jumbo v6, "POST"

    invoke-virtual {p1, v6}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 285
    invoke-virtual {p1, v7}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    goto :goto_0

    .line 287
    :cond_1
    sget-object v6, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPut:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    if-ne v5, v6, :cond_2

    .line 289
    const-string/jumbo v6, "PUT"

    invoke-virtual {p1, v6}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 290
    invoke-virtual {p1, v7}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    goto :goto_0

    .line 294
    :cond_2
    new-instance v6, Ljava/lang/UnsupportedOperationException;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "unrecognized HttpVerb: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 302
    .restart local v0    # "i":I
    :cond_3
    sget-object v6, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPost:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    if-eq v5, v6, :cond_4

    sget-object v6, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbPut:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    if-ne v5, v6, :cond_6

    .line 304
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getBodyBytes()[B

    move-result-object v6

    if-eqz v6, :cond_5

    array-length v7, v6

    if-nez v7, :cond_7

    .line 305
    :cond_5
    :goto_2
    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Finished write body."

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    :cond_6
    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Starting get response code"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    .line 309
    .local v2, "responseCode":I
    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Received response: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 311
    const/4 v6, -0x1

    if-ne v2, v6, :cond_8

    .line 313
    new-instance v6, Ljava/io/IOException;

    const-string/jumbo v7, "Invalid response code"

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 304
    .end local v2    # "responseCode":I
    :cond_7
    array-length v7, v6

    invoke-virtual {p1, v7}, Ljava/net/HttpURLConnection;->setFixedLengthStreamingMode(I)V

    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v7

    :try_start_0
    invoke-virtual {v7, v6}, Ljava/io/OutputStream;->write([B)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    invoke-virtual {v7}, Ljava/io/OutputStream;->flush()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    :goto_3
    :try_start_2
    invoke-virtual {v7}, Ljava/io/OutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2

    :catch_0
    move-exception v6

    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Couldn\'t close write body stream"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :catch_1
    move-exception v6

    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Couldn\'t flush write body stream"

    invoke-static {v6, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    :catchall_0
    move-exception v6

    :try_start_3
    invoke-virtual {v7}, Ljava/io/OutputStream;->flush()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    :goto_4
    :try_start_4
    invoke-virtual {v7}, Ljava/io/OutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    :goto_5
    throw v6

    :catch_2
    move-exception v8

    sget-object v8, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "Couldn\'t flush write body stream"

    invoke-static {v8, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    :catch_3
    move-exception v7

    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Couldn\'t close write body stream"

    invoke-static {v7, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    .line 316
    .restart local v2    # "responseCode":I
    :cond_8
    new-instance v3, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;-><init>()V

    .line 317
    .local v3, "responseHeaders":Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    int-to-long v6, v2

    invoke-virtual {v3, v6, v7}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->setStatusCode(J)V

    .line 319
    const/4 v0, 0x1

    .line 324
    :cond_9
    invoke-virtual {p1, v0}, Ljava/net/HttpURLConnection;->getHeaderFieldKey(I)Ljava/lang/String;

    move-result-object v1

    .line 325
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {p1, v0}, Ljava/net/HttpURLConnection;->getHeaderField(I)Ljava/lang/String;

    move-result-object v4

    .line 326
    .local v4, "value":Ljava/lang/String;
    if-eqz v4, :cond_a

    .line 328
    invoke-virtual {v3, v1, v4}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    add-int/lit8 v0, v0, 0x1

    .line 332
    :cond_a
    if-nez v4, :cond_9

    .line 334
    return-object v3
.end method

.method public static doRun(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/Object;
    .locals 13
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "parser"    # Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
        }
    .end annotation

    .prologue
    .line 174
    const/4 v1, 0x0

    .line 176
    .local v1, "connection":Ljava/net/HttpURLConnection;
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->getTimer(Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v4

    .line 177
    .local v4, "metricsTimer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    const/4 v5, 0x0

    .line 178
    .local v5, "rawInput":Ljava/io/InputStream;
    invoke-virtual {v4}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->start()V

    .line 181
    :try_start_0
    new-instance v8, Ljava/net/URL;

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 182
    .local v8, "url":Ljava/net/URL;
    new-instance v7, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;

    invoke-direct {v7, p0, p2}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallRetryLogic;-><init>(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;)V

    .line 183
    .local v7, "retryLogic":Lcom/amazon/identity/auth/device/framework/RetryLogic;
    move-object/from16 v0, p3

    invoke-static {v8, v7, v0, p0}, Lcom/amazon/identity/auth/device/framework/RetryableURLConnection;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)Ljava/net/HttpURLConnection;

    move-result-object v1

    .line 184
    invoke-static {v1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v9

    move-object v0, v9

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v1, v0

    .line 185
    sget-object v9, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string/jumbo v10, "X-Amzn-RequestId:"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string/jumbo v10, "X-Amzn-RequestId"

    invoke-virtual {v1, v10}, Ljava/net/HttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 186
    sget-object v9, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Opened WebRequest Connection."

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    invoke-static {p1, v1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->connectionRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;Ljava/net/HttpURLConnection;)Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lcom/amazon/identity/kcpsdk/auth/ParseErrorException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v6

    .line 192
    .local v6, "responseHeaders":Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    :try_start_1
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Lcom/amazon/identity/kcpsdk/auth/ParseErrorException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 199
    :goto_0
    const/4 v2, 0x0

    .line 200
    .local v2, "data":[B
    if-eqz v5, :cond_0

    .line 202
    :try_start_2
    invoke-static {v5}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getInput(Ljava/io/InputStream;)[B

    move-result-object v2

    .line 205
    :cond_0
    invoke-interface {p2, v6, v2}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;->parse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;[B)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Lcom/amazon/identity/kcpsdk/auth/ParseErrorException; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v9

    .line 237
    if-eqz v5, :cond_1

    .line 241
    :try_start_3
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 249
    :cond_1
    :goto_1
    if-eqz v1, :cond_2

    .line 251
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 254
    :cond_2
    invoke-virtual {v4}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    return-object v9

    .line 196
    .end local v2    # "data":[B
    :catch_0
    move-exception v9

    :try_start_4
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Lcom/amazon/identity/kcpsdk/auth/ParseErrorException; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v5

    goto :goto_0

    .line 243
    .restart local v2    # "data":[B
    :catch_1
    move-exception v3

    .line 245
    .local v3, "e":Ljava/io/IOException;
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v11, Ljava/lang/StringBuilder;

    const-string/jumbo v12, "Error closing stream to "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getLogSafeUrl(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->printStackTrace(Ljava/lang/Exception;)V

    goto :goto_1

    .line 207
    .end local v2    # "data":[B
    .end local v3    # "e":Ljava/io/IOException;
    .end local v6    # "responseHeaders":Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    .end local v7    # "retryLogic":Lcom/amazon/identity/auth/device/framework/RetryLogic;
    .end local v8    # "url":Ljava/net/URL;
    :catch_2
    move-exception v3

    .line 209
    .restart local v3    # "e":Ljava/io/IOException;
    :try_start_5
    sget-object v9, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "IOException making request to "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getLogSafeUrl(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->printStackTrace(Ljava/lang/Exception;)V

    .line 212
    invoke-static {p0, v4}, Lcom/amazon/identity/platform/metric/MetricUtils;->checkConnectivity(Landroid/content/Context;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 214
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->reportNetworkNotAvailableFailure(Ljava/lang/String;)V

    .line 217
    :cond_3
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->reportNetworkFailure(Ljava/lang/String;)V

    .line 219
    throw v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 237
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v9

    if-eqz v5, :cond_4

    .line 241
    :try_start_6
    invoke-virtual {v5}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_5

    .line 249
    :cond_4
    :goto_2
    if-eqz v1, :cond_5

    .line 251
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 254
    :cond_5
    invoke-virtual {v4}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    throw v9

    .line 221
    :catch_3
    move-exception v3

    .line 223
    .local v3, "e":Ljava/lang/UnsupportedOperationException;
    :try_start_7
    sget-object v9, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string/jumbo v11, "UnsupportedOperationException making request to "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getLogSafeUrl(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->printStackTrace(Ljava/lang/Exception;)V

    .line 226
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->reportNetworkFailure(Ljava/lang/String;)V

    .line 228
    throw v3

    .line 230
    .end local v3    # "e":Ljava/lang/UnsupportedOperationException;
    :catch_4
    move-exception v9

    throw v9
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 243
    :catch_5
    move-exception v3

    .line 245
    .local v3, "e":Ljava/io/IOException;
    sget-object v10, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v11, Ljava/lang/StringBuilder;

    const-string/jumbo v12, "Error closing stream to "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getLogSafeUrl(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->printStackTrace(Ljava/lang/Exception;)V

    goto :goto_2
.end method

.method public static getInput(Ljava/io/InputStream;)[B
    .locals 1
    .param p0, "rawInput"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 376
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v0

    return-object v0
.end method

.method private static getLogSafeUrl(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Ljava/lang/String;
    .locals 3
    .param p0, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;

    .prologue
    .line 267
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getQueryString()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getTimeInMS$134621()I
    .locals 4

    .prologue
    .line 77
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x1e

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    long-to-int v0, v0

    return v0
.end method

.method private static handleAuthentication(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;)V
    .locals 2
    .param p0, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p1, "requestSigner"    # Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    .prologue
    .line 93
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getAuthenticationRequired()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 95
    if-eqz p1, :cond_1

    .line 97
    invoke-virtual {p1, p0}, Lcom/amazon/identity/kcpsdk/auth/RequestSigner;->signRequest(Lcom/amazon/identity/kcpsdk/common/WebRequest;)Z

    .line 105
    :cond_0
    :goto_0
    return-void

    .line 101
    :cond_1
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "The request requires authentication, but no authentication credentials were supplied."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static printStackTrace(Ljava/lang/Exception;)V
    .locals 7
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 381
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    invoke-virtual {p0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 383
    invoke-virtual {p0}, Ljava/lang/Exception;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    .local v0, "arr$":[Ljava/lang/StackTraceElement;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 385
    .local v3, "stEle":Ljava/lang/StackTraceElement;
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Log Exception: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 383
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 387
    .end local v3    # "stEle":Ljava/lang/StackTraceElement;
    :cond_0
    return-void
.end method

.method public static run(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/Object;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "request"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p2, "parser"    # Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;
    .param p3, "requestSigner"    # Lcom/amazon/identity/kcpsdk/auth/RequestSigner;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
        }
    .end annotation

    .prologue
    .line 161
    invoke-static {p1, p3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->handleAuthentication(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;)V

    .line 163
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Starting web request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 166
    invoke-static {p0, p1, p2, p4}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->doRun(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/net/URLConnection;",
            ">(TT;)TT;"
        }
    .end annotation

    .prologue
    .line 60
    .local p0, "connection":Ljava/net/URLConnection;, "TT;"
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    .line 61
    .local v2, "requestID":Ljava/lang/String;
    const-string/jumbo v3, "X-Amzn-RequestId"

    invoke-virtual {p0, v3, v2}, Ljava/net/URLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "RequestId: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 64
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getTimeInMS$134621()I

    move-result v0

    .line 67
    .local v0, "connectionTimeoutInMillis":I
    invoke-virtual {p0, v0}, Ljava/net/URLConnection;->setConnectTimeout(I)V

    .line 69
    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->getTimeInMS$134621()I

    move-result v1

    .line 70
    .local v1, "readTimeoutInMillis":I
    invoke-virtual {p0, v1}, Ljava/net/URLConnection;->setReadTimeout(I)V

    .line 72
    return-object p0
.end method


# virtual methods
.method public call()V
    .locals 4

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mRequestSigner:Lcom/amazon/identity/kcpsdk/auth/RequestSigner;

    invoke-static {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->handleAuthentication(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/RequestSigner;)V

    .line 85
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Starting web request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->TAG:Ljava/lang/String;

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getUrl()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 88
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebRequest:Lcom/amazon/identity/kcpsdk/common/WebRequest;

    new-instance v2, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;

    invoke-direct {v2, p0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall$1;-><init>(Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;)V

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->doRun(Landroid/content/Context;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/amazon/identity/kcpsdk/auth/ParseErrorException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_1

    .line 89
    :goto_0
    return-void

    .line 88
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onNetworkError()V

    goto :goto_0

    :catch_1
    move-exception v0

    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->mWebServiceCallback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onNetworkError()V

    goto :goto_0

    :catch_2
    move-exception v0

    goto :goto_0
.end method
