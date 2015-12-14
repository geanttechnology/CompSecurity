// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.model;

import com.stripe.android.util.DateUtils;
import com.stripe.android.util.TextUtils;
import com.stripe.model.StripeObject;

public class Card extends StripeObject
{

    public static final String AMERICAN_EXPRESS = "American Express";
    public static final String DINERS_CLUB = "Diners Club";
    public static final String DISCOVER = "Discover";
    public static final String JCB = "JCB";
    public static final String MASTERCARD = "MasterCard";
    public static final int MAX_LENGTH_AMERICAN_EXPRESS = 15;
    public static final int MAX_LENGTH_DINERS_CLUB = 14;
    public static final int MAX_LENGTH_STANDARD = 16;
    public static final String PREFIXES_AMERICAN_EXPRESS[] = {
        "34", "37"
    };
    public static final String PREFIXES_DINERS_CLUB[] = {
        "300", "301", "302", "303", "304", "305", "309", "36", "38", "37", 
        "39"
    };
    public static final String PREFIXES_DISCOVER[] = {
        "60", "62", "64", "65"
    };
    public static final String PREFIXES_JCB[] = {
        "35"
    };
    public static final String PREFIXES_MASTERCARD[] = {
        "50", "51", "52", "53", "54", "55"
    };
    public static final String PREFIXES_VISA[] = {
        "4"
    };
    public static final String UNKNOWN = "Unknown";
    public static final String VISA = "Visa";
    private String addressCity;
    private String addressCountry;
    private String addressLine1;
    private String addressLine2;
    private String addressState;
    private String addressZip;
    private String country;
    private String cvc;
    private Integer expMonth;
    private Integer expYear;
    private String fingerprint;
    private String last4;
    private String name;
    private String number;
    private String type;

    private Card(Builder builder)
    {
        number = TextUtils.nullIfBlank(normalizeCardNumber(builder.number));
        expMonth = builder.expMonth;
        expYear = builder.expYear;
        cvc = TextUtils.nullIfBlank(builder.cvc);
        name = TextUtils.nullIfBlank(builder.name);
        addressLine1 = TextUtils.nullIfBlank(builder.addressLine1);
        addressLine2 = TextUtils.nullIfBlank(builder.addressLine2);
        addressCity = TextUtils.nullIfBlank(builder.addressCity);
        addressState = TextUtils.nullIfBlank(builder.addressState);
        addressZip = TextUtils.nullIfBlank(builder.addressZip);
        addressCountry = TextUtils.nullIfBlank(builder.addressCountry);
        last4 = TextUtils.nullIfBlank(builder.last4);
        type = TextUtils.nullIfBlank(builder.type);
        fingerprint = TextUtils.nullIfBlank(builder.fingerprint);
        country = TextUtils.nullIfBlank(builder.country);
        type = getType();
        last4 = getLast4();
    }


    public Card(String s, Integer integer, Integer integer1, String s1)
    {
        this(s, integer, integer1, s1, null, null, null, null, null, null, null, null, null, null, null);
    }

    public Card(String s, Integer integer, Integer integer1, String s1, String s2, String s3, String s4, 
            String s5, String s6, String s7, String s8)
    {
        this(s, integer, integer1, s1, s2, s3, s4, s5, s6, s7, s8, null, null, null, null);
    }

    public Card(String s, Integer integer, Integer integer1, String s1, String s2, String s3, String s4, 
            String s5, String s6, String s7, String s8, String s9, String s10, String s11, 
            String s12)
    {
        number = TextUtils.nullIfBlank(normalizeCardNumber(s));
        expMonth = integer;
        expYear = integer1;
        cvc = TextUtils.nullIfBlank(s1);
        name = TextUtils.nullIfBlank(s2);
        addressLine1 = TextUtils.nullIfBlank(s3);
        addressLine2 = TextUtils.nullIfBlank(s4);
        addressCity = TextUtils.nullIfBlank(s5);
        addressState = TextUtils.nullIfBlank(s6);
        addressZip = TextUtils.nullIfBlank(s7);
        addressCountry = TextUtils.nullIfBlank(s8);
        last4 = TextUtils.nullIfBlank(s9);
        type = TextUtils.nullIfBlank(s10);
        fingerprint = TextUtils.nullIfBlank(s11);
        country = TextUtils.nullIfBlank(s12);
        type = getType();
        last4 = getLast4();
    }

    private boolean isValidLuhnNumber(String s)
    {
        int j = s.length() - 1;
        int k = 0;
        boolean flag = true;
        while (j >= 0) 
        {
            char c = s.charAt(j);
            if (!Character.isDigit(c))
            {
                return false;
            }
            int l = Integer.parseInt(String.valueOf(c));
            int i;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = l;
            if (flag)
            {
                i = l * 2;
            }
            l = i;
            if (i > 9)
            {
                l = i - 9;
            }
            k += l;
            j--;
        }
        return k % 10 == 0;
    }

