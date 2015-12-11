// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.SharedPreferences;

// Referenced classes of package com.wishabi.flipp.b:
//            a

public final class g
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final a a;

    public g(a a1)
    {
        a = a1;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (s.equals("postal_code"))
        {
            com.wishabi.flipp.b.a.a(a, sharedpreferences.getString("postal_code", null));
        }
    }
}
