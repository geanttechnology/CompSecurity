// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorElement

class tElement extends com.ebay.nautilus.kernel.util.Element
{

    final ErrorElement this$0;

    public void text(String s)
        throws SAXException
    {
        ErrorElement.access$100(ErrorElement.this).code = s;
    }

    or.ShortDetails()
    {
        this$0 = ErrorElement.this;
        super();
    }
}
