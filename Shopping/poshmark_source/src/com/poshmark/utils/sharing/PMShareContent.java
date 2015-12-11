// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import android.content.Context;
import android.net.Uri;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.BrandShareMessages;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.Referral;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.CurrencyUtils;

// Referenced classes of package com.poshmark.utils.sharing:
//            ServerShareMessages, PartyShareMessages, ClosetShareMessages, ListingShareMessages, 
//            InviteFriendsMessages, ShowroomShareMessages, BrandShareMessages

public class PMShareContent
{

    private Brand brand;
    private BrandShareMessages brandShareMessages;
    private String closetShortURL;
    private Context context;
    private PartyEvent event;
    private String finalShareMessage;
    private ListingSummary listingItem;
    private com.poshmark.utils.ShareManager.SHARE_MODE mode;
    private Referral referralData;
    private ServerShareMessages serverShareContent;
    private Showroom showroom;
    private com.poshmark.utils.ShareManager.SHARE_TYPE type;
    private UserInfoDetails userInfo;

    public PMShareContent()
    {
        context = PMApplication.getContext();
    }

    private String getBrandShareMessageString(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[];
            static final int $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE = new int[com.poshmark.utils.ShareManager.SHARE_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE[com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND_JUSTIN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE = new int[com.poshmark.utils.ShareManager.SHARE_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TM_SHARE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.TW_SHARE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.SMS_SHARE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_MESSENGER_SHARE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE_BODY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.EMAIL_SHARE_SUBJECT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE[com.poshmark.utils.ShareManager.SHARE_TYPE.FB_DIALOG_SHARE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
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

        case 4: // '\004'
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

        case 5: // '\005'
            if (brandShareMessages == null || brandShareMessages.sms == null)
            {
                return Brand.getUrlFromBrandName(brand.canonical_name);
            } else
            {
                return brandShareMessages.sms.message;
            }

        case 6: // '\006'
            return getFormattedEmailBodyForBrandShare();

        case 7: // '\007'
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

    private String getDefaultPlaceholderString()
    {
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING && type == com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE)
        {
            if (isListingOwner())
            {
                return context.getString(0x7f060174);
            } else
            {
                return context.getString(0x7f060173);
            }
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS && type == com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE)
        {
            String s = (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(referralData.getReferredIncentiveString()).toString();
            return String.format(context.getString(0x7f060159), new Object[] {
                referralData.getId(), s
            });
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY && type == com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE)
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
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET && type == com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE)
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
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM && type == com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE)
        {
            return context.getString(0x7f060271);
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND && type == com.poshmark.utils.ShareManager.SHARE_TYPE.FB_SHARE)
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

    private String getListingShareMessageString(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        String s = getListingShareURL();
        boolean flag = isListingOwner();
        String s1 = listingItem.getTitle();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
        {
        case 5: // '\005'
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

        case 4: // '\004'
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

        case 6: // '\006'
            return getFormattedEmailBodyForListingShare(flag);

        case 7: // '\007'
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

    private String getListingShareURL()
    {
        return (new StringBuilder()).append("https://www.poshmark.com/listings/").append(listingItem.getIdAsString()).toString();
    }

    private String getPartyInviteMessageString(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        String s = event.getURL();
        String s1 = event.getTitle();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
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

        case 5: // '\005'
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

        case 4: // '\004'
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

        case 6: // '\006'
            if (event.isPastEvent())
            {
                return getFormattedEmailBodyForPartyShare(s1, s, true);
            } else
            {
                return getFormattedEmailBodyForPartyShare(s1, s, false);
            }

        case 7: // '\007'
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

    private String getUserInviteMessageString(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
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

        case 6: // '\006'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().email_body;
            }
            break;

        case 7: // '\007'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().email_subject;
            }
            break;

        case 4: // '\004'
            if (referralData.getDefaultMessages() != null)
            {
                return referralData.getDefaultMessages().sms;
            }
            break;

        case 5: // '\005'
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

    private boolean isClosetOwner()
    {
        return PMApplicationSession.GetPMSession().getUserId().equals(userInfo.getPMUserId());
    }

    private boolean isListingOwner()
    {
        return PMApplicationSession.GetPMSession().getUserId().equals(listingItem.getUserId());
    }

    public void addFinalSharingMessage(String s)
    {
        finalShareMessage = s;
    }

    public String getBody()
    {
        String s;
        s = null;
        if (serverShareContent != null)
        {
            return serverShareContent.getBody(type);
        }
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 76
    //                   1 78
    //                   2 93
    //                   3 112
    //                   4 127
    //                   5 142
    //                   6 157
    //                   7 157;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L1:
        return s;
_L2:
        s = PartyShareMessages.getBody(event, type);
        continue; /* Loop/switch isn't completed */
_L3:
        s = ClosetShareMessages.getBody(userInfo, referralData, type);
        continue; /* Loop/switch isn't completed */
_L4:
        s = ListingShareMessages.getBody(listingItem, type);
        continue; /* Loop/switch isn't completed */
_L5:
        s = InviteFriendsMessages.getBody(referralData, type);
        continue; /* Loop/switch isn't completed */
_L6:
        s = ShowroomShareMessages.getBody(showroom, type);
        continue; /* Loop/switch isn't completed */
_L7:
        s = BrandShareMessages.getBody(brand, brandShareMessages, type);
        if (true) goto _L1; else goto _L8
_L8:
    }

    public Brand getBrand()
    {
        return brand;
    }

    public String getClosetShareMessageString(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        boolean flag = isClosetOwner();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
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

        case 4: // '\004'
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

        case 5: // '\005'
            return closetShortURL;

        case 6: // '\006'
            return getFormattedEmailBodyForClosetShare(flag);

        case 7: // '\007'
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

    public String getClosetShortUrl()
    {
        return closetShortURL;
    }

    public String getDefaultShareMessage()
    {
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_LISTING)
        {
            return getListingShareMessageString(type);
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS)
        {
            return getUserInviteMessageString(type);
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_PARTY)
        {
            return getPartyInviteMessageString(type);
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_CLOSET)
        {
            return getClosetShareMessageString(type);
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_SHOWROOM)
        {
            return getShowroomShareMessageString(type);
        }
        if (mode == com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND)
        {
            return getBrandShareMessageString(type);
        } else
        {
            return "";
        }
    }

    public String getFinalSharingMessage()
    {
        return finalShareMessage;
    }

    public String getId()
    {
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 68
    //                   2 98
    //                   3 120
    //                   4 113
    //                   5 83
    //                   6 50;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return null;
_L7:
        if (brand != null)
        {
            return Uri.encode(brand.canonical_name);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (event != null)
        {
            return event.getId();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (showroom != null)
        {
            return showroom.getId();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (userInfo != null)
        {
            return userInfo.getPMUserId();
        }
        if (true) goto _L1; else goto _L5
_L5:
        return PMApplicationSession.GetPMSession().getUserId();
_L4:
        if (listingItem != null)
        {
            return listingItem.getIdAsString();
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public String getImageUrl()
    {
        String s;
        s = null;
        if (serverShareContent != null)
        {
            return serverShareContent.getImageUrl(type);
        }
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 76
    //                   1 78
    //                   2 93
    //                   3 108
    //                   4 123
    //                   5 134
    //                   6 149
    //                   7 149;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L1:
        return s;
_L2:
        s = PartyShareMessages.getImageUrl(event, type);
        continue; /* Loop/switch isn't completed */
_L3:
        s = ClosetShareMessages.getImageUrl(userInfo, type);
        continue; /* Loop/switch isn't completed */
_L4:
        s = ListingShareMessages.getImageUrl(listingItem, type);
        continue; /* Loop/switch isn't completed */
_L5:
        s = InviteFriendsMessages.getImageUrl(type);
        continue; /* Loop/switch isn't completed */
_L6:
        s = ShowroomShareMessages.getImageUrl(showroom, type);
        continue; /* Loop/switch isn't completed */
_L7:
        s = BrandShareMessages.getImageUrl(brand, type);
        if (true) goto _L1; else goto _L8
_L8:
    }

    public ListingSummary getListing()
    {
        return listingItem;
    }

    public String getMessage()
    {
        if (serverShareContent != null)
        {
            return serverShareContent.getMessage(type);
        } else
        {
            return getDefaultShareMessage();
        }
    }

    public PartyEvent getParty()
    {
        return event;
    }

    public String getPlaceHolderString()
    {
        String s;
        s = null;
        if (serverShareContent != null)
        {
            return serverShareContent.getPlaceHolder(type);
        }
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 76
    //                   1 78
    //                   2 93
    //                   3 108
    //                   4 123
    //                   5 138
    //                   6 153
    //                   7 153;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L1:
        return s;
_L2:
        s = PartyShareMessages.getPlaceHolder(event, type);
        continue; /* Loop/switch isn't completed */
_L3:
        s = ClosetShareMessages.getPlaceHolder(userInfo, type);
        continue; /* Loop/switch isn't completed */
_L4:
        s = ListingShareMessages.getPlaceHolder(listingItem, type);
        continue; /* Loop/switch isn't completed */
_L5:
        s = InviteFriendsMessages.getPlaceHolder(referralData, type);
        continue; /* Loop/switch isn't completed */
_L6:
        s = ShowroomShareMessages.getPlaceHolder(showroom, type);
        continue; /* Loop/switch isn't completed */
_L7:
        s = BrandShareMessages.getPlaceHolder(brand, brandShareMessages, type);
        if (true) goto _L1; else goto _L8
_L8:
    }

    public Referral getReferralData()
    {
        return referralData;
    }

    public String getShareDescription()
    {
        if (serverShareContent != null)
        {
            return serverShareContent.getDescription(type);
        }
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return PartyShareMessages.getDescription(event, type);

        case 2: // '\002'
            return ClosetShareMessages.getDescription(userInfo, referralData, closetShortURL, type);

        case 3: // '\003'
            return ListingShareMessages.getDescription(listingItem, type);

        case 4: // '\004'
            return InviteFriendsMessages.getDescription(referralData, type);

        case 5: // '\005'
            return ShowroomShareMessages.getDescription(showroom, type);

        case 6: // '\006'
        case 7: // '\007'
            return BrandShareMessages.getDescription(brand, type);
        }
    }

    public String getShareMessage()
    {
        if (serverShareContent != null)
        {
            return serverShareContent.getMessage(type);
        }
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return PartyShareMessages.getMessage(event, type);

        case 2: // '\002'
            return ClosetShareMessages.getMessage(userInfo, referralData, closetShortURL, type);

        case 3: // '\003'
            return ListingShareMessages.getMessage(listingItem, type);

        case 4: // '\004'
            return InviteFriendsMessages.getMessage(referralData, type);

        case 5: // '\005'
            return ShowroomShareMessages.getMessage(showroom, type);

        case 6: // '\006'
        case 7: // '\007'
            return BrandShareMessages.getMessage(brand, brandShareMessages, type);
        }
    }

    public String getShareTitle()
    {
        if (serverShareContent != null)
        {
            return serverShareContent.getTitle(type);
        }
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return PartyShareMessages.getTitle(event, type);

        case 2: // '\002'
            return ClosetShareMessages.getTitle(userInfo, type);

        case 3: // '\003'
            return ListingShareMessages.getTitle(listingItem, type);

        case 4: // '\004'
            return InviteFriendsMessages.getTitle(referralData, type);

        case 5: // '\005'
            return ShowroomShareMessages.getTitle(showroom, type);

        case 6: // '\006'
        case 7: // '\007'
            return BrandShareMessages.getTitle(brand, type);
        }
    }

    public String getShareUrl()
    {
        if (serverShareContent != null)
        {
            return serverShareContent.getUrl(type);
        }
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return PartyShareMessages.getUrl(event, type);

        case 2: // '\002'
            return ClosetShareMessages.getUrl(closetShortURL, type);

        case 3: // '\003'
            return ListingShareMessages.getUrl(listingItem, type);

        case 4: // '\004'
            return InviteFriendsMessages.getUrl(referralData, type);

        case 5: // '\005'
            return ShowroomShareMessages.getUrl(showroom, type);

        case 6: // '\006'
        case 7: // '\007'
            return BrandShareMessages.getUrl(brand, type);
        }
    }

    public Showroom getShowroom()
    {
        return showroom;
    }

    public String getShowroomShareMessageString(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        String s = showroom.getShortURL();
        switch (_cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_TYPE[share_type.ordinal()])
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

        case 4: // '\004'
            return String.format(context.getString(0x7f060272), new Object[] {
                showroom.getName(), s
            });

        case 5: // '\005'
            return s;

        case 6: // '\006'
            return getFormattedEmailBodyForShowroomShare();

        case 7: // '\007'
            return String.format(context.getString(0x7f060270), new Object[] {
                PMApplicationSession.GetPMSession().getFullName(), showroom.getName()
            });
        }
    }

    public String getSubject()
    {
        String s;
        s = null;
        if (serverShareContent != null)
        {
            return serverShareContent.getSubject(type);
        }
        _cls1..SwitchMap.com.poshmark.utils.ShareManager.SHARE_MODE[mode.ordinal()];
        JVM INSTR tableswitch 1 7: default 76
    //                   1 78
    //                   2 93
    //                   3 108
    //                   4 123
    //                   5 138
    //                   6 153
    //                   7 153;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L1:
        return s;
_L2:
        s = PartyShareMessages.getSubject(event, type);
        continue; /* Loop/switch isn't completed */
_L3:
        s = ClosetShareMessages.getSubject(userInfo, type);
        continue; /* Loop/switch isn't completed */
_L4:
        s = ListingShareMessages.getSubject(listingItem, type);
        continue; /* Loop/switch isn't completed */
_L5:
        s = InviteFriendsMessages.getSubject(referralData, type);
        continue; /* Loop/switch isn't completed */
_L6:
        s = ShowroomShareMessages.getSubject(showroom, type);
        continue; /* Loop/switch isn't completed */
_L7:
        s = BrandShareMessages.getSubject(brand, brandShareMessages, type);
        if (true) goto _L1; else goto _L8
_L8:
    }

    public UserInfoDetails getUser()
    {
        return userInfo;
    }

    public void reset()
    {
        listingItem = null;
        event = null;
        userInfo = null;
        showroom = null;
        brand = null;
        brandShareMessages = null;
        serverShareContent = null;
        referralData = null;
        closetShortURL = null;
    }

    public void setBrand(Brand brand1)
    {
        brand = brand1;
    }

    public void setBrandShareMessages(BrandShareMessages brandsharemessages)
    {
        brandShareMessages = brandsharemessages;
    }

    public void setListing(ListingSummary listingsummary)
    {
        listingItem = listingsummary;
    }

    public void setParty(PartyEvent partyevent)
    {
        event = partyevent;
    }

    public void setReferralData(Referral referral)
    {
        referralData = referral;
    }

    public void setServerShareContent(ServerShareMessages serversharemessages)
    {
        serverShareContent = serversharemessages;
    }

    public void setShareMode(com.poshmark.utils.ShareManager.SHARE_MODE share_mode)
    {
        mode = share_mode;
    }

    public void setShareType(com.poshmark.utils.ShareManager.SHARE_TYPE share_type)
    {
        type = share_type;
    }

    public void setShowroom(Showroom showroom1)
    {
        showroom = showroom1;
    }

    public void setUser(UserInfoDetails userinfodetails)
    {
        userInfo = userinfodetails;
    }

    public void setclosetShortUrl(String s)
    {
        closetShortURL = s;
    }
}
