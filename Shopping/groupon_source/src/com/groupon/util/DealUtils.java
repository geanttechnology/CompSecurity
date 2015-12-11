// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.Channel;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.Badge;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.GiftWrappingCharge;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.SchedulerOption;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.models.mobilescheduler.DealOption;
import com.groupon.models.mobilescheduler.LocalBookingInfo;
import com.groupon.models.mobilescheduler.MobileSchedulerData;
import com.groupon.models.mobilescheduler.Reservation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Strings;

public class DealUtils
{

    private static final String RIBBON = "ribbon";

    public DealUtils()
    {
    }

    private static transient boolean checkChannelMatches(Channel channel, Channel achannel[])
    {
        boolean flag1 = false;
        int j = achannel.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (channel != achannel[i])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private static boolean checkGetawaysTravelChannel(Channel channel)
    {
        return checkChannelMatches(channel, new Channel[] {
            Channel.GETAWAYS, Channel.TRAVEL
        });
    }

    private static boolean checkGoodsShoppingChannel(Channel channel)
    {
        return checkChannelMatches(channel, new Channel[] {
            Channel.GOODS, Channel.SHOPPING
        });
    }

    public static Map createOptionsByIdMap(Deal deal)
    {
        if (deal != null)
        {
            HashMap hashmap = new HashMap(deal.getOptions().size());
            Iterator iterator = deal.getOptions().iterator();
            do
            {
                deal = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                deal = (Option)iterator.next();
                hashmap.put(((Option) (deal)).remoteId, deal);
            } while (true);
        } else
        {
            deal = new HashMap(0);
        }
        return deal;
    }

    public static Collection getDealRecommendations(Deal deal)
    {
        if (deal.merchant == null)
        {
            return Collections.emptyList();
        } else
        {
            return deal.merchant.recommendations;
        }
    }

    public static Option getOption(Deal deal, String s)
    {
label0:
        {
            if (!Strings.notEmpty(s))
            {
                break label0;
            }
            deal = deal.getOptions().iterator();
            Option option;
            do
            {
                if (!deal.hasNext())
                {
                    break label0;
                }
                option = (Option)deal.next();
            } while (!Strings.equals(option.remoteId, s));
            return option;
        }
        return null;
    }

    public static MobileSchedulerData getSchedulerInputData(Deal deal, String s, Channel channel, String s1)
    {
        Option option = getOption(deal, s);
        MobileSchedulerData mobileschedulerdata = new MobileSchedulerData();
        s = new DealOption();
        s.id = option.uuid;
        mobileschedulerdata.dealOption = s;
        mobileschedulerdata.orderId = s1;
        s1 = new com.groupon.models.mobilescheduler.Merchant();
        if (deal.merchant != null)
        {
            s = deal.merchant.remoteId;
        } else
        {
            s = "";
        }
        s1.id = s;
        mobileschedulerdata.merchant = s1;
        s = new com.groupon.models.mobilescheduler.Deal();
        s.id = deal.remoteId;
        mobileschedulerdata.deal = s;
        deal = new LocalBookingInfo();
        s = new Reservation();
        s.status = "unbooked";
        deal.reservation = s;
        mobileschedulerdata.localBookingInfo = deal;
        mobileschedulerdata.bookable = option.bookable;
        mobileschedulerdata.channel = channel.name();
        return mobileschedulerdata;
    }

    public static boolean hasExternalUrl(Deal deal)
    {
        boolean flag1 = false;
        deal = deal.getOptions().iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!deal.hasNext())
            {
                break;
            }
            if (!Strings.notEmpty(((Option)deal.next()).externalUrl))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    public static boolean isBadgeValid(Badge badge)
    {
        return badge.displayLocation.equalsIgnoreCase("ribbon") && Strings.notEmpty(badge.text) && Strings.notEmpty(badge.secondaryColor) && Strings.notEmpty(badge.primaryColor);
    }

    public static boolean isBookingEngineDeal(Deal deal, boolean flag)
    {
        if (deal != null)
        {
            if ((deal = deal.getOptions()) != null && deal.size() > 0)
            {
                deal = deal.iterator();
                while (deal.hasNext()) 
                {
                    Option option = (Option)deal.next();
                    if (option.schedulerOptions != null)
                    {
                        String s = option.schedulerOptions.bookingType;
                        boolean flag1;
                        if (Strings.notEmpty(s) && Strings.equalsIgnoreCase(s, "booking_engine"))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag ? option.bookable && flag1 : flag1)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isConnectedMarketplaceDeal(Deal deal)
    {
        return deal.shippingAddressRequired && deal.isConnectedMarketPlaceDeal && Strings.notEmpty(deal.connectedMarketPlaceDisplayText);
    }

    public static boolean isFoodAndDrinkDeal(Deal deal)
    {
        return deal != null && deal.secondLevelDealCategories != null && !deal.secondLevelDealCategories.isEmpty() && deal.secondLevelDealCategories.contains("food-and-drink");
    }

    public static boolean isG1Deal(Deal deal)
    {
        return deal != null && !isGetawaysTravelDeal(deal) && !deal.isTravelBookableDeal;
    }

    public static boolean isG1Deal(SharedDealInfo shareddealinfo)
    {
        return shareddealinfo != null && !isGetawaysTravelDeal(shareddealinfo) && !shareddealinfo.isTravelBookableDeal;
    }

    public static boolean isGetawaysTravelDeal(Deal deal)
    {
        if (deal != null)
        {
            deal = deal.getChannelList().iterator();
            while (deal.hasNext()) 
            {
                if (checkGetawaysTravelChannel((Channel)deal.next()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isGetawaysTravelDeal(SharedDealInfo shareddealinfo)
    {
        if (shareddealinfo != null)
        {
            shareddealinfo = shareddealinfo.channels;
            int j = shareddealinfo.length;
            int i = 0;
            while (i < j) 
            {
                if (checkGetawaysTravelChannel(shareddealinfo[i]))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean isGiftWrappable(Option option)
    {
        return option.giftWrappingCharge != null && option.giftWrappingCharge.amount != 0;
    }

    public static boolean isGiftableDeal(Deal deal, boolean flag, boolean flag1)
    {
        boolean flag3 = false;
        boolean flag2 = flag3;
        if (!isBookingEngineDeal(deal, false))
        {
            flag2 = flag3;
            if (!deal.isTravelBookableDeal)
            {
                flag2 = flag3;
                if (!isGoodsShoppingDeal(deal))
                {
                    flag2 = flag3;
                    if (!deal.derivedIsGLiveDeal)
                    {
                        flag2 = flag3;
                        if (!flag)
                        {
                            flag2 = flag3;
                            if (!flag1)
                            {
                                flag2 = true;
                            }
                        }
                    }
                }
            }
        }
        return flag2;
    }

    public static boolean isGoodsShoppingDeal(Deal deal)
    {
label0:
        {
            if (deal == null)
            {
                break label0;
            }
            deal = deal.getChannelList().iterator();
            do
            {
                if (!deal.hasNext())
                {
                    break label0;
                }
            } while (!checkGoodsShoppingChannel((Channel)deal.next()));
            return true;
        }
        return false;
    }

    public static boolean isGoodsShoppingDeal(DealSummary dealsummary)
    {
label0:
        {
            if (dealsummary == null)
            {
                break label0;
            }
            if (checkGoodsShoppingChannel(dealsummary.getChannel()))
            {
                return true;
            }
            dealsummary = dealsummary.getChannelList().iterator();
            do
            {
                if (!dealsummary.hasNext())
                {
                    break label0;
                }
            } while (!checkGoodsShoppingChannel((Channel)dealsummary.next()));
            return true;
        }
        return false;
    }

    public static boolean isGoodsShoppingDeal(SharedDealInfo shareddealinfo)
    {
        if (shareddealinfo == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (!checkGoodsShoppingChannel(shareddealinfo.channel)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        shareddealinfo = shareddealinfo.channels;
        int j = shareddealinfo.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (checkGoodsShoppingChannel(shareddealinfo[i]))
            {
                break;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public static boolean isHealthBeautyWellnessDeal(Deal deal)
    {
        return deal != null && deal.secondLevelDealCategories != null && !deal.secondLevelDealCategories.isEmpty() && deal.secondLevelDealCategories.contains("beauty-and-spas");
    }

    public static boolean isLocalDeal(DealSummary dealsummary)
    {
        if (dealsummary == null)
        {
            return false;
        }
        for (dealsummary = dealsummary.getChannelList().iterator(); dealsummary.hasNext();)
        {
            if ((Channel)dealsummary.next() != null)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isSoldOutOrClosed(AbstractDeal abstractdeal)
    {
        boolean flag = Strings.equalsIgnoreCase("closed", abstractdeal.status);
        boolean flag1 = abstractdeal.isSoldOut;
        return flag || flag1;
    }
}
