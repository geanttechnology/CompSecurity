// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrPoint

public class OcrQuadrangle
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrQuadrangle()
    {
        this(jniInterfaceJNI.new_OcrQuadrangle__SWIG_0(), true);
    }

    protected OcrQuadrangle(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrQuadrangle(OcrPoint ocrpoint, OcrPoint ocrpoint1, OcrPoint ocrpoint2, OcrPoint ocrpoint3)
    {
        this(jniInterfaceJNI.new_OcrQuadrangle__SWIG_1(OcrPoint.getCPtr(ocrpoint), ocrpoint, OcrPoint.getCPtr(ocrpoint1), ocrpoint1, OcrPoint.getCPtr(ocrpoint2), ocrpoint2, OcrPoint.getCPtr(ocrpoint3), ocrpoint3), true);
    }

    public OcrQuadrangle(OcrQuadrangle ocrquadrangle)
    {
        this(jniInterfaceJNI.new_OcrQuadrangle__SWIG_2(getCPtr(ocrquadrangle), ocrquadrangle), true);
    }

    protected static long getCPtr(OcrQuadrangle ocrquadrangle)
    {
        if (ocrquadrangle == null)
        {
            return 0L;
        } else
        {
            return ocrquadrangle.a;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrQuadrangle(a);
            }
            a = 0L;
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
        delete();
    }

    public OcrPoint getBottomLeft()
    {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getBottomLeft(a, this), false);
    }

    public OcrPoint getBottomRight()
    {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getBottomRight(a, this), false);
    }

    public OcrPoint getTopLeft()
    {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getTopLeft(a, this), false);
    }

    public OcrPoint getTopRight()
    {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getTopRight(a, this), false);
    }
}
