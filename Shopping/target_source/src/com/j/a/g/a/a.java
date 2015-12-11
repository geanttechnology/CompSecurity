// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g.a;

import java.util.concurrent.TimeoutException;

// Referenced classes of package com.j.a.g.a:
//            d

class a
    implements Runnable
{

    final d a;

    a(d d1)
    {
        a = d1;
        super();
    }

    public void run()
    {
        d.a(a).a(new TimeoutException());
    }
}
