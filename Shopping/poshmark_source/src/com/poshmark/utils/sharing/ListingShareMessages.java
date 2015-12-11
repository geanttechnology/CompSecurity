// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.MetaItem;

public class ListingShareMessages
{

    public ListingShareMessages()
    {
    }

    public static String getBody(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (Boolean.valueOf(isListingOwner(listingsummary)).booleanValue())
        {
            return String.format("<div><p>%1$s</p><p>%2$s</p><div style='clear:both'></div><a href=%3$s><img src='%4$s' width='100px' style='margin-right:10px;float:left;'></a><p style='float:left;padding:0;margin:0;'>%5$s - <a href=%3$s>%3$s</a><br/><br/>Price: %6$s <br/><br/>Size: %7$s</p></div><div style='clear:both'></div><p>-%8$s</p>", new Object[] {
                PMApplication.getContext().getString(0x7f06013e), PMApplication.getContext().getString(0x7f060170), getUrl(listingsummary, share_type), listingsummary.getSmallCovershot(), listingsummary.getTitle(), listingsummary.getPriceString(), listingsummary.getSize(), PMApplicationSession.GetPMSession().getUserName()
            });
        } else
        {
            return String.format("<div><p>%1$s</p><p>%2$s</p><div style='clear:both'></div><a href=%3$s><img src='%4$s' width='100px' style='margin-right:10px;float:left;'></a><p style='float:left;padding:0;margin:0;'>%5$s - <a href=%3$s>%3$s</a><br/><br/>Price: %6$s <br/><br/>Size: %7$s</p></div><div style='clear:both'></div><p>-%8$s</p>", new Object[] {
                PMApplication.getContext().getString(0x7f06013e), PMApplication.getContext().getString(0x7f06016f), getUrl(listingsummary, share_type), listingsummary.getSmallCovershot(), listingsummary.getTitle(), listingsummary.getPriceString(), listingsummary.getSize(), PMApplicationSession.GetPMSession().getUserName()
            });
        }
    }

    public static String getDescription(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
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
        case 2: // '\002'
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        default:
            return "";

        case 1: // '\001'
            return listingsummary.getDescription();

        case 4: // '\004'
            if (isListingOwner(listingsummary))
            {
                if (listingsummary.getBrand() != null && listingsummary.getBrand().length() > 0)
                {
                    return String.format(PMApplication.getContext().getString(0x7f060207), new Object[] {
                        listingsummary.getTitle(), listingsummary.getTitle(), PMApplicationSession.GetPMSession().getUserName(), listingsummary.getBrand(), listingsummary.getCategory().getDisplay()
                    });
                } else
                {
                    return String.format(PMApplication.getContext().getString(0x7f060208), new Object[] {
                        listingsummary.getTitle(), listingsummary.getTitle(), PMApplicationSession.GetPMSession().getUserName(), listingsummary.getCategory().getDisplay()
                    });
                }
            }
            if (listingsummary.getBrand() != null && listingsummary.getBrand().length() > 0)
            {
                return String.format(PMApplication.getContext().getString(0x7f060205), new Object[] {
                    listingsummary.getTitle(), listingsummary.getTitle(), listingsummary.getBrand(), listingsummary.getCategory().getDisplay()
                });
            } else
            {
                return String.format(PMApplication.getContext().getString(0x7f060206), new Object[] {
                    listingsummary.getTitle(), listingsummary.getTitle(), listingsummary.getCategory().getDisplay()
                });
            }

        case 7: // '\007'
            return listingsummary.getDescription();
        }
    }

    public static String getImageUrl(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return listingsummary.getCovershot();
    }

    public static String getMessage(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        String s = getUrl(listingsummary, share_type);
        Boolean boolean1 = Boolean.valueOf(isListingOwner(listingsummary));
        String s1 = listingsummary.getTitle();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 1: // '\001'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return "";

        case 3: // '\003'
            if (boolean1.booleanValue())
            {
                return String.format(PMApplication.getContext().getString(0x7f06018a), new Object[] {
                    s1, s
                });
            } else
            {
                return String.format(PMApplication.getContext().getString(0x7f060189), new Object[] {
                    s1, s
                });
            }

        case 2: // '\002'
            if (boolean1.booleanValue())
            {
                return String.format(PMApplication.getContext().getString(0x7f06018c), new Object[] {
                    s1, listingsummary.getShortURL()
                });
            } else
            {
                return String.format(PMApplication.getContext().getString(0x7f06018b), new Object[] {
                    s1, listingsummary.getShortURL()
                });
            }

        case 5: // '\005'
            break;
        }
        if (boolean1.booleanValue())
        {
            return String.format(PMApplication.getContext().getString(0x7f060183), new Object[] {
                s1, s
            });
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f060182), new Object[] {
                s1, s
            });
        }
    }

    public static String getPlaceHolder(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
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
            break;
        }
        if (isListingOwner(listingsummary))
        {
            return PMApplication.getContext().getString(0x7f060174);
        } else
        {
            return PMApplication.getContext().getString(0x7f060173);
        }
    }

    public static String getSubject(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (Boolean.valueOf(isListingOwner(listingsummary)).booleanValue())
        {
            return String.format(PMApplication.getContext().getString(0x7f060172), new Object[] {
                listingsummary.getTitle()
            });
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f060171), new Object[] {
                listingsummary.getTitle()
            });
        }
    }

    public static String getTitle(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return listingsummary.getTitle();
    }

    public static String getUrl(ListingSummary listingsummary, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return (new StringBuilder()).append("https://www.poshmark.com/listings/").append(listingsummary.getIdAsString()).toString();
    }

    public static boolean isListingOwner(ListingSummary listingsummary)
    {
        return PMApplicationSession.GetPMSession().getUserId().equals(listingsummary.getUserId());
    }
}
