.class Lcom/adobe/mediacore/VideoEngineTimeline$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/VideoEngineTimeline;
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

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline$2;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onComplete()V
    .locals 6

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$2;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$000(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline$2;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # getter for: Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;
    invoke-static {v4}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$500(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/ContentCache;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lcom/adobe/mediacore/ContentCache;->getHandle(Ljava/lang/String;)Lcom/adobe/mediacore/AdHandle;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$2;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # invokes: Lcom/adobe/mediacore/VideoEngineTimeline;->endAdBreakPlacement()V
    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$600(Lcom/adobe/mediacore/VideoEngineTimeline;)V

    :goto_1
    return-void

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline$2;->this$0:Lcom/adobe/mediacore/VideoEngineTimeline;

    # invokes: Lcom/adobe/mediacore/VideoEngineTimeline;->placeAdBreak(Ljava/util/List;Ljava/util/List;)V
    invoke-static {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->access$700(Lcom/adobe/mediacore/VideoEngineTimeline;Ljava/util/List;Ljava/util/List;)V

    goto :goto_1
.end method
