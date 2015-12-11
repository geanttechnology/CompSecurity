.class Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/ContentLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ContentLoaderMonitor"
.end annotation


# instance fields
.field private _pendingContentLoading:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/adobe/mediacore/ContentLoader;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/ContentLoader;)V
    .locals 1

    iput-object p1, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->this$0:Lcom/adobe/mediacore/ContentLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    return-void
.end method

.method synthetic constructor <init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;-><init>(Lcom/adobe/mediacore/ContentLoader;)V

    return-void
.end method


# virtual methods
.method public addPendingContent(ILcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public clear()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    return-void
.end method

.method public getAd(I)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getUrl(I)Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public hasFinishedLoading()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    return v0
.end method

.method public markContentResolved(I)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->_pendingContentLoading:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
