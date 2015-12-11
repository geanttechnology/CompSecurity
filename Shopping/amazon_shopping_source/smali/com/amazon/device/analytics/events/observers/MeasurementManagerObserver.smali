.class public Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;
.super Ljava/lang/Object;
.source "MeasurementManagerObserver.java"

# interfaces
.implements Lcom/amazon/device/analytics/events/observers/EventObserver;
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field adapter:Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;

.field context:Landroid/content/Context;

.field manager:Lcom/amazon/sdk/availability/MeasurementManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/sdk/availability/MeasurementManager;Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "manager"    # Lcom/amazon/sdk/availability/MeasurementManager;
    .param p3, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 29
    new-instance v0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;

    invoke-direct {v0, p3}, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;-><init>(Lcom/amazon/device/analytics/configuration/Configuration;)V

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;-><init>(Landroid/content/Context;Lcom/amazon/sdk/availability/MeasurementManager;Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;)V

    .line 30
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lcom/amazon/sdk/availability/MeasurementManager;Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "manager"    # Lcom/amazon/sdk/availability/MeasurementManager;
    .param p3, "adapter"    # Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->context:Landroid/content/Context;

    .line 34
    iput-object p2, p0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->manager:Lcom/amazon/sdk/availability/MeasurementManager;

    .line 35
    iput-object p3, p0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->adapter:Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;

    .line 36
    return-void
.end method


# virtual methods
.method public notify(Lcom/amazon/device/analytics/events/Event;)V
    .locals 3
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 44
    iget-object v1, p0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->adapter:Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;

    invoke-virtual {v1, p1}, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->translateFromEvent(Lcom/amazon/device/analytics/events/Event;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    .line 46
    .local v0, "measurement":Lcom/amazon/sdk/availability/Measurement;
    if-nez v0, :cond_0

    .line 47
    sget-object v1, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v2, "Failed to translate Event to a Measurement"

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;)V

    .line 55
    :goto_0
    return-void

    .line 51
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->manager:Lcom/amazon/sdk/availability/MeasurementManager;

    iget-object v2, p0, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->context:Landroid/content/Context;

    invoke-interface {v1, v2, v0}, Lcom/amazon/sdk/availability/MeasurementManager;->putMeasurement(Landroid/content/Context;Lcom/amazon/sdk/availability/Measurement;)V

    goto :goto_0
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 69
    new-instance v0, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 59
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 61
    .local v1, "json":Lorg/json/JSONObject;
    const/4 v2, 0x4

    :try_start_0
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 63
    :goto_0
    return-object v2

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method
