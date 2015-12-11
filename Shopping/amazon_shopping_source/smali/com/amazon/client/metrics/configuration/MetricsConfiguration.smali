.class public Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
.super Ljava/lang/Object;
.source "MetricsConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;
    }
.end annotation


# static fields
.field public static final BUILD_TYPE:Ljava/lang/String; = "buildType"

.field public static final COUNTRY_OF_RESIDENCE:Ljava/lang/String; = "countryOfResidence"

.field public static final CUSTOMER_ID:Ljava/lang/String; = "CustomerId"

.field public static final DEVICE_ID:Ljava/lang/String; = "deviceId"

.field public static final DEVICE_LANGUAGE:Ljava/lang/String; = "deviceLanguage"

.field public static final DEVICE_MODE:Ljava/lang/String; = "deviceMode"

.field public static final DEVICE_TYPE:Ljava/lang/String; = "deviceType"

.field public static final HARDWARE:Ljava/lang/String; = "hardware"

.field public static final IP_ADDRESS:Ljava/lang/String; = "REMOTE_ADDR"

.field protected static final METRICS_SERVICE_NAME:Ljava/lang/String; = "DeviceMetricsService"

.field protected static final METRIC_NON_TCOMM_SUFFIX:Ljava/lang/String; = "_NonTComm"

.field public static final MODEL:Ljava/lang/String; = "model"

.field protected static final PASSTHROUGH_SETTINGS_PREFIX:Ljava/lang/String; = "PASSTHROUGH_"

.field public static final PLATFORM:Ljava/lang/String; = "platform"

.field public static final PREFERRED_MARKETPLACE:Ljava/lang/String; = "MarketplaceID"

.field public static final PROTOCOL_BUFFER_CODEC_FORMAT_HEADER:Ljava/lang/String; = "x-codec-format"

.field public static final PROTOCOL_BUFFER_CODEC_VERSION_HEADER:Ljava/lang/String; = "x-codec-version"

.field public static final RSM_GROUP:Ljava/lang/String; = "remoteSettingsGroup"

.field public static final SESSION_ID:Ljava/lang/String; = "Session"

.field public static final SOFTWARE_VERSION:Ljava/lang/String; = "softwareVersion"

.field public static final STATIC_CREDENTIAL_TOKEN_HEADER:Ljava/lang/String; = "x-credential-token"

.field public static final USER_AGENT:Ljava/lang/String; = "HTTP_USER_AGENT"

.field protected static sPassThroughHighPriorityPipelineConfiguration:Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

.field protected static sPassThroughNormalPriorityPipelineConfiguration:Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;


# instance fields
.field private final mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

.field private mCodecConfiguration:Lcom/amazon/client/metrics/configuration/CodecConfiguration;

.field private mDomain:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

.field private final mHttpConfiguration:Lcom/amazon/client/metrics/configuration/HttpConfiguration;

.field private mNetworkConfiguration:Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

