// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.indicate;

import android.view.View;

// Referenced classes of package com.fotoable.photocollage.view.compose2.indicate:
//            TabPageIndicator

class a
    implements Runnable
{

    final View a;
    final TabPageIndicator b;

    public void run()
    {
        int i = a.getLeft();
        int j = (b.getWidth() - a.getWidth()) / 2;
        b.smoothScrollTo(i - j, 0);
        TabPageIndicator.access$202(b, null);
    }

    I(TabPageIndicator tabpageindicator, View view)
    {
        b = tabpageindicator;
        a = view;
        super();
    }
}
