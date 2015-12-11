// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            CreditCardProcessProperty, A9VSMobileJNI, MapOfStringToUInt, MapOfStringToDouble, 
//            ImageByteData, CardRegion, Orientation, CreditCardReaderDelegateBase

public class CreditCardReaderFacade
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected CreditCardReaderFacade(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public CreditCardReaderFacade(CreditCardProcessProperty creditcardprocessproperty)
    {
        this(A9VSMobileJNI.new_CreditCardReaderFacade(CreditCardProcessProperty.getCPtr(creditcardprocessproperty), creditcardprocessproperty), true);
    }

    protected static long getCPtr(CreditCardReaderFacade creditcardreaderfacade)
    {
        if (creditcardreaderfacade == null)
        {
            return 0L;
        } else
        {
            return creditcardreaderfacade.swigCPtr;
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
                A9VSMobileJNI.delete_CreditCardReaderFacade(swigCPtr);
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

    public void generateReportAndClear(MapOfStringToUInt mapofstringtouint, MapOfStringToDouble mapofstringtodouble)
    {
        A9VSMobileJNI.CreditCardReaderFacade_generateReportAndClear(swigCPtr, this, MapOfStringToUInt.getCPtr(mapofstringtouint), mapofstringtouint, MapOfStringToDouble.getCPtr(mapofstringtodouble), mapofstringtodouble);
    }

    public void getCreditCardImage(ImageByteData imagebytedata)
    {
        A9VSMobileJNI.CreditCardReaderFacade_getCreditCardImage(swigCPtr, this, ImageByteData.getCPtr(imagebytedata), imagebytedata);
    }

    public void getOptimalSize(int i, int j, CardRegion cardregion)
    {
        A9VSMobileJNI.CreditCardReaderFacade_getOptimalSize__SWIG_0(swigCPtr, this, i, j, CardRegion.getCPtr(cardregion), cardregion);
    }

    public void getOptimalSize(int i, int j, Orientation orientation, CardRegion cardregion)
    {
        A9VSMobileJNI.CreditCardReaderFacade_getOptimalSize__SWIG_1(swigCPtr, this, i, j, orientation.swigValue(), CardRegion.getCPtr(cardregion), cardregion);
    }

    public boolean loadDigitModel(String s)
    {
        return A9VSMobileJNI.CreditCardReaderFacade_loadDigitModel(swigCPtr, this, s);
    }

    public void process(byte abyte0[], int i, int j, int k, int l, int i1, int j1)
    {
        A9VSMobileJNI.CreditCardReaderFacade_process(swigCPtr, this, abyte0, i, j, k, l, i1, j1);
    }

    public void setDelegate(CreditCardReaderDelegateBase creditcardreaderdelegatebase)
    {
        A9VSMobileJNI.CreditCardReaderFacade_setDelegate(swigCPtr, this, CreditCardReaderDelegateBase.getCPtr(creditcardreaderdelegatebase), creditcardreaderdelegatebase);
    }

    public void setOrientation(Orientation orientation)
    {
        A9VSMobileJNI.CreditCardReaderFacade_setOrientation(swigCPtr, this, orientation.swigValue());
    }

    public void start()
    {
        A9VSMobileJNI.CreditCardReaderFacade_start(swigCPtr, this);
    }

    public void stop()
    {
        A9VSMobileJNI.CreditCardReaderFacade_stop(swigCPtr, this);
    }
}
