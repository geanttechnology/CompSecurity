.class public Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
.super Lcom/amazon/mShop/control/PagedListingBrowser;
.source "AdvSearchResultsBrowser.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/control/PagedListingBrowser",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;",
        "Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;"
    }
.end annotation


# instance fields
.field private mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

.field private mAdvSearchResults:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

.field private mBreadCrumbs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Breadcrumb;",
            ">;"
        }
    .end annotation
.end field

.field private mClickStreamTag:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field private mCorrectedResultsTitle:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation
.end field

.field private mCorrection:Ljava/lang/String;

.field private mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

.field private mFilters:Ljava/lang/String;

.field private mHasCorrectedResults:Z

.field private mMainResultsTitle:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation
.end field

.field private mMainTotalCount:I

.field private final mPageSize:I

.field protected mPrefetchSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

.field private mQuery:Ljava/lang/String;

.field private mRefinementBins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RefinementBin;",
            ">;"
        }
    .end annotation
.end field

.field private mRequestId:Ljava/lang/String;

.field private mReturnProducts:Z

.field private mServiceCallForStubs:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private mShouldReturnCorrection:Z

.field private mSortOptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private mStubsResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

.field private mToggleRefinements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected mTotalCount:I


# direct methods
.method static synthetic access$000(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mHasCorrectedResults:Z

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Z

    .prologue
    .line 34
    iput-boolean p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mHasCorrectedResults:Z

    return p1
.end method

.method static synthetic access$102(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mMainTotalCount:I

    return p1
.end method

.method static synthetic access$1302(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCorrectedResultsTitle:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1402(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mQuery:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$1502(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCorrection:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$202(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mMainResultsTitle:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$302(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;)Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchResults:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;

    return-object p1
.end method

.method static synthetic access$402(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mRefinementBins:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$502(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mFilters:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$602(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mToggleRefinements:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$702(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mBreadCrumbs:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$800(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mSortOptions:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$802(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mSortOptions:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$900(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;)Lcom/amazon/rio/j2me/client/services/mShop/SortOption;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    return-object v0
.end method

.method static synthetic access$902(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/SortOption;)Lcom/amazon/rio/j2me/client/services/mShop/SortOption;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    return-object p1
.end method

.method private checkPrefetchable()Z
    .locals 1

    .prologue
    .line 575
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->primarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->secondarySubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private doAdvSearch(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 3
    .param p1, "offset"    # I
    .param p2, "count"    # I
    .param p3, "query"    # Ljava/lang/String;
    .param p4, "filters"    # Ljava/lang/String;
    .param p6, "returnStubs"    # Ljava/lang/Boolean;
    .param p7, "returnProducts"    # Ljava/lang/Boolean;
    .param p8, "returnRefinements"    # Ljava/lang/Boolean;
    .param p9, "returnCorrections"    # Ljava/lang/Boolean;
    .param p10, "sortId"    # Ljava/lang/String;
    .param p11, "listener"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Boolean;",
            "Ljava/lang/String;",
            "Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;",
            ")",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;"
        }
    .end annotation

    .prologue
    .local p5, "toggleRefinements":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x1

    .line 242
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    .line 244
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 245
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p10}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setSortId(Ljava/lang/String;)V

    .line 246
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setOffset(Ljava/lang/Integer;)V

    .line 247
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setCount(Ljava/lang/Integer;)V

    .line 248
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p3}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setQuery(Ljava/lang/String;)V

    .line 249
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p4}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setFilters(Ljava/lang/String;)V

    .line 250
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p6}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setReturnStubs(Ljava/lang/Boolean;)V

    .line 251
    iget-object v2, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    if-eqz p5, :cond_4

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0, p5}, Ljava/util/Vector;-><init>(Ljava/util/Collection;)V

    :goto_0
    invoke-virtual {v2, v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setToggleRefinements(Ljava/util/List;)V

    .line 254
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p7}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setReturnProducts(Ljava/lang/Boolean;)V

    .line 255
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p8}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setReturnRefinements(Ljava/lang/Boolean;)V

    .line 256
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-virtual {v0, p9}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setReturnCorrections(Ljava/lang/Boolean;)V

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setIncludeAddOnItems(Ljava/lang/Boolean;)V

    .line 263
    invoke-virtual {p6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-ne v0, v1, :cond_0

    invoke-virtual {p7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->checkPrefetchable()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 266
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;->setIsPrefetch(Ljava/lang/Boolean;)V

    .line 270
    :cond_2
    if-nez p1, :cond_3

    .line 271
    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mRequestId:Ljava/lang/String;

    .line 274
    :cond_3
    const-string/jumbo v2, "adv_search_v34"

    if-eqz p1, :cond_5

    move v0, v1

    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mRequestId:Ljava/lang/String;

    invoke-static {v2, v0, v1}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 276
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mAdvSearchRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;

    invoke-interface {v0, v1, p11}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->advSearch(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    return-object v0

    .line 251
    :cond_4
    const/4 v0, 0x0

    goto :goto_0

    .line 274
    :cond_5
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static validateQuery(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "query"    # Ljava/lang/String;

    .prologue
    .line 66
    if-eqz p0, :cond_0

    .line 67
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 68
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 72
    :goto_0
    return-object p0

    :cond_0
    const/4 p0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public cancelServiceCallForStubs()V
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mServiceCallForStubs:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 281
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mServiceCallForStubs:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 282
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mServiceCallForStubs:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 284
    :cond_0
    return-void
.end method

.method public getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;
    .locals 1

    .prologue
    .line 340
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mClickStreamTag:Lcom/amazon/mShop/control/item/ClickStreamTag;

    return-object v0
.end method

.method public getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPrefetchSubscriber:Lcom/amazon/mShop/control/ObjectSubscriber;

    return-object v0
.end method

.method protected onPrefetchCancelled()V
    .locals 1

    .prologue
    .line 521
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 522
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onCancelled()V

    .line 524
    :cond_0
    return-void
.end method

.method protected onPrefetchCountReceived(I)V
    .locals 1
    .param p1, "availableCount"    # I

    .prologue
    .line 548
    invoke-direct {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->checkPrefetchable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 549
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/mShop/control/ObjectSubscriber;->onAvailableCountReceived(I)V

    .line 551
    :cond_0
    return-void
.end method

.method protected onPrefetchError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 558
    invoke-direct {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->checkPrefetchable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 559
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 561
    :cond_0
    return-void
.end method

.method protected onPrefetchObjReceived(Ljava/lang/Object;I)V
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 539
    invoke-direct {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->checkPrefetchable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 540
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectReceived(Ljava/lang/Object;I)V

    .line 542
    :cond_0
    return-void
.end method

.method protected onPrefetchObjsReceived()V
    .locals 1

    .prologue
    .line 565
    invoke-direct {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->checkPrefetchable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 566
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onObjectsReceived()V

    .line 568
    :cond_0
    return-void
.end method

.method protected onPrefetchSuccess()V
    .locals 1

    .prologue
    .line 530
    invoke-direct {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->checkPrefetchable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 531
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getPretchSubscriber()Lcom/amazon/mShop/control/ObjectSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/ObjectSubscriber;->onPageComplete()V

    .line 533
    :cond_0
    return-void
.end method

.method public receivedAdvSearchResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    .param p2, "index"    # I
    .param p3, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 486
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$2;-><init>(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 501
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getAvailableCount()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p0, v0, p3}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->availableCountReceived(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 503
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResults()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 504
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResults()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p3, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;Z)V

    .line 506
    :cond_0
    return-void
.end method

.method public receivedHyperText(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 511
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$3;-><init>(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 517
    return-void
.end method

.method public receivedMainResults(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 347
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getAvailableCount()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p0, v0, p2}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->availableCountReceived(ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 349
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser$1;-><init>(Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 395
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResults()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 396
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResults;->getResults()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p2, v1}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->objectsReceived(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;Z)V

    .line 399
    :cond_0
    return-void
.end method

.method public startFirstPageRequest(ILjava/util/List;)Z
    .locals 1
    .param p1, "availableCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 291
    .local p2, "firstPage":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;>;"
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mTotalCount:I

    .line 292
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mHasCorrectedResults:Z

    .line 293
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    move-result v0

    return v0
.end method

.method protected startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 14
    .param p1, "pageIndex"    # I

    .prologue
    const/4 v13, 0x0

    .line 301
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->getAvailableCount()I

    move-result v0

    iget v1, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    mul-int/2addr v1, p1

    sub-int v12, v0, v1

    .line 304
    .local v12, "remainingCount":I
    iget v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    mul-int v1, p1, v0

    iget v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    if-ge v12, v0, :cond_0

    move v2, v12

    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mQuery:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mFilters:Ljava/lang/String;

    if-nez p1, :cond_1

    iget-object v5, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mToggleRefinements:Ljava/util/List;

    :goto_1
    sget-object v6, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    sget-object v7, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v8, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SortOption;->getSortId()Ljava/lang/String;

    move-result-object v10

    :goto_2
    iget-object v11, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mStubsResponseListener:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    move-object v0, p0

    invoke-direct/range {v0 .. v11}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->doAdvSearch(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mServiceCallForStubs:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 318
    iget v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    mul-int v1, p1, v0

    iget v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    if-ge v12, v0, :cond_3

    move v2, v12

    :goto_3
    iget-object v3, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mQuery:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mFilters:Ljava/lang/String;

    if-nez p1, :cond_4

    iget-object v5, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mToggleRefinements:Ljava/util/List;

    :goto_4
    sget-object v6, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iget-boolean v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mReturnProducts:Z

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    if-nez p1, :cond_5

    sget-object v8, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    :goto_5
    iget-boolean v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mShouldReturnCorrection:Z

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mCurrentSortOption:Lcom/amazon/rio/j2me/client/services/mShop/SortOption;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SortOption;->getSortId()Ljava/lang/String;

    move-result-object v10

    :goto_6
    move-object v0, p0

    move-object v11, p0

    invoke-direct/range {v0 .. v11}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->doAdvSearch(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v0

    return-object v0

    .line 304
    :cond_0
    iget v2, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    goto :goto_0

    :cond_1
    move-object v5, v13

    goto :goto_1

    :cond_2
    move-object v10, v13

    goto :goto_2

    .line 318
    :cond_3
    iget v2, p0, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->mPageSize:I

    goto :goto_3

    :cond_4
    move-object v5, v13

    goto :goto_4

    :cond_5
    sget-object v8, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_5

    :cond_6
    move-object v10, v13

    goto :goto_6
.end method
