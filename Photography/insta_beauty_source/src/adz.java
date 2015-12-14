// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adz extends adv
{

    private transient long b;

    public adz()
    {
        this(fotobeautyengineJNI.new_StateSlimNoseParam(), true);
    }

    protected adz(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateSlimNoseParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateSlimNoseParam(b);
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
        fotobeautyengineJNI.StateSlimNoseParam_autoLevel_set(b, this, f);
    }

    public void a(ado ado1)
    {
        fotobeautyengineJNI.StateSlimNoseParam_mannualSlimNoseOperationData_set(b, this, ado.a(ado1), ado1);
    }

    protected void finalize()
    {
        a();
    }
}
