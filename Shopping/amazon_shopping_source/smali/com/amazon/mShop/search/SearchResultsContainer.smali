.class public Lcom/amazon/mShop/search/SearchResultsContainer;
.super Landroid/widget/LinearLayout;
.source "SearchResultsContainer.java"

# interfaces
.implements Lcom/amazon/mShop/DelayedInitView;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mDepartment:Ljava/lang/String;

.field private mFilter:Ljava/lang/String;

.field private mSearchBarInput:Landroid/widget/EditText;

.field private mSearchResultView:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/amazon/mShop/search/SearchResultsContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/search/SearchResultsContainer;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 44
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchResultsContainer;->initViews()V

    .line 46
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/SearchResultsContainer;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/SearchResultsContainer;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/SearchResultsContainer;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/SearchResultsContainer;

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/amazon/mShop/search/SearchResultsContainer;->goToSearchEntry()V

    return-void
.end method

.method private goToSearchEntry()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 165
    iget-object v2, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 166
    .local v0, "query":Ljava/lang/String;
    :goto_0
    new-instance v2, Lcom/amazon/mShop/search/SearchIntentBuilder;

    iget-object v3, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v0}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mFilter:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->filter(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mDepartment:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->categoryName(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonActivity;->getClickStreamOrigin()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v1

    .line 174
    .local v1, "searchIntent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v2, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    .line 175
    return-void

    .line 165
    .end local v0    # "query":Ljava/lang/String;
    .end local v1    # "searchIntent":Landroid/content/Intent;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setupVoiceSearch(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;)V
    .locals 4
    .param p1, "searchBar"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    .prologue
    .line 86
    if-nez p1, :cond_1

    .line 113
    :cond_0
    :goto_0
    return-void

    .line 90
    :cond_1
    :try_start_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->rs_voice_search_btn:I

    invoke-virtual {p1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 92
    .local v1, "voiceButton":Landroid/widget/Button;
    if-eqz v1, :cond_0

    .line 96
    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->voiceSearchInResultEnabled()Z

    move-result v2

    if-nez v2, :cond_2

    .line 97
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 110
    .end local v1    # "voiceButton":Landroid/widget/Button;
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/mShop/search/SearchResultsContainer;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Failed to setup voice search"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 99
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "voiceButton":Landroid/widget/Button;
    :cond_2
    const/4 v2, 0x0

    :try_start_1
    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 101
    new-instance v2, Lcom/amazon/mShop/search/SearchResultsContainer$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/SearchResultsContainer$1;-><init>(Lcom/amazon/mShop/search/SearchResultsContainer;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method


# virtual methods
.method public getSearchTerm()Landroid/text/Editable;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    return-object v0
.end method

.method protected initViews()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    .line 62
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v4, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/SearchResultsContainer;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 64
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/SearchResultsContainer;->setOrientation(I)V

    .line 66
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchResultsContainer;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->rs_search_entry_bar:I

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;

    .line 68
    .local v0, "searchBar":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x2

    invoke-direct {v1, v4, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->rs_search_src_text:I

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    .line 74
    iget-object v1, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setFocusable(Z)V

    .line 76
    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/SearchResultsContainer;->setupVoiceSearch(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;)V

    .line 78
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchResultsContainer;->addView(Landroid/view/View;)V

    .line 79
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 0

    .prologue
    .line 181
    return-void
.end method

.method public setSearchResultView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchResultView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchResultView:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchResultsContainer;->removeView(Landroid/view/View;)V

    .line 120
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchResultView:Landroid/view/View;

    .line 122
    if-eqz p1, :cond_1

    .line 123
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/SearchResultsContainer;->addView(Landroid/view/View;)V

    .line 126
    :cond_1
    return-void
.end method

.method public setSearchTerm(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/CharSequence;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 59
    return-void
.end method

.method public updateSearchBar(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "filter"    # Ljava/lang/String;
    .param p2, "department"    # Ljava/lang/String;

    .prologue
    .line 132
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mFilter:Ljava/lang/String;

    .line 133
    iput-object p2, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mDepartment:Ljava/lang/String;

    .line 136
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    new-instance v1, Lcom/amazon/mShop/search/SearchResultsContainer$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/SearchResultsContainer$2;-><init>(Lcom/amazon/mShop/search/SearchResultsContainer;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 150
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 151
    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchResultsContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->rs_search_all_departments:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p2

    .line 153
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/SearchResultsContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->rs_search_in_department:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer;->mSearchBarInput:Landroid/widget/EditText;

    new-instance v1, Lcom/amazon/mShop/search/SearchResultsContainer$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/SearchResultsContainer$3;-><init>(Lcom/amazon/mShop/search/SearchResultsContainer;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 161
    return-void
.end method
