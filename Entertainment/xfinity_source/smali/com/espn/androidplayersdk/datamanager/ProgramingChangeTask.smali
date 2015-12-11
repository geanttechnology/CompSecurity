.class Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;
.super Ljava/lang/Object;
.source "ProgramingChangeTask.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# instance fields
.field final defaultInterval:I

.field private didProgramChanged:Z

.field epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

.field epPlaybackManagerListener:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

.field epStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

.field feedsManager:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

.field pollingInterval:I

.field private poolingTaskCancelled:Z

.field programingChangeTask:Ljava/lang/Runnable;

.field programingChangeTaskHandler:Landroid/os/Handler;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPStream;Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;Landroid/os/Handler;Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;)V
    .locals 1
    .param p1, "epStream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;
    .param p2, "playbackInterface"    # Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "epPlaybackManager"    # Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    .prologue
    const/4 v0, 0x0

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->didProgramChanged:Z

    .line 35
    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->poolingTaskCancelled:Z

    .line 36
    iput v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    .line 37
    const v0, 0xea60

    iput v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->defaultInterval:I

    .line 96
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask$1;-><init>(Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    .line 40
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->feedsManager:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    .line 41
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    .line 42
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epPlaybackManagerListener:Lcom/espn/androidplayersdk/playbackmanager/EPPlaybackManagerListener;

    .line 43
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    .line 44
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    .line 45
    return-void
.end method


# virtual methods
.method cancel()V
    .locals 2

    .prologue
    .line 84
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->poolingTaskCancelled:Z

    .line 85
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 86
    return-void
.end method

.method didProgramChanged()Z
    .locals 1

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->didProgramChanged:Z

    return v0
.end method

.method getPollingInterval()I
    .locals 3

    .prologue
    .line 61
    :try_start_0
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiConfigPoolingInterval()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    mul-int/lit16 v1, v1, 0x3e8

    .line 65
    :goto_0
    return v1

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Unable to retrive polling interval. Setting to default"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 65
    const v1, 0xea60

    goto :goto_0
.end method

.method public handleError(I)V
    .locals 4
    .param p1, "errorCode"    # I

    .prologue
    .line 136
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 137
    return-void
.end method

.method monitorProgramingChange()V
    .locals 6

    .prologue
    .line 51
    :try_start_0
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->getPollingInterval()I

    move-result v1

    iput v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    .line 52
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    iget v3, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    int-to-long v4, v3

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 56
    :goto_0
    return-void

    .line 53
    :catch_0
    move-exception v0

    .line 54
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "checkForProgramingChange"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method parseEvent(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 3
    .param p1, "obj"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 146
    const-string v2, "listings"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 147
    const-string v2, "listings"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 148
    .local v1, "listing":Lorg/json/JSONArray;
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 149
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 150
    .local v0, "eventObj":Lorg/json/JSONObject;
    const-string v2, "id"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 151
    const-string v2, "id"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 154
    .end local v0    # "eventObj":Lorg/json/JSONObject;
    .end local v1    # "listing":Lorg/json/JSONArray;
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method resetProgramChangedFlag()V
    .locals 1

    .prologue
    .line 93
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->didProgramChanged:Z

    .line 94
    return-void
.end method

.method update(Lcom/espn/androidplayersdk/datamanager/EPStream;)V
    .locals 4
    .param p1, "epStream"    # Lcom/espn/androidplayersdk/datamanager/EPStream;

    .prologue
    .line 70
    iget-boolean v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->didProgramChanged:Z

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 74
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    .line 75
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    iget v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 80
    :cond_0
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 142
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 6
    .param p1, "object"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 112
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->parseEvent(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v1

    .line 113
    .local v1, "id":Ljava/lang/String;
    if-eqz v1, :cond_1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 116
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->getInstance()Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->trackEventConcluded()V

    .line 117
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->didProgramChanged:Z

    .line 118
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epPlaybackManager:Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;

    invoke-virtual {v2, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlaybackManager;->initiateStartSessionRequest(Ljava/lang/String;)V

    .line 132
    .end local v1    # "id":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 120
    .restart local v1    # "id":Ljava/lang/String;
    :cond_1
    iget-boolean v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->poolingTaskCancelled:Z

    if-nez v2, :cond_0

    .line 123
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    iget v4, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    int-to-long v4, v4

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 127
    .end local v1    # "id":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 128
    .local v0, "e":Lorg/json/JSONException;
    const-string v2, "URL encoding failed"

    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 130
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTaskHandler:Landroid/os/Handler;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->programingChangeTask:Ljava/lang/Runnable;

    iget v4, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->pollingInterval:I

    int-to-long v4, v4

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method
