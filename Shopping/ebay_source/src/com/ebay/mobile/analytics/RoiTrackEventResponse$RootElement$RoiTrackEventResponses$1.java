// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.analytics:
//            RoiTrackEventResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.._cls2
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        if (urls == null)
        {
            urls = new ArrayList();
        }
        urls.add(s);
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
