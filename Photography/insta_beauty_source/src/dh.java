// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.view.View;

public class dh
    implements Runnable
{

    final View a;
    final ScrollingTabContainerView b;

    public dh(ScrollingTabContainerView scrollingtabcontainerview, View view)
    {
        b = scrollingtabcontainerview;
        a = view;
        super();
    }

    public void run()
    {
        int i = a.getLeft();
        int j = (b.getWidth() - a.getWidth()) / 2;
        b.smoothScrollTo(i - j, 0);
        b.mTabSelector = null;
    }
}
