.class final Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;
.super Ljava/lang/Object;
.source "CertificatePinnedKeyStore.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOnlyInstance:Ljava/security/KeyStore;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    return-void
.end method

.method static declared-synchronized getInstance()Ljava/security/KeyStore;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/KeyStoreException;,
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/cert/CertificateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 33
    const-class v1, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->sTheOnlyInstance:Ljava/security/KeyStore;

    if-nez v0, :cond_0

    .line 35
    const-string/jumbo v0, "default_client_truststore.bks"

    const-string/jumbo v2, "BKS"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->loadKeyStoreFromFile$24430370(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->sTheOnlyInstance:Ljava/security/KeyStore;

    .line 38
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->sTheOnlyInstance:Ljava/security/KeyStore;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 33
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static loadKeyStoreFromFile$24430370(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyStore;
    .locals 6
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/KeyStoreException;,
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/cert/CertificateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 53
    const/4 v2, 0x0

    .line 56
    .local v2, "resource":Ljava/io/InputStream;
    :try_start_0
    const-class v3, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;

    invoke-virtual {v3, p0}, Ljava/lang/Class;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    .line 58
    if-nez v2, :cond_1

    .line 60
    sget-object v3, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Can not find the trusted store file: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 61
    if-eqz v2, :cond_0

    .line 75
    :try_start_1
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 81
    :cond_0
    :goto_0
    return-object v1

    .line 78
    :catch_0
    move-exception v0

    .line 80
    .local v0, "e":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Got IOException when trying to close the trusted store stream"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 64
    .end local v0    # "e":Ljava/io/IOException;
    :cond_1
    :try_start_2
    invoke-static {p1}, Ljava/security/KeyStore;->getInstance(Ljava/lang/String;)Ljava/security/KeyStore;

    move-result-object v1

    .line 65
    .local v1, "keyStore":Ljava/security/KeyStore;
    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Ljava/security/KeyStore;->load(Ljava/io/InputStream;[C)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 73
    if-eqz v2, :cond_0

    .line 75
    :try_start_3
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 78
    :catch_1
    move-exception v0

    .line 80
    .restart local v0    # "e":Ljava/io/IOException;
    sget-object v3, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Got IOException when trying to close the trusted store stream"

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 71
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "keyStore":Ljava/security/KeyStore;
    :catchall_0
    move-exception v3

    .line 73
    if-eqz v2, :cond_2

    .line 75
    :try_start_4
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 81
    :cond_2
    :goto_1
    throw v3

    .line 78
    :catch_2
    move-exception v0

    .line 80
    .restart local v0    # "e":Ljava/io/IOException;
    sget-object v4, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Got IOException when trying to close the trusted store stream"

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method
