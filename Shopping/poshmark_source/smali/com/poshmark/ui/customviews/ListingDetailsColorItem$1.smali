.class Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;
.super Ljava/lang/Object;
.source "ListingDetailsColorItem.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->setupListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingDetailsColorItem;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 13
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 55
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->screenNameForAnalytics:Ljava/lang/String;

    const-string v8, "listing"

    const-string v9, "browse_listings_by_color"

    const/4 v10, 0x0

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    new-instance v1, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v1}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 57
    .local v1, "model":Lcom/poshmark/utils/SearchFilterModel;
    iget-object v6, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v6, v6, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->searchTriggerType:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 58
    const-string v6, "available"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 60
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v4

    .line 61
    .local v4, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v4, :cond_0

    iget-object v6, v4, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 62
    invoke-virtual {v1, v12}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 65
    :cond_0
    iget-object v6, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v6, v6, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->category:Ljava/lang/String;

    if-eqz v6, :cond_1

    iget-object v6, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v6, v6, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->category:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_1

    .line 66
    iget-object v6, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v6, v6, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->category:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 67
    iget-object v6, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v6, v6, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->color:Lcom/poshmark/data_model/models/PMColor;

    iget-object v6, v6, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->addColor(Ljava/lang/String;)V

    .line 68
    const-string v6, "brand"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 69
    const-string v6, "size"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 70
    const-string v6, "category_v2"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 71
    const-string v6, "category_feature"

    invoke-virtual {v1, v6}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 74
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMContainerActivity;

    .line 76
    .local v2, "parent":Lcom/poshmark/ui/PMContainerActivity;
    const-string v6, "input_method"

    invoke-virtual {v2, v6}, Lcom/poshmark/ui/PMContainerActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 77
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual {v0}, Landroid/view/inputmethod/InputMethodManager;->isAcceptingText()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 78
    invoke-virtual {v2}, Lcom/poshmark/ui/PMContainerActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v5

    .line 79
    .local v5, "v":Landroid/view/View;
    if-eqz v5, :cond_3

    .line 80
    invoke-virtual {p1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v6

    invoke-virtual {v0, v6, v11}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 85
    .end local v5    # "v":Landroid/view/View;
    :cond_2
    :goto_0
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 86
    .local v3, "searchTrigger":Landroid/os/Bundle;
    const-string v6, "SEARCH_TRIGGER"

    iget-object v7, p0, Lcom/poshmark/ui/customviews/ListingDetailsColorItem$1;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    iget-object v7, v7, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->searchTriggerType:Ljava/lang/String;

    invoke-virtual {v3, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const-class v6, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v2, v3, v6, v1}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 88
    return-void

    .line 82
    .end local v3    # "searchTrigger":Landroid/os/Bundle;
    .restart local v5    # "v":Landroid/view/View;
    :cond_3
    invoke-virtual {v0, v12, v11}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    goto :goto_0
.end method
