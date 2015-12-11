.class public Lcom/poshmark/data_model/models/Features;
.super Ljava/util/Observable;
.source "Features.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/Features$FeatureSettings;
    }
.end annotation


# instance fields
.field feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

.field schema_version:I

.field updated_at:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/util/Observable;-><init>()V

    .line 31
    new-instance v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/models/Features$FeatureSettings;-><init>(Lcom/poshmark/data_model/models/Features;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    .line 234
    return-void
.end method


# virtual methods
.method public getAddToBundleButtonFeature()Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_add_to_bundle:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

    return-object v0
.end method

.method public getBrandShareTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_trigger_brand_share:Lcom/poshmark/triggers/TriggerThresholds;

    return-object v0
.end method

.method public getFbShareProTipInfo(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    .locals 1
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    if-eqz v0, :cond_0

    .line 191
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->getProTipInfo(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    move-result-object v0

    .line 193
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFeedAutoRefreshFeature()Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->feed_auto_refresh:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;

    return-object v0
.end method

.method public getLazyFeedLoadFeature()Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->feed_lazy_load:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;

    return-object v0
.end method

.method public getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->listing:Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    return-object v0
.end method

.method public getLuxuryFeature()Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_shop_tab_luxury:Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;

    return-object v0
.end method

.method public getRateAppTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_trigger_app_rating:Lcom/poshmark/triggers/TriggerThresholds;

    return-object v0
.end method

.method public getSimilarListingsFeature()Lcom/poshmark/data_model/models/inner_models/SimilarListings;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->rp:Lcom/poshmark/data_model/models/inner_models/SimilarListings;

    return-object v0
.end method

.method public isAddToBundleButtonFeatureEnabled()Z
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_add_to_bundle:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_add_to_bundle:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;->isEnabled()Z

    move-result v0

    .line 201
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAutoCompleteEnabled()Z
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->ac:Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->ac:Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;->isEnabled()Z

    move-result v0

    .line 37
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isBrandPriceDropEnabled()Z
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->br:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->br:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;->enabled:Z

    .line 89
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isBrandsFollowOnSignupEnabled()Z
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->sup_flow:Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->sup_flow:Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;->isBrandFollowEnabled()Z

    move-result v0

    .line 55
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEditListingWithNFSEnabled()Z
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->ael_nfs:Lcom/poshmark/data_model/models/inner_models/EditListingWithNFSFeature;

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->ael_nfs:Lcom/poshmark/data_model/models/inner_models/EditListingWithNFSFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/EditListingWithNFSFeature;->isEnabled()Z

    move-result v0

    .line 48
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFBMessengerSharingEnabled()Z
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_share_via_fb_messenger:Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_share_via_fb_messenger:Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;->isEnabled()Z

    move-result v0

    .line 129
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFbExplicitShareEnabled()Z
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->isEnabled()Z

    move-result v0

    .line 137
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFilterBarv2FeatureEnabled()Z
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_filter_bar_v2:Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;

    if-eqz v0, :cond_0

    .line 206
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_filter_bar_v2:Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;->isEnabled()Z

    move-result v0

    .line 208
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isListingDetailsPriceDropEnabled()Z
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->ld:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->ld:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;->enabled:Z

    .line 105
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isListingFeatureEnabled()Z
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->listing:Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->listing:Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->isEnabled()Z

    move-result v0

    .line 70
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isLuxuryFeatureEnabled()Z
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_shop_tab_luxury:Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;

    if-eqz v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_shop_tab_luxury:Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;->isEnabled()Z

    move-result v0

    .line 173
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMakeAnOfferEnabled()Z
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->offers:Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->offers:Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;->isEnabled()Z

    move-result v0

    .line 62
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMyLikesFiltersEnabled()Z
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->mlf:Lcom/poshmark/data_model/models/inner_models/MyLikesFilterFeature;

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->mlf:Lcom/poshmark/data_model/models/inner_models/MyLikesFilterFeature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/MyLikesFilterFeature;->isEnabled()Z

    move-result v0

    .line 165
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMyLikesPriceDropEnabled()Z
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->mlk:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->mlk:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;->enabled:Z

    .line 113
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isNewListingDetailsFeatureEnabled()Z
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_v2:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_v2:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;->isEnabled()Z

    move-result v0

    .line 121
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPinterestButtonEnabled()Z
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pinterest_share:Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pinterest_share:Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;->listing_flow_share:Z

    .line 219
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPinterestConnectionDialogShowable()Z
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pinterest_share:Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;

    if-eqz v0, :cond_0

    .line 226
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pinterest_share:Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;->listing_share_sheet_connect:Z

    .line 228
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShareProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z
    .locals 1
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->isProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z

    move-result v0

    .line 145
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShowRoomsEnabled()Z
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x0

    return v0
.end method

.method public isShowroomPriceDropEnabled()Z
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->shr:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    if-eqz v0, :cond_0

    .line 95
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;->shr:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/PriceDropFeature$SubFeature;->enabled:Z

    .line 97
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSimilarListingsFeatureEnabled()Z
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_v2:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;

    if-eqz v0, :cond_0

    .line 151
    iget-object v0, p0, Lcom/poshmark/data_model/models/Features;->feature_settings:Lcom/poshmark/data_model/models/Features$FeatureSettings;

    iget-object v0, v0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->app_listing_details_v2:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;->isEnabled()Z

    move-result v0

    .line 153
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
