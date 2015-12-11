// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.SavedSeller;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFavoriteSellersResponse

private final class <init> extends com.ebay.nautilus.kernel.util.r
{

    private final SavedSeller seller;
    final seller this$1;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("UserID".compareToIgnoreCase(s1) == 0)
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFavoriteSellersResponse.RootElement.FavoriteSeller this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        seller.userId = s3;
                    }

            
            {
                this$2 = GetFavoriteSellersResponse.RootElement.FavoriteSeller.this;
                super();
            }
                };
            }
            if ("StoreName".compareToIgnoreCase(s1) == 0)
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetFavoriteSellersResponse.RootElement.FavoriteSeller this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        seller.storeName = s3;
                    }

            
            {
                this$2 = GetFavoriteSellersResponse.RootElement.FavoriteSeller.this;
                super();
            }
                };
            } else
            {
                return super.r(s, s1, s2, attributes);
            }
        } else
        {
            return super.r(s, s1, s2, attributes);
        }
    }


    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        seller = new SavedSeller();
        sellerList.add(seller);
    }

    seller(seller seller2)
    {
        this();
    }
}
