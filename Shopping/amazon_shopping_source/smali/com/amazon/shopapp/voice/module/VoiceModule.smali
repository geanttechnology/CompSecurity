.class public abstract Lcom/amazon/shopapp/voice/module/VoiceModule;
.super Ljava/lang/Object;
.source "VoiceModule.java"


# static fields
.field private static sInstance:Lcom/amazon/shopapp/voice/module/VoiceModule;


# instance fields
.field private mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/shopapp/voice/module/VoiceModule;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/amazon/shopapp/voice/module/VoiceModule;->sInstance:Lcom/amazon/shopapp/voice/module/VoiceModule;

    return-object v0
.end method

.method protected static setInstance(Lcom/amazon/shopapp/voice/module/VoiceModule;)V
    .locals 0
    .param p0, "instance"    # Lcom/amazon/shopapp/voice/module/VoiceModule;

    .prologue
    .line 30
    sput-object p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->sInstance:Lcom/amazon/shopapp/voice/module/VoiceModule;

    .line 31
    return-void
.end method


# virtual methods
.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public getExperimentTreatment(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getExperimentProvider()Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getExperimentProvider()Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/shopapp/voice/module/ExperimentProvider;->getTreatment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "C"

    goto :goto_0
.end method

.method public getFeatureState(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getFeatureConfiguration()Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getFeatureConfiguration()Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/shopapp/voice/module/FeatureConfiguration;->getFeatureState(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getInitSettings()Lcom/amazon/shopapp/voice/module/VoiceInitSettings;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    return-object v0
.end method

.method public initialize(Lcom/amazon/shopapp/voice/module/VoiceInitSettings;)V
    .locals 0
    .param p1, "settings"    # Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    .line 38
    return-void
.end method

.method public isDebugEnabled()Z
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getDebugMode()Z

    move-result v0

    return v0
.end method

.method public isExperimentActive(Ljava/lang/String;)Z
    .locals 2
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getExperimentProvider()Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "C"

    iget-object v1, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v1}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getExperimentProvider()Lcom/amazon/shopapp/voice/module/ExperimentProvider;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/amazon/shopapp/voice/module/ExperimentProvider;->getTreatment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFeatureActive(Ljava/lang/String;)Z
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getFeatureConfiguration()Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/shopapp/voice/module/VoiceModule;->mInitSettings:Lcom/amazon/shopapp/voice/module/VoiceInitSettings;

    invoke-virtual {v0}, Lcom/amazon/shopapp/voice/module/VoiceInitSettings;->getFeatureConfiguration()Lcom/amazon/shopapp/voice/module/FeatureConfiguration;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/shopapp/voice/module/FeatureConfiguration;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
