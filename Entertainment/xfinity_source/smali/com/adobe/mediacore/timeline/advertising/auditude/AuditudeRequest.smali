.class public Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
.super Ljava/lang/Object;


# instance fields
.field private _auditudeSettings:Lcom/adobe/mediacore/metadata/AuditudeSettings;

.field private _availCustomParams:Lcom/adobe/mediacore/metadata/Metadata;

.field private _placementInformations:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ">;"
        }
    .end annotation
.end field

.field private _placementOpportunities:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/PlacementOpportunity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementOpportunities:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementInformations:Ljava/util/List;

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_auditudeSettings:Lcom/adobe/mediacore/metadata/AuditudeSettings;

    iput-object p3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_availCustomParams:Lcom/adobe/mediacore/metadata/Metadata;

    invoke-direct {p0, p2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->addOpportunity(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V

    return-void
.end method

.method private addOpportunity(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementOpportunities:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementInformations:Ljava/util/List;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_0
    return-void
.end method


# virtual methods
.method public addPlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementInformations:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public getAuditudeSettings()Lcom/adobe/mediacore/metadata/AuditudeSettings;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_auditudeSettings:Lcom/adobe/mediacore/metadata/AuditudeSettings;

    return-object v0
.end method

.method public getAvailCustomParams()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_availCustomParams:Lcom/adobe/mediacore/metadata/Metadata;

    return-object v0
.end method

.method public getPlacementInformations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementInformations:Ljava/util/List;

    return-object v0
.end method

.method public getPlacementOpportunities()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/PlacementOpportunity;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->_placementOpportunities:Ljava/util/List;

    return-object v0
.end method
