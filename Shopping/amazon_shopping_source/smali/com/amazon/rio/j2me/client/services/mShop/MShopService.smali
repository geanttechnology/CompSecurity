.class public interface abstract Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
.super Ljava/lang/Object;
.source "MShopService.java"


# virtual methods
.method public abstract addListIdeas(Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListIdeasResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract addListItems(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract addToCart(Lcom/amazon/rio/j2me/client/services/mShop/CartAdditionRequest;Lcom/amazon/rio/j2me/client/services/mShop/AddToCartResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract advSearch(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract advSearchSuggestions(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract barcodeBadMatch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatch;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeBadMatchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract barcodeSearch(Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/BarcodeSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract basicProducts(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsRequest;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract buyAsin(Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinRequest;Lcom/amazon/rio/j2me/client/services/mShop/BuyAsinResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract cart(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/CartResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract checkLogin(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract checkUpgrade(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeRequest;Lcom/amazon/rio/j2me/client/services/mShop/CheckUpgradeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract deal(Lcom/amazon/rio/j2me/client/services/mShop/DealRequest;Lcom/amazon/rio/j2me/client/services/mShop/DealResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract disableOneClick(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/DisableOneClickResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract enableOneClick(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/EnableOneClickResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract featureState(Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateRequest;Lcom/amazon/rio/j2me/client/services/mShop/FeatureStateResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getListLists(Lcom/amazon/rio/j2me/client/services/mShop/GetListListsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetListListsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getOneClickAddresses(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickAddressesResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getOneClickBasicInfo(Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickConfigResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getPointsSummary(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/mShop/GetPointsSummaryResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract getRecommendedItems(Lcom/amazon/rio/j2me/client/services/mShop/RecommendedItemsRequest;Lcom/amazon/rio/j2me/client/services/mShop/GetRecommendedItemsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract home(Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract identifyUserWithSis(Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisRequest;Lcom/amazon/rio/j2me/client/services/mShop/IdentifyUserWithSisResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract imageSearch(Lcom/amazon/rio/j2me/client/services/mShop/PhotoSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/ImageSearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract kiangRegister(Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract kiangUpdate(Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateRequest;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract locale(Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract login(Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract logout(Lcom/amazon/rio/j2me/client/services/mShop/LogoutRequest;Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract navigationMenu(Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract newAccount(Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;Lcom/amazon/rio/j2me/client/services/mShop/NewAccountResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract offerListings(Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsRequest;Lcom/amazon/rio/j2me/client/services/mShop/OfferListingsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract postEvents(Lcom/amazon/rio/j2me/client/services/mShop/PostEventsRequest;Lcom/amazon/rio/j2me/client/services/mShop/PostEventsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract product(Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;Lcom/amazon/rio/j2me/client/services/mShop/ProductResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract query(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/QueryResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract rateRecs(Lcom/amazon/rio/j2me/client/services/mShop/RateRecsRequest;Lcom/amazon/rio/j2me/client/services/mShop/RateRecsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract recognizeAuthenticityCode(Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeRequest;Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract search(Lcom/amazon/rio/j2me/client/services/mShop/SearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract searchDeliveryLocations(Lcom/amazon/rio/j2me/client/services/mShop/DeliveryLocationsSearchRequest;Lcom/amazon/rio/j2me/client/services/mShop/SearchDeliveryLocationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract setApplicationID(Ljava/lang/String;)V
.end method

.method public abstract setNotificationSubscriptions(Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract setOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigRequest;Lcom/amazon/rio/j2me/client/services/mShop/SetOneClickConfigResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract smileInfo(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract toggleMarketplaceNotifications(Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method

.method public abstract updateNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
.end method
