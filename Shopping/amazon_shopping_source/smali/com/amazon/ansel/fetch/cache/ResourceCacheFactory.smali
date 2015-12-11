.class public interface abstract Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;
.super Ljava/lang/Object;
.source "ResourceCacheFactory.java"


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
.method public abstract getCache(Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;)Lcom/amazon/ansel/fetch/cache/ResourceCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener",
            "<TK;TV;>;)",
            "Lcom/amazon/ansel/fetch/cache/ResourceCache",
            "<TK;TV;>;"
        }
    .end annotation
.end method
