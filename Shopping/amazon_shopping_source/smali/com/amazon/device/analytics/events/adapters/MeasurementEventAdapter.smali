.class public Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;
.super Ljava/lang/Object;
.source "MeasurementEventAdapter.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;"
    }
.end annotation


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field public clientName:Ljava/lang/String;

.field private final jsonAdapter:Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;

.field private final lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

.field private final readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

.field public version:Ljava/lang/String;

.field private final writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 2
    .param p1, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;

    invoke-direct {v0}, Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->jsonAdapter:Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;

    .line 30
    new-instance v0, Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    .line 31
    iget-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    .line 32
    iget-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    .line 39
    if-eqz p1, :cond_0

    .line 40
    const-string/jumbo v0, "appStoreAvailabilityClientName"

    const-string/jumbo v1, "gamelab"

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->clientName:Ljava/lang/String;

    .line 41
    const-string/jumbo v0, "appStoreAvailabilityClientVersion"

    const-string/jumbo v1, "1.0"

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->version:Ljava/lang/String;

    .line 42
    invoke-interface {p1, p0}, Lcom/amazon/device/analytics/configuration/Configuration;->registerRefreshListener(Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;)V

    .line 47
    :goto_0
    return-void

    .line 44
    :cond_0
    const-string/jumbo v0, "gamelab"

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->clientName:Ljava/lang/String;

    .line 45
    const-string/jumbo v0, "1.0"

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->version:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized onRefresh(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 2
    .param p1, "configuration"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 55
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 57
    :try_start_1
    const-string/jumbo v0, "appStoreAvailabilityClientName"

    iget-object v1, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->clientName:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->clientName:Ljava/lang/String;

    .line 58
    const-string/jumbo v0, "appStoreAvailabilityClientVersion"

    iget-object v1, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->version:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->version:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 60
    :try_start_2
    iget-object v0, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 62
    monitor-exit p0

    return-void

    .line 60
    :catchall_0
    move-exception v0

    :try_start_3
    iget-object v1, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 55
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    new-instance v0, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public translateFromEvent(Lcom/amazon/device/analytics/events/Event;)Lcom/amazon/sdk/availability/Measurement;
    .locals 6
    .param p1, "source"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 71
    if-nez p1, :cond_0

    .line 72
    sget-object v4, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "The Event provided was null"

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;)V

    .line 73
    const/4 v2, 0x0

    .line 102
    :goto_0
    return-object v2

    .line 76
    :cond_0
    const/4 v2, 0x0

    .line 79
    .local v2, "measurement":Lcom/amazon/sdk/availability/Measurement;
    :try_start_0
    new-instance v3, Lcom/amazon/sdk/availability/Measurement;

    invoke-direct {v3}, Lcom/amazon/sdk/availability/Measurement;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 80
    .end local v2    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    .local v3, "measurement":Lcom/amazon/sdk/availability/Measurement;
    :try_start_1
    iget-object v4, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 82
    :try_start_2
    iget-object v4, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->clientName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setClientId(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    .line 83
    iget-object v4, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->version:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setClientVersion(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 87
    :try_start_3
    iget-object v4, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    .line 89
    :goto_1
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementName(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    .line 90
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementValueNumber(Ljava/lang/Number;)Lcom/amazon/sdk/availability/Measurement;

    .line 92
    iget-object v4, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->jsonAdapter:Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;

    invoke-virtual {v4, p1}, Lcom/amazon/device/analytics/events/adapters/JSONEventAdapter;->translateFromEvent(Lcom/amazon/device/analytics/events/Event;)Lorg/json/JSONObject;

    move-result-object v1

    .line 93
    .local v1, "json":Lorg/json/JSONObject;
    if-eqz v1, :cond_1

    .line 94
    const-string/jumbo v4, "event"

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    :goto_2
    move-object v2, v3

    .line 100
    .end local v3    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    .restart local v2    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    goto :goto_0

    .line 84
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v2    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    .restart local v3    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    :catch_0
    move-exception v4

    .line 87
    iget-object v4, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 98
    :catch_1
    move-exception v0

    move-object v2, v3

    .line 99
    .end local v3    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    .local v0, "ex":Ljava/lang/Exception;
    .restart local v2    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    :goto_3
    sget-object v4, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "Failed to translate Event to a Measurement"

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;)V

    goto :goto_0

    .line 87
    .end local v0    # "ex":Ljava/lang/Exception;
    .end local v2    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    .restart local v3    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    :catchall_0
    move-exception v4

    :try_start_4
    iget-object v5, p0, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw v4

    .line 96
    .restart local v1    # "json":Lorg/json/JSONObject;
    :cond_1
    sget-object v4, Lcom/amazon/device/analytics/events/adapters/MeasurementEventAdapter;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "Failed to translate Event to a JSONObject"

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_2

    .line 98
    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v3    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    .restart local v2    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    :catch_2
    move-exception v0

    goto :goto_3
.end method
