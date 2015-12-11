.class public Ltv/freewheel/hybrid/utils/URLLoader;
.super Ltv/freewheel/hybrid/utils/events/EventDispatcher;
.source "URLLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    }
.end annotation


# static fields
.field public static LOADER_BUFFER_SIZE:I

.field protected static androidCookieStore:Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;

.field private static cookieStore:Lorg/apache/http/client/CookieStore;


# instance fields
.field private client:Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

.field private clientAlive:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 41
    const/16 v1, 0x400

    sput v1, Ltv/freewheel/hybrid/utils/URLLoader;->LOADER_BUFFER_SIZE:I

    .line 52
    new-instance v1, Lorg/apache/http/impl/client/BasicCookieStore;

    invoke-direct {v1}, Lorg/apache/http/impl/client/BasicCookieStore;-><init>()V

    sput-object v1, Ltv/freewheel/hybrid/utils/URLLoader;->cookieStore:Lorg/apache/http/client/CookieStore;

    .line 54
    :try_start_0
    new-instance v1, Ltv/freewheel/hybrid/utils/cookie/AndroidCookieStore;

    invoke-direct {v1}, Ltv/freewheel/hybrid/utils/cookie/AndroidCookieStore;-><init>()V

    sput-object v1, Ltv/freewheel/hybrid/utils/URLLoader;->androidCookieStore:Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 58
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    :goto_0
    sget-object v1, Ltv/freewheel/hybrid/utils/URLLoader;->androidCookieStore:Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;

    invoke-interface {v1}, Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;->removeExpiredCookie()V

    .line 59
    return-void

    .line 55
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_0
    move-exception v0

    .line 56
    .restart local v0    # "e":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;

    invoke-direct {v1}, Ltv/freewheel/hybrid/utils/cookie/DummyAndroidCookieStore;-><init>()V

    sput-object v1, Ltv/freewheel/hybrid/utils/URLLoader;->androidCookieStore:Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 72
    invoke-direct {p0}, Ltv/freewheel/hybrid/utils/events/EventDispatcher;-><init>()V

    .line 48
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->clientAlive:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 49
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->client:Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    .line 73
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 74
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/utils/URLLoader;)Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/URLLoader;

    .prologue
    .line 38
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->client:Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    return-object v0
.end method

