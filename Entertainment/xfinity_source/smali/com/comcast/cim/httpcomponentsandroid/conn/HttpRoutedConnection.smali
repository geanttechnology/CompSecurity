.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/HttpRoutedConnection;
.super Ljava/lang/Object;
.source "HttpRoutedConnection.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpInetConnection;


# virtual methods
.method public abstract getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
.end method

.method public abstract getSSLSession()Ljavax/net/ssl/SSLSession;
.end method

.method public abstract isSecure()Z
.end method
