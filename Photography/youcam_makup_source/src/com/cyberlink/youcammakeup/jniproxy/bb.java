// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class bb
{

    protected boolean a;
    private long b;

    public bb()
    {
        this(UIVenusJNI.new_UIModelBrowEngineRect(), true);
    }

    protected bb(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(bb bb1)
    {
        if (bb1 == null)
        {
            return 0L;
        } else
        {
            return bb1.b;
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
                UIVenusJNI.delete_UIModelBrowEngineRect(b);
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
        UIVenusJNI.UIModelBrowEngineRect_head_set(b, this, ah.a(ah1), ah1);
    }

    public void b(ah ah1)
    {
        UIVenusJNI.UIModelBrowEngineRect_top_set(b, this, ah.a(ah1), ah1);
    }

    public void c(ah ah1)
    {
        UIVenusJNI.UIModelBrowEngineRect_tail_set(b, this, ah.a(ah1), ah1);
    }

    protected void finalize()
    {
        a();
    }
}
