.class public Lco/vine/android/service/GCMRegistrationService;
.super Landroid/app/Service;
.source "GCMRegistrationService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/GCMRegistrationService$1;,
        Lco/vine/android/service/GCMRegistrationService$GCMRegistrationListener;,
        Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;,
        Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;
    }
.end annotation


# static fields
.field public static final ACTION_REGISTER:Ljava/lang/String; = "co.vine.android.gcm.REGISTER"

.field public static final ACTION_UNREGISTER:Ljava/lang/String; = "co.vine.android.gcm.UNREGISTER"

.field public static final PREFS:Ljava/lang/String; = "gcmPrefs"

.field public static final PREF_APP_VERSION:Ljava/lang/String; = "registrationVersion"

.field public static final PREF_REG_EXPIRY_TIME:Ljava/lang/String; = "registrationExpiryTime"

.field public static final PREF_REG_ID:Ljava/lang/String; = "registrationId"

.field public static final PREF_REG_ID_SENT:Ljava/lang/String; = "registrationIdSent"

.field public static final REGISTRATION_EXPIRY_TIME_MS:J = 0x240c8400L

.field private static final TAG:Ljava/lang/String; = "GCMRegService"

.field private static sPrefs:Landroid/content/SharedPreferences;


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

.field private mGcmRegistrationListener:Lco/vine/android/client/AppSessionListener;

.field private mSenderId:Ljava/lang/String;

.field private mStartIds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 277
    return-void
.end method

