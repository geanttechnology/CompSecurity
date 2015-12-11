// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            DrawerFragment, af

final class ae
    implements android.view.View.OnClickListener
{

    final DrawerFragment a;

    ae(DrawerFragment drawerfragment)
    {
        a = drawerfragment;
        super();
    }

    public final void onClick(View view)
    {
        if (DrawerFragment.b(a) != null)
        {
            DrawerFragment.b(a).b();
        }
    }
}
