// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import com.google.a.a.e;
import com.target.mothership.common.a.b;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.ui.fragment.a;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d
{

    public static String a(Context context, b b1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[];

            static 
            {
                $SwitchMap$com$target$mothership$common$cart$DeliveryMethod = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Standard.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Email.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Mobile.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.None.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Premium.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Express.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Rush.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Seasonal.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.ToTheDoor.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.InsideTheDoor.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.RoomOfChoice.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.WhiteGlove.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.WhiteGloveAssembly.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.cart.DeliveryMethod[b1.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        default:
            return null;

        case 1: // '\001'
            return context.getString(0x7f090134);

        case 5: // '\005'
            return context.getString(0x7f09012e);

        case 6: // '\006'
            return context.getString(0x7f09012a);

        case 7: // '\007'
            return context.getString(0x7f090131);

        case 8: // '\b'
            return context.getString(0x7f090132);

        case 9: // '\t'
            return context.getString(0x7f090135);

        case 10: // '\n'
            return context.getString(0x7f09012b);

        case 11: // '\013'
            return context.getString(0x7f090130);

        case 12: // '\f'
            return context.getString(0x7f090136);

        case 13: // '\r'
            return context.getString(0x7f090137);
        }
    }

    public static String a(Context context, FreeShippingPromotion freeshippingpromotion, CartDetails cartdetails, CartProduct cartproduct)
    {
        if (a(freeshippingpromotion, cartdetails, cartproduct))
        {
            return context.getString(0x7f090124);
        } else
        {
            return context.getString(0x7f090126);
        }
    }

    public static String a(Context context, GiftProduct giftproduct)
    {
        switch (_cls1..SwitchMap.com.target.mothership.common.cart.DeliveryMethod[giftproduct.c().ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return context.getString(0x7f090124);

        case 2: // '\002'
            return context.getString(0x7f0900fe);

        case 3: // '\003'
            return context.getString(0x7f09013a);
        }
    }

    public static String a(Context context, UsableShipMode usableshipmode)
    {
        Date date;
        if (usableshipmode.d().b())
        {
            date = (Date)usableshipmode.d().c();
        } else
        {
            date = null;
        }
        if (usableshipmode.c().b())
        {
            usableshipmode = (Date)usableshipmode.c().c();
        } else
        {
            usableshipmode = null;
        }
        return a(context, date, ((Date) (usableshipmode)));
    }

    public static String a(Context context, Date date, Date date1)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("M/d", Locale.US);
        String s = "";
        if (date != null && date1 != null)
        {
            date = new StringBuilder(simpledateformat.format(date));
            date.append("-");
            date.append(simpledateformat.format(date1));
            date = context.getString(0x7f0900f4, new Object[] {
                date
            });
        } else
        {
            date = s;
            if (date1 != null)
            {
                return context.getString(0x7f0900f5, new Object[] {
                    simpledateformat.format(date1)
                });
            }
        }
        return date;
    }

    private static boolean a(FreeShippingPromotion freeshippingpromotion, CartDetails cartdetails)
    {
        if (freeshippingpromotion != null) goto _L2; else goto _L1
_L1:
        if (cartdetails.c().compareTo(a.FREE_SHIPPING_THRESHOLD) < 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (freeshippingpromotion.b() != com.target.mothership.common.a.e.Active || cartdetails.c().compareTo(freeshippingpromotion.a()) < 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private static boolean a(FreeShippingPromotion freeshippingpromotion, CartDetails cartdetails, CartProduct cartproduct)
    {
        f f1 = cartproduct.d();
        if (f1 == f.StorePickup || f1 == f.ShipToStore)
        {
            return a(freeshippingpromotion, cartdetails);
        }
        cartproduct = cartproduct.c();
        if (cartproduct == b.Standard || cartproduct == b.Seasonal || cartproduct == b.ToTheDoor)
        {
            return a(freeshippingpromotion, cartdetails);
        } else
        {
            return false;
        }
    }
}
