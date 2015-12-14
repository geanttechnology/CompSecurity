// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class aeb extends adv
{

    private transient long b;

    public aeb()
    {
        this(fotobeautyengineJNI.new_StateSoftenSuggestParam(), true);
    }

    protected aeb(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateSoftenSuggestParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateSoftenSuggestParam(b);
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

    public float b()
    {
        return fotobeautyengineJNI.StateSoftenSuggestParam_whiteLevel_get(b, this);
    }

    public float c()
    {
        return fotobeautyengineJNI.StateSoftenSuggestParam_skinLevel_get(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
