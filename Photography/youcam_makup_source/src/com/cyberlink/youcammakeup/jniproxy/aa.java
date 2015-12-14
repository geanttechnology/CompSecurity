// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class aa
{

    protected boolean a;
    private long b;

    public aa()
    {
        this(UIVenusJNI.new_UIFaceChin(), true);
    }

    protected aa(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(aa aa1)
    {
        if (aa1 == null)
        {
            return 0L;
        } else
        {
            return aa1.b;
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
                UIVenusJNI.delete_UIFaceChin(b);
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
        UIVenusJNI.UIFaceChin_center_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l = UIVenusJNI.UIFaceChin_center_get(b, this);
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
