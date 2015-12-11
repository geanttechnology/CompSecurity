.class Lcom/igexin/sdk/action/NotificationAction$2;
.super Ljava/lang/Object;
.source "NotificationAction.java"

# interfaces
.implements Lcom/igexin/sdk/CallbackListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/igexin/sdk/action/NotificationAction;->prepareExecuteAction(Lcom/igexin/sdk/bean/PushMessageBean;Lcom/igexin/sdk/bean/BaseBean;)Lcom/igexin/sdk/Consts$ActionPrepareState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field catchId:Ljava/lang/String;

.field notificationBean:Lcom/igexin/sdk/bean/NotificationBean;

.field pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

.field final synthetic this$0:Lcom/igexin/sdk/action/NotificationAction;

.field final synthetic val$actionId:Ljava/lang/String;

.field final synthetic val$banner_url:Ljava/lang/String;

.field final synthetic val$messageId:Ljava/lang/String;

.field final synthetic val$taskId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/igexin/sdk/action/NotificationAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 121
    iput-object p1, p0, Lcom/igexin/sdk/action/NotificationAction$2;->this$0:Lcom/igexin/sdk/action/NotificationAction;

    iput-object p2, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$taskId:Ljava/lang/String;

    iput-object p3, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$messageId:Ljava/lang/String;

    iput-object p4, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$actionId:Ljava/lang/String;

    iput-object p5, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$banner_url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v0

    iget-object v1, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$taskId:Ljava/lang/String;

    iget-object v2, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$messageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/igexin/sdk/action/PushMessageAction;->getPushMessageCacheId(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/igexin/sdk/action/NotificationAction$2;->catchId:Ljava/lang/String;

    .line 124
    sget-object v0, Lcom/igexin/sdk/data/BasicDataManager;->pushMessageMap:Ljava/util/Map;

    iget-object v1, p0, Lcom/igexin/sdk/action/NotificationAction$2;->catchId:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/igexin/sdk/bean/PushMessageBean;

    iput-object v0, p0, Lcom/igexin/sdk/action/NotificationAction$2;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    .line 125
    iget-object v0, p0, Lcom/igexin/sdk/action/NotificationAction$2;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    iget-object v1, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$actionId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/igexin/sdk/bean/PushMessageBean;->getBean(Ljava/lang/String;)Lcom/igexin/sdk/bean/BaseBean;

    move-result-object v0

    check-cast v0, Lcom/igexin/sdk/bean/NotificationBean;

    iput-object v0, p0, Lcom/igexin/sdk/action/NotificationAction$2;->notificationBean:Lcom/igexin/sdk/bean/NotificationBean;

    return-void
.end method


# virtual methods
.method public exceptionHandler(Ljava/lang/Exception;)V
    .locals 4
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 151
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string/jumbo v2, "download banner img failed!"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 152
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v1

    iget-object v2, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$taskId:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/igexin/sdk/action/PushMessageAction;->getPrepareWaitActionCounts(Ljava/lang/String;Z)I

    move-result v0

    .line 153
    .local v0, "prepareTimes":I
    if-nez v0, :cond_0

    .line 155
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v1

    iget-object v2, p0, Lcom/igexin/sdk/action/NotificationAction$2;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    const-string/jumbo v3, "1"

    invoke-virtual {v1, v2, v3}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 157
    :cond_0
    return-void
.end method

.method public getCallbackData(Ljava/lang/Object;)V
    .locals 6
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 129
    move-object v1, p1

    check-cast v1, Ljava/lang/String;

    .line 131
    .local v1, "img_src":Ljava/lang/String;
    const-string/jumbo v3, ""

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 133
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 134
    .local v0, "coValues":Landroid/content/ContentValues;
    const-string/jumbo v3, "imageurl"

    iget-object v4, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$banner_url:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    const-string/jumbo v3, "imagesrc"

    invoke-virtual {v0, v3, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    const-string/jumbo v3, "taskid"

    iget-object v4, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$taskId:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const-string/jumbo v3, "createtime"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 139
    iget-object v3, p0, Lcom/igexin/sdk/action/NotificationAction$2;->notificationBean:Lcom/igexin/sdk/bean/NotificationBean;

    invoke-virtual {v3, v1}, Lcom/igexin/sdk/bean/NotificationBean;->setBanner_url_src(Ljava/lang/String;)V

    .line 140
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v3

    invoke-virtual {v3}, Lcom/igexin/sdk/SdkService;->getDBHelper()Lcom/igexin/sdk/db/DBHelper;

    move-result-object v3

    const-string/jumbo v4, "image"

    invoke-virtual {v3, v4, v0}, Lcom/igexin/sdk/db/DBHelper;->insert(Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 143
    .end local v0    # "coValues":Landroid/content/ContentValues;
    :cond_0
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v3

    iget-object v4, p0, Lcom/igexin/sdk/action/NotificationAction$2;->val$taskId:Ljava/lang/String;

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v5}, Lcom/igexin/sdk/action/PushMessageAction;->getPrepareWaitActionCounts(Ljava/lang/String;Z)I

    move-result v2

    .line 144
    .local v2, "prepareTimes":I
    if-nez v2, :cond_1

    .line 145
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v3

    iget-object v4, p0, Lcom/igexin/sdk/action/NotificationAction$2;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;

    const-string/jumbo v5, "1"

    invoke-virtual {v3, v4, v5}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 147
    :cond_1
    return-void
.end method
