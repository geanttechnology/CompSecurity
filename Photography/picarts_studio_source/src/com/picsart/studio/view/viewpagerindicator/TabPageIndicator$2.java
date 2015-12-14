// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.view.View;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            TabPageIndicator

final class a
    implements Runnable
{

    private View a;
    private TabPageIndicator b;

    public final void run()
    {
        int i = a.getLeft();
        int j = (b.getWidth() - a.getWidth()) / 2;
        b.smoothScrollTo(i - j, 0);
        TabPageIndicator.b(b);
    }

    (TabPageIndicator tabpageindicator, View view)
    {
        b = tabpageindicator;
        a = view;
        super();
    }
}
