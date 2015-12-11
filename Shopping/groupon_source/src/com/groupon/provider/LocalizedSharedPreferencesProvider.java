// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.inject.Provider;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import java.util.Map;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

public class LocalizedSharedPreferencesProvider
    implements Provider
{

    private Application application;
    private CurrentCountryManager currentCountryManager;

    public LocalizedSharedPreferencesProvider()
    {
    }

    public static boolean exists(Context context, String s)
    {
        boolean flag = false;
        if (!context.getSharedPreferences((new StringBuilder()).append(s).append("_prefs").toString(), 0).getAll().isEmpty())
        {
            flag = true;
        }
        return flag;
    }

    public ArraySharedPreferences get()
    {
        if (currentCountryManager.getCurrentCountry() == null)
        {
            return null;
        }
        Object obj;
        try
        {
            obj = currentCountryManager.getCurrentCountry().isoName;
            obj = new ArraySharedPreferences(application.getSharedPreferences((new StringBuilder()).append(((String) (obj))).append("_prefs").toString(), 0));
            RoboGuice.getInjector(application).injectMembers(obj);
        }
        catch (Exception exception)
        {
            Ln.d(exception, "Could not find localized store.", new Object[0]);
            return null;
        }
        return ((ArraySharedPreferences) (obj));
    }

    public volatile Object get()
    {
        return get();
    }
}
