// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            d, NavigationDrawerFragment

public class e extends d
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }


    private static boolean b;
    private final a a;

    public e(Activity activity, DrawerLayout drawerlayout, Toolbar toolbar, int i, int j, a a1, NavigationDrawerFragment navigationdrawerfragment)
    {
        super(activity, drawerlayout, toolbar, i, j, navigationdrawerfragment);
        a = a1;
    }

    public void a(View view)
    {
        super.a(view);
        if (a != null)
        {
            a.b();
        }
    }

    public void a(View view, float f)
    {
        super.a(view, f);
        if (f < 0.7F && !b)
        {
            b = true;
            if (a != null)
            {
                a.a();
            }
        }
        if (f == 0.0F)
        {
            b = false;
        }
    }

    public void b(View view)
    {
        super.b(view);
        if (a != null)
        {
            a.c();
        }
    }
}
