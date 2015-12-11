.class public Lcom/igexin/sdk/ActionManager;
.super Ljava/lang/Object;
.source "ActionManager.java"


# static fields
.field private static instance:Lcom/igexin/sdk/ActionManager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/igexin/sdk/ActionManager;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/igexin/sdk/ActionManager;->instance:Lcom/igexin/sdk/ActionManager;

    if-nez v0, :cond_0

    .line 22
    new-instance v0, Lcom/igexin/sdk/ActionManager;

    invoke-direct {v0}, Lcom/igexin/sdk/ActionManager;-><init>()V

    sput-object v0, Lcom/igexin/sdk/ActionManager;->instance:Lcom/igexin/sdk/ActionManager;

    .line 23
    :cond_0
    sget-object v0, Lcom/igexin/sdk/ActionManager;->instance:Lcom/igexin/sdk/ActionManager;

    return-object v0
.end method


# virtual methods
.method public feedback(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;Lcom/igexin/sdk/CallbackListener;)V
    .locals 6
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "actionId"    # Ljava/lang/String;
    .param p3, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;

    .prologue
    .line 59
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 60
    .local v2, "jsonMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string/jumbo v3, "action"

    const-string/jumbo v4, "slavefeedback"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    const-string/jumbo v3, "vcid"

    sget-object v4, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    const-string/jumbo v3, "appid"

    sget-object v4, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    const-string/jumbo v3, "taskid_master"

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMasterTaskId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    const-string/jumbo v3, "message_master"

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMasterMessageId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    const-string/jumbo v3, "taskid"

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    const-string/jumbo v3, "messageid"

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    const-string/jumbo v3, "actionid"

    invoke-interface {v2, v3, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    const-string/jumbo v3, "result"

    const-string/jumbo v4, "ok"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    const-string/jumbo v3, "timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    invoke-static {v2}, Lorg/json/simple/JSONObject;->toJSONString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 73
    .local v0, "data":[B
    new-instance v1, Lcom/igexin/sdk/task/FeedbackTask;

    sget-object v3, Lcom/igexin/sdk/Consts;->PS_URL:Ljava/lang/String;

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getEncryptEnable()Z

    move-result v4

    invoke-direct {v1, v3, v0, p3, v4}, Lcom/igexin/sdk/task/FeedbackTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V

    .line 74
    .local v1, "feedbackTask":Lcom/igexin/sdk/task/FeedbackTask;
    invoke-virtual {v1}, Lcom/igexin/sdk/task/FeedbackTask;->start()V

    .line 75
    return-void
.end method

.method public getConfig(Lcom/igexin/sdk/CallbackListener;)V
    .locals 6
    .param p1, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;

    .prologue
    .line 83
    :try_start_0
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 84
    .local v3, "jsonMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string/jumbo v4, "action"

    const-string/jumbo v5, "sdkconfig"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    const-string/jumbo v4, "cid"

    sget-object v5, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    const-string/jumbo v4, "appid"

    sget-object v5, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    const-string/jumbo v4, "sdk_version"

    const-string/jumbo v5, "v1.0.0"

    invoke-interface {v3, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    invoke-static {v3}, Lorg/json/simple/JSONObject;->toJSONString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 91
    .local v0, "data":[B
    new-instance v2, Lcom/igexin/sdk/task/GetConfigTask;

    sget-object v4, Lcom/igexin/sdk/Consts;->PS_URL:Ljava/lang/String;

    invoke-direct {v2, v4, v0, p1}, Lcom/igexin/sdk/task/GetConfigTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;)V

    .line 92
    .local v2, "getConfigTask":Lcom/igexin/sdk/task/GetConfigTask;
    invoke-virtual {v2}, Lcom/igexin/sdk/task/GetConfigTask;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    .end local v0    # "data":[B
    .end local v2    # "getConfigTask":Lcom/igexin/sdk/task/GetConfigTask;
    .end local v3    # "jsonMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :goto_0
    return-void

    .line 93
    :catch_0
    move-exception v1

    .line 94
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public register(Ljava/util/List;ZZLcom/igexin/sdk/CallbackListener;)V
    .locals 5
    .param p2, "isCIDUpdate"    # Z
    .param p3, "isInfoUpdate"    # Z
    .param p4, "callbackListener"    # Lcom/igexin/sdk/CallbackListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;ZZ",
            "Lcom/igexin/sdk/CallbackListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "cids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 36
    .local v1, "dataMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string/jumbo v3, "action"

    const-string/jumbo v4, "slavebind"

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    const-string/jumbo v3, "vcid"

    sget-object v4, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    const-string/jumbo v3, "registerid"

    sget-object v4, Lcom/igexin/sdk/data/BasicDataManager;->regId:Ljava/lang/String;

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 39
    const-string/jumbo v3, "appid"

    sget-object v4, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    const-string/jumbo v3, "master_cids"

    invoke-interface {v1, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    const-string/jumbo v3, "info"

    sget-object v4, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-virtual {v4}, Lcom/igexin/sdk/data/PhoneInfo;->getJsonMap()Ljava/util/Map;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    const-string/jumbo v3, "isCIDUpdate"

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    const-string/jumbo v3, "isInfoUpdate"

    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    invoke-static {v1}, Lorg/json/simple/JSONObject;->toJSONString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 47
    .local v0, "data":[B
    new-instance v2, Lcom/igexin/sdk/task/RegisterTask;

    sget-object v3, Lcom/igexin/sdk/Consts;->PS_URL:Ljava/lang/String;

    invoke-static {}, Lcom/igexin/sdk/data/ConfigDataManager;->getEncryptEnable()Z

    move-result v4

    invoke-direct {v2, v3, v0, p4, v4}, Lcom/igexin/sdk/task/RegisterTask;-><init>(Ljava/lang/String;[BLcom/igexin/sdk/CallbackListener;Z)V

    .line 48
    .local v2, "registerTask":Lcom/igexin/sdk/task/RegisterTask;
    invoke-virtual {v2}, Lcom/igexin/sdk/task/RegisterTask;->start()V

    .line 49
    return-void
.end method
