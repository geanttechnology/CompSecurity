.class Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;
.super Ljava/lang/Object;
.source "MShopVoicePackageProxy.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "VoiceModuleInitializationRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;->this$0:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;Lcom/amazon/mShop/voice/MShopVoicePackageProxy$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
    .param p2, "x1"    # Lcom/amazon/mShop/voice/MShopVoicePackageProxy$1;

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;-><init>(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;)V

    return-void
.end method


# virtual methods
.method getVoiceSearchPackageInterface()Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/InstantiationException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    .line 97
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.shopapp.voice.mshop.VoiceSearchPackage"

    invoke-virtual {v1, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 98
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    return-object v1
.end method

.method public run()V
    .locals 3

    .prologue
    .line 85
    :try_start_0
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v1

    invoke-virtual {v1}, Lamazon/android/dexload/SupplementalDexLoader;->waitForLoad()V

    .line 86
    iget-object v1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;->this$0:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    invoke-virtual {p0}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;->getVoiceSearchPackageInterface()Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    move-result-object v2

    # setter for: Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoicePackage:Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;
    invoke-static {v1, v2}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->access$202(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;)Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    .line 87
    iget-object v1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;->this$0:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    # getter for: Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mIsSuccessfullyInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v1}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->access$300(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 88
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->setIsVoicePackageLoaded(Z)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 92
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;->this$0:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    # getter for: Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoiceModuleLatch:Ljava/util/concurrent/CountDownLatch;
    invoke-static {v1}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->access$500(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 93
    return-void

    .line 89
    :catch_0
    move-exception v0

    .line 90
    .local v0, "e":Ljava/lang/Throwable;
    # getter for: Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->access$400()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Voice module initialization failed"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
