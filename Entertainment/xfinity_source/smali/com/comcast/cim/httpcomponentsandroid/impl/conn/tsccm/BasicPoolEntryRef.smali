.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntryRef;
.super Ljava/lang/ref/WeakReference;
.source "BasicPoolEntryRef.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ref/WeakReference",
        "<",
        "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;",
        ">;"
    }
.end annotation


# instance fields
.field private final route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;


# virtual methods
.method public final getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntryRef;->route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    return-object v0
.end method
