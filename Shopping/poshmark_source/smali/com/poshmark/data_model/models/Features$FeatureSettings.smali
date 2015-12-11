.class Lcom/poshmark/data_model/models/Features$FeatureSettings;
.super Ljava/lang/Object;
.source "Features.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Features;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "FeatureSettings"
.end annotation


# instance fields
.field ac:Lcom/poshmark/data_model/models/inner_models/AutoCompleteFeature;

.field ael_nfs:Lcom/poshmark/data_model/models/inner_models/EditListingWithNFSFeature;

.field app_external_share:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

.field app_filter_bar_v2:Lcom/poshmark/data_model/models/inner_models/FilterBarv2Feature;

.field app_listing_details_add_to_bundle:Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

.field app_listing_details_v2:Lcom/poshmark/data_model/models/inner_models/ListingDetailsV2Feature;

.field app_share_via_fb_messenger:Lcom/poshmark/data_model/models/inner_models/ShareViaFBMessengerFeature;

.field app_shop_tab_luxury:Lcom/poshmark/data_model/models/inner_models/ShopTabLuxuryFeature;

.field app_trigger_app_rating:Lcom/poshmark/triggers/TriggerThresholds;

.field app_trigger_brand_share:Lcom/poshmark/triggers/TriggerThresholds;

.field feed_auto_refresh:Lcom/poshmark/data_model/models/inner_models/FeedAutoRefreshFeature;

.field feed_lazy_load:Lcom/poshmark/data_model/models/inner_models/FeedLazyLoadFeature;

.field listing:Lcom/poshmark/data_model/models/inner_models/ListingFeature;

.field mlf:Lcom/poshmark/data_model/models/inner_models/MyLikesFilterFeature;

.field offers:Lcom/poshmark/data_model/models/inner_models/MakeAnOfferFeature;

.field pd:Lcom/poshmark/data_model/models/inner_models/PriceDropFeature;

.field pinterest_share:Lcom/poshmark/data_model/models/inner_models/PinterestShareFeature;

.field rp:Lcom/poshmark/data_model/models/inner_models/SimilarListings;

.field sup_flow:Lcom/poshmark/data_model/models/inner_models/SignupFlowFeature;

.field final synthetic this$0:Lcom/poshmark/data_model/models/Features;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/Features;)V
    .locals 0

    .prologue
    .line 234
    iput-object p1, p0, Lcom/poshmark/data_model/models/Features$FeatureSettings;->this$0:Lcom/poshmark/data_model/models/Features;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
