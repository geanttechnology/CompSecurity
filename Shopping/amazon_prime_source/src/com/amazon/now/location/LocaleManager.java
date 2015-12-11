// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.location;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.DataStore;
import java.util.Locale;

public class LocaleManager
{

    public static final Locale DEFAULT_LOCALE;
    public static final Locale DEVICE_LOCALE_ON_APP_CREATE = Locale.getDefault();
    private static LocaleManager sInstance;
    private static Locale sLocales[] = null;
    private Locale mCurrentLocale;

    private LocaleManager()
    {
        setLocale(getLocale());
    }

    private Locale fromCode(String s)
    {
        Locale alocale[] = getAvailableLocales();
        int j = alocale.length;
        for (int i = 0; i < j; i++)
        {
            Locale locale = alocale[i];
            if (locale.toString().equalsIgnoreCase(s))
            {
                return locale;
            }
        }

        return null;
    }

    public static Locale[] getAvailableLocales()
    {
        com/amazon/now/location/LocaleManager;
        JVM INSTR monitorenter ;
        Locale alocale[];
        if (sLocales == null)
        {
            sLocales = (new Locale[] {
                Locale.US, Locale.UK, Locale.ITALY, Locale.JAPAN
            });
        }
        alocale = (Locale[])sLocales.clone();
        com/amazon/now/location/LocaleManager;
        JVM INSTR monitorexit ;
        return alocale;
        Exception exception;
        exception;
        throw exception;
    }

    public static LocaleManager getInstance()
    {
        com/amazon/now/location/LocaleManager;
        JVM INSTR monitorenter ;
        LocaleManager localemanager;
        if (sInstance == null)
        {
            sInstance = new LocaleManager();
        }
        localemanager = sInstance;
        com/amazon/now/location/LocaleManager;
        JVM INSTR monitorexit ;
        return localemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public static void resetAvailableLocales()
    {
        com/amazon/now/location/LocaleManager;
        JVM INSTR monitorenter ;
        sLocales = null;
        com/amazon/now/location/LocaleManager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void enforceCustomLocale()
    {
        setLocale(mCurrentLocale);
    }

    public String getDefaultDomain()
    {
        return AndroidPlatform.getInstance().getApplicationContext().getResources().getString(0x7f070072);
    }

    public Locale getLocale()
    {
        Object obj;
        if (mCurrentLocale != null)
        {
            obj = mCurrentLocale;
        } else
        {
            obj = DataStore.getString("keyAppLocale");
            Locale locale = null;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                locale = fromCode(((String) (obj)));
            }
            obj = locale;
            if (locale == null)
            {
                obj = getAvailableLocales();
                int j = obj.length;
                for (int i = 0; i < j; i++)
                {
                    Locale locale1 = obj[i];
                    if (DEVICE_LOCALE_ON_APP_CREATE.equals(locale1))
                    {
                        locale = DEVICE_LOCALE_ON_APP_CREATE;
                    }
                }

                obj = locale;
                if (locale == null)
                {
                    return DEFAULT_LOCALE;
                }
            }
        }
        return ((Locale) (obj));
    }

    public int getResourceIdForLocale(Context context, String s, Locale locale, String s1)
    {
        locale = String.format("%s_%s", new Object[] {
            s1, locale.getCountry().toLowerCase()
        });
        return context.getResources().getIdentifier(locale, s, context.getPackageName());
    }

    public void setLocale(Locale locale)
    {
        Locale locale1 = locale;
        if (locale == null)
        {
            locale1 = getLocale();
        }
        if (!Locale.getDefault().equals(locale1) || !locale1.equals(mCurrentLocale))
        {
            DataStore.putString("keyAppLocale", locale1.toString());
            mCurrentLocale = locale1;
            Locale.setDefault(locale1);
            locale = AndroidPlatform.getInstance().getApplicationContext().getResources();
            Configuration configuration = new Configuration(locale.getConfiguration());
            configuration.locale = locale1;
            locale.updateConfiguration(configuration, null);
        }
    }

    public void setLocaleFromDomain(String s)
    {
        Locale locale = getLocale();
        if (!s.equalsIgnoreCase("amazon.com")) goto _L2; else goto _L1
_L1:
        locale = Locale.US;
_L4:
        setLocale(locale);
        return;
_L2:
        if (s.equalsIgnoreCase("amazon.co.uk"))
        {
            locale = Locale.UK;
        } else
        if (s.equalsIgnoreCase("amazon.it"))
        {
            locale = Locale.ITALY;
        } else
        if (s.equalsIgnoreCase("amazon.co.jp"))
        {
            locale = Locale.JAPAN;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        DEFAULT_LOCALE = Locale.US;
    }
}
