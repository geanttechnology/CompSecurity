.class public Lcom/amazon/client/metrics/BaseMetricsServiceFactory;
.super Ljava/lang/Object;
.source "BaseMetricsServiceFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/BaseMetricsServiceFactory$1;
    }
.end annotation


# static fields
.field protected static final METRIC_LOG_FILE_NAME:Ljava/lang/String; = "metric-log"

.field private static final OVERRIDING_UUID_KEY:Ljava/lang/String; = "secondaryUUID"

.field protected static final PERIODIC_METRIC_REPORTER_PERIOD_MINS:I = 0x5

.field protected static final PREF_USE_PASS_THROUGH_MODE:Ljava/lang/String; = "PREF_USE_PASS_THROUGH_MODE"

.field public static final PROGRAM_NAME_METRICS_SERVICE:Ljava/lang/String; = "MetricsService"

.field private static final ROTATING_UUID_KEY:Ljava/lang/String; = "rotatingUUID"

.field public static final SOURCE_NAME_RECORD_METRIC:Ljava/lang/String; = "RecordMetric"

.field protected static final TRANSPORT_PREF_FILENAME:Ljava/lang/String; = "transport-preferences"

.field protected static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected mContext:Landroid/content/Context;

.field protected final mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

.field protected mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

.field protected mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

.field protected final mOAuthRequestSigner:Lcom/amazon/client/metrics/transport/OAuthRequestSigner;

.field protected mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

