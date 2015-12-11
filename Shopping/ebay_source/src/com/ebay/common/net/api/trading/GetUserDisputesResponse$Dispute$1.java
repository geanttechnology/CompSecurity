// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDispute;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDisputesResponse

class val.dispute extends com.ebay.nautilus.kernel.util._cls1
{

    final val.dispute this$1;
    final UserDispute val$dispute;

    public void text(String s)
        throws SAXException
    {
        val$dispute.createdTime = EbayDateUtils.parseXml(s);
    }

    ()
    {
        this$1 = final_;
        val$dispute = UserDispute.this;
        super();
    }
}
