.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupBottomBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0

    .prologue
    .line 1195
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1198
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    sget-object v2, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_OFFER:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/poshmark/utils/FBDPAHelper;->trackAddToCart(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V

    .line 1199
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "buyer_make_offer_link_tapped"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1200
    new-instance v0, Lcom/poshmark/utils/OfferFlowHandler;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/OfferFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 1201
    .local v0, "offerFlowHandler":Lcom/poshmark/utils/OfferFlowHandler;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/OfferFlowHandler;->beginCheckoutForListing(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 1202
    return-void
.end method
