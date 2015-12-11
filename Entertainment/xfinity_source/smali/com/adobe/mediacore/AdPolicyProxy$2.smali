.class Lcom/adobe/mediacore/AdPolicyProxy$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdBreakPlacementFailedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/AdPolicyProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/AdPolicyProxy;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/AdPolicyProxy;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailed(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$100(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/AdPolicyProxy;->access$000()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdPolicyProxy::AdBreakPlacementFailedListener"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad break placement failed"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$200(Lcom/adobe/mediacore/AdPolicyProxy;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$200(Lcom/adobe/mediacore/AdPolicyProxy;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$200(Lcom/adobe/mediacore/AdPolicyProxy;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;
    invoke-static {v1}, Lcom/adobe/mediacore/AdPolicyProxy;->access$200(Lcom/adobe/mediacore/AdPolicyProxy;)Ljava/util/List;

    move-result-object v1

    # invokes: Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->access$300(Lcom/adobe/mediacore/AdPolicyProxy;Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$400(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$400(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/adobe/mediacore/SeekEvent;->createSeekAdjustCompleted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # invokes: Lcom/adobe/mediacore/AdPolicyProxy;->removeAdBreakPlacementListeners()V
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$600(Lcom/adobe/mediacore/AdPolicyProxy;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v2

    # -= operator for: Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J
    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/AdPolicyProxy;->access$522(Lcom/adobe/mediacore/AdPolicyProxy;J)J

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$100(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/AdPolicyProxy;->access$000()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "AdPolicyProxy::onAdBreakComplete"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Place next Ad Break Placement that\'s skipped"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;
    invoke-static {v0}, Lcom/adobe/mediacore/AdPolicyProxy;->access$200(Lcom/adobe/mediacore/AdPolicyProxy;)Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy$2;->this$0:Lcom/adobe/mediacore/AdPolicyProxy;

    # getter for: Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;
    invoke-static {v1}, Lcom/adobe/mediacore/AdPolicyProxy;->access$700(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/TimelineOperationQueue;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    goto :goto_0
.end method
