.class public Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;
.super Ljava/lang/Object;
.source "ResourceCacheValue.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Value:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final byteCount:I

.field private final expireTime:J

.field private final value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TValue;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;IJ)V
    .locals 0
    .param p2, "byteCount"    # I
    .param p3, "expireTime"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TValue;IJ)V"
        }
    .end annotation

    .prologue
    .line 8
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TValue;>;"
    .local p1, "value":Ljava/lang/Object;, "TValue;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object p1, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->value:Ljava/lang/Object;

    .line 10
    iput p2, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->byteCount:I

    .line 11
    iput-wide p3, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->expireTime:J

    .line 12
    return-void
.end method


# virtual methods
.method public getByteCount()I
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TValue;>;"
    iget v0, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->byteCount:I

    return v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TValue;"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TValue;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->value:Ljava/lang/Object;

    return-object v0
.end method

.method public isExpired()Z
    .locals 4

    .prologue
    .line 19
    .local p0, "this":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TValue;>;"
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->expireTime:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    iget-wide v0, p0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->expireTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
