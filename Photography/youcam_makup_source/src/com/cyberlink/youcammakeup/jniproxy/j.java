// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageRetouchJNI

public class j
{

    protected boolean a;
    private long b;

    protected j(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long c(j j1)
    {
        if (j1 == null)
        {
            return 0L;
        } else
        {
            return j1.b;
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
                UIImageRetouchJNI.delete_IParamBase(b);
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
        UIImageRetouchJNI.IParamBase_DecodeString(b, this, s);
    }

    public boolean a(j j1)
    {
        return UIImageRetouchJNI.IParamBase_Compare(b, this, c(j1), j1);
    }

    public void b(j j1)
    {
        UIImageRetouchJNI.IParamBase_InitFrom(b, this, c(j1), j1);
    }

    public boolean b()
    {
        return UIImageRetouchJNI.IParamBase_IsDefault(b, this);
    }

    public String c()
    {
        return UIImageRetouchJNI.IParamBase_EncodeString(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
