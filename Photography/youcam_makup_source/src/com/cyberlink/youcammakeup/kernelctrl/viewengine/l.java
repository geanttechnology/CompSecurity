// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            a, q, ImageBufferWrapper

class l
    implements a
{

    final Object a;
    ImageBufferWrapper b;
    ViewEngine.TaskCancelType c;
    String d;

    public l(Object obj)
    {
        b = null;
        c = null;
        d = null;
        a = obj;
    }

    public void a(ViewEngine.TaskCancelType taskcanceltype, String s, Object obj)
    {
        c = taskcanceltype;
        d = s;
        synchronized (a)
        {
            a.notify();
        }
        return;
        s;
        taskcanceltype;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(q q1, Object obj)
    {
        if (q1 != null)
        {
            b = q1.a();
        }
        synchronized (a)
        {
            a.notify();
        }
        return;
        obj;
        q1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void a(String s, Object obj)
    {
        d = s;
        synchronized (a)
        {
            a.notify();
        }
        return;
        obj;
        s;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
