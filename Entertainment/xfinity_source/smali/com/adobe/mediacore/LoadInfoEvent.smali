.class Lcom/adobe/mediacore/LoadInfoEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/qos/LoadInfo;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->LOAD_INFO:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p1, p0, Lcom/adobe/mediacore/LoadInfoEvent;->_loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    return-void
.end method

.method public static createLoadInfoEvent(Lcom/adobe/mediacore/qos/LoadInfo;)Lcom/adobe/mediacore/LoadInfoEvent;
    .locals 8

    new-instance v0, Lcom/adobe/mediacore/LoadInfoEvent;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/LoadInfoEvent;-><init>(Lcom/adobe/mediacore/qos/LoadInfo;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->LOAD_INFO_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Fragment load information is available."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "FRAGMENT_URL"

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/LoadInfo;->getFragmentUrl()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "FRAGMENT_SIZE"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/LoadInfo;->getFragmentSize()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "FRAGMENT_DOWNLOAD_DURATION"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/LoadInfo;->getDownloadDuration()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "PERIOD_INDEX"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/adobe/mediacore/qos/LoadInfo;->getPeriodIndex()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/LoadInfoEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getLoadInfo()Lcom/adobe/mediacore/qos/LoadInfo;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/LoadInfoEvent;->_loadInfo:Lcom/adobe/mediacore/qos/LoadInfo;

    return-object v0
.end method
