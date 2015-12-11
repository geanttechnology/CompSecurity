.class Lcom/adobe/mediacore/MediaPlayerClient$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/OpportunityHandledListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerClient;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/MediaPlayerClient;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerClient$1;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onOpportunityHandled(J)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$1;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$200(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerClient;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#OpportunityHandledListener::onOpportunityHandled"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Release reference for placement complete for HOLD at "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient$1;->this$0:Lcom/adobe/mediacore/MediaPlayerClient;

    # getter for: Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->access$300(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->releaseHoldReference(J)V

    return-void
.end method
