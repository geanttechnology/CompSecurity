.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
.super Ljava/lang/Object;
.source "ClientConnectionRequest.java"


# virtual methods
.method public abstract getConnection(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;
        }
    .end annotation
.end method
