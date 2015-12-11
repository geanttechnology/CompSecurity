.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;
.super Ljava/lang/Object;
.source "PoolEntryRequest.java"


# virtual methods
.method public abstract getPoolEntry(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;
        }
    .end annotation
.end method
