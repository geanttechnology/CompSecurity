// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.widget.ProgressBar;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.an;
import com.wishabi.flipp.b.x;

// Referenced classes of package com.wishabi.flipp.app:
//            cn, cv

final class co extends x
{

    final String a;
    final cn b;

    co(cn cn1, String s)
    {
        b = cn1;
        a = s;
        super();
    }

    public final void a()
    {
        com.wishabi.flipp.app.cn.a(b).setVisibility(4);
        if (cn.b(b) != null && b.isAdded())
        {
            cn.b(b).a(null);
        }
    }

    public final void a(boolean flag)
    {
        com.wishabi.flipp.app.cn.a(b).setVisibility(4);
        if (cn.b(b) == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        cn.b(b).a(a);
_L2:
        (new an()).execute(new Void[0]);
        a a1 = a.a;
        a1.s = 0L;
        a1.c();
        return;
_L4:
        if (b.isAdded())
        {
            cn.b(b).a(null);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
