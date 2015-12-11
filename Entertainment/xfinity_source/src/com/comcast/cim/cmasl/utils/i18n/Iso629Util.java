// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Iso629Util
{

    private static final Map iso3LocaleMap;
    private static final Map localeMap;

    public Iso629Util()
    {
    }

    public static String getDisplayNameForLanguageCode(String s)
    {
        s = getLocaleByLanguageCode(s);
        if (s != null)
        {
            return s.getDisplayLanguage(s);
        } else
        {
            return null;
        }
    }

    public static Locale getLocaleByLanguageCode(String s)
    {
        if (s == null)
        {
            return null;
        }
        if (s.length() == 2)
        {
            return (Locale)localeMap.get(s);
        } else
        {
            return (Locale)iso3LocaleMap.get(s);
        }
    }

    static 
    {
        String as[] = Locale.getISOLanguages();
        localeMap = new HashMap(as.length);
        iso3LocaleMap = new HashMap(as.length);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            Locale locale = new Locale(s);
            localeMap.put(s, locale);
            iso3LocaleMap.put(locale.getISO3Language(), locale);
        }

    }
}
