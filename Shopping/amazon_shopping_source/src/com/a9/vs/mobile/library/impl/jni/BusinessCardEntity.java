// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class BusinessCardEntity
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public BusinessCardEntity()
    {
        this(A9VSMobileJNI.new_BusinessCardEntity(), true);
    }

    protected BusinessCardEntity(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(BusinessCardEntity businesscardentity)
    {
        if (businesscardentity == null)
        {
            return 0L;
        } else
        {
            return businesscardentity.swigCPtr;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_BusinessCardEntity(swigCPtr);
            }
            swigCPtr = 0L;
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

    public String getContent()
    {
        return A9VSMobileJNI.BusinessCardEntity_content_get(swigCPtr, this);
    }

    public String getExtension()
    {
        return A9VSMobileJNI.BusinessCardEntity_extension_get(swigCPtr, this);
    }

    public boolean getIsVerified()
    {
        return A9VSMobileJNI.BusinessCardEntity_isVerified_get(swigCPtr, this);
    }

    public String getType()
    {
        return A9VSMobileJNI.BusinessCardEntity_type_get(swigCPtr, this);
    }

    public void setContent(String s)
    {
        A9VSMobileJNI.BusinessCardEntity_content_set(swigCPtr, this, s);
    }

    public void setExtension(String s)
    {
        A9VSMobileJNI.BusinessCardEntity_extension_set(swigCPtr, this, s);
    }

    public void setIsVerified(boolean flag)
    {
        A9VSMobileJNI.BusinessCardEntity_isVerified_set(swigCPtr, this, flag);
    }

    public void setType(String s)
    {
        A9VSMobileJNI.BusinessCardEntity_type_set(swigCPtr, this, s);
    }
}
