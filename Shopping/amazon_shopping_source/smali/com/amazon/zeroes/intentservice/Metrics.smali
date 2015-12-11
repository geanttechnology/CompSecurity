.class public final Lcom/amazon/zeroes/intentservice/Metrics;
.super Ljava/lang/Object;
.source "Metrics.java"


# static fields
.field private static context:Landroid/content/Context;

.field private static measurementManager:Lcom/amazon/sdk/availability/MeasurementManager;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    return-void
.end method

.method public static putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V
    .locals 2
    .param p0, "measurement"    # Lcom/amazon/sdk/availability/Measurement;

    .prologue
    .line 81
    const-string/jumbo v0, "zeroes"

    invoke-virtual {p0, v0}, Lcom/amazon/sdk/availability/Measurement;->setClientId(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    .line 82
    sget-object v0, Lcom/amazon/zeroes/intentservice/Metrics;->measurementManager:Lcom/amazon/sdk/availability/MeasurementManager;

    sget-object v1, Lcom/amazon/zeroes/intentservice/Metrics;->context:Landroid/content/Context;

    invoke-interface {v0, v1, p0}, Lcom/amazon/sdk/availability/MeasurementManager;->putMeasurement(Landroid/content/Context;Lcom/amazon/sdk/availability/Measurement;)V

    .line 83
    return-void
.end method

.method public static setContext(Landroid/content/Context;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 42
    sput-object p0, Lcom/amazon/zeroes/intentservice/Metrics;->context:Landroid/content/Context;

    .line 43
    return-void
.end method

.method public static setMeasurementDefaults(Lcom/amazon/mas/client/device/DeviceInspector;Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;)V
    .locals 4
    .param p0, "deviceInspector"    # Lcom/amazon/mas/client/device/DeviceInspector;
    .param p1, "accountSummaryProvider"    # Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;

    .prologue
    .line 64
    invoke-interface {p0}, Lcom/amazon/mas/client/device/DeviceInspector;->getDeviceInfo()Ljava/util/Map;

    move-result-object v0

    .line 66
    .local v0, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x0

    invoke-interface {p1, v2}, Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;->isAccountPrepared(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 67
    invoke-interface {p1}, Lcom/amazon/mas/client/account/summary/AccountSummaryProvider;->getAccountSummary()Lcom/amazon/mas/client/account/summary/AccountSummary;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mas/client/account/summary/AccountSummary;->getAmznCustomerId()Ljava/lang/String;

    move-result-object v1

    .line 68
    .local v1, "ecid":Ljava/lang/String;
    const-string/jumbo v2, "ecid"

    invoke-static {v2, v1}, Lcom/amazon/sdk/availability/Measurement;->setGlobalMetadata(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    .end local v1    # "ecid":Ljava/lang/String;
    :cond_0
    const-string/jumbo v3, "deviceModel"

    const-string/jumbo v2, "model"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v3, v2}, Lcom/amazon/sdk/availability/Measurement;->setGlobalMetadata(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string/jumbo v3, "deviceType"

    const-string/jumbo v2, "deviceType"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v3, v2}, Lcom/amazon/sdk/availability/Measurement;->setGlobalMetadata(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public static setMeasurementManager(Lcom/amazon/sdk/availability/MeasurementManager;)V
    .locals 0
    .param p0, "measurementManager"    # Lcom/amazon/sdk/availability/MeasurementManager;

    .prologue
    .line 51
    sput-object p0, Lcom/amazon/zeroes/intentservice/Metrics;->measurementManager:Lcom/amazon/sdk/availability/MeasurementManager;

    .line 52
    return-void
.end method
