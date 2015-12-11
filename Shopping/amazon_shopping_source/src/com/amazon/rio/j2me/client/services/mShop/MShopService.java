// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            AddListIdeasRequest, AddListIdeasResponseListener, AddListItemsRequest, AddListItemsResponseListener, 
//            CartAdditionRequest, AddToCartResponseListener, AdvSearchRequest, AdvSearchResponseListener, 
//            AdvSearchSuggestionsRequest, AdvSearchSuggestionsResponseListener, BarcodeBadMatch, BarcodeBadMatchResponseListener, 
//            BarcodeSearchRequest, BarcodeSearchResponseListener, BasicProductsRequest, BasicProductsResponseListener, 
//            BuyAsinRequest, BuyAsinResponseListener, Null, CartResponseListener, 
//            CheckLoginRequest, CheckLoginResponseListener, UpgradeRequest, CheckUpgradeResponseListener, 
//            DealRequest, DealResponseListener, DisableOneClickResponseListener, EnableOneClickResponseListener, 
//            FeatureStateRequest, FeatureStateResponseListener, GetListListsRequest, GetListListsResponseListener, 
//            GetNotificationSubscriptionsRequest, GetNotificationSubscriptionsResponseListener, GetOneClickAddressesResponseListener, GetOneClickBasicInfoRequest, 
//            GetOneClickBasicInfoResponseListener, GetOneClickConfigResponseListener, GetPointsSummaryResponseListener, RecommendedItemsRequest, 
//            GetRecommendedItemsResponseListener, HomeRequest, HomeResponseListener, IdentifyUserWithSisRequest, 
//            IdentifyUserWithSisResponseListener, PhotoSearchRequest, ImageSearchResponseListener, KiangRegisterRequest, 
//            KiangRegisterResponseListener, KiangUpdateRequest, KiangUpdateResponseListener, LocaleRequest, 
//            LocaleResponseListener, LoginRequest, LoginResponseListener, LogoutRequest, 
//            LogoutResponseListener, NavigationMenuRequest, NavigationMenuResponseListener, NewAccountRequest, 
//            NewAccountResponseListener, OfferListingsRequest, OfferListingsResponseListener, PostEventsRequest, 
//            PostEventsResponseListener, ClientMetrics, PostMetricsResponseListener, ProductRequest, 
//            ProductResponseListener, SearchRequest, QueryResponseListener, RateRecsRequest, 
//            RateRecsResponseListener, RecognizeAuthenticityCodeRequest, RecognizeAuthenticityCodeResponseListener, SearchResponseListener, 
//            DeliveryLocationsSearchRequest, SearchDeliveryLocationsResponseListener, SetNotificationSubscriptionsRequest, SetNotificationSubscriptionsResponseListener, 
//            SetOneClickConfigRequest, SetOneClickConfigResponseListener, SmileInfoRequest, SmileInfoResponseListener, 
//            ToggleMarketplaceNotificationsRequest, ToggleMarketplaceNotificationsResponseListener, UpdateNotificationTargetRequest, UpdateNotificationTargetResponseListener

public interface MShopService
{

    public abstract ServiceCall addListIdeas(AddListIdeasRequest addlistideasrequest, AddListIdeasResponseListener addlistideasresponselistener);

    public abstract ServiceCall addListItems(AddListItemsRequest addlistitemsrequest, AddListItemsResponseListener addlistitemsresponselistener);

    public abstract ServiceCall addToCart(CartAdditionRequest cartadditionrequest, AddToCartResponseListener addtocartresponselistener);

    public abstract ServiceCall advSearch(AdvSearchRequest advsearchrequest, AdvSearchResponseListener advsearchresponselistener);

    public abstract ServiceCall advSearchSuggestions(AdvSearchSuggestionsRequest advsearchsuggestionsrequest, AdvSearchSuggestionsResponseListener advsearchsuggestionsresponselistener);

    public abstract ServiceCall barcodeBadMatch(BarcodeBadMatch barcodebadmatch, BarcodeBadMatchResponseListener barcodebadmatchresponselistener);

    public abstract ServiceCall barcodeSearch(BarcodeSearchRequest barcodesearchrequest, BarcodeSearchResponseListener barcodesearchresponselistener);

    public abstract ServiceCall basicProducts(BasicProductsRequest basicproductsrequest, BasicProductsResponseListener basicproductsresponselistener);

    public abstract ServiceCall buyAsin(BuyAsinRequest buyasinrequest, BuyAsinResponseListener buyasinresponselistener);

    public abstract ServiceCall cart(Null null1, CartResponseListener cartresponselistener);

    public abstract ServiceCall checkLogin(CheckLoginRequest checkloginrequest, CheckLoginResponseListener checkloginresponselistener);

    public abstract ServiceCall checkUpgrade(UpgradeRequest upgraderequest, CheckUpgradeResponseListener checkupgraderesponselistener);

    public abstract ServiceCall deal(DealRequest dealrequest, DealResponseListener dealresponselistener);

    public abstract ServiceCall disableOneClick(Null null1, DisableOneClickResponseListener disableoneclickresponselistener);

