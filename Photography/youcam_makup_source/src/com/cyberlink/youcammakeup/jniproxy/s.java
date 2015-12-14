// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, r

public class s
{

    protected boolean a;
    private long b;

    public s()
    {
        this(UIVenusJNI.new_UIColorVector__SWIG_0(), true);
    }

    protected s(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(s s1)
    {
        if (s1 == null)
        {
            return 0L;
        } else
        {
            return s1.b;
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
                UIVenusJNI.delete_UIColorVector(b);
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

    public void a(r r1)
    {
        UIVenusJNI.UIColorVector_add(b, this, r.a(r1), r1);
    }

    protected void finalize()
    {
        a();
    }
}
