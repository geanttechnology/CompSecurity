.class Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdManifestLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/ContentLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ContentLoadCompleteListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/ContentLoader;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/ContentLoader;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;-><init>(Lcom/adobe/mediacore/ContentLoader;)V

    return-void
.end method


# virtual methods
.method public onCompleted(IIJ)V
    .locals 3

    new-instance v0, Lcom/adobe/mediacore/AdHandle;

    invoke-direct {v0, p2, p3, p4}, Lcom/adobe/mediacore/AdHandle;-><init>(IJ)V

    iget-object v1, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    invoke-static {v1}, Lcom/adobe/mediacore/ContentLoader;->access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->getUrl(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;
    invoke-static {v2}, Lcom/adobe/mediacore/ContentLoader;->access$400(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentCache;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Lcom/adobe/mediacore/ContentCache;->addContent(Ljava/lang/String;Lcom/adobe/mediacore/AdHandle;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->markContentResolved(I)V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->hasFinishedLoading()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;->this$0:Lcom/adobe/mediacore/ContentLoader;

    # getter for: Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;
    invoke-static {v0}, Lcom/adobe/mediacore/ContentLoader;->access$500(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    return-void
.end method
