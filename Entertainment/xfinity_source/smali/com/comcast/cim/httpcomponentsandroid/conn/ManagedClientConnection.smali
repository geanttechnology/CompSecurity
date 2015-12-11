.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
.super Ljava/lang/Object;
.source "ManagedClientConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpClientConnection;
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionReleaseTrigger;
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;


# virtual methods
.method public abstract getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
.end method

.method public abstract getSSLSession()Ljavax/net/ssl/SSLSession;
.end method

.method public abstract getState()Ljava/lang/Object;
.end method

.method public abstract isMarkedReusable()Z
.end method

.method public abstract isSecure()Z
.end method

.method public abstract layerProtocol(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract markReusable()V
.end method

.method public abstract open(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract setIdleDuration(JLjava/util/concurrent/TimeUnit;)V
.end method

.method public abstract setState(Ljava/lang/Object;)V
.end method

.method public abstract tunnelProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract tunnelTarget(ZLcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
