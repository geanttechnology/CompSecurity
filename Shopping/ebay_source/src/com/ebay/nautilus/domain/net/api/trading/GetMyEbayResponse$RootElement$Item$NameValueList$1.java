// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.NameValue;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.alueList._cls1
{

    final meValue this$1;

    public void text(String s)
        throws SAXException
    {
        meValue.setName(s);
    }

    a()
    {
        this$1 = this._cls1.this;
        super();
    }
}
