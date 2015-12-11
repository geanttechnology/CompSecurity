.class public Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;
.super Lcom/poshmark/ui/fragments/MetaItemListViewFragment;
.source "CategoryMetaItemListViewFragment.java"


# instance fields
.field returnResults:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;->returnResults:Z

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->onCreate(Landroid/os/Bundle;)V

    .line 26
    if-nez p1, :cond_0

    .line 27
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "RETURN_RESULT"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;->returnResults:Z

    .line 29
    :cond_0
    return-void
.end method

.method public returnData()V
    .locals 9

    .prologue
    .line 32
    iget-boolean v7, p0, Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;->returnResults:Z

    if-nez v7, :cond_2

    .line 33
    iget-object v7, p0, Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;->metaItem:Lcom/poshmark/data_model/models/MetaItem;

    const-class v8, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v7, v8}, Lcom/poshmark/utils/StringUtils;->toJson(Lcom/poshmark/data_model/models/MetaItem;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 34
    .local v2, "jsonString":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 35
    const-class v7, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2, v7}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/MetaItem;

    .line 36
    .local v1, "categoryItem":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v3, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v3}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 37
    .local v3, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v7, "available"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 39
    invoke-static {}, Lcom/poshmark/controllers/GlobalDbController;->getGlobalDbController()Lcom/poshmark/controllers/GlobalDbController;

    move-result-object v7

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/controllers/GlobalDbController;->getAllSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 41
    .local v5, "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v6

    .line 42
    .local v6, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v6, :cond_0

    iget-object v7, v6, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 43
    const/4 v7, 0x1

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 45
    :cond_0
    const-string v7, "ct"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 46
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 47
    const-string v7, "brand"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 48
    const-string v7, "size"

    invoke-virtual {v3, v7}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 49
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 50
    .local v4, "searchTrigger":Landroid/os/Bundle;
    const-string v7, "SEARCH_TRIGGER"

    const-string v8, "ct"

    invoke-virtual {v4, v7, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/CategoryMetaItemListViewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 52
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v7, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0, v4, v7, v3}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 57
    .end local v0    # "activity":Lcom/poshmark/ui/PMContainerActivity;
    .end local v1    # "categoryItem":Lcom/poshmark/data_model/models/MetaItem;
    .end local v2    # "jsonString":Ljava/lang/String;
    .end local v3    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .end local v4    # "searchTrigger":Landroid/os/Bundle;
    .end local v5    # "sizes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v6    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :cond_1
    :goto_0
    return-void

    .line 55
    :cond_2
    invoke-super {p0}, Lcom/poshmark/ui/fragments/MetaItemListViewFragment;->returnData()V

    goto :goto_0
.end method
