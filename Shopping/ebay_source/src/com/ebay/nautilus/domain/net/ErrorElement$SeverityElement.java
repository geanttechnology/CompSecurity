// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorElement

private final class <init> extends com.ebay.nautilus.kernel.util.init>
{

    final ErrorElement this$0;

    public void text(String s)
        throws SAXException
    {
        if ("Error".equals(s))
        {
            ErrorElement.access$100(ErrorElement.this).severity = 1;
        } else
        {
            if ("Warning".equals(s))
            {
                ErrorElement.access$100(ErrorElement.this).severity = 2;
                return;
            }
            if ("CustomCode".equals(s))
            {
                ErrorElement.access$100(ErrorElement.this).severity = -1;
                return;
            }
        }
    }

    private s()
    {
        this$0 = ErrorElement.this;
        super();
    }

    >(> >)
    {
        this();
    }
}
