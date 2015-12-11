// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.PartyEvent;

public class PartyShareMessages
{

    public PartyShareMessages()
    {
    }

    public static String getBody(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (partyevent.isPastEvent())
        {
            return String.format(PMApplication.getContext().getString(0x7f0601f7), new Object[] {
                partyevent.getTitle(), partyevent.getURL(), "https://www.poshmark.com"
            });
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f0601f2), new Object[] {
                partyevent.getTitle(), partyevent.getURL(), "https://www.poshmark.com"
            });
        }
    }

    public static String getDescription(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return partyevent.getDescription();
    }

    public static String getImageUrl(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return partyevent.getCovershot();
    }

    public static String getMessage(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        Context context = PMApplication.getContext();
        String s = partyevent.getTitle();
        String s1 = partyevent.getURL();
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
        case 4: // '\004'
        case 7: // '\007'
        default:
            return "";

        case 2: // '\002'
            if (partyevent.isPastEvent())
            {
                return String.format(context.getString(0x7f0601fb), new Object[] {
                    s, s1
                });
            }
            if (partyevent.isHappeningNow())
            {
                return String.format(context.getString(0x7f06009f), new Object[] {
                    s, s1
                });
            } else
            {
                return String.format(context.getString(0x7f0602b2), new Object[] {
                    s, s1
                });
            }

        case 3: // '\003'
            if (partyevent.isHappeningNow())
            {
                return String.format(context.getString(0x7f06009e), new Object[] {
                    s, s1
                });
            }
            if (partyevent.isPastEvent())
            {
                return String.format(context.getString(0x7f0601fa), new Object[] {
                    s, s1
                });
            } else
            {
                return String.format(context.getString(0x7f0602b1), new Object[] {
                    s, s1
                });
            }

        case 5: // '\005'
            if (partyevent.isHappeningNow())
            {
                return String.format(context.getString(0x7f06009d), new Object[] {
                    s, s1
                });
            }
            if (partyevent.isPastEvent())
            {
                return String.format(context.getString(0x7f0601f9), new Object[] {
                    s, s1
                });
            } else
            {
                return String.format(context.getString(0x7f0602b0), new Object[] {
                    s, s1
                });
            }

        case 6: // '\006'
            return getBody(partyevent, share_type);
        }
    }

    public static String getPlaceHolder(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (partyevent.isPastEvent())
        {
            return PMApplication.getContext().getString(0x7f0601f6);
        }
        if (partyevent.isHappeningNow())
        {
            return PMApplication.getContext().getString(0x7f06009c);
        } else
        {
            return PMApplication.getContext().getString(0x7f0602af);
        }
    }

    public static String getSubject(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (partyevent.isPastEvent())
        {
            return String.format(PMApplication.getContext().getString(0x7f0601f8), new Object[] {
                partyevent.getTitle()
            });
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f0601f3), new Object[] {
                partyevent.getTitle()
            });
        }
    }

    public static String getTitle(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return partyevent.getTitle();
    }

    public static String getUrl(PartyEvent partyevent, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return partyevent.getURL();
    }
}
