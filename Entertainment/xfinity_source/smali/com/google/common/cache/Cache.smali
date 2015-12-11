.class public interface abstract Lcom/google/common/cache/Cache;
.super Ljava/lang/Object;
.source "Cache.java"

# interfaces
.implements Lcom/google/common/base/Function;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/common/base/Function",
        "<TK;TV;>;"
    }
.end annotation


# virtual methods
.method public abstract apply(Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract asMap()Ljava/util/concurrent/ConcurrentMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/ConcurrentMap",
            "<TK;TV;>;"
        }
    .end annotation
.end method

.method public abstract getUnchecked(Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method
