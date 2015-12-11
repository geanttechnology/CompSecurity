.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
.super Ljava/lang/Object;
.source "OperatedClientConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpClientConnection;
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpInetConnection;


# virtual methods
.method public abstract getSocket()Ljava/net/Socket;
.end method

.method public abstract getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
.end method

.method public abstract isSecure()Z
.end method

.method public abstract openCompleted(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract opening(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract update(Ljava/net/Socket;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
