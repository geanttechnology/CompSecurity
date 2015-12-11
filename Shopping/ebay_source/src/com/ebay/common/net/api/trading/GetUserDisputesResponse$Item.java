// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDispute;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDisputesResponse

private final class dispute extends com.ebay.nautilus.kernel.util.m
{

    private final UserDispute dispute;
    final GetUserDisputesResponse this$0;

    public com.ebay.nautilus.kernel.util.m get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ItemID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetUserDisputesResponse.Item this$1;

                public void text(String s3)
                    throws SAXException
                {
                    dispute.itemId = s3;
                }

            
            {
                this$1 = GetUserDisputesResponse.Item.this;
                super();
            }
            };
        } else
        {
            return super.m(s, s1, s2, attributes);
        }
    }


    public _cls1.this._cls1(UserDispute userdispute)
    {
        this$0 = GetUserDisputesResponse.this;
        super();
        dispute = userdispute;
    }
}
