// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class ak
{

    protected boolean a;
    private long b;

    public ak()
    {
        this(UIVenusJNI.new_UIFaceShape(), true);
    }

    protected ak(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ak ak1)
    {
        if (ak1 == null)
        {
            return 0L;
        } else
        {
            return ak1.b;
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
                UIVenusJNI.delete_UIFaceShape(b);
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
        UIVenusJNI.UIFaceShape_shape1_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l = UIVenusJNI.UIFaceShape_shape1_get(b, this);
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
        UIVenusJNI.UIFaceShape_shape2_set(b, this, ah.a(ah1), ah1);
    }

    public ah c()
    {
        long l = UIVenusJNI.UIFaceShape_shape2_get(b, this);
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
