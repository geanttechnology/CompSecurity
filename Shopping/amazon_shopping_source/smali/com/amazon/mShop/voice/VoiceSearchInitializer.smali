.class public Lcom/amazon/mShop/voice/VoiceSearchInitializer;
.super Ljava/lang/Object;
.source "VoiceSearchInitializer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppExperimentProvider;,
        Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppFeatureConfiguration;,
        Lcom/amazon/mShop/voice/VoiceSearchInitializer$KeyboardListener;,
        Lcom/amazon/mShop/voice/VoiceSearchInitializer$CustomerHandler;,
        Lcom/amazon/mShop/voice/VoiceSearchInitializer$VoiceSearchListener;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static mInstance:Lcom/amazon/mShop/voice/VoiceSearchInitializer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 168
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method public static getInstance()Lcom/amazon/mShop/voice/VoiceSearchInitializer;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->mInstance:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    if-nez v0, :cond_0

    .line 42
    new-instance v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    invoke-direct {v0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer;-><init>()V

    sput-object v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->mInstance:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    .line 44
    :cond_0
    sget-object v0, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->mInstance:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    return-object v0
.end method


# virtual methods
.method public initialize(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 52
    :try_start_0
    new-instance v1, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-direct {v1, p1}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;-><init>(Landroid/content/Context;)V

    .line 53
    .local v1, "settings":Lcom/amazon/shopapp/voice/module/VoiceInitSettings;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->setDebugMode(Z)V

    .line 54
    new-instance v2, Lcom/amazon/mShop/voice/VoiceSearchInitializer$VoiceSearchListener;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer$VoiceSearchListener;-><init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->setVoiceSearchListener(Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;)V

    .line 55
    new-instance v2, Lcom/amazon/mShop/voice/VoiceSearchInitializer$CustomerHandler;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer$CustomerHandler;-><init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->setCustomerProvider(Lcom/amazon/shopapp/voice/module/CustomerProvider;)V

    .line 56
    new-instance v2, Lcom/amazon/mShop/voice/VoiceSearchInitializer$KeyboardListener;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer$KeyboardListener;-><init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->setKeyboardModeListener(Lcom/amazon/shopapp/voice/module/KeyboardModeListener;)V

    .line 57
    new-instance v2, Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppFeatureConfiguration;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppFeatureConfiguration;-><init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->setFeatureConfiguration(Lcom/amazon/shopapp/voice/module/FeatureConfiguration;)V

    .line 58
    new-instance v2, Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppExperimentProvider;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/voice/VoiceSearchInitializer$AppExperimentProvider;-><init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V

    invoke-virtual {v1, v2}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->setExperimentProvider(Lcom/amazon/shopapp/voice/module/ExperimentProvider;)V

    .line 61
    invoke-static {v1}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->initializeApp(Lcom/amazon/shopapp/voice/module/VoiceInitSettings;)V

    .line 62
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->getInstance()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->initializeMShopVoiceModule()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    .end local v1    # "settings":Lcom/amazon/shopapp/voice/module/VoiceInitSettings;
    :goto_0
    return-void

    .line 63
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Failed to initialize voice search"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
