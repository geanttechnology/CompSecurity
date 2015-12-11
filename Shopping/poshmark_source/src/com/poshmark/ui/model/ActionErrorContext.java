// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.model;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApiError;
import com.poshmark.utils.NetworkUtils;

public class ActionErrorContext
{
    public static final class ActionContext extends Enum
    {

        private static final ActionContext $VALUES[];
        public static final ActionContext ADD_COMMENT;
        public static final ActionContext ADD_PRODUCT_TO_ORDER;
        public static final ActionContext ADD_TO_BUNDLE;
        public static final ActionContext BLOCK_USER;
        public static final ActionContext CHECKOUT_ORDER;
        public static final ActionContext CHECK_PASSWORD;
        public static final ActionContext DELETE_LISTING;
        public static final ActionContext FETCH_FACEBOOK_PM_USERS;
        public static final ActionContext FETCH_SUGGESTED_USERS;
        public static final ActionContext FETCH_TUMBLR_PM_USERS;
        public static final ActionContext FETCH_TWITTER_PM_USERS;
        public static final ActionContext FETCH_USERLIST;
        public static final ActionContext FOLLOW_BRAND;
        public static final ActionContext LIKE_LISTING;
        public static final ActionContext LINK_FACEBOOK;
        public static final ActionContext LINK_GOOGLE;
        public static final ActionContext LINK_TUMBLR;
        public static final ActionContext LINK_TWITTER;
        public static final ActionContext LOAD_CLOSET;
        public static final ActionContext LOAD_LISTING;
        public static final ActionContext LOAD_MY_FEED;
        public static final ActionContext LOAD_MY_LIKES;
        public static final ActionContext LOAD_MY_SIZES;
        public static final ActionContext LOAD_PARTY_LISTINGS;
        public static final ActionContext LOAD_REFERRAL_CODE;
        public static final ActionContext LOAD_SEARCHED_LISTING;
        public static final ActionContext LOAD_SHOWROOM_LISTINGS;
        public static final ActionContext LOAD_USER_PROFILE;
        public static final ActionContext LOAD_USER_SETTINGS;
        public static final ActionContext POST_LISTING;
        public static final ActionContext REPORT_LISTING;
        public static final ActionContext REPORT_USER;
        public static final ActionContext SET_PASSWORD;
        public static final ActionContext SHARE_CLOSET;
        public static final ActionContext SHARE_CLOSET_EMAIL;
        public static final ActionContext SHARE_CLOSET_FACEBOOK;
        public static final ActionContext SHARE_CLOSET_ON_INSTAGRAM;
        public static final ActionContext SHARE_CLOSET_SMS;
        public static final ActionContext SHARE_CLOSET_TUMBLR;
        public static final ActionContext SHARE_CLOSET_TWITTER;
        public static final ActionContext SHARE_LISTING;
        public static final ActionContext SHARE_LISTING_EMAIL;
        public static final ActionContext SHARE_LISTING_FACEBOOK;
        public static final ActionContext SHARE_LISTING_SMS;
        public static final ActionContext SHARE_LISTING_TUMBLR;
        public static final ActionContext SHARE_LISTING_TWITTER;
        public static final ActionContext SHARE_SHOWROOM;
        public static final ActionContext SHARE_SHOWROOM_EMAIL;
        public static final ActionContext SHARE_SHOWROOM_FACEBOOK;
        public static final ActionContext SHARE_SHOWROOM_SMS;
        public static final ActionContext SHARE_SHOWROOM_TUMBLR;
        public static final ActionContext SHARE_SHOWROOM_TWITTER;
        public static final ActionContext SUBMIT_CC;
        public static final ActionContext SUBMIT_ORDER;
        public static final ActionContext UNBLOCK_USER;
        public static final ActionContext UNLINK_FACEBOOK;
        public static final ActionContext UPDATE_FB_TIMELINE;
        public static final ActionContext UPDATE_LISTING;
        public static final ActionContext UPDATE_MY_SIZE;
        public static final ActionContext UPDATE_ORDER_ADDRESS;
        public static final ActionContext UPDATE_PASSWORD;
        public static final ActionContext UPDATE_USER_PROFILE;
        public static final ActionContext UPDATE_USER_SETTINGS;
        public static final ActionContext USER_LOGIN;
        public static final ActionContext USER_SIGNUP;

