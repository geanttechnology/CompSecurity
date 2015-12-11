// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsError;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.verity
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        _mth00(this._cls2.this).severity = s;
        if (s.equals("Warning"))
        {
            _fld2.warnings.add(_mth00(this._cls2.this));
            return;
        } else
        {
            _fld2.errors.add(_mth00(this._cls2.this));
            return;
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
