.class Lcom/poshmark/ui/customviews/SearchFilterTextView$1;
.super Ljava/lang/Object;
.source "SearchFilterTextView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/SearchFilterTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/SearchFilterTextView;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 14
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v13, 0x0

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 80
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    if-eqz v7, :cond_0

    .line 81
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    const-string v8, "br"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 82
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    const-string v9, "listing"

    const-string v10, "brand_link_tapped"

    invoke-virtual {v7, v8, v9, v10, v11}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    :cond_0
    :goto_0
    new-instance v2, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v2}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 89
    .local v2, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 90
    const-string v7, "available"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 92
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v5

    .line 93
    .local v5, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v5, :cond_1

    iget-object v7, v5, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 94
    invoke-virtual {v2, v12}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 97
    :cond_1
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->category:Ljava/lang/String;

    if-eqz v7, :cond_2

    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->category:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_2

    .line 100
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->category:Ljava/lang/String;

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 101
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->subCategoryList:Ljava/util/List;

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setSubCategories(Ljava/util/List;)V

    .line 102
    const-string v7, "brand"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 103
    const-string v7, "size"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 104
    const-string v7, "color"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 105
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->subCategoryList:Ljava/util/List;

    if-eqz v7, :cond_8

    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->subCategoryList:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_8

    .line 106
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    const-string v9, "listing"

    const-string v10, "browse_listings_by_subcategory"

    invoke-virtual {v7, v8, v9, v10, v11}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :cond_2
    :goto_1
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->size:Ljava/lang/String;

    if-eqz v7, :cond_3

    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->size:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_3

    .line 116
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->category:Ljava/lang/String;

    if-eqz v7, :cond_3

    .line 117
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->category:Ljava/lang/String;

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->size:Ljava/lang/String;

    invoke-static {v7, v8}, Lcom/poshmark/db/DbApi;->getSizeForCategoryFromLabel(Ljava/lang/String;Ljava/lang/String;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 118
    .local v1, "item":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v1, :cond_3

    .line 119
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->size:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->addSize(Ljava/lang/String;)V

    .line 124
    .end local v1    # "item":Lcom/poshmark/data_model/models/MetaItem;
    :cond_3
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->brand:Ljava/lang/String;

    if-eqz v7, :cond_4

    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->brand:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_4

    .line 125
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getPrimaryFilters()Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->brand:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/poshmark/utils/SearchFilterModel$PrimaryFilters;->addBrand(Ljava/lang/String;)V

    .line 126
    const-string v7, "category_v2"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 127
    const-string v7, "size"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 128
    const-string v7, "color"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 129
    const-string v7, "category_feature"

    invoke-virtual {v2, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 132
    :cond_4
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->NWT_condition:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_9

    .line 133
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7, v12}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableNWTOption(Z)V

    .line 137
    :cond_5
    :goto_2
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/PMContainerActivity;

    .line 139
    .local v3, "parent":Lcom/poshmark/ui/PMContainerActivity;
    const-string v7, "input_method"

    invoke-virtual {v3, v7}, Lcom/poshmark/ui/PMContainerActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 140
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {v0}, Landroid/view/inputmethod/InputMethodManager;->isAcceptingText()Z

    move-result v7

    if-eqz v7, :cond_6

    .line 141
    invoke-virtual {v3}, Lcom/poshmark/ui/PMContainerActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v6

    .line 142
    .local v6, "v":Landroid/view/View;
    if-eqz v6, :cond_a

    .line 143
    invoke-virtual {p1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v7

    invoke-virtual {v0, v7, v13}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 148
    .end local v6    # "v":Landroid/view/View;
    :cond_6
    :goto_3
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 150
    .local v4, "searchTrigger":Landroid/os/Bundle;
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    const-string v8, "br"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_b

    .line 151
    const-string v7, "ID"

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->brand:Ljava/lang/String;

    invoke-virtual {v4, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    const-class v7, Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v3, v4, v7, v11}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 158
    :goto_4
    return-void

    .line 83
    .end local v0    # "imm":Landroid/view/inputmethod/InputMethodManager;
    .end local v2    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .end local v3    # "parent":Lcom/poshmark/ui/PMContainerActivity;
    .end local v4    # "searchTrigger":Landroid/os/Bundle;
    .end local v5    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :cond_7
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->size:Ljava/lang/String;

    if-eqz v7, :cond_0

    .line 84
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    const-string v9, "listing"

    const-string v10, "size_link_tapped"

    invoke-virtual {v7, v8, v9, v10, v11}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 109
    .restart local v2    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .restart local v5    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :cond_8
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    const-string v9, "listing"

    const-string v10, "browse_listings_by_category"

    invoke-virtual {v7, v8, v9, v10, v11}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 134
    :cond_9
    iget-object v7, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/SearchFilterTextView;->Retail_condition:Ljava/lang/Boolean;

    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 135
    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getFilters()Lcom/poshmark/utils/SearchFilterModel$SearchFilters;

    move-result-object v7

    invoke-virtual {v7, v12}, Lcom/poshmark/utils/SearchFilterModel$SearchFilters;->enableRetailOption(Z)V

    goto :goto_2

    .line 145
    .restart local v0    # "imm":Landroid/view/inputmethod/InputMethodManager;
    .restart local v3    # "parent":Lcom/poshmark/ui/PMContainerActivity;
    .restart local v6    # "v":Landroid/view/View;
    :cond_a
    invoke-virtual {v0, v12, v13}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    goto :goto_3

    .line 154
    .end local v6    # "v":Landroid/view/View;
    .restart local v4    # "searchTrigger":Landroid/os/Bundle;
    :cond_b
    const-string v7, "SEARCH_TRIGGER"

    iget-object v8, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;->this$0:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iget-object v8, v8, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    invoke-virtual {v4, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-class v7, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v3, v4, v7, v2}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_4
.end method
