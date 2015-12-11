.class public Lcom/xfinity/playnow/config/MrQaConfiguration;
.super Lcom/xfinity/playnow/config/PlayNowConfiguration;
.source "MrQaConfiguration.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/xfinity/playnow/config/PlayNowConfiguration;-><init>()V

    .line 9
    const-string v0, "https://xip-mr.qa.cim.comcast.net/xip/"

    iput-object v0, p0, Lcom/xfinity/playnow/config/MrQaConfiguration;->XIP_URI:Ljava/lang/String;

    .line 11
    const-string v0, "http://mr.qa.xfinitytv.comcast.net/api/hypermedia/consumables/"

    iput-object v0, p0, Lcom/xfinity/playnow/config/MrQaConfiguration;->CONSUMABLES_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

    .line 12
    const-string v0, "http://mr.qa.xfinitytv.comcast.net/xtvapi/tve/android/home/"

    iput-object v0, p0, Lcom/xfinity/playnow/config/MrQaConfiguration;->TVE_HYPERMEDIA_SERVICES_URL:Ljava/lang/String;

    .line 14
    const-string v0, "http://mr.qa.xfinitytv.comcast.net/api/xfinity/ipad/home/cover?filter&type=json"

    invoke-static {v0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playnow/config/MrQaConfiguration;->EDITORIAL_COVERS_URI:Ljava/net/URI;

    .line 15
    const-string v0, "http://mr.qa.xfinitytv.comcast.net/api/xfinity/ipad/home/videos?filter&type=json"

    invoke-static {v0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playnow/config/MrQaConfiguration;->EDITORIAL_VIDEO_URI:Ljava/net/URI;

    .line 16
    return-void
.end method
