.class public Lcom/adobe/mediacore/DefaultAdvertisingFactory;
.super Lcom/adobe/mediacore/AdvertisingFactory;


# instance fields
.field private _adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field private _context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/metadata/AdSignalingMode;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/AdvertisingFactory;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/metadata/AdSignalingMode;Landroid/content/Context;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/AdvertisingFactory;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iput-object p2, p0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;->_context:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method public createAdPolicySelector(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/DefaultAdPolicySelector;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/DefaultAdPolicySelector;-><init>(Lcom/adobe/mediacore/MediaPlayerItem;)V

    return-object v0
.end method

.method public createContentResolver(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;
    .locals 2

    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;->_context:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/adobe/mediacore/DefaultContentResolverFactory;->createContentResolver(Lcom/adobe/mediacore/MediaResource;Landroid/content/Context;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    move-result-object v0

    return-object v0
.end method

.method public createContentResolvers(Lcom/adobe/mediacore/MediaPlayerItem;)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/MediaPlayerItem;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/ContentResolver;",
            ">;"
        }
    .end annotation

    invoke-interface {p1}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;->_context:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/adobe/mediacore/DefaultContentResolverFactory;->createContentResolvers(Lcom/adobe/mediacore/MediaResource;Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public createOpportunityDetector(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/PlacementOpportunityDetector;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultAdvertisingFactory;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-static {p1, v0}, Lcom/adobe/mediacore/DefaultOpportunityDetectorFactory;->createOpportunityDetector(Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/metadata/AdSignalingMode;)Lcom/adobe/mediacore/PlacementOpportunityDetector;

    move-result-object v0

    return-object v0
.end method
