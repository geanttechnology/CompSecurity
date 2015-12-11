.class public Lcom/localytics/android/PushReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# static fields
.field private static final MAX_RETRIES:I = 0x3

.field private static final RETRY_DELAY:J = 0x1388L

.field private static numRetries:I

.field static retrySenderId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const/4 v0, 0x0

    sput-object v0, Lcom/localytics/android/PushReceiver;->retrySenderId:Ljava/lang/String;

    .line 16
    const/4 v0, 0x0

    sput v0, Lcom/localytics/android/PushReceiver;->numRetries:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6

    .prologue
    .line 22
    invoke-static {p1}, Lcom/localytics/android/DatapointHelper;->getLocalyticsAppKeyOrNull(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 23
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics;->integrate(Landroid/content/Context;Ljava/lang/String;)V

    .line 28
    :cond_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.google.android.c2dm.intent.REGISTRATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 30
    invoke-static {p2}, Lcom/localytics/android/Localytics;->handleRegistration(Landroid/content/Intent;)V

    .line 72
    :cond_1
    :goto_0
    return-void

    .line 34
    :cond_2
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 37
    :try_start_0
    const-string v0, "com.google.android.gms.gcm.GoogleCloudMessaging"

    const-string v2, "getInstance"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Landroid/content/Context;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v0, v2, v3, v4}, Lcom/localytics/android/ReflectionUtils;->tryInvokeStatic(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 38
    if-eqz v0, :cond_1

    .line 40
    const-string v2, "getMessageType"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Landroid/content/Intent;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p2, v4, v5

    invoke-static {v0, v2, v3, v4}, Lcom/localytics/android/ReflectionUtils;->tryInvokeInstance(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 41
    invoke-virtual {v1}, Landroid/os/Bundle;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 43
    const-string v1, "com.google.android.gms.gcm.GoogleCloudMessaging"

    const-string v2, "ERROR_SERVICE_NOT_AVAILABLE"

    invoke-static {v1, v2}, Lcom/localytics/android/ReflectionUtils;->tryGetStaticField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 45
    sget-object v0, Lcom/localytics/android/PushReceiver;->retrySenderId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 47
    sget v0, Lcom/localytics/android/PushReceiver;->numRetries:I

    add-int/lit8 v0, v0, 0x1

    .line 48
    sput v0, Lcom/localytics/android/PushReceiver;->numRetries:I

    const/4 v1, 0x3

    if-gt v0, v1, :cond_3

    .line 50
    const-string v0, "GCM registration ERROR_SERVICE_NOT_AVAILABLE. Retrying in 5000 milliseconds."

    invoke-static {v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;)I

    .line 51
    sget-object v0, Lcom/localytics/android/PushReceiver;->retrySenderId:Ljava/lang/String;

    const-wide/16 v2, 0x1388

    invoke-static {v0, v2, v3}, Lcom/localytics/android/Localytics;->registerPush(Ljava/lang/String;J)V

    .line 57
    :goto_1
    const/4 v0, 0x0

    sput-object v0, Lcom/localytics/android/PushReceiver;->retrySenderId:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 67
    :catch_0
    move-exception v0

    .line 69
    const-string v1, "Something went wrong with GCM"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 55
    :cond_3
    const/4 v0, 0x0

    :try_start_1
    sput v0, Lcom/localytics/android/PushReceiver;->numRetries:I

    goto :goto_1

    .line 60
    :cond_4
    const-string v1, "com.google.android.gms.gcm.GoogleCloudMessaging"

    const-string v2, "MESSAGE_TYPE_MESSAGE"

    invoke-static {v1, v2}, Lcom/localytics/android/ReflectionUtils;->tryGetStaticField(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 62
    invoke-static {p2}, Lcom/localytics/android/Localytics;->handleNotificationReceived(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method