.field protected mTransmissionOffsetMillis:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 78
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "BaseMetricsServiceFactory"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 112
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;-><init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Lcom/amazon/client/metrics/configuration/MetricsConfiguration;)V

    .line 113
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Lcom/amazon/client/metrics/configuration/MetricsConfiguration;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .param p3, "metricsConfig"    # Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    new-instance v0, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;

    invoke-direct {v0}, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mOAuthRequestSigner:Lcom/amazon/client/metrics/transport/OAuthRequestSigner;

    .line 129
    if-nez p1, :cond_0

    .line 130
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 132
    :cond_0
    iput-object p1, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    .line 133
    iput-object p2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    .line 134
    if-nez p3, :cond_1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->getMetricsConfiguration(Landroid/content/Context;)Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    move-result-object p3

    .end local p3    # "metricsConfig":Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    :cond_1
    iput-object p3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    .line 135
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->shouldUsePassThroughMode(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 136
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->setPassThroughMode()V

    .line 138
    :cond_2
    sget-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "createMetricsService"

    const-string/jumbo v2, "Getting MetricsFactory via getSystemService()."

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 139
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "com.amazon.client.metrics.api"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/MetricsFactory;

    iput-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 140
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    if-nez v0, :cond_3

    .line 141
    sget-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "createMetricsService"

    const-string/jumbo v2, "Could not obtain MetricsFactory via context.getSystemService(). Falling back on AndroidMetricsFactoryImpl.getInstance(context)"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 142
    invoke-static {p1}, Lcom/amazon/client/metrics/AndroidMetricsFactoryImpl;->getInstance(Landroid/content/Context;)Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    .line 144
    :cond_3
    new-instance v0, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;

    iget-object v1, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsFactory:Lcom/amazon/client/metrics/MetricsFactory;

    const-string/jumbo v2, "MetricsService"

    const-string/jumbo v3, "RecordMetric"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/client/metrics/PeriodicMetricReporterImpl;-><init>(Lcom/amazon/client/metrics/MetricsFactory;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .line 145
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    const-wide/16 v1, 0x5

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->startRecordingPeriodically(JLjava/util/concurrent/TimeUnit;)V

    .line 159
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    const-wide/high16 v2, 0x43e0000000000000L    # 9.223372036854776E18

    mul-double/2addr v0, v2

    const-wide v2, 0x408f400000000000L    # 1000.0

    div-double/2addr v0, v2

    double-to-long v0, v0

    const-wide/16 v2, 0x3e8

    mul-long/2addr v0, v2

    iput-wide v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mTransmissionOffsetMillis:J

    .line 160
    return-void
.end method

.method private createHTTPMetricsTransport()Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;
    .locals 5

    .prologue
    .line 279
    new-instance v0, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;

    iget-object v1, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    iget-object v3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createRequestSigner()Lamazon/communication/authentication/RequestSigner;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;-><init>(Landroid/content/Context;Lcom/amazon/client/metrics/configuration/MetricsConfiguration;Lcom/amazon/device/utils/DeviceUtil;Lamazon/communication/authentication/RequestSigner;)V

    return-object v0
.end method

.method private createOutputStreamMetricsTransport()Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 308
    new-instance v0, Ljava/io/File;

    iget-object v3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v3

    const-string/jumbo v4, "metric-log"

    invoke-direct {v0, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 309
    .local v0, "metricsFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->createNewFile()Z

    .line 310
    sget-object v3, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "createOutputStreamMetricsService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Metric log file: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 311
    new-instance v1, Ljava/io/BufferedOutputStream;

    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v1, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 312
    .local v1, "outputStream":Ljava/io/OutputStream;
    new-instance v2, Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;

    invoke-direct {v2, v1}, Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;-><init>(Ljava/io/OutputStream;)V

    .line 313
    .local v2, "outputStreamMetricsTransport":Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;
    return-object v2
.end method


# virtual methods
.method protected addOffset(JJ)J
    .locals 4
    .param p1, "transmissionPeriodMillis"    # J
    .param p3, "transmissionOffsetMillis"    # J

    .prologue
    .line 488
    rem-long v0, p3, p1

    .line 490
    .local v0, "transmissionPeriodMillisWithOffset":J
    const-wide/16 v2, 0x2

    div-long v2, p1, v2

    cmp-long v2, v0, v2

    if-gez v2, :cond_0

    .line 491
    add-long/2addr v0, p1

    .line 493
    :cond_0
    return-wide v0
.end method

.method protected createBatchCreator(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/DeviceInfoManager;)Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    .locals 7
    .param p1, "batchQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "priority"    # Lcom/amazon/client/metrics/Priority;
    .param p3, "deviceInfoManager"    # Lcom/amazon/client/metrics/DeviceInfoManager;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 327
    invoke-virtual {p0, p2}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->getBatchPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    move-result-object v4

    .line 328
    .local v4, "batchPipelineConfig":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    sget-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory$1;->$SwitchMap$com$amazon$client$metrics$configuration$CodecType:[I

    iget-object v1, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getCodecConfiguration()Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->getCodecType()Lcom/amazon/client/metrics/configuration/CodecType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/CodecType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 344
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unsupported CodecType: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getCodecConfiguration()Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;->getCodecType()Lcom/amazon/client/metrics/configuration/CodecType;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 330
    :pswitch_0
    new-instance v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    new-instance v2, Lcom/amazon/client/metrics/codec/MetricBatchProtocolBuffersCodec;

    invoke-direct {v2}, Lcom/amazon/client/metrics/codec/MetricBatchProtocolBuffersCodec;-><init>()V

    new-instance v3, Lcom/amazon/client/metrics/codec/MetricEntryProtocolBuffersCodec;

    invoke-direct {v3}, Lcom/amazon/client/metrics/codec/MetricEntryProtocolBuffersCodec;-><init>()V

    iget-object v5, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    move-object v1, p1

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/codec/MetricBatchCodec;Lcom/amazon/client/metrics/codec/MetricEntryCodec;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Lcom/amazon/client/metrics/DeviceInfoManager;)V

    .line 337
    :goto_0
    return-object v0

    :pswitch_1
    new-instance v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    new-instance v2, Lcom/amazon/client/metrics/codec/MetricBatchToStringCodec;

    invoke-direct {v2}, Lcom/amazon/client/metrics/codec/MetricBatchToStringCodec;-><init>()V

    new-instance v3, Lcom/amazon/client/metrics/codec/MetricEntryToStringCodec;

    invoke-direct {v3}, Lcom/amazon/client/metrics/codec/MetricEntryToStringCodec;-><init>()V

    iget-object v5, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    move-object v1, p1

    move-object v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/codec/MetricBatchCodec;Lcom/amazon/client/metrics/codec/MetricEntryCodec;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Lcom/amazon/client/metrics/DeviceInfoManager;)V

    goto :goto_0

    .line 328
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected createBatchQueue(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .locals 6
    .param p1, "priority"    # Lcom/amazon/client/metrics/Priority;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 359
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->getBatchPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    move-result-object v0

    .line 361
    .local v0, "batchPipelineConfig":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    sget-object v1, Lcom/amazon/client/metrics/BaseMetricsServiceFactory$1;->$SwitchMap$com$amazon$client$metrics$configuration$BatchQueueType:[I

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v2, p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/BatchQueueType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 385
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unsupported BatchQueueType: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v3, p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchQueueType()Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 363
    :pswitch_0
    new-instance v1, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-direct {v1, v0, v2}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V

    .line 378
    :goto_0
    return-object v1

    .line 369
    :pswitch_1
    new-instance v1, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    iget-object v3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v4, p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getBatchQueueDirectoryName(Lcom/amazon/client/metrics/Priority;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Ljava/io/File;)V

    goto :goto_0

    .line 378
    :pswitch_2
    new-instance v1, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    iget-object v3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v4, p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getBatchQueueDirectoryName(Lcom/amazon/client/metrics/Priority;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v1, v0, v2, v3}, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Ljava/io/File;)V

    goto :goto_0

    .line 361
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method protected createBatchTransmitter(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;)Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    .locals 8
    .param p1, "byteArrayQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "metricsTransport"    # Lcom/amazon/client/metrics/transport/MetricsTransport;
    .param p3, "uploadResultBroadcaster"    # Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    .param p4, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    .prologue
    .line 413
    invoke-interface {p4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getTransmissionPeriodMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mTransmissionOffsetMillis:J

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->addOffset(JJ)J

    move-result-wide v6

    .line 414
    .local v6, "initialTransmissionPeriodMillis":J
    sget-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory$1;->$SwitchMap$com$amazon$client$metrics$configuration$BatchTransmitterType:[I

    invoke-interface {p4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchTransmitterType()Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 420
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unsupported PeriodicBatchTransmitterType "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getBatchTransmitterType()Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 416
    :pswitch_0
    new-instance v0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    iget-object v5, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v7}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;J)V

    .line 418
    :goto_0
    return-object v0

    :pswitch_1
    new-instance v0, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;

    iget-object v5, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v7}, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;J)V

    goto :goto_0

    .line 414
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected createMetricsService()Lcom/amazon/client/metrics/MetricsService;
    .locals 26

    .prologue
    .line 185
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createMetricsTransport()Lcom/amazon/client/metrics/transport/MetricsTransport;

    move-result-object v17

    .line 186
    .local v17, "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    new-instance v19, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    move-object/from16 v20, v0

    invoke-direct/range {v19 .. v20}, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;-><init>(Landroid/content/Context;)V

    .line 187
    .local v19, "uploadResultBroadcaster":Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    new-instance v5, Ljava/util/HashMap;

    invoke-static {}, Lcom/amazon/client/metrics/Priority;->values()[Lcom/amazon/client/metrics/Priority;

    move-result-object v20

    move-object/from16 v0, v20

    array-length v0, v0

    move/from16 v20, v0

    move/from16 v0, v20

    invoke-direct {v5, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 188
    .local v5, "batchCreatorMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/batch/creator/BatchCreator;>;"
    new-instance v9, Ljava/util/ArrayList;

    invoke-static {}, Lcom/amazon/client/metrics/Priority;->values()[Lcom/amazon/client/metrics/Priority;

    move-result-object v20

    move-object/from16 v0, v20

    array-length v0, v0

    move/from16 v20, v0

    move/from16 v0, v20

    invoke-direct {v9, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 190
    .local v9, "batchTransmitterList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;>;"
    new-instance v11, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    invoke-direct {v11, v0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;-><init>(Lcom/amazon/device/utils/DeviceUtil;)V

    .line 191
    .local v11, "deviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    invoke-static {}, Lcom/amazon/client/metrics/Priority;->values()[Lcom/amazon/client/metrics/Priority;

    move-result-object v3

    .local v3, "arr$":[Lcom/amazon/client/metrics/Priority;
    array-length v0, v3

    move/from16 v16, v0

    .local v16, "len$":I
    const/4 v14, 0x0

    .local v14, "i$":I
    :goto_0
    move/from16 v0, v16

    if-ge v14, v0, :cond_3

    aget-object v18, v3, v14

    .line 192
    .local v18, "priority":Lcom/amazon/client/metrics/Priority;
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->getBatchPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    move-result-object v6

    .line 196
    .local v6, "batchPipelineConfig":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    if-nez v6, :cond_0

    .line 197
    sget-object v20, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v21, "createMetricsService"

    const-string/jumbo v22, "Skipping batch pipeline setup for "

    const/16 v23, 0x2

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-object v18, v23, v24

    const/16 v24, 0x1

    const-string/jumbo v25, " because no configuration is provided."

    aput-object v25, v23, v24

    invoke-virtual/range {v20 .. v23}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 191
    :goto_1
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 205
    :cond_0
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createBatchQueue(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    move-result-object v7

    .line 206
    .local v7, "batchQueue":Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    invoke-virtual/range {v18 .. v18}, Lcom/amazon/client/metrics/Priority;->toString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-interface {v7, v0}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->setQueueName(Ljava/lang/String;)V

    .line 212
    sget-object v20, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_NON_ANONYMOUS_METRICS:Lcom/amazon/client/metrics/Priority;

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/Priority;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_1

    .line 216
    new-instance v12, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    move-object/from16 v21, v0

    const-string/jumbo v22, "secondaryUUID"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v12, v0, v1, v2}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;-><init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/lang/String;)V

    .line 217
    .local v12, "dsnOverridingDeviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v7, v1, v12}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createBatchCreator(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/DeviceInfoManager;)Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    move-result-object v4

    .line 225
    .end local v12    # "dsnOverridingDeviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    .local v4, "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    :goto_2
    move-object/from16 v0, v18

    invoke-interface {v5, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v19

    invoke-virtual {v0, v7, v1, v2, v6}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createBatchTransmitter(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;)Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    move-result-object v8

    .line 231
    .local v8, "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    invoke-interface {v9, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/dp/framework/CodecException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 241
    .end local v3    # "arr$":[Lcom/amazon/client/metrics/Priority;
    .end local v4    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    .end local v5    # "batchCreatorMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/batch/creator/BatchCreator;>;"
    .end local v6    # "batchPipelineConfig":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .end local v7    # "batchQueue":Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .end local v8    # "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    .end local v9    # "batchTransmitterList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;>;"
    .end local v11    # "deviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    .end local v14    # "i$":I
    .end local v16    # "len$":I
    .end local v17    # "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    .end local v18    # "priority":Lcom/amazon/client/metrics/Priority;
    .end local v19    # "uploadResultBroadcaster":Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    :catch_0
    move-exception v10

    .line 242
    .local v10, "ce":Lcom/dp/framework/CodecException;
    sget-object v20, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v21, "createMetricsService"

    const-string/jumbo v22, "could not serialize device info"

    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-object v10, v23, v24

    invoke-virtual/range {v20 .. v23}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 243
    new-instance v20, Ljava/lang/RuntimeException;

    move-object/from16 v0, v20

    invoke-direct {v0, v10}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v20

    .line 218
    .end local v10    # "ce":Lcom/dp/framework/CodecException;
    .restart local v3    # "arr$":[Lcom/amazon/client/metrics/Priority;
    .restart local v5    # "batchCreatorMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/batch/creator/BatchCreator;>;"
    .restart local v6    # "batchPipelineConfig":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .restart local v7    # "batchQueue":Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .restart local v9    # "batchTransmitterList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;>;"
    .restart local v11    # "deviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    .restart local v14    # "i$":I
    .restart local v16    # "len$":I
    .restart local v17    # "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    .restart local v18    # "priority":Lcom/amazon/client/metrics/Priority;
    .restart local v19    # "uploadResultBroadcaster":Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    :cond_1
    :try_start_1
    sget-object v20, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_LOCATION_SERVICE:Lcom/amazon/client/metrics/Priority;

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/Priority;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-eqz v20, :cond_2

    .line 220
    new-instance v13, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mContext:Landroid/content/Context;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    move-object/from16 v21, v0

    const-string/jumbo v22, "rotatingUUID"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-direct {v13, v0, v1, v2}, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;-><init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/lang/String;)V

    .line 221
    .local v13, "dsnRotatingDeviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v7, v1, v13}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createBatchCreator(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/DeviceInfoManager;)Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    move-result-object v4

    .line 222
    .restart local v4    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    goto :goto_2

    .line 223
    .end local v4    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    .end local v13    # "dsnRotatingDeviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v7, v1, v11}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createBatchCreator(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/DeviceInfoManager;)Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    move-result-object v4

    .restart local v4    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    goto :goto_2

    .line 235
    .end local v4    # "batchCreator":Lcom/amazon/client/metrics/batch/creator/BatchCreator;
    .end local v6    # "batchPipelineConfig":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .end local v7    # "batchQueue":Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .end local v18    # "priority":Lcom/amazon/client/metrics/Priority;
    :cond_3
    sget-object v20, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v21, "createMetricsService"

    const-string/jumbo v22, "Triggering intial push for stored metrics on service startup"

    const/16 v23, 0x0

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v20 .. v23}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 236
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v14, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_4

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    .line 237
    .restart local v8    # "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    const/16 v20, 0x0

    move/from16 v0, v20

    invoke-virtual {v8, v0}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->transmitBatches(Z)V
    :try_end_1
    .catch Lcom/dp/framework/CodecException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_3

    .line 244
    .end local v3    # "arr$":[Lcom/amazon/client/metrics/Priority;
    .end local v5    # "batchCreatorMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/batch/creator/BatchCreator;>;"
    .end local v8    # "batchTransmitter":Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
    .end local v9    # "batchTransmitterList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;>;"
    .end local v11    # "deviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    .end local v14    # "i$":Ljava/util/Iterator;
    .end local v16    # "len$":I
    .end local v17    # "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    .end local v19    # "uploadResultBroadcaster":Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    :catch_1
    move-exception v15

    .line 245
    .local v15, "ioe":Ljava/io/IOException;
    sget-object v20, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v21, "createMetricsService"

    const-string/jumbo v22, "\'could not create batch queue"

    const/16 v23, 0x1

    move/from16 v0, v23

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    aput-object v15, v23, v24

    invoke-virtual/range {v20 .. v23}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 246
    new-instance v20, Ljava/lang/RuntimeException;

    move-object/from16 v0, v20

    invoke-direct {v0, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v20

    .line 240
    .end local v15    # "ioe":Ljava/io/IOException;
    .restart local v3    # "arr$":[Lcom/amazon/client/metrics/Priority;
    .restart local v5    # "batchCreatorMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/batch/creator/BatchCreator;>;"
    .restart local v9    # "batchTransmitterList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;>;"
    .restart local v11    # "deviceInfoManager":Lcom/amazon/client/metrics/DeviceInfoManager;
    .restart local v14    # "i$":Ljava/util/Iterator;
    .restart local v16    # "len$":I
    .restart local v17    # "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    .restart local v19    # "uploadResultBroadcaster":Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    :cond_4
    :try_start_2
    new-instance v20, Lcom/amazon/client/metrics/MetricsService;

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createTriggerEvaluator()Lcom/amazon/client/metrics/trigger/TriggerEvaluator;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-direct {v0, v5, v9, v1}, Lcom/amazon/client/metrics/MetricsService;-><init>(Ljava/util/Map;Ljava/util/List;Lcom/amazon/client/metrics/trigger/TriggerEvaluator;)V
    :try_end_2
    .catch Lcom/dp/framework/CodecException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    return-object v20
.end method

.method protected createMetricsTransport()Lcom/amazon/client/metrics/transport/MetricsTransport;
    .locals 6

    .prologue
    .line 258
    sget-object v1, Lcom/amazon/client/metrics/BaseMetricsServiceFactory$1;->$SwitchMap$com$amazon$client$metrics$configuration$TransportType:[I

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getTransportType()Lcom/amazon/client/metrics/configuration/TransportType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/TransportType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 269
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Unsupported TransportType: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getNetworkConfiguration()Lcom/amazon/client/metrics/configuration/NetworkConfiguration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/client/metrics/configuration/NetworkConfiguration;->getTransportType()Lcom/amazon/client/metrics/configuration/TransportType;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 260
    :pswitch_0
    invoke-direct {p0}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createHTTPMetricsTransport()Lcom/amazon/client/metrics/transport/HTTPMetricsTransport;

    move-result-object v1

    .line 263
    :goto_0
    return-object v1

    :pswitch_1
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->createOutputStreamMetricsTransport()Lcom/amazon/client/metrics/transport/OutputStreamMetricsTransport;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 264
    :catch_0
    move-exception v0

    .line 265
    .local v0, "e":Ljava/io/IOException;
    sget-object v1, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "createMetricsTransport"

    const-string/jumbo v3, "postInitialize failed"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 266
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    .line 258
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected createRequestSigner()Lamazon/communication/authentication/RequestSigner;
    .locals 3

    .prologue
    .line 292
    sget-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory$1;->$SwitchMap$com$amazon$client$metrics$configuration$HttpRequestSignerType:[I

    iget-object v1, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getHttpConfiguration()Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->getHttpRequestSignerType()Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 296
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unsupported TransportType: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getHttpConfiguration()Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/HttpConfiguration;->getHttpRequestSignerType()Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 294
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mOAuthRequestSigner:Lcom/amazon/client/metrics/transport/OAuthRequestSigner;

    return-object v0

    .line 292
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected createTriggerEvaluator()Lcom/amazon/client/metrics/trigger/TriggerEvaluator;
    .locals 1

    .prologue
    .line 396
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getBatchPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .locals 1
    .param p1, "priority"    # Lcom/amazon/client/metrics/Priority;

    .prologue
    .line 429
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mMetricsConfiguration:Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;->getPipelineConfiguration(Lcom/amazon/client/metrics/Priority;)Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    move-result-object v0

    return-object v0
.end method

.method protected getMetricsConfiguration(Landroid/content/Context;)Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 460
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v2

    const-string/jumbo v3, "metrics_configuration"

    invoke-virtual {v2, v3}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    .line 461
    .local v0, "assetFileInputStream":Ljava/io/InputStream;
    new-instance v2, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    invoke-direct {v2, v0, v3}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;-><init>(Ljava/io/InputStream;Landroid/content/pm/ApplicationInfo;)V

    invoke-virtual {v2}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->parseConfiguration()Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    return-object v2

    .line 462
    .end local v0    # "assetFileInputStream":Ljava/io/InputStream;
    :catch_0
    move-exception v1

    .line 463
    .local v1, "e":Ljava/io/IOException;
    new-instance v2, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v3, "An IOException was thrown loading the metrics configuration"

    invoke-direct {v2, v3, v1}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method

.method public getPeriodicMetricReporter()Lcom/amazon/client/metrics/PeriodicMetricReporter;
    .locals 1

    .prologue
    .line 469
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    return-object v0
.end method

.method protected getSessionID()Ljava/lang/String;
    .locals 6

    .prologue
    .line 473
    sget-object v0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "BaseMetricsServiceFactory_getSessionID"

    const-string/jumbo v2, "SessionID"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v5}, Lcom/amazon/device/utils/DeviceUtil;->fetchSessionID()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 474
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->fetchSessionID()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setOAuthHelper(Lcom/amazon/client/metrics/transport/OAuthHelper;)V
    .locals 1
    .param p1, "oAuthHelper"    # Lcom/amazon/client/metrics/transport/OAuthHelper;

    .prologue
    .line 446
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mOAuthRequestSigner:Lcom/amazon/client/metrics/transport/OAuthRequestSigner;

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/transport/OAuthRequestSigner;->setOAuthHelper(Lcom/amazon/client/metrics/transport/OAuthHelper;)V

    .line 447
    return-void
.end method

.method protected shouldUsePassThroughMode(Landroid/content/Context;)Z
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x0

    .line 166
    sget-object v2, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "shouldUsePassThroughMode"

    const-string/jumbo v4, "Looking up transport preferences at transport-preferences"

    new-array v5, v7, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 167
    const-string/jumbo v2, "transport-preferences"

    invoke-virtual {p1, v2, v7}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 170
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string/jumbo v2, "PREF_USE_PASS_THROUGH_MODE"

    invoke-interface {v0, v2, v7}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 172
    .local v1, "usePassThroughMode":Z
    sget-object v2, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "shouldUsePassThroughMode"

    const-string/jumbo v4, "usePassThroughMode"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 173
    return v1
.end method

.method public shutdown()V
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    if-eqz v0, :cond_0

    .line 437
    iget-object v0, p0, Lcom/amazon/client/metrics/BaseMetricsServiceFactory;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v0}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->shutdown()V

    .line 439
    :cond_0
    return-void
.end method
