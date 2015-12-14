// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, al

public class am
{

    protected boolean a;
    private long b;

    public am()
    {
        this(UIVenusJNI.new_UIFaceTattooColorVector__SWIG_0(), true);
    }

    protected am(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(am am1)
    {
        if (am1 == null)
        {
            return 0L;
        } else
        {
            return am1.b;
        }
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != 0L)
        {
            if (a)
            {
                a = false;
                UIVenusJNI.delete_UIFaceTattooColorVector(b);
            }
            b = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(al al1)
    {
        UIVenusJNI.UIFaceTattooColorVector_add(b, this, al.a(al1), al1);
    }

    protected void finalize()
    {
        a();
    }
}
