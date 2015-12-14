// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIAthenaJNI, AthenaStrokeType, d

public class e
{

    protected boolean a;
    private long b;

    protected e(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public e(String s)
    {
        this(UIAthenaJNI.new_CUIAthena(s), true);
    }

    public Object a(boolean flag)
    {
        return UIAthenaJNI.CUIAthena_getMask(b, this, flag);
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
                UIAthenaJNI.delete_CUIAthena(b);
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

    public boolean a(float f, float f1)
    {
        return UIAthenaJNI.CUIAthena_addStrokePoint(b, this, f, f1);
    }

    public boolean a(AthenaStrokeType athenastroketype, int i)
    {
        return UIAthenaJNI.CUIAthena_beginStroke(b, this, athenastroketype.a(), i);
    }

    public boolean a(d d1)
    {
        return UIAthenaJNI.CUIAthena_initialize(b, this, com.cyberlink.youcammakeup.jniproxy.d.a(d1), d1);
    }

    public boolean b()
    {
        return UIAthenaJNI.CUIAthena_uninitialize(b, this);
    }

    public boolean c()
    {
        return UIAthenaJNI.CUIAthena_clear(b, this);
    }

    public boolean d()
    {
        return UIAthenaJNI.CUIAthena_endStroke(b, this);
    }

    public boolean e()
    {
        return UIAthenaJNI.CUIAthena_invert(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
