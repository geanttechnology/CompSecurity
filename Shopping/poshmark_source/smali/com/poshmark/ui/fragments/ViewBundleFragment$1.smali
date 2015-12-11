.class Lcom/poshmark/ui/fragments/ViewBundleFragment$1;
.super Ljava/lang/Object;
.source "ViewBundleFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ViewBundleFragment;->createAllViews(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 156
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ViewBundleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "bundle"

    const-string v4, "view_unavailable_listings_in_bundle_tapped"

    const/4 v5, 0x0

    invoke-virtual {v0, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 158
    .local v1, "b":Landroid/os/Bundle;
    const-string v0, "NAME"

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ViewBundleFragment;->userName:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    const-string v0, "PARENT_ID"

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 160
    const-string v0, "SELLER_USER_NAME"

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMBundle;->getSellerUsername()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 161
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    const-class v2, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;->this$0:Lcom/poshmark/ui/fragments/ViewBundleFragment;

    iget v5, v5, Lcom/poshmark/ui/fragments/ViewBundleFragment;->VIEW_UNAVAILABLE_ITEMS:I

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 162
    return-void
.end method
