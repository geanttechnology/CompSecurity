// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import com.baidu.autoupdatesdk.ICallback;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            u, x

class b
    implements Runnable
{

    final x a;
    final ICallback b;
    final u c;

    public void run()
    {
        c.b(a, b);
    }

    k(u u1, x x, ICallback icallback)
    {
        c = u1;
        a = x;
        b = icallback;
        super();
    }
}
