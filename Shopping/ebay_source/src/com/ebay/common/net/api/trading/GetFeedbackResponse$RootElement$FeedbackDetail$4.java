// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackResponse, Feedback

class val.feedback extends com.ebay.nautilus.kernel.util._cls4
{

    final val.feedback this$2;
    final Feedback val$feedback;

    public void text(String s)
        throws SAXException
    {
        val$feedback.commentText = s;
    }

    ()
    {
        this$2 = final_;
        val$feedback = Feedback.this;
        super();
    }
}
