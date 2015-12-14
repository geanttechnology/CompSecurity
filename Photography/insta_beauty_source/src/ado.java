// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class ado
{

    protected transient boolean a;
    private transient long b;

    public ado()
    {
        this(fotobeautyengineJNI.new_MSlimDataVector__SWIG_0(), true);
    }

    protected ado(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ado ado1)
    {
        if (ado1 == null)
        {
            return 0L;
        } else
        {
            return ado1.b;
        }
    }

    public add a(int i)
    {
        return new add(fotobeautyengineJNI.MSlimDataVector_get(b, this, i), false);
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
                fotobeautyengineJNI.delete_MSlimDataVector(b);
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

    public void a(add add1)
    {
        fotobeautyengineJNI.MSlimDataVector_add(b, this, add.a(add1), add1);
    }

    public long b()
    {
        return fotobeautyengineJNI.MSlimDataVector_size(b, this);
    }

    public boolean c()
    {
        return fotobeautyengineJNI.MSlimDataVector_isEmpty(b, this);
    }

    public void d()
    {
        fotobeautyengineJNI.MSlimDataVector_clear(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
