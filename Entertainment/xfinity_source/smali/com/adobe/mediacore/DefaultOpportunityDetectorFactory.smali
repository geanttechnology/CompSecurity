.class Lcom/adobe/mediacore/DefaultOpportunityDetectorFactory;
.super Ljava/lang/Object;


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createOpportunityDetector(Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/metadata/AdSignalingMode;)Lcom/adobe/mediacore/PlacementOpportunityDetector;
    .locals 1

    invoke-interface {p0}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne p1, v0, :cond_1

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;-><init>(Lcom/adobe/mediacore/MediaPlayerItem;)V

    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
