.class public Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;
.super Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;
.source "FreewheelManager.java"


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private adConstants:Ltv/freewheel/ad/interfaces/IConstants;

.field private adContext:Ltv/freewheel/ad/interfaces/IAdContext;

.field private adManager:Ltv/freewheel/ad/interfaces/IAdManager;

.field private freeWheelContextRequest:Ljava/lang/Runnable;

.field private metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

.field private savedSeekValue:J

.field private timelineOperations:Lcom/google/common/util/concurrent/SettableFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/util/concurrent/SettableFuture",
            "<",
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method constructor <init>(Landroid/app/Activity;)V
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 59
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;-><init>()V

    .line 56
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->savedSeekValue:J

    .line 173
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;

    invoke-direct {v0, p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager$1;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->freeWheelContextRequest:Ljava/lang/Runnable;

    .line 60
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Ltv/freewheel/ad/AdManager;->getInstance(Landroid/content/Context;)Ltv/freewheel/ad/interfaces/IAdManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adManager:Ltv/freewheel/ad/interfaces/IAdManager;

    .line 61
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adManager:Ltv/freewheel/ad/interfaces/IAdManager;

    const-string v1, "http://7468.v.fwmrm.net/"

    invoke-interface {v0, v1}, Ltv/freewheel/ad/interfaces/IAdManager;->setServer(Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adManager:Ltv/freewheel/ad/interfaces/IAdManager;

    const v1, 0x5df08

    invoke-interface {v0, v1}, Ltv/freewheel/ad/interfaces/IAdManager;->setNetwork(I)V

    .line 64
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adManager:Ltv/freewheel/ad/interfaces/IAdManager;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IAdManager;->newContext()Ltv/freewheel/ad/interfaces/IAdContext;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    .line 65
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/IAdContext;->getConstants()Ltv/freewheel/ad/interfaces/IConstants;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    .line 66
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    const-string v1, "384776:comcast_android_test"

    invoke-interface {v0, v1, v2, v2, v2}, Ltv/freewheel/ad/interfaces/IAdContext;->setProfile(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    const-string v1, "xtvtest_android_section"

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->random()I

    move-result v2

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v4}, Ltv/freewheel/ad/interfaces/IConstants;->ID_TYPE_CUSTOM()I

    move-result v4

    move v5, v3

    invoke-interface/range {v0 .. v5}, Ltv/freewheel/ad/interfaces/IAdContext;->setSiteSection(Ljava/lang/String;IIII)V

    .line 68
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    invoke-interface {v0, p1}, Ltv/freewheel/ad/interfaces/IAdContext;->setActivity(Landroid/app/Activity;)V

    .line 70
    new-instance v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v0}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    .line 71
    new-instance v6, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;

    invoke-direct {v6}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;-><init>()V

    .line 72
    .local v6, "advertisingMetadata":Lcom/adobe/mediacore/metadata/AdvertisingMetadata;
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    invoke-virtual {v6, v0}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setSignalingMode(Lcom/adobe/mediacore/metadata/AdSignalingMode;)V

    .line 73
    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    const-string v1, "true"

    invoke-virtual {v6, v0, v1}, Lcom/adobe/mediacore/metadata/AdvertisingMetadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    const-string v1, "FREEWHEEL_AD_KEY"

    invoke-virtual {v0, v1, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 77
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ljava/util/Vector;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->processAdSlots()Ljava/util/Vector;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Lcom/google/common/util/concurrent/SettableFuture;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->timelineOperations:Lcom/google/common/util/concurrent/SettableFuture;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;)Ltv/freewheel/ad/interfaces/IAdContext;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    return-object v0
.end method

.method private getTimelineOperation(Ltv/freewheel/ad/interfaces/ISlot;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;)Lcom/adobe/mediacore/timeline/TimelineOperation;
    .locals 21
    .param p1, "slot"    # Ltv/freewheel/ad/interfaces/ISlot;
    .param p2, "i"    # Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    .prologue
    .line 230
    new-instance v18, Ljava/util/Vector;

    invoke-direct/range {v18 .. v18}, Ljava/util/Vector;-><init>()V

    .line 231
    .local v18, "ads":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/adobe/mediacore/timeline/advertising/Ad;>;"
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v3

    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ltv/freewheel/ad/interfaces/IAdInstance;

    .line 232
    .local v17, "adInstance":Ltv/freewheel/ad/interfaces/IAdInstance;
    invoke-interface/range {v17 .. v17}, Ltv/freewheel/ad/interfaces/IAdInstance;->getActiveCreativeRendition()Ltv/freewheel/ad/interfaces/ICreativeRendition;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/ICreativeRendition;->getPrimaryCreativRenditionAsset()Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;

    move-result-object v3

    invoke-interface {v3}, Ltv/freewheel/ad/interfaces/ICreativeRenditionAsset;->getURL()Ljava/lang/String;

    move-result-object v19

    .line 234
    .local v19, "url":Ljava/lang/String;
    const/4 v3, 0x0

    move-object/from16 v0, v19

    invoke-static {v0, v3}, Lcom/adobe/mediacore/MediaResource;->createFromUrl(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v6

    .line 235
    .local v6, "resource":Lcom/adobe/mediacore/MediaResource;
    invoke-interface/range {v17 .. v17}, Ltv/freewheel/ad/interfaces/IAdInstance;->getDuration()D

    move-result-wide v8

    double-to-long v8, v8

    const-wide/16 v12, 0x3e8

    mul-long v4, v8, v12

    .line 236
    .local v4, "duration":J
    invoke-interface/range {p1 .. p1}, Ltv/freewheel/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v8

    double-to-long v8, v8

    const-wide/16 v12, 0x3e8

    mul-long v10, v8, v12

    .line 237
    .local v10, "startTime":J
    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-interface/range {v17 .. v17}, Ltv/freewheel/ad/interfaces/IAdInstance;->getAdId()I

    move-result v3

    new-instance v7, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    const-string v8, ""

    const-string v9, ""

    const-string v12, ""

    invoke-direct {v7, v8, v9, v12}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v8, 0x0

    invoke-direct/range {v2 .. v8}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;-><init>(IJLcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/timeline/advertising/AdClick;Lcom/adobe/mediacore/metadata/Metadata;)V

    .line 238
    .local v2, "adAsset":Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    sget-object v3, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-interface/range {v17 .. v17}, Ltv/freewheel/ad/interfaces/IAdInstance;->getAdId()I

    move-result v8

    invoke-static {v3, v4, v5, v8, v2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->createCustomAdMarker(Lcom/adobe/mediacore/MediaResource$Type;JILcom/adobe/mediacore/timeline/advertising/AdAsset;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v15

    .line 239
    .local v15, "ad":Lcom/adobe/mediacore/timeline/advertising/Ad;
    move-object/from16 v0, v18

    invoke-virtual {v0, v15}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 241
    new-instance v20, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    invoke-direct/range {v20 .. v20}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;-><init>()V

    .line 242
    .local v20, "videoAd":Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
    move-object/from16 v0, v20

    invoke-virtual {v0, v10, v11}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setStartTime(J)V

    .line 243
    move-object/from16 v0, v20

    invoke-virtual {v0, v4, v5}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setDuration(J)V

    .line 244
    invoke-interface/range {v17 .. v17}, Ltv/freewheel/ad/interfaces/IAdInstance;->getAdId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->setId(Ljava/lang/String;)V

    .line 245
    new-instance v16, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;-><init>(Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;)V

    .line 246
    .local v16, "adBreak":Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
    invoke-interface/range {v17 .. v17}, Ltv/freewheel/ad/interfaces/IAdInstance;->getAdId()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;->setId(Ljava/lang/String;)V

    .line 248
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->timeline:Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;

    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdTimeline;->addAd(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 251
    new-instance v7, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v9, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-object/from16 v8, p2

    move-wide v12, v4

    invoke-direct/range {v7 .. v13}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    .line 252
    .local v7, "placementInformation":Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    const-wide/16 v12, 0x0

    invoke-interface/range {p1 .. p1}, Ltv/freewheel/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v9, v18

    invoke-static/range {v9 .. v14}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v8

    invoke-direct {v3, v8, v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    return-object v3
.end method

.method private processAdSlots()Ljava/util/Vector;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 202
    new-instance v1, Ljava/util/Vector;

    invoke-direct {v1}, Ljava/util/Vector;-><init>()V

    .line 203
    .local v1, "operations":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/adobe/mediacore/timeline/TimelineOperation;>;"
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PREROLL()I

    move-result v6

    invoke-interface {v5, v6}, Ltv/freewheel/ad/interfaces/IAdContext;->getSlotsByTimePositionClass(I)Ljava/util/ArrayList;

    move-result-object v3

    .line 204
    .local v3, "slots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/ad/interfaces/ISlot;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 205
    .local v2, "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 206
    sget-object v5, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-direct {p0, v2, v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->getTimelineOperation(Ltv/freewheel/ad/interfaces/ISlot;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    move-result-object v4

    .line 207
    .local v4, "timelineOperation":Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-virtual {v1, v4}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 210
    .end local v2    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    .end local v4    # "timelineOperation":Lcom/adobe/mediacore/timeline/TimelineOperation;
    :cond_1
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_MIDROLL()I

    move-result v6

    invoke-interface {v5, v6}, Ltv/freewheel/ad/interfaces/IAdContext;->getSlotsByTimePositionClass(I)Ljava/util/ArrayList;

    move-result-object v3

    .line 211
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 212
    .restart local v2    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 213
    sget-object v5, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-direct {p0, v2, v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->getTimelineOperation(Ltv/freewheel/ad/interfaces/ISlot;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    move-result-object v4

    .line 214
    .restart local v4    # "timelineOperation":Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-virtual {v1, v4}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 218
    .end local v2    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    .end local v4    # "timelineOperation":Lcom/adobe/mediacore/timeline/TimelineOperation;
    :cond_3
    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/ad/interfaces/IConstants;->TIME_POSITION_CLASS_POSTROLL()I

    move-result v6

    invoke-interface {v5, v6}, Ltv/freewheel/ad/interfaces/IAdContext;->getSlotsByTimePositionClass(I)Ljava/util/ArrayList;

    move-result-object v3

    .line 219
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_4
    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/interfaces/ISlot;

    .line 220
    .restart local v2    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_4

    invoke-interface {v2}, Ltv/freewheel/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_4

    .line 221
    sget-object v5, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-direct {p0, v2, v5}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->getTimelineOperation(Ltv/freewheel/ad/interfaces/ISlot;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;)Lcom/adobe/mediacore/timeline/TimelineOperation;

    move-result-object v4

    .line 222
    .restart local v4    # "timelineOperation":Lcom/adobe/mediacore/timeline/TimelineOperation;
    invoke-virtual {v1, v4}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 226
    .end local v2    # "slot":Ltv/freewheel/ad/interfaces/ISlot;
    .end local v4    # "timelineOperation":Lcom/adobe/mediacore/timeline/TimelineOperation;
    :cond_5
    return-object v1
.end method

.method private random()I
    .locals 4

    .prologue
    .line 80
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    const-wide v2, 0x41dfffffffc00000L    # 2.147483647E9

    mul-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-int v0, v0

    return v0
.end method


# virtual methods
.method public getAdProposals()Ljava/util/Vector;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v7, 0x0

    .line 141
    invoke-static {}, Lcom/google/common/util/concurrent/SettableFuture;->create()Lcom/google/common/util/concurrent/SettableFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->timelineOperations:Lcom/google/common/util/concurrent/SettableFuture;

    .line 142
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getDuration()J

    move-result-wide v8

    long-to-double v8, v8

    const-wide v12, 0x408f400000000000L    # 1000.0

    div-double v2, v8, v12

    .line 143
    .local v2, "videoDuration":D
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    invoke-interface {v0}, Lcom/comcast/playerplatform/primetime/android/player/Player;->getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v1

    .line 145
    .local v1, "assetId":Ljava/lang/String;
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v5}, Ltv/freewheel/ad/interfaces/IConstants;->VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED()I

    move-result v5

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->random()I

    move-result v6

    iget-object v8, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v8}, Ltv/freewheel/ad/interfaces/IConstants;->ID_TYPE_CUSTOM()I

    move-result v8

    iget-object v9, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adConstants:Ltv/freewheel/ad/interfaces/IConstants;

    invoke-interface {v9}, Ltv/freewheel/ad/interfaces/IConstants;->VIDEO_ASSET_DURATION_TYPE_EXACT()I

    move-result v10

    move v9, v7

    invoke-interface/range {v0 .. v10}, Ltv/freewheel/ad/interfaces/IAdContext;->setVideoAsset(Ljava/lang/String;DLjava/lang/String;IIIIII)V

    .line 155
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->freeWheelContextRequest:Ljava/lang/Runnable;

    invoke-virtual {v0, v5}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    .line 158
    :try_start_0
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->timelineOperations:Lcom/google/common/util/concurrent/SettableFuture;

    const-wide/16 v6, 0x5

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v6, v7, v5}, Lcom/google/common/util/concurrent/SettableFuture;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Vector;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2

    .line 170
    :goto_0
    return-object v0

    .line 159
    :catch_0
    move-exception v11

    .line 161
    .local v11, "e":Ljava/lang/InterruptedException;
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Freewheel ad operation failed. "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v11}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v5}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .end local v11    # "e":Ljava/lang/InterruptedException;
    :goto_1
    move-object v0, v4

    .line 170
    goto :goto_0

    .line 162
    :catch_1
    move-exception v11

    .line 164
    .local v11, "e":Ljava/util/concurrent/ExecutionException;
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Freewheel ad operation failed. "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v11}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v5}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_1

    .line 165
    .end local v11    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_2
    move-exception v11

    .line 167
    .local v11, "e":Ljava/util/concurrent/TimeoutException;
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->logger:Lorg/slf4j/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Freewheel ad operation timeout. "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v11}, Ljava/util/concurrent/TimeoutException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v0, v5}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public getMetadataForAdobe()Lcom/adobe/mediacore/metadata/MetadataNode;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->metadataNode:Lcom/adobe/mediacore/metadata/MetadataNode;

    return-object v0
.end method

.method public getPlayerTimeline(Lcom/adobe/mediacore/timeline/Timeline;)Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 2
    .param p1, "timeline"    # Lcom/adobe/mediacore/timeline/Timeline;

    .prologue
    .line 137
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    invoke-interface {p1}, Lcom/adobe/mediacore/timeline/Timeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;-><init>(Ljava/util/Iterator;)V

    return-object v0
.end method

.method public getSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    .prologue
    .line 105
    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method

.method public onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V
    .locals 0
    .param p1, "timedMetadata"    # Lcom/adobe/mediacore/metadata/TimedMetadata;

    .prologue
    .line 128
    return-void
.end method

.method public setAdContext(Ltv/freewheel/ad/interfaces/IAdContext;)V
    .locals 0
    .param p1, "adContext"    # Ltv/freewheel/ad/interfaces/IAdContext;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->adContext:Ltv/freewheel/ad/interfaces/IAdContext;

    .line 96
    return-void
.end method

.method public triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 4
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 85
    invoke-super {p0, p1}, Lcom/comcast/playerplatform/primetime/android/ads/managers/BaseAdManager;->triggerAdBreakComplete(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V

    .line 87
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->savedSeekValue:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->seekingOutOfAd:Z

    if-nez v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->player:Lcom/comcast/playerplatform/primetime/android/player/Player;

    iget-wide v2, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->savedSeekValue:J

    const/4 v1, 0x1

    invoke-interface {v0, v2, v3, v1}, Lcom/comcast/playerplatform/primetime/android/player/Player;->setPosition(JZ)V

    .line 91
    :cond_0
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/ads/managers/FreewheelManager;->savedSeekValue:J

    .line 92
    return-void
.end method