        public static String getString(ActionContext actioncontext)
        {
            if (actioncontext == null) goto _L2; else goto _L1
_L1:
            static class _cls1
            {

                static final int $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[];

                static 
                {
                    $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext = new int[ActionContext.values().length];
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_MY_FEED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror58) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_MY_LIKES.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror57) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.USER_SIGNUP.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror56) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.USER_LOGIN.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror55) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.FOLLOW_BRAND.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror54) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.ADD_COMMENT.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror53) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_USER_PROFILE.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror52) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_USER_SETTINGS.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror51) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_USER_PROFILE.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror50) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_USER_SETTINGS.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror49) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_MY_SIZES.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror48) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_REFERRAL_CODE.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror47) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SET_PASSWORD.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror46) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_PASSWORD.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror45) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.CHECK_PASSWORD.ordinal()] = 15;
                    }
                    catch (NoSuchFieldError nosuchfielderror44) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LINK_FACEBOOK.ordinal()] = 16;
                    }
                    catch (NoSuchFieldError nosuchfielderror43) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LINK_TWITTER.ordinal()] = 17;
                    }
                    catch (NoSuchFieldError nosuchfielderror42) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LINK_TUMBLR.ordinal()] = 18;
                    }
                    catch (NoSuchFieldError nosuchfielderror41) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.FETCH_FACEBOOK_PM_USERS.ordinal()] = 19;
                    }
                    catch (NoSuchFieldError nosuchfielderror40) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.FETCH_TWITTER_PM_USERS.ordinal()] = 20;
                    }
                    catch (NoSuchFieldError nosuchfielderror39) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.FETCH_SUGGESTED_USERS.ordinal()] = 21;
                    }
                    catch (NoSuchFieldError nosuchfielderror38) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.FETCH_USERLIST.ordinal()] = 22;
                    }
                    catch (NoSuchFieldError nosuchfielderror37) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UNLINK_FACEBOOK.ordinal()] = 23;
                    }
                    catch (NoSuchFieldError nosuchfielderror36) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_FB_TIMELINE.ordinal()] = 24;
                    }
                    catch (NoSuchFieldError nosuchfielderror35) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_MY_SIZE.ordinal()] = 25;
                    }
                    catch (NoSuchFieldError nosuchfielderror34) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.BLOCK_USER.ordinal()] = 26;
                    }
                    catch (NoSuchFieldError nosuchfielderror33) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UNBLOCK_USER.ordinal()] = 27;
                    }
                    catch (NoSuchFieldError nosuchfielderror32) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.REPORT_USER.ordinal()] = 28;
                    }
                    catch (NoSuchFieldError nosuchfielderror31) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_CLOSET.ordinal()] = 29;
                    }
                    catch (NoSuchFieldError nosuchfielderror30) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_LISTING.ordinal()] = 30;
                    }
                    catch (NoSuchFieldError nosuchfielderror29) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_SEARCHED_LISTING.ordinal()] = 31;
                    }
                    catch (NoSuchFieldError nosuchfielderror28) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_LISTING.ordinal()] = 32;
                    }
                    catch (NoSuchFieldError nosuchfielderror27) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.POST_LISTING.ordinal()] = 33;
                    }
                    catch (NoSuchFieldError nosuchfielderror26) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_LISTING.ordinal()] = 34;
                    }
                    catch (NoSuchFieldError nosuchfielderror25) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.DELETE_LISTING.ordinal()] = 35;
                    }
                    catch (NoSuchFieldError nosuchfielderror24) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.REPORT_LISTING.ordinal()] = 36;
                    }
                    catch (NoSuchFieldError nosuchfielderror23) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.LOAD_PARTY_LISTINGS.ordinal()] = 37;
                    }
                    catch (NoSuchFieldError nosuchfielderror22) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_LISTING_EMAIL.ordinal()] = 38;
                    }
                    catch (NoSuchFieldError nosuchfielderror21) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_LISTING_SMS.ordinal()] = 39;
                    }
                    catch (NoSuchFieldError nosuchfielderror20) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_LISTING_TWITTER.ordinal()] = 40;
                    }
                    catch (NoSuchFieldError nosuchfielderror19) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_LISTING_TUMBLR.ordinal()] = 41;
                    }
                    catch (NoSuchFieldError nosuchfielderror18) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_LISTING_FACEBOOK.ordinal()] = 42;
                    }
                    catch (NoSuchFieldError nosuchfielderror17) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_CLOSET_EMAIL.ordinal()] = 43;
                    }
                    catch (NoSuchFieldError nosuchfielderror16) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_CLOSET_SMS.ordinal()] = 44;
                    }
                    catch (NoSuchFieldError nosuchfielderror15) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_CLOSET_TWITTER.ordinal()] = 45;
                    }
                    catch (NoSuchFieldError nosuchfielderror14) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_CLOSET_ON_INSTAGRAM.ordinal()] = 46;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_CLOSET.ordinal()] = 47;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_CLOSET_FACEBOOK.ordinal()] = 48;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_SHOWROOM.ordinal()] = 49;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_SHOWROOM_EMAIL.ordinal()] = 50;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_SHOWROOM_SMS.ordinal()] = 51;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_SHOWROOM_FACEBOOK.ordinal()] = 52;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_SHOWROOM_TWITTER.ordinal()] = 53;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SHARE_SHOWROOM_TUMBLR.ordinal()] = 54;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.UPDATE_ORDER_ADDRESS.ordinal()] = 55;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.CHECKOUT_ORDER.ordinal()] = 56;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.ADD_PRODUCT_TO_ORDER.ordinal()] = 57;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SUBMIT_ORDER.ordinal()] = 58;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$poshmark$ui$model$ActionErrorContext$ActionContext[ActionContext.SUBMIT_CC.ordinal()] = 59;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.poshmark.ui.model.ActionErrorContext.ActionContext[actioncontext.ordinal()];
            JVM INSTR tableswitch 1 59: default 264
        //                       1 266
        //                       2 270
        //                       3 274
        //                       4 278
        //                       5 282
        //                       6 286
        //                       7 290
        //                       8 294
        //                       9 298
        //                       10 302
        //                       11 306
        //                       12 310
        //                       13 314
        //                       14 318
        //                       15 322
        //                       16 326
        //                       17 330
        //                       18 334
        //                       19 338
        //                       20 342
        //                       21 346
        //                       22 350
        //                       23 354
        //                       24 358
        //                       25 362
        //                       26 366
        //                       27 370
        //                       28 374
        //                       29 378
        //                       30 382
        //                       31 386
        //                       32 390
        //                       33 394
        //                       34 398
        //                       35 402
        //                       36 406
        //                       37 410
        //                       38 414
        //                       39 418
        //                       40 422
        //                       41 426
        //                       42 430
        //                       43 434
        //                       44 438
        //                       45 442
        //                       46 446
        //                       47 450
        //                       48 454
        //                       49 458
        //                       50 462
        //                       51 466
        //                       52 470
        //                       53 474
        //                       54 478
        //                       55 482
        //                       56 486
        //                       57 490
        //                       58 494
        //                       59 498;
               goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61
