// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            SystemProperty, Util, Log

public final class LocaleUtil
{

    public static final String ARABIC = "ar";
    public static final String CHINA = "zh_CN";
    public static final String ENGLISH = "en";
    public static final String HEBREW = "iw";
    public static final String HINDI = "hi";
    public static final String HONGKONG = "zh_HK";
    public static final String INDONESIAN = "id";
    public static final String ITALIAN = "it";
    public static final String JAPANESE = "ja";
    public static final String KOREAN = "ko";
    public static final String LANGUAGE_DEFAULT = "language_default";
    public static final String LANGUAGE_KEY = "language_key";
    public static final String MALAY = "ms";
    public static final String POLISH = "pl";
    public static final String PORTUGUESE = "pt";
    public static final String RUSSIAN = "ru";
    public static final String SPANISH = "es";
    public static final String TAIWAN = "zh_TW";
    public static final String THAI = "th";
    public static final String TURKEY = "tr";
    public static final String VIETNAMESE = "vi";

    private LocaleUtil()
    {
    }

    private static String b(String s)
    {
        String s1 = Locale.getDefault().getLanguage().trim();
        if (s1.equals("en"))
        {
            s = s1;
        } else
        {
            String s2 = (new StringBuilder()).append(Locale.getDefault().getLanguage().trim()).append("_").append(Locale.getDefault().getCountry().trim()).toString();
            if (s2.equals("zh_TW") || s2.equals("zh_HK"))
            {
                return "zh_TW";
            }
            if ((new StringBuilder()).append(Locale.getDefault().getLanguage().trim()).append("_").append(Locale.getDefault().getCountry().trim()).toString().equals("zh_CN"))
            {
                return "zh_CN";
            }
            if (Locale.getDefault().getLanguage().trim().equals("th"))
            {
                return "th";
            }
            if (Locale.getDefault().getLanguage().trim().equals("id"))
            {
                return "id";
            }
            if (Locale.getDefault().getLanguage().trim().equals("vi"))
            {
                return "vi";
            }
            if (Locale.getDefault().getLanguage().trim().equals("pt"))
            {
                return "pt";
            }
            if (Locale.getDefault().getLanguage().trim().equals("es"))
            {
                return "es";
            }
            if (Locale.getDefault().getLanguage().trim().equals("ru"))
            {
                return "ru";
            }
            if (Locale.getDefault().getLanguage().trim().equals("ar"))
            {
                return "ar";
            }
            if (Locale.getDefault().getLanguage().trim().equals("iw"))
            {
                return "iw";
            }
            if (Locale.getDefault().getLanguage().trim().equals("pl"))
            {
                return "pl";
            }
            if (Locale.getDefault().getLanguage().trim().equals("hi"))
            {
                return "hi";
            }
            if (Locale.getDefault().getLanguage().trim().equals("ja"))
            {
                return "ja";
            }
            if (Locale.getDefault().getLanguage().trim().equals("it"))
            {
                return "it";
            }
            if (Locale.getDefault().getLanguage().trim().equals("ko"))
            {
                return "ko";
            }
            if (Locale.getDefault().getLanguage().trim().equals("ms"))
            {
                return "ms";
            }
            if (Locale.getDefault().getLanguage().trim().equals("tr"))
            {
                return "tr";
            }
        }
        return s;
    }

    public static String getApplicationLanguage()
    {
        String s = Util.nullAsNil(SystemProperty.getProperty("language_key"));
        if (s.length() > 0 && !s.equals("language_default"))
        {
            return s;
        } else
        {
            return b("en");
        }
    }

    public static String getCurrentCountryCode()
    {
        return Locale.getDefault().getCountry().trim();
    }

    public static boolean isLanguageSupported(String s)
    {
        while (Util.isNullOrNil(s) || !s.equalsIgnoreCase("zh_TW") && !s.equalsIgnoreCase("zh_HK") && !s.equalsIgnoreCase("zh_CN") && !s.equalsIgnoreCase("en") && !s.equalsIgnoreCase("th") && !s.equals("id") && !s.equals("vi") && !s.equalsIgnoreCase("pt") && !s.equalsIgnoreCase("es") && !s.equalsIgnoreCase("ru") && !s.equalsIgnoreCase("ar") && !s.equalsIgnoreCase("iw") && !s.equalsIgnoreCase("pl") && !s.equalsIgnoreCase("hi") && !s.equalsIgnoreCase("ja") && !s.equalsIgnoreCase("it") && !s.equalsIgnoreCase("ko") && !s.equalsIgnoreCase("ms") && !s.equalsIgnoreCase("tr")) 
        {
            return false;
        }
        return true;
    }

    public static String loadApplicationLanguage(SharedPreferences sharedpreferences, Context context)
    {
        sharedpreferences = Util.nullAsNil(sharedpreferences.getString("language_key", null));
        if (sharedpreferences.length() > 0 && !sharedpreferences.equals("language_default"))
        {
            SystemProperty.setProperty("language_key", sharedpreferences);
            return sharedpreferences;
        } else
        {
            sharedpreferences = b("en");
            SystemProperty.setProperty("language_key", sharedpreferences);
            return sharedpreferences;
        }
    }

    public static String loadApplicationLanguageSettings(SharedPreferences sharedpreferences, Context context)
    {
        sharedpreferences = Util.nullAsNil(sharedpreferences.getString("language_key", null));
        if (!Util.isNullOrNil(sharedpreferences))
        {
            return sharedpreferences;
        } else
        {
            return "language_default";
        }
    }

    public static void saveApplicationLanguage(SharedPreferences sharedpreferences, Context context, String s)
    {
        if (sharedpreferences.edit().putString("language_key", s).commit())
        {
            SystemProperty.setProperty("language_key", s);
            Log.w("MicroMsg.LocaleUtil", (new StringBuilder("save application lang as:")).append(s).toString());
            return;
        } else
        {
            Log.e("MicroMsg.LocaleUtil", "saving application lang failed");
            return;
        }
    }

    public static Locale transLanguageToLocale(String s)
    {
        if (s.equals("zh_TW") || s.equals("zh_HK"))
        {
            return Locale.TAIWAN;
        }
        if (s.equals("en"))
        {
            return Locale.ENGLISH;
        }
        if (s.equals("zh_CN"))
        {
            return Locale.CHINA;
        }
        if (s.equalsIgnoreCase("th"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("id"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("vi"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("pt"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("es"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("ru"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("ar"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("iw"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("pl"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("hi"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("ja"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("it"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("ko"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("ms"))
        {
            return new Locale(s);
        }
        if (s.equalsIgnoreCase("tr"))
        {
            return new Locale(s);
        } else
        {
            Log.e("MicroMsg.LocaleUtil", (new StringBuilder("transLanguageToLocale country = ")).append(s).toString());
            return Locale.ENGLISH;
        }
    }

    public static void updateApplicationResourceLocale(Context context, Locale locale)
    {
        context = context.getResources();
        Configuration configuration = context.getConfiguration();
        if (configuration.locale.equals(locale))
        {
            return;
        } else
        {
            android.util.DisplayMetrics displaymetrics = context.getDisplayMetrics();
            configuration.locale = locale;
            context.updateConfiguration(configuration, displaymetrics);
            Resources.getSystem().updateConfiguration(configuration, displaymetrics);
            return;
        }
    }
}
