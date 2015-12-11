.class public Lfs;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 106
    const-string v0, ""

    sput-object v0, Lfs;->a:Ljava/lang/String;

    return-void
.end method

.method public static a(Landroid/content/Context;DD)Landroid/location/Address;
    .locals 1

    .prologue
    .line 474
    invoke-static {p0, p1, p2, p3, p4}, Lgi;->a(Landroid/content/Context;DD)Landroid/location/Address;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;
    .locals 4

    .prologue
    .line 759
    if-eqz p3, :cond_0

    .line 760
    invoke-static {p0, p3}, Lgi;->a(Landroid/content/Context;Ljava/lang/String;)Landroid/location/Address;

    move-result-object v0

    .line 761
    if-eqz v0, :cond_0

    .line 762
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Landroid/location/Address;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 763
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Landroid/location/Address;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 766
    :cond_0
    invoke-static {p0, p1, p2}, Lgq;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lft;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;
    .locals 1

    .prologue
    .line 354
    invoke-static {p0, p1, p2}, Lfy;->a(Lft;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/GiftCard;

    move-result-object v0

    return-object v0
.end method

.method public static a(DDIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(DDIII",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;"
        }
    .end annotation

    .prologue
    .line 466
    invoke-static/range {p0 .. p12}, Lgc;->a(DDIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "DDIII",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;"
        }
    .end annotation

    .prologue
    .line 446
    invoke-static/range {p0 .. p11}, Lgc;->a(Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;
    .locals 1

    .prologue
    .line 669
    invoke-static {p0}, Lgf;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 670
    invoke-static {}, Lgg;->b()Ljava/lang/String;

    move-result-object v0

    .line 671
    invoke-static {p0, v0}, Lgf;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 673
    :cond_0
    invoke-static {p0}, Lgf;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Lgq;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;
    .locals 1

    .prologue
    .line 733
    invoke-static {p0, p1, p2, p3}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;IILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;
    .locals 1

    .prologue
    .line 696
    invoke-static {p0, p1, p2, p3}, Lgq;->a(Ljava/lang/String;IILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 300
    invoke-static {p0, p1}, Lgj;->e(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    move-result-object v2

    .line 301
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->isHasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 302
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getAccess_token()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->setRefreshToken(Ljava/lang/String;)V

    .line 304
    :try_start_0
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getUuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getAccess_token()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lgj;->d(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v3

    .line 306
    if-eqz v3, :cond_1

    .line 307
    const/4 v0, 0x1

    .line 308
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->setRegistry(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 310
    :goto_0
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->setHasWeddingRegistry(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 315
    :cond_0
    :goto_1
    return-object v2

    .line 311
    :catch_0
    move-exception v0

    .line 312
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/registry/Recommendations;
    .locals 1

    .prologue
    .line 552
    invoke-static {p0, p1}, Lgj;->a(Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/registry/Recommendations;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 480
    invoke-static {p0, p1, p2, p3}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;
    .locals 1

    .prologue
    .line 524
    invoke-static {p0, p1, p2, p3, p4}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lft;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;
    .locals 1

    .prologue
    .line 387
    invoke-static {p0, p1}, Lgq;->a(Lft;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/app/Activity;DDLjava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;
    .locals 3

    .prologue
    .line 597
    invoke-static {p0, p1, p2, p3, p4}, Lgi;->a(Landroid/content/Context;DD)Landroid/location/Address;

    move-result-object v0

    .line 601
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 602
    invoke-static {p0, p1, p2, p3, p4}, Lgi;->a(Landroid/content/Context;DD)Landroid/location/Address;

    move-result-object v0

    .line 604
    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 605
    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p5, p6, p7}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 607
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;
    .locals 2

    .prologue
    .line 612
    invoke-static {p0, p1}, Lgi;->b(Landroid/content/Context;Ljava/lang/String;)Landroid/location/Address;

    move-result-object v0

    .line 616
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 617
    invoke-static {p0, p1}, Lgi;->b(Landroid/content/Context;Ljava/lang/String;)Landroid/location/Address;

    move-result-object v0

    .line 619
    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 620
    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p2, p3, p4}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 622
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;
    .locals 1

    .prologue
    .line 626
    invoke-static {p0, p1, p2, p3}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "ZZII)",
            "Lcom/bestbuy/android/api/lib/models/search/SearchApi;"
        }
    .end annotation

    .prologue
    .line 645
    invoke-static/range {p0 .. p8}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
    .locals 1

    .prologue
    .line 272
    invoke-static/range {p0 .. p7}, Lgg;->a(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "IIZ)",
            "Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;"
        }
    .end annotation

    .prologue
    .line 282
    invoke-static/range {p0 .. p8}, Lgg;->a(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;)Lft;
    .locals 1

    .prologue
    .line 155
    const-string v0, "PROD"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 156
    sget-object v0, Lft;->a:Lft;

    .line 180
    :goto_0
    return-object v0

    .line 157
    :cond_0
    const-string v0, "QA"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 158
    sget-object v0, Lft;->e:Lft;

    goto :goto_0

    .line 159
    :cond_1
    const-string v0, "PROD_LIKE"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 160
    sget-object v0, Lft;->b:Lft;

    goto :goto_0

    .line 161
    :cond_2
    const-string v0, "CLOUD_TEST"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 162
    sget-object v0, Lft;->c:Lft;

    goto :goto_0

    .line 163
    :cond_3
    const-string v0, "STAGE"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 164
    sget-object v0, Lft;->d:Lft;

    goto :goto_0

    .line 165
    :cond_4
    const-string v0, "QA1"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 166
    sget-object v0, Lft;->f:Lft;

    goto :goto_0

    .line 167
    :cond_5
    const-string v0, "QA2"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 168
    sget-object v0, Lft;->g:Lft;

    goto :goto_0

    .line 169
    :cond_6
    const-string v0, "QA3"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 170
    sget-object v0, Lft;->h:Lft;

    goto :goto_0

    .line 171
    :cond_7
    const-string v0, "CDC"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 172
    sget-object v0, Lft;->i:Lft;

    goto :goto_0

    .line 173
    :cond_8
    const-string v0, "DEV"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 174
    sget-object v0, Lft;->j:Lft;

    goto :goto_0

    .line 175
    :cond_9
    const-string v0, "LOCAL"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 176
    sget-object v0, Lft;->k:Lft;

    goto :goto_0

    .line 177
    :cond_a
    const-string v0, "CUSTOM"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 178
    sget-object v0, Lft;->l:Lft;

    goto :goto_0

    .line 180
    :cond_b
    sget-object v0, Lft;->a:Lft;

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 292
    invoke-static {p0}, Lgf;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 293
    invoke-static {}, Lgg;->b()Ljava/lang/String;

    move-result-object v0

    .line 294
    invoke-static {p0, v0}, Lgf;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 296
    :cond_0
    invoke-static {p0}, Lgf;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Lgg;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 743
    invoke-static/range {p0 .. p6}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 243
    invoke-static {}, Lgm;->b()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Landroid/content/Context;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 580
    invoke-static {p0}, Lgf;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 582
    invoke-static {}, Lgg;->b()Ljava/lang/String;

    move-result-object v0

    .line 583
    invoke-static {p0, v0}, Lgf;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 585
    :cond_0
    invoke-static {p0}, Lgf;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lgq;->c(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/api/lib/models/home/Recommendation;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 568
    invoke-static {p0}, Lgq;->a(Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lft;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lft;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 556
    invoke-static {p0, p1}, Lgq;->a(Lft;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;IIZ)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "IIZ)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 560
    invoke-static {p0, p1, p2, p3}, Lgq;->a(Ljava/lang/String;IIZ)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation

    .prologue
    .line 528
    invoke-static/range {p0 .. p7}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static declared-synchronized a(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 649
    const-class v0, Lfs;

    monitor-enter v0

    :try_start_0
    invoke-static {p0}, Lgq;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 130
    packed-switch p2, :pswitch_data_0

    .line 152
    :goto_0
    :pswitch_0
    return-void

    .line 132
    :pswitch_1
    invoke-static {p0, p1}, Lgm;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 135
    :pswitch_2
    invoke-static {p0, p1}, Lgd;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 138
    :pswitch_3
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lgg;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V

    goto :goto_0

    .line 141
    :pswitch_4
    invoke-static {p0, p1}, Lfu;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 144
    :pswitch_5
    invoke-static {p0}, Lfw;->a(Ljava/lang/String;)V

    .line 146
    :pswitch_6
    invoke-static {p0}, Lga;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 149
    :pswitch_7
    invoke-static {p0}, Lgq;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 130
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 747
    invoke-static {p0, p1, p2}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 748
    return-void
.end method

.method public static a(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 633
    invoke-static {p0}, Lgg;->a(Ljava/util/List;)V

    .line 634
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)Z
    .locals 1

    .prologue
    .line 512
    invoke-static {p0, p1, p2, p3}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)Z

    move-result v0

    return v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 516
    invoke-static {p0, p1, p2, p3}, Lgj;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z
    .locals 1

    .prologue
    .line 540
    invoke-static/range {p0 .. p5}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 536
    invoke-static {p0, p1, p2, p3, p4}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    .locals 1

    .prologue
    .line 544
    invoke-static/range {p0 .. p5}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;)Landroid/location/Address;
    .locals 1

    .prologue
    .line 470
    invoke-static {p0, p1}, Lgi;->a(Landroid/content/Context;Ljava/lang/String;)Landroid/location/Address;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 1

    .prologue
    .line 737
    invoke-static/range {p0 .. p7}, Lga;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 520
    invoke-static {p0, p1, p2, p3}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    .locals 1

    .prologue
    .line 661
    invoke-static {p0, p1, p2}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
    .locals 1

    .prologue
    .line 572
    invoke-static/range {p0 .. p7}, Lgq;->a(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "IIZ)",
            "Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;"
        }
    .end annotation

    .prologue
    .line 576
    invoke-static/range {p0 .. p8}, Lgq;->a(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    return-object v0
.end method

.method public static b()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 257
    invoke-static {}, Lgm;->c()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 488
    invoke-static {p0, p1}, Lgj;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/blueshirt/AppointmentSlots;",
            ">;"
        }
    .end annotation

    .prologue
    .line 751
    invoke-static {p0, p1, p2}, Lgq;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 221
    sput-object p0, Lfs;->a:Ljava/lang/String;

    .line 222
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 755
    invoke-static {p0, p1, p2, p3, p4}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 756
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Z
    .locals 1

    .prologue
    .line 508
    invoke-static {p0, p1, p2, p3}, Lgj;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Z

    move-result v0

    return v0
.end method

.method public static c()Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;
    .locals 1

    .prologue
    .line 362
    invoke-static {}, Lgq;->b()Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    move-result-object v0

    return-object v0
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 492
    invoke-static {p0, p1}, Lgj;->c(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    return-object v0
.end method

.method public static c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/Store;
    .locals 1

    .prologue
    .line 231
    invoke-static {p0}, Lfu;->b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/Store;

    move-result-object v0

    return-object v0
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation

    .prologue
    .line 532
    invoke-static {p0, p1, p2, p3}, Lgj;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static d(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;
    .locals 1

    .prologue
    .line 324
    invoke-static {p0}, Lgd;->a(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    move-result-object v0

    return-object v0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 496
    invoke-static {p0, p1}, Lgj;->d(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    return-object v0
.end method

.method public static d()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;"
        }
    .end annotation

    .prologue
    .line 504
    invoke-static {}, Lgj;->a()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 629
    invoke-static {p0, p1, p2, p3}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 630
    return-void
.end method

.method public static e()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RecommendationsList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 548
    invoke-static {}, Lgj;->b()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static e(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 589
    invoke-static {p0}, Lgq;->d(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 500
    invoke-static {p0, p1}, Lgj;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static f(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;
    .locals 1

    .prologue
    .line 684
    invoke-static {p0, p1}, Lgq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    move-result-object v0

    return-object v0
.end method

.method public static f(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 593
    invoke-static {p0}, Lgq;->e(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static g(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    .line 657
    invoke-static {p0}, Lgq;->g(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static h(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;
    .locals 1

    .prologue
    .line 692
    invoke-static {p0}, Lgq;->j(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    move-result-object v0

    return-object v0
.end method

.method public static i(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;
    .locals 1

    .prologue
    .line 700
    invoke-static {p0}, Lgq;->k(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;

    move-result-object v0

    return-object v0
.end method

.method public static j(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;
    .locals 1

    .prologue
    .line 708
    invoke-static {p0}, Lgq;->l(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    move-result-object v0

    return-object v0
.end method

.method public static k(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;
    .locals 1

    .prologue
    .line 716
    invoke-static {p0}, Lgq;->m(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;

    move-result-object v0

    return-object v0
.end method

.method public static l(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;
    .locals 1

    .prologue
    .line 721
    invoke-static {p0}, Lgq;->n(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;

    move-result-object v0

    return-object v0
.end method

.method public static m(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;
    .locals 1

    .prologue
    .line 729
    invoke-static {p0}, Lgq;->o(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;

    move-result-object v0

    return-object v0
.end method

.method public static n(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/ShareURL;
    .locals 1

    .prologue
    .line 770
    invoke-static {p0}, Lgj;->d(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/ShareURL;

    move-result-object v0

    return-object v0
.end method
