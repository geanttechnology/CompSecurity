.class Lcom/adobe/mediacore/AudioTrackEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _audioTrack:Lcom/adobe/mediacore/info/AudioTrack;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/info/AudioTrack;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-object p2, p0, Lcom/adobe/mediacore/AudioTrackEvent;->_audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    return-void
.end method

.method public static createAudioTrackFailedEvent(Lcom/adobe/mediacore/info/AudioTrack;)Lcom/adobe/mediacore/AudioTrackEvent;
    .locals 5

    new-instance v0, Lcom/adobe/mediacore/AudioTrackEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AUDIO_TRACK_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0}, Lcom/adobe/mediacore/AudioTrackEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/info/AudioTrack;)V

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AUDIO_TRACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v3, "An error related to an audio track occured."

    invoke-direct {v1, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;-><init>(Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AUDIO_TRACK_NAME"

    invoke-virtual {p0}, Lcom/adobe/mediacore/info/AudioTrack;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v3, "AUDIO_TRACK_LANGUAGE"

    invoke-virtual {p0}, Lcom/adobe/mediacore/info/AudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AudioTrackEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method


# virtual methods
.method public getAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AudioTrackEvent;->_audioTrack:Lcom/adobe/mediacore/info/AudioTrack;

    return-object v0
.end method
