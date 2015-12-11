.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;
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
    .line 1177
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1180
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "buyer_view_offer_link_tapped"

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v7, v7, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1181
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingDetails;->getOffersUrl()Ljava/lang/String;

    move-result-object v2

    .line 1182
    .local v2, "url":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 1183
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 1184
    .local v1, "b":Landroid/os/Bundle;
    const-string v3, "URL"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "https://www.poshmark.com/mapp/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1185
    const-string v3, "ANALYTICS_PAGE_NAME"

    const-string v4, "Offers"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1186
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 1187
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v3, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 1189
    .end local v0    # "activity":Lcom/poshmark/ui/PMActivity;
    .end local v1    # "b":Landroid/os/Bundle;
    :cond_0
    return-void
.end method
