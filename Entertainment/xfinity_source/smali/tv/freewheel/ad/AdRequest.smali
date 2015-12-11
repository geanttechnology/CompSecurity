.class public Ltv/freewheel/ad/AdRequest;
.super Ltv/freewheel/ad/AdContextScoped;
.source "AdRequest.java"


# instance fields
.field public globalLevelParameters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private keyValues:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/TreeSet",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private nonTemporalSlots:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/slot/NonTemporalSlot;",
            ">;"
        }
    .end annotation
.end field

.field public overrideLevelParameters:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private requestDuration:D

.field private requestMode:Ljava/lang/String;

.field private ssCustomId:Ljava/lang/String;

.field private ssFallbackId:I

.field private ssId:Ljava/lang/String;

.field private ssNetworkId:I

.field private ssPageViewRandom:I

.field private subsessionToken:I

.field private temporalSlots:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ltv/freewheel/ad/slot/TemporalSlot;",
            ">;"
        }
    .end annotation
.end field

.field private vaAutoPlayType:I

.field private vaCustomId:Ljava/lang/String;

.field private vaDuration:D

.field private vaDurationType:Ljava/lang/String;

.field private vaFallbackId:I

.field private vaId:Ljava/lang/String;

.field protected vaMediaLocation:Ljava/lang/String;

.field private vaNetworkId:I

.field private vaVideoAssetCurrentTimePosition:D

.field private vaVideoPlayRandom:I

.field protected videoViewCallbackRequested:Z

.field private videoViewCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private videoViewTestListener:Ltv/freewheel/ad/interfaces/IEventListener;

.field private vpNetworkId:I


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Ltv/freewheel/ad/AdContextScoped;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 26
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->requestMode:Ljava/lang/String;

    .line 38
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->vaDurationType:Ljava/lang/String;

    .line 40
    const/4 v0, 0x1

    iput v0, p0, Ltv/freewheel/ad/AdRequest;->vaAutoPlayType:I

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/ad/AdRequest;->videoViewCallbackRequested:Z

    .line 52
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->videoViewTestListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 434
    new-instance v0, Ltv/freewheel/ad/AdRequest$1;

    invoke-direct {v0, p0}, Ltv/freewheel/ad/AdRequest$1;-><init>(Ltv/freewheel/ad/AdRequest;)V

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->videoViewCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    .line 56
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0}, Ljava/util/TreeMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->keyValues:Ljava/util/TreeMap;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->temporalSlots:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->nonTemporalSlots:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->globalLevelParameters:Ljava/util/HashMap;

    .line 60
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->overrideLevelParameters:Ljava/util/HashMap;

    .line 61
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/ad/AdRequest;)Ltv/freewheel/ad/interfaces/IEventListener;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/ad/AdRequest;

    .prologue
    .line 24
    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->videoViewTestListener:Ltv/freewheel/ad/interfaces/IEventListener;

    return-object v0
.end method

