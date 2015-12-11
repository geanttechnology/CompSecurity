// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.Referral;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.http.api.PMApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.MessageEditorFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.sharing.EmailShareStateMachine;
import com.poshmark.utils.sharing.FbDialogStateMachine;
import com.poshmark.utils.sharing.FbMessengerStateMachine;
import com.poshmark.utils.sharing.FbServerStateMachine;
import com.poshmark.utils.sharing.PMShareContent;
import com.poshmark.utils.sharing.PinterestShareStateMachine;
import com.poshmark.utils.sharing.SMSShareStateMachine;
import com.poshmark.utils.sharing.ServerShareMessages;
import com.poshmark.utils.sharing.ShareToFollowersStateMachine;
import com.poshmark.utils.sharing.ShareToPartyStateMachine;
import com.poshmark.utils.sharing.TumblrServerShareStateMachine;
import com.poshmark.utils.sharing.TwitterServerShareStateMachine;
import java.util.HashMap;
import java.util.Map;

public class ShareManager
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
            return (SHARE_MODE)Enum.valueOf(com/poshmark/utils/ShareManager$SHARE_MODE, s);
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
        public static final SHARE_TYPE DEFAULT;
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
            return (SHARE_TYPE)Enum.valueOf(com/poshmark/utils/ShareManager$SHARE_TYPE, s);
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
            DEFAULT = new SHARE_TYPE("DEFAULT", 11);
            $VALUES = (new SHARE_TYPE[] {
                FB_SHARE, TW_SHARE, TM_SHARE, INSTAGRAM_SHARE, PINTEREST_SHARE, SMS_SHARE, FB_MESSENGER_SHARE, FB_DIALOG_SHARE, EMAIL_SHARE, EMAIL_SHARE_BODY, 
                EMAIL_SHARE_SUBJECT, DEFAULT
            });
        }

        private SHARE_TYPE(String s, int i)
        {
            super(s, i);
        }
    }

    private static class SingletonHolder
    {

        public static final ShareManager INSTANCE = new ShareManager();


        private SingletonHolder()
        {
        }
    }


    public static String EXTERNAL_SHARE_STATE_CANCELLED = "f";
    public static String EXTERNAL_SHARE_STATE_INITIALED = "i";
    public static String EXTERNAL_SHARE_STATE_SUCCESS = "c";
    PMFragment callingFragment;
    PMShareContent content;
    Context context;
    SHARE_MODE mode;
    private SHARE_TYPE type;

    private ShareManager()
    {
        content = new PMShareContent();
    }


    public static ShareManager getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private String getMessageEditorScreenNameForAnalytics()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];
            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[SHARE_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.FB_DIALOG_SHARE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.FB_SHARE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.TM_SHARE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.TW_SHARE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.EMAIL_SHARE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.PINTEREST_SHARE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[SHARE_TYPE.SMS_SHARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[SHARE_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_LISTING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_PARTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_BRAND.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[SHARE_MODE.SHARE_MODE_BRAND_JUSTIN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[type.ordinal()])
        {
        case 3: // '\003'
        default:
            return "";

        case 2: // '\002'
            return "facebook_share_message_screen";

        case 4: // '\004'
            return "tumblr_share_message_screen";

        case 5: // '\005'
            return "twitter_share_message_screen";
        }
    }

    public void deInit()
    {
        callingFragment = null;
        context = null;
        content.reset();
    }

    public void doEmailShare()
    {
        (new EmailShareStateMachine(this)).init();
    }

    public void doFBMessengerShare()
    {
        (new FbMessengerStateMachine(this)).init();
    }

    public void doFbShareViaServer()
    {
        (new FbServerStateMachine(this)).init();
    }

    public void doFbShareViaShareDialog()
    {
        (new FbDialogStateMachine(this)).init();
    }

    public void doPinterestShare()
    {
        (new PinterestShareStateMachine(this)).init();
    }

    public void doSMSShare()
    {
        (new SMSShareStateMachine(this)).init();
    }

    public void doTumblrShare()
    {
        (new TumblrServerShareStateMachine(this)).init();
    }

    public void doTwitterShare()
    {
        (new TwitterServerShareStateMachine(this)).init();
    }

    public String getExternalShareCode()
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "fbd";

        case 2: // '\002'
            return "fb";

        case 3: // '\003'
            return "fbm";

        case 4: // '\004'
            return "tm";

        case 5: // '\005'
            return "tw";

        case 6: // '\006'
            return "email";

        case 7: // '\007'
            return "pnd";

        case 8: // '\b'
            return "sms";
        }
    }

    public PMFragment getFragment()
    {
        return callingFragment;
    }

    public Referral getReferralData()
    {
        return content.getReferralData();
    }

    public PMShareContent getShareContent()
    {
        return content;
    }

    public SHARE_MODE getShareMode()
    {
        return mode;
    }

    public SHARE_TYPE getShareType()
    {
        return type;
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

    public void getUserMessage()
    {
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", content.getMessage());
        bundle.putString("PLACEHOLDER", content.getPlaceHolderString());
        bundle.putString("ANALYTICS_PAGE_NAME", getMessageEditorScreenNameForAnalytics());
        PMActivity pmactivity = (PMActivity)context;
        if (pmactivity.isActivityInForeground())
        {
            pmactivity.launchFragmentForResult(bundle, com/poshmark/ui/fragments/MessageEditorFragment, null, callingFragment, 12);
        }
    }

    public void init(Context context1, SHARE_MODE share_mode, PMFragment pmfragment)
    {
        context = context1;
        mode = share_mode;
        callingFragment = pmfragment;
        content.setShareMode(share_mode);
    }

    public void setBrand(Brand brand)
    {
        content.setBrand(brand);
    }

    public void setListingItem(ListingSocial listingsocial)
    {
        content.setListing(listingsocial);
    }

    public void setPartyEvent(PartyEvent partyevent)
    {
        content.setParty(partyevent);
    }

    public void setReferralData(Referral referral)
    {
        content.setReferralData(referral);
    }

    public void setShareContent(ServerShareMessages serversharemessages)
    {
        content.setServerShareContent(serversharemessages);
    }

    public void setShareType(SHARE_TYPE share_type)
    {
        type = share_type;
        content.setShareType(share_type);
    }

    public void setShowroom(Showroom showroom)
    {
        content.setShowroom(showroom);
    }

    public void setUserProfile(UserInfoDetails userinfodetails)
    {
        content.setUser(userinfodetails);
    }

    public void shareToEventWithId()
    {
        (new ShareToPartyStateMachine(this)).init();
    }

    public void shareToFollowers()
    {
        (new ShareToFollowersStateMachine(this)).init();
    }

    public void trackExternalShareOnPM(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s1;
        String s2;
        String s3;
        String s4;
        Object obj3;
        Object obj4;
        Object obj5;
        obj3 = null;
        s4 = null;
        s3 = null;
        obj4 = null;
        obj5 = null;
        obj2 = obj3;
        obj = s3;
        s1 = obj4;
        s2 = obj5;
        obj1 = s4;
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 88
    //                   1 202
    //                   2 103
    //                   3 433
    //                   4 636
    //                   5 1094
    //                   6 867
    //                   7 1123;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_1123;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        s2 = obj5;
        s1 = obj4;
        obj = s3;
        obj2 = obj3;
_L9:
        if (obj2 != null && obj != null && s1 != null && s2 != null)
        {
            obj1 = new HashMap();
            ((HashMap) (obj1)).put(PMApi.PMTrackingActionKey, obj2);
            ((HashMap) (obj1)).put(PMApi.PMTrackingMediumKey, obj);
            ((HashMap) (obj1)).put(PMApi.PMTrackingObjectIdKey, s1);
            ((HashMap) (obj1)).put(PMApi.PMTrackingScreenKey, s2);
            obj = (new GsonBuilder()).create();
            String s5;
            if (!(obj instanceof Gson))
            {
                obj = ((Gson) (obj)).toJson(obj1, java/util/HashMap);
            } else
            {
                obj = GsonInstrumentation.toJson((Gson)obj, obj1, java/util/HashMap);
            }
            PMApi.trackExternalShare(((String) (obj)), s);
        }
        return;
_L2:
        obj1 = PMApi.PMTrackingActionShareListing;
        s4 = content.getListing().getIdAsString();
        s5 = PMApi.PMTrackingScreenListingShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_DIALOG_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbDialog;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        {
            obj2 = obj1;
            obj = s3;
            s1 = s4;
            s2 = s5;
            if (type == SHARE_TYPE.INSTAGRAM_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumInstagram;
                obj2 = obj1;
                s1 = s4;
                s2 = s5;
            }
        }
          goto _L9
_L4:
        obj1 = PMApi.PMTrackingActionShareCloset;
        s4 = content.getUser().getPMUserId();
        s5 = PMApi.PMTrackingScreenClosetShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        {
            obj2 = obj1;
            obj = s3;
            s1 = s4;
            s2 = s5;
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumFbDialog;
                obj2 = obj1;
                s1 = s4;
                s2 = s5;
            }
        }
          goto _L9
_L5:
        obj1 = PMApi.PMTrackingActionShareShowroom;
        s4 = content.getShowroom().getId();
        s5 = PMApi.PMTrackingScreenShowroomShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_DIALOG_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbDialog;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        {
            obj2 = obj1;
            obj = s3;
            s1 = s4;
            s2 = s5;
            if (type == SHARE_TYPE.INSTAGRAM_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumInstagram;
                obj2 = obj1;
                s1 = s4;
                s2 = s5;
            }
        }
          goto _L9
_L7:
        obj1 = PMApi.PMTrackingActionShareReferralCode;
        s4 = PMApplicationSession.GetPMSession().getUserId();
        s5 = PMApi.PMTrackingScreenReferralCodeShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_DIALOG_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbDialog;
            obj2 = obj1;
            s1 = s4;
            s2 = s5;
        } else
        {
            obj2 = obj1;
            obj = s3;
            s1 = s4;
            s2 = s5;
            if (type == SHARE_TYPE.INSTAGRAM_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumInstagram;
                obj2 = obj1;
                s1 = s4;
                s2 = s5;
            }
        }
          goto _L9
