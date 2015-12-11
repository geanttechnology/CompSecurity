.class Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdManifestLoadFailedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/ContentLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ContentLoadFailedListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/ContentLoader;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/ContentLoader;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;-><init>(Lcom/adobe/mediacore/ContentLoader;)V

    return-void
.end method


# virtual methods
.method public onError(I)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->getAd(I)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdError(Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    :cond_0
    iget-object v1, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    invoke-static {v1}, Lcom/adobe/mediacore/ContentLoader;->access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->markContentResolved(I)V

    iget-object v1, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v1}, Lcom/adobe/mediacore/ContentLoader;->access$500(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v2, "fail to load ad manifest"

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "AD"

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$500(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    invoke-static {v1}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->hasFinishedLoading()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$500(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_2
    return-void
.end method
