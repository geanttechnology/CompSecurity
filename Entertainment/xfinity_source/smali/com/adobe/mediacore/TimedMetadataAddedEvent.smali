.class Lcom/adobe/mediacore/TimedMetadataAddedEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# static fields
.field private static final DEFAULT_ID:I = 0x0

.field private static final DEFAULT_NAME:Ljava/lang/String; = ""


# instance fields
.field private final _timedMetadata:Lcom/adobe/mediacore/metadata/TimedMetadata;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V
    .locals 0

    invoke-direct {p0, p2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p1, p0, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->_timedMetadata:Lcom/adobe/mediacore/metadata/TimedMetadata;

    return-void
.end method

.method public static createAddedEvent(Lcom/adobe/mediacore/metadata/TimedMetadata;)Lcom/adobe/mediacore/TimedMetadataAddedEvent;
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, p0, v1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;-><init>(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "A new timed metadata was discovered in the manifest."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "TYPE"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "ID"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NAME"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "TIME"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method

.method public static createAddedID3Event(Lcom/adobe/mediacore/metadata/Metadata;J)Lcom/adobe/mediacore/TimedMetadataAddedEvent;
    .locals 9

    new-instance v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    sget-object v1, Lcom/adobe/mediacore/metadata/TimedMetadata$Type;->ID3:Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    const-wide/16 v4, 0x0

    const-string v6, ""

    move-wide v2, p1

    move-object v7, p0

    invoke-direct/range {v0 .. v7}, Lcom/adobe/mediacore/metadata/TimedMetadata;-><init>(Lcom/adobe/mediacore/metadata/TimedMetadata$Type;JJLjava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    new-instance v1, Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v0, v2}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;-><init>(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    new-instance v2, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v3, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v4, "A new id3 timed metadata was discovered in the transport segment."

    invoke-direct {v2, v3, v4}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v3, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v3}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v4, "TYPE"

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "ID"

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "NAME"

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "TIME"

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v1
.end method

.method public static createBackgroundAddedEvent(Lcom/adobe/mediacore/metadata/TimedMetadata;)Lcom/adobe/mediacore/TimedMetadataAddedEvent;
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMED_METADATA_ADDED_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, p0, v1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;-><init>(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "A new timed metadata was discovered in the background manifest."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "TYPE"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getType()Lcom/adobe/mediacore/metadata/TimedMetadata$Type;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "ID"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "NAME"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "TIME"

    invoke-virtual {p0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getTimedMetadata()Lcom/adobe/mediacore/metadata/TimedMetadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->_timedMetadata:Lcom/adobe/mediacore/metadata/TimedMetadata;

    return-object v0
.end method
