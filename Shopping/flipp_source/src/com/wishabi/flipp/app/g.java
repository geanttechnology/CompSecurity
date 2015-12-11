// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.widget.CollectionView;

// Referenced classes of package com.wishabi.flipp.app:
//            dn, ClippingsFragment

final class g extends dn
{

    final ClippingsFragment a;

    g(ClippingsFragment clippingsfragment)
    {
        a = clippingsfragment;
        super();
    }

    public final void a(int i)
    {
        ClippingsFragment.a(a, i);
    }

    public final boolean a()
    {
        ClippingsFragment.a(a).startActionMode(ClippingsFragment.a(a).getMultiChoiceModeListener());
        return true;
    }

    public final void b(int i)
    {
        ClippingsFragment.b(a, i);
    }
}
