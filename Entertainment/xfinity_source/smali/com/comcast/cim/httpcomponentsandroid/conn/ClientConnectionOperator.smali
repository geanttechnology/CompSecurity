.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;
.super Ljava/lang/Object;
.source "ClientConnectionOperator.java"


# virtual methods
.method public abstract createConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
.end method

.method public abstract openConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/net/InetAddress;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract updateSecureConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
