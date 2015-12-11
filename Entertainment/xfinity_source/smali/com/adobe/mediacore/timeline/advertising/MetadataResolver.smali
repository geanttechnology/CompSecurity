.class public Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;
.super Lcom/adobe/mediacore/timeline/advertising/ContentResolver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$1;,
        Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;
    }
.end annotation


# static fields
.field private static final DEFAULT_POSTROLL_TIME:I = -0x2

.field private static final DEFAULT_PREROLL_TIME:I = 0x0

.field private static final JSON_METADATA_KEY:Ljava/lang/String; = "json_metadata"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final NODE_NAME_ADBREAK_ADLIST:Ljava/lang/String; = "ad-list"

.field private static final NODE_NAME_ADBREAK_REPLACE:Ljava/lang/String; = "replace"

.field private static final NODE_NAME_ADBREAK_TAG:Ljava/lang/String; = "tag"

.field private static final NODE_NAME_ADBREAK_TIME:Ljava/lang/String; = "time"

.field private static final NODE_NAME_AD_DURATION:Ljava/lang/String; = "duration"

.field private static final NODE_NAME_AD_TAG:Ljava/lang/String; = "tag"

.field private static final NODE_NAME_AD_URL:Ljava/lang/String; = "url"

.field private static final NODE_NAME_CLICK_INFO:Ljava/lang/String; = "click-info"

.field private static final NODE_NAME_ID:Ljava/lang/String; = "id"

.field private static final NODE_NAME_TITLE:Ljava/lang/String; = "title"

.field private static final NODE_NAME_URL:Ljava/lang/String; = "url"


# instance fields
.field private _availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

.field private _availableAdIterator:Ljava/util/Iterator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Iterator",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;"
        }
    .end annotation
.end field

.field private _linearTagIndex:J

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _nextAvailableAdId:I

.field private final _positionedAdBreakPlacements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[MetadataAd]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_positionedAdBreakPlacements:Ljava/util/List;

    iput-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iput-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_linearTagIndex:J

    const/16 v0, 0xbb8

    iput v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_nextAvailableAdId:I

    return-void
.end method

.method static synthetic access$108(Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;)I
    .locals 2

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_nextAvailableAdId:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_nextAvailableAdId:I

    return v0
.end method

.method private createAdBreakPlacementsFor(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation

    const-wide/16 v4, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#createAdBreakPlacementFor"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Input : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v2

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    if-eqz v1, :cond_2

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->getNextLinearTag()Ljava/lang/String;

    move-result-object v6

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    :goto_0
    cmp-long v7, v2, v4

    if-lez v7, :cond_1

    invoke-direct {p0, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->getAdForDuration(J)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v7

    if-eqz v7, :cond_0

    invoke-interface {v1, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v8

    sub-long/2addr v2, v8

    goto :goto_0

    :cond_0
    move-wide v2, v4

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#createAdBreakPlacementFor"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Output : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v2, v1, p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_2
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#createAdBreakPlacementFor"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Number of ad breaks returned : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private extractAdBreakPlacements(Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;-><init>(Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$1;)V

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->createAdBreakPlacements(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private extractMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/Metadata;
    .locals 2

    const/4 v0, 0x0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    instance-of v1, p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v1, :cond_0

    check-cast p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    goto :goto_0
.end method

.method private getAdForDuration(J)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 7

    const/4 v2, 0x0

    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    :cond_0
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_3

    if-nez v0, :cond_2

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v1

    iput-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    move v1, v0

    :goto_1
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    if-nez v0, :cond_4

    move-object v0, v2

    :cond_1
    return-object v0

    :cond_2
    iput-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    :cond_3
    move v1, v0

    goto :goto_1

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdIterator:Ljava/util/Iterator;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v4

    cmp-long v3, v4, p1

    if-lez v3, :cond_1

    move v0, v1

    goto :goto_0
.end method

.method private getNextLinearTag()Ljava/lang/String;
    .locals 4

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_linearTagIndex:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_linearTagIndex:J

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "linear_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_linearTagIndex:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private handleInvalidMetadata(Ljava/lang/Exception;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#handleInvalidMetadata"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_METADATA_INVALID:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Invalid JSON metadata."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "DESCRIPTION"

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method private isAlreadyPositioned(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Z
    .locals 4

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private processMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 7

    :try_start_0
    const-string v0, "json_metadata"

    invoke-interface {p1, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->extractAdBreakPlacements(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->isAlreadyPositioned(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_positionedAdBreakPlacements:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->handleInvalidMetadata(Ljava/lang/Exception;)V

    :cond_1
    :goto_1
    return-void

    :cond_2
    :try_start_1
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    :catch_1
    move-exception v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->handleInvalidMetadata(Ljava/lang/Exception;)V

    goto :goto_1

    :cond_3
    :try_start_2
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    const-wide/16 v2, -0x1

    const-wide/16 v4, 0x0

    const-string v6, "availableAdBreak"

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1
.end method


# virtual methods
.method protected doCanResolve(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z
    .locals 2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected doProvideAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method protected doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_positionedAdBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_availableAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    if-nez v0, :cond_1

    :cond_0
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->extractMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->processMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    :cond_1
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v1, :cond_3

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_positionedAdBreakPlacements:Ljava/util/List;

    :goto_0
    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->notifyResolveComplete(Ljava/util/List;)V

    return-void

    :cond_3
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v1, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_positionedAdBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_positionedAdBreakPlacements:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->cloneFor(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v3

    invoke-direct {v2, v1, v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_4
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    goto :goto_0

    :cond_5
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->createAdBreakPlacementsFor(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method
