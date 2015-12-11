.class public final Lcom/inc247/bridge/ChatSDKJSToNativeBridge;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLocation(Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 235
    const-string v1, ""

    .line 237
    :try_start_0
    const-string v0, "id"

    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 238
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    if-eqz v0, :cond_0

    .line 240
    const-string v0, "true"

    const-string v2, "true"

    .line 241
    sget-object v3, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    .line 240
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v0

    .line 239
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 253
    :goto_0
    return-void

    .line 245
    :cond_0
    const-string v0, "false"

    const-string v2, "true"

    .line 246
    const-string v3, "{\'Oops!!\':\'Current Location Not Found!!Check GPS\'}"

    .line 245
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 244
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 248
    :catch_0
    move-exception v0

    .line 250
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 249
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public chatStarted(Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 66
    const-string v1, ""

    .line 68
    :try_start_0
    const-string v0, "id"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 70
    const-string v0, "true"

    const-string v2, "true"

    const-string v3, "{}"

    .line 69
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 73
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    .line 74
    const-string v2, "data"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/inc247/ChatSDKEventsCallback;->sendOnChatStartedEvent(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 81
    :goto_0
    return-void

    .line 76
    :catch_0
    move-exception v0

    .line 77
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 79
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 78
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public endChat(Lorg/json/JSONObject;)V
    .locals 3

    .prologue
    .line 119
    :try_start_0
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 120
    new-instance v1, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$2;

    invoke-direct {v1, p0}, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$2;-><init>(Lcom/inc247/bridge/ChatSDKJSToNativeBridge;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 127
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    .line 128
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 129
    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatEndedEvent(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    :goto_0
    return-void

    .line 130
    :catch_0
    move-exception v0

    .line 131
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 132
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public exec(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 38
    const-string v1, ""

    .line 40
    :try_start_0
    const-class v0, Lcom/inc247/bridge/ChatSDKJSToNativeBridge;

    .line 42
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 43
    const-string v3, "id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 44
    invoke-virtual {v2}, Lorg/json/JSONObject;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 45
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    .line 46
    const-class v5, Lorg/json/JSONObject;

    aput-object v5, v3, v4

    .line 45
    invoke-virtual {v0, p1, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 47
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v2, v3, v4

    invoke-virtual {v0, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    :goto_0
    return-void

    .line 49
    :cond_0
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Class;

    invoke-virtual {v0, p1, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 50
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 52
    :catch_0
    move-exception v0

    .line 53
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 55
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 54
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getContext(Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 170
    const-string v1, ""

    .line 172
    :try_start_0
    const-string v0, "id"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 173
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->contextInfo:Lorg/json/JSONObject;

    if-eqz v0, :cond_0

    .line 175
    const-string v0, "true"

    const-string v2, "true"

    .line 176
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v3

    iget-object v3, v3, Lcom/inc247/ChatSDK;->contextInfo:Lorg/json/JSONObject;

    .line 175
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v0

    .line 174
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 188
    :goto_0
    return-void

    .line 179
    :cond_0
    const-string v0, "false"

    const-string v2, "true"

    .line 180
    const-string v3, "{\'Error\':\'Chat has not been started yet\'}"

    .line 179
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 178
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 182
    :catch_0
    move-exception v0

    .line 183
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 185
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 184
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getQueueId(Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 200
    const-string v1, ""

    .line 202
    :try_start_0
    const-string v0, "id"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 203
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->queueIdFromAppDeveloper:Lorg/json/JSONObject;

    if-eqz v0, :cond_0

    .line 207
    const-string v0, "true"

    .line 208
    const-string v2, "true"

    .line 209
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v3

    iget-object v3, v3, Lcom/inc247/ChatSDK;->queueIdFromAppDeveloper:Lorg/json/JSONObject;

    .line 205
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 221
    :goto_0
    return-void

    .line 212
    :cond_0
    const-string v0, "false"

    const-string v2, "true"

    .line 213
    const-string v3, "{\'Error\':\'Chat has not been started yet\'}"

    .line 212
    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 211
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 215
    :catch_0
    move-exception v0

    .line 216
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 218
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 217
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public minimizeChat(Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 87
    const-string v1, ""

    .line 89
    :try_start_0
    const-string v0, "id"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 90
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 91
    new-instance v2, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$1;

    invoke-direct {v2, p0}, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$1;-><init>(Lcom/inc247/bridge/ChatSDKJSToNativeBridge;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 98
    sget-object v0, Lcom/inc247/ChatSDKResources;->CUSTOM_MINIMIZE_STATE:Ljava/lang/String;

    .line 99
    const-string v2, "false"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    const-string v0, "true"

    const-string v2, "true"

    const-string v3, "{}"

    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 100
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 112
    :goto_0
    return-void

    .line 104
    :cond_0
    const-string v0, "true"

    const-string v2, "false"

    const-string v3, "{}"

    invoke-static {v1, v0, v2, v3}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 103
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 107
    :catch_0
    move-exception v0

    .line 108
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 110
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 109
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onAgentMessage(Lorg/json/JSONObject;)V
    .locals 6

    .prologue
    .line 140
    const-string v1, ""

    .line 142
    :try_start_0
    const-string v0, "id"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 143
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 144
    new-instance v2, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$3;

    invoke-direct {v2, p0}, Lcom/inc247/bridge/ChatSDKJSToNativeBridge$3;-><init>(Lcom/inc247/bridge/ChatSDKJSToNativeBridge;)V

    invoke-virtual {v0, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 151
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    .line 152
    const-string v2, "data"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/inc247/ChatSDKEventsCallback;->sendonAgentMessageEvent(Lorg/json/JSONObject;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    :goto_0
    return-void

    .line 153
    :catch_0
    move-exception v0

    .line 154
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 156
    const-string v2, "false"

    const-string v3, "true"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "{\'Error\':\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 155
    invoke-static {v1, v2, v3, v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method
