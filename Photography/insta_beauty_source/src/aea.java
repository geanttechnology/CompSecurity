// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class aea extends adv
{

    private transient long b;

    public aea()
    {
        this(fotobeautyengineJNI.new_StateSoftenParam(), true);
    }

    protected aea(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateSoftenParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateSoftenParam(b);
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

    public void a(float f)
    {
        fotobeautyengineJNI.StateSoftenParam_softenLevel_set(b, this, f);
    }

    public void b(float f)
    {
        fotobeautyengineJNI.StateSoftenParam_whiteLevel_set(b, this, f);
    }

    public void c(float f)
    {
        fotobeautyengineJNI.StateSoftenParam_skinLevel_set(b, this, f);
    }

    protected void finalize()
    {
        a();
    }
}
