// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfString

public class CreditCardInfo
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CreditCardInfo()
    {
        this(A9VSMobileJNI.new_CreditCardInfo(), true);
    }

    protected CreditCardInfo(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CreditCardInfo creditcardinfo)
    {
        if (creditcardinfo == null)
        {
            return 0L;
        } else
        {
            return creditcardinfo.swigCPtr;
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
                A9VSMobileJNI.delete_CreditCardInfo(swigCPtr);
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

    public VectorOfString getCardDateAlternatives()
    {
        long l = A9VSMobileJNI.CreditCardInfo_cardDateAlternatives_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfString(l, false);
        }
    }

    public String getCardHolderName()
    {
        return A9VSMobileJNI.CreditCardInfo_cardHolderName_get(swigCPtr, this);
    }

    public String getCardNumber()
    {
        return A9VSMobileJNI.CreditCardInfo_cardNumber_get(swigCPtr, this);
    }

    public VectorOfString getCardNumberAlternatives()
    {
        long l = A9VSMobileJNI.CreditCardInfo_cardNumberAlternatives_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfString(l, false);
        }
    }

    public String getExpirationDate()
    {
        return A9VSMobileJNI.CreditCardInfo_expirationDate_get(swigCPtr, this);
    }

    public String getType()
    {
        return A9VSMobileJNI.CreditCardInfo_type_get(swigCPtr, this);
    }

    public void setCardDateAlternatives(VectorOfString vectorofstring)
    {
        A9VSMobileJNI.CreditCardInfo_cardDateAlternatives_set(swigCPtr, this, VectorOfString.getCPtr(vectorofstring), vectorofstring);
    }

    public void setCardHolderName(String s)
    {
        A9VSMobileJNI.CreditCardInfo_cardHolderName_set(swigCPtr, this, s);
    }

    public void setCardNumber(String s)
    {
        A9VSMobileJNI.CreditCardInfo_cardNumber_set(swigCPtr, this, s);
    }

    public void setCardNumberAlternatives(VectorOfString vectorofstring)
    {
        A9VSMobileJNI.CreditCardInfo_cardNumberAlternatives_set(swigCPtr, this, VectorOfString.getCPtr(vectorofstring), vectorofstring);
    }

    public void setExpirationDate(String s)
    {
        A9VSMobileJNI.CreditCardInfo_expirationDate_set(swigCPtr, this, s);
    }

    public void setType(String s)
    {
        A9VSMobileJNI.CreditCardInfo_type_set(swigCPtr, this, s);
    }
}
