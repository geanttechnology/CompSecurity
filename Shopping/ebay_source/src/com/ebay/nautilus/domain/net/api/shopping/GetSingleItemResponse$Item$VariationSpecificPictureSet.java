// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.VariationPictureSet;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class this._cls1 extends com.ebay.nautilus.kernel.util.cPictureSet
{

    final _cls2.val.vps this$1;

    public com.ebay.nautilus.kernel.util.cPictureSet get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final VariationPictureSet vps = (VariationPictureSet)item.variationPictureSets.get(item.variationPictureSets.size() - 1);
            if ("VariationSpecificValue".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.VariationSpecificPictureSet this$2;
                    final VariationPictureSet val$vps;

                    public void text(String s3)
                        throws SAXException
                    {
                        vps.specificName = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.VariationSpecificPictureSet.this;
                vps = variationpictureset;
                super();
            }
                };
            }
            if ("PictureURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.VariationSpecificPictureSet this$2;
                    final VariationPictureSet val$vps;

                    public void text(String s3)
                        throws SAXException
                    {
                        vps.pictureUrls.add(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.VariationSpecificPictureSet.this;
                vps = variationpictureset;
                super();
            }
                };
            }
        }
        return super.cPictureSet(s, s1, s2, attributes);
    }

    public _cls2.val.vps()
    {
        this$1 = this._cls1.this;
        super();
        item.variationPictureSets.add(new VariationPictureSet());
    }
}
