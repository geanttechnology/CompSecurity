.class Lcom/adobe/mediacore/PlaybackRateEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private _rate:F


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;F)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput p2, p0, Lcom/adobe/mediacore/PlaybackRateEvent;->_rate:F

    return-void
.end method

.method public static createRatePlayingEvent(F)Lcom/adobe/mediacore/PlaybackRateEvent;
    .locals 2

    new-instance v0, Lcom/adobe/mediacore/PlaybackRateEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RATE_PLAYING:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0}, Lcom/adobe/mediacore/PlaybackRateEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;F)V

    return-object v0
.end method

.method public static createRateSelectedEvent(F)Lcom/adobe/mediacore/PlaybackRateEvent;
    .locals 2

    new-instance v0, Lcom/adobe/mediacore/PlaybackRateEvent;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->RATE_SELECTED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v0, v1, p0}, Lcom/adobe/mediacore/PlaybackRateEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;F)V

    return-object v0
.end method


# virtual methods
.method public getRate()F
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/PlaybackRateEvent;->_rate:F

    return v0
.end method
