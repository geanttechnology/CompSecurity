// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile:
//            Item, MyApp

public class ItemViewPayPalable
{

    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logPaymentHandling = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayPaymentHandling", 3, "Log Payment Handling");

    public ItemViewPayPalable()
    {
    }

    public static boolean canUseImmediatePayment(Item item)
    {
        boolean flag = DeviceConfiguration.getAsync().get(DcsBoolean.PUDOImmediatePayHack);
        return item.autoPay || paisaPayIsAvailableForItem(item) || flag && item.availableForPickupAndDropoff;
    }

    public static boolean canUsePaypal(Context context, Item item)
    {
        return TextUtils.isEmpty(getUsePayPalErrorBuyerIndependent(context, item)) && TextUtils.isEmpty(getUsePayPalErrorBuyerDependent(context, item));
    }

    public static boolean canUsePaypalOptimistic(boolean flag, Context context, Item item)
    {
        if (flag)
        {
            return canUsePaypal(context, item);
        } else
        {
            return TextUtils.isEmpty(getUsePayPalErrorBuyerIndependent(context, item));
        }
    }

    public static String getUsePayPalError(Context context, Item item)
    {
        String s1 = getUsePayPalErrorBuyerIndependent(context, item);
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = getUsePayPalErrorBuyerDependent(context, item);
        }
        return s;
    }

    public static String getUsePayPalErrorBuyerDependent(Context context, Item item)
    {
        String s;
        Resources resources;
        s = "";
        resources = context.getResources();
        if (isPaypalShipping(item)) goto _L2; else goto _L1
_L1:
        context = ViewItemShippingInfo.getShippingType(item);
        int i;
        if (TextUtils.isEmpty(context) || "NotSpecified".equals(context))
        {
            i = 0x7f07068a;
        } else
        {
            i = 0x7f070689;
        }
        item = resources.getString(i);
        context = item;
        if (logPaymentHandling.isLoggable)
        {
            FwLog.println(logPaymentHandling, "fails !isPaypalShipping(item)");
            context = item;
        }
_L4:
        return context;
_L2:
        if (item.autoPay || shipsToCountry(resources, item.buyerCountryCode, item))
        {
            break; /* Loop/switch isn't completed */
        }
        item = resources.getString(0x7f07068c);
        context = item;
        if (logPaymentHandling.isLoggable)
        {
            FwLog.println(logPaymentHandling, "fails shipsToCountry");
            return item;
        }
        if (true) goto _L4; else goto _L3
_L3:
        context = s;
        if (item.autoPay)
        {
            context = s;
            if (item.globalShipping)
            {
                context = s;
                if (!DeviceConfiguration.getAsync().get(DcsBoolean.GSP))
                {
                    context = s;
                    if (!"US".equalsIgnoreCase(item.buyerCountryCode))
                    {
                        item = resources.getString(0x7f07068c);
                        context = item;
                        if (logPaymentHandling.isLoggable)
                        {
                            FwLog.println(logPaymentHandling, "fails autopay GSP etc.");
                            return item;
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private static String getUsePayPalErrorBuyerIndependent(Context context, Item item)
    {
        String s;
        Resources resources;
        DcsHelper dcshelper;
        boolean flag;
        flag = false;
        s = "";
        resources = context.getResources();
        dcshelper = MyApp.getDeviceConfiguration();
        if (sellerHasAvailablePaymentMethod(item)) goto _L2; else goto _L1
_L1:
        context = MyApp.getPrefs().getCurrentCountry();
        item = String.format(resources.getString(0x7f0700c5), new Object[] {
            context.getSiteDomain()
        });
        context = item;
        if (logPaymentHandling.isLoggable)
        {
            FwLog.println(logPaymentHandling, "fails !sellerAcceptsPaypal(item)");
            context = item;
        }
_L4:
        return context;
_L2:
        if (!item.isPartOfOrder)
        {
            break; /* Loop/switch isn't completed */
        }
        item = resources.getString(0x7f070687);
        context = item;
        if (logPaymentHandling.isLoggable)
        {
            FwLog.println(logPaymentHandling, "fails isPartOfOrder");
            return item;
        }
        if (true) goto _L4; else goto _L3
_L3:
        context = s;
        if (!dcshelper.isMecOrMec2Enabled(item.site))
        {
            context = item.site;
            if (EbaySite.US.name.equals(context) || EbaySite.AU.name.equals(context) || EbaySite.UK.name.equals(context) || EbaySite.MOTOR.name.equals(context))
            {
                flag = true;
            }
            int i;
            if (flag)
            {
                i = 0x7f070608;
            } else
            {
                i = 0x7f070607;
            }
            item = resources.getString(i);
            context = item;
            if (logPaymentHandling.isLoggable)
            {
                FwLog.println(logPaymentHandling, "disabled in DCS");
                return item;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private static boolean isItemInBuyerCountry(String s, Item item)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            item = EbaySite.getInstanceFromId(item.site);
            flag = flag1;
            if (item != null)
            {
                flag = s.equals(((EbaySite) (item)).localeCountry);
            }
        }
        return flag;
    }

    public static boolean isLocalPickupOrNoShippingInCountry(String s, Item item)
    {
        String s1 = ViewItemShippingInfo.getShippingType(item);
        return isItemInBuyerCountry(s, item) && ("NotSpecified".equals(s1) || ViewItemShippingInfo.IsLocalPickupOnly(item));
    }

    public static boolean isPaypalShipping(Item item)
    {
        boolean flag = false;
        String s = ViewItemShippingInfo.getShippingType(item);
        if ("CalculatedDomesticFlatInternational".equalsIgnoreCase(s) || "FlatDomesticCalculatedInternational".equalsIgnoreCase(s) || "Calculated".equalsIgnoreCase(s) || "Flat".equalsIgnoreCase(s) || isLocalPickupOrNoShippingInCountry(item.buyerCountryCode, item))
        {
            flag = true;
        } else
        {
            item = item.shippingInfo.shippingServiceCost;
            if (item != null)
            {
                return (new CurrencyAmount(item)).compareToZero() >= 0;
            }
        }
        return flag;
    }

    public static boolean isPreviousPaymentRefunded(String s)
    {
        return "Refunded".equals(s);
    }

    public static boolean paisaPayIsAvailableForItem(Item item)
    {
        while (MyApp.getPrefs().getCurrentCountry().site.idInt != 203 || !MyApp.getDeviceConfiguration().isPaisaPayEnabled(item.site) || !Util.isPaisaPayPaymentMethodAvailable(item.paymentMethods)) 
        {
            return false;
        }
        return true;
    }

    private static boolean sellerHasAvailablePaymentMethod(Item item)
    {
        DcsHelper dcshelper;
        if (!Util.getPaymentMethodsAsLocalizedString(item.paymentMethods).contains("PayPal"))
        {
            if ((!(dcshelper = MyApp.getDeviceConfiguration()).isAlternativePaymentMethodsAvailable() || !Util.isAlternatePaymentMethodSupported(item.paymentMethods)) && (!dcshelper.isPaisaPayEnabled(item.site) || !Util.isPaisaPayPaymentMethodAvailable(item.paymentMethods)))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean shipsToCountry(Resources resources, String s, Item item)
    {
        return !TextUtils.isEmpty(s) && (isLocalPickupOrNoShippingInCountry(s, item) || item.shippingInfo.isShippable(resources, item) && item.isValidShippingCountry(s));
    }

}
