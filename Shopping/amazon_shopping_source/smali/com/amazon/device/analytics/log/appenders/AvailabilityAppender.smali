.class public Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;
.super Ljava/lang/Object;
.source "AvailabilityAppender.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;
.implements Lcom/amazon/device/analytics/log/appenders/LogAppender;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;
    }
.end annotation


# instance fields
.field private final batchLock:Ljava/util/concurrent/locks/ReentrantLock;

.field public batchSize:I

.field public clientName:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private final lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

.field private final logMessages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;",
            ">;"
        }
    .end annotation
.end field

.field private final manager:Lcom/amazon/sdk/availability/MeasurementManager;

.field private final readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

.field public version:Ljava/lang/String;

.field private final writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 121
    invoke-static {}, Lcom/amazon/sdk/availability/MeasurementManagerFactory;->getMeasurementManager()Lcom/amazon/sdk/availability/MeasurementManager;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;-><init>(Landroid/content/Context;Lcom/amazon/sdk/availability/MeasurementManager;Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 122
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/amazon/sdk/availability/MeasurementManager;Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "manager"    # Lcom/amazon/sdk/availability/MeasurementManager;
    .param p3, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 124
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->context:Landroid/content/Context;

    .line 37
    new-instance v0, Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-direct {v0, v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    .line 38
    iget-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    .line 39
    iget-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    .line 40
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0, v2}, Ljava/util/concurrent/locks/ReentrantLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 43
    iput v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I

    .line 44
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->logMessages:Ljava/util/List;

    .line 125
    if-eqz p1, :cond_0

    .line 126
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->context:Landroid/content/Context;

    .line 128
    :cond_0
    if-eqz p3, :cond_1

    .line 129
    const-string/jumbo v0, "appStoreAvailabilityClientName"

    const-string/jumbo v1, "gamelab"

    invoke-interface {p3, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->clientName:Ljava/lang/String;

    .line 130
    const-string/jumbo v0, "appStoreAvailabilityClientVersion"

    const-string/jumbo v1, "1.0"

    invoke-interface {p3, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->version:Ljava/lang/String;

    .line 131
    const-string/jumbo v0, "logBatchSize"

    iget v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p3, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optInt(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I

    .line 132
    invoke-interface {p3, p0}, Lcom/amazon/device/analytics/configuration/Configuration;->registerRefreshListener(Lcom/amazon/device/analytics/configuration/ConfigurationRefreshListener;)V

    .line 138
    :goto_0
    iput-object p2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->manager:Lcom/amazon/sdk/availability/MeasurementManager;

    .line 139
    return-void

    .line 134
    :cond_1
    const-string/jumbo v0, "gamelab"

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->clientName:Ljava/lang/String;

    .line 135
    const-string/jumbo v0, "1.0"

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->version:Ljava/lang/String;

    .line 136
    iput v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I

    goto :goto_0
.end method

.method private enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V
    .locals 4
    .param p1, "logMessage"    # Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    .prologue
    .line 142
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->context:Landroid/content/Context;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->manager:Lcom/amazon/sdk/availability/MeasurementManager;

    if-nez v2, :cond_1

    .line 185
    :cond_0
    :goto_0
    return-void

    .line 146
    :cond_1
    const/4 v1, 0x0

    .line 147
    .local v1, "size":I
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    .line 149
    :try_start_0
    iget v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I

    if-lez v2, :cond_2

    .line 150
    iget v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 153
    :cond_2
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    .line 157
    if-lez v1, :cond_0

    .line 161
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 164
    :try_start_1
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->logMessages:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 166
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->logMessages:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v2

    if-ge v2, v1, :cond_3

    .line 183
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    .line 153
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw v2

    .line 173
    :cond_3
    :try_start_2
    invoke-direct {p0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->writeBatchToMeasurement()Lcom/amazon/sdk/availability/Measurement;

    move-result-object v0

    .line 175
    .local v0, "measurement":Lcom/amazon/sdk/availability/Measurement;
    if-eqz v0, :cond_4

    .line 176
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->manager:Lcom/amazon/sdk/availability/MeasurementManager;

    iget-object v3, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->context:Landroid/content/Context;

    invoke-interface {v2, v3, v0}, Lcom/amazon/sdk/availability/MeasurementManager;->putMeasurement(Landroid/content/Context;Lcom/amazon/sdk/availability/Measurement;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 181
    .end local v0    # "measurement":Lcom/amazon/sdk/availability/Measurement;
    :cond_4
    :goto_1
    :try_start_3
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->logMessages:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 183
    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v2}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    goto :goto_0

    :catchall_1
    move-exception v2

    iget-object v3, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchLock:Ljava/util/concurrent/locks/ReentrantLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    throw v2

    .line 178
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method private writeBatchToMeasurement()Lcom/amazon/sdk/availability/Measurement;
    .locals 7

    .prologue
    .line 188
    new-instance v5, Lcom/amazon/sdk/availability/Measurement;

    invoke-direct {v5}, Lcom/amazon/sdk/availability/Measurement;-><init>()V

    const-string/jumbo v6, "Log"

    invoke-virtual {v5, v6}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementName(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/sdk/availability/Measurement;->setMeasurementValueNumber(Ljava/lang/Number;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v1

    .line 192
    .local v1, "measurement":Lcom/amazon/sdk/availability/Measurement;
    invoke-static {}, Lcom/amazon/device/analytics/events/UniqueIdService;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    .line 193
    .local v4, "uniqueId":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 194
    const-string/jumbo v5, "id"

    invoke-virtual {v1, v5, v4}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    .line 197
    :cond_0
    iget-object v5, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    .line 199
    :try_start_0
    iget-object v5, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->clientName:Ljava/lang/String;

    invoke-virtual {v1, v5}, Lcom/amazon/sdk/availability/Measurement;->setClientId(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    .line 200
    iget-object v5, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->version:Ljava/lang/String;

    invoke-virtual {v1, v5}, Lcom/amazon/sdk/availability/Measurement;->setClientVersion(Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 202
    iget-object v5, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    .line 205
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 206
    .local v3, "messagesArray":Lorg/json/JSONArray;
    iget-object v5, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->logMessages:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    .line 207
    .local v2, "message":Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;
    invoke-virtual {v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->toJSON()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v3, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 202
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "message":Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;
    .end local v3    # "messagesArray":Lorg/json/JSONArray;
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->readLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v6}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw v5

    .line 210
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v3    # "messagesArray":Lorg/json/JSONArray;
    :cond_1
    const-string/jumbo v5, "messages"

    invoke-virtual {v3}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Lcom/amazon/sdk/availability/Measurement;->setMetadata(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/Measurement;

    .line 212
    return-object v1
.end method


# virtual methods
.method public d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 229
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p2, v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 230
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 234
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-direct {v0, v1, p2, p3}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 235
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 274
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p2, v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 275
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 279
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-direct {v0, v1, p2, p3}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 280
    return-void
.end method

.method public i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 249
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->INFO:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p2, v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 250
    return-void
.end method

.method public onRefresh(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 2
    .param p1, "configuration"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 217
    iget-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    .line 219
    :try_start_0
    const-string/jumbo v0, "appStoreAvailabilityClientName"

    iget-object v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->clientName:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->clientName:Ljava/lang/String;

    .line 220
    const-string/jumbo v0, "appStoreAvailabilityClientVersion"

    iget-object v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->version:Ljava/lang/String;

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->version:Ljava/lang/String;

    .line 221
    const-string/jumbo v0, "logBatchSize"

    iget v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/amazon/device/analytics/configuration/Configuration;->optInt(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->batchSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 223
    iget-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    .line 225
    return-void

    .line 223
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->writeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw v0
.end method

.method public v(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 239
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p2, v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 240
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 259
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p2, v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 260
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 269
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;

    sget-object v1, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-direct {v0, v1, p2, p3}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;-><init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-direct {p0, v0}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;->enqueueLogMessage(Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;)V

    .line 270
    return-void
.end method
