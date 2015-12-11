// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.model.favseller.FavoriteSellers;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xmlpull.v1.XmlSerializer;

public class GetFavoriteSellers
{
    public static class GetRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String MAX_ALLOWED_SAVED_SELLERS = "200";
        private static final String operationName = "getFavoriteSellers";

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix("ser", "http://www.ebay.com/marketplace/mobile/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "getFavoriteSellersRequest");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "pagination");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "entriesPerPage", "200");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "pageNumber", "1");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "pagination");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sortOrder", "Ascending");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "getFavoriteSellersRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(ApiSettings.myEbaySvcApi);
        }

        public GetResponse getResponse()
        {
            return new GetResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public GetRequest(String s, EbaySite ebaysite, String s1)
        {
            super("MyEbayApplicationService", true, "getFavoriteSellers");
            super.iafToken = s;
            super.soaGlobalId = ebaysite.idString;
            super.soaMessageProtocol = "SOAP12";
            super.dataFormat = "XML";
            super.soaContentType = "text/xml";
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.bUseSoaServiceVersion = false;
            isConvertedToAlternateHttpFaultStatus = true;
        }
    }

    public static final class GetResponse extends EbayResponse
    {

        public FavoriteSellers fs;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            fs.favSellersList = new ArrayList();
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        protected GetResponse()
        {
            fs = new FavoriteSellers();
        }
    }

    public final class GetResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public GetResponse.RootElement()
        {
            this$0 = GetResponse.this;
            super();
        }
    }

    private final class GetResponse.RootElement.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getFavoriteSellersResponse".equals(s1))
            {
                return new GetResponse.RootElement.ResponseElement();
            }
            if ("Fault".equals(s1))
            {
                return new GetResponse.RootElement.FaultElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetResponse.RootElement.BodyElement()
        {
            this$1 = GetResponse.RootElement.this;
            super();
        }

    }

    private final class GetResponse.RootElement.FaultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("detail".equals(s1))
            {
                return new DetailElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetResponse.RootElement.FaultElement()
        {
            this$1 = GetResponse.RootElement.this;
            super();
        }

    }

    private final class GetResponse.RootElement.FaultElement.DetailElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetResponse.RootElement.FaultElement this$2;

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

        private GetResponse.RootElement.FaultElement.DetailElement()
        {
            this$2 = GetResponse.RootElement.FaultElement.this;
            super();
        }

    }

    private final class GetResponse.RootElement.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetResponse.RootElement this$1;

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

                    final GetResponse.RootElement.ResponseElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        fs.version = s;
                    }

            
            {
                this$2 = GetResponse.RootElement.ResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetResponse.RootElement.ResponseElement this$2;

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
                this$2 = GetResponse.RootElement.ResponseElement.this;
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
                return new GetResponse.RootElement.SellerElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetResponse.RootElement.ResponseElement()
        {
            this$1 = GetResponse.RootElement.this;
            super();
        }

    }

    private final class GetResponse.RootElement.SellerElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final FavoriteSeller favSeller;
        final GetResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("sellerId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.sellerId = s.trim();
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("notes".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.notes = s.trim();
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("topRatedSeller".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        favSeller.topRatedSeller = flag;
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("feedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.feedbackRatingStar = s;
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("positiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        favSeller.positiveFeedbackPercent = s;
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("feedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        favSeller.feedbackScore = i;
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("myWorldSmallImg".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    protected void setValue(URL url)
                        throws SAXException
                    {
                        favSeller.myWorldSmallImg = url;
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            }
            if ("myWorldUrl".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final GetResponse.RootElement.SellerElement this$2;

                    protected void setValue(URL url)
                        throws SAXException
                    {
                        favSeller.myWorldUrl = url;
                    }

            
            {
                this$2 = GetResponse.RootElement.SellerElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public GetResponse.RootElement.SellerElement(FavoriteSeller favoriteseller)
        {
            this$1 = GetResponse.RootElement.this;
            super();
            favSeller = favoriteseller;
        }
    }


    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_NAME = "MyEbayApplicationService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    public final String iafToken;
    public final EbaySite site;

    public GetFavoriteSellers(EbaySite ebaysite, String s)
    {
        site = ebaysite;
        iafToken = s;
        if (ebaysite == null)
        {
            throw new NullPointerException("site");
        }
        if (s == null)
        {
            throw new NullPointerException("iafToken");
        } else
        {
            return;
        }
    }
}
