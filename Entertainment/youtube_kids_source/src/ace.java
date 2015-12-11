// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

final class ace
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    private acd a;

    ace(acd acd1)
    {
        a = acd1;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("background_music".equals(s))
        {
            a.d = sharedpreferences.getBoolean(s, true);
        } else
        if ("sound_effects".equals(s))
        {
            a.e = sharedpreferences.getBoolean(s, true);
            return;
        }
    }
}
