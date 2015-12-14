// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adm
{

    protected transient boolean a;
    private transient long b;

    public adm()
    {
        this(fotobeautyengineJNI.new_FotoUserTappedPt(), true);
    }

    protected adm(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adm adm1)
    {
        if (adm1 == null)
        {
            return 0L;
        } else
        {
            return adm1.b;
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
                fotobeautyengineJNI.delete_FotoUserTappedPt(b);
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

    public void a(float f)
    {
        fotobeautyengineJNI.FotoUserTappedPt_x_set(b, this, f);
    }

    public void b(float f)
    {
        fotobeautyengineJNI.FotoUserTappedPt_y_set(b, this, f);
    }

    public void c(float f)
    {
        fotobeautyengineJNI.FotoUserTappedPt_areRadius_set(b, this, f);
    }

    protected void finalize()
    {
        a();
    }
}
