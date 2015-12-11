// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSellers;
import com.ebay.common.util.EbayDateFormat;
import java.text.ParseException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

class this._cls2 extends com.ebay.nautilus.kernel.util.t._cls2
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        try
        {
            _fld2.timestamp = EbayDateFormat.parse(s);
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
        this$2 = this._cls2.this;
        super();
    }
}
