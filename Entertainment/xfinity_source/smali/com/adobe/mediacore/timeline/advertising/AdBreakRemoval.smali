.class public final Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;
.super Lcom/adobe/mediacore/timeline/TimelineOperation;


# instance fields
.field private final _adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V
    .locals 1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/TimelineOperation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-void
.end method


# virtual methods
.method public getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-object v0
.end method

.method public isValid()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isValid()Z

    move-result v0

    return v0
.end method
