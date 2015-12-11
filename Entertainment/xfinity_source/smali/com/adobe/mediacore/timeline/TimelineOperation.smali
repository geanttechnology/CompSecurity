.class public abstract Lcom/adobe/mediacore/timeline/TimelineOperation;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/adobe/mediacore/timeline/TimelineOperation;",
        ">;"
    }
.end annotation


# instance fields
.field protected _placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;


# direct methods
.method protected constructor <init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The placement parameter must be not null. A valid operation must indicate which position on the timeline will be affected."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/adobe/mediacore/timeline/TimelineOperation;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    return-void
.end method


# virtual methods
.method public compareTo(Lcom/adobe/mediacore/timeline/TimelineOperation;)I
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/TimelineOperation;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/TimelineOperation;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    iget-object v2, p1, Lcom/adobe/mediacore/timeline/TimelineOperation;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    check-cast p1, Lcom/adobe/mediacore/timeline/TimelineOperation;

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->compareTo(Lcom/adobe/mediacore/timeline/TimelineOperation;)I

    move-result v0

    return v0
.end method

.method public getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/TimelineOperation;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    return-object v0
.end method

.method public abstract isValid()Z
.end method

.method public setPlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/TimelineOperation;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    return-void
.end method
