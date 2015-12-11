// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private final class nit> extends com.ebay.nautilus.kernel.util.
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        if ("Error".equals(s))
        {
            ackCode = -1;
            <init>(is._cls1.this)._fld1 = 1;
        } else
        if ("Warning".equals(s))
        {
            this._mth1(is._cls1.this)._fld1 = 2;
            return;
        }
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
