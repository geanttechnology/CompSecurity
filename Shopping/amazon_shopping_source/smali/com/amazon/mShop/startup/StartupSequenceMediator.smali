.class public Lcom/amazon/mShop/startup/StartupSequenceMediator;
.super Lcom/amazon/mShop/util/mediator/MediatorImpl;
.source "StartupSequenceMediator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;
    }
.end annotation


# static fields
.field private static final sExecutor:Ljava/util/concurrent/Executor;


# instance fields
.field private final mFeatureStateubscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;

.field private mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

.field final mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->sExecutor:Ljava/util/concurrent/Executor;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/splashscreen/StartupActivity;)V
    .locals 20
    .param p1, "activity"    # Lcom/amazon/mShop/splashscreen/StartupActivity;

    .prologue
    .line 94
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/util/mediator/MediatorImpl;-><init>()V

    .line 460
    new-instance v19, Lcom/amazon/mShop/startup/StartupSequenceMediator$16;

    invoke-direct/range {v19 .. v20}, Lcom/amazon/mShop/startup/StartupSequenceMediator$16;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;)V

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mFeatureStateubscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    .line 566
    const/16 v19, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    .line 96
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    .line 99
    new-instance v18, Lcom/amazon/mShop/startup/StartupSequenceMediator$1;

    const-string/jumbo v19, "taskUserAgreement"

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object/from16 v2, p0

    move-object/from16 v3, v19

    move-object/from16 v4, p1

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/startup/StartupSequenceMediator$1;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 111
    .local v18, "taskUserAgreement":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "initial"

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 112
    const-string/jumbo v19, "agreement"

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 113
    const-string/jumbo v19, "network"

    invoke-virtual/range {v18 .. v19}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 117
    new-instance v15, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;

    const-string/jumbo v19, "taskSetCountry"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v15, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$2;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 127
    .local v15, "taskSetCountry":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "agreement"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 128
    const-string/jumbo v19, "locale"

    move-object/from16 v0, v19

    invoke-virtual {v15, v0}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 131
    new-instance v9, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;

    const-string/jumbo v19, "taskGetCookiesAndAccount"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v9, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 156
    .local v9, "taskGetCookies":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "network"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 157
    const-string/jumbo v19, "locale"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 158
    const-string/jumbo v19, "cookiesAccounts"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 161
    new-instance v6, Lcom/amazon/mShop/startup/StartupSequenceMediator$4;

    const-string/jumbo v19, "taskAppstoreCookie"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v6, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$4;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 182
    .local v6, "taskAppstoreCookie":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "cookiesAccounts"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 183
    const-string/jumbo v19, "appstore_device_info_cookie"

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 186
    new-instance v13, Lcom/amazon/mShop/startup/StartupSequenceMediator$5;

    const-string/jumbo v19, "taskRequestCoinBalance"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v13, v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator$5;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    .line 194
    .local v13, "taskRequestCoinBalance":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "cookiesAccounts"

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 197
    new-instance v10, Lcom/amazon/mShop/startup/StartupSequenceMediator$6;

    const-string/jumbo v19, "taskGetFeatureState"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v10, v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator$6;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    .line 204
    .local v10, "taskGetFeatureState":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "appstore_device_info_cookie"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 205
    const-string/jumbo v19, "feature_state"

    move-object/from16 v0, v19

    invoke-virtual {v10, v0}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 208
    new-instance v11, Lcom/amazon/mShop/startup/StartupSequenceMediator$7;

    const-string/jumbo v19, "taskPostFacebookEvent"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v11, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$7;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 220
    .local v11, "taskPostFacebookEvent":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "feature_state"

    move-object/from16 v0, v19

    invoke-virtual {v11, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 223
    new-instance v12, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;

    const-string/jumbo v19, "taskPrimeUpsell"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v12, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$8;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 244
    .local v12, "taskPrimeUpsell":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "feature_state"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 245
    const-string/jumbo v19, "prime_upsell"

    move-object/from16 v0, v19

    invoke-virtual {v12, v0}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 247
    new-instance v16, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;

    const-string/jumbo v19, "taskSocialConnect"

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move-object/from16 v2, p0

    move-object/from16 v3, v19

    move-object/from16 v4, p1

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/mShop/startup/StartupSequenceMediator$9;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 264
    .local v16, "taskSocialConnect":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "feature_state"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 265
    const-string/jumbo v19, "prime_upsell"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 266
    const-string/jumbo v19, "social_connect"

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 270
    new-instance v5, Lcom/amazon/mShop/startup/StartupSequenceMediator$10;

    const-string/jumbo v19, "taskAppExtensionsIntialization"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v5, v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator$10;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    .line 281
    .local v5, "taskAppExtensionsInitializationTask":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "prime_upsell"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 282
    const-string/jumbo v19, "app_extensions_initailization"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 283
    const-string/jumbo v19, "social_connect"

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 286
    new-instance v8, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;

    const-string/jumbo v19, "taskGateWay"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v8, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$11;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 332
    .local v8, "taskGateWay":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "app_extensions_initailization"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 333
    const-string/jumbo v19, "social_connect"

    move-object/from16 v0, v19

    invoke-virtual {v8, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 336
    new-instance v14, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;

    const-string/jumbo v19, "taskSSOWelcome"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v14, v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator$12;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    .line 364
    .local v14, "taskSSOWelcome":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "app_extensions_initailization"

    move-object/from16 v0, v19

    invoke-virtual {v14, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 367
    new-instance v17, Lcom/amazon/mShop/startup/StartupSequenceMediator$13;

    const-string/jumbo v19, "taskSyncSmileInfo"

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move-object/from16 v2, p0

    move-object/from16 v3, v19

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$13;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    .line 388
    .local v17, "taskSyncSmile":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "feature_state"

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 390
    new-instance v7, Lcom/amazon/mShop/startup/StartupSequenceMediator$14;

    const-string/jumbo v19, "taskDeviceRegister"

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    move-object/from16 v3, p1

    invoke-direct {v7, v0, v1, v2, v3}, Lcom/amazon/mShop/startup/StartupSequenceMediator$14;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 412
    .local v7, "taskDeviceRegister":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v19, "feature_state"

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Lcom/amazon/mShop/startup/StartupTask;->addInputDependency(Ljava/lang/String;)V

    .line 413
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/startup/StartupSequenceMediator;Landroid/content/Context;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;
    .param p1, "x1"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->handleCookiesAndAccount(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$100()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->sExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/startup/StartupTask;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;
    .param p1, "x1"    # Lcom/amazon/mShop/startup/StartupTask;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->requestFeatureStates(Lcom/amazon/mShop/startup/StartupTask;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/startup/StartupSequenceMediator;Landroid/content/Context;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;
    .param p1, "x1"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->postFaceBookAdvertisedInstallationEvent(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/splashscreen/StartupActivity;Lcom/amazon/mShop/startup/StartupTask;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;
    .param p1, "x1"    # Lcom/amazon/mShop/splashscreen/StartupActivity;
    .param p2, "x2"    # Lcom/amazon/mShop/startup/StartupTask;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->checkPrimeFlag(Lcom/amazon/mShop/splashscreen/StartupActivity;Lcom/amazon/mShop/startup/StartupTask;)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Lcom/amazon/mShop/feature/FeatureStateSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mFeatureStateubscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/startup/StartupSequenceMediator;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/startup/StartupSequenceMediator;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->isAppFirstStart()Z

    move-result v0

    return v0
.end method

.method private checkPrimeFlag(Lcom/amazon/mShop/splashscreen/StartupActivity;Lcom/amazon/mShop/startup/StartupTask;)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/splashscreen/StartupActivity;
    .param p2, "task"    # Lcom/amazon/mShop/startup/StartupTask;

    .prologue
    .line 571
    new-instance v0, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;

    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$19;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    .line 587
    .local v0, "subscriber":Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;
    new-instance v1, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    invoke-direct {v1, v0}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;-><init>(Lcom/amazon/mShop/primeupsell/PrimeFlagChecker$Subscriber;)V

    iput-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    .line 588
    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mPrimeFlagChecker:Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;

    invoke-virtual {v1}, Lcom/amazon/mShop/primeupsell/PrimeFlagChecker;->checkFlag()V

    .line 589
    return-void
.end method

.method private gatherOpenGlExtentions()V
    .locals 3

    .prologue
    .line 598
    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 599
    invoke-static {}, Lcom/amazon/android/dagger/DaggerAndroid;->getGraph()Ldagger/ObjectGraph;

    move-result-object v1

    const-class v2, Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;

    invoke-virtual {v1, v2}, Ldagger/ObjectGraph;->get(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;

    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v1, v2}, Lcom/amazon/mas/client/device/software/opengl/OpenGlActivityInterrogator;->interrogate(Landroid/app/Activity;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 605
    :cond_0
    :goto_0
    return-void

    .line 601
    :catch_0
    move-exception v0

    .line 603
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "StartupSequenceMediator"

    const-string/jumbo v2, "AppStore initialize might time out"

    invoke-static {v1, v2, v0}, Lcom/amazon/mShop/util/DebugUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private handleCookiesAndAccount(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 457
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOInit(Landroid/content/Context;)V

    .line 458
    return-void
.end method

.method private isAppFirstStart()Z
    .locals 1

    .prologue
    .line 552
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getAppStartCountForAllLocales()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isFirstStartOnCurrentMarketplace()Z
    .locals 3

    .prologue
    .line 561
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 562
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v2, "applicationStartCount"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 563
    .local v0, "appStartCount":I
    if-nez v0, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private postFaceBookAdvertisedInstallationEvent(Landroid/content/Context;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 525
    invoke-direct {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->isAppFirstStart()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 526
    invoke-static {p1}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->getFaceBookAttributionId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 527
    .local v0, "attributionId":Ljava/lang/String;
    const/4 v3, 0x0

    .line 528
    .local v3, "eventValue":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 529
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;-><init>()V

    .line 531
    .local v4, "request":Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;-><init>()V

    .line 532
    .local v1, "event":Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "{\"attribution_id\":\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "\"}"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 533
    const-string/jumbo v5, "mobile_app_install"

    invoke-virtual {v1, v5}, Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;->setName(Ljava/lang/String;)V

    .line 534
    invoke-virtual {v1, v3}, Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;->setValue(Ljava/lang/String;)V

    .line 535
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 536
    .local v2, "eventList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;>;"
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 537
    invoke-virtual {v4, v2}, Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;->setEvents(Ljava/util/List;)V

    .line 539
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v5

    new-instance v6, Lcom/amazon/mShop/startup/StartupSequenceMediator$18;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$18;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;)V

    invoke-interface {v5, v4, v6}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->postEvents(Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 549
    .end local v0    # "attributionId":Ljava/lang/String;
    .end local v1    # "event":Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;
    .end local v2    # "eventList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/DeviceEvent;>;"
    .end local v3    # "eventValue":Ljava/lang/String;
    .end local v4    # "request":Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;
    :cond_0
    return-void
.end method

.method private requestFeatureStates(Lcom/amazon/mShop/startup/StartupTask;)V
    .locals 5
    .param p1, "task"    # Lcom/amazon/mShop/startup/StartupTask;

    .prologue
    .line 490
    const/4 v1, 0x0

    new-array v0, v1, [Ljava/lang/String;

    .line 492
    .local v0, "cachedFeatureCheck":[Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-static {v1}, Lcom/amazon/mShop/util/BuildUtils;->isVersionUpdate(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-direct {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->isFirstStartOnCurrentMarketplace()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/feature/Features;->areFeaturesCached([Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 493
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mFeatureStateubscriber:Lcom/amazon/mShop/feature/FeatureStateSubscriber;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/feature/Features;->addFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 494
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/feature/Features;->fetchFeatureStates(Z)V

    .line 497
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    new-instance v2, Lcom/amazon/mShop/startup/StartupSequenceMediator$17;

    invoke-direct {v2, p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$17;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/startup/StartupTask;)V

    const-wide/16 v3, 0x2710

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 505
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->shouldCheckUpgrade()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 506
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->checkForUpgrade()V

    .line 515
    :cond_1
    :goto_0
    return-void

    .line 510
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/mShop/startup/StartupTask;->getId()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->shouldCheckUpgrade()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 512
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->checkForUpgradeLater()V

    goto :goto_0
.end method


# virtual methods
.method public endTask(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "taskId"    # Ljava/lang/String;
    .param p2, "result"    # Ljava/lang/String;

    .prologue
    .line 432
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 439
    :cond_0
    :goto_0
    return-void

    .line 435
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mTasks:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/util/mediator/Task;

    .line 436
    .local v0, "task":Lcom/amazon/mShop/util/mediator/Task;
    if-eqz v0, :cond_0

    .line 437
    invoke-interface {v0, p2}, Lcom/amazon/mShop/util/mediator/Task;->end(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "dependency"    # Ljava/lang/String;

    .prologue
    .line 443
    const-string/jumbo v0, "agreement"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 444
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator;->mStartupActivity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/splashscreen/StartupActivity;->finish()V

    .line 450
    :goto_0
    return-void

    .line 448
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/util/mediator/MediatorImpl;->onReady(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public start()V
    .locals 2

    .prologue
    .line 417
    invoke-direct {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->gatherOpenGlExtentions()V

    .line 420
    new-instance v0, Lcom/amazon/mShop/startup/StartupSequenceMediator$15;

    const-string/jumbo v1, "taskInit"

    invoke-direct {v0, p0, p0, v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$15;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    .line 427
    .local v0, "taskInit":Lcom/amazon/mShop/startup/StartupTask;
    const-string/jumbo v1, "initial"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/StartupTask;->addOutputDependency(Ljava/lang/String;)V

    .line 428
    invoke-virtual {v0}, Lcom/amazon/mShop/startup/StartupTask;->start()V

    .line 429
    return-void
.end method
