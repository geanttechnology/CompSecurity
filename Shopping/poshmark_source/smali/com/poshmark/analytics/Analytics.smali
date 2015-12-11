.class public Lcom/poshmark/analytics/Analytics;
.super Ljava/lang/Object;
.source "Analytics.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/analytics/Analytics$SingletonHolder;
    }
.end annotation


# static fields
.field public static final AnalyticsAccountBalanceButtonTapped:Ljava/lang/String; = "account_balance_button_tapped"

.field public static final AnalyticsAccountBalanceRowTapped:Ljava/lang/String; = "account_balance_row_tapped"

.field public static final AnalyticsBuyerSubmitOfferButtonClicked:Ljava/lang/String; = "offer_price_entered_next_tapped"

.field public static final AnalyticsBuyerViewOfferButtonClicked:Ljava/lang/String; = "buyer_view_offer_link_tapped"

.field public static final AnalyticsCategoryApp:Ljava/lang/String; = "app"

.field public static final AnalyticsCategoryBrand:Ljava/lang/String; = "brand"

.field public static final AnalyticsCategoryBundle:Ljava/lang/String; = "bundle"

.field public static final AnalyticsCategoryError:Ljava/lang/String; = "error"

.field public static final AnalyticsCategoryListing:Ljava/lang/String; = "listing"

.field public static final AnalyticsCategoryParty:Ljava/lang/String; = "party"

.field public static final AnalyticsCategoryShowroom:Ljava/lang/String; = "showroom"

.field public static final AnalyticsCategoryUser:Ljava/lang/String; = "user"

.field public static final AnalyticsEventAddBundleToOrder:Ljava/lang/String; = "added_bundle_to_order"

.field public static final AnalyticsEventAddItemsToBundleButtonClicked:Ljava/lang/String; = "add_listing_to_bundle_cell_tapped"

.field public static final AnalyticsEventAddItemsToBundleClicked:Ljava/lang/String; = "add_more_listings_to_bundle_tapped"

.field public static final AnalyticsEventAddToBundleClicked:Ljava/lang/String; = "add_listing_to_bundle_tapped"

.field public static final AnalyticsEventAddedLineItemToOrder:Ljava/lang/String; = "added_lineitem_to_order"

.field public static final AnalyticsEventAppLaunch:Ljava/lang/String; = "launch"

.field public static final AnalyticsEventAppTerminate:Ljava/lang/String; = "terminate"

.field public static final AnalyticsEventBrandFollowed:Ljava/lang/String; = "brand_followed"

.field public static final AnalyticsEventBrandLinkSelected:Ljava/lang/String; = "brand_link_tapped"

.field public static final AnalyticsEventBrandSearched:Ljava/lang/String; = "brand_searched"

.field public static final AnalyticsEventBrandShareBannerDismissButtonTapped:Ljava/lang/String; = "brand_share_banner_close_button_tapped"

.field public static final AnalyticsEventBrandShareBannerDisplayed:Ljava/lang/String; = "brand_share_banner_displayed"

.field public static final AnalyticsEventBrandShareBannerDisplayedFirstTime:Ljava/lang/String; = "brand_share_banner_displayed_first_time"

.field public static final AnalyticsEventBrandShareBannerInviteFriendsButtonTapped:Ljava/lang/String; = "brand_share_banner_invite_friends_button_tapped"

.field public static final AnalyticsEventBrandShareFailed:Ljava/lang/String; = "share_brand_failed"

.field public static final AnalyticsEventBrandSharedOnFacebook:Ljava/lang/String; = "share_brand_facebook"

.field public static final AnalyticsEventBrandSharedOnPoshmark:Ljava/lang/String; = "share_brand_poshmark"

.field public static final AnalyticsEventBrandSharedOnTumblr:Ljava/lang/String; = "share_brand_tumblr"

.field public static final AnalyticsEventBrandSharedOnTwitter:Ljava/lang/String; = "share_brand_twitter"

.field public static final AnalyticsEventBrandSharedUsingEmail:Ljava/lang/String; = "share_brand_email"

.field public static final AnalyticsEventBrandSharedUsingMessenger:Ljava/lang/String; = "share_brand_fbmessenger"

.field public static final AnalyticsEventBrandSharedUsingSMS:Ljava/lang/String; = "share_brand_sms"

.field public static final AnalyticsEventBrandUnFollowed:Ljava/lang/String; = "brand_unfollowed"

.field public static final AnalyticsEventBrowseListingByCondition:Ljava/lang/String; = "browse_listings_by_condition"

.field public static final AnalyticsEventBrowseListingsByCategory:Ljava/lang/String; = "browse_listings_by_category"

.field public static final AnalyticsEventBrowseListingsByCategoryShopTab:Ljava/lang/String; = "browse_listings_by_category_shop_tab"

.field public static final AnalyticsEventBrowseListingsByColor:Ljava/lang/String; = "browse_listings_by_color"

.field public static final AnalyticsEventBrowseListingsByColorShopTab:Ljava/lang/String; = "browse_listings_by_color_shop_tab"

.field public static final AnalyticsEventBrowseListingsBySubcategory:Ljava/lang/String; = "browse_listings_by_subcategory"

.field public static final AnalyticsEventBrowseListingsBySubcategoryShopTab:Ljava/lang/String; = "browse_listings_by_subcategory_shop_tab"

.field public static final AnalyticsEventBundleBuyButtonClicked:Ljava/lang/String; = "buy_bundle_tapped"

.field public static final AnalyticsEventBuyButtonClicked:Ljava/lang/String; = "buy_button_clicked"

.field public static final AnalyticsEventCachedItemsDisplayed:Ljava/lang/String; = "cached_items_displayed"

.field public static final AnalyticsEventClosetShared:Ljava/lang/String; = "mycloset_share_button_tapped"

.field public static final AnalyticsEventClosetSharedUsingEmail:Ljava/lang/String; = "share_closet_email"

.field public static final AnalyticsEventClosetSharedUsingFbDialog:Ljava/lang/String; = "share_closet_fb_dialog"

