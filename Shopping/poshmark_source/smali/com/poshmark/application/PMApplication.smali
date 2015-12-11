.class public Lcom/poshmark/application/PMApplication;
.super Landroid/app/Application;
.source "PMApplication.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field public static PARTY_START_NOTIFICATION_ID:I

.field public static PM_PUSH_NOTIFICATION_ID:I

.field private static appRestarting:Z

.field private static context:Lcom/poshmark/application/PMApplication;

.field public static kochavaTracker:Lcom/kochava/android/tracker/Feature;

.field public static mobileAppTracker:Lcom/mobileapptracker/MobileAppTracker;


# instance fields
.field public motherActivity:Lcom/poshmark/ui/MainActivity;

.field public topActivity:Lcom/poshmark/ui/PMActivity;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 49
    sput v1, Lcom/poshmark/application/PMApplication;->PARTY_START_NOTIFICATION_ID:I

    .line 50
    const/4 v0, 0x1

    sput v0, Lcom/poshmark/application/PMApplication;->PM_PUSH_NOTIFICATION_ID:I

    .line 54
    sput-object v2, Lcom/poshmark/application/PMApplication;->mobileAppTracker:Lcom/mobileapptracker/MobileAppTracker;

    .line 55
    sput-object v2, Lcom/poshmark/application/PMApplication;->kochavaTracker:Lcom/kochava/android/tracker/Feature;

    .line 57
    sput-boolean v1, Lcom/poshmark/application/PMApplication;->appRestarting:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 60
    sput-object p0, Lcom/poshmark/application/PMApplication;->context:Lcom/poshmark/application/PMApplication;

    .line 61
    return-void
.end method

