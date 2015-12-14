// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.view.View;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            IconPageIndicator

final class a
    implements Runnable
{

    private View a;
    private IconPageIndicator b;

    public final void run()
    {
        int i = a.getLeft();
        int j = (b.getWidth() - a.getWidth()) / 2;
        b.smoothScrollTo(i - j, 0);
        IconPageIndicator.a(b);
    }

    (IconPageIndicator iconpageindicator, View view)
    {
        b = iconpageindicator;
        a = view;
        super();
    }
}
