.class public Lcom/amazon/shopapp/voice/module/VoiceInitSettings;
.super Ljava/lang/Object;
.source "VoiceInitSettings.java"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mCustomerProvider:Lcom/amazon/shopapp/voice/module/CustomerProvider;

.field private mDebugMode:Z

.field private mExperimentProvider:Lcom/amazon/shopapp/voice/module/ExperimentProvider;

.field private mFeatureConfig:Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

.field private mKeyboardModeListener:Lcom/amazon/shopapp/voice/module/KeyboardModeListener;

.field private mVoiceSearchListener:Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mContext:Landroid/content/Context;

    .line 24
    return-void
.end method


# virtual methods
.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method public getCustomerProvider()Lcom/amazon/shopapp/voice/module/CustomerProvider;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mCustomerProvider:Lcom/amazon/shopapp/voice/module/CustomerProvider;

    return-object v0
.end method

.method public getDebugMode()Z
    .locals 1

    .prologue
    .line 31
    iget-boolean v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mDebugMode:Z

    return v0
.end method

.method public getExperimentProvider()Lcom/amazon/shopapp/voice/module/ExperimentProvider;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mExperimentProvider:Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    return-object v0
.end method

.method public getFeatureConfiguration()Lcom/amazon/shopapp/voice/module/FeatureConfiguration;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mFeatureConfig:Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    return-object v0
.end method

.method public getKeyboardModeListener()Lcom/amazon/shopapp/voice/module/KeyboardModeListener;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mKeyboardModeListener:Lcom/amazon/shopapp/voice/module/KeyboardModeListener;

    return-object v0
.end method

.method public getVoiceSearchListener()Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mVoiceSearchListener:Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;

    return-object v0
.end method

.method public setCustomerProvider(Lcom/amazon/shopapp/voice/module/CustomerProvider;)V
    .locals 0
    .param p1, "customerProvider"    # Lcom/amazon/shopapp/voice/module/CustomerProvider;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mCustomerProvider:Lcom/amazon/shopapp/voice/module/CustomerProvider;

    .line 52
    return-void
.end method

.method public setDebugMode(Z)V
    .locals 0
    .param p1, "debugMode"    # Z

    .prologue
    .line 35
    iput-boolean p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mDebugMode:Z

    .line 36
    return-void
.end method

.method public setExperimentProvider(Lcom/amazon/shopapp/voice/module/ExperimentProvider;)V
    .locals 0
    .param p1, "experimentProvider"    # Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mExperimentProvider:Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    .line 76
    return-void
.end method

.method public setFeatureConfiguration(Lcom/amazon/shopapp/voice/module/FeatureConfiguration;)V
    .locals 0
    .param p1, "featureConfig"    # Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mFeatureConfig:Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    .line 68
    return-void
.end method

.method public setKeyboardModeListener(Lcom/amazon/shopapp/voice/module/KeyboardModeListener;)V
    .locals 0
    .param p1, "keyboardModeListener"    # Lcom/amazon/shopapp/voice/module/KeyboardModeListener;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mKeyboardModeListener:Lcom/amazon/shopapp/voice/module/KeyboardModeListener;

    .line 60
    return-void
.end method

.method public setVoiceSearchListener(Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;)V
    .locals 0
    .param p1, "voiceSearchListener"    # Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->mVoiceSearchListener:Lcom/amazon/shopapp/voice/module/VoiceSearchActionListener;

    .line 44
    return-void
.end method
