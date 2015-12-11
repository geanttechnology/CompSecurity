// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.inner_models.Address;
import java.util.HashMap;

public class AddressUtils
{

    public AddressUtils()
    {
    }

    public static String addressStringWithoutPhone(Address address)
    {
        String s1 = new String();
        String s2 = address.getName();
        String s = s1;
        if (s2 != null)
        {
            s2 = s2.trim();
            s = s1;
            if (s2.length() > 0)
            {
                s = (new StringBuilder()).append(s1).append(s2).toString();
            }
        }
        s2 = address.getStreet().trim();
        s1 = s;
        if (s2.length() > 0)
        {
            s1 = (new StringBuilder()).append(s).append("\n").append(s2).toString();
        }
        s2 = address.getStreet2().trim();
        s = s1;
        if (s2.length() > 0)
        {
            s = (new StringBuilder()).append(s1).append(" ").append(s2).toString();
        }
        s2 = address.getCity().trim();
        s1 = s;
        if (s2.length() > 0)
        {
            s1 = (new StringBuilder()).append(s).append("\n").append(s2).toString();
        }
        s2 = address.getState().trim();
        s = s1;
        if (s2.length() > 0)
        {
            s = (new StringBuilder()).append(s1).append(", ").append(s2).toString();
        }
        s1 = address.getZip().trim();
        address = s;
        if (s1.length() > 0)
        {
            address = (new StringBuilder()).append(s).append(", ").append(s1).toString();
        }
        return address;
    }

    public static HashMap statesOfUSA()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Alabama", "AL");
        hashmap.put("Alaska", "AK");
        hashmap.put("American Samoa", "AS");
        hashmap.put("Arizona", "AZ");
        hashmap.put("Arkansas", "AR");
        hashmap.put("California", "CA");
        hashmap.put("Colorado", "CO");
        hashmap.put("Connecticut", "CT");
        hashmap.put("Delaware", "DE");
        hashmap.put("District of Columbia", "DC");
        hashmap.put("Florida", "FL");
        hashmap.put("Georgia", "GA");
        hashmap.put("Guam", "GU");
        hashmap.put("Hawaii", "HI");
        hashmap.put("Idaho", "ID");
        hashmap.put("Illinois", "IL");
        hashmap.put("Indiana", "IN");
        hashmap.put("Iowa", "IA");
        hashmap.put("Kansas", "KS");
        hashmap.put("Kentucky", "KY");
        hashmap.put("Louisiana", "LA");
        hashmap.put("Maine", "ME");
        hashmap.put("Maryland", "MD");
        hashmap.put("Massachusetts", "MA");
        hashmap.put("Michigan", "MI");
        hashmap.put("Minnesota", "MN");
        hashmap.put("Mississippi", "MS");
        hashmap.put("Missouri", "MO");
        hashmap.put("Montana", "MT");
        hashmap.put("Nebraska", "NE");
        hashmap.put("Nevada", "NV");
        hashmap.put("New Hampshire", "NH");
        hashmap.put("New Jersey", "NJ");
        hashmap.put("New Mexico", "NM");
        hashmap.put("New York", "NY");
        hashmap.put("North Carolina", "NC");
        hashmap.put("North Dakota", "ND");
        hashmap.put("Northern Marianas Islands", "MP");
        hashmap.put("Ohio", "OH");
        hashmap.put("Oklahoma", "OK");
        hashmap.put("Oregon", "OR");
        hashmap.put("Pennsylvania", "PA");
        hashmap.put("Puerto Rico", "PR");
        hashmap.put("Rhode Island", "RI");
        hashmap.put("South Carolina", "SC");
        hashmap.put("South Dakota", "SD");
        hashmap.put("Tennessee", "TN");
        hashmap.put("Texas", "TX");
        hashmap.put("Utah", "UT");
        hashmap.put("Vermont", "VT");
        hashmap.put("Virginia", "VA");
        hashmap.put("Virgin Islands", "VI");
        hashmap.put("Washington", "WA");
        hashmap.put("West Virginia", "WV");
        hashmap.put("Wisconsin", "WI");
        hashmap.put("Wyoming", "WY");
        return hashmap;
    }
}
