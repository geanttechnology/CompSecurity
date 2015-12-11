// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class Name
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public Name()
    {
        this(A9VSMobileJNI.new_Name(), true);
    }

    protected Name(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(Name name)
    {
        if (name == null)
        {
            return 0L;
        } else
        {
            return name.swigCPtr;
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
                A9VSMobileJNI.delete_Name(swigCPtr);
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

    public String getFirst()
    {
        return A9VSMobileJNI.Name_first_get(swigCPtr, this);
    }

    public boolean getIsVerified()
    {
        return A9VSMobileJNI.Name_isVerified_get(swigCPtr, this);
    }

    public String getLast()
    {
        return A9VSMobileJNI.Name_last_get(swigCPtr, this);
    }

    public String getMiddle()
    {
        return A9VSMobileJNI.Name_middle_get(swigCPtr, this);
    }

    public void setFirst(String s)
    {
        A9VSMobileJNI.Name_first_set(swigCPtr, this, s);
    }

    public void setIsVerified(boolean flag)
    {
        A9VSMobileJNI.Name_isVerified_set(swigCPtr, this, flag);
    }

    public void setLast(String s)
    {
        A9VSMobileJNI.Name_last_set(swigCPtr, this, s);
    }

    public void setMiddle(String s)
    {
        A9VSMobileJNI.Name_middle_set(swigCPtr, this, s);
    }
}
