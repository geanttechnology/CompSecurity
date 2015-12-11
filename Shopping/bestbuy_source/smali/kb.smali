.class public Lkb;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 3

    .prologue
    .line 104
    const-string v0, "MdotWebFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 143
    :goto_0
    return-object v0

    .line 106
    :cond_0
    const-string v0, "BrowseCategoryFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 107
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;-><init>()V

    goto :goto_0

    .line 108
    :cond_1
    const-string v0, "HomeTabFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 109
    new-instance v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;-><init>()V

    goto :goto_0

    .line 110
    :cond_2
    const-string v0, "MyBBY"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 111
    new-instance v0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;-><init>()V

    goto :goto_0

    .line 112
    :cond_3
    const-string v0, "GHPBanners"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 113
    new-instance v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;-><init>()V

    goto :goto_0

    .line 114
    :cond_4
    const-string v0, "DOD"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 115
    new-instance v0, Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;-><init>()V

    goto :goto_0

    .line 116
    :cond_5
    const-string v0, "Deals"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 117
    new-instance v0, Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/DealsHomeCard;-><init>()V

    goto :goto_0

    .line 118
    :cond_6
    const-string v0, "Trending"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 119
    new-instance v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;-><init>()V

    goto :goto_0

    .line 120
    :cond_7
    const-string v0, "RecentlyViewed"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 121
    new-instance v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;-><init>()V

    goto :goto_0

    .line 122
    :cond_8
    const-string v0, "Contact"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 123
    new-instance v0, Lcom/bestbuy/android/activities/home/ContactHomeCard;

    const-string v1, "Contact"

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/home/ContactHomeCard;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 124
    :cond_9
    const-string v0, "AppSettingsFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 125
    new-instance v0, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsFragment;-><init>()V

    goto/16 :goto_0

    .line 126
    :cond_a
    const-string v0, "ContactBestBuyFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 127
    new-instance v0, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/contactdetails/ContactBestBuyFragment;-><init>()V

    goto/16 :goto_0

    .line 128
    :cond_b
    const-string v0, "PrivacyTermsFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 129
    new-instance v0, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/privacyandterms/PrivacyTermsFragment;-><init>()V

    goto/16 :goto_0

    .line 130
    :cond_c
    const-string v0, "WeeklyVideoCardFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 131
    new-instance v0, Lcom/bestbuy/android/activities/home/WeeklyVideoCardFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/home/WeeklyVideoCardFragment;-><init>()V

    goto/16 :goto_0

    .line 132
    :cond_d
    const-string v0, "StoreSearchMapFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 133
    new-instance v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;-><init>()V

    goto/16 :goto_0

    .line 134
    :cond_e
    const-string v0, "AppSettingsEnvironmentFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 135
    new-instance v0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;-><init>()V

    goto/16 :goto_0

    .line 136
    :cond_f
    const-string v0, "NoSearchResultFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 137
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;-><init>()V

    goto/16 :goto_0

    .line 138
    :cond_10
    const-string v0, "NotificationsFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 139
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 140
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,service"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "SERV"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    sget-object v1, Llu;->q:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 143
    new-instance v0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;-><init>()V

    goto/16 :goto_0

    .line 145
    :cond_11
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 3

    .prologue
    .line 56
    const-string v0, "PDPSkuAndTitleFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-direct {v0, p2, p3, p4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)V

    .line 85
    :goto_0
    return-object v0

    .line 58
    :cond_0
    const-string v0, "PDPSourceDetailFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 59
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    invoke-direct {v0, p2, p3, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V

    goto :goto_0

    .line 60
    :cond_1
    const-string v0, "PDPImageGalleryFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 61
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPImageGalleryFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto :goto_0

    .line 62
    :cond_2
    const-string v0, "PDPPriceBlockFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 63
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;

    invoke-direct {v0, p2, p3, p4, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPPriceBlockFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V

    goto :goto_0

    .line 64
    :cond_3
    const-string v0, "PDPOptionFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 65
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto :goto_0

    .line 66
    :cond_4
    const-string v0, "PDPAvailabilityFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 67
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-direct {v0, p2, p3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;)V

    goto :goto_0

    .line 68
    :cond_5
    const-string v0, "ProductAvailabilityFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 69
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto :goto_0

    .line 70
    :cond_6
    const-string v0, "PDPReviewAndRatingsFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 71
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;

    invoke-direct {v0, p2, p3, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V

    goto :goto_0

    .line 72
    :cond_7
    const-string v0, "PDPAccessoriesFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 73
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAccessoriesFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto :goto_0

    .line 74
    :cond_8
    const-string v0, "PDPRequiredAccessoriesFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 75
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPRequiredAccessoriesFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto :goto_0

    .line 76
    :cond_9
    const-string v0, "PDPCustomerAlsoBoughtFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 77
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto/16 :goto_0

    .line 78
    :cond_a
    const-string v0, "PDPCustomerAlsoViewedFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 79
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto/16 :goto_0

    .line 80
    :cond_b
    const-string v0, "PDPFooterFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 81
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFooterFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFooterFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto/16 :goto_0

    .line 82
    :cond_c
    const-string v0, "EmptyFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 83
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/EmptyFragment;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/EmptyFragment;-><init>(Lcom/bestbuy/android/api/lib/models/product/Product;)V

    goto/16 :goto_0

    .line 84
    :cond_d
    const-string v0, "PDPOverviewFragment"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 85
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;

    invoke-direct {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    goto/16 :goto_0

    .line 87
    :cond_e
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 3

    .prologue
    .line 92
    const-string v0, "OpenBoxListFragmentContainer"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 97
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-direct {v0, p1, p2}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;-><init>(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    return-object v0

    .line 99
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unknown fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
