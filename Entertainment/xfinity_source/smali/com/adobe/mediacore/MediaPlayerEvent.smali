.class Lcom/adobe/mediacore/MediaPlayerEvent;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaPlayerEvent$Type;
    }
.end annotation


# instance fields
.field private _notification:Lcom/adobe/mediacore/MediaPlayerNotification;

.field private final _type:Lcom/adobe/mediacore/MediaPlayerEvent$Type;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerEvent;->_type:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    return-void
.end method


# virtual methods
.method public getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerEvent;->_notification:Lcom/adobe/mediacore/MediaPlayerNotification;

    return-object v0
.end method

.method public getType()Lcom/adobe/mediacore/MediaPlayerEvent$Type;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerEvent;->_type:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    return-object v0
.end method

.method public setNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerEvent;->_notification:Lcom/adobe/mediacore/MediaPlayerNotification;

    return-void
.end method
