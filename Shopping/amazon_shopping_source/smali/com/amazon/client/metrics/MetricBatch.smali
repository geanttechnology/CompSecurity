.class public Lcom/amazon/client/metrics/MetricBatch;
.super Ljava/lang/Object;
.source "MetricBatch.java"


# instance fields
.field private mBatchSizeInBytes:J

.field private mContainsUserMetrics:Z

.field private final mDeviceInfoMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mDeviceSerialNumber:Ljava/lang/String;

.field private mDeviceType:Ljava/lang/String;

.field private final mSerializedMetricEntryList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/EncodedMetricEntry;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    .line 29
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    .line 34
    return-void
.end method

.method public constructor <init>(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "deviceInfoMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    .line 29
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    .line 40
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/MetricBatch;->putMetricsDeviceInfo(Ljava/util/Map;)V

    .line 41
    return-void
.end method


# virtual methods
.method public declared-synchronized addEntry(Lcom/amazon/client/metrics/codec/EncodedMetricEntry;)V
    .locals 4
    .param p1, "encodedMetricEntry"    # Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    .prologue
    .line 71
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 72
    iget-wide v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mBatchSizeInBytes:J

    invoke-interface {p1}, Lcom/amazon/client/metrics/codec/EncodedMetricEntry;->getEncodedSize()I

    move-result v2

    int-to-long v2, v2

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mBatchSizeInBytes:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    monitor-exit p0

    return-void

    .line 71
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized containsUserMetrics()Z
    .locals 1

    .prologue
    .line 122
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mContainsUserMetrics:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 145
    if-ne p0, p1, :cond_1

    .line 164
    :cond_0
    :goto_0
    return v2

    .line 148
    :cond_1
    if-nez p1, :cond_2

    move v2, v3

    .line 149
    goto :goto_0

    .line 151
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    if-eq v4, v5, :cond_3

    move v2, v3

    .line 152
    goto :goto_0

    :cond_3
    move-object v1, p1

    .line 155
    check-cast v1, Lcom/amazon/client/metrics/MetricBatch;

    .line 156
    .local v1, "other":Lcom/amazon/client/metrics/MetricBatch;
    invoke-virtual {p0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v4

    invoke-virtual {v1}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v5

    if-eq v4, v5, :cond_4

    move v2, v3

    .line 157
    goto :goto_0

    .line 159
    :cond_4
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v4

    if-ge v0, v4, :cond_0

    .line 160
    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntry(I)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    move-result-object v4

    invoke-virtual {v1, v0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntry(I)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_5

    move v2, v3

    .line 161
    goto :goto_0

    .line 159
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public declared-synchronized getBatchSizeInBytes()J
    .locals 2

    .prologue
    .line 79
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mBatchSizeInBytes:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getDeviceInfoMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    return-object v0
.end method

.method public getDeviceSerialNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceSerialNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method public declared-synchronized getMetricEntry(I)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 115
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMetricEntryCount()I
    .locals 1

    .prologue
    .line 86
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    .line 135
    const/16 v1, 0x1f

    .line 136
    .local v1, "prime":I
    const/4 v2, 0x1

    .line 137
    .local v2, "result":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 138
    mul-int/lit8 v3, v2, 0x1f

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntry(I)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->hashCode()I

    move-result v4

    add-int v2, v3, v4

    .line 137
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 140
    :cond_0
    return v2
.end method

.method public putMetricsDeviceInfo(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "deviceInfoMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 53
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Device Info Map is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 57
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    const-string/jumbo v1, "deviceId"

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceSerialNumber:Ljava/lang/String;

    .line 58
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    const-string/jumbo v1, "deviceType"

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceType:Ljava/lang/String;

    .line 60
    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceSerialNumber:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceSerialNumber:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 61
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Device Info Map missing device ID"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 64
    :cond_2
    return-void
.end method

.method public declared-synchronized setContainsUserMetrics(Z)V
    .locals 1
    .param p1, "containsUserMetrics"    # Z

    .prologue
    .line 130
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/amazon/client/metrics/MetricBatch;->mContainsUserMetrics:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 131
    monitor-exit p0

    return-void

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 173
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 174
    .local v1, "stringBuilder":Ljava/lang/StringBuilder;
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceSerialNumber:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 175
    const-string/jumbo v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 176
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 177
    const-string/jumbo v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricBatch;->mDeviceInfoMap:Ljava/util/Map;

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 179
    const-string/jumbo v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 180
    iget-wide v2, p0, Lcom/amazon/client/metrics/MetricBatch;->mBatchSizeInBytes:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 181
    const-string/jumbo v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 182
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 183
    iget-object v2, p0, Lcom/amazon/client/metrics/MetricBatch;->mSerializedMetricEntryList:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 182
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 185
    :cond_0
    const-string/jumbo v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 186
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
