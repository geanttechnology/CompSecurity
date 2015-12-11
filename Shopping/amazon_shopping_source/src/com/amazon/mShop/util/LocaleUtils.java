// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.amazon.mShop.AmazonApplication;
import com.amazon.mShop.DCMInitializer;
import com.amazon.mShop.localeswitch.LocaleSwitchChain;
import com.amazon.mShop.localeswitch.LocaleSwitchCommonProcessor;
import com.amazon.mShop.localeswitch.LocaleSwitchNotificationProcessor;
import com.amazon.mShop.platform.AndroidDataStore;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.amazon.mShop.util:
//            ConfigUtils, AttributionUtils, Util

public class LocaleUtils
{

    private static List sLocaleSwitchListeners = new ArrayList();

    public LocaleUtils()
    {
    }

    public static void addLocaleSwitchListener(com.amazon.mShop.localeswitch.LocaleSwitchActivity.LocaleSwitchListener localeswitchlistener)
    {
        if (!sLocaleSwitchListeners.contains(localeswitchlistener))
        {
            sLocaleSwitchListeners.add(localeswitchlistener);
        }
    }

    public static void changeLocale(String s, Context context, Intent intent)
    {
        String s1 = AppLocale.getInstance().getCurrentLocaleName();
        context = new LocaleSwitchChain(s, context, intent);
        context.addProcessor(new LocaleSwitchNotificationProcessor()).addProcessor(new LocaleSwitchCommonProcessor());
        context.process();
        for (context = sLocaleSwitchListeners.iterator(); context.hasNext(); ((com.amazon.mShop.localeswitch.LocaleSwitchActivity.LocaleSwitchListener)context.next()).onLocaleSwitch(s1, s)) { }
        sLocaleSwitchListeners.clear();
    }

    public static void ensureAppLocale(Context context)
    {
        Locale locale = AppLocale.getInstance().getCurrentLocale();
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (!locale.equals(Locale.getDefault()))
        {
            Locale.setDefault(locale);
        }
        if (!locale.equals(configuration.locale))
        {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        DCMInitializer.updatePreferredMarketplace(context);
    }

    public static void ensureConfigLocale(Configuration configuration)
    {
        Locale locale = AppLocale.getInstance().getCurrentLocale();
        if (!locale.equals(configuration.locale))
        {
            configuration.locale = locale;
        }
    }

    public static void helpUserSetLocale(Context context)
    {
        Object obj;
label0:
        {
            if (ConfigUtils.isEnabledForApp(context, com.amazon.mShop.android.lib.R.bool.config_hasLocaleSwitch))
            {
                context = AndroidPlatform.getInstance().getDataStore();
                if (AndroidPlatform.getInstance().getAppStartCountForAllLocales() == 0)
                {
                    obj = AmazonApplication.getDeviceLocaleOnAppCreate();
                    obj = AppLocale.getInstance().getLocaleName(((Locale) (obj)));
                    if (!isFromIndia())
                    {
                        break label0;
                    }
                    setCurrentAppLocale("en_IN");
                }
            }
            return;
        }
        if (AppLocale.getInstance().isSupported(((String) (obj))))
        {
            context = ((Context) (obj));
            if ("fr_CA".equals(obj))
            {
                context = "en_CA";
            }
            setCurrentAppLocale(context);
            return;
        } else
        {
            context.putBoolean("needToSelectLocale", true);
            return;
        }
    }

    public static void initLocale(Context context)
    {
        String s = AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.default_locale);
        String s1 = s;
        if (s != null)
        {
            s1 = s.trim();
        }
        s = s1;
        if (Util.isEmpty(s1))
        {
            s = "en_US";
        }
        setDefaultAppLocale(s);
        String s2 = (new AndroidDataStore(context)).getString("applicationCurrentLocale");
        s1 = s2;
        if (Util.isEmpty(s2))
        {
            s1 = s;
        }
        setCurrentAppLocale(s1);
        ensureAppLocale(context);
        helpUserSetLocale(context);
    }

    public static boolean isCurrentLocale(String s)
    {
        return AppLocale.getInstance().getCurrentLocaleName().toLowerCase().equals(s.toLowerCase());
    }

    public static boolean isFromIndia()
    {
        Object obj = AmazonApplication.getDeviceLocaleOnAppCreate();
        obj = AppLocale.getInstance().getLocaleName(((Locale) (obj)));
        TimeZone timezone;
        if (!((String) (obj)).equals("en_IN"))
        {
            if (TimeZone.getDefault().getRawOffset() != (timezone = TimeZone.getTimeZone("GMT+05:30")).getRawOffset() || !"en_GB".equals(obj) && !"en_US".equals(obj))
            {
                return false;
            }
        }
        return true;
    }

    public static void removeLocaleSwitchListener(com.amazon.mShop.localeswitch.LocaleSwitchActivity.LocaleSwitchListener localeswitchlistener)
    {
        sLocaleSwitchListeners.remove(localeswitchlistener);
    }

    public static void setCurrentAppLocale(String s)
    {
        AppLocale.getInstance().setCurrentLocale(s);
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("applicationCurrentLocale", s);
    }

    public static void setDefaultAppLocale(String s)
    {
        AppLocale.getInstance().setDefaultLocale(s);
    }

}
