// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adg
{

    protected transient boolean a;
    private transient long b;

    public adg()
    {
        this(fotobeautyengineJNI.new_CustomVector__SWIG_0(), true);
    }

    protected adg(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adg adg1)
    {
        if (adg1 == null)
        {
            return 0L;
        } else
        {
            return adg1.b;
        }
    }

    public adm a(int i)
    {
        return new adm(fotobeautyengineJNI.CustomVector_get(b, this, i), false);
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
                fotobeautyengineJNI.delete_CustomVector(b);
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

    public void a(adm adm1)
    {
        fotobeautyengineJNI.CustomVector_add(b, this, adm.a(adm1), adm1);
    }

    public long b()
    {
        return fotobeautyengineJNI.CustomVector_size(b, this);
    }

    public boolean c()
    {
        return fotobeautyengineJNI.CustomVector_isEmpty(b, this);
    }

    public void d()
    {
        fotobeautyengineJNI.CustomVector_clear(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
