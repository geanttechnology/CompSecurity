// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import viewpagerindicator.TabPageIndicator;

public class cfs
    implements Runnable
{

    final View a;
    final TabPageIndicator b;

    public cfs(TabPageIndicator tabpageindicator, View view)
    {
        b = tabpageindicator;
        a = view;
        super();
    }

    public void run()
    {
        int i = a.getLeft();
        int j = (b.getWidth() - a.getWidth()) / 2;
        b.smoothScrollTo(i - j, 0);
        TabPageIndicator.access$202(b, null);
    }
}
