.class public final Lcom/adobe/mediacore/timeline/PlacementOpportunity;
.super Ljava/lang/Object;


# instance fields
.field public final _id:Ljava/lang/String;

.field public final _metadata:Lcom/adobe/mediacore/metadata/Metadata;

.field public final _placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_id:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    iput-object p3, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_id:Ljava/lang/String;

    return-object v0
.end method

.method public getMetadata()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method

.method public getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "PlacementOpportunity { id: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", placementInformation: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
