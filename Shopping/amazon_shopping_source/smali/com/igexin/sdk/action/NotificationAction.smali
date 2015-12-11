.class public Lcom/igexin/sdk/action/NotificationAction;
.super Ljava/lang/Object;
.source "NotificationAction.java"

# interfaces
.implements Lcom/igexin/sdk/action/AbstractPushMessageAction;


# static fields
.field public static notificationMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/igexin/sdk/action/NotificationAction;->notificationMap:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getPendingIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/app/PendingIntent;
    .locals 6
    .param p1, "taskId"    # Ljava/lang/String;
    .param p2, "messageId"    # Ljava/lang/String;
    .param p3, "actionId"    # Ljava/lang/String;

    .prologue
    .line 359
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v3, "com.igexin.sdk.action.doaction"

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 360
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v3, "taskid"

    invoke-virtual {v0, v3, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 361
    const-string/jumbo v3, "messageid"

    invoke-virtual {v0, v3, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 362
    const-string/jumbo v3, "appid"

    sget-object v4, Lcom/igexin/sdk/Consts;->VPUSH_APPID:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 363
    const-string/jumbo v3, "actionid"

    invoke-virtual {v0, v3, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 364
    const-string/jumbo v3, "accesstoken"

    sget-object v4, Lcom/igexin/sdk/data/BasicDataManager;->internalBroadcastAccessToken:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 366
    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    .line 367
    .local v2, "random":Ljava/util/Random;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v3

    const/16 v4, 0x3e8

    invoke-virtual {v2, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v4

    const/high16 v5, 0x8000000

    invoke-static {v3, v4, v0, v5}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 370
    .local v1, "pendingIntent":Landroid/app/PendingIntent;
    return-object v1
.end method


# virtual methods
.method public executeAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Z
    .locals 2
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 181
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    instance-of v0, p2, Lcom/igexin/sdk/bean/NotificationBean;

    if-eqz v0, :cond_0

    .line 182
    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v1

    check-cast p2, Lcom/igexin/sdk/bean/NotificationBean;

    .end local p2    # "baseBean":Lcom/igexin/sdk/bean/BaseBean;
    invoke-virtual {p0, v0, v1, p2}, Lcom/igexin/sdk/action/NotificationAction;->showNotification(Ljava/lang/String;Ljava/lang/String;Lcom/igexin/sdk/bean/NotificationBean;)V

    .line 185
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public parseAction(Lorg/json/JSONObject;)Lcom/igexin/sdk/bean/BaseBean;
    .locals 8
    .param p1, "jsonAction"    # Lorg/json/JSONObject;

    .prologue
    const/4 v7, -0x1

    .line 196
    :try_start_0
    new-instance v2, Lcom/igexin/sdk/bean/NotificationBean;

    invoke-direct {v2}, Lcom/igexin/sdk/bean/NotificationBean;-><init>()V

    .line 197
    .local v2, "notificationBean":Lcom/igexin/sdk/bean/NotificationBean;
    const-string/jumbo v5, "type"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setType(Ljava/lang/String;)V

    .line 198
    const-string/jumbo v5, "actionid"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setActionId(Ljava/lang/String;)V

    .line 199
    const-string/jumbo v5, "do"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setDoActionId(Ljava/lang/String;)V

    .line 201
    const-string/jumbo v5, "title"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 202
    .local v4, "title":Ljava/lang/String;
    const-string/jumbo v5, "text"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 203
    .local v3, "text":Ljava/lang/String;
    invoke-virtual {v2, v4}, Lcom/igexin/sdk/bean/NotificationBean;->setTitle(Ljava/lang/String;)V

    .line 204
    invoke-virtual {v2, v3}, Lcom/igexin/sdk/bean/NotificationBean;->setContent(Ljava/lang/String;)V

    .line 206
    const-string/jumbo v5, "logo"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 207
    const-string/jumbo v5, "logo"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, ".png"

    invoke-virtual {v5, v6}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v5

    if-ne v5, v7, :cond_0

    const-string/jumbo v5, "logo"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, ".jpeg"

    invoke-virtual {v5, v6}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v5

    if-eq v5, v7, :cond_8

    .line 208
    :cond_0
    const-string/jumbo v5, "logo"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, ".png"

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 209
    .local v1, "indexoflogo":I
    if-ne v1, v7, :cond_1

    .line 210
    const-string/jumbo v5, "logo"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, ".jpeg"

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 212
    :cond_1
    const-string/jumbo v5, "logo"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setLogo(Ljava/lang/String;)V

    .line 218
    .end local v1    # "indexoflogo":I
    :cond_2
    :goto_0
    const-string/jumbo v5, "logo_url"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    const-string/jumbo v5, "logo_url"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "http"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 219
    const-string/jumbo v5, "logo_url"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setUrl_logo(Ljava/lang/String;)V

    .line 222
    :cond_3
    const-string/jumbo v5, "banner_url"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    const-string/jumbo v5, "banner_url"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "http"

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 223
    const-string/jumbo v5, "banner_url"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setBanner_url(Ljava/lang/String;)V

    .line 226
    :cond_4
    const-string/jumbo v5, "is_noclear"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 227
    const-string/jumbo v5, "is_noclear"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setIs_noclear(Z)V

    .line 230
    :cond_5
    const-string/jumbo v5, "is_novibrate"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 231
    const-string/jumbo v5, "is_novibrate"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setIs_novibrate(Z)V

    .line 234
    :cond_6
    const-string/jumbo v5, "is_noring"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 235
    const-string/jumbo v5, "is_noring"

    invoke-virtual {p1, v5}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setIs_noring(Z)V

    .line 243
    .end local v2    # "notificationBean":Lcom/igexin/sdk/bean/NotificationBean;
    .end local v3    # "text":Ljava/lang/String;
    .end local v4    # "title":Ljava/lang/String;
    :cond_7
    :goto_1
    return-object v2

    .line 214
    .restart local v2    # "notificationBean":Lcom/igexin/sdk/bean/NotificationBean;
    .restart local v3    # "text":Ljava/lang/String;
    .restart local v4    # "title":Ljava/lang/String;
    :cond_8
    const-string/jumbo v5, "null"

    invoke-virtual {v2, v5}, Lcom/igexin/sdk/bean/NotificationBean;->setLogo(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 240
    .end local v2    # "notificationBean":Lcom/igexin/sdk/bean/NotificationBean;
    .end local v3    # "text":Ljava/lang/String;
    .end local v4    # "title":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 241
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 243
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
    .locals 23
    .param p1, "pushMessageBean"    # Lcom/igexin/sdk/bean/PushMessageBean;
    .param p2, "baseBean"    # Lcom/igexin/sdk/bean/BaseBean;

    .prologue
    .line 48
    sget-object v21, Lcom/igexin/sdk/Consts$ActionPrepareState;->success:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .local v21, "prepareState":Lcom/igexin/sdk/Consts$ActionPrepareState;
    move-object/from16 v20, p2

    .line 50
    check-cast v20, Lcom/igexin/sdk/bean/NotificationBean;

    .line 51
    .local v20, "notificationBean":Lcom/igexin/sdk/bean/NotificationBean;
    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/bean/NotificationBean;->getUrl_logo()Ljava/lang/String;

    move-result-object v7

    .line 52
    .local v7, "logo_url":Ljava/lang/String;
    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/bean/NotificationBean;->getBanner_url()Ljava/lang/String;

    move-result-object v14

    .line 53
    .local v14, "banner_url":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getTaskId()Ljava/lang/String;

    move-result-object v4

    .line 54
    .local v4, "taskId":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lcom/igexin/sdk/bean/PushMessageBean;->getMessageId()Ljava/lang/String;

    move-result-object v5

    .line 55
    .local v5, "messageId":Ljava/lang/String;
    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/bean/NotificationBean;->getActionId()Ljava/lang/String;

    move-result-object v6

    .line 57
    .local v6, "actionId":Ljava/lang/String;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string/jumbo v3, "notification"

    const-string/jumbo v9, "layout"

    sget-object v10, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    invoke-virtual {v2, v3, v9, v10}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v22

    .line 59
    .local v22, "resID_layout":I
    if-eqz v22, :cond_1

    .line 61
    if-eqz v7, :cond_0

    .line 63
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2, v7}, Lcom/igexin/sdk/SdkService;->getDownloadImgCache(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 65
    .local v19, "img_src":Ljava/lang/String;
    const-string/jumbo v2, ""

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 66
    new-instance v8, Lcom/igexin/sdk/task/DownloadRealImageTask;

    const/4 v12, 0x2

    new-instance v2, Lcom/igexin/sdk/action/NotificationAction$1;

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lcom/igexin/sdk/action/NotificationAction$1;-><init>(Lcom/igexin/sdk/action/NotificationAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object v9, v7

    move-object v10, v4

    move-object v11, v6

    move-object v13, v2

    invoke-direct/range {v8 .. v13}, Lcom/igexin/sdk/task/DownloadRealImageTask;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/igexin/sdk/CallbackListener;)V

    .line 105
    .local v8, "downloadRealImageTask":Lcom/igexin/sdk/task/DownloadRealImageTask;
    invoke-virtual {v8}, Lcom/igexin/sdk/task/DownloadRealImageTask;->start()V

    .line 107
    sget-object v21, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .line 114
    .end local v8    # "downloadRealImageTask":Lcom/igexin/sdk/task/DownloadRealImageTask;
    .end local v19    # "img_src":Ljava/lang/String;
    :cond_0
    :goto_0
    if-eqz v14, :cond_1

    .line 116
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2, v14}, Lcom/igexin/sdk/SdkService;->getDownloadImgCache(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 118
    .restart local v19    # "img_src":Ljava/lang/String;
    const-string/jumbo v2, ""

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 120
    new-instance v8, Lcom/igexin/sdk/task/DownloadRealImageTask;

    const/16 v17, 0x3

    new-instance v9, Lcom/igexin/sdk/action/NotificationAction$2;

    move-object/from16 v10, p0

    move-object v11, v4

    move-object v12, v5

    move-object v13, v6

    invoke-direct/range {v9 .. v14}, Lcom/igexin/sdk/action/NotificationAction$2;-><init>(Lcom/igexin/sdk/action/NotificationAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object v13, v8

    move-object v15, v4

    move-object/from16 v16, v6

    move-object/from16 v18, v9

    invoke-direct/range {v13 .. v18}, Lcom/igexin/sdk/task/DownloadRealImageTask;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/igexin/sdk/CallbackListener;)V

    .line 159
    .restart local v8    # "downloadRealImageTask":Lcom/igexin/sdk/task/DownloadRealImageTask;
    invoke-virtual {v8}, Lcom/igexin/sdk/task/DownloadRealImageTask;->start()V

    .line 161
    sget-object v21, Lcom/igexin/sdk/Consts$ActionPrepareState;->wait:Lcom/igexin/sdk/Consts$ActionPrepareState;

    .line 169
    .end local v8    # "downloadRealImageTask":Lcom/igexin/sdk/task/DownloadRealImageTask;
    .end local v19    # "img_src":Ljava/lang/String;
    :cond_1
    :goto_1
    return-object v21

    .line 110
    .restart local v19    # "img_src":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/bean/NotificationBean;->setUrl_logo_src(Ljava/lang/String;)V

    goto :goto_0

    .line 164
    :cond_3
    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/bean/NotificationBean;->setBanner_url_src(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public showNotification(Ljava/lang/String;Ljava/lang/String;Lcom/igexin/sdk/bean/NotificationBean;)V
    .locals 24
    .param p1, "taskId"    # Ljava/lang/String;
    .param p2, "messageId"    # Ljava/lang/String;
    .param p3, "notificationBean"    # Lcom/igexin/sdk/bean/NotificationBean;

    .prologue
    .line 247
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/SdkService;->getPackageName()Ljava/lang/String;

    move-result-object v15

    .line 248
    .local v15, "pkgName":Ljava/lang/String;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v20

    move-wide/from16 v0, v20

    long-to-int v11, v0

    .line 249
    .local v11, "notifID":I
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getDoActionId()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, v20

    invoke-direct {v0, v1, v2, v3}, Lcom/igexin/sdk/action/NotificationAction;->getPendingIntent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/app/PendingIntent;

    move-result-object v14

    .line 251
    .local v14, "pendingIntent":Landroid/app/PendingIntent;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    const-string/jumbo v21, "notification"

    invoke-virtual/range {v20 .. v21}, Lcom/igexin/sdk/SdkService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/app/NotificationManager;

    .line 252
    .local v13, "notificationManager":Landroid/app/NotificationManager;
    new-instance v12, Landroid/app/Notification;

    invoke-direct {v12}, Landroid/app/Notification;-><init>()V

    .line 253
    .local v12, "notification":Landroid/app/Notification;
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getContent()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    iput-object v0, v12, Landroid/app/Notification;->tickerText:Ljava/lang/CharSequence;

    .line 254
    const/16 v20, 0x4

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->defaults:I

    .line 256
    const v20, -0xff0100

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->ledARGB:I

    .line 257
    const/16 v20, 0x3e8

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->ledOnMS:I

    .line 258
    const/16 v20, 0xbb8

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->ledOffMS:I

    .line 259
    const/16 v20, 0x1

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->flags:I

    .line 261
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->isIs_noclear()Z

    move-result v20

    if-nez v20, :cond_4

    .line 262
    iget v0, v12, Landroid/app/Notification;->flags:I

    move/from16 v20, v0

    or-int/lit8 v20, v20, 0x10

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->flags:I

    .line 265
    :goto_0
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->isIs_noring()Z

    move-result v20

    if-nez v20, :cond_0

    .line 266
    iget v0, v12, Landroid/app/Notification;->defaults:I

    move/from16 v20, v0

    or-int/lit8 v20, v20, 0x1

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->defaults:I

    .line 267
    :cond_0
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->isIs_novibrate()Z

    move-result v20

    if-nez v20, :cond_1

    .line 268
    iget v0, v12, Landroid/app/Notification;->defaults:I

    move/from16 v20, v0

    or-int/lit8 v20, v20, 0x2

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->defaults:I

    .line 271
    :cond_1
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const-string/jumbo v21, "push"

    const-string/jumbo v22, "drawable"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v17

    .line 274
    .local v17, "resID_defaultlogo":I
    const-string/jumbo v20, "null"

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getLogo()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_a

    .line 276
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getLogo()Ljava/lang/String;

    move-result-object v20

    const-string/jumbo v21, "@"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_7

    .line 277
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getLogo()Ljava/lang/String;

    move-result-object v8

    .line 278
    .local v8, "logo":Ljava/lang/String;
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v7

    .line 279
    .local v7, "index":I
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v8, v0, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    .line 280
    const-string/jumbo v20, "email"

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v20

    if-eqz v20, :cond_5

    .line 281
    const v20, 0x108008f

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->icon:I

    .line 309
    .end local v7    # "index":I
    .end local v8    # "logo":Ljava/lang/String;
    :goto_1
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const-string/jumbo v21, "notification"

    const-string/jumbo v22, "layout"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v19

    .line 311
    .local v19, "resID_layout":I
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getBanner_url()Ljava/lang/String;

    move-result-object v20

    if-nez v20, :cond_2

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getUrl_logo()Ljava/lang/String;

    move-result-object v20

    if-eqz v20, :cond_3

    :cond_2
    if-nez v19, :cond_c

    .line 314
    :cond_3
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getTitle()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getContent()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v12, v0, v1, v2, v14}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 354
    :goto_2
    invoke-virtual {v13, v11, v12}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 355
    return-void

    .line 264
    .end local v17    # "resID_defaultlogo":I
    .end local v19    # "resID_layout":I
    :cond_4
    iget v0, v12, Landroid/app/Notification;->flags:I

    move/from16 v20, v0

    or-int/lit8 v20, v20, 0x20

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->flags:I

    goto/16 :goto_0

    .line 283
    .restart local v7    # "index":I
    .restart local v8    # "logo":Ljava/lang/String;
    .restart local v17    # "resID_defaultlogo":I
    :cond_5
    if-eqz v17, :cond_6

    .line 284
    move/from16 v0, v17

    iput v0, v12, Landroid/app/Notification;->icon:I

    goto :goto_1

    .line 286
    :cond_6
    const v20, 0x1080093

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->icon:I

    goto :goto_1

    .line 290
    .end local v7    # "index":I
    .end local v8    # "logo":Ljava/lang/String;
    :cond_7
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getLogo()Ljava/lang/String;

    move-result-object v21

    const-string/jumbo v22, "drawable"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v9

    .line 291
    .local v9, "logo_ID":I
    if-eqz v9, :cond_8

    .line 292
    iput v9, v12, Landroid/app/Notification;->icon:I

    goto :goto_1

    .line 294
    :cond_8
    if-eqz v17, :cond_9

    .line 295
    move/from16 v0, v17

    iput v0, v12, Landroid/app/Notification;->icon:I

    goto :goto_1

    .line 297
    :cond_9
    const v20, 0x1080093

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->icon:I

    goto/16 :goto_1

    .line 302
    .end local v9    # "logo_ID":I
    :cond_a
    if-eqz v17, :cond_b

    .line 303
    move/from16 v0, v17

    iput v0, v12, Landroid/app/Notification;->icon:I

    goto/16 :goto_1

    .line 305
    :cond_b
    const v20, 0x1080093

    move/from16 v0, v20

    iput v0, v12, Landroid/app/Notification;->icon:I

    goto/16 :goto_1

    .line 318
    .restart local v19    # "resID_layout":I
    :cond_c
    new-instance v20, Landroid/widget/RemoteViews;

    move-object/from16 v0, v20

    move/from16 v1, v19

    invoke-direct {v0, v15, v1}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    move-object/from16 v0, v20

    iput-object v0, v12, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 319
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const-string/jumbo v21, "notification_icon"

    const-string/jumbo v22, "id"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v18

    .line 320
    .local v18, "resID_icon":I
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    const-string/jumbo v21, "notification_background"

    const-string/jumbo v22, "id"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v16

    .line 321
    .local v16, "resID_background":I
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getUrl_logo_src()Ljava/lang/String;

    move-result-object v10

    .line 322
    .local v10, "logo_url_src":Ljava/lang/String;
    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getBanner_url_src()Ljava/lang/String;

    move-result-object v4

    .line 324
    .local v4, "banner_url_src":Ljava/lang/String;
    const/4 v6, 0x0

    .line 326
    .local v6, "img_result":Z
    if-eqz v10, :cond_d

    .line 327
    invoke-static {v10}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 328
    .local v5, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v5, :cond_d

    .line 329
    iget-object v0, v12, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move/from16 v1, v18

    invoke-virtual {v0, v1, v5}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 330
    const/4 v6, 0x1

    .line 334
    .end local v5    # "bitmap":Landroid/graphics/Bitmap;
    :cond_d
    if-nez v6, :cond_e

    .line 335
    iget-object v0, v12, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    move-object/from16 v20, v0

    iget v0, v12, Landroid/app/Notification;->icon:I

    move/from16 v21, v0

    move-object/from16 v0, v20

    move/from16 v1, v18

    move/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setImageViewResource(II)V

    .line 338
    :cond_e
    if-eqz v4, :cond_f

    .line 339
    invoke-static {v4}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 340
    .restart local v5    # "bitmap":Landroid/graphics/Bitmap;
    if-eqz v5, :cond_f

    .line 341
    iget-object v0, v12, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move/from16 v1, v16

    invoke-virtual {v0, v1, v5}, Landroid/widget/RemoteViews;->setImageViewBitmap(ILandroid/graphics/Bitmap;)V

    .line 345
    .end local v5    # "bitmap":Landroid/graphics/Bitmap;
    :cond_f
    iget-object v0, v12, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    move-object/from16 v20, v0

    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const-string/jumbo v22, "notification_title"

    const-string/jumbo v23, "id"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v21

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getTitle()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v20 .. v22}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 347
    iget-object v0, v12, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    move-object/from16 v20, v0

    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    const-string/jumbo v22, "notification_name"

    const-string/jumbo v23, "id"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v21

    invoke-virtual/range {p3 .. p3}, Lcom/igexin/sdk/bean/NotificationBean;->getContent()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v20 .. v22}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 350
    iput-object v14, v12, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    goto/16 :goto_2
.end method
