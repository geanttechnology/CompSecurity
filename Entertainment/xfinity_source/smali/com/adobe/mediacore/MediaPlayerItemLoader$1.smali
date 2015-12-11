.class Lcom/adobe/mediacore/MediaPlayerItemLoader$1;
.super Lcom/adobe/ave/VideoEngineListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/MediaPlayerItemLoader;->createEngineListener()Lcom/adobe/ave/VideoEngineListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/MediaPlayerItemLoader;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    invoke-direct {p0}, Lcom/adobe/ave/VideoEngineListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onDRMMetadata(Lcom/adobe/ave/VideoEngine;[BIJ)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$000(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$200(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onDRMMetadata"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "DRMMetadata event  received at time ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    const/4 v1, 0x1

    # setter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_isProtected:Z
    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$302(Lcom/adobe/mediacore/MediaPlayerItemLoader;Z)Z

    :cond_0
    return-void
.end method

.method public onError(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$000(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$200(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onError"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[Error] >> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public onTimeline(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/UpdateType;)V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$000(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$200(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Timeline event  received. Update type: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/adobe/mediacore/PSDKConfig;->getAdTagsWithDefault()[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v5

    new-instance v4, Lcom/adobe/mediacore/DRMMetadataCache;

    invoke-direct {v4}, Lcom/adobe/mediacore/DRMMetadataCache;-><init>()V

    iget-object v6, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineItem;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$500(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_mediaResource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v2}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$600(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineItem;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaResource;ILcom/adobe/mediacore/DRMMetadataCache;Ljava/util/List;)V

    # setter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v6, v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$402(Lcom/adobe/mediacore/MediaPlayerItemLoader;Lcom/adobe/mediacore/VideoEngineItem;)Lcom/adobe/mediacore/VideoEngineItem;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$400(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$000(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/ave/VideoEngine;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->update(Lcom/adobe/ave/VideoEngine;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$400(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_isProtected:Z
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$300(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineItem;->setIsProtected(Z)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_listener:Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$700(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngineItem:Lcom/adobe/mediacore/VideoEngineItem;
    invoke-static {v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$400(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/VideoEngineItem;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/MediaPlayerItemLoader$LoaderListener;->onLoadComplete(Lcom/adobe/mediacore/MediaPlayerItem;)V

    :cond_0
    return-void
.end method

.method public onWarning(Lcom/adobe/ave/VideoEngine;Lcom/adobe/ave/MediaErrorCode;Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_videoEngine:Lcom/adobe/ave/VideoEngine;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$000(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/ave/VideoEngine;

    move-result-object v0

    if-ne v0, p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerItemLoader$1;->this$0:Lcom/adobe/mediacore/MediaPlayerItemLoader;

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$200(Lcom/adobe/mediacore/MediaPlayerItemLoader;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/MediaPlayerItemLoader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerItemLoader;->access$100()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onWarning"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[Warning] >> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method
