// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.widget.TextView;
import com.j.a.f.b;
import com.j.a.f.d;

// Referenced classes of package com.j.a.d:
//            t, r, p, ag

class u
    implements Runnable
{

    final t a;

    u(t t1)
    {
        a = t1;
        super();
    }

    public void run()
    {
        ag.a(a.a.f.a, false);
        ag.e(a.a.f.a).a();
        a.a.d.setText(b.a(com.j.a.d.ag.d(a.a.f.a)));
        a.a.a.setText(b.b(com.j.a.d.ag.d(a.a.f.a)));
    }
}
