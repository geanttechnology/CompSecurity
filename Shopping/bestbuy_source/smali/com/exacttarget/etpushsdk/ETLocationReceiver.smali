.class public final Lcom/exacttarget/etpushsdk/ETLocationReceiver;
.super Landroid/support/v4/content/WakefulBroadcastReceiver;
.source "SourceFile"


# static fields
.field public static final LOCATION_15MINUTE_UPDATE:Ljava/lang/String; = "et_location_action_15minute_update"

.field public static final LOCATION_15MINUTE_UPDATE_REQUEST_CODE:I = 0x3e9

.field public static final LOCATION_GEOFENCE_CROSS:Ljava/lang/String; = "et_location_action_geofence_cross"

.field public static final LOCATION_GEOFENCE_CROSS_REQUEST_CODE:I = 0x3ea

.field public static final LOCATION_PASSIVE_LOCATION_CHANGE:Ljava/lang/String; = "et_location_action_passive_location_change"

.field public static final LOCATION_PASSIVE_LOCATION_CHANGE_REQUEST_CODE:I = 0x3eb

.field public static final LOCATION_TIMEOUT:Ljava/lang/String; = "et_location_action_timeout"

.field public static final LOCATION_TIMEOUT_REQUEST_CODE:I = 0x3e8

.field private static final TAG:Ljava/lang/String; = "~!ETLocationReceiver"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/support/v4/content/WakefulBroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 49
    const-string v0, "~!ETLocationReceiver"

    const-string v1, "%s.onReceive()"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 52
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/exacttarget/etpushsdk/ETLocationService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 54
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    .line 56
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 57
    const-string v2, "~!ETLocationReceiver"

    const-string v3, "Location action: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 60
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 61
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 64
    :cond_0
    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETLocationReceiver;->startWakefulService(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 74
    :goto_0
    return-void

    .line 66
    :cond_1
    const-string v0, "~!ETLocationReceiver"

    const-string v1, "No action provided."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 67
    invoke-static {p2}, Lcom/exacttarget/etpushsdk/ETLocationReceiver;->completeWakefulIntent(Landroid/content/Intent;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 70
    :catch_0
    move-exception v0

    .line 71
    const-string v1, "~!ETLocationReceiver"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 72
    invoke-static {p2}, Lcom/exacttarget/etpushsdk/ETLocationReceiver;->completeWakefulIntent(Landroid/content/Intent;)Z

    goto :goto_0
.end method
