.class public final Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;
.super Lcom/amazon/mShop/control/PagedListingBrowser;
.source "OfferListingBrowser.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/control/PagedListingBrowser",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;",
        ">;",
        "Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;"
    }
.end annotation


# instance fields
.field private final asin:Ljava/lang/String;

.field private conditionType:Ljava/lang/String;

.field private final requestId:Ljava/lang/String;


# direct methods
.method public constructor <init>(IILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "pageSize"    # I
    .param p2, "nextPageTriggerCount"    # I
    .param p3, "asin"    # Ljava/lang/String;
    .param p4, "requestId"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/control/PagedListingBrowser;-><init>(II)V

    .line 35
    iput-object p3, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->asin:Ljava/lang/String;

    .line 36
    iput-object p4, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->requestId:Ljava/lang/String;

    .line 37
    return-void
.end method


# virtual methods
.method public receivedOfferListing(Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;
    .param p2, "index"    # I
    .param p3, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 84
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->objectReceived(Ljava/lang/Object;ILcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 85
    return-void
.end method

.method public receivedPrimeOneClickStatus(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 71
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser$1;-><init>(Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 79
    return-void
.end method

.method public setConditionType(Ljava/lang/String;)V
    .locals 0
    .param p1, "conditionType"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->conditionType:Ljava/lang/String;

    .line 43
    return-void
.end method

.method protected startPageRequest(I)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 4
    .param p1, "pageNumber"    # I

    .prologue
    .line 52
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;-><init>()V

    .line 53
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;
    iget-object v1, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->asin:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->setAsin(Ljava/lang/String;)V

    .line 54
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->setPage(I)V

    .line 55
    iget v1, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->pageSize:I

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->setSize(I)V

    .line 56
    iget-object v1, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->conditionType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;->setConditionType(Ljava/lang/String;)V

    .line 59
    const-string/jumbo v1, "offer_listings_v32"

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/amazon/mShop/control/marketplace/OfferListingBrowser;->requestId:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 61
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->offerListings(Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    return-object v1
.end method
