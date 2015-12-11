// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import com.ebay.mobile.photomanager.SiteHostedPictureDetails;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.photomanager.net:
//            UploadSiteHostedPicturesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ls
{

    final _cls5 this$1;

    public com.ebay.nautilus.kernel.util.ls get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("PictureSetMember".equals(s1))
            {
                return new <init>(image.members);
            }
            if ("BaseURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final UploadSiteHostedPicturesResponse.RootElement.PictureDetails this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        image.baseUrl = url;
                    }

            
            {
                this$2 = UploadSiteHostedPicturesResponse.RootElement.PictureDetails.this;
                super();
            }
                };
            }
            if ("FullURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final UploadSiteHostedPicturesResponse.RootElement.PictureDetails this$2;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        image.fullUrl = url;
                    }

            
            {
                this$2 = UploadSiteHostedPicturesResponse.RootElement.PictureDetails.this;
                super();
            }
                };
            }
            if ("PictureFormat".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UploadSiteHostedPicturesResponse.RootElement.PictureDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        image.pictureFormat = s3;
                    }

            
            {
                this$2 = UploadSiteHostedPicturesResponse.RootElement.PictureDetails.this;
                super();
            }
                };
            }
            if ("PictureSet".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UploadSiteHostedPicturesResponse.RootElement.PictureDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        image.pictureSet = s3;
                    }

            
            {
                this$2 = UploadSiteHostedPicturesResponse.RootElement.PictureDetails.this;
                super();
            }
                };
            }
            if ("UseByDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final UploadSiteHostedPicturesResponse.RootElement.PictureDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        try
                        {
                            image.useBy = UploadSiteHostedPicturesResponse.parseGMTDate(s3);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            image.useBy = new Date();
                        }
                        s3.printStackTrace();
                    }

            
            {
                this$2 = UploadSiteHostedPicturesResponse.RootElement.PictureDetails.this;
                super();
            }
                };
            }
        }
        return super.ls(s, s1, s2, attributes);
    }

    private _cls5.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
