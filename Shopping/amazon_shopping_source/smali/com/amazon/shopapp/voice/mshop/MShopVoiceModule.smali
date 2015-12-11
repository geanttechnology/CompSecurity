.class public Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;
.super Lcom/amazon/shopapp/voice/module/VoiceModule;
.source "MShopVoiceModule.java"


# static fields
.field private static sInstance:Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;


# instance fields
.field private mIsVoicePackageLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/shopapp/voice/module/VoiceModule;-><init>()V

    .line 25
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->mIsVoicePackageLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;
    .locals 2

    .prologue
    .line 31
    const-class v1, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->sInstance:Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    invoke-direct {v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;-><init>()V

    sput-object v0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->sInstance:Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    .line 35
    :cond_0
    sget-object v0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->sInstance:Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static initializeApp(Lcom/amazon/shopapp/voice/module/VoiceInitSettings;)V
    .locals 1
    .param p0, "settings"    # Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    .prologue
    .line 42
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v0

    .line 43
    .local v0, "instance":Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;
    invoke-static {v0}, Lcom/amazon/shopapp/voice/module/VoiceModule;->setInstance(Lcom/amazon/shopapp/voice/module/VoiceModule;)V

    .line 44
    invoke-virtual {v0, p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->initialize(Lcom/amazon/shopapp/voice/module/VoiceInitSettings;)V

    .line 45
    return-void
.end method


# virtual methods
.method public barcodeSearchEnabled()Z
    .locals 1

    .prologue
    .line 93
    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->voiceSearchInNavEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "SX_mShop_Android_Voice_Search_Barcode"

    invoke-virtual {p0, v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isFeatureActive(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public flowButtonTreatment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    const-string/jumbo v0, "SX_mShop_Android_Voice_Search_Scan_Flow"

    invoke-virtual {p0, v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getExperimentTreatment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isVoiceSearchSupportedOnDevice()Z
    .locals 3

    .prologue
    .line 58
    iget-object v1, p0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->mIsVoicePackageLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v1

    if-eqz v1, :cond_0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-ge v1, v2, :cond_1

    .line 59
    :cond_0
    const/4 v1, 0x0

    .line 64
    :goto_0
    return v1

    .line 62
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 64
    .local v0, "packageManager":Landroid/content/pm/PackageManager;
    const-string/jumbo v1, "android.hardware.microphone"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method public setIsVoicePackageLoaded(Z)V
    .locals 1
    .param p1, "loaded"    # Z

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->mIsVoicePackageLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 52
    return-void
.end method

.method public shopByDepartmentEnabled()Z
    .locals 1

    .prologue
    .line 100
    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->voiceSearchInNavEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "SX_mShop_Android_Voice_Search_Shop_By_Department"

    invoke-virtual {p0, v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isFeatureActive(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public voiceSearchInNavEnabled()Z
    .locals 1

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isVoiceSearchSupportedOnDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "SX_mShop_Android_Voice_Search_Nav"

    invoke-virtual {p0, v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isExperimentActive(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public voiceSearchInResultEnabled()Z
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isVoiceSearchSupportedOnDevice()Z

    move-result v0

    if-eqz v0, :cond_1

    const-string/jumbo v0, "SX_mShop_Android_Voice_Search_Result_Nav"

    invoke-virtual {p0, v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isFeatureActive(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->voiceSearchInNavEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public voiceSearchInSuggestionsEnabled()Z
    .locals 1

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isVoiceSearchSupportedOnDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "SX_mShop_Android_Voice_Search_Access"

    invoke-virtual {p0, v0}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->isFeatureActive(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
