// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            q, n, f

final class a
    implements Runnable
{

    final validate a;

    public final void run()
    {
        for (int i = 0; i < q.X.size(); i++)
        {
            n n1 = (n)q.X.get(i);
            if (n1 == null || q.b() != n1.a || n1.p)
            {
                continue;
            }
            n1.u = false;
            n1.invalidate();
            if (n1.I != null)
            {
                n1.I.lidate = false;
                n1.I.validate();
            }
        }

    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/jirbo/adcolony/f$2

/* anonymous class */
    static final class f._cls2
        implements Runnable
    {

        final Activity a;

        public final void run()
        {
            a.runOnUiThread(new f._cls2._cls1(this));
        }

            
            {
                a = activity;
                super();
            }
    }

}
