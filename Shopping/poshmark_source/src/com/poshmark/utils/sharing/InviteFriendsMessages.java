// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.Referral;
import com.poshmark.utils.CurrencyUtils;

public class InviteFriendsMessages
{

    private static final String bitlyUrl = "http://bit.ly/GetPosh-FB";

    public InviteFriendsMessages()
    {
    }

    public static String getBody(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        String s = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(referral.getReferredIncentiveString()).toString();
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[com.poshmark.utils.ShareManager.SHARE_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_DIALOG_SHARE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TW_SHARE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TM_SHARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.PINTEREST_SHARE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.SMS_SHARE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 7: // '\007'
        default:
            return "";

        case 5: // '\005'
            return String.format(PMApplication.getContext().getString(0x7f060159), new Object[] {
                referral.getId(), s
            });

        case 6: // '\006'
            return referral.getDefaultMessages().email_body;
        }
    }

    public static String getDescription(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return "";
        }
    }

    public static String getImageUrl(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return "";
        }
    }

    public static String getMessage(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        String s1 = "";
        if (referral == null) goto _L2; else goto _L1
_L1:
        String s;
        com.poshmark.data_model.models.Referral.DefaultMessages defaultmessages;
        defaultmessages = referral.getDefaultMessages();
        s = s1;
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()];
        JVM INSTR tableswitch 1 7: default 64
    //                   1 68
    //                   2 77
    //                   3 86
    //                   4 66
    //                   5 95
    //                   6 104
    //                   7 115;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L7:
        break; /* Loop/switch isn't completed */
_L3:
        s = s1;
_L11:
        return s;
_L4:
        s = defaultmessages.fb_desc;
        continue; /* Loop/switch isn't completed */
_L5:
        s = defaultmessages.tw_share;
        continue; /* Loop/switch isn't completed */
_L6:
        s = defaultmessages.tm_share;
        continue; /* Loop/switch isn't completed */
_L8:
        s = defaultmessages.sms;
        continue; /* Loop/switch isn't completed */
_L9:
        s = referral.getDefaultMessages().email_body;
        continue; /* Loop/switch isn't completed */
_L10:
        s = defaultmessages.sms;
        if (true) goto _L11; else goto _L2
_L2:
        share_type = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(referral.getReferredIncentiveString()).toString();
        return String.format(PMApplication.getContext().getString(0x7f060159), new Object[] {
            referral.getId(), share_type
        });
    }

    public static String getPlaceHolder(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        share_type = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(referral.getReferredIncentiveString()).toString();
        return String.format(PMApplication.getContext().getString(0x7f060159), new Object[] {
            referral.getId(), share_type
        });
    }

    public static String getSubject(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return referral.getDefaultMessages().email_subject;
    }

    public static String getTitle(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return "";
        }
    }

    public static String getUrl(Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (referral != null)
        {
            referral = referral.getDefaultMessages();
            if (referral != null && ((com.poshmark.data_model.models.Referral.DefaultMessages) (referral)).fb_share_url != null)
            {
                return ((com.poshmark.data_model.models.Referral.DefaultMessages) (referral)).fb_share_url;
            } else
            {
                return "http://bit.ly/GetPosh-FB";
            }
        } else
        {
            return "https://www.poshmark.com/getapp";
        }
    }
}
