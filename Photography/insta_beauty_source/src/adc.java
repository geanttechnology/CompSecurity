// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adc
{

    protected transient boolean a;
    private transient long b;

    public adc()
    {
        this(fotobeautyengineJNI.new_BeautyFaceMannualEyeBiggerData(), true);
    }

    protected adc(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adc adc1)
    {
        if (adc1 == null)
        {
            return 0L;
        } else
        {
            return adc1.b;
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
                fotobeautyengineJNI.delete_BeautyFaceMannualEyeBiggerData(b);
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
        fotobeautyengineJNI.BeautyFaceMannualEyeBiggerData_brushSize_set(b, this, f);
    }

    public void a(int i)
    {
        fotobeautyengineJNI.BeautyFaceMannualEyeBiggerData_xcord_set(b, this, i);
    }

    public void b(float f)
    {
        fotobeautyengineJNI.BeautyFaceMannualEyeBiggerData_zoomLevel_set(b, this, f);
    }

    public void b(int i)
    {
        fotobeautyengineJNI.BeautyFaceMannualEyeBiggerData_ycord_set(b, this, i);
    }

    protected void finalize()
    {
        a();
    }
}
