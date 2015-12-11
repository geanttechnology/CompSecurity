.class public Lcom/auditude/ads/response/AuditudeResponseParser;
.super Ljava/lang/Object;
.source "AuditudeResponseParser.java"

# interfaces
.implements Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;
.implements Lcom/auditude/ads/response/IResponseParser;


# static fields
.field private static CRENABLED:Ljava/lang/String;

.field private static SCR:Ljava/lang/String;


# instance fields
.field private adRequest:Lcom/auditude/ads/loader/AdRequest;

.field private adResponse:Lcom/auditude/ads/response/AdResponse;

.field private ads:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/auditude/ads/model/Ad;",
            ">;"
        }
    .end annotation
.end field

.field private breaks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Group;",
            ">;"
        }
    .end annotation
.end field

.field private chapters:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/smil/Group;",
            ">;"
        }
    .end annotation
.end field

.field private dataLoader:Lcom/auditude/ads/loader/DataLoader;

.field private listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

.field private parser:Lorg/xmlpull/v1/XmlPullParser;

.field private refs:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/auditude/ads/model/smil/Ref;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private submissions:Lcom/auditude/ads/model/tracking/Submissions;

.field private timeout:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 61
    const-string v0, "scr"

    sput-object v0, Lcom/auditude/ads/response/AuditudeResponseParser;->SCR:Ljava/lang/String;

    .line 62
    const-string v0, "crenabled"

    sput-object v0, Lcom/auditude/ads/response/AuditudeResponseParser;->CRENABLED:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    new-instance v0, Lcom/auditude/ads/model/tracking/Submissions;

    invoke-direct {v0}, Lcom/auditude/ads/model/tracking/Submissions;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->breaks:Ljava/util/ArrayList;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->chapters:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->ads:Ljava/util/HashMap;

    .line 59
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->refs:Ljava/util/HashMap;

    .line 44
    return-void
.end method

