.class Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdProviderListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerClient;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerClient;)V
    .locals 2

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;
    invoke-static {p1}, Lcom/adobe/mediacore/MediaPlayerClient;->access$000(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/TimelineOperationQueue;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The TimelineOperationQueue must be not null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method


# virtual methods
.method public onComplete(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/timeline/advertising/AdProvider;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->unregisterPlacement()V

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/TimelineOperation;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v2}, Lcom/adobe/mediacore/MediaPlayerClient;->access$200(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerClient;->access$100()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#ContentResolver.OnCompleteListener::onComplete"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Adding reference for timelineOperation for HOLD at "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    invoke-static {v2}, Lcom/adobe/mediacore/MediaPlayerClient;->access$300(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->addHoldReference(J)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$000(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/TimelineOperationQueue;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/adobe/mediacore/TimelineOperationQueue;->addAllToQueue(Ljava/util/List;)V

    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$500(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$500(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v2}, Lcom/adobe/mediacore/MediaPlayerClient;->access$200(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerClient;->access$100()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#ContentResolver.OnCompleteListener::onComplete"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Release reference for timelineOperation for HOLD at "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    invoke-static {v2}, Lcom/adobe/mediacore/MediaPlayerClient;->access$300(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->releaseHoldReference(J)V

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerClient;->access$502(Lcom/adobe/mediacore/MediaPlayerClient;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # invokes: Lcom/adobe/mediacore/MediaPlayerClient;->processQueuedOpportunities()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$600(Lcom/adobe/mediacore/MediaPlayerClient;)V

    return-void

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->doneInitialResolving()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # invokes: Lcom/adobe/mediacore/MediaPlayerClient;->notifyAdResolvingCompletion()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$400(Lcom/adobe/mediacore/MediaPlayerClient;)V

    goto :goto_1
.end method

.method public onError(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->unregisterPlacement()V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Ad resolving operation has failed."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerClient;->access$500(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerClient;->access$300(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    invoke-static {v2}, Lcom/adobe/mediacore/MediaPlayerClient;->access$500(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->releaseHoldReference(J)V

    :cond_0
    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    const/4 v2, 0x0

    # setter for: Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerClient;->access$502(Lcom/adobe/mediacore/MediaPlayerClient;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # invokes: Lcom/adobe/mediacore/MediaPlayerClient;->processQueuedOpportunities()V
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerClient;->access$600(Lcom/adobe/mediacore/MediaPlayerClient;)V

    invoke-virtual {v0, p2}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setInnerNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    invoke-virtual {p0, p1, v0}, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->onWarning(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # invokes: Lcom/adobe/mediacore/MediaPlayerClient;->notifyAdResolvingCompletion()V
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$400(Lcom/adobe/mediacore/MediaPlayerClient;)V

    return-void
.end method

.method public onWarning(Lcom/adobe/mediacore/timeline/advertising/AdProvider;Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$700(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$700(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {p2}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    return-void
.end method
