.class public Lcom/amazon/mShop/social/SocialConnectHelper;
.super Ljava/lang/Object;
.source "SocialConnectHelper.java"


# static fields
.field private static MAX_RETRIES:I

.field private static MAX_TIMES_TO_SHOW:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 36
    sput v0, Lcom/amazon/mShop/social/SocialConnectHelper;->MAX_TIMES_TO_SHOW:I

    .line 37
    sput v0, Lcom/amazon/mShop/social/SocialConnectHelper;->MAX_RETRIES:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isFacebookSDKLoaded()Z
    .locals 4

    .prologue
    .line 116
    :try_start_0
    const-string/jumbo v1, "com.facebook.Session"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 117
    const-string/jumbo v1, "com.facebook.SessionState"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 118
    const-string/jumbo v1, "com.facebook.Settings"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 119
    const/4 v1, 0x1

    .line 122
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    :goto_0
    return v1

    .line 120
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_0
    move-exception v0

    .line 121
    .restart local v0    # "e":Ljava/lang/ClassNotFoundException;
    const-string/jumbo v1, "SocialConnectHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Facebook SDK failed to launch: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 122
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static launchSocialConnect(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "refMarker"    # Ljava/lang/String;
    .param p2, "startupTaskId"    # Ljava/lang/String;

    .prologue
    .line 53
    const/4 v0, 0x0

    .line 55
    .local v0, "isShowedSocialConnect":Z
    if-eqz p0, :cond_0

    if-eqz p2, :cond_0

    .line 57
    invoke-static {p0, p2}, Lcom/amazon/mShop/util/ActivityUtils;->startSocialConnectActivity(Landroid/app/Activity;Ljava/lang/String;)V

    .line 59
    const/4 v0, 0x1

    .line 60
    invoke-static {p1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 62
    :cond_0
    return v0
.end method

.method public static passesPreLaunchCheck()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 78
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectHelper;->isFacebookSDKLoaded()Z

    move-result v2

    if-nez v2, :cond_1

    .line 110
    :cond_0
    :goto_0
    return v0

    .line 82
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 87
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->shouldAlwaysDisplay()Z

    move-result v2

    if-nez v2, :cond_2

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->shouldDisplayOnce()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectHelper;->socialConnectHasNotDisplayed()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_2
    move v0, v1

    .line 89
    goto :goto_0

    .line 90
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDebugSettingsActivity;->shouldNeverDisplay()Z

    move-result v2

    if-nez v2, :cond_0

    .line 95
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_social_connect_support:I

    invoke-static {v2}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 100
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->isPrimeUpsellLaunched()Z

    move-result v2

    if-nez v2, :cond_0

    .line 105
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v2

    const-string/jumbo v3, "Android_SocialConnectOOBE"

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    .line 110
    goto :goto_0
.end method

.method static socialConnectFinished(Z)V
    .locals 5
    .param p0, "doNotShowAgain"    # Z

    .prologue
    .line 133
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    .line 134
    .local v1, "applicationContext":Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 136
    .local v0, "account":Ljava/lang/String;
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    .line 140
    .local v2, "dateTimeMs":J
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    move-result-object v4

    invoke-virtual {v4, v0, v2, v3, p0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->recordInteraction(Ljava/lang/String;JZ)V

    .line 141
    return-void
.end method

.method public static socialConnectHasNotDisplayed()Z
    .locals 3

    .prologue
    .line 127
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/Context;

    .line 128
    .local v1, "applicationContext":Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 129
    .local v0, "account":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getInstance()Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/social/SocialConnectDatabaseHelper;->getNumberTimesShown(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method
