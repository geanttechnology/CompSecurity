.class final Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;
.super Ljava/lang/Object;
.source "CertificatePinnedSSLContext.java"


# static fields
.field private static sTheOnlyInstance:Ljavax/net/ssl/SSLContext;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method

.method static declared-synchronized getInstance()Ljavax/net/ssl/SSLContext;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 26
    const-class v1, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;

    monitor-enter v1

    :try_start_0
    sget-object v2, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;->sTheOnlyInstance:Ljavax/net/ssl/SSLContext;

    if-nez v2, :cond_0

    .line 28
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->getInstance()Ljava/security/KeyStore;

    move-result-object v2

    if-nez v2, :cond_1

    :goto_0
    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;->sTheOnlyInstance:Ljavax/net/ssl/SSLContext;

    .line 31
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;->sTheOnlyInstance:Ljavax/net/ssl/SSLContext;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 28
    :cond_1
    :try_start_1
    invoke-static {}, Ljavax/net/ssl/TrustManagerFactory;->getDefaultAlgorithm()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljavax/net/ssl/TrustManagerFactory;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljavax/net/ssl/TrustManagerFactory;->init(Ljava/security/KeyStore;)V

    const-string/jumbo v0, "TLS"

    invoke-static {v0}, Ljavax/net/ssl/SSLContext;->getInstance(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v3}, Ljavax/net/ssl/TrustManagerFactory;->getTrustManagers()[Ljavax/net/ssl/TrustManager;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Ljavax/net/ssl/SSLContext;->init([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 26
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
