.class public Lcom/livemixtapes/GCMIntentService;
.super Lcom/google/android/gcm/GCMBaseIntentService;
.source "GCMIntentService.java"


# static fields
.field public static final DISPLAY_MESSAGE_ACTION:Ljava/lang/String; = "com.livemixtapes.DISPLAY_MESSAGE"

.field public static final EXTRA_MESSAGE:Ljava/lang/String; = "message"

.field public static final SENDER_ID:Ljava/lang/String; = "663004151835"

.field private static final TAG:Ljava/lang/String; = "LiveMixTapes"


# instance fields
.field ctx:Landroid/content/Context;

.field mRegisterTask:Landroid/os/AsyncTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/AsyncTask",
            "<",
            "Ljava/lang/Void;",
            "Ljava/lang/Void;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 35
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "663004151835"

    aput-object v2, v0, v1

    invoke-direct {p0, v0}, Lcom/google/android/gcm/GCMBaseIntentService;-><init>([Ljava/lang/String;)V

    .line 36
    return-void
.end method

.method private static capitalize(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 137
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    .line 138
    :cond_0
    const-string p0, ""

    .line 144
    .end local p0    # "s":Ljava/lang/String;
    .local v0, "first":C
    :cond_1
    :goto_0
    return-object p0

    .line 140
    .end local v0    # "first":C
    .restart local p0    # "s":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 141
    .restart local v0    # "first":C
    invoke-static {v0}, Ljava/lang/Character;->isUpperCase(C)Z

    move-result v1

    if-nez v1, :cond_1

    .line 144
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method private static generateNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "mixtapeId"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x0

    .line 102
    const v0, 0x7f02005b

    .line 103
    .local v0, "icon":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 105
    .local v6, "when":J
    const-string v8, "notification"

    invoke-virtual {p0, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 104
    check-cast v4, Landroid/app/NotificationManager;

    .line 106
    .local v4, "notificationManager":Landroid/app/NotificationManager;
    new-instance v2, Landroid/app/Notification;

    invoke-direct {v2, v0, p1, v6, v7}, Landroid/app/Notification;-><init>(ILjava/lang/CharSequence;J)V

    .line 107
    .local v2, "notification":Landroid/app/Notification;
    const v8, 0x7f0a003a

    invoke-virtual {p0, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 108
    .local v5, "title":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    const-class v8, Lcom/livemixtapes/MainActivity;

    invoke-direct {v3, p0, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 109
    .local v3, "notificationIntent":Landroid/content/Intent;
    const-string v8, "message"

    invoke-virtual {v3, v8, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 110
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_0

    .line 111
    const-string v8, "mixtapeId"

    invoke-virtual {v3, v8, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 113
    :cond_0
    const/high16 v8, 0x24000000

    invoke-virtual {v3, v8}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 116
    const/high16 v8, 0x8000000

    .line 115
    invoke-static {p0, v10, v3, v8}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 117
    .local v1, "intent":Landroid/app/PendingIntent;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, " sent you a message"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, p0, v8, p1, v1}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 120
    const/4 v8, -0x1

    iput v8, v2, Landroid/app/Notification;->defaults:I

    .line 121
    iget v8, v2, Landroid/app/Notification;->flags:I

    or-int/lit8 v8, v8, 0x10

    iput v8, v2, Landroid/app/Notification;->flags:I

    .line 122
    invoke-virtual {v4, v10, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 124
    return-void
.end method

.method public static getDeviceName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 127
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 128
    .local v0, "manufacturer":Ljava/lang/String;
    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 129
    .local v1, "model":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 130
    invoke-static {v1}, Lcom/livemixtapes/GCMIntentService;->capitalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 132
    :goto_0
    return-object v2

    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Lcom/livemixtapes/GCMIntentService;->capitalize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method


# virtual methods
.method protected onDeletedMessages(Landroid/content/Context;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "total"    # I

    .prologue
    .line 86
    const-string v0, "LiveMixTapes"

    const-string v1, "Received deleted messages notification"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 87
    return-void
.end method

.method public onError(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 91
    const-string v0, "LiveMixTapes"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Received error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 92
    return-void
.end method

.method protected onMessage(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 76
    const-string v2, "LiveMixTapes"

    const-string v3, "Received message"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 77
    const-string v2, "Nithin"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "YYY"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    const-string v5, "message"

    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 78
    iput-object p1, p0, Lcom/livemixtapes/GCMIntentService;->ctx:Landroid/content/Context;

    .line 79
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "message"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 80
    .local v1, "other_key":Ljava/lang/String;
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "mixtape_id"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 81
    .local v0, "mixtapeId":Ljava/lang/String;
    invoke-static {p1, v1, v0}, Lcom/livemixtapes/GCMIntentService;->generateNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method protected onRecoverableError(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "errorId"    # Ljava/lang/String;

    .prologue
    .line 96
    const-string v0, "LiveMixTapes"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Received recoverable error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    invoke-super {p0, p1, p2}, Lcom/google/android/gcm/GCMBaseIntentService;->onRecoverableError(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected onRegistered(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "registrationId"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 40
    const-string v0, "LiveMixTapes"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Device registered: regId = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 42
    new-instance v0, Lcom/livemixtapes/GCMIntentService$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/livemixtapes/GCMIntentService$1;-><init>(Lcom/livemixtapes/GCMIntentService;Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/livemixtapes/GCMIntentService;->mRegisterTask:Landroid/os/AsyncTask;

    .line 65
    iget-object v0, p0, Lcom/livemixtapes/GCMIntentService;->mRegisterTask:Landroid/os/AsyncTask;

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Void;

    const/4 v2, 0x0

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object v3, v1, v2

    const/4 v2, 0x2

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 67
    return-void
.end method

.method protected onUnregistered(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "registrationId"    # Ljava/lang/String;

    .prologue
    .line 71
    const-string v0, "LiveMixTapes"

    const-string v1, "Device unregistered"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    return-void
.end method
