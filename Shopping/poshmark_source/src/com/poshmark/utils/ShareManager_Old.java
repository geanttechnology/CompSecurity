// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.BrandShareMessageContainer;
import com.poshmark.data_model.models.BrandShareMessages;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.Referral;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.data_model.models.inner_models.ShortUrl;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.FBConnectCallback;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.MessageEditorFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.fragments.PartyGuidelinesFragment;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.utils:
//            CurrencyUtils, NewRelicCustomInteractions

public class ShareManager_Old
{
    public static final class SHARE_MODE extends Enum
    {

        private static final SHARE_MODE $VALUES[];
        public static final SHARE_MODE SHARE_MODE_BRAND;
        public static final SHARE_MODE SHARE_MODE_BRAND_JUSTIN;
        public static final SHARE_MODE SHARE_MODE_CLOSET;
        public static final SHARE_MODE SHARE_MODE_INVITE_FRIENDS;
        public static final SHARE_MODE SHARE_MODE_LISTING;
        public static final SHARE_MODE SHARE_MODE_PARTY;
        public static final SHARE_MODE SHARE_MODE_SHOWROOM;

        public static SHARE_MODE valueOf(String s)
        {
            return (SHARE_MODE)Enum.valueOf(com/poshmark/utils/ShareManager_Old$SHARE_MODE, s);
        }

        public static SHARE_MODE[] values()
        {
            return (SHARE_MODE[])$VALUES.clone();
        }

        static 
        {
            SHARE_MODE_LISTING = new SHARE_MODE("SHARE_MODE_LISTING", 0);
            SHARE_MODE_INVITE_FRIENDS = new SHARE_MODE("SHARE_MODE_INVITE_FRIENDS", 1);
            SHARE_MODE_PARTY = new SHARE_MODE("SHARE_MODE_PARTY", 2);
            SHARE_MODE_CLOSET = new SHARE_MODE("SHARE_MODE_CLOSET", 3);
            SHARE_MODE_SHOWROOM = new SHARE_MODE("SHARE_MODE_SHOWROOM", 4);
            SHARE_MODE_BRAND = new SHARE_MODE("SHARE_MODE_BRAND", 5);
            SHARE_MODE_BRAND_JUSTIN = new SHARE_MODE("SHARE_MODE_BRAND_JUSTIN", 6);
            $VALUES = (new SHARE_MODE[] {
                SHARE_MODE_LISTING, SHARE_MODE_INVITE_FRIENDS, SHARE_MODE_PARTY, SHARE_MODE_CLOSET, SHARE_MODE_SHOWROOM, SHARE_MODE_BRAND, SHARE_MODE_BRAND_JUSTIN
            });
        }

