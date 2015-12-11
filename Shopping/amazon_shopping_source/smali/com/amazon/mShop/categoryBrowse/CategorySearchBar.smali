.class public Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;
.super Lcom/amazon/mShop/SearchBar;
.source "CategorySearchBar.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mDepartment:Ljava/lang/String;

.field private mFilter:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/amazon/mShop/SearchBar;-><init>(Landroid/content/Context;)V

    .line 50
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/SearchBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 42
    return-void
.end method


# virtual methods
.method protected checkPreviousSearchTerm()V
    .locals 0

    .prologue
    .line 121
    return-void
.end method

.method protected goToSearchEntry(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "selectInitialQuery"    # Z

    .prologue
    .line 69
    new-instance v1, Lcom/amazon/mShop/search/SearchIntentBuilder;

    iget-object v2, p0, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->mFilter:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->filter(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->mDepartment:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->categoryName(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_BROWSE:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v0

    .line 75
    .local v0, "searchIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    .line 76
    return-void
.end method

.method protected initSearchBar()V
    .locals 6

    .prologue
    .line 58
    invoke-super {p0}, Lcom/amazon/mShop/SearchBar;->initSearchBar()V

    .line 59
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->getSearchBar()Landroid/view/View;

    move-result-object v3

    .line 61
    .local v3, "searchBar":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getPaddingLeft()I

    move-result v0

    .line 62
    .local v0, "paddingLeft":I
    invoke-virtual {v3}, Landroid/view/View;->getPaddingRight()I

    move-result v1

    .line 63
    .local v1, "paddingRight":I
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategorySearchBar;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$dimen;->category_browse_search_bar_padding:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 64
    .local v2, "paddingTopBottom":I
    invoke-virtual {v3, v0, v2, v1, v2}, Landroid/view/View;->setPadding(IIII)V

    .line 65
    return-void
.end method

.method public logRefMarker()V
    .locals 1

    .prologue
    .line 126
    const-string/jumbo v0, "br_sr"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 127
    return-void
.end method
