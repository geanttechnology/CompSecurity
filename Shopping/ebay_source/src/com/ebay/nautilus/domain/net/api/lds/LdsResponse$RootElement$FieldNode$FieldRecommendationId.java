// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.tionId
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        <init>(this._cls2.this).id = s;
        if (s.equals("Listing.Price"))
        {
            _fld2.recommendedPrice = this._mth2(this._cls2.this);
        }
        if (s.equals("Listing.StartPrice"))
        {
            _fld2.recommendedStartPrice = this._mth2(this._cls2.this);
        }
        if (s.equals("Listing.Format"))
        {
            _fld2.recommendedFormat = this._mth2(this._cls2.this);
        }
        if (s.equals("Listing.Duration"))
        {
            _fld2.recommendedDuration = this._mth2(this._cls2.this);
        }
    }

    private ()
    {
        this$2 = this._cls2.this;
        super();
    }

    this._cls2(this._cls2 _pcls2_1)
    {
        this();
    }
}
