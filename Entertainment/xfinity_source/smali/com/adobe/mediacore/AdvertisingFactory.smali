.class public abstract Lcom/adobe/mediacore/AdvertisingFactory;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/AdClientFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract createAdPolicySelector(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;
.end method

.method public createAdProvider(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/AdProvider;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract createContentResolver(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;
.end method

.method public abstract createContentResolvers(Lcom/adobe/mediacore/MediaPlayerItem;)Ljava/util/List;
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
.end method
