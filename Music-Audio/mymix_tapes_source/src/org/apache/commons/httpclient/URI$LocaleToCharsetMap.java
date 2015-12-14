// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.util.Hashtable;
import java.util.Locale;

// Referenced classes of package org.apache.commons.httpclient:
//            URI

public static class 
{

    private static final Hashtable LOCALE_TO_CHARSET_MAP;

    public static String getCharset(Locale locale)
    {
        String s = (String)LOCALE_TO_CHARSET_MAP.get(locale.toString());
        if (s != null)
        {
            return s;
        } else
        {
            return (String)LOCALE_TO_CHARSET_MAP.get(locale.getLanguage());
        }
    }

    static 
    {
        LOCALE_TO_CHARSET_MAP = new Hashtable();
        LOCALE_TO_CHARSET_MAP.put("ar", "ISO-8859-6");
        LOCALE_TO_CHARSET_MAP.put("be", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("bg", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("ca", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("cs", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("da", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("de", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("el", "ISO-8859-7");
        LOCALE_TO_CHARSET_MAP.put("en", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("es", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("et", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("fi", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("fr", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("hr", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("hu", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("is", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("it", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("iw", "ISO-8859-8");
        LOCALE_TO_CHARSET_MAP.put("ja", "Shift_JIS");
        LOCALE_TO_CHARSET_MAP.put("ko", "EUC-KR");
        LOCALE_TO_CHARSET_MAP.put("lt", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("lv", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("mk", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("nl", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("no", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("pl", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("pt", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("ro", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("ru", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("sh", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("sk", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("sl", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("sq", "ISO-8859-2");
        LOCALE_TO_CHARSET_MAP.put("sr", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("sv", "ISO-8859-1");
        LOCALE_TO_CHARSET_MAP.put("tr", "ISO-8859-9");
        LOCALE_TO_CHARSET_MAP.put("uk", "ISO-8859-5");
        LOCALE_TO_CHARSET_MAP.put("zh", "GB2312");
        LOCALE_TO_CHARSET_MAP.put("zh_TW", "Big5");
    }

    public ()
    {
    }
}
