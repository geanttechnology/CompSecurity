// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.SharedPreferences;
import com.wishabi.flipp.content.SearchTermProvider;
import com.wishabi.flipp.content.aj;

// Referenced classes of package com.wishabi.flipp.app:
//            FlippApplication

final class aw
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final FlippApplication a;

    aw(FlippApplication flippapplication)
    {
        a = flippapplication;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (s.equals("postal_code") || s.equals("allow_push"))
        {
            FlippApplication.a(a);
        } else
        if (s.equals("keep_search_history"))
        {
            boolean flag = sharedpreferences.getBoolean("keep_search_history", true);
            if (!flag)
            {
                aj.a(FlippApplication.b());
            }
            SearchTermProvider.a(flag);
            return;
        }
    }
}
