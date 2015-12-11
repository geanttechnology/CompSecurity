// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import com.ebay.mobile.photomanager.SiteHostedPictureDetails;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.photomanager.net:
//            UploadSiteHostedPicturesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.nt
{
    private final class PictureDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final UploadSiteHostedPicturesResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("PictureSetMember".equals(s1))
                {
                    return new UploadSiteHostedPicturesResponse.PictureSetMember(image.members);
                }
                if ("BaseURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                        final PictureDetails this$2;

                        public void setValue(URL url)
                            throws SAXException
                        {
                            image.baseUrl = url;
                        }

            
            {
                this$2 = PictureDetails.this;
                super();
            }
                    };
                }
                if ("FullURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                        final PictureDetails this$2;

                        public void setValue(URL url)
                            throws SAXException
                        {
                            image.fullUrl = url;
                        }

            
            {
                this$2 = PictureDetails.this;
                super();
            }
                    };
                }
                if ("PictureFormat".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PictureDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            image.pictureFormat = s;
                        }

            
            {
                this$2 = PictureDetails.this;
                super();
            }
                    };
                }
                if ("PictureSet".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PictureDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            image.pictureSet = s;
                        }

            
            {
                this$2 = PictureDetails.this;
                super();
            }
                    };
                }
                if ("UseByDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final PictureDetails this$2;

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
                this$2 = PictureDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private PictureDetails()
        {
            this$1 = UploadSiteHostedPicturesResponse.RootElement.this;
            super();
        }

        PictureDetails(UploadSiteHostedPicturesResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final UploadSiteHostedPicturesResponse this$0;

    public com.ebay.nautilus.kernel.util.nt get(String s, String s1, String s2, Attributes attributes)
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
                return new PictureDetails(null);
            }
        }
        return super.nt(s, s1, s2, attributes);
    }

    private PictureDetails()
    {
        this$0 = UploadSiteHostedPicturesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
