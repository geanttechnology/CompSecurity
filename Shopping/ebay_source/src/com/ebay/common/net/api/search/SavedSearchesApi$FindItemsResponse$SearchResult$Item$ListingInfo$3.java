// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.text.ParseException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

class this._cls0 extends com.ebay.nautilus.kernel.util.
{

    final this._cls0 this$0;

    public void text(String s)
        throws SAXException
    {
        try
        {
            cess._mth600(this._cls0.this).endDate = EbayDateFormat.parse(s);
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
        this$0 = this._cls0.this;
        super();
    }
}
