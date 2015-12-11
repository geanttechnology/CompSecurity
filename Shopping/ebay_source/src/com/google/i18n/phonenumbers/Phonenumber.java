// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.i18n.phonenumbers;

import java.io.Serializable;

public final class Phonenumber
{
    public static class PhoneNumber
        implements Serializable
    {

        private CountryCodeSource countryCodeSource_;
        private int countryCode_;
        private String extension_;
        private boolean hasCountryCode;
        private boolean hasCountryCodeSource;
        private boolean hasExtension;
        private boolean hasItalianLeadingZero;
        private boolean hasNationalNumber;
        private boolean hasPreferredDomesticCarrierCode;
        private boolean hasRawInput;
        private boolean italianLeadingZero_;
        private long nationalNumber_;
        private String preferredDomesticCarrierCode_;
        private String rawInput_;

        public PhoneNumber clearCountryCodeSource()
        {
            hasCountryCodeSource = false;
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            return this;
        }

        public boolean equals(Object obj)
        {
            return (obj instanceof PhoneNumber) && exactlySameAs((PhoneNumber)obj);
        }

        public boolean exactlySameAs(PhoneNumber phonenumber)
        {
            boolean flag1 = true;
            if (phonenumber != null) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (this == phonenumber) goto _L4; else goto _L3
_L3:
            if (countryCode_ != phonenumber.countryCode_ || nationalNumber_ != phonenumber.nationalNumber_ || !extension_.equals(phonenumber.extension_) || italianLeadingZero_ != phonenumber.italianLeadingZero_ || !rawInput_.equals(phonenumber.rawInput_) || countryCodeSource_ != phonenumber.countryCodeSource_ || !preferredDomesticCarrierCode_.equals(phonenumber.preferredDomesticCarrierCode_))
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (hasPreferredDomesticCarrierCode() == phonenumber.hasPreferredDomesticCarrierCode()) goto _L4; else goto _L5
_L5:
            return false;
        }

        public int getCountryCode()
        {
            return countryCode_;
        }

        public CountryCodeSource getCountryCodeSource()
        {
            return countryCodeSource_;
        }

        public String getExtension()
        {
            return extension_;
        }

        public long getNationalNumber()
        {
            return nationalNumber_;
        }

        public String getPreferredDomesticCarrierCode()
        {
            return preferredDomesticCarrierCode_;
        }

        public String getRawInput()
        {
            return rawInput_;
        }

        public boolean hasCountryCodeSource()
        {
            return hasCountryCodeSource;
        }

        public boolean hasExtension()
        {
            return hasExtension;
        }

        public boolean hasItalianLeadingZero()
        {
            return hasItalianLeadingZero;
        }

        public boolean hasPreferredDomesticCarrierCode()
        {
            return hasPreferredDomesticCarrierCode;
        }

        public boolean hasRawInput()
        {
            return hasRawInput;
        }

        public int hashCode()
        {
            char c1 = '\u04CF';
            int i = getCountryCode();
            int j = Long.valueOf(getNationalNumber()).hashCode();
            int k = getExtension().hashCode();
            char c;
            int l;
            int i1;
            int j1;
            if (isItalianLeadingZero())
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            l = getRawInput().hashCode();
            i1 = getCountryCodeSource().hashCode();
            j1 = getPreferredDomesticCarrierCode().hashCode();
            if (!hasPreferredDomesticCarrierCode())
            {
                c1 = '\u04D5';
            }
            return (((((((i + 2173) * 53 + j) * 53 + k) * 53 + c) * 53 + l) * 53 + i1) * 53 + j1) * 53 + c1;
        }

        public boolean isItalianLeadingZero()
        {
            return italianLeadingZero_;
        }

        public PhoneNumber setCountryCode(int i)
        {
            hasCountryCode = true;
            countryCode_ = i;
            return this;
        }

        public PhoneNumber setCountryCodeSource(CountryCodeSource countrycodesource)
        {
            if (countrycodesource == null)
            {
                throw new NullPointerException();
            } else
            {
                hasCountryCodeSource = true;
                countryCodeSource_ = countrycodesource;
                return this;
            }
        }

        public PhoneNumber setExtension(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                hasExtension = true;
                extension_ = s;
                return this;
            }
        }

