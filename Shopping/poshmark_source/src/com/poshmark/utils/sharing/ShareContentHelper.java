// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;

public class ShareContentHelper
{

    public ShareContentHelper()
    {
    }

    public static String getShareEndPoint(String s, String s1, com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        String s2 = new String();
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[com.poshmark.utils.ShareManager.SHARE_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[share_mode.ordinal()])
        {
        default:
            return s2;

        case 1: // '\001'
            return (new StringBuilder()).append("/api/posts/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 2: // '\002'
            return (new StringBuilder()).append("/api/users/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 3: // '\003'
            return (new StringBuilder()).append("/api/events/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 4: // '\004'
            return (new StringBuilder()).append("api/collections/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 5: // '\005'
            return (new StringBuilder()).append("/api/users/").append(s).append("/referral_invite_friend?").append("ext_service_ids=").append(s1).toString();

        case 6: // '\006'
            return (new StringBuilder()).append("/api/brands/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();
        }
    }

    public static String getSharingErrorString(com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        String s = new String();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[share_mode.ordinal()])
        {
        default:
            return s;

        case 1: // '\001'
            return PMApplication.getContext().getString(0x7f0600fa);

        case 2: // '\002'
            return PMApplication.getContext().getString(0x7f0600f8);

        case 3: // '\003'
            return PMApplication.getContext().getString(0x7f0600fb);

        case 4: // '\004'
            return PMApplication.getContext().getString(0x7f0600fc);

        case 5: // '\005'
            return PMApplication.getContext().getString(0x7f0600f9);

        case 6: // '\006'
            return PMApplication.getContext().getString(0x7f0600f7);
        }
    }

    public static String prepareGetShareMessagesEndPoint(String s, String s1, com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        String s2 = new String();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[share_mode.ordinal()])
        {
        default:
            return s2;

        case 1: // '\001'
            return (new StringBuilder()).append("/api/posts/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 2: // '\002'
            return (new StringBuilder()).append("/api/users/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 3: // '\003'
            return (new StringBuilder()).append("/api/events/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 4: // '\004'
            return (new StringBuilder()).append("/api/collections/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();

        case 5: // '\005'
            return (new StringBuilder()).append("/api/users/").append(s).append("/referral_invite_content?").append("ext_service_ids=").append(s1).toString();

        case 6: // '\006'
            return (new StringBuilder()).append("/api/brands/").append(s).append("/ext_share_content?").append("ext_service_ids=").append(s1).toString();
        }
    }
}
