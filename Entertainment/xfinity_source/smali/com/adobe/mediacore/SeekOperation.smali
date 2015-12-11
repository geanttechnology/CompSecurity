.class final Lcom/adobe/mediacore/SeekOperation;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/PlayerOperation;


# instance fields
.field private final _desiredTimeMappingPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

.field private _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;


# direct methods
.method protected constructor <init>(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/SeekOperation;->_desiredTimeMappingPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/SeekOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Player operation does not a have a VideoEngineAdapter set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/SeekOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/SeekOperation;->_desiredTimeMappingPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V

    return-void
.end method

.method public setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/SeekOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    return-void
.end method