.field public static final AnalyticsEventClosetSharedUsingMessenger:Ljava/lang/String; = "share_closet_fbmessenger"

.field public static final AnalyticsEventClosetSharedUsingSMS:Ljava/lang/String; = "share_closet_sms"

.field public static final AnalyticsEventClosetViewBundlesTapped:Ljava/lang/String; = "view_bundle_tapped"

.field public static final AnalyticsEventComment:Ljava/lang/String; = "comment"

.field public static final AnalyticsEventCommentButtonTapped:Ljava/lang/String; = "comment_button_tapped"

.field public static final AnalyticsEventCompletedOrder:Ljava/lang/String; = "completed_order"

.field public static final AnalyticsEventDeleteComment:Ljava/lang/String; = "delete_listing_comment"

.field public static final AnalyticsEventDeleteListing:Ljava/lang/String; = "delete_listing"

.field public static final AnalyticsEventEditListingComplete:Ljava/lang/String; = "edit_listing_complete"

.field public static final AnalyticsEventEditListingStart:Ljava/lang/String; = "edit_listing_start"

.field public static final AnalyticsEventEmailSignUp:Ljava/lang/String; = "email_signup"

.field public static final AnalyticsEventEmailSignUpFlowInitiated:Ljava/lang/String; = "email_signup_flow_initiated"

.field public static final AnalyticsEventFBConnectClicked:Ljava/lang/String; = "fb_connect_click"

.field public static final AnalyticsEventFBConnectSucccess:Ljava/lang/String; = "fb_connect_success"

.field public static final AnalyticsEventFacebookSignUp:Ljava/lang/String; = "facebook_signup"

.field public static final AnalyticsEventFacebookSignUpFlowInitiated:Ljava/lang/String; = "facebook_signup_flow_initiated"

.field public static final AnalyticsEventFeedColdStart:Ljava/lang/String; = "feed_cold_start"

.field public static final AnalyticsEventFeedResurrected:Ljava/lang/String; = "feed_resurrected"

.field public static final AnalyticsEventFilterApplied:Ljava/lang/String; = "filter_applied"

.field public static final AnalyticsEventFilterClicked:Ljava/lang/String; = "filter_clicked"

.field public static final AnalyticsEventFilterSelected:Ljava/lang/String; = "filter_selected"

.field public static final AnalyticsEventGPConnectSucccess:Ljava/lang/String; = "gp_connect_success"

.field public static final AnalyticsEventGooglePlusConnectClicked:Ljava/lang/String; = "gp_connect_click"

.field public static final AnalyticsEventGooglePlusSignUpFlowInitiated:Ljava/lang/String; = "gp_signup_flow_initiated"

.field public static final AnalyticsEventGoogleSignUp:Ljava/lang/String; = "gp_signup"

.field public static final AnalyticsEventImageFilterPreviewed:Ljava/lang/String; = "image_filter_preview"

.field public static final AnalyticsEventImageFilterSelected:Ljava/lang/String; = "image_filter_selected"

.field public static final AnalyticsEventInviteFBFriends:Ljava/lang/String; = "referral_facebook"

.field public static final AnalyticsEventInviteFriendsFailed:Ljava/lang/String; = "referral_failed"

.field public static final AnalyticsEventInviteFriendsViaEmail:Ljava/lang/String; = "referral_email"

.field public static final AnalyticsEventInviteFriendsViaFbDialog:Ljava/lang/String; = "referral_fb_dialog"

.field public static final AnalyticsEventInviteFriendsViaMessenger:Ljava/lang/String; = "referral_fbmessenger"

.field public static final AnalyticsEventInviteFriendsViaSMS:Ljava/lang/String; = "referral_sms"

.field public static final AnalyticsEventInviteTumblrFriends:Ljava/lang/String; = "referral_tumblr"

.field public static final AnalyticsEventInviteTwitterFriends:Ljava/lang/String; = "referral_twitter"

.field public static final AnalyticsEventJoinInSignUpClicked:Ljava/lang/String; = "join_in_signup_clicked"

.field public static final AnalyticsEventLabelInFBSettings:Ljava/lang/String; = "fbsettings"

.field public static final AnalyticsEventLabelOff:Ljava/lang/String; = "off"

.field public static final AnalyticsEventLabelOn:Ljava/lang/String; = "on"

.field public static final AnalyticsEventLike:Ljava/lang/String; = "like"

.field public static final AnalyticsEventListingSelectColor:Ljava/lang/String; = "listing_select_color"

.field public static final AnalyticsEventListingSetColor:Ljava/lang/String; = "listing_set_color"

.field public static final AnalyticsEventListingSetCondition:Ljava/lang/String; = "listing_set_listing_condition"

.field public static final AnalyticsEventListingSetSubcategory:Ljava/lang/String; = "listing_set_subcategory"

.field public static final AnalyticsEventListingShareFailed:Ljava/lang/String; = "share_listing_failed"

.field public static final AnalyticsEventListingSharedOnFacebook:Ljava/lang/String; = "share_listing_facebook"

.field public static final AnalyticsEventListingSharedOnPinterest:Ljava/lang/String; = "share_listing_pinterest"

.field public static final AnalyticsEventListingSharedOnPoshmark:Ljava/lang/String; = "share_listing_poshmark"

.field public static final AnalyticsEventListingSharedOnPoshmarkAndPoshParty:Ljava/lang/String; = "share_listing_poshmark_poshparty"

.field public static final AnalyticsEventListingSharedOnTumblr:Ljava/lang/String; = "share_listing_tumblr"

.field public static final AnalyticsEventListingSharedOnTwitter:Ljava/lang/String; = "share_listing_twitter"

.field public static final AnalyticsEventListingSharedUsingEmail:Ljava/lang/String; = "share_listing_email"

.field public static final AnalyticsEventListingSharedUsingFbDialog:Ljava/lang/String; = "share_listing_fb_dialog"

.field public static final AnalyticsEventListingSharedUsingMessenger:Ljava/lang/String; = "share_listing_fbmessenger"

