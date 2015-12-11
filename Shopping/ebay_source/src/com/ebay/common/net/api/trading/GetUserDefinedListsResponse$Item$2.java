// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDefinedListsResponse

class this._cls1 extends com.ebay.nautilus.kernel.util._cls2
{

    final inedList.count this$1;

    public void text(String s)
        throws SAXException
    {
        try
        {
            cess._mth200(this._cls1.this).count = Integer.parseInt(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
    }

    inedList()
    {
        this$1 = this._cls1.this;
        super();
    }
}
