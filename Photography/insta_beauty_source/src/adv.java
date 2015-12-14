// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adv
{

    protected transient boolean a;
    private transient long b;

    protected adv(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adv adv1)
    {
        if (adv1 == null)
        {
            return 0L;
        } else
        {
            return adv1.b;
        }
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
                fotobeautyengineJNI.delete_StateParamBase(b);
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

    protected void finalize()
    {
        a();
    }
}