.field private mPipelineConfigurationMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/client/metrics/Priority;",
            "Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 18

    .prologue
    .line 33
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    sget-object v1, Lcom/amazon/client/metrics/configuration/BatchQueueType;->NON_VOLATILE:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    const-string/jumbo v2, ""

    const-wide/16 v3, 0x2710

    const-wide/16 v5, 0x1f4

    const/16 v7, 0xa

    const/high16 v8, 0x10000

    const/high16 v9, 0x500000

    const/high16 v10, 0x10000

    const-wide/32 v11, 0x240c8400

    const-wide/32 v13, 0x5265c00

    const-wide/32 v15, 0x927c0

    sget-object v17, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->PERIODIC:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    invoke-direct/range {v0 .. v17}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;JJIIIIJJJLcom/amazon/client/metrics/configuration/BatchTransmitterType;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->sPassThroughNormalPriorityPipelineConfiguration:Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    .line 48
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    sget-object v1, Lcom/amazon/client/metrics/configuration/BatchQueueType;->SEMI_VOLATILE:Lcom/amazon/client/metrics/configuration/BatchQueueType;

    const-string/jumbo v2, ""

    const-wide/16 v3, 0x3e8

    const-wide/16 v5, 0x1f4

    const/4 v7, 0x1

    const/high16 v8, 0x10000

    const/high16 v9, 0x100000

    const/high16 v10, 0x10000

    const-wide/32 v11, 0x240c8400

    const-wide/32 v13, 0x5265c00

    const-wide/32 v15, 0x927c0

    sget-object v17, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->URGENT:Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    invoke-direct/range {v0 .. v17}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;JJIIIIJJJLcom/amazon/client/metrics/configuration/BatchTransmitterType;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->sPassThroughHighPriorityPipelineConfiguration:Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/NetworkConfiguration;Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;Lcom/amazon/client/metrics/configuration/CodecConfiguration;Lcom/amazon/client/metrics/configuration/HttpConfiguration;Ljava/util/Map;)V
    .locals 5
    .param p1, "networkConfiguration"    # Lcom/amazon/client/metrics/configuration/NetworkConfiguration;
    .param p2, "batchQueueConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    .param p3, "codecConfiguration"    # Lcom/amazon/client/metrics/configuration/CodecConfiguration;
    .param p4, "httpConfiguration"    # Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/client/metrics/configuration/NetworkConfiguration;",
            "Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;",
            "Lcom/amazon/client/metrics/configuration/CodecConfiguration;",
            "Lcom/amazon/client/metrics/configuration/HttpConfiguration;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/client/metrics/Priority;",
            "Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 121
    .local p5, "pipelineConfigurationMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 122
    if-nez p1, :cond_0

    .line 123
    new-instance v3, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v4, "NetworkConfiguration is null"

    invoke-direct {v3, v4}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 125
    :cond_0
    if-nez p2, :cond_1

    .line 126
    new-instance v3, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v4, "BatchQueueConfiguration is null"

    invoke-direct {v3, v4}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 128
    :cond_1
    if-nez p3, :cond_2

    .line 129
    new-instance v3, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v4, "CodecConfiguration is null"

    invoke-direct {v3, v4}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 131
    :cond_2
    if-nez p4, :cond_3

    .line 132
    new-instance v3, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v4, "HttpConfiguration is null"

    invoke-direct {v3, v4}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 134
    :cond_3
    if-eqz p5, :cond_4

    invoke-interface {p5}, Ljava/util/Map;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 135
    :cond_4
    new-instance v3, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v4, "PipelineConfiguration map is null"

    invoke-direct {v3, v4}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 137
    :cond_5
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mNetworkConfiguration:Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    .line 138
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    .line 139
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mCodecConfiguration:Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    .line 140
    iput-object p4, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mHttpConfiguration:Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    .line 141
    iput-object p5, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    .line 148
    iget-object v3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_6
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/client/metrics/Priority;

    .line 149
    .local v2, "priority":Lcom/amazon/client/metrics/Priority;
    iget-object v3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v3}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v0

    .line 150
    .local v0, "batchQueueType":Lcom/amazon/client/metrics/configuration/BatchQueueType;
    if-nez v0, :cond_6

    .line 151
    iget-object v3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    iget-object v4, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    invoke-virtual {v4}, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->setBatchQueueType(Lcom/amazon/client/metrics/configuration/BatchQueueType;)V

    .line 152
    iget-object v3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v3, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    iget-object v4, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    invoke-virtual {v4}, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->setDirectoryPrefix(Ljava/lang/String;)V

    goto :goto_0

    .line 155
    .end local v0    # "batchQueueType":Lcom/amazon/client/metrics/configuration/BatchQueueType;
    .end local v2    # "priority":Lcom/amazon/client/metrics/Priority;
    :cond_7
    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/NetworkConfiguration;Lcom/amazon/client/metrics/configuration/CodecConfiguration;Lcom/amazon/client/metrics/configuration/HttpConfiguration;Ljava/util/Map;)V
    .locals 4
    .param p1, "networkConfiguration"    # Lcom/amazon/client/metrics/configuration/NetworkConfiguration;
    .param p2, "codecConfiguration"    # Lcom/amazon/client/metrics/configuration/CodecConfiguration;
    .param p3, "httpConfiguration"    # Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/client/metrics/configuration/NetworkConfiguration;",
            "Lcom/amazon/client/metrics/configuration/CodecConfiguration;",
            "Lcom/amazon/client/metrics/configuration/HttpConfiguration;",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/client/metrics/Priority;",
            "Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 170
    .local p4, "pipelineConfigurationMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 171
    if-nez p1, :cond_0

    .line 172
    new-instance v1, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v2, "NetworkConfiguration is null"

    invoke-direct {v1, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 174
    :cond_0
    if-nez p2, :cond_1

    .line 175
    new-instance v1, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v2, "CodecConfiguration is null"

    invoke-direct {v1, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 177
    :cond_1
    if-nez p3, :cond_2

    .line 178
    new-instance v1, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v2, "HttpConfiguration is null"

    invoke-direct {v1, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 180
    :cond_2
    if-eqz p4, :cond_3

    invoke-interface {p4}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 181
    :cond_3
    new-instance v1, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v2, "PipelineConfiguration map is null"

    invoke-direct {v1, v2}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 183
    :cond_4
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mNetworkConfiguration:Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    .line 184
    iput-object p2, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mCodecConfiguration:Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    .line 185
    iput-object p3, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mHttpConfiguration:Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    .line 186
    iput-object p4, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    .line 197
    iget-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    sget-object v2, Lcom/amazon/client/metrics/Priority;->NORMAL:Lcom/amazon/client/metrics/Priority;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    .line 198
    .local v0, "pipelineConfiguration":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    if-eqz v0, :cond_5

    .line 199
    new-instance v1, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    invoke-interface {v0}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v2

    invoke-interface {v0}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    .line 207
    :goto_0
    return-void

    .line 203
    :cond_5
    iget-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "pipelineConfiguration":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    check-cast v0, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    .line 204
    .restart local v0    # "pipelineConfiguration":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    new-instance v1, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    invoke-interface {v0}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v2

    invoke-interface {v0}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    goto :goto_0
.end method


# virtual methods
.method public getBatchQueueConfiguration()Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 241
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mBatchQueueConfiguration:Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    return-object v0
.end method

.method public getBatchQueueDirectoryName(Lcom/amazon/client/metrics/Priority;)Ljava/lang/String;
    .locals 3
    .param p1, "priority"    # Lcom/amazon/client/metrics/Priority;

    .prologue
    .line 291
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v1}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getDirectoryPrefix()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/client/metrics/Priority;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 292
    .local v0, "directoryName":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getTransportType()Lcom/amazon/client/metrics/configuration/TransportType;

    move-result-object v1

    sget-object v2, Lcom/amazon/client/metrics/configuration/TransportType;->OUTPUT_STREAM:Lcom/amazon/client/metrics/configuration/TransportType;

    invoke-virtual {v1, v2}, Lcom/amazon/client/metrics/configuration/TransportType;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 293
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "PASSTHROUGH_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "_NonTComm"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 295
    .end local v0    # "directoryName":Ljava/lang/String;
    :cond_0
    return-object v0
.end method

.method public getCodecConfiguration()Lcom/amazon/client/metrics/configuration/CodecConfiguration;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mCodecConfiguration:Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    return-object v0
.end method

.method public getEndpointIdentity()Lamazon/communication/identity/EndpointIdentity;
    .locals 2

    .prologue
    .line 257
    invoke-virtual {p0}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getTransportType()Lcom/amazon/client/metrics/configuration/TransportType;

    move-result-object v0

    sget-object v1, Lcom/amazon/client/metrics/configuration/TransportType;->HTTP:Lcom/amazon/client/metrics/configuration/TransportType;

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/configuration/TransportType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mHttpConfiguration:Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->getUrlEndpoint()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createUrlEndpointIdentity(Ljava/lang/String;)Lamazon/communication/identity/UrlEndpointIdentity;

    move-result-object v0

    .line 260
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "DeviceMetricsService"

    invoke-static {v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createServiceIdentity(Ljava/lang/String;)Lamazon/communication/identity/ServiceIdentity;

    move-result-object v0

    goto :goto_0
.end method

.method public getHttpConfiguration()Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mHttpConfiguration:Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    return-object v0
.end method

.method public getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mNetworkConfiguration:Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    return-object v0
.end method

.method public getPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .locals 1
    .param p1, "priority"    # Lcom/amazon/client/metrics/Priority;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    return-object v0
.end method

.method public getStaticCredentialEndpointIdentity()Lamazon/communication/identity/EndpointIdentity;
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mHttpConfiguration:Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->getStaticCredentialUrlEndpoint()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lamazon/communication/identity/EndpointIdentityFactory;->createUrlEndpointIdentity(Ljava/lang/String;)Lamazon/communication/identity/UrlEndpointIdentity;

    move-result-object v0

    return-object v0
.end method

.method public setPassThroughMode()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 275
    new-instance v0, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;

    sget-object v1, Lcom/amazon/client/metrics/configuration/TransportType;->OUTPUT_STREAM:Lcom/amazon/client/metrics/configuration/TransportType;

    iget-object v2, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mNetworkConfiguration:Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getNetworkTypes()Ljava/util/Set;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/TransportType;Ljava/util/Set;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mNetworkConfiguration:Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    .line 276
    new-instance v0, Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    sget-object v1, Lcom/amazon/client/metrics/configuration/CodecType;->STRING:Lcom/amazon/client/metrics/configuration/CodecType;

    const-string/jumbo v2, "1.0"

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/CodecType;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mCodecConfiguration:Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    .line 277
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 278
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/client/metrics/Priority;->NORMAL:Lcom/amazon/client/metrics/Priority;

    sget-object v2, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->sPassThroughNormalPriorityPipelineConfiguration:Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    iget-object v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->mPipelineConfigurationMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/client/metrics/Priority;->HIGH:Lcom/amazon/client/metrics/Priority;

    sget-object v2, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->sPassThroughHighPriorityPipelineConfiguration:Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    return-void
.end method
