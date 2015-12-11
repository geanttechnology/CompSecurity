.class public Ltv/freewheel/hybrid/StreamStitcherHelper;
.super Ljava/lang/Object;
.source "StreamStitcherHelper.java"


# static fields
.field public static FW_CREATIVE_PARAMETER_EMBEDDED_METADATA:Ljava/lang/String;

.field public static Timeout:D

.field public static isHybridSDK:Z

.field private static logLevel:I


# instance fields
.field private final activity:Landroid/app/Activity;

.field private final adStartedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private final adStoppedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private final adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

.field private constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

.field private ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

.field private currentAd:Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

.field private exitPlayerFlag:Z

.field private inAdRequesting:Ljava/lang/Boolean;

.field private final logger:Ltv/freewheel/hybrid/utils/Logger;

.field private nonTemporalSlotBases:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/view/ViewGroup;",
            ">;"
        }
    .end annotation
.end field

.field private final onCuePoint:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private pendingEmbeddedMetadata:Landroid/util/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final playedAd:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;>;"
        }
    .end annotation
.end field

.field private final requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

.field private final retiredCtxList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/hybrid/ad/interfaces/IAdContext;",
            ">;"
        }
    .end annotation
.end field

.field private timeline:Ltv/freewheel/hybrid/CuePointManager;

.field private url:Ljava/net/URL;

.field private videoDisplayBase:Landroid/widget/FrameLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 36
    const-string v0, "embedded_metadata"

    sput-object v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->FW_CREATIVE_PARAMETER_EMBEDDED_METADATA:Ljava/lang/String;

    .line 37
    const/4 v0, 0x0

    sput-boolean v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->isHybridSDK:Z

    .line 42
    const-wide/high16 v0, 0x4014000000000000L    # 5.0

    sput-wide v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->Timeout:D

    .line 77
    const/4 v0, 0x6

    sput v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logLevel:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/content/Context;Landroid/location/Location;Ljava/net/URL;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "location"    # Landroid/location/Location;
    .param p4, "streamStitchedUrl"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 258
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-boolean v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->exitPlayerFlag:Z

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->retiredCtxList:Ljava/util/ArrayList;

    .line 51
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->playedAd:Ljava/util/HashSet;

    .line 62
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->inAdRequesting:Ljava/lang/Boolean;

    .line 92
    new-instance v0, Ltv/freewheel/hybrid/StreamStitcherHelper$1;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/StreamStitcherHelper$1;-><init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 109
    new-instance v0, Ltv/freewheel/hybrid/StreamStitcherHelper$2;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/StreamStitcherHelper$2;-><init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adStartedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 144
    new-instance v0, Ltv/freewheel/hybrid/StreamStitcherHelper$3;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/StreamStitcherHelper$3;-><init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adStoppedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 182
    new-instance v0, Ltv/freewheel/hybrid/StreamStitcherHelper$4;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/StreamStitcherHelper$4;-><init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->onCuePoint:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    .line 259
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 260
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->nonTemporalSlotBases:Ljava/util/HashMap;

    .line 261
    new-instance v0, Ltv/freewheel/hybrid/CuePointManager;

    invoke-direct {v0}, Ltv/freewheel/hybrid/CuePointManager;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->timeline:Ltv/freewheel/hybrid/CuePointManager;

    .line 262
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->timeline:Ltv/freewheel/hybrid/CuePointManager;

    sget-object v1, Ltv/freewheel/hybrid/CuePointManager;->EVENT_CUE_POINT_REACHED:Ljava/lang/String;

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->onCuePoint:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/hybrid/CuePointManager;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 263
    invoke-static {p2}, Ltv/freewheel/hybrid/ad/AdManager;->getInstance(Landroid/content/Context;)Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    .line 264
    sget v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logLevel:I

    invoke-static {v0}, Ltv/freewheel/hybrid/utils/Logger;->setLogLevel(I)V

    .line 265
    if-eqz p3, :cond_0

    .line 266
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    invoke-interface {v0, p3}, Ltv/freewheel/hybrid/ad/interfaces/IAdManager;->setLocation(Landroid/location/Location;)V

    .line 268
    :cond_0
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->activity:Landroid/app/Activity;

    .line 269
    invoke-direct {p0, p4}, Ltv/freewheel/hybrid/StreamStitcherHelper;->processStreamStitcherURL(Ljava/net/URL;)V

    .line 270
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/content/Context;Ljava/net/URL;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "streamStitchedUrl"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 235
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0, p3}, Ltv/freewheel/hybrid/StreamStitcherHelper;-><init>(Landroid/app/Activity;Landroid/content/Context;Landroid/location/Location;Ljava/net/URL;)V

    .line 236
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-object v0
.end method

