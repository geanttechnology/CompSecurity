.class public final Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;
.super Ljava/lang/Object;
.source "EnhancedApacheSSLSocketFactory.java"

# interfaces
.implements Lorg/apache/http/conn/scheme/LayeredSocketFactory;
.implements Lorg/apache/http/conn/scheme/SocketFactory;


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final TAG:Ljava/lang/String;

.field private static sTheOnlyInstance:Lorg/apache/http/conn/scheme/SocketFactory;


# instance fields
.field private final mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->$assertionsDisabled:Z

    .line 32
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->TAG:Ljava/lang/String;

    return-void

    .line 28
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Ljava/security/KeyStore;)V
    .locals 2
    .param p1, "truststore"    # Ljava/security/KeyStore;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyManagementException;,
            Ljava/security/KeyStoreException;,
            Ljava/security/UnrecoverableKeyException;
        }
    .end annotation

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-direct {v0, p1}, Lorg/apache/http/conn/ssl/SSLSocketFactory;-><init>(Ljava/security/KeyStore;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    sget-object v1, Lorg/apache/http/conn/ssl/SSLSocketFactory;->STRICT_HOSTNAME_VERIFIER:Lorg/apache/http/conn/ssl/X509HostnameVerifier;

    invoke-virtual {v0, v1}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->setHostnameVerifier(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V

    .line 44
    return-void
.end method

.method private enforceStrongCipher(Ljava/net/Socket;)V
    .locals 3
    .param p1, "socket"    # Ljava/net/Socket;

    .prologue
    .line 90
    sget-boolean v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->$assertionsDisabled:Z

    if-nez v0, :cond_0

    instance-of v0, p1, Ljavax/net/ssl/SSLSocket;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_0
    move-object v0, p1

    .line 92
    check-cast v0, Ljavax/net/ssl/SSLSocket;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->enableAllowed(Ljavax/net/ssl/SSLSocket;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 94
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "The socket only support deprecated ciphers: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    check-cast p1, Ljavax/net/ssl/SSLSocket;

    .end local p1    # "socket":Ljava/net/Socket;
    invoke-virtual {p1}, Ljavax/net/ssl/SSLSocket;->getSupportedCipherSuites()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    new-instance v0, Ljava/lang/SecurityException;

    const-string/jumbo v1, "Unable to enforce strong cipher over https."

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 99
    .restart local p1    # "socket":Ljava/net/Socket;
    :cond_1
    return-void
.end method

.method public static declared-synchronized getInstance()Lorg/apache/http/conn/scheme/SocketFactory;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/KeyManagementException;,
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/KeyStoreException;,
            Ljava/security/UnrecoverableKeyException;,
            Ljava/security/cert/CertificateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 49
    const-class v1, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->sTheOnlyInstance:Lorg/apache/http/conn/scheme/SocketFactory;

    if-nez v0, :cond_0

    .line 51
    new-instance v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;

    invoke-static {}, Lcom/amazon/identity/auth/device/framework/security/CertificatePinnedKeyStore;->getInstance()Ljava/security/KeyStore;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;-><init>(Ljava/security/KeyStore;)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->sTheOnlyInstance:Lorg/apache/http/conn/scheme/SocketFactory;

    .line 53
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->sTheOnlyInstance:Lorg/apache/http/conn/scheme/SocketFactory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public connectSocket(Ljava/net/Socket;Ljava/lang/String;ILjava/net/InetAddress;ILorg/apache/http/params/HttpParams;)Ljava/net/Socket;
    .locals 8
    .param p1, "sock"    # Ljava/net/Socket;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "localAddress"    # Ljava/net/InetAddress;
    .param p5, "localPort"    # I
    .param p6, "params"    # Lorg/apache/http/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->connectSocket(Ljava/net/Socket;Ljava/lang/String;ILjava/net/InetAddress;ILorg/apache/http/params/HttpParams;)Ljava/net/Socket;

    move-result-object v7

    .line 74
    .local v7, "resSocket":Ljava/net/Socket;
    invoke-direct {p0, v7}, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 75
    return-object v7
.end method

.method public createSocket()Ljava/net/Socket;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-virtual {v1}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->createSocket()Ljava/net/Socket;

    move-result-object v0

    .line 60
    .local v0, "socket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 61
    return-object v0
.end method

.method public createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    .locals 2
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "autoClose"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/UnknownHostException;
        }
    .end annotation

    .prologue
    .line 82
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-virtual {v1, p1, p2, p3, p4}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;

    move-result-object v0

    .line 83
    .local v0, "resSocket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 84
    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 113
    instance-of v0, p1, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    check-cast p1, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v1, p1, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 117
    :goto_0
    return v0

    .restart local p1    # "o":Ljava/lang/Object;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/EnhancedApacheSSLSocketFactory;->mInnerSSLSocketFactory:Lorg/apache/http/conn/ssl/SSLSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public isSecure(Ljava/net/Socket;)Z
    .locals 1
    .param p1, "sock"    # Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 106
    const/4 v0, 0x1

    return v0
.end method