        private SHARE_MODE(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class SHARE_TYPE extends Enum
    {

        private static final SHARE_TYPE $VALUES[];
        public static final SHARE_TYPE EMAIL_SHARE;
        public static final SHARE_TYPE EMAIL_SHARE_BODY;
        public static final SHARE_TYPE EMAIL_SHARE_SUBJECT;
        public static final SHARE_TYPE FB_DIALOG_SHARE;
        public static final SHARE_TYPE FB_MESSENGER_SHARE;
        public static final SHARE_TYPE FB_SHARE;
        public static final SHARE_TYPE INSTAGRAM_SHARE;
        public static final SHARE_TYPE PINTEREST_SHARE;
        public static final SHARE_TYPE SMS_SHARE;
        public static final SHARE_TYPE TM_SHARE;
        public static final SHARE_TYPE TW_SHARE;

        public static SHARE_TYPE valueOf(String s)
        {
            return (SHARE_TYPE)Enum.valueOf(com/poshmark/utils/ShareManager_Old$SHARE_TYPE, s);
        }

        public static SHARE_TYPE[] values()
        {
            return (SHARE_TYPE[])$VALUES.clone();
        }

        static 
        {
            FB_SHARE = new SHARE_TYPE("FB_SHARE", 0);
            TW_SHARE = new SHARE_TYPE("TW_SHARE", 1);
            TM_SHARE = new SHARE_TYPE("TM_SHARE", 2);
            INSTAGRAM_SHARE = new SHARE_TYPE("INSTAGRAM_SHARE", 3);
            PINTEREST_SHARE = new SHARE_TYPE("PINTEREST_SHARE", 4);
            SMS_SHARE = new SHARE_TYPE("SMS_SHARE", 5);
            FB_MESSENGER_SHARE = new SHARE_TYPE("FB_MESSENGER_SHARE", 6);
            FB_DIALOG_SHARE = new SHARE_TYPE("FB_DIALOG_SHARE", 7);
            EMAIL_SHARE = new SHARE_TYPE("EMAIL_SHARE", 8);
            EMAIL_SHARE_BODY = new SHARE_TYPE("EMAIL_SHARE_BODY", 9);
            EMAIL_SHARE_SUBJECT = new SHARE_TYPE("EMAIL_SHARE_SUBJECT", 10);
            $VALUES = (new SHARE_TYPE[] {
                FB_SHARE, TW_SHARE, TM_SHARE, INSTAGRAM_SHARE, PINTEREST_SHARE, SMS_SHARE, FB_MESSENGER_SHARE, FB_DIALOG_SHARE, EMAIL_SHARE, EMAIL_SHARE_BODY, 
                EMAIL_SHARE_SUBJECT
            });
        }

        private SHARE_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    private static class ShareManagerHolder
    {

        static final ShareManager_Old INSTANCE = new ShareManager_Old();


        private ShareManagerHolder()
        {
        }
    }


    private static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    private static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    private static final int PROTOCOL_VERSION = 0x133782a;
    private static final int SHARE_TO_MESSENGER_REQUEST_CODE = 1;
    private static final String YOUR_APP_ID = "647031411978994";
    private static final String bitlyUrl = "http://bit.ly/GetPosh-FB";
    private Brand brand;
    private BrandShareMessages brandShareMessages;
    private PMFragment callingFragment;
    private String closetShortURL;
    private Context context;
    com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener dismissListener = new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

        final ShareManager_Old this$0;

        public void dialogDismissed()
        {
            callingFragment.getActivity().finish();
        }

            
            {
                this$0 = ShareManager_Old.this;
                super();
            }
    };
    private PartyEvent event;
    private ListingSocial listingItem;
    private SHARE_MODE mode;
    private Referral referralData;
    private Showroom showroom;
    private SHARE_TYPE type;
    private UserInfoDetails userInfo;

    private ShareManager_Old()
    {
    }


    private String getDefaultPlaceholderString()
    {
        if (mode == SHARE_MODE.SHARE_MODE_LISTING && type == SHARE_TYPE.FB_SHARE)
        {
            if (isListingOwner())
            {
                return context.getString(0x7f060174);
            } else
            {
                return context.getString(0x7f060173);
            }
        }
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS && type == SHARE_TYPE.FB_SHARE)
        {
            String s = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(referralData.getReferredIncentiveString()).toString();
            return String.format(context.getString(0x7f060159), new Object[] {
                referralData.getId(), s
            });
        }
        if (mode == SHARE_MODE.SHARE_MODE_PARTY && type == SHARE_TYPE.FB_SHARE)
        {
            if (event.isPastEvent())
            {
                return context.getString(0x7f0601f6);
            }
            if (event.isHappeningNow())
            {
                return context.getString(0x7f06009c);
            } else
            {
                return context.getString(0x7f0602af);
            }
        }
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET && type == SHARE_TYPE.FB_SHARE)
        {
            if (isClosetOwner())
            {
                return context.getString(0x7f06007f);
            } else
            {
                return String.format(context.getString(0x7f06007e), new Object[] {
                    userInfo.getUserName()
                });
            }
        }
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM && type == SHARE_TYPE.FB_SHARE)
        {
            return context.getString(0x7f060271);
        }
        if (mode == SHARE_MODE.SHARE_MODE_BRAND && type == SHARE_TYPE.FB_SHARE)
        {
            if (brandShareMessages != null && brandShareMessages.facebook != null)
            {
                return brandShareMessages.facebook.hint;
            } else
            {
                return String.format(context.getString(0x7f060059), new Object[] {
                    brand.canonical_name
                });
            }
        } else
        {
            return "";
        }
    }

    private String getDefaultShareMessage()
    {
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            return getListingShareMessageString(type);
        }
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            return getUserInviteMessageString(type);
        }
        if (mode == SHARE_MODE.SHARE_MODE_PARTY)
        {
            return getPartyInviteMessageString(type);
        }
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
        {
            return getClosetShareMessageString(type);
        }
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            return getShowroomShareMessageString(type);
        }
        if (mode == SHARE_MODE.SHARE_MODE_BRAND)
        {
            return getBrandShareMessageString(type);
        } else
        {
            return "";
        }
    }

    private String getFormattedEmailBodyForBrandShare()
    {
        if (brandShareMessages != null && brandShareMessages.email != null)
        {
            return brandShareMessages.email.body;
        }
        String s;
        String s1;
        if (brand.cover_shot != null && brand.cover_shot.url_small != null)
        {
            s = brand.cover_shot.url_small;
        } else
        {
            s = Brand.getDefaultBrandCovershotUrl();
        }
        s1 = Brand.getUrlFromBrandName(brand.canonical_name);
        return String.format(context.getString(0x7f060057), new Object[] {
            s, s1, brand.canonical_name, PMApplicationSession.GetPMSession().getFirstName()
        });
    }

    private String getFormattedEmailBodyForClosetShare(boolean flag)
    {
        String s = userInfo.getUserSmallPicUrl();
        if (flag)
        {
            return String.format(context.getString(0x7f06007b), new Object[] {
                referralData.getReferrerIncentiveFormattedString(), referralData.getId(), userInfo.getClosetURL(), s, userInfo.getUserName(), PMApplicationSession.GetPMSession().getFirstName()
            });
        } else
        {
            return String.format(context.getString(0x7f06007a), new Object[] {
                userInfo.getClosetURL(), userInfo.getUserName(), s, PMApplicationSession.GetPMSession().getFirstName()
            });
        }
    }

    private String getFormattedEmailBodyForListingShare(boolean flag)
    {
        if (flag)
        {
            return String.format("<div><p>%1$s</p><p>%2$s</p><div style='clear:both'></div><a href=%3$s><img src='%4$s' width='100px' style='margin-right:10px;float:left;'></a><p style='float:left;padding:0;margin:0;'>%5$s - <a href=%3$s>%3$s</a><br/><br/>Price: %6$s <br/><br/>Size: %7$s</p></div><div style='clear:both'></div><p>-%8$s</p>", new Object[] {
                context.getString(0x7f06013e), context.getString(0x7f060170), getListingShareURL(), listingItem.getSmallCovershot(), listingItem.getTitle(), listingItem.getPriceString(), listingItem.getSize(), PMApplicationSession.GetPMSession().getUserName()
            });
        } else
        {
            return String.format("<div><p>%1$s</p><p>%2$s</p><div style='clear:both'></div><a href=%3$s><img src='%4$s' width='100px' style='margin-right:10px;float:left;'></a><p style='float:left;padding:0;margin:0;'>%5$s - <a href=%3$s>%3$s</a><br/><br/>Price: %6$s <br/><br/>Size: %7$s</p></div><div style='clear:both'></div><p>-%8$s</p>", new Object[] {
                context.getString(0x7f06013e), context.getString(0x7f06016f), getListingShareURL(), listingItem.getSmallCovershot(), listingItem.getTitle(), listingItem.getPriceString(), listingItem.getSize(), PMApplicationSession.GetPMSession().getUserName()
            });
        }
    }

    private String getFormattedEmailBodyForPartyShare(String s, String s1, boolean flag)
    {
        if (flag)
        {
            return String.format(context.getString(0x7f0601f7), new Object[] {
                s, s1, "https://www.poshmark.com"
            });
        } else
        {
            return String.format(context.getString(0x7f0601f2), new Object[] {
                s, s1, "https://www.poshmark.com"
            });
        }
    }

    private String getFormattedEmailBodyForShowroomShare()
    {
        return String.format(context.getString(0x7f06026f), new Object[] {
            showroom.getCoverShot().url_small, showroom.getWebURL(), showroom.getName(), PMApplicationSession.GetPMSession().getFirstName()
        });
    }

    public static ShareManager_Old getInstance()
    {
        return ShareManagerHolder.INSTANCE;
    }

    private String getMessageEditorScreenNameForAnalytics()
    {
        static class _cls15
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[];
            static final int $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE = new int[SHARE_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_LISTING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_BRAND.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_BRAND_JUSTIN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_PARTY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE[SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE = new int[SHARE_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.FB_SHARE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.TM_SHARE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.TW_SHARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.EMAIL_SHARE_BODY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.EMAIL_SHARE_SUBJECT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.SMS_SHARE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE[SHARE_TYPE.FB_DIALOG_SHARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "facebook_share_message_screen";

        case 2: // '\002'
            return "tumblr_share_message_screen";

        case 3: // '\003'
            return "twitter_share_message_screen";
        }
    }

    private void handleFbShareAuthError(final PMApiResponse apiResponse, final String message)
    {
        FbHelper.getInstance().link(callingFragment, 8, 8, new FBConnectCallback() {

            final ShareManager_Old this$0;
            final PMApiResponse val$apiResponse;
            final String val$message;

            public void error(PMApiError pmapierror)
            {
                callingFragment.showError(new ActionErrorContext(apiResponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_FACEBOOK));
            }

            public void success(int i, String s, String s1)
            {
                if ((i & 8) == 0) goto _L2; else goto _L1
_L1:
                _cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_MODE[mode.ordinal()];
                JVM INSTR tableswitch 1 6: default 60
            //                           1 61
            //                           2 80
            //                           3 99
            //                           4 99
            //                           5 118
            //                           6 137;
                   goto _L2 _L3 _L4 _L5 _L5 _L6 _L7
_L2:
                return;
_L3:
                shareListing(type, message);
                return;
_L4:
                shareShowroom(type, message);
                return;
_L5:
                shareBrand(type, message);
                return;
_L6:
                shareCloset(type, message);
                return;
_L7:
                shareParty(type, message);
                return;
            }

            
            {
                this$0 = ShareManager_Old.this;
                message = s;
                apiResponse = pmapiresponse;
                super();
            }
        });
    }

    private boolean isClosetOwner()
    {
        return PMApplicationSession.GetPMSession().getUserId().equals(userInfo.getPMUserId());
    }

    private boolean isListingOwner()
    {
        return PMApplicationSession.GetPMSession().getUserId().equals(listingItem.getUserId());
    }

    private void trackShareEvent()
    {
        if (mode != SHARE_MODE.SHARE_MODE_LISTING) goto _L2; else goto _L1
_L1:
        String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
        if (type == SHARE_TYPE.FB_SHARE)
        {
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_facebook", s);
        }
        if (type == SHARE_TYPE.TW_SHARE)
        {
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_twitter", s);
        }
        if (type == SHARE_TYPE.TM_SHARE)
        {
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_tumblr", s);
        }
_L4:
        return;
_L2:
        if (mode != SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1 = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
        if (type == SHARE_TYPE.FB_SHARE)
        {
            Analytics.getInstance().trackEvent("referral_screen", "user", "referral_facebook", s1);
        }
        if (type == SHARE_TYPE.TW_SHARE)
        {
            Analytics.getInstance().trackEvent("referral_screen", "user", "referral_twitter", s1);
        }
        if (type == SHARE_TYPE.TM_SHARE)
        {
            Analytics.getInstance().trackEvent("referral_screen", "user", "referral_tumblr", s1);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (mode != SHARE_MODE.SHARE_MODE_PARTY)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s2 = (new StringBuilder()).append(event.getId()).append("/").append(event.getTitle()).toString();
        if (type == SHARE_TYPE.FB_SHARE)
        {
            Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_facebook", s2);
        }
        if (type == SHARE_TYPE.TW_SHARE)
        {
            Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_twitter", s2);
        }
        if (type == SHARE_TYPE.TM_SHARE)
        {
            Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_tumblr", s2);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (mode != SHARE_MODE.SHARE_MODE_BRAND && mode != SHARE_MODE.SHARE_MODE_BRAND_JUSTIN) goto _L4; else goto _L5
_L5:
        String s3 = brand.canonical_name;
        if (type == SHARE_TYPE.FB_SHARE)
        {
            Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_facebook", s3);
        }
        if (type == SHARE_TYPE.TW_SHARE)
        {
            Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_twitter", s3);
        }
        if (type == SHARE_TYPE.TM_SHARE)
        {
            Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_tumblr", s3);
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    private void trackShareFailedEvent()
    {
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_failed", s);
        } else
        {
            if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
            {
                String s1 = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
                Analytics.getInstance().trackEvent("referral_screen", "user", "referral_failed", s1);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_PARTY)
            {
                String s2 = (new StringBuilder()).append(event.getId()).append("/").append(event.getTitle()).toString();
                Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_party_failed", s2);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_BRAND || mode == SHARE_MODE.SHARE_MODE_BRAND_JUSTIN)
            {
                String s3 = brand.canonical_name;
                Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_failed", s3);
                return;
            }
        }
    }

    public void deInit()
    {
        referralData = null;
        listingItem = null;
        event = null;
        userInfo = null;
        showroom = null;
        brand = null;
        brandShareMessages = null;
        callingFragment = null;
        context = null;
        closetShortURL = null;
    }

    public void doEmailShare()
    {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
        if (mode != SHARE_MODE.SHARE_MODE_LISTING) goto _L2; else goto _L1
_L1:
        intent.putExtra("android.intent.extra.SUBJECT", getListingShareMessageString(SHARE_TYPE.EMAIL_SHARE_SUBJECT));
        String s = getListingShareMessageString(SHARE_TYPE.EMAIL_SHARE_BODY);
        intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(s).toString()));
        s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
        Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_email", s);
        trackExternalShareOnPM();
_L4:
        callingFragment.startActivityForResult(Intent.createChooser(intent, "Send email..."), 13);
        return;
_L2:
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            intent.putExtra("android.intent.extra.SUBJECT", getUserInviteMessageString(SHARE_TYPE.EMAIL_SHARE_SUBJECT));
            String s1 = getUserInviteMessageString(SHARE_TYPE.EMAIL_SHARE_BODY);
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(s1).toString()));
            s1 = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
            Analytics.getInstance().trackEvent("referral_screen", "user", "referral_email", s1);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_PARTY)
        {
            intent.putExtra("android.intent.extra.SUBJECT", getPartyInviteMessageString(SHARE_TYPE.EMAIL_SHARE_SUBJECT));
            String s2 = getPartyInviteMessageString(SHARE_TYPE.EMAIL_SHARE_BODY);
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(s2).toString()));
            s2 = (new StringBuilder()).append(event.getId()).append("/").append(event.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_email", s2);
        } else
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
        {
            intent.putExtra("android.intent.extra.SUBJECT", getClosetShareMessageString(SHARE_TYPE.EMAIL_SHARE_SUBJECT));
            String s3 = getClosetShareMessageString(SHARE_TYPE.EMAIL_SHARE_BODY);
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(s3).toString()));
            s3 = (new StringBuilder()).append(userInfo.getPMUserId()).append("/").append(userInfo.getUserName()).toString();
            Analytics.getInstance().trackEvent("share_closet_options_screen", "user", "share_closet_email", s3);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            intent.putExtra("android.intent.extra.SUBJECT", getShowroomShareMessageString(SHARE_TYPE.EMAIL_SHARE_SUBJECT));
            String s4 = getShowroomShareMessageString(SHARE_TYPE.EMAIL_SHARE_BODY);
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(s4).toString()));
            s4 = (new StringBuilder()).append(showroom.getId()).append("/").append(showroom.getName()).toString();
            Analytics.getInstance().trackEvent("share_showroom_options_screen", "listing", "share_showroom_email", s4);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_BRAND || mode == SHARE_MODE.SHARE_MODE_BRAND_JUSTIN)
        {
            intent.putExtra("android.intent.extra.SUBJECT", getBrandShareMessageString(SHARE_TYPE.EMAIL_SHARE_SUBJECT));
            String s5 = getBrandShareMessageString(SHARE_TYPE.EMAIL_SHARE_BODY);
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml((new StringBuilder()).append(s5).toString()));
            Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_email", brand.canonical_name);
            trackExternalShareOnPM();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void doFBMessengerShare()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.addFlags(0x80000);
        intent.setPackage("com.facebook.orca");
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            intent.putExtra("android.intent.extra.TEXT", getListingShareURL());
            String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_fbmessenger", s);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            intent.putExtra("android.intent.extra.TEXT", getUserInviteMessageString(SHARE_TYPE.FB_MESSENGER_SHARE));
            String s1 = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
            Analytics.getInstance().trackEvent("referral_screen", "user", "referral_fbmessenger", s1);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_PARTY)
        {
            intent.putExtra("android.intent.extra.TEXT", event.getURL());
            String s2 = (new StringBuilder()).append(event.getId()).append("/").append(event.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_fbmessenger", s2);
        } else
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
        {
            intent.putExtra("android.intent.extra.TEXT", getClosetShareMessageString(SHARE_TYPE.FB_MESSENGER_SHARE));
            String s3 = (new StringBuilder()).append(userInfo.getPMUserId()).append("/").append(userInfo.getUserName()).toString();
            Analytics.getInstance().trackEvent("share_closet_options_screen", "party", "share_closet_fbmessenger", s3);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            intent.putExtra("android.intent.extra.TEXT", getShowroomShareMessageString(SHARE_TYPE.FB_MESSENGER_SHARE));
            String s4 = (new StringBuilder()).append(showroom.getId()).append("/").append(showroom.getName()).toString();
            Analytics.getInstance().trackEvent("share_showroom_options_screen", "listing", "share_showroom_fbmessenger", s4);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_BRAND)
        {
            intent.putExtra("android.intent.extra.TEXT", getBrandShareMessageString(SHARE_TYPE.FB_MESSENGER_SHARE));
            Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_fbmessenger", brand.canonical_name);
            trackExternalShareOnPM();
        }
        try
        {
            callingFragment.getActivity().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    public void doFbDialogShare()
    {
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            listingItem.getTitle();
            listingItem.getDescription();
            getListingShareURL();
            String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_fb_dialog", s);
            trackExternalShareOnPM();
        } else
        {
            if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
            {
                Object obj = getReferralData();
                if (obj != null)
                {
                    obj = ((Referral) (obj)).getDefaultMessages();
                    if (obj != null && ((com.poshmark.data_model.models.Referral.DefaultMessages) (obj)).fb_share_url != null)
                    {
                        obj = ((com.poshmark.data_model.models.Referral.DefaultMessages) (obj)).fb_share_url;
                    }
                }
                getUserInviteMessageString(SHARE_TYPE.FB_DIALOG_SHARE);
                obj = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
                Analytics.getInstance().trackEvent("referral_screen", "user", "referral_fb_dialog", ((String) (obj)));
                trackExternalShareOnPM();
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_PARTY)
            {
                event.getTitle();
                event.getDescription();
                event.getURL();
                String s1 = (new StringBuilder()).append(event.getId()).append("/").append(event.getTitle()).toString();
                Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_fb_dialog", s1);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
            {
                (new StringBuilder()).append(userInfo.getDisplayHandle()).append("'s Closet").toString();
                String s2 = closetShortURL;
                s2 = (new StringBuilder()).append(userInfo.getPMUserId()).append("/").append(userInfo.getUserName()).toString();
                Analytics.getInstance().trackEvent("share_closet_options_screen", "party", "share_closet_fb_dialog", s2);
                trackExternalShareOnPM();
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
            {
                showroom.getName();
                context.getString(0x7f06010c);
                showroom.getShortURL();
                String s3 = (new StringBuilder()).append(showroom.getId()).append("/").append(showroom.getName()).toString();
                Analytics.getInstance().trackEvent("share_showroom_options_screen", "listing", "share_showroom_fb_dialog", s3);
                trackExternalShareOnPM();
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_BRAND)
            {
                (new StringBuilder()).append(brand.canonical_name).append(" on Poshmark").toString();
                context.getString(0x7f06010c);
                Brand.getUrlFromBrandName(brand.canonical_name);
                Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_fbmessenger", brand.canonical_name);
                trackExternalShareOnPM();
                return;
            }
        }
    }

    public void doSMSShare()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            intent.putExtra("sms_body", getListingShareMessageString(SHARE_TYPE.SMS_SHARE));
            String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_sms", s);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            intent.putExtra("sms_body", getUserInviteMessageString(SHARE_TYPE.SMS_SHARE));
            String s1 = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
            Analytics.getInstance().trackEvent("referral_screen", "user", "referral_sms", s1);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_PARTY)
        {
            intent.putExtra("sms_body", getPartyInviteMessageString(SHARE_TYPE.SMS_SHARE));
            String s2 = (new StringBuilder()).append(event.getId()).append("/").append(event.getTitle()).toString();
            Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_sms", s2);
        } else
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
        {
            intent.putExtra("sms_body", getClosetShareMessageString(SHARE_TYPE.SMS_SHARE));
            String s3 = (new StringBuilder()).append(userInfo.getPMUserId()).append("/").append(userInfo.getUserName()).toString();
            Analytics.getInstance().trackEvent("share_closet_options_screen", "party", "share_closet_sms", s3);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            intent.putExtra("sms_body", getShowroomShareMessageString(SHARE_TYPE.SMS_SHARE));
            String s4 = (new StringBuilder()).append(showroom.getId()).append("/").append(showroom.getName()).toString();
            Analytics.getInstance().trackEvent("share_showroom_options_screen", "listing", "share_showroom_sms", s4);
            trackExternalShareOnPM();
        } else
        if (mode == SHARE_MODE.SHARE_MODE_BRAND)
        {
            intent.putExtra("sms_body", getBrandShareMessageString(SHARE_TYPE.SMS_SHARE));
            Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_sms", brand.canonical_name);
            trackExternalShareOnPM();
        }
        try
        {
            callingFragment.startActivityForResult(intent, 14);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    public String getBrandShareMessageString(SHARE_TYPE share_type)
    {
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "";

        case 2: // '\002'
            if (brandShareMessages == null || brandShareMessages.tumblr == null)
            {
                return String.format(context.getString(0x7f06005f), new Object[] {
                    brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
                });
            } else
            {
                return brandShareMessages.tumblr.message;
            }

        case 3: // '\003'
            if (brandShareMessages == null || brandShareMessages.twitter == null)
            {
                return String.format(context.getString(0x7f060060), new Object[] {
                    brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
                });
            } else
            {
                return brandShareMessages.twitter.message;
            }

        case 6: // '\006'
            if (brandShareMessages == null || brandShareMessages.sms == null)
            {
                String.format(context.getString(0x7f06005e), new Object[] {
                    brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
                });
            } else
            {
                share_type = brandShareMessages.sms.message;
            }
            // fall through

        case 7: // '\007'
            if (brandShareMessages == null || brandShareMessages.sms == null)
            {
                return Brand.getUrlFromBrandName(brand.canonical_name);
            } else
            {
                return brandShareMessages.sms.message;
            }

        case 4: // '\004'
            return getFormattedEmailBodyForBrandShare();

        case 5: // '\005'
            break;
        }
        if (brandShareMessages == null || brandShareMessages.email == null)
        {
            return String.format(context.getString(0x7f060058), new Object[] {
                brand.canonical_name
            });
        } else
        {
            return brandShareMessages.email.subject;
        }
    }

    public String getClosetShareMessageString(SHARE_TYPE share_type)
    {
        boolean flag = isClosetOwner();
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "";

        case 2: // '\002'
            if (flag)
            {
                return String.format(context.getString(0x7f060086), new Object[] {
                    userInfo.getUserName(), referralData.getId(), referralData.getReferredIncentiveFormattedString()
                });
            } else
            {
                return String.format(context.getString(0x7f060085), new Object[] {
                    userInfo.getUserName(), referralData.getId(), referralData.getReferredIncentiveFormattedString()
                });
            }

        case 3: // '\003'
            if (flag)
            {
                return String.format(context.getString(0x7f060088), new Object[] {
                    userInfo.getUserName(), referralData.getId(), referralData.getReferredIncentiveFormattedString(), closetShortURL
                });
            } else
            {
                return String.format(context.getString(0x7f060087), new Object[] {
                    userInfo.getUserName(), referralData.getId(), referralData.getReferredIncentiveFormattedString(), closetShortURL
                });
            }

        case 6: // '\006'
            if (flag)
            {
                return String.format(context.getString(0x7f060083), new Object[] {
                    closetShortURL
                });
            } else
            {
                return String.format(context.getString(0x7f060082), new Object[] {
                    userInfo.getUserName(), closetShortURL
                });
            }

        case 7: // '\007'
            return closetShortURL;

        case 4: // '\004'
            return getFormattedEmailBodyForClosetShare(flag);

        case 5: // '\005'
            break;
        }
        if (flag)
        {
            return String.format(context.getString(0x7f06007d), new Object[0]);
        } else
        {
            return String.format(context.getString(0x7f06007c), new Object[] {
                userInfo.getUserName()
            });
        }
    }

    public String getExternalShareIdString(SHARE_TYPE share_type)
    {
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "fb";

        case 2: // '\002'
            return "tm";

        case 3: // '\003'
            return "tw";
        }
    }

    public String getListingShareMessageString(SHARE_TYPE share_type)
    {
        String s = getListingShareURL();
        boolean flag = isListingOwner();
        String s1 = listingItem.getTitle();
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "";

        case 2: // '\002'
            if (flag)
            {
                return String.format(context.getString(0x7f06018a), new Object[] {
                    s1, s
                });
            } else
            {
                return String.format(context.getString(0x7f060189), new Object[] {
                    s1, s
                });
            }

        case 3: // '\003'
            if (flag)
            {
                return String.format(context.getString(0x7f06018c), new Object[] {
                    s1, listingItem.getShortURL()
                });
            } else
            {
                return String.format(context.getString(0x7f06018b), new Object[] {
                    s1, listingItem.getShortURL()
                });
            }

        case 6: // '\006'
            if (flag)
            {
                return String.format(context.getString(0x7f060183), new Object[] {
                    s1, s
                });
            } else
            {
                return String.format(context.getString(0x7f060182), new Object[] {
                    s1, s
                });
            }

        case 4: // '\004'
            return getFormattedEmailBodyForListingShare(flag);

        case 5: // '\005'
            break;
        }
        if (flag)
        {
            return String.format(context.getString(0x7f060172), new Object[] {
                s1
            });
        } else
        {
            return String.format(context.getString(0x7f060171), new Object[] {
                s1
            });
        }
    }

    public String getListingShareURL()
    {
        return (new StringBuilder()).append("https://www.poshmark.com/listings/").append(listingItem.getIdAsString()).toString();
    }

    public String getPartyInviteMessageString(SHARE_TYPE share_type)
    {
        String s = event.getURL();
        String s1 = event.getTitle();
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "";

        case 2: // '\002'
            if (event.isHappeningNow())
            {
                return String.format(context.getString(0x7f06009e), new Object[] {
                    s1, s
                });
            }
            if (event.isPastEvent())
            {
                return String.format(context.getString(0x7f0601fa), new Object[] {
                    s1, s
                });
            } else
            {
                return String.format(context.getString(0x7f0602b1), new Object[] {
                    s1, s
                });
            }

        case 7: // '\007'
            return s;

        case 3: // '\003'
            if (event.isHappeningNow())
            {
                return String.format(context.getString(0x7f06009f), new Object[] {
                    s1, s
                });
            }
            if (event.isPastEvent())
            {
                return String.format(context.getString(0x7f0601fb), new Object[] {
                    s1, s
                });
            } else
            {
                return String.format(context.getString(0x7f0602b2), new Object[] {
                    s1, s
                });
            }

        case 6: // '\006'
            if (event.isHappeningNow())
            {
                return String.format(context.getString(0x7f06009d), new Object[] {
                    s1, s
                });
            }
            if (event.isPastEvent())
            {
                return String.format(context.getString(0x7f0601f9), new Object[] {
                    s1, s
                });
            } else
            {
                return String.format(context.getString(0x7f0602b0), new Object[] {
                    s1, s
                });
            }

        case 4: // '\004'
            if (event.isPastEvent())
            {
                return getFormattedEmailBodyForPartyShare(s1, s, true);
            } else
            {
                return getFormattedEmailBodyForPartyShare(s1, s, false);
            }

        case 5: // '\005'
            break;
        }
        if (event.isPastEvent())
        {
            return String.format(context.getString(0x7f0601f8), new Object[] {
                s1
            });
        } else
        {
            return String.format(context.getString(0x7f0601f3), new Object[] {
                s1
            });
        }
    }

    public Referral getReferralData()
    {
        return referralData;
    }

    public SHARE_MODE getShareMode()
    {
        return mode;
    }

    public String getShowroomShareMessageString(SHARE_TYPE share_type)
    {
        String s = showroom.getShortURL();
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "";

        case 2: // '\002'
            return String.format(context.getString(0x7f060273), new Object[] {
                showroom.getName(), s
            });

        case 3: // '\003'
            return String.format(context.getString(0x7f060274), new Object[] {
                showroom.getName(), s
            });

        case 6: // '\006'
            return String.format(context.getString(0x7f060272), new Object[] {
                showroom.getName(), s
            });

        case 7: // '\007'
            return s;

        case 4: // '\004'
            return getFormattedEmailBodyForShowroomShare();

        case 5: // '\005'
            return String.format(context.getString(0x7f060270), new Object[] {
                PMApplicationSession.GetPMSession().getFullName(), showroom.getName()
            });
        }
    }

    public String getTitleString()
    {
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            return context.getString(0x7f060252);
        }
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            return context.getString(0x7f060157);
        }
        if (mode == SHARE_MODE.SHARE_MODE_PARTY)
        {
            return context.getString(0x7f060157);
        }
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
        {
            return context.getString(0x7f060250);
        }
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            return context.getString(0x7f060254);
        }
        if (mode == SHARE_MODE.SHARE_MODE_BRAND)
        {
            return context.getString(0x7f06024f);
        } else
        {
            return "";
        }
    }

    public String getUserInviteMessageString(SHARE_TYPE share_type)
    {
        switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().fb_share;
            }
            break;

        case 2: // '\002'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().tm_share;
            }
            break;

        case 3: // '\003'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().tw_share;
            }
            break;

        case 4: // '\004'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().email_body;
            }
            break;

        case 5: // '\005'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().email_subject;
            }
            break;

        case 6: // '\006'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().sms;
            }
            break;

        case 7: // '\007'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().sms;
            }
            break;

        case 8: // '\b'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().fb_desc;
            }
            break;
        }
        return "";
    }

    public void init(Context context1, SHARE_MODE share_mode, PMFragment pmfragment)
    {
        context = context1;
        mode = share_mode;
        callingFragment = pmfragment;
    }

    public void initiateShare(final SHARE_TYPE shareType)
    {
        type = shareType;
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            if (type == SHARE_TYPE.TM_SHARE || type == SHARE_TYPE.TW_SHARE)
            {
                if (listingItem.getShortURL() == null || listingItem.getShortURL().length() == 0)
                {
                    callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
                    PMApi.getTinyUrlForListing(listingItem.getIdAsString(), new PMApiResponseHandler() {

                        final ShareManager_Old this$0;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            callingFragment.hideProgressDialog();
                            if (!pmapiresponse.hasError())
                            {
                                listingItem.setShortURL(((ShortUrl)pmapiresponse.data).short_url);
                                showShareMessageEditor();
                                return;
                            } else
                            {
                                callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER));
                                return;
                            }
                        }

            
            {
                this$0 = ShareManager_Old.this;
                super();
            }
                    });
                    return;
                } else
                {
                    showShareMessageEditor();
                    return;
                }
            } else
            {
                callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
                showShareMessageEditor();
                return;
            }
        }
        if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
        {
            if (closetShortURL == null || closetShortURL.length() == 0)
            {
                callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
                PMApi.getTinyURLForUser(userInfo.getPMUserId(), new PMApiResponseHandler() {

                    final ShareManager_Old this$0;
                    final SHARE_TYPE val$shareType;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
                        callingFragment.hideProgressDialog();
                        if (!pmapiresponse.hasError())
                        {
                            closetShortURL = ((ShortUrl)pmapiresponse.data).short_url;
                            if (shareType == SHARE_TYPE.EMAIL_SHARE)
                            {
                                doEmailShare();
                                return;
                            }
                            if (shareType == SHARE_TYPE.SMS_SHARE)
                            {
                                doSMSShare();
                                return;
                            }
                            if (shareType == SHARE_TYPE.FB_MESSENGER_SHARE)
                            {
                                doFBMessengerShare();
                                return;
                            }
                            if (shareType == SHARE_TYPE.FB_DIALOG_SHARE)
                            {
                                doFbDialogShare();
                                return;
                            } else
                            {
                                showShareMessageEditor();
                                return;
                            }
                        } else
                        {
                            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER));
                            return;
                        }
                    }

            
            {
                this$0 = ShareManager_Old.this;
                shareType = share_type;
                super();
            }
                });
                return;
            }
            if (shareType == SHARE_TYPE.EMAIL_SHARE)
            {
                doEmailShare();
                return;
            }
            if (shareType == SHARE_TYPE.SMS_SHARE)
            {
                doSMSShare();
                return;
            }
            if (shareType == SHARE_TYPE.FB_MESSENGER_SHARE)
            {
                doFBMessengerShare();
                return;
            }
            if (shareType == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                doFbDialogShare();
                return;
            } else
            {
                showShareMessageEditor();
                return;
            }
        } else
        {
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            showShareMessageEditor();
            return;
        }
    }

    public void inviteFriends(final SHARE_TYPE type, String s)
    {
        String s1 = s;
        if (s.length() == 0)
        {
            s1 = getUserInviteMessageString(type);
        }
        s = getExternalShareIdString(type);
        callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
        PMApi.inviteFriends(referralData.getId(), s1, s, new PMApiResponseHandler() {

            final ShareManager_Old this$0;
            final SHARE_TYPE val$type;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext;
                callingFragment.hideProgressDialog();
                if (!pmapiresponse.hasError())
                {
                    callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                    ((PMContainerActivity)context).popTopFragment();
                    return;
                }
                actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING;
                _cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()];
                JVM INSTR tableswitch 1 3: default 100
            //                           1 123
            //                           2 183
            //                           3 153;
                   goto _L1 _L2 _L3 _L4
_L1:
                callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext));
                return;
