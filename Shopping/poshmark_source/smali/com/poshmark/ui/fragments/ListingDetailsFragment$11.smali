.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingHeader(Landroid/widget/LinearLayout;)V
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
    .line 652
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 655
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BannerInfo;->destination_url:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 656
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BannerInfo;->destination_url:Ljava/lang/String;

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 657
    .local v0, "deepLink":Landroid/net/Uri;
    invoke-static {v0}, Lcom/poshmark/utils/DeepLinkUtils;->isValidDeepLink(Landroid/net/Uri;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 658
    invoke-static {v0}, Lcom/poshmark/utils/DeepLinkUtils;->getDeepLinkLaunchInfo(Landroid/net/Uri;)Lcom/poshmark/utils/DeepLinkLaunchInfo;

    move-result-object v1

    .line 659
    .local v1, "deepLinkInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    if-eqz v1, :cond_1

    iget-object v3, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    if-eqz v3, :cond_1

    .line 660
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BannerInfo;->banner_tap_analytics_event:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 661
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    iget-object v6, v6, Lcom/poshmark/data_model/models/BannerInfo;->banner_tap_analytics_event:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 663
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMContainerActivity;

    .line 664
    .local v2, "parentActivity":Lcom/poshmark/ui/PMContainerActivity;
    iget-object v3, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->bundle:Landroid/os/Bundle;

    iget-object v4, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->fragmentClass:Ljava/lang/Class;

    iget-object v5, v1, Lcom/poshmark/utils/DeepLinkLaunchInfo;->data:Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 669
    .end local v0    # "deepLink":Landroid/net/Uri;
    .end local v1    # "deepLinkInfo":Lcom/poshmark/utils/DeepLinkLaunchInfo;
    .end local v2    # "parentActivity":Lcom/poshmark/ui/PMContainerActivity;
    :cond_1
    return-void
.end method
