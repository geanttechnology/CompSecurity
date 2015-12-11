.class Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;
.super Ljavax/net/ssl/SSLSocketFactory;
.source "StrongCipherSSLSocketFactory.java"


# static fields
.field static final synthetic $assertionsDisabled:Z

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->$assertionsDisabled:Z

    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->TAG:Ljava/lang/String;

    return-void

    .line 19
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method constructor <init>(Ljavax/net/ssl/SSLSocketFactory;)V
    .locals 0
    .param p1, "sslSocketFactory"    # Ljavax/net/ssl/SSLSocketFactory;

    .prologue
    .line 26
    invoke-direct {p0}, Ljavax/net/ssl/SSLSocketFactory;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    .line 28
    return-void
.end method

.method private enforceStrongCipher(Ljava/net/Socket;)V
    .locals 3
    .param p1, "socket"    # Ljava/net/Socket;

    .prologue
    .line 97
    sget-boolean v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->$assertionsDisabled:Z

    if-nez v0, :cond_0

    instance-of v0, p1, Ljavax/net/ssl/SSLSocket;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_0
    move-object v0, p1

    .line 99
    check-cast v0, Ljavax/net/ssl/SSLSocket;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/security/AmazonApprovedCiphers;->enableAllowed(Ljavax/net/ssl/SSLSocket;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 101
    sget-object v0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->TAG:Ljava/lang/String;

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

    .line 104
    new-instance v0, Ljava/lang/SecurityException;

    const-string/jumbo v1, "Unable to enforce strong cipher over https."

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 106
    .restart local p1    # "socket":Ljava/net/Socket;
    :cond_1
    return-void
.end method


# virtual methods
.method public createSocket(Ljava/lang/String;I)Ljava/net/Socket;
    .locals 2
    .param p1, "host"    # Ljava/lang/String;
    .param p2, "port"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/UnknownHostException;
        }
    .end annotation

    .prologue
    .line 55
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v1, p1, p2}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/lang/String;I)Ljava/net/Socket;

    move-result-object v0

    .line 57
    .local v0, "socket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 58
    return-object v0
.end method

.method public createSocket(Ljava/lang/String;ILjava/net/InetAddress;I)Ljava/net/Socket;
    .locals 2
    .param p1, "host"    # Ljava/lang/String;
    .param p2, "port"    # I
    .param p3, "localHost"    # Ljava/net/InetAddress;
    .param p4, "localPort"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/UnknownHostException;
        }
    .end annotation

    .prologue
    .line 74
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v1, p1, p2, p3, p4}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/lang/String;ILjava/net/InetAddress;I)Ljava/net/Socket;

    move-result-object v0

    .line 76
    .local v0, "socket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 77
    return-object v0
.end method

.method public createSocket(Ljava/net/InetAddress;I)Ljava/net/Socket;
    .locals 2
    .param p1, "host"    # Ljava/net/InetAddress;
    .param p2, "port"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 64
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v1, p1, p2}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/net/InetAddress;I)Ljava/net/Socket;

    move-result-object v0

    .line 66
    .local v0, "socket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 67
    return-object v0
.end method

.method public createSocket(Ljava/net/InetAddress;ILjava/net/InetAddress;I)Ljava/net/Socket;
    .locals 2
    .param p1, "address"    # Ljava/net/InetAddress;
    .param p2, "port"    # I
    .param p3, "localAddress"    # Ljava/net/InetAddress;
    .param p4, "localPort"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 86
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v1, p1, p2, p3, p4}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/net/InetAddress;ILjava/net/InetAddress;I)Ljava/net/Socket;

    move-result-object v0

    .line 88
    .local v0, "socket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 89
    return-object v0
.end method

.method public createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    .locals 2
    .param p1, "s"    # Ljava/net/Socket;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "autoClose"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 34
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v1, p1, p2, p3, p4}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;

    move-result-object v0

    .line 36
    .local v0, "socket":Ljava/net/Socket;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->enforceStrongCipher(Ljava/net/Socket;)V

    .line 37
    return-object v0
.end method

.method public getDefaultCipherSuites()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocketFactory;->getDefaultCipherSuites()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSupportedCipherSuites()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/security/StrongCipherSSLSocketFactory;->mInnerSSocketFactory:Ljavax/net/ssl/SSLSocketFactory;

    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocketFactory;->getSupportedCipherSuites()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
