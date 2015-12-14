// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class ady extends adv
{

    private transient long b;

    public ady()
    {
        this(fotobeautyengineJNI.new_StateSlimFaceParam(), true);
    }

    protected ady(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateSlimFaceParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateSlimFaceParam(b);
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
        fotobeautyengineJNI.StateSlimFaceParam_autoLevel_set(b, this, f);
    }

    public void a(ado ado1)
    {
        fotobeautyengineJNI.StateSlimFaceParam_mannualSlimFaceOperationData_set(b, this, ado.a(ado1), ado1);
    }

    protected void finalize()
    {
        a();
    }
}
