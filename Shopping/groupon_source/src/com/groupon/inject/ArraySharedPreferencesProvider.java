// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.inject;

import android.app.Application;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.groupon.util.ArraySharedPreferences;

public class ArraySharedPreferencesProvider
    implements Provider
{
    public static class PreferencesNameHolder
    {

        private String value;


        public PreferencesNameHolder()
        {
            value = "default";
        }
    }


    private static final String DEFAULT = "default";
    private Application context;
    private Injector injector;
    private final String preferencesName;

    public ArraySharedPreferencesProvider()
    {
        preferencesName = "default";
    }

    public ArraySharedPreferencesProvider(PreferencesNameHolder preferencesnameholder)
    {
        preferencesName = preferencesnameholder.value;
    }

    public ArraySharedPreferencesProvider(String s)
    {
        preferencesName = s;
    }

    public ArraySharedPreferences get()
    {
        ArraySharedPreferences arraysharedpreferences = new ArraySharedPreferences(context.getSharedPreferences(preferencesName, 0));
        injector.injectMembers(arraysharedpreferences);
        return arraysharedpreferences;
    }

    public volatile Object get()
    {
        return get();
    }
}
