// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class ag
{

    protected boolean a;
    private long b;

    public ag()
    {
        this(UIVenusJNI.new_UIFaceNose(), true);
    }

    protected ag(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ag ag1)
    {
        if (ag1 == null)
        {
            return 0L;
        } else
        {
            return ag1.b;
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
                UIVenusJNI.delete_UIFaceNose(b);
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
        UIVenusJNI.UIFaceNose_left_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l = UIVenusJNI.UIFaceNose_left_get(b, this);
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
        UIVenusJNI.UIFaceNose_top_set(b, this, ah.a(ah1), ah1);
    }

    public ah c()
    {
        long l = UIVenusJNI.UIFaceNose_top_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void c(ah ah1)
    {
        UIVenusJNI.UIFaceNose_right_set(b, this, ah.a(ah1), ah1);
    }

    public ah d()
    {
        long l = UIVenusJNI.UIFaceNose_right_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void d(ah ah1)
    {
        UIVenusJNI.UIFaceNose_bottom_set(b, this, ah.a(ah1), ah1);
    }

    public ah e()
    {
        long l = UIVenusJNI.UIFaceNose_bottom_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void e(ah ah1)
    {
        UIVenusJNI.UIFaceNose_bridgeTop_set(b, this, ah.a(ah1), ah1);
    }

    public ah f()
    {
        long l = UIVenusJNI.UIFaceNose_bridgeTop_get(b, this);
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
