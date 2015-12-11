.class public Lio/branch/indexing/BranchUniversalObject;
.super Ljava/lang/Object;
.source "BranchUniversalObject.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;,
        Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;


# instance fields
.field private canonicalIdentifier_:Ljava/lang/String;

.field private description_:Ljava/lang/String;

.field private expirationInMilliSec_:J

.field private imageUrl_:Ljava/lang/String;

.field private indexMode_:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

.field private final keywords_:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final metadata_:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private title_:Ljava/lang/String;

.field private type_:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 535
    new-instance v0, Lio/branch/indexing/BranchUniversalObject$1;

    invoke-direct {v0}, Lio/branch/indexing/BranchUniversalObject$1;-><init>()V

    sput-object v0, Lio/branch/indexing/BranchUniversalObject;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    .line 72
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    .line 74
    const-string v0, ""

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    .line 75
    const-string v0, ""

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    .line 76
    const-string v0, ""

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    .line 77
    sget-object v0, Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;->PUBLIC:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    iput-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->indexMode_:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    .line 78
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    .line 79
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 565
    invoke-direct {p0}, Lio/branch/indexing/BranchUniversalObject;-><init>()V

    .line 567
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    .line 568
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    .line 569
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    .line 570
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->imageUrl_:Ljava/lang/String;

    .line 571
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    .line 572
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    .line 573
    invoke-static {}, Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;->values()[Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    move-result-object v3

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    aget-object v3, v3, v4

    iput-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->indexMode_:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    .line 575
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 576
    .local v1, "keywordsTemp":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 577
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 578
    .local v2, "metadataSize":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 579
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 578
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 581
    :cond_0
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lio/branch/indexing/BranchUniversalObject$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lio/branch/indexing/BranchUniversalObject$1;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lio/branch/indexing/BranchUniversalObject;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private getLinkBuilder(Landroid/content/Context;Lio/branch/referral/util/LinkProperties;)Lio/branch/referral/BranchShortLinkBuilder;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "linkProperties"    # Lio/branch/referral/util/LinkProperties;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 436
    new-instance v3, Lio/branch/referral/BranchShortLinkBuilder;

    invoke-direct {v3, p1}, Lio/branch/referral/BranchShortLinkBuilder;-><init>(Landroid/content/Context;)V

    .line 437
    .local v3, "shortLinkBuilder":Lio/branch/referral/BranchShortLinkBuilder;
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getTags()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 438
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getTags()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/BranchShortLinkBuilder;->addTags(Ljava/util/List;)Lio/branch/referral/BranchUrlBuilder;

    .line 440
    :cond_0
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getFeature()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 441
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getFeature()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/BranchShortLinkBuilder;->setFeature(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 443
    :cond_1
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getAlias()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 444
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getAlias()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/BranchShortLinkBuilder;->setAlias(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 446
    :cond_2
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getChannel()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 447
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getChannel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/BranchShortLinkBuilder;->setChannel(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 449
    :cond_3
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getStage()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 450
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getStage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lio/branch/referral/BranchShortLinkBuilder;->setStage(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 452
    :cond_4
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getMatchDuration()I

    move-result v4

    if-lez v4, :cond_5

    .line 453
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getMatchDuration()I

    move-result v4

    invoke-virtual {v3, v4}, Lio/branch/referral/BranchShortLinkBuilder;->setDuration(I)Lio/branch/referral/BranchShortLinkBuilder;

    .line 456
    :cond_5
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->ContentTitle:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 457
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->CanonicalIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 458
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->ContentKeyWords:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lio/branch/indexing/BranchUniversalObject;->getKeywordsJsonArray()Lorg/json/JSONArray;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Lorg/json/JSONArray;)Lio/branch/referral/BranchUrlBuilder;

    .line 459
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->ContentDesc:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 460
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->ContentImgUrl:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->imageUrl_:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 461
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->ContentType:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 462
    sget-object v4, Lio/branch/referral/Defines$Jsonkey;->ContentExpiryTime:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v4}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-wide v6, p0, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 464
    iget-object v4, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v4}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 465
    .local v2, "key":Ljava/lang/String;
    iget-object v4, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v4, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v2, v4}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    goto :goto_0

    .line 467
    .end local v2    # "key":Ljava/lang/String;
    :cond_6
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getControlParams()Ljava/util/HashMap;

    move-result-object v0

    .line 468
    .local v0, "controlParam":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 469
    .restart local v2    # "key":Ljava/lang/String;
    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v2, v4}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    goto :goto_1

    .line 473
    .end local v2    # "key":Ljava/lang/String;
    :cond_7
    return-object v3
.end method

