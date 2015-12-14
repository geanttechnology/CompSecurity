// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, dh

class m
    implements AppLovinTargetingData
{

    private final Context a;

    m(AppLovinSdkImpl applovinsdkimpl)
    {
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        } else
        {
            a = applovinsdkimpl.getApplicationContext();
            return;
        }
    }

    private static String a(String as[])
    {
        if (as != null && as.length > 0)
        {
            StringBuilder stringbuilder = new StringBuilder();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                if (AppLovinSdkUtils.isValidString(s))
                {
                    stringbuilder.append(dh.c(s));
                    stringbuilder.append(",");
                }
            }

            if (stringbuilder.length() > 0)
            {
                stringbuilder.setLength(stringbuilder.length() - 1);
            }
            return stringbuilder.toString();
        } else
        {
            return "";
        }
    }

    private void a(String s, String s1)
    {
        if (AppLovinSdkUtils.isValidString(s))
        {
            android.content.SharedPreferences.Editor editor = a.getSharedPreferences("applovin.sdk.targeting", 0).edit();
            editor.putString(s, dh.c(s1));
            editor.commit();
        }
    }

    Map a()
    {
        HashMap hashmap = new HashMap();
        Object obj = a.getSharedPreferences("applovin.sdk.targeting", 0).getAll();
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(entry.getKey(), String.valueOf(entry.getValue())))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

        }
        return hashmap;
    }

    public void clearData()
    {
        android.content.SharedPreferences.Editor editor = a.getSharedPreferences("applovin.sdk.targeting", 0).edit();
        editor.clear();
        editor.commit();
    }

    public void putExtra(String s, String s1)
    {
        if (AppLovinSdkUtils.isValidString(s) && AppLovinSdkUtils.isValidString(s1))
        {
            a((new StringBuilder()).append("ex_").append(s).toString(), s1);
        }
    }

    public void setBirthYear(int i)
    {
        if (i < 9999 && i > 1900)
        {
            a("yob", Integer.toString(i));
        }
    }

    public void setCarrier(String s)
    {
        if (AppLovinSdkUtils.isValidString(s))
        {
            a("carrier", s);
        }
    }

    public void setCountry(String s)
    {
        if (AppLovinSdkUtils.isValidString(s) && s.length() == 2)
        {
            a("country", s.toUpperCase(Locale.ENGLISH));
        }
    }

    public void setGender(char c)
    {
        String s;
        if (c == 'm')
        {
            s = "m";
        } else
        if (c == 'f')
        {
            s = "f";
        } else
        {
            s = "u";
        }
        a("gender", s);
    }

    public transient void setInterests(String as[])
    {
        if (as != null && as.length > 0)
        {
            a("interests", a(as));
        }
    }

    public transient void setKeywords(String as[])
    {
        if (as != null && as.length > 0)
        {
            a("keywords", a(as));
        }
    }

    public void setLanguage(String s)
    {
        if (AppLovinSdkUtils.isValidString(s))
        {
            a("language", s.toLowerCase(Locale.ENGLISH));
        }
    }

    public void setLocation(Location location)
    {
        if (location != null)
        {
            a("lat", Double.toString(location.getLatitude()));
            a("lon", Double.toString(location.getLongitude()));
        }
    }
}
