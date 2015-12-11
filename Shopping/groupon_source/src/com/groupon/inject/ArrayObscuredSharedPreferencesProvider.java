// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.inject;

import android.app.Application;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.ObscuredSharedPreferences;

public class ArrayObscuredSharedPreferencesProvider
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
    private ArraySharedPreferences arraySharedPreferences;
    private Application context;
    private Injector injector;
    private final String preferencesName;

    public ArrayObscuredSharedPreferencesProvider()
    {
        preferencesName = "default";
    }

    public ArrayObscuredSharedPreferencesProvider(PreferencesNameHolder preferencesnameholder)
    {
        preferencesName = preferencesnameholder.value;
    }

    public ArrayObscuredSharedPreferencesProvider(String s)
    {
        preferencesName = s;
    }

    public ArraySharedPreferences get()
    {
        if (arraySharedPreferences == null)
        {
            arraySharedPreferences = new ArraySharedPreferences(new ObscuredSharedPreferences(context, context.getSharedPreferences(preferencesName, 0)));
            injector.injectMembers(arraySharedPreferences);
        }
        return arraySharedPreferences;
    }

    public volatile Object get()
    {
        return get();
    }
}
