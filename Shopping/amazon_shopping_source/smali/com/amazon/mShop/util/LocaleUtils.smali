.class public Lcom/amazon/mShop/util/LocaleUtils;
.super Ljava/lang/Object;
.source "LocaleUtils.java"


# static fields
.field private static sLocaleSwitchListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/LocaleUtils;->sLocaleSwitchListeners:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addLocaleSwitchListener(Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;)V
    .locals 1
    .param p0, "listener"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;

    .prologue
    .line 192
    sget-object v0, Lcom/amazon/mShop/util/LocaleUtils;->sLocaleSwitchListeners:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 193
    sget-object v0, Lcom/amazon/mShop/util/LocaleUtils;->sLocaleSwitchListeners:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 195
    :cond_0
    return-void
.end method

.method public static changeLocale(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p0, "localeName"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "launchIntent"    # Landroid/content/Intent;

    .prologue
    .line 202
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    .line 204
    .local v1, "fromLocale":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;-><init>(Ljava/lang/String;Landroid/content/Context;Landroid/content/Intent;)V

    .line 205
    .local v0, "chain":Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;
    new-instance v4, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;

    invoke-direct {v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchNotificationProcessor;-><init>()V

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->addProcessor(Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;)Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    move-result-object v4

    new-instance v5, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;

    invoke-direct {v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchCommonProcessor;-><init>()V

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->addProcessor(Lcom/amazon/mShop/localeswitch/LocaleSwitchProcessor;)Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;

    .line 207
    invoke-virtual {v0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchChain;->process()V

    .line 209
    sget-object v4, Lcom/amazon/mShop/util/LocaleUtils;->sLocaleSwitchListeners:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;

    .line 210
    .local v3, "listener":Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;
    invoke-interface {v3, v1, p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;->onLocaleSwitch(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 213
    .end local v3    # "listener":Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;
    :cond_0
    sget-object v4, Lcom/amazon/mShop/util/LocaleUtils;->sLocaleSwitchListeners:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 214
    return-void
.end method

.method public static ensureAppLocale(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v0

    .line 53
    .local v0, "appLocale":Ljava/util/Locale;
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 54
    .local v2, "res":Landroid/content/res/Resources;
    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 55
    .local v1, "config":Landroid/content/res/Configuration;
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 56
    invoke-static {v0}, Ljava/util/Locale;->setDefault(Ljava/util/Locale;)V

    .line 58
    :cond_0
    iget-object v3, v1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v0, v3}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 59
    iput-object v0, v1, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 60
    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Landroid/content/res/Resources;->updateConfiguration(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V

    .line 62
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/DCMInitializer;->updatePreferredMarketplace(Landroid/content/Context;)V

    .line 63
    return-void
.end method

.method public static ensureConfigLocale(Landroid/content/res/Configuration;)V
    .locals 2
    .param p0, "config"    # Landroid/content/res/Configuration;

    .prologue
    .line 87
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v0

    .line 88
    .local v0, "appLocale":Ljava/util/Locale;
    iget-object v1, p0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 89
    iput-object v0, p0, Landroid/content/res/Configuration;->locale:Ljava/util/Locale;

    .line 91
    :cond_0
    return-void
.end method

.method public static helpUserSetLocale(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 160
    sget v4, Lcom/amazon/mShop/android/lib/R$bool;->config_hasLocaleSwitch:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabledForApp(Landroid/content/Context;I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 164
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    .line 165
    .local v3, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getAppStartCountForAllLocales()I

    move-result v0

    .line 166
    .local v0, "appStartCount":I
    if-nez v0, :cond_0

    .line 167
    invoke-static {}, Lcom/amazon/mShop/AmazonApplication;->getDeviceLocaleOnAppCreate()Ljava/util/Locale;

    move-result-object v1

    .line 168
    .local v1, "deviceLocale":Ljava/util/Locale;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/amazon/mShop/platform/AppLocale;->getLocaleName(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    .line 171
    .local v2, "deviceLocaleName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/util/LocaleUtils;->isFromIndia()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 172
    const-string/jumbo v4, "en_IN"

    invoke-static {v4}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 188
    .end local v0    # "appStartCount":I
    .end local v1    # "deviceLocale":Ljava/util/Locale;
    .end local v2    # "deviceLocaleName":Ljava/lang/String;
    .end local v3    # "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    :goto_0
    return-void

    .line 176
    .restart local v0    # "appStartCount":I
    .restart local v1    # "deviceLocale":Ljava/util/Locale;
    .restart local v2    # "deviceLocaleName":Ljava/lang/String;
    .restart local v3    # "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/amazon/mShop/platform/AppLocale;->isSupported(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 179
    const-string/jumbo v4, "fr_CA"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 180
    const-string/jumbo v2, "en_CA"

    .line 182
    :cond_2
    invoke-static {v2}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    goto :goto_0

    .line 184
    :cond_3
    const-string/jumbo v4, "needToSelectLocale"

    const/4 v5, 0x1

    invoke-interface {v3, v4, v5}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public static initLocale(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 126
    sget v3, Lcom/amazon/mShop/android/lib/R$raw;->default_locale:I

    invoke-static {p0, v3}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    .line 127
    .local v1, "defaultLocaleName":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 128
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 131
    :cond_0
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 132
    const-string/jumbo v1, "en_US"

    .line 134
    :cond_1
    invoke-static {v1}, Lcom/amazon/mShop/util/LocaleUtils;->setDefaultAppLocale(Ljava/lang/String;)V

    .line 137
    new-instance v2, Lcom/amazon/mShop/platform/AndroidDataStore;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/platform/AndroidDataStore;-><init>(Landroid/content/Context;)V

    .line 138
    .local v2, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "applicationCurrentLocale"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 139
    .local v0, "currentLocaleName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 140
    move-object v0, v1

    .line 142
    :cond_2
    invoke-static {v0}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 145
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 147
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->helpUserSetLocale(Landroid/content/Context;)V

    .line 148
    return-void
.end method

.method public static isCurrentLocale(Ljava/lang/String;)Z
    .locals 3
    .param p0, "localeName"    # Ljava/lang/String;

    .prologue
    .line 243
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 244
    .local v0, "currentLocaleName":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method

.method public static isFromIndia()Z
    .locals 6

    .prologue
    const/4 v3, 0x1

    .line 217
    invoke-static {}, Lcom/amazon/mShop/AmazonApplication;->getDeviceLocaleOnAppCreate()Ljava/util/Locale;

    move-result-object v0

    .line 218
    .local v0, "deviceLocale":Ljava/util/Locale;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/platform/AppLocale;->getLocaleName(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    .line 219
    .local v1, "deviceLocaleName":Ljava/lang/String;
    const-string/jumbo v4, "en_IN"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 231
    :cond_0
    :goto_0
    return v3

    .line 223
    :cond_1
    const-string/jumbo v4, "GMT+05:30"

    invoke-static {v4}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    .line 226
    .local v2, "indiaTimeZone":Ljava/util/TimeZone;
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v4

    invoke-virtual {v2}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v5

    if-ne v4, v5, :cond_2

    const-string/jumbo v4, "en_GB"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string/jumbo v4, "en_US"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 231
    :cond_2
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static removeLocaleSwitchListener(Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;)V
    .locals 1
    .param p0, "listener"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchActivity$LocaleSwitchListener;

    .prologue
    .line 198
    sget-object v0, Lcom/amazon/mShop/util/LocaleUtils;->sLocaleSwitchListeners:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 199
    return-void
.end method

.method public static setCurrentAppLocale(Ljava/lang/String;)V
    .locals 2
    .param p0, "localeName"    # Ljava/lang/String;

    .prologue
    .line 100
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/platform/AppLocale;->setCurrentLocale(Ljava/lang/String;)Z

    .line 101
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "applicationCurrentLocale"

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    return-void
.end method

.method public static setDefaultAppLocale(Ljava/lang/String;)V
    .locals 1
    .param p0, "localeName"    # Ljava/lang/String;

    .prologue
    .line 110
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/platform/AppLocale;->setDefaultLocale(Ljava/lang/String;)Z

    .line 111
    return-void
.end method
