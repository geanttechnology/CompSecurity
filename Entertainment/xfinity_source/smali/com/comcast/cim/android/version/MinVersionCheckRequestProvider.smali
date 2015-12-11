.class public Lcom/comcast/cim/android/version/MinVersionCheckRequestProvider;
.super Lcom/comcast/cim/cmasl/http/request/RevalidatingRequestProvider;
.source "MinVersionCheckRequestProvider.java"

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
    .line 19
    .local p0, "this":Lcom/comcast/cim/android/version/MinVersionCheckRequestProvider;, "Lcom/comcast/cim/android/version/MinVersionCheckRequestProvider<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/version/MinVersionCheckRequestProvider;->cacheKey:Ljava/lang/String;

    return-object v0
.end method
