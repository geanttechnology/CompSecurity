.class Lnet/singular/sdk/Controller;
.super Ljava/lang/Object;
.source "Controller.java"


# static fields
.field public static final TAG:Ljava/lang/String; = "net.singular.sdk.Controller"


# instance fields
.field private collector:Lnet/singular/sdk/Collector;

.field private countersLogger:Lnet/singular/sdk/CountersLogger;

.field private eventReporter:Lnet/singular/sdk/EventReporter;

.field private eventStore:Lnet/singular/sdk/EventStore;

.field private exponential_backoff:Z

.field private exponential_backoff_exponent:I

.field private exponential_backoff_wait_until:J

.field private isPaused:Z

.field private log:Lnet/singular/sdk/SingularLog;

.field private logsKeeper:Lnet/singular/sdk/LogsKeeper;

.field private random:Ljava/util/Random;

.field protected saverPostable:Lnet/singular/sdk/PostableWorker;

.field protected senderPostable:Lnet/singular/sdk/PostableWorker;

.field protected senderRunnable:Ljava/lang/Runnable;

.field private sender_enabled:Z

.field private sessionManager:Lnet/singular/sdk/SessionManager;

.field private single_post_event_limit:I

.field private timeHelper:Lnet/singular/sdk/TimeHelper;


# direct methods
.method public constructor <init>(Lnet/singular/sdk/EventStore;Lnet/singular/sdk/EventReporter;Lnet/singular/sdk/TimeHelper;Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/CountersLogger;Ljava/util/Random;Lnet/singular/sdk/LogsKeeper;Lnet/singular/sdk/SingularLog;)V
    .locals 0
    .param p1, "eventStore"    # Lnet/singular/sdk/EventStore;
    .param p2, "eventReporter"    # Lnet/singular/sdk/EventReporter;
    .param p3, "timeHelper"    # Lnet/singular/sdk/TimeHelper;
    .param p4, "networkPostable"    # Lnet/singular/sdk/PostableWorker;
    .param p5, "saverPostable"    # Lnet/singular/sdk/PostableWorker;
    .param p6, "countersLogger"    # Lnet/singular/sdk/CountersLogger;
    .param p7, "random"    # Ljava/util/Random;
    .param p8, "logsKeeper"    # Lnet/singular/sdk/LogsKeeper;
    .param p9, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;

    .line 45
    iput-object p2, p0, Lnet/singular/sdk/Controller;->eventReporter:Lnet/singular/sdk/EventReporter;

    .line 46
    iput-object p3, p0, Lnet/singular/sdk/Controller;->timeHelper:Lnet/singular/sdk/TimeHelper;

    .line 47
    iput-object p4, p0, Lnet/singular/sdk/Controller;->senderPostable:Lnet/singular/sdk/PostableWorker;

    .line 48
    iput-object p5, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    .line 49
    iput-object p6, p0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    .line 50
    iput-object p7, p0, Lnet/singular/sdk/Controller;->random:Ljava/util/Random;

    .line 51
    iput-object p8, p0, Lnet/singular/sdk/Controller;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    .line 52
    iput-object p9, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    .line 53
    return-void
.end method

