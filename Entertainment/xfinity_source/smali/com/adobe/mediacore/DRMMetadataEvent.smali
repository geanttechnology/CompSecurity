.class Lcom/adobe/mediacore/DRMMetadataEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _drmMetadataInfo:Lcom/adobe/mediacore/DRMMetadataInfo;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/DRMMetadataInfo;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->DRM_METADATA:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p1, p0, Lcom/adobe/mediacore/DRMMetadataEvent;->_drmMetadataInfo:Lcom/adobe/mediacore/DRMMetadataInfo;

    return-void
.end method

.method public static createDRMMetadataEvent(Lcom/adobe/mediacore/DRMMetadataInfo;)Lcom/adobe/mediacore/DRMMetadataEvent;
    .locals 8

    new-instance v0, Lcom/adobe/mediacore/DRMMetadataEvent;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/DRMMetadataEvent;-><init>(Lcom/adobe/mediacore/DRMMetadataInfo;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->DRM_METADATA_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "DRM metadata is available."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "PREFETCH_TIMESTAMP"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/DRMMetadataInfo;->getPrefetchTimestamp()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/DRMMetadataEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getDrmMetadataInfo()Lcom/adobe/mediacore/DRMMetadataInfo;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DRMMetadataEvent;->_drmMetadataInfo:Lcom/adobe/mediacore/DRMMetadataInfo;

    return-object v0
.end method
