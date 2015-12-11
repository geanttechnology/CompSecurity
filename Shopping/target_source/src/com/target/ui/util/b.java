// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.f;
import com.target.mothership.model.guest.interfaces.a.m;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public final class b
{

    private static final long DAY_IN_MILLIS = 0x5265c00L;
    private static final int MIN_DIFF_IN_DAYS_FOR_REFRESH = 29;

    public static int a(f f1)
    {
        f1 = f1.f();
        if (f1.isEmpty())
        {
            return 0x7f090278;
        }
        f1 = f1.iterator();
        int i = 0x7f090278;
        do
        {
            if (f1.hasNext())
            {
                com.target.mothership.model.guest.interfaces.a.f.a a1 = (com.target.mothership.model.guest.interfaces.a.f.a)f1.next();
                static class _cls1
                {

                    static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason[];
                    static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason[];
                    static final int $SwitchMap$com$target$mothership$model$guest$interfaces$error$UpdatePaymentTenderFailure$UpdatePaymentTenderFailureReason[];

                    static 
                    {
                        $SwitchMap$com$target$mothership$model$guest$interfaces$error$UpdatePaymentTenderFailure$UpdatePaymentTenderFailureReason = new int[com.target.mothership.model.guest.interfaces.a.m.a.values().length];
                        try
                        {
                            $SwitchMap$com$target$mothership$model$guest$interfaces$error$UpdatePaymentTenderFailure$UpdatePaymentTenderFailureReason[com.target.mothership.model.guest.interfaces.a.m.a.ERR_CARD_INFORMATION_INVALID.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason = new int[com.target.mothership.model.guest.interfaces.a.f.a.values().length];
                        try
                        {
                            $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason[com.target.mothership.model.guest.interfaces.a.f.a.ERR_INVALID_ADDRESS_TYPE.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$target$mothership$model$guest$interfaces$error$DeleteAddressFailure$DeleteAddressFailureReason[com.target.mothership.model.guest.interfaces.a.f.a.UNKNOWN.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason = new int[com.target.mothership.model.guest.interfaces.a.a.a.values().length];
                        try
                        {
                            $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason[com.target.mothership.model.guest.interfaces.a.a.a.ERR_GIFT_CARD_ACCESS_NUMBER_INVALID.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$target$mothership$model$guest$interfaces$error$AddGiftCardTenderFailure$AddGiftCardTenderFailureReason[com.target.mothership.model.guest.interfaces.a.a.a.ERR_GIFT_CARD_ALREADY_ADDED.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls1..SwitchMap.com.target.mothership.model.guest.interfaces.error.DeleteAddressFailure.DeleteAddressFailureReason[a1.ordinal()])
                {
                default:
                    i = 0x7f090278;
                    break;

                case 1: // '\001'
                    i = 0x7f0901e3;
                    break;
                }
            } else
            {
                return i;
            }
        } while (true);
    }

    public static int a(m m1)
    {
        m1 = m1.f();
        if (m1.isEmpty())
        {
            return 0x7f090278;
        }
        m1 = m1.iterator();
        int i = 0x7f090278;
        do
        {
            if (m1.hasNext())
            {
                com.target.mothership.model.guest.interfaces.a.m.a a1 = (com.target.mothership.model.guest.interfaces.a.m.a)m1.next();
                switch (_cls1..SwitchMap.com.target.mothership.model.guest.interfaces.error.UpdatePaymentTenderFailure.UpdatePaymentTenderFailureReason[a1.ordinal()])
                {
                default:
                    i = 0x7f090278;
                    break;

                case 1: // '\001'
                    i = 0x7f0901fc;
                    break;
                }
            } else
            {
                return i;
            }
        } while (true);
    }

    public static String a(Context context, com.target.mothership.model.guest.interfaces.a.a.a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        switch (_cls1..SwitchMap.com.target.mothership.model.guest.interfaces.error.AddGiftCardTenderFailure.AddGiftCardTenderFailureReason[a1.ordinal()])
        {
        default:
            return context.getString(0x7f090082);

        case 1: // '\001'
            return context.getString(0x7f090082);

        case 2: // '\002'
            return context.getString(0x7f090081);
        }
    }

    public static boolean a(Guest guest)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(guest.getExpirationDate());
        guest = Calendar.getInstance();
        return (int)((calendar.getTimeInMillis() - guest.getTimeInMillis()) / 0x5265c00L) < 29;
    }
}
