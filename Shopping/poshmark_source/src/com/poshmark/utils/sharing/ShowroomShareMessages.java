// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.inner_models.CoverShot;

public class ShowroomShareMessages
{

    public ShowroomShareMessages()
    {
    }

    public static String getBody(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return String.format(PMApplication.getContext().getString(0x7f06026f), new Object[] {
            showroom.getCoverShot().url_small, showroom.getWebURL(), showroom.getName(), PMApplicationSession.GetPMSession().getFirstName()
        });
    }

    public static String getDescription(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
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
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TW_SHARE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TM_SHARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.PINTEREST_SHARE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.SMS_SHARE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE_BODY.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE_SUBJECT.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        default:
            return "";

        case 1: // '\001'
            return PMApplication.getContext().getString(0x7f06010c);

        case 4: // '\004'
            return PMApplication.getContext().getString(0x7f060209, new Object[] {
                showroom.getName()
            });

        case 7: // '\007'
            return PMApplication.getContext().getString(0x7f06010c);
        }
    }

    public static String getImageUrl(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return showroom.getCoverShot().url_small;
    }

    public static String getMessage(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        default:
            return "";

        case 8: // '\b'
            return "";

        case 3: // '\003'
            return String.format(PMApplication.getContext().getString(0x7f060273), new Object[] {
                showroom.getName(), getUrl(showroom, share_type)
            });

        case 2: // '\002'
            return String.format(PMApplication.getContext().getString(0x7f060274), new Object[] {
                showroom.getName(), getUrl(showroom, share_type)
            });

        case 5: // '\005'
            return String.format(PMApplication.getContext().getString(0x7f060272), new Object[] {
                showroom.getName(), getUrl(showroom, share_type)
            });

        case 7: // '\007'
            return getUrl(showroom, share_type);

        case 9: // '\t'
            return getBody(showroom, share_type);

        case 10: // '\n'
            return String.format(PMApplication.getContext().getString(0x7f060270), new Object[] {
                PMApplicationSession.GetPMSession().getFullName(), showroom.getName()
            });

        case 4: // '\004'
            return "";

        case 6: // '\006'
            return getSubject(showroom, share_type);
        }
    }

    public static String getPlaceHolder(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
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

        case 8: // '\b'
            return PMApplication.getContext().getString(0x7f060271);
        }
    }

    public static String getSubject(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return String.format(PMApplication.getContext().getString(0x7f060270), new Object[] {
            PMApplicationSession.GetPMSession().getFullName(), showroom.getName()
        });
    }

    public static String getTitle(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return showroom.getName();
    }

    public static String getUrl(Showroom showroom, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return showroom.getShortURL();
    }
}
