// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class Address
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public Address()
    {
        this(A9VSMobileJNI.new_Address(), true);
    }

    protected Address(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(Address address)
    {
        if (address == null)
        {
            return 0L;
        } else
        {
            return address.swigCPtr;
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
                A9VSMobileJNI.delete_Address(swigCPtr);
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

    public String getCity()
    {
        return A9VSMobileJNI.Address_city_get(swigCPtr, this);
    }

    public boolean getIsVerified()
    {
        return A9VSMobileJNI.Address_isVerified_get(swigCPtr, this);
    }

    public String getState_abbr()
    {
        return A9VSMobileJNI.Address_state_abbr_get(swigCPtr, this);
    }

    public String getState_full()
    {
        return A9VSMobileJNI.Address_state_full_get(swigCPtr, this);
    }

    public String getStreet()
    {
        return A9VSMobileJNI.Address_street_get(swigCPtr, this);
    }

    public String getZipcode()
    {
        return A9VSMobileJNI.Address_zipcode_get(swigCPtr, this);
    }

    public void setCity(String s)
    {
        A9VSMobileJNI.Address_city_set(swigCPtr, this, s);
    }

    public void setIsVerified(boolean flag)
    {
        A9VSMobileJNI.Address_isVerified_set(swigCPtr, this, flag);
    }

    public void setState_abbr(String s)
    {
        A9VSMobileJNI.Address_state_abbr_set(swigCPtr, this, s);
    }

    public void setState_full(String s)
    {
        A9VSMobileJNI.Address_state_full_set(swigCPtr, this, s);
    }

    public void setStreet(String s)
    {
        A9VSMobileJNI.Address_street_set(swigCPtr, this, s);
    }

    public void setZipcode(String s)
    {
        A9VSMobileJNI.Address_zipcode_set(swigCPtr, this, s);
    }
}
