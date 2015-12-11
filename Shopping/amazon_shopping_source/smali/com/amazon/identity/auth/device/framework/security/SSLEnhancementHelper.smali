.class public final Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;
.super Ljava/lang/Object;
.source "SSLEnhancementHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method

.method public static enableSSLEnhancementGlobally()V
    .locals 1

    .prologue
    .line 30
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    invoke-static {v0}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 31
    sget-object v0, Lorg/apache/http/conn/ssl/SSLSocketFactory;->STRICT_HOSTNAME_VERIFIER:Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    invoke-static {v0}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 32
    return-void
.end method

.method static enforceEnhancedSSL(Ljava/net/URLConnection;)V
    .locals 2
    .param p0, "connection"    # Ljava/net/URLConnection;

    .prologue
    .line 41
    instance-of v0, p0, Ljavax/net/ssl/HttpsURLConnection;

    if-eqz v0, :cond_0

    move-object v0, p0

    .line 43
    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;->getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljavax/net/ssl/HttpsURLConnection;->setSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 44
    check-cast p0, Ljavax/net/ssl/HttpsURLConnection;

    .end local p0    # "connection":Ljava/net/URLConnection;
    sget-object v0, Lorg/apache/http/conn/ssl/SSLSocketFactory;->STRICT_HOSTNAME_VERIFIER:Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    invoke-virtual {p0, v0}, Ljavax/net/ssl/HttpsURLConnection;->setHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 46
    :cond_0
    return-void
.end method

.method private static getSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;
    .locals 4

    .prologue
    .line 55
    :try_start_0
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;->getInstance()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v1

    .line 57
    .local v1, "sSlocketFactory":Ljavax/net/ssl/SSLSocketFactory;
    if-nez v1, :cond_0

    .line 59
    new-instance v2, Ljava/lang/RuntimeException;

    const-string/jumbo v3, "Can not get secure SSL context with certificate pinning"

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    :catch_0
    move-exception v0

    .line 66
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/identity/auth/device/framework/security/SSLEnhancementHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Failed to perform certificate pinning."

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 67
    new-instance v2, Ljava/lang/AssertionError;

    invoke-direct {v2, v0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 62
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    return-object v1
.end method
