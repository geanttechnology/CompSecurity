// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.uas;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.uas:
//            IsValidForResponse

private final class <init> extends com.ebay.nautilus.kernel.util.lement
{

    final IsValidForResponse this$0;

    public void text(String s)
        throws SAXException
    {
        valid = "true".equals(s);
    }

    private ()
    {
        this$0 = IsValidForResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
