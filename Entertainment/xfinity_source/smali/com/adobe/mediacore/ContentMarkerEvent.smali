.class Lcom/adobe/mediacore/ContentMarkerEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _contentId:I

.field private final _position:J


# direct methods
.method private constructor <init>(IJ)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput p1, p0, Lcom/adobe/mediacore/ContentMarkerEvent;->_contentId:I

    iput-wide p2, p0, Lcom/adobe/mediacore/ContentMarkerEvent;->_position:J

    return-void
.end method

.method public static createContentMarkerEvent(IJ)Lcom/adobe/mediacore/ContentMarkerEvent;
    .locals 7

    new-instance v0, Lcom/adobe/mediacore/ContentMarkerEvent;

    invoke-direct {v0, p0, p1, p2}, Lcom/adobe/mediacore/ContentMarkerEvent;-><init>(IJ)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Content marker received."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "CONTENT_ID"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "CURRENT_MEDIA_TIME"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/ContentMarkerEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getContentId()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/ContentMarkerEvent;->_contentId:I

    return v0
.end method

.method public getPosition()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/ContentMarkerEvent;->_position:J

    return-wide v0
.end method
