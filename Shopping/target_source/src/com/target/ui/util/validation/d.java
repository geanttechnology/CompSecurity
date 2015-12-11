// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import com.target.mothership.common.tender.a;
import com.target.mothership.common.tender.b;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.util.o;
import com.target.ui.util.d.a.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.target.ui.util.validation:
//            h

public class d
{

    private static final int MAX_AMEX_CVV_LENGTH = 4;
    private static final int MAX_CVV_LENGTH = 3;
    private static final int MAX_PIN_LENGTH = 4;
    private static final int PAYMENT_AMEX_CARD_LENGTH_SHORT = 15;
    private static final int PAYMENT_CARD_LENGTH_LONG = 16;
    private static final int PAYMENT_CARD_LENGTH_SHORT = 10;

    public static int a(a a1)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return 3;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$tender$CardType[];
            static final int $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[];

            static 
            {
                $SwitchMap$com$target$mothership$common$tender$ExpiryMonth = new int[com.target.mothership.common.tender.b.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.January.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.February.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.March.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.April.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.May.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.June.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.July.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.August.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.September.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.October.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.November.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[b.December.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                $SwitchMap$com$target$mothership$common$tender$CardType = new int[com.target.mothership.common.tender.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_DEBIT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.AMEX.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.DISCOVER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.MASTER_CARD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_VISA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_MASTERCARD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.VISA.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_CARD.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_BUSINESS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[a1.ordinal()])
        {
        default:
            return 4;

        case 2: // '\002'
            return 4;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static int a(b b1)
    {
        switch (_cls1..SwitchMap.com.target.mothership.common.tender.ExpiryMonth[b1.ordinal()])
        {
        default:
            return 0;

        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 2;

        case 3: // '\003'
            return 3;

        case 4: // '\004'
            return 4;

        case 5: // '\005'
            return 5;

        case 6: // '\006'
            return 6;

        case 7: // '\007'
            return 7;

        case 8: // '\b'
            return 8;

        case 9: // '\t'
            return 9;

        case 10: // '\n'
            return 10;

        case 11: // '\013'
            return 11;

        case 12: // '\f'
            return 12;
        }
    }

    public static int a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        if (appliedpaymentcardtender == null)
        {
            return 3;
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.tender.CardType[appliedpaymentcardtender.d().ordinal()])
        {
        default:
            return 3;

        case 1: // '\001'
            return 4;

        case 2: // '\002'
            return 4;
        }
    }

    public static c a(String s)
    {
        if (com.target.ui.view.checkout.d.TARGET_BUSINESS_START_PATTERN.matcher(s).matches())
        {
            return new c(a.TARGET_BUSINESS, 10);
        }
        if (com.target.ui.view.checkout.d.TARGET_BUSINESS_START_PATTERN_NEW.matcher(s).matches())
        {
            return new c(a.TARGET_BUSINESS, 16);
        }
        if (com.target.ui.view.checkout.d.TARGET_DEBIT_START_PATTERN.matcher(s).matches())
        {
            return new c(a.TARGET_DEBIT, 16);
        }
        if (com.target.ui.view.checkout.d.TARGET_MASTERCARD_START_PATTERN.matcher(s).matches())
        {
            return new c(a.TARGET_MASTERCARD, 16);
        }
        if (com.target.ui.view.checkout.d.TARGET_VISA_START_PATTERN.matcher(s).matches())
        {
            return new c(a.TARGET_VISA, 16);
        }
        if (com.target.ui.view.checkout.d.TARGET_CARD_START_PATTERN.matcher(s).matches())
        {
            return new c(a.TARGET_CARD, 10);
        }
        if (com.target.ui.view.checkout.d.TARGET_CARD_START_PATTERN_NEW.matcher(s).matches())
        {
            return new c(a.TARGET_CARD, 16);
        }
        if (com.target.ui.view.checkout.d.TARGET_RED_CARD_VISA.matcher(s).matches())
        {
            return new c(a.TARGET_RED_CARD, 16);
        }
        if (com.target.ui.view.checkout.d.VISA_START_PATTERN.matcher(s).matches())
        {
            return new c(a.VISA, 16);
        }
        if (com.target.ui.view.checkout.d.AMEX_START_PATTERN.matcher(s).matches())
        {
            return new c(a.AMEX, 15);
        }
        if (com.target.ui.view.checkout.d.MASTERCARD_START_PATTERN.matcher(s).matches())
        {
            return new c(a.MASTER_CARD, 16);
        }
        if (com.target.ui.view.checkout.d.DISCOVER_START_PATTERN.matcher(s).matches())
        {
            return new c(a.DISCOVER, 16);
        } else
        {
            return new c(a.UNKNOWN, 16);
        }
    }

    public static boolean a(a a1, String s)
    {
        while (a1 == null || !o.g(s) || s.length() != a(a1)) 
        {
            return false;
        }
        return true;
    }

    public static boolean a(b b1, Integer integer)
    {
        if (b1 == null || integer == null)
        {
            return false;
        } else
        {
            return (new com.i.a.a.a("", Integer.valueOf(a(b1)), Integer.valueOf(integer.intValue()), "")).b();
        }
    }

    private static boolean a(c c1, String s)
    {
        if (o.e(s))
        {
            return false;
        } else
        {
            return com.target.ui.util.validation.h.b(s, c1.expectedCardLength);
        }
    }

    public static com.target.ui.util.validation.a.c b(String s)
    {
        com.target.ui.util.validation.a.c.a a1 = null;
        if (o.e(s))
        {
            return new com.target.ui.util.validation.a.c(false, com.target.ui.util.validation.a.c.a.TOO_SHORT, a.UNKNOWN, s);
        }
        c c1 = a(s);
        if (b(c1, s))
        {
            return new com.target.ui.util.validation.a.c(false, com.target.ui.util.validation.a.c.a.TOO_SHORT, c1.cardType, s);
        }
        if (a(c1, s))
        {
            return new com.target.ui.util.validation.a.c(false, com.target.ui.util.validation.a.c.a.TOO_LONG, c1.cardType, s);
        }
        if (b(c1.cardType))
        {
            return new com.target.ui.util.validation.a.c(true, null, c1.cardType, s);
        }
        if (c1.cardType == a.UNKNOWN)
        {
            return new com.target.ui.util.validation.a.c(false, com.target.ui.util.validation.a.c.a.PATTERN_MISMATCH, c1.cardType, s);
        }
        boolean flag = (new com.i.a.a.a(s, Integer.valueOf(0), Integer.valueOf(0), "")).a();
        if (!flag)
        {
            a1 = com.target.ui.util.validation.a.c.a.PATTERN_MISMATCH;
        }
        return new com.target.ui.util.validation.a.c(flag, a1, c1.cardType, s);
    }

    private static boolean b(a a1)
    {
        return a1 == a.TARGET_BUSINESS || a1 == a.TARGET_CARD;
    }

    private static boolean b(c c1, String s)
    {
        if (o.e(s))
        {
            return true;
        } else
        {
            return com.target.ui.util.validation.h.a(s, c1.expectedCardLength);
        }
    }
}
