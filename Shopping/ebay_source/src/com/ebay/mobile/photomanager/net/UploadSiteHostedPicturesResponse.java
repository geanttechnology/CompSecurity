// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import com.ebay.mobile.photomanager.SiteHostedPictureDetails;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class UploadSiteHostedPicturesResponse extends EbayResponse
{
    static final class PictureSetMember extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.mobile.photomanager.SiteHostedPictureDetails.Member member = new com.ebay.mobile.photomanager.SiteHostedPictureDetails.Member();

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("MemberURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                        final PictureSetMember this$0;

                        public void setValue(URL url)
                            throws SAXException
                        {
                            member.url = url;
                        }

            
            {
                this$0 = PictureSetMember.this;
                super();
            }
                    };
                }
                if ("PictureHeight".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final PictureSetMember this$0;

                        public void setValue(int i)
                            throws SAXException
                        {
                            member.height = i;
                        }

            
            {
                this$0 = PictureSetMember.this;
                super();
            }
                    };
                }
                if ("PictureWidth".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final PictureSetMember this$0;

                        public void setValue(int i)
                            throws SAXException
                        {
                            member.width = i;
                        }

            
            {
                this$0 = PictureSetMember.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public PictureSetMember(ArrayList arraylist)
        {
            arraylist.add(member);
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final UploadSiteHostedPicturesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(UploadSiteHostedPicturesResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(UploadSiteHostedPicturesResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(UploadSiteHostedPicturesResponse.this, s);
                }
                if ("SiteHostedPictureDetails".equals(s1))
                {
                    return new PictureDetails();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = UploadSiteHostedPicturesResponse.this;
            super();
        }

    }

    private final class RootElement.PictureDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("PictureSetMember".equals(s1))
                {
                    return new PictureSetMember(image.members);
                }
                if ("BaseURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                        final RootElement.PictureDetails this$2;

                        public void setValue(URL url)
                            throws SAXException
                        {
                            image.baseUrl = url;
                        }

            
            {
                this$2 = RootElement.PictureDetails.this;
                super();
            }
                    };
                }
                if ("FullURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                        final RootElement.PictureDetails this$2;

                        public void setValue(URL url)
                            throws SAXException
                        {
                            image.fullUrl = url;
                        }

            
            {
                this$2 = RootElement.PictureDetails.this;
                super();
            }
                    };
                }
                if ("PictureFormat".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.PictureDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            image.pictureFormat = s;
                        }

            
            {
                this$2 = RootElement.PictureDetails.this;
                super();
            }
                    };
                }
                if ("PictureSet".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.PictureDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            image.pictureSet = s;
                        }

            
            {
                this$2 = RootElement.PictureDetails.this;
                super();
            }
                    };
                }
                if ("UseByDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.PictureDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            try
                            {
                                image.useBy = UploadSiteHostedPicturesResponse.parseGMTDate(s);
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (String s)
                            {
                                image.useBy = new Date();
                            }
                            s.printStackTrace();
                        }

            
            {
                this$2 = RootElement.PictureDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement.PictureDetails()
        {
            this$1 = RootElement.this;
            super();
        }

    }


    private static final SimpleDateFormat dateFormat;
    public final SiteHostedPictureDetails image = new SiteHostedPictureDetails();

    public UploadSiteHostedPicturesResponse()
    {
    }

    public static Date parseGMTDate(String s)
        throws ParseException
    {
        return dateFormat.parse(s);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

    static 
    {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
}
