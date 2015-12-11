// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a;

import java.util.TimerTask;

// Referenced classes of package com.j.a.a:
//            b

class h extends TimerTask
{

    final b a;

    h(b b1)
    {
        a = b1;
        super();
    }

    public void run()
    {
        b.a(a, false);
        a.a(null);
    }
}
