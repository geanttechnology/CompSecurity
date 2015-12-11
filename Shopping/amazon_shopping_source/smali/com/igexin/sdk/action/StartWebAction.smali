.class public Lcom/igexin/sdk/action/StartWebAction;
.super Ljava/lang/Object;
.source "StartWebAction.java"

# interfaces
.implements Lcom/igexin/sdk/action/AbstractPushMessageAction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z
    .locals 4
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 42
    move-object v1, p2

    check-cast v1, Lcom/igexin/sdk/bean/StartWebBean;

    .line 44
    .local v1, "startWebBean":Lcom/igexin/sdk/bean/StartWebBean;
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 45
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 46
    const/high16 v2, 0x10000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 47
    invoke-virtual {v1}, Lcom/igexin/sdk/bean/StartWebBean;->getFinalUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 48
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/igexin/sdk/SdkService;->startActivity(Landroid/content/Intent;)V

    .line 51
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v2

    invoke-virtual {v1}, Lcom/igexin/sdk/bean/StartWebBean;->getDoActionId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, p1, v3}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 53
    const/4 v2, 0x1

    return v2
.end method

.method public parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;
    .locals 5
    .param p1, "jsonAction"    # Lorg/json/JSONObject;

    .prologue
    .line 64
    :try_start_0
    const-string/jumbo v3, "url"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 66
    .local v2, "url":Ljava/lang/String;
    const-string/jumbo v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "http://"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 67
    new-instance v1, Lcom/igexin/sdk/bean/StartWebBean;

    invoke-direct {v1}, Lcom/igexin/sdk/bean/StartWebBean;-><init>()V

    .line 68
    .local v1, "startWebBean":Lcom/igexin/sdk/bean/StartWebBean;
    const-string/jumbo v3, "type"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/igexin/sdk/bean/StartWebBean;->setType(Ljava/lang/String;)V

    .line 69
    const-string/jumbo v3, "actionid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/igexin/sdk/bean/StartWebBean;->setActionId(Ljava/lang/String;)V

    .line 70
    const-string/jumbo v3, "do"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/igexin/sdk/bean/StartWebBean;->setDoActionId(Ljava/lang/String;)V

    .line 72
    invoke-virtual {v1, v2}, Lcom/igexin/sdk/bean/StartWebBean;->setUrl(Ljava/lang/String;)V

    .line 75
    const-string/jumbo v3, "is_withcid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string/jumbo v3, "is_withcid"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "true"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 76
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/igexin/sdk/bean/StartWebBean;->setWithCid(Z)V

    .line 78
    :cond_0
    const-string/jumbo v3, "is_withnettype"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string/jumbo v3, "is_withnettype"

    invoke-virtual {p1, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "true"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 79
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/igexin/sdk/bean/StartWebBean;->setNetType(Z)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    .end local v1    # "startWebBean":Lcom/igexin/sdk/bean/StartWebBean;
    .end local v2    # "url":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object v1

    .line 83
    :catch_0
    move-exception v0

    .line 84
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 87
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 1
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 31
    sget-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    return-object v0
.end method
