.class public Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;
.super Lcom/amazon/mShop/control/BaseController;
.source "AdvSearchSuggestionsController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponseListener;


# instance fields
.field private mAdvSearchSuggestionsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;

.field private final mSubscriber:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;)V
    .locals 2
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mSubscriber:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;

    .line 23
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mAdvSearchSuggestionsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;

    .line 24
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mAdvSearchSuggestionsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;

    const/16 v1, 0xa

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->setMaxSuggestions(Ljava/lang/Integer;)V

    .line 25
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 15
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;)Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mSubscriber:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 43
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;-><init>(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 53
    return-void
.end method

.method public getSearchSuggestions(Ljava/lang/String;)V
    .locals 3
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 28
    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mAdvSearchSuggestionsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;

    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;->setQuery(Ljava/lang/String;)V

    .line 29
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->cancel()V

    .line 30
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    .line 32
    .local v0, "platform":Lcom/amazon/mShop/platform/Platform;
    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mAdvSearchSuggestionsRequest:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;

    invoke-interface {v1, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->advSearchSuggestions(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 34
    return-void
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 15
    invoke-virtual {p0}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->getSubscriber()Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mSubscriber:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;

    return-object v0
.end method
