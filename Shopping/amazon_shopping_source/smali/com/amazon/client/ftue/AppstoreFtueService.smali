.class public Lcom/amazon/client/ftue/AppstoreFtueService;
.super Landroid/app/IntentService;
.source "AppstoreFtueService.java"


# static fields
.field private static final FTUE_SEND_DELAY:Ljava/lang/Long;

.field private static final LOG:Lcom/amazon/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    const-class v0, Lcom/amazon/client/ftue/AppstoreFtueService;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    .line 54
    const-wide/16 v0, 0x7530

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    sput-object v0, Lcom/amazon/client/ftue/AppstoreFtueService;->FTUE_SEND_DELAY:Ljava/lang/Long;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/amazon/client/ftue/AppstoreFtueService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 61
    return-void
.end method

.method private getDelayedPendingIntent()Landroid/app/PendingIntent;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 104
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/amazon/client/ftue/AppstoreFtueService;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string/jumbo v2, "com.amazon.mas.client.startup.ftue.SEND_FTUE"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 105
    .local v0, "delayFtue":Landroid/content/Intent;
    invoke-static {p0, v3, v0, v3}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    return-object v1
.end method

.method private getFtueSharedPrefs()Landroid/content/SharedPreferences;
    .locals 2

    .prologue
    .line 114
    const-string/jumbo v0, "appstore_ftue"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/client/ftue/AppstoreFtueService;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method private reset(Landroid/content/Intent;)V
    .locals 5
    .param p1, "originalIntent"    # Landroid/content/Intent;

    .prologue
    .line 146
    const-string/jumbo v2, "com.amazon.mas.client.authentication.key.DIRECTEDID"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 147
    .local v0, "directedId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 148
    sget-object v2, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v3, "Null account directedId encountered"

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->e(Ljava/lang/String;)V

    .line 166
    :goto_0
    return-void

    .line 152
    :cond_0
    const-string/jumbo v2, "com.amazon.mas.client.authentication.key.DEREGISTERED_ACCOUNT_IS_PRIMARY"

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 154
    .local v1, "isPrimaryAccount":Z
    if-nez v1, :cond_1

    .line 155
    sget-object v2, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v3, "secondary account deregistration encountered, ignoring"

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    goto :goto_0

    .line 159
    :cond_1
    sget-object v2, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v3, "primary account deregistration encountered, clearing shared prefs"

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 162
    invoke-direct {p0}, Lcom/amazon/client/ftue/AppstoreFtueService;->getFtueSharedPrefs()Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string/jumbo v3, "appstore_ftue_encountered"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 165
    invoke-direct {p0}, Lcom/amazon/client/ftue/AppstoreFtueService;->getFtueSharedPrefs()Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string/jumbo v3, "appstore_ftue_clear_webview_cache"

    const/4 v4, 0x1

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method private sendFtueBroadcast(Landroid/content/SharedPreferences;)V
    .locals 6
    .param p1, "prefs"    # Landroid/content/SharedPreferences;

    .prologue
    .line 126
    invoke-direct {p0}, Lcom/amazon/client/ftue/AppstoreFtueService;->getDelayedPendingIntent()Landroid/app/PendingIntent;

    move-result-object v2

    .line 127
    .local v2, "pendingFtue":Landroid/app/PendingIntent;
    const-string/jumbo v3, "alarm"

    invoke-virtual {p0, v3}, Lcom/amazon/client/ftue/AppstoreFtueService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 128
    .local v0, "am":Landroid/app/AlarmManager;
    invoke-virtual {v0, v2}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 129
    invoke-virtual {v2}, Landroid/app/PendingIntent;->cancel()V

    .line 132
    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string/jumbo v4, "appstore_ftue_encountered"

    const/4 v5, 0x1

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 134
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v3, "com.amazon.mas.client.application.events.APPSTORE_FTUE"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 135
    .local v1, "ftueBroadcast":Landroid/content/Intent;
    new-instance v3, Lcom/amazon/mas/client/security/broadcast/SecureBroadcastManager;

    invoke-direct {v3, p0}, Lcom/amazon/mas/client/security/broadcast/SecureBroadcastManager;-><init>(Landroid/content/Context;)V

    invoke-virtual {v3, v1}, Lcom/amazon/mas/client/security/broadcast/SecureBroadcastManager;->sendBroadcast(Landroid/content/Intent;)V

    .line 136
    sget-object v3, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v4, "sent broadcast: com.amazon.mas.client.application.events.APPSTORE_FTUE"

    invoke-virtual {v3, v4}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 137
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 9
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 69
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v4, "com.amazon.mas.client.startup.ftue.RESET"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 72
    invoke-direct {p0, p1}, Lcom/amazon/client/ftue/AppstoreFtueService;->reset(Landroid/content/Intent;)V

    .line 96
    :goto_0
    return-void

    .line 76
    :cond_0
    invoke-direct {p0}, Lcom/amazon/client/ftue/AppstoreFtueService;->getFtueSharedPrefs()Landroid/content/SharedPreferences;

    move-result-object v3

    .line 77
    .local v3, "prefs":Landroid/content/SharedPreferences;
    const-string/jumbo v4, "appstore_ftue_encountered"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 78
    sget-object v4, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v5, "request to send FTUE broadcast ignored as we\'ve already broadcast it"

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    goto :goto_0

    .line 82
    :cond_1
    const-string/jumbo v4, "com.amazon.mas.client.startup.ftue.FORCED_FTUE"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 83
    sget-object v4, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v5, "sending broadcast immediately"

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 84
    invoke-direct {p0, v3}, Lcom/amazon/client/ftue/AppstoreFtueService;->sendFtueBroadcast(Landroid/content/SharedPreferences;)V

    goto :goto_0

    .line 85
    :cond_2
    const-string/jumbo v4, "com.amazon.mas.client.startup.ftue.DELAYED_FTUE"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 86
    invoke-direct {p0}, Lcom/amazon/client/ftue/AppstoreFtueService;->getDelayedPendingIntent()Landroid/app/PendingIntent;

    move-result-object v2

    .line 87
    .local v2, "pendingFtue":Landroid/app/PendingIntent;
    const-string/jumbo v4, "alarm"

    invoke-virtual {p0, v4}, Lcom/amazon/client/ftue/AppstoreFtueService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/AlarmManager;

    .line 88
    .local v1, "am":Landroid/app/AlarmManager;
    const/4 v4, 0x3

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v5

    sget-object v7, Lcom/amazon/client/ftue/AppstoreFtueService;->FTUE_SEND_DELAY:Ljava/lang/Long;

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    add-long/2addr v5, v7

    invoke-virtual {v1, v4, v5, v6, v2}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 89
    sget-object v4, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "sending broadcast in "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lcom/amazon/client/ftue/AppstoreFtueService;->FTUE_SEND_DELAY:Ljava/lang/Long;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "ms"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    goto :goto_0

    .line 90
    .end local v1    # "am":Landroid/app/AlarmManager;
    .end local v2    # "pendingFtue":Landroid/app/PendingIntent;
    :cond_3
    const-string/jumbo v4, "com.amazon.mas.client.startup.ftue.SEND_FTUE"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 91
    sget-object v4, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v5, "finished delay, sending FTUE broadcast"

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 92
    invoke-direct {p0, v3}, Lcom/amazon/client/ftue/AppstoreFtueService;->sendFtueBroadcast(Landroid/content/SharedPreferences;)V

    goto/16 :goto_0

    .line 94
    :cond_4
    sget-object v4, Lcom/amazon/client/ftue/AppstoreFtueService;->LOG:Lcom/amazon/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "unexpected action received: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
