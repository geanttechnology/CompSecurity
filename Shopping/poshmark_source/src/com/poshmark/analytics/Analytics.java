// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.analytics;

import android.content.Intent;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.BuildType;
import com.poshmark.config.BuildTypeConfig;
import com.poshmark.config.EnvConfig;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;

public class Analytics
{
    private static class SingletonHolder
    {

        public static final Analytics INSTANCE = new Analytics();


        private SingletonHolder()
        {
        }
    }


    public static final String AnalyticsAccountBalanceButtonTapped = "account_balance_button_tapped";
    public static final String AnalyticsAccountBalanceRowTapped = "account_balance_row_tapped";
    public static final String AnalyticsBuyerSubmitOfferButtonClicked = "offer_price_entered_next_tapped";
    public static final String AnalyticsBuyerViewOfferButtonClicked = "buyer_view_offer_link_tapped";
    public static final String AnalyticsCategoryApp = "app";
    public static final String AnalyticsCategoryBrand = "brand";
    public static final String AnalyticsCategoryBundle = "bundle";
    public static final String AnalyticsCategoryError = "error";
    public static final String AnalyticsCategoryListing = "listing";
    public static final String AnalyticsCategoryParty = "party";
    public static final String AnalyticsCategoryShowroom = "showroom";
    public static final String AnalyticsCategoryUser = "user";
    public static final String AnalyticsEventAddBundleToOrder = "added_bundle_to_order";
    public static final String AnalyticsEventAddItemsToBundleButtonClicked = "add_listing_to_bundle_cell_tapped";
    public static final String AnalyticsEventAddItemsToBundleClicked = "add_more_listings_to_bundle_tapped";
    public static final String AnalyticsEventAddToBundleClicked = "add_listing_to_bundle_tapped";
    public static final String AnalyticsEventAddedLineItemToOrder = "added_lineitem_to_order";
    public static final String AnalyticsEventAppLaunch = "launch";
    public static final String AnalyticsEventAppTerminate = "terminate";
    public static final String AnalyticsEventBrandFollowed = "brand_followed";
    public static final String AnalyticsEventBrandLinkSelected = "brand_link_tapped";
    public static final String AnalyticsEventBrandSearched = "brand_searched";
    public static final String AnalyticsEventBrandShareBannerDismissButtonTapped = "brand_share_banner_close_button_tapped";
    public static final String AnalyticsEventBrandShareBannerDisplayed = "brand_share_banner_displayed";
    public static final String AnalyticsEventBrandShareBannerDisplayedFirstTime = "brand_share_banner_displayed_first_time";
    public static final String AnalyticsEventBrandShareBannerInviteFriendsButtonTapped = "brand_share_banner_invite_friends_button_tapped";
    public static final String AnalyticsEventBrandShareFailed = "share_brand_failed";
    public static final String AnalyticsEventBrandSharedOnFacebook = "share_brand_facebook";
    public static final String AnalyticsEventBrandSharedOnPoshmark = "share_brand_poshmark";
    public static final String AnalyticsEventBrandSharedOnTumblr = "share_brand_tumblr";
    public static final String AnalyticsEventBrandSharedOnTwitter = "share_brand_twitter";
    public static final String AnalyticsEventBrandSharedUsingEmail = "share_brand_email";
    public static final String AnalyticsEventBrandSharedUsingMessenger = "share_brand_fbmessenger";
    public static final String AnalyticsEventBrandSharedUsingSMS = "share_brand_sms";
    public static final String AnalyticsEventBrandUnFollowed = "brand_unfollowed";
    public static final String AnalyticsEventBrowseListingByCondition = "browse_listings_by_condition";
    public static final String AnalyticsEventBrowseListingsByCategory = "browse_listings_by_category";
    public static final String AnalyticsEventBrowseListingsByCategoryShopTab = "browse_listings_by_category_shop_tab";
    public static final String AnalyticsEventBrowseListingsByColor = "browse_listings_by_color";
    public static final String AnalyticsEventBrowseListingsByColorShopTab = "browse_listings_by_color_shop_tab";
    public static final String AnalyticsEventBrowseListingsBySubcategory = "browse_listings_by_subcategory";
    public static final String AnalyticsEventBrowseListingsBySubcategoryShopTab = "browse_listings_by_subcategory_shop_tab";
    public static final String AnalyticsEventBundleBuyButtonClicked = "buy_bundle_tapped";
    public static final String AnalyticsEventBuyButtonClicked = "buy_button_clicked";
    public static final String AnalyticsEventCachedItemsDisplayed = "cached_items_displayed";
    public static final String AnalyticsEventClosetShared = "mycloset_share_button_tapped";
    public static final String AnalyticsEventClosetSharedUsingEmail = "share_closet_email";
    public static final String AnalyticsEventClosetSharedUsingFbDialog = "share_closet_fb_dialog";
    public static final String AnalyticsEventClosetSharedUsingMessenger = "share_closet_fbmessenger";
    public static final String AnalyticsEventClosetSharedUsingSMS = "share_closet_sms";
    public static final String AnalyticsEventClosetViewBundlesTapped = "view_bundle_tapped";
    public static final String AnalyticsEventComment = "comment";
    public static final String AnalyticsEventCommentButtonTapped = "comment_button_tapped";
    public static final String AnalyticsEventCompletedOrder = "completed_order";
    public static final String AnalyticsEventDeleteComment = "delete_listing_comment";
    public static final String AnalyticsEventDeleteListing = "delete_listing";
    public static final String AnalyticsEventEditListingComplete = "edit_listing_complete";
    public static final String AnalyticsEventEditListingStart = "edit_listing_start";
    public static final String AnalyticsEventEmailSignUp = "email_signup";
    public static final String AnalyticsEventEmailSignUpFlowInitiated = "email_signup_flow_initiated";
    public static final String AnalyticsEventFBConnectClicked = "fb_connect_click";
    public static final String AnalyticsEventFBConnectSucccess = "fb_connect_success";
    public static final String AnalyticsEventFacebookSignUp = "facebook_signup";
    public static final String AnalyticsEventFacebookSignUpFlowInitiated = "facebook_signup_flow_initiated";
    public static final String AnalyticsEventFeedColdStart = "feed_cold_start";
    public static final String AnalyticsEventFeedResurrected = "feed_resurrected";
    public static final String AnalyticsEventFilterApplied = "filter_applied";
    public static final String AnalyticsEventFilterClicked = "filter_clicked";
    public static final String AnalyticsEventFilterSelected = "filter_selected";
    public static final String AnalyticsEventGPConnectSucccess = "gp_connect_success";
    public static final String AnalyticsEventGooglePlusConnectClicked = "gp_connect_click";
    public static final String AnalyticsEventGooglePlusSignUpFlowInitiated = "gp_signup_flow_initiated";
    public static final String AnalyticsEventGoogleSignUp = "gp_signup";
    public static final String AnalyticsEventImageFilterPreviewed = "image_filter_preview";
    public static final String AnalyticsEventImageFilterSelected = "image_filter_selected";
    public static final String AnalyticsEventInviteFBFriends = "referral_facebook";
    public static final String AnalyticsEventInviteFriendsFailed = "referral_failed";
    public static final String AnalyticsEventInviteFriendsViaEmail = "referral_email";
    public static final String AnalyticsEventInviteFriendsViaFbDialog = "referral_fb_dialog";
    public static final String AnalyticsEventInviteFriendsViaMessenger = "referral_fbmessenger";
    public static final String AnalyticsEventInviteFriendsViaSMS = "referral_sms";
    public static final String AnalyticsEventInviteTumblrFriends = "referral_tumblr";
    public static final String AnalyticsEventInviteTwitterFriends = "referral_twitter";
    public static final String AnalyticsEventJoinInSignUpClicked = "join_in_signup_clicked";
    public static final String AnalyticsEventLabelInFBSettings = "fbsettings";
    public static final String AnalyticsEventLabelOff = "off";
    public static final String AnalyticsEventLabelOn = "on";
    public static final String AnalyticsEventLike = "like";
    public static final String AnalyticsEventListingSelectColor = "listing_select_color";
    public static final String AnalyticsEventListingSetColor = "listing_set_color";
    public static final String AnalyticsEventListingSetCondition = "listing_set_listing_condition";
    public static final String AnalyticsEventListingSetSubcategory = "listing_set_subcategory";
    public static final String AnalyticsEventListingShareFailed = "share_listing_failed";
    public static final String AnalyticsEventListingSharedOnFacebook = "share_listing_facebook";
    public static final String AnalyticsEventListingSharedOnPinterest = "share_listing_pinterest";
    public static final String AnalyticsEventListingSharedOnPoshmark = "share_listing_poshmark";
    public static final String AnalyticsEventListingSharedOnPoshmarkAndPoshParty = "share_listing_poshmark_poshparty";
    public static final String AnalyticsEventListingSharedOnTumblr = "share_listing_tumblr";
    public static final String AnalyticsEventListingSharedOnTwitter = "share_listing_twitter";
    public static final String AnalyticsEventListingSharedUsingEmail = "share_listing_email";
    public static final String AnalyticsEventListingSharedUsingFbDialog = "share_listing_fb_dialog";
    public static final String AnalyticsEventListingSharedUsingMessenger = "share_listing_fbmessenger";
    public static final String AnalyticsEventListingSharedUsingPinterest = "share_pinterest";
    public static final String AnalyticsEventListingSharedUsingSMS = "share_listing_sms";
    public static final String AnalyticsEventListingsFiltered = "listings_filtered";
    public static final String AnalyticsEventLoadContacts = "load_contacts";
    public static final String AnalyticsEventLoadFacebookFriends = "load_facebook_friends";
    public static final String AnalyticsEventLoadNewClosets = "load_new_closets";
    public static final String AnalyticsEventLoadSuggestedUsers = "onramp_suggested_users_viewed";
    public static final String AnalyticsEventLoadTwitterFriends = "load_twitter_friends";
    public static final String AnalyticsEventLogin = "login";
    public static final String AnalyticsEventLogout = "logout";
    public static final String AnalyticsEventMySizeUpdated = "my_size_updated";
    public static final String AnalyticsEventNewItemsBubbleClicked = "new_items_bubble_clicked";
    public static final String AnalyticsEventNewItemsBubbleDisplayed = "new_items_bubble_displayed";
    public static final String AnalyticsEventNewListingComplete = "new_listing_complete";
    public static final String AnalyticsEventNewListingStart = "new_listing_start";
    public static final String AnalyticsEventOfferButtonClicked = "buyer_make_offer_link_tapped";
    public static final String AnalyticsEventOnRampBrandFollowed = "onramp_brand_followed";
    public static final String AnalyticsEventOnRampBrandUnFollowed = "onramp_brand_unfollowed";
    public static final String AnalyticsEventOnRampCompleted = "completed_on_ramp";
    public static final String AnalyticsEventOnRampDressSizeEntered = "onramp_dress_size_entered";
    public static final String AnalyticsEventOnRampLocationEntered = "onramp_mycity_entered";
    public static final String AnalyticsEventOnRampNoBrandsFollowed = "onramp_brand_next_nofollowed";
    public static final String AnalyticsEventOnRampProfileNextButtonTapped = "create_profile_button_tapped";
    public static final String AnalyticsEventOnRampShoeSizeEntered = "onramp_shoe_size_entered";
    public static final String AnalyticsEventOnRampWebsiteEntered = "onramp_website_entered";
    public static final String AnalyticsEventPagesScrolledByUser = "pages_scrolled_by_user";
    public static final String AnalyticsEventPartyChangeShowroom = "party_change_showroom";
    public static final String AnalyticsEventPartyInviteShareFailed = "share_party_failed";
    public static final String AnalyticsEventPartyNotificationClicked = "join_party_notification_clicked";
    public static final String AnalyticsEventPartySharedOnFacebook = "share_facebook";
    public static final String AnalyticsEventPartySharedOnTumblr = "share_tumblr";
    public static final String AnalyticsEventPartySharedOnTwitter = "share_twitter";
    public static final String AnalyticsEventPartySharedUsingEmail = "share_email";
    public static final String AnalyticsEventPartySharedUsingFbDialog = "share_fb_dialog";
    public static final String AnalyticsEventPartySharedUsingMessenger = "share_fbmessenger";
    public static final String AnalyticsEventPartySharedUsingSMS = "share_sms";
    public static final String AnalyticsEventPinterestConnectCancelled = "connect_pinterest_cancelled";
    public static final String AnalyticsEventPinterestConnectComplete = "connect_pinterest_complete";
    public static final String AnalyticsEventPinterestConnectFailed = "connect_pinterest_failed";
    public static final String AnalyticsEventPinterestConnectInitiated = "connect_pinterest_initiated";
    public static final String AnalyticsEventProfileImageTapped = "profile_image_tapped";
    public static final String AnalyticsEventRefreshMyFeedClicked = "refresh_myfeed_clicked";
    public static final String AnalyticsEventRefreshNewsClicked = "refresh_news_clicked";
    public static final String AnalyticsEventRefreshPartyClicked = "refresh_party_clicked";
    public static final String AnalyticsEventRemoveListingFromBundleButtonClicked = "remove_listing_from_bundle_tapped";
    public static final String AnalyticsEventRemovedLineItemFromOrder = "removed_lineitem_from_order";
    public static final String AnalyticsEventReportListing = "report_listing";
    public static final String AnalyticsEventRequestTimeoutError = "request_timeout_error";
    public static final String AnalyticsEventSearchIconInMyFeedClicked = "search_listings_button_clicked";
    public static final String AnalyticsEventSecureCheckout = "secure_checkout";
    public static final String AnalyticsEventShareButtonTapped = "share_button_tapped";
    public static final String AnalyticsEventShopTabClicked = "shoptab_clicked";
    public static final String AnalyticsEventShowroomSharedUsingEmail = "share_showroom_email";
    public static final String AnalyticsEventShowroomSharedUsingFbDialog = "share_showroom_fb_dialog";
    public static final String AnalyticsEventShowroomSharedUsingMessenger = "share_showroom_fbmessenger";
    public static final String AnalyticsEventShowroomSharedUsingSMS = "share_showroom_sms";
    public static final String AnalyticsEventSizeLinkSelected = "size_link_tapped";
    public static final String AnalyticsEventSubmitOffer = "offer_submit_button_tapped";
    public static final String AnalyticsEventSubmitOrder = "submit_order";
    public static final String AnalyticsEventTimelineToggled = "timeline_toggled";
    public static final String AnalyticsEventTotalBrandsFollowed = "total_onramp_brands_followed";
    public static final String AnalyticsEventTurnOffSearchVisibility = "turn_off_search_visibility";
    public static final String AnalyticsEventUnknownError = "unknown_error";
    public static final String AnalyticsEventUnlike = "unlike";
    public static final String AnalyticsEventUpdateCreditCard = "update_credit_card";
    public static final String AnalyticsEventUpdateSearchVisibilitySetting = "update_search_visibility_setting";
    public static final String AnalyticsEventUpdateShippingAddress = "update_shipping_address";
    public static final String AnalyticsEventUpdatedOrderAddress = "updated_order_address";
    public static final String AnalyticsEventUserFollowTapped = "follow_tapped";
    public static final String AnalyticsEventUserUnfollowTapped = "unfollow_tapped";
    public static final String AnalyticsEventViewAllMyBundlesClicked = "view_my_bundles_tapped";
    public static final String AnalyticsEventViewBundleClicked = "view_bundle_tapped";
    public static final String AnalyticsEventViewMoreBrandsOnRamp = "view_more_brands_onramp";
    public static final String AnalyticsEventViewUnavailableBundleItemsButtonClicked = "view_unavailable_listings_in_bundle_tapped";
    public static final String AnalyticsEventViewedSimilarListings = "similar_listings_viewed";
    public static final String AnalyticsListingActionsButtonClicked = "listing_actions_button_tapped";
    public static final String AnalyticsMakeOfferScreen = "offer_price_form_screen";
    public static final String AnalyticsOfferPaymentAndShippingEnteredNextButtonClicked = "offer_payment_and_shipping_entered_next_tapped";
    public static final String AnalyticsScreenAbout = "about_screen";
    public static final String AnalyticsScreenAccountBalances = "account_balances_screen";
    public static final String AnalyticsScreenAddComment = "add_comment_screen";
    public static final String AnalyticsScreenAddressConfirmation = "address_confirmation_screen";
    public static final String AnalyticsScreenBrand = "brand_screen";
    public static final String AnalyticsScreenBrowseListingResults = "browse_listing_results_screen";
    public static final String AnalyticsScreenBundleLearnMore = "bundle_learn_more_screen";
    public static final String AnalyticsScreenCamera = "camera_screen";
    public static final String AnalyticsScreenChangePassword = "change_password_screen";
    public static final String AnalyticsScreenCheckout = "checkout_screen";
    public static final String AnalyticsScreenCheckoutMulti = "multi_item_checkout_screen";
    public static final String AnalyticsScreenCreateUserProfile = "create_user_profile_screen";
    public static final String AnalyticsScreenCropImage = "crop_image_screen";
    public static final String AnalyticsScreenEditListing = "edit_listing_screen";
    public static final String AnalyticsScreenEditUserProfile = "edit_user_profile_screen";
    public static final String AnalyticsScreenEmailLogin = "email_login_screen";
    public static final String AnalyticsScreenEmailSignUp = "email_sign_up_screen";
    public static final String AnalyticsScreenFAQs = "faqs_screen";
    public static final String AnalyticsScreenFacebookFriends = "facebook_connections_screen";
    public static final String AnalyticsScreenFacebookShareMessage = "facebook_share_message_screen";
    public static final String AnalyticsScreenFacebookSignUp = "facebook_sign_up_screen";
    public static final String AnalyticsScreenFilterListingBrand = "listing_select_brand_filter_screen";
    public static final String AnalyticsScreenFilterListingPrice = "listing_select_price_filter_screen";
    public static final String AnalyticsScreenFilterListingSize = "listing_select_size_filter_screen";
    public static final String AnalyticsScreenFollowers = "followers_screen";
    public static final String AnalyticsScreenFollowing = "following_screen";
    public static final String AnalyticsScreenGoogleSignUp = "google_sign_up_screen";
    public static final String AnalyticsScreenImageFilters = "image_filters_screen";
    public static final String AnalyticsScreenImagePreview = "image_preview_screen";
    public static final String AnalyticsScreenItemsBought = "items_bought_screen";
    public static final String AnalyticsScreenItemsSold = "items_sold_screen";
    public static final String AnalyticsScreenJustInBrand = "brand_just_in_screen";
    public static final String AnalyticsScreenJustInShowroom = "showroom_just_in_screen";
    public static final String AnalyticsScreenListingCategoryFilter = "listing_select_category_filter_screen";
    public static final String AnalyticsScreenListingColorFilter = "listing_select_color_filter_screen";
    public static final String AnalyticsScreenListingConfirmation = "listing_confirmation_screen";
    public static final String AnalyticsScreenListingDetails = "listing_details_screen";
    public static final String AnalyticsScreenListingFilter = "listing_filter_screen";
    public static final String AnalyticsScreenListingUserLikes = "listing_user_likes_screen";
    public static final String AnalyticsScreenListingUserLikesPriceDrop = "listings_liked_price_drop_screen";
    public static final String AnalyticsScreenListingValidation = "listing_validation_screen";
    public static final String AnalyticsScreenListingsFeed = "listings_feed_screen";
    public static final String AnalyticsScreenListingsLiked = "listings_liked_screen";
    public static final String AnalyticsScreenListingsLikedJustIn = "listings_liked_just_in_screen";
    public static final String AnalyticsScreenListingsLikedPriceDrop = "listings_liked_price_drop_screen";
    public static final String AnalyticsScreenLogin = "login_screen";
    public static final String AnalyticsScreenMultiLineInput = "multiline_input_screen";
    public static final String AnalyticsScreenMultiSelector = "multi_selector_screen";
    public static final String AnalyticsScreenMyAddress = "my_address_screen";
    public static final String AnalyticsScreenMyBundles = "my_bundles_screen";
    public static final String AnalyticsScreenMyClosetStats = "my_closet_stats_screen";
    public static final String AnalyticsScreenMySize = "my_size_screen";
    public static final String AnalyticsScreenNWTPolicy = "nwt_policy_screen";
    public static final String AnalyticsScreenNameKey = "ANALYTICS_PAGE_NAME";
    public static final String AnalyticsScreenNewListing = "new_listing_screen";
    public static final String AnalyticsScreenNewlyJoinedClosets = "newly_joined_closets_screen";
    public static final String AnalyticsScreenNewlyOpenedClosets = "newly_opened_closets_screen";
    public static final String AnalyticsScreenNewsFeed = "news_feed_screen";
    public static final String AnalyticsScreenNotificationSettings = "notification_settings_screen";
    public static final String AnalyticsScreenOAuthLogin = "oauth_login_screen";
    public static final String AnalyticsScreenOffersHelp = "offers_help_screen";
    public static final String AnalyticsScreenOnRampFollowing = "on_ramp_following_screen";
    public static final String AnalyticsScreenOrderDetails = "order_details_screen";
    public static final String AnalyticsScreenOrderEditAddress = "order_edit_address_screen";
    public static final String AnalyticsScreenOrderEditCreditCard = "order_edit_credit_card_screen";
    public static final String AnalyticsScreenOrderEditCreditCardAndAddress = "order_edit_credit_card_and_address_screen";
    public static final String AnalyticsScreenPartyFeed = "party_feed_screen";
    public static final String AnalyticsScreenPartyInvite = "party_invite_screen";
    public static final String AnalyticsScreenPartyShowroomList = "party_showroom_list_screen";
    public static final String AnalyticsScreenPartyTheme = "party_theme_screen";
    public static final String AnalyticsScreenPinterestBoardSelectMyListingsScreen = "my_listings_select_board_screen";
    public static final String AnalyticsScreenPinterestBoardSelectMySharesScreen = "my_shares_select_board_screen";
    public static final String AnalyticsScreenPinterestPostDialogScreen = "post_connect_pinterest_dlg_screen";
    public static final String AnalyticsScreenPinterestPreDialogScreen = "pre_connect_pinterest_dlg_screen";
    public static final String AnalyticsScreenPinterestShareSettingsScreen = "pinterest_share_settings_screen";
    public static final String AnalyticsScreenPoshEtiquette = "posh_etiquette_screen";
    public static final String AnalyticsScreenPoshGuide = "posh_guide_screen";
    public static final String AnalyticsScreenPoshPartiesHome = "parties_home_screen";
    public static final String AnalyticsScreenPriceDropBrand = "brand_price_drop_screen";
    public static final String AnalyticsScreenPriceDropShowroom = "showroom_price_drop_screen";
    public static final String AnalyticsScreenPrivacyPolicy = "privacy_policy_screen";
    public static final String AnalyticsScreenReferral = "referral_screen";
    public static final String AnalyticsScreenSearchPeople = "search_people_screen";
    public static final String AnalyticsScreenSearchUsers = "search_users_screen";
    public static final String AnalyticsScreenSecondarySuggestedUsers = "secondary_suggested_users_screen";
    public static final String AnalyticsScreenSelectBrand = "listing_select_brand_screen";
    public static final String AnalyticsScreenSelectCategory = "listing_select_category_screen";
    public static final String AnalyticsScreenSelectColor = "listing_select_color_screen";
    public static final String AnalyticsScreenSelectListingConditionStatus = "listing_select_condition_status_screen";
    public static final String AnalyticsScreenSelectSize = "listing_select_size_screen";
    public static final String AnalyticsScreenSelectStyleTag = "listing_select_style_tag_screen";
    public static final String AnalyticsScreenSelectSubcategory = "listing_select_subcategory_screen";
    public static final String AnalyticsScreenSellerPolicy = "seller_policy_screen";
    public static final String AnalyticsScreenSellingsTool = "my_selling_tools";
    public static final String AnalyticsScreenSettings = "settings_screen";
    public static final String AnalyticsScreenShareBrandOptions = "share_brand_options_screen";
    public static final String AnalyticsScreenShareClosetOptions = "share_closet_options_screen";
    public static final String AnalyticsScreenShareListingOptions = "share_listing_options_screen";
    public static final String AnalyticsScreenSharePartyOptions = "share_party_options_screen";
    public static final String AnalyticsScreenShareSettings = "share_settings_screen";
    public static final String AnalyticsScreenShareShowroomOptions = "share_showroom_options_screen";
    public static final String AnalyticsScreenSharedListings = "shared_listings_page";
    public static final String AnalyticsScreenShop = "shop_screen";
    public static final String AnalyticsScreenShowroomFeed = "showroom_feed_screen";
    public static final String AnalyticsScreenSuggestedBrand = "suggested_brands_screen";
    public static final String AnalyticsScreenSuggestedUsers = "suggested_users_screen";
    public static final String AnalyticsScreenSupportCenter = "support_center_screen";
    public static final String AnalyticsScreenTermsAndConditions = "terms_and_conditions_screen";
    public static final String AnalyticsScreenTumblrLogin = "tumblr_login_screen";
    public static final String AnalyticsScreenTumblrShareMessage = "tumblr_share_message_screen";
    public static final String AnalyticsScreenTwitterFriends = "twitter_connections_screen";
    public static final String AnalyticsScreenTwitterLogin = "twitter_login_screen";
    public static final String AnalyticsScreenTwitterShareMessage = "twitter_share_message_screen";
    public static final String AnalyticsScreenUserProfile = "user_profile_screen";
    public static final String AnalyticsScreenWebCommandWebView = "webcommand_webview_screen";
    public static final String AnalyticsSellerViewOfferButtonClicked = "seller_view_offers_link_tapped";
    public static final String AnalyticsViewBundleScreen = "bundle_screen";
    public static final String AnalyticsViewMyBundlesScreen = "my_bundles_screen";
    public static final String AnalyticsViewUnavailableItemsBundleScreen = "bundle_unavailable_items_screen";
    public static final String AppLoveAlertDisplayed = "app_love_alert_displayed";
    public static final String AppLoveAlertNoButtonTapped = "app_love_alert_no_button_tapped";
    public static final String AppLoveAlertYesButtonTapped = "app_love_alert_yes_button_tapped";
    public static final String AppRatingAlertDismissButtonTapped = "app_rating_alert_dismiss_button_tapped";
    public static final String AppRatingAlertRateButtonTapped = "app_rating_alert_rate_button_tapped";
    public static final String AppRatingAlertRemindLaterButtonTapped = "app_rating_alert_remind_later_button_tapped";
    public static final String AppRatingSendFeedbackAlertDisplayed = "app_rating_send_feedback_alert_displayed";
    public static final String AppSendFeedbackAlertSendButtonTapped = "app_rating_send_feedback";
    public static final String AppSendFeedbackAlertSendLaterButtonTapped = "app_rating_send_feedback_dismissed";
    public static final String CustomVarNameForAppVersion = "app_version";
    public static final String CustomVarNameForBrand = "brand";
    public static final String CustomVarNameForCategory = "category";
    public static final String CustomVarNameForUserName_UserID = "username_userid";
    public static final String CustomVarNameForUserSegment = "user_segment";
    public static final String MappDefaultAnalyticsScreenName = "mapp_screen";
    private static final int USERNAME_USERID_INDEX = 1;
    private static final int USER_SEGMENT_INDEX = 2;
    private String previousUserID;
    public final Tracker tracker;

