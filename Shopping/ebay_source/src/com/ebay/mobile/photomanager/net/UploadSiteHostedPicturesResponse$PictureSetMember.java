// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import java.net.URL;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.photomanager.net:
//            UploadSiteHostedPicturesResponse

static final class member extends com.ebay.nautilus.kernel.util.er
{

    private final com.ebay.mobile.photomanager.ber member = new com.ebay.mobile.photomanager.ber();

    public com.ebay.nautilus.kernel.util.er get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("MemberURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.UrlElement() {

                    final UploadSiteHostedPicturesResponse.PictureSetMember this$0;

                    public void setValue(URL url)
                        throws SAXException
                    {
                        member.url = url;
                    }

            
            {
                this$0 = UploadSiteHostedPicturesResponse.PictureSetMember.this;
                super();
            }
                };
            }
            if ("PictureHeight".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final UploadSiteHostedPicturesResponse.PictureSetMember this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        member.height = i;
                    }

            
            {
                this$0 = UploadSiteHostedPicturesResponse.PictureSetMember.this;
                super();
            }
                };
            }
            if ("PictureWidth".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final UploadSiteHostedPicturesResponse.PictureSetMember this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        member.width = i;
                    }

            
            {
                this$0 = UploadSiteHostedPicturesResponse.PictureSetMember.this;
                super();
            }
                };
            }
        }
        return super.er(s, s1, s2, attributes);
    }


    public _cls3.this._cls0(ArrayList arraylist)
    {
        arraylist.add(member);
    }
}
