.class public Lcom/xfinity/playnow/config/DenverStagingConfiguration;
.super Lcom/xfinity/playnow/config/PlayNowConfiguration;
.source "DenverStagingConfiguration.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/xfinity/playnow/config/PlayNowConfiguration;-><init>()V

    .line 8
    const-string v0, "https://xip-staging.cim.comcast.net/xip/"

    iput-object v0, p0, Lcom/xfinity/playnow/config/DenverStagingConfiguration;->XIP_URI:Ljava/lang/String;

    .line 10
    const-string v0, "http://denver.staging.xfinitytv.comcast.net/api/hypermedia/consumables/"

    iput-object v0, p0, Lcom/xfinity/playnow/config/DenverStagingConfiguration;->CONSUMABLES_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

    .line 11
    const-string v0, "http://denver.staging.xfinitytv.comcast.net/xtvapi/tve/android/home/"

    iput-object v0, p0, Lcom/xfinity/playnow/config/DenverStagingConfiguration;->TVE_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

    .line 13
    const-string v0, "http://xfinitytv.comcast.net/api/xfinity/ipad/home/cover?filter&type=json"

    invoke-static {v0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playnow/config/DenverStagingConfiguration;->EDITORIAL_COVERS_URI:Ljava/net/URI;

    .line 14
    const-string v0, "http://xfinitytv.comcast.net/api/xfinity/ipad/home/videos?filter&type=json"

    invoke-static {v0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playnow/config/DenverStagingConfiguration;->EDITORIAL_VIDEO_URI:Ljava/net/URI;

    .line 15
    return-void
.end method
