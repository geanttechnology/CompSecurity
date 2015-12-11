// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, CreditCardInfo

public class CreditCardReaderDelegateBase
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CreditCardReaderDelegateBase()
    {
        this(A9VSMobileJNI.new_CreditCardReaderDelegateBase(), true);
        A9VSMobileJNI.CreditCardReaderDelegateBase_director_connect(this, swigCPtr, swigCMemOwn, true);
    }

    protected CreditCardReaderDelegateBase(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CreditCardReaderDelegateBase creditcardreaderdelegatebase)
    {
        if (creditcardreaderdelegatebase == null)
        {
            return 0L;
        } else
        {
            return creditcardreaderdelegatebase.swigCPtr;
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
                A9VSMobileJNI.delete_CreditCardReaderDelegateBase(swigCPtr);
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

    public void detectBlackScreen()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase)
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectBlackScreen(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectBlackScreenSwigExplicitCreditCardReaderDelegateBase(swigCPtr, this);
            return;
        }
    }

    public void detectCard(int i)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase)
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectCard(swigCPtr, this, i);
            return;
        } else
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectCardSwigExplicitCreditCardReaderDelegateBase(swigCPtr, this, i);
            return;
        }
    }

    public void detectCardPromising()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase)
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectCardPromising(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectCardPromisingSwigExplicitCreditCardReaderDelegateBase(swigCPtr, this);
            return;
        }
    }

    public void detectCardStabilized()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase)
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectCardStabilized(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectCardStabilizedSwigExplicitCreditCardReaderDelegateBase(swigCPtr, this);
            return;
        }
    }

    public void detectDarkScene()
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase)
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectDarkScene(swigCPtr, this);
            return;
        } else
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_detectDarkSceneSwigExplicitCreditCardReaderDelegateBase(swigCPtr, this);
            return;
        }
    }

    protected void finalize()
    {
        delete();
    }

    public void recognizeCreditCard(CreditCardInfo creditcardinfo)
    {
        if (getClass() == com/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase)
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_recognizeCreditCard(swigCPtr, this, CreditCardInfo.getCPtr(creditcardinfo), creditcardinfo);
            return;
        } else
        {
            A9VSMobileJNI.CreditCardReaderDelegateBase_recognizeCreditCardSwigExplicitCreditCardReaderDelegateBase(swigCPtr, this, CreditCardInfo.getCPtr(creditcardinfo), creditcardinfo);
            return;
        }
    }

    protected void swigDirectorDisconnect()
    {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership()
    {
        swigCMemOwn = false;
        A9VSMobileJNI.CreditCardReaderDelegateBase_change_ownership(this, swigCPtr, false);
    }

    public void swigTakeOwnership()
    {
        swigCMemOwn = true;
        A9VSMobileJNI.CreditCardReaderDelegateBase_change_ownership(this, swigCPtr, true);
    }
}
