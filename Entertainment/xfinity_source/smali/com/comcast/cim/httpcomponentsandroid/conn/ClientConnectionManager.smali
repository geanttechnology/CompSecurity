.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
.super Ljava/lang/Object;
.source "ClientConnectionManager.java"


# virtual methods
.method public abstract getSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
.end method

.method public abstract releaseConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;JLjava/util/concurrent/TimeUnit;)V
.end method

.method public abstract requestConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
.end method
