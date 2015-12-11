.class Lcom/adobe/mediacore/OperationFailedEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# direct methods
.method private constructor <init>()V
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPERATION_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    return-void
.end method

.method public static createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/OperationFailedEvent;

    invoke-direct {v0}, Lcom/adobe/mediacore/OperationFailedEvent;-><init>()V

    invoke-virtual {v0, p0}, Lcom/adobe/mediacore/OperationFailedEvent;->setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    return-object v0
.end method
