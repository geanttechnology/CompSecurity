// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class ads extends adv
{

    private transient long b;

    public ads()
    {
        this(fotobeautyengineJNI.new_StateEnlargeEyeParam(), true);
    }

    protected ads(long l, boolean flag)
    {
        super(fotobeautyengineJNI.StateEnlargeEyeParam_SWIGUpcast(l), flag);
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
                fotobeautyengineJNI.delete_StateEnlargeEyeParam(b);
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
        fotobeautyengineJNI.StateEnlargeEyeParam_autoLevel_set(b, this, f);
    }

    public void a(adn adn1)
    {
        fotobeautyengineJNI.StateEnlargeEyeParam_mannualEyeBigData_set(b, this, adn.a(adn1), adn1);
    }

    protected void finalize()
    {
        a();
    }
}
