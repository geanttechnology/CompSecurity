.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;
.super Ljava/lang/Object;
.source "SchemeSocketFactory.java"


# virtual methods
.method public abstract connectSocket(Ljava/net/Socket;Ljava/net/InetSocketAddress;Ljava/net/InetSocketAddress;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/net/UnknownHostException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectTimeoutException;
        }
    .end annotation
.end method

.method public abstract createSocket(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract isSecure(Ljava/net/Socket;)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation
.end method
