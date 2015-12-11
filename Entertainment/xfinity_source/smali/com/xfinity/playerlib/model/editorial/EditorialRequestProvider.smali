.class public Lcom/xfinity/playerlib/model/editorial/EditorialRequestProvider;
.super Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;
.source "EditorialRequestProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider",
        "<TT;>;",
        "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final cacheKey:Ljava/lang/String;


# virtual methods
.method public getCacheKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialRequestProvider;, "Lcom/xfinity/playerlib/model/editorial/EditorialRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialRequestProvider;->cacheKey:Ljava/lang/String;

    return-object v0
.end method
