.class public abstract Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;
.super Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;
.source "IAPEventTypeBuilder.java"

# interfaces
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$IAPTypeBuilder;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppAsinView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppPurchaseAmount;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppPurchaseCurrency;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppSkuView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppVersionView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$IsCoinsUsed;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$IsOrderSuccessful;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$1;,
        Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$IAPBuilder;
    }
.end annotation


# instance fields
.field inAppAsin:Ljava/lang/String;

.field inAppPurchaseAmount:D

.field inAppPurchaseCurrency:Ljava/lang/String;

.field inAppSku:Ljava/lang/String;

.field inAppVersion:Ljava/lang/String;

.field isCoinsUsed:Z

.field isOrderSuccessful:Z


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$1;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;-><init>()V

    return-void
.end method


# virtual methods
.method setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V
    .locals 4
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 84
    invoke-super {p0, p1}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V

    .line 85
    const-string/jumbo v0, "ia"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppAsin:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string/jumbo v0, "iv"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppVersion:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const-string/jumbo v0, "as"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppSku:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    const-string/jumbo v0, "ap"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-wide v2, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppPurchaseAmount:D

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppPurchaseCurrency:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 89
    const-string/jumbo v0, "apa"

    iget-wide v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppPurchaseAmount:D

    invoke-static {v1, v2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    .line 90
    const-string/jumbo v0, "apc"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppPurchaseCurrency:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    const-string/jumbo v0, "coins"

    iget-boolean v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->isCoinsUsed:Z

    invoke-static {v1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    const-string/jumbo v0, "ou"

    iget-boolean v1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->isOrderSuccessful:Z

    invoke-static {v1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    return-void
.end method

.method public withInAppAsin(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppVersionView;
    .locals 1
    .param p1, "inAppAsin"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppAsin:Ljava/lang/String;

    .line 42
    return-object p0
.end method

.method public withInAppPurchaseAmount(D)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppPurchaseCurrency;
    .locals 2
    .param p1, "inAppPurchaseAmount"    # D

    .prologue
    .line 59
    const-wide/16 v0, 0x0

    cmpl-double v0, p1, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/amazon/analytics/util/Preconditions;->checkArgument(Z)V

    .line 60
    iput-wide p1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppPurchaseAmount:D

    .line 61
    return-object p0

    .line 59
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public withInAppPurchaseCurrency(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$IsCoinsUsed;
    .locals 1
    .param p1, "inAppPurchaseCurrency"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppPurchaseCurrency:Ljava/lang/String;

    .line 67
    return-object p0
.end method

.method public withInAppSku(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppPurchaseAmount;
    .locals 1
    .param p1, "inAppSku"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppSku:Ljava/lang/String;

    .line 54
    return-object p0
.end method

.method public withInAppVersion(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$InAppSkuView;
    .locals 1
    .param p1, "inAppVersion"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->inAppVersion:Ljava/lang/String;

    .line 48
    return-object p0
.end method

.method public withIsCoinsUsed(Z)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$IsOrderSuccessful;
    .locals 0
    .param p1, "isCoinsUsed"    # Z

    .prologue
    .line 72
    iput-boolean p1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->isCoinsUsed:Z

    .line 73
    return-object p0
.end method

.method public withIsOrderSuccessful(Z)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$BaseAnalyticsBuilder;
    .locals 0
    .param p1, "isOrderSuccessful"    # Z

    .prologue
    .line 78
    iput-boolean p1, p0, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder;->isOrderSuccessful:Z

    .line 79
    return-object p0
.end method
