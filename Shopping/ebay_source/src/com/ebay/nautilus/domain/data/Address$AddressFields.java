// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.Html;
import android.text.TextUtils;
import java.io.Serializable;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Address

public static class phone
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public String city;
    public String country;
    public transient String countryName;
    public String county;
    public String name;
    public String phone;
    public String postalCode;
    public String stateOrProvince;
    public String street1;
    public String street2;

    public static String getCityStatePostalString(String s, String s1, String s2, String s3, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s1);
        }
        s = stringbuilder.toString();
        s1 = new StringBuilder();
        if (TextUtils.isEmpty(s3) || !Address.countryHasReversedPostalCode(s3)) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(s2))
        {
            s1.append(s2);
            s1.append(' ');
        }
        if (!TextUtils.isEmpty(s))
        {
            s1.append(s);
        }
_L4:
        if (!TextUtils.isEmpty(s3) && flag)
        {
            if (s1.length() > 0)
            {
                s1.append(' ');
            }
            s1.append(s3);
        }
        return s1.toString();
_L2:
        if (!TextUtils.isEmpty(s))
        {
            s1.append(s);
            s1.append(' ');
        }
        if (!TextUtils.isEmpty(s2))
        {
            s1.append(s2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static final String htmlDecode(String s)
    {
        String s1 = s;
        if (!TextUtils.isEmpty(s))
        {
            s1 = Html.fromHtml(s).toString();
        }
        return s1;
    }

    public String getCity()
    {
        return htmlDecode(city);
    }

    public String getCityStatePostalString()
    {
        return getCityStatePostalString(getCity(), getStateOrProvince(), getPostalCode(), getCountry(), true);
    }

    public String getCountry()
    {
        if ("UK".equals(country))
        {
            return "GB";
        } else
        {
            return country;
        }
    }

    public String getCountryName()
    {
        return countryName;
    }

    public String getCounty()
    {
        return county;
    }

    public String getName()
    {
        return htmlDecode(name);
    }

    public String getPhone()
    {
        return phone;
    }

    public String getPostalCode()
    {
        if ("default".equals(postalCode))
        {
            return null;
        } else
        {
            return postalCode;
        }
    }

    public String getStateOrProvince()
    {
        if ("default".equals(stateOrProvince))
        {
            return null;
        } else
        {
            return stateOrProvince;
        }
    }

    public String getStreet1()
    {
        return htmlDecode(street1);
    }

    public String getStreet2()
    {
        return htmlDecode(street2);
    }

    public _cls9()
    {
    }

    public _cls9(_cls9 _pcls9)
    {
        if (_pcls9 != null)
        {
            name = _pcls9.getName();
            street1 = _pcls9.getStreet1();
            street2 = _pcls9.getStreet2();
            city = _pcls9.getCity();
            stateOrProvince = _pcls9.getStateOrProvince();
            postalCode = _pcls9.getPostalCode();
            country = _pcls9.getCountry();
            county = _pcls9.getCounty();
            phone = _pcls9.getPhone();
        }
    }

    public getPhone(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        name = s;
        street1 = s1;
        street2 = s2;
        city = s3;
        stateOrProvince = s4;
        postalCode = s5;
        country = s6;
        county = s7;
        phone = s8;
    }
}
