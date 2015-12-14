// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.view.View;
import o;
import p;

public class ActionBarDrawerToggle
    implements android.support.v4.widget.DrawerLayout.DrawerListener
{

    private final o a;
    private p b;
    private boolean c;
    private final int d;
    private final int e;

    void a(int i)
    {
        a.setActionBarDescription(i);
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

    public void onDrawerStateChanged(int i)
    {
    }
}
