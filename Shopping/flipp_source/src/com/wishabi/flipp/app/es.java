// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.preference.Preference;

// Referenced classes of package com.wishabi.flipp.app:
//            eq

final class es
    implements android.preference.Preference.OnPreferenceChangeListener
{

    final eq a;

    es(eq eq1)
    {
        a = eq1;
        super();
    }

    public final boolean onPreferenceChange(Preference preference, Object obj)
    {
        boolean flag = ((Boolean)obj).booleanValue();
        a.findPreference("clear_search_history").setEnabled(flag);
        return true;
    }
}
