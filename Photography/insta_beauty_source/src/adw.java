// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adw extends adv
{

    private transient long b;

    public adw()
    {
        this(fotobeautyengineJNI.new_StateQubanParam(), true);
    }

    protected adw(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateQubanParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateQubanParam(b);
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

    public void a(adg adg1)
    {
        fotobeautyengineJNI.StateQubanParam_pts_set(b, this, adg.a(adg1), adg1);
    }

    public void a(boolean flag)
    {
        fotobeautyengineJNI.StateQubanParam_isOpen_set(b, this, flag);
    }

    protected void finalize()
    {
        a();
    }
}
