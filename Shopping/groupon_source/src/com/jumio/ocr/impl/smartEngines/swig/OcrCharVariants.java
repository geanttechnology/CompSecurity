// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI, OcrQuadrangle, OcrChar, OcrCharVector

public class OcrCharVariants
{

    private long a;
    protected boolean swigCMemOwn;

    public OcrCharVariants()
    {
        this(jniInterfaceJNI.new_OcrCharVariants__SWIG_0(), true);
    }

    protected OcrCharVariants(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public OcrCharVariants(OcrQuadrangle ocrquadrangle, int i)
    {
        this(jniInterfaceJNI.new_OcrCharVariants__SWIG_1(OcrQuadrangle.getCPtr(ocrquadrangle), ocrquadrangle, i), true);
    }

    protected static long getCPtr(OcrCharVariants ocrcharvariants)
    {
        if (ocrcharvariants == null)
        {
            return 0L;
        } else
        {
            return ocrcharvariants.a;
        }
    }

    public void add(OcrChar ocrchar)
    {
        jniInterfaceJNI.OcrCharVariants_add(a, this, OcrChar.getCPtr(ocrchar), ocrchar);
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
                jniInterfaceJNI.delete_OcrCharVariants(a);
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

    public OcrCharVector get()
    {
        return new OcrCharVector(jniInterfaceJNI.OcrCharVariants_get(a, this), false);
    }

    public int getHighlightingMask()
    {
        return jniInterfaceJNI.OcrCharVariants_getHighlightingMask(a, this);
    }

    public OcrQuadrangle getQuadrangle()
    {
        return new OcrQuadrangle(jniInterfaceJNI.OcrCharVariants_getQuadrangle(a, this), false);
    }
}
