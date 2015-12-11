.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
.source "SingleClientConnManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "PoolEntry"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;)V
    .locals 2

    .prologue
    .line 395
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;

    .line 396
    iget-object v0, p1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V

    .line 397
    return-void
.end method


# virtual methods
.method protected close()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 403
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->shutdownEntry()V

    .line 404
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isOpen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 405
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->close()V

    .line 406
    :cond_0
    return-void
.end method

.method protected shutdown()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 412
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->shutdownEntry()V

    .line 413
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isOpen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 414
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->shutdown()V

    .line 415
    :cond_0
    return-void
.end method
