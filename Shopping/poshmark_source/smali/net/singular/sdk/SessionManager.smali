.class Lnet/singular/sdk/SessionManager;
.super Ljava/lang/Object;
.source "SessionManager.java"


# static fields
.field public static final MILLIS_IN_SECOND:I = 0x3e8

.field public static final SESSION_MANAGER_NAMESPACE:Ljava/lang/String; = "SessionManager"


# instance fields
.field private final controller:Lnet/singular/sdk/Controller;

.field private countersLogger:Lnet/singular/sdk/CountersLogger;

.field private end_session_runnable:Ljava/lang/Runnable;

.field private is_paused:Z

.field private final key_value_store:Lnet/singular/sdk/KeyValueStore;

.field private final log:Lnet/singular/sdk/SingularLog;

.field private postable_worker:Lnet/singular/sdk/PostableWorker;

.field private session_id:Ljava/lang/String;

.field private session_pause:J

.field private session_start:J

.field private final time_helper:Lnet/singular/sdk/TimeHelper;


# direct methods
.method public constructor <init>(Lnet/singular/sdk/SingularLog;Lnet/singular/sdk/Controller;Lnet/singular/sdk/TimeHelper;Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/CountersLogger;Lnet/singular/sdk/NewInjector;)V
    .locals 2
    .param p1, "log"    # Lnet/singular/sdk/SingularLog;
    .param p2, "controller"    # Lnet/singular/sdk/Controller;
    .param p3, "timeHelper"    # Lnet/singular/sdk/TimeHelper;
    .param p4, "saverPostable"    # Lnet/singular/sdk/PostableWorker;
    .param p5, "countersLogger"    # Lnet/singular/sdk/CountersLogger;
    .param p6, "I"    # Lnet/singular/sdk/NewInjector;

    .prologue
    const/4 v1, 0x0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    .line 33
    const-string v0, "SessionManager"

    invoke-virtual {p6, v0}, Lnet/singular/sdk/NewInjector;->generateKeyValueStore(Ljava/lang/String;)Lnet/singular/sdk/KeyValueStore;

    move-result-object v0

    iput-object v0, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    .line 34
    iput-object p2, p0, Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;

    .line 35
    iput-object p3, p0, Lnet/singular/sdk/SessionManager;->time_helper:Lnet/singular/sdk/TimeHelper;

    .line 36
    iput-object p4, p0, Lnet/singular/sdk/SessionManager;->postable_worker:Lnet/singular/sdk/PostableWorker;

    .line 37
    iput-object p5, p0, Lnet/singular/sdk/SessionManager;->countersLogger:Lnet/singular/sdk/CountersLogger;

    .line 38
    const/4 v0, 0x0

    iput-boolean v0, p0, Lnet/singular/sdk/SessionManager;->is_paused:Z

    .line 39
    iput-object v1, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    .line 40
    iput-object v1, p0, Lnet/singular/sdk/SessionManager;->end_session_runnable:Ljava/lang/Runnable;

    .line 41
    return-void
.end method

.method static synthetic access$000(Lnet/singular/sdk/SessionManager;)Lnet/singular/sdk/SingularLog;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/SessionManager;

    .prologue
    .line 8
    iget-object v0, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    return-object v0
.end method

.method static synthetic access$100(Lnet/singular/sdk/SessionManager;)Lnet/singular/sdk/Controller;
    .locals 1
    .param p0, "x0"    # Lnet/singular/sdk/SessionManager;

    .prologue
    .line 8
    iget-object v0, p0, Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;

    return-object v0
.end method

.method static synthetic access$200(Lnet/singular/sdk/SessionManager;)V
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/SessionManager;

    .prologue
    .line 8
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->deleteSessionFromKeyValueStore()V

    return-void
.end method

.method static synthetic access$302(Lnet/singular/sdk/SessionManager;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lnet/singular/sdk/SessionManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 8
    iput-object p1, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    return-object p1
.end method

.method private buildAndSendSessionEndEvent()V
    .locals 2

    .prologue
    .line 85
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->buildSessionEndEvent()Lorg/json/JSONObject;

    move-result-object v0

    .line 86
    .local v0, "session_end_event":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 87
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v1, v0}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V

    .line 88
    :cond_0
    return-void
