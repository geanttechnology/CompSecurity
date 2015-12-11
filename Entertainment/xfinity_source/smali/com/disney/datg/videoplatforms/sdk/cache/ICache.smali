.class public interface abstract Lcom/disney/datg/videoplatforms/sdk/cache/ICache;
.super Ljava/lang/Object;
.source "ICache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract get(Ljava/lang/Object;)Lcom/disney/datg/videoplatforms/sdk/cache/Data;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)",
            "Lcom/disney/datg/videoplatforms/sdk/cache/Data",
            "<TK;TV;>;"
        }
    .end annotation
.end method

.method public abstract put(Ljava/lang/Object;Ljava/lang/Object;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;I)V"
        }
    .end annotation
.end method
