.class Lcom/adobe/mediacore/ErrorEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# direct methods
.method private constructor <init>()V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->VIDEO_ERROR:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    return-void
.end method

.method public static createVideoErrorEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)Lcom/adobe/mediacore/ErrorEvent;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/ErrorEvent;

    invoke-direct {v0}, Lcom/adobe/mediacore/ErrorEvent;-><init>()V

    invoke-virtual {v0, p0}, Lcom/adobe/mediacore/ErrorEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method
