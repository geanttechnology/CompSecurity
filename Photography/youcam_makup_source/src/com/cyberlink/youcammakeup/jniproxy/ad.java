// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class ad
{

    protected boolean a;
    private long b;

    public ad()
    {
        this(UIVenusJNI.new_UIFaceForehead(), true);
    }

    protected ad(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ad ad1)
    {
        if (ad1 == null)
        {
            return 0L;
        } else
        {
            return ad1.b;
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
                UIVenusJNI.delete_UIFaceForehead(b);
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
        UIVenusJNI.UIFaceForehead_middle_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l = UIVenusJNI.UIFaceForehead_middle_get(b, this);
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
        UIVenusJNI.UIFaceForehead_left_set(b, this, ah.a(ah1), ah1);
    }

    public ah c()
    {
        long l = UIVenusJNI.UIFaceForehead_left_get(b, this);
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
        UIVenusJNI.UIFaceForehead_right_set(b, this, ah.a(ah1), ah1);
    }

    public ah d()
    {
        long l = UIVenusJNI.UIFaceForehead_right_get(b, this);
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
