.class public final Lcom/amazon/identity/auth/device/framework/security/EnhancedURLConnectionFactory;
.super Ljava/lang/Object;
.source "EnhancedURLConnectionFactory.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static createURLConnection(Ljava/net/URL;)Ljava/net/URLConnection;
    .locals 3
    .param p0, "url"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    if-nez p0, :cond_0

    .line 32
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Null url is not allowed"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 35
    :cond_0
    invoke-virtual {p0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 37
    .local v0, "connection":Ljava/net/URLConnection;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->isCurrentEnvironmentProd()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 39
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;->enforceEnhancedSSL(Ljava/net/URLConnection;)V

    .line 42
    :cond_1
    return-object v0
.end method
