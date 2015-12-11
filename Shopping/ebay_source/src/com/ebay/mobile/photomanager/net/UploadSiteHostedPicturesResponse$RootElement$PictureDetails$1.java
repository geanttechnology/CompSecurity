// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.net;

import com.ebay.mobile.photomanager.SiteHostedPictureDetails;
import java.net.URL;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.photomanager.net:
//            UploadSiteHostedPicturesResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.._cls1
{

    final this._cls2 this$2;

    public void setValue(URL url)
        throws SAXException
    {
        image.baseUrl = url;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
