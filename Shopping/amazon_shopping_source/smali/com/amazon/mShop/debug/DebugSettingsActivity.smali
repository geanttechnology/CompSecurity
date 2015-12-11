.class public Lcom/amazon/mShop/debug/DebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "DebugSettingsActivity.java"


# instance fields
.field protected mLocaleRelatedSettings:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 33
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsActivity;->mLocaleRelatedSettings:Ljava/util/Map;

    return-void
.end method

.method private getSettingValueByLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "dataStoreKey"    # Ljava/lang/String;

    .prologue
    .line 85
    const/4 v1, 0x0

    .line 86
    .local v1, "value":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsActivity;->mLocaleRelatedSettings:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 87
    .local v0, "settings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 88
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "value":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 90
    .restart local v1    # "value":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method private saveToDataStore(Ljava/lang/String;)V
    .locals 6
    .param p1, "newLocaleName"    # Ljava/lang/String;

    .prologue
    .line 127
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->setCurrentAppLocale(Ljava/lang/String;)V

    .line 130
    iget-object v5, p0, Lcom/amazon/mShop/debug/DebugSettingsActivity;->mLocaleRelatedSettings:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    .line 131
    .local v4, "settingsSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 132
    .local v3, "settings":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 133
    .local v1, "localeName":Ljava/lang/String;
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 134
    .local v2, "localeSpecificSettingsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, v1, v2}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->saveToDataStore(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 136
    .end local v1    # "localeName":Ljava/lang/String;
    .end local v2    # "localeSpecificSettingsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "settings":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_0
    return-void
.end method

.method private saveToDataStore(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 65
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-interface {v0, p2, p3, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    return-void
.end method

.method private saveToDataStore(Ljava/lang/String;Ljava/util/Map;)V
    .locals 6
    .param p1, "localeName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p2, "localeSpecificSettingsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    .line 111
    .local v2, "s":Ljava/util/Set;, "Ljava/util/Set<Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 112
    .local v3, "settingsEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 113
    .local v1, "key":Ljava/lang/String;
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 114
    .local v4, "value":Ljava/lang/String;
    const-string/jumbo v5, "clearSessionData"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 115
    invoke-static {v4}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 116
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v5

    invoke-interface {v5, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->removeSessionData(Ljava/lang/String;)V

    goto :goto_0

    .line 120
    :cond_1
    invoke-direct {p0, p1, v1, v4}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->saveToDataStore(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 123
    .end local v1    # "key":Ljava/lang/String;
    .end local v3    # "settingsEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "value":Ljava/lang/String;
    :cond_2
    return-void
.end method


# virtual methods
.method public final getClearSessionDataSettingInMap(Ljava/lang/String;)Z
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 81
    const-string/jumbo v0, "clearSessionData"

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getSettingValueByLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public final getSSOCheckLoginServerInMap(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 77
    const-string/jumbo v0, "currentSSOCheckLoginServer"

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getSettingValueByLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getServiceSecureUrlInMap(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 73
    const-string/jumbo v0, "currentServiceSecureUrl"

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getSettingValueByLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getServiceUrlInMap(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 69
    const-string/jumbo v0, "currentServiceUrl"

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->getSettingValueByLocale(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected initSettingsMap()V
    .locals 8

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/debug/DebugSettingsActivity;->mLocaleRelatedSettings:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 38
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AppLocale;->getSupportedLocaleNameArray()[Ljava/lang/Object;

    move-result-object v7

    .line 39
    .local v7, "localeNameArray":[Ljava/lang/Object;
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    array-length v0, v7

    if-ge v6, v0, :cond_0

    .line 40
    aget-object v1, v7, v6

    check-cast v1, Ljava/lang/String;

    .line 41
    .local v1, "localeName":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->readServiceUrlFromDataStore(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 42
    .local v2, "url":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->readServiceSecureUrlFromDataStore(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 43
    .local v3, "secureUrl":Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->readSSOCheckLoginServerFromDataStore(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 44
    .local v4, "ssoCheckLoginServer":Ljava/lang/String;
    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->recordInMap(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 39
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 46
    .end local v1    # "localeName":Ljava/lang/String;
    .end local v2    # "url":Ljava/lang/String;
    .end local v3    # "secureUrl":Ljava/lang/String;
    .end local v4    # "ssoCheckLoginServer":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 25
    invoke-virtual {p0}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->initSettingsMap()V

    .line 26
    new-instance v0, Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/debug/DebugSettingsView;-><init>(Lcom/amazon/mShop/debug/DebugSettingsActivity;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->pushView(Landroid/view/View;)V

    .line 27
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 148
    const/4 v0, 0x0

    return v0
.end method

.method public final readSSOCheckLoginServerFromDataStore(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 105
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "currentSSOCheckLoginServer"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public final readServiceSecureUrlFromDataStore(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 99
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 100
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "currentServiceSecureUrl"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public final readServiceUrlFromDataStore(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "localeName"    # Ljava/lang/String;

    .prologue
    .line 94
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 95
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "currentServiceUrl"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public recordInMap(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 3
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "serviceUrl"    # Ljava/lang/String;
    .param p3, "serviceSecureUrl"    # Ljava/lang/String;
    .param p4, "ssoCheckLoginServer"    # Ljava/lang/String;
    .param p5, "clearSessionData"    # Z

    .prologue
    .line 51
    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsActivity;->mLocaleRelatedSettings:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 52
    .local v0, "settings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 53
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "settings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 54
    .restart local v0    # "settings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/mShop/debug/DebugSettingsActivity;->mLocaleRelatedSettings:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    :cond_0
    const-string/jumbo v1, "currentServiceUrl"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    const-string/jumbo v1, "currentServiceSecureUrl"

    invoke-interface {v0, v1, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    const-string/jumbo v1, "clearSessionData"

    invoke-static {p5}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    const-string/jumbo v1, "currentSSOCheckLoginServer"

    invoke-interface {v0, v1, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    return-void
.end method

.method public saveChangesAndRestart(Ljava/lang/String;)V
    .locals 0
    .param p1, "newLocaleName"    # Ljava/lang/String;

    .prologue
    .line 139
    invoke-direct {p0, p1}, Lcom/amazon/mShop/debug/DebugSettingsActivity;->saveToDataStore(Ljava/lang/String;)V

    .line 140
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 141
    return-void
.end method
