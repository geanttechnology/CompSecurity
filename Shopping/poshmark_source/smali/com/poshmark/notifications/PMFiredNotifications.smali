.class public Lcom/poshmark/notifications/PMFiredNotifications;
.super Ljava/lang/Object;
.source "PMFiredNotifications.java"


# instance fields
.field firedNotifications:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/notifications/PMNotificationDetails;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/notifications/PMFiredNotifications;->firedNotifications:Ljava/util/List;

    return-void
.end method

.method private addNotification(Lcom/poshmark/notifications/PMNotificationDetails;)V
    .locals 1
    .param p1, "details"    # Lcom/poshmark/notifications/PMNotificationDetails;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/notifications/PMFiredNotifications;->firedNotifications:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 21
    return-void
.end method

.method public static cancelAllSavedNotifications()V
    .locals 9

    .prologue
    .line 72
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const-string v7, "firedNotifications"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    .line 74
    .local v4, "partyAlarms":Landroid/content/SharedPreferences;
    const-string v6, "firedNotifications"

    const/4 v7, 0x0

    invoke-interface {v4, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 75
    .local v3, "notificationsStr":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 90
    :goto_0
    return-void

    .line 78
    :cond_0
    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    .line 79
    .local v1, "gson":Lcom/google/gson/Gson;
    const/4 v5, 0x0

    .line 80
    .local v5, "savedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    const-class v6, Lcom/poshmark/notifications/PMFiredNotifications;

    instance-of v7, v1, Lcom/google/gson/Gson;

    if-nez v7, :cond_1

    invoke-virtual {v1, v3, v6}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v5

    .end local v1    # "gson":Lcom/google/gson/Gson;
    .end local v5    # "savedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    :goto_1
    check-cast v5, Lcom/poshmark/notifications/PMFiredNotifications;

    .line 82
    .restart local v5    # "savedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    iget-object v6, v5, Lcom/poshmark/notifications/PMFiredNotifications;->firedNotifications:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 83
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/PMNotificationDetails;>;"
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 84
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/notifications/PMNotificationDetails;

    .line 85
    .local v0, "details":Lcom/poshmark/notifications/PMNotificationDetails;
    iget v6, v0, Lcom/poshmark/notifications/PMNotificationDetails;->id:I

    invoke-static {v6}, Lcom/poshmark/notifications/PMNotificationManager;->cancelDelayedNotification(I)V

    goto :goto_2

    .line 80
    .end local v0    # "details":Lcom/poshmark/notifications/PMNotificationDetails;
    .end local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/PMNotificationDetails;>;"
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v3, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v5

    goto :goto_1

    .line 87
    .restart local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/notifications/PMNotificationDetails;>;"
    :cond_2
    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method public static getFiredNotifications()Lcom/poshmark/notifications/PMFiredNotifications;
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 27
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "firedNotifications"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 29
    .local v2, "partyAlarms":Landroid/content/SharedPreferences;
    const-string v4, "firedNotifications"

    invoke-interface {v2, v4, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 30
    .local v1, "notificationsStr":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 36
    :goto_0
    return-object v3

    .line 33
    :cond_0
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    .line 34
    .local v0, "gson":Lcom/google/gson/Gson;
    const/4 v3, 0x0

    .line 35
    .local v3, "savedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    const-class v4, Lcom/poshmark/notifications/PMFiredNotifications;

    instance-of v5, v0, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v0, v1, v4}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .end local v0    # "gson":Lcom/google/gson/Gson;
    .end local v3    # "savedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    :goto_1
    check-cast v3, Lcom/poshmark/notifications/PMFiredNotifications;

    .line 36
    .restart local v3    # "savedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    goto :goto_0

    .line 35
    .restart local v0    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v0, Lcom/google/gson/Gson;

    .end local v0    # "gson":Lcom/google/gson/Gson;
    invoke-static {v0, v1, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    goto :goto_1
.end method

.method public static saveFiredNotification(I)V
    .locals 9
    .param p0, "id"    # I

    .prologue
    .line 42
    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    .line 46
    .local v2, "gson":Lcom/google/gson/Gson;
    new-instance v0, Lcom/poshmark/notifications/PMNotificationDetails;

    invoke-direct {v0}, Lcom/poshmark/notifications/PMNotificationDetails;-><init>()V

    .line 47
    .local v0, "details":Lcom/poshmark/notifications/PMNotificationDetails;
    iput p0, v0, Lcom/poshmark/notifications/PMNotificationDetails;->id:I

    .line 49
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const-string v7, "firedNotifications"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 52
    .local v5, "partyAlarms":Landroid/content/SharedPreferences;
    const-string v6, "firedNotifications"

    const/4 v7, 0x0

    invoke-interface {v5, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 54
    .local v4, "notificationsStr":Ljava/lang/String;
    if-nez v4, :cond_1

    .line 56
    new-instance v1, Lcom/poshmark/notifications/PMFiredNotifications;

    invoke-direct {v1}, Lcom/poshmark/notifications/PMFiredNotifications;-><init>()V

    .line 57
    .local v1, "firedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    invoke-direct {v1, v0}, Lcom/poshmark/notifications/PMFiredNotifications;->addNotification(Lcom/poshmark/notifications/PMNotificationDetails;)V

    .line 59
    instance-of v6, v2, Lcom/google/gson/Gson;

    if-nez v6, :cond_0

    invoke-virtual {v2, v1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 60
    .local v3, "jsonRepresentation":Ljava/lang/String;
    :goto_0
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string v7, "firedNotifications"

    invoke-interface {v6, v7, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 67
    .end local v3    # "jsonRepresentation":Ljava/lang/String;
    :goto_1
    instance-of v6, v2, Lcom/google/gson/Gson;

    if-nez v6, :cond_3

    invoke-virtual {v2, v1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 68
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "jsonRepresentation":Ljava/lang/String;
    :goto_2
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string v7, "firedNotifications"

    invoke-interface {v6, v7, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 69
    return-void

    .end local v3    # "jsonRepresentation":Ljava/lang/String;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    :cond_0
    move-object v6, v2

    .line 59
    check-cast v6, Lcom/google/gson/Gson;

    invoke-static {v6, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 63
    .end local v1    # "firedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    :cond_1
    const-class v7, Lcom/poshmark/notifications/PMFiredNotifications;

    instance-of v6, v2, Lcom/google/gson/Gson;

    if-nez v6, :cond_2

    invoke-virtual {v2, v4, v7}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    :goto_3
    check-cast v1, Lcom/poshmark/notifications/PMFiredNotifications;

    .line 65
    .restart local v1    # "firedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    invoke-direct {v1, v0}, Lcom/poshmark/notifications/PMFiredNotifications;->addNotification(Lcom/poshmark/notifications/PMNotificationDetails;)V

    goto :goto_1

    .end local v1    # "firedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    :cond_2
    move-object v6, v2

    .line 63
    check-cast v6, Lcom/google/gson/Gson;

    invoke-static {v6, v4, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_3

    .line 67
    .restart local v1    # "firedNotifications":Lcom/poshmark/notifications/PMFiredNotifications;
    :cond_3
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v1}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    goto :goto_2
.end method
