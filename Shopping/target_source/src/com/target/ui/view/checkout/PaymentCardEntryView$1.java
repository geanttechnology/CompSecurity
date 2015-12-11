// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.widget.EditText;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView

class 
    implements Runnable
{

    final PaymentCardEntryView this$0;
    final EditText val$editText;

    public void run()
    {
        if (val$editText == null)
        {
            q.a(PaymentCardEntryView.TAG, "EditText null while performing delayedRequestFocus");
            return;
        } else
        {
            val$editText.requestFocus();
            return;
        }
    }
}
