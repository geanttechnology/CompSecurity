.class Lcom/poshmark/ui/fragments/SearchResultsFragment$2;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Lcom/poshmark/utils/PMSearchViewListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SearchResultsFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SearchResultsFragment;)V
    .locals 0

    .prologue
    .line 137
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public clearSearchString()V
    .locals 0

    .prologue
    .line 159
    return-void
.end method

.method public fireKeywordSearch(Landroid/os/Bundle;Lcom/poshmark/utils/SearchFilterModel;Z)V
    .locals 4
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "model"    # Lcom/poshmark/utils/SearchFilterModel;
    .param p3, "isBrandSearch"    # Z

    .prologue
    .line 140
    if-eqz p3, :cond_0

    .line 141
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 142
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    const-class v1, Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v0, p1, v1, p2}, Lcom/poshmark/ui/PMContainerActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 154
    .end local v0    # "parent":Lcom/poshmark/ui/PMContainerActivity;
    :goto_0
    return-void

    .line 144
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    const-string v2, "SEARCH_TRIGGER"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    .line 145
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchTrigger:Ljava/lang/String;

    const-string v2, "sl"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 146
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    const-string v2, "KEYWORD_SOURCE"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/ui/fragments/SearchResultsFragment;->keywordSource:Ljava/lang/String;

    .line 147
    sget-object v1, Lcom/poshmark/utils/NewRelicCustomInteractions;->SEARCH_LISTINGS_BY_KEYWORD:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 149
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/poshmark/utils/FilterResultsManager;->setSearchModel(Lcom/poshmark/utils/SearchFilterModel;)V

    .line 150
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SearchResultsFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getFilterModel()Lcom/poshmark/utils/SearchFilterModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/SearchFilterModel;->getQueryText()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setSilentText(Ljava/lang/String;)V

    .line 151
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060190

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 152
    iget-object v1, p0, Lcom/poshmark/ui/fragments/SearchResultsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SearchResultsFragment;

    const/4 v2, 0x0

    # invokes: Lcom/poshmark/ui/fragments/SearchResultsFragment;->getSearchResults(Z)V
    invoke-static {v1, v2}, Lcom/poshmark/ui/fragments/SearchResultsFragment;->access$000(Lcom/poshmark/ui/fragments/SearchResultsFragment;Z)V

    goto :goto_0
.end method