.field public static final AnalyticsEventListingSharedUsingPinterest:Ljava/lang/String; = "share_pinterest"

.field public static final AnalyticsEventListingSharedUsingSMS:Ljava/lang/String; = "share_listing_sms"

.field public static final AnalyticsEventListingsFiltered:Ljava/lang/String; = "listings_filtered"

.field public static final AnalyticsEventLoadContacts:Ljava/lang/String; = "load_contacts"

.field public static final AnalyticsEventLoadFacebookFriends:Ljava/lang/String; = "load_facebook_friends"

.field public static final AnalyticsEventLoadNewClosets:Ljava/lang/String; = "load_new_closets"

.field public static final AnalyticsEventLoadSuggestedUsers:Ljava/lang/String; = "onramp_suggested_users_viewed"

.field public static final AnalyticsEventLoadTwitterFriends:Ljava/lang/String; = "load_twitter_friends"

.field public static final AnalyticsEventLogin:Ljava/lang/String; = "login"

.field public static final AnalyticsEventLogout:Ljava/lang/String; = "logout"

.field public static final AnalyticsEventMySizeUpdated:Ljava/lang/String; = "my_size_updated"

.field public static final AnalyticsEventNewItemsBubbleClicked:Ljava/lang/String; = "new_items_bubble_clicked"

.field public static final AnalyticsEventNewItemsBubbleDisplayed:Ljava/lang/String; = "new_items_bubble_displayed"

.field public static final AnalyticsEventNewListingComplete:Ljava/lang/String; = "new_listing_complete"

.field public static final AnalyticsEventNewListingStart:Ljava/lang/String; = "new_listing_start"

.field public static final AnalyticsEventOfferButtonClicked:Ljava/lang/String; = "buyer_make_offer_link_tapped"

.field public static final AnalyticsEventOnRampBrandFollowed:Ljava/lang/String; = "onramp_brand_followed"

.field public static final AnalyticsEventOnRampBrandUnFollowed:Ljava/lang/String; = "onramp_brand_unfollowed"

.field public static final AnalyticsEventOnRampCompleted:Ljava/lang/String; = "completed_on_ramp"

.field public static final AnalyticsEventOnRampDressSizeEntered:Ljava/lang/String; = "onramp_dress_size_entered"

.field public static final AnalyticsEventOnRampLocationEntered:Ljava/lang/String; = "onramp_mycity_entered"

.field public static final AnalyticsEventOnRampNoBrandsFollowed:Ljava/lang/String; = "onramp_brand_next_nofollowed"

.field public static final AnalyticsEventOnRampProfileNextButtonTapped:Ljava/lang/String; = "create_profile_button_tapped"

.field public static final AnalyticsEventOnRampShoeSizeEntered:Ljava/lang/String; = "onramp_shoe_size_entered"

.field public static final AnalyticsEventOnRampWebsiteEntered:Ljava/lang/String; = "onramp_website_entered"

.field public static final AnalyticsEventPagesScrolledByUser:Ljava/lang/String; = "pages_scrolled_by_user"

.field public static final AnalyticsEventPartyChangeShowroom:Ljava/lang/String; = "party_change_showroom"

.field public static final AnalyticsEventPartyInviteShareFailed:Ljava/lang/String; = "share_party_failed"

.field public static final AnalyticsEventPartyNotificationClicked:Ljava/lang/String; = "join_party_notification_clicked"

.field public static final AnalyticsEventPartySharedOnFacebook:Ljava/lang/String; = "share_facebook"

.field public static final AnalyticsEventPartySharedOnTumblr:Ljava/lang/String; = "share_tumblr"

.field public static final AnalyticsEventPartySharedOnTwitter:Ljava/lang/String; = "share_twitter"

.field public static final AnalyticsEventPartySharedUsingEmail:Ljava/lang/String; = "share_email"

.field public static final AnalyticsEventPartySharedUsingFbDialog:Ljava/lang/String; = "share_fb_dialog"

.field public static final AnalyticsEventPartySharedUsingMessenger:Ljava/lang/String; = "share_fbmessenger"

.field public static final AnalyticsEventPartySharedUsingSMS:Ljava/lang/String; = "share_sms"

.field public static final AnalyticsEventPinterestConnectCancelled:Ljava/lang/String; = "connect_pinterest_cancelled"

.field public static final AnalyticsEventPinterestConnectComplete:Ljava/lang/String; = "connect_pinterest_complete"

.field public static final AnalyticsEventPinterestConnectFailed:Ljava/lang/String; = "connect_pinterest_failed"

.field public static final AnalyticsEventPinterestConnectInitiated:Ljava/lang/String; = "connect_pinterest_initiated"

.field public static final AnalyticsEventProfileImageTapped:Ljava/lang/String; = "profile_image_tapped"

.field public static final AnalyticsEventRefreshMyFeedClicked:Ljava/lang/String; = "refresh_myfeed_clicked"

.field public static final AnalyticsEventRefreshNewsClicked:Ljava/lang/String; = "refresh_news_clicked"

.field public static final AnalyticsEventRefreshPartyClicked:Ljava/lang/String; = "refresh_party_clicked"

.field public static final AnalyticsEventRemoveListingFromBundleButtonClicked:Ljava/lang/String; = "remove_listing_from_bundle_tapped"

.field public static final AnalyticsEventRemovedLineItemFromOrder:Ljava/lang/String; = "removed_lineitem_from_order"

.field public static final AnalyticsEventReportListing:Ljava/lang/String; = "report_listing"

.field public static final AnalyticsEventRequestTimeoutError:Ljava/lang/String; = "request_timeout_error"

.field public static final AnalyticsEventSearchIconInMyFeedClicked:Ljava/lang/String; = "search_listings_button_clicked"

.field public static final AnalyticsEventSecureCheckout:Ljava/lang/String; = "secure_checkout"

.field public static final AnalyticsEventShareButtonTapped:Ljava/lang/String; = "share_button_tapped"

