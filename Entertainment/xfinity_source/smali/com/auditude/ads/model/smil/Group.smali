.class public Lcom/auditude/ads/model/smil/Group;
.super Ljava/lang/Object;
.source "Group.java"

# interfaces
.implements Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;
.implements Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;
.implements Lcom/auditude/ads/util/event/IEventListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;
    }
.end annotation


# instance fields
.field private adPluginEvents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/event/AdPluginEvent;",
            ">;"
        }
    .end annotation
.end field

.field private adSettings:Lcom/auditude/ads/core/AdSettings;

.field private duration:I

.field private index:I

.field private isWatched:Z

.field private maxDuration:I

.field private prefetchListener:Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;

.field private prefetchParCount:I

.field private repackageAssetCount:I

.field private repackageCreatives:Z

.field private repackagerArray:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/repackaging/AssetRepackager;",
            ">;"
        }
    .end annotation
.end field

.field private sequenceIteratorIndex:I

.field private sequenceList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Sequence;",
            ">;"
        }
    .end annotation
.end field

.field private skipCurrentSequence:Z

.field private startTime:I

.field private type:Lcom/auditude/ads/model/smil/SmilElementType;


# direct methods
.method public constructor <init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V
    .locals 2
    .param p1, "type"    # Lcom/auditude/ads/model/smil/SmilElementType;
    .param p2, "index"    # I
    .param p3, "adSettings"    # Lcom/auditude/ads/core/AdSettings;

    .prologue
    const/4 v1, 0x0

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-boolean v1, p0, Lcom/auditude/ads/model/smil/Group;->isWatched:Z

    .line 22
    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->maxDuration:I

    .line 23
    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->duration:I

    .line 24
    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->startTime:I

    .line 25
    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->index:I

    .line 26
    const/4 v0, -0x1

    iput v0, p0, Lcom/auditude/ads/model/smil/Group;->sequenceIteratorIndex:I

    .line 27
    invoke-static {}, Lcom/auditude/ads/model/smil/SmilElementType;->values()[Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v0

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Group;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    .line 30
    iput-boolean v1, p0, Lcom/auditude/ads/model/smil/Group;->skipCurrentSequence:Z

    .line 31
    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->prefetchParCount:I

    .line 35
    iput-boolean v1, p0, Lcom/auditude/ads/model/smil/Group;->repackageCreatives:Z

    .line 36
    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->repackageAssetCount:I

    .line 43
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Group;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 44
    iput p2, p0, Lcom/auditude/ads/model/smil/Group;->index:I

    .line 45
    iput-object p3, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    .line 46
    return-void
.end method

.method private notifyPrefetchComplete()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 373
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->prefetchListener:Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;

    if-eqz v0, :cond_0

    .line 375
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->prefetchListener:Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;

    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    invoke-interface {v0, v1}, Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;->onPrefetchComplete(Ljava/util/ArrayList;)V

    .line 376
    iput-object v2, p0, Lcom/auditude/ads/model/smil/Group;->prefetchListener:Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;

    .line 379
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 381
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 382
    iput-object v2, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    .line 384
    :cond_1
    return-void
.end method

.method private repackageIncompatibleCreatives()V
    .locals 14

    .prologue
    .line 392
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    sget-object v4, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-eq v1, v4, :cond_1

    .line 468
    :cond_0
    :goto_0
    return-void

    .line 397
    :cond_1
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    .line 398
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Group;->getRefs()Ljava/util/ArrayList;

    move-result-object v11

    .line 400
    .local v11, "refs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Ref;>;"
    if-eqz v11, :cond_a

    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_a

    .line 402
    const/4 v12, 0x0

    .line 403
    .local v12, "repackagingEnabled":Z
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    const-string v4, "repackageCreativeEnabled"

    invoke-virtual {v1, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 405
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    const-string v4, "repackageCreativeEnabled"

    invoke-virtual {v1, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v12

    .line 408
    :cond_2
    const-string v3, ""

    .line 409
    .local v3, "requiredFormat":Ljava/lang/String;
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    const-string v4, "repackageCreativeFormat"

    invoke-virtual {v1, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 411
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    const-string v4, "repackageCreativeFormat"

    invoke-virtual {v1, v4}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 414
    :cond_3
    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_9

    if-eqz v12, :cond_9

    .line 416
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    .line 417
    invoke-virtual {v11}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :cond_4
    :goto_1
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_5

    .line 446
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_8

    .line 448
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    iput v1, p0, Lcom/auditude/ads/model/smil/Group;->repackageAssetCount:I

    .line 449
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/auditude/ads/repackaging/AssetRepackager;

    .line 451
    .local v6, "assetRepackager":Lcom/auditude/ads/repackaging/AssetRepackager;
    invoke-virtual {v6}, Lcom/auditude/ads/repackaging/AssetRepackager;->repackage()V

    goto :goto_2

    .line 417
    .end local v6    # "assetRepackager":Lcom/auditude/ads/repackaging/AssetRepackager;
    :cond_5
    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/auditude/ads/model/smil/Ref;

    .line 419
    .local v10, "ref":Lcom/auditude/ads/model/smil/Ref;
    invoke-virtual {v10}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 421
    invoke-virtual {v10}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v2

    .line 422
    .local v2, "asset":Lcom/auditude/ads/model/Asset;
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    .line 423
    .local v7, "found":Ljava/lang/Boolean;
    invoke-virtual {v2}, Lcom/auditude/ads/model/Asset;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v9

    .line 424
    .local v9, "mediaFiles":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/media/MediaFile;>;"
    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_6
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_7

    .line 438
    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v2}, Lcom/auditude/ads/model/Asset;->getParent()Lcom/auditude/ads/model/BaseElement;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/Ad;

    invoke-virtual {v1}, Lcom/auditude/ads/model/Ad;->isRepackagingEnabled()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 440
    new-instance v0, Lcom/auditude/ads/repackaging/AssetRepackager;

    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v1}, Lcom/auditude/ads/core/AdSettings;->getDomain()Ljava/lang/String;

    move-result-object v4

    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->adSettings:Lcom/auditude/ads/core/AdSettings;

    invoke-virtual {v1}, Lcom/auditude/ads/core/AdSettings;->getZoneId()I

    move-result v5

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/repackaging/AssetRepackager;-><init>(Lcom/auditude/ads/repackaging/AssetRepackager$AssetRepackagingCompletionListener;Lcom/auditude/ads/model/Asset;Ljava/lang/String;Ljava/lang/String;I)V

    .line 441
    .local v0, "repackager":Lcom/auditude/ads/repackaging/AssetRepackager;
    iget-object v1, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 424
    .end local v0    # "repackager":Lcom/auditude/ads/repackaging/AssetRepackager;
    :cond_7
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/auditude/ads/model/media/MediaFile;

    .line 426
    .local v8, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    if-eqz v8, :cond_6

    .line 428
    iget-object v4, v8, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-static {v4}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 430
    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    iget-object v5, v8, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 432
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    goto :goto_3

    .line 456
    .end local v2    # "asset":Lcom/auditude/ads/model/Asset;
    .end local v7    # "found":Ljava/lang/Boolean;
    .end local v8    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    .end local v9    # "mediaFiles":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/media/MediaFile;>;"
    .end local v10    # "ref":Lcom/auditude/ads/model/smil/Ref;
    :cond_8
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Group;->notifyPrefetchComplete()V

    goto/16 :goto_0

    .line 461
    :cond_9
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Group;->notifyPrefetchComplete()V

    goto/16 :goto_0

    .line 466
    .end local v3    # "requiredFormat":Ljava/lang/String;
    .end local v12    # "repackagingEnabled":Z
    :cond_a
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Group;->notifyPrefetchComplete()V

    goto/16 :goto_0
.end method


# virtual methods
.method public final addSequence(Lcom/auditude/ads/model/smil/Sequence;)V
    .locals 2
    .param p1, "sequence"    # Lcom/auditude/ads/model/smil/Sequence;

    .prologue
    .line 186
    if-eqz p1, :cond_1

    .line 188
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 189
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getMaxDuration()I

    move-result v0

    if-ltz v0, :cond_0

    .line 191
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->maxDuration:I

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getMaxDuration()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/auditude/ads/model/smil/Group;->maxDuration:I

    .line 193
    :cond_0
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getDuration()I

    move-result v0

    if-ltz v0, :cond_1

    .line 195
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->duration:I

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getDuration()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/auditude/ads/model/smil/Group;->duration:I

    .line 198
    :cond_1
    return-void
.end method

.method public final getDescription()Ljava/util/HashMap;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    const/4 v2, 0x0

    .line 114
    .local v2, "playableDuration":I
    const/4 v1, 0x0

    .line 115
    .local v1, "playableAdCount":I
    iget-object v5, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_0

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 123
    .local v0, "description":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v5, "startTime"

    iget v6, p0, Lcom/auditude/ads/model/smil/Group;->startTime:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    const-string v5, "isEmpty"

    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Group;->isEmpty()Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    const-string v5, "breakDuration"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    const-string v5, "breakIndex"

    iget v6, p0, Lcom/auditude/ads/model/smil/Group;->index:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    const-string v5, "adCount"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    return-object v0

    .line 115
    .end local v0    # "description":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/auditude/ads/model/smil/Sequence;

    .line 117
    .local v4, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->getPlayableMetrics()Ljava/util/HashMap;

    move-result-object v3

    .line 118
    .local v3, "result":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v5, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_DURATION:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    add-int/2addr v2, v5

    .line 119
    sget-object v5, Lcom/auditude/ads/model/smil/Sequence;->PLAYABLE_AD_COUNT:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    add-int/2addr v1, v5

    goto :goto_0
.end method

.method public final getIndex()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->index:I

    return v0
.end method

.method public final getPars()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Par;",
            ">;"
        }
    .end annotation

    .prologue
    .line 303
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 304
    .local v1, "pars":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Par;>;"
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    if-eqz v3, :cond_0

    .line 306
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lt v0, v3, :cond_1

    .line 312
    .end local v0    # "i":I
    :cond_0
    return-object v1

    .line 308
    .restart local v0    # "i":I
    :cond_1
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/model/smil/Sequence;

    .line 309
    .local v2, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    invoke-virtual {v2}, Lcom/auditude/ads/model/smil/Sequence;->getPars()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 306
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public final getRefs()Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            ">;"
        }
    .end annotation

    .prologue
    .line 202
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 205
    .local v1, "result":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Ref;>;"
    iget-object v4, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 218
    return-object v1

    .line 205
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Sequence;

    .line 207
    .local v0, "aSequenceList":Lcom/auditude/ads/model/smil/Sequence;
    move-object v2, v0

    .line 208
    .local v2, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    if-eqz v2, :cond_0

    .line 210
    invoke-virtual {v2}, Lcom/auditude/ads/model/smil/Sequence;->getRefs()Ljava/util/ArrayList;

    move-result-object v3

    .line 211
    .local v3, "sequenceRefs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Ref;>;"
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 213
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method public final getSequenceList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Sequence;",
            ">;"
        }
    .end annotation

    .prologue
    .line 181
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getStartTime()I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->startTime:I

    return v0
