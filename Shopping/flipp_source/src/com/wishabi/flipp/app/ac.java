// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.SharedPreferences;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.app:
//            DrawerFragment

final class ac
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final DrawerFragment a;

    ac(DrawerFragment drawerfragment)
    {
        a = drawerfragment;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (!s.equals("postal_code"))
        {
            return;
        } else
        {
            DrawerFragment.a(a).setText(sharedpreferences.getString("postal_code", null));
            return;
        }
    }
}
