// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            BillingAddress

public class CreditCard extends BaseDataMapped
    implements Parcelable
{
    public static class Expiration
    {

        public static String format(String s)
        {
            s = CreditCard.getDigitsOnlyString(s);
            StringBuilder stringbuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                if (i == 0 && c != '0' && c != '1')
                {
                    stringbuilder.append('0');
                    stringbuilder.append(c);
                    return stringbuilder.toString();
                }
                if (i == 1 && s.charAt(0) == '1' && c > '2')
                {
                    return stringbuilder.toString();
                }
                if (i == 2)
                {
                    stringbuilder.append('/');
                }
                stringbuilder.append(c);
            }

            return stringbuilder.toString();
        }

        public static boolean hasFullLength(String s)
        {
            while (TextUtils.isEmpty(s) || CreditCard.getDigitsOnlyString(s).length() != 4) 
            {
                return false;
            }
            return true;
        }

        public static boolean isDateValid(int i, int j)
        {
            if (i >= 1 && 12 >= i)
            {
                Calendar calendar = Calendar.getInstance();
                int k = calendar.get(1) % 100;
                int l = calendar.get(2);
                if (j >= k && (j != k || i >= l + 1) && j <= k + 15)
                {
                    return true;
                }
            }
            return false;
        }

        public static boolean isValid(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return false;
            } else
            {
                s = CreditCard.getDigitsOnlyString(s);
                return isDateValid(Integer.parseInt(s.substring(0, 2)), Integer.parseInt(s.substring(2)));
            }
        }

        public Expiration()
        {
        }
    }

    public static class Number
    {

        private static String formatFifteenString(String s)
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
            {
                if (i == 4 || i == 10)
                {
                    stringbuilder.append(' ');
                }
                stringbuilder.append(s.charAt(i));
            }

            return stringbuilder.toString();
        }

        private static String formatSixteenString(String s)
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++)
            {
                if (i != 0 && i % 4 == 0)
                {
                    stringbuilder.append(' ');
                }
                stringbuilder.append(s.charAt(i));
            }

            return stringbuilder.toString();
        }

        public static String formatString(String s)
        {
            return formatString(s, true, null);
        }

        public static String formatString(String s, boolean flag, Type type1)
        {
            String s1;
            Type type2;
            int i;
            if (flag)
            {
                s1 = CreditCard.getDigitsOnlyString(s);
            } else
            {
                s1 = s;
            }
            type2 = type1;
            if (type1 == null)
            {
                type2 = Type.fromCardNumber(s1);
            }
            i = type2.numberLength();
            type1 = s;
            if (s1.length() > 0)
            {
                if (i == 16)
                {
                    type1 = formatSixteenString(s1);
                } else
                {
                    type1 = s;
                    if (i == 15)
                    {
                        return formatFifteenString(s1);
                    }
                }
            }
            return type1;
        }

        public static boolean hasFullLength(String s)
        {
            if (!TextUtils.isEmpty(s))
            {
                s = CreditCard.getDigitsOnlyString(s);
                Type type1 = Type.fromCardNumber(s);
                if (s.length() == type1.numberLength())
                {
                    return true;
                }
            }
            return false;
        }

        public static boolean passesLuhnChecksum(String s)
        {
            boolean flag = true;
            if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            int j;
            Object obj = CreditCard.getDigitsOnlyString(s);
            j = 0;
            s = (new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
            });
            int ai[] = {
                0, 2, 4, 6, 8, 1, 3, 5, 7, 9
            };
            obj = new StringCharacterIterator(((String) (obj)));
            char c = ((CharacterIterator) (obj)).last();
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (c == '\uFFFF')
                    {
                        break label1;
                    }
                    if (!Character.isDigit(c))
                    {
                        break label0;
                    }
                    j += (new int[][] {
                        s, ai
                    })[i & 1][c - 48];
                    c = ((CharacterIterator) (obj)).previous();
                    i++;
                }
            } while (true);
            if (true) goto _L1; else goto _L3
