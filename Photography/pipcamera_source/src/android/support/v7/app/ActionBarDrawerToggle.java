// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.view.View;
import i;
import j;

public class ActionBarDrawerToggle
    implements android.support.v4.widget.DrawerLayout.DrawerListener
{

    private final i a;
    private j b;
    private boolean c;
    private final int d;
    private final int e;

    void a(int k)
    {
        a.setActionBarDescription(k);
    }

    public void onDrawerClosed(View view)
    {
        b.a(0.0F);
        if (c)
        {
            a(d);
        }
    }

    public void onDrawerOpened(View view)
    {
        b.a(1.0F);
        if (c)
        {
            a(e);
        }
    }

    public void onDrawerSlide(View view, float f)
    {
        b.a(Math.min(1.0F, Math.max(0.0F, f)));
    }

    public void onDrawerStateChanged(int k)
    {
    }
}
