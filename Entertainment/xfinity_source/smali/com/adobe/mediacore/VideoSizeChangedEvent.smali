.class Lcom/adobe/mediacore/VideoSizeChangedEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _height:I

.field private final _width:I


# direct methods
.method private constructor <init>(II)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput p1, p0, Lcom/adobe/mediacore/VideoSizeChangedEvent;->_height:I

    iput p2, p0, Lcom/adobe/mediacore/VideoSizeChangedEvent;->_width:I

    return-void
.end method

.method public static createChangedEvent(II)Lcom/adobe/mediacore/VideoSizeChangedEvent;
    .locals 6

    new-instance v0, Lcom/adobe/mediacore/VideoSizeChangedEvent;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mediacore/VideoSizeChangedEvent;-><init>(II)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->VIDEO_SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "The size of the video has changed."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "HEIGHT"

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

    const-string v3, "WIDTH"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoSizeChangedEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getHeight()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoSizeChangedEvent;->_height:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/VideoSizeChangedEvent;->_width:I

    return v0
.end method
