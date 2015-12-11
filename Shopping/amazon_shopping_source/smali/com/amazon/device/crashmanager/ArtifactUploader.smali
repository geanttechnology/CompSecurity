.class Lcom/amazon/device/crashmanager/ArtifactUploader;
.super Ljava/lang/Object;
.source "ArtifactUploader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/crashmanager/ArtifactUploader$1;,
        Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mArtifactProcessors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/crashmanager/ArtifactProcessor;",
            ">;"
        }
    .end annotation
.end field

.field private final mArtifactSources:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/crashmanager/ArtifactSource;",
            ">;"
        }
    .end annotation
.end field

.field private final mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

.field private final mDetEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

.field protected mDetUtil:Lcom/amazon/device/utils/DetUtil;

.field private final mDeviceSerialNumber:Ljava/lang/String;

.field private final mDeviceType:Ljava/lang/String;

.field private final mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

.field private final mRequestContext:Lamazon/communication/authentication/RequestContext;

.field private final mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

.field private final mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 57
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "ArtifactUploader"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lamazon/communication/identity/EndpointIdentity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;Lcom/amazon/device/utils/StatusNotifier;Lcom/amazon/communication/authentication/RequestSigner;Lcom/amazon/device/utils/NetworkManager;)V
    .locals 3
    .param p1, "endpointIdentity"    # Lamazon/communication/identity/EndpointIdentity;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "deviceSerialNumber"    # Ljava/lang/String;
    .param p6, "crashDescriptorStorageUtil"    # Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
    .param p7, "statusNotifier"    # Lcom/amazon/device/utils/StatusNotifier;
    .param p8, "requestSigner"    # Lcom/amazon/communication/authentication/RequestSigner;
    .param p9, "networkManager"    # Lcom/amazon/device/utils/NetworkManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lamazon/communication/identity/EndpointIdentity;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/crashmanager/ArtifactSource;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/crashmanager/ArtifactProcessor;",
            ">;",
            "Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;",
            "Lcom/amazon/device/utils/StatusNotifier;",
            "Lcom/amazon/communication/authentication/RequestSigner;",
            "Lcom/amazon/device/utils/NetworkManager;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 76
    .local p4, "artifactSources":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/crashmanager/ArtifactSource;>;"
    .local p5, "artifactProcessors":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/device/crashmanager/ArtifactProcessor;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    new-instance v0, Lcom/amazon/device/utils/DetUtil;

    invoke-direct {v0}, Lcom/amazon/device/utils/DetUtil;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    .line 77
    if-nez p1, :cond_0

    .line 78
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Endpoint identity must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 81
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Device type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", is invalid"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 83
    :cond_2
    if-eqz p3, :cond_3

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_4

    .line 84
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Device type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", is invalid"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 86
    :cond_4
    if-nez p4, :cond_5

    .line 87
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Artifact sources must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 89
    :cond_5
    if-nez p5, :cond_6

    .line 90
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Artifact processors must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_6
    if-nez p6, :cond_7

    .line 93
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "CrashDescriptorStorageUtil must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 95
    :cond_7
    if-nez p7, :cond_8

    .line 96
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "StatusNotifier must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 98
    :cond_8
    if-nez p8, :cond_9

    .line 99
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "RequestSigner must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 101
    :cond_9
    if-nez p9, :cond_a

    .line 102
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "NetworkManager must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 105
    :cond_a
    iput-object p1, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDetEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    .line 106
    iput-object p2, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDeviceType:Ljava/lang/String;

    .line 107
    iput-object p3, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDeviceSerialNumber:Ljava/lang/String;

    .line 108
    iput-object p4, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mArtifactSources:Ljava/util/List;

    .line 109
    iput-object p5, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mArtifactProcessors:Ljava/util/List;

    .line 110
    iput-object p6, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    .line 111
    iput-object p7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    .line 112
    iput-object p8, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

    .line 113
    iput-object p9, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    .line 115
    iget-object v0, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

    instance-of v0, v0, Lcom/amazon/communication/authentication/DcpRequestSigner;

    if-eqz v0, :cond_b

    .line 117
    sget-object v0, Lamazon/communication/authentication/AccountRequestContext;->EMPTY_ACCOUNT:Lamazon/communication/authentication/AccountRequestContext;

    iput-object v0, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mRequestContext:Lamazon/communication/authentication/RequestContext;

    .line 121
    :goto_0
    return-void

    .line 119
    :cond_b
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mRequestContext:Lamazon/communication/authentication/RequestContext;

    goto :goto_0
