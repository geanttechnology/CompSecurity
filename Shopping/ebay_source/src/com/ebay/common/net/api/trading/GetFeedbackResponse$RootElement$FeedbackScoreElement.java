// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackResponse

public final class this._cls1 extends com.ebay.nautilus.kernel.util.t
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        return super.t(s, s1, s2, attributes);
    }

    protected void setValue(int i)
        throws SAXException
    {
        feedbackScore = i;
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