.end method

.method public final getType()Lcom/auditude/ads/model/smil/SmilElementType;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    return-object v0
.end method

.method public final isEmpty()Z
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 161
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 176
    :cond_0
    :goto_0
    return v2

    .line 167
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 169
    iget-object v3, p0, Lcom/auditude/ads/model/smil/Group;->sequenceList:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/smil/Sequence;

    .line 170
    .local v1, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Sequence;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 172
    const/4 v2, 0x0

    goto :goto_0

    .line 167
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public final isLinear()Z
    .locals 2

    .prologue
    .line 60
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->type:Lcom/auditude/ads/model/smil/SmilElementType;

    sget-object v1, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final load(Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;Ljava/lang/Boolean;Ljava/util/HashMap;)V
    .locals 4
    .param p1, "prefetchListener"    # Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;
    .param p2, "repackageIncompatibleCreatives"    # Ljava/lang/Boolean;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;",
            "Ljava/lang/Boolean;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 326
    .local p3, "customParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/auditude/ads/model/smil/Group;->prefetchListener:Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;

    .line 327
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    iput-boolean v2, p0, Lcom/auditude/ads/model/smil/Group;->repackageCreatives:Z

    .line 329
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Group;->getPars()Ljava/util/ArrayList;

    move-result-object v1

    .line 330
    .local v1, "prefetchPars":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/smil/Par;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    iput v2, p0, Lcom/auditude/ads/model/smil/Group;->prefetchParCount:I

    .line 331
    iget v2, p0, Lcom/auditude/ads/model/smil/Group;->prefetchParCount:I

    if-lez v2, :cond_1

    .line 333
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 344
    :goto_1
    return-void

    .line 333
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Par;

    .line 335
    .local v0, "par":Lcom/auditude/ads/model/smil/Par;
    const-string v3, "error"

    invoke-virtual {v0, v3, p0}, Lcom/auditude/ads/model/smil/Par;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 336
    invoke-virtual {v0, p0}, Lcom/auditude/ads/model/smil/Par;->setParResolutionCompleteListener(Lcom/auditude/ads/model/smil/Par$ParResoultionCompleteListener;)V

    .line 337
    invoke-virtual {v0, p3}, Lcom/auditude/ads/model/smil/Par;->resolve(Ljava/util/HashMap;)V

    goto :goto_0

    .line 342
    .end local v0    # "par":Lcom/auditude/ads/model/smil/Par;
    :cond_1
    invoke-virtual {p0}, Lcom/auditude/ads/model/smil/Group;->onParResolutionComplete()V

    goto :goto_1
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 348
    instance-of v0, p2, Lcom/auditude/ads/event/AdPluginEvent;

    if-eqz v0, :cond_1

    .line 350
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    .line 351
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->adPluginEvents:Ljava/util/ArrayList;

    check-cast p2, Lcom/auditude/ads/event/AdPluginEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 353
    :cond_1
    return-void
