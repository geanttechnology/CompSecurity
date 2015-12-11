.class Lcom/adobe/mediacore/TimelineOperationQueue$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdBreakPlacementFailedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/TimelineOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/TimelineOperationQueue;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/TimelineOperationQueue;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineOperationQueue$3;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailed(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$3;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$500(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#adProviderError"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Proposed ad break was refused as we fail to place any of the contained ads.["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$3;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$300(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/OpportunityHandledEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    invoke-direct {v1, v2, v4, v5}, Lcom/adobe/mediacore/OpportunityHandledEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;J)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$3;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$102(Lcom/adobe/mediacore/TimelineOperationQueue;Lcom/adobe/mediacore/timeline/TimelineOperation;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$3;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # invokes: Lcom/adobe/mediacore/TimelineOperationQueue;->process()V
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$200(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    return-void
.end method