_L2:
            return null;
_L3:
            return "user_load_my_feed";
_L4:
            return "user_load_liked_listings";
_L5:
            return "user_signup";
_L6:
            return "user_login";
_L7:
            return "follow_brand";
_L8:
            return "listing_add_comment";
_L9:
            return "user_update_profile";
_L10:
            return "user_update_settings";
_L11:
            return "user_load_profile";
_L12:
            return "user_load_settings";
_L13:
            return "load_sizes";
_L14:
            return "user_referral";
_L15:
            return "user_set_password";
_L16:
            return "user_change_password";
_L17:
            return "user_check_for_password";
_L18:
            return "link_facebook";
_L19:
            return "link_twitter";
_L20:
            return "link_tumblr";
_L21:
            return "user_find_facebook_friends";
_L22:
            return "user_load_twitter_friends";
_L23:
            return "user_load_suggested_users";
_L24:
            return "load_userlist";
_L25:
            return "user_unlink_facebook";
_L26:
            return "user_update_facebook_timeline_access";
_L27:
            return "update_sizes";
_L28:
            return "block_user";
_L29:
            return "unblock_user";
_L30:
            return "report_user";
_L31:
            return "user_load_closet";
_L32:
            return "listing_load_listings";
_L33:
            return "load_searched_listings";
_L34:
            return "listing_share";
_L35:
            return "listing_upload";
_L36:
            return "listing_edit";
_L37:
            return "listing_delete";
_L38:
            return "listing_report";
_L39:
            return "load_party_feed";
_L40:
            return "listing_share_via_email";
_L41:
            return "listing_share_via_sms";
_L42:
            return "listing_share_on_twitter";
_L43:
            return "listing_share_on_tumblr";
_L44:
            return "listing_share_on_facebook";
_L45:
            return "closet_share_via_email";
_L46:
            return "closet_share_via_sms";
_L47:
            return "closet_share_on_twitter";
_L48:
            return "share_closet_on_instagram";
_L49:
            return "share_closet";
