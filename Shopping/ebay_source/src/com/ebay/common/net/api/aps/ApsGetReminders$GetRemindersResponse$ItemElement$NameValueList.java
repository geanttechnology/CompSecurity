// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

private final class this._cls1 extends com.ebay.nautilus.kernel.util.is._cls1
{

    final _cls2.val.nameValue this$1;

    public com.ebay.nautilus.kernel.util.is._cls1 get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final NameValue nameValue = (NameValue)this._mth1(this._cls1.this).nameValueList.get(this._mth1(this._cls1.this).nameValueList.size() - 1);
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement.NameValueList this$2;
                final NameValue val$nameValue;

                public void text(String s3)
                    throws SAXException
                {
                    nameValue.setName(s3);
                }

            
            {
                this$2 = ApsGetReminders.GetRemindersResponse.ItemElement.NameValueList.this;
                nameValue = namevalue;
                super();
            }
            };
        }
        if ("Value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ApsGetReminders.GetRemindersResponse.ItemElement.NameValueList this$2;
                final NameValue val$nameValue;

                public void text(String s3)
                    throws SAXException
                {
                    nameValue.addValue(s3);
                }

            
            {
                this$2 = ApsGetReminders.GetRemindersResponse.ItemElement.NameValueList.this;
                nameValue = namevalue;
                super();
            }
            };
        } else
        {
            return super.nameValue(s, s1, s2, attributes);
        }
    }

    public _cls2.val.nameValue()
    {
        this$1 = this._cls1.this;
        super();
        if (this._mth1(this._cls1.this).nameValueList == null)
        {
            this._mth1(this._cls1.this).nameValueList = new ArrayList();
        }
        this._mth1(this._cls1.this).nameValueList.add(new NameValue());
    }
}
