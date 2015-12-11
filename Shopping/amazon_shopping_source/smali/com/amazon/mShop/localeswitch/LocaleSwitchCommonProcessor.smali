.class public Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;
.super Ljava/lang/Object;
.source "LocaleSwitchCommonProcessor.java"

# interfaces
.implements Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;Landroid/content/Context;Landroid/content/Intent;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;
    .param p1, "x1"    # Landroid/content/Context;
    .param p2, "x2"    # Landroid/content/Intent;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;->localeChangedCompleted(Landroid/content/Context;Landroid/content/Intent;)V

    return-void
.end method

.method private getLocaleChangedIntent()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 109
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 110
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "com.amazon.mShop.LOCALE_SWITCHED"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 111
    const-string/jumbo v1, "locale"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 112
    return-object v0
.end method

.method private localeChangedCompleted(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "launchIntent"    # Landroid/content/Intent;

    .prologue
    .line 99
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 102
    invoke-static {}, Lcom/amazon/mShop/share/WechatSDKManager;->clearPendingTransaction()V

    .line 103
    invoke-static {p2}, Lcom/amazon/mShop/util/AppUtils;->restartApp(Landroid/content/Intent;)V

    .line 105
    invoke-direct {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;->getLocaleChangedIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 106
    return-void
.end method


# virtual methods
.method public doProcess(Ljava/lang/String;Landroid/content/Context;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V
    .locals 11
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "chain"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    .prologue
    const/4 v10, 0x0

    const/4 v4, 0x1

    const/4 v0, 0x0

    .line 30
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v2

    .line 32
    .local v2, "localeFrom":Ljava/util/Locale;
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 34
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v5

    .line 37
    .local v5, "localeTo":Ljava/util/Locale;
    invoke-static {p1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 38
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v3, "latestLocaleOfCanada"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 40
    .local v8, "latestLocaleOfCanada":Ljava/lang/String;
    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 41
    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v5}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/platform/AppLocale;->isLocaleOfCA(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 42
    .local v4, "switchLocaleInCA":Z
    :goto_0
    new-instance v7, Lcom/amazon/mShop/control/locale/LocaleController;

    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;

    move-object v1, p0

    move-object v3, p2

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor$1;-><init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;Ljava/util/Locale;Landroid/content/Context;ZLjava/util/Locale;Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;)V

    invoke-direct {v7, v0}, Lcom/amazon/mShop/control/locale/LocaleController;-><init>(Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;)V

    .line 68
    .local v7, "controller":Lcom/amazon/mShop/control/locale/LocaleController;
    if-eqz v4, :cond_1

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->config_notifications_changing_language:I

    .line 70
    .local v9, "titleId":I
    :goto_1
    invoke-virtual {p3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->getExistentProgDiag()Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v0

    if-nez v0, :cond_2

    .line 72
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v1, p2}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    move-object v0, p2

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-static {p2, v9, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v10, v0, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->getFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    invoke-virtual {v7, p1, v0}, Lcom/amazon/mShop/control/locale/LocaleController;->switchLanguage(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 90
    .end local v4    # "switchLocaleInCA":Z
    .end local v7    # "controller":Lcom/amazon/mShop/control/locale/LocaleController;
    .end local v8    # "latestLocaleOfCanada":Ljava/lang/String;
    .end local v9    # "titleId":I
    :goto_2
    return-void

    .restart local v8    # "latestLocaleOfCanada":Ljava/lang/String;
    :cond_0
    move v4, v0

    .line 41
    goto :goto_0

    .line 68
    .restart local v4    # "switchLocaleInCA":Z
    .restart local v7    # "controller":Lcom/amazon/mShop/control/locale/LocaleController;
    :cond_1
    sget v9, Lcom/amazon/mShop/android/lib/R$string;->config_notifications_changing_country:I

    goto :goto_1

    .line 76
    .restart local v9    # "titleId":I
    :cond_2
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v1, p2}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    move-object v0, p2

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-static {p2, v9, p1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->getExistentProgDiag()Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v6

    invoke-virtual {v1, v10, v0, v3, v6}, Lcom/amazon/mShop/TaskCallbackFactory;->getLocaleSwitchFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    invoke-virtual {v7, p1, v0}, Lcom/amazon/mShop/control/locale/LocaleController;->switchLanguage(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    goto :goto_2

    .line 87
    .end local v4    # "switchLocaleInCA":Z
    .end local v7    # "controller":Lcom/amazon/mShop/control/locale/LocaleController;
    .end local v8    # "latestLocaleOfCanada":Ljava/lang/String;
    .end local v9    # "titleId":I
    :cond_3
    const-string/jumbo v1, "ch_lc_%1$s"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v5}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v0

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 89
    invoke-virtual {p3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->getLaunchIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-direct {p0, p2, v0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;->localeChangedCompleted(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_2
.end method