.method private buildKeyValuesElement()Ltv/freewheel/utils/XMLElement;
    .locals 8

    .prologue
    .line 307
    new-instance v4, Ltv/freewheel/utils/XMLElement;

    const-string v6, "keyValues"

    invoke-direct {v4, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 308
    .local v4, "node":Ltv/freewheel/utils/XMLElement;
    iget-object v6, p0, Ltv/freewheel/ad/AdRequest;->keyValues:Ljava/util/TreeMap;

    invoke-virtual {v6}, Ljava/util/TreeMap;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 309
    .local v2, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 310
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 311
    .local v3, "key":Ljava/lang/String;
    iget-object v6, p0, Ltv/freewheel/ad/AdRequest;->keyValues:Ljava/util/TreeMap;

    invoke-virtual {v6, v3}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/TreeSet;

    .line 312
    .local v5, "values":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Ljava/lang/String;>;"
    invoke-virtual {v5}, Ljava/util/TreeSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 313
    .local v1, "ii":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 314
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v6, "keyValue"

    invoke-direct {v0, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 315
    .local v0, "child":Ltv/freewheel/utils/XMLElement;
    const-string v6, "key"

    invoke-virtual {v0, v6, v3}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    const-string v7, "value"

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v0, v7, v6}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 317
    invoke-virtual {v4, v0}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_0

    .line 321
    .end local v0    # "child":Ltv/freewheel/utils/XMLElement;
    .end local v1    # "ii":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v3    # "key":Ljava/lang/String;
    .end local v5    # "values":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Ljava/lang/String;>;"
    :cond_1
    return-object v4
.end method

.method private buildSiteSectionElement()Ltv/freewheel/utils/XMLElement;
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 325
    new-instance v1, Ltv/freewheel/utils/XMLElement;

    const-string v6, "siteSection"

    invoke-direct {v1, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 326
    .local v1, "siteSectionNode":Ltv/freewheel/utils/XMLElement;
    const-string v6, "customId"

    iget-object v7, p0, Ltv/freewheel/ad/AdRequest;->ssCustomId:Ljava/lang/String;

    invoke-virtual {v1, v6, v7}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    const-string v6, "id"

    iget-object v7, p0, Ltv/freewheel/ad/AdRequest;->ssId:Ljava/lang/String;

    invoke-virtual {v1, v6, v7}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    const-string v6, "fallbackId"

    iget v7, p0, Ltv/freewheel/ad/AdRequest;->ssFallbackId:I

    invoke-virtual {v1, v6, v7, v8}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 329
    const-string v6, "pageViewRandom"

    iget v7, p0, Ltv/freewheel/ad/AdRequest;->ssPageViewRandom:I

    invoke-virtual {v1, v6, v7, v8}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 330
    const-string v6, "siteSectionNetworkId"

    iget v7, p0, Ltv/freewheel/ad/AdRequest;->ssNetworkId:I

    invoke-virtual {v1, v6, v7, v8}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 332
    new-instance v4, Ltv/freewheel/utils/XMLElement;

    const-string v6, "videoPlayer"

    invoke-direct {v4, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 333
    .local v4, "videoPlayerNode":Ltv/freewheel/utils/XMLElement;
    const-string v6, "videoPlayerNetworkId"

    iget v7, p0, Ltv/freewheel/ad/AdRequest;->vpNetworkId:I

    invoke-virtual {v4, v6, v7, v8}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 334
    invoke-direct {p0}, Ltv/freewheel/ad/AdRequest;->buildVideoAssetElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v6

    invoke-virtual {v4, v6}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 337
    new-instance v5, Ltv/freewheel/utils/XMLElement;

    const-string v6, "adSlots"

    invoke-direct {v5, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 338
    .local v5, "vpntSlotsNode":Ltv/freewheel/utils/XMLElement;
    const-string v6, "defaultSlotProfile"

    iget-object v7, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/ad/AdContext;->defaultVideoPlayerSlotProfile:Ljava/lang/String;

    invoke-virtual {v5, v6, v7}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    iget-object v6, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v6, v6, Ltv/freewheel/ad/AdContext;->capabilities:Ltv/freewheel/ad/Capabilities;

    const-string v7, "skipsAdSelection"

    invoke-virtual {v6, v7}, Ltv/freewheel/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v6

    if-ne v6, v8, :cond_1

    .line 341
    iget-object v6, p0, Ltv/freewheel/ad/AdRequest;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 342
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 343
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/NonTemporalSlot;

    .line 344
    .local v2, "slot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    iget v6, v2, Ltv/freewheel/ad/slot/NonTemporalSlot;->type:I

    if-ne v6, v8, :cond_0

    .line 345
    invoke-virtual {v2}, Ltv/freewheel/ad/slot/NonTemporalSlot;->buildXMLElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_0

    .line 349
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    .end local v2    # "slot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    :cond_1
    invoke-virtual {v4, v5}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 350
    invoke-virtual {v1, v4}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 352
    new-instance v3, Ltv/freewheel/utils/XMLElement;

    const-string v6, "adSlots"

    invoke-direct {v3, v6}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 353
    .local v3, "ssntSlotsNode":Ltv/freewheel/utils/XMLElement;
    const-string v6, "defaultSlotProfile"

    iget-object v7, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v7, v7, Ltv/freewheel/ad/AdContext;->defaultSiteSectionSlotProfile:Ljava/lang/String;

    invoke-virtual {v3, v6, v7}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 355
    iget-object v6, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v6, v6, Ltv/freewheel/ad/AdContext;->capabilities:Ltv/freewheel/ad/Capabilities;

    const-string v7, "skipsAdSelection"

    invoke-virtual {v6, v7}, Ltv/freewheel/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v6

    if-ne v6, v8, :cond_3

    .line 356
    iget-object v6, p0, Ltv/freewheel/ad/AdRequest;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 357
    .restart local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 358
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/NonTemporalSlot;

    .line 359
    .restart local v2    # "slot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    iget v6, v2, Ltv/freewheel/ad/slot/NonTemporalSlot;->type:I

    const/4 v7, 0x2

    if-ne v6, v7, :cond_2

    .line 360
    invoke-virtual {v2}, Ltv/freewheel/ad/slot/NonTemporalSlot;->buildXMLElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v6

    invoke-virtual {v3, v6}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_1

    .line 364
    .end local v0    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    .end local v2    # "slot":Ltv/freewheel/ad/slot/NonTemporalSlot;
    :cond_3
    invoke-virtual {v1, v3}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 366
    return-object v1
.end method

.method private buildVideoAssetElement()Ltv/freewheel/utils/XMLElement;
    .locals 8

    .prologue
    const/4 v4, 0x1

    .line 393
    new-instance v2, Ltv/freewheel/utils/XMLElement;

    const-string v3, "videoAsset"

    invoke-direct {v2, v3}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 394
    .local v2, "node":Ltv/freewheel/utils/XMLElement;
    const-string v3, "customId"

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    invoke-virtual {v2, v3, v5}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 395
    const-string v3, "id"

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    invoke-virtual {v2, v3, v5}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 396
    const-string v3, "fallbackId"

    iget v5, p0, Ltv/freewheel/ad/AdRequest;->vaFallbackId:I

    invoke-virtual {v2, v3, v5, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 397
    const-string v3, "mediaLocation"

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest;->vaMediaLocation:Ljava/lang/String;

    invoke-virtual {v2, v3, v5}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 398
    const-string v3, "duration"

    iget-wide v6, p0, Ltv/freewheel/ad/AdRequest;->vaDuration:D

    invoke-virtual {v2, v3, v6, v7, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;DZ)V

    .line 399
    const-string v3, "videoAssetNetworkId"

    iget v5, p0, Ltv/freewheel/ad/AdRequest;->vaNetworkId:I

    invoke-virtual {v2, v3, v5, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 400
    const-string v3, "videoPlayRandom"

    iget v5, p0, Ltv/freewheel/ad/AdRequest;->vaVideoPlayRandom:I

    invoke-virtual {v2, v3, v5, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;IZ)V

    .line 401
    const-string v5, "autoPlay"

    iget v3, p0, Ltv/freewheel/ad/AdRequest;->vaAutoPlayType:I

    if-eqz v3, :cond_2

    move v3, v4

    :goto_0
    invoke-virtual {v2, v5, v3}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 402
    const-string v3, "currentTimePosition"

    iget-wide v6, p0, Ltv/freewheel/ad/AdRequest;->vaVideoAssetCurrentTimePosition:D

    invoke-virtual {v2, v3, v6, v7, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;DZ)V

    .line 403
    const-string v3, "requestDuration"

    iget-wide v6, p0, Ltv/freewheel/ad/AdRequest;->requestDuration:D

    invoke-virtual {v2, v3, v6, v7, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;DZ)V

    .line 405
    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->vaDurationType:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->vaDurationType:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-eqz v3, :cond_0

    .line 406
    const-string v3, "durationType"

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest;->vaDurationType:Ljava/lang/String;

    invoke-virtual {v2, v3, v5}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    :cond_0
    iget v3, p0, Ltv/freewheel/ad/AdRequest;->vaAutoPlayType:I

    const/4 v5, 0x2

    if-ne v3, v5, :cond_1

    .line 408
    const-string v3, "unattendedPlay"

    invoke-virtual {v2, v3, v4}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Z)V

    .line 409
    :cond_1
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v3, "adSlots"

    invoke-direct {v0, v3}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 410
    .local v0, "child":Ltv/freewheel/utils/XMLElement;
    const-string v3, "defaultSlotProfile"

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v5, v5, Ltv/freewheel/ad/AdContext;->defaultTemporalSlotProfile:Ljava/lang/String;

    invoke-virtual {v0, v3, v5}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 411
    const-string v3, "compatibleDimensions"

    iget-object v5, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v5}, Ltv/freewheel/ad/AdContext;->getScreenDimensionStr()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v3, v5}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 413
    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v3, v3, Ltv/freewheel/ad/AdContext;->capabilities:Ltv/freewheel/ad/Capabilities;

    const-string v5, "skipsAdSelection"

    invoke-virtual {v3, v5}, Ltv/freewheel/ad/Capabilities;->getCapability(Ljava/lang/String;)I

    move-result v3

    if-ne v3, v4, :cond_4

    .line 414
    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 415
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 416
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ltv/freewheel/ad/slot/TemporalSlot;

    invoke-virtual {v3}, Ltv/freewheel/ad/slot/TemporalSlot;->buildXMLElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v3

    invoke-virtual {v0, v3}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    goto :goto_1

    .line 401
    .end local v0    # "child":Ltv/freewheel/utils/XMLElement;
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_2
    const/4 v3, 0x0

    goto :goto_0

    .line 418
    .restart local v0    # "child":Ltv/freewheel/utils/XMLElement;
    .restart local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_3
    invoke-virtual {v2, v0}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 420
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_4
    return-object v2
.end method

.method private getCustomId(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "idType"    # I

    .prologue
    const/4 v0, 0x0

    .line 257
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    move-object p1, v0

    .line 263
    .end local p1    # "id":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object p1

    .line 260
    .restart local p1    # "id":Ljava/lang/String;
    :cond_2
    if-eqz p2, :cond_1

    move-object p1, v0

    .line 263
    goto :goto_0
.end method

.method private getFWId(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "idType"    # I

    .prologue
    const/4 v0, 0x0

    .line 244
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    move-object p1, v0

    .line 253
    .end local p1    # "id":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object p1

    .line 247
    .restart local p1    # "id":Ljava/lang/String;
    :cond_2
    const/4 v1, 0x2

    if-ne p2, v1, :cond_3

    .line 248
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "g"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 250
    :cond_3
    const/4 v1, 0x1

    if-eq p2, v1, :cond_1

    move-object p1, v0

    .line 253
    goto :goto_0
.end method


# virtual methods
.method public addKeyValue(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 90
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    if-nez p2, :cond_1

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 93
    :cond_1
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->keyValues:Ljava/util/TreeMap;

    invoke-virtual {v1, p1}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/TreeSet;

    .line 94
    .local v0, "values":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Ljava/lang/String;>;"
    if-nez v0, :cond_2

    .line 95
    new-instance v0, Ljava/util/TreeSet;

    .end local v0    # "values":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Ljava/lang/String;>;"
    invoke-direct {v0}, Ljava/util/TreeSet;-><init>()V

    .line 96
    .restart local v0    # "values":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Ljava/lang/String;>;"
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->keyValues:Ljava/util/TreeMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    :cond_2
    invoke-virtual {v0, p2}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public buildXMLElement()Ltv/freewheel/utils/XMLElement;
    .locals 3

    .prologue
    .line 289
    new-instance v0, Ltv/freewheel/utils/XMLElement;

    const-string v1, "adRequest"

    invoke-direct {v0, v1}, Ltv/freewheel/utils/XMLElement;-><init>(Ljava/lang/String;)V

    .line 290
    .local v0, "root":Ltv/freewheel/utils/XMLElement;
    const-string v1, "networkId"

    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget v2, v2, Ltv/freewheel/ad/AdContext;->networkId:I

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;I)V

    .line 291
    const-string v1, "version"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    const-string v1, "profile"

    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v2, v2, Ltv/freewheel/ad/AdContext;->playerProfile:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 293
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->requestMode:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->requestMode:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_0

    .line 294
    const-string v1, "mode"

    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->requestMode:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 295
    :cond_0
    iget v1, p0, Ltv/freewheel/ad/AdRequest;->subsessionToken:I

    if-lez v1, :cond_1

    .line 296
    const-string v1, "subsessionToken"

    iget v2, p0, Ltv/freewheel/ad/AdRequest;->subsessionToken:I

    invoke-virtual {v0, v1, v2}, Ltv/freewheel/utils/XMLElement;->setAttribute(Ljava/lang/String;I)V

    .line 298
    :cond_1
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v1, v1, Ltv/freewheel/ad/AdContext;->capabilities:Ltv/freewheel/ad/Capabilities;

    invoke-virtual {v1}, Ltv/freewheel/ad/Capabilities;->buildXMLElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 299
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v1, v1, Ltv/freewheel/ad/AdContext;->visitor:Ltv/freewheel/ad/Visitor;

    invoke-virtual {v1}, Ltv/freewheel/ad/Visitor;->buildXMLElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 300
    invoke-direct {p0}, Ltv/freewheel/ad/AdRequest;->buildKeyValuesElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 301
    invoke-direct {p0}, Ltv/freewheel/ad/AdRequest;->buildSiteSectionElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/XMLElement;->appendChild(Ltv/freewheel/utils/XMLElement;)V

    .line 303
    return-object v0
.end method

.method public getSlotByCustomId(Ljava/lang/String;)Ltv/freewheel/ad/slot/Slot;
    .locals 4
    .param p1, "customId"    # Ljava/lang/String;

    .prologue
    .line 215
    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->temporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 216
    .local v0, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/TemporalSlot;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 217
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .line 218
    .local v2, "slot":Ltv/freewheel/ad/slot/Slot;
    iget-object v3, v2, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 231
    .end local v2    # "slot":Ltv/freewheel/ad/slot/Slot;
    :goto_0
    return-object v2

    .line 223
    :cond_1
    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->nonTemporalSlots:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 224
    .local v1, "iter2":Ljava/util/Iterator;, "Ljava/util/Iterator<Ltv/freewheel/ad/slot/NonTemporalSlot;>;"
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 225
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ltv/freewheel/ad/slot/Slot;

    .line 226
    .restart local v2    # "slot":Ltv/freewheel/ad/slot/Slot;
    iget-object v3, v2, Ltv/freewheel/ad/slot/Slot;->customId:Ljava/lang/String;

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_0

    .line 231
    .end local v2    # "slot":Ltv/freewheel/ad/slot/Slot;
    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public hasSetVideoAssetId()Z
    .locals 1

    .prologue
    .line 424
    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 425
    const/4 v0, 0x0

    .line 427
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public hasVideoAsset()Z
    .locals 1

    .prologue
    .line 457
    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public requestVideoView()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 461
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "will send videoView request"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 462
    iget-boolean v2, p0, Ltv/freewheel/ad/AdRequest;->videoViewCallbackRequested:Z

    if-eqz v2, :cond_1

    .line 510
    :cond_0
    :goto_0
    return-void

    .line 465
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Ltv/freewheel/ad/AdRequest;->videoViewCallbackRequested:Z

    .line 466
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    const-string v3, "skipsAdSelection"

    invoke-virtual {v2, v3, v4}, Ltv/freewheel/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 468
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    const-string v3, "requiresVideoCallbackUrl"

    invoke-virtual {v2, v3, v4}, Ltv/freewheel/ad/AdContext;->setCapability(Ljava/lang/String;I)V

    .line 471
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v2, v2, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    const-string v3, "^\\w+:.*"

    invoke-virtual {v2, v3}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 472
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "requestVideoView: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v4, v4, Ltv/freewheel/ad/AdContext;->serverUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 473
    new-instance v2, Ltv/freewheel/ad/AdRequest$2;

    invoke-direct {v2, p0}, Ltv/freewheel/ad/AdRequest$2;-><init>(Ltv/freewheel/ad/AdRequest;)V

    invoke-virtual {v2}, Ltv/freewheel/ad/AdRequest$2;->start()V

    goto :goto_0

    .line 500
    :cond_2
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    invoke-virtual {v2}, Ltv/freewheel/ad/AdContext;->buildRequest()Ltv/freewheel/utils/URLRequest;

    move-result-object v1

    .line 502
    .local v1, "req":Ltv/freewheel/utils/URLRequest;
    if-eqz v1, :cond_0

    .line 503
    new-instance v0, Ltv/freewheel/utils/URLLoader;

    invoke-direct {v0}, Ltv/freewheel/utils/URLLoader;-><init>()V

    .line 505
    .local v0, "loader":Ltv/freewheel/utils/URLLoader;
    const-string v2, "URLLoader.Load.Complete"

    iget-object v3, p0, Ltv/freewheel/ad/AdRequest;->videoViewCompleteListener:Ltv/freewheel/ad/interfaces/IEventListener;

    invoke-virtual {v0, v2, v3}, Ltv/freewheel/utils/URLLoader;->addEventListener(Ljava/lang/String;Ltv/freewheel/ad/interfaces/IEventListener;)V

    .line 508
    invoke-virtual {v0, v1}, Ltv/freewheel/utils/URLLoader;->load(Ltv/freewheel/utils/URLRequest;)V

    goto :goto_0
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;I)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "level"    # I

    .prologue
    .line 370
    if-nez p1, :cond_0

    .line 390
    :goto_0
    return-void

    .line 373
    :cond_0
    const/4 v0, 0x0

    .line 374
    .local v0, "dict":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sparse-switch p3, :sswitch_data_0

    .line 382
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "can not set parameter for level "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 376
    :sswitch_0
    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->globalLevelParameters:Ljava/util/HashMap;

    .line 385
    :goto_1
    if-nez p2, :cond_1

    .line 386
    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 379
    :sswitch_1
    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->overrideLevelParameters:Ljava/util/HashMap;

    .line 380
    goto :goto_1

    .line 388
    :cond_1
    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 374
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x5 -> :sswitch_1
    .end sparse-switch
.end method

.method public setSiteSection(Ljava/lang/String;IIII)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "pageViewRandom"    # I
    .param p3, "networkId"    # I
    .param p4, "idType"    # I
    .param p5, "fallbackId"    # I

    .prologue
    .line 102
    invoke-direct {p0, p1, p4}, Ltv/freewheel/ad/AdRequest;->getFWId(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->ssId:Ljava/lang/String;

    .line 103
    invoke-direct {p0, p1, p4}, Ltv/freewheel/ad/AdRequest;->getCustomId(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdRequest;->ssCustomId:Ljava/lang/String;

    .line 104
    iput p2, p0, Ltv/freewheel/ad/AdRequest;->ssPageViewRandom:I

    .line 105
    iput p3, p0, Ltv/freewheel/ad/AdRequest;->ssNetworkId:I

    .line 106
    iput p5, p0, Ltv/freewheel/ad/AdRequest;->ssFallbackId:I

    .line 107
    return-void
.end method

.method public setVideoAsset(Ljava/lang/String;DLjava/lang/String;ZIIIIII)V
    .locals 4
    .param p1, "videoAssetId"    # Ljava/lang/String;
    .param p2, "duration"    # D
    .param p4, "location"    # Ljava/lang/String;
    .param p5, "autoPlay"    # Z
    .param p6, "videoPlayRandom"    # I
    .param p7, "networkId"    # I
    .param p8, "idType"    # I
    .param p9, "fallbackId"    # I
    .param p10, "durationType"    # I
    .param p11, "autoPlayType"    # I

    .prologue
    .line 116
    iget-object v1, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    .line 117
    .local v1, "oldVaId":Ljava/lang/String;
    iget-object v0, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    .line 119
    .local v0, "oldVaCustomId":Ljava/lang/String;
    invoke-direct {p0, p1, p8}, Ltv/freewheel/ad/AdRequest;->getFWId(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    .line 120
    invoke-direct {p0, p1, p8}, Ltv/freewheel/ad/AdRequest;->getCustomId(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    .line 122
    const-wide/16 v2, 0x0

    cmpl-double v2, p2, v2

    if-lez v2, :cond_3

    .end local p2    # "duration":D
    :goto_0
    iput-wide p2, p0, Ltv/freewheel/ad/AdRequest;->vaDuration:D

    .line 123
    iput-object p4, p0, Ltv/freewheel/ad/AdRequest;->vaMediaLocation:Ljava/lang/String;

    .line 124
    iput p6, p0, Ltv/freewheel/ad/AdRequest;->vaVideoPlayRandom:I

    .line 125
    iput p7, p0, Ltv/freewheel/ad/AdRequest;->vaNetworkId:I

    .line 126
    iput p9, p0, Ltv/freewheel/ad/AdRequest;->vaFallbackId:I

    .line 127
    packed-switch p10, :pswitch_data_0

    .line 137
    :goto_1
    packed-switch p11, :pswitch_data_1

    .line 146
    :goto_2
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaId:Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaCustomId:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 148
    :cond_1
    if-nez v1, :cond_4

    if-nez v0, :cond_4

    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v2, v2, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v2, v2, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    iget-object v2, v2, Ltv/freewheel/ad/VideoAsset;->state:Ltv/freewheel/ad/state/VideoState;

    invoke-static {}, Ltv/freewheel/ad/state/VideoPendingState;->Instance()Ltv/freewheel/ad/state/VideoState;

    move-result-object v3

    if-ne v2, v3, :cond_4

    .line 150
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v2, v2, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    iget-object v2, v2, Ltv/freewheel/ad/AdResponse;->videoAsset:Ltv/freewheel/ad/VideoAsset;

    invoke-virtual {v2}, Ltv/freewheel/ad/VideoAsset;->play()V

    .line 156
    :cond_2
    :goto_3
    return-void

    .line 122
    .restart local p2    # "duration":D
    :cond_3
    const-wide/16 p2, 0x0

    goto :goto_0

    .line 129
    .end local p2    # "duration":D
    :pswitch_0
    const-string v2, "VARIABLE"

    iput-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaDurationType:Ljava/lang/String;

    goto :goto_1

    .line 132
    :pswitch_1
    const-string v2, "EXACT"

    iput-object v2, p0, Ltv/freewheel/ad/AdRequest;->vaDurationType:Ljava/lang/String;

    goto :goto_1

    .line 141
    :pswitch_2
    iput p11, p0, Ltv/freewheel/ad/AdRequest;->vaAutoPlayType:I

    goto :goto_2

    .line 152
    :cond_4
    iget-object v2, p0, Ltv/freewheel/ad/AdRequest;->context:Ltv/freewheel/ad/AdContext;

    iget-object v2, v2, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    invoke-virtual {v2}, Ltv/freewheel/ad/AdResponse;->onVideoAssetChanged()V

    .line 153
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Ltv/freewheel/ad/AdRequest;->vaVideoAssetCurrentTimePosition:D

    goto :goto_3

    .line 127
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch

    .line 137
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_2
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method public toXML()Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 285
    invoke-virtual {p0}, Ltv/freewheel/ad/AdRequest;->buildXMLElement()Ltv/freewheel/utils/XMLElement;

    move-result-object v0

    invoke-static {v0}, Ltv/freewheel/utils/XMLHandler;->createXMLDocument(Ltv/freewheel/utils/XMLElement;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