.method static synthetic access$100(Lco/vine/android/service/GCMRegistrationService;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMRegistrationService;

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    return-object v0
.end method

.method static synthetic access$102(Lco/vine/android/service/GCMRegistrationService;Lcom/google/android/gms/gcm/GoogleCloudMessaging;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMRegistrationService;
    .param p1, "x1"    # Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    .prologue
    .line 27
    iput-object p1, p0, Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    return-object p1
.end method

.method static synthetic access$200(Lco/vine/android/service/GCMRegistrationService;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMRegistrationService;

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mSenderId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/service/GCMRegistrationService;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMRegistrationService;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lco/vine/android/service/GCMRegistrationService;->setRegistrationId(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lco/vine/android/service/GCMRegistrationService;)Lco/vine/android/client/AppController;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/GCMRegistrationService;

    .prologue
    .line 27
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;

    return-object v0
.end method

.method static synthetic access$500(Lco/vine/android/service/GCMRegistrationService;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/service/GCMRegistrationService;

    .prologue
    .line 27
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->stopService()V

    return-void
.end method

.method private getAppVersion()I
    .locals 5

    .prologue
    .line 144
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/service/GCMRegistrationService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Lco/vine/android/service/GCMRegistrationService;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 145
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget v2, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 148
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return v2

    .line 146
    :catch_0
    move-exception v0

    .line 148
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v2, -0x1

    goto :goto_0
.end method

.method public static getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 178
    sget-object v0, Lco/vine/android/service/GCMRegistrationService;->sPrefs:Landroid/content/SharedPreferences;

    if-nez v0, :cond_0

    .line 179
    const-string v0, "gcmPrefs"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lco/vine/android/service/GCMRegistrationService;->sPrefs:Landroid/content/SharedPreferences;

    .line 181
    :cond_0
    sget-object v0, Lco/vine/android/service/GCMRegistrationService;->sPrefs:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public static getRegisterIntent(Landroid/content/Context;J)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "userId"    # J

    .prologue
    .line 51
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 52
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "co.vine.android.gcm.REGISTER"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 53
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 54
    return-object v0
.end method

.method private getRegistrationId()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 124
    invoke-static {p0}, Lco/vine/android/service/GCMRegistrationService;->getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 125
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v5, "registrationId"

    invoke-interface {v1, v5, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 126
    .local v3, "registrationId":Ljava/lang/String;
    if-nez v3, :cond_1

    .line 127
    const-string v5, "GCMRegService"

    const-string v6, "Registration not found."

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    .line 139
    .end local v3    # "registrationId":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v3

    .line 132
    .restart local v3    # "registrationId":Ljava/lang/String;
    :cond_1
    const-string v5, "registrationVersion"

    const/high16 v6, -0x80000000

    invoke-interface {v1, v5, v6}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 133
    .local v2, "registeredVersion":I
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->getAppVersion()I

    move-result v0

    .line 134
    .local v0, "currentVersion":I
    if-ne v2, v0, :cond_2

    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->isRegistrationExpired()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 135
    :cond_2
    const-string v5, "GCMRegService"

    const-string v6, "App version changed or registration expired."

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    .line 136
    goto :goto_0
.end method

.method public static getUnregisterIntent(Landroid/content/Context;JLjava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "userId"    # J
    .param p3, "key"    # Ljava/lang/String;

    .prologue
    .line 58
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/service/GCMRegistrationService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 59
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "co.vine.android.gcm.UNREGISTER"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 60
    const-string v1, "user_id"

    invoke-virtual {v0, v1, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 61
    const-string v1, "s_key"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 62
    return-object v0
.end method

.method private isRegistrationExpired()Z
    .locals 6

    .prologue
    .line 153
    invoke-static {p0}, Lco/vine/android/service/GCMRegistrationService;->getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 154
    .local v2, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "registrationExpiryTime"

    const-wide/16 v4, -0x1

    invoke-interface {v2, v3, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    .line 155
    .local v0, "expirationTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    cmp-long v3, v3, v0

    if-lez v3, :cond_0

    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private setRegistrationId(Ljava/lang/String;)V
    .locals 9
    .param p1, "regId"    # Ljava/lang/String;

    .prologue
    .line 165
    invoke-static {p0}, Lco/vine/android/service/GCMRegistrationService;->getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    .line 166
    .local v4, "prefs":Landroid/content/SharedPreferences;
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->getAppVersion()I

    move-result v0

    .line 167
    .local v0, "appVersion":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/32 v7, 0x240c8400

    add-long v2, v5, v7

    .line 169
    .local v2, "expirationTime":J
    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 170
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v5, "registrationIdSent"

    const/4 v6, 0x0

    invoke-interface {v1, v5, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 171
    const-string v5, "registrationVersion"

    invoke-interface {v1, v5, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 172
    const-string v5, "registrationExpiryTime"

    invoke-interface {v1, v5, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 173
    const-string v5, "registrationId"

    invoke-interface {v1, v5, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 174
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 175
    return-void
.end method

.method private stopService()V
    .locals 5

    .prologue
    .line 112
    iget-object v2, p0, Lco/vine/android/service/GCMRegistrationService;->mStartIds:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 113
    .local v1, "startId":I
    const-string v2, "GCMRegService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Stopping service for startId="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    invoke-virtual {p0, v1}, Lco/vine/android/service/GCMRegistrationService;->stopSelf(I)V

    goto :goto_0

    .line 116
    .end local v1    # "startId":I
    :cond_0
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 292
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 2

    .prologue
    .line 67
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 68
    invoke-static {p0}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    .line 69
    invoke-static {p0}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;

    .line 70
    new-instance v0, Lco/vine/android/service/GCMRegistrationService$GCMRegistrationListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/service/GCMRegistrationService$GCMRegistrationListener;-><init>(Lco/vine/android/service/GCMRegistrationService;Lco/vine/android/service/GCMRegistrationService$1;)V

    iput-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mGcmRegistrationListener:Lco/vine/android/client/AppSessionListener;

    .line 71
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mGcmRegistrationListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/service/GCMRegistrationService;->mGcmRegistrationListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->addListener(Lco/vine/android/client/AppSessionListener;)V

    .line 74
    :cond_0
    invoke-static {p0}, Lco/vine/android/util/BuildUtil;->getSenderId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mSenderId:Ljava/lang/String;

    .line 75
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mStartIds:Ljava/util/ArrayList;

    .line 76
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 186
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 187
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mGcmRegistrationListener:Lco/vine/android/client/AppSessionListener;

    if-eqz v0, :cond_0

    .line 188
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/service/GCMRegistrationService;->mGcmRegistrationListener:Lco/vine/android/client/AppSessionListener;

    invoke-virtual {v0, v1}, Lco/vine/android/client/AppController;->removeListener(Lco/vine/android/client/AppSessionListener;)V

    .line 190
    :cond_0
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mGcm:Lcom/google/android/gms/gcm/GoogleCloudMessaging;

    invoke-virtual {v0}, Lcom/google/android/gms/gcm/GoogleCloudMessaging;->close()V

    .line 191
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 11
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x0

    .line 80
    const-string v0, "GCMRegService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "onStartCommand, startId="

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v7, ", startIds="

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v7, p0, Lco/vine/android/service/GCMRegistrationService;->mStartIds:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mStartIds:Ljava/util/ArrayList;

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 83
    if-nez p1, :cond_0

    .line 108
    :goto_0
    return v10

    .line 88
    :cond_0
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->getRegistrationId()Ljava/lang/String;

    move-result-object v2

    .line 89
    .local v2, "regId":Ljava/lang/String;
    const-string v0, "GCMRegService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Starting GCM registration service with regId="

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    const-string v0, "user_id"

    const-wide/16 v7, 0x0

    invoke-virtual {p1, v0, v7, v8}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    .line 91
    .local v3, "userId":J
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v6

    .line 93
    .local v6, "action":Ljava/lang/String;
    const-string v0, "co.vine.android.gcm.REGISTER"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 94
    if-nez v2, :cond_1

    .line 95
    new-instance v0, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;

    invoke-direct {v0, p0, v3, v4}, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;-><init>(Lco/vine/android/service/GCMRegistrationService;J)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lco/vine/android/service/GCMRegistrationService$GCMRegisterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 96
    :cond_1
    invoke-static {p0}, Lco/vine/android/service/GCMRegistrationService;->getGCMPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "registrationIdSent"

    invoke-interface {v0, v1, v9}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_2

    .line 98
    iget-object v0, p0, Lco/vine/android/service/GCMRegistrationService;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, v2, v3, v4}, Lco/vine/android/client/AppController;->sendGcmRegId(Ljava/lang/String;J)Ljava/lang/String;

    goto :goto_0

    .line 100
    :cond_2
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->stopService()V

    goto :goto_0

    .line 102
    :cond_3
    const-string v0, "co.vine.android.gcm.UNREGISTER"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 103
    const-string v0, "s_key"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 104
    .local v5, "key":Ljava/lang/String;
    new-instance v0, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;-><init>(Lco/vine/android/service/GCMRegistrationService;Ljava/lang/String;JLjava/lang/String;)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lco/vine/android/service/GCMRegistrationService$GCMUnregisterTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 106
    .end local v5    # "key":Ljava/lang/String;
    :cond_4
    invoke-direct {p0}, Lco/vine/android/service/GCMRegistrationService;->stopService()V

    goto :goto_0
.end method