    public abstract ServiceCall enableOneClick(String s, EnableOneClickResponseListener enableoneclickresponselistener);

    public abstract ServiceCall featureState(FeatureStateRequest featurestaterequest, FeatureStateResponseListener featurestateresponselistener);

    public abstract ServiceCall getListLists(GetListListsRequest getlistlistsrequest, GetListListsResponseListener getlistlistsresponselistener);

    public abstract ServiceCall getNotificationSubscriptions(GetNotificationSubscriptionsRequest getnotificationsubscriptionsrequest, GetNotificationSubscriptionsResponseListener getnotificationsubscriptionsresponselistener);

    public abstract ServiceCall getOneClickAddresses(Null null1, GetOneClickAddressesResponseListener getoneclickaddressesresponselistener);

    public abstract ServiceCall getOneClickBasicInfo(GetOneClickBasicInfoRequest getoneclickbasicinforequest, GetOneClickBasicInfoResponseListener getoneclickbasicinforesponselistener);

    public abstract ServiceCall getOneClickConfig(Null null1, GetOneClickConfigResponseListener getoneclickconfigresponselistener);

    public abstract ServiceCall getPointsSummary(Null null1, GetPointsSummaryResponseListener getpointssummaryresponselistener);

    public abstract ServiceCall getRecommendedItems(RecommendedItemsRequest recommendeditemsrequest, GetRecommendedItemsResponseListener getrecommendeditemsresponselistener);

    public abstract ServiceCall home(HomeRequest homerequest, HomeResponseListener homeresponselistener);

    public abstract ServiceCall identifyUserWithSis(IdentifyUserWithSisRequest identifyuserwithsisrequest, IdentifyUserWithSisResponseListener identifyuserwithsisresponselistener);

    public abstract ServiceCall imageSearch(PhotoSearchRequest photosearchrequest, ImageSearchResponseListener imagesearchresponselistener);

    public abstract ServiceCall kiangRegister(KiangRegisterRequest kiangregisterrequest, KiangRegisterResponseListener kiangregisterresponselistener);

    public abstract ServiceCall kiangUpdate(KiangUpdateRequest kiangupdaterequest, KiangUpdateResponseListener kiangupdateresponselistener);

    public abstract ServiceCall locale(LocaleRequest localerequest, LocaleResponseListener localeresponselistener);

    public abstract ServiceCall login(LoginRequest loginrequest, LoginResponseListener loginresponselistener);

    public abstract ServiceCall logout(LogoutRequest logoutrequest, LogoutResponseListener logoutresponselistener);

    public abstract ServiceCall navigationMenu(NavigationMenuRequest navigationmenurequest, NavigationMenuResponseListener navigationmenuresponselistener);

    public abstract ServiceCall newAccount(NewAccountRequest newaccountrequest, NewAccountResponseListener newaccountresponselistener);

    public abstract ServiceCall offerListings(OfferListingsRequest offerlistingsrequest, OfferListingsResponseListener offerlistingsresponselistener);

    public abstract ServiceCall postEvents(PostEventsRequest posteventsrequest, PostEventsResponseListener posteventsresponselistener);

    public abstract ServiceCall postMetrics(ClientMetrics clientmetrics, PostMetricsResponseListener postmetricsresponselistener);

    public abstract ServiceCall product(ProductRequest productrequest, ProductResponseListener productresponselistener);

    public abstract ServiceCall query(SearchRequest searchrequest, QueryResponseListener queryresponselistener);

    public abstract ServiceCall rateRecs(RateRecsRequest raterecsrequest, RateRecsResponseListener raterecsresponselistener);

    public abstract ServiceCall recognizeAuthenticityCode(RecognizeAuthenticityCodeRequest recognizeauthenticitycoderequest, RecognizeAuthenticityCodeResponseListener recognizeauthenticitycoderesponselistener);

    public abstract ServiceCall search(SearchRequest searchrequest, SearchResponseListener searchresponselistener);

    public abstract ServiceCall searchDeliveryLocations(DeliveryLocationsSearchRequest deliverylocationssearchrequest, SearchDeliveryLocationsResponseListener searchdeliverylocationsresponselistener);

    public abstract void setApplicationID(String s);

    public abstract ServiceCall setNotificationSubscriptions(SetNotificationSubscriptionsRequest setnotificationsubscriptionsrequest, SetNotificationSubscriptionsResponseListener setnotificationsubscriptionsresponselistener);

    public abstract ServiceCall setOneClickConfig(SetOneClickConfigRequest setoneclickconfigrequest, SetOneClickConfigResponseListener setoneclickconfigresponselistener);

    public abstract ServiceCall smileInfo(SmileInfoRequest smileinforequest, SmileInfoResponseListener smileinforesponselistener);

    public abstract ServiceCall toggleMarketplaceNotifications(ToggleMarketplaceNotificationsRequest togglemarketplacenotificationsrequest, ToggleMarketplaceNotificationsResponseListener togglemarketplacenotificationsresponselistener);

    public abstract ServiceCall updateNotificationTarget(UpdateNotificationTargetRequest updatenotificationtargetrequest, UpdateNotificationTargetResponseListener updatenotificationtargetresponselistener);
}