.method static synthetic access$102(Ltv/freewheel/hybrid/StreamStitcherHelper;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 35
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->inAdRequesting:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic access$200(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    return-object v0
.end method

.method static synthetic access$300(Ltv/freewheel/hybrid/StreamStitcherHelper;)Landroid/util/Pair;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    return-object v0
.end method

.method static synthetic access$500(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->currentAd:Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    return-object v0
.end method

.method static synthetic access$502(Ltv/freewheel/hybrid/StreamStitcherHelper;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;)Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;
    .param p1, "x1"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .prologue
    .line 35
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->currentAd:Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    return-object p1
.end method

.method static synthetic access$600(Ltv/freewheel/hybrid/StreamStitcherHelper;)Ljava/util/HashSet;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->playedAd:Ljava/util/HashSet;

    return-object v0
.end method

.method static synthetic access$700(Ltv/freewheel/hybrid/StreamStitcherHelper;Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;
    .param p1, "x1"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/StreamStitcherHelper;->playCompanion(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;)V

    return-void
.end method

.method static synthetic access$800(Ltv/freewheel/hybrid/StreamStitcherHelper;Ltv/freewheel/hybrid/ad/interfaces/ISlot;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/StreamStitcherHelper;
    .param p1, "x1"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/StreamStitcherHelper;->resetCuePointSlotsInTimeline(Ltv/freewheel/hybrid/ad/interfaces/ISlot;)V

    return-void
.end method

.method private findAdWithMetadataValue(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .locals 10
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 421
    iget-object v6, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "findAdWithMetadataValue: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 422
    iget-object v6, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    if-nez v6, :cond_1

    .line 423
    const/4 v3, 0x0

    .line 446
    :cond_0
    return-object v3

    .line 425
    :cond_1
    const/4 v3, 0x0

    .line 426
    .local v3, "ret":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    iget-object v6, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getTemporalSlots()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 427
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 428
    .local v4, "s":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i2":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;>;"
    :cond_3
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 429
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .line 430
    .local v0, "a":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    iget-object v6, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->playedAd:Ljava/util/HashSet;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getAdId()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getReplicaId()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 433
    sget-object v6, Ltv/freewheel/hybrid/StreamStitcherHelper;->FW_CREATIVE_PARAMETER_EMBEDDED_METADATA:Ljava/lang/String;

    invoke-interface {v0, v6}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 434
    .local v5, "v":Ljava/lang/Object;
    if-eqz v5, :cond_3

    .line 437
    check-cast v5, Ljava/lang/String;

    .end local v5    # "v":Ljava/lang/Object;
    invoke-virtual {p1, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 438
    if-nez v3, :cond_4

    .line 439
    move-object v3, v0

    goto :goto_0

    .line 440
    :cond_4
    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v6

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v6

    invoke-interface {v4}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v8

    cmpl-double v6, v6, v8

    if-lez v6, :cond_3

    .line 441
    move-object v3, v0

    goto :goto_0
.end method

.method private playCompanion(Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;)V
    .locals 6
    .param p1, "ad"    # Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .prologue
    .line 488
    iget-object v4, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v5, "playCompanion"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 489
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getCompanionAdInstances()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    .line 490
    .local v0, "adi":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v2

    .line 491
    .local v2, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    iget-object v4, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->nonTemporalSlotBases:Ljava/util/HashMap;

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    .line 492
    .local v3, "slotContainer":Landroid/view/ViewGroup;
    if-eqz v3, :cond_0

    .line 493
    invoke-virtual {v3}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 494
    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 497
    .end local v0    # "adi":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    .end local v2    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .end local v3    # "slotContainer":Landroid/view/ViewGroup;
    :cond_1
    return-void
.end method

.method private processStreamStitcherURL(Ljava/net/URL;)V
    .locals 7
    .param p1, "streamStitchedUrl"    # Ljava/net/URL;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 473
    invoke-virtual {p1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v3

    .line 474
    .local v3, "raw":Ljava/lang/String;
    new-instance v4, Ljava/net/URL;

    const-string v5, "resp=m3u8"

    const-string v6, "resp=smrx"

    invoke-virtual {v3, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->url:Ljava/net/URL;

    .line 475
    iget-object v4, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->url:Ljava/net/URL;

    invoke-virtual {v5}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ltv/freewheel/hybrid/ad/interfaces/IAdManager;->setServer(Ljava/lang/String;)V

    .line 477
    :try_start_0
    const-string v4, "[\\?&]nw=([\\d]+)"

    invoke-static {v4}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v2

    .line 478
    .local v2, "p":Ljava/util/regex/Pattern;
    invoke-virtual {v2, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 479
    .local v1, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 480
    iget-object v4, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    const/4 v5, 0x1

    invoke-virtual {v1, v5}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-interface {v4, v5}, Ltv/freewheel/hybrid/ad/interfaces/IAdManager;->setNetwork(I)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 485
    .end local v1    # "m":Ljava/util/regex/Matcher;
    .end local v2    # "p":Ljava/util/regex/Pattern;
    :cond_0
    :goto_0
    return-void

    .line 482
    :catch_0
    move-exception v0

    .line 483
    .local v0, "e":Ljava/lang/NumberFormatException;
    iget-object v4, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to parse network id from URL "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private resetCuePointSlotsInTimeline(Ltv/freewheel/hybrid/ad/interfaces/ISlot;)V
    .locals 10
    .param p1, "endedSlot"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .prologue
    .line 502
    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v6, "resetCuePointSlotsInTimeline"

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 503
    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->timeline:Ltv/freewheel/hybrid/CuePointManager;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/CuePointManager;->reset()V

    .line 504
    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v5}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getTemporalSlots()Ljava/util/ArrayList;

    move-result-object v4

    .line 505
    .local v4, "sortedSlots":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ltv/freewheel/hybrid/ad/interfaces/ISlot;>;"
    new-instance v5, Ltv/freewheel/hybrid/StreamStitcherHelper$5;

    invoke-direct {v5, p0}, Ltv/freewheel/hybrid/StreamStitcherHelper$5;-><init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V

    invoke-static {v4, v5}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 511
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .line 512
    .local v1, "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v6

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v8

    cmpg-double v5, v6, v8

    if-ltz v5, :cond_0

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v5

    iget-object v6, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_PAUSE_MIDROLL()I

    move-result v6

    if-eq v5, v6, :cond_0

    .line 518
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePositionClass()I

    move-result v5

    iget-object v6, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v6}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_CLASS_OVERLAY()I

    move-result v6

    if-eq v5, v6, :cond_2

    .line 519
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 533
    .end local v1    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_1
    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->timeline:Ltv/freewheel/hybrid/CuePointManager;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/CuePointManager;->start()V

    .line 534
    return-void

    .line 524
    .restart local v1    # "slot":Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    :cond_2
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v6

    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v8

    sub-double v2, v6, v8

    .line 525
    .local v2, "newCuePointTime":D
    const-wide/16 v6, 0x0

    cmpl-double v5, v2, v6

    if-nez v5, :cond_3

    .line 526
    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->play()V

    goto :goto_0

    .line 528
    :cond_3
    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "schedule an overlay slot "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " after "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " seconds"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 529
    iget-object v5, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->timeline:Ltv/freewheel/hybrid/CuePointManager;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getCustomId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6, v2, v3}, Ltv/freewheel/hybrid/CuePointManager;->addCuePointForName(Ljava/lang/String;D)V

    goto/16 :goto_0
.end method

.method private startNewContext()V
    .locals 4

    .prologue
    .line 450
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->inAdRequesting:Ljava/lang/Boolean;

    .line 451
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    if-eqz v0, :cond_1

    .line 452
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->removeEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 453
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adStartedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->removeEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 454
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adStoppedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->removeEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 456
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->retiredCtxList:Ljava/util/ArrayList;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 457
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdManager;->newContextWithContext(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    .line 462
    :goto_0
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getConstants()Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    .line 463
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_REQUEST_COMPLETE()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->requestCompleteListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 464
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STARTED()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adStartedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 465
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_AD_STOPPED()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adStoppedListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 466
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->PARAMETER_REQUEST_ALTERNATIVE_URL()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->url:Ljava/net/URL;

    iget-object v3, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->PARAMETER_LEVEL_GLOBAL()I

    move-result v3

    invoke-interface {v0, v1, v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->setParameter(Ljava/lang/String;Ljava/lang/Object;I)V

    .line 467
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->videoDisplayBase:Landroid/widget/FrameLayout;

    if-eqz v0, :cond_0

    .line 468
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->videoDisplayBase:Landroid/widget/FrameLayout;

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->registerVideoDisplayBase(Landroid/widget/FrameLayout;)V

    .line 469
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    sget-wide v2, Ltv/freewheel/hybrid/StreamStitcherHelper;->Timeout:D

    invoke-interface {v0, v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->submitRequest(D)V

    .line 470
    return-void

    .line 459
    :cond_1
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->adm:Ltv/freewheel/hybrid/ad/interfaces/IAdManager;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdManager;->newContext()Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    .line 460
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->activity:Landroid/app/Activity;

    invoke-interface {v0, v1}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->setActivity(Landroid/app/Activity;)V

    goto :goto_0
.end method


# virtual methods
.method public handleMetadata(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 9
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "timePositionInStitchedStream"    # J

    .prologue
    const/4 v7, 0x0

    .line 311
    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v3, "handleMetadata (%s, %s, %d)"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p1, v4, v7

    const/4 v5, 0x1

    aput-object p2, v4, v5

    const/4 v5, 0x2

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 312
    const/4 v1, 0x0

    .line 313
    .local v1, "bMetadataPended":Z
    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;

    if-eqz v2, :cond_0

    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {p2, v3}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/util/Pair;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 314
    const/4 v1, 0x1

    .line 316
    :cond_0
    const/4 v2, 0x0

    iput-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;

    .line 317
    invoke-direct {p0, p2}, Ltv/freewheel/hybrid/StreamStitcherHelper;->findAdWithMetadataValue(Ljava/lang/String;)Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;

    move-result-object v0

    .line 318
    .local v0, "a":Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;
    if-eqz v0, :cond_3

    .line 319
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v2

    invoke-interface {v2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getAdInstances()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    if-ne v0, v2, :cond_1

    .line 320
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->getSlot()Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    move-result-object v2

    iget-object v3, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_SLOT_STARTED()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->processSlotEvent(Ljava/lang/String;)V

    .line 322
    :cond_1
    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdInstance;->play2()V

    .line 330
    :cond_2
    :goto_0
    return-void

    .line 324
    :cond_3
    if-nez v1, :cond_2

    iget-boolean v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->exitPlayerFlag:Z

    if-nez v2, :cond_2

    .line 325
    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {p2, v2}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->pendingEmbeddedMetadata:Landroid/util/Pair;

    .line 326
    iget-object v2, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->playedAd:Ljava/util/HashSet;

    invoke-virtual {v2}, Ljava/util/HashSet;->clear()V

    .line 327
    invoke-direct {p0}, Ltv/freewheel/hybrid/StreamStitcherHelper;->startNewContext()V

    goto :goto_0
.end method

.method public handleProgressUpdate(J)V
    .locals 5
    .param p1, "timePositionInStitchedStream"    # J

    .prologue
    .line 341
    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    if-nez v1, :cond_0

    .line 349
    :goto_0
    return-void

    .line 344
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 345
    .local v0, "x":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->TIME_POSITION_STRING()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 346
    iget-object v1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    new-instance v2, Ltv/freewheel/hybrid/utils/events/Event;

    iget-object v3, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    invoke-interface {v3}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_PROGRESS_UPDATE()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-interface {v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    goto :goto_0
.end method

.method public start()V
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->retiredCtxList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 278
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->playedAd:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 279
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->exitPlayerFlag:Z

    .line 280
    const/4 v0, 0x1

    sput-boolean v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->isHybridSDK:Z

    .line 282
    return-void
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    if-eqz v0, :cond_0

    .line 289
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->ctx:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v0}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->dispose()V

    .line 291
    :cond_0
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->timeline:Ltv/freewheel/hybrid/CuePointManager;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/CuePointManager;->stop()V

    .line 292
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->retiredCtxList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 293
    iget-object v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->playedAd:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 294
    const/4 v0, 0x0

    sput-boolean v0, Ltv/freewheel/hybrid/StreamStitcherHelper;->isHybridSDK:Z

    .line 295
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/StreamStitcherHelper;->exitPlayerFlag:Z

    .line 296
    return-void
.end method
