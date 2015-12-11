// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.b:
//            y, x, u

final class v extends y
{

    final int a;
    final x b;
    final u c;

    v(u u1, String s, int i, x x1)
    {
        c = u1;
        a = i;
        b = x1;
        super(s);
    }

    protected final void a(Boolean boolean1)
    {
        if (b != null)
        {
            b.a(boolean1.booleanValue());
        }
        u.a(c).remove(Integer.valueOf(a));
    }

    protected final void onCancelled()
    {
        if (b != null)
        {
            b.a();
        }
        u.a(c).remove(Integer.valueOf(a));
    }

    protected final void onPreExecute()
    {
        u.a(c).put(Integer.valueOf(a), this);
        if (b != null)
        {
            b.b();
        }
    }
}
