.class Lcom/adobe/mediacore/BlackoutEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    return-void
.end method

.method public static createBlackoutEvent()Lcom/adobe/mediacore/BlackoutEvent;
    .locals 2

    new-instance v0, Lcom/adobe/mediacore/BlackoutEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->BACKGROUND_MANIFEST_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1}, Lcom/adobe/mediacore/BlackoutEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    return-object v0
.end method
