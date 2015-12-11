// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.Duration;
import java.util.Date;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

private final class <init> extends com.ebay.nautilus.kernel.util.<init>
{

    final  this$0;

    public void text(String s)
        throws SAXException
    {
        try
        {
            Date date = new Date();
            s = Duration.parse(s, date).getEndFromStart(date);
            . = s.getTime();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotSupportedException(s.getLocalizedMessage());
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