_L3:
            if (j % 10 != 0)
            {
                flag = false;
            }
            return flag;
        }

        public Number()
        {
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type AMERICANEXPRESS;
        public static final Type DINERSCLUB;
        public static final Type DISCOVER;
        public static final Type INSUFFICIENT_DIGITS;
        public static final Type JCB;
        public static final Type MASTERCARD;
        public static final Type SOLO;
        public static final Type SWITCH;
        public static final Type UNKNOWN;
        public static final Type VISA;
        private static HashMap intervalLookup;
        private static int minDigits;
        public final String token;

        public static Type fromCardNumber(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return UNKNOWN;
            }
            s = CreditCard.getDigitsOnlyString(s);
            HashSet hashset = new HashSet();
            Iterator iterator = getIntervalLookup().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (isNumberInInterval(s, (String)((Pair)entry.getKey()).first, (String)((Pair)entry.getKey()).second))
                {
                    hashset.add(entry.getValue());
                }
            } while (true);
            if (hashset.size() > 1)
            {
                return INSUFFICIENT_DIGITS;
            }
            if (hashset.size() == 1)
            {
                return (Type)hashset.iterator().next();
            } else
            {
                return UNKNOWN;
            }
        }

        public static Type fromString(String s)
        {
            Type atype[];
            int i;
            int j;
            if (s == null)
            {
                return UNKNOWN;
            }
            atype = values();
            j = atype.length;
            i = 0;
_L3:
            Type type1;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            type1 = atype[i];
              goto _L1
_L5:
            i++;
            if (true) goto _L3; else goto _L2
_L1:
            if (type1 == UNKNOWN || type1 == INSUFFICIENT_DIGITS || !s.equalsIgnoreCase(type1.toString())) goto _L5; else goto _L4
_L4:
            return type1;
_L2:
            return UNKNOWN;
        }

        public static final Type fromToken(String s)
        {
            Type atype[] = values();
            int j = atype.length;
            for (int i = 0; i < j; i++)
            {
                Type type1 = atype[i];
                if (TextUtils.equals(s, type1.token))
                {
                    return type1;
                }
            }

            return UNKNOWN;
        }

        private static HashMap getIntervalLookup()
        {
            return intervalLookup;
        }

        private static Pair getNewPair(String s, String s1)
        {
            String s2 = s1;
            if (s1 == null)
            {
                s2 = s;
            }
            return new Pair(s, s2);
        }

        private static boolean isNumberInInterval(String s, String s1, String s2)
        {
            int i = Math.min(s.length(), s1.length());
            for (int j = Math.min(s.length(), s2.length()); Integer.parseInt(s.substring(0, i)) < Integer.parseInt(s1.substring(0, i)) || Integer.parseInt(s.substring(0, j)) > Integer.parseInt(s2.substring(0, j));)
            {
                return false;
            }

            return true;
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/ebay/nautilus/domain/data/CreditCard$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public int cvvLength()
        {
            static class _cls2
            {

                static final int $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type = new int[Type.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.AMERICANEXPRESS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.JCB.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.MASTERCARD.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.VISA.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.DISCOVER.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.INSUFFICIENT_DIGITS.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[Type.UNKNOWN.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls2..SwitchMap.com.ebay.nautilus.domain.data.CreditCard.Type[ordinal()])
            {
            default:
                return -1;

            case 1: // '\001'
                return 4;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                return 3;
            }
        }

        public int numberLength()
        {
            switch (_cls2..SwitchMap.com.ebay.nautilus.domain.data.CreditCard.Type[ordinal()])
            {
            default:
                return -1;

            case 1: // '\001'
                return 15;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                return 16;

            case 6: // '\006'
                return minDigits;
            }
        }

        public String toString()
        {
            return token;
        }

        static 
        {
            INSUFFICIENT_DIGITS = new Type("INSUFFICIENT_DIGITS", 0, "MORE_DIGITS_REQUIRED");
            UNKNOWN = new Type("UNKNOWN", 1, "UNKNOWN");
            SWITCH = new Type("SWITCH", 2, "SWITCH");
            SOLO = new Type("SOLO", 3, "SOLO");
            MASTERCARD = new Type("MASTERCARD", 4, "MASTERCARD");
            VISA = new Type("VISA", 5, "VISA");
            AMERICANEXPRESS = new Type("AMERICANEXPRESS", 6, "AMERICANEXPRESS");
            DISCOVER = new Type("DISCOVER", 7, "DISCOVER");
            DINERSCLUB = new Type("DINERSCLUB", 8, "DINERSCLUB");
            JCB = new Type("JCB", 9, "JCB");
            $VALUES = (new Type[] {
                INSUFFICIENT_DIGITS, UNKNOWN, SWITCH, SOLO, MASTERCARD, VISA, AMERICANEXPRESS, DISCOVER, DINERSCLUB, JCB
            });
            minDigits = 1;
            intervalLookup = new HashMap();
            intervalLookup.put(getNewPair("34", null), AMERICANEXPRESS);
            intervalLookup.put(getNewPair("37", null), AMERICANEXPRESS);
            intervalLookup.put(getNewPair("3528", "3589"), JCB);
            intervalLookup.put(getNewPair("4", null), VISA);
            intervalLookup.put(getNewPair("51", "55"), MASTERCARD);
            intervalLookup.put(getNewPair("6011", null), DISCOVER);
            intervalLookup.put(getNewPair("622126", "622925"), DISCOVER);
            intervalLookup.put(getNewPair("644", "649"), DISCOVER);
            intervalLookup.put(getNewPair("65", null), DISCOVER);
            Iterator iterator = getIntervalLookup().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                minDigits = Math.max(minDigits, ((String)((Pair)entry.getKey()).first).length());
                if (((Pair)entry.getKey()).second != null)
                {
                    minDigits = Math.max(minDigits, ((String)((Pair)entry.getKey()).second).length());
                }
            } while (true);
        }

        private Type(String s, int i, String s1)
        {
            super(s, i);
            token = s1;
        }
    }

    public static class Type.Deserializer
        implements JsonDeserializer
    {

        public Type deserialize(JsonElement jsonelement, java.lang.reflect.Type type1, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return Type.fromToken(jsonelement.getAsString());
        }

        public volatile Object deserialize(JsonElement jsonelement, java.lang.reflect.Type type1, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type1, jsondeserializationcontext);
        }

        public Type.Deserializer()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CreditCard createFromParcel(Parcel parcel)
        {
            return (CreditCard)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/CreditCard);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CreditCard[] newArray(int i)
        {
            return new CreditCard[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int EXPIRY_MAX_FUTURE_YEARS = 15;
    public String accountHolderName;
    public BillingAddress billingAddress;
    public String cardNumber;
    public String cardNumberLastFour;
    public String cvvNumber;
    public int expireMonth;
    public int expireYear;
    public Type type;

    public CreditCard()
    {
    }

    public static String getDigitsOnlyString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        s = s.toCharArray();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            char c = s[i];
            if (Character.isDigit(c))
            {
                stringbuilder.append(c);
            }
        }

        return stringbuilder.toString();
    }

    public static String renderExpirationDate(CreditCard creditcard)
    {
        if (creditcard.expireMonth > 0 && creditcard.expireYear > 0)
        {
            return String.format(Locale.getDefault(), "%02d/%02d", new Object[] {
                Integer.valueOf(creditcard.expireMonth), Integer.valueOf(creditcard.expireYear % 100)
            });
        } else
        {
            return null;
        }
    }

    public String getMaskedCvv()
    {
        if (type == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i <= type.cvvLength() - 1; i++)
        {
            stringbuilder.append("\u2022");
        }

        return stringbuilder.toString();
    }

    public String getMaskedNumber()
    {
        while (type == null || cardNumberLastFour == null && cardNumber == null) 
        {
            return null;
        }
        String s;
        StringBuilder stringbuilder;
        if (cardNumberLastFour != null)
        {
            s = cardNumberLastFour;
        } else
        {
            s = cardNumber.substring(cardNumber.length() - 4);
        }
        stringbuilder = new StringBuilder();
        for (int i = 0; i <= type.numberLength() - s.length() - 1; i++)
        {
            stringbuilder.append("\u2022");
        }

        stringbuilder.append(s);
        return Number.formatString(stringbuilder.toString(), false, type);
    }

}
