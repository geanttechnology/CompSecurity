// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.common.util.EbayDateFormat;
import java.text.ParseException;
import java.util.Date;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

private final class <init> extends com.ebay.nautilus.kernel.util.<init>
{

    final this._cls0 this$0;

    public void text(String s)
        throws SAXException
    {
        try
        {
            s = EbayDateFormat.parse(s);
            this._cls0.this.<init>._fld0 = s.getTime();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
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
