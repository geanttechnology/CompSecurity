.class Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AdvertisingJSONFactory"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->this$0:Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;-><init>(Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;)V

    return-void
.end method

.method private createAdClick(Lorg/json/JSONObject;)Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "click-info"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "click-info"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "title"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "url"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "id"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    invoke-direct {v0, v3, v1, v2}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    const-string v1, ""

    const-string v2, ""

    const-string v3, ""

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private createPrimaryAdAsset(Lorg/json/JSONObject;JI)Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    const/4 v6, 0x0

    const-string v0, "url"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v6}, Lcom/adobe/mediacore/MediaResource;->createFromUrl(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v4

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->createAdClick(Lorg/json/JSONObject;)Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v5

    move v1, p4

    move-wide v2, p2

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;-><init>(IJLcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/timeline/advertising/AdClick;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-object v0
.end method

.method private declared-synchronized getNextTimelineId()I
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->this$0:Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;

    # operator++ for: Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->_nextAvailableAdId:I
    invoke-static {v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;->access$108(Lcom/adobe/mediacore/timeline/advertising/MetadataResolver;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public createAd(Lorg/json/JSONObject;)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    const-string v0, "duration"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-wide/16 v2, -0x1

    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/utils/NumberUtils;->parseLong(Ljava/lang/String;J)J

    move-result-wide v2

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->getNextTimelineId()I

    move-result v4

    invoke-direct {p0, p1, v2, v3, v4}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->createPrimaryAdAsset(Lorg/json/JSONObject;JI)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v5

    sget-object v1, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    const/4 v7, 0x0

    invoke-static/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/Ad;->createAd(Lcom/adobe/mediacore/MediaResource$Type;JILcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    return-object v0
.end method

.method public createAdBreakPlacement(Lorg/json/JSONObject;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    const-wide/16 v8, 0x0

    const-string v0, "tag"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v0, "time"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-wide/16 v2, -0x1

    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/utils/NumberUtils;->parseNumber(Ljava/lang/String;J)J

    move-result-wide v2

    const-string v0, "replace"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v8, v9}, Lcom/adobe/mediacore/utils/NumberUtils;->parseNumber(Ljava/lang/String;J)J

    move-result-wide v4

    const-string v0, "ad-list"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->createAds(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v7

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    cmp-long v0, v2, v8

    if-nez v0, :cond_0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    new-instance v8, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-object v1, v7

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-direct {v8, v1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    return-object v8
.end method

.method public createAdBreakPlacements(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
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

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-lez v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->createAdBreakPlacement(Lorg/json/JSONObject;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public createAds(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-lez v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/adobe/mediacore/timeline/advertising/MetadataResolver$AdvertisingJSONFactory;->createAd(Lorg/json/JSONObject;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method
