// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

// Referenced classes of package com.pf.common.utility:
//            n, p, q

class o
    implements ComponentCallbacks, ComponentCallbacks2
{

    final n a;

    private o(n n1)
    {
        a = n1;
        super();
    }

    o(n n1, n._cls1 _pcls1)
    {
        this(n1);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        n.a(a);
    }

    public void onLowMemory()
    {
        q q1 = n.a(a);
        if (q1 != null)
        {
            if (q1 instanceof p)
            {
                ((p)q1).a();
                return;
            }
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                q1.a(80);
                return;
            }
        }
    }

    public void onTrimMemory(int i)
    {
        q q1 = n.a(a);
        if (q1 != null)
        {
            q1.a(i);
        }
    }
}
