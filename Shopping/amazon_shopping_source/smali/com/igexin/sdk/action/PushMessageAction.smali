.class public Lcom/igexin/sdk/action/PushMessageAction;
.super Ljava/lang/Object;
.source "PushMessageAction.java"


# static fields
.field private static instance:Lcom/igexin/sdk/action/PushMessageAction;

.field private static prepareWaitCountMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private pushMessageActionMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/igexin/sdk/action/AbstractPushMessageAction;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    .line 58
    iget-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    const-string/jumbo v1, "null"

    new-instance v2, Lcom/igexin/sdk/action/EndAction;

    invoke-direct {v2}, Lcom/igexin/sdk/action/EndAction;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    iget-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    const-string/jumbo v1, "goto"

    new-instance v2, Lcom/igexin/sdk/action/GotoAction;

    invoke-direct {v2}, Lcom/igexin/sdk/action/GotoAction;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    iget-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    const-string/jumbo v1, "notification"

    new-instance v2, Lcom/igexin/sdk/action/NotificationAction;

    invoke-direct {v2}, Lcom/igexin/sdk/action/NotificationAction;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    iget-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    const-string/jumbo v1, "popup"

    new-instance v2, Lcom/igexin/sdk/action/PopupAction;

    invoke-direct {v2}, Lcom/igexin/sdk/action/PopupAction;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    iget-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    const-string/jumbo v1, "startapp"

    new-instance v2, Lcom/igexin/sdk/action/StartAppAction;

    invoke-direct {v2}, Lcom/igexin/sdk/action/StartAppAction;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    iget-object v0, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    const-string/jumbo v1, "startweb"

    new-instance v2, Lcom/igexin/sdk/action/StartWebAction;

    invoke-direct {v2}, Lcom/igexin/sdk/action/StartWebAction;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    return-void
.end method

.method public static getInstance()Lcom/igexin/sdk/action/PushMessageAction;
    .locals 1

    .prologue
    .line 48
    sget-object v0, Lcom/igexin/sdk/action/PushMessageAction;->instance:Lcom/igexin/sdk/action/PushMessageAction;

    if-nez v0, :cond_0

    .line 49
    new-instance v0, Lcom/igexin/sdk/action/PushMessageAction;

    invoke-direct {v0}, Lcom/igexin/sdk/action/PushMessageAction;-><init>()V

    sput-object v0, Lcom/igexin/sdk/action/PushMessageAction;->instance:Lcom/igexin/sdk/action/PushMessageAction;

    .line 50
    :cond_0
    sget-object v0, Lcom/igexin/sdk/action/PushMessageAction;->instance:Lcom/igexin/sdk/action/PushMessageAction;

    return-object v0
.end method