.method public static getReferredBranchUniversalObject()Lio/branch/indexing/BranchUniversalObject;
    .locals 10

    .prologue
    .line 484
    const/4 v1, 0x0

    .line 485
    .local v1, "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v0

    .line 486
    .local v0, "branchInstance":Lio/branch/referral/Branch;
    if-eqz v0, :cond_7

    invoke-virtual {v0}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v8

    if-eqz v8, :cond_7

    .line 487
    invoke-virtual {v0}, Lio/branch/referral/Branch;->getLatestReferringParams()Lorg/json/JSONObject;

    move-result-object v7

    .line 489
    .local v7, "latestParam":Lorg/json/JSONObject;
    :try_start_0
    const-string v8, "+clicked_branch_link"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    const-string v8, "+clicked_branch_link"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 490
    new-instance v2, Lio/branch/indexing/BranchUniversalObject;

    invoke-direct {v2}, Lio/branch/indexing/BranchUniversalObject;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 492
    .end local v1    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    .local v2, "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    :try_start_1
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentTitle:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 493
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentTitle:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v2, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    .line 495
    :cond_0
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->CanonicalIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 496
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->CanonicalIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v2, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    .line 498
    :cond_1
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentKeyWords:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 499
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentKeyWords:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v6

    .line 500
    .local v6, "keywordJsonArray":Lorg/json/JSONArray;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {v6}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v3, v8, :cond_2

    .line 501
    iget-object v9, v2, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 500
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 504
    .end local v3    # "i":I
    .end local v6    # "keywordJsonArray":Lorg/json/JSONArray;
    :cond_2
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentDesc:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 505
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentDesc:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v2, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    .line 507
    :cond_3
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentImgUrl:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 508
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentImgUrl:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v2, Lio/branch/indexing/BranchUniversalObject;->imageUrl_:Ljava/lang/String;

    .line 510
    :cond_4
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentType:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 511
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentType:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, v2, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    .line 513
    :cond_5
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentExpiryTime:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 514
    sget-object v8, Lio/branch/referral/Defines$Jsonkey;->ContentExpiryTime:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v8}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v8

    iput-wide v8, v2, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    .line 516
    :cond_6
    invoke-virtual {v7}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v5

    .line 517
    .local v5, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_8

    .line 518
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 519
    .local v4, "key":Ljava/lang/String;
    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v4, v8}, Lio/branch/indexing/BranchUniversalObject;->addContentMetadata(Ljava/lang/String;Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 523
    .end local v4    # "key":Ljava/lang/String;
    .end local v5    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :catch_0
    move-exception v8

    move-object v1, v2

    .line 526
    .end local v2    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    .end local v7    # "latestParam":Lorg/json/JSONObject;
    .restart local v1    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    :cond_7
    :goto_2
    return-object v1

    .line 523
    .restart local v7    # "latestParam":Lorg/json/JSONObject;
    :catch_1
    move-exception v8

    goto :goto_2

    .end local v1    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    .restart local v2    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    .restart local v5    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_8
    move-object v1, v2

    .end local v2    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    .restart local v1    # "branchUniversalObject":Lio/branch/indexing/BranchUniversalObject;
    goto :goto_2
.end method


# virtual methods
.method public addContentMetadata(Ljava/lang/String;Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 157
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    return-object p0
.end method

.method public addContentMetadata(Ljava/util/HashMap;)Lio/branch/indexing/BranchUniversalObject;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lio/branch/indexing/BranchUniversalObject;"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "metadata":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 144
    return-object p0
.end method

.method public addKeyWord(Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 1
    .param p1, "keyword"    # Ljava/lang/String;

    .prologue
    .line 210
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 211
    return-object p0
.end method

.method public addKeyWords(Ljava/util/ArrayList;)Lio/branch/indexing/BranchUniversalObject;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lio/branch/indexing/BranchUniversalObject;"
        }
    .end annotation

    .prologue
    .line 197
    .local p1, "keywords":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 198
    return-object p0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 532
    const/4 v0, 0x0

    return v0
.end method

.method public generateShortUrl(Landroid/content/Context;Lio/branch/referral/util/LinkProperties;Lio/branch/referral/Branch$BranchLinkCreateListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "linkProperties"    # Lio/branch/referral/util/LinkProperties;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "callback"    # Lio/branch/referral/Branch$BranchLinkCreateListener;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 389
    invoke-direct {p0, p1, p2}, Lio/branch/indexing/BranchUniversalObject;->getLinkBuilder(Landroid/content/Context;Lio/branch/referral/util/LinkProperties;)Lio/branch/referral/BranchShortLinkBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Lio/branch/referral/BranchShortLinkBuilder;->generateShortUrl(Lio/branch/referral/Branch$BranchLinkCreateListener;)V

    .line 390
    return-void
.end method

.method public getCanonicalIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationTime()J
    .locals 2

    .prologue
    .line 257
    iget-wide v0, p0, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    return-wide v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->imageUrl_:Ljava/lang/String;

    return-object v0
.end method

.method public getKeywords()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 336
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getKeywordsJsonArray()Lorg/json/JSONArray;
    .locals 4

    .prologue
    .line 322
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 323
    .local v2, "keywordArray":Lorg/json/JSONArray;
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 324
    .local v1, "keyword":Ljava/lang/String;
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 326
    .end local v1    # "keyword":Ljava/lang/String;
    :cond_0
    return-object v2
.end method

.method public getMetadata()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 246
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    return-object v0
.end method

.method public getShortUrl(Landroid/content/Context;Lio/branch/referral/util/LinkProperties;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "linkProperties"    # Lio/branch/referral/util/LinkProperties;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 385
    invoke-direct {p0, p1, p2}, Lio/branch/indexing/BranchUniversalObject;->getLinkBuilder(Landroid/content/Context;Lio/branch/referral/util/LinkProperties;)Lio/branch/referral/BranchShortLinkBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/BranchShortLinkBuilder;->getShortUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 312
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    return-object v0
.end method

.method public isPublicallyIndexable()Z
    .locals 2

    .prologue
    .line 235
    iget-object v0, p0, Lio/branch/indexing/BranchUniversalObject;->indexMode_:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    sget-object v1, Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;->PUBLIC:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public registerView()V
    .locals 1

    .prologue
    .line 345
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lio/branch/indexing/BranchUniversalObject;->registerView(Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;)V

    .line 346
    return-void
.end method

.method public registerView(Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;)V
    .locals 4
    .param p1, "callback"    # Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 354
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 355
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lio/branch/referral/Branch;->registerView(Lio/branch/indexing/BranchUniversalObject;Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;)V

    .line 361
    :cond_0
    :goto_0
    return-void

    .line 357
    :cond_1
    if-eqz p1, :cond_0

    .line 358
    const/4 v0, 0x0

    new-instance v1, Lio/branch/referral/BranchError;

    const-string v2, "Register view error"

    const/16 v3, -0x6d

    invoke-direct {v1, v2, v3}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {p1, v0, v1}, Lio/branch/indexing/BranchUniversalObject$RegisterViewStatusListener;->onRegisterViewFinished(ZLio/branch/referral/BranchError;)V

    goto :goto_0
.end method

.method public setCanonicalIdentifier(Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 0
    .param p1, "canonicalIdentifier"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 90
    iput-object p1, p0, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    .line 91
    return-object p0
.end method

.method public setContentDescription(Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 116
    iput-object p1, p0, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    .line 117
    return-object p0
.end method

.method public setContentExpiration(Ljava/util/Date;)Lio/branch/indexing/BranchUniversalObject;
    .locals 2
    .param p1, "expirationDate"    # Ljava/util/Date;

    .prologue
    .line 223
    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    iput-wide v0, p0, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    .line 224
    return-object p0
.end method

.method public setContentImageUrl(Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 0
    .param p1, "imageUrl"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 129
    iput-object p1, p0, Lio/branch/indexing/BranchUniversalObject;->imageUrl_:Ljava/lang/String;

    .line 130
    return-object p0
.end method

.method public setContentIndexingMode(Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;)Lio/branch/indexing/BranchUniversalObject;
    .locals 0
    .param p1, "indexMode"    # Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    .prologue
    .line 183
    iput-object p1, p0, Lio/branch/indexing/BranchUniversalObject;->indexMode_:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    .line 184
    return-object p0
.end method

.method public setContentType(Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 170
    iput-object p1, p0, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    .line 171
    return-object p0
.end method

.method public setTitle(Ljava/lang/String;)Lio/branch/indexing/BranchUniversalObject;
    .locals 0
    .param p1, "title"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 103
    iput-object p1, p0, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    .line 104
    return-object p0
.end method

.method public showShareSheet(Landroid/app/Activity;Lio/branch/referral/util/LinkProperties;Lio/branch/referral/util/ShareSheetStyle;Lio/branch/referral/Branch$BranchLinkShareListener;)V
    .locals 9
    .param p1, "activity"    # Landroid/app/Activity;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "linkProperties"    # Lio/branch/referral/util/LinkProperties;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "style"    # Lio/branch/referral/util/ShareSheetStyle;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p4, "callback"    # Lio/branch/referral/Branch$BranchLinkShareListener;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v8, 0x0

    .line 395
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v5

    if-nez v5, :cond_1

    .line 396
    if-eqz p4, :cond_0

    .line 397
    new-instance v5, Lio/branch/referral/BranchError;

    const-string v6, "Trouble sharing link. "

    const/16 v7, -0x6d

    invoke-direct {v5, v6, v7}, Lio/branch/referral/BranchError;-><init>(Ljava/lang/String;I)V

    invoke-interface {p4, v8, v8, v5}, Lio/branch/referral/Branch$BranchLinkShareListener;->onLinkShareResponse(Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/BranchError;)V

    .line 433
    :goto_0
    return-void

    .line 399
    :cond_0
    const-string v5, "BranchSDK"

    const-string v6, "Sharing error. Branch instance is not created yet. Make sure you have initialised Branch."

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 402
    :cond_1
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 404
    .local v3, "params":Lorg/json/JSONObject;
    :try_start_0
    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 405
    .local v2, "key":Ljava/lang/String;
    iget-object v5, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v5, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 411
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 414
    :cond_2
    new-instance v5, Lio/branch/referral/Branch$ShareLinkBuilder;

    invoke-direct {p0, p1, p2}, Lio/branch/indexing/BranchUniversalObject;->getLinkBuilder(Landroid/content/Context;Lio/branch/referral/util/LinkProperties;)Lio/branch/referral/BranchShortLinkBuilder;

    move-result-object v6

    invoke-direct {v5, p1, v6}, Lio/branch/referral/Branch$ShareLinkBuilder;-><init>(Landroid/app/Activity;Lio/branch/referral/BranchShortLinkBuilder;)V

    invoke-virtual {v5, p4}, Lio/branch/referral/Branch$ShareLinkBuilder;->setCallback(Lio/branch/referral/Branch$BranchLinkShareListener;)Lio/branch/referral/Branch$ShareLinkBuilder;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getMessageTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lio/branch/referral/Branch$ShareLinkBuilder;->setSubject(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getMessageBody()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lio/branch/referral/Branch$ShareLinkBuilder;->setMessage(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;

    move-result-object v4

    .line 419
    .local v4, "shareLinkBuilder":Lio/branch/referral/Branch$ShareLinkBuilder;
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getCopyUrlIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 420
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getCopyUrlIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getCopyURlText()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getUrlCopiedMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v5, v6, v7}, Lio/branch/referral/Branch$ShareLinkBuilder;->setCopyUrlStyle(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;

    .line 422
    :cond_3
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getMoreOptionIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 423
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getMoreOptionIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getMoreOptionText()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lio/branch/referral/Branch$ShareLinkBuilder;->setMoreOptionStyle(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;

    .line 425
    :cond_4
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getDefaultURL()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_5

    .line 426
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getDefaultURL()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lio/branch/referral/Branch$ShareLinkBuilder;->setDefaultURL(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;

    .line 428
    :cond_5
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getPreferredOptions()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_6

    .line 429
    invoke-virtual {p3}, Lio/branch/referral/util/ShareSheetStyle;->getPreferredOptions()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v4, v5}, Lio/branch/referral/Branch$ShareLinkBuilder;->addPreferredSharingOptions(Ljava/util/ArrayList;)Lio/branch/referral/Branch$ShareLinkBuilder;

    .line 431
    :cond_6
    invoke-virtual {v4}, Lio/branch/referral/Branch$ShareLinkBuilder;->shareLink()V

    goto/16 :goto_0

    .line 407
    .end local v4    # "shareLinkBuilder":Lio/branch/referral/Branch$ShareLinkBuilder;
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_7
    :try_start_1
    invoke-virtual {p2}, Lio/branch/referral/util/LinkProperties;->getControlParams()Ljava/util/HashMap;

    move-result-object v0

    .line 408
    .local v0, "controlParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 409
    .restart local v2    # "key":Ljava/lang/String;
    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v2, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 6
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 547
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->canonicalIdentifier_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 548
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->title_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 549
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->description_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 550
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->imageUrl_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 551
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->type_:Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 552
    iget-wide v4, p0, Lio/branch/indexing/BranchUniversalObject;->expirationInMilliSec_:J

    invoke-virtual {p1, v4, v5}, Landroid/os/Parcel;->writeLong(J)V

    .line 553
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->indexMode_:Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;

    invoke-virtual {v3}, Lio/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE;->ordinal()I

    move-result v3

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 554
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->keywords_:Ljava/util/ArrayList;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 556
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->size()I

    move-result v2

    .line 557
    .local v2, "metaDataSize":I
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 558
    iget-object v3, p0, Lio/branch/indexing/BranchUniversalObject;->metadata_:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 559
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 560
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 562
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    return-void
.end method
