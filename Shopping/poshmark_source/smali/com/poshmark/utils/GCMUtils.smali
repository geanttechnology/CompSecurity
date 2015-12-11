.class public Lcom/poshmark/utils/GCMUtils;
.super Ljava/lang/Object;
.source "GCMUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;
    }
.end annotation


# instance fields
.field public final GCM_TOKEN_FETCH_ALARM_TIMER_DELAY:J

.field public final GCM_TOKEN_FETCH_PENDING_INTENT_ID:I

.field public final PLAY_SERVICES_RESOLUTION_REQUEST:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/utils/GCMUtils;->PLAY_SERVICES_RESOLUTION_REQUEST:I

    .line 35
    const-wide/32 v0, 0x240c8400

    iput-wide v0, p0, Lcom/poshmark/utils/GCMUtils;->GCM_TOKEN_FETCH_ALARM_TIMER_DELAY:J

    .line 36
    const/16 v0, 0x65

    iput v0, p0, Lcom/poshmark/utils/GCMUtils;->GCM_TOKEN_FETCH_PENDING_INTENT_ID:I

    .line 95
    return-void
.end method


# virtual methods
.method public checkPlayServices(Landroid/content/Context;)Z
    .locals 4
    .param p1, "cntx"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    .line 79
    instance-of v0, p1, Landroid/app/Activity;

    .line 80
    .local v0, "b":Z
    invoke-static {p1}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v1

    .line 81
    .local v1, "resultCode":I
    if-eqz v1, :cond_1

    .line 82
    invoke-static {v1}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isUserRecoverableError(I)Z

    move-result v3

    if-eqz v3, :cond_0

    instance-of v3, p1, Landroid/app/Activity;

    if-eqz v3, :cond_0

    .line 83
    check-cast p1, Landroid/app/Activity;

    .end local p1    # "cntx":Landroid/content/Context;
    invoke-static {v1, p1, v2}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->getErrorDialog(ILandroid/app/Activity;I)Landroid/app/Dialog;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Dialog;->show()V

    .line 86
    :cond_0
    const/4 v2, 0x0

    .line 88
    :cond_1
    return v2
.end method

.method public forceRegisterWithGCM(Landroid/content/Context;)V
    .locals 0
    .param p1, "cntx"    # Landroid/content/Context;

    .prologue
    .line 75
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/GCMUtils;->registerInBackground(Landroid/content/Context;)V

    .line 76
    return-void
.end method

.method public registerInBackground(Landroid/content/Context;)V
    .locals 3
    .param p1, "cntx"    # Landroid/content/Context;

    .prologue
    .line 92
    new-instance v0, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;

    invoke-direct {v0, p0, p1}, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;-><init>(Lcom/poshmark/utils/GCMUtils;Landroid/content/Context;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    instance-of v2, v0, Landroid/os/AsyncTask;

    if-nez v2, :cond_0

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/GCMUtils$RegisterAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 93
    :goto_0
    return-void

    .line 92
    :cond_0
    check-cast v0, Landroid/os/AsyncTask;

    invoke-static {v0, v1}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public registerWithGCM(Landroid/content/Context;)V
    .locals 6
    .param p1, "cntx"    # Landroid/content/Context;

    .prologue
    .line 40
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v2

    .line 41
    .local v2, "regId":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getGCMAppVersion()Ljava/lang/String;

    move-result-object v0

    .line 42
    .local v0, "gcmAppVersion":Ljava/lang/String;
    if-nez v2, :cond_1

    .line 43
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/GCMUtils;->registerInBackground(Landroid/content/Context;)V

    .line 44
    invoke-virtual {p0}, Lcom/poshmark/utils/GCMUtils;->setTimerForFreshGcmTokenFetch()V

    .line 59
    :cond_0
    :goto_0
    return-void

    .line 47
    :cond_1
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 48
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/GCMUtils;->registerInBackground(Landroid/content/Context;)V

    goto :goto_0

    .line 50
    :cond_2
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getGCMLastRegisteredTime()Ljava/util/Date;

    move-result-object v1

    .line 51
    .local v1, "lastGCMRegistrationDate":Ljava/util/Date;
    const-wide/16 v4, 0x7

    sget-object v3, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->DAYS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v1, v4, v5, v3}, Lcom/poshmark/utils/DateUtils;->isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 52
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/GCMUtils;->registerInBackground(Landroid/content/Context;)V

    goto :goto_0

    .line 53
    :cond_3
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegIdSentFlag()Z

    move-result v3

    if-nez v3, :cond_0

    .line 55
    invoke-virtual {p0}, Lcom/poshmark/utils/GCMUtils;->sendGcmPushTokenToServer()V

    goto :goto_0
.end method

.method public sendGcmPushTokenToServer()V
    .locals 2

    .prologue
    .line 133
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getGCMRegId()Ljava/lang/String;

    move-result-object v0

    .line 134
    .local v0, "pushToken":Ljava/lang/String;
    new-instance v1, Lcom/poshmark/utils/GCMUtils$1;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/GCMUtils$1;-><init>(Lcom/poshmark/utils/GCMUtils;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->putGCMPushToken(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 144
    return-void
.end method

.method public setTimerForFreshGcmTokenFetch()V
    .locals 9

    .prologue
    .line 62
    new-instance v2, Landroid/content/Intent;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const-class v7, Lcom/poshmark/notifications/PMGcmReciever;

    invoke-direct {v2, v6, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 63
    .local v2, "intent":Landroid/content/Intent;
    const-string v6, "com.poshmark.intents.FETCH_GCM_TOKEN"

    invoke-virtual {v2, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 65
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const/16 v7, 0x65

    const/high16 v8, 0x10000000

    invoke-static {v6, v7, v2, v8}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 66
    .local v3, "pendingIntent":Landroid/app/PendingIntent;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const-string v7, "alarm"

    invoke-virtual {v6, v7}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 67
    .local v0, "alarmManager":Landroid/app/AlarmManager;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 68
    .local v1, "currentDate":Ljava/util/Date;
    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    .line 69
    .local v4, "timeInMilli":J
    const-wide/32 v6, 0x240c8400

    add-long/2addr v4, v6

    .line 70
    const/4 v6, 0x0

    invoke-virtual {v0, v6, v4, v5, v3}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 72
    return-void
.end method
