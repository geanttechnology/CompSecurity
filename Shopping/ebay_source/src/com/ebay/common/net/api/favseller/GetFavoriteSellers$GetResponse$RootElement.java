// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.model.favseller.FavoriteSellers;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

public final class this._cls0 extends com.ebay.nautilus.kernel.util.ent
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellers.GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getFavoriteSellersResponse".equals(s1))
            {
                return new ResponseElement(null);
            }
            if ("Fault".equals(s1))
            {
                return new FaultElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$1 = GetFavoriteSellers.GetResponse.RootElement.this;
            super();
        }

        BodyElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellers.GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("detail".equals(s1))
            {
                return new DetailElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FaultElement()
        {
            this$1 = GetFavoriteSellers.GetResponse.RootElement.this;
            super();
        }

        FaultElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FaultElement.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FaultElement this$2;

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

        private FaultElement.DetailElement()
        {
            this$2 = FaultElement.this;
            super();
        }

        FaultElement.DetailElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellers.GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(this$0);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        fs.version = s;
                    }

            
            {
                this$2 = ResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            fs.timestamp = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$2 = ResponseElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(this$0, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("seller".equals(s1))
            {
                s = new FavoriteSeller();
                fs.favSellersList.add(s);
                return new SellerElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$1 = GetFavoriteSellers.GetResponse.RootElement.this;
            super();
        }

        ResponseElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SellerElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final FavoriteSeller favSeller;
        final GetFavoriteSellers.GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("sellerId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.sellerId = s.trim();
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("notes".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.notes = s.trim();
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("topRatedSeller".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final SellerElement this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        favSeller.topRatedSeller = flag;
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("feedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.feedbackRatingStar = s;
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("positiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.positiveFeedbackPercent = s;
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("feedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellerElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        favSeller.feedbackScore = i;
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("myWorldSmallImg".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final SellerElement this$2;

                    protected void setValue(URL url)
                        throws SAXException
                    {
                        favSeller.myWorldSmallImg = url;
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            }
            if ("myWorldUrl".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final SellerElement this$2;

                    protected void setValue(URL url)
                        throws SAXException
                    {
                        favSeller.myWorldUrl = url;
                    }

            
            {
                this$2 = SellerElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public SellerElement(FavoriteSeller favoriteseller)
        {
            this$1 = GetFavoriteSellers.GetResponse.RootElement.this;
            super();
            favSeller = favoriteseller;
        }
    }


    final BodyElement this$0;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Body".equals(s1))
        {
            return new BodyElement(null);
        } else
        {
            return super.ent(s, s1, s2, attributes);
        }
    }

    public SellerElement.favSeller()
    {
        this$0 = this._cls0.this;
        super();
    }
}
