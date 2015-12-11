// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSeller;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

private final class favSeller extends com.ebay.nautilus.kernel.util.ent
{

    private final FavoriteSeller favSeller;
    final favSeller this$1;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("sellerId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    favSeller.sellerId = s3.trim();
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("notes".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    favSeller.notes = s3.trim();
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("topRatedSeller".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                public void setValue(boolean flag)
                    throws SAXException
                {
                    favSeller.topRatedSeller = flag;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("feedbackRatingStar".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    favSeller.feedbackRatingStar = s3;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("positiveFeedbackPercent".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    favSeller.positiveFeedbackPercent = s3;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("feedbackScore".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                protected void setValue(int i)
                    throws SAXException
                {
                    favSeller.feedbackScore = i;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("myWorldSmallImg".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                protected void setValue(URL url)
                    throws SAXException
                {
                    favSeller.myWorldSmallImg = url;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        }
        if ("myWorldUrl".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                final GetFavoriteSellers.GetResponse.RootElement.SellerElement this$2;

                protected void setValue(URL url)
                    throws SAXException
                {
                    favSeller.myWorldUrl = url;
                }

            
            {
                this$2 = GetFavoriteSellers.GetResponse.RootElement.SellerElement.this;
                super();
            }
            };
        } else
        {
            return super.ent(s, s1, s2, attributes);
        }
    }


    public _cls8.this._cls2(FavoriteSeller favoriteseller)
    {
        this$1 = this._cls1.this;
        super();
        favSeller = favoriteseller;
    }
}
