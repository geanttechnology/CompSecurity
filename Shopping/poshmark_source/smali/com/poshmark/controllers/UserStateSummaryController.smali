.class public Lcom/poshmark/controllers/UserStateSummaryController;
.super Ljava/lang/Object;
.source "UserStateSummaryController.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field static globalUserStateSummaryController:Lcom/poshmark/controllers/UserStateSummaryController;


# instance fields
.field final REFRESH_USER_STATE_SUMMARY:I

.field public delayedMessageHandler:Landroid/os/Handler;

.field private userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/controllers/UserStateSummaryController;->globalUserStateSummaryController:Lcom/poshmark/controllers/UserStateSummaryController;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/controllers/UserStateSummaryController;->REFRESH_USER_STATE_SUMMARY:I

    .line 151
    new-instance v0, Lcom/poshmark/controllers/UserStateSummaryController$2;

    invoke-direct {v0, p0}, Lcom/poshmark/controllers/UserStateSummaryController$2;-><init>(Lcom/poshmark/controllers/UserStateSummaryController;)V

    iput-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController;->delayedMessageHandler:Landroid/os/Handler;

    .line 47
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 48
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 49
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.APP_STARTED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 50
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/controllers/UserStateSummaryController;)Lcom/poshmark/data_model/models/UserStateSummary;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/controllers/UserStateSummaryController;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;

    return-object v0
.end method

.method static synthetic access$002(Lcom/poshmark/controllers/UserStateSummaryController;Lcom/poshmark/data_model/models/UserStateSummary;)Lcom/poshmark/data_model/models/UserStateSummary;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/controllers/UserStateSummaryController;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/UserStateSummary;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;

    return-object p1
.end method

.method static synthetic access$100(Lcom/poshmark/controllers/UserStateSummaryController;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/controllers/UserStateSummaryController;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/poshmark/controllers/UserStateSummaryController;->fireRecurringRefreshMessage()V

    return-void
.end method

.method private fireRecurringRefreshMessage()V
    .locals 4

    .prologue
    .line 131
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 132
    .local v0, "msg":Landroid/os/Message;
    const/4 v1, 0x0

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 133
    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 134
    iget-object v1, p0, Lcom/poshmark/controllers/UserStateSummaryController;->delayedMessageHandler:Landroid/os/Handler;

    sget v2, Lcom/poshmark/config/EnvConfig;->USER_STATE_SUMMARY_INTERVAL:I

    int-to-long v2, v2

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 135
    return-void
.end method

.method public static getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/poshmark/controllers/UserStateSummaryController;->globalUserStateSummaryController:Lcom/poshmark/controllers/UserStateSummaryController;

    if-nez v0, :cond_0

    .line 36
    new-instance v0, Lcom/poshmark/controllers/UserStateSummaryController;

    invoke-direct {v0}, Lcom/poshmark/controllers/UserStateSummaryController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/UserStateSummaryController;->globalUserStateSummaryController:Lcom/poshmark/controllers/UserStateSummaryController;

    .line 38
    :cond_0
    sget-object v0, Lcom/poshmark/controllers/UserStateSummaryController;->globalUserStateSummaryController:Lcom/poshmark/controllers/UserStateSummaryController;

    return-object v0
.end method


# virtual methods
.method public disableAllControllerNotifications()V
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController;->delayedMessageHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 139
    return-void
.end method

.method public getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 54
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 55
    invoke-virtual {p0}, Lcom/poshmark/controllers/UserStateSummaryController;->refreshModels()V

    .line 56
    invoke-direct {p0}, Lcom/poshmark/controllers/UserStateSummaryController;->fireRecurringRefreshMessage()V

    .line 66
    :cond_0
    :goto_0
    return-void

    .line 57
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 58
    invoke-virtual {p0}, Lcom/poshmark/controllers/UserStateSummaryController;->disableAllControllerNotifications()V

    goto :goto_0

    .line 59
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.APP_STARTED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController;->userStateSummary:Lcom/poshmark/data_model/models/UserStateSummary;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 62
    invoke-virtual {p0}, Lcom/poshmark/controllers/UserStateSummaryController;->refreshModels()V

    .line 63
    invoke-direct {p0}, Lcom/poshmark/controllers/UserStateSummaryController;->fireRecurringRefreshMessage()V

    goto :goto_0
.end method

.method public refreshModels()V
    .locals 1

    .prologue
    .line 71
    new-instance v0, Lcom/poshmark/controllers/UserStateSummaryController$1;

    invoke-direct {v0, p0}, Lcom/poshmark/controllers/UserStateSummaryController$1;-><init>(Lcom/poshmark/controllers/UserStateSummaryController;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getUserSummary(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 128
    return-void
.end method
