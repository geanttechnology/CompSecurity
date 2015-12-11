.class Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;
.super Ljava/lang/Object;
.source "SocketFactoryAdaptor.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactory;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V
    .locals 0
    .param p1, "factory"    # Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    .line 48
    return-void
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

    .prologue
    .line 60
    const/4 v0, 0x0

    .line 61
    .local v0, "local":Ljava/net/InetSocketAddress;
    if-nez p4, :cond_0

    if-lez p5, :cond_2

    .line 63
    :cond_0
    if-gez p5, :cond_1

    .line 64
    const/4 p5, 0x0

    .line 66
    :cond_1
    new-instance v0, Ljava/net/InetSocketAddress;

    .end local v0    # "local":Ljava/net/InetSocketAddress;
    invoke-direct {v0, p4, p5}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 68
    .restart local v0    # "local":Ljava/net/InetSocketAddress;
    :cond_2
    invoke-static {p2}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v2

    .line 69
    .local v2, "remoteAddress":Ljava/net/InetAddress;
    new-instance v1, Ljava/net/InetSocketAddress;

    invoke-direct {v1, v2, p3}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 70
    .local v1, "remote":Ljava/net/InetSocketAddress;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-interface {v3, p1, v1, v0, p6}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;->connectSocket(Ljava/net/Socket;Ljava/net/InetSocketAddress;Ljava/net/InetSocketAddress;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;

    move-result-object v3

    return-object v3
.end method

.method public createSocket()Ljava/net/Socket;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 51
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;-><init>()V

    .line 52
    .local v0, "params":Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-interface {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;->createSocket(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;

    move-result-object v1

    return-object v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 83
    if-nez p1, :cond_0

    const/4 v0, 0x0

    .line 88
    .end local p1    # "obj":Ljava/lang/Object;
    :goto_0
    return v0

    .line 84
    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_0
    if-ne p0, p1, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    .line 85
    :cond_1
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;

    if-eqz v0, :cond_2

    .line 86
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;

    .end local p1    # "obj":Ljava/lang/Object;
    iget-object v1, p1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0

    .line 88
    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_2
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public isSecure(Ljava/net/Socket;)Z
    .locals 1
    .param p1, "socket"    # Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SocketFactoryAdaptor;->factory:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;

    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;->isSecure(Ljava/net/Socket;)Z

    move-result v0

    return v0
.end method
