.class public Lcom/igexin/sdk/action/PopupAction;
.super Ljava/lang/Object;
.source "PopupAction.java"

# interfaces
.implements Lcom/igexin/sdk/action/AbstractPushMessageAction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z
    .locals 3
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 113
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 114
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "action"

    const-string/jumbo v2, "popup"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 115
    const-string/jumbo v1, "messageId"

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 116
    const-string/jumbo v1, "taskId"

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 117
    const/high16 v1, 0x14000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 118
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "com.igexin.action.popupact."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/igexin/sdk/SdkService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 119
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v1

    const-class v2, Lcom/igexin/sdk/SdkActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 120
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/igexin/sdk/SdkService;->startActivity(Landroid/content/Intent;)V

    .line 122
    const/4 v1, 0x1

    return v1
.end method

.method public parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;
    .locals 10
    .param p1, "jsonAction"    # Lorg/json/JSONObject;

    .prologue
    .line 133
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v9

    invoke-virtual {v9}, Lcom/igexin/sdk/SdkService;->isSdkActivitySet()Z

    move-result v9

    if-eqz v9, :cond_3

    .line 136
    :try_start_0
    new-instance v6, Lcom/igexin/sdk/bean/PopupBean;

    invoke-direct {v6}, Lcom/igexin/sdk/bean/PopupBean;-><init>()V

    .line 137
    .local v6, "popupBean":Lcom/igexin/sdk/bean/PopupBean;
    const-string/jumbo v9, "type"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lcom/igexin/sdk/bean/PopupBean;->setType(Ljava/lang/String;)V

    .line 138
    const-string/jumbo v9, "actionid"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lcom/igexin/sdk/bean/PopupBean;->setActionId(Ljava/lang/String;)V

    .line 139
    const-string/jumbo v9, "do"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lcom/igexin/sdk/bean/PopupBean;->setDoActionId(Ljava/lang/String;)V

    .line 141
    const-string/jumbo v9, "title"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 142
    .local v8, "title":Ljava/lang/String;
    invoke-virtual {v6, v8}, Lcom/igexin/sdk/bean/PopupBean;->setTitle(Ljava/lang/String;)V

    .line 144
    const-string/jumbo v9, "text"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 145
    .local v7, "text":Ljava/lang/String;
    invoke-virtual {v6, v7}, Lcom/igexin/sdk/bean/PopupBean;->setContent(Ljava/lang/String;)V

    .line 147
    const-string/jumbo v9, "img"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 148
    const-string/jumbo v9, "img"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lcom/igexin/sdk/bean/PopupBean;->setImageUrl(Ljava/lang/String;)V

    .line 150
    :cond_0
    const-string/jumbo v9, "buttons"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 151
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 152
    .local v3, "buttons":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/ButtonBean;>;"
    const-string/jumbo v9, "buttons"

    invoke-virtual {p1, v9}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 153
    .local v0, "btnArray":Lorg/json/JSONArray;
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-lez v9, :cond_1

    .line 154
    const/4 v5, 0x0

    .local v5, "j":I
    :goto_0
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v9

    if-ge v5, v9, :cond_1

    .line 155
    new-instance v2, Lcom/igexin/sdk/bean/ButtonBean;

    invoke-direct {v2}, Lcom/igexin/sdk/bean/ButtonBean;-><init>()V

    .line 156
    .local v2, "buttonBean":Lcom/igexin/sdk/bean/ButtonBean;
    invoke-virtual {v0, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 157
    .local v1, "btnJsonObject":Lorg/json/JSONObject;
    const-string/jumbo v9, "text"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Lcom/igexin/sdk/bean/ButtonBean;->setText(Ljava/lang/String;)V

    .line 158
    const-string/jumbo v9, "do"

    invoke-virtual {v1, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Lcom/igexin/sdk/bean/ButtonBean;->setDoActionId(Ljava/lang/String;)V

    .line 159
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 154
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 162
    .end local v1    # "btnJsonObject":Lorg/json/JSONObject;
    .end local v2    # "buttonBean":Lcom/igexin/sdk/bean/ButtonBean;
    .end local v5    # "j":I
    :cond_1
    invoke-virtual {v6, v3}, Lcom/igexin/sdk/bean/PopupBean;->setButtons(Ljava/util/List;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 172
    .end local v0    # "btnArray":Lorg/json/JSONArray;
    .end local v3    # "buttons":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/ButtonBean;>;"
    .end local v6    # "popupBean":Lcom/igexin/sdk/bean/PopupBean;
    .end local v7    # "text":Ljava/lang/String;
    .end local v8    # "title":Ljava/lang/String;
    :cond_2
    :goto_1
    return-object v6

    .line 166
    :catch_0
    move-exception v4

    .line 168
    .local v4, "e":Lorg/json/JSONException;
    invoke-virtual {v4}, Lorg/json/JSONException;->printStackTrace()V

    .line 172
    .end local v4    # "e":Lorg/json/JSONException;
    :cond_3
    const/4 v6, 0x0

    goto :goto_1
.end method

.method public prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 15
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 41
    sget-object v14, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .local v14, "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    move-object/from16 v13, p2

    .line 43
    check-cast v13, Lcom/igexin/sdk/bean/PopupBean;

    .line 44
    .local v13, "popupBean":Lcom/igexin/sdk/bean/PopupBean;
    invoke-virtual {v13}, Lcom/igexin/sdk/bean/PopupBean;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    .line 45
    .local v5, "imgUrl":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "taskId":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v3

    .line 47
    .local v3, "messageId":Ljava/lang/String;
    invoke-virtual {v13}, Lcom/igexin/sdk/bean/PopupBean;->getActionId()Ljava/lang/String;

    move-result-object v4

    .line 49
    .local v4, "actionId":Ljava/lang/String;
    if-eqz v5, :cond_0

    const-string/jumbo v0, "http://"

    invoke-virtual {v5, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v0

    invoke-virtual {v0, v5}, Lcom/igexin/sdk/SdkService;->getDownloadImgCache(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 53
    .local v12, "img_src":Ljava/lang/String;
    const-string/jumbo v0, ""

    invoke-virtual {v12, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 55
    new-instance v6, Lcom/igexin/sdk/task/DownloadRealImageTask;

    const/4 v10, 0x1

    new-instance v0, Lcom/igexin/sdk/action/PopupAction$1;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/igexin/sdk/action/PopupAction$1;-><init>(Lcom/igexin/sdk/action/PopupAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object v7, v5

    move-object v8, v2

    move-object v9, v4

    move-object v11, v0

    invoke-direct/range {v6 .. v11}, Lcom/igexin/sdk/task/DownloadRealImageTask;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/igexin/sdk/CallbackListener;)V

    .line 93
    .local v6, "downloadRealImageTask":Lcom/igexin/sdk/task/DownloadRealImageTask;
    invoke-virtual {v6}, Lcom/igexin/sdk/task/DownloadRealImageTask;->start()V

    .line 95
    sget-object v14, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .line 102
    .end local v6    # "downloadRealImageTask":Lcom/igexin/sdk/task/DownloadRealImageTask;
    .end local v12    # "img_src":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v14

    .line 98
    .restart local v12    # "img_src":Ljava/lang/String;
    :cond_1
    invoke-virtual {v13, v12}, Lcom/igexin/sdk/bean/PopupBean;->setImg_src(Ljava/lang/String;)V

    goto :goto_0
.end method
