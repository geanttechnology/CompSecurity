// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsError;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.tegory
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        <init>(this._cls2.this).category = s;
        if (!s.equals("Application"))
        {
            ackCode = -1;
        }
    }

    private ()
    {
        this$2 = this._cls2.this;
        super();
    }

    this._cls2(this._cls2 _pcls2_1)
    {
        this();
    }
}
