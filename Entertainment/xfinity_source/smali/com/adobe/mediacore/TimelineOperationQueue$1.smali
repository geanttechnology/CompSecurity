.class Lcom/adobe/mediacore/TimelineOperationQueue$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/TimelineOperationQueue;->initialise()V
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

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$000(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$100(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$000(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # getter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-static {v1}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$100(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->execute(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    const/4 v1, 0x0

    # setter for: Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-static {v0, v1}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$102(Lcom/adobe/mediacore/TimelineOperationQueue;Lcom/adobe/mediacore/timeline/TimelineOperation;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue$1;->this$0:Lcom/adobe/mediacore/TimelineOperationQueue;

    # invokes: Lcom/adobe/mediacore/TimelineOperationQueue;->process()V
    invoke-static {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->access$200(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    goto :goto_0
.end method
