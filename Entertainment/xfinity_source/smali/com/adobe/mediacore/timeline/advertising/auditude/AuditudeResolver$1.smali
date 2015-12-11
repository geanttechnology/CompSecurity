.class Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/auditude/ads/event/AuditudePluginEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;
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

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdClickEvent(Lcom/auditude/ads/event/AdClickThroughEvent;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdClickThroughEvent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onAdPluginErrorEvent(Lcom/auditude/ads/event/AdPluginErrorEvent;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onAdPluginErrorEvent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "An error ocurred while resolving ads"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_RESOLVE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Auditude plugin failed to resolve ad."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "NATIVE_ERROR_CODE"

    invoke-virtual {p1}, Lcom/auditude/ads/event/AdPluginErrorEvent;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # invokes: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    invoke-static {v1, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$400(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # invokes: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->startConsumer()V
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$100(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V

    return-void
.end method

.method public onAdPluginEvent(Lcom/auditude/ads/event/AdPluginEvent;)V
    .locals 2

    const-string v0, "initComplete"

    invoke-virtual {p1}, Lcom/auditude/ads/event/AdPluginEvent;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # invokes: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadAdBreaks(Lcom/auditude/ads/event/AdPluginEvent;)V
    invoke-static {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$000(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/auditude/ads/event/AdPluginEvent;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # invokes: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->startConsumer()V
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$100(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V

    :cond_0
    return-void
.end method

.method public onAdProgressEvent(Lcom/auditude/ads/event/AdProgressEvent;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdProgressEvent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onLinearAdEvent(Lcom/auditude/ads/event/LinearAdEvent;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#LinearAdEvent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onNonLinearAdEvent(Lcom/auditude/ads/event/NonLinearAdEvent;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#NonLinearAdEvent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onOnPageAdEvent(Lcom/auditude/ads/event/OnPageEvent;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;->this$0:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    # getter for: Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;
    invoke-static {v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#OnPageEvent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Event: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