        public PhoneNumber setItalianLeadingZero(boolean flag)
        {
            hasItalianLeadingZero = true;
            italianLeadingZero_ = flag;
            return this;
        }

        public PhoneNumber setNationalNumber(long l)
        {
            hasNationalNumber = true;
            nationalNumber_ = l;
            return this;
        }

        public PhoneNumber setPreferredDomesticCarrierCode(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                hasPreferredDomesticCarrierCode = true;
                preferredDomesticCarrierCode_ = s;
                return this;
            }
        }

        public PhoneNumber setRawInput(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                hasRawInput = true;
                rawInput_ = s;
                return this;
            }
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Country Code: ").append(countryCode_);
            stringbuilder.append(" National Number: ").append(nationalNumber_);
            if (hasItalianLeadingZero() && isItalianLeadingZero())
            {
                stringbuilder.append(" Leading Zero: true");
            }
            if (hasExtension())
            {
                stringbuilder.append(" Extension: ").append(extension_);
            }
            if (hasCountryCodeSource())
            {
                stringbuilder.append(" Country Code Source: ").append(countryCodeSource_);
            }
            if (hasPreferredDomesticCarrierCode())
            {
                stringbuilder.append(" Preferred Domestic Carrier Code: ").append(preferredDomesticCarrierCode_);
            }
            return stringbuilder.toString();
        }

        public PhoneNumber()
        {
            countryCode_ = 0;
            nationalNumber_ = 0L;
            extension_ = "";
            italianLeadingZero_ = false;
            rawInput_ = "";
            preferredDomesticCarrierCode_ = "";
            countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
    }

    public static final class PhoneNumber.CountryCodeSource extends Enum
    {

        private static final PhoneNumber.CountryCodeSource $VALUES[];
        public static final PhoneNumber.CountryCodeSource FROM_DEFAULT_COUNTRY;
        public static final PhoneNumber.CountryCodeSource FROM_NUMBER_WITHOUT_PLUS_SIGN;
        public static final PhoneNumber.CountryCodeSource FROM_NUMBER_WITH_IDD;
        public static final PhoneNumber.CountryCodeSource FROM_NUMBER_WITH_PLUS_SIGN;

        public static PhoneNumber.CountryCodeSource valueOf(String s)
        {
            return (PhoneNumber.CountryCodeSource)Enum.valueOf(com/google/i18n/phonenumbers/Phonenumber$PhoneNumber$CountryCodeSource, s);
        }

        public static PhoneNumber.CountryCodeSource[] values()
        {
            return (PhoneNumber.CountryCodeSource[])$VALUES.clone();
        }

        static 
        {
            FROM_NUMBER_WITH_PLUS_SIGN = new PhoneNumber.CountryCodeSource("FROM_NUMBER_WITH_PLUS_SIGN", 0);
            FROM_NUMBER_WITH_IDD = new PhoneNumber.CountryCodeSource("FROM_NUMBER_WITH_IDD", 1);
            FROM_NUMBER_WITHOUT_PLUS_SIGN = new PhoneNumber.CountryCodeSource("FROM_NUMBER_WITHOUT_PLUS_SIGN", 2);
            FROM_DEFAULT_COUNTRY = new PhoneNumber.CountryCodeSource("FROM_DEFAULT_COUNTRY", 3);
            $VALUES = (new PhoneNumber.CountryCodeSource[] {
                FROM_NUMBER_WITH_PLUS_SIGN, FROM_NUMBER_WITH_IDD, FROM_NUMBER_WITHOUT_PLUS_SIGN, FROM_DEFAULT_COUNTRY
            });
        }

        private PhoneNumber.CountryCodeSource(String s, int i)
        {
            super(s, i);
        }
    }

}
