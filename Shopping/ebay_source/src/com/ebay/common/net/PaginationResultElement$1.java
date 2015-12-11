// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net:
//            PaginationResultElement

class erElement extends com.ebay.nautilus.kernel.util.<init>
{

    final PaginationResultElement this$0;

    protected void setValue(int i)
        throws SAXException
    {
        totalEntries = i;
    }

    erElement()
    {
        this$0 = PaginationResultElement.this;
        super();
    }
}
