// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            j, UIImageRetouchJNI

public class g extends j
{

    private long b;

    public g()
    {
        this(UIImageRetouchJNI.new_CropRotateParam__SWIG_0(), true);
    }

    protected g(long l, boolean flag)
    {
        super(UIImageRetouchJNI.CropRotateParam_SWIGUpcast(l), flag);
        b = l;
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
                UIImageRetouchJNI.delete_CropRotateParam(b);
            }
            b = 0L;
        }
        super.a();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s)
    {
        UIImageRetouchJNI.CropRotateParam_DecodeString(b, this, s);
    }

    public boolean a(int i, int k)
    {
        return UIImageRetouchJNI.CropRotateParam_ChangeResolution(b, this, i, k);
    }

    public boolean a(j j1)
    {
        return UIImageRetouchJNI.CropRotateParam_Compare(b, this, j.c(j1), j1);
    }

    public void b(j j1)
    {
        UIImageRetouchJNI.CropRotateParam_InitFrom(b, this, j.c(j1), j1);
    }

    public boolean b()
    {
        return UIImageRetouchJNI.CropRotateParam_IsDefault(b, this);
    }

    public String c()
    {
        return UIImageRetouchJNI.CropRotateParam_EncodeString(b, this);
    }

    public int d()
    {
        return UIImageRetouchJNI.CropRotateParam_nLeft_get(b, this);
    }

    public int e()
    {
        return UIImageRetouchJNI.CropRotateParam_nTop_get(b, this);
    }

    public int f()
    {
        return UIImageRetouchJNI.CropRotateParam_nWidth_get(b, this);
    }

    protected void finalize()
    {
        a();
    }

    public int g()
    {
        return UIImageRetouchJNI.CropRotateParam_nHeight_get(b, this);
    }

    public float h()
    {
        return UIImageRetouchJNI.CropRotateParam_fAngle_get(b, this);
    }
}
