.class public Lcom/bestbuy/android/base/BBYApplication;
.super Landroid/app/Application;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String;

.field public static firstLaunch:Z

.field private static instance:Lcom/bestbuy/android/base/BBYApplication;


# instance fields
.field private databaseProvider:Lfo;

.field private isRegistrationStarted:Z

.field private mLoginNeeded:Z

.field private mLoginOkay:Z

.field private sManager:Landroid/hardware/SensorManager;

.field private sensor:Landroid/hardware/Sensor;

.field private settingsSharedPrefs:Landroid/content/SharedPreferences;

.field private shakeEventListener:Lnq;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/bestbuy/android/base/BBYApplication;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/base/BBYApplication;->TAG:Ljava/lang/String;

    .line 39
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/base/BBYApplication;->firstLaunch:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 47
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->isRegistrationStarted:Z

    return-void
.end method

.method public static getInstance()Lcom/bestbuy/android/base/BBYApplication;
    .locals 1

    .prologue
    .line 170
    sget-object v0, Lcom/bestbuy/android/base/BBYApplication;->instance:Lcom/bestbuy/android/base/BBYApplication;

    return-object v0
.end method

.method private initShakeSetting()V
    .locals 3

    .prologue
    .line 111
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 112
    const-string v1, "shake_your_device"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 113
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 115
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "shake_your_device"

    const-string v2, "On"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 117
    :cond_0
    return-void
.end method


# virtual methods
.method public getDatabaseProvider()Lfo;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->databaseProvider:Lfo;

    return-object v0
.end method

