// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, TemplatePolygon

public class TemplateInfo
{

    private long a;
    protected boolean swigCMemOwn;

    public TemplateInfo()
    {
        this(jniLivenessAndTMJNI.new_TemplateInfo__SWIG_0(), true);
    }

    public TemplateInfo(int i, String s, String s1, String s2, String s3, TemplatePolygon templatepolygon, int j, 
            double d)
    {
        this(jniLivenessAndTMJNI.new_TemplateInfo__SWIG_1(i, s, s1, s2, s3, TemplatePolygon.getCPtr(templatepolygon), templatepolygon, j, d), true);
    }

    protected TemplateInfo(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(TemplateInfo templateinfo)
    {
        if (templateinfo == null)
        {
            return 0L;
        } else
        {
            return templateinfo.a;
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
                jniLivenessAndTMJNI.delete_TemplateInfo(a);
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

    public String getCountry()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getCountry(a, this);
    }

    public String getDocumentType()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getDocumentType(a, this);
    }

    public int getFrameIndex()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getFrameIndex(a, this);
    }

    public int getMatchesCount()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getMatchesCount(a, this);
    }

    public TemplatePolygon getPolygon()
    {
        return new TemplatePolygon(jniLivenessAndTMJNI.TemplateInfo_getPolygon(a, this), false);
    }

    public String getRegion()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getRegion(a, this);
    }

    public String getState()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getState(a, this);
    }

    public int getTemplateHeight()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getTemplateHeight(a, this);
    }

    public int getTemplateWidth()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getTemplateWidth(a, this);
    }

    public double getTransformError()
    {
        return jniLivenessAndTMJNI.TemplateInfo_getTransformError(a, this);
    }

    public void setCountry(String s)
    {
        jniLivenessAndTMJNI.TemplateInfo_setCountry(a, this, s);
    }

    public void setDocumentType(String s)
    {
        jniLivenessAndTMJNI.TemplateInfo_setDocumentType(a, this, s);
    }

    public void setFrameIndex(int i)
    {
        jniLivenessAndTMJNI.TemplateInfo_setFrameIndex(a, this, i);
    }

    public void setMatchesCount(int i)
    {
        jniLivenessAndTMJNI.TemplateInfo_setMatchesCount(a, this, i);
    }

    public void setPolygon(TemplatePolygon templatepolygon)
    {
        jniLivenessAndTMJNI.TemplateInfo_setPolygon(a, this, TemplatePolygon.getCPtr(templatepolygon), templatepolygon);
    }

    public void setRegion(String s)
    {
        jniLivenessAndTMJNI.TemplateInfo_setRegion(a, this, s);
    }

    public void setState(String s)
    {
        jniLivenessAndTMJNI.TemplateInfo_setState(a, this, s);
    }

    public void setTemplateHeight(int i)
    {
        jniLivenessAndTMJNI.TemplateInfo_setTemplateHeight(a, this, i);
    }

    public void setTemplateWidth(int i)
    {
        jniLivenessAndTMJNI.TemplateInfo_setTemplateWidth(a, this, i);
    }

    public void setTransformError(double d)
    {
        jniLivenessAndTMJNI.TemplateInfo_setTransformError(a, this, d);
    }
}