_L2:
                com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext1 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_FACEBOOK;
                actioncontext = actioncontext1;
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                {
                    ExtServiceConnectManager.getGlobalConnectManager().fbUnlink();
                    actioncontext = actioncontext1;
                }
                continue; /* Loop/switch isn't completed */
_L4:
                com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext2 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER;
                actioncontext = actioncontext2;
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                {
                    ExtServiceConnectManager.getGlobalConnectManager().twUnlink();
                    actioncontext = actioncontext2;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext3 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TUMBLR;
                actioncontext = actioncontext3;
                if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                {
                    ExtServiceConnectManager.getGlobalConnectManager().tmUnlink();
                    actioncontext = actioncontext3;
                }
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                this$0 = ShareManager_Old.this;
                type = share_type;
                super();
            }
        });
    }

    public void setBrand(Brand brand1)
    {
        brand = brand1;
        PMApi.getBrandShareMessages(brand1.canonical_name, new PMApiResponseHandler() {

            final ShareManager_Old this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    brandShareMessages = ((BrandShareMessageContainer)pmapiresponse.data).getBrandShareMessages();
                }
            }

            
            {
                this$0 = ShareManager_Old.this;
                super();
            }
        });
    }

    public void setCallingFragment(PMFragment pmfragment)
    {
        callingFragment = pmfragment;
    }

    public void setListingItem(ListingSocial listingsocial)
    {
        listingItem = listingsocial;
    }

    public void setPartyEvent(PartyEvent partyevent)
    {
        event = partyevent;
    }

    public void setReferralData(Referral referral)
    {
        referralData = referral;
    }

    public void setShareType(SHARE_TYPE share_type)
    {
        type = share_type;
    }

    public void setShowroom(Showroom showroom1)
    {
        showroom = showroom1;
    }

    public void setUserProfile(UserInfoDetails userinfodetails)
    {
        userInfo = userinfodetails;
    }

    public void share(String s)
    {
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            inviteFriends(type, s);
        } else
        {
            if (mode == SHARE_MODE.SHARE_MODE_LISTING)
            {
                shareListing(type, s);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_PARTY)
            {
                shareParty(type, s);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_CLOSET)
            {
                shareCloset(type, s);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
            {
                shareShowroom(type, s);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_BRAND)
            {
                shareBrand(type, s);
                return;
            }
        }
    }

    public void shareBrand(final SHARE_TYPE type, final String message)
    {
        if (brand == null)
        {
            return;
        } else
        {
            String s = getExternalShareIdString(type);
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            PMApi.shareBrandToExternalService(brand.canonical_name, s, message, new PMApiResponseHandler() {

                final ShareManager_Old this$0;
                final String val$message;
                final SHARE_TYPE val$type;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        trackShareEvent();
                        callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                        ((PMContainerActivity)context).popTopFragment();
                        return;
                    }
                    trackShareFailedEvent();
                    com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING;
                    switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_FACEBOOK;
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            handleFbShareAuthError(pmapiresponse, message);
                            return;
                        } else
                        {
                            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext));
                            return;
                        }

                    case 3: // '\003'
                        actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER;
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            ExtServiceConnectManager.getGlobalConnectManager().twUnlink();
                        }
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext));
                        return;

                    case 2: // '\002'
                        actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TUMBLR;
                        break;
                    }
                    if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                    {
                        ExtServiceConnectManager.getGlobalConnectManager().tmUnlink();
                    }
                    callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext));
                }

            
            {
                this$0 = ShareManager_Old.this;
                type = share_type;
                message = s;
                super();
            }
            });
            return;
        }
    }

    public void shareCloset(final SHARE_TYPE type, final String message)
    {
        if (userInfo == null)
        {
            return;
        } else
        {
            final String defaultMessage = getClosetShareMessageString(type);
            String s = getExternalShareIdString(type);
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            PMApi.shareCloset(userInfo.getPMUserId(), s, message, new PMApiResponseHandler() {

                final ShareManager_Old this$0;
                final String val$defaultMessage;
                final String val$message;
                final SHARE_TYPE val$type;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        trackShareEvent();
                        callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                        ((PMContainerActivity)context).popTopFragment();
                        return;
                    }
                    trackShareFailedEvent();
                    com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_CLOSET;
                    switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        Object obj = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_CLOSET_FACEBOOK;
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            ShareManager_Old sharemanager_old = ShareManager_Old.this;
                            if (message.length() == 0)
                            {
                                obj = defaultMessage;
                            } else
                            {
                                obj = message;
                            }
                            sharemanager_old.handleFbShareAuthError(pmapiresponse, ((String) (obj)));
                            return;
                        } else
                        {
                            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionErrorContext.ActionContext) (obj))));
                            return;
                        }

                    case 3: // '\003'
                        com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext1 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER;
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext1));
                        return;

                    case 2: // '\002'
                        com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext2 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TUMBLR;
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext2));
                        return;
                    }
                }

            
            {
                this$0 = ShareManager_Old.this;
                type = share_type;
                message = s;
                defaultMessage = s1;
                super();
            }
            });
            return;
        }
    }

    public void shareListing(final SHARE_TYPE type, final String message)
    {
        if (listingItem == null)
        {
            return;
        } else
        {
            final String defaultMessage = getListingShareMessageString(type);
            String s = getExternalShareIdString(type);
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            PMApi.shareListingToExternalService(listingItem.getIdAsString(), s, message, new PMApiResponseHandler() {

                final ShareManager_Old this$0;
                final String val$defaultMessage;
                final String val$message;
                final SHARE_TYPE val$type;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        trackShareEvent();
                        callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                        ((PMContainerActivity)context).popTopFragment();
                        return;
                    }
                    trackShareFailedEvent();
                    Object obj = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING;
                    switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            ShareManager_Old sharemanager_old = ShareManager_Old.this;
                            if (message.length() == 0)
                            {
                                obj = defaultMessage;
                            } else
                            {
                                obj = message;
                            }
                            sharemanager_old.handleFbShareAuthError(pmapiresponse, ((String) (obj)));
                            return;
                        } else
                        {
                            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionErrorContext.ActionContext) (obj))));
                            return;
                        }

                    case 3: // '\003'
                        obj = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER;
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            ExtServiceConnectManager.getGlobalConnectManager().twUnlink();
                        }
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionErrorContext.ActionContext) (obj))));
                        return;

                    case 2: // '\002'
                        obj = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TUMBLR;
                        break;
                    }
                    if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                    {
                        ExtServiceConnectManager.getGlobalConnectManager().tmUnlink();
                    }
                    callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionErrorContext.ActionContext) (obj))));
                }

            
            {
                this$0 = ShareManager_Old.this;
                type = share_type;
                message = s;
                defaultMessage = s1;
                super();
            }
            });
            return;
        }
    }

    public void shareParty(final SHARE_TYPE type, final String message)
    {
        if (event == null)
        {
            return;
        } else
        {
            final String defaultMessage = getPartyInviteMessageString(type);
            String s = getExternalShareIdString(type);
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            PMApi.shareEvent(event.getId(), s, message, new PMApiResponseHandler() {

                final ShareManager_Old this$0;
                final String val$defaultMessage;
                final String val$message;
                final SHARE_TYPE val$type;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        trackShareEvent();
                        callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                        ((PMContainerActivity)context).popTopFragment();
                        return;
                    }
                    trackShareFailedEvent();
                    com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING;
                    switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        Object obj = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_FACEBOOK;
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            ShareManager_Old sharemanager_old = ShareManager_Old.this;
                            if (message.length() == 0)
                            {
                                obj = defaultMessage;
                            } else
                            {
                                obj = message;
                            }
                            sharemanager_old.handleFbShareAuthError(pmapiresponse, ((String) (obj)));
                            return;
                        } else
                        {
                            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionErrorContext.ActionContext) (obj))));
                            return;
                        }

                    case 3: // '\003'
                        com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext1 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TWITTER;
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext1));
                        return;

                    case 2: // '\002'
                        com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext2 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING_TUMBLR;
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext2));
                        return;
                    }
                }

            
            {
                this$0 = ShareManager_Old.this;
                type = share_type;
                message = s;
                defaultMessage = s1;
                super();
            }
            });
            return;
        }
    }

    public void shareShowroom(final SHARE_TYPE type, final String message)
    {
        if (showroom == null)
        {
            return;
        } else
        {
            final String defaultMessage = getShowroomShareMessageString(type);
            String s = getExternalShareIdString(type);
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            PMApi.shareShowroom(showroom.getId(), s, message, new PMApiResponseHandler() {

                final ShareManager_Old this$0;
                final String val$defaultMessage;
                final String val$message;
                final SHARE_TYPE val$type;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        trackShareEvent();
                        callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                        ((PMContainerActivity)context).popTopFragment();
                        return;
                    }
                    trackShareFailedEvent();
                    com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_SHOWROOM;
                    switch (_cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_TYPE[type.ordinal()])
                    {
                    default:
                        return;

                    case 1: // '\001'
                        Object obj = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_SHOWROOM_FACEBOOK;
                        if (pmapiresponse.apiError.pmErrorType == PMErrorType.EXTERNAL_AUTH_ERROR)
                        {
                            ShareManager_Old sharemanager_old = ShareManager_Old.this;
                            if (message.length() == 0)
                            {
                                obj = defaultMessage;
                            } else
                            {
                                obj = message;
                            }
                            sharemanager_old.handleFbShareAuthError(pmapiresponse, ((String) (obj)));
                            return;
                        } else
                        {
                            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, ((com.poshmark.ui.model.ActionErrorContext.ActionContext) (obj))));
                            return;
                        }

                    case 3: // '\003'
                        com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext1 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_SHOWROOM_TWITTER;
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext1));
                        return;

                    case 2: // '\002'
                        com.poshmark.ui.model.ActionErrorContext.ActionContext actioncontext2 = com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_SHOWROOM_TUMBLR;
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, actioncontext2));
                        return;
                    }
                }

            
            {
                this$0 = ShareManager_Old.this;
                type = share_type;
                message = s;
                defaultMessage = s1;
                super();
            }
            });
            return;
        }
    }

    public void shareToEventWithId(final PartyEvent event)
    {
label0:
        {
            if (PMApplicationSession.GetPMSession().isLoggedIn())
            {
                if (event.isListingEligibleForParty(listingItem))
                {
                    break label0;
                }
                String s = String.format(new String(context.getString(0x7f060149)), new Object[] {
                    event.getTitle()
                });
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
                builder.setIcon(0x1080027);
                builder.setTitle(context.getString(0x7f0600d0));
                builder.setMessage(s);
                builder.setPositiveButton(context.getString(0x7f0602be), new android.content.DialogInterface.OnClickListener() {

                    final ShareManager_Old this$0;
                    final PartyEvent val$event;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        ((PMContainerActivity)callingFragment.getActivity()).launchFragment(null, com/poshmark/ui/fragments/PartyGuidelinesFragment, event);
                    }

            
            {
                this$0 = ShareManager_Old.this;
                event = partyevent;
                super();
            }
                });
                builder.setNegativeButton(callingFragment.getString(0x7f0601e1), null);
                builder.show();
            }
            return;
        }
        NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_PARTY);
        callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
        PMApi.shareListing(listingItem.getIdAsString(), null, event.getId(), null, new PMApiResponseHandler() {

            final ShareManager_Old this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_PARTY);
                callingFragment.hideProgressDialog();
                if (!pmapiresponse.hasError())
                {
                    callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                    pmapiresponse = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
                    Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_poshmark_poshparty", pmapiresponse);
                    return;
                } else
                {
                    String s1 = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
                    Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_failed", s1);
                    callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING, context.getString(0x7f0600fa)));
                    return;
                }
            }

            
            {
                this$0 = ShareManager_Old.this;
                super();
            }
        });
    }

    public void shareToFollowers()
    {
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_FOLLOWERS);
            callingFragment.showProgressDialogWithMessage(context.getString(0x7f06025d));
            PMApi.shareListing(listingItem.getIdAsString(), null, null, null, new PMApiResponseHandler() {

                final ShareManager_Old this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    NewRelicWrapper.stopCustomInteraction(NewRelicCustomInteractions.SHARE_LISTING_TO_FOLLOWERS);
                    callingFragment.hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        callingFragment.showAutoHideProgressDialogWithMessage(context.getString(0x7f060259), dismissListener);
                        pmapiresponse = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
                        Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_poshmark", pmapiresponse);
                        return;
                    } else
                    {
                        String s = (new StringBuilder()).append(listingItem.getIdAsString()).append("/").append(listingItem.getTitle()).toString();
                        Analytics.getInstance().trackEvent("share_listing_options_screen", "listing", "share_listing_failed", s);
                        callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SHARE_LISTING, context.getString(0x7f0600fa)));
                        return;
                    }
                }

            
            {
                this$0 = ShareManager_Old.this;
                super();
            }
            });
        }
    }

    public void showShareMessageEditor()
    {
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", getDefaultShareMessage());
        bundle.putString("PLACEHOLDER", getDefaultPlaceholderString());
        bundle.putString("ANALYTICS_PAGE_NAME", getMessageEditorScreenNameForAnalytics());
        ((PMActivity)context).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MessageEditorFragment, null, callingFragment, 12);
    }

    public void trackExternalShareOnPM()
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        Object obj3;
        Object obj4;
        s4 = null;
        s3 = null;
        s2 = null;
        obj3 = null;
        obj4 = null;
        obj2 = s4;
        obj = s2;
        s = obj3;
        s1 = obj4;
        obj1 = s3;
        _cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 84
    //                   1 190
    //                   2 576
    //                   3 961
    //                   4 990
    //                   5 383
    //                   6 98
    //                   7 769;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        s1 = obj4;
        s = obj3;
        obj = s2;
        obj2 = s4;
