.class Lnet/singular/sdk/SingularLog;
.super Ljava/lang/Object;
.source "SingularLog.java"


# static fields
.field private static final LOG_TO_CONSOLE:Z


# instance fields
.field private controller:Lnet/singular/sdk/Controller;

.field private countersLogger:Lnet/singular/sdk/CountersLogger;

.field private logsKeeper:Lnet/singular/sdk/LogsKeeper;

.field private outputToDeveloper:Z


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-boolean v0, p0, Lnet/singular/sdk/SingularLog;->outputToDeveloper:Z

    return-void
.end method

.method private trackInternalException(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 126
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/SingularLog;->countersLogger:Lnet/singular/sdk/CountersLogger;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lnet/singular/sdk/SingularLog;->countersLogger:Lnet/singular/sdk/CountersLogger;

    const-string v1, "exception_count"

    invoke-virtual {v0, v1}, Lnet/singular/sdk/CountersLogger;->increaseCounter(Ljava/lang/String;)J

    .line 129
    :cond_0
    iget-object v0, p0, Lnet/singular/sdk/SingularLog;->controller:Lnet/singular/sdk/Controller;

    if-eqz v0, :cond_1

    .line 130
    iget-object v0, p0, Lnet/singular/sdk/SingularLog;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v0, p1, p2}, Lnet/singular/sdk/Controller;->trackInternalException(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 133
    :cond_1
    :goto_0
    return-void

    .line 132
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method protected addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 6
    .param p1, "level"    # Ljava/lang/String;
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 137
    :try_start_0
    iget-object v4, p0, Lnet/singular/sdk/SingularLog;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    if-eqz v4, :cond_1

    .line 138
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_1

    .line 140
    .local v1, "line":Lorg/json/JSONObject;
    :try_start_1
    new-instance v4, Lnet/singular/sdk/TimeHelper;

    invoke-direct {v4}, Lnet/singular/sdk/TimeHelper;-><init>()V

    invoke-virtual {v4}, Lnet/singular/sdk/TimeHelper;->currentTimeSeconds()J

    move-result-wide v2

    .line 141
    .local v2, "timestamp_s":J
    const-string v4, "event_timestamp_s"

    invoke-virtual {v1, v4, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 142
    const-string v4, "id"

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 143
    const-string v4, "level"

    invoke-virtual {v1, v4, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 144
    const-string v4, "tag"

    invoke-virtual {v1, v4, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 145
    const-string v4, "message"

    invoke-virtual {v1, v4, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 146
    if-eqz p4, :cond_0

    .line 147
    const-string v4, "stacktrace"

    invoke-static {p4}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 149
    :cond_0
    iget-object v4, p0, Lnet/singular/sdk/SingularLog;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    invoke-virtual {v4, v1}, Lnet/singular/sdk/LogsKeeper;->addLine(Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    .line 155
    .end local v1    # "line":Lorg/json/JSONObject;
    .end local v2    # "timestamp_s":J
    :cond_1
    :goto_0
    return-void

    .line 150
    .restart local v1    # "line":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .local v0, "ignored":Lorg/json/JSONException;
    goto :goto_0

    .line 154
    .end local v0    # "ignored":Lorg/json/JSONException;
    .end local v1    # "line":Lorg/json/JSONObject;
    :catch_1
    move-exception v4

    goto :goto_0
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 55
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 56
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 51
    const-string v0, "d"

    invoke-virtual {p0, v0, p1, p2, p3}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 52
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 76
    const-string v0, "e"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, p2, v1}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 77
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 83
    const-string v0, "e"

    invoke-virtual {p0, v0, p1, p2, p3}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 84
    return-void
.end method

.method public forDeveloper(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 87
    iget-boolean v0, p0, Lnet/singular/sdk/SingularLog;->outputToDeveloper:Z

    if-eqz v0, :cond_0

    .line 88
    const-string v0, "singular_sdk"

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    :cond_0
    return-void
.end method

.method public i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 62
    const-string v0, "i"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, p2, v1}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 63
    return-void
.end method

.method public initialize(Lnet/singular/sdk/ManifestHelper;)V
    .locals 2
    .param p1, "manifestHelper"    # Lnet/singular/sdk/ManifestHelper;

    .prologue
    .line 20
    const-string v0, "net.singular.verbose"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Lnet/singular/sdk/ManifestHelper;->tryToGetManifestAttributeBool(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lnet/singular/sdk/SingularLog;->outputToDeveloper:Z

    .line 22
    return-void
.end method

.method public setController(Lnet/singular/sdk/Controller;)V
    .locals 0
    .param p1, "controller"    # Lnet/singular/sdk/Controller;

    .prologue
    .line 25
    iput-object p1, p0, Lnet/singular/sdk/SingularLog;->controller:Lnet/singular/sdk/Controller;

    .line 26
    return-void
.end method

.method public setCountersLogger(Lnet/singular/sdk/CountersLogger;)V
    .locals 0
    .param p1, "countersLogger"    # Lnet/singular/sdk/CountersLogger;

    .prologue
    .line 33
    iput-object p1, p0, Lnet/singular/sdk/SingularLog;->countersLogger:Lnet/singular/sdk/CountersLogger;

    .line 34
    return-void
.end method

.method public setLogsKeeper(Lnet/singular/sdk/LogsKeeper;)V
    .locals 0
    .param p1, "logsKeeper"    # Lnet/singular/sdk/LogsKeeper;

    .prologue
    .line 29
    iput-object p1, p0, Lnet/singular/sdk/SingularLog;->logsKeeper:Lnet/singular/sdk/LogsKeeper;

    .line 30
    return-void
.end method

.method public trackError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 93
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 94
    return-void
.end method

.method public trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 98
    if-eqz p3, :cond_0

    .line 99
    :try_start_0
    invoke-virtual {p0, p1, p2, p3}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 103
    :goto_0
    invoke-direct {p0, p2, p3}, Lnet/singular/sdk/SingularLog;->trackInternalException(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 104
    const-string v0, "trackError"

    invoke-virtual {p0, v0, p1, p2, p3}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 106
    :goto_1
    return-void

    .line 101
    :cond_0
    invoke-virtual {p0, p1, p2}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 105
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 109
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lnet/singular/sdk/SingularLog;->trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 110
    return-void
.end method

.method public trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 117
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/SingularLog;->controller:Lnet/singular/sdk/Controller;

    if-eqz v0, :cond_0

    .line 118
    iget-object v0, p0, Lnet/singular/sdk/SingularLog;->controller:Lnet/singular/sdk/Controller;

    invoke-virtual {v0, p1, p2, p3}, Lnet/singular/sdk/Controller;->trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 119
    const-string v0, "trackInternalDebugEvent"

    invoke-virtual {p0, v0, p1, p2, p3}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 121
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public v(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 69
    const-string v0, "v"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, p2, v1}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 70
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 40
    const-string v0, "w"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p1, p2, v1}, Lnet/singular/sdk/SingularLog;->addToLogKeeper(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 41
    return-void
.end method
