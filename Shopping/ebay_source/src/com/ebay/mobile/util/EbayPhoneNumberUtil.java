// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.text.TextUtils;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Locale;

public final class EbayPhoneNumberUtil
{

    public EbayPhoneNumberUtil()
    {
    }

    public static final String formatPhoneNumber(String s, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            String s2 = s1;
            if (s1.equals("UK"))
            {
                s2 = "GB";
            }
            s1 = PhoneNumberUtil.getInstance();
            try
            {
                com.google.i18n.phonenumbers.Phonenumber.PhoneNumber phonenumber = s1.parse(s, s2);
                if (s1.isValidNumber(phonenumber) || s1.isPossibleNumber(phonenumber))
                {
                    if (!TextUtils.isEmpty(s2) && s2.equals(Locale.getDefault().getCountry()))
                    {
                        s = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL;
                    } else
                    {
                        s = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL;
                    }
                    return s1.format(phonenumber, s);
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
        }
        return null;
    }

    public static final String formatPhoneNumberForApi(String s, String s1)
    {
        String s2 = s1;
        if (s1.equals("UK"))
        {
            s2 = "GB";
        }
        Object obj = PhoneNumberUtil.getInstance();
        boolean flag;
        try
        {
            s = ((PhoneNumberUtil) (obj)).parse(s, s2);
            flag = ((PhoneNumberUtil) (obj)).isValidNumber(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (!flag)
        {
            return null;
        }
        s1 = ((PhoneNumberUtil) (obj)).format(s, com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164);
        obj = ((PhoneNumberUtil) (obj)).format(s, com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        StringBuilder stringbuilder = new StringBuilder();
        if (s2.equals("US") || s2.equals("CA"))
        {
            stringbuilder.append(s1.substring(2, 5));
            stringbuilder.append('|');
            stringbuilder.append(s1.substring(5, 8));
            stringbuilder.append('|');
            stringbuilder.append(s1.substring(8, 12));
            if (s.hasExtension())
            {
                stringbuilder.append('|').append(s.getExtension());
            }
        } else
        if (s2.equals("GB") || s2.equals("DE") || s2.equals("AT") || s2.equals("IE") || s2.equals("PL") || s2.equals("CH") || s2.equals("AU"))
        {
            stringbuilder.append(((String) (obj)).substring(0, ((String) (obj)).indexOf(' ')).replaceAll("\\(", "").replaceAll("\\)", ""));
            stringbuilder.append('|');
            stringbuilder.append(((String) (obj)).substring(((String) (obj)).indexOf(' ')).replaceAll(" ", ""));
        } else
        {
            stringbuilder.append(((String) (obj)).replaceAll(" ", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", ""));
        }
        return stringbuilder.toString();
    }

    public static final String formatPhoneNumberNational(String s, String s1)
    {
        String s2;
        s2 = s1;
        if (s1.equals("UK"))
        {
            s2 = "GB";
        }
        s1 = PhoneNumberUtil.getInstance();
        s = s1.parse(s, s2);
        if (!s1.isValidNumber(s))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        s = s1.format(s, com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        return s;
        s;
        return null;
    }
}
