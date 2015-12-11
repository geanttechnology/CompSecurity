.class public Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference;
.super Ljava/lang/ref/WeakReference;
.source "WeakObjectReference.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/ref/WeakReference",
        "<TT;>;",
        "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 7
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference<TT;>;"
    .local p1, "reference":Ljava/lang/Object;, "TT;"
    invoke-direct {p0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 8
    return-void
.end method
