// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class ab
{

    protected boolean a;
    private long b;

    public ab()
    {
        this(UIVenusJNI.new_UIFaceEar(), true);
    }

    protected ab(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ab ab1)
    {
        if (ab1 == null)
        {
            return 0L;
        } else
        {
            return ab1.b;
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
                UIVenusJNI.delete_UIFaceEar(b);
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

    public void a(ah ah1)
    {
        UIVenusJNI.UIFaceEar_top_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l = UIVenusJNI.UIFaceEar_top_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void b(ah ah1)
    {
        UIVenusJNI.UIFaceEar_bottom_set(b, this, ah.a(ah1), ah1);
    }

    public ah c()
    {
        long l = UIVenusJNI.UIFaceEar_bottom_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    protected void finalize()
    {
        a();
    }
}