.method private GetAssetForType(Ljava/lang/String;Lcom/auditude/ads/model/BaseElement;)Lcom/auditude/ads/model/Asset;
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "parent"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    .line 933
    const-string v0, "linear"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 935
    new-instance v0, Lcom/auditude/ads/model/LinearAsset;

    invoke-direct {v0, p2}, Lcom/auditude/ads/model/LinearAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 947
    :goto_0
    return-object v0

    .line 937
    :cond_0
    const-string v0, "nonlinear"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 939
    new-instance v0, Lcom/auditude/ads/model/NonLinearAsset;

    invoke-direct {v0, p2}, Lcom/auditude/ads/model/NonLinearAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    goto :goto_0

    .line 941
    :cond_1
    const-string v0, "companion"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 943
    new-instance v0, Lcom/auditude/ads/model/OnPageAsset;

    invoke-direct {v0, p2}, Lcom/auditude/ads/model/OnPageAsset;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    goto :goto_0

    .line 947
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private NotifyError(Ljava/lang/String;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/String;

    .prologue
    .line 954
    return-void
.end method

.method private applyAdsOnRefs()V
    .locals 6

    .prologue
    .line 175
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->refs:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 190
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->refs:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->clear()V

    .line 191
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->refs:Ljava/util/HashMap;

    .line 192
    return-void

    .line 175
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 177
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Lcom/auditude/ads/model/smil/Ref;Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/model/smil/Ref;

    .line 178
    .local v3, "reff":Lcom/auditude/ads/model/smil/Ref;
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 180
    .local v1, "adId":Ljava/lang/String;
    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    iget-object v5, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->ads:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 182
    iget-object v5, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->ads:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Ad;

    .line 183
    .local v0, "ad":Lcom/auditude/ads/model/Ad;
    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/smil/Ref;->setAd(Lcom/auditude/ads/model/Ad;)V

    .line 185
    invoke-virtual {v3}, Lcom/auditude/ads/model/smil/Ref;->getID()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/auditude/ads/model/Ad;->getAssetsBySegment(Ljava/lang/String;)[Lcom/auditude/ads/model/Asset;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/auditude/ads/model/smil/Ref;->setAssets([Lcom/auditude/ads/model/Asset;)V

    goto :goto_0
.end method

.method private hasMimeType(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/Boolean;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/model/Asset;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/Boolean;"
        }
    .end annotation

    .prologue
    .line 596
    .local p1, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    .local p2, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz p1, :cond_1

    .line 598
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_2

    .line 605
    :cond_1
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    :goto_0
    return-object v1

    .line 598
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Asset;

    .line 599
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    invoke-virtual {v0, p2}, Lcom/auditude/ads/model/Asset;->hasAssetsWithMimeType(Ljava/util/ArrayList;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 601
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    goto :goto_0
.end method

.method private parseAd()V
    .locals 25
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 430
    new-instance v3, Lcom/auditude/ads/model/Ad;

    const/16 v22, 0x0

    move-object/from16 v0, v22

    invoke-direct {v3, v0}, Lcom/auditude/ads/model/Ad;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 431
    .local v3, "ad":Lcom/auditude/ads/model/Ad;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    const-string v23, "id"

    const/16 v24, 0x0

    invoke-static/range {v22 .. v24}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/Ad;->setID(Ljava/lang/String;)V

    .line 433
    const/16 v18, 0x0

    .line 434
    .local v18, "segments":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/ArrayList<Ljava/lang/String;>;>;"
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 435
    .local v5, "assetData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    .line 436
    .local v11, "customData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;[Ljava/lang/String;>;"
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 439
    .local v9, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v13

    .line 442
    .local v13, "eventType":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v20

    .line 443
    .local v20, "tag":Ljava/lang/String;
    const/16 v22, 0x2

    move/from16 v0, v22

    if-ne v13, v0, :cond_a

    .line 445
    const-string v22, "wrapper"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_1

    .line 447
    const/16 v22, 0x1

    move/from16 v0, v22

    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/Ad;->setIsNetworkAd(Z)V

    .line 448
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    const-string v24, "adSystem"

    invoke-interface/range {v22 .. v24}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/Ad;->setNetworkAdType(Ljava/lang/String;)V

    .line 449
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    const-string v24, "adTagURI"

    invoke-interface/range {v22 .. v24}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/Ad;->setNetworkAdSource(Ljava/lang/Object;)V

    .line 541
    :cond_0
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v13

    .line 440
    goto :goto_0

    .line 451
    :cond_1
    const-string v22, "behavior"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_3

    .line 453
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    const-string v23, "type"

    const/16 v24, 0x0

    invoke-static/range {v22 .. v24}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 454
    .local v10, "behaviorType":Ljava/lang/String;
    if-eqz v10, :cond_0

    .line 456
    sget-object v22, Lcom/auditude/ads/response/AuditudeResponseParser;->SCR:Ljava/lang/String;

    move-object/from16 v0, v22

    invoke-virtual {v10, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-nez v22, :cond_0

    .line 460
    sget-object v22, Lcom/auditude/ads/response/AuditudeResponseParser;->CRENABLED:Ljava/lang/String;

    move-object/from16 v0, v22

    invoke-virtual {v10, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_2

    .line 462
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v22 .. v22}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v22

    move/from16 v0, v22

    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/Ad;->setRepackagingEnabled(Z)V

    goto :goto_1

    .line 466
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v22

    const-string v23, "&"

    const-string v24, "="

    invoke-static/range {v22 .. v24}, Lcom/auditude/ads/util/StringUtil;->ConvertToKeysAndValues(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v5, v10, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 470
    .end local v10    # "behaviorType":Ljava/lang/String;
    :cond_3
    const-string v22, "submission"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_4

    .line 472
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSubmission(Lcom/auditude/ads/model/BaseElement;)V

    goto :goto_1

    .line 474
    :cond_4
    const-string v22, "asset"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_8

    .line 476
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseAsset(Lcom/auditude/ads/model/Ad;)Lcom/auditude/ads/model/Asset;

    move-result-object v4

    .line 477
    .local v4, "asset":Lcom/auditude/ads/model/Asset;
    if-eqz v4, :cond_0

    .line 479
    invoke-virtual {v3}, Lcom/auditude/ads/model/Ad;->getIsNetworkAd()Z

    move-result v22

    if-eqz v22, :cond_7

    .line 481
    invoke-virtual {v3, v4}, Lcom/auditude/ads/model/Ad;->addTrackingAsset(Lcom/auditude/ads/model/Asset;)V

    .line 482
    instance-of v0, v4, Lcom/auditude/ads/model/ILinearAsset;

    move/from16 v22, v0

    if-nez v22, :cond_5

    instance-of v0, v4, Lcom/auditude/ads/model/INonLinearAsset;

    move/from16 v22, v0

    if-eqz v22, :cond_6

    .line 484
    :cond_5
    invoke-virtual {v4}, Lcom/auditude/ads/model/Asset;->getAuditudeParams()Ljava/util/HashMap;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v3, v0}, Lcom/auditude/ads/model/Ad;->setAuditudeParams(Ljava/util/HashMap;)V

    .line 486
    :cond_6
    instance-of v0, v4, Lcom/auditude/ads/model/OnPageAsset;

    move/from16 v22, v0

    if-eqz v22, :cond_0

    .line 488
    new-instance v19, Lcom/auditude/ads/model/tracking/ParStateSubmission;

    invoke-virtual {v4}, Lcom/auditude/ads/model/Asset;->getUrl()Ljava/lang/String;

    move-result-object v22

    const-string v23, "creativeview"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/model/tracking/ParStateSubmission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 489
    .local v19, "submission":Lcom/auditude/ads/model/tracking/ParStateSubmission;
    const-string v22, "creativeview"

    move-object/from16 v0, v19

    move-object/from16 v1, v22

    invoke-virtual {v4, v0, v1}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 494
    .end local v19    # "submission":Lcom/auditude/ads/model/tracking/ParStateSubmission;
    :cond_7
    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 498
    .end local v4    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_8
    const-string v22, "customdata"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_9

    .line 500
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    const-string v23, "type"

    const/16 v24, 0x0

    invoke-static/range {v22 .. v24}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 501
    .local v21, "value":Ljava/lang/String;
    if-eqz v21, :cond_0

    .line 503
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    move-object/from16 v22, v0

    invoke-interface/range {v22 .. v22}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v22

    const-string v23, "&"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-virtual {v11, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    .line 506
    .end local v21    # "value":Ljava/lang/String;
    :cond_9
    const-string v22, "smil"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_0

    .line 508
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseAdSmil(Lcom/auditude/ads/model/Ad;)Ljava/util/HashMap;

    move-result-object v18

    .line 510
    goto/16 :goto_1

    .line 511
    :cond_a
    const/16 v22, 0x3

    move/from16 v0, v22

    if-ne v13, v0, :cond_0

    .line 513
    const-string v22, "ad"

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_0

    .line 515
    invoke-virtual {v3}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v22 .. v22}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v22

    if-nez v22, :cond_d

    .line 518
    const/16 v17, 0x0

    .line 519
    .local v17, "repackageCreativeEnabled":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v22

    const-string v23, "repackageCreativeEnabled"

    invoke-virtual/range {v22 .. v23}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v22

    if-eqz v22, :cond_b

    .line 521
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v22

    const-string v23, "repackageCreativeEnabled"

    invoke-virtual/range {v22 .. v23}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v22 .. v22}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v17

    .line 523
    :cond_b
    invoke-virtual {v3}, Lcom/auditude/ads/model/Ad;->getIsNetworkAd()Z

    move-result v22

    if-nez v22, :cond_c

    if-eqz v17, :cond_10

    .line 525
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->ads:Ljava/util/HashMap;

    move-object/from16 v22, v0

    invoke-virtual {v3}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 545
    .end local v17    # "repackageCreativeEnabled":Z
    :cond_d
    :goto_2
    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .line 546
    .local v14, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/model/Asset;>;"
    :goto_3
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v22

    if-nez v22, :cond_12

    .line 561
    if-eqz v18, :cond_f

    .line 563
    invoke-virtual/range {v18 .. v18}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v22

    invoke-interface/range {v22 .. v22}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v23

    :cond_e
    :goto_4
    invoke-interface/range {v23 .. v23}, Ljava/util/Iterator;->hasNext()Z

    move-result v22

    if-nez v22, :cond_14

    .line 586
    :cond_f
    invoke-virtual {v5}, Ljava/util/HashMap;->clear()V

    .line 587
    const/4 v5, 0x0

    .line 589
    invoke-virtual {v9}, Ljava/util/ArrayList;->clear()V

    .line 590
    const/4 v9, 0x0

    .line 591
    const/4 v4, 0x0

    .line 592
    .restart local v4    # "asset":Lcom/auditude/ads/model/Asset;
    return-void

    .line 529
    .end local v4    # "asset":Lcom/auditude/ads/model/Asset;
    .end local v14    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/model/Asset;>;"
    .restart local v17    # "repackageCreativeEnabled":Z
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v22

    const-string v23, "validMimeTypes"

    invoke-virtual/range {v22 .. v23}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/util/ArrayList;

    .line 530
    .local v16, "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz v16, :cond_11

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v9, v1}, Lcom/auditude/ads/response/AuditudeResponseParser;->hasMimeType(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/Boolean;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v22

    if-eqz v22, :cond_d

    .line 532
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/auditude/ads/response/AuditudeResponseParser;->ads:Ljava/util/HashMap;

    move-object/from16 v22, v0

    invoke-virtual {v3}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 548
    .end local v16    # "mimeTypes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v17    # "repackageCreativeEnabled":Z
    .restart local v14    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/auditude/ads/model/Asset;>;"
    :cond_12
    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/auditude/ads/model/Asset;

    .line 549
    .restart local v4    # "asset":Lcom/auditude/ads/model/Asset;
    invoke-virtual {v4}, Lcom/auditude/ads/model/Asset;->getID()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v22

    if-eqz v22, :cond_13

    .line 551
    invoke-virtual {v4}, Lcom/auditude/ads/model/Asset;->getID()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/HashMap;

    .line 552
    .local v6, "assetExtensionData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v6, :cond_13

    const-string v22, "format"

    move-object/from16 v0, v22

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v22

    if-eqz v22, :cond_13

    .line 554
    const-string v22, "format"

    move-object/from16 v0, v22

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Ljava/lang/String;

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lcom/auditude/ads/model/Asset;->setFormat(Ljava/lang/String;)V

    .line 557
    .end local v6    # "assetExtensionData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_13
    invoke-virtual {v4, v11}, Lcom/auditude/ads/model/Asset;->setCustomData(Ljava/util/HashMap;)V

    .line 558
    invoke-virtual {v3, v4}, Lcom/auditude/ads/model/Ad;->addAsset(Lcom/auditude/ads/model/Asset;)V

    goto/16 :goto_3

    .line 563
    .end local v4    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_14
    invoke-interface/range {v23 .. v23}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/Map$Entry;

    .line 565
    .local v12, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/ArrayList<Ljava/lang/String;>;>;"
    invoke-interface {v12}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 566
    .local v15, "key":Ljava/lang/String;
    invoke-interface {v12}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/ArrayList;

    .line 567
    .local v8, "assetIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v9, Ljava/util/ArrayList;

    .end local v9    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 569
    .restart local v9    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/auditude/ads/model/Asset;>;"
    invoke-static {v15}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_e

    .line 571
    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :cond_15
    :goto_5
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v24

    if-nez v24, :cond_16

    .line 580
    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v22

    move/from16 v0, v22

    new-array v0, v0, [Lcom/auditude/ads/model/Asset;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v22

    check-cast v22, [Lcom/auditude/ads/model/Asset;

    move-object/from16 v0, v22

    invoke-virtual {v3, v15, v0}, Lcom/auditude/ads/model/Ad;->addSegmentById(Ljava/lang/String;[Lcom/auditude/ads/model/Asset;)V

    goto/16 :goto_4

    .line 571
    :cond_16
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 573
    .local v7, "assetId":Ljava/lang/String;
    invoke-virtual {v3, v7}, Lcom/auditude/ads/model/Ad;->getAssetById(Ljava/lang/String;)Lcom/auditude/ads/model/Asset;

    move-result-object v4

    .line 574
    .restart local v4    # "asset":Lcom/auditude/ads/model/Asset;
    if-eqz v4, :cond_15

    .line 576
    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_5
.end method

.method private parseAdSmil(Lcom/auditude/ads/model/Ad;)Ljava/util/HashMap;
    .locals 14
    .param p1, "ad"    # Lcom/auditude/ads/model/Ad;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/Ad;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v13, 0x0

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 610
    const/4 v3, 0x0

    .line 611
    .local v3, "id":Ljava/lang/String;
    const/4 v1, 0x0

    .line 612
    .local v1, "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 614
    .local v5, "segments":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/util/ArrayList<Ljava/lang/String;>;>;"
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v8}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    .line 617
    .local v2, "eventType":I
    :goto_0
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v8}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    .line 619
    .local v7, "tag":Ljava/lang/String;
    if-ne v2, v12, :cond_4

    .line 621
    const-string v8, "par"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 623
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v9, "id"

    invoke-static {v8, v9, v13}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 624
    new-instance v1, Ljava/util/ArrayList;

    .end local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 667
    .restart local v1    # "assets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_0
    :goto_1
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v8}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    .line 615
    goto :goto_0

    .line 626
    :cond_1
    const-string v8, "ref"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 628
    const/4 v0, 0x0

    .line 629
    .local v0, "asset":Ljava/lang/String;
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v9, "asset"

    invoke-static {v8, v9, v13}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 630
    .local v6, "source":Ljava/lang/String;
    invoke-static {v6}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 632
    const-string v8, "\\."

    invoke-virtual {v6, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 633
    .local v4, "parts":[Ljava/lang/String;
    array-length v8, v4

    if-ne v8, v11, :cond_3

    .line 635
    aget-object v0, v4, v10

    .line 645
    :cond_2
    :goto_2
    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 647
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 637
    :cond_3
    array-length v8, v4

    if-ne v8, v12, :cond_2

    .line 639
    invoke-virtual {p1}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v8

    aget-object v9, v4, v10

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 641
    aget-object v0, v4, v11

    goto :goto_2

    .line 652
    .end local v0    # "asset":Ljava/lang/String;
    .end local v4    # "parts":[Ljava/lang/String;
    .end local v6    # "source":Ljava/lang/String;
    :cond_4
    const/4 v8, 0x3

    if-ne v2, v8, :cond_0

    .line 654
    const-string v8, "par"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 656
    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 658
    invoke-virtual {v5, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 661
    :cond_5
    const-string v8, "smil"

    invoke-virtual {v8, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 670
    return-object v5
.end method

.method private parseAsset(Lcom/auditude/ads/model/Ad;)Lcom/auditude/ads/model/Asset;
    .locals 11
    .param p1, "ad"    # Lcom/auditude/ads/model/Ad;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v7, 0x0

    .line 675
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v9, "contentType"

    invoke-static {v8, v9, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v8, p1}, Lcom/auditude/ads/response/AuditudeResponseParser;->GetAssetForType(Ljava/lang/String;Lcom/auditude/ads/model/BaseElement;)Lcom/auditude/ads/model/Asset;

    move-result-object v0

    .line 676
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    if-nez v0, :cond_1

    move-object v0, v7

    .line 757
    .end local v0    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_0
    :goto_0
    return-object v0

    .line 678
    .restart local v0    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_1
    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v9, "id"

    invoke-static {v8, v9, v7}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->setID(Ljava/lang/String;)V

    .line 679
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v8, "runtime"

    invoke-static {v7, v8, v10}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v7

    mul-int/lit16 v7, v7, 0x3e8

    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->setDurationInMillis(I)V

    .line 680
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v8, "timeOffset"

    const/16 v9, 0xf

    invoke-static {v7, v8, v9}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v7

    mul-int/lit16 v7, v7, 0x3e8

    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->setLeadTimeInMillis(I)V

    .line 683
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v8, "parameters"

    const-string v9, ""

    invoke-static {v7, v8, v9}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "&"

    const-string v9, "="

    invoke-static {v7, v8, v9}, Lcom/auditude/ads/util/StringUtil;->ConvertToKeysAndValues(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    .line 684
    .local v1, "audParam":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lcom/auditude/ads/model/Ad;->getNetworkAdType()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_2

    invoke-virtual {p1}, Lcom/auditude/ads/model/Ad;->getNetworkAdType()Ljava/lang/String;

    move-result-object v7

    const-string v8, "VMAP"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v7, "daisy_chaining"

    invoke-virtual {v1, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 686
    const-string v7, "daisy_chaining"

    invoke-virtual {v1, v7}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 688
    :cond_2
    invoke-virtual {v0, v1}, Lcom/auditude/ads/model/Asset;->setAuditudeParams(Ljava/util/HashMap;)V

    .line 690
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    .line 693
    .local v2, "eventType":I
    :goto_1
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 694
    .local v4, "tag":Ljava/lang/String;
    const/4 v7, 0x2

    if-ne v2, v7, :cond_8

    .line 696
    const-string v7, "mediaFile"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 698
    invoke-direct {p0, v0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseMediaFile(Lcom/auditude/ads/model/Asset;)Lcom/auditude/ads/model/media/MediaFile;

    move-result-object v3

    .line 699
    .local v3, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    if-eqz v3, :cond_3

    .line 701
    iget-object v7, v3, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->setCreativeType(Ljava/lang/String;)V

    .line 702
    const-string v7, "text/html"

    iget-object v8, v3, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_4

    const-string v7, "iframe"

    :goto_2
    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->setResourceType(Ljava/lang/String;)V

    .line 703
    invoke-virtual {v0, v3}, Lcom/auditude/ads/model/Asset;->AddMediaFile(Lcom/auditude/ads/model/media/MediaFile;)V

    .line 727
    .end local v3    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    :cond_3
    :goto_3
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    .line 691
    goto :goto_1

    .line 702
    .restart local v3    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    :cond_4
    const-string v7, "static"

    goto :goto_2

    .line 706
    .end local v3    # "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    :cond_5
    const-string v7, "click"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 708
    invoke-direct {p0, v0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseClick(Lcom/auditude/ads/model/Asset;)V

    goto :goto_3

    .line 710
    :cond_6
    const-string v7, "tracking"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 712
    invoke-direct {p0, v0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseTracking(Lcom/auditude/ads/model/Asset;)V

    goto :goto_3

    .line 714
    :cond_7
    const-string v7, "submission"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 716
    invoke-direct {p0, v0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSubmission(Lcom/auditude/ads/model/BaseElement;)V

    goto :goto_3

    .line 719
    :cond_8
    const/4 v7, 0x3

    if-ne v2, v7, :cond_3

    .line 721
    const-string v7, "asset"

    invoke-virtual {v7, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 731
    const-string v7, "linear"

    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getType()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 733
    const-string v7, "creativeprogress"

    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v5

    .line 734
    .local v5, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v5, :cond_9

    invoke-virtual {v5}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v7

    if-eqz v7, :cond_9

    invoke-virtual {v5}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lez v7, :cond_9

    .line 736
    invoke-virtual {v5}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 737
    .local v6, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    if-eqz v6, :cond_9

    .line 739
    new-instance v7, Lcom/auditude/ads/model/tracking/Submission;

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v8

    const-string v9, "start"

    invoke-direct {v7, v8, v9}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v8, "start"

    invoke-virtual {v0, v7, v8}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 740
    new-instance v7, Lcom/auditude/ads/model/tracking/Submission;

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v8

    const-string v9, "firstquartile"

    invoke-direct {v7, v8, v9}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v8, "firstquartile"

    invoke-virtual {v0, v7, v8}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 741
    new-instance v7, Lcom/auditude/ads/model/tracking/Submission;

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v8

    const-string v9, "midpoint"

    invoke-direct {v7, v8, v9}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v8, "midpoint"

    invoke-virtual {v0, v7, v8}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 742
    new-instance v7, Lcom/auditude/ads/model/tracking/Submission;

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v8

    const-string v9, "thirdquartile"

    invoke-direct {v7, v8, v9}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v8, "thirdquartile"

    invoke-virtual {v0, v7, v8}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 743
    new-instance v7, Lcom/auditude/ads/model/tracking/Submission;

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v8

    const-string v9, "complete"

    invoke-direct {v7, v8, v9}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v8, "complete"

    invoke-virtual {v0, v7, v8}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 749
    .end local v5    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    .end local v6    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_9
    instance-of v7, v0, Lcom/auditude/ads/model/OnPageAsset;

    if-eqz v7, :cond_0

    .line 751
    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 753
    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v7

    check-cast v7, Lcom/auditude/ads/model/Click;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Lcom/auditude/ads/model/Click;->setShouldAppendParState(Z)V

    goto/16 :goto_0
.end method

.method private parseClick(Lcom/auditude/ads/model/Asset;)V
    .locals 6
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 832
    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Click;

    .line 833
    .local v0, "click":Lcom/auditude/ads/model/Click;
    if-nez v0, :cond_0

    .line 835
    new-instance v0, Lcom/auditude/ads/model/Click;

    .end local v0    # "click":Lcom/auditude/ads/model/Click;
    invoke-direct {v0, p1}, Lcom/auditude/ads/model/Click;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 836
    .restart local v0    # "click":Lcom/auditude/ads/model/Click;
    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setClick(Lcom/auditude/ads/model/IClick;)V

    .line 839
    :cond_0
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "href"

    invoke-static {v3, v4, v5}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/model/Click;->setUrl(Ljava/lang/String;)V

    .line 840
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "title"

    invoke-static {v3, v4, v5}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/model/Click;->setTitle(Ljava/lang/String;)V

    .line 841
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v4, "id"

    invoke-static {v3, v4, v5}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/auditude/ads/model/Click;->setID(Ljava/lang/String;)V

    .line 844
    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->isNetworkAd()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 846
    new-instance v3, Lcom/auditude/ads/model/tracking/TrackingUrl;

    invoke-virtual {v0}, Lcom/auditude/ads/model/Click;->getUrl()Ljava/lang/String;

    move-result-object v4

    const-string v5, "click"

    invoke-direct {v3, v4, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "click"

    invoke-virtual {v0, v3, v4}, Lcom/auditude/ads/model/Click;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 850
    :cond_1
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    move-result v1

    .line 851
    .local v1, "eventType":I
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 852
    .local v2, "tag":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v1, v3, :cond_2

    .line 854
    const-string v3, "submission"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 856
    invoke-direct {p0, v0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSubmission(Lcom/auditude/ads/model/BaseElement;)V

    goto :goto_0

    .line 859
    :cond_2
    const/4 v3, 0x3

    if-ne v1, v3, :cond_1

    const-string v3, "click"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 864
    return-void
.end method

.method private parseMediaFile(Lcom/auditude/ads/model/Asset;)Lcom/auditude/ads/model/media/MediaFile;
    .locals 5
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 820
    new-instance v0, Lcom/auditude/ads/model/media/MediaFile;

    invoke-direct {v0}, Lcom/auditude/ads/model/media/MediaFile;-><init>()V

    .line 822
    .local v0, "mediaFile":Lcom/auditude/ads/model/media/MediaFile;
    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v2, "src"

    invoke-static {v1, v2, v4}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    .line 823
    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v2, "width"

    invoke-static {v1, v2, v3}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v1

    iput v1, v0, Lcom/auditude/ads/model/media/MediaFile;->width:I

    .line 824
    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v2, "height"

    invoke-static {v1, v2, v3}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v1

    iput v1, v0, Lcom/auditude/ads/model/media/MediaFile;->height:I

    .line 825
    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v2, "type"

    invoke-static {v1, v2, v4}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    .line 827
    return-object v0
.end method

.method private parsePar()Lcom/auditude/ads/model/smil/Par;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 354
    new-instance v2, Lcom/auditude/ads/model/smil/Par;

    invoke-direct {v2}, Lcom/auditude/ads/model/smil/Par;-><init>()V

    .line 356
    .local v2, "par":Lcom/auditude/ads/model/smil/Par;
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 359
    .local v0, "eventType":I
    :goto_0
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v5

    .line 361
    .local v5, "tag":Ljava/lang/String;
    const/4 v6, 0x2

    if-ne v0, v6, :cond_3

    .line 363
    const-string v6, "meta"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 365
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "name"

    const-string v8, ""

    invoke-static {v6, v7, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 366
    .local v1, "metaName":Ljava/lang/String;
    const-string v6, "priority"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 368
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "content"

    const/4 v8, 0x0

    invoke-static {v6, v7, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v6

    invoke-virtual {v2, v6}, Lcom/auditude/ads/model/smil/Par;->setPriority(I)V

    .line 396
    .end local v1    # "metaName":Ljava/lang/String;
    :cond_0
    :goto_1
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 357
    goto :goto_0

    .line 371
    :cond_1
    const-string v6, "setvalue"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 373
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "ref"

    const/4 v8, 0x0

    invoke-static {v6, v7, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 374
    .local v4, "setvalueKey":Ljava/lang/String;
    invoke-static {v4}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 376
    iget-object v6, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v7, "value"

    const-string v8, ""

    invoke-static {v6, v7, v8}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v4, v6}, Lcom/auditude/ads/model/smil/Par;->addState(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 379
    .end local v4    # "setvalueKey":Ljava/lang/String;
    :cond_2
    const-string v6, "ref"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 381
    invoke-direct {p0, v2}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseRef(Lcom/auditude/ads/model/smil/Par;)Lcom/auditude/ads/model/smil/Ref;

    move-result-object v3

    .line 382
    .local v3, "reff":Lcom/auditude/ads/model/smil/Ref;
    if-eqz v3, :cond_0

    .line 384
    invoke-virtual {v2, v3}, Lcom/auditude/ads/model/smil/Par;->addRef(Lcom/auditude/ads/model/smil/Ref;)V

    goto :goto_1

    .line 388
    .end local v3    # "reff":Lcom/auditude/ads/model/smil/Ref;
    :cond_3
    const/4 v6, 0x3

    if-ne v0, v6, :cond_0

    .line 390
    const-string v6, "par"

    invoke-virtual {v6, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 399
    return-object v2
.end method

.method private parseRef(Lcom/auditude/ads/model/smil/Par;)Lcom/auditude/ads/model/smil/Ref;
    .locals 6
    .param p1, "par"    # Lcom/auditude/ads/model/smil/Par;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 404
    new-instance v1, Lcom/auditude/ads/model/smil/Ref;

    invoke-direct {v1, p1}, Lcom/auditude/ads/model/smil/Ref;-><init>(Lcom/auditude/ads/model/smil/Par;)V

    .line 406
    .local v1, "reff":Lcom/auditude/ads/model/smil/Ref;
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const/4 v4, 0x0

    const-string v5, "src"

    invoke-interface {v3, v4, v5}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 407
    .local v2, "source":Ljava/lang/String;
    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "urn:ad:"

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_0

    .line 409
    new-instance v3, Ljava/lang/String;

    const-string v4, "urn:ad:"

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 412
    const-string v3, "#"

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    if-lez v3, :cond_1

    .line 414
    const/4 v3, 0x0

    const-string v4, "#"

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 415
    .local v0, "adId":Ljava/lang/String;
    const-string v3, "#"

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/auditude/ads/model/smil/Ref;->setID(Ljava/lang/String;)V

    .line 422
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->refs:Ljava/util/HashMap;

    invoke-virtual {v3, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 425
    .end local v0    # "adId":Ljava/lang/String;
    :cond_0
    return-object v1

    .line 419
    :cond_1
    move-object v0, v2

    .restart local v0    # "adId":Ljava/lang/String;
    goto :goto_0
.end method

.method private parseSMIL()V
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 196
    const/4 v3, 0x0

    .line 197
    .local v3, "index":I
    const/4 v5, 0x0

    .line 198
    .local v5, "startTime":I
    const/4 v1, 0x0

    .line 201
    .local v1, "group":Lcom/auditude/ads/model/smil/Group;
    const/4 v2, -0x1

    .line 203
    .local v2, "i":I
    const/4 v0, 0x2

    .line 206
    .local v0, "eventType":I
    :cond_0
    :goto_0
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    .line 207
    .local v6, "tag":Ljava/lang/String;
    const/4 v7, 0x2

    if-ne v0, v7, :cond_8

    .line 209
    const-string v7, "head"

    invoke-virtual {v7, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 211
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    invoke-direct {p0, v7}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSMILSubmissions(Lcom/auditude/ads/model/BaseElement;)V

    .line 262
    :cond_1
    :goto_1
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 204
    goto :goto_0

    .line 213
    :cond_2
    const-string v7, "seq"

    invoke-virtual {v7, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 215
    add-int/lit8 v2, v2, 0x1

    .line 216
    invoke-direct {p0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v4

    .line 217
    .local v4, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    if-eqz v4, :cond_0

    .line 219
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Group;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v7

    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v8

    if-eq v7, v8, :cond_5

    .line 223
    :cond_3
    if-nez v2, :cond_4

    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->isLinear()Z

    move-result v7

    if-nez v7, :cond_4

    .line 225
    new-instance v1, Lcom/auditude/ads/model/smil/Group;

    .end local v1    # "group":Lcom/auditude/ads/model/smil/Group;
    sget-object v7, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v8}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v8

    invoke-direct {v1, v7, v3, v8}, Lcom/auditude/ads/model/smil/Group;-><init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V

    .line 226
    .restart local v1    # "group":Lcom/auditude/ads/model/smil/Group;
    const/4 v7, 0x0

    invoke-virtual {v1, v7}, Lcom/auditude/ads/model/smil/Group;->setStartTime(I)V

    .line 227
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 230
    :cond_4
    new-instance v1, Lcom/auditude/ads/model/smil/Group;

    .end local v1    # "group":Lcom/auditude/ads/model/smil/Group;
    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v7

    iget-object v8, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    invoke-virtual {v8}, Lcom/auditude/ads/response/AdResponse;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v8

    invoke-direct {v1, v7, v3, v8}, Lcom/auditude/ads/model/smil/Group;-><init>(Lcom/auditude/ads/model/smil/SmilElementType;ILcom/auditude/ads/core/AdSettings;)V

    .line 232
    .restart local v1    # "group":Lcom/auditude/ads/model/smil/Group;
    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Group;->isLinear()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 234
    invoke-virtual {v1, v5}, Lcom/auditude/ads/model/smil/Group;->setStartTime(I)V

    .line 235
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 248
    :cond_5
    :goto_2
    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->isLinear()Z

    move-result v7

    if-nez v7, :cond_6

    .line 251
    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->getDuration()I

    move-result v7

    add-int/2addr v5, v7

    .line 254
    :cond_6
    invoke-virtual {v1, v4}, Lcom/auditude/ads/model/smil/Group;->addSequence(Lcom/auditude/ads/model/smil/Sequence;)V

    goto :goto_1

    .line 240
    :cond_7
    add-int/lit8 v3, v3, 0x1

    .line 243
    invoke-virtual {v1, v5}, Lcom/auditude/ads/model/smil/Group;->setStartTime(I)V

    .line 244
    iget-object v7, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->chapters:Ljava/util/ArrayList;

    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 257
    .end local v4    # "sequence":Lcom/auditude/ads/model/smil/Sequence;
    :cond_8
    const/4 v7, 0x3

    if-ne v0, v7, :cond_1

    const-string v7, "smil"

    invoke-virtual {v7, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 264
    return-void
.end method

.method private parseSMILData(Lcom/auditude/ads/model/BaseElement;)V
    .locals 4
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 898
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 900
    .local v1, "stateKeys":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1, v1}, Lcom/auditude/ads/model/BaseElement;->setState(Ljava/util/HashMap;)V

    .line 902
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 905
    .local v0, "eventType":I
    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 907
    .local v2, "tag":Ljava/lang/String;
    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    .line 909
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 920
    :cond_0
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 903
    goto :goto_0

    .line 911
    :cond_1
    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    .line 913
    const-string v3, "data"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 915
    invoke-virtual {p1, v1}, Lcom/auditude/ads/model/BaseElement;->setState(Ljava/util/HashMap;)V

    .line 922
    return-void
.end method

.method private parseSMILSubmissions(Lcom/auditude/ads/model/BaseElement;)V
    .locals 3
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 868
    iget-object v2, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 871
    .local v0, "eventType":I
    :goto_0
    iget-object v2, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 873
    .local v1, "tag":Ljava/lang/String;
    const/4 v2, 0x2

    if-ne v0, v2, :cond_2

    .line 875
    const-string v2, "data"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 877
    invoke-direct {p0, p1}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSMILData(Lcom/auditude/ads/model/BaseElement;)V

    .line 892
    :cond_0
    :goto_1
    iget-object v2, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 869
    goto :goto_0

    .line 879
    :cond_1
    const-string v2, "submission"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 881
    invoke-direct {p0, p1}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSubmission(Lcom/auditude/ads/model/BaseElement;)V

    goto :goto_1

    .line 884
    :cond_2
    const/4 v2, 0x3

    if-ne v0, v2, :cond_0

    .line 886
    const-string v2, "head"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 894
    return-void
.end method

.method private parseSequence()Lcom/auditude/ads/model/smil/Sequence;
    .locals 14
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v13, 0x0

    const/4 v12, 0x0

    .line 271
    new-instance v4, Lcom/auditude/ads/model/smil/Sequence;

    sget-object v9, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    invoke-direct {v4, v13, v9}, Lcom/auditude/ads/model/smil/Sequence;-><init>(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/SmilElementType;)V

    .line 273
    .local v4, "sequence":Lcom/auditude/ads/model/smil/Sequence;
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 276
    .local v0, "eventType":I
    :goto_0
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v8

    .line 278
    .local v8, "tag":Ljava/lang/String;
    const/4 v9, 0x2

    if-ne v0, v9, :cond_a

    .line 280
    const-string v9, "meta"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 282
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "name"

    const-string v11, ""

    invoke-static {v9, v10, v11}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 283
    .local v1, "metaName":Ljava/lang/String;
    const-string v9, "dur"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 285
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "content"

    invoke-static {v9, v10, v12}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v9

    mul-int/lit16 v9, v9, 0x3e8

    invoke-virtual {v4, v9}, Lcom/auditude/ads/model/smil/Sequence;->setDuration(I)V

    .line 346
    .end local v1    # "metaName":Ljava/lang/String;
    :cond_0
    :goto_1
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    .line 274
    goto :goto_0

    .line 287
    .restart local v1    # "metaName":Ljava/lang/String;
    :cond_1
    const-string v9, "max-dur"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 289
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "content"

    invoke-static {v9, v10, v12}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v9

    mul-int/lit16 v9, v9, 0x3e8

    invoke-virtual {v4, v9}, Lcom/auditude/ads/model/smil/Sequence;->setMaxDuration(I)V

    goto :goto_1

    .line 291
    :cond_2
    const-string v9, "count"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 293
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "content"

    invoke-static {v9, v10, v12}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v9

    invoke-virtual {v4, v9}, Lcom/auditude/ads/model/smil/Sequence;->setCount(I)V

    goto :goto_1

    .line 295
    :cond_3
    const-string v9, "max-count"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 297
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "content"

    invoke-static {v9, v10, v12}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v9

    invoke-virtual {v4, v9}, Lcom/auditude/ads/model/smil/Sequence;->setMaxCount(I)V

    goto :goto_1

    .line 299
    :cond_4
    const-string v9, "creativemaxdur"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 301
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "content"

    invoke-static {v9, v10, v12}, Lcom/auditude/ads/util/XMLUtil;->attributeAsIntOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;I)I

    move-result v9

    mul-int/lit16 v9, v9, 0x3e8

    invoke-virtual {v4, v9}, Lcom/auditude/ads/model/smil/Sequence;->setCreativeMaxDuration(I)V

    goto :goto_1

    .line 303
    :cond_5
    const-string v9, "ctype"

    invoke-virtual {v1, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 305
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "content"

    const-string v11, ""

    invoke-static {v9, v10, v11}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 306
    .local v2, "metaValue":Ljava/lang/String;
    const-string v9, "linear"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_6

    sget-object v5, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 307
    .local v5, "sequenceType":Lcom/auditude/ads/model/smil/SmilElementType;
    :goto_2
    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Sequence;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v9

    if-eq v5, v9, :cond_0

    .line 309
    invoke-virtual {v4, v5}, Lcom/auditude/ads/model/smil/Sequence;->setType(Lcom/auditude/ads/model/smil/SmilElementType;)V

    goto :goto_1

    .line 306
    .end local v5    # "sequenceType":Lcom/auditude/ads/model/smil/SmilElementType;
    :cond_6
    sget-object v5, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    goto :goto_2

    .line 313
    .end local v1    # "metaName":Ljava/lang/String;
    .end local v2    # "metaValue":Ljava/lang/String;
    :cond_7
    const-string v9, "setvalue"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 315
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "ref"

    invoke-static {v9, v10, v13}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 316
    .local v6, "setvalueKey":Ljava/lang/String;
    invoke-static {v6}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 318
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "value"

    const-string v11, ""

    invoke-static {v9, v10, v11}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v6, v9}, Lcom/auditude/ads/model/smil/Sequence;->addState(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 321
    .end local v6    # "setvalueKey":Ljava/lang/String;
    :cond_8
    const-string v9, "par"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 323
    invoke-direct {p0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parsePar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    .line 324
    .local v3, "par":Lcom/auditude/ads/model/smil/Par;
    if-eqz v3, :cond_0

    .line 326
    invoke-virtual {v4, v3}, Lcom/auditude/ads/model/smil/Sequence;->addPar(Lcom/auditude/ads/model/smil/Par;)V

    goto/16 :goto_1

    .line 329
    .end local v3    # "par":Lcom/auditude/ads/model/smil/Par;
    :cond_9
    const-string v9, "send"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 331
    iget-object v9, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v10, "submission"

    invoke-static {v9, v10, v13}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 332
    .local v7, "submissionId":Ljava/lang/String;
    invoke-static {v7}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 334
    invoke-virtual {v4, v7}, Lcom/auditude/ads/model/smil/Sequence;->setSubmissionId(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 338
    .end local v7    # "submissionId":Ljava/lang/String;
    :cond_a
    const/4 v9, 0x3

    if-ne v0, v9, :cond_0

    .line 340
    const-string v9, "seq"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 349
    return-object v4
.end method

.method private parseSubmission(Lcom/auditude/ads/model/BaseElement;)V
    .locals 5
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;

    .prologue
    const/4 v4, 0x0

    .line 926
    new-instance v0, Lcom/auditude/ads/model/tracking/Submission;

    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v2, "action"

    invoke-interface {v1, v4, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 927
    iget-object v2, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v3, "id"

    invoke-interface {v2, v4, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/model/tracking/Submission;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 928
    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v2, "id"

    invoke-interface {v1, v4, v2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 926
    invoke-virtual {p1, v0, v1}, Lcom/auditude/ads/model/BaseElement;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 929
    return-void
.end method

.method private parseTracking(Lcom/auditude/ads/model/Asset;)V
    .locals 7
    .param p1, "asset"    # Lcom/auditude/ads/model/Asset;

    .prologue
    const/4 v6, 0x0

    .line 762
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "action"

    invoke-static {v4, v5, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 763
    .local v3, "url":Ljava/lang/String;
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    const-string v5, "actuate"

    invoke-static {v4, v5, v6}, Lcom/auditude/ads/util/XMLUtil;->attributeAsStringOrDefault(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 765
    .local v2, "trackType":Ljava/lang/String;
    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-static {v3}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 768
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "creativeview"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "creativeview"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    .line 816
    :cond_0
    :goto_0
    return-void

    .line 773
    :cond_1
    const-string v4, "click"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 775
    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Click;

    .line 776
    .local v0, "click":Lcom/auditude/ads/model/Click;
    if-nez v0, :cond_2

    .line 778
    new-instance v0, Lcom/auditude/ads/model/Click;

    .end local v0    # "click":Lcom/auditude/ads/model/Click;
    invoke-direct {v0, p1}, Lcom/auditude/ads/model/Click;-><init>(Lcom/auditude/ads/model/BaseElement;)V

    .line 779
    .restart local v0    # "click":Lcom/auditude/ads/model/Click;
    invoke-virtual {p1, v0}, Lcom/auditude/ads/model/Asset;->setClick(Lcom/auditude/ads/model/IClick;)V

    .line 781
    :cond_2
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "click"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "click"

    invoke-virtual {v0, v4, v5}, Lcom/auditude/ads/model/Click;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto :goto_0

    .line 794
    .end local v0    # "click":Lcom/auditude/ads/model/Click;
    :cond_3
    const-string v4, "%"

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    if-lez v4, :cond_0

    .line 796
    const/4 v4, 0x0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 797
    .local v1, "trackTime":I
    sparse-switch v1, :sswitch_data_0

    goto :goto_0

    .line 800
    :sswitch_0
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "start"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "start"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto :goto_0

    .line 803
    :sswitch_1
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "firstquartile"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "firstquartile"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto :goto_0

    .line 806
    :sswitch_2
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "midpoint"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "midpoint"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto :goto_0

    .line 809
    :sswitch_3
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "thirdquartile"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "thirdquartile"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto :goto_0

    .line 812
    :sswitch_4
    new-instance v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    const-string v5, "complete"

    invoke-direct {v4, v3, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "complete"

    invoke-virtual {p1, v4, v5}, Lcom/auditude/ads/model/Asset;->addTrackingUrlForType(Lcom/auditude/ads/model/tracking/TrackingUrl;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 797
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x19 -> :sswitch_1
        0x32 -> :sswitch_2
        0x4b -> :sswitch_3
        0x64 -> :sswitch_4
    .end sparse-switch
.end method

.method private parseXML(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 8
    .param p1, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 114
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 116
    const-string v4, "Adserver response is empty"

    invoke-direct {p0, v4}, Lcom/auditude/ads/response/AuditudeResponseParser;->NotifyError(Ljava/lang/String;)V

    .line 117
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    .line 169
    :goto_0
    return-object v4

    .line 120
    :cond_0
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 122
    .local v2, "isResponse14":Ljava/lang/Boolean;
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v1

    .line 123
    .local v1, "factory":Lorg/xmlpull/v1/XmlPullParserFactory;
    invoke-virtual {v1}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v4

    iput-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    .line 125
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    new-instance v5, Ljava/io/StringReader;

    invoke-direct {v5, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v4, v5}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 127
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 128
    .local v0, "eventType":I
    :goto_1
    if-ne v0, v6, :cond_1

    .line 161
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 164
    invoke-direct {p0}, Lcom/auditude/ads/response/AuditudeResponseParser;->applyAdsOnRefs()V

    .line 165
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    goto :goto_0

    .line 130
    :cond_1
    packed-switch v0, :pswitch_data_0

    .line 158
    :cond_2
    :goto_2
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_1

    .line 133
    :pswitch_0
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 134
    .local v3, "tagName":Ljava/lang/String;
    const-string v4, "response"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 137
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 138
    goto :goto_2

    .line 139
    :cond_3
    const-string v4, "error"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 141
    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->parser:Lorg/xmlpull/v1/XmlPullParser;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/auditude/ads/response/AuditudeResponseParser;->NotifyError(Ljava/lang/String;)V

    .line 142
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    goto :goto_0

    .line 144
    :cond_4
    const-string v4, "smil"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 146
    invoke-direct {p0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseSMIL()V

    goto :goto_2

    .line 148
    :cond_5
    const-string v4, "ad"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 150
    invoke-direct {p0}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseAd()V

    goto :goto_2

    .line 169
    .end local v3    # "tagName":Ljava/lang/String;
    :cond_6
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    goto :goto_0

    .line 130
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 958
    iget-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    if-eqz v0, :cond_0

    .line 960
    iget-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    invoke-virtual {v0}, Lcom/auditude/ads/loader/DataLoader;->cancel()V

    .line 962
    :cond_0
    return-void
.end method

.method public loadAdRequest(Lcom/auditude/ads/response/AdResponse;Lcom/auditude/ads/loader/AdRequest;I)V
    .locals 4
    .param p1, "adResponse"    # Lcom/auditude/ads/response/AdResponse;
    .param p2, "adRequest"    # Lcom/auditude/ads/loader/AdRequest;
    .param p3, "timeout"    # I

    .prologue
    .line 67
    iput-object p1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    .line 68
    iput-object p2, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    .line 69
    iput p3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->timeout:I

    .line 71
    new-instance v0, Lcom/auditude/ads/loader/DataLoader;

    invoke-direct {v0}, Lcom/auditude/ads/loader/DataLoader;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    .line 72
    iget-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    invoke-virtual {v0, p0}, Lcom/auditude/ads/loader/DataLoader;->setDataLoaderListener(Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;)V

    .line 73
    iget-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    iget-object v1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    invoke-virtual {v1}, Lcom/auditude/ads/loader/AdRequest;->getAdRequestUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adRequest:Lcom/auditude/ads/loader/AdRequest;

    invoke-virtual {v2}, Lcom/auditude/ads/loader/AdRequest;->getKeyValueString()Ljava/lang/String;

    move-result-object v2

    iget v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->timeout:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/auditude/ads/loader/DataLoader;->load(Ljava/lang/String;Ljava/lang/String;I)V

    .line 74
    return-void
.end method

.method public onRequestComplete(Ljava/lang/String;)V
    .locals 5
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 83
    :try_start_0
    invoke-direct {p0, p1}, Lcom/auditude/ads/response/AuditudeResponseParser;->parseXML(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    .line 84
    .local v1, "isValidResponse":Ljava/lang/Boolean;
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->breaks:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/AdResponse;->setBreaks(Ljava/util/ArrayList;)V

    .line 85
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->chapters:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/AdResponse;->setChapters(Ljava/util/ArrayList;)V

    .line 86
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/AdResponse;->setSubmissions(Lcom/auditude/ads/model/tracking/Submissions;)V

    .line 87
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->adResponse:Lcom/auditude/ads/response/AdResponse;

    iget-object v4, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->ads:Ljava/util/HashMap;

    invoke-virtual {v3, v4}, Lcom/auditude/ads/response/AdResponse;->setAds(Ljava/util/HashMap;)V

    .line 88
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 90
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestComplete(Lcom/auditude/ads/exception/AssetException;)V

    .line 105
    .end local v1    # "isValidResponse":Ljava/lang/Boolean;
    :goto_0
    return-void

    .line 94
    .restart local v1    # "isValidResponse":Ljava/lang/Boolean;
    :cond_0
    iget-object v3, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestFailed(Ljava/lang/Throwable;)V
    :try_end_0
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 97
    .end local v1    # "isValidResponse":Ljava/lang/Boolean;
    :catch_0
    move-exception v2

    .line 99
    .local v2, "ppe":Lorg/xmlpull/v1/XmlPullParserException;
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserException;->printStackTrace()V

    goto :goto_0

    .line 101
    .end local v2    # "ppe":Lorg/xmlpull/v1/XmlPullParserException;
    :catch_1
    move-exception v0

    .line 103
    .local v0, "ioe":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public onRequestFailed(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    invoke-interface {v0, p1}, Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;->onRequestFailed(Ljava/lang/Throwable;)V

    .line 110
    return-void
.end method

.method public setResponseParserListener(Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/auditude/ads/response/AuditudeResponseParser;->listener:Lcom/auditude/ads/response/IResponseParser$ResponseParserListener;

    return-void
.end method
