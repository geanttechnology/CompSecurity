// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adn
{

    protected transient boolean a;
    private transient long b;

    public adn()
    {
        this(fotobeautyengineJNI.new_MEyeBigDataVector__SWIG_0(), true);
    }

    protected adn(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adn adn1)
    {
        if (adn1 == null)
        {
            return 0L;
        } else
        {
            return adn1.b;
        }
    }

    public adc a(int i)
    {
        return new adc(fotobeautyengineJNI.MEyeBigDataVector_get(b, this, i), false);
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
                fotobeautyengineJNI.delete_MEyeBigDataVector(b);
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

    public void a(adc adc1)
    {
        fotobeautyengineJNI.MEyeBigDataVector_add(b, this, adc.a(adc1), adc1);
    }

    public long b()
    {
        return fotobeautyengineJNI.MEyeBigDataVector_size(b, this);
    }

    public boolean c()
    {
        return fotobeautyengineJNI.MEyeBigDataVector_isEmpty(b, this);
    }

    public void d()
    {
        fotobeautyengineJNI.MEyeBigDataVector_clear(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