.field public static final AnalyticsEventShopTabClicked:Ljava/lang/String; = "shoptab_clicked"

.field public static final AnalyticsEventShowroomSharedUsingEmail:Ljava/lang/String; = "share_showroom_email"

.field public static final AnalyticsEventShowroomSharedUsingFbDialog:Ljava/lang/String; = "share_showroom_fb_dialog"

.field public static final AnalyticsEventShowroomSharedUsingMessenger:Ljava/lang/String; = "share_showroom_fbmessenger"

.field public static final AnalyticsEventShowroomSharedUsingSMS:Ljava/lang/String; = "share_showroom_sms"

.field public static final AnalyticsEventSizeLinkSelected:Ljava/lang/String; = "size_link_tapped"

.field public static final AnalyticsEventSubmitOffer:Ljava/lang/String; = "offer_submit_button_tapped"

.field public static final AnalyticsEventSubmitOrder:Ljava/lang/String; = "submit_order"

.field public static final AnalyticsEventTimelineToggled:Ljava/lang/String; = "timeline_toggled"

.field public static final AnalyticsEventTotalBrandsFollowed:Ljava/lang/String; = "total_onramp_brands_followed"

.field public static final AnalyticsEventTurnOffSearchVisibility:Ljava/lang/String; = "turn_off_search_visibility"

.field public static final AnalyticsEventUnknownError:Ljava/lang/String; = "unknown_error"

.field public static final AnalyticsEventUnlike:Ljava/lang/String; = "unlike"

.field public static final AnalyticsEventUpdateCreditCard:Ljava/lang/String; = "update_credit_card"

.field public static final AnalyticsEventUpdateSearchVisibilitySetting:Ljava/lang/String; = "update_search_visibility_setting"

.field public static final AnalyticsEventUpdateShippingAddress:Ljava/lang/String; = "update_shipping_address"

.field public static final AnalyticsEventUpdatedOrderAddress:Ljava/lang/String; = "updated_order_address"

.field public static final AnalyticsEventUserFollowTapped:Ljava/lang/String; = "follow_tapped"

.field public static final AnalyticsEventUserUnfollowTapped:Ljava/lang/String; = "unfollow_tapped"

.field public static final AnalyticsEventViewAllMyBundlesClicked:Ljava/lang/String; = "view_my_bundles_tapped"

.field public static final AnalyticsEventViewBundleClicked:Ljava/lang/String; = "view_bundle_tapped"

.field public static final AnalyticsEventViewMoreBrandsOnRamp:Ljava/lang/String; = "view_more_brands_onramp"

.field public static final AnalyticsEventViewUnavailableBundleItemsButtonClicked:Ljava/lang/String; = "view_unavailable_listings_in_bundle_tapped"

.field public static final AnalyticsEventViewedSimilarListings:Ljava/lang/String; = "similar_listings_viewed"

.field public static final AnalyticsListingActionsButtonClicked:Ljava/lang/String; = "listing_actions_button_tapped"

.field public static final AnalyticsMakeOfferScreen:Ljava/lang/String; = "offer_price_form_screen"

.field public static final AnalyticsOfferPaymentAndShippingEnteredNextButtonClicked:Ljava/lang/String; = "offer_payment_and_shipping_entered_next_tapped"

.field public static final AnalyticsScreenAbout:Ljava/lang/String; = "about_screen"

.field public static final AnalyticsScreenAccountBalances:Ljava/lang/String; = "account_balances_screen"

.field public static final AnalyticsScreenAddComment:Ljava/lang/String; = "add_comment_screen"

.field public static final AnalyticsScreenAddressConfirmation:Ljava/lang/String; = "address_confirmation_screen"

.field public static final AnalyticsScreenBrand:Ljava/lang/String; = "brand_screen"

.field public static final AnalyticsScreenBrowseListingResults:Ljava/lang/String; = "browse_listing_results_screen"

.field public static final AnalyticsScreenBundleLearnMore:Ljava/lang/String; = "bundle_learn_more_screen"

.field public static final AnalyticsScreenCamera:Ljava/lang/String; = "camera_screen"

.field public static final AnalyticsScreenChangePassword:Ljava/lang/String; = "change_password_screen"

.field public static final AnalyticsScreenCheckout:Ljava/lang/String; = "checkout_screen"

.field public static final AnalyticsScreenCheckoutMulti:Ljava/lang/String; = "multi_item_checkout_screen"

.field public static final AnalyticsScreenCreateUserProfile:Ljava/lang/String; = "create_user_profile_screen"

.field public static final AnalyticsScreenCropImage:Ljava/lang/String; = "crop_image_screen"

.field public static final AnalyticsScreenEditListing:Ljava/lang/String; = "edit_listing_screen"

.field public static final AnalyticsScreenEditUserProfile:Ljava/lang/String; = "edit_user_profile_screen"

.field public static final AnalyticsScreenEmailLogin:Ljava/lang/String; = "email_login_screen"

.field public static final AnalyticsScreenEmailSignUp:Ljava/lang/String; = "email_sign_up_screen"

.field public static final AnalyticsScreenFAQs:Ljava/lang/String; = "faqs_screen"

.field public static final AnalyticsScreenFacebookFriends:Ljava/lang/String; = "facebook_connections_screen"

.field public static final AnalyticsScreenFacebookShareMessage:Ljava/lang/String; = "facebook_share_message_screen"

.field public static final AnalyticsScreenFacebookSignUp:Ljava/lang/String; = "facebook_sign_up_screen"

.field public static final AnalyticsScreenFilterListingBrand:Ljava/lang/String; = "listing_select_brand_filter_screen"

.field public static final AnalyticsScreenFilterListingPrice:Ljava/lang/String; = "listing_select_price_filter_screen"

.field public static final AnalyticsScreenFilterListingSize:Ljava/lang/String; = "listing_select_size_filter_screen"

.field public static final AnalyticsScreenFollowers:Ljava/lang/String; = "followers_screen"

.field public static final AnalyticsScreenFollowing:Ljava/lang/String; = "following_screen"

