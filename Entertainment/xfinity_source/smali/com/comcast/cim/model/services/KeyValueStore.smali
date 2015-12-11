.class public interface abstract Lcom/comcast/cim/model/services/KeyValueStore;
.super Ljava/lang/Object;
.source "KeyValueStore.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<PK:",
        "Ljava/lang/Object;",
        "ValueT:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract get(Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TPK;)TValueT;"
        }
    .end annotation
.end method

.method public abstract put(Ljava/lang/Object;Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TPK;TValueT;)V"
        }
    .end annotation
.end method