.end method

.method private addExceptionMessageToMetricEvent(Ljava/lang/String;Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Exception;)V
    .locals 3
    .param p1, "metricKey"    # Ljava/lang/String;
    .param p2, "metricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 382
    invoke-virtual {p3}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    if-nez v1, :cond_0

    invoke-virtual {p3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 384
    .local v0, "causeMessage":Ljava/lang/String;
    :goto_0
    invoke-interface {p2, p1, v0}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 385
    return-void

    .line 382
    .end local v0    # "causeMessage":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p3}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private chooseArtifactProcessor(Lcom/amazon/device/crashmanager/Artifact;)Lcom/amazon/device/crashmanager/ArtifactProcessor;
    .locals 5
    .param p1, "artifact"    # Lcom/amazon/device/crashmanager/Artifact;

    .prologue
    .line 393
    iget-object v2, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mArtifactProcessors:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/crashmanager/ArtifactProcessor;

    .line 394
    .local v0, "artifactProcessor":Lcom/amazon/device/crashmanager/ArtifactProcessor;
    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/amazon/device/crashmanager/ArtifactProcessor;->canProcessTag(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 395
    return-object v0

    .line 398
    .end local v0    # "artifactProcessor":Lcom/amazon/device/crashmanager/ArtifactProcessor;
    :cond_1
    new-instance v2, Ljava/lang/IllegalStateException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "No artifact processor available for artifact. Tag:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private processArtifact(Lcom/amazon/device/crashmanager/Artifact;)[B
    .locals 2
    .param p1, "artifact"    # Lcom/amazon/device/crashmanager/Artifact;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 388
    invoke-direct {p0, p1}, Lcom/amazon/device/crashmanager/ArtifactUploader;->chooseArtifactProcessor(Lcom/amazon/device/crashmanager/Artifact;)Lcom/amazon/device/crashmanager/ArtifactProcessor;

    move-result-object v0

    .line 389
    .local v0, "artifactProcessor":Lcom/amazon/device/crashmanager/ArtifactProcessor;
    invoke-interface {v0, p1}, Lcom/amazon/device/crashmanager/ArtifactProcessor;->processArtifact(Lcom/amazon/device/crashmanager/Artifact;)[B

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method protected uploadArtifact(Lamazon/communication/srr/SrrManager;Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/device/crashmanager/Artifact;Ljava/lang/String;)Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    .locals 14
    .param p1, "srrManager"    # Lamazon/communication/srr/SrrManager;
    .param p2, "uploadMetricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p3, "artifact"    # Lcom/amazon/device/crashmanager/Artifact;
    .param p4, "uploadTag"    # Ljava/lang/String;

    .prologue
    .line 233
    :try_start_0
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadArtifact"

    const-string/jumbo v9, "About to upload artifact"

    const/16 v10, 0x8

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "Tag"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "Creation time UTC"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCreationTimeUTCMillis()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x4

    const-string/jumbo v12, "DeviceType"

    aput-object v12, v10, v11

    const/4 v11, 0x5

    iget-object v12, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDeviceType:Ljava/lang/String;

    aput-object v12, v10, v11

    const/4 v11, 0x6

    const-string/jumbo v12, "DeviceSerialNumber"

    aput-object v12, v10, v11

    const/4 v11, 0x7

    iget-object v12, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDeviceSerialNumber:Ljava/lang/String;

    aput-object v12, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 241
    const-string/jumbo v7, "uploadAttempt"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 245
    const-string/jumbo v7, "%s-%d"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCreationTimeUTCMillis()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 249
    .local v5, "key":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    iget-object v8, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDeviceType:Ljava/lang/String;

    iget-object v9, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDeviceSerialNumber:Ljava/lang/String;

    invoke-virtual {v7, v5, v8, v9}, Lcom/amazon/device/utils/DetUtil;->createDefaultHttpPost(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/methods/HttpPost;

    move-result-object v6

    .line 253
    .local v6, "postRequest":Lorg/apache/http/client/methods/HttpPost;
    const-string/jumbo v7, "X-Content-Type"

    const-string/jumbo v8, "CrashReport"

    invoke-virtual {v6, v7, v8}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    if-eqz p4, :cond_0

    invoke-virtual/range {p4 .. p4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_0

    .line 257
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    const-string/jumbo v9, "X-Upload-Tag"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object p4, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 258
    const-string/jumbo v7, "X-Upload-Tag"

    move-object/from16 v0, p4

    invoke-virtual {v6, v7, v0}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 262
    :cond_0
    move-object/from16 v0, p3

    invoke-direct {p0, v0}, Lcom/amazon/device/crashmanager/ArtifactUploader;->processArtifact(Lcom/amazon/device/crashmanager/Artifact;)[B

    move-result-object v2

    .line 264
    .local v2, "crashUploadMessage":[B
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCrashDescriptor()Ljava/lang/String;

    move-result-object v1

    .line 266
    .local v1, "crashDescriptor":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 268
    const-string/jumbo v7, "crashDescriptor"

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCrashDescriptor()Ljava/lang/String;

    move-result-object v8

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->addString(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v7, v1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->contains(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 275
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v7, v1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->shouldDedupe(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 277
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v7, v1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->push(Ljava/lang/String;)V

    .line 279
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "Duplicate CrashDescriptor found: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 280
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_0
    .catch Lamazon/communication/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lamazon/communication/RequestFailedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lamazon/communication/MissingCredentialsException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    .end local v1    # "crashDescriptor":Ljava/lang/String;
    .end local v2    # "crashUploadMessage":[B
    .end local v5    # "key":Ljava/lang/String;
    .end local v6    # "postRequest":Lorg/apache/http/client/methods/HttpPost;
    :goto_0
    return-object v7

    .line 283
    .restart local v1    # "crashDescriptor":Ljava/lang/String;
    .restart local v2    # "crashUploadMessage":[B
    .restart local v5    # "key":Ljava/lang/String;
    .restart local v6    # "postRequest":Lorg/apache/http/client/methods/HttpPost;
    :cond_1
    :try_start_1
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v7, v1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->prune(Ljava/lang/String;)Ljava/lang/Integer;

    .line 289
    :cond_2
    new-instance v7, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-direct {v7, v2}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    invoke-virtual {v6, v7}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 292
    const-string/jumbo v7, "uploadCrashSize"

    array-length v8, v2

    int-to-double v8, v8

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 293
    const/4 v2, 0x0

    .line 296
    const-string/jumbo v7, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v7}, Lcom/amazon/client/metrics/MetricEvent;->startTimer(Ljava/lang/String;)V

    .line 299
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    iget-object v8, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mDetEndpointIdentity:Lamazon/communication/identity/EndpointIdentity;

    iget-object v9, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mRequestContext:Lamazon/communication/authentication/RequestContext;

    invoke-virtual {v7, v6, p1, v8, v9}, Lcom/amazon/device/utils/DetUtil;->postFileToDet(Lorg/apache/http/client/methods/HttpPost;Lamazon/communication/srr/SrrManager;Lamazon/communication/identity/EndpointIdentity;Lamazon/communication/authentication/RequestContext;)Lcom/amazon/device/utils/DetUtil$DetResponse;

    move-result-object v3

    .line 302
    .local v3, "detResponse":Lcom/amazon/device/utils/DetUtil$DetResponse;
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$1;->$SwitchMap$com$amazon$device$utils$DetUtil$DetResponse:[I

    invoke-virtual {v3}, Lcom/amazon/device/utils/DetUtil$DetResponse;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 327
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntries"

    const-string/jumbo v9, "Unknown det response!"

    const/4 v10, 0x6

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "DetReponse"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    aput-object v3, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "Tag"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x4

    const-string/jumbo v12, "Creation time UTC"

    aput-object v12, v10, v11

    const/4 v11, 0x5

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCreationTimeUTCMillis()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 331
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_1
    .catch Lamazon/communication/TimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lamazon/communication/RequestFailedException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lamazon/communication/MissingCredentialsException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto :goto_0

    .line 305
    :pswitch_0
    :try_start_2
    iget-object v7, p0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v7, v1}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->push(Ljava/lang/String;)V

    .line 306
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SUCCESS:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_2
    .catch Lamazon/communication/TimeoutException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lamazon/communication/RequestFailedException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lamazon/communication/MissingCredentialsException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 308
    :pswitch_1
    :try_start_3
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntries"

    const-string/jumbo v9, "Client error on upload of artifact."

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "Tag"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "Creation time UTC"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCreationTimeUTCMillis()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 313
    const-string/jumbo v7, "uploadFailed"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 315
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_3
    .catch Lamazon/communication/TimeoutException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Lamazon/communication/RequestFailedException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Lamazon/communication/MissingCredentialsException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_4
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 317
    :pswitch_2
    :try_start_4
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntries"

    const-string/jumbo v9, "Server error on upload of artifact."

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string/jumbo v12, "Tag"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    const-string/jumbo v12, "Creation time UTC"

    aput-object v12, v10, v11

    const/4 v11, 0x3

    invoke-virtual/range {p3 .. p3}, Lcom/amazon/device/crashmanager/Artifact;->getCreationTimeUTCMillis()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 322
    const-string/jumbo v7, "uploadFailed"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 325
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_4
    .catch Lamazon/communication/TimeoutException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Lamazon/communication/RequestFailedException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Lamazon/communication/MissingCredentialsException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 334
    .end local v1    # "crashDescriptor":Ljava/lang/String;
    .end local v2    # "crashUploadMessage":[B
    .end local v3    # "detResponse":Lcom/amazon/device/utils/DetUtil$DetResponse;
    .end local v5    # "key":Ljava/lang/String;
    .end local v6    # "postRequest":Lorg/apache/http/client/methods/HttpPost;
    :catch_0
    move-exception v4

    .line 335
    .local v4, "e":Lamazon/communication/TimeoutException;
    :try_start_5
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    const-string/jumbo v9, "TimeoutException while uploading crashes."

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v4, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 336
    const-string/jumbo v7, "uploadTimeoutException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 337
    const-string/jumbo v7, "uploadTimeoutExceptionMessage"

    move-object/from16 v0, p2

    invoke-direct {p0, v7, v0, v4}, Lcom/amazon/device/crashmanager/ArtifactUploader;->addExceptionMessageToMetricEvent(Ljava/lang/String;Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Exception;)V

    .line 341
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 342
    .end local v4    # "e":Lamazon/communication/TimeoutException;
    :catch_1
    move-exception v4

    .line 343
    .local v4, "e":Lamazon/communication/RequestFailedException;
    :try_start_6
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    const-string/jumbo v9, "RequestFailedException while uploading crashes."

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-virtual {v4}, Lamazon/communication/RequestFailedException;->getCause()Ljava/lang/Throwable;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 344
    const-string/jumbo v7, "uploadRequestFailedException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 345
    const-string/jumbo v7, "uploadRequestFailedExceptionMessage"

    move-object/from16 v0, p2

    invoke-direct {p0, v7, v0, v4}, Lcom/amazon/device/crashmanager/ArtifactUploader;->addExceptionMessageToMetricEvent(Ljava/lang/String;Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Exception;)V

    .line 349
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 350
    .end local v4    # "e":Lamazon/communication/RequestFailedException;
    :catch_2
    move-exception v4

    .line 351
    .local v4, "e":Lamazon/communication/MissingCredentialsException;
    :try_start_7
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    const-string/jumbo v9, "No Amazon account present, unable to upload crashes"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v4, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 352
    const-string/jumbo v7, "uploadMissingCredentialsException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 353
    const-string/jumbo v7, "uploadMissingCredentialsMessage"

    move-object/from16 v0, p2

    invoke-direct {p0, v7, v0, v4}, Lcom/amazon/device/crashmanager/ArtifactUploader;->addExceptionMessageToMetricEvent(Ljava/lang/String;Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Exception;)V

    .line 357
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 358
    .end local v4    # "e":Lamazon/communication/MissingCredentialsException;
    :catch_3
    move-exception v4

    .line 359
    .local v4, "e":Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException;
    :try_start_8
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    invoke-virtual {v4}, Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException;->getMessage()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v4, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 360
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 362
    .end local v4    # "e":Lcom/amazon/device/crashmanager/exception/DuplicateCrashDescriptorException;
    :catch_4
    move-exception v4

    .line 363
    .local v4, "e":Ljava/lang/Exception;
    :try_start_9
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "uploadCrashEntry"

    const-string/jumbo v9, "Exception while uploading crashes"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v4, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 366
    const-string/jumbo v7, "uploadFailed"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 367
    const-string/jumbo v7, "uploadUnknowException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    move-object/from16 v0, p2

    invoke-interface {v0, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->addCounter(Ljava/lang/String;D)V

    .line 368
    const-string/jumbo v7, "uploadUnknownExceptionMessage"

    move-object/from16 v0, p2

    invoke-direct {p0, v7, v0, v4}, Lcom/amazon/device/crashmanager/ArtifactUploader;->addExceptionMessageToMetricEvent(Ljava/lang/String;Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/Exception;)V

    .line 371
    sget-object v7, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->SKIP:Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 374
    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    goto/16 :goto_0

    .end local v4    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v7

    const-string/jumbo v8, "uploadTime"

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/amazon/client/metrics/MetricEvent;->stopTimer(Ljava/lang/String;)V

    throw v7

    .line 302
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public uploadArtifacts(Lcom/amazon/client/metrics/MetricEvent;)I
    .locals 1
    .param p1, "uploadMetricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    .line 131
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/device/crashmanager/ArtifactUploader;->uploadArtifacts(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public uploadArtifacts(Lcom/amazon/client/metrics/MetricEvent;Ljava/lang/String;)I
    .locals 17
    .param p1, "uploadMetricEvent"    # Lcom/amazon/client/metrics/MetricEvent;
    .param p2, "uploadTag"    # Ljava/lang/String;

    .prologue
    .line 144
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    invoke-virtual {v12}, Lcom/amazon/device/utils/NetworkManager;->isWifiConnected()Z

    move-result v12

    if-nez v12, :cond_0

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mNetworkManager:Lcom/amazon/device/utils/NetworkManager;

    invoke-virtual {v12}, Lcom/amazon/device/utils/NetworkManager;->isEthernetConnected()Z

    move-result v12

    if-nez v12, :cond_0

    .line 145
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadCrashes"

    const-string/jumbo v14, "Skipping artifact upload because there is no usable connection."

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 146
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    const-string/jumbo v13, "Device is not connected to WiFi or Ethernet."

    invoke-interface {v12, v13}, Lcom/amazon/device/utils/StatusNotifier;->broadcastUploadStatus(Ljava/lang/CharSequence;)V

    .line 147
    const/4 v11, 0x0

    .line 218
    :goto_0
    return v11

    .line 150
    :cond_0
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    const-string/jumbo v13, "Uploading artifacts."

    invoke-interface {v12, v13}, Lcom/amazon/device/utils/StatusNotifier;->broadcastUploadStatus(Ljava/lang/CharSequence;)V

    .line 152
    const/4 v11, 0x0

    .line 154
    .local v11, "numEntriesUploaded":I
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadCrashEntries"

    const-string/jumbo v14, "Uploading artifacts."

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 157
    const-string/jumbo v12, ""

    const/4 v13, 0x0

    invoke-static {v12, v13}, Landroid/net/http/AndroidHttpClient;->newInstance(Ljava/lang/String;Landroid/content/Context;)Landroid/net/http/AndroidHttpClient;

    move-result-object v6

    .line 159
    .local v6, "httpClient":Landroid/net/http/AndroidHttpClient;
    :try_start_0
    new-instance v7, Lamazon/communication/srr/HttpClientSrrManager;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mRequestSigner:Lcom/amazon/communication/authentication/RequestSigner;

    invoke-direct {v7, v6, v12}, Lamazon/communication/srr/HttpClientSrrManager;-><init>(Lorg/apache/http/client/HttpClient;Lamazon/communication/authentication/RequestSigner;)V

    .line 162
    .local v7, "httpSrrManager":Lamazon/communication/srr/HttpClientSrrManager;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mArtifactSources:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-eqz v12, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/device/crashmanager/ArtifactSource;

    .line 163
    .local v3, "artifactSource":Lcom/amazon/device/crashmanager/ArtifactSource;
    :goto_1
    move-object/from16 v0, p1

    invoke-interface {v3, v0}, Lcom/amazon/device/crashmanager/ArtifactSource;->getNextArtifact(Lcom/amazon/client/metrics/MetricEvent;)Lcom/amazon/device/crashmanager/Artifact;

    move-result-object v10

    .local v10, "nextArtifact":Lcom/amazon/device/crashmanager/Artifact;
    if-eqz v10, :cond_1

    .line 164
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v7, v1, v10, v2}, Lcom/amazon/device/crashmanager/ArtifactUploader;->uploadArtifact(Lamazon/communication/srr/SrrManager;Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/device/crashmanager/Artifact;Ljava/lang/String;)Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    .line 169
    .local v4, "artifactUploadStatus":Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    :try_start_1
    invoke-virtual {v10}, Lcom/amazon/device/crashmanager/Artifact;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 177
    :goto_2
    :try_start_2
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader$1;->$SwitchMap$com$amazon$device$crashmanager$ArtifactUploader$ArtifactUploadStatus:[I

    invoke-virtual {v4}, Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;->ordinal()I

    move-result v13

    aget v12, v12, v13

    packed-switch v12, :pswitch_data_0

    goto :goto_1

    .line 179
    :pswitch_0
    add-int/lit8 v11, v11, 0x1

    .line 180
    invoke-interface {v3}, Lcom/amazon/device/crashmanager/ArtifactSource;->saveCurrentIndex()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 199
    .end local v3    # "artifactSource":Lcom/amazon/device/crashmanager/ArtifactSource;
    .end local v4    # "artifactUploadStatus":Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    .end local v7    # "httpSrrManager":Lamazon/communication/srr/HttpClientSrrManager;
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v10    # "nextArtifact":Lcom/amazon/device/crashmanager/Artifact;
    :catch_0
    move-exception v5

    .line 200
    .local v5, "e":Ljava/lang/Exception;
    :try_start_3
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadArtifacts"

    const-string/jumbo v14, "Exception thrown while uploading crash entries"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object v5, v15, v16

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 201
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "Exception while uploading artifacts:\n "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v5}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v12, v13}, Lcom/amazon/device/utils/StatusNotifier;->broadcastUploadStatus(Ljava/lang/CharSequence;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 202
    const/4 v11, 0x0

    .line 208
    .end local v11    # "numEntriesUploaded":I
    invoke-virtual {v6}, Landroid/net/http/AndroidHttpClient;->close()V

    .line 212
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v12}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->saveToSharedPreferences()V

    goto/16 :goto_0

    .line 170
    .end local v5    # "e":Ljava/lang/Exception;
    .restart local v3    # "artifactSource":Lcom/amazon/device/crashmanager/ArtifactSource;
    .restart local v4    # "artifactUploadStatus":Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    .restart local v7    # "httpSrrManager":Lamazon/communication/srr/HttpClientSrrManager;
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v10    # "nextArtifact":Lcom/amazon/device/crashmanager/Artifact;
    .restart local v11    # "numEntriesUploaded":I
    :catch_1
    move-exception v9

    .line 171
    .local v9, "ioe":Ljava/io/IOException;
    :try_start_4
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadCrashEntries"

    const-string/jumbo v14, "Failed to close artifact."

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object v9, v15, v16

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_2

    .line 208
    .end local v3    # "artifactSource":Lcom/amazon/device/crashmanager/ArtifactSource;
    .end local v4    # "artifactUploadStatus":Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    .end local v7    # "httpSrrManager":Lamazon/communication/srr/HttpClientSrrManager;
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "ioe":Ljava/io/IOException;
    .end local v10    # "nextArtifact":Lcom/amazon/device/crashmanager/Artifact;
    :catchall_0
    move-exception v12

    invoke-virtual {v6}, Landroid/net/http/AndroidHttpClient;->close()V

    .line 212
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v13}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->saveToSharedPreferences()V

    throw v12

    .line 183
    .restart local v3    # "artifactSource":Lcom/amazon/device/crashmanager/ArtifactSource;
    .restart local v4    # "artifactUploadStatus":Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    .restart local v7    # "httpSrrManager":Lamazon/communication/srr/HttpClientSrrManager;
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v10    # "nextArtifact":Lcom/amazon/device/crashmanager/Artifact;
    :pswitch_1
    :try_start_5
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadArtifacts"

    const-string/jumbo v14, "Skipped an artifact."

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 186
    invoke-interface {v3}, Lcom/amazon/device/crashmanager/ArtifactSource;->saveCurrentIndex()V

    goto/16 :goto_1

    .line 190
    :pswitch_2
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadArtifacts"

    const-string/jumbo v14, "Transient failure while uploading artifacts. Will retry later."

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 208
    invoke-virtual {v6}, Landroid/net/http/AndroidHttpClient;->close()V

    .line 212
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v12}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->saveToSharedPreferences()V

    goto/16 :goto_0

    .line 208
    .end local v3    # "artifactSource":Lcom/amazon/device/crashmanager/ArtifactSource;
    .end local v4    # "artifactUploadStatus":Lcom/amazon/device/crashmanager/ArtifactUploader$ArtifactUploadStatus;
    .end local v10    # "nextArtifact":Lcom/amazon/device/crashmanager/Artifact;
    :cond_2
    invoke-virtual {v6}, Landroid/net/http/AndroidHttpClient;->close()V

    .line 212
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mCrashDescriptorStorageUtil:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v12}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->saveToSharedPreferences()V

    .line 215
    sget-object v12, Lcom/amazon/device/crashmanager/ArtifactUploader;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v13, "uploadCrashEntries"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v15, "Finished uploading artifacts. Uploaded "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string/jumbo v15, " artifacts."

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-virtual {v12, v13, v14, v15}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 216
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/amazon/device/crashmanager/ArtifactUploader;->mStatusNotifier:Lcom/amazon/device/utils/StatusNotifier;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v14, "Uploaded "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string/jumbo v14, " artifacts."

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v12, v13}, Lcom/amazon/device/utils/StatusNotifier;->broadcastUploadStatus(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 177
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
