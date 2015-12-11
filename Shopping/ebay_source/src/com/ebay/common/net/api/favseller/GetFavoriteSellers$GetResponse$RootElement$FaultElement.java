// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.nautilus.domain.net.ErrorMessageElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

private final class <init> extends com.ebay.nautilus.kernel.util.ent
{
    private final class DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellers.GetResponse.RootElement.FaultElement this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(this$0, "http://www.ebay.com/marketplace/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private DetailElement()
        {
            this$2 = GetFavoriteSellers.GetResponse.RootElement.FaultElement.this;
            super();
        }

        DetailElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }


    final DetailElement this$1;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("detail".equals(s1))
        {
            return new DetailElement(null);
        } else
        {
            return super.ent(s, s1, s2, attributes);
        }
    }

    private DetailElement()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
