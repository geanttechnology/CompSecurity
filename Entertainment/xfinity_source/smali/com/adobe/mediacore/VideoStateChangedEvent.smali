.class Lcom/adobe/mediacore/VideoStateChangedEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _playerState:Lcom/adobe/mediacore/MediaPlayerState;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerState;)V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_STATE_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p1, p0, Lcom/adobe/mediacore/VideoStateChangedEvent;->_playerState:Lcom/adobe/mediacore/MediaPlayerState;

    return-void
.end method

.method public static createChangedEvent(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)Lcom/adobe/mediacore/VideoStateChangedEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/VideoStateChangedEvent;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/VideoStateChangedEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerState;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Info;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYER_STATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v3, "Player state has changed."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "STATE"

    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaPlayerState;->name()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v1, p1}, Lcom/adobe/mediacore/MediaPlayerNotification$Info;->setInnerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoStateChangedEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getPlayerState()Lcom/adobe/mediacore/MediaPlayerState;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoStateChangedEvent;->_playerState:Lcom/adobe/mediacore/MediaPlayerState;

    return-object v0
.end method
