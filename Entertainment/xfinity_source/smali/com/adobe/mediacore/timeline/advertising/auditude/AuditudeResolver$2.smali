.class Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->startConsumer()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$500(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/util/LinkedList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$500(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/util/LinkedList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/LinkedList;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    # setter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    invoke-static {v1, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$602(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$600(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->getAuditudeSettings()Lcom/adobe/mediacore/metadata/AuditudeSettings;

    move-result-object v2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$600(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->getPlacementOpportunities()Ljava/util/List;

    move-result-object v0

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    invoke-static {v3}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$600(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->getAvailCustomParams()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    invoke-static {v4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$600(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->getPlacementInformations()Ljava/util/List;

    move-result-object v4

    # invokes: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->issueAdResolvingRequest(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)V
    invoke-static {v1, v2, v0, v3, v4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$700(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v3}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#startConsumer"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_METADATA_INVALID:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v2, "Invalid ad metadata."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # invokes: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    invoke-static {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$800(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    goto/16 :goto_0
.end method
