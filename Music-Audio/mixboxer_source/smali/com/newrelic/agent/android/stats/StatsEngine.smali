.class public Lcom/newrelic/agent/android/stats/StatsEngine;
.super Ljava/lang/Object;
.source "StatsEngine.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/newrelic/agent/android/stats/StatsEngine$1;,
        Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    }
.end annotation


# static fields
.field public static final INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

.field private static final log:Lcom/newrelic/agent/android/logging/AgentLog;


# instance fields
.field public enabled:Z

.field private statsMap:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/newrelic/agent/android/stats/StatsEngine$Stat;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/newrelic/agent/android/stats/StatsEngine;

    invoke-direct {v0}, Lcom/newrelic/agent/android/stats/StatsEngine;-><init>()V

    sput-object v0, Lcom/newrelic/agent/android/stats/StatsEngine;->INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

    .line 25
    invoke-static {}, Lcom/newrelic/agent/android/logging/AgentLogManager;->getAgentLog()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v0

    sput-object v0, Lcom/newrelic/agent/android/stats/StatsEngine;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine;->enabled:Z

    .line 23
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine;->statsMap:Ljava/util/concurrent/ConcurrentHashMap;

    .line 29
    return-void
.end method

.method public static declared-synchronized disable()V
    .locals 3

    .prologue
    .line 119
    const-class v1, Lcom/newrelic/agent/android/stats/StatsEngine;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/newrelic/agent/android/stats/StatsEngine;->INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

    const/4 v2, 0x0

    iput-boolean v2, v0, Lcom/newrelic/agent/android/stats/StatsEngine;->enabled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    monitor-exit v1

    return-void

    .line 119
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized enable()V
    .locals 3

    .prologue
    .line 126
    const-class v1, Lcom/newrelic/agent/android/stats/StatsEngine;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/newrelic/agent/android/stats/StatsEngine;->INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

    const/4 v2, 0x1

    iput-boolean v2, v0, Lcom/newrelic/agent/android/stats/StatsEngine;->enabled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 127
    monitor-exit v1

    return-void

    .line 126
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static get()Lcom/newrelic/agent/android/stats/StatsEngine;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/newrelic/agent/android/stats/StatsEngine;->INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

    return-object v0
.end method

.method private getStatsMap()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/newrelic/agent/android/stats/StatsEngine$Stat;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    iget-object v0, p0, Lcom/newrelic/agent/android/stats/StatsEngine;->statsMap:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method private lazyGet(Ljava/lang/String;)Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 134
    iget-object v1, p0, Lcom/newrelic/agent/android/stats/StatsEngine;->statsMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;

    .line 136
    .local v0, "s":Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    if-nez v0, :cond_0

    .line 137
    new-instance v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;

    .end local v0    # "s":Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;-><init>(Lcom/newrelic/agent/android/stats/StatsEngine;Lcom/newrelic/agent/android/stats/StatsEngine$1;)V

    .line 139
    .restart local v0    # "s":Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    iget-boolean v1, p0, Lcom/newrelic/agent/android/stats/StatsEngine;->enabled:Z

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 140
    iget-object v1, p0, Lcom/newrelic/agent/android/stats/StatsEngine;->statsMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    :cond_0
    return-object v0
.end method

.method public static populateMetrics(Lorg/json/JSONObject;)V
    .locals 6
    .param p0, "metrics"    # Lorg/json/JSONObject;

    .prologue
    .line 96
    sget-object v3, Lcom/newrelic/agent/android/stats/StatsEngine;->INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

    invoke-direct {v3}, Lcom/newrelic/agent/android/stats/StatsEngine;->getStatsMap()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/concurrent/ConcurrentHashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 98
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/newrelic/agent/android/stats/StatsEngine$Stat;>;"
    :try_start_0
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;

    invoke-virtual {v4}, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 100
    :catch_0
    move-exception v0

    .line 101
    .local v0, "e":Lorg/json/JSONException;
    sget-object v4, Lcom/newrelic/agent/android/stats/StatsEngine;->log:Lcom/newrelic/agent/android/logging/AgentLog;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to build metric for "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, ":"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v4, v3}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    goto :goto_0

    .line 104
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/newrelic/agent/android/stats/StatsEngine$Stat;>;"
    :cond_0
    return-void
.end method

.method public static reset()V
    .locals 1

    .prologue
    .line 111
    sget-object v0, Lcom/newrelic/agent/android/stats/StatsEngine;->INSTANCE:Lcom/newrelic/agent/android/stats/StatsEngine;

    invoke-direct {v0}, Lcom/newrelic/agent/android/stats/StatsEngine;->getStatsMap()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/ConcurrentHashMap;->clear()V

    .line 112
    return-void
.end method


# virtual methods
.method public inc(Ljava/lang/String;)V
    .locals 5
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/stats/StatsEngine;->lazyGet(Ljava/lang/String;)Lcom/newrelic/agent/android/stats/StatsEngine$Stat;

    move-result-object v0

    .line 43
    .local v0, "s":Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    monitor-enter v0

    .line 44
    :try_start_0
    iget-wide v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    .line 45
    monitor-exit v0

    .line 46
    return-void

    .line 45
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public inc(Ljava/lang/String;J)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "count"    # J

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/stats/StatsEngine;->lazyGet(Ljava/lang/String;)Lcom/newrelic/agent/android/stats/StatsEngine$Stat;

    move-result-object v0

    .line 57
    .local v0, "s":Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    monitor-enter v0

    .line 58
    :try_start_0
    iget-wide v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    add-long/2addr v1, p2

    iput-wide v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    .line 59
    monitor-exit v0

    .line 60
    return-void

    .line 59
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public recordTime(Ljava/lang/String;F)V
    .locals 5
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "time"    # F

    .prologue
    .line 69
    invoke-direct {p0, p1}, Lcom/newrelic/agent/android/stats/StatsEngine;->lazyGet(Ljava/lang/String;)Lcom/newrelic/agent/android/stats/StatsEngine$Stat;

    move-result-object v0

    .line 71
    .local v0, "s":Lcom/newrelic/agent/android/stats/StatsEngine$Stat;
    monitor-enter v0

    .line 72
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->haveTime:Z

    .line 73
    iget-wide v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->callCount:J

    .line 74
    iget v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->totalTime:F

    add-float/2addr v1, p2

    iput v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->totalTime:F

    .line 75
    iget v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->minTime:F

    invoke-static {p2, v1}, Ljava/lang/Math;->min(FF)F

    move-result v1

    iput v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->minTime:F

    .line 76
    iget v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->maxTime:F

    invoke-static {p2, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    iput v1, v0, Lcom/newrelic/agent/android/stats/StatsEngine$Stat;->maxTime:F

    .line 77
    monitor-exit v0

    .line 78
    return-void

    .line 77
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public recordTimeMs(Ljava/lang/String;J)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "time"    # J

    .prologue
    .line 87
    long-to-float v0, p2

    const/high16 v1, 0x447a0000    # 1000.0f

    div-float/2addr v0, v1

    invoke-virtual {p0, p1, v0}, Lcom/newrelic/agent/android/stats/StatsEngine;->recordTime(Ljava/lang/String;F)V

    .line 88
    return-void
.end method
