.class public interface abstract Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;
.super Ljava/lang/Object;
.source "CacheableRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;"
    }
.end annotation


# virtual methods
.method public abstract getCacheKey()Ljava/lang/String;
.end method