    private Analytics()
    {
        previousUserID = null;
        GoogleAnalytics googleanalytics = GoogleAnalytics.getInstance(PMApplication.getContext());
        googleanalytics.setDryRun(false);
        googleanalytics.setAppOptOut(false);
        Logger logger = googleanalytics.getLogger();
        com.google.analytics.tracking.android.Logger.LogLevel loglevel;
        if (BuildTypeConfig.BUILD_TYPE == BuildType.DEBUG)
        {
            loglevel = com.google.analytics.tracking.android.Logger.LogLevel.VERBOSE;
        } else
        {
            loglevel = com.google.analytics.tracking.android.Logger.LogLevel.ERROR;
        }
        logger.setLogLevel(loglevel);
        GAServiceManager.getInstance().setLocalDispatchPeriod(60);
        tracker = googleanalytics.getTracker(EnvConfig.GOOGLE_ANALYTICS_ID);
        tracker.send(MapBuilder.createEvent("app", "launch", null, null).set("&sc", "start").build());
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            userLoginChanged();
        }
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", new PMNotificationListener() {

            final Analytics this$0;

            public void handleNotification(Intent intent)
            {
                userLoginChanged();
            }

            
            {
                this$0 = Analytics.this;
                super();
            }
        });
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", new PMNotificationListener() {

            final Analytics this$0;

            public void handleNotification(Intent intent)
            {
                userLoginChanged();
            }

            
            {
                this$0 = Analytics.this;
                super();
            }
        });
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.APP_STARTED", new PMNotificationListener() {

            final Analytics this$0;

            public void handleNotification(Intent intent)
            {
                userLoginChanged();
            }

            
            {
                this$0 = Analytics.this;
                super();
            }
        });
    }


    public static Analytics getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private void userLoginChanged()
    {
        String s = null;
        Object obj = null;
        Object obj1 = null;
        String s1;
        if (!PMApplicationSession.GetPMSession().isLoggedIn())
        {
            s = obj;
            s1 = obj1;
            if (previousUserID != null)
            {
                s = obj;
                s1 = obj1;
                if (previousUserID.length() > 0)
                {
                    tracker.send(MapBuilder.createEvent("user", "logout", null, null).set("&sc", "end").build());
                    s1 = obj1;
                    s = obj;
                }
            }
        } else
        {
            String s2 = PMApplicationSession.GetPMSession().getUserId();
            s1 = PMApplicationSession.GetPMSession().getUserName();
            if (s1 == null)
            {
                s1 = "";
            }
            if (s2 != null)
            {
                s = String.format("%s/%s", new Object[] {
                    s2, s1
                });
            }
            previousUserID = s2;
            s1 = PMApplicationSession.GetPMSession().getUserABSegment();
        }
        tracker.set(Fields.customDimension(1), s);
        tracker.set(Fields.customDimension(2), s1);
    }

    public void addItem(String s, String s1, String s2, String s3, Double double1, Long long1, String s4)
    {
        s = MapBuilder.createItem(s, s1, s2, s3, double1, long1, s4);
        tracker.send(s.build());
    }

    public void onDestroy()
    {
        tracker.send(MapBuilder.createEvent("app", "terminate", null, null).set("&sc", "end").build());
        GAServiceManager.getInstance().dispatchLocalHits();
    }

    public void setUserSegment(String s)
    {
        tracker.set(Fields.customDimension(2), s);
    }

    public void trackEvent(String s, String s1, String s2, String s3)
    {
        s1 = MapBuilder.createEvent(s1, s2, s3, null);
        if (s != null)
        {
            s1.set("&cd", s);
        }
        tracker.send(s1.build());
    }

    public void trackEventWithValue(String s, String s1, String s2, String s3, long l)
    {
        s1 = MapBuilder.createEvent(s1, s2, s3, Long.valueOf(l));
        if (s != null)
        {
            s1.set("&cd", s);
        }
        tracker.send(s1.build());
    }

    public void trackTransaction(String s, String s1, Double double1, Double double2, Double double3, String s2)
    {
        s = MapBuilder.createTransaction(s, s1, double1, double2, double3, s2);
        tracker.send(s.build());
    }

    public void trackView(String s)
    {
        tracker.send(MapBuilder.createAppView().set("&cd", s).build());
    }

}
