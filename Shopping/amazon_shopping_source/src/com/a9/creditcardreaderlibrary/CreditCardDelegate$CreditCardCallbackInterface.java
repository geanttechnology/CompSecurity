// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary;

import com.a9.vs.mobile.library.impl.jni.CreditCardInfo;

// Referenced classes of package com.a9.creditcardreaderlibrary:
//            CreditCardDelegate

public static interface 
{

    public abstract void onDetectedCardLines(int i);

    public abstract void onPromisingCardDetection();

    public abstract void onRecognizedCreditCard(CreditCardInfo creditcardinfo);

    public abstract void onStabilizedCardDetection();
}
