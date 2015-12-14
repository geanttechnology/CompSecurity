// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class add
{

    protected transient boolean a;
    private transient long b;

    public add()
    {
        this(fotobeautyengineJNI.new_BeautyFaceMannualSlimData(), true);
    }

    protected add(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(add add1)
    {
        if (add1 == null)
        {
            return 0L;
        } else
        {
            return add1.b;
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
                fotobeautyengineJNI.delete_BeautyFaceMannualSlimData(b);
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
        fotobeautyengineJNI.BeautyFaceMannualSlimData_brushSize_set(b, this, f);
    }

    public void a(int i)
    {
        fotobeautyengineJNI.BeautyFaceMannualSlimData_xstart_set(b, this, i);
    }

    public void b(float f)
    {
        fotobeautyengineJNI.BeautyFaceMannualSlimData_zoomLevel_set(b, this, f);
    }

    public void b(int i)
    {
        fotobeautyengineJNI.BeautyFaceMannualSlimData_ystart_set(b, this, i);
    }

    public void c(int i)
    {
        fotobeautyengineJNI.BeautyFaceMannualSlimData_xend_set(b, this, i);
    }

    public void d(int i)
    {
        fotobeautyengineJNI.BeautyFaceMannualSlimData_yend_set(b, this, i);
    }

    protected void finalize()
    {
        a();
    }
}
