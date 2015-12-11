// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.net.Uri;
import com.target.mothership.b;
import com.target.mothership.common.page_item.c;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.d;
import com.target.mothership.common.registries.RegistryAlternateId;
import com.target.mothership.model.guest.interfaces.OrderSummaryProduct;
import com.target.mothership.services.apigee.b.a.a;

public class p
{

    private static final int CARTWHEEL_IMAGE_SIZES[] = {
        37, 60, 75, 85, 106, 138, 150, 160, 180, 212, 
        276, 300, 360
    };
    public static final String CARTWHEEL_IMAGE_TARGET = "${productImageSize}";
    private static final String DEFAULT_APPAREL_IMAGE_URL = "http://target.scene7.com/is/image/Target/m-targetapp-apparelproduct";
    private static final String DEFAULT_HEAVY_IMAGE_URL = "http://target.scene7.com/is/image/Target/m-targetapp-heavyproduct";
    private static final String DEFAULT_LIGHT_IMAGE_URL = "http://target.scene7.com/is/image/Target/m-targetapp-lightproduct";
    private static final String DEFAULT_SMALL_IMAGE_URL = "http://target.scene7.com/is/image/Target/m-targetapp-smallproduct";
    private static final String DOMAIN_SCENE7_TYPE_1 = "target.scene7.com";
    private static final String DOMAIN_SCENE7_TYPE_2 = "scene7.targetimg1.com";
    private static final String DOMAIN_SHOP_LOCAL = "shoplocal.com";
    private static final String KEYWORD_CARTWHEEL = "${productImageSize}";
    private static final String ORDER_SUMMARY_IMAGE_EXPECTED_URL_FORMAT = "https://scene7-secure.targetimg1.com/is/image/Target/";
    private static final String SCENE_7_HEIGHT_PARAM = "hei";

    private static String a(int i)
    {
        int j = CARTWHEEL_IMAGE_SIZES[0];
        int ai[] = CARTWHEEL_IMAGE_SIZES;
        int l = ai.length;
        int k = 0;
        do
        {
label0:
            {
                if (k < l)
                {
                    j = ai[k];
                    if (j < i)
                    {
                        break label0;
                    }
                }
                return String.format("_%dx%d", new Object[] {
                    Integer.valueOf(j), Integer.valueOf(j)
                });
            }
            k++;
        } while (true);
    }

    public static String a(d d1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$page_item$ImageType[];
            static final int $SwitchMap$com$target$mothership$common$product$Department[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$Department = new int[com.target.mothership.common.product.d.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.APPAREL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.BABY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.FURNITURE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.GARAGE_HARDWARE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.GIFTS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.HOME.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.KITCHEN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.LAUNDRY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.LAUNDRY_CLEANING_CLOSET.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.PATIO_OUTDOOR_DECOR.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.SPORTING_GOODS.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.ELECTRONICS.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.TOYS.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.GROCERY.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.HEALTH_BEAUTY.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.JEWELRY.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.STATIONERY_OFFICE_SUPPLIES.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.SERVICES.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.UNKNOWN.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$target$mothership$common$page_item$ImageType = new int[com.target.mothership.common.page_item.c.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$ImageType[c.CARTWHEEL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$ImageType[c.SCENE_7.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$ImageType[c.SHOPLOCAL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$ImageType[c.FIXED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$page_item$ImageType[c.UNKNOWN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.Department[d1.ordinal()])
        {
        default:
            return "http://target.scene7.com/is/image/Target/m-targetapp-smallproduct";

        case 1: // '\001'
            return "http://target.scene7.com/is/image/Target/m-targetapp-apparelproduct";

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return "http://target.scene7.com/is/image/Target/m-targetapp-heavyproduct";

        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return "http://target.scene7.com/is/image/Target/m-targetapp-lightproduct";

        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
            return "http://target.scene7.com/is/image/Target/m-targetapp-smallproduct";
        }
    }

    public static String a(RegistryAlternateId registryalternateid, Double double1)
        throws IllegalArgumentException
    {
        if (registryalternateid == null || double1 == null)
        {
            throw new IllegalArgumentException("The registryId or xSizeRatio cannot be null");
        }
        if (double1.doubleValue() > 1.0D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The target xSizeRatio of ").append(double1).append(" is above the maximum of one").toString());
        } else
        {
            return a(registryalternateid.a(), double1);
        }
    }

    public static String a(OrderSummaryProduct ordersummaryproduct, int i)
        throws IllegalArgumentException
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The target height of ").append(i).append(" is below the minimum of zero").toString());
        }
        if (ordersummaryproduct == null)
        {
            throw new IllegalArgumentException("The orderSummaryProduct may not be null");
        } else
        {
            ordersummaryproduct = ordersummaryproduct.k_();
            return c((new StringBuilder()).append("https://scene7-secure.targetimg1.com/is/image/Target/").append(ordersummaryproduct.b()).toString(), i);
        }
    }

    public static String a(String s, int i)
    {
        return a(s, i, c.UNKNOWN);
    }

    public static String a(String s, int i, c c1)
        throws IllegalArgumentException
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("The target height of ").append(i).append(" is below the minimum of zero").toString());
        }
        if (s == null)
        {
            return null;
        }
        c c2 = c1;
        if (c1 == null)
        {
            c2 = c.UNKNOWN;
        }
        c1 = c2;
        if (c2.equals(c.UNKNOWN))
        {
            if (s.contains("${productImageSize}"))
            {
                c1 = c.CARTWHEEL;
            } else
            if (s.contains("target.scene7.com") || s.contains("scene7.targetimg1.com"))
            {
                c1 = c.SCENE_7;
            } else
            {
                c1 = c2;
                if (s.contains("shoplocal.com"))
                {
                    c1 = c.SHOPLOCAL;
                }
            }
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.page_item.ImageType[c1.ordinal()])
        {
        default:
            return s;

        case 1: // '\001'
            return b(s, i);

        case 2: // '\002'
            return c(s, i);

        case 3: // '\003'
            return d(s, i);
        }
    }

    private static String a(String s, Double double1)
    {
        return (new a(com.target.mothership.b.a().b())).a(s, double1).e();
    }

    private static String b(String s, int i)
    {
        return s.replace("${productImageSize}", a(i));
    }

    private static String c(String s, int i)
    {
        s = Uri.parse(s).buildUpon();
        s.clearQuery().appendQueryParameter("hei", String.valueOf(i));
        return s.toString();
    }

    private static String d(String s, int i)
    {
        return s.replaceAll("[0-9]+\\.([0-9]+)\\.([0-9]+)\\.([0-9]+)", (new StringBuilder()).append(i).append(".$1.$2.$3").toString());
    }

}
