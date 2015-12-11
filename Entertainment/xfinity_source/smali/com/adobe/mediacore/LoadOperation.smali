.class final Lcom/adobe/mediacore/LoadOperation;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/PlayerOperation;


# instance fields
.field private final _contentId:I

.field private final _mediaResource:Lcom/adobe/mediacore/MediaResource;

.field private _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaResource;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/LoadOperation;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput p2, p0, Lcom/adobe/mediacore/LoadOperation;->_contentId:I

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/LoadOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Player operation does not a have a VideoEngineAdapter set"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/LoadOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/LoadOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineAdapter;->getDefaultBufferingParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->setBufferControlParameters(Lcom/adobe/mediacore/BufferControlParameters;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/LoadOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v1, p0, Lcom/adobe/mediacore/LoadOperation;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iget v2, p0, Lcom/adobe/mediacore/LoadOperation;->_contentId:I

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineAdapter;->load(Lcom/adobe/mediacore/MediaResource;I)V

    return-void
.end method

.method public setVideoEngineAdapter(Lcom/adobe/mediacore/VideoEngineAdapter;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/LoadOperation;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    return-void
.end method