_L50:
            return "share_closet_facebook";
_L51:
            return "share_showroom";
_L52:
            return "share_showroom_email";
_L53:
            return "share_showroom_sms";
_L54:
            return "share_showroom_facebook";
_L55:
            return "share_showroom_twitter";
_L56:
            return "share_showroom_tumblr";
_L57:
            return "order_update_address";
_L58:
            return "order_checkout";
_L59:
            return "order_add_product";
_L60:
            return "order_submit";
_L61:
            return "cc_submit";
        }

        public static ActionContext valueOf(String s)
        {
            return (ActionContext)Enum.valueOf(com/poshmark/ui/model/ActionErrorContext$ActionContext, s);
        }

        public static ActionContext[] values()
        {
            return (ActionContext[])$VALUES.clone();
        }

        static 
        {
            LOAD_MY_FEED = new ActionContext("LOAD_MY_FEED", 0);
            LOAD_MY_LIKES = new ActionContext("LOAD_MY_LIKES", 1);
            USER_SIGNUP = new ActionContext("USER_SIGNUP", 2);
            USER_LOGIN = new ActionContext("USER_LOGIN", 3);
            ADD_COMMENT = new ActionContext("ADD_COMMENT", 4);
            FOLLOW_BRAND = new ActionContext("FOLLOW_BRAND", 5);
            UPDATE_USER_PROFILE = new ActionContext("UPDATE_USER_PROFILE", 6);
            UPDATE_USER_SETTINGS = new ActionContext("UPDATE_USER_SETTINGS", 7);
            LOAD_USER_PROFILE = new ActionContext("LOAD_USER_PROFILE", 8);
            LOAD_USER_SETTINGS = new ActionContext("LOAD_USER_SETTINGS", 9);
            LOAD_MY_SIZES = new ActionContext("LOAD_MY_SIZES", 10);
            LOAD_REFERRAL_CODE = new ActionContext("LOAD_REFERRAL_CODE", 11);
            SET_PASSWORD = new ActionContext("SET_PASSWORD", 12);
            UPDATE_PASSWORD = new ActionContext("UPDATE_PASSWORD", 13);
            CHECK_PASSWORD = new ActionContext("CHECK_PASSWORD", 14);
            LINK_FACEBOOK = new ActionContext("LINK_FACEBOOK", 15);
            LINK_GOOGLE = new ActionContext("LINK_GOOGLE", 16);
            LINK_TWITTER = new ActionContext("LINK_TWITTER", 17);
            LINK_TUMBLR = new ActionContext("LINK_TUMBLR", 18);
            FETCH_FACEBOOK_PM_USERS = new ActionContext("FETCH_FACEBOOK_PM_USERS", 19);
            FETCH_TWITTER_PM_USERS = new ActionContext("FETCH_TWITTER_PM_USERS", 20);
            FETCH_TUMBLR_PM_USERS = new ActionContext("FETCH_TUMBLR_PM_USERS", 21);
            FETCH_SUGGESTED_USERS = new ActionContext("FETCH_SUGGESTED_USERS", 22);
            FETCH_USERLIST = new ActionContext("FETCH_USERLIST", 23);
            UNLINK_FACEBOOK = new ActionContext("UNLINK_FACEBOOK", 24);
            UPDATE_FB_TIMELINE = new ActionContext("UPDATE_FB_TIMELINE", 25);
            UPDATE_MY_SIZE = new ActionContext("UPDATE_MY_SIZE", 26);
            BLOCK_USER = new ActionContext("BLOCK_USER", 27);
            UNBLOCK_USER = new ActionContext("UNBLOCK_USER", 28);
            REPORT_USER = new ActionContext("REPORT_USER", 29);
            LOAD_CLOSET = new ActionContext("LOAD_CLOSET", 30);
            LIKE_LISTING = new ActionContext("LIKE_LISTING", 31);
            LOAD_LISTING = new ActionContext("LOAD_LISTING", 32);
            LOAD_SEARCHED_LISTING = new ActionContext("LOAD_SEARCHED_LISTING", 33);
            POST_LISTING = new ActionContext("POST_LISTING", 34);
            UPDATE_LISTING = new ActionContext("UPDATE_LISTING", 35);
            DELETE_LISTING = new ActionContext("DELETE_LISTING", 36);
            REPORT_LISTING = new ActionContext("REPORT_LISTING", 37);
            LOAD_PARTY_LISTINGS = new ActionContext("LOAD_PARTY_LISTINGS", 38);
            LOAD_SHOWROOM_LISTINGS = new ActionContext("LOAD_SHOWROOM_LISTINGS", 39);
            SHARE_LISTING = new ActionContext("SHARE_LISTING", 40);
            SHARE_LISTING_SMS = new ActionContext("SHARE_LISTING_SMS", 41);
            SHARE_LISTING_EMAIL = new ActionContext("SHARE_LISTING_EMAIL", 42);
            SHARE_LISTING_TWITTER = new ActionContext("SHARE_LISTING_TWITTER", 43);
            SHARE_LISTING_TUMBLR = new ActionContext("SHARE_LISTING_TUMBLR", 44);
            SHARE_LISTING_FACEBOOK = new ActionContext("SHARE_LISTING_FACEBOOK", 45);
            SHARE_CLOSET = new ActionContext("SHARE_CLOSET", 46);
            SHARE_CLOSET_FACEBOOK = new ActionContext("SHARE_CLOSET_FACEBOOK", 47);
            SHARE_CLOSET_SMS = new ActionContext("SHARE_CLOSET_SMS", 48);
            SHARE_CLOSET_EMAIL = new ActionContext("SHARE_CLOSET_EMAIL", 49);
            SHARE_CLOSET_TWITTER = new ActionContext("SHARE_CLOSET_TWITTER", 50);
            SHARE_CLOSET_TUMBLR = new ActionContext("SHARE_CLOSET_TUMBLR", 51);
            SHARE_CLOSET_ON_INSTAGRAM = new ActionContext("SHARE_CLOSET_ON_INSTAGRAM", 52);
            SHARE_SHOWROOM = new ActionContext("SHARE_SHOWROOM", 53);
            SHARE_SHOWROOM_FACEBOOK = new ActionContext("SHARE_SHOWROOM_FACEBOOK", 54);
            SHARE_SHOWROOM_SMS = new ActionContext("SHARE_SHOWROOM_SMS", 55);
            SHARE_SHOWROOM_EMAIL = new ActionContext("SHARE_SHOWROOM_EMAIL", 56);
            SHARE_SHOWROOM_TWITTER = new ActionContext("SHARE_SHOWROOM_TWITTER", 57);
            SHARE_SHOWROOM_TUMBLR = new ActionContext("SHARE_SHOWROOM_TUMBLR", 58);
            UPDATE_ORDER_ADDRESS = new ActionContext("UPDATE_ORDER_ADDRESS", 59);
            CHECKOUT_ORDER = new ActionContext("CHECKOUT_ORDER", 60);
            ADD_PRODUCT_TO_ORDER = new ActionContext("ADD_PRODUCT_TO_ORDER", 61);
            SUBMIT_ORDER = new ActionContext("SUBMIT_ORDER", 62);
            SUBMIT_CC = new ActionContext("SUBMIT_CC", 63);
            ADD_TO_BUNDLE = new ActionContext("ADD_TO_BUNDLE", 64);
            $VALUES = (new ActionContext[] {
                LOAD_MY_FEED, LOAD_MY_LIKES, USER_SIGNUP, USER_LOGIN, ADD_COMMENT, FOLLOW_BRAND, UPDATE_USER_PROFILE, UPDATE_USER_SETTINGS, LOAD_USER_PROFILE, LOAD_USER_SETTINGS, 
                LOAD_MY_SIZES, LOAD_REFERRAL_CODE, SET_PASSWORD, UPDATE_PASSWORD, CHECK_PASSWORD, LINK_FACEBOOK, LINK_GOOGLE, LINK_TWITTER, LINK_TUMBLR, FETCH_FACEBOOK_PM_USERS, 
                FETCH_TWITTER_PM_USERS, FETCH_TUMBLR_PM_USERS, FETCH_SUGGESTED_USERS, FETCH_USERLIST, UNLINK_FACEBOOK, UPDATE_FB_TIMELINE, UPDATE_MY_SIZE, BLOCK_USER, UNBLOCK_USER, REPORT_USER, 
                LOAD_CLOSET, LIKE_LISTING, LOAD_LISTING, LOAD_SEARCHED_LISTING, POST_LISTING, UPDATE_LISTING, DELETE_LISTING, REPORT_LISTING, LOAD_PARTY_LISTINGS, LOAD_SHOWROOM_LISTINGS, 
                SHARE_LISTING, SHARE_LISTING_SMS, SHARE_LISTING_EMAIL, SHARE_LISTING_TWITTER, SHARE_LISTING_TUMBLR, SHARE_LISTING_FACEBOOK, SHARE_CLOSET, SHARE_CLOSET_FACEBOOK, SHARE_CLOSET_SMS, SHARE_CLOSET_EMAIL, 
                SHARE_CLOSET_TWITTER, SHARE_CLOSET_TUMBLR, SHARE_CLOSET_ON_INSTAGRAM, SHARE_SHOWROOM, SHARE_SHOWROOM_FACEBOOK, SHARE_SHOWROOM_SMS, SHARE_SHOWROOM_EMAIL, SHARE_SHOWROOM_TWITTER, SHARE_SHOWROOM_TUMBLR, UPDATE_ORDER_ADDRESS, 
                CHECKOUT_ORDER, ADD_PRODUCT_TO_ORDER, SUBMIT_ORDER, SUBMIT_CC, ADD_TO_BUNDLE
            });
        }

        private ActionContext(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Severity extends Enum
    {

        private static final Severity $VALUES[];
        public static final Severity HIGH;
        public static final Severity LOW;

        public static Severity valueOf(String s)
        {
            return (Severity)Enum.valueOf(com/poshmark/ui/model/ActionErrorContext$Severity, s);
        }

        public static Severity[] values()
        {
            return (Severity[])$VALUES.clone();
        }

        static 
        {
            HIGH = new Severity("HIGH", 0);
            LOW = new Severity("LOW", 1);
            $VALUES = (new Severity[] {
                HIGH, LOW
            });
        }

        private Severity(String s, int i)
        {
            super(s, i);
        }
    }


    public final String analyticsEvent;
    public final String message;
    public final Severity severity;
    public final String title;

    public ActionErrorContext(PMApiError pmapierror, ActionContext actioncontext)
    {
        this(pmapierror, actioncontext, null, Severity.LOW, null, null);
    }

    public ActionErrorContext(PMApiError pmapierror, ActionContext actioncontext, Severity severity1)
    {
        this(pmapierror, actioncontext, null, severity1, null, null);
    }

    public ActionErrorContext(PMApiError pmapierror, ActionContext actioncontext, String s)
    {
        this(pmapierror, actioncontext, s, Severity.LOW, null, null);
    }

    public ActionErrorContext(PMApiError pmapierror, ActionContext actioncontext, String s, Severity severity1)
    {
        this(pmapierror, actioncontext, s, severity1, null, null);
    }

    public ActionErrorContext(PMApiError pmapierror, ActionContext actioncontext, String s, Severity severity1, String s1, String s2)
    {
        severity = severity1;
        analyticsEvent = getAnalyticsEvent(actioncontext);
        title = getTitle(pmapierror);
        message = getMessage(pmapierror, s, s1, s2);
    }

    private String getAnalyticsEvent(ActionContext actioncontext)
    {
        actioncontext = ActionContext.getString(actioncontext);
        if (actioncontext != null && actioncontext.length() > 0)
        {
            return (new StringBuilder()).append(actioncontext).append("_error").toString();
        } else
        {
            return "unknown_error";
        }
    }

    private String getMessage(PMApiError pmapierror, String s, String s1, String s2)
    {
        Context context = PMApplication.getContext();
        String s3 = pmapierror.getUserMessage();
        if (s3 != null && s3.length() > 0)
        {
            return s3;
        }
        if (pmapierror.isNetworkDomainError())
        {
            if (s1 != null && s1.length() > 0)
            {
                return s1;
            }
            if (!NetworkUtils.isOnline())
            {
                if (s != null && s.length() > 0)
                {
                    return String.format(context.getString(0x7f0600f1), new Object[] {
                        s
                    });
                } else
                {
                    return context.getString(0x7f0600f0);
                }
            }
            if (s != null && s.length() > 0)
            {
                return String.format(context.getString(0x7f0600f3), new Object[] {
                    s
                });
            } else
            {
                return context.getString(0x7f0600f2);
            }
        }
        if (s2 != null && s2.length() > 0)
        {
            return s2;
        }
        if (s != null && s.length() > 0)
        {
            return String.format(context.getString(0x7f0600d9), new Object[] {
                s
            });
        } else
        {
            return context.getString(0x7f0600d8);
        }
    }

    private static Severity getSeverity(PMApiError pmapierror)
    {
        pmapierror = pmapierror.getUserMessage();
        if (pmapierror != null && pmapierror.length() > 0)
        {
            return Severity.HIGH;
        } else
        {
            return Severity.LOW;
        }
    }

    private String getTitle(PMApiError pmapierror)
    {
        return null;
    }
}
