.class public Lcom/amazon/analytics/SystemAnalytics;
.super Ljava/lang/Object;
.source "SystemAnalytics.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createIAPEvent()Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$IAPTypeBuilder;
    .locals 1

    .prologue
    .line 44
    new-instance v0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$IAPBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$IAPBuilder;-><init>()V

    return-object v0
.end method

.method public createInstallEvent()Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$BaseAnalyticsBuilder;
    .locals 1

    .prologue
    .line 32
    new-instance v0, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$InstallBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$InstallBuilder;-><init>()V

    return-object v0
.end method

.method public createOnPauseEvent()Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$SessionTypeBuilder;
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnPauseBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnPauseBuilder;-><init>()V

    return-object v0
.end method

.method public createOnResumeEvent()Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$SessionTypeBuilder;
    .locals 1

    .prologue
    .line 52
    new-instance v0, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnResumeBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnResumeBuilder;-><init>()V

    return-object v0
.end method

.method public createUninstallEvent()Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$BaseAnalyticsBuilder;
    .locals 1

    .prologue
    .line 36
    new-instance v0, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UninstallBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UninstallBuilder;-><init>()V

    return-object v0
.end method

.method public createUpgradeEvent()Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$BaseAnalyticsBuilder;
    .locals 1

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UpgradeBuilder;

    invoke-direct {v0}, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UpgradeBuilder;-><init>()V

    return-object v0
.end method
