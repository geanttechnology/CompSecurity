// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class list extends com.ebay.nautilus.kernel.util.meValueList
{

    ArrayList list;
    final _cls2.val.nameValue this$1;

    public com.ebay.nautilus.kernel.util.meValueList get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final NameValue nameValue = (NameValue)list.get(list.size() - 1);
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.NameValueList this$2;
                    final NameValue val$nameValue;

                    public void text(String s3)
                        throws SAXException
                    {
                        nameValue.setName(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.NameValueList.this;
                nameValue = namevalue;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.NameValueList this$2;
                    final NameValue val$nameValue;

                    public void text(String s3)
                        throws SAXException
                    {
                        nameValue.addValue(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.NameValueList.this;
                nameValue = namevalue;
                super();
            }
                };
            }
        }
        return super.meValueList(s, s1, s2, attributes);
    }

    public _cls2.val.nameValue(ArrayList arraylist)
    {
        this$1 = this._cls1.this;
        super();
        list = arraylist;
        arraylist.add(new NameValue());
    }
}
