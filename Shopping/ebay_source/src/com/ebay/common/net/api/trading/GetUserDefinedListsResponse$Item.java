// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDefinedListsResponse

private final class item extends com.ebay.nautilus.kernel.util.m
{

    private final efinedList item;
    final GetUserDefinedListsResponse this$0;

    public com.ebay.nautilus.kernel.util.m get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDefinedListsResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.name = s3;
                    }

            
            {
                this$1 = GetUserDefinedListsResponse.Item.this;
                super();
            }
                };
            }
            if ("ItemCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserDefinedListsResponse.Item this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        try
                        {
                            item.count = Integer.parseInt(s3);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = GetUserDefinedListsResponse.Item.this;
                super();
            }
                };
            }
        }
        return super.m(s, s1, s2, attributes);
    }


    public _cls2.this._cls1()
    {
        this$0 = GetUserDefinedListsResponse.this;
        super();
        item = new efinedList(GetUserDefinedListsResponse.this);
        GetUserDefinedListsResponse.access$100(GetUserDefinedListsResponse.this).add(item);
    }
}
