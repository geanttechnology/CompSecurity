// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.inner_models.CoverShot;

public class BrandShareMessages
{

    public BrandShareMessages()
    {
    }

    public static String getBody(Brand brand, com.poshmark.data_model.models.BrandShareMessages brandsharemessages, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (brandsharemessages != null && brandsharemessages.email != null)
        {
            return brandsharemessages.email.body;
        }
        if (brand.cover_shot != null && brand.cover_shot.url_small != null)
        {
            brandsharemessages = brand.cover_shot.url_small;
        } else
        {
            brandsharemessages = Brand.getDefaultBrandCovershotUrl();
        }
        share_type = Brand.getUrlFromBrandName(brand.canonical_name);
        return String.format(PMApplication.getContext().getString(0x7f060057), new Object[] {
            brandsharemessages, share_type, brand.canonical_name, PMApplicationSession.GetPMSession().getFirstName()
        });
    }

    public static String getDescription(Brand brand, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
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
            return String.format(PMApplication.getContext().getString(0x7f06005a), new Object[] {
                brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
            });

        case 7: // '\007'
            return PMApplication.getContext().getString(0x7f06010c);
        }
    }

    public static String getImageUrl(Brand brand, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return brand.logo.url_small;
    }

    public static String getMessage(Brand brand, com.poshmark.data_model.models.BrandShareMessages brandsharemessages, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 4: // '\004'
        case 6: // '\006'
        default:
            return "";

        case 8: // '\b'
            return "";

        case 3: // '\003'
            if (brandsharemessages == null || brandsharemessages.tumblr == null)
            {
                return String.format(PMApplication.getContext().getString(0x7f06005f), new Object[] {
                    brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
                });
            } else
            {
                return brandsharemessages.tumblr.message;
            }

        case 2: // '\002'
            if (brandsharemessages == null || brandsharemessages.twitter == null)
            {
                return String.format(PMApplication.getContext().getString(0x7f060060), new Object[] {
                    brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
                });
            } else
            {
                return brandsharemessages.twitter.message;
            }

        case 5: // '\005'
            if (brandsharemessages == null || brandsharemessages.sms == null)
            {
                return String.format(PMApplication.getContext().getString(0x7f06005e), new Object[] {
                    brand.canonical_name, Brand.getUrlFromBrandName(brand.canonical_name)
                });
            } else
            {
                return brandsharemessages.sms.message;
            }

        case 7: // '\007'
            if (brandsharemessages == null || brandsharemessages.sms == null)
            {
                return Brand.getUrlFromBrandName(brand.canonical_name);
            } else
            {
                return brandsharemessages.sms.message;
            }

        case 9: // '\t'
            return getBody(brand, brandsharemessages, share_type);

        case 10: // '\n'
            break;
        }
        if (brandsharemessages == null || brandsharemessages.email == null)
        {
            return String.format(PMApplication.getContext().getString(0x7f060058), new Object[] {
                brand.canonical_name
            });
        } else
        {
            return brandsharemessages.email.subject;
        }
    }

    public static String getPlaceHolder(Brand brand, com.poshmark.data_model.models.BrandShareMessages brandsharemessages, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (brandsharemessages != null && brandsharemessages.facebook != null)
        {
            return brandsharemessages.facebook.hint;
        } else
        {
            return String.format(PMApplication.getContext().getString(0x7f060059), new Object[] {
                brand.canonical_name
            });
        }
    }

    public static String getSubject(Brand brand, com.poshmark.data_model.models.BrandShareMessages brandsharemessages, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        if (brandsharemessages == null || brandsharemessages.email == null)
        {
            return String.format(PMApplication.getContext().getString(0x7f060058), new Object[] {
                brand.canonical_name
            });
        } else
        {
            return brandsharemessages.email.subject;
        }
    }

    public static String getTitle(Brand brand, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        return (new StringBuilder()).append(brand.canonical_name).append(PMApplication.getContext().getString(0x7f0601e3)).toString();
    }

    public static String getUrl(Brand brand, com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        default:
            return "";

        case 1: // '\001'
            return Brand.getUrlFromBrandName(brand.canonical_name);

        case 7: // '\007'
            return Brand.getUrlFromBrandName(brand.canonical_name);
        }
    }
}