.method public declared-synchronized isLoginNeeded()Z
    .locals 1

    .prologue
    .line 162
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginNeeded:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isLoginOkay()Z
    .locals 1

    .prologue
    .line 154
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginOkay:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onCreate()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 50
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 51
    sput-object p0, Lcom/bestbuy/android/base/BBYApplication;->instance:Lcom/bestbuy/android/base/BBYApplication;

    .line 53
    :try_start_0
    new-instance v0, Lfo;

    invoke-direct {v0, p0}, Lfo;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->databaseProvider:Lfo;

    .line 54
    invoke-static {p0}, Lng;->a(Landroid/content/Context;)V

    .line 55
    invoke-static {p0}, Lnb;->a(Landroid/content/Context;)V

    .line 56
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "IS_MAP_VIEW"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "APP_STATE"

    const-string v2, "Background"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 59
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->f(Z)V

    .line 60
    invoke-static {p0}, Lna;->a(Landroid/content/Context;)V

    .line 61
    invoke-static {p0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 62
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V

    .line 63
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYApplication;->initShakeSetting()V

    .line 64
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginNeeded:Z

    .line 65
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "v"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lfs;->b(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    const-string v1, "IS_APP_RESET"

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 70
    if-nez v0, :cond_0

    .line 71
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "etdb.db"

    invoke-virtual {v0, v1}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    .line 74
    const-string v0, "ETPush"

    invoke-virtual {p0, v0, v4}, Lcom/bestbuy/android/base/BBYApplication;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 75
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 76
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "IS_APP_RESET"

    invoke-interface {v0, v1, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 81
    :cond_0
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getDefault()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    .line 82
    sget-object v0, Lcom/bestbuy/android/base/BBYApplication;->TAG:Ljava/lang/String;

    invoke-static {p0, v0}, Llq;->a(Landroid/app/Application;Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    const-string v1, "FIRST_APP_LAUNCH"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "FIRST_APP_LAUNCH"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 86
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08004b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 87
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08003e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 88
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08008a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 89
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 91
    const/4 v0, 0x0

    invoke-static {p0, v0}, Llq;->a(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 100
    :cond_1
    :goto_1
    sget-object v0, Lcom/bestbuy/android/base/BBYApplication;->TAG:Ljava/lang/String;

    const-string v1, "ET push notification"

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 104
    :goto_2
    return-void

    .line 66
    :catch_0
    move-exception v0

    .line 67
    sget-object v1, Lcom/bestbuy/android/base/BBYApplication;->TAG:Ljava/lang/String;

    invoke-static {v1, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    goto/16 :goto_0

    .line 93
    :cond_2
    :try_start_2
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08004b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 94
    iget-object v1, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08003e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 95
    iget-object v2, p0, Lcom/bestbuy/android/base/BBYApplication;->settingsSharedPrefs:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08008a

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 96
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    .line 97
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->pushManager()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->disablePush()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 101
    :catch_1
    move-exception v0

    .line 102
    sget-object v1, Lcom/bestbuy/android/base/BBYApplication;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "PN UA Configaration ERROR: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;)V
    .locals 2

    .prologue
    .line 181
    :try_start_0
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;->isReadyAimFireReady()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 182
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    .line 183
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->enablePush()V

    .line 184
    const-class v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->setOpenDirectRecipient(Ljava/lang/Class;)V

    .line 185
    const-class v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->setNotificationRecipientClass(Ljava/lang/Class;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 190
    :cond_0
    :goto_0
    return-void

    .line 187
    :catch_0
    move-exception v0

    .line 188
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/RegistrationEvent;)V
    .locals 2

    .prologue
    .line 193
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/lang/String;)V

    .line 194
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getSystemToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnb;->b(Ljava/lang/String;)V

    .line 196
    :try_start_0
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getSubscriberKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getSubscriberKey()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getSubscriberKey()Ljava/lang/String;

    move-result-object v0

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 197
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->setSubscriberKey(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    .line 201
    :cond_1
    :goto_0
    iget-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->isRegistrationStarted:Z

    if-nez v0, :cond_2

    .line 202
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->isRegistrationStarted:Z

    .line 203
    new-instance v0, Lhs;

    invoke-direct {v0}, Lhs;-><init>()V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhs;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 205
    :cond_2
    return-void

    .line 198
    :catch_0
    move-exception v0

    .line 199
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->printStackTrace()V

    goto :goto_0
.end method

.method public registerSensor()V
    .locals 4

    .prologue
    .line 124
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    :goto_0
    return-void

    .line 127
    :cond_0
    const-string v0, "sensor"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/base/BBYApplication;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SensorManager;

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->sManager:Landroid/hardware/SensorManager;

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->sManager:Landroid/hardware/SensorManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->sensor:Landroid/hardware/Sensor;

    .line 129
    new-instance v0, Lnq;

    invoke-direct {v0}, Lnq;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->shakeEventListener:Lnq;

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->sManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYApplication;->shakeEventListener:Lnq;

    iget-object v2, p0, Lcom/bestbuy/android/base/BBYApplication;->sensor:Landroid/hardware/Sensor;

    const/4 v3, 0x3

    invoke-virtual {v0, v1, v2, v3}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    goto :goto_0
.end method

.method public declared-synchronized setLoginNeeded(Z)V
    .locals 1

    .prologue
    .line 166
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginNeeded:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 167
    monitor-exit p0

    return-void

    .line 166
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setLoginOkay(Z)V
    .locals 1

    .prologue
    .line 158
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginOkay:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 159
    monitor-exit p0

    return-void

    .line 158
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setLoginOkayAndNotify()V
    .locals 3

    .prologue
    .line 144
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->isLoginOkay()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 145
    invoke-virtual {p0}, Lcom/bestbuy/android/base/BBYApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    .line 146
    new-instance v1, Landroid/content/Intent;

    const-string v2, "loginOkay"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 147
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginNeeded:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 151
    :goto_0
    monitor-exit p0

    return-void

    .line 149
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/bestbuy/android/base/BBYApplication;->mLoginOkay:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 144
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public unRegisterSensor()V
    .locals 2

    .prologue
    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->sManager:Landroid/hardware/SensorManager;

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/base/BBYApplication;->sManager:Landroid/hardware/SensorManager;

    iget-object v1, p0, Lcom/bestbuy/android/base/BBYApplication;->shakeEventListener:Lnq;

    invoke-virtual {v0, v1}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 140
    :cond_0
    return-void
.end method
