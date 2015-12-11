// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.widget.ec;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment

final class dz
    implements ec
{

    final SearchFragment a;

    dz(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final boolean a(int i, int j)
    {
        if (i == j)
        {
            return false;
        } else
        {
            SearchFragment.a(a, j);
            SearchFragment.a(a);
            return true;
        }
    }
}