.method static synthetic access$002(Ltv/freewheel/hybrid/utils/URLLoader;Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;)Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/URLLoader;
    .param p1, "x1"    # Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    .prologue
    .line 38
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/URLLoader;->client:Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    return-object p1
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/utils/URLLoader;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/URLLoader;

    .prologue
    .line 38
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->clientAlive:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/utils/URLLoader;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/utils/URLLoader;

    .prologue
    .line 38
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method private static inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 5
    .param p0, "stream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 250
    new-instance v1, Ljava/io/InputStreamReader;

    const-string v4, "UTF-8"

    invoke-direct {v1, p0, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 252
    .local v1, "isr":Ljava/io/InputStreamReader;
    new-instance v3, Ljava/io/StringWriter;

    invoke-direct {v3}, Ljava/io/StringWriter;-><init>()V

    .line 254
    .local v3, "sw":Ljava/io/StringWriter;
    :try_start_0
    sget v4, Ltv/freewheel/hybrid/utils/URLLoader;->LOADER_BUFFER_SIZE:I

    new-array v0, v4, [C

    .line 255
    .local v0, "cbuf":[C
    const/4 v2, 0x0

    .line 256
    .local v2, "n":I
    :goto_0
    invoke-virtual {v1, v0}, Ljava/io/InputStreamReader;->read([C)I

    move-result v2

    const/4 v4, -0x1

    if-eq v2, v4, :cond_0

    .line 257
    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4, v2}, Ljava/io/StringWriter;->write([CII)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 260
    .end local v0    # "cbuf":[C
    .end local v2    # "n":I
    :catchall_0
    move-exception v4

    invoke-virtual {v1}, Ljava/io/InputStreamReader;->close()V

    throw v4

    .restart local v0    # "cbuf":[C
    .restart local v2    # "n":I
    :cond_0
    invoke-virtual {v1}, Ljava/io/InputStreamReader;->close()V

    .line 263
    invoke-virtual {v3}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    .line 243
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->clientAlive:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->client:Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    invoke-interface {v0}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    .line 245
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/URLLoader;->client:Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    .line 247
    :cond_0
    return-void
.end method

.method protected initHttpClient(Ltv/freewheel/hybrid/utils/URLRequest;I)Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;
    .locals 4
    .param p1, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;
    .param p2, "timeOutMilliSeconds"    # I

    .prologue
    .line 141
    iget-object v1, p1, Ltv/freewheel/hybrid/utils/URLRequest;->userAgent:Ljava/lang/String;

    invoke-static {v1}, Ltv/freewheel/hybrid/utils/http/SimpleHttpClient;->newInstance(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;

    move-result-object v0

    .line 145
    .local v0, "client":Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;
    invoke-interface {v0}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v1

    const-string v2, "http.connection.timeout"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 148
    invoke-interface {v0}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v1

    const-string v2, "http.socket.timeout"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 151
    return-object v0
.end method

.method protected initRequestHeader(Ltv/freewheel/hybrid/utils/URLRequest;Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)V
    .locals 5
    .param p1, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;
    .param p2, "client"    # Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;
    .param p3, "method"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 177
    sget-object v1, Ltv/freewheel/hybrid/utils/URLLoader;->androidCookieStore:Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;

    iget-object v2, p1, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    invoke-interface {v1, v2}, Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 178
    .local v0, "cookieString":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 179
    iget-object v1, p0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "sending cookie: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 181
    const-class v1, Lorg/apache/http/client/protocol/RequestAddCookies;

    invoke-interface {p2, v1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->removeRequestInterceptorByClass(Ljava/lang/Class;)V

    .line 182
    const-string v1, "Cookie"

    invoke-interface {p3, v1, v0}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    :cond_0
    iget-object v1, p1, Ltv/freewheel/hybrid/utils/URLRequest;->data:Ljava/lang/String;

    if-eqz v1, :cond_1

    instance-of v1, p3, Lorg/apache/http/client/methods/HttpPost;

    if-eqz v1, :cond_1

    move-object v1, p3

    .line 186
    check-cast v1, Lorg/apache/http/client/methods/HttpPost;

    new-instance v2, Lorg/apache/http/entity/StringEntity;

    iget-object v3, p1, Ltv/freewheel/hybrid/utils/URLRequest;->data:Ljava/lang/String;

    const-string v4, "UTF-8"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 189
    :cond_1
    const-string v1, "Content-Type"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p1, Ltv/freewheel/hybrid/utils/URLRequest;->contentType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "; charset="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "UTF-8"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p3, v1, v2}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    return-void
.end method

.method protected initRequestMethod(Ltv/freewheel/hybrid/utils/URLRequest;)Lorg/apache/http/client/methods/HttpUriRequest;
    .locals 6
    .param p1, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
        }
    .end annotation

    .prologue
    .line 155
    const/4 v1, 0x0

    .line 156
    .local v1, "method":Lorg/apache/http/client/methods/HttpUriRequest;
    const/4 v2, 0x0

    .line 158
    .local v2, "notSupportedMethod":Z
    :try_start_0
    iget v3, p1, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 159
    new-instance v1, Lorg/apache/http/client/methods/HttpGet;

    .end local v1    # "method":Lorg/apache/http/client/methods/HttpUriRequest;
    iget-object v3, p1, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    invoke-direct {v1, v3}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 168
    .restart local v1    # "method":Lorg/apache/http/client/methods/HttpUriRequest;
    :goto_0
    if-eqz v2, :cond_2

    .line 169
    new-instance v3, Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "method not supported: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v5, p1, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 160
    :cond_0
    :try_start_1
    iget v3, p1, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    if-nez v3, :cond_1

    .line 161
    new-instance v1, Lorg/apache/http/client/methods/HttpPost;

    .end local v1    # "method":Lorg/apache/http/client/methods/HttpUriRequest;
    iget-object v3, p1, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    invoke-direct {v1, v3}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    .restart local v1    # "method":Lorg/apache/http/client/methods/HttpUriRequest;
    goto :goto_0

    .line 163
    :cond_1
    const/4 v2, 0x1

    goto :goto_0

    .line 165
    .end local v1    # "method":Lorg/apache/http/client/methods/HttpUriRequest;
    :catch_0
    move-exception v0

    .line 166
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v3, Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p1, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " causes IllegalArgumentException."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 171
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .restart local v1    # "method":Lorg/apache/http/client/methods/HttpUriRequest;
    :cond_2
    return-object v1
.end method

.method protected issueHttpRequest(Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;Ltv/freewheel/hybrid/utils/URLRequest;)V
    .locals 21
    .param p1, "client"    # Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;
    .param p2, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;

    .prologue
    .line 82
    const/4 v13, 0x0

    .line 84
    .local v13, "method":Lorg/apache/http/client/methods/HttpUriRequest;
    :try_start_0
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->initRequestMethod(Ltv/freewheel/hybrid/utils/URLRequest;)Lorg/apache/http/client/methods/HttpUriRequest;
    :try_end_0
    .catch Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v13

    .line 107
    :cond_0
    :try_start_1
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p1

    invoke-virtual {v0, v1, v2, v13}, Ltv/freewheel/hybrid/utils/URLLoader;->initRequestHeader(Ltv/freewheel/hybrid/utils/URLRequest;Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)V

    .line 108
    new-instance v12, Lorg/apache/http/protocol/BasicHttpContext;

    invoke-direct {v12}, Lorg/apache/http/protocol/BasicHttpContext;-><init>()V

    .line 110
    .local v12, "localContext":Lorg/apache/http/protocol/HttpContext;
    const-string v17, "http.cookie-store"

    sget-object v18, Ltv/freewheel/hybrid/utils/URLLoader;->cookieStore:Lorg/apache/http/client/CookieStore;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-interface {v12, v0, v1}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 111
    move-object/from16 v0, p1

    invoke-interface {v0, v13, v12}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v14

    .line 113
    .local v14, "response":Lorg/apache/http/HttpResponse;
    const-string v17, "Set-Cookie"

    move-object/from16 v0, v17

    invoke-interface {v14, v0}, Lorg/apache/http/HttpResponse;->getHeaders(Ljava/lang/String;)[Lorg/apache/http/Header;

    move-result-object v4

    .line 114
    .local v4, "cookies":[Lorg/apache/http/Header;
    move-object v3, v4

    .local v3, "arr$":[Lorg/apache/http/Header;
    array-length v11, v3

    .local v11, "len$":I
    const/4 v10, 0x0

    .local v10, "i$":I
    :goto_0
    if-ge v10, v11, :cond_3

    aget-object v5, v3, v10

    .line 115
    .local v5, "cooky":Lorg/apache/http/Header;
    sget-object v17, Ltv/freewheel/hybrid/utils/URLLoader;->androidCookieStore:Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-interface {v5}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v19

    invoke-interface/range {v17 .. v19}, Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 85
    .end local v3    # "arr$":[Lorg/apache/http/Header;
    .end local v4    # "cookies":[Lorg/apache/http/Header;
    .end local v5    # "cooky":Lorg/apache/http/Header;
    .end local v10    # "i$":I
    .end local v11    # "len$":I
    .end local v12    # "localContext":Lorg/apache/http/protocol/HttpContext;
    .end local v14    # "response":Lorg/apache/http/HttpResponse;
    :catch_0
    move-exception v6

    .line 86
    .local v6, "e":Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    const/4 v9, 0x1

    .line 87
    .local v9, "gotAnError":Z
    invoke-virtual {v6}, Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;->getCause()Ljava/lang/Throwable;

    move-result-object v17

    move-object/from16 v0, v17

    instance-of v0, v0, Ljava/lang/IllegalArgumentException;

    move/from16 v17, v0

    if-eqz v17, :cond_1

    .line 88
    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ltv/freewheel/hybrid/utils/URIUtil;->getFixedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 89
    .local v8, "fixedURLStr":Ljava/lang/String;
    if-nez v8, :cond_2

    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Failed to fix URL:"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 102
    .end local v8    # "fixedURLStr":Ljava/lang/String;
    :cond_1
    :goto_1
    if-eqz v9, :cond_0

    .line 103
    new-instance v17, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v18, "URLLoader.Load.Error"

    invoke-virtual {v6}, Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v17 .. v19}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 133
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "httpclient["

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "] for URL: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " is reclaimed"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 135
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    .line 137
    .end local v6    # "e":Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    .end local v9    # "gotAnError":Z
    :goto_2
    return-void

    .line 92
    .restart local v6    # "e":Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    .restart local v8    # "fixedURLStr":Ljava/lang/String;
    .restart local v9    # "gotAnError":Z
    :cond_2
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Replace URL:"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " with fixed one:"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 93
    move-object/from16 v0, p2

    iput-object v8, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;
    :try_end_2
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 95
    :try_start_3
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->initRequestMethod(Ltv/freewheel/hybrid/utils/URLRequest;)Lorg/apache/http/client/methods/HttpUriRequest;
    :try_end_3
    .catch Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_4
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v13

    .line 96
    const/4 v9, 0x0

    goto/16 :goto_1

    .line 97
    :catch_1
    move-exception v7

    .line 98
    .local v7, "ex":Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    :try_start_4
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Failed to use fixed URL:"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V
    :try_end_4
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_1

    .line 126
    .end local v6    # "e":Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    .end local v7    # "ex":Ltv/freewheel/hybrid/utils/URLLoader$URLLoaderErrorException;
    .end local v8    # "fixedURLStr":Ljava/lang/String;
    .end local v9    # "gotAnError":Z
    :catch_2
    move-exception v6

    .line 127
    .local v6, "e":Lorg/apache/http/client/ClientProtocolException;
    :try_start_5
    new-instance v17, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v18, "URLLoader.Load.Error"

    invoke-virtual {v6}, Lorg/apache/http/client/ClientProtocolException;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v17 .. v19}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 133
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "httpclient["

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "] for URL: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " is reclaimed"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 135
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    goto/16 :goto_2

    .line 118
    .end local v6    # "e":Lorg/apache/http/client/ClientProtocolException;
    .restart local v3    # "arr$":[Lorg/apache/http/Header;
    .restart local v4    # "cookies":[Lorg/apache/http/Header;
    .restart local v10    # "i$":I
    .restart local v11    # "len$":I
    .restart local v12    # "localContext":Lorg/apache/http/protocol/HttpContext;
    .restart local v14    # "response":Lorg/apache/http/HttpResponse;
    :cond_3
    :try_start_6
    invoke-interface {v14}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v16

    .line 119
    .local v16, "status":Lorg/apache/http/StatusLine;
    invoke-interface/range {v16 .. v16}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v15

    .line 121
    .local v15, "returnCode":I
    const/16 v17, 0xc8

    move/from16 v0, v17

    if-eq v15, v0, :cond_4

    .line 122
    new-instance v17, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v18, "URLLoader.Load.Error"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "bad status code: "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v17 .. v19}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_6
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 133
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "httpclient["

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "] for URL: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " is reclaimed"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 135
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    goto/16 :goto_2

    .line 124
    :cond_4
    :try_start_7
    invoke-interface {v14}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2, v15}, Ltv/freewheel/hybrid/utils/URLLoader;->parseResponseBody(Ltv/freewheel/hybrid/utils/URLRequest;Lorg/apache/http/HttpEntity;I)V
    :try_end_7
    .catch Lorg/apache/http/client/ClientProtocolException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_4
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto :goto_3

    .line 128
    .end local v3    # "arr$":[Lorg/apache/http/Header;
    .end local v4    # "cookies":[Lorg/apache/http/Header;
    .end local v10    # "i$":I
    .end local v11    # "len$":I
    .end local v12    # "localContext":Lorg/apache/http/protocol/HttpContext;
    .end local v14    # "response":Lorg/apache/http/HttpResponse;
    .end local v15    # "returnCode":I
    .end local v16    # "status":Lorg/apache/http/StatusLine;
    :catch_3
    move-exception v6

    .line 129
    .local v6, "e":Ljava/io/IOException;
    :try_start_8
    new-instance v17, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v18, "URLLoader.Load.Error"

    invoke-virtual {v6}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v17 .. v19}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 133
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "httpclient["

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "] for URL: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " is reclaimed"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 135
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    goto/16 :goto_2

    .line 130
    .end local v6    # "e":Ljava/io/IOException;
    :catch_4
    move-exception v6

    .line 131
    .local v6, "e":Ljava/lang/Exception;
    :try_start_9
    new-instance v17, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v18, "URLLoader.Load.Error"

    invoke-virtual {v6}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v17 .. v19}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 133
    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "httpclient["

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "] for URL: "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " is reclaimed"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 135
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    goto/16 :goto_2

    .line 133
    .end local v6    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v17

    move-object/from16 v0, p0

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    move-object/from16 v18, v0

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "httpclient["

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->hashCode()I

    move-result v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "] for URL: "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p2

    iget-object v0, v0, Ltv/freewheel/hybrid/utils/URLRequest;->url:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " is reclaimed"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 135
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/hybrid/utils/http/ISimpleHttpClient;->close()V

    throw v17
.end method

.method public load(Ltv/freewheel/hybrid/utils/URLRequest;)V
    .locals 2
    .param p1, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;

    .prologue
    .line 218
    const-wide/high16 v0, 0x4034000000000000L    # 20.0

    invoke-virtual {p0, p1, v0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->load(Ltv/freewheel/hybrid/utils/URLRequest;D)V

    .line 219
    return-void
.end method

.method public load(Ltv/freewheel/hybrid/utils/URLRequest;D)V
    .locals 2
    .param p1, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;
    .param p2, "timeOutSeconds"    # D

    .prologue
    .line 222
    new-instance v0, Ltv/freewheel/hybrid/utils/URLLoader$1;

    invoke-direct {v0, p0, p1, p2, p3}, Ltv/freewheel/hybrid/utils/URLLoader$1;-><init>(Ltv/freewheel/hybrid/utils/URLLoader;Ltv/freewheel/hybrid/utils/URLRequest;D)V

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/URLLoader$1;->start()V

    .line 240
    return-void
.end method

.method protected parseResponseBody(Ltv/freewheel/hybrid/utils/URLRequest;Lorg/apache/http/HttpEntity;I)V
    .locals 4
    .param p1, "request"    # Ltv/freewheel/hybrid/utils/URLRequest;
    .param p2, "entity"    # Lorg/apache/http/HttpEntity;
    .param p3, "returnCode"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 194
    iget v1, p1, Ltv/freewheel/hybrid/utils/URLRequest;->method:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 195
    if-eqz p2, :cond_0

    .line 196
    invoke-interface {p2}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    invoke-static {v1}, Ltv/freewheel/hybrid/utils/URLLoader;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 197
    .local v0, "data":Ljava/lang/String;
    new-instance v1, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v2, "URLLoader.Load.Complete"

    invoke-direct {v1, v2, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 215
    .end local v0    # "data":Ljava/lang/String;
    :goto_0
    return-void

    .line 200
    :cond_0
    new-instance v1, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v2, "URLLoader.Load.Complete"

    invoke-direct {v1, v2, p3}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;I)V

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 205
    :cond_1
    if-eqz p2, :cond_2

    .line 206
    invoke-interface {p2}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    invoke-static {v1}, Ltv/freewheel/hybrid/utils/URLLoader;->inputStreamToString(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 207
    .restart local v0    # "data":Ljava/lang/String;
    new-instance v1, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v2, "URLLoader.Load.Complete"

    invoke-direct {v1, v2, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0

    .line 210
    .end local v0    # "data":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Ltv/freewheel/hybrid/utils/URLLoader;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v2, "response entity is null"

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    .line 211
    new-instance v1, Ltv/freewheel/hybrid/utils/events/Event;

    const-string v2, "URLLoader.Load.Error"

    const-string v3, "entity is null"

    invoke-direct {v1, v2, v3}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Ltv/freewheel/hybrid/utils/URLLoader;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0
.end method
