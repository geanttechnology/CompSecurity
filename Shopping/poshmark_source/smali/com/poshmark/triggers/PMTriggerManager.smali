.class public Lcom/poshmark/triggers/PMTriggerManager;
.super Ljava/lang/Object;
.source "PMTriggerManager.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field private static triggerManager:Lcom/poshmark/triggers/PMTriggerManager;


# instance fields
.field brandShareTrigger:Lcom/poshmark/triggers/BrandShareTrigger;

.field rateAppTrigger:Lcom/poshmark/triggers/RateAppTrigger;

.field savedTriggers:Landroid/content/SharedPreferences;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Lcom/poshmark/triggers/BrandShareTrigger;

    invoke-direct {v0}, Lcom/poshmark/triggers/BrandShareTrigger;-><init>()V

    iput-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->brandShareTrigger:Lcom/poshmark/triggers/BrandShareTrigger;

    .line 32
    new-instance v0, Lcom/poshmark/triggers/RateAppTrigger;

    invoke-direct {v0}, Lcom/poshmark/triggers/RateAppTrigger;-><init>()V

    iput-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->rateAppTrigger:Lcom/poshmark/triggers/RateAppTrigger;

    .line 37
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 38
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 39
    return-void
.end method

.method public static declared-synchronized getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;
    .locals 2

    .prologue
    .line 23
    const-class v1, Lcom/poshmark/triggers/PMTriggerManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/poshmark/triggers/PMTriggerManager;->triggerManager:Lcom/poshmark/triggers/PMTriggerManager;

    if-nez v0, :cond_0

    .line 24
    new-instance v0, Lcom/poshmark/triggers/PMTriggerManager;

    invoke-direct {v0}, Lcom/poshmark/triggers/PMTriggerManager;-><init>()V

    sput-object v0, Lcom/poshmark/triggers/PMTriggerManager;->triggerManager:Lcom/poshmark/triggers/PMTriggerManager;

    .line 26
    :cond_0
    sget-object v0, Lcom/poshmark/triggers/PMTriggerManager;->triggerManager:Lcom/poshmark/triggers/PMTriggerManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 23
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public getBrandShareTrigger()Lcom/poshmark/triggers/BrandShareTrigger;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->brandShareTrigger:Lcom/poshmark/triggers/BrandShareTrigger;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->brandShareTrigger:Lcom/poshmark/triggers/BrandShareTrigger;

    .line 46
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getRateAppTrigger()Lcom/poshmark/triggers/RateAppTrigger;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->rateAppTrigger:Lcom/poshmark/triggers/RateAppTrigger;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->rateAppTrigger:Lcom/poshmark/triggers/RateAppTrigger;

    .line 54
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 60
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->brandShareTrigger:Lcom/poshmark/triggers/BrandShareTrigger;

    invoke-virtual {v0}, Lcom/poshmark/triggers/BrandShareTrigger;->fetchTriggerFromPrefs()V

    .line 63
    iget-object v0, p0, Lcom/poshmark/triggers/PMTriggerManager;->rateAppTrigger:Lcom/poshmark/triggers/RateAppTrigger;

    invoke-virtual {v0}, Lcom/poshmark/triggers/RateAppTrigger;->fetchTriggerFromPrefs()V

    .line 67
    :cond_0
    :goto_0
    return-void

    .line 64
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0
.end method
