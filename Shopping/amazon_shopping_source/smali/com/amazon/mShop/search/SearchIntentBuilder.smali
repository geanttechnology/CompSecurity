.class public Lcom/amazon/mShop/search/SearchIntentBuilder;
.super Ljava/lang/Object;
.source "SearchIntentBuilder.java"


# instance fields
.field private asrRequestId:Ljava/lang/String;

.field private interpretationNum:I

.field private mCategoryName:Ljava/lang/String;

.field private mClickStreamOrigin:Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field private mDataUrl:Ljava/lang/String;

.field private mExtraFlag:I

.field private mFilter:Ljava/lang/String;

.field private mQuery:Ljava/lang/String;

.field private mRefmarker:Ljava/lang/String;

.field private mRsQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

.field private mSearchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field private mSelectInitialQuery:Z

.field private mShowSearchEntryView:Z

.field private utteranceId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mQuery:Ljava/lang/String;

    .line 29
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mFilter:Ljava/lang/String;

    .line 30
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mCategoryName:Ljava/lang/String;

    .line 31
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mDataUrl:Ljava/lang/String;

    .line 33
    iput-boolean v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mShowSearchEntryView:Z

    .line 34
    iput-boolean v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mSelectInitialQuery:Z

    .line 35
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mClickStreamOrigin:Ljava/lang/String;

    .line 36
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRefmarker:Ljava/lang/String;

    .line 37
    iput-object v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRsQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .line 38
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mExtraFlag:I

    .line 52
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mContext:Landroid/content/Context;

    .line 53
    return-void
.end method


# virtual methods
.method public asrRequestId(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "asrRequestId"    # Ljava/lang/String;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->asrRequestId:Ljava/lang/String;

    .line 112
    return-object p0
.end method

.method public build()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 134
    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mQuery:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mFilter:Ljava/lang/String;

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mDataUrl:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 135
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mShowSearchEntryView:Z

    .line 137
    :cond_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mContext:Landroid/content/Context;

    const-class v2, Lcom/amazon/mShop/search/SearchActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/util/ActivityUtils;->shouldReorderActivity(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 142
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 144
    :cond_1
    const-string/jumbo v1, "selectInitialQuery"

    iget-boolean v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mSelectInitialQuery:Z

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 145
    const-string/jumbo v1, "SHOW_SEARCH_ENTRY_VIEW"

    iget-boolean v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mShowSearchEntryView:Z

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 148
    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mClickStreamOrigin:Ljava/lang/String;

    if-eqz v1, :cond_4

    .line 149
    const-string/jumbo v1, "clickStreamOrigin"

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mClickStreamOrigin:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 154
    :goto_0
    new-instance v1, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mCategoryName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->categoryName(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mDataUrl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->dataUrl(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mFilter:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->filter(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mQuery:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->query(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mSearchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->searchMethod(Lcom/amazon/searchapp/retailsearch/client/SearchMethod;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->asrRequestId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->asrRequestId(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->utteranceId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->utteranceId(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    iget v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->interpretationNum:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->interpretationNum(I)Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/api/intent/search/SearchIntentUriBuilder;->build()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 165
    iget v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mExtraFlag:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_2

    .line 166
    iget v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mExtraFlag:I

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 168
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mContext:Landroid/content/Context;

    instance-of v1, v1, Lcom/amazon/mShop/search/SearchActivity;

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRefmarker:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 172
    const-string/jumbo v1, "adv_search_v34"

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRefmarker:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/amazon/mShop/customclientfields/RefmarkerClientField;->logServiceMethodNameAndRefmarker(Ljava/lang/String;Ljava/lang/String;)Z

    .line 174
    :cond_3
    sget-object v1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->INTENT_EXTRA_KEY:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRsQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 176
    return-object v0

    .line 151
    :cond_4
    const-string/jumbo v1, "clickStreamOrigin"

    sget-object v2, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SEARCH:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public categoryName(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "categoryName"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mCategoryName:Ljava/lang/String;

    .line 67
    return-object p0
.end method

.method public clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mClickStreamOrigin:Ljava/lang/String;

    .line 92
    return-object p0
.end method

.method public dataUrl(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "dataUrl"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mDataUrl:Ljava/lang/String;

    .line 72
    return-object p0
.end method

.method public extraFlag(I)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "extraFlag"    # I

    .prologue
    .line 101
    iput p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mExtraFlag:I

    .line 102
    return-object p0
.end method

.method public filter(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "filter"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mFilter:Ljava/lang/String;

    .line 62
    return-object p0
.end method

.method public interpretationNum(I)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "interpretationNum"    # I

    .prologue
    .line 121
    iput p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->interpretationNum:I

    .line 122
    return-object p0
.end method

.method public query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mQuery:Ljava/lang/String;

    .line 57
    return-object p0
.end method

.method public refmarker(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "refmarker"    # Ljava/lang/String;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRefmarker:Ljava/lang/String;

    .line 97
    return-object p0
.end method

.method public retailSearchQuery(Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "rsQuery"    # Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mRsQuery:Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .line 107
    return-object p0
.end method

.method public searchMethod(Lcom/amazon/searchapp/retailsearch/client/SearchMethod;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "searchMethod"    # Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mSearchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 77
    return-object p0
.end method

.method public selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "selectInitialQuery"    # Z

    .prologue
    .line 86
    iput-boolean p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mSelectInitialQuery:Z

    .line 87
    return-object p0
.end method

.method public showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "showSearchEntryView"    # Z

    .prologue
    .line 81
    iput-boolean p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->mShowSearchEntryView:Z

    .line 82
    return-object p0
.end method

.method public utteranceId(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;
    .locals 0
    .param p1, "utteranceId"    # Ljava/lang/String;

    .prologue
    .line 116
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchIntentBuilder;->utteranceId:Ljava/lang/String;

    .line 117
    return-object p0
.end method