# virtual methods
.method public doPushMessageAction(Landroid/content/Intent;)V
    .locals 27
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 72
    if-eqz p1, :cond_1

    .line 74
    :try_start_0
    const-string/jumbo v24, "vPayloadid"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 75
    .local v22, "vPayloadId":Ljava/lang/String;
    const-string/jumbo v24, "vPayload"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 77
    .local v21, "vPayload":Ljava/lang/String;
    new-instance v10, Lorg/json/JSONObject;

    move-object/from16 v0, v21

    invoke-direct {v10, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 78
    .local v10, "jsonObject":Lorg/json/JSONObject;
    const-string/jumbo v24, "vcid"

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 80
    .local v23, "vcid":Ljava/lang/String;
    sget-object v24, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v26, "Payload vcid = "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    const-string/jumbo v26, " == vcid = "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    sget-object v26, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 82
    sget-object v24, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_1

    .line 84
    const-string/jumbo v24, ":"

    move-object/from16 v0, v22

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 86
    .local v11, "masterCacheId":[Ljava/lang/String;
    array-length v0, v11

    move/from16 v24, v0

    const/16 v25, 0x2

    move/from16 v0, v24

    move/from16 v1, v25

    if-ne v0, v1, :cond_1

    .line 88
    const/16 v24, 0x0

    aget-object v12, v11, v24

    .line 89
    .local v12, "masterMessageId":Ljava/lang/String;
    const/16 v24, 0x1

    aget-object v13, v11, v24

    .line 91
    .local v13, "masterTaskId":Ljava/lang/String;
    const-string/jumbo v24, "taskid"

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    .line 92
    .local v20, "taskId":Ljava/lang/String;
    const-string/jumbo v24, "messageid"

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 93
    .local v14, "messageId":Ljava/lang/String;
    const-string/jumbo v24, "action_chains"

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 95
    .local v4, "actionChains":Ljava/lang/String;
    const/16 v24, 0x0

    move/from16 v0, v24

    invoke-static {v4, v0}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v5

    .line 97
    .local v5, "actionChainsDecode":[B
    new-instance v19, Lcom/igexin/sdk/bean/PushMessageBean;

    invoke-direct/range {v19 .. v19}, Lcom/igexin/sdk/bean/PushMessageBean;-><init>()V

    .line 98
    .local v19, "pushMessageBean":Lcom/igexin/sdk/bean/PushMessageBean;
    move-object/from16 v0, v19

    invoke-virtual {v0, v12}, Lcom/igexin/sdk/bean/PushMessageBean;->setMasterMessageId(Ljava/lang/String;)V

    .line 99
    move-object/from16 v0, v19

    invoke-virtual {v0, v13}, Lcom/igexin/sdk/bean/PushMessageBean;->setMasterTaskId(Ljava/lang/String;)V

    .line 100
    invoke-virtual/range {v19 .. v20}, Lcom/igexin/sdk/bean/PushMessageBean;->setTaskId(Ljava/lang/String;)V

    .line 101
    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Lcom/igexin/sdk/bean/PushMessageBean;->setMessageId(Ljava/lang/String;)V

    .line 104
    invoke-static {}, Lcom/igexin/sdk/ActionManager;->getInstance()Lcom/igexin/sdk/ActionManager;

    move-result-object v24

    const-string/jumbo v25, "0"

    const/16 v26, 0x0

    move-object/from16 v0, v24

    move-object/from16 v1, v19

    move-object/from16 v2, v25

    move-object/from16 v3, v26

    invoke-virtual {v0, v1, v2, v3}, Lcom/igexin/sdk/ActionManager;->feedback(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;Lcom/igexin/sdk/CallbackListener;)V

    .line 107
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, v20

    invoke-virtual {v0, v1, v14}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 108
    .local v7, "cacheId":Ljava/lang/String;
    sget-object v24, Lcom/igexin/sdk/data/BasicDataManager;->pushMessageMap:Ljava/util/Map;

    move-object/from16 v0, v24

    invoke-interface {v0, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v24

    if-nez v24, :cond_1

    .line 110
    if-eqz v5, :cond_1

    .line 112
    new-instance v6, Ljava/lang/String;

    sget-object v24, Lcom/igexin/sdk/Consts;->VPUSH_APPSECRET:Ljava/lang/String;

    move-object/from16 v0, v24

    invoke-static {v5, v0}, Lcom/igexin/sdk/encrypt/RC4Carder;->Dencrypt([BLjava/lang/String;)[B

    move-result-object v24

    const-string/jumbo v25, "UTF-8"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-direct {v6, v0, v1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 113
    .local v6, "actionChainsStr":Ljava/lang/String;
    sget-object v24, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v26, "actionChainsStr = "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 115
    const-string/jumbo v24, "payload"

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v24

    if-eqz v24, :cond_0

    .line 117
    const-string/jumbo v24, "payload"

    move-object/from16 v0, v24

    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 119
    .local v17, "payloadStr":Ljava/lang/String;
    const-string/jumbo v24, ""

    move-object/from16 v0, v17

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-nez v24, :cond_0

    .line 121
    const/16 v24, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v24

    invoke-static {v0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v16

    .line 122
    .local v16, "payloadDecode":[B
    sget-object v24, Lcom/igexin/sdk/Consts;->VPUSH_APPSECRET:Ljava/lang/String;

    move-object/from16 v0, v16

    move-object/from16 v1, v24

    invoke-static {v0, v1}, Lcom/igexin/sdk/encrypt/RC4Carder;->Dencrypt([BLjava/lang/String;)[B

    move-result-object v15

    .line 124
    .local v15, "payloadBytes":[B
    move-object/from16 v0, v19

    invoke-virtual {v0, v15}, Lcom/igexin/sdk/bean/PushMessageBean;->setPayload([B)V

    .line 126
    sget-object v24, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v26, "payloadBytes = "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    new-instance v26, Ljava/lang/String;

    move-object/from16 v0, v26

    invoke-direct {v0, v15}, Ljava/lang/String;-><init>([B)V

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 130
    .end local v15    # "payloadBytes":[B
    .end local v16    # "payloadDecode":[B
    .end local v17    # "payloadStr":Ljava/lang/String;
    :cond_0
    new-instance v9, Lorg/json/JSONArray;

    invoke-direct {v9, v6}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 133
    .local v9, "jsonArray":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v9, v1}, Lcom/igexin/sdk/action/PushMessageAction;->parsePushMessageAction(Lorg/json/JSONArray;Lcom/igexin/sdk/bean/PushMessageBean;)Z

    move-result v24

    if-eqz v24, :cond_1

    .line 136
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/action/PushMessageAction;->prepareExecutePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;

    move-result-object v18

    .line 138
    .local v18, "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    sget-object v24, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v25, Ljava/lang/StringBuilder;

    invoke-direct/range {v25 .. v25}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v26, "prepareState = "

    invoke-virtual/range {v25 .. v26}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v25

    move-object/from16 v0, v25

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v25

    invoke-virtual/range {v25 .. v25}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 140
    sget-object v24, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    move-object/from16 v0, v18

    move-object/from16 v1, v24

    if-ne v0, v1, :cond_1

    .line 143
    const-string/jumbo v24, "1"

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 154
    .end local v4    # "actionChains":Ljava/lang/String;
    .end local v5    # "actionChainsDecode":[B
    .end local v6    # "actionChainsStr":Ljava/lang/String;
    .end local v7    # "cacheId":Ljava/lang/String;
    .end local v9    # "jsonArray":Lorg/json/JSONArray;
    .end local v10    # "jsonObject":Lorg/json/JSONObject;
    .end local v11    # "masterCacheId":[Ljava/lang/String;
    .end local v12    # "masterMessageId":Ljava/lang/String;
    .end local v13    # "masterTaskId":Ljava/lang/String;
    .end local v14    # "messageId":Ljava/lang/String;
    .end local v18    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .end local v19    # "pushMessageBean":Lcom/igexin/sdk/bean/PushMessageBean;
    .end local v20    # "taskId":Ljava/lang/String;
    .end local v21    # "vPayload":Ljava/lang/String;
    .end local v22    # "vPayloadId":Ljava/lang/String;
    .end local v23    # "vcid":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void

    .line 150
    :catch_0
    move-exception v8

    .line 151
    .local v8, "e":Ljava/lang/Exception;
    invoke-virtual {v8}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z
    .locals 6
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "actionId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 247
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "executePushMessageAction = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 250
    invoke-static {}, Lcom/igexin/sdk/ActionManager;->getInstance()Lcom/igexin/sdk/ActionManager;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, p1, p2, v4}, Lcom/igexin/sdk/ActionManager;->feedback(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;Lcom/igexin/sdk/CallbackListener;)V

    .line 253
    invoke-virtual {p1, p2}, Lcom/igexin/sdk/bean/PushMessageBean;->getBean(Ljava/lang/String;)Lcom/igexin/sdk/bean/BaseBean;

    move-result-object v1

    .line 254
    .local v1, "bean":Lcom/igexin/sdk/bean/BaseBean;
    if-nez v1, :cond_1

    .line 263
    :cond_0
    :goto_0
    return v2

    .line 257
    :cond_1
    iget-object v3, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    invoke-virtual {v1}, Lcom/igexin/sdk/bean/BaseBean;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/igexin/sdk/action/AbstractPushMessageAction;

    .line 259
    .local v0, "action":Lcom/igexin/sdk/action/AbstractPushMessageAction;
    if-eqz v0, :cond_0

    .line 260
    invoke-virtual {p1, p2}, Lcom/igexin/sdk/bean/PushMessageBean;->setActionId(Ljava/lang/String;)V

    .line 261
    invoke-interface {v0, p1, v1}, Lcom/igexin/sdk/action/AbstractPushMessageAction;->executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z

    move-result v2

    goto :goto_0
.end method

.method public getPrepareWaitActionCounts(Ljava/lang/String;Z)I
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "isDecrement"    # Z

    .prologue
    .line 277
    sget-object v2, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    monitor-enter v2

    .line 279
    :try_start_0
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_0

    .line 280
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, p1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 282
    :cond_0
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 283
    .local v0, "prepareTimes":I
    if-eqz p2, :cond_1

    .line 284
    add-int/lit8 v0, v0, -0x1

    .line 285
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, p1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    if-nez v0, :cond_1

    .line 288
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 291
    :cond_1
    monitor-exit v2

    return v0

    .line 292
    .end local v0    # "prepareTimes":I
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "taskid"    # Ljava/lang/String;
    .param p2, "messageid"    # Ljava/lang/String;

    .prologue
    .line 67
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public parsePushMessageAction(Lorg/json/JSONArray;Lcom/igexin/sdk/bean/PushMessageBean;)Z
    .locals 12
    .param p1, "jsonArray"    # Lorg/json/JSONArray;
    .param p2, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;

    .prologue
    const/4 v8, 0x0

    .line 158
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 161
    .local v1, "actionChains":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/BaseBean;>;"
    :try_start_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-nez v9, :cond_1

    .line 203
    :cond_0
    :goto_0
    return v8

    .line 165
    :cond_1
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_1
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-ge v5, v9, :cond_2

    .line 167
    invoke-virtual {p1, v5}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lorg/json/JSONObject;

    .line 168
    .local v6, "jsonAction":Lorg/json/JSONObject;
    const-string/jumbo v9, "type"

    invoke-virtual {v6, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 170
    .local v7, "type":Ljava/lang/String;
    if-eqz v7, :cond_0

    .line 172
    iget-object v9, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    invoke-interface {v9, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/igexin/sdk/action/AbstractPushMessageAction;

    .line 173
    .local v0, "action":Lcom/igexin/sdk/action/AbstractPushMessageAction;
    const/4 v2, 0x0

    .line 175
    .local v2, "bean":Lcom/igexin/sdk/bean/BaseBean;
    if-eqz v0, :cond_0

    .line 177
    invoke-interface {v0, v6}, Lcom/igexin/sdk/action/AbstractPushMessageAction;->parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;

    move-result-object v2

    .line 178
    if-eqz v2, :cond_0

    .line 186
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 165
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 194
    .end local v0    # "action":Lcom/igexin/sdk/action/AbstractPushMessageAction;
    .end local v2    # "bean":Lcom/igexin/sdk/bean/BaseBean;
    .end local v6    # "jsonAction":Lorg/json/JSONObject;
    .end local v7    # "type":Ljava/lang/String;
    :cond_2
    invoke-virtual {p2, v1}, Lcom/igexin/sdk/bean/PushMessageBean;->setActionChains(Ljava/util/List;)V

    .line 195
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v9

    invoke-virtual {p2}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p2}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 196
    .local v3, "cacheId":Ljava/lang/String;
    sget-object v9, Lcom/igexin/sdk/data/BasicDataManager;->pushMessageMap:Ljava/util/Map;

    invoke-interface {v9, v3, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 203
    const/4 v8, 0x1

    goto :goto_0

    .line 198
    .end local v3    # "cacheId":Ljava/lang/String;
    .end local v5    # "i":I
    :catch_0
    move-exception v4

    .line 199
    .local v4, "e":Lorg/json/JSONException;
    invoke-virtual {v4}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public prepareExecutePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 10
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;

    .prologue
    .line 208
    sget-object v4, Lcom/igexin/sdk/Consts$ActionPrepareState;->stop:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .line 209
    .local v4, "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    const/4 v6, 0x0

    .line 211
    .local v6, "waitTimes":I
    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getActionChains()Ljava/util/List;

    move-result-object v1

    .line 212
    .local v1, "actionChains":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/BaseBean;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/igexin/sdk/bean/BaseBean;

    .line 214
    .local v2, "bean":Lcom/igexin/sdk/bean/BaseBean;
    sget-object v4, Lcom/igexin/sdk/Consts$ActionPrepareState;->stop:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .line 215
    if-nez v2, :cond_1

    move-object v5, v4

    .line 242
    .end local v2    # "bean":Lcom/igexin/sdk/bean/BaseBean;
    .end local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .local v5, "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    :goto_1
    return-object v5

    .line 218
    .end local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v2    # "bean":Lcom/igexin/sdk/bean/BaseBean;
    .restart local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    :cond_1
    iget-object v7, p0, Lcom/igexin/sdk/action/PushMessageAction;->pushMessageActionMap:Ljava/util/Map;

    invoke-virtual {v2}, Lcom/igexin/sdk/bean/BaseBean;->getType()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/igexin/sdk/action/AbstractPushMessageAction;

    .line 220
    .local v0, "action":Lcom/igexin/sdk/action/AbstractPushMessageAction;
    if-eqz v0, :cond_3

    .line 222
    invoke-interface {v0, p1, v2}, Lcom/igexin/sdk/action/AbstractPushMessageAction;->prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;

    move-result-object v4

    .line 224
    sget-object v7, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    if-ne v4, v7, :cond_2

    .line 225
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 226
    :cond_2
    sget-object v7, Lcom/igexin/sdk/Consts$ActionPrepareState;->stop:Lcom/igexin/sdk/Consts$ActionPrepareState;

    if-ne v4, v7, :cond_0

    move-object v5, v4

    .line 227
    .end local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    goto :goto_1

    .end local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    :cond_3
    move-object v5, v4

    .line 230
    .end local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    goto :goto_1

    .line 234
    .end local v0    # "action":Lcom/igexin/sdk/action/AbstractPushMessageAction;
    .end local v2    # "bean":Lcom/igexin/sdk/bean/BaseBean;
    .end local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    :cond_4
    if-eqz v6, :cond_5

    .line 236
    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    const/4 v9, 0x1

    invoke-virtual {p0, v7, v8, v9}, Lcom/igexin/sdk/action/PushMessageAction;->setPrepareWaitActionCounts(Ljava/lang/String;Ljava/lang/Integer;Z)Z

    move-result v7

    if-nez v7, :cond_6

    .line 237
    sget-object v4, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    :cond_5
    :goto_2
    move-object v5, v4

    .line 242
    .end local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    goto :goto_1

    .line 239
    .end local v5    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    .restart local v4    # "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    :cond_6
    sget-object v4, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    goto :goto_2
.end method

.method public setPrepareWaitActionCounts(Ljava/lang/String;Ljava/lang/Integer;Z)Z
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Integer;
    .param p3, "isSpecial"    # Z

    .prologue
    .line 307
    sget-object v2, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    monitor-enter v2

    .line 308
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 310
    .local v0, "prepareTimes":I
    if-eqz p3, :cond_0

    .line 311
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 312
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v3

    add-int v0, v1, v3

    .line 314
    if-nez v0, :cond_0

    .line 315
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 316
    const/4 v1, 0x0

    monitor-exit v2

    .line 322
    :goto_0
    return v1

    .line 321
    :cond_0
    sget-object v1, Lcom/igexin/sdk/action/PushMessageAction;->prepareWaitCountMap:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, p1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 322
    const/4 v1, 0x1

    monitor-exit v2

    goto :goto_0

    .line 323
    .end local v0    # "prepareTimes":I
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