.field public static final AnalyticsScreenGoogleSignUp:Ljava/lang/String; = "google_sign_up_screen"

.field public static final AnalyticsScreenImageFilters:Ljava/lang/String; = "image_filters_screen"

.field public static final AnalyticsScreenImagePreview:Ljava/lang/String; = "image_preview_screen"

.field public static final AnalyticsScreenItemsBought:Ljava/lang/String; = "items_bought_screen"

.field public static final AnalyticsScreenItemsSold:Ljava/lang/String; = "items_sold_screen"

.field public static final AnalyticsScreenJustInBrand:Ljava/lang/String; = "brand_just_in_screen"

.field public static final AnalyticsScreenJustInShowroom:Ljava/lang/String; = "showroom_just_in_screen"

.field public static final AnalyticsScreenListingCategoryFilter:Ljava/lang/String; = "listing_select_category_filter_screen"

.field public static final AnalyticsScreenListingColorFilter:Ljava/lang/String; = "listing_select_color_filter_screen"

.field public static final AnalyticsScreenListingConfirmation:Ljava/lang/String; = "listing_confirmation_screen"

.field public static final AnalyticsScreenListingDetails:Ljava/lang/String; = "listing_details_screen"

.field public static final AnalyticsScreenListingFilter:Ljava/lang/String; = "listing_filter_screen"

.field public static final AnalyticsScreenListingUserLikes:Ljava/lang/String; = "listing_user_likes_screen"

.field public static final AnalyticsScreenListingUserLikesPriceDrop:Ljava/lang/String; = "listings_liked_price_drop_screen"

.field public static final AnalyticsScreenListingValidation:Ljava/lang/String; = "listing_validation_screen"

.field public static final AnalyticsScreenListingsFeed:Ljava/lang/String; = "listings_feed_screen"

.field public static final AnalyticsScreenListingsLiked:Ljava/lang/String; = "listings_liked_screen"

.field public static final AnalyticsScreenListingsLikedJustIn:Ljava/lang/String; = "listings_liked_just_in_screen"

.field public static final AnalyticsScreenListingsLikedPriceDrop:Ljava/lang/String; = "listings_liked_price_drop_screen"

.field public static final AnalyticsScreenLogin:Ljava/lang/String; = "login_screen"

.field public static final AnalyticsScreenMultiLineInput:Ljava/lang/String; = "multiline_input_screen"

.field public static final AnalyticsScreenMultiSelector:Ljava/lang/String; = "multi_selector_screen"

.field public static final AnalyticsScreenMyAddress:Ljava/lang/String; = "my_address_screen"

.field public static final AnalyticsScreenMyBundles:Ljava/lang/String; = "my_bundles_screen"

.field public static final AnalyticsScreenMyClosetStats:Ljava/lang/String; = "my_closet_stats_screen"

.field public static final AnalyticsScreenMySize:Ljava/lang/String; = "my_size_screen"

.field public static final AnalyticsScreenNWTPolicy:Ljava/lang/String; = "nwt_policy_screen"

.field public static final AnalyticsScreenNameKey:Ljava/lang/String; = "ANALYTICS_PAGE_NAME"

.field public static final AnalyticsScreenNewListing:Ljava/lang/String; = "new_listing_screen"

.field public static final AnalyticsScreenNewlyJoinedClosets:Ljava/lang/String; = "newly_joined_closets_screen"

.field public static final AnalyticsScreenNewlyOpenedClosets:Ljava/lang/String; = "newly_opened_closets_screen"

.field public static final AnalyticsScreenNewsFeed:Ljava/lang/String; = "news_feed_screen"

.field public static final AnalyticsScreenNotificationSettings:Ljava/lang/String; = "notification_settings_screen"

.field public static final AnalyticsScreenOAuthLogin:Ljava/lang/String; = "oauth_login_screen"

.field public static final AnalyticsScreenOffersHelp:Ljava/lang/String; = "offers_help_screen"

.field public static final AnalyticsScreenOnRampFollowing:Ljava/lang/String; = "on_ramp_following_screen"

.field public static final AnalyticsScreenOrderDetails:Ljava/lang/String; = "order_details_screen"

.field public static final AnalyticsScreenOrderEditAddress:Ljava/lang/String; = "order_edit_address_screen"

.field public static final AnalyticsScreenOrderEditCreditCard:Ljava/lang/String; = "order_edit_credit_card_screen"

.field public static final AnalyticsScreenOrderEditCreditCardAndAddress:Ljava/lang/String; = "order_edit_credit_card_and_address_screen"

.field public static final AnalyticsScreenPartyFeed:Ljava/lang/String; = "party_feed_screen"

.field public static final AnalyticsScreenPartyInvite:Ljava/lang/String; = "party_invite_screen"

.field public static final AnalyticsScreenPartyShowroomList:Ljava/lang/String; = "party_showroom_list_screen"

.field public static final AnalyticsScreenPartyTheme:Ljava/lang/String; = "party_theme_screen"

.field public static final AnalyticsScreenPinterestBoardSelectMyListingsScreen:Ljava/lang/String; = "my_listings_select_board_screen"

.field public static final AnalyticsScreenPinterestBoardSelectMySharesScreen:Ljava/lang/String; = "my_shares_select_board_screen"

.field public static final AnalyticsScreenPinterestPostDialogScreen:Ljava/lang/String; = "post_connect_pinterest_dlg_screen"

.field public static final AnalyticsScreenPinterestPreDialogScreen:Ljava/lang/String; = "pre_connect_pinterest_dlg_screen"

.field public static final AnalyticsScreenPinterestShareSettingsScreen:Ljava/lang/String; = "pinterest_share_settings_screen"

.field public static final AnalyticsScreenPoshEtiquette:Ljava/lang/String; = "posh_etiquette_screen"

.field public static final AnalyticsScreenPoshGuide:Ljava/lang/String; = "posh_guide_screen"

.field public static final AnalyticsScreenPoshPartiesHome:Ljava/lang/String; = "parties_home_screen"