.method public static getAppKey()Ljava/lang/String;
    .locals 10

    .prologue
    .line 197
    :try_start_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getApplicationObject()Lcom/poshmark/application/PMApplication;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplication;->getActivity()Lcom/poshmark/ui/MainActivity;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/ui/MainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    const-string v8, "com.poshmark.app"

    const/16 v9, 0x40

    invoke-virtual {v7, v8, v9}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 200
    .local v2, "info":Landroid/content/pm/PackageInfo;
    iget-object v0, v2, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    .local v0, "arr$":[Landroid/content/pm/Signature;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    if-ge v1, v4, :cond_0

    aget-object v6, v0, v1

    .line 201
    .local v6, "signature":Landroid/content/pm/Signature;
    const-string v7, "SHA"

    invoke-static {v7}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v5

    .line 202
    .local v5, "md":Ljava/security/MessageDigest;
    invoke-virtual {v6}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/security/MessageDigest;->update([B)V

    .line 203
    invoke-virtual {v5}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v7

    const/4 v8, 0x0

    invoke-static {v7, v8}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    .line 204
    .local v3, "keyHash":Ljava/lang/String;
    const-string v7, "KeyHash:"

    invoke-static {v7, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 212
    .end local v0    # "arr$":[Landroid/content/pm/Signature;
    .end local v1    # "i$":I
    .end local v3    # "keyHash":Ljava/lang/String;
    .end local v4    # "len$":I
    .end local v5    # "md":Ljava/security/MessageDigest;
    .end local v6    # "signature":Landroid/content/pm/Signature;
    :goto_0
    return-object v3

    .line 209
    :catch_0
    move-exception v7

    .line 212
    :cond_0
    :goto_1
    const/4 v3, 0x0

    goto :goto_0

    .line 207
    :catch_1
    move-exception v7

    goto :goto_1
.end method

.method public static getApplicationObject()Lcom/poshmark/application/PMApplication;
    .locals 1

    .prologue
    .line 167
    sget-object v0, Lcom/poshmark/application/PMApplication;->context:Lcom/poshmark/application/PMApplication;

    return-object v0
.end method

.method public static getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 163
    sget-object v0, Lcom/poshmark/application/PMApplication;->context:Lcom/poshmark/application/PMApplication;

    return-object v0
.end method

.method public static getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;
    .locals 1

    .prologue
    .line 171
    sget-object v0, Lcom/poshmark/application/PMApplication;->mobileAppTracker:Lcom/mobileapptracker/MobileAppTracker;

    return-object v0
.end method

.method public static getKochavaTracker()Lcom/kochava/android/tracker/Feature;
    .locals 1

    .prologue
    .line 175
    sget-object v0, Lcom/poshmark/application/PMApplication;->kochavaTracker:Lcom/kochava/android/tracker/Feature;

    return-object v0
.end method

.method private sendAdvertiserIdToTrackers()V
    .locals 2

    .prologue
    .line 108
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/poshmark/application/PMApplication$1;

    invoke-direct {v1, p0}, Lcom/poshmark/application/PMApplication$1;-><init>(Lcom/poshmark/application/PMApplication;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 130
    return-void
.end method

.method private setupDevIP()V
    .locals 3

    .prologue
    .line 98
    sget-object v1, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v2, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    if-ne v1, v2, :cond_0

    .line 99
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getDevIP()Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, "ip":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 101
    invoke-static {v0}, Lcom/poshmark/config/EnvConfig;->setupDevIP(Ljava/lang/String;)V

    .line 104
    .end local v0    # "ip":Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method public getActivity()Lcom/poshmark/ui/MainActivity;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/poshmark/application/PMApplication;->motherActivity:Lcom/poshmark/ui/MainActivity;

    return-object v0
.end method

.method public getTopActivity()Lcom/poshmark/ui/PMActivity;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/poshmark/application/PMApplication;->topActivity:Lcom/poshmark/ui/PMActivity;

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 218
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 219
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 221
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplication;->setCookieInJar()V

    .line 224
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 225
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "user_id"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getKochavaTracker()Lcom/kochava/android/tracker/Feature;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/kochava/android/tracker/Feature;->linkIdentity(Ljava/util/Map;)V

    .line 231
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/branch/referral/Branch;->setIdentity(Ljava/lang/String;)V

    .line 245
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :goto_0
    return-void

    .line 234
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.APP_STARTED"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 235
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 236
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplication;->setCookieInJar()V

    goto :goto_0

    .line 238
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 239
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 240
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->logout()V

    .line 242
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v1

    invoke-virtual {v1}, Lio/branch/referral/Branch;->logout()V

    goto :goto_0
.end method

.method public initGlobalControllers()V
    .locals 1

    .prologue
    .line 147
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    .line 149
    invoke-static {}, Lcom/poshmark/utils/PoshLearnManager;->getInstance()Lcom/poshmark/utils/PoshLearnManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/PoshLearnManager;->shouldShowPoshLearnScreen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 150
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->disablePartyAlerts()V

    .line 155
    :goto_0
    invoke-static {}, Lcom/poshmark/controllers/ShowroomsController;->getGlobalShowroomsController()Lcom/poshmark/controllers/ShowroomsController;

    .line 157
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    .line 159
    invoke-static {}, Lcom/poshmark/triggers/PMTriggerManager;->getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;

    .line 160
    return-void

    .line 152
    :cond_0
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->enablePartyAlerts()V

    goto :goto_0
.end method

.method public onCreate()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 65
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 67
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplication;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->CALLING_CODE_BASEMENT:I

    invoke-static {v0, v1}, Lcom/facebook/FacebookSdk;->sdkInitialize(Landroid/content/Context;I)V

    .line 68
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    .line 69
    invoke-direct {p0}, Lcom/poshmark/application/PMApplication;->setupDevIP()V

    .line 70
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplication;->initGlobalControllers()V

    .line 71
    invoke-virtual {p0}, Lcom/poshmark/application/PMApplication;->setupImageDownloader()V

    .line 73
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGIN_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 74
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.APP_STARTED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 75
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 78
    sget-object v0, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v1, Lcom/poshmark/config/Env;->DEVTEAM:Lcom/poshmark/config/Env;

    if-eq v0, v1, :cond_1

    sget-object v0, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v1, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    if-eq v0, v1, :cond_1

    .line 79
    const-string v0, "9056"

    const-string v1, "026e1400a6bc5a185b79446a9d6620e8"

    invoke-static {p0, v0, v1}, Lcom/mobileapptracker/MobileAppTracker;->init(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/mobileapptracker/MobileAppTracker;

    .line 80
    invoke-static {}, Lcom/mobileapptracker/MobileAppTracker;->getInstance()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v0

    sput-object v0, Lcom/poshmark/application/PMApplication;->mobileAppTracker:Lcom/mobileapptracker/MobileAppTracker;

    .line 81
    sget-object v0, Lcom/poshmark/application/PMApplication;->mobileAppTracker:Lcom/mobileapptracker/MobileAppTracker;

    if-eqz v0, :cond_1

    .line 82
    sget-object v0, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v1, Lcom/poshmark/config/Env;->STAGE:Lcom/poshmark/config/Env;

    if-ne v0, v1, :cond_0

    .line 83
    sget-object v0, Lcom/poshmark/application/PMApplication;->mobileAppTracker:Lcom/mobileapptracker/MobileAppTracker;

    invoke-virtual {v0, v2}, Lcom/mobileapptracker/MobileAppTracker;->setDebugMode(Z)V

    .line 85
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/application/PMApplication;->sendAdvertiserIdToTrackers()V

    .line 88
    :cond_1
    new-instance v0, Lcom/kochava/android/tracker/Feature;

    const-string v1, "koposhmarkandroid3476533b1c455ecb8"

    invoke-direct {v0, p0, v1}, Lcom/kochava/android/tracker/Feature;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sput-object v0, Lcom/poshmark/application/PMApplication;->kochavaTracker:Lcom/kochava/android/tracker/Feature;

    .line 89
    sget-object v0, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v1, Lcom/poshmark/config/Env;->STAGE:Lcom/poshmark/config/Env;

    if-eq v0, v1, :cond_2

    sget-object v0, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v1, Lcom/poshmark/config/Env;->DEV:Lcom/poshmark/config/Env;

    if-ne v0, v1, :cond_3

    .line 90
    :cond_2
    invoke-static {v2}, Lcom/kochava/android/tracker/Feature;->enableDebug(Z)V

    .line 94
    :cond_3
    invoke-static {p0}, Lio/branch/referral/Branch;->getAutoInstance(Landroid/content/Context;)Lio/branch/referral/Branch;

    .line 95
    return-void
.end method

.method public setActivity(Lcom/poshmark/ui/MainActivity;)V
    .locals 0
    .param p1, "activity"    # Lcom/poshmark/ui/MainActivity;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/poshmark/application/PMApplication;->motherActivity:Lcom/poshmark/ui/MainActivity;

    .line 180
    return-void
.end method

.method public setCookieInJar()V
    .locals 12

    .prologue
    .line 248
    const-string v10, "https://www.poshmark.com"

    invoke-static {v10}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 249
    .local v8, "uri":Landroid/net/Uri;
    invoke-virtual {v8}, Landroid/net/Uri;->getEncodedAuthority()Ljava/lang/String;

    move-result-object v0

    .line 250
    .local v0, "authority":Ljava/lang/String;
    invoke-static {p0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    move-result-object v7

    .line 251
    .local v7, "sm":Landroid/webkit/CookieSyncManager;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 252
    .local v1, "cookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {v1}, Landroid/webkit/CookieManager;->removeAllCookie()V

    .line 253
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "access_token="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v11

    invoke-virtual {v11}, Lcom/poshmark/application/PMApplicationSession;->getAccessToken()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 254
    .local v2, "cookieString1":Ljava/lang/String;
    const-string v3, "PM_application=android"

    .line 256
    .local v3, "cookieString2":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "app_version="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v11

    iget-object v11, v11, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 257
    .local v9, "version":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "display_handle ="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v11

    invoke-virtual {v11}, Lcom/poshmark/application/PMApplicationSession;->getDisplayHandle()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 258
    .local v4, "displayHandle":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fb_user_id="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v11

    invoke-virtual {v11}, Lcom/poshmark/application/PMApplicationSession;->getFacebookUserId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 259
    .local v5, "fb_id":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "pm_user_id="

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v11

    invoke-virtual {v11}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 260
    .local v6, "pm_id":Ljava/lang/String;
    invoke-virtual {v1, v0, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 261
    invoke-virtual {v1, v0, v3}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    invoke-virtual {v1, v0, v9}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    invoke-virtual {v1, v0, v4}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    invoke-virtual {v1, v0, v5}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    invoke-virtual {v1, v0, v6}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 266
    invoke-virtual {v7}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 267
    return-void
.end method

.method public setTopActivity(Lcom/poshmark/ui/PMActivity;)V
    .locals 0
    .param p1, "activity"    # Lcom/poshmark/ui/PMActivity;

    .prologue
    .line 183
    iput-object p1, p0, Lcom/poshmark/application/PMApplication;->topActivity:Lcom/poshmark/ui/PMActivity;

    .line 184
    return-void
.end method

.method public setupImageDownloader()V
    .locals 4

    .prologue
    .line 133
    new-instance v2, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    invoke-virtual {v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc()Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v1

    .line 138
    .local v1, "defaultOptions":Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    new-instance v2, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    sget-object v3, Lcom/poshmark/application/PMApplication;->context:Lcom/poshmark/application/PMApplication;

    invoke-direct {v2, v3}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->defaultDisplayImageOptions(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->build()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    move-result-object v0

    .line 142
    .local v0, "config":Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->init(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V

    .line 143
    return-void
.end method
