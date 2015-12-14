// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;


// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
{

    final CameraCtrl a;
    private boolean b;
    private Object c;

    public a(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
        c = new Object();
        b();
    }

    private void c()
    {
        if (b)
        {
            return;
        } else
        {
            b = true;
            return;
        }
    }

    public void a()
    {
        synchronized (c)
        {
            c();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        b = false;
    }
}
