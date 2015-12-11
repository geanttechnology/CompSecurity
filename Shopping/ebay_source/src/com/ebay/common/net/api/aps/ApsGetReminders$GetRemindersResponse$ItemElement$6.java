// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.text.ParseException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

class this._cls1 extends com.ebay.nautilus.kernel.util.is._cls1
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        try
        {
            cess._mth700(this._cls1.this).transaction._fld1 = EbayDateFormat.parse(s);
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
