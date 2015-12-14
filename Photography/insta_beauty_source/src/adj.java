// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adj
{

    protected transient boolean a;
    private transient long b;

    public adj()
    {
        this(fotobeautyengineJNI.new_FotoBeautyRemoveEyeBagVector__SWIG_0(), true);
    }

    protected adj(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adj adj1)
    {
        if (adj1 == null)
        {
            return 0L;
        } else
        {
            return adj1.b;
        }
    }

    public adl a(int i)
    {
        return new adl(fotobeautyengineJNI.FotoBeautyRemoveEyeBagVector_get(b, this, i), false);
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
                fotobeautyengineJNI.delete_FotoBeautyRemoveEyeBagVector(b);
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

    public void a(adl adl1)
    {
        fotobeautyengineJNI.FotoBeautyRemoveEyeBagVector_add(b, this, adl.a(adl1), adl1);
    }

    public long b()
    {
        return fotobeautyengineJNI.FotoBeautyRemoveEyeBagVector_size(b, this);
    }

    public boolean c()
    {
        return fotobeautyengineJNI.FotoBeautyRemoveEyeBagVector_isEmpty(b, this);
    }

    public void d()
    {
        fotobeautyengineJNI.FotoBeautyRemoveEyeBagVector_clear(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
