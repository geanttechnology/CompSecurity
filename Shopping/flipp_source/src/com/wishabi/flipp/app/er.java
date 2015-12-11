// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.preference.Preference;
import com.wishabi.flipp.content.aj;

// Referenced classes of package com.wishabi.flipp.app:
//            eq

final class er
    implements android.preference.Preference.OnPreferenceClickListener
{

    final eq a;

    er(eq eq1)
    {
        a = eq1;
        super();
    }

    public final boolean onPreferenceClick(Preference preference)
    {
        aj.a(a.getActivity());
        eq.a(a, a.getString(0x7f0e002b));
        return true;
    }
}
