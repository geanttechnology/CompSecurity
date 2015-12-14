// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;


// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            AsyncTask, n

public class q extends AsyncTask
{

    final n d;

    protected q(n n1)
    {
        d = n1;
        super();
    }

    protected Object a(Object aobj[])
    {
        return d(aobj);
    }

    protected transient Void d(Object aobj[])
    {
        ((Integer)aobj[0]).intValue();
        JVM INSTR tableswitch 0 3: default 40
    //                   0 42
    //                   1 52
    //                   2 62
    //                   3 72;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return null;
_L2:
        d.c();
        continue; /* Loop/switch isn't completed */
_L3:
        d.b();
        continue; /* Loop/switch isn't completed */
_L4:
        d.d();
        continue; /* Loop/switch isn't completed */
_L5:
        d.e();
        if (true) goto _L1; else goto _L6
_L6:
    }
}
