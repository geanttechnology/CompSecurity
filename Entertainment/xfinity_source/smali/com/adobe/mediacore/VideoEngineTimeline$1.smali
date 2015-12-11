.class Lcom/adobe/mediacore/VideoEngineTimeline$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/VideoEngineTimeline;->initialise()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/VideoEngineTimeline;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$1;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$1;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$000(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$1;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$000(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$1;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_contentLoader:Lcom/adobe/mediacore/ContentLoader;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$100(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/ContentLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$1;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    invoke-static {v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$000(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/ContentLoader;->loadContent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :goto_0
    return-void

    :cond_0
    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$300()Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$200()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#initialise::run"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Loading manifests for ads cannot proceed"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
