.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPooledConnAdapter;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;
.source "BasicPooledConnAdapter.java"


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V
    .locals 0
    .param p1, "tsccm"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ThreadSafeClientConnManager;
    .param p2, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;)V

    .line 51
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPooledConnAdapter;->markReusable()V

    .line 52
    return-void
.end method


# virtual methods
.method protected detach()V
    .locals 0

    .prologue
    .line 69
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->detach()V

    .line 70
    return-void
.end method

.method protected getManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 57
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method protected getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;
    .locals 1

    .prologue
    .line 63
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPooledConnAdapter;->getPoolEntry()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    move-result-object v0

    return-object v0
.end method
