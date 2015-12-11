.class public Lcom/inc247/NotificationToUser;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static body:Ljava/lang/String;

.field static subject:Ljava/lang/String;

.field static title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-string v0, "Current Chat Status"

    sput-object v0, Lcom/inc247/NotificationToUser;->title:Ljava/lang/String;

    .line 23
    const-string v0, "Your Chat is In Background"

    sput-object v0, Lcom/inc247/NotificationToUser;->body:Ljava/lang/String;

    .line 24
    const-string v0, "Chat Notification"

    sput-object v0, Lcom/inc247/NotificationToUser;->subject:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ShowNotificationToUser(Landroid/content/Context;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 28
    .line 29
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 28
    check-cast v0, Landroid/app/NotificationManager;

    .line 30
    new-instance v2, Landroid/app/Notification;

    sget v1, Lcom/inc247/R$drawable;->icon:I

    sget-object v3, Lcom/inc247/NotificationToUser;->title:Ljava/lang/String;

    .line 31
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 30
    invoke-direct {v2, v1, v3, v4, v5}, Landroid/app/Notification;-><init>(ILjava/lang/CharSequence;J)V

    .line 33
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 32
    invoke-static {p0, v6, v1, v6}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 34
    sget-object v3, Lcom/inc247/NotificationToUser;->subject:Ljava/lang/String;

    sget-object v4, Lcom/inc247/NotificationToUser;->body:Ljava/lang/String;

    invoke-virtual {v2, p0, v3, v4, v1}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 37
    const/4 v1, 0x2

    :try_start_0
    invoke-static {v1}, Landroid/media/RingtoneManager;->getDefaultUri(I)Landroid/net/Uri;

    move-result-object v1

    .line 38
    invoke-static {p0, v1}, Landroid/media/RingtoneManager;->getRingtone(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/Ringtone;

    move-result-object v1

    .line 39
    invoke-virtual {v1}, Landroid/media/Ringtone;->play()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    :goto_0
    invoke-virtual {v0, v6, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 46
    return-void

    .line 40
    :catch_0
    move-exception v1

    .line 41
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 43
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "{\'Error\':\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "\'}"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 42
    invoke-static {v1}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method
