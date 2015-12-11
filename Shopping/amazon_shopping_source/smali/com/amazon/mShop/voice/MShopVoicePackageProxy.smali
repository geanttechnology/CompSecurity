.class public Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
.super Ljava/lang/Object;
.source "MShopVoicePackageProxy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/voice/MShopVoicePackageProxy$1;,
        Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;,
        Lcom/amazon/mShop/voice/MShopVoicePackageProxy$SingletonHolder;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mInitializationStarted:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mIsSuccessfullyInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mVoiceModuleLatch:Ljava/util/concurrent/CountDownLatch;

.field private mVoicePackage:Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

.field private final voiceSearchPackageClassName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mInitializationStarted:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 37
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mIsSuccessfullyInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 42
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoiceModuleLatch:Ljava/util/concurrent/CountDownLatch;

    .line 47
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoicePackage:Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    .line 52
    const-string/jumbo v0, "com.amazon.shopapp.voice.mshop.VoiceSearchPackage"

    iput-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->voiceSearchPackageClassName:Ljava/lang/String;

    .line 81
    return-void
.end method

.method static synthetic access$202(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;)Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
    .param p1, "x1"    # Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoicePackage:Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    return-object p1
.end method

.method static synthetic access$300(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mIsSuccessfullyInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-object v0
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;)Ljava/util/concurrent/CountDownLatch;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoiceModuleLatch:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
    .locals 1

    .prologue
    .line 59
    # getter for: Lcom/amazon/mShop/voice/MShopVoicePackageProxy$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/voice/MShopVoicePackageProxy;
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$SingletonHolder;->access$000()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public initializeMShopVoiceModule()V
    .locals 3

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mInitializationStarted:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Voice module initialization can only be called once"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 70
    :cond_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy$VoiceModuleInitializationRunnable;-><init>(Lcom/amazon/mShop/voice/MShopVoicePackageProxy;Lcom/amazon/mShop/voice/MShopVoicePackageProxy$1;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 71
    return-void
.end method

.method public openVoiceSearch(Landroid/app/Activity;Z)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "isFromSuggestions"    # Z

    .prologue
    .line 107
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mIsSuccessfullyInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoicePackage:Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    if-eqz v1, :cond_0

    .line 108
    iget-object v1, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoicePackage:Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;

    invoke-interface {v1, p1, p2}, Lcom/amazon/shopapp/voice/mshop/VoiceSearchPackageInterface;->startVoiceSearch(Landroid/app/Activity;Z)V

    .line 117
    :goto_0
    return-void

    .line 111
    :cond_0
    sget-object v1, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Voice Search library is not initialized"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 114
    :catch_0
    move-exception v0

    .line 115
    .local v0, "e":Ljava/lang/Throwable;
    sget-object v1, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public waitForInitialization()V
    .locals 4

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->mVoiceModuleLatch:Ljava/util/concurrent/CountDownLatch;

    const-wide/16 v1, 0xa

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/util/ConcurrentUtils;->waitLatchWithTimeOut(Ljava/util/concurrent/CountDownLatch;JLjava/util/concurrent/TimeUnit;)Z

    .line 79
    return-void
.end method
