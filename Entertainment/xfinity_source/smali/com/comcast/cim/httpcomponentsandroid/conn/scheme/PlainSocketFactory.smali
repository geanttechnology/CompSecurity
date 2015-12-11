.class public Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;
.super Ljava/lang/Object;
.source "PlainSocketFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactory;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final nameResolver:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/HostNameResolver;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->nameResolver:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/HostNameResolver;

    .line 79
    return-void
.end method

.method public static getSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;-><init>()V

    return-object v0
.end method


# virtual methods
.method public connectSocket(Ljava/net/Socket;Ljava/lang/String;ILjava/net/InetAddress;ILcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;
    .locals 4
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "host"    # Ljava/lang/String;
    .param p3, "port"    # I
    .param p4, "localAddress"    # Ljava/net/InetAddress;
    .param p5, "localPort"    # I
    .param p6, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/UnknownHostException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 164
    const/4 v0, 0x0

    .line 165
    .local v0, "local":Ljava/net/InetSocketAddress;
    if-nez p4, :cond_0

    if-lez p5, :cond_2

    .line 167
    :cond_0
    if-gez p5, :cond_1

    .line 168
    const/4 p5, 0x0

    .line 170
    :cond_1
    new-instance v0, Ljava/net/InetSocketAddress;

    .end local v0    # "local":Ljava/net/InetSocketAddress;
    invoke-direct {v0, p4, p5}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 173
    .restart local v0    # "local":Ljava/net/InetSocketAddress;
    :cond_2
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->nameResolver:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/HostNameResolver;

    if-eqz v3, :cond_3

    .line 174
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->nameResolver:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/HostNameResolver;

    invoke-interface {v3, p2}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/HostNameResolver;->resolve(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v2

    .line 178
    .local v2, "remoteAddress":Ljava/net/InetAddress;
    :goto_0
    new-instance v1, Ljava/net/InetSocketAddress;

    invoke-direct {v1, v2, p3}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 179
    .local v1, "remote":Ljava/net/InetSocketAddress;
    invoke-virtual {p0, p1, v1, v0, p6}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->connectSocket(Ljava/net/Socket;Ljava/net/InetSocketAddress;Ljava/net/InetSocketAddress;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;

    move-result-object v3

    return-object v3

    .line 176
    .end local v1    # "remote":Ljava/net/InetSocketAddress;
    .end local v2    # "remoteAddress":Ljava/net/InetAddress;
    :cond_3
    invoke-static {p2}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v2

    .restart local v2    # "remoteAddress":Ljava/net/InetAddress;
    goto :goto_0
.end method

.method public connectSocket(Ljava/net/Socket;Ljava/net/InetSocketAddress;Ljava/net/InetSocketAddress;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;
    .locals 7
    .param p1, "socket"    # Ljava/net/Socket;
    .param p2, "remoteAddress"    # Ljava/net/InetSocketAddress;
    .param p3, "localAddress"    # Ljava/net/InetSocketAddress;
    .param p4, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;
        }
    .end annotation

    .prologue
    .line 104
    if-nez p2, :cond_0

    .line 105
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Remote address may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 107
    :cond_0
    if-nez p4, :cond_1

    .line 108
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "HTTP parameters may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 110
    :cond_1
    move-object v3, p1

    .line 111
    .local v3, "sock":Ljava/net/Socket;
    if-nez v3, :cond_2

    .line 112
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->createSocket()Ljava/net/Socket;

    move-result-object v3

    .line 114
    :cond_2
    if-eqz p3, :cond_3

    .line 115
    invoke-static {p4}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getSoReuseaddr(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z

    move-result v4

    invoke-virtual {v3, v4}, Ljava/net/Socket;->setReuseAddress(Z)V

    .line 116
    invoke-virtual {v3, p3}, Ljava/net/Socket;->bind(Ljava/net/SocketAddress;)V

    .line 118
    :cond_3
    invoke-static {p4}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getConnectionTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)I

    move-result v0

    .line 119
    .local v0, "connTimeout":I
    invoke-static {p4}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->getSoTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)I

    move-result v2

    .line 122
    .local v2, "soTimeout":I
    :try_start_0
    invoke-virtual {v3, v2}, Ljava/net/Socket;->setSoTimeout(I)V

    .line 123
    invoke-virtual {v3, p2, v0}, Ljava/net/Socket;->connect(Ljava/net/SocketAddress;I)V
    :try_end_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_0

    .line 127
    return-object v3

    .line 124
    :catch_0
    move-exception v1

    .line 125
    .local v1, "ex":Ljava/net/SocketTimeoutException;
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Connect to "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " timed out"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public createSocket()Ljava/net/Socket;
    .locals 1

    .prologue
    .line 93
    new-instance v0, Ljava/net/Socket;

    invoke-direct {v0}, Ljava/net/Socket;-><init>()V

    return-object v0
.end method

.method public createSocket(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;
    .locals 1
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 89
    new-instance v0, Ljava/net/Socket;

    invoke-direct {v0}, Ljava/net/Socket;-><init>()V

    return-object v0
.end method

.method public final isSecure(Ljava/net/Socket;)Z
    .locals 2
    .param p1, "sock"    # Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 144
    if-nez p1, :cond_0

    .line 145
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Socket may not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 149
    :cond_0
    invoke-virtual {p1}, Ljava/net/Socket;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 150
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Socket is closed."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 152
    :cond_1
    const/4 v0, 0x0

    return v0
.end method
