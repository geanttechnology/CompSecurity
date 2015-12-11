.class public final Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;
.super Ljava/lang/Object;
.source "AIVAvailabilityUtils.java"


# static fields
.field private static final AIV_COMPANION_APP_INTENT:Landroid/content/Intent;

.field private static final AIV_COMPANION_APP_PACKAGE:Ljava/lang/String; = "com.amazon.avod.thirdpartyclient"

.field private static final AIV_COMPANION_SETTINGS_INTENT:Landroid/content/Intent;

.field private static final MIN_SDK:I = 0xf

.field private static final sInitializationLatch:Ljava/util/concurrent/CountDownLatch;

.field private static sIsAIVInitializedSuccessful:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->sIsAIVInitializedSuccessful:Z

    .line 26
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->sInitializationLatch:Ljava/util/concurrent/CountDownLatch;

    .line 28
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->makeAIVCompanionAppIntent()Landroid/content/Intent;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->AIV_COMPANION_APP_INTENT:Landroid/content/Intent;

    .line 29
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->makeAIVCompanionSettingsIntent()Landroid/content/Intent;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->AIV_COMPANION_SETTINGS_INTENT:Landroid/content/Intent;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getSettingsIntent()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 154
    sget-object v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->AIV_COMPANION_SETTINGS_INTENT:Landroid/content/Intent;

    return-object v0
.end method

.method public static isAIVAvailable()Z
    .locals 1

    .prologue
    .line 53
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->waitForAIVInitialize()V

    .line 54
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasAIV:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVTurnedOnByWeblabAndBuild()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-boolean v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->sIsAIVInitializedSuccessful:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->isSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isAIVCompanionAppInstalled(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 93
    if-nez p0, :cond_0

    .line 94
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Context cannot be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 97
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->AIV_COMPANION_APP_INTENT:Landroid/content/Intent;

    invoke-virtual {v2, v3, v1}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v0

    .line 98
    .local v0, "resolveInfo":Landroid/content/pm/ResolveInfo;
    if-eqz v0, :cond_1

    const/4 v1, 0x1

    :cond_1
    return v1
.end method

.method public static isAIVSupportedByDevice()Z
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 77
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xf

    if-lt v4, v5, :cond_0

    move v1, v2

    .line 80
    .local v1, "isOsVersionSupported":Z
    :goto_0
    sget-object v4, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "arm"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    .line 82
    .local v0, "isArchSupported":Z
    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    :goto_1
    return v2

    .end local v0    # "isArchSupported":Z
    .end local v1    # "isOsVersionSupported":Z
    :cond_0
    move v1, v3

    .line 77
    goto :goto_0

    .restart local v0    # "isArchSupported":Z
    .restart local v1    # "isOsVersionSupported":Z
    :cond_1
    move v2, v3

    .line 82
    goto :goto_1
.end method

.method public static isAIVTurnedOnByWeblabAndBuild()Z
    .locals 2

    .prologue
    .line 66
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    const-string/jumbo v1, "Android_ShopAppAIV"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isCompanionSettingsPageAvailable(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 130
    invoke-static {p0}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVCompanionAppInstalled(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 135
    :cond_0
    :goto_0
    return v1

    .line 134
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->AIV_COMPANION_SETTINGS_INTENT:Landroid/content/Intent;

    invoke-virtual {v2, v3, v1}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v0

    .line 135
    .local v0, "resolveInfo":Landroid/content/pm/ResolveInfo;
    if-eqz v0, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method private static makeAIVCompanionAppIntent()Landroid/content/Intent;
    .locals 4

    .prologue
    .line 106
    new-instance v0, Landroid/content/ComponentName;

    const-string/jumbo v2, "com.amazon.avod.thirdpartyclient"

    const-string/jumbo v3, "com.amazon.avod.thirdpartyclient.LauncherActivity"

    invoke-direct {v0, v2, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    .local v0, "companionComponent":Landroid/content/ComponentName;
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 109
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 110
    return-object v1
.end method

.method private static makeAIVCompanionSettingsIntent()Landroid/content/Intent;
    .locals 4

    .prologue
    .line 118
    new-instance v0, Landroid/content/ComponentName;

    const-string/jumbo v2, "com.amazon.avod.thirdpartyclient"

    const-string/jumbo v3, "com.amazon.avod.thirdpartyclient.SettingsActivity"

    invoke-direct {v0, v2, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    .local v0, "companionComponent":Landroid/content/ComponentName;
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 121
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 122
    return-object v1
.end method

.method public static setIsAIVInitialized(Z)V
    .locals 1
    .param p0, "successful"    # Z

    .prologue
    .line 139
    sput-boolean p0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->sIsAIVInitializedSuccessful:Z

    .line 140
    sget-object v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->sInitializationLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 141
    return-void
.end method

.method public static waitForAIVInitialize()V
    .locals 4

    .prologue
    .line 146
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasAIV:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->isAIVSupportedByDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 147
    sget-object v0, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->sInitializationLatch:Ljava/util/concurrent/CountDownLatch;

    const-wide/16 v1, 0xa

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/util/ConcurrentUtils;->waitLatchWithTimeOut(Ljava/util/concurrent/CountDownLatch;JLjava/util/concurrent/TimeUnit;)Z

    .line 151
    :cond_0
    return-void
.end method
