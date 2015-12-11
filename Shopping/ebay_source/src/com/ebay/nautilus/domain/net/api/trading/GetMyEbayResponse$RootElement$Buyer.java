// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

static final class item extends com.ebay.nautilus.kernel.util.ment.Buyer
{

    protected final MyEbayListItem item;

    public com.ebay.nautilus.kernel.util.ment.Buyer get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("UserID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Buyer this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.buyerUserID = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.Buyer.this;
                super();
            }
            };
        } else
        {
            return super.Buyer(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls0(MyEbayListItem myebaylistitem)
    {
        item = myebaylistitem;
    }
}
