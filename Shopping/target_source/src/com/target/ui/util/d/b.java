// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.google.a.a.e;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.tender.PaymentCardExpiration;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.util.d.a.a;
import com.target.ui.util.d.a.d;
import com.target.ui.util.j;
import com.target.ui.util.q;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class b
{
    private static final class a
    {

        final com.target.mothership.common.tender.b month;
        final Integer year;

        private a(com.target.mothership.common.tender.b b1, Integer integer)
        {
            month = b1;
            year = integer;
        }

    }


    private static final int ADDRESS_LINE_1_INDEX = 0;
    private static final int ADDRESS_LINE_2_INDEX = 1;
    private static final String AMEX_CARD_FORMAT_ONE_STARTING_DIGITS = "34";
    private static final String AMEX_CARD_FORMAT_TWO_STARTING_DIGITS = "37";
    private static final int AMEX_PAYMENT_CARD_INDEX_FIRST = 3;
    private static final int AMEX_PAYMENT_CARD_INDEX_SECOND = 9;
    private static final int AMOUNT_PRECISION = 2;
    private static final int CARD_LAST_NUMBER_OF_DIGITS = 4;
    private static final int CORRECT_AMEX_PAYMENT_CARD_INDEX_FIRST = 4;
    private static final int CORRECT_AMEX_PAYMENT_CARD_INDEX_SECOND = 11;
    private static final int CORRECT_EXPIRY_SEPARATOR_INDEX = 2;
    private static final int CORRECT_GIFT_CARD_INDEX_FIRST = 3;
    private static final int CORRECT_GIFT_CARD_INDEX_FOURTH = 15;
    private static final int CORRECT_GIFT_CARD_INDEX_SECOND = 7;
    private static final int CORRECT_GIFT_CARD_INDEX_THIRD = 11;
    private static final int CORRECT_PAYMENT_CARD_INDEX_FIRST = 4;
    private static final int CORRECT_PAYMENT_CARD_INDEX_SECOND = 9;
    private static final int CORRECT_PAYMENT_CARD_INDEX_THIRD = 14;
    private static final int CORRECT_SHORT_PAYMENT_CARD_INDEX_FIRST = 1;
    private static final int CORRECT_SHORT_PAYMENT_CARD_INDEX_SECOND = 5;
    private static final int CORRECT_SHORT_PAYMENT_CARD_INDEX_THIRD = 9;
    private static final String DEFAULT_COUNTRY_CODE = "US";
    private static final int EMPTY_STRING_LENGTH = 0;
    private static final String EXPIRY_MONTH_FORMAT = "%02d";
    private static final int EXPIRY_SEPARATOR_INDEX = 1;
    private static final int EXPIRY_YEAR_CORRECT_LENGTH = 2;
    private static final int EXPIRY_YEAR_FACTOR = 100;
    private static final int EXPIRY_YEAR_MILLENNIUM = 2000;
    private static final int GIFT_CARD_INDEX_FIRST = 2;
    private static final int GIFT_CARD_INDEX_FOURTH = 11;
    private static final int GIFT_CARD_INDEX_SECOND = 5;
    private static final int GIFT_CARD_INDEX_THIRD = 8;
    private static final int GIFT_CARD_LAST_NUMBER_OF_DIGITS = 3;
    public static final String NAME_PLACE_HOLDER = "Target Guest";
    private static final String NON_NUMERIC_PATTERN = "[^\\d.]";
    private static final int PAYMENT_CARD_INDEX_FIRST = 3;
    private static final int PAYMENT_CARD_INDEX_SECOND = 7;
    private static final int PAYMENT_CARD_INDEX_THIRD = 11;
    private static final String SHORT_CARD_FORMAT_STARTING_DIGIT = "9";
    private static final int SHORT_PAYMENT_CARD_INDEX_FIRST = 0;
    private static final int SHORT_PAYMENT_CARD_INDEX_SECOND = 3;
    private static final int SHORT_PAYMENT_CARD_INDEX_THIRD = 6;
    private static final String TAG = com/target/ui/util/d/b.getSimpleName();
    private static final int TOTAL_EXPIRY_LENGTH = 5;
    private static final int TOTAL_GIFT_CARD_LENGTH = 19;
    private static final int TOTAL_PAYMENT_CARD_AMEX_LENGTH = 17;
    private static final int TOTAL_PAYMENT_CARD_LENGTH = 19;
    private static final int TOTAL_PAYMENT_CARD_SHORT_LENGTH = 13;
    private static final int YEAR_TWO_DIGIT_BOUND_LOWER = 0;
    private static final int YEAR_TWO_DIGIT_BOUND_UPPER = 99;
    private static final int ZIP_CODE_LENGTH = 5;

    public b()
    {
    }

    public static com.target.ui.util.d.a.b a(String s1, String s2)
    {
        if (s1.length() > s2.length())
        {
            return d(s1, s2);
        } else
        {
            return t(s2);
        }
    }

    public static d a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        if (appliedpaymentcardtender == null)
        {
            return new d(null, false);
        }
        if (appliedpaymentcardtender.f().b())
        {
            return new d(c((PaymentCardExpiration)appliedpaymentcardtender.f().c()), true);
        } else
        {
            return new d(null, false);
        }
    }

    public static d a(CardDataModel carddatamodel)
    {
        carddatamodel = b(carddatamodel);
        if (com.target.mothership.util.o.g(carddatamodel))
        {
            return new d(carddatamodel, true);
        } else
        {
            return new d(carddatamodel, false);
        }
    }

    public static String a(Context context, String s1)
    {
        if (!com.target.mothership.util.o.g(s1))
        {
            return null;
        } else
        {
            return String.format(context.getString(0x7f09027e), new Object[] {
                a(s1)
            });
        }
    }

    private static String a(PaymentCardExpiration paymentcardexpiration)
    {
        StringBuilder stringbuilder = new StringBuilder();
        paymentcardexpiration = paymentcardexpiration.a();
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[];

            static 
            {
                $SwitchMap$com$target$mothership$common$tender$ExpiryMonth = new int[com.target.mothership.common.tender.b.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.January.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.February.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.March.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.April.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.May.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.June.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.July.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.August.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.September.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.October.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.November.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$ExpiryMonth[com.target.mothership.common.tender.b.December.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.tender.ExpiryMonth[paymentcardexpiration.ordinal()])
        {
        default:
            return paymentcardexpiration.toString();

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            stringbuilder.append("0");
            break;
        }
        stringbuilder.append(paymentcardexpiration.toString());
        return stringbuilder.toString();
    }

    public static String a(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() < 4)
        {
            return "";
        } else
        {
            return s1.substring(s1.length() - 4, s1.length());
        }
    }

    public static String a(BigDecimal bigdecimal)
    {
        if (bigdecimal == null)
        {
            return "";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("$");
            stringbuilder.append(bigdecimal.setScale(2, RoundingMode.CEILING));
            return stringbuilder.toString();
        }
    }

    public static com.target.ui.util.d.a.b b(String s1, String s2)
    {
        int j1 = 0;
        int i1;
        if (com.target.mothership.util.o.a(s1))
        {
            i1 = 0;
        } else
        {
            i1 = s1.length();
        }
        if (!com.target.mothership.util.o.a(s2))
        {
            j1 = s2.length();
        }
        if (i1 > j1)
        {
            return e(s1, s2);
        } else
        {
            return u(s2);
        }
    }

    private static String b(PaymentCardExpiration paymentcardexpiration)
    {
        paymentcardexpiration = String.valueOf(paymentcardexpiration.b());
        if (paymentcardexpiration.length() < 2)
        {
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("cannot format expiration year string from input year integer: ").append(paymentcardexpiration).toString());
            return "";
        } else
        {
            return paymentcardexpiration.substring(paymentcardexpiration.length() - 2);
        }
    }

    private static String b(CardDataModel carddatamodel)
    {
        if (carddatamodel == null || carddatamodel.d() == null || carddatamodel.e() == null)
        {
            return null;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(String.format("%02d", new Object[] {
                Integer.valueOf(carddatamodel.d())
            }));
            stringbuilder.append("/");
            stringbuilder.append(Integer.valueOf(carddatamodel.e()).intValue() % 100);
            return stringbuilder.toString();
        }
    }

    public static String b(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() < 3)
        {
            return "";
        } else
        {
            return s1.substring(s1.length() - 3, s1.length());
        }
    }

    public static String b(BigDecimal bigdecimal)
    {
        if (bigdecimal == null)
        {
            return "";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("-");
            stringbuilder.append("$");
            stringbuilder.append(bigdecimal.setScale(2, RoundingMode.CEILING));
            return stringbuilder.toString();
        }
    }

    public static com.target.ui.util.d.a.a c(String s1, String s2)
    {
        if (s1.length() > s2.length())
        {
            return f(s1, s2);
        } else
        {
            return v(s2);
        }
    }

    public static com.target.ui.util.d.a.e c(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 19)
        {
            return new com.target.ui.util.d.a.e("", "");
        }
        s1 = d(s1);
        StringBuilder stringbuilder = new StringBuilder();
        char ac[] = s1.toCharArray();
        for (int i1 = 0; i1 < ac.length; i1++)
        {
            stringbuilder.append(ac[i1]);
            if (i1 == 2 || i1 == 5 || i1 == 8 || i1 == 11)
            {
                stringbuilder.append("-");
            }
        }

        return new com.target.ui.util.d.a.e(s1, stringbuilder.toString());
    }

    private static String c(PaymentCardExpiration paymentcardexpiration)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a(paymentcardexpiration));
        stringbuilder.append("/");
        stringbuilder.append(b(paymentcardexpiration));
        return stringbuilder.toString();
    }

    private static com.target.ui.util.d.a.b d(String s1, String s2)
    {
        boolean flag = true;
        String s3;
        if (s2.length() <= 1 || !String.valueOf(s2.charAt(s2.length() - 1)).equals("-") || s2.length() >= s1.length())
        {
            flag = false;
        }
        s3 = s2.substring(0, s2.length() - 1);
        if (s2.length() != 0 && s2.length() < s1.length() && s1.equals((new StringBuilder()).append(s2).append("-").toString()))
        {
            s3 = s2.substring(0, s2.length() - 2);
        }
        return new com.target.ui.util.d.a.b(flag, s1, d(s2), s3);
    }

    public static String d(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 19)
        {
            s1 = "";
        } else
        {
            String s2 = s1.replace("-", "");
            s1 = s2;
            if (s2.isEmpty())
            {
                return "";
            }
        }
        return s1;
    }

    public static com.target.ui.util.d.a.b e(String s1)
    {
        return u(s1);
    }

    private static com.target.ui.util.d.a.b e(String s1, String s2)
    {
        String s3;
        boolean flag;
        if (s2.length() != 0 && s2.length() < s1.length() && s1.equals((new StringBuilder()).append(s2).append(" ").toString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s3 = s2.substring(0, s2.length() - 1);
        return new com.target.ui.util.d.a.b(flag, s1, q(s2), s3);
    }

    private static com.target.ui.util.d.a.a f(String s1, String s2)
    {
        String s3;
        a a1;
        boolean flag;
        if (s2.length() != 0 && s2.length() < s1.length() && s1.equals((new StringBuilder()).append(s2).append("/").toString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s3 = s2.substring(0, s2.length() - 1);
        s2 = k(s2);
        a1 = w(s3);
        return new com.target.ui.util.d.a.a(flag, s1, s2, s3, a1.month, a1.year);
    }

    public static String f(String s1)
    {
        String s2 = s1;
        if (com.target.mothership.util.o.g(s1))
        {
            s2 = s1;
            if (s1.length() > 5)
            {
                s2 = s1.substring(0, 5);
            }
        }
        return s2;
    }

    public static String g(String s1)
    {
        if (!com.target.mothership.util.o.g(s1))
        {
            return s1;
        } else
        {
            return s1.replaceAll("[^\\d.]", "");
        }
    }

    public static String h(String s1)
    {
        if (!com.target.mothership.util.o.g(s1))
        {
            return s1;
        }
        if (com.target.ui.util.j.b())
        {
            s1 = PhoneNumberUtils.formatNumber(s1, "US");
        } else
        {
            s1 = PhoneNumberUtils.formatNumber(s1);
        }
        return s1;
    }

    private static boolean i(String s1)
    {
_L2:
        return false;
        if (com.target.mothership.util.o.c(s1) || s1.length() > 5 || s1.length() == 2) goto _L2; else goto _L1
_L1:
        s1 = s1.toCharArray();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= s1.length)
                {
                    break label1;
                }
                if (i1 == 2 && s1[i1] != '/')
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    private static com.target.ui.util.d.a.e j(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 5)
        {
            return new com.target.ui.util.d.a.e("", "");
        }
        s1 = k(s1);
        StringBuilder stringbuilder = new StringBuilder();
        char ac[] = s1.toCharArray();
        for (int i1 = 0; i1 < ac.length; i1++)
        {
            stringbuilder.append(ac[i1]);
            if (i1 == 1)
            {
                stringbuilder.append("/");
            }
        }

        return new com.target.ui.util.d.a.e(s1, stringbuilder.toString());
    }

    private static String k(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 5)
        {
            s1 = "";
        } else
        {
            String s2 = s1.replace("/", "");
            s1 = s2;
            if (s2.isEmpty())
            {
                return "";
            }
        }
        return s1;
    }

    private static boolean l(String s1)
    {
_L2:
        return false;
        if (com.target.mothership.util.o.c(s1) || s1.length() > 19 || s1.length() == 4 || s1.length() == 9 || s1.length() == 14) goto _L2; else goto _L1
_L1:
        s1 = s1.toCharArray();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= s1.length)
                {
                    break label1;
                }
                if (s1[i1] != ' ' && (i1 == 4 || i1 == 9 || i1 == 14))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    private static boolean m(String s1)
    {
_L2:
        return false;
        if (com.target.mothership.util.o.c(s1) || s1.length() > 13 || s1.length() == 1 || s1.length() == 5 || s1.length() == 9) goto _L2; else goto _L1
_L1:
        s1 = s1.toCharArray();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= s1.length)
                {
                    break label1;
                }
                if (s1[i1] != ' ' && (i1 == 1 || i1 == 5 || i1 == 9))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    private static boolean n(String s1)
    {
_L2:
        return false;
        if (com.target.mothership.util.o.c(s1) || s1.length() > 17 || s1.length() == 4 || s1.length() == 11) goto _L2; else goto _L1
_L1:
        s1 = s1.toCharArray();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= s1.length)
                {
                    break label1;
                }
                if (s1[i1] != ' ' && (i1 == 4 || i1 == 11))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    private static com.target.ui.util.d.a.e o(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 13)
        {
            return new com.target.ui.util.d.a.e("", "");
        }
        s1 = q(s1);
        StringBuilder stringbuilder = new StringBuilder();
        char ac[] = s1.toCharArray();
        for (int i1 = 0; i1 < ac.length; i1++)
        {
            stringbuilder.append(ac[i1]);
            if (i1 == 0 || i1 == 3 || i1 == 6)
            {
                stringbuilder.append(" ");
            }
        }

        return new com.target.ui.util.d.a.e(s1, stringbuilder.toString());
    }

    private static com.target.ui.util.d.a.e p(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 19)
        {
            return new com.target.ui.util.d.a.e("", "");
        }
        s1 = q(s1);
        StringBuilder stringbuilder = new StringBuilder();
        char ac[] = s1.toCharArray();
        for (int i1 = 0; i1 < ac.length; i1++)
        {
            stringbuilder.append(ac[i1]);
            if (i1 == 3 || i1 == 7 || i1 == 11)
            {
                stringbuilder.append(" ");
            }
        }

        return new com.target.ui.util.d.a.e(s1, stringbuilder.toString());
    }

    private static String q(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 19)
        {
            s1 = "";
        } else
        {
            String s2 = s1.replace(" ", "");
            s1 = s2;
            if (s2.isEmpty())
            {
                return "";
            }
        }
        return s1;
    }

    private static com.target.ui.util.d.a.e r(String s1)
    {
        if (com.target.mothership.util.o.c(s1) || s1.length() > 17)
        {
            return new com.target.ui.util.d.a.e("", "");
        }
        s1 = q(s1);
        StringBuilder stringbuilder = new StringBuilder();
        char ac[] = s1.toCharArray();
        for (int i1 = 0; i1 < ac.length; i1++)
        {
            stringbuilder.append(ac[i1]);
            if (i1 == 3 || i1 == 9)
            {
                stringbuilder.append(" ");
            }
        }

        return new com.target.ui.util.d.a.e(s1, stringbuilder.toString());
    }

    private static boolean s(String s1)
    {
_L2:
        return false;
        if (com.target.mothership.util.o.c(s1) || s1.length() > 19 || s1.length() == 3 || s1.length() == 7 || s1.length() == 11 || s1.length() == 15) goto _L2; else goto _L1
_L1:
        s1 = s1.toCharArray();
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= s1.length)
                {
                    break label1;
                }
                if (s1[i1] != '-' && (i1 == 3 || i1 == 7 || i1 == 11 || i1 == 15))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    private static com.target.ui.util.d.a.b t(String s1)
    {
        boolean flag = false;
        if (!s(s1))
        {
            flag = true;
        }
        com.target.ui.util.d.a.e e1 = c(s1);
        return new com.target.ui.util.d.a.b(flag, s1, e1.noFormatting, e1.withFormatting);
    }

    private static com.target.ui.util.d.a.b u(String s1)
    {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag = true;
        if (com.target.mothership.util.o.a(s1))
        {
            return new com.target.ui.util.d.a.b(false, "", "", "");
        }
        if (s1.startsWith("9"))
        {
            com.target.ui.util.d.a.e e1;
            if (m(s1))
            {
                flag = false;
            }
            e1 = o(s1);
        } else
        if (s1.length() <= 17 && (s1.startsWith("34") || s1.startsWith("37")))
        {
            if (!n(s1))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            e1 = r(s1);
        } else
        {
            if (!l(s1))
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            e1 = p(s1);
        }
        return new com.target.ui.util.d.a.b(flag, s1, e1.noFormatting, e1.withFormatting);
    }

    private static com.target.ui.util.d.a.a v(String s1)
    {
        boolean flag = false;
        if (!i(s1))
        {
            flag = true;
        }
        com.target.ui.util.d.a.e e1 = j(s1);
        a a1 = w(s1);
        return new com.target.ui.util.d.a.a(flag, s1, e1.noFormatting, e1.withFormatting, a1.month, a1.year);
    }

    private static a w(String s1)
    {
        if (com.target.mothership.util.o.e(s1))
        {
            return new a(null, null, null);
        }
        String as[] = s1.split("/", 2);
        Integer integer;
        if (as.length > 0)
        {
            s1 = x(as[0]);
        } else
        {
            s1 = null;
        }
        if (as.length > 1)
        {
            integer = y(as[1]);
        } else
        {
            integer = null;
        }
        return new a(s1, integer, null);
    }

    private static com.target.mothership.common.tender.b x(String s1)
    {
        if (com.target.mothership.util.o.e(s1))
        {
            return null;
        }
        try
        {
            s1 = Integer.valueOf(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return com.target.mothership.common.tender.b.a(s1.toString());
    }

    private static Integer y(String s1)
    {
        if (!com.target.mothership.util.o.e(s1) && s1.length() == 2)
        {
            try
            {
                s1 = Integer.valueOf(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return null;
            }
            if (s1.intValue() <= 99 && s1.intValue() >= 0)
            {
                return Integer.valueOf(s1.intValue() + 2000);
            }
        }
        return null;
    }

}
