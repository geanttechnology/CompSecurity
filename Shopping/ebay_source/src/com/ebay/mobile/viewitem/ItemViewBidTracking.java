// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.text.TextUtils;
import com.ebay.common.util.Debug;
import com.ebay.mobile.CheckoutItem;
import com.ebay.mobile.Item;
import com.ebay.mobile.analytics.RoiTrackingUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public class ItemViewBidTracking
{
    public static final class BidStateType extends Enum
    {

        private static final BidStateType $VALUES[];
        public static final BidStateType BID;
        public static final BidStateType BIN;
        public static final BidStateType BO;

        public static BidStateType valueOf(String s)
        {
            return (BidStateType)Enum.valueOf(com/ebay/mobile/viewitem/ItemViewBidTracking$BidStateType, s);
        }

        public static BidStateType[] values()
        {
            return (BidStateType[])$VALUES.clone();
        }

        static 
        {
            BID = new BidStateType("BID", 0);
            BIN = new BidStateType("BIN", 1);
            BO = new BidStateType("BO", 2);
            $VALUES = (new BidStateType[] {
                BID, BIN, BO
            });
        }

        private BidStateType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class BidTrackingType
    {

        private static final BidTrackingType BROWSE_CATEGORIES = new BidTrackingType("BHN", "BNN", "BUB", "BHB");
        private static final BidTrackingType COUNTEROFFER = new BidTrackingType("CHN", "CNN", "CUB", "CHB");
        private static final BidTrackingType ENDING_SOON_NOTIFICATION = new BidTrackingType("EHN", "ENN", "EUB", "EHB");
        private static final BidTrackingType ORGANIC = new BidTrackingType("NHN", "NNN", "NUB", "NHB");
        private static final BidTrackingType OUTBID_NOTIFICATION = new BidTrackingType("OHN", "ONN", "OUB", "OHB");
        private static final BidTrackingType SAVED_SEARCH_NOTIFICATION = new BidTrackingType("SHN", "SNN", "SUB", "SHB");
        private static final BidTrackingType SHOPPING_CART = new BidTrackingType("XHN", "XNN", "XUB", "XHB");
        private final String NON_RTB_INC;
        private final String RTB_INC;
        private final String RTB_SPECIFIC_BID_AMT;
        private final String SPECIFIC_BID_AMT;

        public static BidTrackingType getTypeForBidSource(String s)
        {
            BidTrackingType bidtrackingtype1 = ORGANIC;
            BidTrackingType bidtrackingtype = bidtrackingtype1;
            if (s != null)
            {
                if (s.equals(ItemViewBidTracking.BID_SOURCE_OUTBID_NOTIFICATION))
                {
                    bidtrackingtype = OUTBID_NOTIFICATION;
                } else
                {
                    if (s.equals(ItemViewBidTracking.BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION))
                    {
                        return ENDING_SOON_NOTIFICATION;
                    }
                    if (s.equals(ItemViewBidTracking.BID_SOURCE_SVDSRCH_NOTIFICATION))
                    {
                        return SAVED_SEARCH_NOTIFICATION;
                    }
                    if (s.equals("browse_categories"))
                    {
                        return BROWSE_CATEGORIES;
                    }
                    if (s.equals(ItemViewBidTracking.BID_SOURCE_COUNTEROFFER))
                    {
                        return COUNTEROFFER;
                    }
                    bidtrackingtype = bidtrackingtype1;
                    if (s.equals("shopping_cart"))
                    {
                        return SHOPPING_CART;
                    }
                }
            }
            return bidtrackingtype;
        }

        public String getTrackingCode(boolean flag, boolean flag1)
        {
            if (flag1 && flag)
            {
                return RTB_INC;
            }
            if (!flag1 && flag)
            {
                return NON_RTB_INC;
            }
            if (!flag1 && !flag)
            {
                return SPECIFIC_BID_AMT;
            }
            if (flag1 && !flag)
            {
                return RTB_SPECIFIC_BID_AMT;
            } else
            {
                return null;
            }
        }


        public BidTrackingType(String s, String s1, String s2, String s3)
        {
            RTB_INC = s;
            NON_RTB_INC = s1;
            SPECIFIC_BID_AMT = s2;
            RTB_SPECIFIC_BID_AMT = s3;
        }
    }

    public static class Roi
    {

        public final String iafToken;
        public String roiUrl;
        public final ItemCurrency totalCostWithShipping;
        public final boolean usePlaceOfferRoi;

        public Roi(String s, ItemCurrency itemcurrency)
        {
            roiUrl = null;
            usePlaceOfferRoi = DeviceConfiguration.getAsync().get(DcsBoolean.PlaceOfferRoi);
            iafToken = s;
            totalCostWithShipping = itemcurrency;
        }
    }


    public static final String BID_SOURCE_ADD_PHOTO;
    public static final String BID_SOURCE_BESTOFR_NOTIFICATION;
    public static final String BID_SOURCE_BIDRCVD_NOTIFICATION;
    public static final String BID_SOURCE_BID_ITEM_ENDING_NOTIFICATION;
    public static final String BID_SOURCE_BOACCPTD_NOTIFICATION;
    public static final String BID_SOURCE_BODECLND_NOTIFICATION;
    public static final String BID_SOURCE_BROWSE_CATEGORIES = "browse_categories";
    public static final String BID_SOURCE_BUCKS_EXPIRING;
    public static final String BID_SOURCE_BYRNOSHW;
    public static final String BID_SOURCE_CNTROFFR_NOTIFICATION;
    public static final String BID_SOURCE_COACCPTED_NOTIFICATION;
    public static final String BID_SOURCE_COCMPLT_NOTIFICATION;
    public static final String BID_SOURCE_CODECLND_NOTIFICATION;
    public static final String BID_SOURCE_COUNTEROFFER;
    public static final String BID_SOURCE_COUPON_AVAILABLE;
    public static final String BID_SOURCE_DAILYDEALS_NOTIFICATION;
    public static final String BID_SOURCE_DEALSFRENZY_NOTIFICATION;
    public static final String BID_SOURCE_EBN_ORDER_CANCELED;
    public static final String BID_SOURCE_EBN_ORDER_PICKED_UP;
    public static final String BID_SOURCE_ITMOUTSTK;
    public static final String BID_SOURCE_ITMPAID_NOTIFICATION;
    public static final String BID_SOURCE_ITMPICKUP;
    public static final String BID_SOURCE_ITMSHPD_NOTIFICATION;
    public static final String BID_SOURCE_ITMSOLD_NOTIFICATION;
    public static final String BID_SOURCE_ITMWON_NOTIFICATION;
    public static final String BID_SOURCE_MSGEBAYMSGHDR_NOTIFICATION;
    public static final String BID_SOURCE_MSGM2MMSGHDR_NOTIFICATION;
    public static final String BID_SOURCE_OFRDCLNDACPT_NOTIFICATION;
    public static final String BID_SOURCE_OFREXPIRED_NOTIFICATION;
    public static final String BID_SOURCE_OFRRETRACTED_NOTIFICATION;
    public static final String BID_SOURCE_OUTBID_NOTIFICATION;
    public static final String BID_SOURCE_PAYREM;
    public static final String BID_SOURCE_SHOPCARTITM_NOTIFICATION;
    public static final String BID_SOURCE_SHOPPING_CART = "shopping_cart";
    public static final String BID_SOURCE_SVDSRCH_NOTIFICATION;
    public static final String BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION;
    public static final String EXTRA_INCREMENTAL_BID = "com.ebay.mobile.tracking.IncrementalBid";
    public static final String EXTRA_REFERRER = "com.ebay.mobile.tracking.Referrer";
    public static final String EXTRA_SEARCH_RESULTS_RANK = "com.ebay.mobile.tracking.SearchResultsRank";
    public static final String EXTRA_SOURCE = "com.ebay.mobile.tracking.BidSource";

    private ItemViewBidTracking()
    {
    }

    public static boolean isIncrementalBid(Item item, ViewItemDataManager viewitemdatamanager, CurrencyAmount currencyamount)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (item != null)
        {
            flag = flag1;
            if (viewitemdatamanager != null)
            {
                flag = flag1;
                if (currencyamount != null)
                {
                    item = item.minimumToBid;
                    flag = flag1;
                    if (item != null)
                    {
                        flag = flag1;
                        if (((com.ebay.mobile.Item.BidBounds) (item)).lowerBound != null)
                        {
                            flag = ((com.ebay.mobile.Item.BidBounds) (item)).lowerBound.equals(currencyamount);
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static void sendBidState(Activity activity, Item item, String s, String s1, BidStateType bidstatetype, Roi roi, String s2)
    {
        EbaySite ebaysite;
        Object obj = BidTrackingType.getTypeForBidSource(s1);
        boolean flag1 = false;
        boolean flag = flag1;
        if (item != null)
        {
            flag = flag1;
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ItemViewBidTracking$BidStateType[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ItemViewBidTracking$BidStateType = new int[BidStateType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewBidTracking$BidStateType[BidStateType.BID.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewBidTracking$BidStateType[BidStateType.BIN.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ItemViewBidTracking$BidStateType[BidStateType.BO.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            if (item.endDate != null)
            {
                if (item.endDate.getTime() - EbayResponse.currentHostTime() <= 0x493e0L)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        obj = ((BidTrackingType) (obj)).getTrackingCode(false, flag);
        if (Debug.logBidTracking.isLoggable)
        {
            s1 = (new StringBuilder()).append(com/ebay/mobile/viewitem/ItemViewBidTracking.getSimpleName()).append("\n    referrer: ").append(s).append("\n    bid source: ").append(s1).append("\n    incremental bid? ").append(false).append("\n    five or less minutes remaining in auction? ").append(flag).append("\n    final state is ");
            if (obj != null)
            {
                s = ((String) (obj));
            } else
            {
                s = "<bid tracking failed, null code>";
            }
            s = s1.append(s).toString();
            FwLog.println(Debug.logBidTracking, s);
        }
        if (obj == null || item == null) goto _L2; else goto _L1
_L1:
        ebaysite = EbaySite.getInstanceFromId(item.site);
        if (ebaysite == null) goto _L2; else goto _L3
_L3:
        s1 = new TrackingData("BidState", TrackingType.EVENT);
        s1.addKeyValuePair("mfls", ((String) (obj)));
        s1.addKeyValuePair("itm", item.getIdString());
        s1.addKeyValuePair("bti", s2);
        s1.addKeyValuePair("shipsiteid", ebaysite.id);
        s1.addKeyValuePair("curprice", String.valueOf((new CurrencyAmount(item.currentPrice)).getValueAsDouble()));
        s1.addKeyValuePair("leaf", String.valueOf(item.primaryCategoryId));
        s1.addKeyValuePair("quan", Integer.toString(item.quantity));
        s1.addKeyValuePair("type", bidstatetype.toString());
        s1.addKeyValuePair("ipay", "0");
        if (item.quantity > 1)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("mqty", s);
        if (bidstatetype == BidStateType.BID)
        {
            if (item.buyItNowAvailable)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            s1.addKeyValuePair("abin", s);
        } else
        {
            s1.addKeyValuePair("abin", "1");
        }
        if (item.isReserveMet)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("resmet", s);
        if (item.hasReservePrice)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("resprice", s);
        if (item.isSellerRequirePayPal)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("ppreq", s);
        if (item.watched)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("watcher", s);
        s1.addKeyValuePair("rebid", "0");
        s1.send(activity);
        if (roi == null || roi.usePlaceOfferRoi || bidstatetype != BidStateType.BO && bidstatetype != BidStateType.BID && bidstatetype != BidStateType.BIN || TextUtils.isEmpty(roi.iafToken) || bidstatetype != BidStateType.BO && TextUtils.isEmpty(s2)) goto _L2; else goto _L4
_L4:
        _cls1..SwitchMap.com.ebay.mobile.viewitem.ItemViewBidTracking.BidStateType[bidstatetype.ordinal()];
        JVM INSTR tableswitch 1 3: default 544
    //                   1 623
    //                   2 701
    //                   3 711;
           goto _L5 _L6 _L7 _L8
_L5:
        throw new RuntimeException("Add new type");
_L6:
        s = "BID-MobileApp";
        s1 = s2;
_L10:
        bidstatetype = null;
        if (item.secondaryCategoryId > 0L)
        {
            bidstatetype = String.valueOf(item.secondaryCategoryId);
        }
        RoiTrackingUtil.trackRoi(activity, s, ebaysite, new com.ebay.mobile.analytics.RoiTrackingUtil.RoiItemData(roi.iafToken, item.sellerUserId, item.getIdString(), s1, Integer.toString(item.quantity), roi.totalCostWithShipping, String.valueOf(item.primaryCategoryId), bidstatetype));
_L2:
        return;
_L7:
        s = "BIN-MobileApp";
        s1 = s2;
        continue; /* Loop/switch isn't completed */
_L8:
        bidstatetype = "BO-MobileApp";
        s = bidstatetype;
        s1 = s2;
        if (s2 == null)
        {
            s1 = com.ebay.mobile.analytics.RoiTrackingUtil.RoiItemData.NO_TRANSACTION_ID;
            s = bidstatetype;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static void sendBidState(com.ebay.mobile.analytics.model.TrackingData.SendHelper sendhelper, BidStateType bidstatetype, CheckoutItem checkoutitem, String s, String s1, String s2, Roi roi, String s3, 
            boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, Boolean boolean1)
    {
        EbaySite ebaysite;
        Object obj = BidTrackingType.getTypeForBidSource(s);
        boolean flag7 = false;
        boolean flag6 = flag7;
        if (checkoutitem != null)
        {
            flag6 = flag7;
            if (checkoutitem.endDate != null)
            {
                if (checkoutitem.endDate.getTime() - EbayResponse.currentHostTime() <= 0x493e0L)
                {
                    flag6 = true;
                } else
                {
                    flag6 = false;
                }
            }
        }
        obj = ((BidTrackingType) (obj)).getTrackingCode(flag, flag6);
        if (Debug.logBidTracking.isLoggable)
        {
            s1 = (new StringBuilder()).append(com/ebay/mobile/viewitem/ItemViewBidTracking.getSimpleName()).append("\n    referrer: ").append(s1).append("\n    bid source: ").append(s).append("\n    incremental bid? ").append(flag).append("\n    five or less minutes remaining in auction? ").append(flag6).append("\n    final state is ");
            if (obj != null)
            {
                s = ((String) (obj));
            } else
            {
                s = "<bid tracking failed, null code>";
            }
            s = s1.append(s).toString();
            FwLog.println(Debug.logBidTracking, s);
        }
        if (obj == null || checkoutitem == null) goto _L2; else goto _L1
_L1:
        ebaysite = EbaySite.getInstanceFromId(checkoutitem.site);
        if (ebaysite == null) goto _L2; else goto _L3
_L3:
        s1 = new TrackingData("BidState", TrackingType.EVENT);
        s1.addKeyValuePair("mfls", ((String) (obj)));
        s1.addKeyValuePair("itm", Long.toString(checkoutitem.id));
        s1.addKeyValuePair("bti", s2);
        s1.addKeyValuePair("shipsiteid", ebaysite.id);
        s1.addKeyValuePair("curprice", String.valueOf((new CurrencyAmount(checkoutitem.currentPrice)).getValueAsDouble()));
        s1.addKeyValuePair("leaf", String.valueOf(checkoutitem.primaryCategoryId));
        s1.addKeyValuePair("quan", s3);
        s1.addKeyValuePair("type", bidstatetype.toString());
        if (flag1)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("ipay", s);
        if (flag2)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("mqty", s);
        if (bidstatetype == BidStateType.BID)
        {
            if (checkoutitem.buyItNowAvailable)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            s1.addKeyValuePair("abin", s);
        } else
        {
            s1.addKeyValuePair("abin", "1");
        }
        if (checkoutitem.reserveMet)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("resmet", s);
        if (checkoutitem.hasReservePrice)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("resprice", s);
        if (flag3)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("ppreq", s);
        if (flag4)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("watcher", s);
        if (flag5)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        s1.addKeyValuePair("rebid", s);
        if (boolean1 != null)
        {
            if (boolean1.booleanValue())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            s1.addKeyValuePair("pxybid", s);
        }
        sendhelper.send(s1);
        if (roi == null || roi.usePlaceOfferRoi || bidstatetype != BidStateType.BO && bidstatetype != BidStateType.BID && bidstatetype != BidStateType.BIN || TextUtils.isEmpty(roi.iafToken) || bidstatetype != BidStateType.BO && TextUtils.isEmpty(s2)) goto _L2; else goto _L4
_L4:
        _cls1..SwitchMap.com.ebay.mobile.viewitem.ItemViewBidTracking.BidStateType[bidstatetype.ordinal()];
        JVM INSTR tableswitch 1 3: default 592
    //                   1 693
    //                   2 770
    //                   3 780;
           goto _L5 _L6 _L7 _L8
_L5:
        throw new RuntimeException("Add new type");
_L6:
        bidstatetype = "BID-MobileApp";
        s = s2;
_L10:
        s1 = null;
        if (checkoutitem.secondaryCategoryId > 0L)
        {
            s1 = String.valueOf(checkoutitem.secondaryCategoryId);
        }
        RoiTrackingUtil.trackRoi(sendhelper, bidstatetype, ebaysite, null, new com.ebay.mobile.analytics.RoiTrackingUtil.RoiItemData(roi.iafToken, checkoutitem.sellerUserId, Long.toString(checkoutitem.id), s, s3, roi.totalCostWithShipping, String.valueOf(checkoutitem.primaryCategoryId), s1));
_L2:
        return;
_L7:
        bidstatetype = "BIN-MobileApp";
        s = s2;
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = "BO-MobileApp";
        bidstatetype = s1;
        s = s2;
        if (s2 == null)
        {
            s = com.ebay.mobile.analytics.RoiTrackingUtil.RoiItemData.NO_TRANSACTION_ID;
            bidstatetype = s1;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void sendBidState(EbayContext ebaycontext, Item item, String s, String s1, boolean flag, boolean flag1, int i, BidStateType bidstatetype, 
            Roi roi, String s2, boolean flag2, boolean flag3, Boolean boolean1)
    {
        sendBidState(new com.ebay.mobile.analytics.model.TrackingData.SendHelper(ebaycontext), bidstatetype, new CheckoutItem(item), s1, s, s2, roi, String.valueOf(i), flag, false, flag1, item.isSellerRequirePayPal, flag3, flag2, boolean1);
    }

    public static void sendBidStateForCheckout(Activity activity, CheckoutItem checkoutitem, String s, String s1, Roi roi, String s2, boolean flag, boolean flag1, 
            int i, boolean flag2)
    {
        activity = new com.ebay.mobile.analytics.model.TrackingData.SendHelper(activity);
        BidStateType bidstatetype = BidStateType.BIN;
        boolean flag3;
        if (checkoutitem.quantity > 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        sendBidState(activity, bidstatetype, checkoutitem, s1, s, s2, roi, String.valueOf(i), false, flag2, flag3, true, flag1, flag, null);
    }

    static 
    {
        BID_SOURCE_OUTBID_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.OUTBID.name();
        BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name();
        BID_SOURCE_BID_ITEM_ENDING_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name();
        BID_SOURCE_BIDRCVD_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.BIDRCVD.name();
        BID_SOURCE_BESTOFR_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.BESTOFR.name();
        BID_SOURCE_BODECLND_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.BODECLND.name();
        BID_SOURCE_CNTROFFR_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.CNTROFFR.name();
        BID_SOURCE_ITMWON_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.ITMWON.name();
        BID_SOURCE_COCMPLT_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.COCMPLT.name();
        BID_SOURCE_ITMSOLD_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.ITMSOLD.name();
        BID_SOURCE_ITMPAID_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.ITMPAID.name();
        BID_SOURCE_ITMSHPD_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.ITMSHPD.name();
        BID_SOURCE_MSGM2MMSGHDR_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.MSGM2MMSGHDR.name();
        BID_SOURCE_MSGEBAYMSGHDR_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.MSGEBAYMSGHDR.name();
        BID_SOURCE_SVDSRCH_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name();
        BID_SOURCE_COUNTEROFFER = com.ebay.common.model.mdns.NotificationPreference.EventType.CNTROFFR.name();
        BID_SOURCE_COUPON_AVAILABLE = com.ebay.common.model.mdns.NotificationPreference.EventType.COUPONAVLBL.name();
        BID_SOURCE_ADD_PHOTO = com.ebay.common.model.mdns.NotificationPreference.EventType.ADDPHOTO.name();
        BID_SOURCE_BUCKS_EXPIRING = com.ebay.common.model.mdns.NotificationPreference.EventType.BUCKSEXP.name();
        BID_SOURCE_ITMPICKUP = com.ebay.common.model.mdns.NotificationPreference.EventType.ITMPICKUP.name();
        BID_SOURCE_ITMOUTSTK = com.ebay.common.model.mdns.NotificationPreference.EventType.ITMOUTSTK.name();
        BID_SOURCE_BYRNOSHW = com.ebay.common.model.mdns.NotificationPreference.EventType.BYRNOSHW.name();
        BID_SOURCE_PAYREM = com.ebay.common.model.mdns.NotificationPreference.EventType.PAYREM.name();
        BID_SOURCE_EBN_ORDER_PICKED_UP = com.ebay.common.model.mdns.NotificationPreference.EventType.EBNORDPICKED.name();
        BID_SOURCE_EBN_ORDER_CANCELED = com.ebay.common.model.mdns.NotificationPreference.EventType.EBNORDCNCL.name();
        BID_SOURCE_BOACCPTD_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.BOACCPTD.name();
        BID_SOURCE_COACCPTED_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.COACCPTED.name();
        BID_SOURCE_CODECLND_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.CODECLND.name();
        BID_SOURCE_OFRDCLNDACPT_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.OFRDCLNDACPT.name();
        BID_SOURCE_OFREXPIRED_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.OFREXPIRED.name();
        BID_SOURCE_OFRRETRACTED_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.OFRRETRACTED.name();
        BID_SOURCE_SHOPCARTITM_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.SHOPCARTITM.name();
        BID_SOURCE_DEALSFRENZY_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.DealsFrenzy.name();
        BID_SOURCE_DAILYDEALS_NOTIFICATION = com.ebay.common.model.mdns.NotificationPreference.EventType.DailyDeals.name();
    }
}
