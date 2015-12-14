// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adx extends adv
{

    private transient long b;

    public adx()
    {
        this(fotobeautyengineJNI.new_StateRemoveEyebagParam(), true);
    }

    protected adx(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateRemoveEyebagParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateRemoveEyebagParam(b);
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
        fotobeautyengineJNI.StateRemoveEyebagParam_level_set(b, this, f);
    }

    public void a(adj adj1)
    {
        fotobeautyengineJNI.StateRemoveEyebagParam_bagContour_set(b, this, adj.a(adj1), adj1);
    }

    public void a(boolean flag)
    {
        fotobeautyengineJNI.StateRemoveEyebagParam_isOpen_set(b, this, flag);
    }

    protected void finalize()
    {
        a();
    }
}
