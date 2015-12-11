.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
.super Ljava/lang/Object;
.source "CimAssetFactory.java"


# instance fields
.field private final LOG:Lorg/slf4j/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->LOG:Lorg/slf4j/Logger;

    return-void
.end method


# virtual methods
.method public create(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "channelName"    # Ljava/lang/String;
    .param p3, "eventId"    # Ljava/lang/String;
    .param p4, "scm"    # Ljava/lang/String;
    .param p5, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .prologue
    .line 44
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isEspn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;

    invoke-direct {v0, p2, p3, p4, p5}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V

    .line 49
    :goto_0
    return-object v0

    .line 48
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Error creating ESPN live event asset. Everything we know is wrong."

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 49
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public create(Ljava/lang/String;Lcom/xfinity/playerlib/downloads/TitaniumTicket;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 8
    .param p1, "assetUri"    # Ljava/lang/String;
    .param p2, "ticket"    # Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .param p3, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p4, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .prologue
    .line 26
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/downloads/TitaniumTicket;->getKey()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getPid()Ljava/lang/String;

    move-result-object v5

    .line 27
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    move-object v1, p1

    move-object v4, p4

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 6
    .param p1, "assetUri"    # Ljava/lang/String;
    .param p2, "scm"    # Ljava/lang/String;
    .param p3, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .param p4, "streamId"    # Ljava/lang/String;

    .prologue
    .line 31
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset;

    const/4 v3, 0x1

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "scm"    # Ljava/lang/String;
    .param p3, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .prologue
    .line 35
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/asset/ESPNAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 8
    .param p1, "assetUri"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p4, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .prologue
    .line 21
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset;

    const/4 v3, 0x1

    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getPid()Ljava/lang/String;

    move-result-object v5

    .line 22
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;Landroid/app/Activity;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 6
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "channelId"    # Ljava/lang/String;
    .param p3, "scm"    # Ljava/lang/String;
    .param p4, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    .param p5, "activity"    # Landroid/app/Activity;

    .prologue
    .line 40
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;Landroid/app/Activity;)V

    return-object v0
.end method
