.class public final Lcom/amazon/identity/auth/device/framework/RetryableURLConnection;
.super Ljava/lang/Object;
.source "RetryableURLConnection.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method

.method public static openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)Ljava/net/HttpURLConnection;
    .locals 3
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
    .line 26
    if-nez p0, :cond_0

    .line 28
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Must Specify a URL"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 31
    :cond_0
    if-nez p1, :cond_1

    .line 33
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Must Specify Retry Logic"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 36
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;->createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;

    move-result-object v0

    .line 38
    .local v0, "connection":Ljava/net/URLConnection;
    instance-of v1, v0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v1, :cond_2

    .line 40
    new-instance v1, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/RetryableHttpsURLConnection;-><init>(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V

    .line 44
    :goto_0
    return-object v1

    .line 42
    :cond_2
    instance-of v1, v0, Ljava/net/HttpURLConnection;

    if-eqz v1, :cond_3

    .line 44
    new-instance v1, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/framework/RetryableHttpURLConnection;-><init>(Ljava/net/URL;Lcom/amazon/identity/auth/device/framework/RetryLogic;Lcom/amazon/identity/auth/device/framework/Tracer;Landroid/content/Context;)V

    goto :goto_0

    .line 47
    :cond_3
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Url must be an Https or Http Url"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
