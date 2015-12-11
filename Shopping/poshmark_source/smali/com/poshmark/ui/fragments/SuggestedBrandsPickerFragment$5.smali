.class Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;
.super Ljava/lang/Object;
.source "SuggestedBrandsPickerFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMImageViewOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;)V
    .locals 0

    .prologue
    .line 325
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/poshmark/ui/customviews/PMImageView;Landroid/os/Bundle;)V
    .locals 8
    .param p1, "v"    # Lcom/poshmark/ui/customviews/PMImageView;
    .param p2, "b"    # Landroid/os/Bundle;

    .prologue
    const/4 v7, 0x0

    .line 328
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMImageView;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout;

    .line 329
    .local v1, "parent":Landroid/widget/FrameLayout;
    const-string v3, "POSITION"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 330
    .local v2, "position":I
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->allBrandsModel:Lcom/poshmark/db/AllBrandsModel;

    iget-object v3, v3, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/Brand;

    .line 332
    .local v0, "brand":Lcom/poshmark/data_model/models/Brand;
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v3

    iget-object v4, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/poshmark/controllers/GlobalDbController;->isFollowingBrand(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 333
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "brand"

    const-string v6, "onramp_brand_unfollowed"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 334
    iget-object v3, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    new-instance v4, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;

    invoke-direct {v4, p0, v0, v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$1;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;Lcom/poshmark/data_model/models/Brand;Landroid/widget/FrameLayout;)V

    invoke-static {v3, v4}, Lcom/poshmark/http/api/PMApi;->unFollowBrand(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 345
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    const/4 v4, 0x4

    # invokes: Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setOverlay(Landroid/widget/FrameLayout;I)V
    invoke-static {v3, v1, v4}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->access$300(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;Landroid/widget/FrameLayout;I)V

    .line 364
    :goto_0
    return-void

    .line 347
    :cond_0
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "brand"

    const-string v6, "onramp_brand_followed"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 348
    iget-object v3, v0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    new-instance v4, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$2;

    invoke-direct {v4, p0, v0, v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5$2;-><init>(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;Lcom/poshmark/data_model/models/Brand;Landroid/widget/FrameLayout;)V

    invoke-static {v3, v4}, Lcom/poshmark/http/api/PMApi;->followBrand(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 360
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    const/4 v4, 0x0

    # invokes: Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setOverlay(Landroid/widget/FrameLayout;I)V
    invoke-static {v3, v1, v4}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->access$300(Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;Landroid/widget/FrameLayout;I)V

    goto :goto_0
.end method