_L7:
        if (obj2 != null && obj != null && s != null && s1 != null)
        {
            obj1 = new HashMap();
            ((HashMap) (obj1)).put(PMApi.PMTrackingActionKey, obj2);
            ((HashMap) (obj1)).put(PMApi.PMTrackingMediumKey, obj);
            ((HashMap) (obj1)).put(PMApi.PMTrackingObjectIdKey, s);
            ((HashMap) (obj1)).put(PMApi.PMTrackingScreenKey, s1);
            obj = (new GsonBuilder()).create();
            if (obj instanceof Gson)
            {
                break; /* Loop/switch isn't completed */
            }
            ((Gson) (obj)).toJson(obj1, java/util/HashMap);
        }
        return;
_L2:
        obj1 = PMApi.PMTrackingActionShareListing;
        s3 = listingItem.getIdAsString();
        s4 = PMApi.PMTrackingScreenListingShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        {
            obj2 = obj1;
            obj = s2;
            s = s3;
            s1 = s4;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumFbDialog;
                obj2 = obj1;
                s = s3;
                s1 = s4;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj1 = PMApi.PMTrackingActionShareCloset;
        s3 = userInfo.getPMUserId();
        s4 = PMApi.PMTrackingScreenClosetShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        {
            obj2 = obj1;
            obj = s2;
            s = s3;
            s1 = s4;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumFbDialog;
                obj2 = obj1;
                s = s3;
                s1 = s4;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        obj1 = PMApi.PMTrackingActionShareShowroom;
        s3 = showroom.getId();
        s4 = PMApi.PMTrackingScreenShowroomShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        {
            obj2 = obj1;
            obj = s2;
            s = s3;
            s1 = s4;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumFbDialog;
                obj2 = obj1;
                s = s3;
                s1 = s4;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        obj1 = PMApi.PMTrackingActionShareReferralCode;
        s3 = PMApplicationSession.GetPMSession().getUserId();
        s4 = PMApi.PMTrackingScreenReferralCodeShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s = s3;
            s1 = s4;
        } else
        {
            obj2 = obj1;
            obj = s2;
            s = s3;
            s1 = s4;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumFbDialog;
                obj2 = obj1;
                s = s3;
                s1 = s4;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = PMApi.PMTrackingActionShareBrand;
        PMApplicationSession.GetPMSession().getUserId();
        obj = PMApi.PMTrackingScreenBrandShare;
        if (type != SHARE_TYPE.SMS_SHARE) goto _L10; else goto _L9
_L9:
        obj1 = PMApi.PMTrackingShareMediumSMS;
_L5:
        s2 = PMApi.PMTrackingActionShareBrand;
        s3 = PMApplicationSession.GetPMSession().getUserId();
        s4 = PMApi.PMTrackingScreenJustInBrandShare;
        if (type != SHARE_TYPE.SMS_SHARE)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = PMApi.PMTrackingShareMediumSMS;
        obj2 = s2;
        s = s3;
        s1 = s4;
        continue; /* Loop/switch isn't completed */
_L10:
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj1 = PMApi.PMTrackingShareMediumEmail;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj1 = PMApi.PMTrackingShareMediumInstagram;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj1 = PMApi.PMTrackingShareMediumPinterest;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj1 = PMApi.PMTrackingShareMediumFbMessenger;
        } else
        {
            obj1 = s3;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj1 = PMApi.PMTrackingShareMediumFbDialog;
            }
        }
        if (true) goto _L5; else goto _L11
_L11:
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = s2;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = s2;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = s2;
            s = s3;
            s1 = s4;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = s2;
            s = s3;
            s1 = s4;
        } else
        {
            obj2 = s2;
            obj = obj1;
            s = s3;
            s1 = s4;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumFbDialog;
                obj2 = s2;
                s = s3;
                s1 = s4;
            }
        }
        if (true) goto _L7; else goto _L12
