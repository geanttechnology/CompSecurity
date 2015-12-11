// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary;

import android.util.Pair;
import com.a9.vs.mobile.library.impl.jni.CreditCardInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.a9.creditcardreaderlibrary:
//            CreditCardReaderActivity, CreditCardResult

class this._cls0
    implements rdCallbackInterface
{

    final CreditCardReaderActivity this$0;

    public void onDetectedCardLines(int i)
    {
        ArrayList arraylist = new ArrayList();
        if ((i & 1) > 0)
        {
            arraylist.add(new Pair(CreditCardReaderActivity.access$100(CreditCardReaderActivity.this), CreditCardReaderActivity.access$200(CreditCardReaderActivity.this)));
        }
        if ((i & 2) > 0)
        {
            arraylist.add(new Pair(CreditCardReaderActivity.access$300(CreditCardReaderActivity.this), CreditCardReaderActivity.access$100(CreditCardReaderActivity.this)));
        }
        if ((i & 4) > 0)
        {
            arraylist.add(new Pair(CreditCardReaderActivity.access$400(CreditCardReaderActivity.this), CreditCardReaderActivity.access$300(CreditCardReaderActivity.this)));
        }
        if ((i & 8) > 0)
        {
            arraylist.add(new Pair(CreditCardReaderActivity.access$200(CreditCardReaderActivity.this), CreditCardReaderActivity.access$400(CreditCardReaderActivity.this)));
        }
        didDetectGoodEdges(arraylist);
    }

    public void onPromisingCardDetection()
    {
        didPromisingCardRecognition();
    }

    public void onRecognizedCreditCard(CreditCardInfo creditcardinfo)
    {
        CreditCardReaderActivity.access$000(CreditCardReaderActivity.this);
        didRecognizeCreditCard(new CreditCardResult(creditcardinfo));
    }

    public void onStabilizedCardDetection()
    {
        didStableCardRecognition();
    }

    rdCallbackInterface()
    {
        this$0 = CreditCardReaderActivity.this;
        super();
    }
}
