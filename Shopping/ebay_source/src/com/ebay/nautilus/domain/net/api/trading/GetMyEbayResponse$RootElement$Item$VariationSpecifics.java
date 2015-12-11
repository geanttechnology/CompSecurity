// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.nSpecifics
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.nSpecifics get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("NameValueList".equals(s1))
        {
            if (this._cls0.this.<init>.nameValueList == null)
            {
                _fld0.nameValueList = new ArrayList();
            }
            s = new NameValue();
            _fld0.nameValueList.add(s);
            return new >(this._cls0.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
