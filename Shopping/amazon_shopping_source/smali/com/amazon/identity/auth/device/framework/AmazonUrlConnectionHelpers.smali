.class public final Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;
.super Ljava/lang/Object;
.source "AmazonUrlConnectionHelpers.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static openConnection(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;
    .locals 1
    .param p0, "urlConn"    # Ljava/net/HttpURLConnection;
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 37
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->openConnection(Ljava/net/HttpURLConnection;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 38
    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    return-object v0
.end method

.method public static openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;
    .locals 1
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "authMethod"    # Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 31
    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    return-object v0
.end method

.method public static openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)Ljava/net/HttpURLConnection;
    .locals 1
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "retryLogic"    # Lcom/amazon/identity/auth/device/framework/RetryLogic;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .param p3, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/RetryableURLConnection;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)Ljava/net/HttpURLConnection;

    move-result-object v0

    .line 48
    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    return-object v0
.end method

.method public static openConnection(Ljava/net/URL;)Ljava/net/URLConnection;
    .locals 1
    .param p0, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 53
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;->createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;

    move-result-object v0

    .line 54
    invoke-static {v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->setAmazonWebRequestSettings(Ljava/net/URLConnection;)Ljava/net/URLConnection;

    move-result-object v0

    return-object v0
.end method

.method public static writeErrorStream(Ljava/net/HttpURLConnection;Ljava/lang/String;)V
    .locals 4
    .param p0, "request"    # Ljava/net/HttpURLConnection;
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    const/4 v1, 0x0

    .line 62
    .local v1, "errorStream":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v1

    .line 64
    if-nez v1, :cond_0

    .line 66
    const-string/jumbo v0, "No Error Stream Found"

    .line 73
    .local v0, "errorResponse":Ljava/lang/String;
    :goto_0
    sget-object v2, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->TAG:Ljava/lang/String;

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object v0, v2, v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 78
    return-void

    .line 70
    .end local v0    # "errorResponse":Ljava/lang/String;
    :cond_0
    :try_start_1
    new-instance v0, Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>([B)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .restart local v0    # "errorResponse":Ljava/lang/String;
    goto :goto_0

    .line 77
    .end local v0    # "errorResponse":Ljava/lang/String;
    :catchall_0
    move-exception v2

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v2
.end method
