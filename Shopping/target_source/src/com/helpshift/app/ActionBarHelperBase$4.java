// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.app;

import android.view.MenuItem;
import android.view.View;

// Referenced classes of package com.helpshift.app:
//            ActionBarHelperBase

class c
    implements android.support.v4.view.
{

    final View a;
    final View b;
    final com.helpshift.j._cls4.c c;
    final ActionBarHelperBase d;

    public boolean a(MenuItem menuitem)
    {
        a.setVisibility(8);
        if (b != null)
        {
            b.setVisibility(8);
        }
        d.b = true;
        return c.c();
    }

    public boolean b(MenuItem menuitem)
    {
        a.setVisibility(0);
        if (b != null)
        {
            b.setVisibility(0);
        }
        d.b = false;
        return c.c();
    }

    (ActionBarHelperBase actionbarhelperbase, View view, View view1, com.helpshift.j._cls4 _pcls4)
    {
        d = actionbarhelperbase;
        a = view;
        b = view1;
        c = _pcls4;
        super();
    }
}
