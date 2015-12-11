.class public Lcom/newrelic/agent/android/harvest/ActivitySighting;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableArray;
.source "ActivitySighting.java"


# instance fields
.field private durationMs:J

.field private name:Ljava/lang/String;

.field private final timestampMs:J


# direct methods
.method public constructor <init>(JLjava/lang/String;)V
    .locals 3
    .param p1, "timestampMs"    # J
    .param p3, "name"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableArray;-><init>()V

    .line 15
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->durationMs:J

    .line 20
    iput-wide p1, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->timestampMs:J

    .line 21
    iput-object p3, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->name:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public static newFromJson(Lcom/newrelic/com/google/gson/JsonArray;)Lcom/newrelic/agent/android/harvest/ActivitySighting;
    .locals 4
    .param p0, "jsonArray"    # Lcom/newrelic/com/google/gson/JsonArray;

    .prologue
    .line 71
    new-instance v0, Lcom/newrelic/agent/android/harvest/ActivitySighting;

    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->get(I)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsLong()J

    move-result-wide v2

    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->get(I)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v2, v3, v1}, Lcom/newrelic/agent/android/harvest/ActivitySighting;-><init>(JLjava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public asJsonArray()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 4

    .prologue
    .line 51
    new-instance v0, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 52
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonArray;
    monitor-enter p0

    .line 53
    :try_start_0
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->name:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 54
    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->timestampMs:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 55
    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->durationMs:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 56
    monitor-exit p0

    .line 57
    return-object v0

    .line 56
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public asJsonArrayWithoutDuration()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 4

    .prologue
    .line 62
    new-instance v0, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 63
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonArray;
    monitor-enter p0

    .line 64
    :try_start_0
    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->timestampMs:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 65
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->name:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 66
    monitor-exit p0

    .line 67
    return-object v0

    .line 66
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public end(J)V
    .locals 3
    .param p1, "endTimestampMs"    # J

    .prologue
    .line 43
    monitor-enter p0

    .line 44
    :try_start_0
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->timestampMs:J

    sub-long v0, p1, v0

    iput-wide v0, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->durationMs:J

    .line 45
    monitor-exit p0

    .line 46
    return-void

    .line 45
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 39
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->durationMs:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getTimestampMs()J
    .locals 2

    .prologue
    .line 35
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->timestampMs:J

    return-wide v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 29
    monitor-enter p0

    .line 30
    :try_start_0
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/ActivitySighting;->name:Ljava/lang/String;

    .line 31
    monitor-exit p0

    .line 32
    return-void

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
