// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adt extends adv
{

    private transient long b;

    public adt()
    {
        this(fotobeautyengineJNI.new_StateOneKeyBeautyInitParam(), true);
    }

    protected adt(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateOneKeyBeautyInitParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateOneKeyBeautyInitParam(b);
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

    public void a(float f1)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_slimFaceLevel_set(b, this, f1);
    }

    public void a(boolean flag)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_autoQuBan_set(b, this, flag);
    }

    public void b(float f1)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_slimNoseLevel_set(b, this, f1);
    }

    public void c(float f1)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_enlargeEyeLevel_set(b, this, f1);
    }

    public void d(float f1)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_clearEyeLevel_set(b, this, f1);
    }

    public void e(float f1)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_enhanceNoseLevel_set(b, this, f1);
    }

    public void f(float f1)
    {
        fotobeautyengineJNI.StateOneKeyBeautyInitParam_autoRemoveEyeBagLevel_set(b, this, f1);
    }

    protected void finalize()
    {
        a();
    }
}
