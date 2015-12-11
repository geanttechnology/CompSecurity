.class public Lcom/adobe/mediacore/DRMMetadataInfo;
.super Ljava/lang/Object;


# static fields
.field public static final INVALID_TIME_RANGE_START_POSITION_AVE:J = -0x3e8L

.field public static final INVALID_TIME_RANGE_START_POSITION_PSDK:J = -0x1L

.field private static final LOG_TAG:Ljava/lang/String;

.field private static _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private final _drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

.field private final _prefetchDeadline:J

.field private _timeRange:Lcom/adobe/mediacore/utils/TimeRange;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DRMMetadataInfo;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/DRMMetadataInfo;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DRMMetadataInfo;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method protected constructor <init>(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/mediacore/utils/TimeRange;J)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    iput-object p2, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_timeRange:Lcom/adobe/mediacore/utils/TimeRange;

    iput-wide p3, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_prefetchDeadline:J

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/DRMMetadataInfo;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100()Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/DRMMetadataInfo;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method public static createDRMMetadataInfo(Lcom/adobe/ave/drm/DRMManager;[BIJZ)Lcom/adobe/mediacore/DRMMetadataInfo;
    .locals 5

    const-wide/16 v2, -0x1

    const/4 v0, 0x0

    if-nez p0, :cond_0

    sget-object v1, Lcom/adobe/mediacore/DRMMetadataInfo;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/DRMMetadataInfo;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#createDRMMetadataInfo"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "DRMManager is null."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v1, Lcom/adobe/mediacore/DRMMetadataInfo$1;

    invoke-direct {v1}, Lcom/adobe/mediacore/DRMMetadataInfo$1;-><init>()V

    invoke-virtual {p0, p1, v1}, Lcom/adobe/ave/drm/DRMManager;->createMetadataFromBytes([BLcom/adobe/ave/drm/DRMOperationErrorCallback;)Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v4

    if-nez v4, :cond_1

    sget-object v1, Lcom/adobe/mediacore/DRMMetadataInfo;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/DRMMetadataInfo;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#createDRMMetadataInfo"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "DRMMetadata is null."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    const-wide/16 v0, -0x3e8

    cmp-long v0, p3, v0

    if-nez v0, :cond_2

    const-wide/16 v0, 0x0

    invoke-static {v2, v3, v0, v1}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    move-wide p3, v2

    :goto_1
    new-instance v1, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-direct {v1, v4, v0, p3, p4}, Lcom/adobe/mediacore/DRMMetadataInfo;-><init>(Lcom/adobe/ave/drm/DRMMetadata;Lcom/adobe/mediacore/utils/TimeRange;J)V

    move-object v0, v1

    goto :goto_0

    :cond_2
    const-wide/32 v0, 0x7fffffff

    invoke-static {p3, p4, v0, v1}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    goto :goto_1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-ne p1, p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    if-eqz p1, :cond_1

    instance-of v0, p1, Lcom/adobe/mediacore/DRMMetadataInfo;

    if-nez v0, :cond_2

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-virtual {p0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/drm/DRMMetadata;->getLicenseId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/ave/drm/DRMMetadata;->getLicenseId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_drmMetadata:Lcom/adobe/ave/drm/DRMMetadata;

    return-object v0
.end method

.method public getPrefetchTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_prefetchDeadline:J

    return-wide v0
.end method

.method public getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_timeRange:Lcom/adobe/mediacore/utils/TimeRange;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    invoke-virtual {p0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getDRMMetadata()Lcom/adobe/ave/drm/DRMMetadata;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/ave/drm/DRMMetadata;->getLicenseId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public setTimeRange(Lcom/adobe/mediacore/utils/TimeRange;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DRMMetadataInfo;->_timeRange:Lcom/adobe/mediacore/utils/TimeRange;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "DRMMetadataInfo { range begin: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "end: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "prefetchDeadline: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getPrefetchTimestamp()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
