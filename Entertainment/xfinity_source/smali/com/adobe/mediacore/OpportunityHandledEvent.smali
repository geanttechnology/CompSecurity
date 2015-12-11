.class Lcom/adobe/mediacore/OpportunityHandledEvent;
.super Lcom/adobe/mediacore/MediaPlayerEvent;


# instance fields
.field private final _time:J


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;J)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    iput-wide p2, p0, Lcom/adobe/mediacore/OpportunityHandledEvent;->_time:J

    return-void
.end method


# virtual methods
.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/OpportunityHandledEvent;->_time:J

    return-wide v0
.end method
