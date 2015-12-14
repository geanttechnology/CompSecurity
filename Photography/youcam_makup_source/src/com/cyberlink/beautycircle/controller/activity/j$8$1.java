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

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        j.a(a.a, a.a);
    }

    Source(Source source)
    {
        a = source;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$8

/* anonymous class */
    class j._cls8
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
                DialogUtils.a(c.a, s, "Comment", a, com.cyberlink.beautycircle.utility.DialogUtils.ReportSource.a, new j._cls8._cls1(this));
            }
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                c = j1;
                a = l;
                b = view;
                super();
            }
    }

}
