.class public Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;
.super Ljava/lang/Object;
.source "MShopServiceImpl.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/MShopService;


# instance fields
.field private applicationID:Ljava/lang/String;

.field private final eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

.field private final invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Lcom/amazon/rio/j2me/client/services/RioEventListener;)V
    .locals 0
    .param p1, "applicationID"    # Ljava/lang/String;
    .param p2, "invoker"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;
    .param p3, "eventListener"    # Lcom/amazon/rio/j2me/client/services/RioEventListener;

    .prologue
    .line 171
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 172
    invoke-virtual {p0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->setApplicationID(Ljava/lang/String;)V

    .line 173
    iput-object p2, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    .line 174
    iput-object p3, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    .line 175
    return-void
.end method


# virtual methods
.method public addListIdeas(Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 194
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 195
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "add_list_ideas_v38"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 205
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 206
    return-object v7
.end method

.method public addListItems(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;

    .prologue
    .line 211
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 212
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "add_list_items_v37"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 222
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 223
    return-object v7
.end method

.method public addToCart(Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddToCartResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/AddToCartResponseListener;

    .prologue
    .line 279
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 280
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "add_to_cart_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/AddToCartClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/AddToCartClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddToCartResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 290
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 291
    return-object v7
.end method

.method public advSearch(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;

    .prologue
    .line 313
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 314
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "adv_search_v34"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 324
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 325
    return-object v7
.end method

.method public advSearchSuggestions(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponseListener;

    .prologue
    .line 330
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 331
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "adv_search_suggestions_v34"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 341
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 342
    return-object v7
.end method

.method public barcodeBadMatch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchResponseListener;

    .prologue
    .line 432
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 433
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "barcode_bad_match_v11"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 443
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 444
    return-object v7
.end method

.method public barcodeSearch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;

    .prologue
    .line 449
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 450
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "barcode_search_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 460
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 461
    return-object v7
.end method

.method public basicProducts(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 466
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 467
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "basic_products_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 477
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 478
    return-object v7
.end method

.method public buyAsin(Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 500
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 501
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "buy_asin_v28"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 511
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 512
    return-object v7
.end method

.method public cart(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/CartResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/CartResponseListener;

    .prologue
    .line 551
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 552
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "cart_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/CartClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/CartClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/CartResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 562
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 563
    return-object v7
.end method

.method public checkLogin(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 619
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 620
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "check_login_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 630
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 631
    return-object v7
.end method

.method public checkUpgrade(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 636
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 637
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "check_upgrade_v34"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 647
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 648
    return-object v7
.end method

.method public deal(Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;Lcom/amazon/rio/j2me/client/services/mShop/DealResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/DealResponseListener;

    .prologue
    .line 806
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 807
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "deal_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/DealClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/DealClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;Lcom/amazon/rio/j2me/client/services/mShop/DealResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 817
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 818
    return-object v7
.end method

.method public disableOneClick(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 908
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 909
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "disable_one_click_v1"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 919
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 920
    return-object v7
.end method

.method public enableOneClick(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 959
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 960
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "enable_one_click_v1"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 970
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 971
    return-object v7
.end method

.method public featureState(Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 993
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 994
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "feature_state_v36"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1004
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1005
    return-object v7
.end method

.method public getApplicationID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->applicationID:Ljava/lang/String;

    return-object v0
.end method

.method public getListLists(Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetListListsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetListListsResponseListener;

    .prologue
    .line 1078
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1079
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_list_lists_v37"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetListListsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetListListsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1089
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1090
    return-object v7
.end method

.method public getNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1112
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1113
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_notification_subscriptions_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1123
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1124
    return-object v7
.end method

.method public getOneClickAddresses(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1129
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1130
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_one_click_addresses_v21"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1140
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1141
    return-object v7
.end method

.method public getOneClickBasicInfo(Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1146
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1147
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_one_click_basic_info_v39"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1157
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1158
    return-object v7
.end method

.method public getOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1163
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1164
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_one_click_config_v21"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1174
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1175
    return-object v7
.end method

.method public getPointsSummary(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1180
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1181
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_points_summary_v8"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1191
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1192
    return-object v7
.end method

.method public getRecommendedItems(Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;

    .prologue
    .line 1248
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1249
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "get_recommended_items_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1259
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1260
    return-object v7
.end method

.method public home(Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;

    .prologue
    .line 1401
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1402
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "home_v38"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/HomeClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1412
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1413
    return-object v7
.end method

.method public identifyUserWithSis(Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1435
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1436
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "identify_user_with_sis_v25"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1446
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1447
    return-object v7
.end method

.method public imageSearch(Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchResponseListener;

    .prologue
    .line 1452
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1453
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "image_search_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1463
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1464
    return-object v7
.end method

.method public kiangRegister(Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1554
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1555
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "kiang_register_v39"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1565
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1566
    return-object v7
.end method

.method public kiangUpdate(Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1571
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1572
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "kiang_update_v39"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1582
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1583
    return-object v7
.end method

.method public locale(Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1605
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1606
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "locale_v28"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/LocaleClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/LocaleClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1616
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1617
    return-object v7
.end method

.method public login(Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1622
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1623
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "login_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/LoginClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/LoginClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1633
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1634
    return-object v7
.end method

.method public logout(Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1639
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1640
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "logout_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/LogoutClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/LogoutClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1650
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1651
    return-object v7
.end method

.method public navigationMenu(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;

    .prologue
    .line 1741
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1742
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "navigation_menu_v34"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1752
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1753
    return-object v7
.end method

.method public newAccount(Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;Lcom/amazon/rio/j2me/client/services/mShop/NewAccountResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/NewAccountResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1758
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1759
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "new_account_v34"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;Lcom/amazon/rio/j2me/client/services/mShop/NewAccountResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1769
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1770
    return-object v7
.end method

.method public offerListings(Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;

    .prologue
    .line 1775
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1776
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "offer_listings_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1786
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1787
    return-object v7
.end method

.method public postEvents(Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1809
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1810
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "post_events_v34"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/PostEventsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/PostEventsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1820
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1821
    return-object v7
.end method

.method public postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1826
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1827
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "post_metrics_v36"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1837
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1838
    return-object v7
.end method

.method public product(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;

    .prologue
    .line 1843
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1844
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "product_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/ProductClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1854
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1855
    return-object v7
.end method

.method public query(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;

    .prologue
    .line 1877
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1878
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "query_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/QueryClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/QueryClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1888
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1889
    return-object v7
.end method

.method public rateRecs(Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponseListener;

    .prologue
    .line 1911
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1912
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "rate_recs_v17"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/RateRecsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1922
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1923
    return-object v7
.end method

.method public recognizeAuthenticityCode(Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 1928
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 1929
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "recognize_authenticity_code_v38"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 1939
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 1940
    return-object v7
.end method

.method public search(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResponseListener;

    .prologue
    .line 2064
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2065
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "search_v32"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/SearchClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2075
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2076
    return-object v7
.end method

.method public searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;

    .prologue
    .line 2081
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2082
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "search_delivery_locations_v21"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)V

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2092
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2093
    return-object v7
.end method

.method public setApplicationID(Ljava/lang/String;)V
    .locals 0
    .param p1, "applicationID"    # Ljava/lang/String;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->applicationID:Ljava/lang/String;

    .line 190
    return-void
.end method

.method public setNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 2200
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2201
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "set_notification_subscriptions_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2211
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2212
    return-object v7
.end method

.method public setOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 2217
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2218
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "set_one_click_config_v21"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2228
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2229
    return-object v7
.end method

.method public smileInfo(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 2336
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2337
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "smile_info_v38"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2347
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2348
    return-object v7
.end method

.method public toggleMarketplaceNotifications(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 2404
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2405
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "toggle_marketplace_notifications_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2415
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2416
    return-object v7
.end method

.method public updateNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 9
    .param p1, "request"    # Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;
    .param p2, "callback"    # Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponseListener;

    .prologue
    const/4 v4, 0x1

    .line 2472
    new-instance v7, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;

    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->eventListener:Lcom/amazon/rio/j2me/client/services/RioEventListener;

    invoke-direct {v7, v0}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;-><init>(Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 2473
    .local v7, "call":Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->invoker:Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;

    const-string/jumbo v1, "mShop"

    const-string/jumbo v2, "update_notification_target_v35"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;->getApplicationID()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetClientRequestReply;

    invoke-direct {v6, v7, p1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetClientRequestReply;-><init>(Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponseListener;)V

    move v5, v4

    invoke-interface/range {v0 .. v6}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;->invoke(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/rsc/ClientRequestReply;)Lcom/amazon/rio/j2me/client/rsc/ServiceCall;

    move-result-object v8

    .line 2483
    .local v8, "sc":Lcom/amazon/rio/j2me/client/rsc/ServiceCall;
    invoke-virtual {v7, v8}, Lcom/amazon/rio/j2me/client/services/ServiceCallImpl;->setUnderlyingCall(Lcom/amazon/rio/j2me/client/rsc/ServiceCall;)V

    .line 2484
    return-object v7
.end method
