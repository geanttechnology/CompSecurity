// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adi
{

    protected transient boolean a;
    private transient long b;

    public adi()
    {
        this(fotobeautyengineJNI.new_FotoBeautyPoint(), true);
    }

    protected adi(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adi adi1)
    {
        if (adi1 == null)
        {
            return 0L;
        } else
        {
            return adi1.b;
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
                fotobeautyengineJNI.delete_FotoBeautyPoint(b);
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
        fotobeautyengineJNI.FotoBeautyPoint_x_set(b, this, f);
    }

    public float b()
    {
        return fotobeautyengineJNI.FotoBeautyPoint_x_get(b, this);
    }

    public void b(float f)
    {
        fotobeautyengineJNI.FotoBeautyPoint_y_set(b, this, f);
    }

    public float c()
    {
        return fotobeautyengineJNI.FotoBeautyPoint_y_get(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
