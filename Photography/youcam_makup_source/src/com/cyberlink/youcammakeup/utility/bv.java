// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bz, bx, bw

public class bv
{

    private ThreadPoolExecutor a;
    private int b;
    private int c;
    private int d;

    public bv()
    {
        b = 1;
        c = 1;
        d = 5;
        a = new ThreadPoolExecutor(b, c, d, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public Future a(bx bx)
    {
        bx = new bz(this, bx);
        a.execute(bx);
        return bx;
    }

    public Future a(bx bx, bw bw)
    {
        bx = new bz(this, bx, bw);
        a.execute(bx);
        return bx;
    }

    public void a()
    {
        a.shutdown();
    }
}
