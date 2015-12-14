// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adq extends adv
{

    private transient long b;

    public adq()
    {
        this(fotobeautyengineJNI.new_StateClearEyeParam(), true);
    }

    protected adq(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateClearEyeParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateClearEyeParam(b);
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
        fotobeautyengineJNI.StateClearEyeParam_level_set(b, this, f);
    }

    protected void finalize()
    {
        a();
    }
}