.method static synthetic access$000(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/CountersLogger;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 16
    iget-object v0, p0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    return-object v0
.end method

.method static synthetic access$100(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/Controller;
    .param p1, "x1"    # Ljava/lang/Exception;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Lnet/singular/sdk/Controller;->logAndReportException(Ljava/lang/Exception;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$200(Lnet/singular/sdk/Controller;)V
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 16
    invoke-direct {p0}, Lnet/singular/sdk/Controller;->senderMethod()V

    return-void
.end method

.method static synthetic access$300(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/Controller;
    .param p1, "x1"    # Ljava/lang/Exception;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Lnet/singular/sdk/Controller;->logException(Ljava/lang/Exception;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/SessionManager;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 16
    iget-object v0, p0, Lnet/singular/sdk/Controller;->sessionManager:Lnet/singular/sdk/SessionManager;

    return-object v0
.end method

.method static synthetic access$500(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/Collector;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 16
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    return-object v0
.end method

.method static synthetic access$600(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/EventStore;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 16
    iget-object v0, p0, Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;

    return-object v0
.end method

.method static synthetic access$700(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/SingularLog;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 16
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    return-object v0
.end method

.method private declared-synchronized activateSenderInner(J)V
    .locals 3
    .param p1, "delayMillis"    # J

    .prologue
    .line 336
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lnet/singular/sdk/Controller;->sender_enabled:Z

    if-eqz v0, :cond_0

    .line 337
    iget-object v0, p0, Lnet/singular/sdk/Controller;->senderPostable:Lnet/singular/sdk/PostableWorker;

    iget-object v1, p0, Lnet/singular/sdk/Controller;->senderRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, p1, p2}, Lnet/singular/sdk/PostableWorker;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 339
    :cond_0
    monitor-exit p0

    return-void

    .line 336
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private exponentialBackoff()V
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 197
    iget-boolean v2, p0, Lnet/singular/sdk/Controller;->exponential_backoff:Z

    if-nez v2, :cond_1

    .line 198
    iput-boolean v8, p0, Lnet/singular/sdk/Controller;->exponential_backoff:Z

    .line 199
    iput v8, p0, Lnet/singular/sdk/Controller;->exponential_backoff_exponent:I

    .line 204
    :goto_0
    iget v2, p0, Lnet/singular/sdk/Controller;->exponential_backoff_exponent:I

    shl-int v1, v8, v2

    .line 205
    .local v1, "current_multiplier":I
    iget-object v2, p0, Lnet/singular/sdk/Controller;->random:Ljava/util/Random;

    int-to-long v4, v1

    const-wide/16 v6, 0x7530

    mul-long/2addr v4, v6

    long-to-int v3, v4

    invoke-virtual {v2, v3}, Ljava/util/Random;->nextInt(I)I

    move-result v0

    .line 206
    .local v0, "current_delay":I
    int-to-long v2, v0

    const-wide/32 v4, 0xa4cb80

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    long-to-int v0, v2

    .line 207
    iget-object v2, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "exponentialBackoff: exponent = %d, current_delay = %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    iget v7, p0, Lnet/singular/sdk/Controller;->exponential_backoff_exponent:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    iget-object v2, p0, Lnet/singular/sdk/Controller;->timeHelper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v2}, Lnet/singular/sdk/TimeHelper;->currentTimeMillis()J

    move-result-wide v2

    int-to-long v4, v0

    add-long/2addr v2, v4

    iput-wide v2, p0, Lnet/singular/sdk/Controller;->exponential_backoff_wait_until:J

    .line 212
    iget-boolean v2, p0, Lnet/singular/sdk/Controller;->isPaused:Z

    if-nez v2, :cond_0

    .line 213
    iget-object v2, p0, Lnet/singular/sdk/Controller;->senderPostable:Lnet/singular/sdk/PostableWorker;

    iget-object v3, p0, Lnet/singular/sdk/Controller;->senderRunnable:Ljava/lang/Runnable;

    int-to-long v4, v0

    invoke-virtual {v2, v3, v4, v5}, Lnet/singular/sdk/PostableWorker;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 215
    :cond_0
    return-void

    .line 201
    .end local v0    # "current_delay":I
    .end local v1    # "current_multiplier":I
    :cond_1
    iget v2, p0, Lnet/singular/sdk/Controller;->exponential_backoff_exponent:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lnet/singular/sdk/Controller;->exponential_backoff_exponent:I

    goto :goto_0
.end method

.method private handleVerboseRequestIfNeeded(Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    .locals 6
    .param p1, "persistentAndCounters"    # Lorg/json/JSONObject;
    .param p2, "responseJson"    # Lorg/json/JSONObject;

    .prologue
    .line 175
    :try_start_0
    const-string v3, "submit_verbose"

    invoke-virtual {p2, v3}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v3

    if-eqz v3, :cond_0

    .line 177
    :try_start_1
    iget-object v3, p0, Lnet/singular/sdk/Controller;->eventReporter:Lnet/singular/sdk/EventReporter;

    iget-object v4, p0, Lnet/singular/sdk/Controller;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    invoke-virtual {v4}, Lnet/singular/sdk/LogsKeeper;->getLogs()Lorg/json/JSONArray;

    move-result-object v4

    invoke-virtual {v3, p1, v4}, Lnet/singular/sdk/EventReporter;->sendVerboseLogsRequest(Lorg/json/JSONObject;Lorg/json/JSONArray;)Landroid/util/Pair;

    move-result-object v1

    .line 178
    .local v1, "verboseResponsePair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Lorg/json/JSONObject;>;"
    if-eqz v1, :cond_0

    .line 179
    iget-object v2, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Integer;

    .line 180
    .local v2, "verboseStatusCode":Ljava/lang/Integer;
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/16 v4, 0xc8

    if-lt v3, v4, :cond_0

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/16 v4, 0x12c

    if-ge v3, v4, :cond_0

    .line 181
    iget-object v3, p0, Lnet/singular/sdk/Controller;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    invoke-virtual {v3}, Lnet/singular/sdk/LogsKeeper;->cleanLogs()V
    :try_end_1
    .catch Lnet/singular/sdk/InvalidArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 191
    .end local v1    # "verboseResponsePair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Lorg/json/JSONObject;>;"
    .end local v2    # "verboseStatusCode":Ljava/lang/Integer;
    :cond_0
    :goto_0
    return-void

    .line 184
    :catch_0
    move-exception v0

    .line 185
    .local v0, "e":Lnet/singular/sdk/InvalidArgumentException;
    :try_start_2
    iget-object v3, p0, Lnet/singular/sdk/Controller;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    invoke-virtual {v3}, Lnet/singular/sdk/LogsKeeper;->cleanLogs()V

    .line 186
    iget-object v3, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "singular_sdk"

    const-string v5, "logsKeeper lines corruption"

    invoke-virtual {v3, v4, v5, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 189
    .end local v0    # "e":Lnet/singular/sdk/InvalidArgumentException;
    :catch_1
    move-exception v3

    goto :goto_0
.end method

.method private logAndReportException(Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "failName"    # Ljava/lang/String;

    .prologue
    .line 419
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v2, "Controller:%s failed"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2, p1}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 420
    return-void
.end method

.method private logException(Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "failName"    # Ljava/lang/String;

    .prologue
    .line 415
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v2, "Controller:%s failed"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2, p1}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 416
    return-void
.end method

.method private senderMethod()V
    .locals 19

    .prologue
    .line 106
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "net.singular.sdk.Controller"

    const-string v15, "senderRunnable: started!"

    invoke-virtual {v13, v14, v15}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v13}, Lnet/singular/sdk/Collector;->getPersistentIdCountersAndDebugVars()Lorg/json/JSONObject;

    move-result-object v8

    .line 111
    .local v8, "persistentAndCounters":Lorg/json/JSONObject;
    :cond_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;

    move-object/from16 v0, p0

    iget v14, v0, Lnet/singular/sdk/Controller;->single_post_event_limit:I

    invoke-virtual {v13, v14}, Lnet/singular/sdk/EventStore;->getEvents(I)Landroid/util/Pair;

    move-result-object v11

    .line 112
    .local v11, "result_pair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Lorg/json/JSONArray;>;"
    if-nez v11, :cond_1

    .line 168
    :goto_0
    return-void

    .line 114
    :cond_1
    iget-object v13, v11, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v13, Ljava/lang/Long;

    invoke-virtual {v13}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    .line 115
    .local v6, "max_id":J
    iget-object v3, v11, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v3, Lorg/json/JSONArray;

    .line 116
    .local v3, "events":Lorg/json/JSONArray;
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v13

    int-to-long v4, v13

    .line 117
    .local v4, "events_count":J
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "net.singular.sdk.Controller"

    const-string v15, "senderRunnable: event_count = %d"

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    aput-object v18, v16, v17

    invoke-static/range {v15 .. v16}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v14, v15}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const-wide/16 v14, 0x0

    cmp-long v13, v4, v14

    if-lez v13, :cond_3

    .line 120
    const/4 v10, 0x0

    .line 122
    .local v10, "responsePair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Lorg/json/JSONObject;>;"
    :try_start_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->eventReporter:Lnet/singular/sdk/EventReporter;

    invoke-virtual {v13, v8, v3}, Lnet/singular/sdk/EventReporter;->sendPostEventsRequest(Lorg/json/JSONObject;Lorg/json/JSONArray;)Landroid/util/Pair;
    :try_end_0
    .catch Lnet/singular/sdk/InvalidArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v10

    .line 129
    :goto_1
    if-nez v10, :cond_2

    .line 130
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "net.singular.sdk.Controller"

    const-string v15, "senderRunnable: no response, retry later"

    invoke-virtual {v13, v14, v15}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    invoke-direct/range {p0 .. p0}, Lnet/singular/sdk/Controller;->exponentialBackoff()V

    goto :goto_0

    .line 124
    :catch_0
    move-exception v2

    .line 125
    .local v2, "e":Lnet/singular/sdk/InvalidArgumentException;
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "singular_sdk"

    const-string v15, "senderMethod: InvalidArgumentException"

    invoke-virtual {v13, v14, v15, v2}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 127
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;

    invoke-virtual {v13, v6, v7}, Lnet/singular/sdk/EventStore;->deleteEvents(J)Z

    goto :goto_1

    .line 134
    .end local v2    # "e":Lnet/singular/sdk/InvalidArgumentException;
    :cond_2
    iget-object v12, v10, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v12, Ljava/lang/Integer;

    .line 135
    .local v12, "statusCode":Ljava/lang/Integer;
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "singular_sdk"

    const-string v15, "senderRunnable: responseCode = %d"

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v12, v16, v17

    invoke-static/range {v15 .. v16}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v13, v14, v15}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    iget-object v9, v10, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v9, Lorg/json/JSONObject;

    .line 139
    .local v9, "responseJson":Lorg/json/JSONObject;
    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0xc8

    if-lt v13, v14, :cond_4

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0x12c

    if-ge v13, v14, :cond_4

    .line 140
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lnet/singular/sdk/Controller;->exponential_backoff:Z

    .line 141
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v14, "total_successful_sends"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 142
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "net.singular.sdk.Controller"

    const-string v15, "senderRunnable: send_ok :)"

    invoke-virtual {v13, v14, v15}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;

    invoke-virtual {v13, v6, v7}, Lnet/singular/sdk/EventStore;->deleteEvents(J)Z

    .line 144
    move-object/from16 v0, p0

    invoke-direct {v0, v8, v9}, Lnet/singular/sdk/Controller;->handleVerboseRequestIfNeeded(Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    .line 145
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "Events reported to server!"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/SingularLog;->forDeveloper(Ljava/lang/String;)V

    .line 167
    .end local v9    # "responseJson":Lorg/json/JSONObject;
    .end local v10    # "responsePair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Lorg/json/JSONObject;>;"
    .end local v12    # "statusCode":Ljava/lang/Integer;
    :cond_3
    :goto_2
    const-wide/16 v14, 0x0

    cmp-long v13, v4, v14

    if-gtz v13, :cond_0

    goto/16 :goto_0

    .line 146
    .restart local v9    # "responseJson":Lorg/json/JSONObject;
    .restart local v10    # "responsePair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Lorg/json/JSONObject;>;"
    .restart local v12    # "statusCode":Ljava/lang/Integer;
    :cond_4
    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0x19d

    if-ne v13, v14, :cond_5

    .line 147
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v14, "failed_sends"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 148
    const/4 v13, 0x1

    move-object/from16 v0, p0

    iget v14, v0, Lnet/singular/sdk/Controller;->single_post_event_limit:I

    div-int/lit8 v14, v14, 0x2

    invoke-static {v13, v14}, Ljava/lang/Math;->max(II)I

    move-result v13

    move-object/from16 v0, p0

    iput v13, v0, Lnet/singular/sdk/Controller;->single_post_event_limit:I

    goto :goto_2

    .line 149
    :cond_5
    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0x190

    if-ne v13, v14, :cond_6

    .line 150
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v14, "failed_sends"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 151
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->eventStore:Lnet/singular/sdk/EventStore;

    invoke-virtual {v13, v6, v7}, Lnet/singular/sdk/EventStore;->deleteEvents(J)Z

    goto :goto_2

    .line 152
    :cond_6
    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0x191

    if-eq v13, v14, :cond_7

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0x195

    if-eq v13, v14, :cond_7

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/16 v14, 0x19f

    if-ne v13, v14, :cond_8

    .line 155
    :cond_7
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lnet/singular/sdk/Controller;->sender_enabled:Z

    .line 156
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v14, "failed_sends"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 157
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "Fatal failure reporting events to server! turning reporter off"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/SingularLog;->forDeveloper(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 160
    :cond_8
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v14, "failed_sends"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 161
    invoke-direct/range {p0 .. p0}, Lnet/singular/sdk/Controller;->exponentialBackoff()V

    .line 162
    move-object/from16 v0, p0

    iget-object v13, v0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v14, "Failed reporting events to server, backing off for a while"

    invoke-virtual {v13, v14}, Lnet/singular/sdk/SingularLog;->forDeveloper(Ljava/lang/String;)V

    goto/16 :goto_0
.end method


# virtual methods
.method protected declared-synchronized activateSender(J)V
    .locals 1
    .param p1, "delayMillis"    # J

    .prologue
    .line 330
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lnet/singular/sdk/Controller;->exponential_backoff:Z

    if-nez v0, :cond_0

    .line 331
    invoke-direct {p0, p1, p2}, Lnet/singular/sdk/Controller;->activateSenderInner(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 333
    :cond_0
    monitor-exit p0

    return-void

    .line 330
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public clearTemporalIds()V
    .locals 2

    .prologue
    .line 411
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v0, v1}, Lnet/singular/sdk/Collector;->clearTemporalIds(Lnet/singular/sdk/PostableWorker;)V

    .line 412
    return-void
.end method

.method public getDefaultCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 379
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v0}, Lnet/singular/sdk/Collector;->getCurrency()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLogger()Lnet/singular/sdk/SingularLog;
    .locals 2

    .prologue
    .line 452
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    if-nez v0, :cond_0

    .line 453
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Controller: getLogger"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 455
    :cond_0
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    return-object v0
.end method

.method public getSingularId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 97
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v0}, Lnet/singular/sdk/Collector;->getSingularId()Ljava/lang/String;

    move-result-object v0

    .line 101
    :goto_0
    return-object v0

    .line 100
    :cond_0
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v2, "getSingularId: called before initController"

    invoke-virtual {v0, v1, v2}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public initController(Lnet/singular/sdk/SessionManager;Lnet/singular/sdk/Collector;)V
    .locals 2
    .param p1, "sessionManager"    # Lnet/singular/sdk/SessionManager;
    .param p2, "collector"    # Lnet/singular/sdk/Collector;

    .prologue
    const/4 v1, 0x0

    .line 59
    iput-object p1, p0, Lnet/singular/sdk/Controller;->sessionManager:Lnet/singular/sdk/SessionManager;

    .line 60
    iput-object p2, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    .line 61
    const/4 v0, 0x1

    iput-boolean v0, p0, Lnet/singular/sdk/Controller;->sender_enabled:Z

    .line 62
    iput-boolean v1, p0, Lnet/singular/sdk/Controller;->exponential_backoff:Z

    .line 63
    const/16 v0, 0x64

    iput v0, p0, Lnet/singular/sdk/Controller;->single_post_event_limit:I

    .line 64
    invoke-virtual {p2}, Lnet/singular/sdk/Collector;->initializeMandatoryManifestIds()Z

    move-result v0

    if-nez v0, :cond_0

    .line 66
    iput-boolean v1, p0, Lnet/singular/sdk/Controller;->sender_enabled:Z

    .line 68
    :cond_0
    iput-boolean v1, p0, Lnet/singular/sdk/Controller;->isPaused:Z

    .line 69
    iget-object v0, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    new-instance v1, Lnet/singular/sdk/Controller$1;

    invoke-direct {v1, p0, p2}, Lnet/singular/sdk/Controller$1;-><init>(Lnet/singular/sdk/Controller;Lnet/singular/sdk/Collector;)V

    invoke-virtual {v0, v1}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 82
    iget-object v0, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v0}, Lnet/singular/sdk/PostableWorker;->start()V

    .line 83
    new-instance v0, Lnet/singular/sdk/Controller$2;

    invoke-direct {v0, p0}, Lnet/singular/sdk/Controller$2;-><init>(Lnet/singular/sdk/Controller;)V

    iput-object v0, p0, Lnet/singular/sdk/Controller;->senderRunnable:Ljava/lang/Runnable;

    .line 94
    return-void
.end method

.method public initEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;
    .locals 8
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "attribute1"    # Ljava/lang/String;
    .param p3, "attribute2"    # Ljava/lang/String;
    .param p4, "attribute3"    # Ljava/lang/String;
    .param p5, "attribute4"    # Ljava/lang/String;
    .param p6, "attribute5"    # Ljava/lang/String;
    .param p7, "isSpecialEvent"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 358
    const/4 v4, 0x5

    new-array v0, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p2, v0, v4

    const/4 v4, 0x1

    aput-object p3, v0, v4

    const/4 v4, 0x2

    aput-object p4, v0, v4

    const/4 v4, 0x3

    aput-object p5, v0, v4

    const/4 v4, 0x4

    aput-object p6, v0, v4

    .line 360
    .local v0, "attributes":[Ljava/lang/String;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 362
    .local v3, "res":Lorg/json/JSONObject;
    const-string v4, "event_name"

    invoke-virtual {v3, v4, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 363
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v4, v0

    if-ge v2, v4, :cond_1

    .line 364
    aget-object v4, v0, v2

    if-nez v4, :cond_0

    .line 363
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 367
    :cond_0
    sget-object v4, Lnet/singular/sdk/HTTPConstants;->EVENT_ATTRIBUTE_FIELDS:[Ljava/lang/String;

    aget-object v4, v4, v2

    aget-object v5, v0, v2

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 371
    .end local v2    # "i":I
    .end local v3    # "res":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 373
    .local v1, "e":Lorg/json/JSONException;
    iget-object v4, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "initEvent: invalid argument with attributes: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v0}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 374
    throw v1

    .line 369
    .end local v1    # "e":Lorg/json/JSONException;
    .restart local v2    # "i":I
    .restart local v3    # "res":Lorg/json/JSONObject;
    :cond_1
    :try_start_1
    const-string v4, "is_special_event"

    invoke-virtual {v3, v4, p7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    .line 370
    return-object v3
.end method

.method public initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;
    .locals 8
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "isSpecialEvent"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 347
    move-object v0, p0

    move-object v1, p1

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    move v7, p2

    invoke-virtual/range {v0 .. v7}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 221
    const/4 v0, 0x1

    iput-boolean v0, p0, Lnet/singular/sdk/Controller;->isPaused:Z

    .line 222
    iget-object v0, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "onPause() called"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/SingularLog;->forDeveloper(Ljava/lang/String;)V

    .line 223
    iget-object v0, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    new-instance v1, Lnet/singular/sdk/Controller$3;

    invoke-direct {v1, p0}, Lnet/singular/sdk/Controller$3;-><init>(Lnet/singular/sdk/Controller;)V

    invoke-virtual {v0, v1}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 233
    return-void
.end method

.method public onResume()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 239
    iput-boolean v9, p0, Lnet/singular/sdk/Controller;->isPaused:Z

    .line 240
    iget-object v4, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "onResume() called"

    invoke-virtual {v4, v5}, Lnet/singular/sdk/SingularLog;->forDeveloper(Ljava/lang/String;)V

    .line 241
    iget-object v4, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    new-instance v5, Lnet/singular/sdk/Controller$4;

    invoke-direct {v5, p0}, Lnet/singular/sdk/Controller$4;-><init>(Lnet/singular/sdk/Controller;)V

    invoke-virtual {v4, v5}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 253
    iget-object v4, p0, Lnet/singular/sdk/Controller;->timeHelper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v4}, Lnet/singular/sdk/TimeHelper;->currentTimeMillis()J

    move-result-wide v0

    .line 254
    .local v0, "cur_time":J
    iget-object v4, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v4}, Lnet/singular/sdk/Collector;->getFirstUploadDelay()J

    move-result-wide v2

    .line 255
    .local v2, "current_delay":J
    iget-boolean v4, p0, Lnet/singular/sdk/Controller;->exponential_backoff:Z

    if-eqz v4, :cond_0

    .line 256
    iget-object v4, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v4}, Lnet/singular/sdk/Collector;->getFirstUploadDelay()J

    move-result-wide v4

    iget-wide v6, p0, Lnet/singular/sdk/Controller;->exponential_backoff_wait_until:J

    sub-long/2addr v6, v0

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v2

    .line 257
    iget-object v4, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "onResume: exponential_backoff = true, current_delay = %d"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    :cond_0
    invoke-direct {p0, v2, v3}, Lnet/singular/sdk/Controller;->activateSenderInner(J)V

    .line 261
    return-void
.end method

.method public postEventDelayed(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "event"    # Lorg/json/JSONObject;

    .prologue
    .line 315
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v0}, Lnet/singular/sdk/Collector;->getNormalUploadDelay()J

    move-result-wide v0

    invoke-virtual {p0, p1, v0, v1}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;J)V

    .line 316
    return-void
.end method

.method public postEventDelayed(Lorg/json/JSONObject;J)V
    .locals 8
    .param p1, "event"    # Lorg/json/JSONObject;
    .param p2, "delayMillis"    # J

    .prologue
    .line 272
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    instance-of v3, p1, Lorg/json/JSONObject;

    if-nez v3, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    .end local p1    # "event":Lorg/json/JSONObject;
    :goto_0
    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->init(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 273
    .local v1, "event_copy":Lorg/json/JSONObject;
    const-string v3, "event_timestamp_s"

    iget-object v4, p0, Lnet/singular/sdk/Controller;->timeHelper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v4}, Lnet/singular/sdk/TimeHelper;->currentTimeSeconds()J

    move-result-wide v4

    invoke-virtual {v1, v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 274
    const-string v3, "sdk_event_id"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 279
    iget-object v4, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "Event Saved: %s"

    const/4 v3, 0x1

    new-array v6, v3, [Ljava/lang/Object;

    const/4 v7, 0x0

    instance-of v3, v1, Lorg/json/JSONObject;

    if-nez v3, :cond_1

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_1
    aput-object v3, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Lnet/singular/sdk/SingularLog;->forDeveloper(Ljava/lang/String;)V

    .line 281
    new-instance v2, Lnet/singular/sdk/Controller$5;

    invoke-direct {v2, p0, v1, p2, p3}, Lnet/singular/sdk/Controller$5;-><init>(Lnet/singular/sdk/Controller;Lorg/json/JSONObject;J)V

    .line 310
    .local v2, "runnable":Ljava/lang/Runnable;
    iget-object v3, p0, Lnet/singular/sdk/Controller;->log:Lnet/singular/sdk/SingularLog;

    const-string v4, "net.singular.sdk.Controller"

    const-string v5, "postEventDelayed: posted save event runnable"

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 311
    iget-object v3, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v3, v2}, Lnet/singular/sdk/PostableWorker;->postNow(Ljava/lang/Runnable;)Z

    .line 312
    .end local v1    # "event_copy":Lorg/json/JSONObject;
    .end local v2    # "runnable":Ljava/lang/Runnable;
    :goto_2
    return-void

    .line 272
    .restart local p1    # "event":Lorg/json/JSONObject;
    :cond_0
    :try_start_1
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "event":Lorg/json/JSONObject;
    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v3

    goto :goto_0

    .line 275
    :catch_0
    move-exception v0

    .line 276
    .local v0, "e":Lorg/json/JSONException;
    const-string v3, "postEventDelayed()"

    invoke-direct {p0, v0, v3}, Lnet/singular/sdk/Controller;->logException(Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_2

    .end local v0    # "e":Lorg/json/JSONException;
    .restart local v1    # "event_copy":Lorg/json/JSONObject;
    :cond_1
    move-object v3, v1

    .line 279
    check-cast v3, Lorg/json/JSONObject;

    invoke-static {v3}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1
.end method

.method public postEventNow(Lorg/json/JSONObject;)V
    .locals 2
    .param p1, "event"    # Lorg/json/JSONObject;

    .prologue
    .line 325
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;J)V

    .line 326
    return-void
.end method

.method public setDefaultCurrency(Ljava/lang/String;)V
    .locals 1
    .param p1, "currency"    # Ljava/lang/String;

    .prologue
    .line 386
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    invoke-virtual {v0, p1}, Lnet/singular/sdk/Collector;->setCurrency(Ljava/lang/String;)V

    .line 387
    return-void
.end method

.method public setReferralId(Ljava/lang/String;)V
    .locals 2
    .param p1, "referralId"    # Ljava/lang/String;

    .prologue
    .line 397
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v0, p1, v1}, Lnet/singular/sdk/Collector;->setReferralId(Ljava/lang/String;Lnet/singular/sdk/PostableWorker;)V

    .line 398
    return-void
.end method

.method public setTemporalId(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 393
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v0, p1, p2, v1}, Lnet/singular/sdk/Collector;->setTemporalId(Ljava/lang/String;Ljava/lang/Object;Lnet/singular/sdk/PostableWorker;)Z

    .line 394
    return-void
.end method

.method public trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 438
    :try_start_0
    const-string v2, "SINGULAR_INTERNAL_DEBUG_EVENT"

    const/4 v3, 0x1

    invoke-virtual {p0, v2, v3}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 439
    .local v0, "event":Lorg/json/JSONObject;
    const-string v2, "tag"

    invoke-virtual {v0, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 440
    const-string v2, "message"

    invoke-virtual {v0, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 441
    const-string v1, ""

    .line 442
    .local v1, "stack_trace_str":Ljava/lang/String;
    if-eqz p3, :cond_0

    .line 443
    invoke-static {p3}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    .line 445
    :cond_0
    const-string v2, "exception_stacktrace"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 446
    invoke-virtual {p0, v0}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 449
    .end local v0    # "event":Lorg/json/JSONObject;
    .end local v1    # "stack_trace_str":Ljava/lang/String;
    :goto_0
    return-void

    .line 448
    :catch_0
    move-exception v2

    goto :goto_0

    .line 447
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method public trackInternalException(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 424
    :try_start_0
    const-string v1, ""

    .line 425
    .local v1, "stack_trace_str":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 426
    invoke-static {p2}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    .line 428
    :cond_0
    const-string v2, "SINGULAR_INTERNAL_EXCEPTION"

    const/4 v3, 0x1

    invoke-virtual {p0, v2, v3}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v0

    .line 429
    .local v0, "event":Lorg/json/JSONObject;
    const-string v2, "exception_message"

    invoke-virtual {v0, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 430
    const-string v2, "exception_stacktrace"

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 431
    invoke-virtual {p0, v0}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 434
    .end local v0    # "event":Lorg/json/JSONObject;
    .end local v1    # "stack_trace_str":Ljava/lang/String;
    :goto_0
    return-void

    .line 433
    :catch_0
    move-exception v2

    goto :goto_0

    .line 432
    :catch_1
    move-exception v2

    goto :goto_0
.end method

.method public unsetTemporalId(Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 404
    iget-object v0, p0, Lnet/singular/sdk/Controller;->collector:Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/Controller;->saverPostable:Lnet/singular/sdk/PostableWorker;

    invoke-virtual {v0, p1, v1}, Lnet/singular/sdk/Collector;->unsetTemporalId(Ljava/lang/String;Lnet/singular/sdk/PostableWorker;)V

    .line 405
    return-void
.end method
