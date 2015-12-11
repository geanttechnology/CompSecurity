// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.Date;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.m.TimeLeft
{

    final  this$0;

    public void text(String s)
        throws SAXException
    {
        if (this._cls0.this.<init>.endDate != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s = Duration.parse(s, );
        .endDate = s.getEndFromStart();
        .endTimestamp = .endDate.getTime();
        return;
        s;
        throw new SAXNotSupportedException(s.getLocalizedMessage());
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