.field public static final AnalyticsScreenPriceDropBrand:Ljava/lang/String; = "brand_price_drop_screen"

.field public static final AnalyticsScreenPriceDropShowroom:Ljava/lang/String; = "showroom_price_drop_screen"

.field public static final AnalyticsScreenPrivacyPolicy:Ljava/lang/String; = "privacy_policy_screen"

.field public static final AnalyticsScreenReferral:Ljava/lang/String; = "referral_screen"

.field public static final AnalyticsScreenSearchPeople:Ljava/lang/String; = "search_people_screen"

.field public static final AnalyticsScreenSearchUsers:Ljava/lang/String; = "search_users_screen"

.field public static final AnalyticsScreenSecondarySuggestedUsers:Ljava/lang/String; = "secondary_suggested_users_screen"

.field public static final AnalyticsScreenSelectBrand:Ljava/lang/String; = "listing_select_brand_screen"

.field public static final AnalyticsScreenSelectCategory:Ljava/lang/String; = "listing_select_category_screen"

.field public static final AnalyticsScreenSelectColor:Ljava/lang/String; = "listing_select_color_screen"

.field public static final AnalyticsScreenSelectListingConditionStatus:Ljava/lang/String; = "listing_select_condition_status_screen"

.field public static final AnalyticsScreenSelectSize:Ljava/lang/String; = "listing_select_size_screen"

.field public static final AnalyticsScreenSelectStyleTag:Ljava/lang/String; = "listing_select_style_tag_screen"

.field public static final AnalyticsScreenSelectSubcategory:Ljava/lang/String; = "listing_select_subcategory_screen"

.field public static final AnalyticsScreenSellerPolicy:Ljava/lang/String; = "seller_policy_screen"

.field public static final AnalyticsScreenSellingsTool:Ljava/lang/String; = "my_selling_tools"

.field public static final AnalyticsScreenSettings:Ljava/lang/String; = "settings_screen"

.field public static final AnalyticsScreenShareBrandOptions:Ljava/lang/String; = "share_brand_options_screen"

.field public static final AnalyticsScreenShareClosetOptions:Ljava/lang/String; = "share_closet_options_screen"

.field public static final AnalyticsScreenShareListingOptions:Ljava/lang/String; = "share_listing_options_screen"

.field public static final AnalyticsScreenSharePartyOptions:Ljava/lang/String; = "share_party_options_screen"

.field public static final AnalyticsScreenShareSettings:Ljava/lang/String; = "share_settings_screen"

.field public static final AnalyticsScreenShareShowroomOptions:Ljava/lang/String; = "share_showroom_options_screen"

.field public static final AnalyticsScreenSharedListings:Ljava/lang/String; = "shared_listings_page"

.field public static final AnalyticsScreenShop:Ljava/lang/String; = "shop_screen"

.field public static final AnalyticsScreenShowroomFeed:Ljava/lang/String; = "showroom_feed_screen"

.field public static final AnalyticsScreenSuggestedBrand:Ljava/lang/String; = "suggested_brands_screen"

.field public static final AnalyticsScreenSuggestedUsers:Ljava/lang/String; = "suggested_users_screen"

.field public static final AnalyticsScreenSupportCenter:Ljava/lang/String; = "support_center_screen"

.field public static final AnalyticsScreenTermsAndConditions:Ljava/lang/String; = "terms_and_conditions_screen"

.field public static final AnalyticsScreenTumblrLogin:Ljava/lang/String; = "tumblr_login_screen"

.field public static final AnalyticsScreenTumblrShareMessage:Ljava/lang/String; = "tumblr_share_message_screen"

.field public static final AnalyticsScreenTwitterFriends:Ljava/lang/String; = "twitter_connections_screen"

.field public static final AnalyticsScreenTwitterLogin:Ljava/lang/String; = "twitter_login_screen"

.field public static final AnalyticsScreenTwitterShareMessage:Ljava/lang/String; = "twitter_share_message_screen"

.field public static final AnalyticsScreenUserProfile:Ljava/lang/String; = "user_profile_screen"

.field public static final AnalyticsScreenWebCommandWebView:Ljava/lang/String; = "webcommand_webview_screen"

.field public static final AnalyticsSellerViewOfferButtonClicked:Ljava/lang/String; = "seller_view_offers_link_tapped"

.field public static final AnalyticsViewBundleScreen:Ljava/lang/String; = "bundle_screen"

.field public static final AnalyticsViewMyBundlesScreen:Ljava/lang/String; = "my_bundles_screen"

.field public static final AnalyticsViewUnavailableItemsBundleScreen:Ljava/lang/String; = "bundle_unavailable_items_screen"

.field public static final AppLoveAlertDisplayed:Ljava/lang/String; = "app_love_alert_displayed"

.field public static final AppLoveAlertNoButtonTapped:Ljava/lang/String; = "app_love_alert_no_button_tapped"

.field public static final AppLoveAlertYesButtonTapped:Ljava/lang/String; = "app_love_alert_yes_button_tapped"

.field public static final AppRatingAlertDismissButtonTapped:Ljava/lang/String; = "app_rating_alert_dismiss_button_tapped"

.field public static final AppRatingAlertRateButtonTapped:Ljava/lang/String; = "app_rating_alert_rate_button_tapped"

.field public static final AppRatingAlertRemindLaterButtonTapped:Ljava/lang/String; = "app_rating_alert_remind_later_button_tapped"

.field public static final AppRatingSendFeedbackAlertDisplayed:Ljava/lang/String; = "app_rating_send_feedback_alert_displayed"

.field public static final AppSendFeedbackAlertSendButtonTapped:Ljava/lang/String; = "app_rating_send_feedback"

.field public static final AppSendFeedbackAlertSendLaterButtonTapped:Ljava/lang/String; = "app_rating_send_feedback_dismissed"

.field public static final CustomVarNameForAppVersion:Ljava/lang/String; = "app_version"

.field public static final CustomVarNameForBrand:Ljava/lang/String; = "brand"