.end method

.method private buildSessionEndEvent()Lorg/json/JSONObject;
    .locals 6

    .prologue
    .line 92
    :try_start_0
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "SESSION_END"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v1

    .line 93
    .local v1, "session_end_event":Lorg/json/JSONObject;
    const-string v2, "last_session_start_s"

    iget-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_start:J

    invoke-virtual {v1, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 94
    const-string v2, "last_session_pause_s"

    iget-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_pause:J

    invoke-virtual {v1, v2, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 95
    const-string v2, "last_session_id"

    iget-object v3, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 100
    .end local v1    # "session_end_event":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 97
    :catch_0
    move-exception v0

    .line 99
    .local v0, "ignored":Lorg/json/JSONException;
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "SessionManager: buildAndSendSessionEndEvent failed"

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private deleteSessionFromKeyValueStore()V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v1, "last_session_id"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/KeyValueStore;->delete(Ljava/lang/String;)V

    .line 80
    iget-object v0, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v1, "last_session_start_s"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/KeyValueStore;->delete(Ljava/lang/String;)V

    .line 81
    iget-object v0, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v1, "last_session_pause_s"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/KeyValueStore;->delete(Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method private startNewSession()V
    .locals 5

    .prologue
    .line 105
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "startNewSession"

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v3, "session_count"

    invoke-virtual {v2, v3}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 107
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    .line 108
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->time_helper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v2}, Lnet/singular/sdk/TimeHelper;->currentTimeSeconds()J

    move-result-wide v2

    iput-wide v2, p0, Lnet/singular/sdk/SessionManager;->session_start:J

    .line 109
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lnet/singular/sdk/SessionManager;->session_pause:J

    .line 111
    :try_start_0
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;

    const-string v3, "SESSION_START"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/Controller;->initEvent(Ljava/lang/String;Z)Lorg/json/JSONObject;

    move-result-object v1

    .line 112
    .local v1, "session_start_event":Lorg/json/JSONObject;
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v2, v1}, Lnet/singular/sdk/Controller;->postEventDelayed(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 116
    .end local v1    # "session_start_event":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 113
    :catch_0
    move-exception v0

    .line 114
    .local v0, "ignored":Lorg/json/JSONException;
    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v3, "singular_sdk"

    const-string v4, "SessionManager: startNewSession failed"

    invoke-virtual {v2, v3, v4}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    return-object v0
.end method

.method public onPause()V
    .locals 6

    .prologue
    .line 119
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v2, "singular_sdk"

    const-string v3, "SessionManager: onPause"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->time_helper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v1}, Lnet/singular/sdk/TimeHelper;->currentTimeSeconds()J

    move-result-wide v2

    iput-wide v2, p0, Lnet/singular/sdk/SessionManager;->session_pause:J

    .line 121
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v2, "last_session_start_s"

    iget-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_start:J

    invoke-virtual {v1, v2, v4, v5}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;J)Z

    .line 122
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v2, "last_session_pause_s"

    iget-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_pause:J

    invoke-virtual {v1, v2, v4, v5}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;J)Z

    .line 123
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v2, "last_session_id"

    iget-object v3, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;Ljava/lang/String;)Z

    .line 124
    const/4 v1, 0x1

    iput-boolean v1, p0, Lnet/singular/sdk/SessionManager;->is_paused:Z

    .line 126
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->buildSessionEndEvent()Lorg/json/JSONObject;

    move-result-object v0

    .line 127
    .local v0, "session_end_event":Lorg/json/JSONObject;
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->postable_worker:Lnet/singular/sdk/PostableWorker;

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 128
    new-instance v1, Lnet/singular/sdk/SessionManager$1;

    invoke-direct {v1, p0, v0}, Lnet/singular/sdk/SessionManager$1;-><init>(Lnet/singular/sdk/SessionManager;Lorg/json/JSONObject;)V

    iput-object v1, p0, Lnet/singular/sdk/SessionManager;->end_session_runnable:Ljava/lang/Runnable;

    .line 142
    iget-object v1, p0, Lnet/singular/sdk/SessionManager;->postable_worker:Lnet/singular/sdk/PostableWorker;

    iget-object v2, p0, Lnet/singular/sdk/SessionManager;->end_session_runnable:Ljava/lang/Runnable;

    const-wide/32 v4, 0x2bf20

    invoke-virtual {v1, v2, v4, v5}, Lnet/singular/sdk/PostableWorker;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 145
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 11

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 44
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "SessionManager: onResume (is_paused = %b, session_id = %s)"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    iget-boolean v8, p0, Lnet/singular/sdk/SessionManager;->is_paused:Z

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    aput-object v8, v7, v9

    iget-object v8, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    aput-object v8, v7, v10

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    iget-boolean v4, p0, Lnet/singular/sdk/SessionManager;->is_paused:Z

    if-nez v4, :cond_0

    .line 49
    :try_start_0
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v5, "last_session_id"

    invoke-virtual {v4, v5}, Lnet/singular/sdk/KeyValueStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    .line 50
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v5, "last_session_start_s"

    invoke-virtual {v4, v5}, Lnet/singular/sdk/KeyValueStore;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_start:J

    .line 51
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->key_value_store:Lnet/singular/sdk/KeyValueStore;

    const-string v5, "last_session_pause_s"

    invoke-virtual {v4, v5}, Lnet/singular/sdk/KeyValueStore;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_pause:J

    .line 52
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->deleteSessionFromKeyValueStore()V
    :try_end_0
    .catch Lnet/singular/sdk/KeyNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 56
    :cond_0
    :goto_0
    iput-boolean v9, p0, Lnet/singular/sdk/SessionManager;->is_paused:Z

    .line 57
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->session_id:Ljava/lang/String;

    if-eqz v4, :cond_3

    .line 59
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->time_helper:Lnet/singular/sdk/TimeHelper;

    invoke-virtual {v4}, Lnet/singular/sdk/TimeHelper;->currentTimeSeconds()J

    move-result-wide v0

    .line 60
    .local v0, "cur_time":J
    iget-wide v4, p0, Lnet/singular/sdk/SessionManager;->session_pause:J

    sub-long v2, v0, v4

    .line 61
    .local v2, "time_since_pause":J
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "SessionManager: time_since_pause = %d"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    const-wide/16 v4, 0xb4

    cmp-long v4, v2, v4

    if-lez v4, :cond_2

    .line 63
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "SESSION_TIMEOUT exceeded!"

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->buildAndSendSessionEndEvent()V

    .line 65
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->startNewSession()V

    .line 76
    .end local v0    # "cur_time":J
    .end local v2    # "time_since_pause":J
    :cond_1
    :goto_1
    return-void

    .line 67
    .restart local v0    # "cur_time":J
    .restart local v2    # "time_since_pause":J
    :cond_2
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->end_session_runnable:Ljava/lang/Runnable;

    if-eqz v4, :cond_1

    .line 68
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->postable_worker:Lnet/singular/sdk/PostableWorker;

    iget-object v5, p0, Lnet/singular/sdk/SessionManager;->end_session_runnable:Ljava/lang/Runnable;

    invoke-virtual {v4, v5}, Lnet/singular/sdk/PostableWorker;->removeCallback(Ljava/lang/Runnable;)V

    .line 69
    const/4 v4, 0x0

    iput-object v4, p0, Lnet/singular/sdk/SessionManager;->end_session_runnable:Ljava/lang/Runnable;

    goto :goto_1

    .line 73
    .end local v0    # "cur_time":J
    .end local v2    # "time_since_pause":J
    :cond_3
    iget-object v4, p0, Lnet/singular/sdk/SessionManager;->log:Lnet/singular/sdk/SingularLog;

    const-string v5, "singular_sdk"

    const-string v6, "session_id = null, startNewSession!"

    invoke-virtual {v4, v5, v6}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    invoke-direct {p0}, Lnet/singular/sdk/SessionManager;->startNewSession()V

    goto :goto_1

    .line 53
    :catch_0
    move-exception v4

    goto :goto_0
.end method
