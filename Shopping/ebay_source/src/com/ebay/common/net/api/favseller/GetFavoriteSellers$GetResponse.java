// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.model.favseller.FavoriteSellers;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

public static final class fs extends EbayResponse
{
    public final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellers.GetResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement()
        {
            this$0 = GetFavoriteSellers.GetResponse.this;
            super();
        }
    }

    private final class RootElement.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getFavoriteSellersResponse".equals(s1))
            {
                return new RootElement.ResponseElement(null);
            }
            if ("Fault".equals(s1))
            {
                return new RootElement.FaultElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.BodyElement()
        {
            this$1 = RootElement.this;
            super();
        }

        RootElement.BodyElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

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

        private RootElement.FaultElement()
        {
            this$1 = RootElement.this;
            super();
        }

        RootElement.FaultElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement.FaultElement.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.FaultElement this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(_fld0, "http://www.ebay.com/marketplace/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.FaultElement.DetailElement()
        {
            this$2 = RootElement.FaultElement.this;
            super();
        }

        RootElement.FaultElement.DetailElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(_fld0);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ResponseElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        fs.version = s;
                    }

            
            {
                this$2 = RootElement.ResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ResponseElement this$2;

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
                this$2 = RootElement.ResponseElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(_fld0, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("seller".equals(s1))
            {
                s = new FavoriteSeller();
                fs.favSellersList.add(s);
                return new RootElement.SellerElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.ResponseElement()
        {
            this$1 = RootElement.this;
            super();
        }

        RootElement.ResponseElement(GetFavoriteSellers._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement.SellerElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final FavoriteSeller favSeller;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("sellerId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.sellerId = s.trim();
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("notes".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.notes = s.trim();
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("topRatedSeller".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final RootElement.SellerElement this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        favSeller.topRatedSeller = flag;
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("feedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.feedbackRatingStar = s;
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("positiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.positiveFeedbackPercent = s;
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("feedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SellerElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        favSeller.feedbackScore = i;
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("myWorldSmallImg".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final RootElement.SellerElement this$2;

                    protected void setValue(URL url)
                        throws SAXException
                    {
                        favSeller.myWorldSmallImg = url;
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("myWorldUrl".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final RootElement.SellerElement this$2;

                    protected void setValue(URL url)
                        throws SAXException
                    {
                        favSeller.myWorldUrl = url;
                    }

            
            {
                this$2 = RootElement.SellerElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public RootElement.SellerElement(FavoriteSeller favoriteseller)
        {
            this$1 = RootElement.this;
            super();
            favSeller = favoriteseller;
        }
    }


    public FavoriteSellers fs;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ption
    {
        fs.favSellersList = new ArrayList();
        SaxHandler.parseXml(inputstream, new RootElement());
    }

    protected RootElement.this._cls0()
    {
        fs = new FavoriteSellers();
    }
}
