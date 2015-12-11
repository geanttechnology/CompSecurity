.class Lnet/singular/sdk/CountersLogger;
.super Ljava/lang/Object;
.source "CountersLogger.java"


# static fields
.field public static final COUNTERS_KEY:Ljava/lang/String; = "COUNTERS_KEY"


# instance fields
.field private counters:Lorg/json/JSONObject;

.field private final countersKeyValueStore:Lnet/singular/sdk/KeyValueStore;

.field private loaded:Z

.field private saverPostable:Lnet/singular/sdk/PostableWorker;


# direct methods
.method public constructor <init>(Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/NewInjector;)V
    .locals 1
    .param p1, "saverPostable"    # Lnet/singular/sdk/PostableWorker;
    .param p2, "I"    # Lnet/singular/sdk/NewInjector;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const-string v0, "counters"

    invoke-virtual {p2, v0}, Lnet/singular/sdk/NewInjector;->generateKeyValueStore(Ljava/lang/String;)Lnet/singular/sdk/KeyValueStore;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/CountersLogger;->countersKeyValueStore:Lnet/singular/sdk/KeyValueStore;

    .line 15
    iput-object p1, p0, Lnet/singular/sdk/CountersLogger;->saverPostable:Lnet/singular/sdk/PostableWorker;

    .line 16
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;

    .line 17
    const/4 v0, 0x0

    iput-boolean v0, p0, Lnet/singular/sdk/CountersLogger;->loaded:Z

    .line 18
    return-void
.end method

.method static synthetic access$000(Lnet/singular/sdk/CountersLogger;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/CountersLogger;

    .prologue
    .line 6
    iget-object v0, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;

    return-object v0
.end method

.method static synthetic access$100(Lnet/singular/sdk/CountersLogger;)Lnet/singular/sdk/KeyValueStore;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/CountersLogger;

    .prologue
    .line 6
    iget-object v0, p0, Lnet/singular/sdk/CountersLogger;->countersKeyValueStore:Lnet/singular/sdk/KeyValueStore;

    return-object v0
.end method

.method private saveCounters()V
    .locals 2

    .prologue
    .line 89
    iget-boolean v0, p0, Lnet/singular/sdk/CountersLogger;->loaded:Z

    if-eqz v0, :cond_0

    .line 90
    iget-object v0, p0, Lnet/singular/sdk/CountersLogger;->saverPostable:Lnet/singular/sdk/PostableWorker;

    new-instance v1, Lnet/singular/sdk/CountersLogger$1;

    invoke-direct {v1, p0}, Lnet/singular/sdk/CountersLogger$1;-><init>(Lnet/singular/sdk/CountersLogger;)V

    invoke-virtual {v0, v1}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 99
    :cond_0
    return-void
.end method


# virtual methods
.method public getAllCounters()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getCounter(Ljava/lang/String;)J
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 45
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;

    invoke-virtual {v1, p1}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    .line 47
    :goto_0
    return-wide v2

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "e":Lorg/json/JSONException;
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method public increaseCounter(Ljava/lang/String;)J
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 57
    const-wide/16 v0, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public declared-synchronized increaseCounter(Ljava/lang/String;J)J
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "count"    # J

    .prologue
    .line 66
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1}, Lnet/singular/sdk/CountersLogger;->getCounter(Ljava/lang/String;)J

    move-result-wide v2

    .line 67
    .local v2, "old_value":J
    add-long v0, v2, p2

    .line 68
    .local v0, "new_value":J
    invoke-virtual {p0, p1, v0, v1}, Lnet/singular/sdk/CountersLogger;->setCounter(Ljava/lang/String;J)V

    .line 69
    invoke-virtual {p0, p1}, Lnet/singular/sdk/CountersLogger;->getCounter(Ljava/lang/String;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v4

    monitor-exit p0

    return-wide v4

    .line 66
    .end local v0    # "new_value":J
    .end local v2    # "old_value":J
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public loadSavedCounters()V
    .locals 4

    .prologue
    .line 26
    const/4 v2, 0x1

    iput-boolean v2, p0, Lnet/singular/sdk/CountersLogger;->loaded:Z

    .line 29
    :try_start_0
    iget-object v2, p0, Lnet/singular/sdk/CountersLogger;->countersKeyValueStore:Lnet/singular/sdk/KeyValueStore;

    const-string v3, "COUNTERS_KEY"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/KeyValueStore;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 31
    .local v1, "saved_counters":Ljava/lang/String;
    :try_start_1
    new-instance v2, Lorg/json/JSONObject;

    invoke-static {v1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    iput-object v2, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 41
    .end local v1    # "saved_counters":Ljava/lang/String;
    :goto_0
    return-void

    .line 32
    .restart local v1    # "saved_counters":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 34
    .local v0, "e":Lorg/json/JSONException;
    :try_start_2
    iget-object v2, p0, Lnet/singular/sdk/CountersLogger;->countersKeyValueStore:Lnet/singular/sdk/KeyValueStore;

    const-string v3, "COUNTERS_KEY"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/KeyValueStore;->delete(Ljava/lang/String;)V

    .line 35
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    iput-object v2, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;
    :try_end_2
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 37
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "saved_counters":Ljava/lang/String;
    :catch_1
    move-exception v0

    .line 39
    .local v0, "e":Lnet/singular/sdk/KeyNotFoundException;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    iput-object v2, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;

    goto :goto_0
.end method

.method public setCounter(Ljava/lang/String;J)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "newValue"    # J

    .prologue
    .line 79
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/CountersLogger;->counters:Lorg/json/JSONObject;

    invoke-virtual {v0, p1, p2, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 80
    invoke-direct {p0}, Lnet/singular/sdk/CountersLogger;->saveCounters()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :goto_0
    return-void

    .line 81
    :catch_0
    move-exception v0

    goto :goto_0
.end method
