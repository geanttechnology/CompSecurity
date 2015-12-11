// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrQuadrangle

public class OcrQuadrangleVector
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrQuadrangleVector()
    {
        this(jniInterfaceJNI.new_OcrQuadrangleVector__SWIG_0(), true);
    }

    public OcrQuadrangleVector(long l)
    {
        this(jniInterfaceJNI.new_OcrQuadrangleVector__SWIG_1(l), true);
    }

    protected OcrQuadrangleVector(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(OcrQuadrangleVector ocrquadranglevector)
    {
        if (ocrquadranglevector == null)
        {
            return 0L;
        } else
        {
            return ocrquadranglevector.a;
        }
    }

    public void add(OcrQuadrangle ocrquadrangle)
    {
        jniInterfaceJNI.OcrQuadrangleVector_add(a, this, OcrQuadrangle.getCPtr(ocrquadrangle), ocrquadrangle);
    }

    public long capacity()
    {
        return jniInterfaceJNI.OcrQuadrangleVector_capacity(a, this);
    }

    public void clear()
    {
        jniInterfaceJNI.OcrQuadrangleVector_clear(a, this);
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
                jniInterfaceJNI.delete_OcrQuadrangleVector(a);
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

    public OcrQuadrangle get(int i)
    {
        return new OcrQuadrangle(jniInterfaceJNI.OcrQuadrangleVector_get(a, this, i), false);
    }

    public boolean isEmpty()
    {
        return jniInterfaceJNI.OcrQuadrangleVector_isEmpty(a, this);
    }

    public void reserve(long l)
    {
        jniInterfaceJNI.OcrQuadrangleVector_reserve(a, this, l);
    }

    public void set(int i, OcrQuadrangle ocrquadrangle)
    {
        jniInterfaceJNI.OcrQuadrangleVector_set(a, this, i, OcrQuadrangle.getCPtr(ocrquadrangle), ocrquadrangle);
    }

    public long size()
    {
        return jniInterfaceJNI.OcrQuadrangleVector_size(a, this);
    }
}
