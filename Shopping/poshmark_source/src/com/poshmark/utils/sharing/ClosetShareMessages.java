// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.Referral;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.user.UserInfoDetails;

public class ClosetShareMessages
{

    public ClosetShareMessages()
    {
    }

    public static String getBody(UserInfoDetails userinfodetails, Referral referral, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        share_type = userinfodetails.getUserSmallPicUrl();
        if (isClosetOwner(userinfodetails))
        {
            return String.format(PMApplication.getContext().getString(0x7f06007b), new Object[] {
                referral.getReferrerIncentiveFormattedString(), referral.getId(), userinfodetails.getClosetURL(), share_type, userinfodetails.getUserName(), PMApplicationSession.GetPMSession().getFirstName()
            });
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f06007a), new Object[] {
                userinfodetails.getClosetURL(), userinfodetails.getUserName(), share_type, PMApplicationSession.GetPMSession().getFirstName()
            });
        }
    }

    public static String getDescription(UserInfoDetails userinfodetails, Referral referral, String s, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
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
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return null;

        case 4: // '\004'
            break;
        }
        if (isClosetOwner(userinfodetails))
        {
            return String.format(PMApplication.getContext().getString(0x7f060081), new Object[] {
                userinfodetails.getUserName(), referral.getId(), referral.getReferredIncentiveFormattedString(), s
            });
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f060080), new Object[] {
                userinfodetails.getUserName(), referral.getId(), referral.getReferredIncentiveFormattedString(), s
            });
        }
    }

    public static String getImageUrl(UserInfoDetails userinfodetails, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return null;

        case 4: // '\004'
            return userinfodetails.getCoverShot().url_small;
        }
    }

    public static String getMessage(UserInfoDetails userinfodetails, Referral referral, String s, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        boolean flag = isClosetOwner(userinfodetails);
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 4: // '\004'
        case 6: // '\006'
        default:
            return "";

        case 8: // '\b'
            return "";

        case 3: // '\003'
            if (flag)
            {
                return String.format(PMApplication.getContext().getString(0x7f060086), new Object[] {
                    userinfodetails.getUserName(), referral.getId(), referral.getReferredIncentiveFormattedString()
                });
            } else
            {
                return String.format(PMApplication.getContext().getString(0x7f060085), new Object[] {
                    userinfodetails.getUserName(), referral.getId(), referral.getReferredIncentiveFormattedString()
                });
            }

        case 2: // '\002'
            if (flag)
            {
                return String.format(PMApplication.getContext().getString(0x7f060088), new Object[] {
                    userinfodetails.getUserName(), referral.getId(), referral.getReferredIncentiveFormattedString(), s
                });
            } else
            {
                return String.format(PMApplication.getContext().getString(0x7f060087), new Object[] {
                    userinfodetails.getUserName(), referral.getId(), referral.getReferredIncentiveFormattedString(), s
                });
            }

        case 5: // '\005'
            if (flag)
            {
                return String.format(PMApplication.getContext().getString(0x7f060083), new Object[] {
                    userinfodetails
                });
            } else
            {
                return String.format(PMApplication.getContext().getString(0x7f060082), new Object[] {
                    userinfodetails.getUserName(), s
                });
            }

        case 7: // '\007'
            return s;

        case 9: // '\t'
            return getBody(userinfodetails, referral, share_type);

        case 10: // '\n'
            break;
        }
        if (flag)
        {
            return String.format(PMApplication.getContext().getString(0x7f06007d), new Object[0]);
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f06007c), new Object[] {
                userinfodetails.getUserName()
            });
        }
    }

    public static String getPlaceHolder(UserInfoDetails userinfodetails, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (isClosetOwner(userinfodetails))
        {
            return PMApplication.getContext().getString(0x7f06007f);
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f06007e), new Object[] {
                userinfodetails.getUserName()
            });
        }
    }

    public static String getSubject(UserInfoDetails userinfodetails, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (isClosetOwner(userinfodetails))
        {
            return String.format(PMApplication.getContext().getString(0x7f06007d), new Object[0]);
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f06007c), new Object[] {
                userinfodetails.getUserName()
            });
        }
    }

    public static String getTitle(UserInfoDetails userinfodetails, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return (new StringBuilder()).append(userinfodetails.getDisplayHandle()).append(PMApplication.getContext().getString(0x7f060084)).toString();
    }

    public static String getUrl(String s, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return s;
    }

    public static boolean isClosetOwner(UserInfoDetails userinfodetails)
    {
        return PMApplicationSession.GetPMSession().getUserId().equals(userinfodetails.getPMUserId());
    }
}
