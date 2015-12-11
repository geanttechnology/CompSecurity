.class public Lcom/amazon/mShop/AppExtensionsInitializer;
.super Ljava/lang/Object;
.source "AppExtensionsInitializer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AppExtensionsInitializer$1;,
        Lcom/amazon/mShop/AppExtensionsInitializer$AppWeblabClient;,
        Lcom/amazon/mShop/AppExtensionsInitializer$AppFeatureConfiguration;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    return-void
.end method

.method public static initializeSearch(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 26
    new-instance v0, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;-><init>()V

    .line 27
    .local v0, "settings":Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->setDebugMode(Z)V

    .line 28
    new-instance v1, Lcom/amazon/mShop/AppExtensionsInitializer$AppFeatureConfiguration;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/AppExtensionsInitializer$AppFeatureConfiguration;-><init>(Lcom/amazon/mShop/AppExtensionsInitializer$1;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->setFeatureConfiguration(Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)V

    .line 29
    new-instance v1, Lcom/amazon/mShop/AppExtensionsInitializer$AppWeblabClient;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/AppExtensionsInitializer$AppWeblabClient;-><init>(Lcom/amazon/mShop/AppExtensionsInitializer$1;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->setWeblabClient(Lcom/amazon/retailsearch/android/api/experimentation/WeblabClient;)V

    .line 30
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->setUserAgent(Ljava/lang/String;)V

    .line 31
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;->setAppVersion(Ljava/lang/String;)V

    .line 34
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->getInstance()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    move-result-object v1

    invoke-virtual {v1, p0, v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->initialize(Landroid/content/Context;Lcom/amazon/retailsearch/android/api/init/RetailSearchInitSettings;)V

    .line 35
    return-void
.end method
