// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary;

import com.a9.vs.mobile.library.impl.jni.CreditCardInfo;
import com.a9.vs.mobile.library.impl.jni.CreditCardReaderDelegateBase;

public class CreditCardDelegate extends CreditCardReaderDelegateBase
{
    public static interface CreditCardCallbackInterface
    {

        public abstract void onDetectedCardLines(int i);

        public abstract void onPromisingCardDetection();

        public abstract void onRecognizedCreditCard(CreditCardInfo creditcardinfo);

        public abstract void onStabilizedCardDetection();
    }


    CreditCardCallbackInterface m_interface;

    CreditCardDelegate(CreditCardCallbackInterface creditcardcallbackinterface)
    {
        m_interface = creditcardcallbackinterface;
    }

    public void detectCard(int i)
    {
        m_interface.onDetectedCardLines(i);
    }

    public void detectCardPromising()
    {
        m_interface.onPromisingCardDetection();
    }

    public void detectCardStabilized()
    {
        m_interface.onStabilizedCardDetection();
    }

    public void recognizeCreditCard(CreditCardInfo creditcardinfo)
    {
        m_interface.onRecognizedCreditCard(creditcardinfo);
    }
}
