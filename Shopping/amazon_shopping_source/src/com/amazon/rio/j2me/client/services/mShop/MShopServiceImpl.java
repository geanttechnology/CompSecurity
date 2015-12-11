// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.rsc.ServiceCallInvoker;
import com.amazon.rio.j2me.client.services.RioEventListener;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.ServiceCallImpl;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            MShopService, AddListIdeasClientRequestReply, AddListItemsClientRequestReply, AddToCartClientRequestReply, 
//            AdvSearchClientRequestReply, AdvSearchSuggestionsClientRequestReply, BarcodeBadMatchClientRequestReply, BarcodeSearchClientRequestReply, 
//            BasicProductsClientRequestReply, BuyAsinClientRequestReply, CartClientRequestReply, CheckLoginClientRequestReply, 
//            CheckUpgradeClientRequestReply, DealClientRequestReply, DisableOneClickClientRequestReply, EnableOneClickClientRequestReply, 
//            FeatureStateClientRequestReply, GetListListsClientRequestReply, GetNotificationSubscriptionsClientRequestReply, GetOneClickAddressesClientRequestReply, 
//            GetOneClickBasicInfoClientRequestReply, GetOneClickConfigClientRequestReply, GetPointsSummaryClientRequestReply, GetRecommendedItemsClientRequestReply, 
//            HomeClientRequestReply, IdentifyUserWithSisClientRequestReply, ImageSearchClientRequestReply, KiangRegisterClientRequestReply, 
//            KiangUpdateClientRequestReply, LocaleClientRequestReply, LoginClientRequestReply, LogoutClientRequestReply, 
//            NavigationMenuClientRequestReply, NewAccountClientRequestReply, OfferListingsClientRequestReply, PostEventsClientRequestReply, 
//            PostMetricsClientRequestReply, ProductClientRequestReply, QueryClientRequestReply, RateRecsClientRequestReply, 
//            RecognizeAuthenticityCodeClientRequestReply, SearchClientRequestReply, SearchDeliveryLocationsClientRequestReply, SetNotificationSubscriptionsClientRequestReply, 
//            SetOneClickConfigClientRequestReply, SmileInfoClientRequestReply, ToggleMarketplaceNotificationsClientRequestReply, UpdateNotificationTargetClientRequestReply, 
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

