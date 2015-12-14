// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import viewpagerindicator.IconPageIndicator;

public class cfm
    implements Runnable
{

    final View a;
    final IconPageIndicator b;

    public cfm(IconPageIndicator iconpageindicator, View view)
    {
        b = iconpageindicator;
        a = view;
        super();
    }

    public void run()
    {
        int i = a.getLeft();
        int j = (b.getWidth() - a.getWidth()) / 2;
        b.smoothScrollTo(i - j, 0);
        IconPageIndicator.access$002(b, null);
    }
}
