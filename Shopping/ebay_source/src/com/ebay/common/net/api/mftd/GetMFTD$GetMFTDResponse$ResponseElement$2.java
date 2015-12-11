// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.model.mftd.MessageListResult;
import com.ebay.common.util.EbayDateFormat;
import java.text.ParseException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.mftd:
//            GetMFTD

class this._cls1 extends com.ebay.nautilus.kernel.util.his._cls1
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        try
        {
            _fld1.timestamp = EbayDateFormat.parse(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
