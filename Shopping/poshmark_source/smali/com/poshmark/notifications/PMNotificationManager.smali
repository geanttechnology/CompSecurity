.class public Lcom/poshmark/notifications/PMNotificationManager;
.super Ljava/lang/Object;
.source "PMNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    }
.end annotation


# static fields
.field static listeners:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/poshmark/notifications/PMNotificationListener;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;",
            ">;>;"
        }
    .end annotation
.end field

.field static notificationManager:Lcom/poshmark/notifications/PMNotificationManager;


# instance fields
.field alarmBroadcastReceiver:Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/notifications/PMNotificationManager;->notificationManager:Lcom/poshmark/notifications/PMNotificationManager;

    .line 48
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;

    invoke-direct {v0}, Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;-><init>()V

    iput-object v0, p0, Lcom/poshmark/notifications/PMNotificationManager;->alarmBroadcastReceiver:Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;

    .line 52
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/notifications/PMNotificationManager;->alarmBroadcastReceiver:Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "com.poshmark.intents.PARTY_ALARM"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 53
    return-void
.end method

.method public static cancelDelayedNotification(I)V
    .locals 5
    .param p0, "id"    # I

    .prologue
    .line 129
    new-instance v1, Landroid/content/Intent;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const-class v4, Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 130
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "com.poshmark.intents.PARTY_ALARM"

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 132
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const/high16 v4, 0x10000000

    invoke-static {v3, p0, v1, v4}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    .line 133
    .local v2, "pendingIntent":Landroid/app/PendingIntent;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "alarm"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 134
    .local v0, "alarmManager":Landroid/app/AlarmManager;
    invoke-virtual {v0, v2}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 135
    return-void
.end method

.method public static fireDelayedNotification(Ljava/lang/String;Landroid/os/Bundle;J)V
    .locals 8
    .param p0, "pmIntent"    # Ljava/lang/String;
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "timeInMilli"    # J

    .prologue
    .line 114
    new-instance v3, Landroid/content/Intent;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/poshmark/notifications/PMPartyAlarmBroadcastReciever;

    invoke-direct {v3, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 115
    .local v3, "intent":Landroid/content/Intent;
    const-string v5, "FRAGMENT_DATA"

    invoke-virtual {v3, v5, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 116
    invoke-virtual {v3, p0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 118
    new-instance v1, Ljava/util/Random;

    invoke-direct {v1}, Ljava/util/Random;-><init>()V

    .line 119
    .local v1, "generator":Ljava/util/Random;
    invoke-virtual {v1}, Ljava/util/Random;->nextInt()I

    move-result v2

    .line 120
    .local v2, "id":I
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const/high16 v6, 0x10000000

    invoke-static {v5, v2, v3, v6}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v4

    .line 121
    .local v4, "pendingIntent":Landroid/app/PendingIntent;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    const-string v6, "alarm"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 122
    .local v0, "alarmManager":Landroid/app/AlarmManager;
    const/4 v5, 0x0

    invoke-virtual {v0, v5, p2, p3, v4}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 125
    invoke-static {v2}, Lcom/poshmark/notifications/PMFiredNotifications;->saveFiredNotification(I)V

    .line 126
    return-void
.end method

.method public static fireNotification(Ljava/lang/String;)V
    .locals 2
    .param p0, "intent"    # Ljava/lang/String;

    .prologue
    .line 102
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 103
    .local v0, "i":Landroid/content/Intent;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 104
    return-void
.end method

.method public static fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 2
    .param p0, "intent"    # Ljava/lang/String;
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 107
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 108
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "RESULT"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 109
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 110
    return-void
.end method

.method public static getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/poshmark/notifications/PMNotificationManager;->notificationManager:Lcom/poshmark/notifications/PMNotificationManager;

    if-nez v0, :cond_0

    .line 28
    new-instance v0, Lcom/poshmark/notifications/PMNotificationManager;

    invoke-direct {v0}, Lcom/poshmark/notifications/PMNotificationManager;-><init>()V

    sput-object v0, Lcom/poshmark/notifications/PMNotificationManager;->notificationManager:Lcom/poshmark/notifications/PMNotificationManager;

    .line 30
    :cond_0
    sget-object v0, Lcom/poshmark/notifications/PMNotificationManager;->notificationManager:Lcom/poshmark/notifications/PMNotificationManager;

    return-object v0
.end method


# virtual methods
.method public registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V
    .locals 4
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/poshmark/notifications/PMNotificationListener;

    .prologue
    .line 56
    sget-object v2, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 58
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 59
    .local v1, "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    new-instance v0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;

    invoke-direct {v0, p0, p2}, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;-><init>(Lcom/poshmark/notifications/PMNotificationManager;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 60
    .local v0, "reciever":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v2

    new-instance v3, Landroid/content/IntentFilter;

    invoke-direct {v3, p1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0, v3}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 62
    sget-object v2, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    .end local v0    # "reciever":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    :cond_0
    :goto_0
    return-void

    .line 65
    .end local v1    # "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    :cond_1
    sget-object v2, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 66
    .restart local v1    # "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 67
    new-instance v0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;

    invoke-direct {v0, p0, p2}, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;-><init>(Lcom/poshmark/notifications/PMNotificationManager;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 68
    .restart local v0    # "reciever":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v2

    new-instance v3, Landroid/content/IntentFilter;

    invoke-direct {v3, p1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0, v3}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 69
    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public unRegisterForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V
    .locals 3
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "listener"    # Lcom/poshmark/notifications/PMNotificationListener;

    .prologue
    .line 75
    sget-object v2, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 76
    sget-object v2, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 77
    .local v1, "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;

    .line 78
    .local v0, "rcvr":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    if-eqz v0, :cond_0

    .line 79
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 80
    invoke-interface {v1, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    .end local v0    # "rcvr":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    .end local v1    # "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    :cond_0
    return-void
.end method

.method public unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V
    .locals 5
    .param p1, "listener"    # Lcom/poshmark/notifications/PMNotificationListener;

    .prologue
    .line 87
    sget-object v4, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 88
    sget-object v4, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    .line 89
    .local v3, "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    .line 90
    .local v0, "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 91
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 92
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;

    .line 93
    .local v2, "rcvr":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 94
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 96
    .end local v2    # "rcvr":Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;
    :cond_0
    sget-object v4, Lcom/poshmark/notifications/PMNotificationManager;->listeners:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    .end local v0    # "collection":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    .end local v3    # "registeredEventsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationManager$PMBroadcastReciever;>;"
    :cond_1
    return-void
.end method