public class MShopServiceImpl
    implements MShopService
{

    private String applicationID;
    private final RioEventListener eventListener;
    private final ServiceCallInvoker invoker;

    public MShopServiceImpl(String s, ServiceCallInvoker servicecallinvoker, RioEventListener rioeventlistener)
    {
        setApplicationID(s);
        invoker = servicecallinvoker;
        eventListener = rioeventlistener;
    }

    public ServiceCall addListIdeas(AddListIdeasRequest addlistideasrequest, AddListIdeasResponseListener addlistideasresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "add_list_ideas_v38", getApplicationID(), true, true, new AddListIdeasClientRequestReply(servicecallimpl, addlistideasrequest, addlistideasresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall addListItems(AddListItemsRequest addlistitemsrequest, AddListItemsResponseListener addlistitemsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "add_list_items_v37", getApplicationID(), false, true, new AddListItemsClientRequestReply(servicecallimpl, addlistitemsrequest, addlistitemsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall addToCart(CartAdditionRequest cartadditionrequest, AddToCartResponseListener addtocartresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "add_to_cart_v32", getApplicationID(), false, true, new AddToCartClientRequestReply(servicecallimpl, cartadditionrequest, addtocartresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall advSearch(AdvSearchRequest advsearchrequest, AdvSearchResponseListener advsearchresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "adv_search_v34", getApplicationID(), false, true, new AdvSearchClientRequestReply(servicecallimpl, advsearchrequest, advsearchresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall advSearchSuggestions(AdvSearchSuggestionsRequest advsearchsuggestionsrequest, AdvSearchSuggestionsResponseListener advsearchsuggestionsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "adv_search_suggestions_v34", getApplicationID(), false, true, new AdvSearchSuggestionsClientRequestReply(servicecallimpl, advsearchsuggestionsrequest, advsearchsuggestionsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall barcodeBadMatch(BarcodeBadMatch barcodebadmatch, BarcodeBadMatchResponseListener barcodebadmatchresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "barcode_bad_match_v11", getApplicationID(), false, true, new BarcodeBadMatchClientRequestReply(servicecallimpl, barcodebadmatch, barcodebadmatchresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall barcodeSearch(BarcodeSearchRequest barcodesearchrequest, BarcodeSearchResponseListener barcodesearchresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "barcode_search_v32", getApplicationID(), false, true, new BarcodeSearchClientRequestReply(servicecallimpl, barcodesearchrequest, barcodesearchresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall basicProducts(BasicProductsRequest basicproductsrequest, BasicProductsResponseListener basicproductsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "basic_products_v32", getApplicationID(), true, true, new BasicProductsClientRequestReply(servicecallimpl, basicproductsrequest, basicproductsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall buyAsin(BuyAsinRequest buyasinrequest, BuyAsinResponseListener buyasinresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "buy_asin_v28", getApplicationID(), true, true, new BuyAsinClientRequestReply(servicecallimpl, buyasinrequest, buyasinresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall cart(Null null1, CartResponseListener cartresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "cart_v32", getApplicationID(), false, true, new CartClientRequestReply(servicecallimpl, null1, cartresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall checkLogin(CheckLoginRequest checkloginrequest, CheckLoginResponseListener checkloginresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "check_login_v35", getApplicationID(), true, true, new CheckLoginClientRequestReply(servicecallimpl, checkloginrequest, checkloginresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall checkUpgrade(UpgradeRequest upgraderequest, CheckUpgradeResponseListener checkupgraderesponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "check_upgrade_v34", getApplicationID(), true, true, new CheckUpgradeClientRequestReply(servicecallimpl, upgraderequest, checkupgraderesponselistener)));
        return servicecallimpl;
    }

    public ServiceCall deal(DealRequest dealrequest, DealResponseListener dealresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "deal_v32", getApplicationID(), false, true, new DealClientRequestReply(servicecallimpl, dealrequest, dealresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall disableOneClick(Null null1, DisableOneClickResponseListener disableoneclickresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "disable_one_click_v1", getApplicationID(), true, true, new DisableOneClickClientRequestReply(servicecallimpl, null1, disableoneclickresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall enableOneClick(String s, EnableOneClickResponseListener enableoneclickresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "enable_one_click_v1", getApplicationID(), true, true, new EnableOneClickClientRequestReply(servicecallimpl, s, enableoneclickresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall featureState(FeatureStateRequest featurestaterequest, FeatureStateResponseListener featurestateresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "feature_state_v36", getApplicationID(), true, true, new FeatureStateClientRequestReply(servicecallimpl, featurestaterequest, featurestateresponselistener)));
        return servicecallimpl;
    }

    public String getApplicationID()
    {
        return applicationID;
    }

    public ServiceCall getListLists(GetListListsRequest getlistlistsrequest, GetListListsResponseListener getlistlistsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_list_lists_v37", getApplicationID(), false, true, new GetListListsClientRequestReply(servicecallimpl, getlistlistsrequest, getlistlistsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall getNotificationSubscriptions(GetNotificationSubscriptionsRequest getnotificationsubscriptionsrequest, GetNotificationSubscriptionsResponseListener getnotificationsubscriptionsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_notification_subscriptions_v35", getApplicationID(), true, true, new GetNotificationSubscriptionsClientRequestReply(servicecallimpl, getnotificationsubscriptionsrequest, getnotificationsubscriptionsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall getOneClickAddresses(Null null1, GetOneClickAddressesResponseListener getoneclickaddressesresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_one_click_addresses_v21", getApplicationID(), true, true, new GetOneClickAddressesClientRequestReply(servicecallimpl, null1, getoneclickaddressesresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall getOneClickBasicInfo(GetOneClickBasicInfoRequest getoneclickbasicinforequest, GetOneClickBasicInfoResponseListener getoneclickbasicinforesponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_one_click_basic_info_v39", getApplicationID(), true, true, new GetOneClickBasicInfoClientRequestReply(servicecallimpl, getoneclickbasicinforequest, getoneclickbasicinforesponselistener)));
        return servicecallimpl;
    }

    public ServiceCall getOneClickConfig(Null null1, GetOneClickConfigResponseListener getoneclickconfigresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_one_click_config_v21", getApplicationID(), true, true, new GetOneClickConfigClientRequestReply(servicecallimpl, null1, getoneclickconfigresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall getPointsSummary(Null null1, GetPointsSummaryResponseListener getpointssummaryresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_points_summary_v8", getApplicationID(), true, true, new GetPointsSummaryClientRequestReply(servicecallimpl, null1, getpointssummaryresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall getRecommendedItems(RecommendedItemsRequest recommendeditemsrequest, GetRecommendedItemsResponseListener getrecommendeditemsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "get_recommended_items_v32", getApplicationID(), false, true, new GetRecommendedItemsClientRequestReply(servicecallimpl, recommendeditemsrequest, getrecommendeditemsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall home(HomeRequest homerequest, HomeResponseListener homeresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "home_v38", getApplicationID(), false, true, new HomeClientRequestReply(servicecallimpl, homerequest, homeresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall identifyUserWithSis(IdentifyUserWithSisRequest identifyuserwithsisrequest, IdentifyUserWithSisResponseListener identifyuserwithsisresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "identify_user_with_sis_v25", getApplicationID(), true, true, new IdentifyUserWithSisClientRequestReply(servicecallimpl, identifyuserwithsisrequest, identifyuserwithsisresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall imageSearch(PhotoSearchRequest photosearchrequest, ImageSearchResponseListener imagesearchresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "image_search_v32", getApplicationID(), false, true, new ImageSearchClientRequestReply(servicecallimpl, photosearchrequest, imagesearchresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall kiangRegister(KiangRegisterRequest kiangregisterrequest, KiangRegisterResponseListener kiangregisterresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "kiang_register_v39", getApplicationID(), true, true, new KiangRegisterClientRequestReply(servicecallimpl, kiangregisterrequest, kiangregisterresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall kiangUpdate(KiangUpdateRequest kiangupdaterequest, KiangUpdateResponseListener kiangupdateresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "kiang_update_v39", getApplicationID(), true, true, new KiangUpdateClientRequestReply(servicecallimpl, kiangupdaterequest, kiangupdateresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall locale(LocaleRequest localerequest, LocaleResponseListener localeresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "locale_v28", getApplicationID(), true, true, new LocaleClientRequestReply(servicecallimpl, localerequest, localeresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall login(LoginRequest loginrequest, LoginResponseListener loginresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "login_v35", getApplicationID(), true, true, new LoginClientRequestReply(servicecallimpl, loginrequest, loginresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall logout(LogoutRequest logoutrequest, LogoutResponseListener logoutresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "logout_v35", getApplicationID(), true, true, new LogoutClientRequestReply(servicecallimpl, logoutrequest, logoutresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall navigationMenu(NavigationMenuRequest navigationmenurequest, NavigationMenuResponseListener navigationmenuresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "navigation_menu_v34", getApplicationID(), false, true, new NavigationMenuClientRequestReply(servicecallimpl, navigationmenurequest, navigationmenuresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall newAccount(NewAccountRequest newaccountrequest, NewAccountResponseListener newaccountresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "new_account_v34", getApplicationID(), true, true, new NewAccountClientRequestReply(servicecallimpl, newaccountrequest, newaccountresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall offerListings(OfferListingsRequest offerlistingsrequest, OfferListingsResponseListener offerlistingsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "offer_listings_v32", getApplicationID(), false, true, new OfferListingsClientRequestReply(servicecallimpl, offerlistingsrequest, offerlistingsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall postEvents(PostEventsRequest posteventsrequest, PostEventsResponseListener posteventsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "post_events_v34", getApplicationID(), true, true, new PostEventsClientRequestReply(servicecallimpl, posteventsrequest, posteventsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall postMetrics(ClientMetrics clientmetrics, PostMetricsResponseListener postmetricsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "post_metrics_v36", getApplicationID(), true, true, new PostMetricsClientRequestReply(servicecallimpl, clientmetrics, postmetricsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall product(ProductRequest productrequest, ProductResponseListener productresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "product_v32", getApplicationID(), false, true, new ProductClientRequestReply(servicecallimpl, productrequest, productresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall query(SearchRequest searchrequest, QueryResponseListener queryresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "query_v32", getApplicationID(), false, true, new QueryClientRequestReply(servicecallimpl, searchrequest, queryresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall rateRecs(RateRecsRequest raterecsrequest, RateRecsResponseListener raterecsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "rate_recs_v17", getApplicationID(), false, true, new RateRecsClientRequestReply(servicecallimpl, raterecsrequest, raterecsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall recognizeAuthenticityCode(RecognizeAuthenticityCodeRequest recognizeauthenticitycoderequest, RecognizeAuthenticityCodeResponseListener recognizeauthenticitycoderesponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "recognize_authenticity_code_v38", getApplicationID(), true, true, new RecognizeAuthenticityCodeClientRequestReply(servicecallimpl, recognizeauthenticitycoderequest, recognizeauthenticitycoderesponselistener)));
        return servicecallimpl;
    }

    public ServiceCall search(SearchRequest searchrequest, SearchResponseListener searchresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "search_v32", getApplicationID(), false, true, new SearchClientRequestReply(servicecallimpl, searchrequest, searchresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall searchDeliveryLocations(DeliveryLocationsSearchRequest deliverylocationssearchrequest, SearchDeliveryLocationsResponseListener searchdeliverylocationsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "search_delivery_locations_v21", getApplicationID(), false, true, new SearchDeliveryLocationsClientRequestReply(servicecallimpl, deliverylocationssearchrequest, searchdeliverylocationsresponselistener)));
        return servicecallimpl;
    }

    public void setApplicationID(String s)
    {
        applicationID = s;
    }

    public ServiceCall setNotificationSubscriptions(SetNotificationSubscriptionsRequest setnotificationsubscriptionsrequest, SetNotificationSubscriptionsResponseListener setnotificationsubscriptionsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "set_notification_subscriptions_v35", getApplicationID(), true, true, new SetNotificationSubscriptionsClientRequestReply(servicecallimpl, setnotificationsubscriptionsrequest, setnotificationsubscriptionsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall setOneClickConfig(SetOneClickConfigRequest setoneclickconfigrequest, SetOneClickConfigResponseListener setoneclickconfigresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "set_one_click_config_v21", getApplicationID(), true, true, new SetOneClickConfigClientRequestReply(servicecallimpl, setoneclickconfigrequest, setoneclickconfigresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall smileInfo(SmileInfoRequest smileinforequest, SmileInfoResponseListener smileinforesponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "smile_info_v38", getApplicationID(), true, true, new SmileInfoClientRequestReply(servicecallimpl, smileinforequest, smileinforesponselistener)));
        return servicecallimpl;
    }

    public ServiceCall toggleMarketplaceNotifications(ToggleMarketplaceNotificationsRequest togglemarketplacenotificationsrequest, ToggleMarketplaceNotificationsResponseListener togglemarketplacenotificationsresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "toggle_marketplace_notifications_v35", getApplicationID(), true, true, new ToggleMarketplaceNotificationsClientRequestReply(servicecallimpl, togglemarketplacenotificationsrequest, togglemarketplacenotificationsresponselistener)));
        return servicecallimpl;
    }

    public ServiceCall updateNotificationTarget(UpdateNotificationTargetRequest updatenotificationtargetrequest, UpdateNotificationTargetResponseListener updatenotificationtargetresponselistener)
    {
        ServiceCallImpl servicecallimpl = new ServiceCallImpl(eventListener);
        servicecallimpl.setUnderlyingCall(invoker.invoke("mShop", "update_notification_target_v35", getApplicationID(), true, true, new UpdateNotificationTargetClientRequestReply(servicecallimpl, updatenotificationtargetrequest, updatenotificationtargetresponselistener)));
        return servicecallimpl;
    }
}
