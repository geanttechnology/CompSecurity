// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class ae
{

    protected boolean a;
    private long b;

    public ae()
    {
        this(UIVenusJNI.new_UIFaceModelCacheVector__SWIG_0(), true);
    }

    protected ae(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ae ae1)
    {
        if (ae1 == null)
        {
            return 0L;
        } else
        {
            return ae1.b;
        }
    }

    public String a(int i)
    {
        return UIVenusJNI.UIFaceModelCacheVector_get(b, this, i);
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
                UIVenusJNI.delete_UIFaceModelCacheVector(b);
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

    public void a(String s)
    {
        UIVenusJNI.UIFaceModelCacheVector_add(b, this, s);
    }

    public long b()
    {
        return UIVenusJNI.UIFaceModelCacheVector_size(b, this);
    }

    public void c()
    {
        UIVenusJNI.UIFaceModelCacheVector_clear(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
