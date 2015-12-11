.class public Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;
.super Landroid/content/BroadcastReceiver;
.source "PMPartyAlarmBroadcastReciever.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 24
    return-void
.end method

.method private fireNotification(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "PMIntent"    # Ljava/lang/String;
    .param p3, "title"    # Ljava/lang/String;

    .prologue
    .line 56
    new-instance v5, Landroid/app/Notification$Builder;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v5, v6}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    const v6, 0x7f0200b3

    invoke-virtual {v5, v6}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v5

    const-string v6, "Poshmark"

    invoke-virtual {v5, v6}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " party is starting!"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v0

    .line 63
    .local v0, "mBuilder":Landroid/app/Notification$Builder;
    new-instance v4, Landroid/content/Intent;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/poshmark/ui/PmNotificationRecieverActivity;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 64
    .local v4, "resultIntent":Landroid/content/Intent;
    const-string v5, "NOTIFICATION_BUNDLE"

    invoke-virtual {v4, v5, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 66
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const/4 v6, 0x0

    const/high16 v7, 0x10000000

    invoke-static {v5, v6, v4, v7}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 68
    .local v3, "pIntent":Landroid/app/PendingIntent;
    invoke-virtual {v0, v3}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    .line 70
    invoke-virtual {v0}, Landroid/app/Notification$Builder;->getNotification()Landroid/app/Notification;

    move-result-object v2

    .line 71
    .local v2, "notification":Landroid/app/Notification;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "notification"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationManager;

    .line 75
    .local v1, "mNotificationManager":Landroid/app/NotificationManager;
    iget v5, v2, Landroid/app/Notification;->flags:I

    or-int/lit8 v5, v5, 0x10

    iput v5, v2, Landroid/app/Notification;->flags:I

    .line 76
    sget v5, Lcom/poshmark/application/PMApplication;->PARTY_START_NOTIFICATION_ID:I

    invoke-virtual {v1, v5, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 77
    return-void
.end method

.method private preparePartyBundle(Landroid/content/Intent;)Landroid/os/Bundle;
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 44
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 45
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "FRAGMENT_DATA"

    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 46
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "intentType":Ljava/lang/String;
    const-string v2, "com.poshmark.intents.PARTY_ALARM"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 48
    const-string v2, "FRAGMENT"

    const-class v3, Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 50
    :cond_0
    const-string v2, "TYPE"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 52
    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 29
    const-string v4, "FRAGMENT_DATA"

    invoke-virtual {p2, v4}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 30
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "PARTY_TITLE"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 31
    .local v2, "partyTitle":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;->preparePartyBundle(Landroid/content/Intent;)Landroid/os/Bundle;

    move-result-object v1

    .line 33
    .local v1, "notificationBundle":Landroid/os/Bundle;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplication;->getTopActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v3

    .line 34
    .local v3, "topActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v4

    if-nez v4, :cond_1

    .line 35
    :cond_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v1, v4, v2}, Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;->fireNotification(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    :goto_0
    return-void

    .line 38
    :cond_1
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/poshmark/controllers/GlobalPartiesController;->firePartyAlert(Landroid/os/Bundle;)V

    goto :goto_0
.end method
