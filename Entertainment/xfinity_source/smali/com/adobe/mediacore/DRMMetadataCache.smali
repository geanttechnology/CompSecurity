.class final Lcom/adobe/mediacore/DRMMetadataCache;
.super Ljava/lang/Object;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private _drmMetadataInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/DRMMetadataInfo;",
            ">;"
        }
    .end annotation
.end field

.field private _internalDrmMetadataInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/DRMMetadataInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/DRMMetadataCache;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DRMMetadataCache;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/DRMMetadataCache;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/DRMMetadataCache;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;

    return-void
.end method


# virtual methods
.method declared-synchronized addDRMMetadata(Lcom/adobe/mediacore/DRMMetadataInfo;)Z
    .locals 10

    const-wide/16 v8, -0x1

    const/4 v2, 0x1

    const/4 v1, 0x0

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v3

    const/4 v0, -0x1

    if-eq v3, v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v6

    cmp-long v0, v4, v6

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    cmp-long v0, v4, v8

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    move v0, v2

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v3, v0

    :goto_1
    if-ltz v3, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v6

    cmp-long v0, v4, v6

    if-lez v0, :cond_5

    add-int/lit8 v1, v3, 0x1

    :cond_3
    if-lez v1, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    add-int/lit8 v3, v1, -0x1

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    cmp-long v3, v4, v8

    if-eqz v3, :cond_4

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v6

    sub-long/2addr v6, v4

    invoke-static {v4, v5, v6, v7}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/adobe/mediacore/DRMMetadataInfo;->setTimeRange(Lcom/adobe/mediacore/utils/TimeRange;)V

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0, v1, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v0, v2

    goto :goto_0

    :cond_5
    add-int/lit8 v0, v3, -0x1

    move v3, v0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDRMMetadataInfos()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/DRMMetadataInfo;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized reset()V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized update(Lcom/adobe/ave/Timeline;J)V
    .locals 8

    monitor-enter p0

    if-nez p1, :cond_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/DRMMetadataInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    const-wide/16 v6, -0x1

    cmp-long v3, v4, v6

    if-eqz v3, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getTimeRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v4

    cmp-long v3, v4, p2

    if-gez v3, :cond_1

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_2
    :try_start_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_internalDrmMetadataInfos:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    sget-object v0, Lcom/adobe/mediacore/DRMMetadataCache;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/DRMMetadataCache;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#update"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Removed "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " old DRMMetadataInfo."

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v2, v1}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/DRMMetadataCache;->_drmMetadataInfos:Ljava/util/List;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method
