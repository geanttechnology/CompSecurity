// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.catalog;

import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.catalog:
//            MatchProductResponse

class this._cls2 extends com.ebay.nautilus.kernel.util._cls1
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        results.add(s);
    }

    Y()
    {
        this$2 = this._cls2.this;
        super();
    }
}
