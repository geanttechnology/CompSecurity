// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adl
{

    protected transient boolean a;
    private transient long b;

    public adl()
    {
        this(fotobeautyengineJNI.new_FotoRemoveEyebagContour(), true);
    }

    protected adl(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adl adl1)
    {
        if (adl1 == null)
        {
            return 0L;
        } else
        {
            return adl1.b;
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
                fotobeautyengineJNI.delete_FotoRemoveEyebagContour(b);
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

    public void a(int i)
    {
        fotobeautyengineJNI.FotoRemoveEyebagContour_thickness_set(b, this, i);
    }

    public void a(ade ade1)
    {
        fotobeautyengineJNI.FotoRemoveEyebagContour_pts_set(b, this, ade.a(ade1), ade1);
    }

    protected void finalize()
    {
        a();
    }
}
