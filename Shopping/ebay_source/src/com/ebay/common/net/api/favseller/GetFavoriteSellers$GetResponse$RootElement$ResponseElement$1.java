// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSellers;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

class this._cls2 extends com.ebay.nautilus.kernel.util.t._cls1
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        _fld2.version = s;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
