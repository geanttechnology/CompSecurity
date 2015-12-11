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
        if ("RequestError".equals(s))
        {
            ErrorElement.access$100(ErrorElement.this).gory = 2;
        } else
        {
            if ("SystemError".equals(s))
            {
                ErrorElement.access$100(ErrorElement.this).gory = 3;
                return;
            }
            if ("CustomCode".equals(s))
            {
                ErrorElement.access$100(ErrorElement.this).gory = -1;
                return;
            }
        }
    }

    private ()
    {
        this$0 = ErrorElement.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
