// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.ab;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

class ABSharedPreference extends ABSettingsFactory.ABSettingsManager
{

    private static final String KEY_UUID = "ab-uuid";
    private final String uuid;

    public ABSharedPreference(Context context)
    {
        uuid = generate(context);
    }

    private String generate(Context context)
    {
        context = getSharedPreferences(context);
        if (context.contains("ab-uuid"))
        {
            String s = context.getString("ab-uuid", null);
            if (s != null)
            {
                return s;
            }
        }
        String s1 = generateNew().toString();
        context = context.edit();
        context.putString("ab-uuid", s1);
        context.commit();
        return s1;
    }

    private SharedPreferences getSharedPreferences(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return getSharedPreferencesNewApi(context);
        } else
        {
            return getSharedPreferencesOldApi(context);
        }
    }

    private SharedPreferences getSharedPreferencesNewApi(Context context)
    {
        return context.getSharedPreferences("alphabeta", 4);
    }

    private SharedPreferences getSharedPreferencesOldApi(Context context)
    {
        return context.getSharedPreferences("alphabeta", 0);
    }

    public String getUUID()
    {
        return uuid;
    }
}
