// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

public final class GetMultipleItemsResponse extends GetSingleItemResponse
{
    protected class GetMultipleItemRootElement extends GetSingleItemResponse.RootElement
    {

        final GetMultipleItemsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Item".equals(s1))
            {
                item = new EbayItem();
                if (items == null)
                {
                    items = new ArrayList();
                }
                items.add(item);
                return new GetSingleItemResponse.Item(GetMultipleItemsResponse.this);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected GetMultipleItemRootElement()
        {
            this$0 = GetMultipleItemsResponse.this;
            super(GetMultipleItemsResponse.this);
        }
    }


    public ArrayList items;

    public GetMultipleItemsResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            SaxHandler.parseXml(inputstream, new GetMultipleItemRootElement());
            super.postParseProcess();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
    }
}
