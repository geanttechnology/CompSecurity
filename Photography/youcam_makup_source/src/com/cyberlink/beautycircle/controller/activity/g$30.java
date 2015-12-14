// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class b
    implements b
{

    final long a;
    final View b;
    final g c;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (s != null)
        {
            DialogUtils.a(c.b, s, "Comment", a, com.cyberlink.beautycircle.utility.gUtils.ReportSource.a, new Runnable() {

                final g._cls30 a;

                public void run()
                {
                    g.a(a.c, a.b);
                }

            
            {
                a = g._cls30.this;
                super();
            }
            });
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    _cls1.a(g g1, long l, View view)
    {
        c = g1;
        a = l;
        b = view;
        super();
    }
}
