.class public final Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;
.super Ljava/lang/Object;
.source "SSLConfiguration.java"


# static fields
.field private static final DEFAULT_HOSTNAME_VERIFIER:Ljavax/net/ssl/HostnameVerifier;

.field private static final DEFAULT_SSL_SOCKET_FACTORY:Ljavax/net/ssl/SSLSocketFactory;

.field private static final TAG:Ljava/lang/String;

.field private static final TRUST_ALL_HOSTNAME_VERIFIER:Ljavax/net/ssl/HostnameVerifier;

.field private static final TRUST_ALL_HOSTS_SOCKET_FACTORY:Ljavax/net/ssl/SSLSocketFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TAG:Ljava/lang/String;

    .line 21
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->DEFAULT_HOSTNAME_VERIFIER:Ljavax/net/ssl/HostnameVerifier;

    .line 22
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->DEFAULT_SSL_SOCKET_FACTORY:Ljavax/net/ssl/SSLSocketFactory;

    .line 24
    new-instance v0, Lorg/apache/http/conn/ssl/AllowAllHostnameVerifier;

    invoke-direct {v0}, Lorg/apache/http/conn/ssl/AllowAllHostnameVerifier;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TRUST_ALL_HOSTNAME_VERIFIER:Ljavax/net/ssl/HostnameVerifier;

    .line 25
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/net/SSLCertificateSocketFactory;->getInsecure(ILandroid/net/SSLSessionCache;)Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TRUST_ALL_HOSTS_SOCKET_FACTORY:Ljavax/net/ssl/SSLSocketFactory;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public static toggleTrustSSLHosts(Z)V
    .locals 7
    .param p0, "trustAllSSLHosts"    # Z

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 34
    sget-object v1, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Attempting to toggle trusting all SSL hosts to %s. This should never happen in production devices."

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    if-eqz p0, :cond_1

    .line 40
    sget-object v1, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TRUST_ALL_HOSTNAME_VERIFIER:Ljavax/net/ssl/HostnameVerifier;

    sget-object v2, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TRUST_ALL_HOSTS_SOCKET_FACTORY:Ljavax/net/ssl/SSLSocketFactory;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->tryChangeDefaults(Ljavax/net/ssl/HostnameVerifier;Ljavax/net/ssl/SSLSocketFactory;)Z

    move-result v0

    .line 47
    .local v0, "changed":Z
    :goto_0
    if-eqz v0, :cond_0

    .line 49
    sget-object v1, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Toggling trust all ssl hosts. New Value: %s"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    :cond_0
    return-void

    .line 44
    .end local v0    # "changed":Z
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->DEFAULT_HOSTNAME_VERIFIER:Ljavax/net/ssl/HostnameVerifier;

    sget-object v2, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->DEFAULT_SSL_SOCKET_FACTORY:Ljavax/net/ssl/SSLSocketFactory;

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/framework/security/SSLConfiguration;->tryChangeDefaults(Ljavax/net/ssl/HostnameVerifier;Ljavax/net/ssl/SSLSocketFactory;)Z

    move-result v0

    .restart local v0    # "changed":Z
    goto :goto_0
.end method

.method private static tryChangeDefaults(Ljavax/net/ssl/HostnameVerifier;Ljavax/net/ssl/SSLSocketFactory;)Z
    .locals 2
    .param p0, "newHostnameVerifier"    # Ljavax/net/ssl/HostnameVerifier;
    .param p1, "newSocketFactory"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 57
    const/4 v0, 0x0

    .line 58
    .local v0, "changed":Z
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultHostnameVerifier()Ljavax/net/ssl/HostnameVerifier;

    move-result-object v1

    if-eq v1, p0, :cond_0

    .line 60
    invoke-static {p0}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultHostnameVerifier(Ljavax/net/ssl/HostnameVerifier;)V

    .line 61
    const/4 v0, 0x1

    .line 64
    :cond_0
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v1

    if-eq v1, p1, :cond_1

    .line 66
    invoke-static {p1}, Ljavax/net/ssl/HttpsURLConnection;->setDefaultSSLSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)V

    .line 67
    const/4 v0, 0x1

    .line 70
    :cond_1
    return v0
.end method