_L6:
        obj = PMApi.PMTrackingActionShareBrand;
        PMApplicationSession.GetPMSession().getUserId();
        obj = PMApi.PMTrackingScreenBrandShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj1 = PMApi.PMTrackingShareMediumSMS;
        } else
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
        if (type == SHARE_TYPE.FB_DIALOG_SHARE)
        {
            obj1 = PMApi.PMTrackingShareMediumFbDialog;
        } else
        {
            obj1 = s4;
            if (type == SHARE_TYPE.INSTAGRAM_SHARE)
            {
                obj1 = PMApi.PMTrackingShareMediumInstagram;
            }
        }
        s3 = PMApi.PMTrackingActionShareBrand;
        s4 = PMApplicationSession.GetPMSession().getUserId();
        s5 = PMApi.PMTrackingScreenJustInBrandShare;
        if (type == SHARE_TYPE.SMS_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumSMS;
            obj2 = s3;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.EMAIL_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumEmail;
            obj2 = s3;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.INSTAGRAM_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumInstagram;
            obj2 = s3;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.PINTEREST_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumPinterest;
            obj2 = s3;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbMessenger;
            obj2 = s3;
            s1 = s4;
            s2 = s5;
        } else
        if (type == SHARE_TYPE.FB_DIALOG_SHARE)
        {
            obj = PMApi.PMTrackingShareMediumFbDialog;
            obj2 = s3;
            s1 = s4;
            s2 = s5;
        } else
        {
            obj2 = s3;
            obj = obj1;
            s1 = s4;
            s2 = s5;
            if (type == SHARE_TYPE.INSTAGRAM_SHARE)
            {
                obj = PMApi.PMTrackingShareMediumInstagram;
                obj2 = s3;
                s1 = s4;
                s2 = s5;
            }
        }
          goto _L9
    }

    public void trackShareEvent()
    {
        String s;
        String s1;
        String s2;
        s1 = null;
        s2 = null;
        s = null;
        if (mode != SHARE_MODE.SHARE_MODE_LISTING) goto _L2; else goto _L1
_L1:
        s1 = (new StringBuilder()).append(content.getListing().getIdAsString()).append("/").append(content.getListing().getTitle()).toString();
        s2 = "share_listing_options_screen";
        s = "listing";
_L4:
        if (s1 != null)
        {
            if (type == SHARE_TYPE.FB_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_facebook", s1);
            }
            if (type == SHARE_TYPE.TW_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_twitter", s1);
            }
            if (type == SHARE_TYPE.TM_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_tumblr", s1);
            }
            if (type == SHARE_TYPE.PINTEREST_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_pinterest", s1);
            }
            if (type == SHARE_TYPE.EMAIL_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_email", s1);
            }
            if (type == SHARE_TYPE.SMS_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_sms", s1);
            }
            if (type == SHARE_TYPE.FB_MESSENGER_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_fbmessenger", s1);
            }
            if (type == SHARE_TYPE.FB_DIALOG_SHARE)
            {
                Analytics.getInstance().trackEvent(s2, s, "share_listing_fb_dialog", s1);
            }
        }
        return;
_L2:
        if (mode == SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            s1 = (new StringBuilder()).append(PMApplicationSession.GetPMSession().getUserId()).append("/").append(PMApplicationSession.GetPMSession().getUserName()).toString();
            s2 = "referral_screen";
            s = "user";
        } else
        if (mode == SHARE_MODE.SHARE_MODE_PARTY)
        {
            s1 = (new StringBuilder()).append(content.getParty().getId()).append("/").append(content.getParty().getTitle()).toString();
            s2 = "share_party_options_screen";
            s = "party";
        } else
        if (mode == SHARE_MODE.SHARE_MODE_BRAND || mode == SHARE_MODE.SHARE_MODE_BRAND_JUSTIN)
        {
            s1 = content.getBrand().canonical_name;
            s2 = "share_brand_options_screen";
            s = "brand";
        } else
        if (mode == SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            s1 = content.getShowroom().getId();
            s2 = "share_showroom_options_screen";
            s = "showroom";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void trackShareFailedEvent()
    {
        if (mode == SHARE_MODE.SHARE_MODE_LISTING)
        {
            String s = (new StringBuilder()).append(content.getListing().getIdAsString()).append("/").append(content.getListing().getTitle()).toString();
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
                String s2 = (new StringBuilder()).append(content.getParty().getId()).append("/").append(content.getParty().getTitle()).toString();
                Analytics.getInstance().trackEvent("share_party_options_screen", "party", "share_party_failed", s2);
                return;
            }
            if (mode == SHARE_MODE.SHARE_MODE_BRAND || mode == SHARE_MODE.SHARE_MODE_BRAND_JUSTIN)
            {
                String s3 = content.getBrand().canonical_name;
                Analytics.getInstance().trackEvent("share_brand_options_screen", "brand", "share_brand_failed", s3);
                return;
            }
        }
    }

    public void trackShareFragmentDisplayed()
    {
        HashMap hashmap = new HashMap();
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 6: default 56
    //                   1 86
    //                   2 122
    //                   3 158
    //                   4 194
    //                   5 230
    //                   6 266;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        if (!hashmap.isEmpty())
        {
            hashmap.put("signup_segment", PMApplicationSession.GetPMSession().getUserABSegment());
            PMApi.getViewTrackingInfo(hashmap);
        }
        return;
_L2:
        hashmap.put("nm", PMApi.PMTrackingScreenListingShare);
        hashmap.put("oid", content.getListing().getIdAsString());
        continue; /* Loop/switch isn't completed */
_L3:
        hashmap.put("nm", PMApi.PMTrackingScreenPartyShare);
        hashmap.put("oid", content.getParty().getId());
        continue; /* Loop/switch isn't completed */
_L4:
        hashmap.put("nm", PMApi.PMTrackingScreenClosetShare);
        hashmap.put("oid", content.getUser().getPMUserId());
        continue; /* Loop/switch isn't completed */
_L5:
        hashmap.put("nm", PMApi.PMTrackingScreenShowroomShare);
        hashmap.put("oid", content.getShowroom().getId());
        continue; /* Loop/switch isn't completed */
_L6:
        hashmap.put("nm", PMApi.PMTrackingScreenBrandShare);
        hashmap.put("oid", content.getBrand().canonical_name);
        continue; /* Loop/switch isn't completed */
_L7:
        hashmap.put("nm", PMApi.PMTrackingScreenReferralCodeShare);
        hashmap.put("oid", PMApplicationSession.GetPMSession().getUserId());
        if (true) goto _L1; else goto _L8
_L8:
    }

}
