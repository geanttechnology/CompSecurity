.class public Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;
.super Ljava/lang/Object;
.source "MetricsBatchPipelineConfiguration.java"

# interfaces
.implements Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;


# instance fields
.field private mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

.field private final mBatchTransmitterType:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

.field private final mBoundedCheckBatchOpenTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedExpiryTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedMaxBatchOpenTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedMaxBatchQueueCapacityBytes:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedMaxBatchQueueEntries:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedMaxNumEntriesPerBatch:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedMaxSizePerBatchBytes:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedPurgePeriodMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private final mBoundedTransmissionPeriodMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

.field private mDirectoryPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>(JJIIIIJJJLcom/amazon/client/metrics/configuration/BatchTransmitterType;)V
    .locals 18
    .param p1, "maxBatchOpenTimeMillis"    # J
    .param p3, "checkBatchOpenTimeMillis"    # J
    .param p5, "maxNumEntriesPerBatch"    # I
    .param p6, "maxSizePerBatchBytes"    # I
    .param p7, "maxBatchQueueCapacityBytes"    # I
    .param p8, "maxBatchQueueEntries"    # I
    .param p9, "expiryTimeMillis"    # J
    .param p11, "purgePeriodMillis"    # J
    .param p13, "transmissionPeriodMillis"    # J
    .param p15, "batchTransmitterType"    # Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 55
    const/4 v1, 0x0

    const/4 v2, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move/from16 v7, p5

    move/from16 v8, p6

    move/from16 v9, p7

    move/from16 v10, p8

    move-wide/from16 v11, p9

    move-wide/from16 v13, p11

    move-wide/from16 v15, p13

    move-object/from16 v17, p15

    invoke-direct/range {v0 .. v17}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;JJIIIIJJJLcom/amazon/client/metrics/configuration/BatchTransmitterType;)V

    .line 68
    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;JJIIIIJJJLcom/amazon/client/metrics/configuration/BatchTransmitterType;)V
    .locals 9
    .param p1, "batchQueueType"    # Lcom/amazon/client/metrics/configuration/BatchQueueType;
    .param p2, "directoryPrefix"    # Ljava/lang/String;
    .param p3, "maxBatchOpenTimeMillis"    # J
    .param p5, "checkBatchOpenTimeMillis"    # J
    .param p7, "maxNumEntriesPerBatch"    # I
    .param p8, "maxSizePerBatchBytes"    # I
    .param p9, "maxBatchQueueCapacityBytes"    # I
    .param p10, "maxBatchQueueEntries"    # I
    .param p11, "expiryTimeMillis"    # J
    .param p13, "purgePeriodMillis"    # J
    .param p15, "transmissionPeriodMillis"    # J
    .param p17, "batchTransmitterType"    # Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    .line 85
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mDirectoryPrefix:Ljava/lang/String;

    .line 87
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "MaxBatchOpenTimeMillis"

    const-wide/16 v3, 0x1f4

    const-wide/32 v5, 0x240c8400

    move-wide v7, p3

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxBatchOpenTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 92
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "CheckBatchOpenTimeMillis"

    const-wide/16 v3, 0x1f4

    const-wide/32 v5, 0x5265c00

    move-wide v7, p5

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedCheckBatchOpenTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 98
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "MaxBatchQueueCapacityBytes"

    const-wide/16 v3, 0x400

    const-wide/32 v5, 0xa00000

    move/from16 v0, p9

    int-to-long v7, v0

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxBatchQueueCapacityBytes:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 104
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "MaxBatchEntries"

    const-wide/16 v3, 0x1

    const-wide/32 v5, 0xf4240

    move/from16 v0, p7

    int-to-long v7, v0

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxNumEntriesPerBatch:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 110
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "MaxBatchSizeBytes"

    const-wide/16 v3, 0x400

    const-wide/32 v5, 0x100000

    move/from16 v0, p8

    int-to-long v7, v0

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxSizePerBatchBytes:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 116
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "MaxBatchQueueEntries"

    const-wide/16 v3, 0x1

    const-wide/16 v5, 0x2710

    move/from16 v0, p10

    int-to-long v7, v0

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxBatchQueueEntries:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 122
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "ExpiryTimeMillis"

    const-wide/32 v3, 0x5265c00

    const-wide v5, 0xe7be2c00L

    move-wide/from16 v7, p11

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedExpiryTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 128
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "PurgePeriodMillis"

    const-wide/32 v3, 0x36ee80

    const-wide/32 v5, 0xf731400

    move-wide/from16 v7, p13

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedPurgePeriodMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 134
    new-instance v1, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    const-string/jumbo v2, "TransmissionPeriodMillis"

    const-wide/16 v3, 0x2710

    const-wide/32 v5, 0x5265c00

    move-wide/from16 v7, p15

    invoke-direct/range {v1 .. v8}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;-><init>(Ljava/lang/String;JJJ)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedTransmissionPeriodMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    .line 140
    move-object/from16 v0, p17

    iput-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBatchTransmitterType:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    .line 141
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 253
    if-ne p0, p1, :cond_1

    .line 264
    :cond_0
    :goto_0
    return v1

    .line 256
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 257
    goto :goto_0

    .line 259
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 260
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 262
    check-cast v0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    .line 264
    .local v0, "other":Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;
    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v4

    if-ne v3, v4, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getCheckBatchOpenTimeMillis()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getCheckBatchOpenTimeMillis()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchOpenTimeMillis()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchOpenTimeMillis()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchQueueEntries()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchQueueEntries()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxNumEntriesPerBatch()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxNumEntriesPerBatch()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxSizePerBatchBytes()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxSizePerBatchBytes()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getExpiryTimeMillis()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getExpiryTimeMillis()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getPurgePeriodMillis()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getPurgePeriodMillis()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getTransmissionPeriodMillis()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getTransmissionPeriodMillis()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getBatchTransmitterType()Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getBatchTransmitterType()Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v4

    if-eq v3, v4, :cond_0

    :cond_4
    move v1, v2

    goto/16 :goto_0
