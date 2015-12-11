.class Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;
.super Ljava/lang/Object;
.source "SuggestedBrandsPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->setupActionBar()V
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
    .line 86
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 13
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v12, 0x0

    .line 90
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/GlobalDbController;->getAllFollowingBrands()Ljava/util/List;

    move-result-object v8

    .line 91
    .local v8, "followedBrands":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v8, :cond_1

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v9

    .line 92
    .local v9, "followedCount":I
    :goto_0
    if-lez v9, :cond_3

    .line 93
    new-instance v5, Ljava/lang/String;

    invoke-direct {v5}, Ljava/lang/String;-><init>()V

    .line 94
    .local v5, "allFollowedBrands":Ljava/lang/String;
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_1
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v1

    if-ge v10, v1, :cond_2

    .line 95
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v8, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 96
    add-int/lit8 v1, v10, 0x1

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 97
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 94
    :cond_0
    add-int/lit8 v10, v10, 0x1

    goto :goto_1

    .line 91
    .end local v5    # "allFollowedBrands":Ljava/lang/String;
    .end local v9    # "followedCount":I
    .end local v10    # "i":I
    :cond_1
    const/4 v9, 0x0

    goto :goto_0

    .line 100
    .restart local v5    # "allFollowedBrands":Ljava/lang/String;
    .restart local v9    # "followedCount":I
    .restart local v10    # "i":I
    :cond_2
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "total_onramp_brands_followed"

    int-to-long v6, v9

    invoke-virtual/range {v1 .. v7}, Lcom/poshmark/analytics/Analytics;->trackEventWithValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 104
    .end local v5    # "allFollowedBrands":Ljava/lang/String;
    .end local v10    # "i":I
    :goto_2
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 105
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "NAME"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/PMActivity;

    .line 107
    .local v11, "parent":Lcom/poshmark/ui/PMActivity;
    const-class v1, Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-virtual {v11, v12, v1, v12}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 108
    return-void

    .line 102
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v11    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_3
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/SuggestedBrandsPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    const-string v4, "onramp_brand_next_nofollowed"

    invoke-virtual {v1, v2, v3, v4, v12}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2
.end method
