// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorMessageElement

private final class <init> extends com.ebay.nautilus.kernel.util.init>
{

    final this._cls0 this$0;

    public void text(String s)
        throws SAXException
    {
        if ("CONSULTTECHSUPPORT".equalsIgnoreCase(s))
        {
            <init>(this._cls0.this)._fld0 = T;
        } else
        {
            if ("RETRY".equalsIgnoreCase(s))
            {
                T(this._cls0.this)._fld0 = this._fld0;
                return;
            }
            if ("CORRECTINPUTDATA".equalsIgnoreCase(s))
            {
                this._mth0(this._cls0.this)._fld0 = this._fld0;
                return;
            }
        }
    }

    private ()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
