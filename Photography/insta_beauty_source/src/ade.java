// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class ade
{

    protected transient boolean a;
    private transient long b;

    public ade()
    {
        this(fotobeautyengineJNI.new_BeautyPointVector__SWIG_0(), true);
    }

    protected ade(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ade ade1)
    {
        if (ade1 == null)
        {
            return 0L;
        } else
        {
            return ade1.b;
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
                fotobeautyengineJNI.delete_BeautyPointVector(b);
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

    public void a(adi adi1)
    {
        fotobeautyengineJNI.BeautyPointVector_add(b, this, adi.a(adi1), adi1);
    }

    public void b()
    {
        fotobeautyengineJNI.BeautyPointVector_clear(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
