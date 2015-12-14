// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.support.v7.widget.SearchView;
import java.util.List;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookMainActivity

final class a
    implements android.support.v4.view.istener
{

    private FacebookMainActivity a;

    public final void onPageScrollStateChanged(int i)
    {
    }

    public final void onPageScrolled(int i, float f, int j)
    {
    }

    public final void onPageSelected(int i)
    {
        if (i != 1 || FacebookMainActivity.c.size() != 0) goto _L2; else goto _L1
_L1:
        FacebookMainActivity.a(a, true);
_L4:
        a.invalidateOptionsMenu();
        return;
_L2:
        FacebookMainActivity.a(a, false);
        if (FacebookMainActivity.a(a) != null)
        {
            FacebookMainActivity.a(a).setOnQueryTextListener(null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    r(FacebookMainActivity facebookmainactivity)
    {
        a = facebookmainactivity;
        super();
    }
}