.end method

.method public getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    return-object v0
.end method

.method public getBatchTransmitterType()Lcom/amazon/client/metrics/configuration/BatchTransmitterType;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBatchTransmitterType:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    return-object v0
.end method

.method public getCheckBatchOpenTimeMillis()J
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedCheckBatchOpenTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDirectoryPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mDirectoryPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public getExpiryTimeMillis()J
    .locals 2

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedExpiryTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getMaxBatchOpenTimeMillis()J
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxBatchOpenTimeMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getMaxBatchQueueCapacityBytes()J
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxBatchQueueCapacityBytes:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getMaxBatchQueueEntries()J
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxBatchQueueEntries:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getMaxNumEntriesPerBatch()J
    .locals 2

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxNumEntriesPerBatch:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getMaxSizePerBatchBytes()J
    .locals 2

    .prologue
    .line 176
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedMaxSizePerBatchBytes:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getPurgePeriodMillis()J
    .locals 2

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedPurgePeriodMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTransmissionPeriodMillis()J
    .locals 2

    .prologue
    .line 204
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBoundedTransmissionPeriodMillis:Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BoundedNumberEvaluator;->getValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 280
    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/BatchQueueType;->hashCode()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getCheckBatchOpenTimeMillis()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchOpenTimeMillis()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchQueueEntries()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxNumEntriesPerBatch()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getMaxSizePerBatchBytes()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getExpiryTimeMillis()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getPurgePeriodMillis()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    new-instance v1, Ljava/lang/Long;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getTransmissionPeriodMillis()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->getBatchTransmitterType()Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public setBatchQueueType(Lcom/amazon/client/metrics/configuration/BatchQueueType;)V
    .locals 1
    .param p1, "batchQueueType"    # Lcom/amazon/client/metrics/configuration/BatchQueueType;

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    if-nez v0, :cond_0

    .line 235
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    .line 237
    :cond_0
    return-void
.end method

.method public setDirectoryPrefix(Ljava/lang/String;)V
    .locals 1
    .param p1, "directoryPrefix"    # Ljava/lang/String;

    .prologue
    .line 245
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mDirectoryPrefix:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 246
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;->mDirectoryPrefix:Ljava/lang/String;

    .line 248
    :cond_0
    return-void
.end method
