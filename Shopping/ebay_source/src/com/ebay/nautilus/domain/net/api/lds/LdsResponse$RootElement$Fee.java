// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsFee;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class fee extends com.ebay.nautilus.kernel.util.nt.Fee
{

    private final LdsFee fee = new LdsFee();
    final fee this$1;

    public com.ebay.nautilus.kernel.util.nt.Fee get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.Fee this$2;

                public void text(String s3)
                    throws SAXException
                {
                    fee.value = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.Fee.this;
                super();
            }
            };
        }
        if ("feeType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.Fee this$2;

                public void text(String s3)
                    throws SAXException
                {
                    fee.type = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.Fee.this;
                super();
            }
            };
        } else
        {
            return super.Fee(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls2(ArrayList arraylist)
    {
        this$1 = this._cls1.this;
        super();
        arraylist.add(fee);
    }
}
