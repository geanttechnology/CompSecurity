.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;
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
    .line 1218
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1221
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "buy_button_clicked"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1222
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    sget-object v2, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_SINGLE_LISTING:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/poshmark/utils/FBDPAHelper;->trackAddToCart(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V

    .line 1223
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    sget-object v2, Lcom/poshmark/utils/FBDPAHelper;->PURCHASE_TYPE_SINGLE_LISTING:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/poshmark/utils/FBDPAHelper;->trackListingPurchaseInitiated(Lcom/poshmark/data_model/models/ListingSummary;Ljava/lang/String;)V

    .line 1224
    new-instance v0, Lcom/poshmark/utils/CheckoutFlowHandler;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/CheckoutFlowHandler;-><init>(Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 1225
    .local v0, "checkoutFlowHandler":Lcom/poshmark/utils/CheckoutFlowHandler;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->beginCheckoutForListing(Lcom/poshmark/data_model/models/ListingSummary;)V

    .line 1226
    return-void
.end method
