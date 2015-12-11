.class public abstract Lcom/amazon/device/analytics/events/UniqueIdResolverChain;
.super Ljava/lang/Object;
.source "UniqueIdResolverChain.java"

# interfaces
.implements Lcom/amazon/device/analytics/events/UniqueIdResolver;
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final lock:Ljava/util/concurrent/locks/ReentrantLock;

.field private final nextResolver:Lcom/amazon/device/analytics/events/UniqueIdResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;-><init>(Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/events/UniqueIdResolver;)V
    .locals 2
    .param p1, "resolver"    # Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/locks/ReentrantLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 28
    iput-object p1, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->nextResolver:Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .line 29
    return-void
.end method


# virtual methods
.method protected next()Lcom/amazon/device/analytics/events/UniqueIdResolver;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->nextResolver:Lcom/amazon/device/analytics/events/UniqueIdResolver;

    return-object v0
.end method

.method public resolveUniqueId()Ljava/lang/String;
    .locals 6

    .prologue
    .line 40
    const/4 v1, 0x0

    .line 41
    .local v1, "uniqueId":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 43
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->tryResolve()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 45
    iget-object v2, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 47
    invoke-static {v1}, Lcom/amazon/device/analytics/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 48
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->next()Lcom/amazon/device/analytics/events/UniqueIdResolver;

    move-result-object v0

    .line 49
    .local v0, "next":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    if-eqz v0, :cond_0

    .line 50
    invoke-interface {v0}, Lcom/amazon/device/analytics/events/UniqueIdResolver;->resolveUniqueId()Ljava/lang/String;

    move-result-object v1

    .line 51
    iget-object v2, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 53
    :try_start_1
    invoke-virtual {p0, v1}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->tryStore(Ljava/lang/String;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 55
    iget-object v2, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 62
    .end local v0    # "next":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    :cond_0
    :goto_0
    return-object v1

    .line 45
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v2

    .line 55
    .restart local v0    # "next":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    :catchall_1
    move-exception v2

    iget-object v3, p0, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->lock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v2

    .line 60
    .end local v0    # "next":Lcom/amazon/device/analytics/events/UniqueIdResolver;
    :cond_1
    sget-object v2, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "Resolved uniqueId: %s from UniqueIdResolver: %s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v5, 0x1

    aput-object p0, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 95
    new-instance v0, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    .line 96
    .local v0, "builder":Lcom/amazon/device/analytics/util/JSONBuilder;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->tryResolve()Ljava/lang/String;

    move-result-object v1

    .line 97
    .local v1, "uniqueId":Ljava/lang/String;
    const-string/jumbo v2, "uniqueId"

    if-nez v1, :cond_0

    const-string/jumbo v1, ""

    .end local v1    # "uniqueId":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0, v2, v1}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v2

    const-string/jumbo v3, "nextResolver"

    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->next()Lcom/amazon/device/analytics/events/UniqueIdResolver;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 100
    invoke-virtual {v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v2

    return-object v2
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 84
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 86
    .local v1, "json":Lorg/json/JSONObject;
    const/4 v2, 0x4

    :try_start_0
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 88
    :goto_0
    return-object v2

    .line 87
    :catch_0
    move-exception v0

    .line 88
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method protected abstract tryResolve()Ljava/lang/String;
.end method

.method protected abstract tryStore(Ljava/lang/String;)Z
.end method
