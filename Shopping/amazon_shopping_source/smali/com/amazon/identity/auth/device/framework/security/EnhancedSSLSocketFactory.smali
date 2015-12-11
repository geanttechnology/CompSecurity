.class final Lcom/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;
.super Ljava/lang/Object;
.source "EnhancedSSLSocketFactory.java"


# static fields
.field private static sTheOnlyInstance:Ljavax/net/ssl/SSLSocketFactory;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method

.method static declared-synchronized getInstance()Ljavax/net/ssl/SSLSocketFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 25
    const-class v1, Lcom/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;->sTheOnlyInstance:Ljavax/net/ssl/SSLSocketFactory;

    if-nez v0, :cond_0

    .line 27
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedSSLContext;->getInstance()Ljavax/net/ssl/SSLContext;

    move-result-object v2

    if-nez v2, :cond_1

    const/4 v0, 0x0

    :goto_0
    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;->sTheOnlyInstance:Ljavax/net/ssl/SSLSocketFactory;

    .line 30
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedSSLSocketFactory;->sTheOnlyInstance:Ljavax/net/ssl/SSLSocketFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 27
    :cond_1
    :try_start_1
    new-instance v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;

    invoke-virtual {v2}, Ljavax/net/ssl/SSLContext;->getSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;-><init>(Ljavax/net/ssl/SSLSocketFactory;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 25
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
