.class public Lcom/amazon/mShop/util/AppUtils;
.super Ljava/lang/Object;
.source "AppUtils.java"


# static fields
.field private static sLaunchIntent:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/util/AppUtils;->sLaunchIntent:Landroid/content/Intent;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clearUserCoinBalance()V
    .locals 2

    .prologue
    .line 284
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    .line 285
    .local v0, "adapter":Lcom/amazon/mShop/gno/GNOItemAdapter;
    const-string/jumbo v1, "DISABLED"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNOItemAdapter;->setAppstoreCoinsCount(Ljava/lang/String;)V

    .line 286
    return-void
.end method

.method public static exitApp()V
    .locals 2

    .prologue
    .line 234
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 235
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->resetStatus()V

    .line 237
    invoke-static {v0}, Lcom/amazon/mShop/ActivityTerminationReceiver;->sendTerminationBroadcast(Landroid/content/Context;)V

    .line 238
    return-void
.end method

.method public static isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "appPackageName"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 48
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 49
    const-string/jumbo v4, "Amazon.AppUtils"

    const-string/jumbo v5, "package name is empty."

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 62
    :cond_0
    :goto_0
    return v0

    .line 52
    :cond_1
    const/4 v0, 0x0

    .line 54
    .local v0, "appInstalled":Z
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 55
    .local v2, "manager":Landroid/content/pm/PackageManager;
    const/4 v4, 0x0

    invoke-virtual {v2, p1, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 56
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v3, :cond_0

    .line 57
    const/4 v0, 0x1

    goto :goto_0

    .line 59
    .end local v2    # "manager":Landroid/content/pm/PackageManager;
    .end local v3    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v1

    .line 60
    .local v1, "ex":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isApplicationForeground()Z
    .locals 1

    .prologue
    .line 203
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static launchApp(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 154
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/amazon/mShop/util/AppUtils;->launchApp(Landroid/content/Context;Z)V

    .line 155
    return-void
.end method

.method public static launchApp(Landroid/content/Context;Z)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "noNeedCountAppStart"    # Z

    .prologue
    const/4 v3, 0x0

    .line 112
    sget-object v2, Lcom/amazon/mShop/util/AppUtils;->sLaunchIntent:Landroid/content/Intent;

    if-eqz v2, :cond_1

    .line 113
    sget-object v2, Lcom/amazon/mShop/util/AppUtils;->sLaunchIntent:Landroid/content/Intent;

    invoke-virtual {p0, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 114
    sput-object v3, Lcom/amazon/mShop/util/AppUtils;->sLaunchIntent:Landroid/content/Intent;

    .line 151
    :cond_0
    :goto_0
    return-void

    .line 116
    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 117
    .local v1, "manager":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 118
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 119
    const/high16 v2, 0x10000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 140
    const/high16 v2, 0x200000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 141
    const-string/jumbo v2, "android.intent.action.MAIN"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 142
    const-string/jumbo v2, "android.intent.category.LAUNCHER"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 143
    invoke-virtual {v0, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 146
    const-string/jumbo v2, "INTENT_EXTRA_STARTED_NO_NEED_COUNT_APPSTART"

    invoke-virtual {v0, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 148
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static resetStatus()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 71
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 72
    .local v0, "context":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/mobileads/AdsHelper;->resetIfNecessary(Landroid/content/Context;)V

    .line 74
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 75
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 76
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->clearUser()V

    .line 78
    invoke-static {v2}, Lcom/amazon/mShop/control/home/HomeController;->setInstance(Lcom/amazon/mShop/control/home/HomeController;)V

    .line 79
    invoke-static {v2}, Lcom/amazon/mShop/control/cart/CartController;->setInstance(Lcom/amazon/mShop/control/cart/CartController;)V

    .line 80
    invoke-static {v2}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->setInstance(Lcom/amazon/mShop/control/wishlist/WishListManageController;)V

    .line 82
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->resetApplicationId()V

    .line 86
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/feature/Features;->resetStatus()V

    .line 91
    invoke-static {}, Lcom/amazon/mShop/util/BadgeUtils;->clearCachedBadge()V

    .line 93
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->resetDefaultImage()V

    .line 96
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->clearInstance()V

    .line 100
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->stopSync()V

    .line 101
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->startSync()V

    .line 104
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->getInstance()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    move-result-object v1

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->reset(Ljava/util/Locale;)V

    .line 107
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->reset()V

    .line 108
    return-void
.end method

.method public static restartApp()V
    .locals 2

    .prologue
    .line 162
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/util/AppUtils$1;

    invoke-direct {v1}, Lcom/amazon/mShop/util/AppUtils$1;-><init>()V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 169
    return-void
.end method

.method public static restartApp(Landroid/content/Intent;)V
    .locals 2
    .param p0, "launchIntent"    # Landroid/content/Intent;

    .prologue
    .line 184
    sput-object p0, Lcom/amazon/mShop/util/AppUtils;->sLaunchIntent:Landroid/content/Intent;

    .line 185
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 192
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->resetStatus()V

    .line 195
    invoke-static {v0}, Lcom/amazon/mShop/ActivityTerminationReceiver;->sendTerminationBroadcast(Landroid/content/Context;)V

    .line 199
    const/4 v1, 0x1

    invoke-static {v1}, Lcom/amazon/mShop/AmazonActivity;->setNeedRestart(Z)V

    .line 200
    return-void
.end method

.method public static sendRequestCoinBalanceBroadcast(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 277
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 278
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "com.amazon.mShop.appstore.coin.requestCoin"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 279
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 281
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public static showSwitchLocaleDialog(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    .locals 5
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "loacleName"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "launchIntent"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x0

    .line 250
    new-instance v1, Lcom/amazon/mShop/util/AppUtils$2;

    invoke-direct {v1, p0, p1, p3}, Lcom/amazon/mShop/util/AppUtils$2;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Landroid/content/Intent;)V

    .line 264
    .local v1, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    new-instance v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 265
    .local v2, "switchLocaleDialogBuilder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->public_url_switch_locale_title:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 266
    invoke-virtual {v2, p2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 268
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->yes:I

    invoke-virtual {v2, v3, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 269
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->no:I

    invoke-virtual {v2, v3, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 270
    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    .line 271
    .local v0, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog;->setCancelable(Z)V

    .line 272
    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 273
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 274
    return-void
.end method