    private String normalizeCardNumber(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.trim().replaceAll("\\s+|-", "");
        }
    }

    public String getAddressCity()
    {
        return addressCity;
    }

    public String getAddressCountry()
    {
        return addressCountry;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public String getAddressState()
    {
        return addressState;
    }

    public String getAddressZip()
    {
        return addressZip;
    }

    public String getCVC()
    {
        return cvc;
    }

    public String getCountry()
    {
        return country;
    }

    public Integer getExpMonth()
    {
        return expMonth;
    }

    public Integer getExpYear()
    {
        return expYear;
    }

    public String getFingerprint()
    {
        return fingerprint;
    }

    public String getLast4()
    {
        if (!TextUtils.isBlank(last4))
        {
            return last4;
        }
        if (number != null && number.length() > 4)
        {
            return number.substring(number.length() - 4, number.length());
        } else
        {
            return null;
        }
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getType()
    {
        if (TextUtils.isBlank(type) && !TextUtils.isBlank(number))
        {
            if (TextUtils.hasAnyPrefix(number, PREFIXES_AMERICAN_EXPRESS))
            {
                return "American Express";
            }
            if (TextUtils.hasAnyPrefix(number, PREFIXES_DISCOVER))
            {
                return "Discover";
            }
            if (TextUtils.hasAnyPrefix(number, PREFIXES_JCB))
            {
                return "JCB";
            }
            if (TextUtils.hasAnyPrefix(number, PREFIXES_DINERS_CLUB))
            {
                return "Diners Club";
            }
            if (TextUtils.hasAnyPrefix(number, PREFIXES_VISA))
            {
                return "Visa";
            }
            if (TextUtils.hasAnyPrefix(number, PREFIXES_MASTERCARD))
            {
                return "MasterCard";
            } else
            {
                return "Unknown";
            }
        } else
        {
            return type;
        }
    }

    public void setAddressCity(String s)
    {
        addressCity = s;
    }

    public void setAddressCountry(String s)
    {
        addressCountry = s;
    }

    public void setAddressLine1(String s)
    {
        addressLine1 = s;
    }

    public void setAddressLine2(String s)
    {
        addressLine2 = s;
    }

    public void setAddressState(String s)
    {
        addressState = s;
    }

    public void setAddressZip(String s)
    {
        addressZip = s;
    }

    public void setCVC(String s)
    {
        cvc = s;
    }

    public void setExpMonth(Integer integer)
    {
        expMonth = integer;
    }

    public void setExpYear(Integer integer)
    {
        expYear = integer;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setNumber(String s)
    {
        number = s;
    }

    public boolean validateCVC()
    {
        if (!TextUtils.isBlank(cvc))
        {
            String s = cvc.trim();
            boolean flag;
            if (type == null && s.length() >= 3 && s.length() <= 4 || "American Express".equals(type) && s.length() == 4 || !"American Express".equals(type) && s.length() == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (TextUtils.isWholePositiveNumber(s) && flag)
            {
                return true;
            }
        }
        return false;
    }

    public boolean validateCard()
    {
        if (cvc != null) goto _L2; else goto _L1
_L1:
        if (!validateNumber() || !validateExpiryDate()) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!validateNumber() || !validateExpiryDate() || !validateCVC())
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean validateExpMonth()
    {
        while (expMonth == null || expMonth.intValue() <= 0 || expMonth.intValue() > 12) 
        {
            return false;
        }
        return true;
    }

    public boolean validateExpYear()
    {
        while (expYear == null || DateUtils.hasYearPassed(expYear.intValue())) 
        {
            return false;
        }
        return true;
    }

    public boolean validateExpiryDate()
    {
        while (!validateExpMonth() || !validateExpYear() || DateUtils.hasMonthPassed(expYear.intValue(), expMonth.intValue())) 
        {
            return false;
        }
        return true;
    }

    public boolean validateNumber()
    {
        if (!TextUtils.isBlank(number)) goto _L2; else goto _L1
_L1:
        String s;
        return false;
_L2:
        if (TextUtils.isBlank(s = number.trim().replaceAll("\\s+|-", "")) || !TextUtils.isWholePositiveNumber(s) || !isValidLuhnNumber(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!"American Express".equals(type))
        {
            break; /* Loop/switch isn't completed */
        }
        if (s.length() == 15)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!"Diners Club".equals(type))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s.length() != 14) goto _L1; else goto _L4
_L4:
        return true;
        if (s.length() != 16) goto _L1; else goto _L5
_L5:
        return true;
    }


    private class Builder
    {

        private String addressCity;
        private String addressCountry;
        private String addressLine1;
        private String addressLine2;
        private String addressState;
        private String addressZip;
        private String country;
        private final String cvc;
        private final Integer expMonth;
        private final Integer expYear;
        private String fingerprint;
        private String last4;
        private String name;
        private final String number;
        private String type;

        public Builder addressCity(String s)
        {
            addressCity = s;
            return this;
        }

        public Builder addressCountry(String s)
        {
            addressCountry = s;
            return this;
        }

        public Builder addressLine1(String s)
        {
            addressLine1 = s;
            return this;
        }

        public Builder addressLine2(String s)
        {
            addressLine2 = s;
            return this;
        }

        public Builder addressState(String s)
        {
            addressState = s;
            return this;
        }

        public Builder addressZip(String s)
        {
            addressZip = s;
            return this;
        }

        public Card build()
        {
            return new Card(this);
        }

        public Builder country(String s)
        {
            country = s;
            return this;
        }

        public Builder fingerprint(String s)
        {
            fingerprint = s;
            return this;
        }

        public Builder last4(String s)
        {
            last4 = s;
            return this;
        }

        public Builder name(String s)
        {
            name = s;
            return this;
        }

        public Builder type(String s)
        {
            type = s;
            return this;
        }
















        public Builder(String s, Integer integer, Integer integer1, String s1)
        {
            number = s;
            expMonth = integer;
            expYear = integer1;
            cvc = s1;
        }
    }

}
