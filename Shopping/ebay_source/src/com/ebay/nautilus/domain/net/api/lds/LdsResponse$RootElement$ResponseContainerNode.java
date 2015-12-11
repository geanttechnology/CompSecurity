// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class this._cls1 extends com.ebay.nautilus.kernel.util.erNode
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.erNode get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorMessage".equals(s1))
        {
            return new this._cls1(this._cls1.this, null);
        }
        if ("listingDraft".equals(s1))
        {
            return new >(this._cls1.this, null);
        }
        if ("field".equals(s1))
        {
            return new this._cls1(this._cls1.this, s1);
        } else
        {
            return super._mth1(s, s1, s2, attributes);
        }
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
        _fld1 = new ListingDraft();
        drafts.add(_fld1);
    }
}