.end method

.method public onParResolutionComplete()V
    .locals 1

    .prologue
    .line 357
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->prefetchParCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/auditude/ads/model/smil/Group;->prefetchParCount:I

    .line 358
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->prefetchParCount:I

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/model/smil/Group;->prefetchListener:Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;

    if-eqz v0, :cond_0

    .line 360
    iget-boolean v0, p0, Lcom/auditude/ads/model/smil/Group;->repackageCreatives:Z

    if-eqz v0, :cond_1

    .line 362
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Group;->repackageIncompatibleCreatives()V

    .line 369
    :cond_0
    :goto_0
    return-void

    .line 366
    :cond_1
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Group;->notifyPrefetchComplete()V

    goto :goto_0
.end method

.method public onRepackagingComplete(Lcom/auditude/ads/model/Asset;Z)V
    .locals 1
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .param p2, "success"    # Z

    .prologue
    .line 472
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->repackageAssetCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/auditude/ads/model/smil/Group;->repackageAssetCount:I

    .line 474
    iget v0, p0, Lcom/auditude/ads/model/smil/Group;->repackageAssetCount:I

    if-gtz v0, :cond_0

    .line 476
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/model/smil/Group;->repackagerArray:Ljava/util/ArrayList;

    .line 477
    invoke-direct {p0}, Lcom/auditude/ads/model/smil/Group;->notifyPrefetchComplete()V

    .line 479
    :cond_0
    return-void
.end method

.method public final setStartTime(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 78
    iput p1, p0, Lcom/auditude/ads/model/smil/Group;->startTime:I

    .line 79
    return-void
.end method
