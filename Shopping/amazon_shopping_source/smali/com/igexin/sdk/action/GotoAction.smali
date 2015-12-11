.class public Lcom/igexin/sdk/action/GotoAction;
.super Ljava/lang/Object;
.source "GotoAction.java"

# interfaces
.implements Lcom/igexin/sdk/action/AbstractPushMessageAction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z
    .locals 2
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 37
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 38
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v0

    invoke-virtual {p2}, Lcom/igexin/sdk/bean/BaseBean;->getDoActionId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 41
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;
    .locals 3
    .param p1, "jsonAction"    # Lorg/json/JSONObject;

    .prologue
    .line 52
    :try_start_0
    new-instance v0, Lcom/igexin/sdk/bean/BaseBean;

    invoke-direct {v0}, Lcom/igexin/sdk/bean/BaseBean;-><init>()V

    .line 53
    .local v0, "baseBean":Lcom/igexin/sdk/bean/BaseBean;
    const-string/jumbo v2, "type"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/igexin/sdk/bean/BaseBean;->setType(Ljava/lang/String;)V

    .line 54
    const-string/jumbo v2, "actionid"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/igexin/sdk/bean/BaseBean;->setActionId(Ljava/lang/String;)V

    .line 55
    const-string/jumbo v2, "do"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/igexin/sdk/bean/BaseBean;->setDoActionId(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 61
    .end local v0    # "baseBean":Lcom/igexin/sdk/bean/BaseBean;
    :goto_0
    return-object v0

    .line 58
    :catch_0
    move-exception v1

    .line 59
    .local v1, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    .line 61
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 1
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 26
    sget-object v0, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    return-object v0
.end method
