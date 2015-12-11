.class public Lco/vine/android/service/GCMBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "GCMBroadcastReceiver.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "GCMBroadcastReceiver"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 23
    const-string v1, "GCMBroadcastReceiver"

    const-string v2, "Message received!"

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    invoke-static {p1}, Lco/vine/android/Settings;->isNotificationEnabled(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 25
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/util/FlurryUtils;->trackNotificationReceived(Z)V

    .line 36
    :goto_0
    return-void

    .line 28
    :cond_0
    const/4 v1, 0x0

    invoke-static {v1}, Lco/vine/android/util/FlurryUtils;->trackNotificationReceived(Z)V

    .line 31
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/GCMNotificationService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 32
    .local v0, "serviceIntent":Landroid/content/Intent;
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 33
    const-string v1, "co.vine.android.notifications.ACTION_SHOW_NOTIFICATION"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 34
    invoke-virtual {p1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 35
    const/4 v1, -0x1

    invoke-virtual {p0, v1}, Lco/vine/android/service/GCMBroadcastReceiver;->setResultCode(I)V

    goto :goto_0
.end method
