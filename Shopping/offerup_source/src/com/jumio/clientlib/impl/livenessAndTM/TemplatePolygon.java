// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI

public class TemplatePolygon
{

    private long a;
    protected boolean swigCMemOwn;

    public TemplatePolygon()
    {
        this(jniLivenessAndTMJNI.new_TemplatePolygon__SWIG_0(), true);
    }

    public TemplatePolygon(float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7)
    {
        this(jniLivenessAndTMJNI.new_TemplatePolygon__SWIG_1(f, f1, f2, f3, f4, f5, f6, f7), true);
    }

    protected TemplatePolygon(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(TemplatePolygon templatepolygon)
    {
        if (templatepolygon == null)
        {
            return 0L;
        } else
        {
            return templatepolygon.a;
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
                jniLivenessAndTMJNI.delete_TemplatePolygon(a);
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

    public float getBLx()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getBLx(a, this);
    }

    public float getBLy()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getBLy(a, this);
    }

    public float getBRx()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getBRx(a, this);
    }

    public float getBRy()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getBRy(a, this);
    }

    public float getTLx()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getTLx(a, this);
    }

    public float getTLy()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getTLy(a, this);
    }

    public float getTRx()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getTRx(a, this);
    }

    public float getTRy()
    {
        return jniLivenessAndTMJNI.TemplatePolygon_getTRy(a, this);
    }

    public void setBLx(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setBLx(a, this, f);
    }

    public void setBLy(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setBLy(a, this, f);
    }

    public void setBRx(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setBRx(a, this, f);
    }

    public void setBRy(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setBRy(a, this, f);
    }

    public void setTLx(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setTLx(a, this, f);
    }

    public void setTLy(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setTLy(a, this, f);
    }

    public void setTRx(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setTRx(a, this, f);
    }

    public void setTRy(float f)
    {
        jniLivenessAndTMJNI.TemplatePolygon_setTRy(a, this, f);
    }
}
