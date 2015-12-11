.class public Lcom/newrelic/agent/android/harvest/crash/Crash;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableObject;
.source "Crash.java"


# static fields
.field public static final PROTOCOL_VERSION:I = 0x1


# instance fields
.field private activityHistory:Lcom/newrelic/agent/android/harvest/ActivityHistory;

.field private final analyticsEnabled:Z

.field private final appToken:Ljava/lang/String;

.field private applicationInfo:Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

.field private final buildId:Ljava/lang/String;

.field private deviceInfo:Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

.field private events:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/newrelic/agent/android/analytics/AnalyticsEvent;",
            ">;"
        }
    .end annotation
.end field

.field private exceptionInfo:Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

.field private sessionAttributes:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/newrelic/agent/android/analytics/AnalyticAttribute;",
            ">;"
        }
    .end annotation
.end field

.field private threads:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final timestamp:J

.field private final uuid:Ljava/util/UUID;


# direct methods
.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 68
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    const/4 v2, 0x0

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/newrelic/agent/android/harvest/crash/Crash;-><init>(Ljava/lang/Throwable;Ljava/util/Set;Ljava/util/Collection;Z)V

    .line 69
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;Ljava/util/Set;Ljava/util/Collection;Z)V
    .locals 8
    .param p1, "throwable"    # Ljava/lang/Throwable;
    .param p4, "analyticsEnabled"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            "Ljava/util/Set",
            "<",
            "Lcom/newrelic/agent/android/analytics/AnalyticAttribute;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/newrelic/agent/android/analytics/AnalyticsEvent;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 71
    .local p2, "sessionAttributes":Ljava/util/Set;, "Ljava/util/Set<Lcom/newrelic/agent/android/analytics/AnalyticAttribute;>;"
    .local p3, "events":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/newrelic/agent/android/analytics/AnalyticsEvent;>;"
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 72
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getImpl()Lcom/newrelic/agent/android/AgentImpl;

    move-result-object v0

    .line 74
    .local v0, "agentImpl":Lcom/newrelic/agent/android/AgentImpl;
    invoke-static {p1}, Lcom/newrelic/agent/android/harvest/crash/Crash;->getRootCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v1

    .line 76
    .local v1, "cause":Ljava/lang/Throwable;
    new-instance v2, Ljava/util/UUID;

    invoke-static {}, Lcom/newrelic/agent/android/util/Util;->getRandom()Ljava/util/Random;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Random;->nextLong()J

    move-result-wide v4

    invoke-static {}, Lcom/newrelic/agent/android/util/Util;->getRandom()Ljava/util/Random;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Random;->nextLong()J

    move-result-wide v6

    invoke-direct {v2, v4, v5, v6, v7}, Ljava/util/UUID;-><init>(JJ)V

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->uuid:Ljava/util/UUID;

    .line 77
    invoke-static {}, Lcom/newrelic/agent/android/harvest/crash/Crash;->getBuildId()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->buildId:Ljava/lang/String;

    .line 78
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    iput-wide v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->timestamp:J

    .line 79
    invoke-static {}, Lcom/newrelic/agent/android/crashes/CrashReporter;->getAgentConfiguration()Lcom/newrelic/agent/android/AgentConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/newrelic/agent/android/AgentConfiguration;->getApplicationToken()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->appToken:Ljava/lang/String;

    .line 80
    new-instance v2, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    invoke-interface {v0}, Lcom/newrelic/agent/android/AgentImpl;->getDeviceInformation()Lcom/newrelic/agent/android/harvest/DeviceInformation;

    move-result-object v3

    invoke-interface {v0}, Lcom/newrelic/agent/android/AgentImpl;->getEnvironmentInformation()Lcom/newrelic/agent/android/harvest/EnvironmentInformation;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;-><init>(Lcom/newrelic/agent/android/harvest/DeviceInformation;Lcom/newrelic/agent/android/harvest/EnvironmentInformation;)V

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->deviceInfo:Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    .line 81
    new-instance v2, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    invoke-interface {v0}, Lcom/newrelic/agent/android/AgentImpl;->getApplicationInformation()Lcom/newrelic/agent/android/harvest/ApplicationInformation;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;-><init>(Lcom/newrelic/agent/android/harvest/ApplicationInformation;)V

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->applicationInfo:Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    .line 82
    new-instance v2, Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    invoke-direct {v2, v1}, Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;-><init>(Ljava/lang/Throwable;)V

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->exceptionInfo:Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    .line 83
    invoke-static {v1}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->extractThreads(Ljava/lang/Throwable;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->threads:Ljava/util/List;

    .line 84
    invoke-static {}, Lcom/newrelic/agent/android/tracing/TraceMachine;->getActivityHistory()Lcom/newrelic/agent/android/harvest/ActivityHistory;

    move-result-object v2

    iput-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->activityHistory:Lcom/newrelic/agent/android/harvest/ActivityHistory;

    .line 85
    iput-object p2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->sessionAttributes:Ljava/util/Set;

    .line 86
    iput-object p3, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->events:Ljava/util/Collection;

    .line 87
    iput-boolean p4, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->analyticsEnabled:Z

    .line 88
    return-void
.end method

.method public constructor <init>(Ljava/util/UUID;Ljava/lang/String;J)V
    .locals 5
    .param p1, "uuid"    # Ljava/util/UUID;
    .param p2, "buildId"    # Ljava/lang/String;
    .param p3, "timestamp"    # J

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 51
    invoke-static {}, Lcom/newrelic/agent/android/Agent;->getImpl()Lcom/newrelic/agent/android/AgentImpl;

    move-result-object v0

    .line 53
    .local v0, "agentImpl":Lcom/newrelic/agent/android/AgentImpl;
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->uuid:Ljava/util/UUID;

    .line 54
    iput-object p2, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->buildId:Ljava/lang/String;

    .line 55
    iput-wide p3, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->timestamp:J

    .line 56
    invoke-static {}, Lcom/newrelic/agent/android/crashes/CrashReporter;->getAgentConfiguration()Lcom/newrelic/agent/android/AgentConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/agent/android/AgentConfiguration;->getApplicationToken()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->appToken:Ljava/lang/String;

    .line 57
    new-instance v1, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    invoke-interface {v0}, Lcom/newrelic/agent/android/AgentImpl;->getDeviceInformation()Lcom/newrelic/agent/android/harvest/DeviceInformation;

    move-result-object v2

    invoke-interface {v0}, Lcom/newrelic/agent/android/AgentImpl;->getEnvironmentInformation()Lcom/newrelic/agent/android/harvest/EnvironmentInformation;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;-><init>(Lcom/newrelic/agent/android/harvest/DeviceInformation;Lcom/newrelic/agent/android/harvest/EnvironmentInformation;)V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->deviceInfo:Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    .line 58
    new-instance v1, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    invoke-interface {v0}, Lcom/newrelic/agent/android/AgentImpl;->getApplicationInformation()Lcom/newrelic/agent/android/harvest/ApplicationInformation;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;-><init>(Lcom/newrelic/agent/android/harvest/ApplicationInformation;)V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->applicationInfo:Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    .line 59
    new-instance v1, Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    invoke-direct {v1}, Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->exceptionInfo:Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    .line 60
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->threads:Ljava/util/List;

    .line 61
    new-instance v1, Lcom/newrelic/agent/android/harvest/ActivityHistory;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {v1, v2}, Lcom/newrelic/agent/android/harvest/ActivityHistory;-><init>(Ljava/util/List;)V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->activityHistory:Lcom/newrelic/agent/android/harvest/ActivityHistory;

    .line 62
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->sessionAttributes:Ljava/util/Set;

    .line 63
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iput-object v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->events:Ljava/util/Collection;

    .line 64
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->analyticsEnabled:Z

    .line 65
    return-void
.end method

.method public static crashFromJsonString(Ljava/lang/String;)Lcom/newrelic/agent/android/harvest/crash/Crash;
    .locals 8
    .param p0, "json"    # Ljava/lang/String;

    .prologue
    .line 162
    new-instance v7, Lcom/newrelic/com/google/gson/JsonParser;

    invoke-direct {v7}, Lcom/newrelic/com/google/gson/JsonParser;-><init>()V

    invoke-virtual {v7, p0}, Lcom/newrelic/com/google/gson/JsonParser;->parse(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v3

    .line 163
    .local v3, "element":Lcom/newrelic/com/google/gson/JsonElement;
    invoke-virtual {v3}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v2

    .line 165
    .local v2, "crashObject":Lcom/newrelic/com/google/gson/JsonObject;
    const-string v7, "uuid"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v6

    .line 166
    .local v6, "uuid":Ljava/lang/String;
    const-string v7, "buildId"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v0

    .line 167
    .local v0, "buildIdentifier":Ljava/lang/String;
    const-string v7, "timestamp"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsLong()J

    move-result-wide v4

    .line 169
    .local v4, "timestamp":J
    new-instance v1, Lcom/newrelic/agent/android/harvest/crash/Crash;

    invoke-static {v6}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v7

    invoke-direct {v1, v7, v0, v4, v5}, Lcom/newrelic/agent/android/harvest/crash/Crash;-><init>(Ljava/util/UUID;Ljava/lang/String;J)V

    .line 171
    .local v1, "crash":Lcom/newrelic/agent/android/harvest/crash/Crash;
    const-string v7, "deviceInfo"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    move-result-object v7

    iput-object v7, v1, Lcom/newrelic/agent/android/harvest/crash/Crash;->deviceInfo:Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    .line 172
    const-string v7, "appInfo"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    move-result-object v7

    iput-object v7, v1, Lcom/newrelic/agent/android/harvest/crash/Crash;->applicationInfo:Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    .line 173
    const-string v7, "exception"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;->newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    move-result-object v7

    iput-object v7, v1, Lcom/newrelic/agent/android/harvest/crash/Crash;->exceptionInfo:Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    .line 174
    const-string v7, "threads"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonArray()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->newListFromJson(Lcom/newrelic/com/google/gson/JsonArray;)Ljava/util/List;

    move-result-object v7

    iput-object v7, v1, Lcom/newrelic/agent/android/harvest/crash/Crash;->threads:Ljava/util/List;

    .line 175
    const-string v7, "activityHistory"

    invoke-virtual {v2, v7}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonArray()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/harvest/ActivityHistory;->newFromJson(Lcom/newrelic/com/google/gson/JsonArray;)Lcom/newrelic/agent/android/harvest/ActivityHistory;

    move-result-object v7

    iput-object v7, v1, Lcom/newrelic/agent/android/harvest/crash/Crash;->activityHistory:Lcom/newrelic/agent/android/harvest/ActivityHistory;

    .line 177
    return-object v1
.end method

.method public static getBuildId()Ljava/lang/String;
    .locals 1

    const-string v0, "1c0c63fe-f3f4-46a8-8ddb-02c5f5ce2c99"

    return-object v0
.end method

.method protected static getRootCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .locals 2
    .param p0, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 181
    if-eqz p0, :cond_1

    .line 182
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 184
    .local v0, "cause":Ljava/lang/Throwable;
    if-nez v0, :cond_0

    .line 191
    .end local v0    # "cause":Ljava/lang/Throwable;
    .end local p0    # "throwable":Ljava/lang/Throwable;
    :goto_0
    return-object p0

    .line 187
    .restart local v0    # "cause":Ljava/lang/Throwable;
    .restart local p0    # "throwable":Ljava/lang/Throwable;
    :cond_0
    invoke-static {v0}, Lcom/newrelic/agent/android/harvest/crash/Crash;->getRootCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object p0

    goto :goto_0

    .line 191
    .end local v0    # "cause":Ljava/lang/Throwable;
    :cond_1
    new-instance p0, Ljava/lang/Throwable;

    .end local p0    # "throwable":Ljava/lang/Throwable;
    const-string v1, "Unknown cause"

    invoke-direct {p0, v1}, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;
    .locals 10

    .prologue
    .line 121
    new-instance v2, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v2}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 123
    .local v2, "data":Lcom/newrelic/com/google/gson/JsonObject;
    const-string v7, "protocolVersion"

    new-instance v8, Lcom/newrelic/com/google/gson/JsonPrimitive;

    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/newrelic/com/google/gson/JsonPrimitive;-><init>(Ljava/lang/Number;)V

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 124
    const-string v7, "platform"

    new-instance v8, Lcom/newrelic/com/google/gson/JsonPrimitive;

    const-string v9, "Android"

    invoke-direct {v8, v9}, Lcom/newrelic/com/google/gson/JsonPrimitive;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 125
    const-string v7, "uuid"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->uuid:Ljava/util/UUID;

    invoke-virtual {v8}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 126
    const-string v7, "buildId"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->buildId:Ljava/lang/String;

    invoke-static {v8}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 127
    const-string v7, "timestamp"

    iget-wide v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->timestamp:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-static {v8}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 128
    const-string v7, "appToken"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->appToken:Ljava/lang/String;

    invoke-static {v8}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 129
    const-string v7, "deviceInfo"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->deviceInfo:Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;

    invoke-virtual {v8}, Lcom/newrelic/agent/android/harvest/crash/DeviceInfo;->asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 130
    const-string v7, "appInfo"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->applicationInfo:Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;

    invoke-virtual {v8}, Lcom/newrelic/agent/android/harvest/crash/ApplicationInfo;->asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 131
    const-string v7, "exception"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->exceptionInfo:Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    invoke-virtual {v8}, Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;->asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 132
    const-string v7, "threads"

    invoke-virtual {p0}, Lcom/newrelic/agent/android/harvest/crash/Crash;->getThreadsAsJson()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 133
    const-string v7, "activityHistory"

    iget-object v8, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->activityHistory:Lcom/newrelic/agent/android/harvest/ActivityHistory;

    invoke-virtual {v8}, Lcom/newrelic/agent/android/harvest/ActivityHistory;->asJsonArrayWithoutDuration()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 135
    iget-boolean v7, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->analyticsEnabled:Z

    if-eqz v7, :cond_2

    sget-object v7, Lcom/newrelic/agent/android/FeatureFlag;->AnalyticsEvents:Lcom/newrelic/agent/android/FeatureFlag;

    invoke-static {v7}, Lcom/newrelic/agent/android/FeatureFlag;->featureEnabled(Lcom/newrelic/agent/android/FeatureFlag;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 136
    new-instance v1, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v1}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 137
    .local v1, "attributeObject":Lcom/newrelic/com/google/gson/JsonObject;
    iget-object v7, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->sessionAttributes:Ljava/util/Set;

    if-eqz v7, :cond_0

    .line 138
    iget-object v7, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->sessionAttributes:Ljava/util/Set;

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;

    .line 139
    .local v0, "attribute":Lcom/newrelic/agent/android/analytics/AnalyticAttribute;
    invoke-virtual {v0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->asJsonElement()Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    goto :goto_0

    .line 142
    .end local v0    # "attribute":Lcom/newrelic/agent/android/analytics/AnalyticAttribute;
    .end local v6    # "i$":Ljava/util/Iterator;
    :cond_0
    const-string v7, "sessionAttributes"

    invoke-virtual {v2, v7, v1}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 144
    new-instance v5, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v5}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 145
    .local v5, "eventArray":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v7, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->events:Ljava/util/Collection;

    if-eqz v7, :cond_1

    .line 146
    iget-object v7, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->events:Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .restart local v6    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/newrelic/agent/android/analytics/AnalyticsEvent;

    .line 147
    .local v4, "event":Lcom/newrelic/agent/android/analytics/AnalyticsEvent;
    invoke-virtual {v4}, Lcom/newrelic/agent/android/analytics/AnalyticsEvent;->asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    goto :goto_1

    .line 150
    .end local v4    # "event":Lcom/newrelic/agent/android/analytics/AnalyticsEvent;
    .end local v6    # "i$":Ljava/util/Iterator;
    :cond_1
    const-string v7, "analyticsEvents"

    invoke-virtual {v2, v7, v5}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 153
    .end local v1    # "attributeObject":Lcom/newrelic/com/google/gson/JsonObject;
    .end local v5    # "eventArray":Lcom/newrelic/com/google/gson/JsonArray;
    :cond_2
    invoke-static {}, Lcom/newrelic/agent/android/harvest/Harvest;->getHarvestConfiguration()Lcom/newrelic/agent/android/harvest/HarvestConfiguration;

    move-result-object v7

    invoke-virtual {v7}, Lcom/newrelic/agent/android/harvest/HarvestConfiguration;->getDataToken()Lcom/newrelic/agent/android/harvest/DataToken;

    move-result-object v3

    .line 154
    .local v3, "dataToken":Lcom/newrelic/agent/android/harvest/DataToken;
    if-eqz v3, :cond_3

    .line 155
    const-string v7, "dataToken"

    invoke-virtual {v3}, Lcom/newrelic/agent/android/harvest/DataToken;->asJsonArray()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 158
    :cond_3
    return-object v2
.end method

.method public getExceptionInfo()Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->exceptionInfo:Lcom/newrelic/agent/android/harvest/crash/ExceptionInfo;

    return-object v0
.end method

.method protected getThreadsAsJson()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 4

    .prologue
    .line 195
    new-instance v0, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 197
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v3, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->threads:Ljava/util/List;

    if-eqz v3, :cond_0

    .line 198
    iget-object v3, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->threads:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;

    .line 199
    .local v2, "thread":Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;
    invoke-virtual {v2}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    goto :goto_0

    .line 203
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "thread":Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;
    :cond_0
    return-object v0
.end method

.method public getTimestamp()J
    .locals 2

    .prologue
    .line 100
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->timestamp:J

    return-wide v0
.end method

.method public getUuid()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->uuid:Ljava/util/UUID;

    return-object v0
.end method

.method public setAnalyticsEvents(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/analytics/AnalyticsEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 116
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/analytics/AnalyticsEvent;>;"
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->events:Ljava/util/Collection;

    .line 117
    return-void
.end method

.method public setSessionAttributes(Ljava/util/Set;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/newrelic/agent/android/analytics/AnalyticAttribute;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    .local p1, "sessionAttributes":Ljava/util/Set;, "Ljava/util/Set<Lcom/newrelic/agent/android/analytics/AnalyticAttribute;>;"
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/crash/Crash;->sessionAttributes:Ljava/util/Set;

    .line 113
    return-void
.end method
