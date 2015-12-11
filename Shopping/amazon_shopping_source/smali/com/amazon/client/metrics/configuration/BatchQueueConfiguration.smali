.class public Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
.super Ljava/lang/Object;
.source "BatchQueueConfiguration.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

.field private mDirectoryPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;)V
    .locals 2
    .param p1, "batchQueueType"    # Lcom/amazon/client/metrics/configuration/BatchQueueType;
    .param p2, "directoryPrefix"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    if-nez p1, :cond_0

    .line 17
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "batchQueueType is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 20
    :cond_0
    if-nez p2, :cond_1

    .line 21
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v1, "directoryPrefix is null in configuration"

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 24
    :cond_1
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;->mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    .line 25
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;->mDirectoryPrefix:Ljava/lang/String;

    .line 26
    return-void
.end method


# virtual methods
.method public getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;->mBatchQueueType:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    return-object v0
.end method

.method public getDirectoryPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;->mDirectoryPrefix:Ljava/lang/String;

    return-object v0
.end method
