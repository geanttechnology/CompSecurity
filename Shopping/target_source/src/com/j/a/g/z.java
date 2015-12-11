// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.view.ViewGroup;
import com.j.a.d.ag;
import com.j.a.f.h;
import java.util.HashMap;

// Referenced classes of package com.j.a.g:
//            a, o

final class z
    implements Runnable
{

    final ViewGroup a;
    final String b;
    final int c;
    final String d;

    z(ViewGroup viewgroup, String s, int i, String s1)
    {
        a = viewgroup;
        b = s;
        c = i;
        d = s1;
        super();
    }

    public void run()
    {
        int j = com.j.a.g.a.a(a);
        if (a.findViewById(j) == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= a.getChildCount()) goto _L2; else goto _L3
_L3:
        if (!(a.getChildAt(i) instanceof h)) goto _L5; else goto _L4
_L4:
        a.removeView(a.getChildAt(i));
        a.invalidate();
_L2:
        com.j.a.g.a.a(j, a, b);
        com.j.a.g.a.a(c, true);
        com.j.a.g.a.b(c, b, d);
        com.j.a.g.a.c().put(b, Boolean.valueOf(false));
        o.c(ag.c().d());
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        Throwable throwable;
        throwable;
        com.j.a.g.a.c().put(b, Boolean.valueOf(false));
        return;
    }
}
