// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            j

class b
    implements b
{

    final long a;
    final View b;
    final j c;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (s != null)
        {
            DialogUtils.a(c.a, s, "Comment", a, com.cyberlink.beautycircle.utility.ogUtils.ReportSource.a, new Runnable() {

                final j._cls8 a;

                public void run()
                {
                    j.a(a.c, a.b);
                }

            
            {
                a = j._cls8.this;
                super();
            }
            });
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    _cls1.a(j j1, long l, View view)
    {
        c = j1;
        a = l;
        b = view;
        super();
    }
}
