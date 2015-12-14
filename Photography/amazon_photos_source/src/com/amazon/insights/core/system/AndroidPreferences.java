// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.insights.InsightsCredentials;

// Referenced classes of package com.amazon.insights.core.system:
//            Preferences

public class AndroidPreferences
    implements Preferences
{

    private final SharedPreferences preferences;

    public AndroidPreferences(Context context, InsightsCredentials insightscredentials)
    {
        preferences = context.getSharedPreferences(insightscredentials.getApplicationKey(), 0);
    }

    public long getLong(String s, long l)
    {
        return preferences.getLong(s, l);
    }

    public String getString(String s, String s1)
    {
        return preferences.getString(s, s1);
    }

    public void putLong(String s, long l)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(s, l);
        editor.commit();
    }

    public void putString(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(s, s1);
        editor.commit();
    }
}
