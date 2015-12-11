// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.model.EbayOrder;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import java.util.Calendar;

public class PickupUtil
{

    private static final int DAYS_PER_WEEK = 7;
    public static com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Pickup", 3, "Log ISPU and PUDO events");

    public PickupUtil()
    {
    }

    public static String formatFulfillmentTime(Context context, Long long1)
    {
        String s1 = "";
        String s = s1;
        if (long1 != null)
        {
            context = context.getResources();
            if (long1.longValue() < 0x36ee80L)
            {
                long l = long1.longValue() / 60000L;
                s = String.format(context.getQuantityString(0x7f080031, (int)l), new Object[] {
                    Long.valueOf(l)
                });
            } else
            {
                if (long1.longValue() < 0x5265c00L)
                {
                    long l1 = long1.longValue() / 0x36ee80L;
                    return String.format(context.getQuantityString(0x7f080030, (int)l1), new Object[] {
                        Long.valueOf(l1)
                    });
                }
                s = s1;
                if (long1.longValue() < 0x240c8400L)
                {
                    long l2 = long1.longValue() / 0x5265c00L;
                    return String.format(context.getQuantityString(0x7f08002f, (int)l2), new Object[] {
                        Long.valueOf(l2)
                    });
                }
            }
        }
        return s;
    }

    public static String formatStoreAddress(LocationAddress locationaddress)
    {
        boolean flag = false;
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(locationaddress.address1))
        {
            stringbuilder.append(locationaddress.address1);
            flag = true;
        }
        boolean flag1 = flag;
        if (locationaddress.address2 != null)
        {
            flag1 = flag;
            if (!TextUtils.isEmpty(locationaddress.address2.trim()))
            {
                if (flag)
                {
                    stringbuilder.append("\n");
                }
                stringbuilder.append(locationaddress.address2);
                flag1 = true;
            }
        }
        boolean flag2;
        boolean flag3;
        if (!TextUtils.isEmpty(locationaddress.city))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(locationaddress.region))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!TextUtils.isEmpty(locationaddress.postalCode))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag || flag2 || flag3)
        {
            if (flag1)
            {
                stringbuilder.append("\n");
            }
            if (flag)
            {
                stringbuilder.append(locationaddress.city);
            }
            if (flag2)
            {
                if (flag)
                {
                    stringbuilder.append(", ");
                }
                stringbuilder.append(locationaddress.region);
            }
            if (flag3)
            {
                if (flag || flag2)
                {
                    stringbuilder.append(" ");
                }
                stringbuilder.append(locationaddress.postalCode);
            }
        }
        return stringbuilder.toString();
    }

    public static String formatStoreHours(Context context, com.ebay.common.model.inventory.LocationDetails.Hours hours, int i)
    {
        int k = Calendar.getInstance().get(7);
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < 7; j++)
        {
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append("\n");
            }
            stringbuilder.append(Util.getDisplayableHours(context, hours, new int[] {
                ((j + (k + i)) - 1) % 7 + 1
            }));
        }

        return stringbuilder.toString();
    }

    public static String formatStoreHours(Context context, StoreAvailability storeavailability)
    {
        return formatStoreHours(context, storeavailability.hours, getDaysModifierFromFulfillmentTime(storeavailability.fulfillmentTime));
    }

    public static int getDaysModifierFromFulfillmentTime(Long long1)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (long1 != null)
        {
            i = ((flag) ? 1 : 0);
            if (long1.longValue() < 0x240c8400L)
            {
                i = (int)(long1.longValue() / 0x5265c00L) % 7;
            }
        }
        return i;
    }

    public static String getOrderStatusSubText(Activity activity, ItemTransaction itemtransaction)
    {
        if (itemtransaction == null || itemtransaction.pickupStatus == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus = new int[OrderPickupStatus.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PendingMerchantConfirmation.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.ReadyToPickup.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.Pickedup.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledBuyerRejected.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledBuyerNoShow.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$OrderPickupStatus[OrderPickupStatus.PickupCancelledOutOfStock.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.nautilus.domain.data.OrderPickupStatus[itemtransaction.pickupStatus.ordinal()];
        JVM INSTR tableswitch 1 6: default 60
    //                   1 62
    //                   2 69
    //                   3 133
    //                   4 135
    //                   5 135
    //                   6 135;
           goto _L2 _L3 _L4 _L5 _L6 _L6 _L6
_L2:
        return null;
_L3:
        return activity.getString(0x7f07074d);
_L4:
        if (itemtransaction.isInStoreCredit() || itemtransaction.isPaymentRefund())
        {
            return activity.getString(0x7f07074c);
        } else
        {
            itemtransaction = MyApp.getPrefs().getCurrentCountry();
            return (new StringBuilder()).append(activity.getString(0x7f07074a)).append("\n\n").append(activity.getString(getPudoCollectionCodeInstructionsResourceForCountry(itemtransaction))).toString();
        }
_L5:
        return null;
_L6:
        return activity.getString(0x7f07074c);
    }

    public static String getOrderStatusText(Activity activity, ItemTransaction itemtransaction, EbayOrder ebayorder)
    {
        if (itemtransaction == null)
        {
            return activity.getString(0x7f070748);
        }
        OrderPickupStatus orderpickupstatus = itemtransaction.pickupStatus;
        if (orderpickupstatus == null)
        {
            return activity.getString(0x7f070748);
        }
        if (activity instanceof ItemViewActivity)
        {
            if (itemtransaction.isInStoreCredit())
            {
                return activity.getString(0x7f07074b);
            }
            if (itemtransaction.isPaymentRefund())
            {
                return activity.getString(0x7f07074c);
            }
        }
        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.data.OrderPickupStatus[orderpickupstatus.ordinal()])
        {
        default:
            return activity.getString(0x7f070748);

        case 1: // '\001'
            return activity.getString(0x7f070748);

        case 2: // '\002'
            if (itemtransaction.isInStoreCredit() || itemtransaction.isPaymentRefund())
            {
                return activity.getString(0x7f070744);
            }
            if (activity instanceof ItemViewActivity)
            {
                return activity.getString(0x7f07074a);
            } else
            {
                return getPickupCode(ebayorder.merchantPickupCode);
            }

        case 3: // '\003'
            return activity.getString(0x7f070747);

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return activity.getString(0x7f070744);
        }
    }

    public static String getPickupCode(String s)
    {
        String s1 = s;
        if (!TextUtils.isEmpty(s))
        {
            int i = s.indexOf(" Barcode:");
            s1 = s;
            if (i != -1)
            {
                s1 = s.substring(0, i);
            }
        }
        return s1;
    }

    public static int getPudoCollectionCodeInstructionsResourceForCountry(EbayCountry ebaycountry)
    {
        if (ebaycountry == null)
        {
            throw new IllegalArgumentException("country must not be null");
        }
        int i = 0x7f0707ad;
        if ("AU".equals(ebaycountry.getCountryCode()))
        {
            i = 0x7f0707ae;
        }
        return i;
    }

}
