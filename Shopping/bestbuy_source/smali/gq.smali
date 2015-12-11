.class public Lgq;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;

.field private static b:Lgr;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 101
    const-class v0, Lgq;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lgq;->a:Ljava/lang/String;

    .line 102
    sget-object v0, Lgr;->a:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    return-void
.end method

.method public static a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 1487
    const-string v0, ""

    .line 1488
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1489
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/featureFlags/blueAssist"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1490
    const/4 v2, 0x0

    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1491
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1492
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    .line 1493
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "lat"

    invoke-direct {v4, v5, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1494
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "lon"

    invoke-direct {v4, v5, p2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1496
    :cond_0
    const/4 v4, 0x1

    invoke-static {v0, v3, v2, v1, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1498
    new-instance v2, Lcom/bestbuy/android/api/lib/models/SIResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/SIResponse;-><init>()V

    .line 1499
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 1500
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/SIResponse;

    .line 1501
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/SIResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1502
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/SIResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    .line 1503
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1504
    new-instance v0, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;-><init>()V

    .line 1505
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v1

    .line 1506
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getBookABlueShirtStores()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->setBookABlueShirtStores(Ljava/util/ArrayList;)V

    .line 1507
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->isBookABlueShirt()Z

    move-result v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->setBookABlueShirt(Z)V

    .line 1508
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->isChat()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->setChat(Z)V

    .line 1511
    :goto_0
    return-object v0

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 891
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 892
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/homeScreen/bbyApp"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 893
    invoke-static {v2}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v1

    .line 894
    invoke-static {v0, v3, v1, v3, v2}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 896
    if-eqz v0, :cond_0

    .line 897
    invoke-static {v0, p0}, Lgq;->b(Ljava/lang/String;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    move-result-object v0

    return-object v0

    .line 899
    :cond_0
    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    throw v0
.end method

.method public static a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 953
    const-string v0, ""

    .line 954
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 955
    invoke-static {v1}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v1

    .line 956
    const-string v2, ""

    .line 957
    if-eqz p1, :cond_0

    .line 958
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->getUrl()Ljava/lang/String;

    move-result-object v2

    const-string v3, "{context_id}"

    invoke-virtual {v2, v3, p0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 962
    :goto_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 964
    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v2, v1, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 966
    new-instance v1, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;-><init>()V

    .line 967
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 968
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/recentlyviewed/RecentlyViewedAlsoViewedResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 970
    return-object v0

    .line 960
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/recommendations/recentlyViewedAlsoViewed/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/9?datasetVersion="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 971
    :catch_0
    move-exception v0

    .line 972
    throw v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;
    .locals 9

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 979
    const-string v0, ""

    .line 980
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v2

    .line 982
    invoke-static {v3}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v3

    .line 983
    const-string v0, ""

    .line 984
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 985
    if-eqz p1, :cond_0

    .line 986
    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string v6, "storeId"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 987
    :cond_0
    if-eqz p0, :cond_1

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_1

    .line 988
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v2, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/pdp/overview/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 992
    :cond_1
    :try_start_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_6

    .line 993
    new-instance v2, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;-><init>()V

    .line 994
    const/4 v5, 0x0

    const/4 v6, 0x1

    invoke-static {v0, v4, v3, v5, v6}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 995
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 996
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    .line 997
    invoke-static {p0}, Lgq;->b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    .line 998
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 999
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    .line 1001
    :cond_2
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    if-eqz v2, :cond_5

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    if-eqz v2, :cond_5

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 1002
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSoftwareDetails()Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 1003
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSoftwareDetails()Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;

    move-result-object v2

    .line 1004
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v3

    .line 1005
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;->getRequirements()Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

    move-result-object v4

    invoke-static {v4, v3}, Lgq;->a(Lcom/bestbuy/android/api/lib/models/pdp/Requirement;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v3

    .line 1006
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/pdp/SoftWareDetails;->setSpecifications(Ljava/util/ArrayList;)V

    .line 1008
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getGameDetails()Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 1009
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getGameDetails()Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;

    move-result-object v2

    .line 1010
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->getSpecifications()Ljava/util/ArrayList;

    move-result-object v3

    .line 1011
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->getRequirements()Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

    move-result-object v4

    invoke-static {v4, v3}, Lgq;->a(Lcom/bestbuy/android/api/lib/models/pdp/Requirement;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v3

    .line 1012
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/pdp/games/GameDetails;->setSpecifications(Ljava/util/ArrayList;)V

    .line 1014
    :cond_4
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->setRestrictedPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1017
    :cond_5
    :goto_0
    return-object v0

    .line 1018
    :catch_0
    move-exception v0

    .line 1019
    throw v0

    :cond_6
    move-object v0, v1

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 1381
    const-string v0, ""

    .line 1382
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1383
    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1384
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1385
    const-string v0, ""

    .line 1386
    if-eqz p0, :cond_1

    if-nez p2, :cond_1

    .line 1387
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/reviews/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1388
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "feature"

    const-string v5, "UTF-8"

    invoke-static {p1, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1389
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "page"

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1394
    :cond_0
    :goto_0
    const/4 v1, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v3, v2, v1, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1395
    new-instance v1, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/PDPFeaturesParent;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/PDPFeaturesParent;-><init>()V

    .line 1396
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 1397
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/PDPFeaturesParent;

    .line 1398
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/PDPFeaturesParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/SIFeatureReviews;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/SIFeatureReviews;->getResponse()Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 1390
    :cond_1
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 1391
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1399
    :catch_0
    move-exception v0

    .line 1400
    throw v0
.end method

.method public static a(Ljava/lang/String;IILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;
    .locals 6

    .prologue
    const/4 v1, 0x1

    .line 1182
    const-string v0, ""

    .line 1184
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1185
    invoke-static {v1}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v1

    .line 1186
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lgr;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/pdp/reviewDetails/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1187
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1188
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "start"

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1189
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "limit"

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1190
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "sort"

    invoke-direct {v3, v4, p3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1191
    new-instance v3, Lcom/bestbuy/android/api/lib/models/pdpreviews/PDPReviewsParent;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/pdpreviews/PDPReviewsParent;-><init>()V

    .line 1193
    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_0
    invoke-static {v0, v2, v1, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1194
    new-instance v1, Lgy;

    invoke-direct {v1}, Lgy;-><init>()V

    .line 1195
    invoke-virtual {v1, v0, v3}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/PDPReviewsParent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1200
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/PDPReviewsParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdpreviews/SIReviews;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/SIReviews;->getResponse()Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    move-result-object v0

    return-object v0

    .line 1196
    :catch_0
    move-exception v0

    .line 1197
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error making GET request: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1198
    throw v0
.end method

.method private static a(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;
    .locals 1

    .prologue
    .line 566
    const/16 v0, 0x64

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->setType(I)V

    .line 567
    const-string v0, "market://details?id=com.bestbuy.android"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->setStoreLink(Ljava/lang/String;)V

    .line 568
    const-string v0, "Install"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->setStoreButtonTitle(Ljava/lang/String;)V

    .line 569
    const-string v0, "Later"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->setCancelButtonTitle(Ljava/lang/String;)V

    .line 570
    const-string v0, "Feedback"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->setFeedbackButtonTitle(Ljava/lang/String;)V

    .line 571
    const-string v0, "Get the Update"

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->setUpdateButtonTitle(Ljava/lang/String;)V

    .line 572
    return-object p0
.end method

.method public static a(Lft;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 541
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 542
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/supportedVersions/bby-android-app"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 546
    const/4 v1, 0x0

    invoke-static {v1}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v1

    .line 547
    const/4 v2, 0x1

    invoke-static {v0, v3, v1, v3, v2}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 548
    if-eqz v0, :cond_0

    .line 549
    invoke-static {v0, p1}, Lgq;->a(Ljava/lang/String;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    move-result-object v0

    return-object v0

    .line 551
    :cond_0
    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    throw v0
.end method

.method private static a(Ljava/lang/String;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;
    .locals 2

    .prologue
    .line 556
    new-instance v0, Lgy;

    invoke-direct {v0}, Lgy;-><init>()V

    .line 557
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v0, p0, v1}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    .line 558
    if-eqz v0, :cond_0

    .line 560
    invoke-static {v0}, Lgq;->a(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    move-result-object v0

    .line 562
    :cond_0
    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;
    .locals 7

    .prologue
    .line 483
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 484
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/stores/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 486
    const/4 v1, 0x0

    invoke-static {v1}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v1

    .line 488
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 489
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "start"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 490
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "limit"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 491
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 492
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "skuId"

    invoke-direct {v3, v4, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 493
    :cond_0
    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v0, v2, v1, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 494
    invoke-static {v0}, Lgq;->f(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    .locals 6

    .prologue
    .line 854
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 855
    const/4 v0, 0x0

    invoke-static {v0}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v2

    .line 856
    const-string v0, ""

    .line 857
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "&page="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "&sort="

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 859
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_0
    invoke-static {v1, v3, v2, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 863
    :goto_0
    invoke-static {v0}, Lgq;->h(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    return-object v0

    .line 860
    :catch_0
    move-exception v1

    .line 861
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    .locals 14
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
    .line 591
    const-string v1, ""

    .line 592
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 593
    new-instance v5, Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-direct {v5}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;-><init>()V

    .line 594
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 595
    const/4 v2, 0x1

    invoke-static {v2}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v7

    .line 596
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 597
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/si/products/search/www?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 599
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 600
    if-eqz p0, :cond_0

    const-string v1, "sort"

    invoke-virtual {p0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 603
    :cond_0
    if-eqz p4, :cond_2

    invoke-virtual/range {p4 .. p4}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 604
    const-string v1, "sort"

    move-object/from16 v0, p4

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 612
    :cond_1
    :goto_0
    const-string v1, "enableRedirect"

    const-string v3, "false"

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 613
    const-string v1, "page"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p8

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 614
    const-string v1, "rows"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, p7

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 616
    if-eqz p0, :cond_6

    .line 617
    const-string v1, "si/products/search/www"

    invoke-virtual {p0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 618
    const-string v1, "?"

    invoke-static {v1}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 619
    const/4 v3, 0x1

    aget-object v1, v1, v3

    .line 620
    const-string v3, "&"

    invoke-static {v3}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 621
    const/4 v1, 0x0

    :goto_1
    array-length v4, v3

    if-ge v1, v4, :cond_6

    .line 622
    aget-object v4, v3, v1

    .line 623
    const-string v10, "="

    invoke-static {v10}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v4, v10}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 625
    new-instance v10, Lorg/apache/http/message/BasicNameValuePair;

    const/4 v11, 0x0

    aget-object v11, v4, v11

    const/4 v12, 0x1

    aget-object v4, v4, v12

    invoke-direct {v10, v11, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 621
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 605
    :cond_2
    if-eqz p0, :cond_3

    const-string v1, "si/products/search/www"

    invoke-virtual {p0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 606
    const-string v1, "Best-Selling"

    .line 607
    const-string v3, "sort"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 608
    :cond_3
    if-eqz p4, :cond_4

    invoke-virtual/range {p4 .. p4}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 609
    :cond_4
    const-string v1, "Best-Match"

    .line 610
    const-string v3, "sort"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 628
    :cond_5
    const-string v1, "query"

    invoke-interface {v2, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 631
    :cond_6
    if-eqz p3, :cond_7

    invoke-interface/range {p3 .. p3}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_7

    .line 632
    move-object/from16 v0, p3

    invoke-interface {v2, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 633
    :cond_7
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 634
    if-eqz v2, :cond_b

    .line 635
    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .line 636
    :cond_8
    :goto_2
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_b

    .line 637
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 638
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 639
    if-eqz v2, :cond_8

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_8

    const-string v3, "null"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_8

    .line 640
    const-string v3, "|"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 641
    new-instance v11, Ljava/util/ArrayList;

    const-string v3, "\\|"

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-direct {v11, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 642
    const/4 v2, 0x0

    move v4, v2

    :goto_3
    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v4, v2, :cond_8

    .line 643
    invoke-virtual {v11, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 644
    new-instance v12, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v13, "UTF-8"

    invoke-static {v2, v13}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v3, v13}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v12}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    .line 645
    new-instance v12, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v13, "UTF-8"

    invoke-static {v2, v13}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v12, v3, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 642
    :cond_9
    add-int/lit8 v2, v4, 0x1

    move v4, v2

    goto :goto_3

    .line 648
    :cond_a
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v11, "UTF-8"

    invoke-static {v3, v11}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v4, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_8

    .line 649
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v4, "UTF-8"

    invoke-static {v1, v4}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v3, v2, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2

    .line 654
    :cond_b
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "searchType"

    invoke-direct {v1, v2, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 655
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "facetsOnly"

    invoke-static/range {p5 .. p5}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 657
    if-eqz p2, :cond_c

    invoke-virtual/range {p2 .. p2}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_c

    .line 658
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "storeId"

    move-object/from16 v0, p2

    invoke-direct {v1, v2, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 661
    :cond_c
    const/4 v1, 0x0

    const/4 v2, 0x1

    :try_start_0
    invoke-static {v9, v8, v7, v1, v2}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    .line 662
    new-instance v2, Lcom/bestbuy/android/api/lib/models/search/SiSearch;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;-><init>()V

    .line 663
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 664
    invoke-virtual {v3, v1, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/SiSearch;

    .line 665
    if-eqz v1, :cond_1a

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->getSi()Lcom/bestbuy/android/api/lib/models/search/Si;

    move-result-object v2

    if-eqz v2, :cond_1a

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->getSi()Lcom/bestbuy/android/api/lib/models/search/Si;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/Si;->getResponse()Lcom/bestbuy/android/api/lib/models/search/Response;

    move-result-object v2

    if-eqz v2, :cond_1a

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->getSi()Lcom/bestbuy/android/api/lib/models/search/Si;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/Si;->getResponse()Lcom/bestbuy/android/api/lib/models/search/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/Response;->getSearchApi()Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v2

    if-eqz v2, :cond_1a

    .line 667
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->getSi()Lcom/bestbuy/android/api/lib/models/search/Si;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Si;->getResponse()Lcom/bestbuy/android/api/lib/models/search/Response;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Response;->getSearchApi()Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v2

    .line 669
    if-eqz v2, :cond_e

    .line 670
    const/4 v1, 0x0

    move v3, v1

    :goto_4
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v3, v1, :cond_d

    .line 671
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getSkuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 670
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_4

    .line 673
    :cond_d
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setSkuList(Ljava/util/ArrayList;)V

    .line 674
    invoke-static {v6}, Lgq;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v1

    .line 675
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setSkuDetails(Ljava/util/ArrayList;)V

    .line 678
    :cond_e
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 679
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_13

    .line 680
    const/4 v1, 0x0

    move v4, v1

    :goto_5
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v4, v1, :cond_12

    .line 681
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getSystemName()Ljava/lang/String;

    move-result-object v1

    const-string v3, "Features Dynamic - Hidden"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getSystemName()Ljava/lang/String;

    move-result-object v1

    const-string v3, "Features (Hidden) DO NOT UNHIDE"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v1

    const-string v3, "subclassid_facet"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Facets;->isDisplayContext()Ljava/lang/String;

    move-result-object v1

    const-string v3, "No"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 680
    :cond_f
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    goto :goto_5

    .line 684
    :cond_10
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 686
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getValues()Ljava/util/ArrayList;

    move-result-object v6

    .line 687
    if-eqz v6, :cond_f

    .line 688
    const/4 v1, 0x0

    move v3, v1

    :goto_6
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v3, v1, :cond_f

    .line 689
    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_11

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_11

    .line 690
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v7

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getCategoryPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v8, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 688
    :cond_11
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_6

    .line 695
    :cond_12
    invoke-virtual {v2, v5}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setFacets(Ljava/util/ArrayList;)V

    .line 698
    :cond_13
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 699
    const/4 v1, 0x0

    move v5, v1

    :goto_7
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->getAppliedFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v5, v1, :cond_19

    .line 700
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->getAppliedFacets()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/AppliedFacets;

    .line 701
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/AppliedFacets;->getId()Ljava/lang/String;

    move-result-object v7

    .line 702
    const-string v3, "category_facet"

    invoke-virtual {v7, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_14

    .line 703
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/AppliedFacets;->getValues()Ljava/util/ArrayList;

    move-result-object v1

    .line 704
    invoke-virtual {v6, v7, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 706
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/4 v4, 0x1

    if-le v3, v4, :cond_16

    .line 707
    invoke-virtual {v6, v7, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 723
    :cond_14
    :goto_8
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->getCategoryFacet()Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;

    move-result-object v1

    .line 724
    if-eqz v1, :cond_15

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->getCategoryPath()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_15

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->getCategoryPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_15

    .line 725
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->getCategoryPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_15

    .line 726
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 727
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/CategoryFacets;->getCategoryName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 728
    const-string v1, "category_facet"

    invoke-virtual {v6, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 699
    :cond_15
    add-int/lit8 v1, v5, 0x1

    move v5, v1

    goto :goto_7

    .line 709
    :cond_16
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v3, "["

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "]"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "\\"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 710
    const-string v1, "|"

    invoke-virtual {v4, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 711
    new-instance v3, Ljava/util/ArrayList;

    const-string v1, "\\|"

    invoke-virtual {v4, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 712
    const/4 v1, 0x0

    move v4, v1

    :goto_9
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v4, v1, :cond_17

    .line 713
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 714
    invoke-virtual {v3, v4, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 712
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    goto :goto_9

    :cond_17
    move-object v1, v3

    .line 720
    :goto_a
    invoke-virtual {v6, v7, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_8

    .line 735
    :catch_0
    move-exception v1

    .line 736
    sget-object v2, Lgq;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error making GET request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 737
    throw v1

    .line 717
    :cond_18
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 718
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_a

    .line 732
    :cond_19
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setRequestedFacets(Ljava/util/HashMap;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-object v1, v2

    .line 734
    :goto_b
    return-object v1

    :cond_1a
    move-object v1, v5

    goto :goto_b
.end method

.method public static a(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
    .locals 9

    .prologue
    .line 380
    const/4 v2, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-static/range {v0 .. v8}, Lgq;->a(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;
    .locals 11
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
    .line 384
    new-instance v2, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;-><init>()V

    .line 385
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v3

    .line 386
    const-string v1, ""

    .line 387
    const-string v1, ""

    .line 388
    const-string v4, ""

    .line 389
    const/4 v4, 0x1

    invoke-static {v4}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v4

    .line 390
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 391
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 392
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 393
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 395
    const-string v9, "RecentlyRemoved"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string v9, "BundleItems"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string v9, "PLP"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_0

    const-string v9, "Best-Match"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 396
    :cond_0
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->setTotalCount(I)V

    .line 397
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v1

    move/from16 v0, p7

    if-le v1, v0, :cond_3

    .line 398
    add-int/lit8 v1, p6, -0x1

    mul-int v3, v1, p7

    .line 399
    add-int v1, v3, p7

    .line 400
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-le v1, v4, :cond_1

    .line 401
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 402
    :cond_1
    invoke-virtual {p2, v3, v1}, Ljava/util/ArrayList;->subList(II)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 461
    :goto_0
    const-string v1, "MostPopular"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "RecenltyViewed"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "CustomerAlsoBought"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "CustomerAlsoViewed"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "Trending"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_14

    .line 462
    :cond_2
    const/4 v1, 0x1

    move/from16 v0, p6

    if-le v0, v1, :cond_13

    const/16 v1, 0x32

    move/from16 v0, p7

    if-ne v0, v1, :cond_13

    .line 463
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 464
    if-eqz v6, :cond_12

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/16 v4, 0x18

    if-le v1, v4, :cond_12

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v1

    move/from16 v0, p7

    if-gt v1, v0, :cond_12

    .line 465
    const/16 v1, 0x19

    :goto_1
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v1, v4, :cond_11

    .line 466
    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 465
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 404
    :cond_3
    invoke-virtual {v6, p2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 407
    :cond_4
    const-string v9, "BestSelling"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 408
    if-eqz p5, :cond_5

    invoke-virtual/range {p5 .. p5}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 409
    :cond_5
    const-string p5, "all"

    .line 410
    :cond_6
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "/api/category/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/store/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move-object/from16 v0, p5

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/items/purchased"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 436
    :cond_7
    :goto_2
    :try_start_0
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, v3, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 437
    const/4 v3, 0x0

    const/4 v9, 0x1

    invoke-static {v1, v5, v4, v3, v9}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    .line 438
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 439
    const-string v1, "si"

    invoke-virtual {v3, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 440
    const-string v3, "response"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 441
    const-string v3, "recommendations"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 442
    const-string v3, "skus"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 443
    if-eqz v3, :cond_10

    .line 444
    const/4 v1, 0x0

    :goto_3
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v1, v4, :cond_10

    .line 445
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    .line 446
    const-string v5, "skuId"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 447
    const-string v5, "ep"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v7, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 448
    const-string v5, "summary"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 449
    const-string v5, "parentCategory"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 450
    const-string v5, "categoryId"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 444
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 411
    :cond_8
    const-string v9, "Trending"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 412
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "/si/recommendations/trendingMostPopular/cat00000/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p7

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 414
    :cond_9
    const-string v9, "RecenltyViewed"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 415
    invoke-static {p1}, Lgf;->a(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_a

    .line 416
    invoke-static {}, Lgg;->b()Ljava/lang/String;

    move-result-object v1

    .line 417
    invoke-static {p1, v1}, Lgf;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 421
    :goto_4
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "/si/recommendations/recentlyViewed/"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p7

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 419
    :cond_a
    invoke-static {p1}, Lgf;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    goto :goto_4

    .line 422
    :cond_b
    const-string v9, "Recommended"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_c

    .line 423
    invoke-static {p1}, Lgf;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 424
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "/api/context/"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/items/recommended.json"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 425
    :cond_c
    const-string v9, "CustomerAlsoBought"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_d

    .line 426
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "/si/recommendations/alsoBought/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p7

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 427
    :cond_d
    const-string v9, "CustomerAlsoViewed"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_e

    .line 428
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "/si/recommendations/alsoViewed/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p7

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 429
    :cond_e
    const-string v9, "MostPopular"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_f

    .line 430
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "/si/recommendations/mostPopular/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    move/from16 v0, p7

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 431
    :cond_f
    const-string v9, "Similar"

    invoke-virtual {p0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 432
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "/api/item/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v9, "/similarproducts.json"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_2

    .line 454
    :cond_10
    :try_start_1
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->setTotalCount(I)V

    .line 455
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->setSkuList(Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 456
    :catch_0
    move-exception v1

    .line 457
    sget-object v2, Lgq;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not get Most Popular Products Data: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 458
    throw v1

    .line 468
    :cond_11
    invoke-static {v3}, Lgq;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v1

    .line 469
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->setBbyProducts(Ljava/util/ArrayList;)V

    .line 479
    :cond_12
    :goto_5
    return-object v2

    .line 471
    :cond_13
    const/4 v1, 0x1

    move/from16 v0, p6

    if-ne v0, v1, :cond_12

    .line 472
    invoke-static {v6}, Lgq;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v1

    .line 473
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->setBbyProducts(Ljava/util/ArrayList;)V

    goto :goto_5

    .line 476
    :cond_14
    invoke-static {v6}, Lgq;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v1

    .line 477
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->setBbyProducts(Ljava/util/ArrayList;)V

    goto :goto_5
.end method

.method public static a()Lgr;
    .locals 1

    .prologue
    .line 149
    sget-object v0, Lgq;->b:Lgr;

    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 1407
    const-string v1, ""

    .line 1408
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1410
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/si/d/scheduling/stores/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/appointments"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1411
    const/4 v2, 0x0

    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1412
    new-instance v3, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;-><init>()V

    .line 1413
    invoke-virtual {v3, p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setDate(Ljava/lang/String;)V

    .line 1414
    invoke-virtual {v3, p2}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setTime(Ljava/lang/String;)V

    .line 1415
    invoke-virtual {v3, p3}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setFirstName(Ljava/lang/String;)V

    .line 1416
    invoke-virtual {v3, p4}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setLastName(Ljava/lang/String;)V

    .line 1417
    invoke-virtual {v3, p5}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setEmailAddress(Ljava/lang/String;)V

    .line 1418
    invoke-virtual {v3, p6}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setPhoneNumber(Ljava/lang/String;)V

    .line 1419
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/blueshirt/AppoinmentRequest;->setSendEmail(Z)V

    .line 1420
    new-instance v4, Lgy;

    invoke-direct {v4}, Lgy;-><init>()V

    invoke-virtual {v4, v3}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v3

    .line 1421
    const-string v4, "application/json"

    invoke-static {v1, v0, v2, v3, v4}, Lgw;->b(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1429
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1430
    if-eqz v2, :cond_0

    .line 1431
    const-string v1, "si"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 1432
    if-eqz v1, :cond_0

    .line 1433
    const-string v2, "response"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 1434
    if-eqz v1, :cond_0

    .line 1435
    const-string v0, "appointmentId"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1439
    :cond_0
    return-object v0
.end method

.method public static a(Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Ljava/util/ArrayList;
    .locals 6
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
    const/4 v1, 0x0

    const/4 v3, 0x1

    .line 291
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 292
    const-string v2, ""

    .line 293
    invoke-static {v3}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v2

    .line 294
    const-string v3, ""

    .line 295
    if-nez p0, :cond_0

    .line 296
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/si/recommendations/trendingMostPopular/cat00000/10"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 300
    :goto_0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 302
    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_0
    invoke-static {v0, v3, v2, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 303
    new-instance v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;-><init>()V

    .line 304
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 305
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    .line 306
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;->getSkuList()Ljava/util/ArrayList;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 312
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;->getSkuList()Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 314
    :goto_1
    return-object v0

    .line 298
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/home/Recommendation;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    move-object v0, v1

    .line 314
    goto :goto_1

    .line 315
    :catch_0
    move-exception v0

    .line 316
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get Trending Products Data: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    throw v0
.end method

.method private static a(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 938
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;->getSi()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIPageConfiguration;->getResponse()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationInnerResponse;->getPageConfiguration()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->getWidgets()Ljava/util/List;

    move-result-object v4

    .line 939
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 940
    if-eqz v4, :cond_1

    move v1, v2

    .line 941
    :goto_0
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 942
    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->getOffers()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->getOffers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    move v3, v2

    .line 943
    :goto_1
    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->getOffers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v3, v0, :cond_0

    .line 944
    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->getOffers()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 943
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    .line 941
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 949
    :cond_1
    return-object v5
.end method

.method private static a(Lcom/bestbuy/android/api/lib/models/pdp/Requirement;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/api/lib/models/pdp/Requirement;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Specification;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1024
    if-eqz p1, :cond_4

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1025
    new-instance v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;-><init>()V

    .line 1026
    const-string v1, "Specifications"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setDisplayName(Ljava/lang/String;)V

    .line 1027
    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setValue(Ljava/lang/String;)V

    .line 1028
    const/4 v1, 0x0

    invoke-virtual {p1, v1, v0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 1031
    :goto_0
    if-eqz p0, :cond_3

    .line 1032
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getMacSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1033
    new-instance v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;-><init>()V

    .line 1034
    const-string v1, "Mac Requirements"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setDisplayName(Ljava/lang/String;)V

    .line 1035
    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setValue(Ljava/lang/String;)V

    .line 1036
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1037
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getMacSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1039
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getPcSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1040
    new-instance v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;-><init>()V

    .line 1041
    const-string v1, "PC Requirements"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setDisplayName(Ljava/lang/String;)V

    .line 1042
    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setValue(Ljava/lang/String;)V

    .line 1043
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1044
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getPcSpecifications()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1046
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getDownload()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 1047
    new-instance v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;-><init>()V

    .line 1048
    const-string v1, "Download Requirements"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setDisplayName(Ljava/lang/String;)V

    .line 1049
    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setValue(Ljava/lang/String;)V

    .line 1050
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1051
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getDownload()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1053
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getSystem()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 1054
    new-instance v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;-><init>()V

    .line 1055
    const-string v1, "System Requirements"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setDisplayName(Ljava/lang/String;)V

    .line 1056
    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->setValue(Ljava/lang/String;)V

    .line 1057
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1058
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/pdp/Requirement;->getSystem()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1061
    :cond_3
    return-object p1

    .line 1030
    :cond_4
    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    goto/16 :goto_0
.end method

.method public static a(Lft;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 6
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
    .line 576
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 577
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/search/suggest/www?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 579
    const/4 v1, 0x0

    invoke-static {v1}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v1

    .line 581
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 582
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "query"

    const-string v5, "UTF-8"

    invoke-static {p1, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 583
    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v0, v2, v1, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 584
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 585
    const-string v0, "si"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 586
    const-string v1, "response"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 587
    const-string v1, "suggestions"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/search/SuggestedSearch;->getSuggestionsList(Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;IIZ)Ljava/util/ArrayList;
    .locals 2
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
    .line 356
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 357
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/recommendations/mostPopular/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 358
    invoke-static {v0}, Lgq;->p(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static declared-synchronized a(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 7
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
    const/4 v1, 0x0

    .line 742
    const-class v3, Lgq;

    monitor-enter v3

    :try_start_0
    const-string v0, ""

    .line 743
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v4

    .line 744
    invoke-virtual {p0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 745
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 766
    :goto_0
    monitor-exit v3

    return-object v0

    .line 746
    :cond_0
    :try_start_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 747
    const/4 v0, 0x0

    move v2, v0

    :goto_1
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_2

    .line 748
    invoke-virtual {p0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 749
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 750
    invoke-virtual {p0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 751
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-eq v2, v0, :cond_1

    .line 752
    const-string v0, ","

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 747
    :cond_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    .line 755
    :cond_2
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 756
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, v4, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "/si/products/pricesAndSummaries?"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "skus="

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 757
    const/4 v2, 0x1

    invoke-static {v2}, Lgq;->c(Z)Ljava/util/List;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    .line 759
    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    :try_start_2
    invoke-static {v0, v4, v2, v5, v6}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 760
    new-instance v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;-><init>()V

    .line 761
    new-instance v4, Lgy;

    invoke-direct {v4}, Lgy;-><init>()V

    .line 762
    invoke-virtual {v4, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    .line 763
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    if-eqz v2, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getSkuList()Ljava/util/ArrayList;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 764
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getSkuList()Ljava/util/ArrayList;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    goto/16 :goto_0

    :cond_3
    move-object v0, v1

    .line 766
    goto/16 :goto_0

    .line 767
    :catch_0
    move-exception v0

    .line 768
    :try_start_3
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error making GET request: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 769
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 742
    :catchall_0
    move-exception v0

    monitor-exit v3

    throw v0
.end method

.method private static a(Ljava/util/List;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 828
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 830
    const/4 v2, 0x0

    const/4 v3, 0x1

    :try_start_0
    invoke-static {p1, v0, p0, v2, v3}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 831
    new-instance v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;-><init>()V

    .line 832
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 833
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    .line 834
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;->getSkuList()Ljava/util/ArrayList;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 840
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getRecommendations()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Recommendations;->getSkuList()Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 843
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0

    .line 844
    :catch_0
    move-exception v0

    .line 845
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get Also Viewed Products Data: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 849
    throw v0
.end method

.method private static a(Lorg/json/JSONArray;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/browse/Category;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1087
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1089
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_3

    .line 1090
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 1091
    new-instance v3, Lcom/bestbuy/android/api/lib/models/browse/Category;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;-><init>()V

    .line 1092
    const-string v4, "widgetType"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/browse/Category;->setWidgetType(Ljava/lang/String;)V

    .line 1093
    const-string v4, "name"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/browse/Category;->setName(Ljava/lang/String;)V

    .line 1094
    const-string v4, "categoryId"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/browse/Category;->setCategoryId(Ljava/lang/String;)V

    .line 1095
    const-string v4, "displayOnly"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/browse/Category;->setDisplayOnly(Ljava/lang/String;)V

    .line 1096
    const-string v4, "searchPath"

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/api/lib/models/browse/Category;->setSearchPath(Ljava/lang/String;)V

    .line 1097
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getSearchPath()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getSearchPath()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getSearchPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1098
    :cond_0
    const-string v4, "groups"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 1099
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-lez v4, :cond_1

    .line 1100
    invoke-static {v2}, Lgq;->a(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/api/lib/models/browse/Category;->setGroups(Ljava/util/List;)V

    .line 1103
    :cond_1
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/browse/Category;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 1104
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1089
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0

    .line 1107
    :cond_3
    return-object v1
.end method

.method private static a(Z)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 153
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 154
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "Content-type"

    const-string v3, "application/json"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 155
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "Accept"

    const-string v3, "application/json"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 156
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "X-SI-API-VERSION"

    const-string v3, "1.0"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 157
    if-eqz p0, :cond_0

    .line 158
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    .line 159
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 160
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "X-SI-USER-UUID"

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 161
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "access_token"

    invoke-direct {v2, v3, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 164
    :cond_0
    return-object v0
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 125
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 126
    sget-object v0, Lgr;->a:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    .line 137
    :goto_0
    return-void

    .line 127
    :cond_0
    sget-object v0, Lft;->f:Lft;

    if-ne p0, v0, :cond_1

    .line 128
    sget-object v0, Lgr;->b:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    goto :goto_0

    .line 129
    :cond_1
    sget-object v0, Lft;->h:Lft;

    if-ne p0, v0, :cond_2

    .line 130
    sget-object v0, Lgr;->c:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    goto :goto_0

    .line 131
    :cond_2
    sget-object v0, Lft;->d:Lft;

    if-ne p0, v0, :cond_3

    .line 132
    sget-object v0, Lgr;->d:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    goto :goto_0

    .line 133
    :cond_3
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_4

    .line 134
    sget-object v0, Lgr;->e:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    goto :goto_0

    .line 136
    :cond_4
    sget-object v0, Lgr;->a:Lgr;

    sput-object v0, Lgq;->b:Lgr;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 144
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lgr;->a(Ljava/lang/String;)Lgr;

    move-result-object v0

    .line 145
    iput-object p0, v0, Lgr;->f:Ljava/lang/String;

    .line 146
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 1456
    const-string v0, ""

    .line 1457
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1458
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/d/scheduling/stores/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/appointments/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1459
    invoke-static {v4}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v1

    .line 1460
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "emailAddress"

    invoke-direct {v2, v3, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1461
    invoke-static {v0, v5, v1, v5, v4}, Lgw;->c(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    .line 1462
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 518
    const-string v0, ""

    .line 519
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v1

    .line 520
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    .line 521
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v2

    .line 522
    const/4 v3, 0x0

    invoke-static {v3}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v3

    .line 523
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 524
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "access_token"

    invoke-direct {v4, v5, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 525
    :cond_0
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 526
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, v2, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/users/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/devices"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 527
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "uuid"

    invoke-direct {v2, v4, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 531
    :goto_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 532
    const-string v2, "device-token"

    invoke-virtual {v1, v2, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 533
    const-string v2, "operating-system"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 534
    const-string v2, "manufacturer"

    invoke-virtual {v1, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 535
    const-string v2, "model"

    invoke-virtual {v1, v2, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 536
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    .line 537
    const/4 v2, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v2, v3, v1, v4}, Lgw;->b(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 538
    return-void

    .line 529
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v2, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/devices"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 1443
    const-string v0, ""

    .line 1444
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1445
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/d/scheduling/stores/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/appointments/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1446
    invoke-static {v5}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v1

    .line 1447
    new-instance v2, Lcom/bestbuy/android/api/lib/models/blueshirt/UpdateAppointmentRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/blueshirt/UpdateAppointmentRequest;-><init>()V

    .line 1448
    invoke-virtual {v2, p1}, Lcom/bestbuy/android/api/lib/models/blueshirt/UpdateAppointmentRequest;->setDate(Ljava/lang/String;)V

    .line 1449
    invoke-virtual {v2, p2}, Lcom/bestbuy/android/api/lib/models/blueshirt/UpdateAppointmentRequest;->setTime(Ljava/lang/String;)V

    .line 1450
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 1451
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "emailAddress"

    invoke-direct {v3, v4, p3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1452
    const/4 v3, 0x0

    invoke-static {v0, v3, v1, v2, v5}, Lgw;->b(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    .line 1453
    return-void
.end method

.method public static b()Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;
    .locals 6

    .prologue
    .line 1065
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1066
    const/4 v1, 0x0

    invoke-static {v1}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v1

    .line 1067
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/catalog"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1069
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1070
    new-instance v3, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;-><init>()V

    .line 1072
    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_0
    invoke-static {v0, v2, v1, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1073
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1074
    const-string v0, "si"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "response"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 1075
    const-string v1, "groups"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 1076
    invoke-static {v0}, Lgq;->a(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v0

    .line 1077
    invoke-virtual {v3, v0}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->setHeader(Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1078
    return-object v3

    .line 1080
    :catch_0
    move-exception v0

    .line 1081
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getListData error : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1082
    throw v0
.end method

.method private static b(Ljava/lang/String;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;
    .locals 2

    .prologue
    .line 908
    new-instance v0, Lgy;

    invoke-direct {v0}, Lgy;-><init>()V

    .line 909
    new-instance v1, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;-><init>()V

    .line 910
    invoke-virtual {v0, p0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    .line 912
    return-object v0
.end method

.method public static b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 325
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 326
    const/4 v2, 0x0

    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 327
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/si/products/restrictedPriceBlock/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 328
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 330
    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_0
    invoke-static {v0, v3, v2, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 331
    new-instance v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;-><init>()V

    .line 332
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 333
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;

    .line 334
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 335
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SummariesPriceBlockResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 337
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0

    .line 338
    :catch_0
    move-exception v0

    .line 339
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get Restricted Price Block: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    throw v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 6
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
    const/4 v1, 0x0

    .line 1465
    const-string v0, ""

    .line 1466
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1467
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/d/scheduling/stores/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/slots"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1468
    const/4 v2, 0x0

    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1469
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1470
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "startDate"

    invoke-direct {v4, v5, p1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1471
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 1472
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "endDate"

    invoke-direct {v4, v5, p2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1474
    :cond_0
    invoke-static {v0, v3, v2, v1}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1475
    new-instance v2, Lcom/bestbuy/android/api/lib/models/blueshirt/TimeSlotResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/blueshirt/TimeSlotResponse;-><init>()V

    .line 1476
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 1477
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/blueshirt/TimeSlotResponse;

    .line 1478
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/TimeSlotResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1479
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/TimeSlotResponse;->getSi()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;

    move-result-object v0

    .line 1480
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1481
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SI;->getResponse()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Response;->getAppointmentSlots()Ljava/util/ArrayList;

    move-result-object v0

    .line 1483
    :goto_0
    return-object v0

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method private static b(Z)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 168
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 169
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "Content-type"

    const-string v3, "application/json"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 170
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "Accept"

    const-string v3, "application/json"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 171
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "X-SI-API-VERSION"

    const-string v3, "2.0"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 172
    if-eqz p0, :cond_0

    .line 173
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    .line 174
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 175
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "X-SI-USER-UUID"

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 176
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "access_token"

    invoke-direct {v2, v3, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 179
    :cond_0
    return-object v0
.end method

.method public static c(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 2
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
    .line 362
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 363
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/recommendations/recentlyViewed/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/10"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 364
    invoke-static {v0}, Lgq;->p(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method private static c(Z)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;"
        }
    .end annotation

    .prologue
    .line 183
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 184
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "Content-type"

    const-string v3, "application/json"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 185
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "Accept"

    const-string v3, "application/json"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 186
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "X-SI-API-VERSION"

    const-string v3, "3.0"

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 187
    if-eqz p0, :cond_0

    .line 188
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    .line 189
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 190
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "X-SI-USER-UUID"

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 191
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "access_token"

    invoke-direct {v2, v3, v1}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 194
    :cond_0
    return-object v0
.end method

.method public static d(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 2
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
    .line 368
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 369
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/recommendations/alsoViewed/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/10"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 370
    invoke-static {v0}, Lgq;->p(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static e(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 2
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
    .line 374
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 375
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/recommendations/alsoBought/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/10"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 376
    invoke-static {v0}, Lgq;->p(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static f(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/StoreList;
    .locals 4

    .prologue
    .line 498
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 499
    new-instance v0, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;-><init>()V

    .line 500
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 501
    invoke-virtual {v2, p0, v0}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;

    .line 502
    new-instance v2, Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;-><init>()V

    .line 503
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;->getSi()Lcom/bestbuy/android/api/lib/models/store/Si;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;->getSi()Lcom/bestbuy/android/api/lib/models/store/Si;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/Si;->getResponse()Lcom/bestbuy/android/api/lib/models/store/Response;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 504
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoresResponse;->getSi()Lcom/bestbuy/android/api/lib/models/store/Si;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Si;->getResponse()Lcom/bestbuy/android/api/lib/models/store/Response;

    move-result-object v0

    .line 505
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Response;->getStores()[Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v3

    .line 506
    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 507
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->setStores(Ljava/util/ArrayList;)V

    .line 508
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/Response;->getNext()Ljava/lang/String;

    move-result-object v0

    .line 509
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 510
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->setHasNext(Z)V

    .line 514
    :cond_0
    :goto_0
    return-object v2

    .line 512
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->setHasNext(Z)V

    goto :goto_0
.end method

.method public static g(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 3
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
    .line 820
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 821
    const/4 v1, 0x1

    invoke-static {v1}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v1

    .line 822
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 823
    invoke-static {v1, v0}, Lgq;->a(Ljava/util/List;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static h(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    .locals 5

    .prologue
    .line 867
    new-instance v1, Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;-><init>()V

    .line 870
    :try_start_0
    new-instance v0, Lcom/bestbuy/android/api/lib/models/search/SiSearch;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;-><init>()V

    .line 871
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 872
    invoke-virtual {v2, p0, v0}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/SiSearch;

    .line 873
    if-eqz v0, :cond_0

    .line 874
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SiSearch;->getSi()Lcom/bestbuy/android/api/lib/models/search/Si;

    move-result-object v0

    .line 875
    if-eqz v0, :cond_0

    .line 876
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Si;->getResponse()Lcom/bestbuy/android/api/lib/models/search/Response;

    move-result-object v0

    .line 877
    if-eqz v0, :cond_0

    .line 878
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Response;->getSearchApi()Lcom/bestbuy/android/api/lib/models/search/SearchApi;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 885
    :goto_0
    return-object v0

    .line 882
    :catch_0
    move-exception v0

    .line 883
    sget-object v2, Lgq;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Couldn\'t parse custom offer deals data"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method public static declared-synchronized i(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 916
    const-class v1, Lgq;

    monitor-enter v1

    :try_start_0
    const-string v0, ""

    .line 917
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 918
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 919
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v0, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 920
    const/4 v2, 0x1

    invoke-static {v2}, Lgq;->b(Z)Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 922
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_1
    invoke-static {v0, v3, v2, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 923
    new-instance v2, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;-><init>()V

    .line 924
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 925
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;

    .line 926
    invoke-static {v0}, Lgq;->a(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfigurationResponse;)Ljava/util/ArrayList;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 931
    monitor-exit v1

    return-object v0

    .line 927
    :catch_0
    move-exception v0

    .line 928
    :try_start_2
    sget-object v2, Lgq;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error making GET request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 929
    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 916
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static j(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 1161
    const-string v0, ""

    .line 1163
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v0

    .line 1164
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lgr;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/si/pdp/buyingOptions/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1165
    invoke-static {v3}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1167
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x1

    :try_start_0
    invoke-static {v0, v3, v2, v4, v5}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1168
    new-instance v2, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PDPBuyingOptionsParent;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PDPBuyingOptionsParent;-><init>()V

    .line 1169
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    .line 1170
    invoke-virtual {v3, v0, v2}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PDPBuyingOptionsParent;

    .line 1171
    if-eqz v0, :cond_0

    .line 1172
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PDPBuyingOptionsParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SIBuyingOptions;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SIBuyingOptions;->getResponse()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1178
    :goto_0
    return-object v0

    .line 1174
    :catch_0
    move-exception v0

    .line 1175
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error making GET request: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1176
    throw v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method public static k(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 1204
    const-string v0, ""

    .line 1205
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1206
    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1207
    const-string v0, ""

    .line 1208
    if-eqz p0, :cond_0

    .line 1209
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/pdp/castAndCrew/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1212
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1214
    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v1, v2, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1216
    new-instance v1, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;-><init>()V

    .line 1217
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 1218
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewParent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1220
    return-object v0

    .line 1221
    :catch_0
    move-exception v0

    .line 1222
    throw v0
.end method

.method public static l(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 1252
    const-string v0, ""

    .line 1253
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1254
    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1255
    const-string v0, ""

    .line 1256
    if-eqz p0, :cond_0

    .line 1257
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/pdp/episodes/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1260
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1262
    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v1, v2, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1264
    new-instance v1, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;-><init>()V

    .line 1265
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 1266
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/episodes/PDPEpisodesParent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1268
    return-object v0

    .line 1269
    :catch_0
    move-exception v0

    .line 1270
    throw v0
.end method

.method public static m(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 1300
    const-string v0, ""

    .line 1301
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1302
    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1303
    const-string v0, ""

    .line 1304
    if-eqz p0, :cond_0

    .line 1306
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/pdp/movieDetails/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1308
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1310
    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v1, v2, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1311
    new-instance v1, Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;-><init>()V

    .line 1312
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 1313
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;

    .line 1314
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;->getResponse()Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 1315
    :catch_0
    move-exception v0

    .line 1316
    throw v0
.end method

.method public static n(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 1321
    const-string v0, ""

    .line 1322
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1323
    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1324
    const-string v0, ""

    .line 1325
    if-eqz p0, :cond_0

    .line 1326
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/pdp/musicDetails/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1328
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1330
    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v1, v2, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1331
    new-instance v1, Lcom/bestbuy/android/api/lib/models/pdpmusic/PDPMusicParent;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/pdpmusic/PDPMusicParent;-><init>()V

    .line 1332
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 1333
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpmusic/PDPMusicParent;

    .line 1334
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/PDPMusicParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdpmusic/SIMusic;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpmusic/SIMusic;->getResponse()Lcom/bestbuy/android/api/lib/models/pdpmusic/MusicResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 1335
    :catch_0
    move-exception v0

    .line 1336
    throw v0
.end method

.method public static o(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 1361
    const-string v0, ""

    .line 1362
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 1363
    invoke-static {v2}, Lgq;->a(Z)Ljava/util/List;

    move-result-object v2

    .line 1364
    const-string v0, ""

    .line 1365
    if-eqz p0, :cond_0

    .line 1366
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/si/pdp/accessories/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1368
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1370
    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {v0, v1, v2, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1371
    new-instance v1, Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;

    invoke-direct {v1}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;-><init>()V

    .line 1372
    new-instance v2, Lgy;

    invoke-direct {v2}, Lgy;-><init>()V

    .line 1373
    invoke-virtual {v2, v0, v1}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;

    .line 1374
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/PDPAccessoriesParent;->getSi()Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpaccessories/SIAccessories;->getResponse()Lcom/bestbuy/android/api/lib/models/pdpaccessories/AccessoriesResponse;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    .line 1375
    :catch_0
    move-exception v0

    .line 1376
    throw v0
.end method

.method private static p(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 7
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
    const/4 v2, 0x1

    const/4 v0, 0x0

    .line 220
    const-string v1, ""

    .line 221
    invoke-static {v2}, Lgq;->b(Z)Ljava/util/List;

    move-result-object v1

    .line 223
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x1

    :try_start_0
    invoke-static {p0, v2, v1, v3, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    .line 224
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 225
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 226
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 227
    const-string v1, "si"

    invoke-virtual {v4, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 228
    const-string v4, "response"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 229
    const-string v4, "recommendations"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 230
    const-string v4, "skus"

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 231
    if-eqz v4, :cond_0

    move v1, v0

    .line 232
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v1, v5, :cond_0

    .line 233
    invoke-virtual {v4, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    .line 234
    const-string v6, "skuId"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 235
    const-string v6, "ep"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 232
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 238
    :cond_0
    invoke-static {v2}, Lgq;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v4

    move v2, v0

    .line 239
    :goto_1
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_1

    .line 240
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 241
    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 242
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setEp(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 239
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    .line 278
    :catch_0
    move-exception v0

    .line 279
    sget-object v1, Lgq;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not get Trending Products Data: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    throw v0

    .line 244
    :cond_1
    return-object v4
.end method
