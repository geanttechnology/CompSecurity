// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.text.style.ClickableSpan;
import android.view.View;
import com.ebay.common.net.api.trading.Feedback;

// Referenced classes of package com.ebay.mobile.activities:
//            FeedbackFragment

class val.feedback extends ClickableSpan
{

    final val.feedback this$1;
    final Feedback val$feedback;

    public void onClick(View view)
    {
        showUser(val$feedback);
    }

    ()
    {
        this$1 = final_;
        val$feedback = Feedback.this;
        super();
    }
}
