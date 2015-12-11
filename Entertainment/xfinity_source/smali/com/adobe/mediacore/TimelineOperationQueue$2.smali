.class Lcom/adobe/mediacore/TimelineOperationQueue$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;


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

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineOperationQueue$2;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V
    .locals 6

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLocalTime()J

    move-result-wide v0

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setLocalTime(J)V

    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$2;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$102(Lcom/adobe/mediacore/TimelineOperationQueue;Lcom/adobe/mediacore/timeline/TimelineOperation;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$2;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # invokes: Lcom/adobe/mediacore/TimelineOperationQueue;->process()V
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$200(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$2;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$000(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->convertToLocalTime(J)J

    move-result-wide v0

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setLocalTime(J)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$2;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$300(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/OpportunityHandledEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    invoke-direct {v1, v2, v4, v5}, Lcom/adobe/mediacore/OpportunityHandledEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;J)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method
