.class public Lcom/auditude/ads/util/http/ConnectionManager;
.super Ljava/lang/Object;
.source "ConnectionManager.java"


# static fields
.field private static instance:Lcom/auditude/ads/util/http/ConnectionManager;


# instance fields
.field private active:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field private httpContextList:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lorg/apache/http/protocol/HttpContext;",
            ">;"
        }
    .end annotation
.end field

.field private queue:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/util/http/ConnectionManager;->active:Ljava/util/ArrayList;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/util/http/ConnectionManager;->queue:Ljava/util/ArrayList;

    .line 25
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/util/http/ConnectionManager;->httpContextList:Ljava/util/HashMap;

    .line 19
    return-void
.end method

.method public static getInstance()Lcom/auditude/ads/util/http/ConnectionManager;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/auditude/ads/util/http/ConnectionManager;->instance:Lcom/auditude/ads/util/http/ConnectionManager;

    if-nez v0, :cond_0

    .line 33
    new-instance v0, Lcom/auditude/ads/util/http/ConnectionManager;

    invoke-direct {v0}, Lcom/auditude/ads/util/http/ConnectionManager;-><init>()V

    sput-object v0, Lcom/auditude/ads/util/http/ConnectionManager;->instance:Lcom/auditude/ads/util/http/ConnectionManager;

    .line 36
    :cond_0
    sget-object v0, Lcom/auditude/ads/util/http/ConnectionManager;->instance:Lcom/auditude/ads/util/http/ConnectionManager;

    return-object v0
.end method

.method private declared-synchronized startNext()V
    .locals 4

    .prologue
    .line 69
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/auditude/ads/util/http/ConnectionManager;->queue:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 71
    iget-object v2, p0, Lcom/auditude/ads/util/http/ConnectionManager;->queue:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    .line 72
    .local v0, "next":Ljava/lang/Runnable;
    iget-object v2, p0, Lcom/auditude/ads/util/http/ConnectionManager;->queue:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 73
    iget-object v2, p0, Lcom/auditude/ads/util/http/ConnectionManager;->active:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 75
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 76
    .local v1, "thread":Ljava/lang/Thread;
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 78
    .end local v0    # "next":Ljava/lang/Runnable;
    .end local v1    # "thread":Ljava/lang/Thread;
    :cond_0
    monitor-exit p0

    return-void

    .line 69
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method


# virtual methods
.method public didComplete(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/auditude/ads/util/http/ConnectionManager;->active:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 83
    invoke-direct {p0}, Lcom/auditude/ads/util/http/ConnectionManager;->startNext()V

    .line 84
    return-void
.end method

.method public getLocalContext(Ljava/lang/String;)Lorg/apache/http/protocol/HttpContext;
    .locals 5
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v3, p0, Lcom/auditude/ads/util/http/ConnectionManager;->httpContextList:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 44
    new-instance v2, Lorg/apache/http/protocol/BasicHttpContext;

    invoke-direct {v2}, Lorg/apache/http/protocol/BasicHttpContext;-><init>()V

    .line 45
    .local v2, "httpContext":Lorg/apache/http/protocol/HttpContext;
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v3

    invoke-virtual {v3}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v3

    const-string v4, "applicationContext"

    invoke-virtual {v3, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 46
    .local v0, "appContext":Landroid/content/Context;
    if-eqz v0, :cond_1

    .line 48
    const-string v3, "http.cookie-store"

    new-instance v4, Lcom/auditude/ads/util/http/PersistentCookieStore;

    invoke-direct {v4, v0}, Lcom/auditude/ads/util/http/PersistentCookieStore;-><init>(Landroid/content/Context;)V

    invoke-interface {v2, v3, v4}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 54
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/util/http/ConnectionManager;->httpContextList:Ljava/util/HashMap;

    invoke-virtual {v3, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    .end local v0    # "appContext":Landroid/content/Context;
    .end local v2    # "httpContext":Lorg/apache/http/protocol/HttpContext;
    :cond_0
    iget-object v3, p0, Lcom/auditude/ads/util/http/ConnectionManager;->httpContextList:Ljava/util/HashMap;

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/http/protocol/HttpContext;

    .line 57
    .local v1, "domainContext":Lorg/apache/http/protocol/HttpContext;
    const-string v3, "http.cookie-store"

    invoke-interface {v1, v3}, Lorg/apache/http/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/apache/http/client/CookieStore;

    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-interface {v3, v4}, Lorg/apache/http/client/CookieStore;->clearExpired(Ljava/util/Date;)Z

    .line 58
    return-object v1

    .line 52
    .end local v1    # "domainContext":Lorg/apache/http/protocol/HttpContext;
    .restart local v0    # "appContext":Landroid/content/Context;
    .restart local v2    # "httpContext":Lorg/apache/http/protocol/HttpContext;
    :cond_1
    const-string v3, "http.cookie-store"

    new-instance v4, Lorg/apache/http/impl/client/BasicCookieStore;

    invoke-direct {v4}, Lorg/apache/http/impl/client/BasicCookieStore;-><init>()V

    invoke-interface {v2, v3, v4}, Lorg/apache/http/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public push(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/auditude/ads/util/http/ConnectionManager;->queue:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 64
    iget-object v0, p0, Lcom/auditude/ads/util/http/ConnectionManager;->active:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0xa

    if-ge v0, v1, :cond_0

    invoke-direct {p0}, Lcom/auditude/ads/util/http/ConnectionManager;->startNext()V

    .line 65
    :cond_0
    return-void
.end method
