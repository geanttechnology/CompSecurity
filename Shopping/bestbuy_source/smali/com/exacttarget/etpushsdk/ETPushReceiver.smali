.class public final Lcom/exacttarget/etpushsdk/ETPushReceiver;
.super Landroid/support/v4/content/WakefulBroadcastReceiver;
.source "SourceFile"


# static fields
.field public static final ACTIVITY_PAUSED_REQUEST_CODE:I = 0x3e8

.field protected static final APP_IN_BACKGROUND:Ljava/lang/String; = "et_push_app_in_background"

.field protected static final MESSAGE_OPENED:Ljava/lang/String; = ".MESSAGE_OPENED"

.field protected static final NOTIFICATION_ID:Ljava/lang/String; = "et_notification_id_key"

.field protected static final OPEN_TYPE_EXTRA:Ljava/lang/String; = "et_open_type_extra"

.field protected static final PUSH_ACTION:Ljava/lang/String; = "et_push_action"

.field protected static final PUSH_ACTION_OPEN:Ljava/lang/String; = "et_push_action_open"

.field protected static final PUSH_ACTION_OPEN_INTENT:Ljava/lang/String; = "et_push_open_intent"

.field protected static final PUSH_ACTION_SEND:Ljava/lang/String; = "et_push_action_send"

.field protected static final SEND_TYPE_CLOUDPAGE_REQUEST:Ljava/lang/String; = "et_send_type_cloudpage"

.field public static final SEND_TYPE_CUSTOM_APP_REQUEST:Ljava/lang/String; = "et_send_type_custom_app_request"

.field protected static final SEND_TYPE_ET_ANALYTIC_EVENTS:Ljava/lang/String; = "et_send_type_analytic_events"

.field protected static final SEND_TYPE_EXTRA:Ljava/lang/String; = "et_send_type_extra"

.field protected static final SEND_TYPE_GEOFENCE_REQUEST:Ljava/lang/String; = "et_send_type_geofence"

.field protected static final SEND_TYPE_LOCATION:Ljava/lang/String; = "et_send_type_location"

.field protected static final SEND_TYPE_PI_ANALYTIC_EVENTS:Ljava/lang/String; = "pi_send_type_analytic_events"

.field protected static final SEND_TYPE_PROXIMITY_REQUEST:Ljava/lang/String; = "et_send_type_proximity"

.field protected static final SEND_TYPE_REGISTRATION:Ljava/lang/String; = "et_send_type_registration"

.field private static final TAG:Ljava/lang/String; = "~!ETPushReceiver"


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

    .line 59
    const-string v0, "~!ETPushReceiver"

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

    .line 62
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 64
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 65
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 68
    :cond_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    .line 69
    const-string v2, "et_send_type_extra"

    invoke-virtual {p2, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 70
    const-string v3, "et_open_type_extra"

    invoke-virtual {p2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 72
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 73
    const-string v1, "et_push_action"

    const-string v2, "et_push_action_send"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 74
    const-string v1, "~!ETPushReceiver"

    const-string v2, "Push action: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "et_push_action_send"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPushReceiver;->startWakefulService(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 92
    :goto_0
    return-void

    .line 76
    :cond_1
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 77
    const-string v1, "et_push_action"

    const-string v2, "et_push_action_open"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 78
    const-string v1, "~!ETPushReceiver"

    const-string v2, "Push action: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "et_push_action_open"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPushReceiver;->startWakefulService(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 88
    :catch_0
    move-exception v0

    .line 89
    const-string v1, "~!ETPushReceiver"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 90
    invoke-static {p2}, Lcom/exacttarget/etpushsdk/ETPushReceiver;->completeWakefulIntent(Landroid/content/Intent;)Z

    goto :goto_0

    .line 80
    :cond_2
    :try_start_1
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 81
    const-string v2, "et_push_action"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 82
    const-string v2, "~!ETPushReceiver"

    const-string v3, "Push action: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 83
    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPushReceiver;->startWakefulService(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;

    goto :goto_0

    .line 85
    :cond_3
    const-string v0, "~!ETPushReceiver"

    const-string v1, "No action provided."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 86
    invoke-static {p2}, Lcom/exacttarget/etpushsdk/ETPushReceiver;->completeWakefulIntent(Landroid/content/Intent;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
