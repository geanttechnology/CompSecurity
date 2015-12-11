.class public abstract Lcom/disney/datg/videoplatforms/sdk/cache/Cache;
.super Ljava/lang/Object;
.source "Cache.java"

# interfaces
.implements Lcom/disney/datg/videoplatforms/sdk/cache/ICache;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/disney/datg/videoplatforms/sdk/cache/ICache",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field protected cacheName:Ljava/lang/String;

.field protected capacity:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Cache;, "Lcom/disney/datg/videoplatforms/sdk/cache/Cache<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/4 v0, -0x1

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->capacity:I

    return-void
.end method


# virtual methods
.method public abstract isEmpty()Z
.end method

.method public setCacheName(Ljava/lang/String;)V
    .locals 0
    .param p1, "cacheName"    # Ljava/lang/String;

    .prologue
    .line 32
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Cache;, "Lcom/disney/datg/videoplatforms/sdk/cache/Cache<TK;TV;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->cacheName:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setCapacity(I)V
    .locals 0
    .param p1, "capacity"    # I

    .prologue
    .line 24
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/cache/Cache;, "Lcom/disney/datg/videoplatforms/sdk/cache/Cache<TK;TV;>;"
    iput p1, p0, Lcom/disney/datg/videoplatforms/sdk/cache/Cache;->capacity:I

    .line 25
    return-void
.end method