.field public static final CustomVarNameForCategory:Ljava/lang/String; = "category"

.field public static final CustomVarNameForUserName_UserID:Ljava/lang/String; = "username_userid"

.field public static final CustomVarNameForUserSegment:Ljava/lang/String; = "user_segment"

.field public static final MappDefaultAnalyticsScreenName:Ljava/lang/String; = "mapp_screen"

.field private static final USERNAME_USERID_INDEX:I = 0x1

.field private static final USER_SEGMENT_INDEX:I = 0x2


# instance fields
.field private previousUserID:Ljava/lang/String;

.field public final tracker:Lcom/google/analytics/tracking/android/Tracker;


# direct methods
.method private constructor <init>()V
    .locals 6

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x0

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object v5, p0, Lcom/poshmark/analytics/Analytics;->previousUserID:Ljava/lang/String;

    .line 35
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 37
    .local v0, "ctx":Landroid/content/Context;
    invoke-static {v0}, Lcom/google/analytics/tracking/android/GoogleAnalytics;->getInstance(Landroid/content/Context;)Lcom/google/analytics/tracking/android/GoogleAnalytics;

    move-result-object v1

    .line 38
    .local v1, "ga":Lcom/google/analytics/tracking/android/GoogleAnalytics;
    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/GoogleAnalytics;->setDryRun(Z)V

    .line 39
    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/GoogleAnalytics;->setAppOptOut(Z)V

    .line 40
    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/GoogleAnalytics;->getLogger()Lcom/google/analytics/tracking/android/Logger;

    move-result-object v3

    sget-object v2, Lcom/poshmark/config/BuildTypeConfig;->BUILD_TYPE:Lcom/poshmark/config/BuildType;

    sget-object v4, Lcom/poshmark/config/BuildType;->DEBUG:Lcom/poshmark/config/BuildType;

    if-ne v2, v4, :cond_1

    sget-object v2, Lcom/google/analytics/tracking/android/Logger$LogLevel;->VERBOSE:Lcom/google/analytics/tracking/android/Logger$LogLevel;

    :goto_0
    invoke-interface {v3, v2}, Lcom/google/analytics/tracking/android/Logger;->setLogLevel(Lcom/google/analytics/tracking/android/Logger$LogLevel;)V

    .line 41
    invoke-static {}, Lcom/google/analytics/tracking/android/GAServiceManager;->getInstance()Lcom/google/analytics/tracking/android/GAServiceManager;

    move-result-object v2

    const/16 v3, 0x3c

    invoke-virtual {v2, v3}, Lcom/google/analytics/tracking/android/GAServiceManager;->setLocalDispatchPeriod(I)V

    .line 43
    sget-object v2, Lcom/poshmark/config/EnvConfig;->GOOGLE_ANALYTICS_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/GoogleAnalytics;->getTracker(Ljava/lang/String;)Lcom/google/analytics/tracking/android/Tracker;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    .line 52
    iget-object v2, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    const-string v3, "app"

    const-string v4, "launch"

    invoke-static {v3, v4, v5, v5}, Lcom/google/analytics/tracking/android/MapBuilder;->createEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v3

    const-string v4, "&sc"

    const-string v5, "start"

    invoke-virtual {v3, v4, v5}, Lcom/google/analytics/tracking/android/MapBuilder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 58
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 60
    invoke-direct {p0}, Lcom/poshmark/analytics/Analytics;->userLoginChanged()V

    .line 63
    :cond_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.LOGOUT_COMPLETE"

    new-instance v4, Lcom/poshmark/analytics/Analytics$1;

    invoke-direct {v4, p0}, Lcom/poshmark/analytics/Analytics$1;-><init>(Lcom/poshmark/analytics/Analytics;)V

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 70
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.LOGIN_COMPLETE"

    new-instance v4, Lcom/poshmark/analytics/Analytics$2;

    invoke-direct {v4, p0}, Lcom/poshmark/analytics/Analytics$2;-><init>(Lcom/poshmark/analytics/Analytics;)V

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 77
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.APP_STARTED"

    new-instance v4, Lcom/poshmark/analytics/Analytics$3;

    invoke-direct {v4, p0}, Lcom/poshmark/analytics/Analytics$3;-><init>(Lcom/poshmark/analytics/Analytics;)V

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 84
    return-void

    .line 40
    :cond_1
    sget-object v2, Lcom/google/analytics/tracking/android/Logger$LogLevel;->ERROR:Lcom/google/analytics/tracking/android/Logger$LogLevel;

    goto :goto_0
.end method

