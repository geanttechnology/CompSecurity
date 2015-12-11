.class public Lcom/igexin/sdk/action/StartAppAction;
.super Ljava/lang/Object;
.source "StartAppAction.java"

# interfaces
.implements Lcom/igexin/sdk/action/AbstractPushMessageAction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public broadcastPayload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V
    .locals 9
    .param p1, "taskId"    # Ljava/lang/String;
    .param p2, "messageId"    # Ljava/lang/String;
    .param p3, "appId"    # Ljava/lang/String;
    .param p4, "payload"    # [B
    .param p5, "isSelf"    # Z

    .prologue
    .line 145
    if-eqz p4, :cond_0

    .line 146
    if-eqz p5, :cond_2

    .line 148
    new-instance v4, Landroid/content/Intent;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "com.igexin.sdk.action.carrier."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v4, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 149
    .local v4, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v7

    invoke-virtual {v7, p1, p2}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 151
    .local v1, "cacheId":Ljava/lang/String;
    const-string/jumbo v7, "type"

    const/4 v8, 0x3

    invoke-virtual {v4, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 152
    const-string/jumbo v7, "payloadid"

    invoke-virtual {v4, v7, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 153
    const-string/jumbo v7, "appid"

    invoke-virtual {v4, v7, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 154
    const-string/jumbo v7, "packagename"

    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v8

    invoke-virtual {v8}, Lcom/igexin/sdk/SdkService;->getPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 156
    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    .line 157
    .local v3, "flags":Ljava/lang/Boolean;
    array-length v7, p4

    const/high16 v8, 0x10000

    if-lt v7, v8, :cond_1

    .line 159
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    .line 160
    new-instance v5, Ljava/io/ByteArrayInputStream;

    invoke-direct {v5, p4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 161
    .local v5, "is":Ljava/io/InputStream;
    const/high16 v7, 0x10000

    new-array v6, v7, [B

    .line 163
    .local v6, "payloadData":[B
    const/4 v7, 0x0

    const v8, 0xffff

    :try_start_0
    invoke-virtual {v5, v6, v7, v8}, Ljava/io/InputStream;->read([BII)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 169
    :goto_0
    const-string/jumbo v7, "payload"

    invoke-virtual {v4, v7, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 176
    .end local v5    # "is":Ljava/io/InputStream;
    .end local v6    # "payloadData":[B
    :goto_1
    const-string/jumbo v7, "datadone"

    invoke-virtual {v4, v7, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 177
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v7

    invoke-virtual {v7, v4}, Lcom/igexin/sdk/SdkService;->sendBroadcast(Landroid/content/Intent;)V

    .line 218
    .end local v1    # "cacheId":Ljava/lang/String;
    .end local v3    # "flags":Ljava/lang/Boolean;
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_0
    :goto_2
    return-void

    .line 164
    .restart local v1    # "cacheId":Ljava/lang/String;
    .restart local v3    # "flags":Ljava/lang/Boolean;
    .restart local v4    # "intent":Landroid/content/Intent;
    .restart local v5    # "is":Ljava/io/InputStream;
    .restart local v6    # "payloadData":[B
    :catch_0
    move-exception v2

    .line 166
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 173
    .end local v2    # "e":Ljava/io/IOException;
    .end local v5    # "is":Ljava/io/InputStream;
    .end local v6    # "payloadData":[B
    :cond_1
    const-string/jumbo v7, "payload"

    invoke-virtual {v4, v7, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    goto :goto_1

    .line 180
    .end local v1    # "cacheId":Ljava/lang/String;
    .end local v3    # "flags":Ljava/lang/Boolean;
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_2
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4}, Landroid/content/Intent;-><init>()V

    .line 181
    .restart local v4    # "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 182
    .local v0, "bundleT":Landroid/os/Bundle;
    const-string/jumbo v7, "action"

    const/16 v8, 0x2711

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 184
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v7

    invoke-virtual {v7, p1, p2}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 186
    .restart local v1    # "cacheId":Ljava/lang/String;
    const-string/jumbo v7, "payloadid"

    invoke-virtual {v0, v7, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    const-string/jumbo v7, "appid"

    invoke-virtual {v0, v7, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    const-string/jumbo v7, "packagename"

    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v8

    invoke-virtual {v8}, Lcom/igexin/sdk/SdkService;->getPackageName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "com.igexin.sdk.action."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 192
    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    .line 193
    .restart local v3    # "flags":Ljava/lang/Boolean;
    array-length v7, p4

    const/high16 v8, 0x10000

    if-lt v7, v8, :cond_3

    .line 195
    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    .line 196
    new-instance v5, Ljava/io/ByteArrayInputStream;

    invoke-direct {v5, p4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 197
    .restart local v5    # "is":Ljava/io/InputStream;
    const/high16 v7, 0x10000

    new-array v6, v7, [B

    .line 199
    .restart local v6    # "payloadData":[B
    const/4 v7, 0x0

    const v8, 0xffff

    :try_start_1
    invoke-virtual {v5, v6, v7, v8}, Ljava/io/InputStream;->read([BII)I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 205
    :goto_3
    const-string/jumbo v7, "payload"

    invoke-virtual {v0, v7, v6}, Landroid/os/Bundle;->putByteArray(Ljava/lang/String;[B)V

    .line 212
    .end local v5    # "is":Ljava/io/InputStream;
    .end local v6    # "payloadData":[B
    :goto_4
    const-string/jumbo v7, "datadone"

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 214
    invoke-virtual {v4, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 215
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v7

    invoke-virtual {v7, v4}, Lcom/igexin/sdk/SdkService;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 200
    .restart local v5    # "is":Ljava/io/InputStream;
    .restart local v6    # "payloadData":[B
    :catch_1
    move-exception v2

    .line 202
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 209
    .end local v2    # "e":Ljava/io/IOException;
    .end local v5    # "is":Ljava/io/InputStream;
    .end local v6    # "payloadData":[B
    :cond_3
    const-string/jumbo v7, "payload"

    invoke-virtual {v0, v7, p4}, Landroid/os/Bundle;->putByteArray(Ljava/lang/String;[B)V

    goto :goto_4
.end method

.method public executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z
    .locals 12
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 48
    if-eqz p1, :cond_2

    if-eqz p2, :cond_2

    move-object v11, p2

    .line 49
    check-cast v11, Lcom/igexin/sdk/bean/StartAppBean;

    .line 51
    .local v11, "startAppBean":Lcom/igexin/sdk/bean/StartAppBean;
    const/4 v6, 0x0

    .line 52
    .local v6, "doStartApp":Z
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/igexin/sdk/SdkService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    .line 55
    .local v9, "packageManager":Landroid/content/pm/PackageManager;
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getAppid()Ljava/lang/String;

    move-result-object v3

    .line 56
    .local v3, "startappid":Ljava/lang/String;
    const-string/jumbo v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 58
    sget-object v3, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    .line 59
    const/4 v6, 0x1

    .line 64
    :cond_0
    :goto_0
    if-eqz v6, :cond_4

    .line 65
    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getPayload()[B

    move-result-object v4

    const/4 v5, 0x1

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/igexin/sdk/action/StartAppAction;->broadcastPayload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V

    .line 67
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getIsAutoStart()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 69
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    invoke-virtual {v0}, Lcom/igexin/sdk/SdkService;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v9, v0}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v7

    .line 70
    .local v7, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/igexin/sdk/SdkService;->startActivity(Landroid/content/Intent;)V

    .line 73
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v0

    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getDoActionId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 105
    .end local v3    # "startappid":Ljava/lang/String;
    .end local v6    # "doStartApp":Z
    .end local v9    # "packageManager":Landroid/content/pm/PackageManager;
    .end local v11    # "startAppBean":Lcom/igexin/sdk/bean/StartAppBean;
    :cond_2
    :goto_1
    const/4 v0, 0x1

    return v0

    .line 60
    .restart local v3    # "startappid":Ljava/lang/String;
    .restart local v6    # "doStartApp":Z
    .restart local v9    # "packageManager":Landroid/content/pm/PackageManager;
    .restart local v11    # "startAppBean":Lcom/igexin/sdk/bean/StartAppBean;
    :cond_3
    sget-object v0, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getAppid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 61
    const/4 v6, 0x1

    goto :goto_0

    .line 76
    :cond_4
    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getPayload()[B

    move-result-object v4

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/igexin/sdk/action/StartAppAction;->broadcastPayload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V

    .line 78
    const/4 v8, 0x1

    .line 79
    .local v8, "is_done":Z
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getIsAutoStart()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 81
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/SdkService;->checkAppLauncher(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 83
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getPackageName()Ljava/lang/String;

    move-result-object v10

    .line 84
    .local v10, "packageName":Ljava/lang/String;
    invoke-virtual {v9, v10}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v7

    .line 86
    .restart local v7    # "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    invoke-virtual {v0, v7}, Lcom/igexin/sdk/SdkService;->startActivity(Landroid/content/Intent;)V

    .line 93
    .end local v7    # "intent":Landroid/content/Intent;
    .end local v10    # "packageName":Ljava/lang/String;
    :cond_5
    :goto_2
    if-eqz v8, :cond_7

    .line 94
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getDoActionId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 95
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v0

    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getDoActionId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    goto :goto_1

    .line 89
    :cond_6
    const/4 v8, 0x0

    goto :goto_2

    .line 99
    :cond_7
    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getDoUninstallId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 100
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v0

    invoke-virtual {v11}, Lcom/igexin/sdk/bean/StartAppBean;->getDoUninstallId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    goto :goto_1
.end method

.method public parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;
    .locals 4
    .param p1, "jsonAction"    # Lorg/json/JSONObject;

    .prologue
    .line 116
    :try_start_0
    new-instance v2, Lcom/igexin/sdk/bean/StartAppBean;

    invoke-direct {v2}, Lcom/igexin/sdk/bean/StartAppBean;-><init>()V

    .line 117
    .local v2, "startAppBean":Lcom/igexin/sdk/bean/StartAppBean;
    const-string/jumbo v3, "type"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setType(Ljava/lang/String;)V

    .line 118
    const-string/jumbo v3, "actionid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setActionId(Ljava/lang/String;)V

    .line 119
    const-string/jumbo v3, "do"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setDoActionId(Ljava/lang/String;)V

    .line 121
    const/4 v0, 0x0

    .line 122
    .local v0, "appname":Lorg/json/JSONObject;
    const-string/jumbo v3, "appstartupid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 123
    const-string/jumbo v3, "appstartupid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 124
    const-string/jumbo v3, "android"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setPackageName(Ljava/lang/String;)V

    .line 126
    :cond_0
    const-string/jumbo v3, "is_autostart"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 127
    const-string/jumbo v3, "is_autostart"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setIsAutoStart(Ljava/lang/String;)V

    .line 129
    :cond_1
    const-string/jumbo v3, "appid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 130
    const-string/jumbo v3, "appid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setAppid(Ljava/lang/String;)V

    .line 132
    :cond_2
    const-string/jumbo v3, "noinstall_action"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 133
    const-string/jumbo v3, "noinstall_action"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/StartAppBean;->setDoUninstallId(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 140
    .end local v0    # "appname":Lorg/json/JSONObject;
    .end local v2    # "startAppBean":Lcom/igexin/sdk/bean/StartAppBean;
    :cond_3
    :goto_0
    return-object v2

    .line 136
    :catch_0
    move-exception v1

    .line 137
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 140
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 1
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 37
    sget-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    return-object v0
.end method