_L12:
        GsonInstrumentation.toJson((Gson)obj, obj1, java/util/HashMap);
        return;
    }

    public void trackShareFragmentDisplayed()
    {
        HashMap hashmap = new HashMap();
        _cls15..SwitchMap.com.poshmark.utils.ShareManager_Old.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 60
    //                   1 90
    //                   2 189
    //                   3 222
    //                   4 60
    //                   5 156
    //                   6 123
    //                   7 255;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7
_L1:
        if (!hashmap.isEmpty())
        {
            hashmap.put("signup_segment", PMApplicationSession.GetPMSession().getUserABSegment());
            PMApi.getViewTrackingInfo(hashmap);
        }
        return;
_L2:
        hashmap.put("nm", PMApi.PMTrackingScreenListingShare);
        hashmap.put("oid", listingItem.getIdAsString());
        continue; /* Loop/switch isn't completed */
_L6:
        hashmap.put("nm", PMApi.PMTrackingScreenPartyShare);
        hashmap.put("oid", event.getId());
        continue; /* Loop/switch isn't completed */
_L5:
        hashmap.put("nm", PMApi.PMTrackingScreenClosetShare);
        hashmap.put("oid", userInfo.getPMUserId());
        continue; /* Loop/switch isn't completed */
_L3:
        hashmap.put("nm", PMApi.PMTrackingScreenShowroomShare);
        hashmap.put("oid", showroom.getId());
        continue; /* Loop/switch isn't completed */
_L4:
        hashmap.put("nm", PMApi.PMTrackingScreenBrandShare);
        hashmap.put("oid", brand.canonical_name);
        continue; /* Loop/switch isn't completed */
_L7:
        hashmap.put("nm", PMApi.PMTrackingScreenReferralCodeShare);
        hashmap.put("oid", PMApplicationSession.GetPMSession().getUserId());
        if (true) goto _L1; else goto _L8
_L8:
    }



/*
    static BrandShareMessages access$102(ShareManager_Old sharemanager_old, BrandShareMessages brandsharemessages)
    {
        sharemanager_old.brandShareMessages = brandsharemessages;
        return brandsharemessages;
    }

*/





/*
    static String access$502(ShareManager_Old sharemanager_old, String s)
    {
        sharemanager_old.closetShortURL = s;
        return s;
    }

*/




}