.method synthetic constructor <init>(Lcom/poshmark/analytics/Analytics$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/analytics/Analytics$1;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/poshmark/analytics/Analytics;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/analytics/Analytics;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/analytics/Analytics;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/poshmark/analytics/Analytics;->userLoginChanged()V

    return-void
.end method

.method public static getInstance()Lcom/poshmark/analytics/Analytics;
    .locals 1

    .prologue
    .line 93
    sget-object v0, Lcom/poshmark/analytics/Analytics$SingletonHolder;->INSTANCE:Lcom/poshmark/analytics/Analytics;

    return-object v0
.end method

.method private userLoginChanged()V
    .locals 11

    .prologue
    const/4 v8, 0x0

    const/4 v10, 0x2

    const/4 v9, 0x1

    .line 152
    const/4 v2, 0x0

    .line 153
    .local v2, "userName_userID":Ljava/lang/String;
    const/4 v3, 0x0

    .line 155
    .local v3, "userSignupSegment":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    .line 157
    .local v0, "isLoggedIn":Z
    if-nez v0, :cond_1

    .line 159
    iget-object v5, p0, Lcom/poshmark/analytics/Analytics;->previousUserID:Ljava/lang/String;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/poshmark/analytics/Analytics;->previousUserID:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_0

    .line 164
    iget-object v5, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    const-string v6, "user"

    const-string v7, "logout"

    invoke-static {v6, v7, v8, v8}, Lcom/google/analytics/tracking/android/MapBuilder;->createEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v6

    const-string v7, "&sc"

    const-string v8, "end"

    invoke-virtual {v6, v7, v8}, Lcom/google/analytics/tracking/android/MapBuilder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 184
    :cond_0
    :goto_0
    iget-object v5, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-static {v9}, Lcom/google/analytics/tracking/android/Fields;->customDimension(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6, v2}, Lcom/google/analytics/tracking/android/Tracker;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    iget-object v5, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-static {v10}, Lcom/google/analytics/tracking/android/Fields;->customDimension(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6, v3}, Lcom/google/analytics/tracking/android/Tracker;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    return-void

    .line 172
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    .line 173
    .local v1, "userID":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v4

    .line 174
    .local v4, "username":Ljava/lang/String;
    if-eqz v4, :cond_3

    .line 175
    :goto_1
    if-eqz v1, :cond_2

    .line 177
    const-string v5, "%s/%s"

    new-array v6, v10, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    aput-object v4, v6, v9

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 179
    :cond_2
    iput-object v1, p0, Lcom/poshmark/analytics/Analytics;->previousUserID:Ljava/lang/String;

    .line 181
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserABSegment()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 174
    :cond_3
    const-string v4, ""

    goto :goto_1
.end method


# virtual methods
.method public addItem(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)V
    .locals 3
    .param p1, "transactionId"    # Ljava/lang/String;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "sku"    # Ljava/lang/String;
    .param p4, "category"    # Ljava/lang/String;
    .param p5, "price"    # Ljava/lang/Double;
    .param p6, "quantity"    # Ljava/lang/Long;
    .param p7, "currencyCode"    # Ljava/lang/String;

    .prologue
    .line 142
    invoke-static/range {p1 .. p7}, Lcom/google/analytics/tracking/android/MapBuilder;->createItem(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v0

    .line 143
    .local v0, "mb":Lcom/google/analytics/tracking/android/MapBuilder;
    iget-object v1, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 144
    return-void
.end method

.method public onDestroy()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 98
    iget-object v0, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    const-string v1, "app"

    const-string v2, "terminate"

    invoke-static {v1, v2, v3, v3}, Lcom/google/analytics/tracking/android/MapBuilder;->createEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v1

    const-string v2, "&sc"

    const-string v3, "end"

    invoke-virtual {v1, v2, v3}, Lcom/google/analytics/tracking/android/MapBuilder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 104
    invoke-static {}, Lcom/google/analytics/tracking/android/GAServiceManager;->getInstance()Lcom/google/analytics/tracking/android/GAServiceManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/GAServiceManager;->dispatchLocalHits()V

    .line 105
    return-void
.end method

.method public setUserSegment(Ljava/lang/String;)V
    .locals 2
    .param p1, "segment"    # Ljava/lang/String;

    .prologue
    .line 147
    iget-object v0, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    const/4 v1, 0x2

    invoke-static {v1}, Lcom/google/analytics/tracking/android/Fields;->customDimension(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lcom/google/analytics/tracking/android/Tracker;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    return-void
.end method

.method public trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "viewName"    # Ljava/lang/String;
    .param p2, "category"    # Ljava/lang/String;
    .param p3, "action"    # Ljava/lang/String;
    .param p4, "label"    # Ljava/lang/String;

    .prologue
    .line 118
    const/4 v1, 0x0

    invoke-static {p2, p3, p4, v1}, Lcom/google/analytics/tracking/android/MapBuilder;->createEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v0

    .line 119
    .local v0, "mb":Lcom/google/analytics/tracking/android/MapBuilder;
    if-eqz p1, :cond_0

    .line 120
    const-string v1, "&cd"

    invoke-virtual {v0, v1, p1}, Lcom/google/analytics/tracking/android/MapBuilder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    .line 123
    :cond_0
    iget-object v1, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 124
    return-void
.end method

.method public trackEventWithValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 3
    .param p1, "viewName"    # Ljava/lang/String;
    .param p2, "category"    # Ljava/lang/String;
    .param p3, "action"    # Ljava/lang/String;
    .param p4, "label"    # Ljava/lang/String;
    .param p5, "value"    # J

    .prologue
    .line 128
    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {p2, p3, p4, v1}, Lcom/google/analytics/tracking/android/MapBuilder;->createEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v0

    .line 129
    .local v0, "mb":Lcom/google/analytics/tracking/android/MapBuilder;
    if-eqz p1, :cond_0

    .line 130
    const-string v1, "&cd"

    invoke-virtual {v0, v1, p1}, Lcom/google/analytics/tracking/android/MapBuilder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    .line 133
    :cond_0
    iget-object v1, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 134
    return-void
.end method

.method public trackTransaction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V
    .locals 3
    .param p1, "transactionId"    # Ljava/lang/String;
    .param p2, "storeName"    # Ljava/lang/String;
    .param p3, "totalPrice"    # Ljava/lang/Double;
    .param p4, "tax"    # Ljava/lang/Double;
    .param p5, "shipping"    # Ljava/lang/Double;
    .param p6, "currencyCode"    # Ljava/lang/String;

    .prologue
    .line 137
    invoke-static/range {p1 .. p6}, Lcom/google/analytics/tracking/android/MapBuilder;->createTransaction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v0

    .line 138
    .local v0, "mb":Lcom/google/analytics/tracking/android/MapBuilder;
    iget-object v1, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 139
    return-void
.end method

.method public trackView(Ljava/lang/String;)V
    .locals 3
    .param p1, "viewName"    # Ljava/lang/String;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/poshmark/analytics/Analytics;->tracker:Lcom/google/analytics/tracking/android/Tracker;

    invoke-static {}, Lcom/google/analytics/tracking/android/MapBuilder;->createAppView()Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v1

    const-string v2, "&cd"

    invoke-virtual {v1, v2, p1}, Lcom/google/analytics/tracking/android/MapBuilder;->set(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/MapBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/MapBuilder;->build()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/Tracker;->send(Ljava/util/Map;)V

    .line 114
    return-void
.end method
