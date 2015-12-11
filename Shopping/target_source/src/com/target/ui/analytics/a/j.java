// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.google.a.a.e;
import com.target.mothership.model.common.a.f;
import com.target.mothership.model.d;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.analytics.a:
//            n

public class j extends d
{

    private static final String TAG = com/target/ui/analytics/a/j.getSimpleName();
    private final d mReceiver;

    public j(d d1)
    {
        mReceiver = d1;
    }

    public String a()
    {
        return super.a();
    }

    public void a(f f1)
    {
        String s;
        if (c().b())
        {
            mReceiver.b(f1, (o)c().c());
        } else
        {
            mReceiver.b(f1);
        }
        if (f1.d() != null)
        {
            s = f1.d().a();
        } else
        {
            s = "";
        }
        q.a(TAG, s);
        n.a(f1.d(), f1.e()).e();
    }

    public void a(Object obj)
    {
        if (c().b())
        {
            mReceiver.a(obj, (o)c().c());
            return;
        } else
        {
            mReceiver.a(obj);
            return;
        }
    }

    public void b(Object obj)
    {
        a((f)obj);
    }

}
