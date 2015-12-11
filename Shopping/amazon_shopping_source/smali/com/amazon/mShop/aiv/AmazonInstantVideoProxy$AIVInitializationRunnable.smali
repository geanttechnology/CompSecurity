.class Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AIVInitializationRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Landroid/content/Context;)V
    .locals 0
    .param p2, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;
    invoke-static {p1, p2}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$102(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Landroid/content/Context;)Landroid/content/Context;

    .line 76
    return-void
.end method

.method private initializeReflectively(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Object;
    .locals 10
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 118
    const-string/jumbo v4, "AmazonApplication"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "loading and initializing class "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 120
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string/jumbo v4, "getInstance"

    new-array v5, v8, [Ljava/lang/Class;

    invoke-virtual {v0, v4, v5}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 121
    .local v2, "getInstance":Ljava/lang/reflect/Method;
    const/4 v4, 0x0

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {v2, v4, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 122
    .local v1, "component":Ljava/lang/Object;, "TT;"
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const-string/jumbo v5, "initialize"

    new-array v6, v9, [Ljava/lang/Class;

    const-class v7, Landroid/content/Context;

    aput-object v7, v6, v8

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 123
    .local v3, "initializeMethod":Ljava/lang/reflect/Method;
    new-array v4, v9, [Ljava/lang/Object;

    aput-object p2, v4, v8

    invoke-virtual {v3, v1, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    return-object v1
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 80
    const/4 v2, 0x0

    .line 82
    .local v2, "initializedSuccessful":Z
    :try_start_0
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v4

    invoke-virtual {v4}, Lamazon/android/dexload/SupplementalDexLoader;->waitForLoad()V

    .line 83
    iget-object v5, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    const-string/jumbo v4, "com.amazon.avod.MShopAmazonInstantVideoDelegate"

    iget-object v6, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    # getter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;
    invoke-static {v6}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$100(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v4, v6}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->initializeReflectively(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/avod/MShopAmazonInstantVideo;

    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;
    invoke-static {v5, v4}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$202(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/avod/MShopAmazonInstantVideo;)Lcom/amazon/avod/MShopAmazonInstantVideo;

    .line 85
    iget-object v5, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    const-string/jumbo v4, "com.amazon.avod.playbackclient.settings.page.MobileStreamingQualitySettingsFragmentFactoryDelegate"

    iget-object v6, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    # getter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;
    invoke-static {v6}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$100(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Landroid/content/Context;

    move-result-object v6

    invoke-direct {p0, v4, v6}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->initializeReflectively(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;

    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMobileStreamingQualitySettingsFragmentFactory:Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;
    invoke-static {v5, v4}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$302(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;)Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;

    .line 89
    new-instance v3, Lcom/amazon/avod/sdk/AmazonInstantVideo;

    iget-object v4, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    # getter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mApplicationContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$100(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/avod/sdk/AmazonInstantVideo;-><init>(Landroid/content/Context;)V

    .line 91
    .local v3, "sdkLauncher":Lcom/amazon/avod/sdk/AmazonInstantVideo;
    new-instance v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable$1;-><init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;)V

    .line 100
    .local v0, "callback":Lcom/amazon/avod/sdk/PlaybackSupportResponse;
    invoke-virtual {v3, v0}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V

    .line 101
    invoke-virtual {v3}, Lcom/amazon/avod/sdk/AmazonInstantVideo;->cleanup()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    const/4 v2, 0x1

    .line 109
    .end local v0    # "callback":Lcom/amazon/avod/sdk/PlaybackSupportResponse;
    .end local v3    # "sdkLauncher":Lcom/amazon/avod/sdk/AmazonInstantVideo;
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    # getter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mAivInitializedLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v4}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$800(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 110
    invoke-static {v2}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->setIsAIVInitialized(Z)V

    .line 111
    return-void

    .line 104
    :catch_0
    move-exception v1

    .line 105
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v4, "AmazonApplication"

    const-string/jumbo v5, "AIV initialization failed, falling back to silently disabling AIV integration"

    invoke-static {v4, v5, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 106
    iget-object v4, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    new-instance v5, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$MShopNoopAmazonInstantVideo;

    invoke-direct {v5, v7}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$MShopNoopAmazonInstantVideo;-><init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;)V

    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMShopAmazonInstantVideo:Lcom/amazon/avod/MShopAmazonInstantVideo;
    invoke-static {v4, v5}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$202(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/avod/MShopAmazonInstantVideo;)Lcom/amazon/avod/MShopAmazonInstantVideo;

    .line 107
    iget-object v4, p0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$AIVInitializationRunnable;->this$0:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    new-instance v5, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$NoopMobileStreamingQualitySettingsFragmentFactory;

    invoke-direct {v5, v7}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$NoopMobileStreamingQualitySettingsFragmentFactory;-><init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;)V

    # setter for: Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->mMobileStreamingQualitySettingsFragmentFactory:Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;
    invoke-static {v4, v5}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->access$302(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;)Lcom/amazon/avod/playbackclient/settings/page/MobileStreamingQualitySettingsFragmentFactory;

    goto :goto_0
.end method
