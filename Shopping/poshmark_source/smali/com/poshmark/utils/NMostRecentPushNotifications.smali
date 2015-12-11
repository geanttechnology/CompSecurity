.class public Lcom/poshmark/utils/NMostRecentPushNotifications;
.super Ljava/lang/Object;
.source "NMostRecentPushNotifications.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    }
.end annotation


# instance fields
.field MAX_PRIOTITY:I

.field VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

.field blockSize:I

.field currentSize:I

.field savedNotifications:Landroid/content/SharedPreferences;

.field stack:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    iput-object v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    .line 22
    const/4 v2, 0x4

    iput v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->blockSize:I

    .line 23
    iput v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    .line 24
    const/16 v2, 0x64

    iput v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->MAX_PRIOTITY:I

    .line 30
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "savedNotifications"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    invoke-virtual {v2, v3, v5}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    .line 32
    iget-object v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    const-string v3, "version"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 33
    .local v1, "version":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 34
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v0, v2, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    .line 35
    .local v0, "currentVersion":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 38
    iget-object v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 41
    .end local v0    # "currentVersion":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    const-string v3, "savedNotificationCount"

    invoke-interface {v2, v3, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    .line 42
    return-void
.end method

.method private addNewMessage(Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;)V
    .locals 2
    .param p1, "msg"    # Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    .line 132
    iget-object v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    if-eqz v0, :cond_0

    iget v0, p1, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    iget-object v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    iget v1, v1, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    if-lt v0, v1, :cond_1

    .line 133
    :cond_0
    iput-object p1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .line 135
    :cond_1
    return-void
.end method

.method public static clearAllSavedPushNotifications()V
    .locals 4

    .prologue
    .line 63
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "savedNotifications"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 65
    .local v0, "savedNotifications":Landroid/content/SharedPreferences;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 66
    return-void
.end method

.method private removeOldMessage(I)V
    .locals 7
    .param p1, "priority"    # I

    .prologue
    .line 112
    iget v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    iget v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->blockSize:I

    if-ne v5, v6, :cond_2

    .line 114
    iget-object v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v5}, Ljava/util/LinkedList;->size()I

    move-result v4

    .line 115
    .local v4, "size":I
    iget v2, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->MAX_PRIOTITY:I

    .line 116
    .local v2, "lowestPriorityFound":I
    const/4 v1, 0x0

    .line 117
    .local v1, "itemIndex":I
    add-int/lit8 v0, v4, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 118
    iget-object v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v5, v0}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .line 119
    .local v3, "msg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    iget v5, v3, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    if-ge v5, v2, :cond_0

    .line 120
    iget v2, v3, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    .line 121
    move v1, v0

    .line 117
    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 125
    .end local v3    # "msg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    :cond_1
    iget-object v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v5, v1}, Ljava/util/LinkedList;->remove(I)Ljava/lang/Object;

    .line 126
    iget v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    add-int/lit8 v5, v5, -0x1

    iput v5, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    .line 128
    .end local v0    # "i":I
    .end local v1    # "itemIndex":I
    .end local v2    # "lowestPriorityFound":I
    .end local v4    # "size":I
    :cond_2
    return-void
.end method


# virtual methods
.method public add(Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;)V
    .locals 2
    .param p1, "msg"    # Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .prologue
    .line 69
    iget-object v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->size()I

    move-result v0

    .line 70
    .local v0, "size":I
    iget v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->blockSize:I

    if-ne v0, v1, :cond_0

    .line 72
    iget v1, p1, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    invoke-direct {p0, v1}, Lcom/poshmark/utils/NMostRecentPushNotifications;->removeOldMessage(I)V

    .line 74
    :cond_0
    invoke-direct {p0, p1}, Lcom/poshmark/utils/NMostRecentPushNotifications;->addNewMessage(Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;)V

    .line 75
    iget v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    .line 76
    return-void
.end method

.method public flush()V
    .locals 9

    .prologue
    .line 91
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 92
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 93
    .local v1, "gson":Lcom/google/gson/Gson;
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string v7, "version"

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v8

    iget-object v8, v8, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-interface {v6, v7, v8}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 94
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string v7, "savedNotificationCount"

    iget v8, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    invoke-interface {v6, v7, v8}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 95
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    if-ge v2, v6, :cond_1

    .line 96
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v6, v2}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .line 97
    .local v4, "msg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    instance-of v6, v1, Lcom/google/gson/Gson;

    if-nez v6, :cond_0

    invoke-virtual {v1, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 98
    .local v5, "str":Ljava/lang/String;
    :goto_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Notification-"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 99
    .local v3, "key":Ljava/lang/String;
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6, v3, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 95
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .end local v3    # "key":Ljava/lang/String;
    .end local v5    # "str":Ljava/lang/String;
    :cond_0
    move-object v6, v1

    .line 97
    check-cast v6, Lcom/google/gson/Gson;

    invoke-static {v6, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 103
    .end local v4    # "msg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    :cond_1
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    if-eqz v6, :cond_2

    .line 104
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    instance-of v7, v1, Lcom/google/gson/Gson;

    if-nez v7, :cond_3

    invoke-virtual {v1, v6}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 105
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .restart local v5    # "str":Ljava/lang/String;
    :goto_2
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    invoke-interface {v6}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string v7, "VipPushNotification"

    invoke-interface {v6, v7, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 108
    .end local v5    # "str":Ljava/lang/String;
    :cond_2
    return-void

    .line 104
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_3
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_2
.end method

.method public get(I)Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 83
    iget-object v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    return v0
.end method

.method public getVIPMessage()Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    return-object v0
.end method

.method public loadAll()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 45
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 46
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 47
    .local v1, "gson":Lcom/google/gson/Gson;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->currentSize:I

    if-ge v2, v6, :cond_2

    .line 48
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Notification-"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 49
    .local v3, "key":Ljava/lang/String;
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    invoke-interface {v6, v3, v8}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 50
    .local v5, "str":Ljava/lang/String;
    const-class v7, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    instance-of v6, v1, Lcom/google/gson/Gson;

    if-nez v6, :cond_1

    invoke-virtual {v1, v5, v7}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    :goto_1
    check-cast v4, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .line 51
    .local v4, "msg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    if-eqz v4, :cond_0

    .line 52
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->stack:Ljava/util/LinkedList;

    invoke-virtual {v6, v4}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 47
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .end local v4    # "msg":Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
    :cond_1
    move-object v6, v1

    .line 50
    check-cast v6, Lcom/google/gson/Gson;

    invoke-static {v6, v5, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    goto :goto_1

    .line 56
    .end local v3    # "key":Ljava/lang/String;
    .end local v5    # "str":Ljava/lang/String;
    :cond_2
    iget-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->savedNotifications:Landroid/content/SharedPreferences;

    const-string v7, "VipPushNotification"

    invoke-interface {v6, v7, v8}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 57
    .restart local v5    # "str":Ljava/lang/String;
    if-eqz v5, :cond_3

    .line 58
    const-class v6, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    instance-of v7, v1, Lcom/google/gson/Gson;

    if-nez v7, :cond_4

    invoke-virtual {v1, v5, v6}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    .end local v1    # "gson":Lcom/google/gson/Gson;
    :goto_2
    check-cast v6, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    iput-object v6, p0, Lcom/poshmark/utils/NMostRecentPushNotifications;->VIPMessage:Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;

    .line 60
    :cond_3
    return-void

    .line 58
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_4
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v5, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_2
.end method
